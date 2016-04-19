
package com.programming.Project2;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//The structure of the game of 21
public class WindowsFrame extends JFrame 
{	
	 private static final long serialVersionUID = 1L;
	 
	    private JButton yesButton;			//This is the roll button 
	    private JButton noButton;
	    private JButton exitButton;//This is the quit button
	    JButton tryAgain=new JButton();
	    
	    //JPanel is the location where you want your items to appear
	    JPanel imagePanel=new JPanel();		//This panel shows the images
	    JPanel ButtonPanel=new JPanel();	//This panel is where you add the Buttons 
	    JPanel scorePanel=new JPanel();		//This panel is where the scores are added
	    JPanel LostPanel=new JPanel();		//This panel is not used, but it is created just for future use
	    
	    //JLabel can hold text and images
	    JLabel LostText=new JLabel();		//This label is used to display "You Lose" text
	    JLabel emptySpace=new JLabel();		//This Label is used to add empty space to panel(Look at it as decoration)
	    JLabel computerScore=new JLabel();	//This label holds the computer Score text you want displayed
	    JLabel image=new JLabel();			//This label holds the image you want displayed
	    JLabel score=new JLabel();			//This label is used to hold the user's score text
	    JLabel winText=new JLabel();
	    
	    //Allows the user to enter text, but for now it's used to display scores
	    JLabel computerScore1=new JLabel(); 	//Location where the score of computer is auto-entered
	    JLabel userScore=new JLabel();			//Location where the score of user is auto-entered
	  
	    AddScore addScore=new AddScore();				//object of AddScore class
	    
	    int width,height;
	//Constructor of this class
	public WindowsFrame(int w, int h)
	{						
				//Hold the name of the frame
		        super("Game of Chance");
		        width=w;
				height=h;       
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//defines how the frame is closed
		        setSize(width, height);						//The width and height of the frame
		        setResizable(false);					//Asked if the frame can me maximum or minimum
		        setLocationRelativeTo(null);			//Sets the frame at the center
		        scorePanel.setBackground(Color.gray);
		        ButtonPanel.setBackground(Color.gray);
		        imagePanel.setBackground(Color.gray);
		        
		        //Adds the location of each panel you created
		        add(scorePanel, BorderLayout.NORTH);
		        add(ButtonPanel, BorderLayout.SOUTH);				
				add(imagePanel, BorderLayout.CENTER);
				
				yesButton = new JButton("Roll Dice");
				yesButton.setForeground(Color.white);
			    ButtonPanel.add(yesButton);					//yesButton is added to ButtonPanel
			    
			    noButton=new JButton("Stop");
			    noButton.setForeground(Color.white);
			    ButtonPanel.add(noButton);					//noButton is added to ButtonPanel
			    
			    exitButton=new JButton("Quit Game");
			    exitButton.setForeground(Color.white);
			    ButtonPanel.add(exitButton);
			    addScore.computerEqualsZero();					//calls the setRollValue from the AddScore class				        	
				image=new JLabel(addScore.dicy);		//calls the getImage method from the AddScore Class
			    imagePanel.add(image);						//Adds the image Label to the ImagePanel 		        
			    
			    
				addScore.numEqualsZero();						//calls the setValue from AddScore Class
				score=new JLabel("Your Score: ");
				score.setText("Your Score: ");				//Writes text to the panel
				score.setForeground(Color.white);
				
				userScore=new JLabel (addScore.getValue());		//Calls the getValue method from AddScore Class and set the length
				userScore.setForeground(Color.white);
				userScore.getForeground();
				scorePanel.add(score);						//Adds Score to ScorePanel
				scorePanel.add(userScore);					//Adds UserScore to ScorePanel	
				
				addScore.computerEqualsZero();
				yesButton.setBackground(Color.darkGray);
				noButton.setBackground(Color.darkGray);
				exitButton.setBackground(Color.darkGray);
		        
				//System.out.println("player Score: "+addScore.getPlayIntValue()+"  computer's : "+addScore.computerIntVaue());
				PlayerBurst();
				       
		                
				setVisible(true);							//Sets the windows Frame visible				
				//ActionListener for the yesButton
				yesButton();
				noButton();
				exitButton();
				jOptionPane();
	}		//End of Constructor

	
public void yesButton()
{
	yesButton.addActionListener(new ActionListener() 
	{		        	
	            //yesButton does what is placed in here
	 	public void actionPerformed(ActionEvent e)
	 		{
	 		
	 	    		scorePanel.setBackground(Color.gray);
	 	    		ButtonPanel.setBackground(Color.gray);
	 	    		imagePanel.setBackground(Color.gray);
	 				image.setVisible(true);
	            	addScore.setRollValue();					//Calls the setRollValue() from AddScore Class
	            	addScore.setValue();						//Calls the setValue from AddScore Class
	            	userScore.setText(addScore.getValue());
	            	
	        		image.setIcon(addScore.getImage());			//Adds the images from the AddScore Class
	            		        		
	        		score.setText("Your Score: ");		        				        		
					userScore.getText();
								
					PlayerBurst();
					ComputerMax();
					yesButton.setBackground(Color.darkGray);
					noButton.setBackground(Color.darkGray);
					exitButton.setBackground(Color.darkGray);
	 		}
	});

}
public void noButton()
{
	noButton.addActionListener(new ActionListener()
	{					        	
	            public void actionPerformed(ActionEvent e)
	            {		        	   
	            	lostScreen();		            		            			            	
	            }
	});
}
public void exitButton()
{
	exitButton.addActionListener(new ActionListener()
	{					        	
	            public void actionPerformed(ActionEvent e)
	            {		        	   		            	
	        		System.exit(0);		           	        				        		
	            }
	});
}
			
