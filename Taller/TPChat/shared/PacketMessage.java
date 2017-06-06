package shared;

public class PacketMessage extends Packet {
	private String from;
	private String to;
	private String message;

	public PacketMessage(String from, String to, String message) {
		super(Command.MESSAGE);
		this.from = from;
		this.to = to;
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public String getFrom() {
		return this.from;
	}
	
	public String getTo() {
		return this.to;
	}
}
