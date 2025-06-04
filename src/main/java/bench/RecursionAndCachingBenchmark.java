package bench;

public class RecursionAndCachingBenchmark implements IBenchmark {

    @Override
    public String run() {

        return "Recursion and caching benchmark completed successfully!";
    }

    @Override
    public String run(Object... params) {
        return run();
    }

    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmup() {

    }
}
