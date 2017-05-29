/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

public class OffensivePlayer extends NFLPlayer implements Celebrator 
{
		
		private double passing;
		private double rec;
		private double passingAvg;
		private double rushing;
		private double rushingAvg;
		private double rushingAttempts;
		private double td;
		private String position;
		
	//	OffensivePlayer(String name, int age, int number, String team, float height, float weight, String category, double passing,
	//	double rec, double passingAvg, double rushing, double rushingAvg, double rushingAttempts, double td, String position) 
		
OffensivePlayer(String name, int age, int number, String team, double height, int weight, String category,String position,  
		
		int passing,double passingAvg, int rushingAttempts,  double rushing,double rushingAvg, double td,double rec)
	

		
		
		
		
		{
			super(name, age, number, team, height, weight, "off");
			this.setPassing(passing);
			this.setRec(rec);
			this.setPassingAvg(passingAvg);
			this.setRushing(rushing);
			this.setRushingAvg(rushingAvg);
			this.setRushingAttempts(rushingAttempts);
			this.setTd(td);
			this.setPosition(position);
		}
		
		

		public String celebrate() 
		{
			int r = new Random().nextInt(4);
			String message = "";
			switch(r)
			{
			case 0: message = " The Tim Tebow kneeling bobblehead";
        	break;
		case 1: message = " Points his finger to the sky";
    		break;
		case 2: message = " Does Carlton dance";
    		break;
		case 3: message = " Jumps up and down then plays it off";
    		break;
		case 4: message = " Throwing up the peace sign";
	        		break;
			}
			
			
			return message;
			}

		
		//Get Passing
		public double getPassing() 
		{
			return passing;
		}


		//Set Passing
		public void setPassing(double passing) 
		{
			this.passing = passing;
		}

		
		//Get Rec
		public double getRec() 
		{
			return rec;
		}

		
		//Set Rec
		public void setRec(double rec) 
		{
			this.rec = rec;
		}

		
		//Get PassingAvg
		public double getPassingAvg() 
		{
			return passingAvg;
		}

		
		//Set PassingAvg
		public void setPassingAvg(double passingAvg) 
		{
			this.passingAvg = passingAvg;
		}

		
		//Get Rushing
		public double getRushing() 
		{
			return rushing;
		}

		//Set Rushing
		public void setRushing(double rushing) 
		{
			this.rushing = rushing;
		}

		
		//Get RushingAvg
		public double RushingAvg() 
		{
			return rushingAvg;
		}

		
		//Set RushingAvg
		public void setRushingAvg(double rushingAvg) 
		{
			this.rushingAvg = rushingAvg;
		}

		
		//Get RushingAttempts
		public double getRushingAttempts() 
		{
			return rushingAttempts;
		}

		
		//Set RushingAttempts
		public void setRushingAttempts(double rushingAttempts) 
		{
			this.rushingAttempts = rushingAttempts;
		}


		//Get TD
		public double getTd() 
		{
			return td;
		}

		
		//Set TD
		public void setTd(double td) 
		{
			this.td = td;
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