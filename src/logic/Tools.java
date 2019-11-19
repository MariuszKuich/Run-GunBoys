package logic;

import living.*;
import resting.*;

public class Tools 
{
	public static void cleanScreen()
	{
		try
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static int getRR()
	{
		return (int)(Math.random() * (Field.getA()-2) + 1);
	}
	public static int getRC()
	{
		return (int)(Math.random() * (Field.getB()-2) + 1);
	}
}
