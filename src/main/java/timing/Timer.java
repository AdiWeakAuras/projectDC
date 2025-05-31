package timing;

public class Timer implements ITimer {

    private long startTime;
    private long stopTime;
    private long accumulatedTime;
    private boolean running;

    public Timer() {
        reset();
    }

    private void reset() {
        startTime = 0;
        stopTime = 0;
        accumulatedTime = 0;
        running = false;
    }

    @Override
    public void start() {
        startTime = System.nanoTime();
        accumulatedTime = 0;
        running = true;
    }

    @Override
    public long stop() {
        if (running) {
            stopTime = System.nanoTime();
            accumulatedTime += stopTime - startTime;
            running = false;
        }
        return accumulatedTime;
    }

    @Override
    public void resume() {
        if (!running) {
            startTime = System.nanoTime();
            running = true;
        }
    }

    @Override
    public long pause() {
        if (running) {
            stopTime = System.nanoTime();
            accumulatedTime += stopTime - startTime;
            running = false;
        }
        return accumulatedTime;
    }
}
