package com.Martin.Frogger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.management.timer.Timer;
import javax.swing.text.Position;

public class MartinCars extends Rectangle {
	public int x_cars;
	public int y_cars;
	public int Orange_x_cars;
	public int Orange_y_cars;
	public int J = 0;
	public static int POSITION;
	private int row;
	private int startX;
	public MartinCars(int StartX, int StartY, int StartX1, int StartY1) {

		x_cars = StartX;
		y_cars = StartY;
		Orange_x_cars = StartX1;
		Orange_y_cars = StartY1;
	}

	public void CarMove() {
		POSITION = Orange_x_cars - Orange_x_cars;
		x_cars += 20;
		Orange_x_cars += 20;
		if ((x_cars > 750)) {
			x_cars = 0;

		}

		if ((Orange_x_cars > 900)) {
			Orange_x_cars = 0;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Rectangle bounds() {
		return (new Rectangle(x_cars, y_cars, 30, 20));
	}

	public Rectangle ORANGE_bounds() {
		return (new Rectangle(Orange_x_cars, Orange_y_cars, 30, 20));

	}

	public boolean isVisble() {
		// TODO Auto-generated method stub
		return true;

	}
}
