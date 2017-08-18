class Format {
	public static void main(String[] args) {
		System.out.println(String.format("%1$02d:%2$02d", 9, 1));

		System.out.println(String.format("members", 1));

		System.out.println(String.format("%swebsocket", "http://www.baidu.com/"));
	}
}