package bench.cpu;

import bench.IBenchmark;

public class CPUFixedVsFloatingPoint implements IBenchmark {
	private int result;
	private int size;
	private long operations;

	@Override
	public void initialize(Object... params) {
		this.size = (Integer) params[0];
	}

	@Override
	public void warmUp() {
		for (int i = 0; i < 1000; ++i) {
			result = i >> 8;       // Fixed (1 op)
			result = (int)(i / 256.0); // Floating (1 op)
		}
		operations = 0;
	}


	public void run() {

	}


	@Override
	public void run(Object... options) {
		result = 0;
		operations = 0;

		switch ((NumberRepresentation) options[0]) {
			case FLOATING:
				for (int i = 0; i < size; ++i) {
					result += i / 256.0;  // 1 op (floating division)
					operations += 1;
				}
				break;
			case FIXED:
				for (int i = 0; i < size; ++i) {
					result += i >> 8;     // 1 op (bit shift)
					operations += 1;
				}
				break;
		}
		// Count loop operations: i<size (size times), i++ (size times)
		operations += 2L * size;
	}

	public long getOperations() {
		return operations;
	}
	@Override
	public void cancel() {}

	@Override
	public void clean() {}

	@Override
	public String getResult() {
		return String.valueOf(result);
	}
}