package timing;

public interface ITimer {
    void start();

    /**
     * @return Total elapsed time in nanoseconds.
     */
    long stop();
    void resume();
    /**
     * @return Elapsed time in nanoseconds for the last active interval.
     */
    long pause();
}
