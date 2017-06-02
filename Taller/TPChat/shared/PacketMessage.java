package shared;

public class PacketMessage extends Packet {
	private String message;	

	public PacketMessage(String message) {
		super(Command.MESSAGE);
		this.message = message;		
	}

	public String getMessage() {
		return this.message;
	}
}
