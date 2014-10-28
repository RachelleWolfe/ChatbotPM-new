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
		chatArea = new JTextArea(5,20);
		chatPane = new JScrollPane(chatArea);
		
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
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -10, SpringLayout.SOUTH, this);
	}
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				firstTextField.setText(firstTextField.getText()+ " >:O");
			}
		});
		
	}
}
