package com.codetreat.col.runner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RulesTest {

	int INIT_X = 3;
	int INIT_Y = 3;
	private Board getBoard() {

		List<Point> points = new ArrayList<Point>();
		
		int [][] input = new int[INIT_X][INIT_Y];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				points.add(new Point(i, j));
			}
		}
		
		Board board = new Board();
		board.setBoardPoints(points);
		
		
		return board;
	}
	
	@Test
	public void testGetMaxX() {
		Board board = getBoard();
		assertEquals(INIT_X - 1, board.getMaxX());
	}


	@Test
	public void testGetMaxY() {
		Board board = getBoard();
		assertEquals(INIT_Y - 1, board.getMaxY());
	}

	
	@Test
	public void testGetNeighboursFor11(){
		List<Point> neighbours = Rules.getNeighbours(getBoard(), 1, 1);
		
		List<Point> expected = new ArrayList<Point>();
		expected.add(new Point(0,0));
		expected.add(new Point(0,1));
		expected.add(new Point(0,2));
		
		expected.add(new Point(1,0));
		expected.add(new Point(1,2));

		expected.add(new Point(2,0));
		expected.add(new Point(2,1));
		expected.add(new Point(2,2));
		
		assertEquals(expected, neighbours);
		
	}
	
	@Test
	public void testGetNeighboursFor00(){
		List<Point> neighbours = Rules.getNeighbours(getBoard(), 0, 0);
		
		List<Point> expected = new ArrayList<Point>();
		expected.add(new Point(0,1));
		
		expected.add(new Point(1,0));
		expected.add(new Point(1,1));

		assertEquals(expected, neighbours);
		
	}
	
	@Test
	public void testGetLiveNeighbours(){
		List<Point> points = new ArrayList<Point>();

		points.add(new Point(0, 1,false));
		points.add(new Point(1, 0, true));
		points.add(new Point(1, 1, true));
		
		assertEquals(2, Rules.getLiveCount(points));
	}
	
	@Test
	public void testGetDeadNeighbours(){
		List<Point> points = new ArrayList<Point>();

		points.add(new Point(0, 1,false));
		points.add(new Point(1, 0, true));
		points.add(new Point(1, 1, true));
		
		assertEquals(1, Rules.getDeadCount(points));
	}
	
	@Test
	public void testRuleWithLessThenTwoNeighbours(){
		Board board = getBoard();
		board.updateBoard(new Point(0, 0, true));
		
		Board result = Rules.ruleWithLessThenTwoNeighbours(board, board.getPoint(0, 0), 1);
		
		assertEquals(new Point(0,0,false), result.getPoint(0, 0));
	}
	
	@Test
	public void testRulewithExactlyThreeLiveNeighbours(){
		Board board = getBoard();
		board.updateBoard(new Point(1, 0, true));
		board.updateBoard(new Point(1, 1, true));
		board.updateBoard(new Point(0, 1, true));
		
		Board result = Rules.rulewithExactlyThreeLiveNeighbours(board, board.getPoint(0, 0),3);
		
		assertEquals(new Point(0,0,true), result.getPoint(0, 0));
		
	}
	
	@Test
	public void  testRuleWithMoreThenThreeLiveNeighbours(){
		Board board = getBoard();
		
		board.updateBoard(new Point(0, 0, true));
		board.updateBoard(new Point(2, 0, true));
		board.updateBoard(new Point(0, 1, true));
		board.updateBoard(new Point(0, 2, true));
		
		board.updateBoard(new Point(1, 1, true));
		
		Board result = Rules.ruleWithMoreThenThreeLiveNeighbours(board, board.getPoint(1, 1),4);
		
		assertEquals(new Point(1,1,false), result.getPoint(1, 1));
	}
	
	@Test
	public void testRuleWithTwoORThreeLiveNeighbours(){
		Board board = getBoard();
		
		board.updateBoard(new Point(2, 2, true));
		board.updateBoard(new Point(1, 2, true));
		board.updateBoard(new Point(2, 1, true));
		
		Board result = Rules.ruleWithTwoORThreeLiveNeighbours(board, board.getPoint(2, 2),3);
		
		assertEquals(new Point(3,2,true), result.getPoint(3, 2));
	}
	
	@Test
	public void ruleExecuteRules(){
		Board board = getBoard();
		
	}
}
