package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotAppController;
import javax.swing.*;

public class ChatbotPanel extends JPanel 
{
	private ChatbotAppController baseController;
	
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout; 
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	
	public ChatbotPanel(ChatbotAppController baseController) 
	{
		this.baseController = baseController;
		
		firstButton = new JButton("Click the button... Just do it");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 45, SpringLayout.NORTH, this);
		chatArea = new JTextArea(5,20);
		chatPane = new JScrollPane(chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 20, SpringLayout.EAST, chatPane);
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -10, SpringLayout.SOUTH, this);
	}
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentInput = firstTextField.getText();
				String result = baseController.getChatbotDialog(currentInput);
				showTextMessage(currentInput);
				showTextMessage(result);
				firstTextField.setText("");
			}
		});
		
	}
	
	public void showTextMessage(String userInput)
	{
		chatArea.append("\n" + userInput);
	}
}

