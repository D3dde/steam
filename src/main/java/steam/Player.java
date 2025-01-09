package steam;

import java.util.ArrayList;

public class Player extends User{

    ArrayList<Game> ownedGames;

    public Player(String username, String password){
        super(username, password);
        ownedGames = new ArrayList<Game>();
    }

    public boolean buyGame(Game game){
        boolean isPresent = false;
        for (int i = 0; i < ownedGames.size() ; i++){
            if (game.equals(ownedGames.get(i))){
                isPresent = true;
            }
        }
        if (isPresent){
            return false;
        }else{
            ownedGames.add(game);
            return true;
        }
    }

    public String getLibrary(){
        String out = "";
        for (int i = 0; i < ownedGames.size(); i++){
            out+=ownedGames.get(i).toString()+"\n";
        }
        return out;
    }

}
