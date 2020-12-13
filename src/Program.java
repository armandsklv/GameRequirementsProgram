import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pccomponents.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
    static User currentUser;
    public static void main(String[] args)
    {
        runProgram();
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
            if(user.getUsername().equals(username))
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
    public static void saveResources(User user)
    {
        try
        {
            FileWriter writer = new FileWriter("data/users/"+user.getUsername()+".JSON");
            Gson gson = new GsonBuilder().create();
            gson.toJson(user,writer);
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void runProgram()
    {
        loadResources();
        currentUser = setCurrentUser();
        System.out.println("-----Welcome!-----");
        System.out.println("Please input the number of the command to do: ");
        System.out.println("(1) Show all systems.");
        System.out.println("(2) Create a new system.");
        System.out.println("(0) Log out");
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        while(command != 0)
        {
            try
            {
                command = scanner.nextInt();
                switch (command)
                {
                    case 1:
                        systemsMenu();
                        break;
                    case 2:
                        createNewSystem(command);
                        break;
                    case 0:
                        System.out.println("Logging out!");
                        break;
                    default:
                        System.out.println("Entered number is not a valid command! Please try again:");
                        break;
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Entered symbol is not a number! Please try again:");
                scanner.next();
            }


        }

        saveResources(currentUser);
    }
    public static void systemsMenu()
    {
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----User systems menu-----");
        System.out.println("Please input the number of the command to do: ");
        System.out.println("(System No.)Select a system.");
        System.out.println("(0) Go back");

        while(command != 0)
        {
            try
            {
                command = scanner.nextInt();
                if (command == 0)
                {
                    System.out.println("Going back.");
                    break;
                }
                else
                {
                    workOnSystem(command);
                    break;
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Entered symbol is not a number! Please try again:");
                scanner.next();
            }


        }
    }
    public static void workOnSystem(int systemNum)
    {
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----PC menu-----");
        System.out.println("Please input the number of the command to do: ");
        System.out.println("(1)Check requirements.");
        System.out.println("(2)Show game check results.");
        System.out.println("(3)Change CPU.");
        System.out.println("(4)Change GPU.");
        System.out.println("(5)Change RAM.");
        System.out.println("(6)Change Disk.");
        System.out.println("(7)Change motherboard.");
        System.out.println("(8)Change OS.");
        System.out.println("(0) Go back");
        UserPCSystem tempPC = currentUser.getSystems().get(systemNum);
        while(command != 0)
        {
            try
            {
                command = scanner.nextInt();
                switch (command)
                {

                    case 1:
                        checkRequirements();
                        break;
                    case 2:
                        getGameCheckResults();
                        break;
                    case 3:
                        changeCPU();
                        break;
                    case 4:
                        changeGPU();
                        break;
                    case 5:
                        changeRAM();
                        break;
                    case 6:
                        changeDisk();
                        break;
                    case 7:
                        changeMotherboard();
                        break;
                    case 8:
                        changeOS();
                        break;
                    case 0:
                        System.out.println("Going back.");
                        break;
                    default:
                        workOnSystem(command);
                        break;
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Entered symbol is not a number! Please try again:");
                scanner.next();
            }

        }
    }
    public static void createNewSystem(int command)
    {
        System.out.println("Creating new user system:");
    }
    public static void checkRequirements()
    {

    }
    public static void getGameCheckResults()
    {

    }
    public static void changeCPU()
    {

    }
    public static void changeGPU()
    {

    }
    public static void changeRAM()
    {

    }
    public static void changeDisk()
    {

    }
    public static void changeMotherboard()
    {

    }
    public static void changeOS()
    {

    }

    public static ArrayList<User> getUsers()
    {
        return users;
    }

    public static void setUsers(ArrayList<User> users)
    {
        Program.users = users;
    }

    public static ArrayList<CPU> getCpus()
    {
        return cpus;
    }

    public static void setCpus(ArrayList<CPU> cpus)
    {
        Program.cpus = cpus;
    }

    public static ArrayList<Disk> getDisks()
    {
        return disks;
    }

    public static void setDisks(ArrayList<Disk> disks)
    {
        Program.disks = disks;
    }

    public static ArrayList<GPU> getGpus()
    {
        return gpus;
    }

    public static void setGpus(ArrayList<GPU> gpus)
    {
        Program.gpus = gpus;
    }

    public static ArrayList<Motherboard> getMotherboards()
    {
        return motherboards;
    }

    public static void setMotherboards(ArrayList<Motherboard> motherboards)
    {
        Program.motherboards = motherboards;
    }

    public static ArrayList<OS> getOs()
    {
        return os;
    }

    public static void setOs(ArrayList<OS> os)
    {
        Program.os = os;
    }

    public static ArrayList<RAM> getRam()
    {
        return ram;
    }

    public static void setRam(ArrayList<RAM> ram)
    {
        Program.ram = ram;
    }

    public static String getUsername()
    {
        return username;
    }

    public static void setUsername(String username)
    {
        Program.username = username;
    }

    public static User getCurrentUser()
    {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser)
    {
        Program.currentUser = currentUser;
    }
}
