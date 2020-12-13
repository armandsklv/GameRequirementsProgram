package pccomponents.cputypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pccomponents.CPU;
import pccomponents.ICPUGrade;

public class BudgetCPU extends CPU implements ICPUGrade
{
    private boolean overclockPotential;// yes or no
    private String cpuPower; //LOW, AVERAGE, HIGH
    public BudgetCPU(String cpuType, String cpuManufacturer, String cpuModel, int cpuCoreCount, double cpuClockSpeed, double cpuBoostSpeed, int logicalCoreCount, boolean isOverclockable, int benchmarkScore)
    {
        super(cpuType, cpuManufacturer, cpuModel, cpuCoreCount, cpuClockSpeed, cpuBoostSpeed, logicalCoreCount, isOverclockable, benchmarkScore);
        setOverclockPotential();
        cpuPower = "LOW";
    }
    public BudgetCPU(CPU cpu)
    {
        super(cpu);
        setOverclockPotential();
        cpuPower = "LOW";
    }

    @Override
    public boolean hasOverclockPotential()
    {
        return overclockPotential;
    }

    @Override
    public void setOverclockPotential()
    {
        if(this.isOverclockable())
        {
            if(this.getCpuManufacturer().equals("AMD"))//All of AMD cpu's can be overclocked, however only the X, XT and non X versions of amd ryzen cpu's has overclock potential
            {
                Pattern pattern = Pattern.compile("\\w+(\\s)(\\d)(\\s)(\\d{4})([^(GgHhUu)]?)", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(this.getCpuModel());
                boolean matchFound = matcher.find();
                overclockPotential = !matchFound;
            }
            else//All of Intel cpu's which can be overclocked, has overclock potential to actually increase performance
            {
                overclockPotential = true;
            }
        }
        else
        {
            overclockPotential = false;
        }
    }

    @Override
    public String getCpuPower()
    {
        return cpuPower;
    }

}
