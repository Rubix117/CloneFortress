
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.map;

import java.util.Random;

public class SquareaDiamondGenerator extends WorldGenerator{
	private int arraySize;
	private int mapArray[][];
	private int mapSize; // this will be the size that the user sees.
	private int noise;
	private Random rand;

	@Override
	public int[][] generateWorld(int size) {
		rand = new Random();
		mapSize = size;
		noise = rand.nextInt(70 - 50) + 50;
		arraySize = size - 1; // total size is the size of the map and keeps in
		// the array bounds, this will be renamed to array size.
		mapArray = new int[size][size];
		System.out.println(size);
		setStaringCorners();
		size -= 1;
		for (double x = size / 2; x >= 1; x /= 2) {
			System.out.println(size);
			size /= 2; // this is harraySizeow much the distance between each point is itteration
			diamond(size);
			square(size);
			noise *= .7;
			// printMap();
		}
		
		return mapArray;
	}
	
	public SquareaDiamondGenerator() { }

	private void diamond(int size)// this is the diamond step gets the
	// value for the diamond.
	{
		for (int y = size; y < arraySize; y += size * 2) {
			for (int x = size; x < arraySize; x += size * 2) {
				// System.out.println("Y: " + y + "X: " + x + "Size: " + size);
				mapArray[y][x] = cornerAverage(y, x, size);
			}
		}
	}

	private int cornerAverage(int y, int x, int size) // calculates the average, this is
	// only used in the diamond calulations
	{
		int average = ((mapArray[y - size][x - size] + mapArray[y + size][x - size] + mapArray[y - size][x + size]
				+ mapArray[y + size][x + size]) / 4) + (rand.nextInt(noise + noise + 1) - noise);

		return average;
	}

	private void square(int size) {
		// This is where the square is drwen and the averages are calculated
		for (int y = size; y < arraySize; y += size * 2) {
			for (int x = size; x < arraySize; x += size * 2) {
				mapArray[y - size][x] = topBottomAverage(y - size, x, size);
				mapArray[y + size][x] = topBottomAverage(y + size, x, size);
				mapArray[y][x - size] = topBottomAverage(y, x - size, size);
				mapArray[y][x + size] = topBottomAverage(y, x + size, size);
			}
		}
	}

	private int topBottomAverage(int y, int x, int size) {

		int average = ((mapArray[(Math.abs(y - size))][x] + mapArray[(y + size) % arraySize][x]
				+ mapArray[y][(x + size) % arraySize] + mapArray[y][Math.abs(x - size)]) / 4)
				+ (rand.nextInt(noise + noise + 1) - noise);

		return average;
	}

	// private void printMap() //this prints the 2D array.
	// {
	// for (int i = 0; i < arraySize + 1; i++)
	// {
	// for (int j = 0; j < arraySize + 1; j++)
	// {
	// System.out.print(mapArray[i][j] + "\t");
	// }
	// System.out.println("");
	// }
	// }

	private void setStaringCorners() // these are the starting corners and will
	// be random later..
	{
		for (int i = 0; i <= arraySize; i += arraySize) {
			for (int j = 0; j <= arraySize; j += arraySize) {
				mapArray[i][j] = rand.nextInt(80); // this is the
				// random amount that each corner gets.
			}
		}
	}

	public int getMapSize() {
		return mapSize;
	}

	public int[][] getMap() {
		return mapArray;
	}
}