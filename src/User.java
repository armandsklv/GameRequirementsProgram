import pccomponents.*;

import java.util.ArrayList;

public class User
{
    private String username;
    private ArrayList<UserPCSystem> systems;
    private ArrayList<Caretaker> caretakers;
    private GameRequirementsChecker gameRequirementsChecker;
    //For instantiating an existing user
    public User(String username, ArrayList<UserPCSystem> systems, ArrayList<Caretaker> caretakers)
    {
        this.username = username;
        this.systems = systems;
        this.caretakers = caretakers;
    }
    //For new user
    public User(String username)
    {
        this.username=username;
        systems = new ArrayList<>();
        caretakers = new ArrayList<>();
    }

    public String getUsername()
    {
        return username;
    }

    public void setusername(String username)
    {
        this.username = username;
    }

    public ArrayList<UserPCSystem> getSystems()
    {
        return systems;
    }

    public void setSystems(ArrayList<UserPCSystem> systems)
    {
        this.systems = systems;
    }

    public ArrayList<Caretaker> getCaretakers()
    {
        return caretakers;
    }

    public void setCaretakers(ArrayList<Caretaker> caretakers)
    {
        this.caretakers = caretakers;
    }
    public void createNewSystem(String name, CPU cpu, RAM ram, OS os, GPU gpu, Motherboard motherboard, Disk disk)
    {
        systems.add(new UserPCSystem(name, cpu, ram, os, gpu, motherboard, disk));
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public GameRequirementsChecker getGameRequirementsChecker()
    {
        return gameRequirementsChecker;
    }

    public void setGameRequirementsChecker(GameRequirementsChecker gameRequirementsChecker)
    {
        this.gameRequirementsChecker = gameRequirementsChecker;
    }
}
