import java.io.*;

public class PrintHuffman {
	public void printCode(HuffmanNode root, String s) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("HuffmanEncoding.csv",true));
		if (root.left == null && root.right == null && Character.isLetter(root.c)) {
			bw.write(root.c + "," + s+'\n');
			bw.close();
			return;
		}
		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
		bw.close();
	}
}
