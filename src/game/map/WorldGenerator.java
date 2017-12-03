package game.map;

public abstract class WorldGenerator {
	protected int size;
	
	public abstract int[][] generateWorld(int size);
}