	//Play lost method
public void PlayerBurst()
{
	int convert=Integer.parseInt(addScore.getValue());			//Converts from text to integer
		//LostPanel=new JPanel();
	if(convert >= 22)
	{	  
		loseScreen();				
	}else
	if(convert ==21)
	{		
		winScreen();	
	}
}	

	//Checks computer score if it's at max
public void ComputerMax()
{			  
	if(addScore.computerIntVaue()>=18)
	{				
		computerScore1.setText(addScore.getMax());		
	}
	else
	{				   
		addScore.computerRandom();		
		addScore.setComputeValue();				
	}
}
	
//Calls the Computer Score to ScorePanel
public void addJtextToPanel()
{
	scorePanel.add(emptySpace);					//Adds the EmptySpace to ScorePanel
	scorePanel.add(computerScore);				//Adds the ComputerScore to ScorePanel
	scorePanel.add(computerScore1); 
}

public void centerJtextToPanel()
{	
	imagePanel.add(score);
	imagePanel.add(userScore);
	imagePanel.add(emptySpace);
	imagePanel.add(computerScore);
	imagePanel.add(computerScore1);	
}
  
public void lostScreen()
{		
	if(addScore.getPlayIntValue()>addScore.computerIntVaue() || addScore.getPlayIntValue()>addScore.ComP_Max )
	{			
	    scorePanel.setBackground(Color.green);
        ButtonPanel.setBackground(Color.green);
        imagePanel.setBackground(Color.green);
		yesButton.setVisible(false);
		noButton.setVisible(false);
		exitButton.setVisible(false);
		userScore.setVisible(false);
		score.setVisible(false);
	
		winText=new JLabel();
		winText.setText("You Won!");
		winText.getText();
		scorePanel.add(winText);
				
		image.setVisible(false);
		
		score=new JLabel("Your Score: ");
		score.setText("Your Score: ");				//Writes text to the panel
		score.getText();
		userScore=new JLabel (addScore.getValue());		//Calls the getValue method from AddScore Class and set the length
		userScore.getText();
		
		emptySpace=new JLabel("       ");
		emptySpace.setText("       ");
		emptySpace.getText();
		computerScore=new JLabel("Computer Score: ");	
		computerScore.setText("Computer Score: ");
		computerScore.getText();
		computerScore1=new JLabel (addScore.getComputeValue());
		computerScore1.getText();
		centerJtextToPanel();
		
		ComputerMax();		
		tryAgain=new JButton("Play Agiain");
		tryAgain.getText();
		ButtonPanel.add(tryAgain);
		tryAgain.setBackground(Color.darkGray);
		tryAgain.setForeground(Color.white);
		playAgain();
	}
	else
	if(addScore.getPlayIntValue()==addScore.computerIntVaue() || addScore.getPlayIntValue()==addScore.ComP_Max )
	{				
		    scorePanel.setBackground(Color.cyan);
	        ButtonPanel.setBackground(Color.cyan);
	        imagePanel.setBackground(Color.cyan);
			yesButton.setVisible(false);
			noButton.setVisible(false);
			exitButton.setVisible(false);
			userScore.setVisible(false);
			score.setVisible(false);
			
			winText=new JLabel();
			winText.setText("Score is Tied!");
			winText.getText();
			scorePanel.add(winText);
					
			image.setVisible(false);
			
			score=new JLabel("Your Score: ");
			score.setText("Your Score: ");				//Writes text to the panel
			score.getText();
			userScore=new JLabel (addScore.getValue());		//Calls the getValue method from AddScore Class and set the length
			userScore.getText();
			
			emptySpace=new JLabel("       ");
			emptySpace.setText("       ");
			emptySpace.getText();
			computerScore=new JLabel("Computer Score: ");	
			computerScore.setText("Computer Score: ");
			computerScore.getText();
			computerScore1=new JLabel (addScore.getComputeValue());
			computerScore1.getText();
			centerJtextToPanel();
				
			ComputerMax();
			tryAgain=new JButton("Play Again");
			tryAgain.getText();
			ButtonPanel.add(tryAgain);
			tryAgain.setBackground(Color.darkGray);
			tryAgain.setForeground(Color.white);
			playAgain();		
	}
	else
	if(addScore.getPlayIntValue()<addScore.computerIntVaue() || addScore.getPlayIntValue()<addScore.ComP_Max )
	{			
	    scorePanel.setBackground(Color.red);
        ButtonPanel.setBackground(Color.red);
        imagePanel.setBackground(Color.red);
		yesButton.setVisible(false);
		noButton.setVisible(false);
		exitButton.setVisible(false);
		userScore.setVisible(false);
		score.setVisible(false);
		
		winText=new JLabel();
		winText.setText("You Lose!");
		winText.getText();
		scorePanel.add(winText);
				
		image.setVisible(false);
		
		score=new JLabel("Your Score: ");
		score.setText("Your Score: ");				//Writes text to the panel
		score.getText();
		userScore=new JLabel (addScore.getValue());		//Calls the getValue method from AddScore Class and set the length
		userScore.getText();
		
		emptySpace=new JLabel("       ");
		emptySpace.setText("       ");
		emptySpace.getText();
		computerScore=new JLabel("Computer Score: ");	
		computerScore.setText("Computer Score: ");
		computerScore.getText();
		computerScore1=new JLabel (addScore.getComputeValue());
		computerScore1.getText();
		centerJtextToPanel();
			
		ComputerMax();
		tryAgain=new JButton("Play Again");
		tryAgain.getText();
		ButtonPanel.add(tryAgain);
		tryAgain.setBackground(Color.darkGray);
		tryAgain.setForeground(Color.white);
		playAgain();
	}
	
}
private void playAgain()
{
	tryAgain.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					computerScore.setVisible(false);
					emptySpace.setVisible(false);
					computerScore1.setVisible(false);
					tryAgain.setVisible(false);
					winText.setVisible(false);
					score.setVisible(false);
					userScore.setVisible(false);
				
					image.setVisible(false);
					
					renderGraphics();																			
				}		
			});
}

