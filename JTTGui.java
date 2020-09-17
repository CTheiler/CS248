import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/* So First things first: I completely forgot that we were supposed to do the
AI as a BST. That being said, I totally understand if I'm docked points for that.

Anyway my AI follows two main Ideas:
1) When the AI goes first, it should always win
2) When the AI goes second, it should never lose

Now this may seem contradictory: if my AI can always win, who says there won't
be another AI that never loses? Or the opposite: If my AI never loses, then who says
there won't be another AI that always wins?

My idea to make these two ideas cooperate with each other was to minimize the amount
of winning the other AI can do. Through my testing, I believe that I have accomplished
my first idea of always winning, when going first. However, there is one combination (that i found) 
where my AI will lose when going second.

Because of these two Ideas, I made both of my AI's separately. When going first, I meticulously
tell my program where to go, depending on the moves the opponent makes. When going second, I allow
the AI to do the thinking for itself, by using functions to check if the opponent
or itself is close to winning. Because of this, I consider my AI to be much more reactionary
when going second compared to going first.

Anyway, how does it actually work? 

When going First, the AI will always to choose to go in circle 2. This is because I believe 
circles 2 & 8 are the most powerful spaces in the game. Then, depending on where the opponent
moves, the AI will move somewhere to account for that. Once the AI places it's second token, the
opponent will be forced to block it on their next turn. Once the AI forces the opponent into their
first block, the trap has been initiated. The AI will then be forced to block the opponent, but
when doing so, it will create two opportunities for itself to win on the it's next turn. So, once
the opponent makes their first block, it is effectively Game, Set and Match.

Now there's one situation where the opponent is not forced to block on their second turn. That is when
they decide to play on 5 the first turn. Then the AI is forced to play more passively on it's second turn
to secure the W. The AI will play in spot 8, and then the opponent will have the freedom to choose where
they play. No matter where the opponent plays, the AI will be forced in to blocking them on its third turn.
They say that the best form of Offense is a Solid defense right? Well this applies here as well.
After the block, there will be 2 oppurtunities where the AI can win, meaning the game is finished.

Basically, no matter how the player moves when going second, the game will be (effectively) finished
by their third turn!

If the AI plays second, the mentality completely changes. Instead of playing extremely aggresively, it's main
goal is not to lose. One thing that I found when experimenting with different possibilities is that
it is impossible to lose if you have 2,5 and 8. The opponent can't form any combinations to win if those
spaces are acquired. 

Let's go turn by turn. The first move for the AI is set up. If the player goes anywhere but 2, then the AI will go 2.
If the opponent goes 2, the AI goes 8. Simple stuff. On the second turn, the AI runs a function that checks if the
opponent is close to winning. This function checks every winning combination and if the opponent has 2 out of 3
of the spaces, and the last space they need is availble, the best move will be set to the last space they need.
Then the AI will chose to move there. If the opponent does not have a winning combination available, the AI will default
to taking one of 2/5/8 to continue to play defensively. On the third turn, the AI acts much the same, but it runs a function
to check if it can win. The function is very similar to checking if the opponent can win, but for the AI itself.
Once again, there is a way that my AIcan be beaten going second, but I believe there is only one (two ways if you count the mirror)
that it does lose!

Anyway, I'm sure this was much longer than it needed to be. Guess I got caried away. I quickly grew much more competitive
than I would've expected for this project, and I'm sure this represents that.

Thanks for a wonderful semester! See you in the Fall (hopefully!!)!
- Colin Theiler

P.S: I was going to be doing a lot of stuff with the Fibonacci sequence in this project
but I couldn't figure out how to get the Images to work how I wanted them too! That's why some
of the system messages and variable names are themed that way!
*/

