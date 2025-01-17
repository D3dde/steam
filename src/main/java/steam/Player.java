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

    public void sortGames(String sort){
        System.out.println(sort);
        if (sort.equals("name")){
            int n = ownedGames.size();
            for (int i = 0; i < n - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < n; j++) {
                    if (ownedGames.get(j).getName().compareTo(ownedGames.get(min_idx).getName()) <0)
                        min_idx = j;
                }
                Game temp = ownedGames.get(min_idx);
                ownedGames.set(min_idx,ownedGames.get(i));
                ownedGames.set(i,temp);
            }
        } else if (sort.equals("description")) {
            int n = ownedGames.size();
            for (int i = 0; i < n - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < n; j++) {
                    if (ownedGames.get(j).getDescription().compareTo(ownedGames.get(min_idx).getDescription()) <0)
                        min_idx = j;
                }
                Game temp = ownedGames.get(min_idx);
                ownedGames.set(min_idx,ownedGames.get(i));
                ownedGames.set(i,temp);
            }
        } else if (sort.equals("price")) {
            int n = ownedGames.size();
            for (int i = 0; i < n - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < n; j++) {
                    if (ownedGames.get(j).getPrice() < ownedGames.get(min_idx).getPrice())
                        min_idx = j;
                }
                Game temp = ownedGames.get(min_idx);
                ownedGames.set(min_idx,ownedGames.get(i));
                ownedGames.set(i,temp);
            }
        }
    }

}