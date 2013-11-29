package data;

/**
 * Implementation of DataWriter interface. This class has a thread that 
 * writes watch positions to the queue.
 */
public class DatabaseDataWriter implements DataWriter{

	private DatabaseDataWriterRunnable runnable;
	
	/**
	 * Instantiates a new database data writer.
	 */
	public DatabaseDataWriter() {
		// TODO Auto-generated constructor stub
		
	}

	/* (non-Javadoc)
	 * @see data.DataWriter#writeData()
	 */
	@Override
	public void writeData() {
		
		runnable = new DatabaseDataWriterRunnable();
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
	public void stopReading() {
		runnable.terminate();
	}

}
