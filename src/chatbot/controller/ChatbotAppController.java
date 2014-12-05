package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;


/**
 * Runs the CHatbot Project. Owns the model and associated views.
 * @author Raye
 *@version 1.2 10/2/14 - cleaned the quit method.
 */
public class ChatbotAppController
{
	private ChatbotView applicationView;
	private Chatbot mySillyChatbot;
	private String startMessage;
	private String quitMessage;
	
	/**
	 * Reference to the GUI JFrame object for the application
	 */
	private ChatbotFrame appFrame;
	
	/**
	 * produces the welcome message of the Chatbot
	 */
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		appFrame = new ChatbotFrame(this);
		mySillyChatbot = new Chatbot("Alonso");
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " chatbot. What is your name?";
		quitMessage = "Goodbye cruel user :(";
	}
	/**
	 * Get's the chatbot
	 * @return mySillyChatbot
	 */
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}
	/**
	 * starts the program
	 */
	public void start()
	{
		
		((ChatbotPanel) appFrame.getContentPane()).showTextMessage(startMessage);
		
		//ChatbotPanel testPanel = (ChatbotPanel) appFrame.getContentPane();
		//testPanel.showTextMessage(startMessage);
		
	}
	/*
	 * brings the chatbot pop up window	
	 */
	public String getChatbotDialog(String input)
	{
		String result = "";
		if(mySillyChatbot.quitChecker(input))
		{
			quit();
		}
		
		result = mySillyChatbot.processText(input);
		
		return result;
	}
	/**
	 * quits the app
	 */
	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
	}
	
	
}
