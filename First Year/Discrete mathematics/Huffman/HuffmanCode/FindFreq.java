
public class FindFreq {
	private int x;
	private int[] charFreq;
	private char[] stringChars;

	public FindFreq(String str) {
		charFreq = new int[str.length()];
		stringChars = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			charFreq[i] = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (stringChars[i] == stringChars[j]) {
					charFreq[i]++;
					stringChars[j] = '0';
				}
			}
		}
		x = 0;
		for (int i = 0; i < charFreq.length; i++) {
			if (stringChars[i] != '0') x++;
		}
	}

	public char[] getChars() {
		char[] chars = new char[x];
		int j = 0;
		for (char stringChar : stringChars) {
			if (stringChar != '0') {
				chars[j] = stringChar;
				j++;
			}
		}
		for (int i = 0 ; i < chars.length ; i++) {
			if (chars[i] == ' ') {
				chars[i] = 'á';
			}
		} // á is Space
		System.out.println(chars);
		return chars;
	}

	public int[] getCharsFreq() {
		int[] freq = new int[x];
		int j = 0;
		for (int i = 0; i < stringChars.length; i++) {
			if (stringChars[i] != '0') {
				freq[j] = charFreq[i];
				j++;
			}
		}
		return freq;
	}
}
