package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Game;
import engine.Player;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import model.world.Champion;

public class ChampionSelection   extends JFrame implements ActionListener{
	
	private static Player Player1 = new Player(PlayerNameFrame.getPlayer1());
	private static Player Player2 = new Player(PlayerNameFrame.getPlayer2());
	private static Game game = new Game (Player1,Player2);
	
	
	JPanel ChampionGrid = new JPanel();
	JPanel firstPlayerPanel = new JPanel();
	JPanel secondPlayerPanel = new JPanel();
	
	ArrayList<JButton> buttons = new ArrayList<>();
	ArrayList<JButton> firstButtons = new ArrayList<>();
	ArrayList<JButton> secondButtons = new ArrayList<>();
	
	JButton playB = new JButton();
	
	JPanel selectLeader = new JPanel();
	JPanel teamVsP = new JPanel();
	JPanel ChampionSelectionP = new JPanel();
	
	JButton p1champ1 = new JButton();
	JButton p1champ2 = new JButton();
	JButton p1champ3 = new JButton();
	
	JButton p2champ1 = new JButton();
	JButton p2champ2 = new JButton();
	JButton p2champ3 = new JButton();
	
	JLabel avengersBlue = new JLabel(new ImageIcon("ablue1.png"));
	JLabel ChampionSelectionL = new JLabel(new ImageIcon("pickchamp.png"));
	JLabel avengersRed = new JLabel(new ImageIcon("ared.png"));

	
	public ChampionSelection() throws IOException {
		
		game.loadAbilities("Abilities.csv");
		game.loadChampions("Champions.csv");
		
		
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Marvel Ultimate War");
		this.setIconImage(new ImageIcon("GameIcon.jpeg").getImage());
		
		
		
		
		ChampionSelectionP.setLayout(new BorderLayout());
		ChampionSelectionP.setBackground(Color.BLACK);
		ChampionSelectionP.add(avengersBlue,BorderLayout.WEST);
		ChampionSelectionP.add(ChampionSelectionL,BorderLayout.CENTER);
		ChampionSelectionP.add(avengersRed,BorderLayout.EAST);
		
		
		JButton captianAmericaB =  new JButton();
		captianAmericaB.setName("Captain America");
		captianAmericaB.addActionListener(this);
		JButton deadpoolB =  new JButton();
		deadpoolB.setName("Deadpool");
		deadpoolB.addActionListener(this);
		JButton drStrangeB =  new JButton();
		drStrangeB.setName("Dr Strange");
		drStrangeB.addActionListener(this);
		JButton electroB =  new JButton();
		electroB.setName("Electro");
		electroB.addActionListener(this);
		JButton ghostRiderB =  new JButton();
		ghostRiderB.setName("Ghost Rider");
		ghostRiderB.addActionListener(this);
		JButton helaB =  new JButton();
		helaB.setName("Hela");
		helaB.addActionListener(this);
		JButton hulkB=  new JButton();
		hulkB.setName("Hulk");
		hulkB.addActionListener(this);
		JButton iceManB=  new JButton();
		iceManB.setName("Iceman");
		iceManB.addActionListener(this);
		JButton ironManB=  new JButton();
		ironManB.setName("Ironman");
		ironManB.addActionListener(this);
		JButton lokiB=  new JButton();
		lokiB.setName("Loki");
		lokiB.addActionListener(this);
		JButton quickSilverB=  new JButton();
		quickSilverB.setName("Quicksilver");
		quickSilverB.addActionListener(this);
		JButton spiderManB=  new JButton();
		spiderManB.setName("Spiderman");
		spiderManB.addActionListener(this);
		JButton thorB=  new JButton();
		thorB.setName("Thor");
		thorB.addActionListener(this);
		JButton venomB=  new JButton();
		venomB.setName("Venom");
		venomB.addActionListener(this);
		JButton yellowJackB=  new JButton();
		yellowJackB.setName("Yellow Jacket");
		yellowJackB.addActionListener(this);
		
		ImageIcon captianAmericaI = new ImageIcon("captainamericaa.png");
		ImageIcon deadpoolI = new ImageIcon("deadpool.png");
		ImageIcon drStrangeI = new ImageIcon("dr starnge .png");
		ImageIcon electroI = new ImageIcon("electro.png");
		ImageIcon ghostRiderI = new ImageIcon("ghost rider.png");
		ImageIcon helaI = new ImageIcon("hela.png");
		ImageIcon hulkI = new ImageIcon("hulk.png");
		ImageIcon iceManI = new ImageIcon("ice man.png");
		ImageIcon ironManI = new ImageIcon("ironman.png");
		ImageIcon lokiI = new ImageIcon("loki.png");
		ImageIcon quickSilverI = new ImageIcon("quicksilver.png");
		ImageIcon spiderManI = new ImageIcon("spiderman.png");
		ImageIcon thorI = new ImageIcon("thor.png");
		ImageIcon venomI = new ImageIcon("venom.png");
		ImageIcon yellowJackI = new ImageIcon("yellow jack.png");
		
		 captianAmericaB.setIcon(captianAmericaI);
		 deadpoolB.setIcon(deadpoolI);
		 drStrangeB.setIcon(drStrangeI);
		 electroB.setIcon(electroI);
		 ghostRiderB.setIcon(ghostRiderI);
		 helaB.setIcon(helaI);
		 hulkB.setIcon(hulkI);
		 iceManB.setIcon(iceManI);
		 ironManB.setIcon(ironManI);
		 lokiB.setIcon(lokiI);
		 quickSilverB.setIcon(quickSilverI);
		 spiderManB.setIcon(spiderManI);
		 thorB.setIcon(thorI);
		 venomB.setIcon(venomI);
		 yellowJackB.setIcon(yellowJackI);
		 
		 
		 
		
		
		
		
		ChampionGrid.setLayout(new GridLayout(3,5,5,5));
		ChampionGrid.setBackground(Color.BLACK);
		ChampionGrid.add(captianAmericaB);
		ChampionGrid.add(deadpoolB);
		ChampionGrid.add(drStrangeB);
		ChampionGrid.add(electroB);
		ChampionGrid.add(ghostRiderB);
		ChampionGrid.add(helaB);
		ChampionGrid.add(hulkB);
		ChampionGrid.add(iceManB);
		ChampionGrid.add(ironManB);
		ChampionGrid.add(lokiB);
		ChampionGrid.add(quickSilverB);
		ChampionGrid.add(spiderManB);
		ChampionGrid.add(thorB);
		ChampionGrid.add(venomB);
		ChampionGrid.add(yellowJackB);
		
		
		
		firstPlayerPanel.setLayout(new GridLayout(3,1,5,5));
		secondPlayerPanel.setLayout(new GridLayout(3,1,5,5));
		
		firstPlayerPanel.setBackground(Color.BLACK);
		secondPlayerPanel.setBackground(Color.BLACK);
		
		JLabel one = new JLabel("1st Champion");
		JLabel two = new JLabel("2nd Champion");
		JLabel three = new JLabel("3rd Champion");
		
		JLabel one2 = new JLabel("1st Champion");
		JLabel two2 = new JLabel("2nd Champion");
		JLabel three2 = new JLabel("3rd Champion");
		
		one.setForeground(Color.WHITE);
		two.setForeground(Color.WHITE);
		three.setForeground(Color.WHITE);
		
		one2.setForeground(Color.WHITE);
		two2.setForeground(Color.WHITE);
		three2.setForeground(Color.WHITE);
		
		
		
		
		p1champ1.addActionListener(this);
		p1champ2.addActionListener(this);
		p1champ3.addActionListener(this);
		
		p2champ1.addActionListener(this);
		p2champ2.addActionListener(this);
		p2champ3.addActionListener(this);
		
		firstButtons.add(p1champ1);
		firstButtons.add(p1champ2);
		firstButtons.add(p1champ3);
		
		secondButtons.add(p2champ1);
		secondButtons.add(p2champ2);
		secondButtons.add(p2champ3);
		
		
		
		p1champ1.add(one);
		p1champ2.add(two);
		p1champ3.add(three);
		
		p2champ1.add(one2);
		p2champ2.add(two2);
		p2champ3.add(three2);
		
		for(int i =0 ; i <3;i++) {
			firstButtons.get(i).setBackground(new Color(9,20,60));
			secondButtons.get(i).setBackground(new Color(170,1,20));
			firstButtons.get(i).setPreferredSize(new Dimension(350,350));
			secondButtons.get(i).setPreferredSize(new Dimension(350,350));
			firstButtons.get(i).setFocusable(false);
			secondButtons.get(i).setFocusable(false);
		}
		
		
		
		
		
		
		firstPlayerPanel.add(p1champ1);
		firstPlayerPanel.add(p1champ2);
		firstPlayerPanel.add(p1champ3);
		
		secondPlayerPanel.add(p2champ1);
		secondPlayerPanel.add(p2champ2);
		secondPlayerPanel.add(p2champ3);
		
		ImageIcon playI = new ImageIcon("playB.png");
		playB.setBackground(Color.BLACK);
		playB.addActionListener(this);
		playB.setFocusable(false);
		playB.setEnabled(false);
		playB.setIcon(playI);
		JPanel playP = new JPanel();
		playP.setBackground(Color.BLACK);
		playP.add(playB);
		
		
		
		
		selectLeader.setVisible(false);
		
		this.add(ChampionSelectionP,BorderLayout.NORTH);
		this.add(firstPlayerPanel, BorderLayout.WEST);
		this.add(secondPlayerPanel, BorderLayout.EAST);
		this.add(ChampionGrid,BorderLayout.CENTER);
		this.add(playP,BorderLayout.SOUTH);
		//this.add(selectLeader,BorderLayout.CENTER);
		
		
		buttons.add(captianAmericaB);
		buttons.add(deadpoolB);
		buttons.add(drStrangeB);
		buttons.add(electroB);
		buttons.add(ghostRiderB);
		buttons.add(helaB);
		buttons.add(hulkB);
		buttons.add(iceManB);
		buttons.add(ironManB);
		buttons.add(lokiB);
		buttons.add(quickSilverB);
		buttons.add(spiderManB);
		buttons.add(thorB);
		buttons.add(venomB);
		buttons.add(yellowJackB);
		
		for(int i =0; i<buttons.size();i++) {
			 buttons.get(i).setBackground(Color.BLACK);
			 buttons.get(i).setFocusable(false);
			 buttons.get(i).setToolTipText(getChampionAttributes( buttons.get(i).getName()));
			
		 }
		this.validate();
		this.repaint();
	}
	
