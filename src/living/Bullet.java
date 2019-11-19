package living;

import logic.*;
import resting.*;

public class Bullet 
{
	private char name;
	private char direction;
	public Bullet(char n, char d)
	{
		name = n;
		direction = d;
	}
	public void follow(Field f, Entity player ,Entity enemy)
	{
		int r = player.getR();
		int c = player.getC();
		switch (direction)
		{
			case 'w':
				r--;	
				while(f.getSquare(r, c) == '\0')
				{
					f.setBullet(r, c, name);
					Tools.cleanScreen();
					System.out.println();
					System.out.println("~Run&GunBoys~\tv1.0.0\tbyMariuszek");
					f.getField();
					try 
					{
						Thread.sleep(50);
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					f.unsetField(r, c);
					r--;
				}
				if(f.getSquare(r, c) == '+' || f.getSquare(r, c) == '^')
				{
					f.unsetField(r, c);
					System.out.println("Bullet of player " + player.getName() + " hit a PowerUp and destroyed it.");
				}
				else if(f.getSquare(r, c) == '#')
				{
					System.out.println("Bullet of player " + player.getName() + " hit a wall and got destroyed.");
				}
				else if(f.getSquare(r, c) == enemy.getName())
				{
					enemy.subLife();
					System.out.println("Bullet of player " + player.getName() + " hit the opponent. Enemy's life decreased.");
				}
				break;
			case 'd':
				c++;
				while(f.getSquare(r, c) == '\0')
				{
					f.setBullet(r, c, name);
					Tools.cleanScreen();
					System.out.println();
					System.out.println("~Run&GunBoys~\tv1.0.0\tbyMariuszek");
					f.getField();
					try 
					{
						Thread.sleep(50);
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					f.unsetField(r, c);
					c++;
				}
				if(f.getSquare(r, c) == '+' || f.getSquare(r, c) == '^')
				{
					f.unsetField(r, c);
					System.out.println("Bullet of player " + player.getName() + " hit a PowerUp and destroyed it.");
				}
				else if(f.getSquare(r, c) == '#')
				{
					System.out.println("Bullet of player " + player.getName() + " hit a wall and got destroyed.");
				}
				else if(f.getSquare(r, c) == enemy.getName())
				{
					enemy.subLife();
					System.out.println("Bullet of player " + player.getName() + " hit the opponent. Enemy's life decreased.");
				}
				break;
			case 's':
				r++;
				while(f.getSquare(r, c) == '\0')
				{
					f.setBullet(r, c, name);
					Tools.cleanScreen();
					System.out.println();
					System.out.println("~Run&GunBoys~\tv1.0.0\tbyMariuszek");
					f.getField();
					try 
					{
						Thread.sleep(50);
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					f.unsetField(r, c);
					r++;
				}
				if(f.getSquare(r, c) == '+' || f.getSquare(r, c) == '^')
				{
					f.unsetField(r, c);
					System.out.println("Bullet of player " + player.getName() + " hit a PowerUp and destroyed it.");
				}
				else if(f.getSquare(r, c) == '#')
				{
					System.out.println("Bullet of player " + player.getName() + " hit a wall and got destroyed.");
				}
				else if(f.getSquare(r, c) == enemy.getName())
				{
					enemy.subLife();
					System.out.println("Bullet of player " + player.getName() + " hit the opponent. Enemy's life decreased.");
				}
				break;
			case 'a':
				c--;
				while(f.getSquare(r, c) == '\0')
				{
					f.setBullet(r, c, name);
					Tools.cleanScreen();
					System.out.println();
					System.out.println("~Run&GunBoys~\tv1.0.0\tbyMariuszek");
					f.getField();
					try 
					{
						Thread.sleep(50);
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					f.unsetField(r, c);
					c--;
				}
				if(f.getSquare(r, c) == '+' || f.getSquare(r, c) == '^')
				{
					f.unsetField(r, c);
					System.out.println("Bullet of player " + player.getName() + " hit a PowerUp and destroyed it.");
				}
				else if(f.getSquare(r, c) == '#')
				{
					System.out.println("Bullet of player " + player.getName() + " hit a wall and got destroyed.");
				}
				else if(f.getSquare(r, c) == enemy.getName())
				{
					enemy.subLife();
					System.out.println("Bullet of player " + player.getName() + " hit the opponent. Enemy's life decreased.");
				}
				break;
			default:
			System.out.println("Incorrect direction, turn lost.");
		}
	}
}
