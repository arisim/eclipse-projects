package classwork;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.Scanner;


//Aryan Patel
//Period E
//May 9, 2018
//Description

public class AryanPCS extends JoeApplet implements KeyListener, MouseListener, MouseMotionListener
{
	Color brown = new Color (165, 42, 42);
	
	int[] floorxpos = {-200, 300, 985, 1500};
	int[] floorypos = {680, 400, 400, 680};
	
	SolidObject mouseSO = new SolidObject();
	SolidObject detrickSO = new SolidObject();
	
	boolean home = true;
	boolean playGame = true;
	boolean firstCollision = true;
	
	
	char quiz;
	int countinedialogue;
	
	//Import anything to program at home with comment importhome
	Scanner scan = new Scanner(System.in);
	
	Image titlescreen, detrickF, alexR, blackBoard;
	
	//happens once at the beginning of the program
	public void init()
	{
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		//getImage(getCodeBase(),".jpg");
		titlescreen = getImage(getCodeBase(),"WHSchool.jpg");
		detrickF = getImage(getCodeBase(),"DetrickF.PNG");
		alexR = getImage(getCodeBase(),"AlexAr.jpg");
		blackBoard = getImage(getCodeBase(),"blackboard.jpg");
	}
	
	//This will have the directions to start
	public void drawHomeScreen(Graphics art)
		{
			art.drawImage(titlescreen,0,0, 1400,685, this);
			//art.drawImage(img, x, y, width, height, observer)
			art.drawString("FIRST DAY AT WARRENHILLS SIMULATIOR.   Hit X to begin", 200, 200);
			
		}
		
	public void drawEndScreen(Graphics art)
		{
			art.drawString("Game over.   Hit R to replay", 200,200);
		}
	public void drawdetrick(Graphics art)
	{
		art.drawImage(detrickF, 545, 100, 200, 165, this);
		detrickSO.makeSolidObject(545, 100, 205, 165);
	}
	
	public void collision()
	{
		if(mouseSO.isCollidingWith(detrickSO) )		//check if two balls are colliding
		{
			if(firstCollision)						//check if this is the first collision
			{
				playGame = false	//if it is the first collision, now it is not colliding
			}
		}
		else
		{
			playGame = true;					//when no longer colliding, put first collision back to true
		}
	}
	
	public void room(Graphics art)
	{
		//wall
		art.setColor(Color.white);
		art.fillRect(0, 0, 1300, 690);
		
		//floor
		art.setColor(Color.black);
		art.fillPolygon(floorxpos, floorypos, 4);
		//int[] floorxpos = {0, 200, 1100, 1300};
		//int[] floorypos = {680, 500, 500, 680};
		
		
		//blacklines
		art.setColor(Color.BLACK);
		//farthest Left
		art.fillRect(0, 0, 5, 800);
		//left of desk
		art.fillRect(300, 0, 5, 510);
		//art.fillRect(x, y, width, height);
		//right of teach
		art.fillRect(980, 0, 5, 510);
		//farthest right
		art.fillRect(1300, 0, 5, 800);
		
		//wallpaperback
		art.drawImage(blackBoard, 305, 0, 575, 250, this);
		
		drawDoor(art);
		
	}
	
	public void teacherdesk(Graphics art)
	{
		//topofdesk
		art.setColor(Color.GRAY);
		art.fillRect(350, 265, 600, 35);
		//art.drawRect(x, y, width, height);
		
		//the teacher desk
		art.setColor(brown);
		art.fillRect(400, 300, 475, 100);
	
	}

	public void studentdesk(Graphics art)
	{
		//art.fillRect(x, y, width, height);
		
		//desk 
		//table
		art.setColor(Color.YELLOW);
		art.fillRect(150, 350, 200, 10);
				
		//legs
		art.setColor(Color.GRAY);
		art.fillRect(200,360,25,50);
		
				
		//SDChair
		art.setColor(Color.GRAY);
		//back
		art.fillRect(100, 300, 10, 120);
		//"chair"
		art.fillRect(100, 420, 100, 10);
		
		//studentbody
		
		//studenthead
		art.drawImage(alexR,100, 200, 100, 50, this);
	
	}
	
	public void playerdesk(Graphics art)
	{
		//art.fillRect(x, y, width, height);
		//desk 
		//table
		art.setColor(Color.YELLOW);
		art.fillRect(350, 500, 600, 500);
		
	}
	
	public void classroom(Graphics art)
	{
		room(art);
		teacherdesk(art);
		studentdesk(art);
		playerdesk(art);
	}
	
	
	public void quiz(Graphics art)
	{
		countinedialogue = 0;
		art.drawString("Welcome to my class my favorite block E class of the year. We are taking a quiz so please type", 330, 35);
		art.drawString("quiz on your computer to begin or you want to fail do anything else...", 330, 46);
		
	}
	
	
	
	public void detrickquiz(Graphics art)
	{
		
		quiz(art);
	}

	public void detrickClassroom(Graphics art)
	{
		classroom(art);
		art.drawImage(detrickF, 545, 100, 200, 165, this);
		detrickquiz(art);
	}
	
	
	public void paint (Graphics art)
	{
		setSize(1305,685);
		if(home)							//draws the home screen
		{
			drawHomeScreen(art);
		}
		else if(playGame)								//plays the game
		{
			setBackground(Color.blue);
			detrickClassroom(art);
			
		}
		else
		{
			drawEndScreen(art);
		}
		setFrameRate(60);
		repaint();
		
	}





	@Override
	public void mouseDragged(MouseEvent e)
	{
	}





	@Override
	public void mouseMoved(MouseEvent e)
	{
		
		ball2X = e.getX();
		ball2Y = e.getY();
			

	}





	@Override
	public void mouseClicked(MouseEvent arg0)
	{
	}





	@Override
	public void mouseEntered(MouseEvent arg0)
	{
	}





	@Override
	public void mouseExited(MouseEvent arg0)
	{
	}





	@Override
	public void mousePressed(MouseEvent arg0)
	{
		mouseSO.makeSolidObject(e.getX(), e.getY(), 1,1);
	}





	@Override
	public void mouseReleased(MouseEvent arg0)
	{
	}





	@Override
	public void keyPressed(KeyEvent e)
	{
int key = e.getKeyCode();
		
		if(key == e.VK_R)
		{
			home = true;
			playGame = true;
		}
		if(key == e.VK_X)
		{
			home = false;
		}
		
		
	}





	@Override
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(key == e.VK_P)
		{
			countinedialogue++;
			
		}
	}





	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}
