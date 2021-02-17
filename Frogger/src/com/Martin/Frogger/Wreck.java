package com.Martin.Frogger;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class Wreck extends Rectangle {
	public int RECTx;
	public int RECTy;

	public static int Time_Min = 5;
	public static int Time_TenSec = 0;
	public static int Time_Seconds = 0;
	public static int Seconds = 300;
	public static Timer Time = new Timer();
	
	public Wreck(int StartX, int StartY) {

		RECTx = StartX;
		RECTy = StartY;

	}

	public void TruckMove() {
		MartinFrogger.TRUCK_X += MartinFrogger.TRUCK_VEL_X; // X value for Truck 1
		MartinFrogger.TRUCK_Y += MartinFrogger.TRUCK_VEL_Y; // Y Truck 1
		MartinFrogger.Tx += MartinFrogger.TRUCK_VEL_X; // X Truck 1
		MartinFrogger.Ty += MartinFrogger.TRUCK_VEL_Y; // Y Truck 1
		MartinFrogger.T2x += MartinFrogger.TRUCK_VEL_X; // X Truck 2
		MartinFrogger.T2y += MartinFrogger.TRUCK_VEL_Y; // y Truck 2
		MartinFrogger.T3x += MartinFrogger.TRUCK_VEL_X; // X Truck 3
		MartinFrogger.T3y += MartinFrogger.TRUCK_VEL_Y;// Y Truck 3
		MartinFrogger.Truckx4 -= MartinFrogger.TRUCK_VEL_X; // X Truck 4
		MartinFrogger.Trucky4 -= MartinFrogger.TRUCK_VEL_Y;// Y Truck 4
		MartinFrogger.Truckx5 -= MartinFrogger.TRUCK_VEL_X; // X Truck 5
		MartinFrogger.Trucky5 -= MartinFrogger.TRUCK_VEL_Y;// Y Truck 5
		MartinFrogger.Truckx6 -= MartinFrogger.TRUCK_VEL_X; // X Truck 6
		MartinFrogger.Trucky6 -= MartinFrogger.TRUCK_VEL_Y;// Y Truck 6
		
		if (MartinFrogger.TRUCK_X > 900) { // Testing Truck
			MartinFrogger.TRUCK_X = -10;
		}
		if (MartinFrogger.Tx > 900) { // Truck 1
			MartinFrogger.Tx = -10;
		}
		if (MartinFrogger.T2x > 900) { // Truck 2
			MartinFrogger.T2x = -10;
		}
		if (MartinFrogger.T3x > 900) { // Truck 3
			MartinFrogger.T3x = -10;
		}
		if (MartinFrogger.Truckx4 < -100) { // Truck 4
			MartinFrogger.Truckx4 = 750;
		}
		if (MartinFrogger.Truckx5 < -100) { // Truck 5
			MartinFrogger.Truckx5 = 750;
		}
		if (MartinFrogger.Truckx6 < -100) { // Truck 6
			MartinFrogger.Truckx6 = 750;
		}
	}


	public static TimerTask Go() {
		TimerTask task = new TimerTask() {
			public void run() {

				Seconds--;
				// TODO Auto-generated method stub
				if ((Time_Seconds == 0) && (Time_TenSec == 0) && (Time_Min == 0)) {
					Time_Seconds =0;
					Time_TenSec = 0;
					Time_Min = 5;
					MartinFrogger.Game = false;
				} else if ((Time_TenSec == 0) && (Time_Seconds == 0)) {
					Time_Min--;
					Time_Seconds = 9;
					Time_TenSec = 5;
				} else if (Time_Seconds == 0) {
					Time_Seconds = 9;
					Time_TenSec--;
				} else
					Time_Seconds -= 1;
				MartinFrogger.TIME_LEFT.setValue(Seconds);
			}
		};

		return task;
	}

	public Rectangle Truckbounds() {
		return (new Rectangle(RECTx, RECTy, 75, 30));
	}

	public Rectangle carBounds() {
		return (new Rectangle(RECTx, RECTy, 50, 20));

	}

	public Rectangle PlayerBounds() {
		return (new Rectangle(RECTx, RECTy, 20, 20));
	}
}
