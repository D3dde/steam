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

}