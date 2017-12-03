package game.map;

public class WorldGeneratorFactory {
		public WorldGenerator getWorldGenerator(String generatorType) {
			if(generatorType.equalsIgnoreCase("SQUAREDIAMOND")) {
				return new SquareaDiamondGenerator();
			}
			else {
				return null;
			}
		}
}
