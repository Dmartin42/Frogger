package com.Martin.Frogger;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.Timer;



public class MartinFrogger extends JPanel implements ActionListener, KeyListener{
	
	/**
	 *@author: Daniel Martin
	 */
	private static final long serialVersionUID = 1L;
	private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private static Dimension windowDim = new Dimension(dim.width/4, dim.width/4);
	private static Dimension gameDim = new Dimension((dim.width/3)+60, (dim.width/3)+80);
	public static int x = 360;
	public static int y = 0;
	public static int TRUCK_VEL_X = 10; 
	public static int TRUCK_VEL_Y = 0;
	public static int Tx =0;
	public static int Ty =110;
	public static int T2x = 300;
	public static int T2y =110;
	public static int T3x= 600;
	public static int T3y =110;
	
	public static int Truckx4=750;
	public static int Trucky4=160;
	
	public static int Truckx5=400;
	public static int Trucky5=160;
	
	public static int Truckx6=100;
	public static int Trucky6=160;
	
	public static int TRUCK_X = 0; 
	public static int TRUCK_Y = 350; 
	public static Boolean GameStartUp = true;
	public static JFrame frame;
	public static JProgressBar TIME_LEFT;
	public final static  int Car1_pos[][] = {{-200,45},{-100,45},{0,45},{80,45}}; //First set of Cars coordinates L to R
	public final static int Car2_pos[][] = {{-250,76},{-150,76},{-20,76},{150,76}};  //Second Set of Cars coordinates L to R
	
