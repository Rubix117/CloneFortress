package game.map;


public class World {
	private int size;
	private int[][] worldMap;
	private WorldGenerator worldGenerator;
	public World(int size, String worldGeneratorType) {
		this.size = size;
		WorldGeneratorFactory worldGeneratorFactory = new WorldGeneratorFactory();
		worldGenerator = worldGeneratorFactory.getWorldGenerator(worldGeneratorType);
		worldMap = worldGenerator.generateWorld(this.size);
		
	}
	
	
	public int[][] getWorldMap(){
		return worldMap;
	}
	
	public int getWorldTile(int x, int y) {
		return worldMap[y][x];
	}
	
}