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
    static ArrayList<Game> games = new ArrayList<>();
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
        games = resourceLoader.getGamesList();
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
                        if(currentUser.getSystems().isEmpty())
                        {
                            System.out.println("You currently do not have any systems to work with!");
                            System.out.println("Please input the number of the command to do: ");
                            System.out.println("(1) Show all systems.");
                            System.out.println("(2) Create a new system.");
                            System.out.println("(0) Log out");
                        }
                        else
                        {
                            systemsMenu();
                        }
                        break;
                    case 2:
                        createNewSystem();
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
        int num = 1;
        Scanner scanner = new Scanner(System.in);
        for(UserPCSystem system : currentUser.getSystems())
        {
            System.out.println("System No."+num);
            system.printSystem();
            num+=1;
        }
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
                    System.out.println("Please input the number of the command to do: ");
                    System.out.println("(1) Show all systems.");
                    System.out.println("(2) Create a new system.");
                    System.out.println("(0) Log out");
                }
                else
                {
                    workOnSystem(command-1);
                }
                break;
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
                        checkRequirements(systemNum);
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
                        break;
                    case 2:
                        getGameCheckResults(systemNum);
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
                        break;
                    case 3:
                        changeCPU(tempPC, systemNum);
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
                        break;
                    case 4:
                        changeGPU(tempPC, systemNum);
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
                        break;
                    case 5:
                        changeRAM(tempPC, systemNum);
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
                        break;
                    case 6:
                        changeDisk(tempPC, systemNum);
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
                        break;
                    case 7:
                        changeMotherboard(tempPC, systemNum);
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
                        break;
                    case 8:
                        changeOS(tempPC, systemNum);
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
                        break;
                    case 0:
                        System.out.println("Going back.");
                        System.out.println("Please input the number of the command to do: ");
                        System.out.println("(System No.)Select a system.");
                        System.out.println("(0) Go back");
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
    public static void createNewSystem()
    {
        System.out.println("-----Creating new user system-----");
        System.out.println("You will be asked to enter the name of your new system,\n after that you will be asked to select each component of your new system, one by one.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of your system:");
        String pcName = scanner.next();
        UserPCSystem tempPC = new UserPCSystem();
        tempPC.setName(pcName);
        addCPU(tempPC);
        addGPU(tempPC);
        addRAM(tempPC);
        addDisk(tempPC);
        addMotherboard(tempPC);
        addOS(tempPC);
        currentUser.getSystems().add(tempPC);
        currentUser.getCaretakers().add(new Caretaker());
        System.out.println("Please input the number of the command to do: ");
        System.out.println("(1) Show all systems.");
        System.out.println("(2) Create a new system.");
        System.out.println("(0) Log out");
    }

    public static ArrayList<Game> getGames()
    {
        return games;
    }

    public static void setGames(ArrayList<Game> games)
    {
        Program.games = games;
    }

    public static void checkRequirements(int systemNum)
    {
        GameRequirementsChecker gameRequirementsChecker;
        int num = 1;
        System.out.println("Game list:");
        for(Game game: getGames())
        {
            System.out.println(num+".");
            System.out.println(game.getName());
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the game you would like to check the requirements for: ");
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
                else if(command >= 1 && command < num)
                {
                    gameRequirementsChecker = new GameRequirementsChecker(getGames().get(command-1), currentUser.getSystems().get(systemNum));
                    currentUser.getSystems().get(systemNum).getCheckedGames().add(gameRequirementsChecker.getRequirementsComparisonResults());
                    currentUser.getSystems().get(systemNum).getCheckedGames().get(currentUser.getSystems().get(systemNum).getCheckedGames().size()-1).printResult();
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
    public static void getGameCheckResults(int systemNum)
    {
        System.out.println("-----Checked game results-----");
        for(GameCheckResults gcr : currentUser.getSystems().get(systemNum).getCheckedGames())
        {
            gcr.printResult();
        }
    }
    public static void changeCPU(UserPCSystem pc, int systemNum)
    {
        int num = 1;
        System.out.println("CPU list:");
        for(CPU cpu: getCpus())
        {
            System.out.println(num+".");
            cpu.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the cpu you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    currentUser.getCaretakers().get(systemNum).add(pc.createMemento());
                    pc.setCpu(getCpus().get(command-1));
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
    public static void changeGPU(UserPCSystem pc, int systemNum)
    {
        int num = 1;
        System.out.println("GPU list:");
        for(GPU gpu: getGpus())
        {
            System.out.println(num+".");
            gpu.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the gpu you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    currentUser.getCaretakers().get(systemNum).add(pc.createMemento());
                    pc.setGpu(getGpus().get(command-1));
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
    public static void changeRAM(UserPCSystem pc, int systemNum)
    {
        int num = 1;
        System.out.println("RAM list:");
        for(RAM ram: getRam())
        {
            System.out.println(num+".");
            ram.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the ram you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    currentUser.getCaretakers().get(systemNum).add(pc.createMemento());
                    pc.setRam(getRam().get(command-1));
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
    public static void changeDisk(UserPCSystem pc, int systemNum)
    {
        int num = 1;
        System.out.println("Disk list:");
        for(Disk disk: getDisks())
        {
            System.out.println(num+".");
            disk.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the disk you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    currentUser.getCaretakers().get(systemNum).add(pc.createMemento());
                    pc.setDisk(getDisks().get(command-1));
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
    public static void changeMotherboard(UserPCSystem pc, int systemNum)
    {
        int num = 1;
        System.out.println("Motherboard list:");
        for(Motherboard motherboard: getMotherboards())
        {
            System.out.println(num+".");
            motherboard.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the motherboard you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    currentUser.getCaretakers().get(systemNum).add(pc.createMemento());
                    pc.setMotherboard(getMotherboards().get(command-1));
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
    public static void changeOS(UserPCSystem pc, int systemNum)
    {
        int num = 1;
        System.out.println("OS list:");
        for(OS os: getOs())
        {
            System.out.println(num+".");
            os.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the OS you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    currentUser.getCaretakers().get(systemNum).add(pc.createMemento());
                    pc.setOs(getOs().get(command-1));
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
    public static void getCPUGrade(CPU cpu)
    {

    }
    public static void getGPUGrade(GPU gpu)
    {

    }
    public static void addCPU(UserPCSystem pc)
    {
        int num = 1;
        System.out.println("CPU list:");
        for(CPU cpu: getCpus())
        {
            System.out.println(num+".");
            cpu.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the cpu you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    pc.setCpu(getCpus().get(command-1));
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
    public static void addGPU(UserPCSystem pc)
    {
        int num = 1;
        System.out.println("GPU list:");
        for(GPU gpu: getGpus())
        {
            System.out.println(num+".");
            gpu.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the gpu you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    pc.setGpu(getGpus().get(command-1));
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
    public static void addRAM(UserPCSystem pc )
    {
        int num = 1;
        System.out.println("RAM list:");
        for(RAM ram: getRam())
        {
            System.out.println(num+".");
            ram.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the ram you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    pc.setRam(getRam().get(command-1));
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
    public static void addDisk(UserPCSystem pc )
    {
        int num = 1;
        System.out.println("Disk list:");
        for(Disk disk: getDisks())
        {
            System.out.println(num+".");
            disk.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the disk you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    pc.setDisk(getDisks().get(command-1));
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
    public static void addMotherboard(UserPCSystem pc)
    {
        int num = 1;
        System.out.println("Motherboard list:");
        for(Motherboard motherboard: getMotherboards())
        {
            System.out.println(num+".");
            motherboard.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the motherboard you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    pc.setMotherboard(getMotherboards().get(command-1));
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
    public static void addOS(UserPCSystem pc)
    {
        int num = 1;
        System.out.println("OS list:");
        for(OS os: getOs())
        {
            System.out.println(num+".");
            os.printComponentInfo();
            num+=1;
        }
        int command = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of the OS you would like to put in your system: ");
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
                else if(command >= 1 && command < num)
                {
                    pc.setOs(getOs().get(command-1));
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
}
