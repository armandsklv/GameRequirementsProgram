import com.google.gson.Gson;
import pccomponents.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Program
{
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<CPU> cpus = new ArrayList<>();
    static ArrayList<Disk> disks = new ArrayList<>();
    static ArrayList<GPU> gpus = new ArrayList<>();
    static ArrayList<Motherboard> motherboards = new ArrayList<>();
    static ArrayList<OS> os = new ArrayList<>();
    static ArrayList<RAM> ram = new ArrayList<>();
    static String username;
    public static void main(String[] args)
    {
        getUsers();
        Scanner scanner = new Scanner(System.in);
        for(User user: users)
        {
            System.out.println(user.getUsername());
        }
        System.out.println("Enter your username, if it exists previous data will be loaded, otherwise new user will be created:");
        username = scanner.next();
        setCurrentUser();
        User currentUser = setCurrentUser();

    }
    public static User setCurrentUser()
    {
        for(User user : users)
        {
            if(user.getUsername().equals("username"))
            {
                return user;
            }
        }
        return new User(username);
    }
    public static void getUsers()
    {
        ArrayList<String> results = new ArrayList<>();
        try
        {
            File[] userFiles = new File("data/users").listFiles();
            for (File user : userFiles)
            {
                if (user.isFile())
                {
                    results.add(user.getName());
                }
                System.out.println(user.getName());
            }
        }
        catch (NullPointerException npe)
        {
            System.out.println("Couldn't read user files or no users exist.");
        }

        String json = "";
        for(String user : results)
        {
            try
            {
                json = new String ( Files.readAllBytes( Paths.get("data/users/"+user) ) );
            }
            catch (IOException e)
            {
                System.out.println("Couldn't read user from file!");
            }
            users.add(new Gson().fromJson(json,User.class));
        }
    }
}
