package view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.*;

import engine.Game;
import engine.GameListener;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Damageable;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;
import view.ChampionSelection;

public class GameFrame  extends JFrame implements ActionListener  {

	
	static Game game = ChampionSelection.getGame();
	static Player winner;
	
	
	JPanel boardP = new JPanel();
	JButton[][] board = new JButton[5][5];
	ArrayList<JLabel> championIcons = new ArrayList<>();
	
	
	JPanel topPanel =  new JPanel();
	JPanel turnOrderP = new JPanel();
	JPanel turnOrderPL = new JPanel();
	JPanel currentChampionP1  = new JPanel();
	JPanel currentChampionP2  = new JPanel();
	
	JPanel nameAndLeader1 = new JPanel();
	JPanel nameAndLeader2 = new JPanel();

	JPanel functionP= new JPanel();
	JPanel attackP = new JPanel();
	JPanel moveP = new JPanel();
	
	JPanel attackMainP = new JPanel();
	
	JPanel moveMainP = new JPanel();
	
	JPanel ability1P = new JPanel();
	JPanel ability2P = new JPanel();
	JPanel ability3P = new JPanel();
			
	JPanel ability1MainP = new JPanel();
	JPanel ability2MainP = new JPanel();
	JPanel ability3MainP = new JPanel();
	
	
	
	JButton ability1B = new JButton();
	JButton ability2B = new JButton();
	JButton ability3B = new JButton();
	
	JButton ability1UpB = new JButton();
	JButton ability1DownB = new JButton();
	JButton ability1RightB = new JButton();
	JButton ability1LeftB = new JButton();
	
	JButton ability2UpB = new JButton();
	JButton ability2DownB = new JButton();
	JButton ability2RightB = new JButton();
	JButton ability2LeftB = new JButton();
	
	JButton ability3UpB = new JButton();
	JButton ability3DownB = new JButton();
	JButton ability3RightB = new JButton();
	JButton ability3LeftB = new JButton();
	
	
	
	JButton leaderAbilityB = new JButton(new ImageIcon("public/leader_ability.png"));
	JButton attackUpB = new JButton("Attack Up");
	JButton attackDownB = new JButton("Attack Down");
	JButton attackRightB = new JButton("Attack Right");
	JButton attackLeftB = new JButton("Attack Left");
	
	JButton moveUpB = new JButton("Move Up");
	JButton moveDownB = new JButton("Move Down");
	JButton moveRightB = new JButton("Move Right");
	JButton moveLeftB = new JButton("Move Left");
	
	
	JButton endTurnB = new JButton(new ImageIcon("public/end_turn.png"));
	
	JButton abilityUpB= new JButton("Ability Up");
	JButton abilityDownB =  new JButton("Ability Up");
	JButton abilityRightB =  new JButton("Ability Up");
	JButton abilityLeftB =  new JButton("Ability Up");
	
	
	JLabel leaderAbilityUsed1= new JLabel("Leader Ability not used yet");
	JLabel leaderAbilityUsed2= new JLabel("Leader Ability not used yet");
	JLabel championTurnsL= new JLabel(new ImageIcon("public/champions_turn1.png"));
	JLabel championAttributesL = new JLabel();
	
	ImageIcon coverf;
	
	Object[][] boardtemp=  game.getBoard();
	
	
	ArrayList<Champion> championsTurn = new ArrayList<>();
	
	JPanel sliderSubmit = new JPanel();
	
	JPanel slidersP = new JPanel();
	
	JSlider targetX =  new JSlider(0,4,2);
	JSlider targetY =  new JSlider(0,4,2);
	JButton submitB = new JButton("CAST");
	int n =0;
	public GameFrame()   {
		
		
		//Frame
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Marvel Ultimate War");
		this.setIconImage(new ImageIcon("public/GameIcon.jpeg").getImage());
		this.setBackground(Color.BLACK);
		this.repaint();
	
		
		//Panels
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Color.BLACK);
		
		
		boardP.setLayout(new GridLayout(5,5,10,10));
		boardP.setBackground(Color.BLACK);
		boardP.setPreferredSize(new Dimension(750,750));
		
		
		turnOrderP.setLayout(new GridLayout(1,6,3,3));
		turnOrderP.setBackground(Color.BLACK);
		turnOrderP.setPreferredSize(new Dimension(700,150));
		
		turnOrderPL.setLayout(new FlowLayout());
		turnOrderPL.setPreferredSize(new Dimension(750,150));
		turnOrderPL.setBackground(Color.BLACK);
		
		
		functionP.setLayout(new GridLayout(1,8,5,5));
		functionP.setBackground(Color.BLACK);
		functionP.setPreferredSize(new Dimension(750,150));
	
		attackMainP.setLayout(new GridLayout(2,1));
		attackMainP.setBackground(Color.BLACK);
		
		attackP.setLayout(new BorderLayout());
		attackP.setBackground(Color.BLACK);
		attackP.setVisible(true);
		
		moveMainP.setLayout(new GridLayout(2,1));
		moveMainP.setBackground(Color.BLACK);
		
		moveP.setLayout(new BorderLayout());
		moveP.setBackground(Color.BLACK);
		moveP.setVisible(true);
		
		currentChampionP1.setLayout(new GridLayout(3,1,5,5));
		currentChampionP2.setLayout(new GridLayout(3,1,5,5));
		
		nameAndLeader1.setLayout(new GridLayout(2,1,5,5));
		nameAndLeader1.setBackground(Color.BLACK);
		nameAndLeader2.setLayout(new GridLayout(2,1,5,5));
		nameAndLeader2.setBackground(Color.BLACK);
		
		
		//JPanel boardFestek = new JPanel();
		//boardFestek.setLayout(new GridLayout(5,5));
		JLabel boardPic = new JLabel(new ImageIcon("public/BoardPic1.png"));
		boardPic.setBackground(Color.BLACK);
		
		slidersP.setLayout(new BorderLayout());
		slidersP.setBackground(Color.BLACK);
		sliderSubmit.setLayout(new GridLayout(1,2,3,3));
		sliderSubmit.setBackground(Color.BLACK);
		
		targetX.setBackground(Color.BLACK);
		targetX.setPaintTrack(true);
		targetX.setMajorTickSpacing(1);
		targetX.setOrientation(SwingConstants.VERTICAL);
		targetX.setPaintLabels(true);
		targetX.setForeground(Color.BLUE);
		
