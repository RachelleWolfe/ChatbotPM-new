package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatbotAppController;
/**
 * GUI Frame class for a Chatbot. Shows the basic framework code for a JFrame extension
 * @author Rachel
 * @version 1.1 10/21/14
 */
public class ChatbotFrame extends JFrame 
{
	/**
	 * Reference for the CHatbotPanel of the GUI
	 */
	private ChatbotPanel basePanel;
	
	public ChatbotFrame(ChatbotAppController baseController) 
	{
		basePanel = new ChatbotPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		setVisible(true);
	}

}
