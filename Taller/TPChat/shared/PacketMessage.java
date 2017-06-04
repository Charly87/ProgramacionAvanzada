package shared;

public class PacketMessage extends Packet {
	private int idFrom;
	private int idTo;
	private String message;

	public PacketMessage(int idFrom, int idTo, String message) {
		super(Command.MESSAGE);
		this.idFrom = idFrom;
		this.idTo = idTo;
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public int getFrom() {
		return this.idFrom;
	}
	
	public int getTo() {
		return this.idTo;
	}
}
