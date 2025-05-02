package bench;

public interface IBenchmark {
    void run();

    /**
     * @param params Variable list of parameters for the benchmark run.
     */
    void run(Object ... params);

    /**
     * @param params Variable list of parameters for initialization 
     */
    void initialize(Object ... params);
    void clean();
    void cancel();
    void warmup();
}
