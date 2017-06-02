package shared;

public class PacketLogin extends Packet {
	private String username;
	private String password;

	public PacketLogin(String username, String password) {
		super(Command.LOGIN);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}
}
