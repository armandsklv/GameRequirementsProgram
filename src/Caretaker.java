import java.util.ArrayList;

public class Caretaker
{
    private ArrayList<Memento> mementoList;
    public Caretaker()
    {
        mementoList = new ArrayList<>();
    }
    public void add(Memento state)
    {
        mementoList.add(state);
    }

    public Memento get()
    {
        Memento temp;
        if(!mementoList.isEmpty())
        {
            temp = mementoList.get(mementoList.size()-1);
            mementoList.remove(temp);
            return temp;
        }
        else
        {
            return null;
        }
    }
}
