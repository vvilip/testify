package de.vilip.clioptions;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class OptionsDefinition
{
	public Options initalizeOptions()
	{
		return new Options().addOption(new Option("t", true, "The test file which tests should be run"));
	}
}
