import java.io.*;

public class RoomNode {
	int price;
	int capacity;
	int roomId;

	public RoomNode(int capacity, int price)  {
		this.price = price;
		this.capacity = capacity;
//		setId();
//		saveRoomInfo();
	}

	@Override
	public String toString() {
		return "RoomNode{" +
				"price=" + price +
				", capacity=" + capacity +
				", roomId=" + roomId +
				'}';
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

//	public void setId() throws IOException {
//		File roomData = new File("RoomData.csv");
//		BufferedReader bw = new BufferedReader(new FileReader(roomData));
//		String line = bw.readLine();
//		String[] RoomData = ",".split(line);
//		int Id = Integer.parseInt(RoomData[0]);
//		roomId = Id++;
//		bw.close();
//
//	}
//
//	public void saveRoomInfo() throws IOException {
//		File roomData = new File("RoomData.csv");
//		BufferedWriter bw = new BufferedWriter(new FileWriter(roomData));
//		PrintWriter pw = new PrintWriter(bw);
//		pw.println(roomId + "," + price + "," + capacity);
//		pw.flush();
//		pw.close();
//
//	}
}
