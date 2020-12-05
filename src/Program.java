import pccomponents.*;

import java.util.ArrayList;

public class Program
{

    public static void main(String[] args)
    {
        Caretaker caretaker = new Caretaker();
        CPU cpu = new CPU("AMD", "Ryzen 3 1200", 4, 3.6F, 4.2F,4);
        Disk disk = new Disk("A400", "Kingston", "SSD", 480);
        GPU gpu = new GPU("GTX 960", "nVidia", 4.0, 3500.0, 1200.0, 1500.0);
        Motherboard motherboard = new Motherboard("A320", "AMD", "MS-7B07", "MSI", "AM4");
        OS os = new OS("Windows 10", 64);
        RAM ram = new RAM(8, 16, 2333.0, "DDR4", "Kingston", "KGX81623A2");
        UserPCSystem userPCSystem = new UserPCSystem(cpu, ram, os, gpu, motherboard, disk);
        userPCSystem.printSystem();
        caretaker.add(userPCSystem.createMemento());
        userPCSystem.getDisk().setDiskSpace(960);
        userPCSystem.printSystem();
        userPCSystem.restoreFromMemento(caretaker.get());
        userPCSystem.printSystem();
        userPCSystem.restoreFromMemento(caretaker.get());
        userPCSystem.printSystem();
    }
}