		targetY.setBackground(Color.BLACK);
		targetY.setPaintTrack(true);
		targetY.setMajorTickSpacing(1);
		targetY.setOrientation(SwingConstants.HORIZONTAL);
		targetY.setPaintLabels(true);
		targetY.setForeground(Color.BLUE);
		
		slidersP.add(boardPic,BorderLayout.CENTER);
		slidersP.add(targetX,BorderLayout.WEST);
		slidersP.add(targetY,BorderLayout.SOUTH);
		sliderSubmit.add(slidersP);
		sliderSubmit.add(submitB);
		//Abilities Panels
		
		ability1MainP.setLayout(new GridLayout(2,1));
		ability1MainP.setBackground(Color.BLACK);
		
		
		ability1P.setLayout(new BorderLayout());
		ability1P.setBackground(Color.BLACK);
		
		ability1P.add(ability1UpB,BorderLayout.NORTH);
		ability1P.add(ability1DownB,BorderLayout.SOUTH);
		ability1P.add(ability1B,BorderLayout.CENTER);
		ability1P.add(ability1RightB,BorderLayout.EAST);
		ability1P.add(ability1LeftB,BorderLayout.WEST);
		
		
		ability1MainP.add(new JLabel(new ImageIcon("public/orb.png")));
		ability1MainP.add(ability1P);
		
		///////////////////////////////////////////////////
		
		ability2MainP.setLayout(new GridLayout(2,1));
		ability2MainP.setBackground(Color.BLACK);
		
		ability2P.setLayout(new BorderLayout());
		ability2P.setBackground(Color.BLACK);
		
		ability2P.add(ability2UpB,BorderLayout.NORTH);
		ability2P.add(ability2DownB,BorderLayout.SOUTH);
		ability2P.add(ability2B,BorderLayout.CENTER);
		ability2P.add(ability2RightB,BorderLayout.EAST);
		ability2P.add(ability2LeftB,BorderLayout.WEST);
		
		ability2MainP.add(new JLabel(new ImageIcon("public/orb.png")));
		ability2MainP.add(ability2P);
		
		////////////////////////////////
		
		
		ability3MainP.setLayout(new GridLayout(2,1));
		ability3MainP.setBackground(Color.BLACK);
		
		ability3P.setLayout(new BorderLayout());
		ability3P.setBackground(Color.BLACK);
		
		ability3P.add(ability3UpB,BorderLayout.NORTH);
		ability3P.add(ability3DownB,BorderLayout.SOUTH);
		ability3P.add(ability3B,BorderLayout.CENTER);
		ability3P.add(ability3RightB,BorderLayout.EAST);
		ability3P.add(ability3LeftB,BorderLayout.WEST);
	
		ability3MainP.add(new JLabel(new ImageIcon("public/orb.png")));
		ability3MainP.add(ability3P);
	////////////////////////////////////////////
		
		//Buttons
		ability1UpB.addActionListener(this);
		ability1DownB.addActionListener(this);
		ability1B.addActionListener(this);
		ability1RightB.addActionListener(this);
		ability1LeftB.addActionListener(this);
		
		ability2UpB.addActionListener(this);
		ability2DownB.addActionListener(this);
		ability2B.addActionListener(this);
		ability2RightB.addActionListener(this);
		ability2LeftB.addActionListener(this);
		
		ability3UpB.addActionListener(this);
		ability3DownB.addActionListener(this);
		ability3B.addActionListener(this);
		ability3RightB.addActionListener(this);
		ability3LeftB.addActionListener(this);
		
		ability1UpB.setEnabled(false);
		ability1DownB.setEnabled(false);
		ability1RightB.setEnabled(false);
		ability1LeftB.setEnabled(false);
		
		ability2UpB.setEnabled(false);
		ability2DownB.setEnabled(false);
		ability2RightB.setEnabled(false);
		ability2LeftB.setEnabled(false);
		
		ability3UpB.setEnabled(false);
		ability3DownB.setEnabled(false);
		ability3RightB.setEnabled(false);
		ability3LeftB.setEnabled(false);
		
		
		
	
		attackUpB.addActionListener(this);
		attackDownB.addActionListener(this);
		attackRightB.addActionListener(this);
		attackLeftB.addActionListener(this);
		
		attackUpB.setBackground(new Color(255,103,0));
		attackDownB.setBackground(new Color(255,103,0));
		attackRightB.setBackground(new Color(255,103,0));
		attackLeftB.setBackground(new Color(255,103,0));
	
		moveUpB.addActionListener(this);
		moveDownB.addActionListener(this);
		moveRightB.addActionListener(this);
		moveLeftB.addActionListener(this);
		
		moveUpB.setBackground(new Color(34,50,110));
		moveDownB.setBackground(new Color(34,50,110));
		moveRightB.setBackground(new Color(34,50,110));
		moveLeftB.setBackground(new Color(34,50,110));
		
		moveUpB.setForeground(Color.WHITE);
		moveDownB.setForeground(Color.WHITE);
		moveRightB.setForeground(Color.WHITE);
		moveLeftB.setForeground(Color.WHITE);
		
		leaderAbilityB.setBackground(Color.BLACK);
		endTurnB.setBackground(Color.BLACK);
		endTurnB.setFocusable(false);
		
		endTurnB.addActionListener(this);
		ability1B.addActionListener(this);
		ability2B.addActionListener(this);
		ability3B.addActionListener(this);
		leaderAbilityB.addActionListener(this);
		
		submitB.addActionListener(this);
		submitB.setBackground(Color.BLUE);
		submitB.setForeground(Color.WHITE);
		
		attackP.add(attackUpB,BorderLayout.NORTH);
		attackP.add(attackDownB,BorderLayout.SOUTH);
		attackP.add(attackRightB,BorderLayout.EAST);
		attackP.add(attackLeftB,BorderLayout.WEST);
		
		moveP.add(moveUpB,BorderLayout.NORTH);
		moveP.add(moveDownB,BorderLayout.SOUTH);
		moveP.add(moveRightB,BorderLayout.EAST);
		moveP.add(moveLeftB,BorderLayout.WEST);
		
		
		
