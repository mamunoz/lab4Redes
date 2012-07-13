package models;

import java.util.ArrayList;
//rtpkt
public class Packet {
	private int sourceId;

	private int destId;
	private ArrayList<Integer> mincost;

	/**
	 * @param sourceId
	 * @param destId
	 * @param mincost
	 */
	public Packet(int sourceId, int destId) {
		this.sourceId = sourceId;
		this.destId = destId;
		this.mincost = new ArrayList<Integer>();
		
		mincost.add(999);
		mincost.add(999);
		mincost.add(999);
		mincost.add(999);
	}
	
	/* Getters & Setters */
	public int getSourceId() {
		return sourceId;
	}

	public int getDestId() {
		return destId;
	}

	public ArrayList<Integer> getMincost() {
		return mincost;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public void setDestId(int destId) {
		this.destId = destId;
	}

	public void setMincost(ArrayList<Integer> mincost) {
		this.mincost = mincost;
	}

}
