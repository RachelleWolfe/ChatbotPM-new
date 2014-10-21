package chatbot.model;

import java.util.ArrayList;

/**
 * The Chatbot model class. Used for checking and manipulating Strings.
 * @author Rachel Goodliffe
 * @version 1.2 10/9/14
 */

public class Chatbot 
{
	private ArrayList<String> memeList;
	private String name;
	private String contentArea;
	private int chatCount;
	
	/**
	 * Creates a Chatbot object with supplied name and initializes the current number of chats to zero.
	 * @param name The supplied name for the Chatbot.
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		this.name = name;
		contentArea = "";
		chatCount = 0;
		fillTheMemeList();
	}
	
	
	public String processText(String currentInput)
	{
		String result = "";
		
		int randomPosition = (int) (Math.random() * 3);
		if(currentInput != null)
		{
		
			if(randomPosition == 0)
		{
			if(stringLengthChecker(currentInput))
			{
				result = "too long";
			}
			else
			{
				result = "too short";
			}
		}
		else if(randomPosition == 1)
		{
			//content checker here
		}
		else
		{
			if(memeChecker(currentInput))
			{
				result = "Wow, " + currentInput + " is a meme. Wahoo!";
			}
			else
			{
				result = "Not a meme, try again";
			}	
		}
		}
		else
		{
			result = "Use words!";
		}
		
		return result;
	}
	
	
	/**
	 * Returns the name of the Chatbot object.
	 * @return The current name of the Chatbot.
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the number of chats of the Chatbot object.
	 * @return The current number of the Chatbot.
	 */
	public int getChatCount()
	{
		return chatCount;
	}
	/**
	 * Sets the name in the Chatbot object.
	 * @param name The new name of the Chatbot.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * gives the name of approved memes
	 */
	private void fillTheMemeList()
	{
		memeList.add("kitties");
		memeList.add("one does not simply");
		memeList.add("doge");
		memeList.add("doh!");
		memeList.add("toddler fist");
		memeList.add("y u no");
		
	}
	
	/**
	 * Keeps chat count updated
	 */
	private void updateChatCount()
	{
		chatCount++;
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;
		
		for (String currentMeme : memeList)
		{
			if(input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}
		
		for(int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if(input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}
		
		return isAMeme;
	}
	
	private boolean stringLengthChecker(String input)
	{
		boolean isTooLong = false;
		
		if (input.length() >= 70)
		{
			isTooLong = true;
		}
		
		return isTooLong;
	}
	
	
	private boolean contentChecker(String input)
	{
		boolean isContent = false;
		
		if (input != null &&input.contains("Hello"))
		{
			isContent = true; 
		}
		return isContent;
	}
	
	/**
	 * 
	 * @param input of the string.
	 * @return Quits the checker
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equals("sayonara"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
	
}