public void renderGraphics()
{
    scorePanel.setBackground(Color.gray);
    ButtonPanel.setBackground(Color.gray);
    imagePanel.setBackground(Color.gray);
	yesButton = new JButton("Roll Dice");		
     ButtonPanel.add(yesButton);					//yesButton is added to ButtonPanel
    
    noButton=new JButton("Stop");
    ButtonPanel.add(noButton);					//noButton is added to ButtonPanel
    
    exitButton=new JButton("Quit Game");
    ButtonPanel.add(exitButton);
     									        	
	image=new JLabel(addScore.dicy);		//calls the getImage method from the AddScore Class
    imagePanel.add(image);						//Adds the image Label to the ImagePanel 		        
    
	
	score=new JLabel("Your Score: ");
	score.setText("Your Score: ");				//Writes text to the panel
	score.setForeground(Color.white);
	score.getForeground();
	addScore.numEqualsZero();
	userScore=new JLabel (addScore.getValue());		//Calls the getValue method from AddScore Class and set the length
	userScore.setForeground(Color.white);
	userScore.getForeground();
	
	scorePanel.add(score);						//Adds Score to ScorePanel
	scorePanel.add(userScore);					//Adds UserScore to ScorePanel	
	
	addScore.computerEqualsZero();
	addScore.getComputeValue(); 
	
	yesButton.setBackground(Color.darkGray);
	yesButton.setForeground(Color.white);
	noButton.setBackground(Color.darkGray);
	noButton.setForeground(Color.white);
	exitButton.setBackground(Color.darkGray);
	exitButton.setForeground(Color.white);
	yesButton();
	
	noButton();
	exitButton();
	
}

