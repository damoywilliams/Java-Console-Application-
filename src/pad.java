/**
 * This class contains two method 1 to pad int and the other to pad strings
 * this is done so every record have a fix length.
 *
 * @author (Damoy Williams)
 * @version (2)
 */

public class pad {

	public static String writeFixedLengthInt(int i) {
		// converts integer to left-zero padded string, len chars long.
		String s = Integer.toString(i);
		if (s.length() > 6) {
			return s.substring(0,6);
			// pad on left with zeros
		} else if (s.length() < 6) {
			return "000000000000000000000000000".substring(0,
					6 - s.length())
					+ s;
		} else {
			return s;
		}
	}

	public static String writeFixedLengthString(String s ) {
		char[] chars = new char[36];

		// Fill in string with characters
		s.getChars(0, Math.min(s.length(), 36), chars, 0);

		// Fill in blank characters in the rest of the array
		for (int i = Math.min(s.length(), 36); i < chars.length; i++)
			chars[i] = ' ';

		// Create and write a new string padded with blank characters
		return (new String(chars));
	}
}