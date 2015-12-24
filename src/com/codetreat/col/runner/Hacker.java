package com.codetreat.col.runner;

public class Hacker {
	public static void main(String[] args){
		int[][] input = new int[10][35];
		
		System.out.println(getMaxX(input) + " " + getMaxY(input));
	}
	
	public static int getMaxX(int[][] input){
		int maxX = 0;
		for(int row = 0; row < input.length; row++){
			maxX++;
		}
		return maxX;
	}
	
	public static int getMaxY(int[][] input){
		int maxY = 0;
		for(int row = 0; row < input.length; row++){
			maxY = 0;
			for(int col = 0; col < input[row].length; col++){
				maxY++;
			}
		}
		return maxY;
	}
}
