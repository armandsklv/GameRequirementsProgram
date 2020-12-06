import com.google.gson.Gson;
import pccomponents.CPU;
import pccomponents.GPU;
import systemupgrade.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameRequirementsChecker
{
    private String gameName;
    private GameRequirements gameMinimumRequirements;
    private GameRequirements gameRecommendedRequirements;
    private UserPCSystem userPCSystem;
    private String minUpgradePath;
    private String recommendedUpgradePath;

    public GameRequirementsChecker(Game game, UserPCSystem userPCSystem)
    {
        this.gameMinimumRequirements = game.getMinimumRequirements();
        if(game.getRecommendedRequirements() != null)
        {
            this.gameRecommendedRequirements = game.getRecommendedRequirements();
        }
        gameName = game.getName();
        this.userPCSystem = userPCSystem;
    }
    public GameCheckResults getRequirementsComparisonResults()
    {
        compareMinimumRequirements();
        compareRecommendedRequirements();
        return new GameCheckResults(gameName, minUpgradePath, recommendedUpgradePath);
    }

    private void compareMinimumRequirements()
    {
        String cpuName;
        if(userPCSystem.getCpu().getCpuManufacturer().equals("AMD"))
        {
            cpuName = gameMinimumRequirements.getAmdCpu();
        }
        else
        {
            cpuName = gameMinimumRequirements.getIntelCpu();
        }
        if(getCpuBenchmarkScore(cpuName) > userPCSystem.getCpu().getBenchmarkScore())
        {
            if((float)getCpuBenchmarkScore(cpuName)/userPCSystem.getCpu().getBenchmarkScore() < 1.075)
            {
                minUpgradePath = minUpgradePath.concat(new Context(new OverclockCPU()).executeStrategy());
            }
            else
            {
                minUpgradePath = minUpgradePath.concat(new Context(new UpgradeCPU()).executeStrategy());
            }
        }
        String gpuName;
        if(userPCSystem.getGpu().getManufacturer().equals("NVIDIA"))
        {
            gpuName = gameMinimumRequirements.getNvidiaGpu();
            if(getGpuBenchmarkScore(gpuName) > userPCSystem.getGpu().getBenchmarkScore())
            {
                if((float)getGpuBenchmarkScore(gpuName)/userPCSystem.getGpu().getBenchmarkScore() < 1.075)
                {
                    minUpgradePath = minUpgradePath.concat(new Context(new OverclockGPU()).executeStrategy());
                }
                else
                {
                    minUpgradePath = minUpgradePath.concat(new Context(new UpgradeGPU()).executeStrategy());
                }
            }
        }
        else
        {
            gpuName = gameMinimumRequirements.getAMDGpu();
            if(getGpuBenchmarkScore(gpuName) > userPCSystem.getGpu().getBenchmarkScore())
            {
                if((float)getGpuBenchmarkScore(gpuName)/userPCSystem.getGpu().getBenchmarkScore() < 1.075)
                {
                    minUpgradePath = minUpgradePath.concat(new Context(new OverclockGPU()).executeStrategy());
                }
                else
                {
                    minUpgradePath = minUpgradePath.concat(new Context(new UpgradeGPU()).executeStrategy());
                }
            }
            else if(gameMinimumRequirements.getGpuVRAM() > userPCSystem.getGpu().getGpuVRAMAmount())
            {
                minUpgradePath = minUpgradePath.concat(new Context(new UpgradeGPU()).executeStrategy());
            }
        }
        if(gameMinimumRequirements.getRam() > userPCSystem.getRam().getRamAmount())
        {
            minUpgradePath = minUpgradePath.concat(new Context(new UpgradeRAM()).executeStrategy());
        }
        if(gameMinimumRequirements.getDiskSpace() > userPCSystem.getDisk().getDiskSpace())
        {
            minUpgradePath = minUpgradePath.concat(new Context(new UpgradeDisk()).executeStrategy());
        }
        if(!gameMinimumRequirements.getOs().equals(userPCSystem.getOs().getOsName()))
        {
            minUpgradePath = minUpgradePath.concat(new Context(new UpgradeOS()).executeStrategy());
        }
    }
    private void compareRecommendedRequirements()
    {
        String cpuName;
        if (userPCSystem.getCpu().getCpuManufacturer().equals("AMD"))
        {
            cpuName = gameRecommendedRequirements.getAmdCpu();
        } else
        {
            cpuName = gameRecommendedRequirements.getIntelCpu();
        }
        if (getCpuBenchmarkScore(cpuName) > userPCSystem.getCpu().getBenchmarkScore())
        {
            if ((float) getCpuBenchmarkScore(cpuName) / userPCSystem.getCpu().getBenchmarkScore() < 1.075)
            {
                minUpgradePath = minUpgradePath.concat(new Context(new OverclockCPU()).executeStrategy());
            } else
            {
                minUpgradePath = minUpgradePath.concat(new Context(new UpgradeCPU()).executeStrategy());
            }
        }
        String gpuName;
        if (userPCSystem.getGpu().getManufacturer().equals("NVIDIA"))
        {
            gpuName = gameRecommendedRequirements.getNvidiaGpu();
            if (getGpuBenchmarkScore(gpuName) > userPCSystem.getGpu().getBenchmarkScore())
            {
                if ((float) getGpuBenchmarkScore(gpuName) / userPCSystem.getGpu().getBenchmarkScore() < 1.075)
                {
                    minUpgradePath = minUpgradePath.concat(new Context(new OverclockGPU()).executeStrategy());
                } else
                {
                    minUpgradePath = minUpgradePath.concat(new Context(new UpgradeGPU()).executeStrategy());
                }
            }
        } else
        {
            gpuName = gameRecommendedRequirements.getAMDGpu();
            if (getGpuBenchmarkScore(gpuName) > userPCSystem.getGpu().getBenchmarkScore())
            {
                if ((float) getGpuBenchmarkScore(gpuName) / userPCSystem.getGpu().getBenchmarkScore() < 1.075)
                {
                    minUpgradePath = minUpgradePath.concat(new Context(new OverclockGPU()).executeStrategy());
                } else
                {
                    minUpgradePath = minUpgradePath.concat(new Context(new UpgradeGPU()).executeStrategy());
                }
            } else if (gameRecommendedRequirements.getGpuVRAM() > userPCSystem.getGpu().getGpuVRAMAmount())
            {
                minUpgradePath = minUpgradePath.concat(new Context(new UpgradeGPU()).executeStrategy());
            }
        }
        if (gameRecommendedRequirements.getRam() > userPCSystem.getRam().getRamAmount())
        {
            minUpgradePath = minUpgradePath.concat(new Context(new UpgradeRAM()).executeStrategy());
        }
        if (gameRecommendedRequirements.getDiskSpace() > userPCSystem.getDisk().getDiskSpace())
        {
            minUpgradePath = minUpgradePath.concat(new Context(new UpgradeDisk()).executeStrategy());
        }
        if (!gameRecommendedRequirements.getOs().equals(userPCSystem.getOs().getOsName()))
        {
            minUpgradePath = minUpgradePath.concat(new Context(new UpgradeOS()).executeStrategy());
        }
    }
    private int getCpuBenchmarkScore(String cpuName)
    {
        String json = "";
        try
        {
            json = new String ( Files.readAllBytes( Paths.get("data/components/cpus/"+cpuName+".JSON") ) );
        }
        catch (IOException e)
        {
            System.out.println("Couldn't read cpu benchmark score from file!");
        }
        CPU cpu = new Gson().fromJson(json,CPU.class);
        return cpu.getBenchmarkScore();
    }
    private int getGpuBenchmarkScore(String gpuName)
    {
        String json = "";
        try
        {
            json = new String ( Files.readAllBytes( Paths.get("data/components/gpus/"+gpuName+".JSON") ) );
        }
        catch (IOException e)
        {
            System.out.println("Couldn't read cpu benchmark score from file!");
        }
        GPU gpu = new Gson().fromJson(json,GPU.class);
        return gpu.getBenchmarkScore();
    }
}
