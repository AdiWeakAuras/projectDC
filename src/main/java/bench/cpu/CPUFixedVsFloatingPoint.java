package bench.cpu;

import bench.IBenchmark;

public class CPUFixedVsFloatingPoint implements IBenchmark {

	private int result;
	private int size;

	@Override
	public void initialize(Object ... params) {
		this.size = (Integer)params[0];
	}

	@Override
	public void warmup() {
	    result = 0;
	    for (int i = 0; i < size; ++i) {
	        result += i;
	    }
	}

	@Override
	public String run(Object... params) {
	    result = 0;
	    size = (int) params[0];
	    for (int i = 0; i < size; ++i) {
	        result += i;
	    }
	    return "Result: " + result;
	}

	@Override
	public String run() {
	    result = 0;
	    for (int i = 0; i < size; ++i) {
	        result += i;
	    }
	    return "Result: " + result;
	}

	@Override
	public void cancel() {
	    result = 0;
	}

	@Override
	public void clean() {
		result = 0;
	}
}
