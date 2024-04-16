package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Game;
import engine.Player;

public class GameOverFrame extends JFrame implements ActionListener {
	
	
	String player1Name= PlayerNameFrame.getPlayer1();
	Player Player1 = new Player(player1Name);
	String player2Name= PlayerNameFrame.getPlayer2();
	Player Player2 = new Player(player2Name);
	private Player winner = GameFrame.getWinner();
	
	JButton closeB = new JButton();
	JLabel winnerName = new JLabel();
	
	public GameOverFrame() {
		
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		this.setTitle("Marvel Ultimate War");
		this.setIconImage(new ImageIcon("GameIcon.jpeg").getImage());
		
		this.repaint();
		
		JLabel closeL=new JLabel("Close");
		closeL.setFont(new Font(null,Font.BOLD,50));
		closeL.setForeground(Color.RED);
		closeB.setSize(new Dimension(150,150));
		closeB.add(closeL);
		
		JLabel gameOver = new JLabel(new ImageIcon("gameover.jpg"));
		gameOver.setBackground(Color.BLACK);
		closeB.addActionListener(this);
		
		
		winnerName.setBackground(Color.BLACK);
		if(Player1 == winner) {
			winnerName.setText("The Winner is " +player1Name);
			winnerName.setForeground(Color.BLUE);
		}
		else {
			winnerName.setText("The Winner is " + player2Name);
			winnerName.setForeground(Color.RED);
		}
			
		this.add(winnerName,BorderLayout.CENTER);
		this.add(gameOver,BorderLayout.NORTH);
		this.add(closeB,BorderLayout.SOUTH);
		
		this.revalidate();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==closeB) {
				this.setVisible(false);
				this.dispose();
			}
		
	}

}