/* @author Colin Theiler */
class Oval extends JPanel
{
	Color c;
	int x1; int y1;
	public Oval(Color color, int x, int y)
	{
		c=color;
		x1=x;
		y1=y; 
	}
	public void setGreen()
	{
		c=new Color(152,251,152);
	}
	public void setGold()
	{
		c = new Color(212,175,55);
	}
	public void setUp(Graphics g)
	{
		int[] xPoints14 = new int[4];
		int[] yPoints14 = new int[4];
		int[] xPoints15 = new int[4];
		int[] yPoints15 = new int[4];
		int[] xPoints35 = new int[4];
		int[] yPoints35 = new int[4];
		int[] xPoints36 = new int[4];
		int[] yPoints36 = new int[4];
		int[] xPoints24 = new int[4];
		int[] yPoints24 = new int[4];
		int[] xPoints26 = new int[4];
		int[] yPoints26 = new int[4];
		int[] xPoints74 = new int[4];
		int[] yPoints74 = new int[4];
		int[] xPoints75 = new int[4];
		int[] yPoints75 = new int[4];
		int[] xPoints95 = new int[4];
		int[] yPoints95 = new int[4];
		int[] xPoints96 = new int[4];
		int[] yPoints96 = new int[4];
		int[] xPoints84 = new int[4];
		int[] yPoints84 = new int[4];
		int[] xPoints86 = new int[4];
		int[] yPoints86 = new int[4];
		xPoints14[0]=65; xPoints14[1]=85; xPoints14[2]=360; xPoints14[3]=340;
		yPoints14[0]=75; yPoints14[1]=75; yPoints14[2]=400; yPoints14[3]=400;
		xPoints15[0]=65; xPoints15[1]=85; xPoints15[2]=560; xPoints15[3]=540;
		yPoints15[0]=75; yPoints15[1]=75; yPoints15[2]=400; yPoints15[3]=400;
		xPoints35[0]=1025; xPoints35[1]=1045; xPoints35[2]=560; xPoints35[3]=540;
		yPoints35[0]=75; yPoints35[1]=75; yPoints35[2]=400; yPoints35[3]=400;
		xPoints36[0]=1025; xPoints36[1]=1045; xPoints36[2]=760; xPoints36[3]=740;
		yPoints36[0]=75; yPoints36[1]=75; yPoints36[2]=400; yPoints36[3]=400;
		xPoints24[0]=540; xPoints24[1]=560; xPoints24[2]=360; xPoints24[3]=340;
		yPoints24[0]=75; yPoints24[1]=75; yPoints24[2]=400; yPoints24[3]=400;
		xPoints26[0]=540; xPoints26[1]=560; xPoints26[2]=760; xPoints26[3]=740;
		yPoints26[0]=75; yPoints26[1]=75; yPoints26[2]=400; yPoints26[3]=400;
		xPoints74[0]=65; xPoints74[1]=85; xPoints74[2]=360; xPoints74[3]=340;
		yPoints74[0]=725; yPoints74[1]=725; yPoints74[2]=400; yPoints74[3]=400;
		xPoints75[0]=65; xPoints75[1]=85; xPoints75[2]=560; xPoints75[3]=540;
		yPoints75[0]=725; yPoints75[1]=725; yPoints75[2]=400; yPoints75[3]=400;
		xPoints95[0]=1025; xPoints95[1]=1045; xPoints95[2]=560; xPoints95[3]=540;
		yPoints95[0]=725; yPoints95[1]=725; yPoints95[2]=400; yPoints95[3]=400;
		xPoints96[0]=1025; xPoints96[1]=1045; xPoints96[2]=760; xPoints96[3]=740;
		yPoints96[0]=725; yPoints96[1]=725; yPoints96[2]=400; yPoints96[3]=400;
		xPoints84[0]=540; xPoints84[1]=560; xPoints84[2]=360; xPoints84[3]=340;
		yPoints84[0]=725; yPoints84[1]=725; yPoints84[2]=400; yPoints84[3]=400;
		xPoints86[0]=540; xPoints86[1]=560; xPoints86[2]=760; xPoints86[3]=740;
		yPoints86[0]=725; yPoints86[1]=725; yPoints86[2]=400; yPoints86[3]=400;
			
		g.setColor(Color.blue);
		g.fillRect(0,0,1200,800);
		g.setColor(Color.yellow);
		g.fillRect(150,90,350,20);
		g.fillRect(600,90,350,20);
		g.fillRect(150,690,350,20);
		g.fillRect(600,690,350,20);
		g.fillRect(350,390,200,20);
		g.fillRect(600,390,200,20);
		g.fillPolygon(xPoints14, yPoints14, 4);
		g.fillPolygon(xPoints15, yPoints15, 4);
		g.fillPolygon(xPoints35, yPoints35, 4);
		g.fillPolygon(xPoints36, yPoints36, 4);
		g.fillPolygon(xPoints24, yPoints24, 4);
		g.fillPolygon(xPoints26, yPoints26, 4);
		g.fillPolygon(xPoints74,yPoints74,4);
		g.fillPolygon(xPoints75,yPoints75,4);
		g.fillPolygon(xPoints95,yPoints95,4);
		g.fillPolygon(xPoints96,yPoints96,4);
		g.fillPolygon(xPoints84, yPoints84,4);
		g.fillPolygon(xPoints86, yPoints86,4);
		g.setColor(Color.white);
		g.fillOval(50, 50, 100, 100); // oval 1
		g.fillOval(500, 50, 100, 100); // oval 2
		g.fillOval(50,650,100,100); // oval 7
		g.fillOval(950,50,100,100); //oval 3
		g.fillOval(300,350, 100 ,100); // oval 4
		g.fillOval(500,350,100,100); // oval 5
		g.fillOval(700,350,100,100); // oval 6
		g.fillOval(500,650,100,100);//oval 8
		g.fillOval(950,650,100,100); //oval 9
		g.setColor(Color.black);
		g.drawOval(50, 50, 100, 100);
		g.drawOval(500, 50, 100, 100);
		g.drawOval(50,650,100,100);
		g.drawOval(950,50,100,100);
		g.drawOval(300,350, 100 ,100);
		g.drawOval(500,350,100,100);
		g.drawOval(700,350,100,100);
		g.drawOval(500,650,100,100);
		g.drawOval(950,650,100,100);

	}
	public void draw(Graphics g)
    {
      g.setColor(c);
      g.fillOval(x1,y1, 100, 100);
	  drawNums(g);
    }
	public void drawNums(Graphics g)
	{
		g.setColor(Color.black);
		Font font = new Font("Comic Sans MS", Font.PLAIN, 36);
		g.setFont(font);
			
		g.drawString("1", 90, 110);
		g.drawString("2", 540,110);
		g.drawString("3", 990, 110);
		g.drawString("4", 340, 410);
		g.drawString("5", 540, 410);
		g.drawString("6", 740, 410);
		g.drawString("7", 90, 710);
		g.drawString("8", 540, 710);
		g.drawString("9", 990, 710);
	}
}


