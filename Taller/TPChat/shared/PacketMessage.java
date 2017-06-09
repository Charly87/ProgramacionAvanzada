package shared;

public class PacketMessage extends Packet {
	private String from;
	private String to;
	private String message;
	private boolean isPrivate;

	public PacketMessage(String from, String to, String message, boolean isPrivate) {
		super(Command.MESSAGE);
		this.from = from;
		this.to = to;
		this.message = message;
		this.isPrivate = isPrivate;
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
	
	public boolean isPrivate() {
		return this.isPrivate;
	}
}