		attackMainP.add(new JLabel(new ImageIcon("public/attack2.png")));
		attackMainP.add(attackP);
		
		moveMainP.add(new JLabel(new ImageIcon("public/Arrows.png")));
		moveMainP.add(moveP);
		
		functionP.add(attackMainP);
		functionP.add(moveMainP);
		functionP.add(ability1MainP);
		functionP.add(ability2MainP);
		functionP.add(ability3MainP);
		functionP.add(leaderAbilityB);
		functionP.add(endTurnB);
		
		
		

		
		game.placeChampions();
		
		
		
		//ImageIcons
		ImageIcon captianamericaf = new ImageIcon("public/captainamericaf.png");
		ImageIcon deadpoolf = new ImageIcon("public/deadpoolf.png");
		ImageIcon drstrangef = new ImageIcon("public/drstrangef.png");
		ImageIcon electrof = new ImageIcon("public/electrof.png");
		ImageIcon ghostriderf = new ImageIcon("public/ghostriderf.png");
		ImageIcon helaf = new ImageIcon("public/helaf.png");
		ImageIcon hulkf = new ImageIcon("public/hulkf.png");
		ImageIcon icemanf = new ImageIcon("public/iceManf.png");
		ImageIcon ironmanf = new ImageIcon("public/ironManf.png");
		ImageIcon lokif = new ImageIcon("public/lokif.png");
		ImageIcon quicksilverf = new ImageIcon("public/quickSilverf.png");
		ImageIcon spidermanf = new ImageIcon("public/spiderManf.png");
		ImageIcon thorf = new ImageIcon("public/thorf.png");
		ImageIcon venomf = new ImageIcon("public/venomf.png");
		ImageIcon yellowjacketf = new ImageIcon("public/yellowjackf.png");
		
		 coverf= new ImageIcon("public/cover.png");
		
		JLabel captainamerical = new JLabel (captianamericaf);
		JLabel deadpooll = new JLabel (deadpoolf);
		JLabel drstrangel = new JLabel (drstrangef);
		JLabel electrol = new JLabel (electrof);
		JLabel ghostriderl = new JLabel (ghostriderf);
		JLabel helal = new JLabel (helaf);
		JLabel hulkl = new JLabel (hulkf);
		JLabel icemanl = new JLabel (icemanf);
		JLabel ironmanl = new JLabel (ironmanf);
		JLabel lokil = new JLabel (lokif);
		JLabel quicksilverl = new JLabel (quicksilverf);
		JLabel spidermanl = new JLabel (spidermanf);
		JLabel thorl = new JLabel (thorf);
		JLabel venoml  = new JLabel (venomf);
		JLabel yellowjacketl = new JLabel (yellowjacketf);
		
		
		JLabel p1name = new JLabel(PlayerNameFrame.getPlayer1());
		p1name.setFont(new Font("MV BOlI",Font.BOLD,50));
		p1name.setForeground(new Color(9,20,60));
		JLabel p2name =new JLabel(PlayerNameFrame.getPlayer2());
		p2name.setFont(new Font("MV BOlI",Font.BOLD,50));
		p2name.setForeground(new Color(170,1,20));
		
		leaderAbilityUsed1.setForeground(Color.GREEN);
		leaderAbilityUsed1.setFont(new Font(null,Font.BOLD,10));
		leaderAbilityUsed2.setForeground(Color.GREEN);
		leaderAbilityUsed2.setFont(new Font(null,Font.BOLD,10));
		
		
		
		
		captainamerical.setName("Captain America");
		deadpooll.setName("Deadpool");
		drstrangel.setName("Dr Strange");
		electrol.setName("Electro");
		ghostriderl.setName("Ghost Rider");
		helal.setName("Hela");
		hulkl.setName("Hulk");
		icemanl.setName("Iceman");
		ironmanl.setName("Ironman");
		lokil.setName("Loki");
		quicksilverl.setName("Quicksilver");
		spidermanl.setName("Spiderman");
		thorl.setName("Thor");
		venoml.setName("Venom");
		yellowjacketl.setName("Yellow Jacket");
		
		championIcons.add(captainamerical);
		championIcons.add(deadpooll);
		championIcons.add(drstrangel);
		championIcons.add(electrol);
		championIcons.add(ghostriderl);
		championIcons.add(helal);
		championIcons.add(hulkl);
		championIcons.add(icemanl);
		championIcons.add(ironmanl);
		championIcons.add(lokil);
		championIcons.add(quicksilverl);
		championIcons.add(spidermanl);
		championIcons.add(thorl);
		championIcons.add(venoml);
		championIcons.add(yellowjacketl);
		
		
		nameAndLeader1.add(p1name);
		nameAndLeader1.add(leaderAbilityUsed1);
		nameAndLeader2.add(p2name);
		nameAndLeader2.add(leaderAbilityUsed2);
		
		turnOrderPL.add(championTurnsL);
		turnOrderPL.add(turnOrderP);
		
		topPanel.add(nameAndLeader1,BorderLayout.WEST);
		topPanel.add(turnOrderPL,BorderLayout.CENTER);
		topPanel.add(nameAndLeader2,BorderLayout.EAST);
		
		
		
		
		
		
		for(int x=4 ;x>=0;x--) {
			for(int y =0;y<5;y++) {
				JButton cell = new JButton();
				board[x][y]=cell;
				boardP.add(cell);
				cell.addActionListener(this);
				cell.setBackground(Color.GRAY);
			}
		}
		
