package game.map;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateNoiseThread implements Callable<GenerateNoiseThread>{
	
	private double[] mapSegment;
	private int rowID;
	
	
	public GenerateNoiseThread(double[] mapSegment, int rowID) {
		this.mapSegment = mapSegment;
		this.rowID = rowID;
	}
	@Override
	public GenerateNoiseThread call() throws Exception {
		for(int i = 0; i < this.mapSegment.length; i++) {
			this.mapSegment[i] = ThreadLocalRandom.current().nextDouble(0, 255);
		}
		return this;
	}
	
	public double[] getMapSegment() {
		return mapSegment;
	}
	
	public int getRowID() {
		return rowID;
	}
}