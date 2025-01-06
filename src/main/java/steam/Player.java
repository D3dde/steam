package steam;

import java.util.ArrayList;

public class Player extends User{

    ArrayList<Game> ownedGames;

    public Player(String username, String password){
        super(username, password);
        ownedGames = new ArrayList<Game>();
    }

    public void buyGame(Game game){
        ownedGames.add(game);
    }

}
