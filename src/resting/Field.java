package resting;

import logic.*;
import living.*;

public class Field 
{
	private static int a = 20; //wiersze
	private static int b = 60; //kolumny
	private char[][] area = new char[a][b];
	private boolean[][] taken = new boolean[a][b];
	public Field()
	{
		for(int i = 0 ; i < a ; i++)
		{
			for(int j = 0 ; j < b ; j++)
			{
				if(edgeOrBounds(i, j))
				{
					area[i][j] = '#';
					taken[i][j] = true;
				}
				else 
				{
					area[i][j] = '\0'; 
					taken[i][j] = false;
				}
			}
		}
		int r, c;
		for(int i = 0 ; i <= 4 ; i++)
		{
			do
			{
				r = Tools.getRR();
				c = Tools.getRC();
			}
			while(taken[r][c] == true);
			area[r][c] = '+';
			taken[r][c] = false;
		}
		for(int i = 0 ; i <= 9 ; i++)
		{	
			do
			{
				r = Tools.getRR();
				c = Tools.getRC();
			}
			while(taken[r][c] == true);
			area[r][c] = '^';
			taken[r][c] = false;
		}
	}
	public boolean edgeOrBounds(int r, int c)
	{
		if(r <= 0 || r >= a-1 || c <=0 || c >= b-1 || taken[r][c]) return true;
		else return false;
	}
	public boolean isLife(int r, int c)
	{
		if(area[r][c] == '+') return true;
		else return false;
	}
	public boolean isAmmo(int r, int c)
	{
		if(area[r][c] == '^') return true;
		else return false;
	}
	public boolean isPlayer(int r, int c)
	{
		if(area[r][c] == '!' || area[r][c] == '?') return true;
		else return false;
	}
	public void getField()
	{
		for(int i = 0 ; i < a ; i++)
		{
			for(int j = 0 ; j < b ; j++)
			{
				System.out.print(area[i][j]);
			}
			System.out.println();
		}
	}
	public char getSquare(int r, int c)
	{
		return area[r][c];
	}
	public void unsetField(int r, int c)
	{
		area[r][c] = '\0';
		taken[r][c] = false;
	}
	public boolean setStartField(int r, int c, char n)
	{
		if(!taken[r][c])
		{
			area[r][c] = n;
			taken[r][c] = true;
			return true;
		}
		else return false;
	}
	public boolean setField(Entity e, int nr, int nc)
	{
		if(!edgeOrBounds(nr, nc))
		{
			if(isLife(nr, nc))
			{
				e.addLife();
				System.out.println("Player " + e.getName() + " obtained additional life point!");
			}
			else if(isAmmo(nr, nc))
			{
				e.addAmmo();
				System.out.println("Player " + e.getName() + " obtained additional ammo!");
			}
			area[e.getR()][e.getC()] = '\0';
			taken[e.getR()][e.getC()] = false;
			area[nr][nc] = e.getName();
			taken[nr][nc] = true;
			return true;
		}
		else return false;
	}
	public void setBrick(int nr, int nc)
	{
		area[nr][nc] = '#';
		taken[nr][nc] = true;
	}
	public void setBullet(int nr, int nc, char n)
	{
		area[nr][nc] = n;
	}
	public static int getA()
	{
		return a;
	}
	public static int getB()
	{
		return b;
	}
}