		for(int i =0 ; i<championIcons.size();i++) {
			for(int j =0 ;j<game.getFirstPlayer().getTeam().size();j++) {
				String name =championIcons.get(i).getName();
				if(name.equals(game.getFirstPlayer().getTeam().get(j).getName())) {
					 int x=(int) game.getFirstPlayer().getTeam().get(j).getLocation().getX();
					 int y=(int) game.getFirstPlayer().getTeam().get(j).getLocation().getY();
					
					board[x][y].setIcon(championIcons.get(i).getIcon());
					board[x][y].setToolTipText(getCurrentAttributes(name));
					board[x][y].setBackground(new Color(9,20,60));
					
					championAttributesL = new JLabel(getCurrentAttributes(game.getFirstPlayer().getTeam().get(j).getName()));
					championAttributesL.setForeground(Color.WHITE);
					currentChampionP1.add(championAttributesL);
					currentChampionP1.setBackground(new Color(9,20,60));
					currentChampionP1.add( new JLabel (championIcons.get(i).getIcon()));
					
					
				
				}
			}
			
			for(int j =0 ;j<game.getSecondPlayer().getTeam().size();j++) {
				String name =championIcons.get(i).getName();
				if(name.equals(game.getSecondPlayer().getTeam().get(j).getName())) {
					int x=(int) game.getSecondPlayer().getTeam().get(j).getLocation().getX();
					int y=(int) game.getSecondPlayer().getTeam().get(j).getLocation().getY();
					
					board[x][y].setIcon(championIcons.get(i).getIcon());
					board[x][y].setToolTipText(getCurrentAttributes(name));
					board[x][y].setBackground(new Color(170,1,20));
					
					championAttributesL = new JLabel(getCurrentAttributes(game.getSecondPlayer().getTeam().get(j).getName()));
					championAttributesL.setForeground(Color.WHITE);
					currentChampionP2.add(championAttributesL);
					
					currentChampionP2.setBackground(new Color(170,1,20));
					currentChampionP2.add( new JLabel (championIcons.get(i).getIcon()));
			
				}
			}
		}
		    ArrayList<Point> coversLocations =new ArrayList<>();
		    ArrayList<Cover> covers = new ArrayList<>();
		    boardtemp=game.getBoard();
			for(int x=4;x>=0;x--) {
				for(int y=0;y<5;y++) {
					if(boardtemp[x][y] instanceof Cover) {
						coversLocations.add(new Point(x,y));
						covers.add((Cover) boardtemp[x][y]);
					}
				}
			}
		   
		  for(int i =0 ; i<coversLocations.size();i++) {
				int x= (int) coversLocations.get(i).getX();
				int y= (int) coversLocations.get(i).getY();
				String coverHP =  "Cover's HP: " + ((Cover) covers.get(i)).getCurrentHP() ;
				
				board[x][y].setToolTipText(coverHP);
				board[x][y].setIcon(coverf);
				board[x][y].setBackground(Color.DARK_GRAY);
			}
		  
		  
		  for(int i =0 ;i<game.getFirstPlayer().getTeam().size();i++) {
			  game.getTurnOrder().insert(game.getFirstPlayer().getTeam().get(i));
		  }
		  for(int i =0 ;i<game.getSecondPlayer().getTeam().size();i++) {
			  game.getTurnOrder().insert(game.getSecondPlayer().getTeam().get(i));
		  }
		  
		  
		  for(int i=0;i< game.getTurnOrder().size();i++) {
				championsTurn.add((Champion)game.getTurnOrder().remove());
				i--;
			}
			for(int i =0 ; i<championsTurn.size();i++) {
				 game.getTurnOrder().insert(championsTurn.get(i));
			}
			
			updateChampionTurn();
			//game.loadAbilities("Abilities.csv");
			abilityName();
			