class board extends JPanel
{
	Oval [] jtt;
	int [] xpoints = {50,500,950,300,500,700,50,500,950};
	int [] ypoints = {50,50,50,350,350,350,650,650,650};

	
	public board()
	{
		jtt = new Oval[9];
		setSize(1200, 800);
		for(int i =0; i<jtt.length;i++)
		{
			jtt[i] = new Oval(Color.white, xpoints[i], ypoints[i]);
		}
	}
	public void clear()
	{
		for(int i =0; i<jtt.length;i++)
		{
			jtt[i] = new Oval(Color.white, xpoints[i], ypoints[i]);
			repaint();
		}
	}
	public void setFillAI(int i)
	{
		jtt[i].setGold();
	}	
	public void setFillPL(int i)
	{
		jtt[i].setGreen();
	}
	public void paintComponent(Graphics g)
	{
		jtt[0].setUp(g);
		for(int i=0; i<jtt.length; i++)
		{
			jtt[i].draw(g);
		}
	}
}

class JTTGui extends JFrame implements ActionListener
{
	JTextField imput;
	JButton enter;
	JTTGui gamer;
	board webby;
	int count;
	int[] unusable = new int[9];
	int[] opp = new int[5];
	int[] ai=new int[5];
	boolean first;
	int bestmove;
	int bestWinmove;
	int realplayer;
	int aiplayer;
	String cont;
	boolean aiwinner = false;
	
