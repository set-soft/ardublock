/******************************************************************************

  Copyright (c) 2019 by Salvador E. Tropea
  License: Same as the rest of the Ardublock project (currently GPL v3.0)
  Block: Rastuino_Apagar
  Rastuino API: Apagar

******************************************************************************/

// Define our domain
package com.ardublock.translator.block.Rastuino;

// Classes we use
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

// Our class (com.ardublock.translator.block.Rastuino.Apagar)
// Corresponds to a line in block-mapping.properties:
// Rastuino_Apagar=com.ardublock.translator.block.Rastuino.Apagar
public class Apagar extends TranslatorBlock
{
        // Simple constructor, nothing new here
        public Apagar(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
        {
                super(blockId, translator, codePrefix, codeSuffix, label);
        }

        // How we convert the block into sketch (Arduino) code:
        @Override
        public String toCode() throws SocketNullException, SubroutineNotDeclaredException
        {
                // Get the first parameter, is mandatory, not optional (not getTranslatorBlockAtSocket)
                TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
                // Add the Rastuino.h include, needed for Apagar
                translator.addHeaderFile("Rastuino.h");
                // Add the Rastuino initialization
                translator.addSetupCommand("Inicializar();");
                // This is the actual code
                String ret = "Apagar(";
                ret = ret + translatorBlock.toCode();
                ret = ret + ");\n";
                return ret;                
        }
}