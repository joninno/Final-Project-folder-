/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

public abstract class NFLPlayer implements Celebrator
{
	//Declare private variables
	private String name;
	private int age;
	private int number;
	private String team;
	private float height;
	private float weight;
	private String status = "available";
	private String category;


	NFLPlayer() 
	{
		setName("");
		setAge(0);
		setNumber(0);
		setTeam("");
		setHeight(0); 
		setWeight(0);
		setCategory("");
	}
	
	
	 //No arg constructor for intial values of private variables
	NFLPlayer(String name, int age, int number, String team, double height2, float weight, String category) 
	{
		this.setName(name);
		this.setAge(age);
		this.setNumber(number);
		this.setTeam(team);
		this.setHeight((float) height2); 
		this.setWeight(weight);
		this.setCategory(category);
	}
	
	
	//Getter for name
	public String getName() 
	{
		return name;
	}
	
	
	//Setter for name
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	//Get for age
	public int getAge() 
	{
		return age;
	}
	//Set for age
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	//Get for number
	public int getNumber() 
	{
		return number;
	}
	
	//Set for number
	public void setNumber(int number) 
	{
		this.number = number;
	}
	
	//Get for team
	public String getTeam() 
	{
		return team;
	}
	
	//Set for team
	public void setTeam(String team) 
	{
		this.team = team;
	}
	
	//Get for height
	public float getHeight() 
	{
		return height;
	}
	
	//Set for height
	public void setHeight(float height) 
	{
		this.height = height;
	}
	
	//Get for weight
	public float getWeight() 
	{
		return weight;
	}
	
	//Set for weight
	public void setWeight(float weight) 
	{
		this.weight = weight;
	}
	
	
	//Get for status
	public String getStatus() 
	{
		return status;
	}

	
	//Set for status
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	
	//Get for Category
	public String getCategory() 
	{
		return category;
	}
	

	//Set for Category
	public void setCategory(String category) 
	{
		this.category = category;
	}
	
	
	
	public String celebrate() 
	{
		int r = new Random().nextInt(4);
		String message = "";
		switch(r){
			case 0: message = " The Tim Tebow kneeling bobblehead";
	        	break;
			case 1: message = " Give his friends a high five";
        		break;
			case 2: message = " Moonwalks 5 pace and does a back flip";
        		break;
			case 3: message = " Jumps up and down then plays it off";
        		break;
			case 4: message = " Points his finger to the sky";
        		break;
		}
		
		
		return getName() + message;
		}
	
}