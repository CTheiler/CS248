import java.util.*;

public class WumpRoom
{
	public void roomLayout(int[] rooms, int[]roomsleft, int[]roomsstraight, int[]roomsright,int room,int rl,int rs,int rr)
	{
		int temp = room;
		temp--;
		rooms[temp]=room;
		roomsleft[temp]=rl;
		roomsright[temp]=rr;
		roomsstraight[temp]=rs;
		
	}
	
	public void storeDesc(String[] descriptions, String line, int room)
	{
		int temp = room;
		temp--;
		descriptions[temp]=line;
	}
	
	public void storeDescNext(String[] ndesc, String line, int room)
	{	
		ndesc[room]=line;
	}
}