package controller;

import java.io.IOException;

import engine.Game;
import engine.Player;
import view.ChampionSelection;
import view.GameFrame;
import view.GameOverFrame;
import view.PlayerNameFrame;

public class GameConsole {
	
public static void main(String[]args) throws IOException {
	
		new PlayerNameFrame();
		new ChampionSelection();
		
		
	}
}
