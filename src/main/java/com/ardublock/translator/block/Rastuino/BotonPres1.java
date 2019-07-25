/******************************************************************************

  Copyright (c) 2019 by Salvador E. Tropea
  License: Same as the rest of the Ardublock project (currently GPL v3.0)
  Block: Rastuino_BotonPres1
  Rastuino API: EsperarUnPulsador

******************************************************************************/

package com.ardublock.translator.block.Rastuino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class BotonPres1 extends TranslatorBlock
{
        
        public BotonPres1(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
        {
                super(blockId, translator, codePrefix, codeSuffix, label);
        }

        @Override
        public String toCode() throws SocketNullException, SubroutineNotDeclaredException
        {
                TranslatorBlock translatorBlock = getRequiredTranslatorBlockAtSocket(0);

                translator.addHeaderFile("Rastuino.h");
                translator.addSetupCommand("Inicializar();");
                String ret = getComment(); //"";

                String comment = getComment();
                if (comment != null && !comment.trim().isEmpty())
                      ret = "// " + comment + "\n";

                ret = ret + "EsperarUnPulsador(";
                int i;
                for (i=0; i<4; i++)
                {
                        if  (translatorBlock != null)
                                ret = ret + translatorBlock.toCode();
                        else
                                ret = ret + "0";
                        if (i<3)
                        {
                                ret = ret + ",";
                                translatorBlock = getTranslatorBlockAtSocket(i+1);
                        }
                }
                ret = ret + ");\n";
                return ret;                
        }
        
}