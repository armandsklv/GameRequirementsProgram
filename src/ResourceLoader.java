import com.google.gson.Gson;
import pccomponents.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ResourceLoader
{
    public ArrayList<User> getUsers()
    {
        ArrayList<User> tmpUsers = new ArrayList<>();
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
            tmpUsers.add(new Gson().fromJson(json,User.class));
        }
        return tmpUsers;
    }
    public ArrayList<CPU> getCPUList()//In progress
    {
        ArrayList<CPU> tmpCPUs = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        try
        {
            File[] cpuFiles = new File("data/components/cpus").listFiles();
            for (File cpu : cpuFiles)
            {
                if (cpu.isFile())
                {
                    results.add(cpu.getName());
                }
            }
        }
        catch (NullPointerException npe)
        {
            System.out.println("Couldn't read cpu files or no cpu's exist.");
        }

        String json = "";
        for(String cpu : results)
        {
            try
            {
                json = new String ( Files.readAllBytes( Paths.get("data/components/cpus/"+cpu) ) );
            }
            catch (IOException e)
            {
                System.out.println("Couldn't read cpu from file!");
            }
            tmpCPUs.add(new Gson().fromJson(json,CPU.class));
        }
        return tmpCPUs;
    }
    public ArrayList<Disk> getDiskList()
    {
        ArrayList<Disk> tmpDisks = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        try
        {
            File[] diskFiles = new File("data/components/disks").listFiles();
            for (File disk : diskFiles)
            {
                if (disk.isFile())
                {
                    results.add(disk.getName());
                }
            }
        }
        catch (NullPointerException npe)
        {
            System.out.println("Couldn't read disk files or no disks exist.");
        }

        String json = "";
        for(String disk : results)
        {
            try
            {
                json = new String ( Files.readAllBytes( Paths.get("data/components/disks/"+disk) ) );
            }
            catch (IOException e)
            {
                System.out.println("Couldn't read disk from file!");
            }
            tmpDisks.add(new Gson().fromJson(json,Disk.class));
        }
        return tmpDisks;
    }
    public ArrayList<GPU> getGPUList()
    {
        ArrayList<GPU> tmpGPUs = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        try
        {
            File[] gpuFiles = new File("data/components/gpus").listFiles();
            for (File gpu : gpuFiles)
            {
                if (gpu.isFile())
                {
                    results.add(gpu.getName());
                }
            }
        }
        catch (NullPointerException npe)
        {
            System.out.println("Couldn't read gpu files or no gpu's exist.");
        }

        String json = "";
        for(String gpu : results)
        {
            try
            {
                json = new String ( Files.readAllBytes( Paths.get("data/components/gpus/"+gpu) ) );
            }
            catch (IOException e)
            {
                System.out.println("Couldn't read gpu from file!");
            }
            tmpGPUs.add(new Gson().fromJson(json, GPU.class));
        }
        return tmpGPUs;
    }
    public ArrayList<Motherboard> getMotherboardList()
    {
        ArrayList<Motherboard> tmpMotherboardList = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        try
        {
            File[] motherboardFiles = new File("data/components/motherboards").listFiles();
            for (File motherboard : motherboardFiles)
            {
                if (motherboard.isFile())
                {
                    results.add(motherboard.getName());
                }
            }
        }
        catch (NullPointerException npe)
        {
            System.out.println("Couldn't read motherboard files or no motherboards exist.");
        }

        String json = "";
        for(String motherboard : results)
        {
            try
            {
                json = new String ( Files.readAllBytes( Paths.get("data/components/motherboards/"+motherboard) ) );
            }
            catch (IOException e)
            {
                System.out.println("Couldn't read motherboard from file!");
            }
            tmpMotherboardList.add(new Gson().fromJson(json, Motherboard.class));
        }
        return tmpMotherboardList;
    }
    public ArrayList<RAM> getRAMList()
    {
        ArrayList<RAM> tmpRAMList = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        try
        {
            File[] RAMFiles = new File("data/components/ram").listFiles();
            for (File ram : RAMFiles)
            {
                if (ram.isFile())
                {
                    results.add(ram.getName());
                }
            }
        }
        catch (NullPointerException npe)
        {
            System.out.println("Couldn't read ram files or no ram's exist.");
        }

        String json = "";
        for(String ram : results)
        {
            try
            {
                json = new String ( Files.readAllBytes( Paths.get("data/components/ram/"+ram) ) );
            }
            catch (IOException e)
            {
                System.out.println("Couldn't read ram from file!");
            }
            tmpRAMList.add(new Gson().fromJson(json, RAM.class));
        }
        return tmpRAMList;
    }
    public ArrayList<OS> getOSList()
    {
        ArrayList<OS> tmpOSList = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        try
        {
            File[] OSFiles = new File("data/components/os").listFiles();
            for (File os : OSFiles)
            {
                if (os.isFile())
                {
                    results.add(os.getName());
                }
            }
        }
        catch (NullPointerException npe)
        {
            System.out.println("Couldn't read os files or no os's exist.");
        }

        String json = "";
        for(String os : results)
        {
            try
            {
                json = new String ( Files.readAllBytes( Paths.get("data/components/os/"+os) ) );
            }
            catch (IOException e)
            {
                System.out.println("Couldn't read os from file!");
            }
            tmpOSList.add(new Gson().fromJson(json, OS.class));
        }
        return tmpOSList;
    }
}
