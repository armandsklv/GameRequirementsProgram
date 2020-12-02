import pccomponents.*;

public class UserPCSystem implements IPCSystems
{
    CPU cpu;
    RAM ram;
    OS os;
    GPU gpu;
    Motherboard motherboard;
    Disk disk;
    @Override
    public void printSystem()
    {

    }
    public Memento createMemento()
    {

        return new Memento();
    }
    public void restoreFromMemento(Memento memento)
    {

    }

}
