package logging;

public interface ILog {

	public void write(String string);

	public void write(long value);

	public void write(Object... values);

	public void close();
}
