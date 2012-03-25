package me.blocksparty.tools;

public enum Tool {

	AUTOPILOT("auto pilot"),
	BUILD("build"),
	GIVE("give material"),
	INSTANTBREAK("instant block break"),
	PAINT("paint"),
	REMOVE("remove block/chunk"),
	TELEPORT("teleport");

	private final String name;

	private Tool(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
