import java.util.*;
import java.io.*;

class Posanivee extends BST
{
	public static void main(String[] args) throws IOException
	{
		Scanner g;
		g=new Scanner(new FileReader("camp.txt"));
		
		BST camp = new BST();
		
		while(g.hasNext())
		{
			char command = g.next().charAt(0);
			if(command=='H' | command=='h' )
			{
				System.out.println("Command - H");
				System.out.println("Here's a list of Commands:");
				System.out.println("E: Enroll");
				System.out.println("W: Withdraw");
				System.out.println("D: Display");
				System.out.println("A: Print Average Age");
				System.out.println("L : List all campers in Alphabetical Order");
				System.out.println("V: Print the number of Vegan Campers");
				System.out.println("P: List all campers names in preorder");
				System.out.println("Q: Quit the program");
			}
			else if (command=='Q' | command=='q')
			{
				System.out.println("Command - Q");
				System.out.println("Quitting the program! Hope you bring a lotta calomine!");
				System.exit(0);
			}
			else if (command=='E' | command=='e')
			{
				System.out.println("Command - E");
				camper temp = new camper(g);
				camp.insert(temp);
				System.out.println("New camper added");
			}
			else if (command=='W' | command=='w')
			{
				System.out.println("Command - W");
				String withdraw = g.next();
				camp.reset(INORDER);
				while(camp.hasNext())
				{
					camper withdraw_hold = (camper)camp.getNext();
					String withdraw_name = withdraw_hold.getName();
					if(withdraw_name.equals(withdraw))
					{
						camp.delete(withdraw_hold);
						System.out.println("This camper has been withdrawn: " + withdraw_hold.getName());
						break;
					}
				}
				
			}
			else if(command=='D' | command=='d')
			{
				System.out.println("Command - D");
				String display_name = g.next();
				camp.reset(INORDER);
				while(camp.hasNext())
				{
					camper disp_hold = (camper)camp.getNext();
					String name_hold = (String) disp_hold.getName();
					if(name_hold.equals(display_name))
					{
						System.out.println("\tName: "+ disp_hold.getName() + "\n\tAge: "+ disp_hold.getAge() + "\n\tDiet: " + disp_hold.getDiet());
					}             
				}
			}
			else if (command=='A' | command=='a')
			{
				System.out.println("Command - A");
				double avg_age = 0;
				camp.reset(INORDER);
				if(camp.size()==0)
				{
					System.out.println("There aren't any campers enrolled!");
				}
				else
				{
					while(camp.hasNext())
					{
						camper age_hold = (camper)camp.getNext();
						int age = age_hold.getAge();
						System.out.println(age);
						avg_age+=age;
					}	
					avg_age= avg_age/camp.size();
					System.out.println("The Average age of campers is: " + avg_age);					
				}	
			}
			else if(command=='L' | command=='l')
			{
				System.out.println("Command - L");
				System.out.println("These are the campers currently enrolled (Alphabetical Order): ");
				camp.reset(BST.INORDER);
				while(camp.hasNext())
				{
					System.out.println("" + ((camper)camp.getNext()).getName());
				}
			}
			else if(command=='V' | command=='v')
			{
				System.out.println("Command - V");
				int countVegan = 0;
				camp.reset(INORDER);
				while(camp.hasNext())
				{
					camper vegan_hold = (camper)camp.getNext();
					char eat = vegan_hold.getDiet();
					if(eat=='V')
					{
						countVegan++;
					}
				}
				System.out.println("The number of Vegan campers is: " + countVegan);
			}
			else if(command=='P' | command=='p')
			{
				System.out.println("Command - P");
				System.out.println("These are the campers currently enrolled (Preorder Order): ");
				camp.reset(BST.PREORDER);
				while(camp.hasNext())
				{
					System.out.println("" + ((camper)camp.getNext()).getName());
				}
			}
			else
				System.out.println("The program has read an invalid command");
		}
		
	}
	
}