			this.add(boardP,BorderLayout.CENTER);
			this.add(topPanel,BorderLayout.NORTH);
			this.add(currentChampionP1,BorderLayout.WEST);
			this.add(currentChampionP2,BorderLayout.EAST);
			this.add(functionP,BorderLayout.SOUTH);
		
			
	
		
		   this.validate();
			this.repaint();
	}
	
	
	public void abilityName() {
		
		
		
		
		ability1UpB.setEnabled(false);
		ability1DownB.setEnabled(false);
		ability1RightB.setEnabled(false);
		ability1LeftB.setEnabled(false);
		ability1B.setEnabled(true);
		
		ability2UpB.setEnabled(false);
		ability2DownB.setEnabled(false);
		ability2RightB.setEnabled(false);
		ability2LeftB.setEnabled(false);
		ability2B.setEnabled(true);
		
		ability3UpB.setEnabled(false);
		ability3DownB.setEnabled(false);
		ability3RightB.setEnabled(false);
		ability3LeftB.setEnabled(false);
		ability3B.setEnabled(true);
		
		ability1UpB.setVisible(false);
		ability1DownB.setVisible(false);
		ability1RightB.setVisible(false);
		ability1LeftB.setVisible(false);
		
		ability2UpB.setVisible(false);
		ability2DownB.setVisible(false);
		ability2RightB.setVisible(false);
		ability2LeftB.setVisible(false);
		
		ability3UpB.setVisible(false);
		ability3DownB.setVisible(false);
		ability3RightB.setVisible(false);
		ability3LeftB.setVisible(false);
		
		ability1UpB.removeAll();
		ability1DownB.removeAll();
		ability1RightB.removeAll();
		ability1LeftB.removeAll();
		
		ability2UpB.removeAll();
		ability2DownB.removeAll();
		ability2RightB.removeAll();
		ability2LeftB.removeAll();
		
		ability3UpB.removeAll();
		ability3DownB.removeAll();
		ability3RightB.removeAll();
		ability3LeftB.removeAll();
		
		
		
		ability1B.removeAll();
		ability2B.removeAll();
		ability3B.removeAll();
		
		
		
		Champion c = game.getCurrentChampion();
		ArrayList<JButton> abilitiesButtons= new ArrayList<>();
		abilitiesButtons.add(ability1B);
		abilitiesButtons.add(ability2B);
		abilitiesButtons.add(ability3B);
		for(int i =0 ; i<abilitiesButtons.size();i++) {
			
			JLabel ab = new JLabel( c.getAbilities().get(i).getName());
			ab.setForeground(Color.BLACK);
			abilitiesButtons.get(i).add(ab);
			abilitiesButtons.get(i).setName(c.getAbilities().get(i).getName());
			String abilityAttributes = "" ;
			if(c.getAbilities().get(i) instanceof DamagingAbility) {
				DamagingAbility ability1 =(DamagingAbility) c.getAbilities().get(i);
				abilityAttributes = "<html>"+ "Ability Name :" +ability1.getName()+ ",  Ability Type : DamagingAbility" +"<br>"
						+ "AreaOfEffect :" + ability1.getCastArea()  + ",  Cast Range :" + ability1.getCastRange()
						+"<br>" + "Mana Cost : " + ability1.getManaCost()  + ",  Required Action Points :" + 
						ability1.getRequiredActionPoints() +"<br>" + "Current Cooldown :" + ability1.getCurrentCooldown()	
						 + ",  Base Cooldown :" + ability1.getBaseCooldown() +"<br>" + "Damage Amount :" + ability1.getDamageAmount()+ "</html>" ;
				abilitiesButtons.get(i).setToolTipText( abilityAttributes);
				abilitiesButtons.get(i).setBackground(new Color(127,0,0));
			}
			if(c.getAbilities().get(i) instanceof HealingAbility) {
				HealingAbility ability2 =(HealingAbility) c.getAbilities().get(i);
				abilityAttributes = "<html>"+ "Ability Name :" +ability2.getName()+ ",  Ability Type : HealingAbility" +"<br>"
						+ "AreaOfEffect :" + ability2.getCastArea()  + ",  Cast Range :" + ability2.getCastRange()
						+"<br>" + "Mana Cost : " + ability2.getManaCost()  + ",  Required Action Points :" + 
						ability2.getRequiredActionPoints() +"<br>" + "Current Cooldown :" + ability2.getCurrentCooldown()	
						 + ",  Base Cooldown :" + ability2.getBaseCooldown() +"<br>" + "Heal Amount :" + ability2.getHealAmount()+"</html>" ;
				
				abilitiesButtons.get(i).setToolTipText( abilityAttributes);
				abilitiesButtons.get(i).setBackground(new Color(255,211,0));
			}
			if(c.getAbilities().get(i) instanceof CrowdControlAbility) {
				CrowdControlAbility ability3 =(CrowdControlAbility) c.getAbilities().get(i);
				abilityAttributes = "<html>"+ "Ability Name :" +ability3.getName()+ ",  Ability Type : CrowdControlAbility" +"<br>"
						+ "AreaOfEffect :" + ability3.getCastArea()  + ",  Cast Range :" + ability3.getCastRange()
						+"<br>" + "Mana Cost : " + ability3.getManaCost()  + ",  Required Action Points :" + 
						ability3.getRequiredActionPoints() +"<br>" + "Current Cooldown :" + ability3.getCurrentCooldown()	
						 + ",  Base Cooldown :" + ability3.getBaseCooldown() +"<br>" + "Effect Name :" + ability3.getEffect().getName()  +
						  ",   Effect Duration"+  ability3.getEffect().getDuration() + "</html>" ;
	
				abilitiesButtons.get(i).setToolTipText( abilityAttributes);
				abilitiesButtons.get(i).setBackground(new Color(102,51,153));
			}
			
			
			if(c.getAbilities().get(0).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				ability1UpB.setEnabled(true);
				ability1DownB.setEnabled(true);
				ability1RightB.setEnabled(true);
				ability1LeftB.setEnabled(true);
				
				
				ability1UpB.setVisible(true);
				ability1DownB.setVisible(true);
				ability1RightB.setVisible(true);
				ability1LeftB.setVisible(true);
				
				ability1UpB.setBackground(new Color(34,50,110));
				ability1DownB.setBackground(new Color(34,50,110));
				ability1RightB.setBackground(new Color(34,50,110));
				ability1LeftB.setBackground(new Color(34,50,110));
				
				ability1UpB.setForeground(Color.WHITE);
				ability1DownB.setForeground(Color.WHITE);
				ability1RightB.setForeground(Color.WHITE);
				ability1LeftB.setForeground(Color.WHITE);
				
			
				ability1UpB.setName(c.getAbilities().get(0).getName());
				ability1DownB.setName(c.getAbilities().get(0).getName());
				ability1RightB.setName(c.getAbilities().get(0).getName());
				ability1LeftB.setName(c.getAbilities().get(0).getName());
				
				ability1UpB.setText(c.getAbilities().get(0).getName() + " UP");
				ability1DownB.setText(c.getAbilities().get(0).getName() + " DOWN");
				ability1RightB.setText(c.getAbilities().get(0).getName()+ " RIGHT");
				ability1LeftB.setText(c.getAbilities().get(0).getName()+ " LEFT");
				
				
				ability1B.setEnabled(false);
			}
			if(c.getAbilities().get(1).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				ability2UpB.setEnabled(true);
				ability2DownB.setEnabled(true);
				ability2RightB.setEnabled(true);
				ability2LeftB.setEnabled(true);
				
				ability2UpB.setVisible(true);
				ability2DownB.setVisible(true);
				ability2RightB.setVisible(true);
				ability2LeftB.setVisible(true);
				
				ability2UpB.setBackground(new Color(34,50,110));
				ability2DownB.setBackground(new Color(34,50,110));
				ability2RightB.setBackground(new Color(34,50,110));
				ability2LeftB.setBackground(new Color(34,50,110));
				
				ability2UpB.setForeground(Color.WHITE);
				ability2DownB.setForeground(Color.WHITE);
				ability2RightB.setForeground(Color.WHITE);
				ability2LeftB.setForeground(Color.WHITE);
				
				ability2UpB.setName(c.getAbilities().get(1).getName());
				ability2DownB.setName(c.getAbilities().get(1).getName());
				ability2RightB.setName(c.getAbilities().get(1).getName());
				ability2LeftB.setName(c.getAbilities().get(1).getName());
				
				ability2UpB.setText(c.getAbilities().get(1).getName() + " UP");
				ability2DownB.setText(c.getAbilities().get(1).getName() + " DOWN");
				ability2RightB.setText(c.getAbilities().get(1).getName()+" RIGHT");
				ability2LeftB.setText(c.getAbilities().get(1).getName()+" LEFT");
			
				ability2B.setEnabled(false);
			}
			if(c.getAbilities().get(2).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				ability3UpB.setEnabled(true);
				ability3DownB.setEnabled(true);
				ability3RightB.setEnabled(true);
				ability3LeftB.setEnabled(true);
				
				ability3UpB.setVisible(true);
				ability3DownB.setVisible(true);
				ability3RightB.setVisible(true);
				ability3LeftB.setVisible(true);
				
				ability3UpB.setBackground(new Color(34,50,110));
				ability3DownB.setBackground(new Color(34,50,110));
				ability3RightB.setBackground(new Color(34,50,110));
				ability3LeftB.setBackground(new Color(34,50,110));
				
				ability3UpB.setForeground(Color.WHITE);
				ability3DownB.setForeground(Color.WHITE);
				ability3RightB.setForeground(Color.WHITE);
				ability3LeftB.setForeground(Color.WHITE);
				
				ability3UpB.setName(c.getAbilities().get(2).getName());
				ability3DownB.setName(c.getAbilities().get(2).getName());
				ability3RightB.setName(c.getAbilities().get(2).getName());
				ability3LeftB.setName(c.getAbilities().get(2).getName());
				
				ability3UpB.setText(c.getAbilities().get(2).getName() + " UP");
				ability3DownB.setText(c.getAbilities().get(2).getName() + " DOWN");
				ability3RightB.setText(c.getAbilities().get(2).getName()+" RIGHT");
				ability3LeftB.setText(c.getAbilities().get(2).getName()+" LEFT");
				
				
				ability3B.setEnabled(false);
			}
			
			
		}
		this.validate();
	}
	
	
	public void updateChampionTurn() {
		
		ArrayList<Champion> championsTurn = new ArrayList<>();
		for(int i=0;i< game.getTurnOrder().size();i++) {
			championsTurn.add((Champion)game.getTurnOrder().remove());
			i--;
		}
		for(int i =0 ; i<championsTurn.size();i++) {
			 game.getTurnOrder().insert(championsTurn.get(i));
		}
		turnOrderP.removeAll();
		
		for(int i =0 ;i<championsTurn.size();i++) {
			String champName = championsTurn.get(i).getName();
			for(int j =0 ; j<championIcons.size();j++) {
			String iconName =championIcons.get(j).getName();
			  if(champName.equals(iconName)) {
				  JLabel temp = new JLabel();
				  ImageIcon ChampIcon= (ImageIcon) championIcons.get(j).getIcon();
				  temp.setIcon(ChampIcon);
				  temp.setToolTipText(getCurrentAttributes(iconName));
				  turnOrderP.add(temp);
				  if(i==0) {
					  JPanel currentChamp =new JPanel();
					  currentChamp.setLayout(new BorderLayout());
					  currentChamp.setBackground(Color.BLACK);
					  JLabel cChamp = new JLabel("Current Champion");
					  cChamp.setForeground(Color.GREEN);
					  currentChamp.add(cChamp,BorderLayout.NORTH);
					  currentChamp.add(temp,BorderLayout.CENTER);
					  turnOrderP.add(currentChamp);
				  }
				  else {
				  turnOrderP.add(temp);
				  }
				  this.revalidate();
				  this.repaint();
			  }
			}	
		}
	}
	public void cleanUpBoard() {
		
		boardP.removeAll();
		
		
		JButton[][] boardtempB = new JButton[5][5];
		boardtemp=game.getBoard();
		
		for(int x=4 ;x>=0;x--) {
			for(int y =0;y<5;y++) {
				JButton cell = new JButton();
				boardtempB[x][y]=cell;
				boardP.add(cell);
				cell.addActionListener(this);
				cell.setBackground(Color.GRAY);
			}
		}
		
		for(int x=0;x<5;x++) {
			for(int y=0;y<5;y++) {
				if(boardtemp[x][y] == null) {
					boardtempB[x][y].setBackground(Color.GRAY);
					this.revalidate();
				}
				if(boardtemp[x][y] instanceof Cover) {
					Cover cover = (Cover) boardtemp[x][y];
					boardtempB[x][y].setIcon(coverf);
					boardtempB[x][y].setBackground(Color.DARK_GRAY);
					boardtempB[x][y].setToolTipText("Cover's HP :" +cover.getCurrentHP());
					this.revalidate();
				}
				
				if(boardtemp[x][y] instanceof Champion) {
					if(((Champion) boardtemp[x][y]).getCurrentHP()!=0) {
					for(int i =0 ; i<championIcons.size();i++) {
						for(int j =0 ;j<game.getFirstPlayer().getTeam().size();j++) {
							String name =championIcons.get(i).getName();
							if(name.equals(game.getFirstPlayer().getTeam().get(j).getName())) {
								 int x1=(int) game.getFirstPlayer().getTeam().get(j).getLocation().getX();
								 int y1=(int) game.getFirstPlayer().getTeam().get(j).getLocation().getY();
								
								boardtempB[x1][y1].setIcon(championIcons.get(i).getIcon());
								boardtempB[x1][y1].setToolTipText(getCurrentAttributes(name));
								boardtempB[x1][y1].setBackground(new Color(9,20,60));
								
								
							this.revalidate();	
								
							
							}
						}
						
						for(int j =0 ;j<game.getSecondPlayer().getTeam().size();j++) {
							String name =championIcons.get(i).getName();
							if(name.equals(game.getSecondPlayer().getTeam().get(j).getName())) {
								int x2=(int) game.getSecondPlayer().getTeam().get(j).getLocation().getX();
								int y2=(int) game.getSecondPlayer().getTeam().get(j).getLocation().getY();
								
								boardtempB[x2][y2].setIcon(championIcons.get(i).getIcon());
								boardtempB[x2][y2].setToolTipText(getCurrentAttributes(name));
								boardtempB[x2][y2].setBackground(new Color(170,1,20));
								
								
						
							}
						}
					   }
					 }
					else {
						if(game.getFirstPlayer().getTeam().contains(boardtemp[x][y])){
							game.getFirstPlayer().getTeam().remove(boardtemp[x][y]);
							boardtemp[x][y]=null;
						}
						else if(game.getSecondPlayer().getTeam().contains(boardtemp[x][y])){
							game.getSecondPlayer().getTeam().remove(boardtemp[x][y]);
							boardtemp[x][y]=null;
						}
						
					}
				}
				
			}
		}
		
	
		
		this.validate();
		this.repaint();
		this.add(boardP,BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}
	
	
	
	
	public String getCurrentAttributes(String name ) {
		
		String attributes= "";
		String champName = "";
		String currentHP = "";
		String mana="";
		String actionPoints="";
		String speed="";
		String attackRange="";
		String attackDamage="";
		
		String ability1="";
		String ability2="";
		String ability3="";
		
		String type="";
		String isLeader="";
		String appliedEffects="";
	
		Champion c =null;
		for(int j =0 ;j<game.getAvailableChampions().size();j++) {
			if(name.equals(game.getAvailableChampions().get(j).getName())) {
				 c =game.getAvailableChampions().get(j);
			}
		}
		
		
		
		 ability1 = "Ability 1 :" + c.getAbilities().get(0).getName() ;
	     ability2 = "Ability 2 :" + c.getAbilities().get(1).getName() ;
	     ability3 = "Ability 3 :" + c.getAbilities().get(2).getName() ; 
	   
	      champName=  c.getName()  ;
		  currentHP = "CurrentHP: "+ c.getCurrentHP()  ;
		  mana ="Mana: "+c.getMana()  ;
		  actionPoints="Action Points: "+c.getCurrentActionPoints();
		  speed="Speed: "+c.getSpeed() ;
		  attackRange ="Attack Range: "+c.getAttackRange();
		  attackDamage =	"Attack Damage: "+c.getAttackDamage();
		  if(c instanceof Hero) {
			  type = "Hero";
		  }
		  if(c instanceof AntiHero) {
			  type = "AntiHero";
		  }
		  if(c instanceof Villain) {
			  type = "Villain";
		  }
		  
		  if(game.getFirstPlayer().getTeam().contains(c)) {
			  if(game.getFirstPlayer().getLeader()==c)
				  isLeader = c.getName() + " is the Leader" ;
			  else 
				  isLeader = c.getName() + " is not the Leader" ;
		  }
		  
		  if(game.getSecondPlayer().getTeam().contains(c)) {
			  if(game.getSecondPlayer().getLeader()==c)
				  isLeader =c.getName() + " is the Leader" ;
			  else 
				  isLeader = c.getName() + " is not the Leader" ;
		  }
		  
		  for(int i =0 ; i<c.getAppliedEffects().size();i++) {
			  Effect e =c.getAppliedEffects().get(i);
			  appliedEffects += "<html>" + "Effects :" + e.getName() +  " , " + "Duration :" + e.getDuration() + "<br>" + "</html>";
		  }

		  attributes = "<html>" + champName + "<br>" + "<br>" + ability1 + "<br>" + ability2 + "<br>" + ability3 + "<br>" + currentHP + "<br>" + mana + "<br>" +
								actionPoints + "<br>" + speed + "<br>" + attackRange + "<br>" + attackDamage +"<br>" + type +"<br>"
								+ isLeader +  "<br>" +appliedEffects +  "</html>" ;
		
		
		return attributes;
	
	}

 public void updateCurrentChampion() {
	 currentChampionP1.removeAll();
	 currentChampionP2.removeAll();
	 for(int i =0 ; i<championIcons.size();i++) {
		 String name =championIcons.get(i).getName();
			for(int j =0 ;j<game.getFirstPlayer().getTeam().size();j++) {
				if(name.equals(game.getFirstPlayer().getTeam().get(j).getName())) {					
					championAttributesL = new JLabel(getCurrentAttributes(game.getFirstPlayer().getTeam().get(j).getName()));
					championAttributesL.setForeground(Color.WHITE);
					currentChampionP1.add(championAttributesL);
					currentChampionP1.setBackground(new Color(9,20,60));
					currentChampionP1.add( new JLabel (championIcons.get(i).getIcon()));
					
				}
				
			}
			
			
			for(int j =0 ;j<game.getSecondPlayer().getTeam().size();j++) {
				if(name.equals(game.getSecondPlayer().getTeam().get(j).getName())) {
					championAttributesL = new JLabel(getCurrentAttributes(game.getSecondPlayer().getTeam().get(j).getName()));
					championAttributesL.setForeground(Color.WHITE);
					currentChampionP2.add(championAttributesL);
					currentChampionP2.setBackground(new Color(170,1,20));
					currentChampionP2.add( new JLabel (championIcons.get(i).getIcon()));
				  }
				}
			}
	 this.revalidate();
	 }
 
 	public Ability getAbility(String name) {
 		Ability a=null;
 		for(int i=0; i<game.getCurrentChampion().getAbilities().size();i++) {
 			if(name.equals(game.getCurrentChampion().getAbilities().get(i).getName())) {
 				 a = game.getCurrentChampion().getAbilities().get(i);
 			}
 		}
 		return a;
 	}

	@Override
	public void actionPerformed(ActionEvent e)  {
		
		   
		  if(e.getSource()==attackUpB) {
		    	try {
					game.attack(Direction.UP);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
				} catch (ChampionDisarmedException e1) {
					JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
				}
		    	
		  }	
		    	
		    	if(e.getSource()==attackDownB) {
			    	try {
						game.attack(Direction.DOWN);
						
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (ChampionDisarmedException e1) {
						JOptionPane.showMessageDialog(this, e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					}
			    	
			    }	
		    	
		    	if(e.getSource()==attackRightB) {
			    	try {
						game.attack(Direction.RIGHT);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(this, e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (ChampionDisarmedException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					}
			    	
			    }	
		    	
		    	if(e.getSource()==attackLeftB) {
			    	try {
						game.attack(Direction.LEFT);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (ChampionDisarmedException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					}
			    	
			    }	
		    	
	
		   
		   this.validate();
		   this.repaint();
		
		
		    	
		   Champion c = game.getCurrentChampion(); 
		   int x = (int) c.getLocation().getX();
	       int y = (int) c.getLocation().getY();
	       
	    		
		   if(e.getSource()==moveUpB) {
		    		try {
						game.move(Direction.UP);
						ImageIcon temp= (ImageIcon) board[x][y].getIcon();
			    		board[x][y].setIcon(null);
			    		x++;
			    		board[x][y].setIcon(temp);
			    		 this.validate();
			  		   this.repaint();
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (UnallowedMovementException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} 
		    		
		    		
		    		
		    	}
		    	if(e.getSource()==moveDownB) {
		    		try {
						game.move(Direction.DOWN);
						ImageIcon temp= (ImageIcon) board[x][y].getIcon();
			    		board[x][y].setIcon(null);
			    		x--;
			    		board[x][y].setIcon(temp);
			    		
			    	   this.validate();
			  		   this.repaint();
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(this, e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (UnallowedMovementException e1) {
						JOptionPane.showMessageDialog(this, e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					}
		    	
		    		
		    	}
		    	if(e.getSource()==moveRightB) {
		    		try {
						game.move(Direction.RIGHT);
						ImageIcon temp= (ImageIcon) board[x][y].getIcon();
			    		board[x][y].setIcon(null);
			    		y++;
			    		board[x][y].setIcon(temp);
			    		 this.validate();
			  		   this.repaint();
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (UnallowedMovementException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					}
		    		
		    		
		    	}
		    	if(e.getSource()==moveLeftB) {
		    		try {
						game.move(Direction.LEFT);
						ImageIcon temp= (ImageIcon) board[x][y].getIcon();
			    		board[x][y].setIcon(null);
			    		y--;
			    		board[x][y].setIcon(temp);
			    		 this.validate();
			  		   this.repaint();
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					} catch (UnallowedMovementException e1) {
						JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
					}
		    		
	
		    		
		    	}
		
		if(e.getSource()==ability1B) {
			if(getAbility(ability1B.getName()).getCastArea()==AreaOfEffect.SINGLETARGET) {
				functionP.removeAll();
				functionP.add(attackMainP);
				functionP.add(moveMainP);
				functionP.add(ability1MainP);
				functionP.add(ability2MainP);
				functionP.add(ability3MainP);
				functionP.add(sliderSubmit);
				functionP.add(leaderAbilityB);
				functionP.add(endTurnB);
				n =1;
				
			}
			else {
			try {
				game.castAbility(getAbility(ability1B.getName()));
				
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
			
	}
		if(e.getSource()==ability2B) {
			if(getAbility(ability2B.getName()).getCastArea()==AreaOfEffect.SINGLETARGET) {
				functionP.removeAll();
				functionP.add(attackMainP);
				functionP.add(moveMainP);
				functionP.add(ability1MainP);
				functionP.add(ability2MainP);
				functionP.add(ability3MainP);
				functionP.add(sliderSubmit);
				functionP.add(leaderAbilityB);
				functionP.add(endTurnB);
				
				n=2;
			}
			else {
			try {
				game.castAbility(getAbility(ability2B.getName()));
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		if(e.getSource()==ability3B) {
			if(getAbility(ability3B.getName()).getCastArea()==AreaOfEffect.SINGLETARGET) {
				functionP.removeAll();
				functionP.add(attackMainP);
				functionP.add(moveMainP);
				functionP.add(ability1MainP);
				functionP.add(ability2MainP);
				functionP.add(ability3MainP);
				functionP.add(sliderSubmit);
				functionP.add(leaderAbilityB);
				functionP.add(endTurnB);
				n=3;
				
			}
			else {
			try {
				game.castAbility(getAbility(ability3B.getName()));
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
		if(e.getSource()==submitB) {
		   if(n==1) {
			   try {
				game.castAbility(getAbility(ability1B.getName()), targetX.getValue(), targetY.getValue());
				
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
			   
		   }
		   if(n==2) {
			   try {
				game.castAbility(getAbility(ability2B.getName()), targetX.getValue(), targetY.getValue());
				
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
			   
		   }
		   if(n==3) {
			   try {
				game.castAbility(getAbility(ability3B.getName()), targetX.getValue(), targetY.getValue());
				
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
			   
		   }
		   
		   functionP.removeAll();
			functionP.add(attackMainP);
			functionP.add(moveMainP);
			functionP.add(ability1MainP);
			functionP.add(ability2MainP);
			functionP.add(ability3MainP);
			functionP.add(leaderAbilityB);
			functionP.add(endTurnB);
			
		}
		
		
		if (e.getSource()== ability1UpB) {
			try {
				game.castAbility(getAbility(ability1UpB.getName()), Direction.UP);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource()== ability1DownB) {
			try {
				game.castAbility(getAbility(ability1DownB.getName()), Direction.DOWN);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()== ability1RightB) {
			try {
				game.castAbility(getAbility(ability1RightB.getName()), Direction.RIGHT);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()== ability1LeftB) {
			try {
				game.castAbility(getAbility(ability1LeftB.getName()), Direction.LEFT);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource()== ability2UpB) {
			try {
				game.castAbility(getAbility(ability2UpB.getName()), Direction.UP);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource()== ability2DownB) {
			try {
				game.castAbility(getAbility(ability2DownB.getName()), Direction.DOWN);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()== ability2RightB) {
			try {
				game.castAbility(getAbility(ability2RightB.getName()), Direction.RIGHT);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()== ability2LeftB) {
			try {
				game.castAbility(getAbility(ability2LeftB.getName()), Direction.LEFT);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()== ability3UpB) {
			try {
				game.castAbility(getAbility(ability3UpB.getName()), Direction.UP);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource()== ability3DownB) {
			try {
				game.castAbility(getAbility(ability3DownB.getName()), Direction.DOWN);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()== ability3RightB) {
			try {
				game.castAbility(getAbility(ability3RightB.getName()), Direction.RIGHT);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()== ability3LeftB) {
			try {
				game.castAbility(getAbility(ability1LeftB.getName()), Direction.LEFT);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource()==leaderAbilityB) {
			try {
				game.useLeaderAbility();
				if(game.getFirstPlayer().getTeam().contains(game.getCurrentChampion())) {
					leaderAbilityUsed1.removeAll();
					leaderAbilityUsed1.setText("Leader Ability is Used");
					
				}
				if(game.getSecondPlayer().getTeam().contains(game.getCurrentChampion())) {
					leaderAbilityUsed2.removeAll();
					leaderAbilityUsed2.setText("Leader Ability is Used");
				}
			} catch (LeaderNotCurrentException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(this,  e1.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
			}
			this.validate();
		}
		
		
		if(e.getSource()== endTurnB) {
			
			
			championsTurn.add(championsTurn.remove(0));
			updateChampionTurn();
			game.endTurn();
			abilityName();
			
			this.revalidate();
			this.repaint();
			
			
		}
		cleanUpBoard();
		updateCurrentChampion();
		updateChampionTurn();
		cleanUpBoard();
		if (game.checkGameOver() == game.getFirstPlayer()||game.checkGameOver() == game.getSecondPlayer()) {
			Player winner = game.checkGameOver();
			this.setVisible(false);
			new GameOverFrame().setVisible(true);
				
		}
		this.revalidate();
		this.repaint();
		
	}
	
	public static Player getWinner() {
		return winner;
	}


	public static Game getGame() {
		
		return game;
	}



	
}
