package chatbot.controller;


/**
 * The runner for the Chatbot
 * @author Raye
 *@version 10/1/14
 */
public class ChatbotRunner 
{
	/**
	 * Allows the app to begin
	 * @param args
	 */
	public static void main(String [] args)
	{
		ChatbotAppController appController = new ChatbotAppController();
		appController.start();
	}

}
