package ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {
	private int low;
	private int high;
	private Random random = new Random();

	public ThreadLocalRandomExample(int low, int high) {
		this.low = low;
		this.high = high;
	}

	public List<Integer> generateRandom(int size) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			list.add(ThreadLocalRandom.current().nextInt(low, high));
		}
		return list;
	}

	public List<Integer> generateRandomOld(int size) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			list.add(random.nextInt(high - low) + low);
		}
		return list;
	}

	public static void main(String[] args) {
		ThreadLocalRandomExample ex = new ThreadLocalRandomExample(1, 100);
		long start = System.nanoTime();
		ex.generateRandom(10000);
		System.out.println(System.nanoTime() - start);

		start = System.nanoTime();
		ex.generateRandomOld(10000);
		System.out.println(System.nanoTime() - start);
	}

}
