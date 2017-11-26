package game.map;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class World {
	private int size;
	private double[][] noise;
	public World(int size) {
		this.size = size;
		this.noise = new double[this.size][this.size];
	}
	
	double[][] generateWhiteNoise(){
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<GenerateNoiseThread>> listOfExecutors = new ArrayList<Future<GenerateNoiseThread>>();
		for(int i = 0; i < this.size; i++) {
			Callable<GenerateNoiseThread> randomPoints = new GenerateNoiseThread(this.noise[i], i);
			Future<GenerateNoiseThread> futureRandomPoints = executor.submit(randomPoints);
			listOfExecutors.add(futureRandomPoints);
		}
		for(Future<GenerateNoiseThread> futureRandomPoint : listOfExecutors) {
			try {
				System.out.println(futureRandomPoint.get().getRowID());
				noise[futureRandomPoint.get().getRowID()] = futureRandomPoint.get().getMapSegment();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		System.out.println("DONE");
		return noise;
	}
}