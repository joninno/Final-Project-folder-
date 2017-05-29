/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

public class DefensivePlayer extends NFLPlayer implements Celebrator 
{
	
	private double tackles;
	private double ast;
	private double comb;
	private double sacks;
	private double inter;
	private String position;
	
	
	//DefensivePlayer constructor	
	DefensivePlayer(String name, int age, int number, String team, String position, double height, int weight, String category,  int comb, int tackles,
	int ast, double d, double inter) 
	{
		super(name, age, number, team, height, weight, "def");
		this.setTackles(tackles);
		this.setAst(ast);
		this.setComb(comb);
		this.setSacks(d);
		this.setInter(inter);
		this.setPosition(position);
	}
	

	public String celebrate() 
	{
		int r = new Random().nextInt(4);
		String message = "";
		switch(r){
		case 0: message = " The Ray Lewis Dance";
    	break;
	case 1: message = " The Tim Tebow kneeling bobblehead";
		break;
	case 2: message = " Give his friends a high five";
		break;
	case 3: message = " The Heisman Pose";
		break;
	case 4: message = " The Ickey Shuffle";
        		break;
		}
		return message;
		}


	//Get tackles
	public double getTackles() 
	{
		return tackles;
	}


	//Set tackles
	public void setTackles(double tackles) 
	{
		this.tackles = tackles;
	}


	//Get Ast
	public double getAst() 
	{
		return ast;
	}

	
	//Set Ast
	public void setAst(double ast) 
	{
		this.ast = ast;
	}


	//get comb
	public double getComb() 
	{
		return comb;
	}


	//Set comb
	public void setComb(double comb) 
	{
		this.comb = comb;
	}

	
	//Get sacks
	public double getSacks() 
	{
		return sacks;
	}


	//Set sacks
	public void setSacks(double sacks) 
	{
		this.sacks = sacks;
	}


	//Get inter
	public double getInter() 
	{
		return inter;
	}

	
	//Set inter
	public void setInter(double inter) 
	{
		this.inter = inter;
	}


	
	//Get Position
	public String getPosition() 
	{
		return position;
	}

	
	//Set Position
	public void setPosition(String position) 
	{
		this.position = position;
	}

}	