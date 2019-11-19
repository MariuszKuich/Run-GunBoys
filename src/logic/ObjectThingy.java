package logic;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.FieldView;

import living.*;
import resting.*;

public class ObjectThingy 
{
	public static void main(String[] args)
	{		
		Field field = new Field();
		
		Entity first = new Entity('!');
		boolean t;
		do
		{
			t = first.setStartCoords(field, Tools.getRR(), Tools.getRC());
		}
		while(t == false);
		
		Entity second = new Entity('?');
		do
		{
			t = second.setStartCoords(field, Tools.getRR(), Tools.getRC());
		}
		while(t == false);
		
		boolean f_turn = true;
		while(first.getHP() > 0 || second.getHP() > 0)
		{
			Tools.cleanScreen();
			System.out.println();
			System.out.println("~Run&GunBoys~\tv1.0.0\tbyMariusz");
			field.getField();
			if(f_turn)
			{
				dialogue(first, second, field);
			}
			else dialogue(second, first, field);
			f_turn = !f_turn;
			if(first.getHP() == 0 || second.getHP() == 0)
			{
				System.out.println();
				if(first.getHP() == 0) System.out.println("Player ? won, congratulations!");
				else System.out.println("Player ! won, congratulations!");
				System.out.println();
				break;
			}
		}
	}
	public static void dialogue(Entity e, Entity f, Field field)
	{
		System.out.println("Player turn: " + e.getName());
		System.out.println();
		System.out.println("Statistics:");
		System.out.print("HP: ");
		for(int i = 0 ; i < e.getHP() ; i++)
		{
			System.out.print("+  ");
		}
		System.out.println();
		System.out.print("Ammo: ");
		for(int i = 0 ; i < e.getAmmo() ; i++)
		{
			System.out.print("=>  ");
		}
		System.out.println();
		System.out.print("Bricks: ");
		for(int i = 0 ; i < e.getBricks() ; i++)
		{
			System.out.print("#  ");
		}
		System.out.println();
		System.out.println();
		System.out.println("Choose action([action][direction]): ");
		System.out.println("[M] - move");
		System.out.println("[R] - run");
		System.out.println("[S] - shoot");
		System.out.println("[B] - set brick");
		System.out.println("\t+");
		System.out.println("[W] - up");
		System.out.println("[D] - right");
		System.out.println("[S] - down");
		System.out.println("[A] - left");
		System.out.println();
		System.out.print("Enter action type: ");
		Scanner s = new Scanner(System.in);
		char type = s.next().charAt(0);
		System.out.print("Enter action's direction: ");
		char dir = s.next().charAt(0);
		s.reset();
		System.out.println();
		e.action(type, dir, field, f);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
	}
}
