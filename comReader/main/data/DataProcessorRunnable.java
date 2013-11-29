package data;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Application;
import algorithm.helper.Point;

/**
 * DataProcessorRunnable checks if the batchSignalQueue is empty. If it is not empty, it takes
 * a batch of signal strengths and performs algorithm calculations on them. After that, it puts 
 * calculated values into the calculatedPositionsQueue. If the queue is empty, thread sleeps
 * for constant number of milliseconds, before checking if a new batch has arrived into the batchSignalQueue.
 */
public class DataProcessorRunnable implements Runnable {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	private volatile boolean running = true;
	
	/** Time in milliseconds to put the thread to sleep before checking again is the queue empty.  */
	private static final int TIME_TO_SLEEP_IF_QUEUE_EMPTY = 25;
	
	/**
	 * Instantiates a new data processor runnable.
	 */
	public DataProcessorRunnable() {
		
		running = true;
	}

	/** (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		while (running == true) {
			
			if (!Application.getApplication().getController().getBatchSignalQueue().isEmpty()) {
				
				// allSignalStrengths contains averaged signal strengths, from every receiver, for every watch  
				 
				HashMap<Integer, HashMap<Integer, Double>> allSignalStrengths = 
						Application.getApplication().getController().getBatchSignalQueue().poll();
				
				// for every watch, send the average receivers strength to the algorithm for calculation 
				for (Map.Entry<Integer, HashMap<Integer, Double>> entry : allSignalStrengths.entrySet()) {
						
					Point position = Application.getApplication().getAlgorithm().calculate(entry.getValue());
					if(position == null) {
						System.out.println("position is null");
					}
					else {
						System.out.println(position);
					}
					int watchId = entry.getKey();
					long currentTime = System.currentTimeMillis() / 1000L; // Tommy: changed it by dividing 1000L to get UNIX timestamp
					int mapId = 0; // TODO: get actual room map id instead of supplying zero every time
					WatchPositionData newData = new WatchPositionData(watchId, currentTime, position);
					Application.getApplication().getController().getCalculatedPositionsQueue().add(newData);
				}
				
			} else { // queue is empty, check again later
				
				try {
					Thread.sleep(TIME_TO_SLEEP_IF_QUEUE_EMPTY);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} // end run

	public void terminate() {
        running = false;
        logger.log(Level.INFO, "DataProcessorRunnable has been terminated.");
    }
	
}
