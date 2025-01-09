package steam;

import java.util.ArrayList;

public class Platform{
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Game> games = new ArrayList<Game>();

    public static void addUser(User user){
        users.add(user);
    }

    public static void addGame(Game game){
        games.add(game);
    }

    public static boolean validateUser(User user){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).equals(user)){
                return true;
            }
        }
        return false;
    }

    public static boolean exist(String username){
        for (int i = 0; i<users.size() ; i++){
            if (users.get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public static User getUser(int index){
        return users.get(index);
    }

    public static int getIndex(String username){
        for (int i = 0; i<users.size() ; i++){
            if (users.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }

    public static String[] getGames(){
        String[] out = new String[games.size()];
        for (int i = 0; i < games.size(); i++){
            out[i] = games.get(i).toString();
        }
        return out;
    }

    public static int getGameIndex(String game){
        for (int i = 0; i < games.size(); i++){
            if (games.get(i).toString().equals(game)){
                return i;
            }
        }
        return -1;
    }

    public static Game getGame(int index){
        return games.get(index);
    }

}