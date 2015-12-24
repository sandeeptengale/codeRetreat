package com.codetreat.col.runner;

import java.util.ArrayList;
import java.util.List;

public class Rules {

	public static Board executeRules(Board input, Point currentPoint){

		int liveCount = getLiveCount(getNeighbours(input, currentPoint.getX(), currentPoint.getY()));

		input =	ruleWithLessThenTwoNeighbours(input, currentPoint, liveCount);
		input = rulewithExactlyThreeLiveNeighbours(input, currentPoint, liveCount);
		input = ruleWithTwoORThreeLiveNeighbours(input, currentPoint, liveCount);
		input = ruleWithMoreThenThreeLiveNeighbours(input, currentPoint, liveCount);
		return input;
	}

	public static Board ruleWithLessThenTwoNeighbours(Board input,
			Point currentPoint, int liveCount) {
		if(currentPoint.isLive() && liveCount < 2){
			currentPoint.setLive(false);
			input.updateBoard(currentPoint);

		}

		return input;
	}	

	public static Board rulewithExactlyThreeLiveNeighbours(Board input, Point currentPoint, int liveCount){
		if(!currentPoint.isLive() && liveCount == 3){
			currentPoint.setLive(true);
			input.updateBoard(currentPoint);
		}
		return input;
	}

	public static Board ruleWithMoreThenThreeLiveNeighbours(Board input, Point currentPoint, int liveCount){
		if(currentPoint.isLive() && liveCount > 3){
				currentPoint.setLive(false);
				input.updateBoard(currentPoint);
		}
		return input;
	}

	public static Board ruleWithTwoORThreeLiveNeighbours(Board input, Point currentPoint, int liveCount){
		if(currentPoint.isLive() && (liveCount == 2 || liveCount == 3)){
				input.addRowTop();
				input.updateBoard(new Point(currentPoint.getX() + 1, currentPoint.getY(), true));
			}
		return input;
	}

	public static List<Point> getNeighbours(Board input, int targetX, int targetY){

		List<Point> points = new ArrayList<Point>();
		int maxX = input.getMaxX();
		int maxY = input.getMaxY();

		int minX = input.getMinX();
		int minY = input.getMinY();

		//box 1 
		if(targetX > minX && targetY > minY){
			points.add(input.getPoint(targetX - 1, targetY - 1));
		}

		//box 2
		if(targetX > minX){
			points.add(input.getPoint(targetX -1, targetY));
		}

		//box 3
		if(targetX > minX && targetY < maxY){
			points.add(input.getPoint(targetX - 1, targetY + 1));
		}

		//box 4
		if(targetY > minY){
			points.add(input.getPoint(targetX, targetY - 1));
		}

		//box 6
		if(targetY < maxY){
			points.add(input.getPoint(targetX, targetY + 1));
		}

		//box 7
		if(targetX < maxX && targetY > minY){
			points.add(input.getPoint(targetX + 1, targetY - 1));
		}

		//box 8
		if(targetX < maxX){
			points.add(input.getPoint(targetX + 1, targetY));
		}

		//box 9
		if(targetX < maxX && targetY < maxY){
			points.add(input.getPoint(targetX + 1, targetY + 1));
		}

		return points;
	}

	public static int getLiveCount(List<Point> points){
		int count = 0;
		for(Point p : points){
			if(p.isLive()){
				count++;
			}
		}
		return count;
	}

	public static int getDeadCount(List<Point> points){
		int count = 0;
		for(Point p : points){
			if(!p.isLive()){
				count++;
			}
		}
		return count;
	}

}
