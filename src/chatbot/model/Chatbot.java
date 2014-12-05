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
		myUser = new ChatbotUser();
		fillTheMemeList();
	}
	
	/**
	 * Opens the conversation window
	 * @return a new chatbot user
	 */
	private ChatbotUser newChatbotUser() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * imports the different options for speaking
	 */
	private ArrayList<String> userInputList;
	/**
	 * Letter count less than 5
	 * @param currentInput
	 * @return input
	 */
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
		else 	
		{
			result = "Use words!";
		}
		updateChatCount();
		return result;
	}
	/**
	 * reply to 'hello'
	 * @param input
	 * @return the result
	 */
	private String introduceUser(String input)
	{
		String userQuestion = "";
		int x;
		
		if(getChatCount() == 0)
		{
			myUser.setUserName(input);
			userQuestion = "Good name " + myUser.getUserName() + ". How old are you?";
		}
		else if(getChatCount() == 1)
		{
			int userAge = Integer.parseInt(input);
			myUser.setAge(userAge);
			userQuestion = "You're older than a tree, " +myUser.getUserName() + "! How much do you weigh?";
		}
		else if(getChatCount() == 2)
		{
			double userWeight = Double.parseDouble(input);
			myUser.setWeight(userWeight);
			userQuestion = "You're really light " +myUser.getUserName() + ". What is your favorite music?";
		}
		else if(getChatCount() == 3)
		{
			boolean lovesMusic = Boolean.parseBoolean(input);
			myUser.setLovesMusic(lovesMusic);
			userQuestion = "That's a good group " +myUser.getUserName() + "! Do you play piano?";
		}
		else 
		{
			boolean playsPiano = Boolean.parseBoolean(input);
			myUser.setPlaysPiano(playsPiano);
			userQuestion = "That's awesome " +myUser.getUserName() + ". What else would you like to talk about?";
		}
		//continue for other user into fields		
		return userQuestion;
	}
	/**
	 * response for short conversations
	 * @param input
	 * @return
	 */
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
		else if(randomPosition ==5)
		{
			if(mashChecker(input))
			{
				conversation = mashingDetected(input);
			}
			else
			{
				conversation = noMashingDetected(input);
			}

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
	/**
	 * Adds substrings that are added over and over again
	 * @param input string Mashing Detected
	 * @return mashed
	 */
	private String mashingDetected(String input)
	{
		String mashed = "";
		
		mashed = input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		
		return mashed;
	}
	/**
	 * Reply to when mashing does not happen to keyboard
	 * @param input
	 * @return
	 */
	private String noMashingDetected(String input)
	{
		String noMashing = "Thank you for not mashing your keyboard";
		
		{
			noMashing += input.substring(input.length()/3, input.length()/2);
		}
		return noMashing;
		
	}
	/**
	 * Checks the mashing
	 * @param userInput
	 * @return false if not mashing
	 */
	private boolean mashChecker(String userInput)
	{
		boolean isMashing = false;
		
		if(userInput.indexOf("asds") > -1)
		{
			isMashing = true;
		}
		
		return isMashing;
	}
	/**
	 * Response given determined by users interests
	 * @param userInput
	 * @return
	 */
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
	/**
	 * gives the user input
	 * @param userInput
	 * @return
	 */
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
	/**
	 * checks the length of the response
	 * @param input
	 * @return the response
	 */
	private boolean stringLengthChecker(String input)
	{
		boolean isTooLong = false;
		
		if (input.length() >= 70)
		{
			isTooLong = true;
		}
		
		return isTooLong;
	}
	
	/**
	 * Checks the content of the string
	 * @param input
	 * @return the completed content
	 */
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
	 * checks to see if the quit took place
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