		//This is the first set of cars going from Right to Left
	public final static int Llog_pos[][] = {
											{100,460},{121,460,},{142,460},{163,460},  //Log: Line   1:1
											{300,460},{321,460},{342,460},{363,460},     //2:1
											{500,460},{521,460,},{542,460},{563,460},  //3:1
											{-100,460},{-79,460,},{-58,460},{-37,460}, //4:1
											{0,480},{21,480},{42,480},{63,480 }, 			 //5:2 
											{200,480},{221,480},{242,480},{263,480 },//6:2
											{400,480},{421,480},{442,480},{463,480}, //7:2
											{600,480},{621,480},{642,480},{663,480}, //8:2
											{-200,480},{-179,480},{-158,480},{-137,480} //9:2
											};  	
	public static ArrayList<Rectangle> 	LargeLOGS;
	public static ArrayList<MartinCars> Vehicles1;  //First set of vehicles (the cyan ones)
	public static ArrayList<MartinCars> Vehicles2; //Second set of vehicles (the orange ones)
	public static ImageIcon i = new ImageIcon("D:\\Tech\\Frog.jpg");
	public static Image Frog = i.getImage();
	public  static int Hx = 0;
	public static int Hy =0;
	public static Boolean Collision = false;
	public static Boolean onLOG = false;
	public static int Lives = 3;
	public static Boolean Game = false;
	public Timer timer= new Timer(100,this);
	Wreck Truck1;
	Wreck truck;
	Wreck Player;
	Wreck Truck2;
	Wreck Truck3;
	Wreck Truck4;
	Wreck Truck5;
	Wreck Truck6;
	waterLogs Water;
	public MartinFrogger() {


			
			this.setLayout(null);
			TIME_LEFT = new JProgressBar();
			this.add(TIME_LEFT);
			TIME_LEFT.setBackground(Color.LIGHT_GRAY);
			TIME_LEFT.setBounds(90,13, 100, 20);
			TIME_LEFT.setForeground(Color.MAGENTA);
			JLabel source = new JLabel("Writtten by Daniel Martin 2018");
			source.setBounds(590, 370, 155, 155);
			add(source);
			
			
			addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
					x = (e.getX()/20) * 20;
					y = (e.getY()/20) * 20;
					System.out.println("Player:"+"("+x+","+y+")");
				}
			});
			
			TIME_LEFT.setVisible(true);
			TIME_LEFT.setMaximum(300);
			
			LoadCars();
		
			timer.start();

			
			
			setBackground(Color.BLACK);
			
			addKeyListener(this);
			
			setFocusable(true);
			
			setFocusTraversalKeysEnabled(false);
			
		
			
	}

	public static void LoadCars() {   //CARS ARE RENDERED HERE. 
		// TODO Auto-generated method stub
		Vehicles1 = new ArrayList<>();
		Vehicles2 = new ArrayList<>();
		for(int[] i:Car1_pos) {
			Vehicles1.add(new MartinCars(i[0],i[1],0,0));//Array list Vehicles spawns the car from the 2d array above.
	} 
		for(int[] j:Car2_pos) {
			Vehicles2.add(new MartinCars(0,0,j[0],j[1]));
		}
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			Drawing(g);
	}
	public static void Menu() {   //Main Menu that pops up b4 game begins! User must hit 'begin' to begin!
		JFrame Frame = new JFrame("Menu");
			Frame.getContentPane().setLayout(null);
			Frame.setSize(windowDim);
			Frame.setLocation(dim.width/2-Frame.getWidth()/2,dim.height/2-Frame.getHeight()/2);
		JPanel Panel = new JPanel();
		Panel.setLocation(0, 0);
			Panel.setSize(new Dimension(458, 424));
			Panel.setBackground(Color.DARK_GRAY);
			Frame.getContentPane().add(Panel);
		GridBagLayout gbl_Panel = new GridBagLayout();
		gbl_Panel.columnWidths = new int[]{108, 0, 180, 93, 0};
		gbl_Panel.rowHeights = new int[]{56, 22, 37, 31, 31, 31, 0, 106, 0, 14, 0};
		gbl_Panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Panel.setLayout(gbl_Panel);
		JLabel Title = new JLabel("FROGGER");
		Title.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,48));
		Title.setForeground(Color.GREEN);
		GridBagConstraints gbc_Title = new GridBagConstraints();
		gbc_Title.anchor = GridBagConstraints.NORTH;
		gbc_Title.insets = new Insets(0, 0, 5, 5);
		gbc_Title.gridwidth = 2;
		gbc_Title.gridx = 1;
		gbc_Title.gridy = 0;
		Panel.add(Title, gbc_Title);
		JLabel Author = new JLabel("By Daniel Martin");
		Author.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,18));
		Author.setForeground(Color.BLACK);
		GridBagConstraints gbc_Author = new GridBagConstraints();
		gbc_Author.gridheight = 2;
		gbc_Author.anchor = GridBagConstraints.NORTHEAST;
		gbc_Author.insets = new Insets(0, 0, 5, 5);
		gbc_Author.gridx = 2;
		gbc_Author.gridy = 1;
		Panel.add(Author, gbc_Author);
		JButton Inst = new JButton("Instructions");
		Inst.setBackground(Color.WHITE);
		Inst.setFont(new Font("Times New Roman",Font.BOLD,18));
		Inst.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(Frame, "Player will have to take on an adventure and travel across the screen and capture 5 frogs.\nPlayer will only have 5 mins to do so and, Player gets three chances to do so.\nPlayer ought to be careful to not get hit by a car/truck or fall into the water.\nGood Luck ", "HOW TO BASIC", JOptionPane.OK_OPTION);
				}
			});
		JButton Start = new JButton("Begin!");
		Start.setBackground(Color.GREEN);
		Start.setFont(new Font("Times New Roman",Font.BOLD,24));
		Start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Game=true;
				Frame.dispose();
				main(null); 
			}
		});
		GridBagConstraints gbc_Start = new GridBagConstraints();
		gbc_Start.gridwidth = 2;
		gbc_Start.fill = GridBagConstraints.BOTH;
		gbc_Start.insets = new Insets(0, 0, 5, 5);
		gbc_Start.gridx = 1;
		gbc_Start.gridy = 3;
		Panel.add(Start, gbc_Start);
		GridBagConstraints gbc_Inst = new GridBagConstraints();
		gbc_Inst.gridwidth = 2;
		gbc_Inst.fill = GridBagConstraints.HORIZONTAL;
		gbc_Inst.insets = new Insets(0, 0, 5, 5);
		gbc_Inst.gridx = 1;
		gbc_Inst.gridy = 4;
		Panel.add(Inst, gbc_Inst);
		JButton Score = new JButton("Score");
		Score.setEnabled(false);
		Score.setForeground(Color.PINK);
		Score.setBackground(Color.CYAN);
		Score.setFont(new Font("Times New Roman",Font.BOLD,18));
		Score.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("IMPLEMENT LATER");
				}
			});
		GridBagConstraints gbc_Score = new GridBagConstraints();
		gbc_Score.gridwidth = 2;
		gbc_Score.fill = GridBagConstraints.HORIZONTAL;
		gbc_Score.insets = new Insets(0, 0, 5, 5);
		gbc_Score.gridx = 1;
		gbc_Score.gridy = 5;
		Panel.add(Score, gbc_Score);
		JButton Quit = new JButton("Quit");
		Quit.setBackground(Color.RED);
		Quit.setFont(new Font("Times New Roman",Font.BOLD,18));
		GridBagConstraints gbc_Quit = new GridBagConstraints();
		gbc_Quit.gridwidth = 2;
		gbc_Quit.fill = GridBagConstraints.HORIZONTAL;
		gbc_Quit.insets = new Insets(0, 0, 5, 5);
		gbc_Quit.gridx = 1;
		gbc_Quit.gridy = 6;
		Panel.add(Quit, gbc_Quit);
		Quit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});
		JLabel Source = new JLabel("All Rights Reserved");
		Source.setFont(new Font("Times New Roman",Font.ITALIC,12));
		Source.setForeground(Color.GRAY);
		GridBagConstraints gbc_Source = new GridBagConstraints();
		gbc_Source.insets = new Insets(0, 0, 5, 0);
		gbc_Source.anchor = GridBagConstraints.WEST;
		gbc_Source.gridx = 3;
		gbc_Source.gridy = 8;
		Panel.add(Source, gbc_Source);
		Frame.setVisible(true);
	}
	public void Drawing(Graphics g) {
        if(Collision) {
        	g.setColor(Color.WHITE);
    		g.setFont(new Font("Times New Roman",Font.BOLD,24));
    		g.drawString("COLLISION",403,304);
        	EndGame();
        }
        g.setColor(Color.RED);
		g.setFont(new Font("Times New Roman",Font.BOLD,24));
		g.drawString("LIVES: "+ Lives,500,35);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Leelawadee UI",Font.BOLD,18)); //TIME text font 
		g.drawString("TIME:                           "+Wreck.Time_Min+":"+Wreck.Time_TenSec+""+Wreck.Time_Seconds,10,30); //Time text atop of screen used for TIME
		truck = new Wreck(TRUCK_X,TRUCK_Y);
		Player = new Wreck(x,y);
		Truck1 = new Wreck(Tx,Ty);
		Truck2 = new Wreck(T2x,T3y);
		Truck3 = new Wreck(T3x,T3y);
		Truck4 = new Wreck(Truckx4,Trucky4);
		Truck5 = new Wreck(Truckx5,Trucky5);
		Truck6 = new Wreck(Truckx6,Trucky6);
		Water = new waterLogs(0,460);
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setColor(Color.GREEN);
        
        g2d.setColor(Color.RED);
        g2d.fillRect(truck.RECTx, truck.RECTy,75,30 );
        g2d.fillRect(Truck1.RECTx,Truck1.RECTy,75,30);
        g2d.fillRect(Truck2.RECTx,Truck2.RECTy,75,30);
        g2d.fillRect(Truck3.RECTx,Truck3.RECTy,75,30);
        g2d.fillRect(Truck4.RECTx,Truck4.RECTy,75,30);
        g2d.fillRect(Truck5.RECTx,Truck5.RECTy,75,30);
        g2d.fillRect(Truck6.RECTx,Truck6.RECTy,75,30);
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0,460,700,180);
       
        drawLine(g);
        for(MartinCars a : Vehicles1) 
        {
        		g.setColor(Color.CYAN);
        		g.fillRect(a.x_cars, a.y_cars, 30, 20);
        		a.CarMove();
        }
        for(MartinCars b: Vehicles2) 
        {
        	g.setColor(Color.ORANGE);
        	g.fillRect(b.Orange_x_cars,b.Orange_y_cars, 30, 20);
        	b.CarMove();
        }
        for(int i =0; i<Llog_pos.length;i++) {
        	g.setColor(Color.PINK);
        	g.fillRect(Llog_pos[i][0],Llog_pos[i][1],20,20);
        }
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x,y,20,20); //player model
	}
	public void drawLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.YELLOW);
	    g.drawLine(0,40,150,40);
		g.drawLine(180,40,280,40);    //ROW1
		g.drawLine(310,40,410,40);   //ROW1
		g.drawLine(440,40,540,40);	//ROW1
		g.drawLine(570,40,670,40); //ROW1
		
	
		
		g.drawLine(10,70,50,70);g.drawLine(60,70,100,70);g.drawLine(110,70,150,70);g.drawLine(160,70,200,70);  //Lane 2
		g.drawLine(210,70,250,70);g.drawLine(260,70,300,70);g.drawLine(310,70,350,70);g.drawLine(360,70,400,70);
		g.drawLine(410,70,450,70);g.drawLine(460,70,500,70);g.drawLine(510,70,550,70);g.drawLine(560,70,600,70);g.drawLine(610,70,650,70);
		
		g.drawLine(10,100,50,100);g.drawLine(60,100,100,100);g.drawLine(110,100,150,100);g.drawLine(160,100,200,100);  //Lane 3
		g.drawLine(210,100,250,100);g.drawLine(260,100,300,100);g.drawLine(310,100,350,100);g.drawLine(360,100,400,100);
		g.drawLine(410,100,450,100);g.drawLine(460,100,500,100);g.drawLine(510,100,550,100);g.drawLine(560,100,600,100);g.drawLine(610,100,650,100);

