package com.codetreat.col.runner;

import java.util.List;

public class Board {
	List<Point> boardPoints;
	int maxX;
	int maxY;
	int minX;
	int minY;
	
	public void calculateAndUpdateMaxX(){
		int maxX = 0;
		int minX = 0;
		for(Point p : boardPoints){
			if(p.getX() > maxX){
				maxX = p.getX();
			}
			if(p.getX() < minX){
				minX = p.getX();
			}
		}
		setMaxX(maxX);
		setMinX(minX);
	}

	public List<Point> getBoardPoints() {
		return boardPoints;
	}

	public void setBoardPoints(List<Point> boardPoints) {
		this.boardPoints = boardPoints;
		calculateAndUpdateMaxX();
		calculateAndUpdateMaxY();
	}

	
	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public void calculateAndUpdateMaxY() {
		// TODO Auto-generated method stub
		int maxY = 0;
		int minY = 0;
		for(Point p : boardPoints){
			if(p.getY() > maxY){
				maxY = p.getY();
			}
			if(p.getY() < minY){
				minY = p.getY();
			}
		}
		setMinY(minY);
		setMaxY(maxY);
	}
	
	public Point getPoint(int x, int y){
		for(Point p : boardPoints){
			if(p.getX() == x && p.getY() == y)
				return p;
		}
		return null;
	}
	
	public void updateBoard(Point point){
		Point localPoint = getPoint(point.getX(), point.getY());
		localPoint.setLive(point.isLive());
	}

	@Override
	public String toString() {
		return "Board [boardPoints=" + boardPoints + ", maxX=" + maxX
				+ ", maxY=" + maxY + "]";
	}
	
	public void addRowBottom(){
		for(int i = 0; i < getMaxY(); i++){
			boardPoints.add(new Point(getMinX() - 1, i));
		}
	}
	
	public void addRowTop(){
		for(int i = 0; i <= getMaxY(); i++){
			boardPoints.add(new Point(getMaxX() + 1, i));
		}
	}
}
