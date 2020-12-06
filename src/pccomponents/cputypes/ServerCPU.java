package pccomponents.cputypes;

import pccomponents.CPU;
import pccomponents.ICPUGrade;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerCPU extends CPU implements ICPUGrade
{
    private boolean overclockPotential;// yes or no
    private String cpuPower; //LOW, AVERAGE, HIGH
    public ServerCPU(String cpuManufacturer, String cpuModel, int cpuCoreCount, double cpuClockSpeed, double cpuBoostSpeed, int logicalCoreCount, boolean isOverclockable, int benchmarkScore)
    {
        super(cpuManufacturer, cpuModel, cpuCoreCount, cpuClockSpeed, cpuBoostSpeed, logicalCoreCount, isOverclockable, benchmarkScore);
        setOverclockPotential();
        cpuPower = "HIGH";
    }

    @Override
    public boolean hasOverclockPotential()
    {
        return overclockPotential;
    }

    @Override
    public void setOverclockPotential()
    {
        overclockPotential=false;
    }

    @Override
    public String getCpuPower()
    {
        return cpuPower;
    }

}
