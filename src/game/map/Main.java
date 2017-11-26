package game.map;

public class Main {
	public static void main(String[] args) {
		World worldMap = new World(5000);
		worldMap.generateWhiteNoise();
		System.out.println("Done");
	}
}