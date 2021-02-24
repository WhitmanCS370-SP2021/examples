// Which version is better? (exercise 2.17)

// Version 1
public String substring(int start) {
	String temp = new String();
	for (int i = start; i < length(); i++) {
		temp += this.charAt(i);
	return temp;
}
public String substring(int start, int length) {
	String temp = new String();
	for (int i = 0; i < start + length; i++) {
		temp += this.charAt(i);
	return temp.substring(start);
}

// Version 2
public String substring(int start, int length) {
	String temp = new String();
	for (int i = start; i < start + length; i++) {
		temp += this.charAt(i);
	return temp;
}
public String substring(int start) {
	return substring(start, length() - start);
}
