package com.Martin.Frogger;

import java.util.Timer;
import java.util.TimerTask;

public class Cars {
public static int KeySec = 2;
public int Carsx = 0;
public static Timer keyTime = new Timer();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		keyTime.scheduleAtFixedRate(KeyTimer(), 1000, 1000);
	}
	public static TimerTask KeyTimer() {
		TimerTask task = new TimerTask() {
			public void run() {
				KeySec=2;
				KeySec--; 
			
			}
		};

		return task;
	}

}
