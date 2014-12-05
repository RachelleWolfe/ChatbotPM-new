package chatbot.model;
/**
 * File that stores different possibilities for the chatbot
 * @author rgoo2093
 * Version 1.1
 */
public class ChatbotUser 
{
	/**
	 * Gives the opportunity for a username
	 */
	private String userName;
	/**
	 * Gives the space for a age
	 */
	private int age;
	/**
	 * Gives the space for a possibility of an answer
	 */
	private boolean lovesMusic;
	/**
	 * Gives a possibility of an answer
	 */
	private Boolean playsPiano;
	private double weight;
	/**
	 * Gets the username
	 * @return
	 */
	public String getUserName() 
	{
		return userName;
	}
	/**
	 * Returns the given username of the user.
	 * @param userName
	 */
	public void setUserName(String userName) 
	{
		
		this.userName = userName;
	}
	/**
	 * allows the age to be given
	 * @return
	 */
	public int getAge()
	{
		return age;
	}
	/**
	 * Allows the age to be set
	 * @param userAge
	 */
	public void setAge(int userAge)
	{
		this.age = userAge;
	}
	/**
	 * One of the options given for the chatbot to reply to.
	 * @return
	 */
	public boolean isLovesMusic() 
	{
		return lovesMusic;
	}
	/**
	 * Gives the variable of the chatbot
	 * @param lovesMusic
	 */
	public void setLovesMusic(boolean lovesMusic) 
	{
		this.lovesMusic = lovesMusic;
	}

	
	/**
	 * gets the option into the chatbot
	 * @return the variable
	 */
	public Boolean getPlaysPiano() 
	{
		return playsPiano;
	}
	/**
	 * Sets the piano to be able to be answered or replied to.
	 * @param playsPiano
	 */
	public void setPlaysPiano(Boolean playsPiano) 

	{
		this.playsPiano = playsPiano;
	
	}
	public double getWeight()
	{
		return weight;
	}
	
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	/**
	 * Gives the ability to answer any of the following code
	 */
	public ChatbotUser()
	{
		this.userName = "";
		this.age = -18;
		this.lovesMusic = false;
		this.playsPiano = false;
		this.weight = -65;
		
	}
	
	
}
