import java.util.*;
import java.io.*;

class HuntWump
{
	public static void main(String[] args) throws IOException
	{
		WumpRoom current = new WumpRoom();
		Scanner g;
		g=new Scanner(new FileReader("WumpusText.txt"));

		int rnumber = g.nextInt();
		int[] rooms = new int [rnumber];
		int[] roomsleft = new int [rnumber];
		int[] roomsstraight = new int [rnumber];
		int[] roomsright = new int [rnumber];
		String[] descriptions = new String[rnumber];
		
		int room=0;
		int rleft=0;
		int rstraight=0;
		int rright=0;
		
		while(g.hasNext())
		{
			String roominfo;
			if(g.hasNextInt())
			{
				room=g.nextInt();
				rleft=g.nextInt();
				rstraight=g.nextInt();
				rright=g.nextInt();
				current.roomLayout(rooms, roomsleft, roomsstraight, roomsright, room, rleft, rstraight, rright);
			}
			roominfo = g.nextLine();
			current.storeDesc(descriptions, roominfo, room);
			
		}
		
		String[] desc_next = new String[rnumber];
		for(int i = 0; i<desc_next.length; i++)
		{
			desc_next[i] = " ";
		}
		
		Random randi = new Random();
		int wily_wookie1 = randi.nextInt(rnumber-1)+1;
		int wily_wookie2 = randi.nextInt(rnumber-1)+1;
		int belligerent_blurrg1= randi.nextInt(rnumber-1)+1;
		int belligerent_blurrg2 = randi.nextInt(rnumber-1)+1;
		int babyyoda = randi.nextInt(rnumber-1)+1;
		int charged_plasma = randi.nextInt(rnumber-1)+1;
		int bogwing = randi.nextInt(rnumber-1)+1;
		
		while(babyyoda==1)
		{
			babyyoda = randi.nextInt(rnumber-1)+1;
		}	
		while(wily_wookie1==babyyoda | wily_wookie1 == 1)
		{
			wily_wookie1 = randi.nextInt(rnumber-1)+1;
		}
		while(wily_wookie2==babyyoda | wily_wookie2==wily_wookie1 | wily_wookie2 == 1)
		{
			wily_wookie2 = randi.nextInt(rnumber-1)+1;
		}
		while(belligerent_blurrg1==babyyoda | belligerent_blurrg1==wily_wookie1 | belligerent_blurrg1==wily_wookie2 | belligerent_blurrg1== 1)
		{
			belligerent_blurrg1 = randi.nextInt(rnumber-1)+1;
		}
		while(belligerent_blurrg2==babyyoda | belligerent_blurrg2==wily_wookie1 | belligerent_blurrg2 == wily_wookie2 | belligerent_blurrg2==belligerent_blurrg1| belligerent_blurrg2 == 1)
		{
			belligerent_blurrg2 = randi.nextInt(rnumber-1)+1;
		}
		while(charged_plasma==babyyoda | charged_plasma==wily_wookie1 | charged_plasma==wily_wookie2 | charged_plasma==belligerent_blurrg1| charged_plasma==belligerent_blurrg2 | charged_plasma ==1)
		{
			charged_plasma = randi.nextInt(rnumber-1)+1;
		}
		while(bogwing==babyyoda | bogwing==wily_wookie1 | bogwing == wily_wookie2 | bogwing == belligerent_blurrg1 | bogwing == belligerent_blurrg2 | bogwing == charged_plasma | bogwing==1)
		{
			bogwing = randi.nextInt(rnumber-1)+1;
		}
		
		
		System.out.println(babyyoda + " " + wily_wookie1 + " " + wily_wookie2 + " " + belligerent_blurrg1+ " " + belligerent_blurrg2 + " " + charged_plasma + " " + bogwing);
		
		babyyoda=rooms[babyyoda];
		wily_wookie1=rooms[wily_wookie1];
		wily_wookie2=rooms[wily_wookie2];
		belligerent_blurrg1=rooms[belligerent_blurrg1];
		belligerent_blurrg2=rooms[belligerent_blurrg2];
		charged_plasma=rooms[charged_plasma];
		bogwing=rooms[bogwing];
		
		System.out.println(babyyoda + " " + wily_wookie1 + " " + wily_wookie2 + " " + belligerent_blurrg1+ " " + belligerent_blurrg2 + " " + charged_plasma + " " + bogwing);
		
		current.storeDescNext(desc_next, "\nYou feel a strong source of the force around you! ", babyyoda-1);
		current.storeDescNext(desc_next, "\nYou hear some loud stomping nearby ", belligerent_blurrg1-1);
		current.storeDescNext(desc_next, "\nYou hear some loud stomping nearby ", belligerent_blurrg2-1);
		current.storeDescNext(desc_next, "\nYou smell something like a wet dog nearby ", wily_wookie1-1);
		current.storeDescNext(desc_next, "\nYou smell something like a wet dog nearby ", wily_wookie2-1);
		
		
		char wumpus='a';
		char alive='a';
		int arrowcount=3;
		room=1;
		
		Scanner cin = new Scanner(System.in);
		System.out.println("A long time ago, in a galaxy far, far away ");
		System.out.println("You are a bounty hunter, sent by a client representing the empire to find an unnamed target on the barren planet of Nevarro");
		System.out.println("You know that a droid, IB 88, has had a head start on you in the chase. You can only assume that he has found baby yoda before you");
		System.out.println("However, you do not let that deter you. You will stop at nothing to earn the reward for this bounty");
		System.out.println("");
		System.out.println("Welcome to.......\n \n **FIND THE BABY YODA** \n");
		
		System.out.println("");
		
		while(wumpus=='a')
		{
			int moveto=0;
			int shootto=0;
			System.out.println("You are in room " + room);
			System.out.println("You have " + arrowcount + " shots left");
			System.out.println("There are tunnels connecting to rooms " + roomsleft[room-1] + ", " + roomsstraight[room-1] +" and "+ roomsright[room-1]);
			System.out.print(descriptions[room-1]);
			System.out.println(desc_next[roomsleft[room-1]-1] + " " + desc_next[roomsstraight[room-1]-1] + " " + desc_next[roomsright[room-1]-1]);
			System.out.println("Would you like to (M)ove or (S)hoot?");
			char entry = cin.next().charAt(0);
			if(entry == 'm' | entry == 'M')
			{
				System.out.println("What room would you like to move to?");
				moveto = cin.nextInt();
				if(moveto == roomsleft[room-1] | moveto == roomsstraight[room-1] | moveto == roomsright[room-1])
					room=moveto;
				else
				{
					System.out.println("Doofus! You can't move there!");
				}
				
			}
			else if(entry == 's' | entry =='S')
			{
				if(arrowcount==0)
				{
					System.out.println("You don't have any more plasma charges in your rifle! Find some charged plasma cannnisters to recharge your rifle! ");
				}
				System.out.println("Which room would you like to shoot into?");
				shootto = cin.nextInt();
				if(shootto == roomsleft[room-1] | shootto == roomsstraight[room-1] | shootto == roomsright[room-1] && arrowcount != 0)
				{
					arrowcount--;
				}
				else
				{
					System.out.println("Dummy boi! You can't shoot there!");
					break;
				}
			}
			else
				System.out.println("Invalid command! Please enter a new command");
			
			if(moveto==babyyoda)
			{
				System.out.println("The IG 88 has shot you! You slowly bleed out as he scampers off with baby yoda!!");
				System.out.println("Congratulations! You lose!");
				break;
			}
			else if(moveto==wily_wookie1 | moveto==wily_wookie2)
			{
				System.out.println("A wookie grabs you by the head and tosses you against the wall. Your spine breaks and you are paralyzed! ");
				System.out.println("Congratulations! You lose!");
				break;
			}
			else if(moveto==belligerent_blurrg1| moveto==belligerent_blurrg2)
			{
				System.out.println("A blurrg swallows you whole! Kuill can't save you this time! ");
				System.out.println("Congratulations! You lose!");
				break;
			}
			else if(moveto==charged_plasma)
			{
				System.out.println("You enter a room full of plasma canisters! You reload your rifle and resume the hunt ");
				arrowcount = 3;
			}
			else if(moveto==bogwing)
			{
				int newroom = 0;
				newroom = randi.nextInt(rnumber-1)+1;
				while(newroom==bogwing)
					newroom = randi.nextInt(rnumber-1)+1;
				System.out.println("You walk into a room with a giant bogwing! It scoops you up and drops you into room: " + newroom);
				if(newroom == wily_wookie1 | newroom == wily_wookie2)
				{
					System.out.println("A wookie grabs you by the head and tosses you against the wall. Your spine breaks and you are paralyzed! ");
					System.out.println("Congratulations! You lose!");
					break;
				}
				else if(newroom == belligerent_blurrg1 | newroom == belligerent_blurrg2)
				{
					System.out.println("A blurrg swallows you whole! Kuill can't save you this time! ");
					System.out.println("Congratulations! You lose!");
					break;
				}
				else if(newroom == babyyoda)
				{
					System.out.println("The IG 88 has shot you! You slowly bleed out as he scampers off with baby yoda!!");
					System.out.println("Congratulations! You lose!");
					break;
				}
				else if(newroom == charged_plasma)
				{
					System.out.println("You enter a room full of plasma canisters! You reload your rifle and resume the hunt ");
					arrowcount = 3;
				}
				room = newroom;
			}
			
			if(shootto==babyyoda && arrowcount!=0)
			{
				System.out.println("You shoot the IB 88 through his motherboard with your rifle! He slumps to the ground");
				System.out.println("Baby Yoda is now yours for the taking! ");
				System.out.println("Congratulations, you won! You have the fate of the world in your hands... ");
				wumpus = 'd';
			}
			else if(shootto!=0 && arrowcount!=0)
			{
				System.out.println("You hear your shoot fizz into the wall, missing any potential targets");
			}
			System.out.println("");
			
		}
		
		/*
		for(int i=0; i<rooms.length-1; i++)
		{
			System.out.println(rooms[i] + " " + roomsleft[i] + " " + roomsstraight[i] + " " + roomsright[i]);
			System.out.println(descriptions[i]);
		}
		*/
	}
}