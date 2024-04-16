package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import engine.Game;
import engine.Player;

public class PlayerNameFrame  extends JFrame implements ActionListener {
	
	private static String Player1 = null;
	private static String Player2 = null;
	
	private JPanel iconPanel;
	private JPanel firstPlayer;
	private JPanel secondPlayer;
	private JPanel playPanel;
	private JPanel vsPanel;
	
	private JTextField firstPlayerName;
	private JTextField secondPlayerName;
	
	private JButton submit1 ;
	private JButton submit2;
	private JButton playButton ;
	
	
	public PlayerNameFrame() throws IOException {
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Marvel Ultimate War");
		this.setIconImage(new ImageIcon("public/GameIcon.jpeg").getImage());
		//this.setContentPane(new JLabel(new ImageIcon("GameIcon.jpeg")));
	
		
		
		//vsLabel.setSize(1920,1080);
		
		//this.getContentPane().add(new JPanelWithBackground("background1.jpg"));
		
		
		
		//Panels
		iconPanel= new JPanel();
		iconPanel.setBounds(0,0, 150, 150);
		iconPanel.setBackground(Color.BLACK);
		//iconPanel.setLayout(new BorderLayout());
		firstPlayer= new JPanel();
		firstPlayer.setBounds(250,0, 250, 250);
		firstPlayer.setBackground(Color.BLACK);
		secondPlayer= new JPanel();
		
		secondPlayer.setBounds(250,250, 250, 250);
		secondPlayer.setBackground(Color.BLACK);
		
		playPanel = new JPanel();
		playPanel.setBounds(500,500, 250, 250);
		playPanel.setBackground(Color.BLACK);
		vsPanel = new JPanel();
		vsPanel.setBounds(1000,1000,250,250);
		vsPanel.setBackground(Color.BLACK);
		
		//label
		JLabel marvelIcon = new JLabel();
		ImageIcon marvelLogo = new ImageIcon("public/marvel1.jpeg");
		marvelIcon.setIcon(marvelLogo);
		//JLabel ultimatewar = new JLabel();
		//ultimatewar.setIcon(new ImageIcon("ultimatewar.jpg"));
		
		ImageIcon vsIcon = new ImageIcon("public/vsicon.png");
		JLabel vsLabel= new JLabel(vsIcon);
		
	
		JLabel firstPlayerLabel = new JLabel("Enter First Player Name");
		JLabel secondPlayerLabel = new JLabel("Enter Second Player Name");
		firstPlayerLabel.setFont(new Font(null,Font.BOLD,20));
		firstPlayerLabel.setForeground(Color.BLUE);
		secondPlayerLabel.setForeground(Color.RED);
		secondPlayerLabel.setFont(new Font(null,Font.BOLD,20));
		
		//firstPlayerLabel.setVerticalAlignment(JLabel.TOP);
		//secondPlayerLabel.setVerticalAlignment(JLabel.TOP);
		
		//firstPlayerLabel.setHorizontalAlignment(JLabel.CENTER);
		//secondPlayerLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		
		//TextFields
		firstPlayerName = new JTextField();
		firstPlayerName.setPreferredSize(new Dimension(250,40));
		firstPlayerName.setFont(new Font("MV Boli",Font.BOLD,20));
		
		secondPlayerName = new JTextField();
		secondPlayerName.setPreferredSize(new Dimension(250,40));
		secondPlayerName.setFont(new Font("MV Boli",Font.BOLD,20));
		
		//Buttons
	    submit1 = new JButton("Submit");
		submit1.addActionListener(this);
	    submit2 = new JButton("Submit");
		submit2.addActionListener(this);
		
	
	    playButton = new JButton();
		playButton.addActionListener(this);
		ImageIcon startIcon = new ImageIcon("public/startIcon.png");
		playButton.setIcon(startIcon);
		playButton.setBackground(Color.BLACK);
		this.add(playButton);
		playButton.setEnabled(false);
		playButton.setFocusable(false);
		
		
		
		
		//PanelsAdding
		iconPanel.add(marvelIcon);
		
		firstPlayer.add(firstPlayerLabel);
		firstPlayer.add(firstPlayerName);
		firstPlayer.add(submit1);
		
		
		
		secondPlayer.add(secondPlayerLabel);
		secondPlayer.add(secondPlayerName);
		secondPlayer.add(submit2);
		
		
		playPanel.add(playButton);
		vsPanel.add(vsLabel);

		//FrameAdding
		this.add(iconPanel,BorderLayout.NORTH);
		this.add(firstPlayer , BorderLayout.WEST);
		this.add(secondPlayer, BorderLayout.EAST);
		this.add(playPanel , BorderLayout.SOUTH);
		this.add(vsPanel,BorderLayout.CENTER);
		
	    
		this.setVisible(true);
		
	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit1) {
			Player1 = firstPlayerName.getText();
			if(!Player1.equals("")) {
				submit1.setEnabled(false);	 
			}
			
		}
        if(e.getSource()==submit2) {
        	Player2 = secondPlayerName.getText();
        	if(!Player2.equals("")) {
        		submit2.setEnabled(false);
        	}
		}
        if (!Player1.equals("") && !Player2.equals("")) {
    		playButton.setEnabled(true);
    	}
        if(e.getSource()==playButton) {
        	this.dispose();
        	try {
				new ChampionSelection().setVisible(true);
				} 
        	catch (IOException e1) {
					e1.printStackTrace();
				}
			
        
        	 
	
		}
		
	}


	public static  String getPlayer1() {
		return Player1;
	}

	public static   String getPlayer2() {
		return Player2;
	}
	

}
