import com.google.gson.Gson;
import pccomponents.*;
import pccomponents.cputypes.BudgetCPU;
import pccomponents.cputypes.ConsumerCPU;
import pccomponents.cputypes.EnthusiastCPU;
import pccomponents.cputypes.ServerCPU;
import pccomponents.gputypes.BudgetGPU;
import pccomponents.gputypes.ConsumerGPU;
import pccomponents.gputypes.EnthusiastGPU;
import pccomponents.gputypes.WorkstationGPU;

import java.util.ArrayList;

public class UserPCSystem implements IPCSystems
{
    String name;
    CPU cpu;
    RAM ram;
    OS os;
    GPU gpu;
    Motherboard motherboard;
    Disk disk;
    ArrayList<GameCheckResults> checkedGames = new ArrayList<>();

    public UserPCSystem(String name, CPU cpu, RAM ram, OS os, GPU gpu, Motherboard motherboard, Disk disk)
    {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.os = os;
        this.gpu = gpu;
        this.motherboard = motherboard;
        this.disk = disk;
    }
    public UserPCSystem()
    {

    }
    @Override
    public void printSystem()
    {
        System.out.println("System: "+getName());
        cpu.printComponentInfo();
        motherboard.printComponentInfo();
        ram.printComponentInfo();
        gpu.printComponentInfo();
        disk.printComponentInfo();
        os.printComponentInfo();
    }
    public Memento createMemento()
    {
        System.out.println("System state saved.");
        GPU tmpGPU;
        CPU tmpCPU;
        if(gpu.getGpuType().equals("enthusiast"))
        {
            tmpGPU = new EnthusiastGPU(gpu.getGpuType(),gpu.getGpuModel(), gpu.getManufacturer(), gpu.getGpuVRAMAmount(), gpu.getGpuVRAMClockSpeed(), gpu.getGpuClockSpeed(), gpu.getGpuBoostClock(), gpu.getBenchmarkScore());
        }
        else if(gpu.getGpuType().equals("consumer"))
        {
            tmpGPU = new ConsumerGPU(gpu.getGpuType(),gpu.getGpuModel(), gpu.getManufacturer(), gpu.getGpuVRAMAmount(), gpu.getGpuVRAMClockSpeed(), gpu.getGpuClockSpeed(), gpu.getGpuBoostClock(), gpu.getBenchmarkScore());
        }
        else if(gpu.getGpuType().equals("budget"))
        {
            tmpGPU = new BudgetGPU(gpu.getGpuType(),gpu.getGpuModel(), gpu.getManufacturer(), gpu.getGpuVRAMAmount(), gpu.getGpuVRAMClockSpeed(), gpu.getGpuClockSpeed(), gpu.getGpuBoostClock(), gpu.getBenchmarkScore());
        }
        else if(gpu.getGpuType().equals("workstation"))
        {
            tmpGPU = new WorkstationGPU(gpu.getGpuType(),gpu.getGpuModel(), gpu.getManufacturer(), gpu.getGpuVRAMAmount(), gpu.getGpuVRAMClockSpeed(), gpu.getGpuClockSpeed(), gpu.getGpuBoostClock(), gpu.getBenchmarkScore());
        }
        else
        {
            tmpGPU = new GPU(gpu.getGpuType(),gpu.getGpuModel(), gpu.getManufacturer(), gpu.getGpuVRAMAmount(), gpu.getGpuVRAMClockSpeed(), gpu.getGpuClockSpeed(), gpu.getGpuBoostClock(), gpu.getBenchmarkScore());
        }
        if(cpu.getCpuType().equals("enthusiast"))
        {
            tmpCPU = new EnthusiastCPU(cpu.getCpuType(), cpu.getCpuManufacturer(), cpu.getCpuModel(), cpu.getCpuCoreCount(), cpu.getCpuClockSpeed(), cpu.getCpuBoostSpeed(), cpu.getLogicalCoreCount(), cpu.isOverclockable(), cpu.getBenchmarkScore());
        }
        else if(cpu.getCpuType().equals("consumer"))
        {
            tmpCPU = new ConsumerCPU(cpu.getCpuType(), cpu.getCpuManufacturer(), cpu.getCpuModel(), cpu.getCpuCoreCount(), cpu.getCpuClockSpeed(), cpu.getCpuBoostSpeed(), cpu.getLogicalCoreCount(), cpu.isOverclockable(), cpu.getBenchmarkScore());
        }
        else if(cpu.getCpuType().equals("budget"))
        {
            tmpCPU = new BudgetCPU(cpu.getCpuType(), cpu.getCpuManufacturer(), cpu.getCpuModel(), cpu.getCpuCoreCount(), cpu.getCpuClockSpeed(), cpu.getCpuBoostSpeed(), cpu.getLogicalCoreCount(), cpu.isOverclockable(), cpu.getBenchmarkScore());
        }
        else if(cpu.getCpuType().equals("server"))
        {
            tmpCPU = new ServerCPU(cpu.getCpuType(), cpu.getCpuManufacturer(), cpu.getCpuModel(), cpu.getCpuCoreCount(), cpu.getCpuClockSpeed(), cpu.getCpuBoostSpeed(), cpu.getLogicalCoreCount(), cpu.isOverclockable(), cpu.getBenchmarkScore());
        }
        else
        {
            tmpCPU = new CPU(cpu.getCpuType(), cpu.getCpuManufacturer(), cpu.getCpuModel(), cpu.getCpuCoreCount(), cpu.getCpuClockSpeed(), cpu.getCpuBoostSpeed(), cpu.getLogicalCoreCount(), cpu.isOverclockable(), cpu.getBenchmarkScore());
        }


        return new Memento(new UserPCSystem(name, tmpCPU,
                new RAM(ram.getRamAmount(), ram.getRamCL(), ram.getRamClockSpeed(), ram.getRamType(), ram.getManufacturer(), ram.getModel()),
                new OS(os.getOsName(), os.getOsBits()),
                tmpGPU,
                new Motherboard(motherboard.getChipsetType(), motherboard.getCpuManufacturer(), motherboard.getModel(), motherboard.getManufacturer(), motherboard.getSocketType()),
                new Disk(disk.getDiskModel(), disk.getDiskManufacturer(), disk.getDiskType(), disk.getDiskSpace())));
    }
    public void restoreFromMemento(Memento memento)
    {
         try
         {
             UserPCSystem previousState = memento.getSavedState();
             this.disk = previousState.getDisk();
             this.gpu = previousState.getGpu();
             this.cpu = previousState.getCpu();
             this.ram = previousState.getRam();
             this.motherboard = previousState.getMotherboard();
             this.os = previousState.getOs();
             System.out.println("System restored to previous state;");
         }
         catch(NullPointerException npe)
         {
             System.out.println("There are no more previous states for this system!");
         }
    }

    public CPU getCpu()
    {
        return cpu;
    }

    public void setCpu(CPU cpu)
    {
        this.cpu = cpu;
    }

    public RAM getRam()
    {
        return ram;
    }

    public void setRam(RAM ram)
    {
        this.ram = ram;
    }

    public OS getOs()
    {
        return os;
    }

    public void setOs(OS os)
    {
        this.os = os;
    }

    public GPU getGpu()
    {
        return gpu;
    }

    public void setGpu(GPU gpu)
    {
        this.gpu = gpu;
    }

    public Motherboard getMotherboard()
    {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard)
    {
        this.motherboard = motherboard;
    }

    public Disk getDisk()
    {
        return disk;
    }

    public void setDisk(Disk disk)
    {
        this.disk = disk;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<GameCheckResults> getCheckedGames()
    {
        return checkedGames;
    }

    public void setCheckedGames(ArrayList<GameCheckResults> checkedGames)
    {
        this.checkedGames = checkedGames;
    }
}
