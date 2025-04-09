package de.vilip.clioptions;

import org.apache.commons.cli.Option;

public enum CLIOptions
{
	TEST(new Option("t", true, "A whole test directory")), DIRECTORY(new Option("d", true, "A single test file")), FILE(new Option("f", true, "A single test in a file"));

	private final Option option;

	CLIOptions(Option option)
	{
		this.option = option;
	}

	public Option getOption()
	{
		return option;
	}
}
