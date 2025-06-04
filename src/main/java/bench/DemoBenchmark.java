package bench;

import java.util.Random;

public class DemoBenchmark implements IBenchmark {

    private int workload;
    private int[] data;
    private volatile boolean running;

    @Override
    public String run() {
        long sum = 0;
        for (int i = 0; i < data.length && running; i++) {
            sum += data[i];
        }
        return "Sum: " + sum;
    }

    @Override
    public String run(Object... params) {
        return run();
    }

    @Override
    public void initialize(Object... params) {
        if (params.length < 1 || !(params[0] instanceof Integer)) {
            throw new IllegalArgumentException("Workload size (Integer) required for initialization.");
        }
        this.workload = (Integer) params[0];
        this.data = new int[this.workload];
        Random random = new Random();
        for (int i = 0; i < this.workload; i++) {
            data[i] = random.nextInt(100);
        }
        this.running = true;

    }

    @Override
    public void clean() {
        this.data = null;

    }

    @Override
    public void cancel() {
        this.running = false;

    }

    @Override
    public void warmup() {

        for (int i = 0; i < 1000; i++) {
            Math.sqrt(i);
        }
    }
}
