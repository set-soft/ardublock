/******************************************************************************

  Copyright (c) 2019 by Salvador E. Tropea
  License: Same as the rest of the Ardublock project (currently GPL v3.0)
  Block: Rastuino_ReadDig
  Rastuino API: Leer

******************************************************************************/

package com.ardublock.translator.block.Rastuino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ReadDig extends TranslatorBlock
{
	public ReadDig(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);

		String ret = "Leer(" + translatorBlock.toCode() + ")";
		return codePrefix + ret + codeSuffix;
	} 

}
