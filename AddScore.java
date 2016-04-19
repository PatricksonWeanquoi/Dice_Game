package com.programming.Project2;

import java.util.Random;

import javax.swing.ImageIcon;

public class AddScore
{
	
	Random randomValue=new Random(); 
	ImageIcon picturevalue;
	ImageArray image=new ImageArray();
	
	public int indexValue=image.index;
	public int value=0;
	public int comV=0;
	public int num = 0;
	public int addition=0;
	public final int ComP_Max=18;
	
	public String computeValue;
	public String computerString;
	public String text;
	
	ImageIcon dicy=new ImageIcon("src\\com\\programming\\Project2\\intro.png");
	
	//random value of the index from ImageArray class
	public void setRollValue()
	{
		
		value=randomValue.nextInt(indexValue);
		picturevalue=image.imagesR.get(value);
		
	}
	
	public void computerRandom()
	{
		comV=randomValue.nextInt(indexValue); //calls random value of computer
		
	
	}
	
	//sets the value of the computer
	public void setComputeValue()
	{				
		addition+=comV+1;
		computeValue=String.valueOf(addition); 		//convert from integer to string
	}
	public void computerEqualsZero()
	{
		addition=0;
		computeValue=String.valueOf(addition); 
		
	}
	//gets the value of the computer
	public String getComputeValue()
	{
		
		return computeValue;
	}
	public int computerIntVaue()
	{
		return addition;
	}
	
	//get the max value of computer
	//****this is used in the WindowsFrame class
	public String getMax()
	{
		computerString=String.valueOf(ComP_Max);
		return computerString ;
	}

public void numEqualsZero()
{
	num=0;
	text=String.valueOf(num);
	
}
	//sets the value of user's rolls
	public void setValue()
	{
		
		num+=value+1;					//adds the value every time the method is called
		text=String.valueOf(num);
	}
	
	//gets the value of user's value
	public String getValue()
	{
		
		return text;
	}
	public int getPlayIntValue()
	{
		return num;
	}
	
	//get the specific image 
	public ImageIcon getImage()
	{
		return picturevalue;
	}


}
