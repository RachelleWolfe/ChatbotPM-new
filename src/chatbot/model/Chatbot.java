package chatbot.model;

import java.util.ArrayList;

/**
 * The Chatbot model class. Used for checking and manipulating Strings.
 * @author Rachel Goodliffe
 * @version 1.4 11/11/14 Update processText and added a checker
 */

public class Chatbot 
{
	private ArrayList<String> memeList;
	private String name;
	private String contentArea;
	private int chatCount;
	private ChatbotUser myUser;
	
	/**
	 * Creates a Chatbot object with supplied name and initializes the current number of chats to zero.
	 * @param name The supplied name for the Chatbot.
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		userInputList = new ArrayList<String>();
		this.name = name;
		contentArea = "";
		chatCount = 0;
		myUser = newChatbotUser();
		fillTheMemeList();
	}
	
	
	private ChatbotUser newChatbotUser() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<String> userInputList;
	
	public String processText(String currentInput)
	{
		String result = "";
		
		if (getChatCount() < 5)
		{
			result = introduceUser(currentInput);
		}
		else if(currentInput != null && currentInput.length() >0)
		{
			result = randomChatConversation(currentInput);
		}
			
		{
			result = "Use words!";
			chatCount--;
		}
		updateChatCount();
		return result;
	}
	
	private String introduceUser(String input)
	{
		String userQuestion = "";
		int x;
		
		if(getChatCount() < 5)
		{
			
			if(getChatCount() == 0)
			{
				myUser.setUserName(input);
				userQuestion = "Good name" + myUser.getUserName() + "How old are you?";
			}
			else if(getChatCount() == 1)
			{
				int userAge = Integer.parseInt(input);
				myUser.setAge(userAge);
				userQuestion = "You're older than a tree! " +myUser.getUserName() + "how much do you weigh?";
			}
			//continue for other user into fields
		}
		return userQuestion;
	}
	
	private String randomChatConversation(String input)
	{
		String conversation = "";
		int randomPosition = (int) (Math.random() * 6);
		
		if (randomPosition == 0)
		{
			if(stringLengthChecker(input))
			{
				conversation = "too long";
			}
			else
			{
				conversation = "too short";
			}
		}
		else if(randomPosition == 1)
		{
			//content checker here
		}
		else if(randomPosition == 2)
		{
			if(memeChecker(input))
			{
				conversation = "Wow, " + input + " is a meme. Wahoo!";
			}
			else
			{
				conversation = "Not a meme, try again";
			}	
		}
		else if( randomPosition == 3)
		{
			//talk about person here :D
		}
		else if( randomPosition == 4)
		{
			//add to our list
			userInputList.add(input);
			conversation = "Thank you for the comment";
		}
		else
		{
			if(userInputChecker(input))
			{
				conversation = "That was nice - you removed it from the list";
			}
			else
			{
				conversation = "that wasn't in the conversation before";
			}
		}
		
		return conversation;
	}
	
	private String userTopic(String userInput)
	{
		String userBasedResponse = "";
		
		int randomUserTopic = (int) (Math.random() * 6);
		
		switch(randomUserTopic)
		{
			case 1:
				userBasedResponse = myUser.getAge() + " TATTOOOOOOOOOOOOOS";
				break;
			case 0:
				userBasedResponse = myUser.getAge() + " is a silly name :P";
				break;
			default:
				userBasedResponse = myUser.getAge() + " is suuuuuuuuuuuuuuuper old";
				break;
		}
		return userBasedResponse;
	}
	
	private boolean userInputChecker(String userInput)
	{
		boolean matchesInput = false;
		
		for(int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if(userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
			}
		}
		
		return matchesInput;
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
