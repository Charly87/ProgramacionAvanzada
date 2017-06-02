package shared;

import java.io.Serializable;

public class Packet implements Serializable {

	private Command command;

	public Packet(Command command) {
		this.command = command;
	}

	public Command getCommand() {
		return this.command;
	}
}