/* Median 1*/ g.setColor(Color.WHITE);
			g.fillRect(0,150,700,5);
			g.setColor(Color.YELLOW);

/*Lane 4 REVERSED */ g.drawLine(10,200,50,200);g.drawLine(60,200,100,200);g.drawLine(110,200,150,200);g.drawLine(160,200,200,200);  //Lane 4   
			g.drawLine(210,200,250,200);g.drawLine(260,200,300,200);g.drawLine(310,200,350,200);g.drawLine(360,200,400,200);
			g.drawLine(410,200,450,200);g.drawLine(460,200,500,200);g.drawLine(510,200,550,200);g.drawLine(560,200,600,200);g.drawLine(610,200,650,200);		
			
/*Lane 5 */ g.drawLine(10,240,50,240);g.drawLine(60,240,100,240);g.drawLine(110,240,150,240);g.drawLine(160,240,200,240);  //Lane 5   
g.drawLine(210,240,250,240);g.drawLine(260,240,300,240);g.drawLine(310,240,350,240);g.drawLine(360,240,400,240);
g.drawLine(410,240,450,240);g.drawLine(460,240,500,240);g.drawLine(510,240,550,240);g.drawLine(560,240,600,240);g.drawLine(610,240,650,240);

/*Lane 6*/ g.drawLine(10,270,50,270);g.drawLine(60,270,100,270);g.drawLine(110,270,150,270);g.drawLine(160,270,200,270);  //Lane 6   
g.drawLine(210,270,270,270);g.drawLine(260,270,300,270);g.drawLine(310,270,350,270);g.drawLine(360,270,400,270);
g.drawLine(410,270,450,270);g.drawLine(460,270,500,270);g.drawLine(510,270,550,270);g.drawLine(560,270,600,270);g.drawLine(610,270,650,270);
	
	}
 	public static void main(String[] args) {  //MAIN 
		// TODO Auto-generated method stub
			if(GameStartUp) {
				GameStartUp=false;
				Menu();
			}
			if(Game) {
				frame = new JFrame("Main"); 
				frame.setSize(gameDim);
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				frame.setLocation(dim.width/2-frame.getWidth()/2,dim.height/2-frame.getHeight()/2);
				Wreck.Time.scheduleAtFixedRate(Wreck.Go(), 1000, 1000);
			
				MartinFrogger j = new MartinFrogger();
				
				frame.add(j);
				frame.setVisible(true);
			
			}

	}
	public void keyPressed(KeyEvent i) {
		
		int key = i.getKeyCode();
		if((key==KeyEvent.VK_UP)||(key==KeyEvent.VK_W)) 
			
		{
			Hy=-20;
			Hx=0;
			
		
		}
		if((key==KeyEvent.VK_DOWN)||(key==KeyEvent.VK_S)) 
		{
			Hy=20;
			Hx=0;
			
			
		}
		if(key==KeyEvent.VK_LEFT)
		{
			Hx=-20; 
			Hy=0;
			
				
		}
		if(key==KeyEvent.VK_RIGHT)
		{
			Hx=20;
			Hy=0;
			
		
		}
	
		
		
	}

	public void keyReleased(KeyEvent e) 
	{
		Hx=0;
		Hy=0;
		
	}

	public void keyTyped(KeyEvent e) {
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		waterLogs.LogMove();
		truck.TruckMove();
		CheckCollision();
		x+=Hx;
		y+=Hy;
	
		if(x<0) {
			x+=20;
		}
		if(x>=655) {
			x=655;
		}
		if(y<=0) {
			y+=20;
		}
		if((y>=639)||(y==660)) {
			y=640;
		}
		if(onLOG) {
			onLOG=false;
		}
		if(Game==false) {
			Reset();
		}
	
		repaint();
		
	}
	public  boolean CheckCollision() {
			for(MartinCars a : Vehicles1) {
				Rectangle r2 = a.bounds();
				 if(Player.carBounds().intersects(r2)) {
					 Collision = true;
					 return true;
				 }
			}  
			for(MartinCars a: Vehicles2) {
				
					Rectangle r3 = a.ORANGE_bounds();
					if(Player.carBounds().intersects(r3)) {
						 Collision = true;
						 return true;
					 }
				}
			for(int i =0; i<Llog_pos.length;i++) {  // PLAYER ON LOGS.... 
				if(Player.PlayerBounds().intersects(Water.LogBounds(i))) {
					onLOG= true;
					x=Llog_pos[i][0];
				} 
			}
			
			if(Player.PlayerBounds().intersects(truck.Truckbounds())){
				Collision =  true; 
				return true;
			
			}
			if(Player.PlayerBounds().intersects(Truck1.Truckbounds())){
				Collision =  true; 
				return true;
			
			}
			if(Player.PlayerBounds().intersects(Truck2.Truckbounds())){
				Collision =  true; 
				return true;
			
			}
			if(Player.PlayerBounds().intersects(Truck3.Truckbounds())){
				Collision =  true; 
				return true;
			}
			if(Player.PlayerBounds().intersects(Truck4.Truckbounds())){
				Collision =  true; 
				return true;
			
			}
			if(Player.PlayerBounds().intersects(Truck5.Truckbounds())){
				Collision =  true; 
				return true;
			
			}
			if(Player.PlayerBounds().intersects(Truck6.Truckbounds())){
				Collision =  true; 
				return true;
			
			}
			if(Player.carBounds().intersects(Water.WaterBOUNDS())&&(onLOG==false)) {
				Collision=true;
				return true;
			} else {
				Collision = false; 
				return false;
			}
			 
	}
	public static  void EndGame() {
		Lives--;
		if(Lives<=0) {
			Game=false;
			Lives=3;
			//IMPLEMENT WHEN DONE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
		}
		x=350;
		y=0;
			
	}
	public void Reset() {   //Goes back to menu when done!
		timer.stop();
		this.removeAll();
		frame.dispose();
		Menu();
	}


}
