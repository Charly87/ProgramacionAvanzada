package shared;

import java.util.List;
import java.util.Map;

public class PacketUpdate extends Packet {
	private List<String> users;

	public PacketUpdate(List<String> users) {
		super(Command.UPDATE);
		this.users = users;
	}

	public List<String> getUsers() {
		return this.users;
	}
}
