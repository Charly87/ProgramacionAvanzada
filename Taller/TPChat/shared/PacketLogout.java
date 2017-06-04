package shared;

public class PacketLogout extends Packet {
	private int id;
	private String username;

	public PacketLogout(int id, String username) {
		super(Command.LOGOUT);
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
