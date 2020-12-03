package pccomponents;

public class CPU extends PCComponent
{
    private String cpuManufacturer;
    private String cpuModel;
    private int cpuCoreCount;
    private double cpuClockSpeed;
    private double cpuBoostSpeed;
    private int logicalCoreCount;
    private boolean overclockPotential;// yes or no
    private String cpuPower; //LOW, AVERAGE, HIGH

    public CPU(String cpuManufacturer, String cpuModel, int cpuCoreCount, double cpuClockSpeed, double cpuBoostSpeed, int logicalCoreCount)
    {
        this.cpuManufacturer = cpuManufacturer;
        this.cpuModel = cpuModel;
        this.cpuCoreCount = cpuCoreCount;
        this.cpuClockSpeed = cpuClockSpeed;
        this.cpuBoostSpeed = cpuBoostSpeed;
        this.logicalCoreCount = logicalCoreCount;
    }
    @Override
    public void printComponentInfo()
    {
        System.out.println("CPU: "+cpuManufacturer+" "+cpuModel+", "+String.format("%.2f",cpuClockSpeed)+"Ghz Clock/"+String.format("%.2f",cpuBoostSpeed)+"Ghz Boost, "+cpuCoreCount+"C/"+logicalCoreCount+"T");
    }

    public String getCpuManufacturer()
    {
        return cpuManufacturer;
    }

    public void setCpuManufacturer(String cpuManufacturer)
    {
        this.cpuManufacturer = cpuManufacturer;
    }

    public String getCpuModel()
    {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel)
    {
        this.cpuModel = cpuModel;
    }

    public int getCpuCoreCount()
    {
        return cpuCoreCount;
    }

    public void setCpuCoreCount(int cpuCoreCount)
    {
        this.cpuCoreCount = cpuCoreCount;
    }

    public double getCpuClockSpeed()
    {
        return cpuClockSpeed;
    }

    public void setCpuClockSpeed(double cpuClockSpeed)
    {
        this.cpuClockSpeed = cpuClockSpeed;
    }

    public double getCpuBoostSpeed()
    {
        return cpuBoostSpeed;
    }

    public void setCpuBoostSpeed(double cpuBoostSpeed)
    {
        this.cpuBoostSpeed = cpuBoostSpeed;
    }

    public int getLogicalCoreCount()
    {
        return logicalCoreCount;
    }

    public void setLogicalCoreCount(int logicalCoreCount)
    {
        this.logicalCoreCount = logicalCoreCount;
    }

    public boolean isOverclockPotential()
    {
        return overclockPotential;
    }

    public void setOverclockPotential(boolean overclockPotential)
    {
        this.overclockPotential = overclockPotential;
    }

    public String getCpuPower()
    {
        return cpuPower;
    }

    public void setCpuPower(String cpuPower)
    {
        this.cpuPower = cpuPower;
    }
}
