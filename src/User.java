import java.util.ArrayList;

public class User
{
    private String username;
    private ArrayList<IPCSystems> systems;
    private ArrayList<Caretaker> caretakers;
    private GameRequirementsChecker gameRequirementsChecker;
    //For instantiating an existing user
    public User(String username, ArrayList<IPCSystems> systems, ArrayList<Caretaker> caretakers)
    {
        this.username = username;
        this.systems = systems;
        this.caretakers = caretakers;
    }
    //For new user
    public User(String username)
    {
        systems = new ArrayList<>();
        caretakers = new ArrayList<>();
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public ArrayList<IPCSystems> getSystems()
    {
        return systems;
    }

    public void setSystems(ArrayList<IPCSystems> systems)
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
}