	class Closer extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.out.println("But the Fibonacci Sequence never ends... ");
			System.exit(0);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String x=imput.getText();
		int i=Integer.parseInt(x);
		if(checkAvailable(i))
		{
			unusable[count]=i;
			opp[count/2]=i;
			count++;
			i--;
			webby.setFillPL(i);
			webby.repaint();
			makeMove();
			winCheck(count);
		}
		else if(!checkAvailable(i))
		{
			System.out.println("That position is already taken! Try again!");
		}
	}
	
	public JTTGui()
	{
		setTitle("Jerry-Tac-Toe: Fibonacci Edition!");
		setSize(1300, 900);
		
		Container glass = getContentPane();
		
		glass.setLayout(new BorderLayout());
		addWindowListener(new Closer());
		
		imput = new JTextField("Input your move here!");
		enter = new JButton("Enter");
		
		enter.addActionListener(this);
		
		JPanel mlg = new JPanel();
		mlg.setLayout(new BorderLayout());
		webby=new board();
		mlg.add(webby,"Center");
		glass.add(mlg, "Center");
		
		JPanel bot = new JPanel();
		bot.setLayout(new BorderLayout());
		bot.add(imput, "South");
		bot.add(enter, "East");
		glass.add(bot, "South");

		setVisible(true);
	}
	
	public void playFirst()
	{
		first = true;
		makeMove();
	}
	public void playSecond()
	{
		first = false;
		makeMove();
	}
	public void makeMove()
	{
		if(first)
		{
			if(count==0)
			{
				webby.setFillAI(1);
				webby.repaint();
				unusable[count]=2;
				ai[count]=2;
				count++;
			}
			else if(count==2)
			{
					int temp = opp[0];
					if(temp==4)
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=6;
						count++;
					}
					else if(temp==6)
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=4;
						count++;
					}
					else if(temp==1)
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=9;
						count++;
					}
					else if(temp==3)
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=7;
						count++;
					}
					else if(temp==7)
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=3;
						count++;
					}
					else if(temp==9)
					{
						webby.setFillAI(1);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=1;
						count++;
					}
					else if(temp==8)
					{
						webby.setFillAI(4);
						webby.repaint();
						unusable[count]=5;
						ai[count/2]=5;
						count++;
					}
					else if(temp==5)
					{
						webby.setFillAI(7);
						webby.repaint();
						unusable[count]=8;
						ai[count/2]=8;
						count++;
					}
			}
			//third move
			else if(count==4)
			{
				
				//if opp went 4 first turn
				if(opp[0]==4)
				{
					if(opp[1]!=9)
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==9)
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				
				if(opp[0]==6)
				{
					if(opp[1]!=7)
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==7)
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				//if opp went 1 first turn
				if(opp[0]==1)
				{
					if(opp[1]!=6)
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=6;
						count++;
					}
					else if(opp[1]==6)
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=7;
						count++;
					}
				}
				//if opp went 3 first turn
				if(opp[0]==3)
				{
					if(opp[1]!=4)
					{
						webby.setFillAI(4);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=4;
						count++;
					}
					else if(opp[1]==4)
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				//if opp went 7 first turn
				if(opp[0]==7)
				{
					if(opp[1]!=1)
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
					// if opp went 1 second turn, go 6
					else if(opp[1]==1)
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				if(opp[0]==9)
				{
					if(opp[1]!=3)
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
					// if opp went 1 second turn, go 4
					else if(opp[1]==3)
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				if(opp[0]==5)
				{
					if(opp[1]==7)
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==9)
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==1)
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==3)
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==4)
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==6)
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
					
				}
				//if opp went 8 first turn
				if(opp[0]==8)
				{
					if(opp[1]==6)
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==4)
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==1)
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==3)
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==7)
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(opp[1]==9)
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=unusable[count];
						count++;
					}
				}
			}
			//fourth turn
			else if(count==6)
			{
				if(opp[0]==4 && opp[1]==9)
				{
					if(opp[2]==1)
					{
						webby.setFillAI(7);
						webby.repaint();
						unusable[count]=8;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{	
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==6 && opp[1]==7)
				{
					if(opp[2]==3)
					{
						webby.setFillAI(7);
						webby.repaint();
						unusable[count]=8;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==1 && opp[1]==6)
				{
					if(opp[2]==8)
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(7);
						webby.repaint();
						unusable[count]=8;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==3 && opp[1]==4)
				{
					if(opp[2]==8)
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(7);
						webby.repaint();
						unusable[count]=8;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==5 && opp[1]==7)
				{
					if(opp[2]==1)
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==5 && opp[1]==9)
				{
					if(opp[2]==3)
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==5 && opp[1]==1)
				{
					if(opp[2]==7)
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==5 && opp[1]==3)
				{
					if(opp[2]==9)
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==5 && opp[1]==4)
				{
					if(opp[2]==3)
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==5 && opp[1]==6)
				{
					if(opp[2]==1)
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==7 && opp[1]==1)
				{
					if(opp[2]==8)
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==9 && opp[1]==3)
				{
					if(opp[2]==8)
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(7);
						webby.repaint();
						unusable[count]=8;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				else if(opp[0]==8&&opp[1]==9)
				{
					if(opp[2]==3)
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
					
				}
				else if(opp[0]==8&&opp[1]==7)
				{
					if(opp[2]==6)
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
				}
			}
			else if(count==8)
			{
				if(opp[0]==8&&opp[1]==7&&opp[2]==1)
				{
					if(opp[3]==6)
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
				}
				if(opp[0]==8&&opp[1]==9&&opp[2]==3)
				{
					if(opp[3]==4)
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
					else
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
				}
			}
		}
		else if(!first)
		{
			if(count==1)
			{
				if(opp[0]!=2)
				{
					webby.setFillAI(1);
					webby.repaint();
					unusable[count]=2;
					ai[count/2]=unusable[count];
					count++;
				}
				else
				{
					webby.setFillAI(7);
					webby.repaint();
					unusable[count]=8;
					ai[count/2]=unusable[count];
					count++;
				}
			}
			else if(count==3)
			{
				bestmove=0;
				oneAway();
				if(bestmove!=0)
				{
					webby.setFillAI(bestmove-1);
					webby.repaint();
					unusable[count]=bestmove;
					ai[count/2]=unusable[count];
					count++;
				}
				else if (checkAvailable(5))
				{
					webby.setFillAI(4);
					webby.repaint();
					unusable[count]=5;
					ai[count/2]=unusable[count];
					count++;
				}
				else if (checkAvailable(3))
				{
					webby.setFillAI(2);
					webby.repaint();
					unusable[count]=3;
					ai[count/2]=unusable[count];
					count++;
				}
				else if(checkAvailable(1))
				{
					webby.setFillAI(0);
					webby.repaint();
					unusable[count]=1;
					ai[count/2]=unusable[count];
					count++;
				}
			}
			else if(count==5)
			{
				bestWinmove=0;
				bestmove=0;
				checkClose();
				oneAway();
				if(bestWinmove!=0)
				{
					System.out.println(bestWinmove);
					webby.setFillAI(bestWinmove-1);
					webby.repaint();
					unusable[count]=bestWinmove;
					ai[count/2]=unusable[count];
					count++;
					for(int i=0;i<=count/2; i++)
						System.out.println(ai[i]);
					winCheck(count);
				}
				else if(bestmove!=0)
				{
					webby.setFillAI(bestmove-1);
					webby.repaint();
					unusable[count]=bestmove;
					ai[count/2]=unusable[count];
					count++;
				}
				else
				{
					if(ai[0]==2)
					{
						if(checkAvailable(8))
						{
							webby.setFillAI(7);
							webby.repaint();
							unusable[count]=8;
							ai[count/2]=unusable[count];
							count++;
						}
					}
					else if(checkAvailable(2))
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(5))
					{
						webby.setFillAI(4);
						webby.repaint();
						unusable[count]=5;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(checkAvailable(6))
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(checkAvailable(4))
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(9))
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(7))
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(1))
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(3))
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
				}
					
			}
			else if(count==7)
			{
				checkClose();
				oneAway();
				if(bestWinmove!=0)
				{
					webby.setFillAI(bestWinmove-1);
					webby.repaint();
					unusable[count]=bestWinmove;
					ai[count/2]=unusable[count];
					count++;
					winCheck(count);
				}
				else if(bestmove!=0)
				{
					webby.setFillAI(bestmove-1);
					webby.repaint();
					unusable[count]=bestmove;
					ai[count/2]=unusable[count];
					count++;
				}
				else
				{
					if(ai[0]==2)
					{
						if(checkAvailable(8))
						{
							webby.setFillAI(7);
							webby.repaint();
							unusable[count]=8;
							ai[count/2]=unusable[count];
							count++;
						}
					}
					else if(checkAvailable(2))
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(5))
					{
						webby.setFillAI(4);
						webby.repaint();
						unusable[count]=5;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(checkAvailable(6))
					{
						webby.setFillAI(5);
						webby.repaint();
						unusable[count]=6;
						ai[count/2]=unusable[count];
						count++;
					}
					else if(checkAvailable(4))
					{
						webby.setFillAI(3);
						webby.repaint();
						unusable[count]=4;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(9))
					{
						webby.setFillAI(8);
						webby.repaint();
						unusable[count]=9;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(7))
					{
						webby.setFillAI(6);
						webby.repaint();
						unusable[count]=7;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(1))
					{
						webby.setFillAI(0);
						webby.repaint();
						unusable[count]=1;
						ai[count/2]=unusable[count];
						count++;
					}
					else if (checkAvailable(3))
					{
						webby.setFillAI(2);
						webby.repaint();
						unusable[count]=3;
						ai[count/2]=unusable[count];
						count++;
					}
				}
			}
			
		}
		webby.repaint();
		winCheck(count);
	}
	
	//checks to see if the opp is about to win, and sets an int to the spot where they will winn
	public void oneAway()
	{
		bestmove=0;
		for(int i=0; i<opp.length; i++)
		{
			for(int j=0; j<opp.length; j++)
			{
				//123
				if (opp[i]==1 && opp[j]==3 && checkAvailable(2))
					bestmove=2;
				if (opp[i]==1 && opp[j]==2 && checkAvailable(3))
					bestmove=3;
				if (opp[i]==2 && opp[j]==3 && checkAvailable(1))
					bestmove=1;
				//147
				if(opp[i]==1 && opp[j]==4 && checkAvailable(8))
					bestmove=8;
				if(opp[i]==1 && opp[j]==8 && checkAvailable(4))
					bestmove=4;
				if(opp[i]==4 && opp[j]==8 && checkAvailable(1))
					bestmove=1;
				//195
				if(opp[i]==1 && opp[j]==9 && checkAvailable(5))
					bestmove=5;
				if(opp[i]==1 && opp[j]==5 && checkAvailable(9))
					bestmove=9;
				if(opp[i]==9&&opp[j]==5&&checkAvailable(1))
					bestmove=1;
				//274
				if(opp[i]==2 && opp[j]==7 && checkAvailable(4))
					bestmove=4;
				if(opp[i]==2 && opp[j]==4 && checkAvailable(7))
					bestmove=7;
				if(opp[i]==4 && opp[j]==7 && checkAvailable(2))
					bestmove=2;
				
				//269
				if(opp[i]==2 && opp[j]==6 && checkAvailable(9))
					bestmove=9;
				if(opp[i]==2 && opp[j]==9 && checkAvailable(6))
					bestmove=6;
				if(opp[i]==9 && opp[j]==6 && checkAvailable(2))
					bestmove=2;
				//357
				if(opp[i]==3 && opp[j]==5 && checkAvailable(7))
					bestmove=7;
				if(opp[i]==3 && opp[j]==7 && checkAvailable(5))
					bestmove=5;
				if(opp[i]==5 && opp[j]==7 && checkAvailable(3))
					bestmove=3;
				
				//368
				if(opp[i]==3 && opp[j]==6 && checkAvailable(8))
					bestmove=8;
				if(opp[i]==3 && opp[j]==8 && checkAvailable(6))
					bestmove=6;
				if(opp[i]==6 && opp[j]==8 && checkAvailable(3))
					bestmove=3;
				
				//456
				if(opp[i]==4 && opp[j]==6 && checkAvailable(5))
					bestmove=5;
				if(opp[i]==5 && opp[j]==6 && checkAvailable(4))
					bestmove=4;
				if(opp[i]==4 && opp[j]==5 && checkAvailable(6))
					bestmove=6;
				
				//789
				if(opp[i]==7 && opp[j]==9 && checkAvailable(8))
					bestmove=8;
				if(opp[i]==7 && opp[j]==8 && checkAvailable(9))
					bestmove=9;
				if(opp[i]==9 && opp[j]==8 && checkAvailable(7))
					bestmove=7;
			}
		}
	}
	
	public void checkClose()
	{
		bestWinmove=0;
		for(int i=0; i<ai.length; i++)
		{
			for(int j=0; j<ai.length; j++)
			{
				//123
				if (ai[i]==1 && ai[j]==3 && checkAvailable(2))
					bestWinmove=2;
				if (ai[i]==1 && ai[j]==2 && checkAvailable(3))
					bestWinmove=3;
				if (ai[i]==2 && ai[j]==3 && checkAvailable(1))
					bestWinmove=1;
				//148
				if(ai[i]==1 && ai[j]==4 && checkAvailable(8))
					bestWinmove=8;
				if(ai[i]==1 && ai[j]==8 && checkAvailable(4))
					bestWinmove=4;
				if(ai[i]==4 && ai[j]==7 && checkAvailable(1))
					bestWinmove=1;
				//195
				if(ai[i]==1 && ai[j]==9 && checkAvailable(5))
					bestWinmove=5;
				if(ai[i]==1 && ai[j]==5 && checkAvailable(9))
					bestWinmove=9;
				if(ai[i]==9&&ai[j]==5&&checkAvailable(1))
					bestWinmove=1;
				//274
				if(ai[i]==2 && ai[j]==7 && checkAvailable(4))
					bestWinmove=4;
				if(ai[i]==2 && ai[j]==4 && checkAvailable(7))
					bestWinmove=7;
				if(ai[i]==4 && ai[j]==7 && checkAvailable(2))
					bestWinmove=2;
				
				//269
				if(ai[i]==2 && ai[j]==6 && checkAvailable(9))
					bestWinmove=9;
				if(ai[i]==2 && ai[j]==9 && checkAvailable(6))
					bestWinmove=6;
				if(ai[i]==9 && ai[j]==6 && checkAvailable(2))
					bestWinmove=2;
				//357
				if(ai[i]==3 && ai[j]==5 && checkAvailable(7))
					bestWinmove=7;
				if(ai[i]==3 && ai[j]==7 && checkAvailable(5))
					bestWinmove=5;
				if(ai[i]==5 && ai[j]==7 && checkAvailable(3))
					bestWinmove=3;
				
				//368
				if(ai[i]==3 && ai[j]==6 && checkAvailable(8))
					bestWinmove=8;
				if(ai[i]==3 && ai[j]==8 && checkAvailable(6))
					bestWinmove=6;
				if(ai[i]==6 && ai[j]==8 && checkAvailable(3))
					bestWinmove=3;
				
				//456
				if(ai[i]==4 && ai[j]==6 && checkAvailable(5))
					bestWinmove=5;
				if(ai[i]==5 && ai[j]==6 && checkAvailable(4))
					bestWinmove=4;
				if(ai[i]==4 && ai[j]==5 && checkAvailable(6))
					bestWinmove=6;
				
				//789
				if(ai[i]==7 && ai[j]==9 && checkAvailable(8))
					bestWinmove=8;
				if(ai[i]==7 && ai[j]==8 && checkAvailable(9))
					bestWinmove=9;
				if(ai[i]==9 && ai[j]==8 && checkAvailable(7))
					bestWinmove=7;
			}
		}
		
	}
	
	//Checks if Either player has a winning combination
	public void winCheck(int x)
	{
		//This long search finds if any winning combination is present
		//Also, every value is lowered one because of how I set it up
		if(x>=4)
		{
			for(int i=0; i<ai.length; i++)
			{
				for (int j=0; j<ai.length; j++)
				{	
					for(int k=0; k<ai.length; k++)
					{
						//Searches all winning combinations when the AI has circle 1
						if(ai[i]==1)
						{
							if((ai[j]==2 && ai[k]==3) | (ai[j]==3 && ai[k]==2) | (ai[j]==4 && ai[k]==8) | (ai[j]==8&&ai[k]==4) | (ai[j]==5&&ai[k]==9) | (ai[j]==9&&ai[k]==5) )
							{
								webby.repaint();
								aiWin();
							}
						}
					//Searches all unsearched winnig combinations when the AI has 2
						if(ai[i]==2)
						{
							if((ai[j]==4&&ai[k]==7) | (ai[j]==7&&ai[k]==4) | (ai[j]==6 && ai[k]==9) | (ai[j]==9 && ai[k]==6))
							{
								webby.repaint();
								aiWin();
							}
						}
						if(ai[i]==3)
						{
							if((ai[j]==5 && ai[k]==7)|(ai[j]==7&&ai[k]==5)|(ai[j]==6&&ai[k]==8)|(ai[j]==8&&ai[k]==6))
							{
								webby.repaint();
								aiWin();
							}
						}
						if(ai[i]==4)
						{
							if((ai[j]==5 && ai[k]==6)|(ai[j]==6&&ai[k]==5))
							{
								webby.repaint();
								aiWin();
							}
						}
						if(ai[i]==7)
						{
							if((ai[j]==8 && ai[k]==9)|(ai[j]==9&&ai[k]==8))
							{
								webby.repaint();
								aiWin();
							}
						}
						if(ai[i]==8)
						{
							if((ai[j]==7 && ai[k]==9)|(ai[j]==9&&ai[k]==7))
							{
								webby.repaint();
								aiWin();
							}
						}
					}
				}
			}
			for(int i=0; i<opp.length; i++)
			{
				for (int j=0; j<opp.length; j++)
				{	
					for(int k=0; k<opp.length; k++)
					{
						//Searches all winning combinations when the opp has circle 1
						if(opp[i]==1)
						{
							if((opp[j]==2 && opp[k]==3) | (opp[j]==3 && opp[k]==2) | (opp[j]==4 && opp[k]==8) | (opp[j]==8&&opp[k]==4) | (opp[j]==5&&opp[k]==9) | (opp[j]==9&&opp[k]==5) )
							{
								webby.repaint();
								oppWin();
							}
						}
						//Searches all unsearched winnig combinations when the opp has 2
						if(opp[i]==2)
						{
							if((opp[j]==4&&opp[k]==7) | (opp[j]==7&&opp[k]==4) | (opp[j]==6 && opp[k]==9) | (opp[j]==9 && opp[k]==6))
							{
								webby.repaint();
								oppWin();
							}
						}
						if(opp[i]==3)
						{
							if((opp[j]==5 && opp[k]==7)|(opp[j]==7&&opp[k]==5)|(opp[j]==6&&opp[k]==8)|(opp[j]==8&&opp[k]==6))
							{
								webby.repaint();
								oppWin();
							}
						}
						if(opp[i]==4)
						{
							if((opp[j]==5 && opp[k]==6)|(opp[j]==6&&opp[k]==5))
							{
								webby.repaint();
								oppWin();
							}
						}
						if(opp[i]==7)
						{
							if((opp[j]==8 && opp[k]==9)|(opp[j]==9&&opp[k]==8))
							{	
								webby.repaint();
								oppWin();
							}
					}
				}
			}
		}
		if(count>=9)
		{
			System.out.println("It's a draw?!? You've survived the Fibonacci Sequence, but only by a couple terms");
			System.out.println("The AI had circles: ");
			for(int i=0; i<ai.length; i++)
			{
				if(ai[i]!=-1)
				{
					System.out.print(ai[i] + "  ");
				}
			}
			System.out.println("\n You had circles: ");
			for(int i=0; i<opp.length; i++)
			{
				if(opp[i]!=-1)
				{
					System.out.print(opp[i] + "  ");
				}
			}
			System.out.println("\n Would you like to play again?");
			Scanner cin = new Scanner(System.in);
			cont = cin.next();
			if(cont.equals("No")|cont.equals("no"))
			{
				System.out.println("You have chosen to quit the program. 1+1+2+3+5+8...");
				System.exit(0);
			}

			else if(cont.equals("Yes") | cont.equals("yes"))
			{
				System.out.println("You have chosen to feel the wrath of the fibonacci sequence once more.");
				count=0;
				for(int i=0; i<ai.length; i++)
				{
					ai[i]=-1;
					opp[i]=-1;
				}
				for(int i =0; i<unusable.length;i++)
				{
					unusable[i]=-1;
				}
				startGame();
			}
			
		}
	}
	}
		
	public void aiWin()
	{
		System.out.println("And the Fibonacci Sequence Prevails Again!");
		System.out.println("The AI won with the combination of: ");
		for(int i=0; i<ai.length; i++)
		{
			if(ai[i]!=-1)
			{
				System.out.print(ai[i] + "  ");
			}
		}
		System.out.println("\n Would you like to play again?");
		Scanner cin = new Scanner(System.in);
		cont = cin.next();
		if(cont.equals("No")|cont.equals("no"))
		{
			System.out.println("You have chosen to quit the program. 1+1+2+3+5+8...");
			System.exit(0);
		}
		else if(cont.equals("Yes") | cont.equals("yes"))
		{
			System.out.println("You have chosen to feel the wrath of the fibonacci sequence once more.");
			count=0;
			for(int i=0; i<ai.length; i++)
			{
				ai[i]=-1;
				opp[i]=-1;
			}
			for(int i =0; i<unusable.length;i++)
			{
				unusable[i]=-1;
			}
			startGame();
		}
	}
	public void oppWin()
	{
		System.out.println("Congratulations! You've defeated the fibonacci sequence!");
		System.out.println("You won with the combination of: ");
		for(int i=0; i<opp.length; i++)
		{
			if(opp[i]!=-1)
			{
				System.out.print(opp[i] + "  ");
			}
		}
		System.out.println("\n Would you like to play again?");
		Scanner cin = new Scanner(System.in);
		cont = cin.next();
		if(cont.equals("No")|cont.equals("no"))
		{
			System.out.println("You have chosen to quit the program. 1+1+2+3+5+8...");
			System.exit(0);
		}
		else if(cont.equals("Yes") | cont.equals("yes"))
		{
			System.out.println("You have chosen to feel the wrath of the fibonacci sequence once more.");
			count=0;
			for(int i=0; i<ai.length; i++)
			{
				ai[i]=-1;
				opp[i]=-1;
			}
			for(int i =0; i<unusable.length;i++)
			{
				unusable[i]=-1;
			}
			startGame();
		}
		
	}
	public boolean checkAvailable(int x)
	{
		boolean available = false;
		for(int i=0; i<=count; i++)
		{
			if(x==unusable[i])
			{
				available=false;
				return available;
			}
			else
				available=true;
		}
		return available;
	}
	
	public void startGame()
	{
		for(int i=0; i<ai.length; i++)
		{
			ai[i]=-1;
			opp[i]=-1;
		}
		for(int i =0; i<unusable.length;i++)
		{
			unusable[i]=-1;
		}
		webby.clear();
		
		System.out.println("Would you like to go First or Second?");
		Scanner cin = new Scanner(System.in);
		String move = cin.next();
		
		if(move.equals("First") | move.equals("first"))
		{
			System.out.println("Ok! You'll be going first! Good luck sucker!");
			playSecond();
		}
		else if(move.equals("Second")| move.equals("second"))
		{
			System.out.println("Ok! You'll be going second! Good luck bozo!");
			playFirst();
		}
	}
	
	public void playGame()
	{
		startGame();
	}
	
	public static void main(String[] args)
	{
		JTTGui gamer=new JTTGui();
		System.out.println("Welcome to Jerry-Tac-Toe: Fibonacci edition!");
		System.out.println("You will be using the green tokens, whereas the AI will use gold tokens!");
		gamer.playGame();
	}
}