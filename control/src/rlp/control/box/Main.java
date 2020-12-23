package rlp.control.box;

public class Main {

	public static void main(String[] args) {
		ControlConfiguration configuration = new ControlConfiguration(args);
		ControlBox box = new ControlBox(configuration);
		box.start();
		Runtime.getRuntime().addShutdownHook(new Thread(box::stop));
	}
}