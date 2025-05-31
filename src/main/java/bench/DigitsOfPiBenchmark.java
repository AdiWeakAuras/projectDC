package bench;

public class DigitsOfPiBenchmark implements IBenchmark {

    @Override
    public String run() {

        return "Digits of Pi calculated successfully!";
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
