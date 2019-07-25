/******************************************************************************

  Copyright (c) 2019 by Salvador E. Tropea
  License: Same as the rest of the Ardublock project (currently GPL v3.0)
  Block: Rastuino_CalibrarMotor
  Rastuino API: CalibrarMotor

******************************************************************************/

package com.ardublock.translator.block.Rastuino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class CalibrarMotor extends TranslatorBlock
{
        
        public CalibrarMotor(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
        {
                super(blockId, translator, codePrefix, codeSuffix, label);
        }

        @Override
        public String toCode() throws SocketNullException, SubroutineNotDeclaredException
        {
                TranslatorBlock translatorBlock1 = getRequiredTranslatorBlockAtSocket(0);
                TranslatorBlock translatorBlock2 = getRequiredTranslatorBlockAtSocket(1);

                translator.addHeaderFile("Rastuino.h");
                translator.addSetupCommand("Inicializar();");
                String ret = "CalibrarMotor(" + translatorBlock1.toCode() + "," +
                             translatorBlock2.toCode() + ");";
                return ret;                
        }
        
}