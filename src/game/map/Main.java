package game.map;

public class Main {
	public static void main(String[] args) {
		World worldMap = new World((int) Math.pow(2, 10) + 1,"SQUAREDIAMOND");
		
		for(int i = 0; i < worldMap.getWorldMap().length; i++) {
			for(int j = 0; j < worldMap.getWorldMap().length; j++) {
				System.out.print(worldMap.getWorldTile(j, i));
			}
			System.out.println();
		}
		
	}
}