package shared;

public class PacketUser extends Packet {
	private String username;
	private String password;
	private boolean logged;
	
	public PacketUser(String username, String password) {
		this.username = username;
		this.password = password;
	}	

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public boolean getLogged() {
		return this.logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
}
