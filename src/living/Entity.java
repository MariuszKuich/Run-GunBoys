package living;

import logic.*;
import resting.*;

public class Entity 
{
	private char name;
	private int r;
	private int c;
	private int hp;
	private int ammo;
	private int bricks;
	
	public Entity(char n)
	{
		name = n;
		hp = 3;
		ammo = 5;
		bricks = 1;
	}
	public char getName()
	{
		return name;
	}
	public int getR()
	{
		return r;
	}
	public int getC()
	{
		return c;
	}
	public int getHP()
	{
		return hp;
	}
	public int getAmmo()
	{
		return ammo;
	}
	public int getBricks()
	{
		return bricks;
	}
	public void addLife()
	{
		hp++;
	}
	public void subLife()
	{
		hp--;
	}
	public void addAmmo()
	{
		ammo++;
	}
	public boolean setCoords(Field f, int nr, int nc)
	{
		if(f.setField(this, nr, nc))
		{
			r = nr;
			c = nc;
			return true;
		}
		else return false;
	}
	public boolean setStartCoords(Field f, int r, int c)
	{
		if(f.setStartField(r, c, name))
		{
			this.r = r;
			this.c = c;
			return true;
		}
		else return false;
	}
	public void action(char t, char d, Field f, Entity enemy)
	{
		t = Character.toLowerCase(t);
		d = Character.toLowerCase(d);
		int a;
		switch(t)
		{
		case 'm':
			move(d, f, a = 1);
			break;
		case 'r':
			move(d, f, a = 2);
			break;
		case 's':
			shoot(d, f, enemy);
			break;
		case 'b':
			brick(d, f);
			break;
		default: 
			System.out.println("Incorrect action type, turn lost.");
		}
	}
	private void move(char d, Field f, int a)
	{
		switch(d)
		{
		case 'w':
			if(setCoords(f, r-a, c))
			{
				System.out.println("Player " + getName() + " moved up (amount of fields: " + a + ").");
			}
			else
			{
				System.out.println("Player " + getName() + " is unable to move in that direction.");
			}
			break;
		case 'd':
			if(setCoords(f, r, c+a))
			{
				System.out.println("Player " + getName() + " moved right (amount of fields: " + a + ").");
			}
			else
			{
				System.out.println("Player " + getName() + " is unable to move in that direction.");
			}
			break;
		case 's':
			if(setCoords(f, r+a, c))
			{
				System.out.println("Player " + getName() + " moved down (amount of fields: " + a + ").");
			}
			else
			{
				System.out.println("Player " + getName() + " is unable to move in that direction.");
			}
			break;
		case 'a':
			if(setCoords(f, r, c-a))
			{
				System.out.println("Player " + getName() + " moved left (amount of fields: " + a + ").");
			}
			else
			{
				System.out.println("Player " + getName() + " is unable to move in that direction.");
			}
			break;
			default:
			System.out.println("Incorrect direction, turn lost.");
		}
	}
	private void shoot(char d, Field f, Entity enemy)
	{
		if(ammo > 0)
		{
			char b;
			
			if(d == 'w' || d == 's')
			{
				b = '|';
			}
			else b = '-';
			
			new Bullet(b, d).follow(f, this, enemy);
			
			ammo--;
		}
		else System.out.println("Player " + getName() + " cannot shoot - he has got no bullets!");
	}
	private void brick(char d, Field f)
	{
		if(bricks > 0)
		{
			switch(d)
			{
			case 'w':
				if(!f.edgeOrBounds(r-1, c) && !f.isAmmo(r-1, c) && !f.isLife(r-1, c))
				{
					f.setBrick(r-1, c);
					System.out.println("Player " + getName() + " successfully set a brick.");
				}
				else System.out.println("Player " + getName() + " is unable to set a brick on that field.");
				break;
			case 'd':
				if(!f.edgeOrBounds(r, c+1) && !f.isAmmo(r, c+1) && !f.isLife(r, c+1))
				{
					f.setBrick(r, c+1);
					System.out.println("Player " + getName() + " successfully set a brick.");
				}
				else System.out.println("Player " + getName() + " is unable to set a brick on that field.");
				break;
			case 's':
				if(!f.edgeOrBounds(r+1, c) && !f.isAmmo(r+1, c) && !f.isLife(r+1, c))
				{
					f.setBrick(r+1, c);
					System.out.println("Player " + getName() + " successfully set a brick.");
				}
				else System.out.println("Player " + getName() + " is unable to set a brick on that field.");
				break;
			case 'a':
				if(!f.edgeOrBounds(r, c-1) && !f.isAmmo(r, c-1) && !f.isLife(r, c-1))
				{
					f.setBrick(r, c-1);
					System.out.println("Player " + getName() + " successfully set a brick.");
				}
				else System.out.println("Player " + getName() + " is unable to set a brick on that field.");
				break;
				default:
				System.out.println("Incorrect direction, turn lost.");
			}
			bricks --;
		}
		else System.out.println("Player " + getName() + " cannot set a brick - he has not got any!");
	}
}
