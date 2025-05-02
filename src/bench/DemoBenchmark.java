package bench;

import java.util.Random;

public class DemoBenchmark implements IBenchmark {

    private int workload;
    private int[] data;
    private volatile boolean running;//flag to indicate if the benchmark is runing

    @Override
    public void run() {
        long sum = 0;
        for (int i = 0; i < data.length && running; i++) {
            sum += data[i];
             try {
                 Thread.sleep(0, 10);
             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
                 running = false;
             }
        }
        // System.out.println("DemoBenchmark finished run. Sum: " + sum); 
    }

    @Override
    public void run(Object... params) {
        run();
    }

    /**
     * @param params First parameter should be an Integer representing the workload size.
     */
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
        // System.out.println("DemoBenchmark initialized with workload: " + this.workload); 
    }

    @Override
    public void clean() {
        this.data = null;
        // System.out.println("DemoBenchmark cleaned."); 
    }

    @Override
    public void cancel() {
        this.running = false;
        // System.out.println("DemoBenchmark cancel requested.");
}
    @Override
    public void warmup() {
        int warmupWorkload = Math.min(1000, workload / 10); // Keep it short and safe
        Random random = new Random();
        int[] warmupData = new int[warmupWorkload];
        for (int i = 0; i < warmupWorkload; i++) {
            warmupData[i] = random.nextInt(100);
        }

        long sum = 0;
        for (int i = 0; i < warmupData.length; i++) {
            sum += warmupData[i];
            try {
                Thread.sleep(0, 10); // simulate CPU work
            } catch (InterruptedException ignored) {}
        }
    }

}
