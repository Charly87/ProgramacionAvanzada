package shared;

import java.util.List;
import java.util.Map;

public class PacketUpdate extends Packet {
	private Map<Integer, PacketUser> users;

	public PacketUpdate( Map<Integer, PacketUser> users) {
		super(Command.UPDATE);
		this.users = users;
	}

	public  Map<Integer, PacketUser> getUsers() {
		return this.users;
	}
}
