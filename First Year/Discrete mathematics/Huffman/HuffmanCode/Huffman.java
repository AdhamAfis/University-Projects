import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Huffman {
	private String text;
	private int[] freq;
	private char[] chars;
	private StringBuilder t = new StringBuilder();

	public Huffman(String text) throws IOException {
		this.text = text;
		FindFreq findfreq = new FindFreq(text);
		chars = findfreq.getChars();
		freq = findfreq.getCharsFreq();
		System.out.println(Arrays.toString(chars) + '\n' + Arrays.toString(freq));
		HuffmanTree();
	}

	public void HuffmanTree() throws IOException {
		PrintHuffman pf = new PrintHuffman();
		PriorityQueue<HuffmanNode> q = new PriorityQueue<>(freq.length, new HuffmanComparator());

		for (int i = 0; i < freq.length; i++) {
			HuffmanNode huffmanNode = new HuffmanNode();

			huffmanNode.c = chars[i];
			huffmanNode.item = freq[i];

			huffmanNode.left = null;
			huffmanNode.right = null;

			q.add(huffmanNode);
		}

		HuffmanNode root = null;

		while (q.size() > 1) {

			HuffmanNode x = q.peek();
			q.poll();

			HuffmanNode y = q.peek();
			q.poll();

			HuffmanNode f = new HuffmanNode();

			f.item = x.item + y.item;
			f.c = '-';
			f.left = x;
			f.right = y;
			root = f;

			q.add(f);
		}
		Encode();
		BufferedWriter bw = new BufferedWriter(new FileWriter("HuffmanEncoding.csv", false));
		pf.printCode(root, "");
		StringBuilder Decoded = Encode();
		if (isLeaf(root)) {
			while (root.item-- > 0) {
				System.out.print(root.c);
			}
		} else {
			int index = -1;
			while (index < Decoded.length() - 1) {
				index = decodeData(root, index, Decoded);
			}
		}
		printDecoded();
	}


	public StringBuilder Encode() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("HuffmanEncoding.csv"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("Encoded.txt"));
		StringBuilder str = new StringBuilder(text);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				str.setCharAt(i, 'á');
		}
		String[][] arr = new String[chars.length][2];
		String line;
		int x = 0;
		while ((line = br.readLine()) != null) {
			String[] values = line.split("[,\n]");
			arr[x][0] = values[0];
			arr[x][1] = values[1];
			x++;
		}
		StringBuilder Encoded = new StringBuilder();
		for (int j = 0; j < str.length(); j++) {
			for (int i = 0; i < chars.length; i++) {
				if (String.valueOf(str.charAt(j)).equals(arr[i][0])) {
					Encoded.append(arr[i][1]);
				}

			}
		}
		bw.write(String.valueOf(Encoded));
		br.close();
		bw.flush();
		bw.close();
		return Encoded;
	}

	public void printDecoded() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Decoded.txt"));
		bw.write(String.valueOf(t));
		bw.close();
	}


	public int decodeData(HuffmanNode root, int index, StringBuilder Decoded) {
		if (root == null) {
			return index;
		}
		if (isLeaf(root)) {
			if (root.c == 'á') {
				t.append(" ");
			} else {
				t.append(root.c);
			}
			return index;
		}
		index++;
		if (Decoded.charAt(index) == '0') root = root.left;
		else root = root.right;
		index = decodeData(root, index, Decoded);
		return index;
	}

	public static boolean isLeaf(HuffmanNode root) {
		return root.left == null && root.right == null;
	}

}


