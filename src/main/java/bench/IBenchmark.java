package bench;

public interface IBenchmark {
    String run();

    String run(Object ... params);

    void initialize(Object ... params);
    void clean();
    void cancel();

    void warmup();
}
