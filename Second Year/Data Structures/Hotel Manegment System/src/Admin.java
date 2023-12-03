import java.util.LinkedList;

public class Admin {
	private LinkedList<RoomNode> roomNodes = new LinkedList<>();

	public void addRoom(int capacity, int price) {
		RoomNode newNode = new RoomNode(capacity, price);
		roomNodes.add(newNode);
	}

	public void printLinkedList() {
		for (int i = 0; i < roomNodes.size(); i++) {
			System.out.print(roomNodes.get(i).toString());
		}

	}
}
