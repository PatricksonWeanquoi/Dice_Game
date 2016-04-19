package com.programming.Project2;

import java.util.ArrayList;


import javax.swing.ImageIcon;

public class ImageArray 
{
	
	 //location  of images
	 ImageIcon icon1=new ImageIcon("src\\com\\programming\\Project2\\1Die.png");
	 ImageIcon icon2=new ImageIcon("src\\com\\programming\\Project2\\2Die.png");
	 ImageIcon icon3=new ImageIcon("src\\com\\programming\\Project2\\3Die.png");
	 ImageIcon icon4=new ImageIcon("src\\com\\programming\\Project2\\4Die.png");
	 ImageIcon icon5=new ImageIcon("src\\com\\programming\\Project2\\5Die.png");
	 ImageIcon icon6=new ImageIcon("src\\com\\programming\\Project2\\6Die.png");
	 
	 //arrayList of the ImageIcon
	 public ArrayList<ImageIcon> imagesR=new ArrayList<ImageIcon>();
	 {
		 imagesR.add(icon1);
		 imagesR.add(icon2);
		 imagesR.add(icon3);
		 imagesR.add(icon4);
		 imagesR.add(icon5);
		 imagesR.add(icon6);
	 }
	 //Holds the length of the ImageIcon
	 int index=imagesR.size();
	 

}