	public String getChampionAttributes(String name) {
		
		String attributes= "";
		String champName = "";
		String maxHP = "";
		String mana="";
		String actionPoints="";
		String speed="";
		String attackRange="";
		String attackDamage="";
		
		String ability1="";
		String ability2="";
		String ability3="";
		
	
		for(int j =0 ;j<game.getAvailableChampions().size();j++) {
			if(name.equals(game.getAvailableChampions().get(j).getName())) {
				Champion c =game.getAvailableChampions().get(j);
				
				 ability1 = "Ability 1 :" + c.getAbilities().get(0).getName() ;
			     ability2 = "Ability 2 :" + c.getAbilities().get(1).getName() ;
			     ability3 = "Ability 3 :" + c.getAbilities().get(2).getName() ; 
			   
			      champName= "Name: " + c.getName()  ;
				  maxHP = "MaxHP: "+ c.getMaxHP()  ;
				  mana ="Mana: "+c.getMana()  ;
				  actionPoints="Action Points: "+c.getMaxActionPointsPerTurn();
				  speed="Speed: "+c.getSpeed() ;
				  attackRange ="Attack Range: "+c.getAttackRange();
				  attackDamage =	"Attack Damage: "+c.getAttackDamage();

	 attributes = "<html>" + champName + "<br>" + "<br>" + ability1 + "<br>" + ability2 + "<br>" + ability3 + "<br>" + maxHP + "<br>" + mana + "<br>" +
										actionPoints + "<br>" + speed + "<br>" + attackRange + "<br>" + attackDamage + "<br> </html>" ;
				  
			}
			
		}
		
	
	
		return attributes;
		
}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	    	for(int i =0; i<buttons.size();i++) {
	    	if(game.getFirstPlayer().getTeam().size()==3 && game.getSecondPlayer().getTeam().size()==3) {
	    		ChampionGrid.setVisible(false);
	    		JLabel leader= new JLabel(new ImageIcon("Choose your leader1.png"));
	    		selectLeader.add(leader);
	    		selectLeader.setBackground(Color.BLACK);
	    		this.add(selectLeader,BorderLayout.CENTER);
	    		selectLeader.setVisible(true);
	    		break;	
	    		}
	    	else if ( game.getFirstPlayer().getTeam().size()==game.getSecondPlayer().getTeam().size()) {
		    	if(e.getSource()==buttons.get(i)) {
		    		for (int j=0 ; j<game.getAvailableChampions().size();j++) {
		    			if(game.getAvailableChampions().get(j).getName().equals(buttons.get(i).getName())) {
		    				buttons.get(i).setEnabled(false);
		    				game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(j));
		    				firstButtons.get(0).setIcon(buttons.get(i).getIcon());
		    				firstButtons.get(0).setToolTipText(getChampionAttributes(game.getAvailableChampions().get(j).getName()));
	    					firstButtons.get(0).setName(game.getAvailableChampions().get(j).getName());
	    					firstButtons.remove(firstButtons.get(0));
	    					
		    			}
		    		}
		    		
    					
		    	}
		    }
	    	
	    
	    	  else if (game.getSecondPlayer().getTeam().size()< game.getFirstPlayer().getTeam().size()) {
		    	if(e.getSource()==buttons.get(i)) {
		    		for (int j=0 ; j<game.getAvailableChampions().size();j++) {
		    			if(game.getAvailableChampions().get(j).getName().equals(buttons.get(i).getName())) {
		    				buttons.get(i).setEnabled(false);
		    				game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(j));
		    				secondButtons.get(0).setIcon(buttons.get(i).getIcon());
		    				secondButtons.get(0).setToolTipText(getChampionAttributes(game.getAvailableChampions().get(j).getName()));
	    					secondButtons.get(0).setName(game.getAvailableChampions().get(j).getName());
	    					secondButtons.remove(secondButtons.get(0));
		    				
		    			}
		    		}
		    	}
		    }
	  
	    	  this.validate();
	    }
	    	if(e.getSource()==p1champ1) {
	    		String name = p1champ1.getName();
    			for(int i=0 ; i<game.getFirstPlayer().getTeam().size();i++) {
    				if(name.equals(game.getFirstPlayer().getTeam().get(i).getName()) ) {
    					Champion c =game.getFirstPlayer().getTeam().get(i);
    					game.getFirstPlayer().setLeader(c);
    					p1champ1.setBackground(new Color(137, 113, 50));
    					p1champ2.setBackground(new Color(9,20,60));
    					p1champ3.setBackground(new Color(9,20,60));
    				}
    			}	
	    		
	    	}
	    	
	    	if(e.getSource()==p1champ2) {
	    		String name = p1champ2.getName();
    			for(int i=0 ; i<game.getFirstPlayer().getTeam().size();i++) {
    				if(name.equals(game.getFirstPlayer().getTeam().get(i).getName()) ) {
    					Champion c =game.getFirstPlayer().getTeam().get(i);
    					game.getFirstPlayer().setLeader(c);
    					p1champ2.setBackground(new Color(137, 113, 50));
    					p1champ1.setBackground(new Color(9,20,60));
    					p1champ3.setBackground(new Color(9,20,60));
    				}
    			}	
	    		
	    	}


	    	if(e.getSource()==p1champ3) {
	    		String name = p1champ3.getName();
    			for(int i=0 ; i<game.getFirstPlayer().getTeam().size();i++) {
    				if(name.equals(game.getFirstPlayer().getTeam().get(i).getName()) ) {
    					Champion c =game.getFirstPlayer().getTeam().get(i);
    					game.getFirstPlayer().setLeader(c);
    					p1champ3.setBackground(new Color(137, 113, 50));
    					p1champ2.setBackground(new Color(9,20,60));
    					p1champ1.setBackground(new Color(9,20,60));
    				}
    			}	
	
	    	}


	    	if(e.getSource()==p2champ1) {
	    		String name = p2champ1.getName();
    			for(int i=0 ; i<game.getSecondPlayer().getTeam().size();i++) {
    				if(name.equals(game.getSecondPlayer().getTeam().get(i).getName()) ) {
    					Champion c =game.getSecondPlayer().getTeam().get(i);
    					game.getSecondPlayer().setLeader(c);
    					p2champ1.setBackground(new Color(137, 113, 50));
    					p2champ2.setBackground(new Color(170,1,20));
    					p2champ3.setBackground(new Color(170,1,20));
    				}
    			}	
	
	    	}



	    	if(e.getSource()==p2champ2) {
	    		String name = p2champ2.getName();
    			for(int i=0 ; i<game.getSecondPlayer().getTeam().size();i++) {
    				if(name.equals(game.getSecondPlayer().getTeam().get(i).getName()) ) {
    					Champion c =game.getSecondPlayer().getTeam().get(i);
    					game.getSecondPlayer().setLeader(c);
    					p2champ2.setBackground(new Color(137, 113, 50));
    					p2champ1.setBackground(new Color(170,1,20));
    					p2champ3.setBackground(new Color(170,1,20));
    				}
    			}	
	
	    	}


	    	if(e.getSource()==p2champ3) {
	    		String name = p2champ3.getName();
    			for(int i=0 ; i<game.getSecondPlayer().getTeam().size();i++) {
    				if(name.equals(game.getSecondPlayer().getTeam().get(i).getName()) ) {
    					Champion c =game.getSecondPlayer().getTeam().get(i);
    					game.getSecondPlayer().setLeader(c);
    					p2champ3.setBackground(new Color(137, 113, 50));
    					p2champ1.setBackground(new Color(170,1,20));
    					p2champ2.setBackground(new Color(170,1,20));
    				}
    			}	
	
	    	}
	    	
	    	if(game.getFirstPlayer().getLeader()!=null && game.getSecondPlayer().getLeader()!=null) {
	    		
	    		selectLeader.setVisible(false);
	    		
	    		JLabel teams= new JLabel(new ImageIcon("teams.jpg"));
	    		teamVsP.add(teams);
	    		teamVsP.setBackground(Color.BLACK);
	    		this.add(teamVsP,BorderLayout.CENTER);
	    		teamVsP.setVisible(true);
	    		
	    		playB.setEnabled(true);
	    		
	    	}
	    	
	    	if(e.getSource()==playB) {
	    		this.dispose();
	        	new GameFrame().setVisible(true);
			
	    	}
			
	    	
	    	 
	    		 
	    	 
		
	}
	
	public static  Game getGame() {
		return game;
	}
	
	
}

