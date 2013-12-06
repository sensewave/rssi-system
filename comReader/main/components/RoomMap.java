/*
 * File: RoomMap.java
 * Date				Author				Changes
 * 08 Nov 2013		Tommy Griese		create version 1.0
 * 					Yentran Tran
 * 03 Dec 2013		Tommy Griese		Code refactoring (added variable GRANULARITY_DEFAULT, granularity and changed constructor)
 */
package components;

<<<<<<< HEAD
import java.util.ArrayList;

import algorithm.helper.PointRoomMap;
=======
import java.awt.image.BufferedImage;
>>>>>>> 4468ee92ad778bbabc9428f636dafd0fcd36dd9e

/**
 * The class RoomMap represents the map of a room.
 * 
 * @version 1.0 08 Nov 2013
 * @author Tommy Griese
 */
public class RoomMap {
	
	/** The default granularity constant for the roommap. */
	public static final double GRANULARITY_DEFAULT = 0.25;
	
	/** The actual granularity for the roommap. */
	private double granularity;
	
	/** The start value for the room map in x. */
	private double xFrom;
	
	/** The end value for the room map in x. */
	private double xTo;
	
	/** The start value for the room map in y. */
	private double yFrom;
	
	/** The end value for the room map in y. */
	private double yTo;
	
	/** Map image. */
	private BufferedImage mapImage;
	
	private double widthInMeters;
	private double heightInMeters;
	private double scaling; // pixels/meter
	private String title;
	
	/** Each point of this list contains a weighted point in a room ({@link algorithm.helper.PointRoomMap}). */
	private ArrayList<PointRoomMap> pointsRoomMap;
	
	/**
	 * Instantiates a new room map.
	 *
	 * @param xFrom the start value for the room map in x
	 * @param xTo the end value for the room map in x
	 * @param yFrom the start value for the room map in y
	 * @param yTo the end value for the room map in y
	 */
	public RoomMap(double xFrom, double xTo, double yFrom, double yTo, double granularity, String pathToImage) {
		super();
		this.xFrom = xFrom;
		this.xTo = xTo;
		
		this.yFrom = yFrom;
		this.yTo = yTo;
		this.pathToImage = pathToImage;
		
		this.granularity = granularity;
		
		initialize();
	}
	
	/**
	 * Instantiates a new room map.
	 *
	 * @param xFrom the start value for the room map in x
	 * @param xTo the end value for the room map in x
	 * @param yFrom the start value for the room map in y
	 * @param yTo the end value for the room map in y
	 * @param pathToImage the path to the image of the room map
	 */
	public RoomMap(double xFrom, double xTo, double yFrom, double yTo, BufferedImage image) {
		super();
		this.xFrom = xFrom;
		this.xTo = xTo;
		
		this.yFrom = yFrom;
		this.yTo = yTo;
<<<<<<< HEAD
		this.pathToImage = pathToImage;
		
		this.granularity = RoomMap.GRANULARITY_DEFAULT;
		
		initialize();
=======
		this.mapImage = image;
>>>>>>> 4468ee92ad778bbabc9428f636dafd0fcd36dd9e
	}
	
	/**
	 * Gets the start value for the room map in x.
	 *
	 * @return the x from
	 */
	public double getXFrom() {
		return this.xFrom;
	}
	
	/**
	 * Gets the end value for the room map in x.
	 *
	 * @return the x to
	 */
	public double getXTo() {
		return this.xTo;
	}
	
	/**
	 * Gets the start value for the room map in y.
	 *
	 * @return the y from
	 */
	public double getYFrom() {
		return this.yFrom;
	}
	
	/**
	 * Gets the end value for the room map in y.
	 *
	 * @return the y to
	 */
	public double getYTo() {
		return this.yTo;
	}
	
	/**
	 * Gets the path to the image.
	 *
	 * @return the path to the image
	 */
	public BufferedImage getPathToImage() {
		return mapImage;
	}

	/**
	 * Sets the path to the image.
	 *
	 * @param pathToImage the new path to the image
	 */
	public void setPathToImage(BufferedImage image) {
		this.mapImage = image;
	}

	public double getWidthInMeters() {
		return widthInMeters;
	}

	public void setWidthInMeters(double widthInMeters) {
		this.widthInMeters = widthInMeters;
	}

	public double getHeightInMeters() {
		return heightInMeters;
	}

	public void setHeightInMeters(double heightInMeters) {
		this.heightInMeters = heightInMeters;
	}
<<<<<<< HEAD
	
	/**
	 * Creates an array list of the room map with weighted points ({@link algorithm.helper.PointRoomMap}), depending on the given parameters.
	 *
	 * @param xFrom the start value for the room map in x
	 * @param xTo the end value for the room map in x
	 * @param yFrom the start value for the room map in y
	 * @param yTo the end value for the room map in y
	 * @param granularity the granularity of the room map
	 * @return an array list that represents the weighted room map 
	 */
	public void initialize() {
		this.pointsRoomMap = new ArrayList<PointRoomMap>();
		for (double i = this.xFrom; i <= this.xTo; i += this.granularity) { // x-Axe
			for (double j = this.yFrom; j <= this.yTo; j += this.granularity) { // y-Axe
				this.pointsRoomMap.add(new PointRoomMap(i, j));
			}
		}
	}
	
	public ArrayList<PointRoomMap> getRoomMapPoints() {
		return this.pointsRoomMap;
	}
	
	public void setRoomMapPoints(ArrayList<PointRoomMap> roomMap) {
		this.pointsRoomMap = roomMap;
	}
	
	public double getGranularity() {
		return this.granularity;
	}
=======

	public BufferedImage getMapImage() {
		return mapImage;
	}

	public void setMapImage(BufferedImage mapImage) {
		this.mapImage = mapImage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
>>>>>>> 4468ee92ad778bbabc9428f636dafd0fcd36dd9e
}