public void loseScreen()
{
	ComputerMax();
    scorePanel.setBackground(Color.red);
    ButtonPanel.setBackground(Color.red);
    imagePanel.setBackground(Color.red);
	yesButton.setVisible(false);
	noButton.setVisible(false);
	exitButton.setVisible(false);
	userScore.setVisible(false);
	score.setVisible(false);
	
	winText=new JLabel();
	winText.setText("You Lose!");
	winText.getText();
	scorePanel.add(winText);
		
	image.setVisible(false);
	
	score=new JLabel("Your Score: ");
	score.setText("Your Score: ");				//Writes text to the panel
	score.getText();
	userScore=new JLabel (addScore.getValue());		//Calls the getValue method from AddScore Class and set the length
	userScore.getText();
	
	emptySpace=new JLabel("       ");
	emptySpace.setText("       ");
	emptySpace.getText();
	computerScore=new JLabel("Computer Score: ");	
	computerScore.setText("Computer Score: ");
	computerScore.getText();
	computerScore1=new JLabel (addScore.getComputeValue());
	computerScore1.getText();
	centerJtextToPanel();
		
	tryAgain=new JButton("Play Again");
	tryAgain.getText();
	ButtonPanel.add(tryAgain);
	tryAgain.setBackground(Color.darkGray);
	tryAgain.setForeground(Color.white);
	playAgain();
}

public void winScreen()
{
	ComputerMax();
	image.setVisible(false);
    scorePanel.setBackground(Color.green);
    ButtonPanel.setBackground(Color.green);
    imagePanel.setBackground(Color.green);
	yesButton.setVisible(false);
	noButton.setVisible(false);
	exitButton.setVisible(false);
	userScore.setVisible(false);
	score.setVisible(false);

	winText=new JLabel();
	winText.setText("You Won!");
	winText.getText();
	scorePanel.add(winText);
				
	score=new JLabel("Your Score: ");
	score.setText("Your Score: ");				//Writes text to the panel
	score.getText();
	userScore=new JLabel (addScore.getValue());		//Calls the getValue method from AddScore Class and set the length
	userScore.getText();
	
	emptySpace=new JLabel("       ");
	emptySpace.setText("       ");
	emptySpace.getText();
	computerScore=new JLabel("Computer Score: ");	
	computerScore.setText("Computer Score: ");
	computerScore.getText();
	computerScore1=new JLabel (addScore.getComputeValue());
	computerScore1.getText();
	centerJtextToPanel();
			
	tryAgain=new JButton("Play Again");
	tryAgain.getText();
	ButtonPanel.add(tryAgain);	
	tryAgain.setBackground(Color.darkGray);
	tryAgain.setForeground(Color.white);
	playAgain();
}

private void jOptionPane()
{
	int num;
	
	num=JOptionPane.showConfirmDialog(null, "This a Game of 21. Do you want to continue?", "Please Confirm", JOptionPane.YES_NO_OPTION);
	if(num==JOptionPane.YES_OPTION)
	{
		//JOptionPane.showMessageDialog(null, "Click \"Roll Dice\" to play game. Click \"Stop\" to forfeit game.","",JOptionPane.OK_OPTION);
	}
	else
	if(num==JOptionPane.NO_OPTION || num==JOptionPane.CLOSED_OPTION)
	{		
		num=JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?","", JOptionPane.YES_NO_OPTION);
		if(num==JOptionPane.YES_OPTION || num==JOptionPane.CLOSED_OPTION)
		{
			System.exit(0);
		}
	}
}
}



