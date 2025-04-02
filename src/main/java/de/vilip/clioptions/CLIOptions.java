package de.vilip.clioptions;

public enum CLIOptions
{
	TEST("t"), DIRECTORY("d"), FILE("f");

	private final String shortOption;

	CLIOptions(String shortOption)
	{
		this.shortOption = shortOption;
	}

	public String getShortOption()
	{
		return shortOption;
	}
}
