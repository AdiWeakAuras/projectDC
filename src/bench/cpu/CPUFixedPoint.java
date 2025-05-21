package bench.cpu;

import bench.IBenchmark;
import logging.TimeUnit;

public class CPUFixedPoint implements IBenchmark {
    private int[] num = {0, 1, 2, 3};
    private int[] res;
    private int[] a, b, c;
    private int size;
    private long totalOps;

    private long operations;


    public void arithmeticTest() {
        int j = 1, k = 2, l = 3;
        for (int i = 0; i < size; i++) {
            j = num[1] * (k - j) * (l - k);  // 6 ops
            k = num[3] * k - (l - j) * k;     // 6 ops
            l = (l - k) * (num[2] + j);       // 5 ops
            res[l - 2] = j + k + l;           // 4 ops
            res[k - 2] = j * k * l;           // 4 ops
            // Total per iteration: 25 ops
            operations += 25;
        }
        // Loop operations: 2 ops/iteration * size
        operations += 2L * size;
    }
    @Override
    public void initialize(Object... params) {
        size = (Integer) params[0];
        res = new int[size];
        a = new int[size];
        b = new int[size];
        c = new int[size];

        // Initialize arrays with values
        for (int i = 0; i < size; i++) {
            a[i] = i;
            b[i] = size - i - 1;
            c[i] = i % 4;
        }
        totalOps = 0;
    }

    // Integer arithmetic test (29 operations per iteration)


    // Branching test (12 operations per iteration)
    public void branchingTest() {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (j == 1) j = num[2]; else j = num[3];  // 3 ops
            if (j > 2) j = num[0]; else j = num[1];    // 3 ops
            if (j < 1) j = num[1]; else j = num[0];    // 3 ops
            // Loop: i<size (1), i++ (1), total = 9 + 2 = 11 ops/iteration
        }
        totalOps += 11L * size;
    }

    // Array test (5 operations per iteration)
    public void arrayTest() {
        for (int i = 0; i < size; i++) {
            c[i] = a[b[i]];  // 3 ops (access a, access b, assign c)
            // Loop: i<size (1), i++ (1), total = 3 + 2 = 5 ops/iteration
        }
        totalOps += 5L * size;
    }

    @Override
    public void warmUp() {
        // Warm up all test methods
        arithmeticTest();
        branchingTest();
        arrayTest();
        totalOps = 0; // Reset after warmup
    }

    @Override
    public void run() {
        run(NumberRepresentation.FIXED); // Default to fixed-point
    }

    @Override
    public void run(Object... options) {
        totalOps = 0;
        arithmeticTest();
        branchingTest();
        arrayTest();
    }

    @Override
    public void cancel() {}

    @Override
    public void clean() {
        res = null;
        a = b = c = null;
    }

    @Override
    public String getResult() {
        return String.format("Total operations: %,d", totalOps);
    }

    public double getMOPS(long runtimeNs) {
        double runtimeSeconds = TimeUnit.toTimeUnit(runtimeNs, TimeUnit.Sec);
        return totalOps / (runtimeSeconds * 1e6);
    }


    public long getOperations() {
        return operations;
    }
}