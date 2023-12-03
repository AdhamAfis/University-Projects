import java.util.Comparator;

class HuffmanComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode x, HuffmanNode y) {
		return x.item - y.item;
	}
}
