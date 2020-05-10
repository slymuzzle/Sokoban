
public class Analyze {
    public static String parseText(String value) {
	String text = "";
	for(int i = 0; i < value.length();i++) {
		char symbol = value.charAt(i);
		if('0' <= symbol & symbol <= '9') {
			text = text + symbol;
		}
		if(symbol == '\n') {
			text = text + '\n';
		}
	}
	return text;
    }
}