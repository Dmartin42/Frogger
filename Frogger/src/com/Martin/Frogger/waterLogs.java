package com.Martin.Frogger;

import java.awt.Rectangle;


public class waterLogs extends Rectangle{
	public  int Waterx;
	public int Watery;
	public static  	int speed1 = 5;
 	public static int speed2 = 10;
	public waterLogs(int STARTx,int STARTy){
		Waterx=STARTx;
		Watery=STARTy;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void LogMove() {
			//   -- LOGS MOVEMENT --
	
			MartinFrogger.Llog_pos [0][0]+=speed1; //loG 1:1   
			MartinFrogger.Llog_pos [1][0]+=speed1;  
			MartinFrogger.Llog_pos [2][0]+=speed1;
			MartinFrogger.Llog_pos [3][0]+=speed1; 
			
			MartinFrogger.Llog_pos [4][0]+=speed1; //log2:1
			MartinFrogger.Llog_pos [5][0]+=speed1;  
			MartinFrogger.Llog_pos [6][0]+=speed1; //log2
			MartinFrogger.Llog_pos [7][0]+=speed1;  //log2
		
			MartinFrogger.Llog_pos [8][0]+=speed1;//Log 3:1
			MartinFrogger.Llog_pos [9][0]+=speed1;
			MartinFrogger.Llog_pos [10][0]+=speed1;//Log 3
			MartinFrogger.Llog_pos [11][0]+=speed1;
			
			MartinFrogger.Llog_pos[12][0]+=speed1; //Log 4:1
			MartinFrogger.Llog_pos[13][0]+=speed1;
			MartinFrogger.Llog_pos[14][0]+=speed1;   //Log 4
			MartinFrogger.Llog_pos[15][0]+=speed1;  //Log 4
			
			MartinFrogger.Llog_pos [16][0]+=speed2;		 //Log 5:2
			MartinFrogger.Llog_pos [17][0]+=speed2;
			MartinFrogger.Llog_pos [18][0]+=speed2;
		 	MartinFrogger.Llog_pos [19][0]+=speed2;
			
		 	MartinFrogger.Llog_pos [20][0]+=speed2;   //Log 6:2
		 	MartinFrogger.Llog_pos [21][0]+=speed2;    
		 	MartinFrogger.Llog_pos [22][0]+=speed2;    
		 	MartinFrogger.Llog_pos [23][0]+=speed2;
		 	
		 	MartinFrogger.Llog_pos [24][0]+=speed2;   //Log 7:2
		 	MartinFrogger.Llog_pos [25][0]+=speed2;    
		 	MartinFrogger.Llog_pos [26][0]+=speed2;    
		 	MartinFrogger.Llog_pos [27][0]+=speed2;
		 	
		 	MartinFrogger.Llog_pos [28][0]+=speed2;   //Log 8:2
		 	MartinFrogger.Llog_pos [29][0]+=speed2;    
		 	MartinFrogger.Llog_pos [30][0]+=speed2;    
		 	MartinFrogger.Llog_pos [31][0]+=speed2;
		 	
		 	MartinFrogger.Llog_pos [32][0]+=speed2;   //Log 9:2
		 	MartinFrogger.Llog_pos [33][0]+=speed2;    
		 	MartinFrogger.Llog_pos [34][0]+=speed2;    
		 	MartinFrogger.Llog_pos [35][0]+=speed2;
			for(int i=0; i<MartinFrogger.Llog_pos.length;i+=4) {
				 if((MartinFrogger.Llog_pos[i][0]>750)) {
					 MartinFrogger.Llog_pos[i][0] = -300;
					 MartinFrogger.Llog_pos[i+1][0] = -279;
					 MartinFrogger.Llog_pos[i+2][0] = -258;
					 MartinFrogger.Llog_pos[i+3][0] = -237;
				 }
		}
	}
	public Rectangle WaterBOUNDS() {
		return (new Rectangle(Waterx,Watery,700,180));
	}
	public Rectangle LogBounds(int i) {
		Rectangle r6 = (new Rectangle(MartinFrogger.Llog_pos[i][0],MartinFrogger.Llog_pos[i][1],20,20));
		return r6;
	}
}

