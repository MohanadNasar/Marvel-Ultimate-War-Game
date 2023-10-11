package engine;

import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.world.Champion;
import model.world.Direction;

public interface GameListener  {
	
	Champion getCurrentChampion();
	
	Player checkGameOver();
	
	void move(Direction d) throws NotEnoughResourcesException, UnallowedMovementException ;
	
	void attack (Direction d) throws NotEnoughResourcesException, ChampionDisarmedException, InvalidTargetException;
	
	void castAbility(Ability a) throws NotEnoughResourcesException, AbilityUseException, CloneNotSupportedException;
	
	void castAbility(Ability a, Direction d) throws NotEnoughResourcesException, AbilityUseException, CloneNotSupportedException;
	
	 void castAbility(Ability a, int x, int y) throws NotEnoughResourcesException, AbilityUseException, InvalidTargetException, CloneNotSupportedException;
	 
	 void useLeaderAbility() throws LeaderNotCurrentException, LeaderAbilityAlreadyUsedException;
	 
	 void endTurn();
	 
	
     
	
}
