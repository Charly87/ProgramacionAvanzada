package shared;

import java.io.Serializable;

public class Packet implements Serializable {

	private Command command;
	private boolean status;

	public Packet() {
	}

	public Packet(Command command) {
		this.command = command;
	}

	public Command getCommand() {
		return this.command;
	}
	
	public boolean getStatus()
	{
		return this.status;
	}
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void setStatus(boolean status)
	{
		this.status = status;
	}	
	
}
