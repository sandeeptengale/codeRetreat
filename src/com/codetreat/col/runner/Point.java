package com.codetreat.col.runner;

public class Point {
	private int x;
	private int y;
	private boolean live;
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Point(int targetX, int targetY){
		this.x = targetX;
		this.y = targetY;
	}
	
	public Point(int targetX, int targetY, boolean live){
		this.x = targetX;
		this.y = targetY;
		this.live = live;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (live ? 1231 : 1237);
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (live != other.live)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", live=" + live + "]";
	}

	
}
