package de.vilip.clioptions;

import org.apache.commons.cli.Option;

public enum CLIOptions
{
	TEST(new Option("t", true, "A whole test directory"), "t"), DIRECTORY(new Option("d", true, "A single test file"), "d"), FILE(new Option("f", true, "A single test in a file"), "f");

	private final Option option;

	private final String shortOption;

	CLIOptions(Option option, String shortOption)
	{
		this.option = option;
		this.shortOption = shortOption;
	}

	public Option getOption()
	{
		return option;
	}

	public String getShortOption()
	{
		return shortOption;
	}
}
