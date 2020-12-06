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
    static ResourceLoader resourceLoader = new ResourceLoader();
    static String username;
    public static void main(String[] args)
    {
        loadResources();
        User currentUser = setCurrentUser();

    }
    public static User setCurrentUser()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("List of users:");
        for(User user: users)
        {
            System.out.println(user.getUsername());
        }
        System.out.println("Enter your username, if it exists previous data will be loaded, otherwise new user will be created:");
        username = scanner.next();
        for(User user : users)
        {
            if(user.getUsername().equals("username"))
            {
                return user;
            }
        }
        return new User(username);
    }
    public static void loadResources()
    {
        users = resourceLoader.getUsers();
        cpus = resourceLoader.getCPUList();
        disks = resourceLoader.getDiskList();
        gpus = resourceLoader.getGPUList();
        motherboards = resourceLoader.getMotherboardList();
        ram = resourceLoader.getRAMList();
        os = resourceLoader.getOSList();
        System.out.println("Resources loaded!");
    }
}
