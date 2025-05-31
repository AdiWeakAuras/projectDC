package bench.ram;

import java.util.Random;

import bench.IBenchmark;
import timing.Timer;

public class VirtualMemoryBenchmark implements IBenchmark {

    private int[] memoryArray;

    @Override
    public void initialize(Object... params) {
        int size = (int) params[0];
        memoryArray = new int[size];
    }

    @Override
    public void warmup() {
        for (int i = 0; i < memoryArray.length; i++) {
            memoryArray[i] = i;
        }
    }

    @Override
    public String run() {
        throw new UnsupportedOperationException("Use run(Object[]) instead");
    }

    @Override
    public String run(Object... options) {
        int iterations = (int) options[0];
        Random random = new Random();
        Timer timer = new Timer();

        timer.start();
        for (int i = 0; i < iterations; i++) {
            int index = random.nextInt(memoryArray.length);
            memoryArray[index] = random.nextInt();
        }
        long elapsedTime = timer.stop();

        return "Execution time: " + elapsedTime + " ns";
    }

    @Override
    public void clean() {
        memoryArray = null;
    }

    @Override
    public void cancel() {

    }
}
