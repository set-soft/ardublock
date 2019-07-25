/******************************************************************************

  Copyright (c) 2019 by Salvador E. Tropea
  License: Same as the rest of the Ardublock project (currently GPL v3.0)
  Block: Rastuino_Derecha
  Rastuino API: GirarDerecha

******************************************************************************/

package com.ardublock.translator.block.Rastuino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Derecha extends TranslatorBlock
{
        
        public Derecha(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
        {
                super(blockId, translator, codePrefix, codeSuffix, label);
        }

        @Override
        public String toCode() throws SocketNullException, SubroutineNotDeclaredException
        {
                TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);

                translator.addHeaderFile("Rastuino.h");
                translator.addSetupCommand("Inicializar();");
                String ret = "GirarDerecha(";
                
                ret = ret + translatorBlock.toCode();
                ret = ret + ");\n";
                return ret;                
        }
        
}