/******************************************************************************

  Copyright (c) 2019 by Salvador E. Tropea
  License: Same as the rest of the Ardublock project (currently GPL v3.0)
  Block: Rastuino_WriteAna
  Rastuino API: EscribirAnalogico

******************************************************************************/

package com.ardublock.translator.block.Rastuino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class WriteAna extends TranslatorBlock
{
	public WriteAna(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		TranslatorBlock translatorBlock2 = this.getRequiredTranslatorBlockAtSocket(1);
		translator.addHeaderFile("Rastuino.h");
		translator.addSetupCommand("Inicializar();");
		String ret = "EscribirAnalogico(" + translatorBlock.toCode() + "," +
			translatorBlock2.toCode() + ");\n";
		return codePrefix + ret + codeSuffix;
	}
}
