package pccomponents;

public class CPU extends PCComponent
{
    private String cpuType;
    private String cpuManufacturer;
    private String cpuModel;
    private int cpuCoreCount;
    private double cpuClockSpeed;
    private double cpuBoostSpeed;
    private int logicalCoreCount;
    private boolean isOverclockable;
    private int benchmarkScore;

    public CPU(String cpuType, String cpuManufacturer, String cpuModel, int cpuCoreCount, double cpuClockSpeed, double cpuBoostSpeed, int logicalCoreCount, boolean isOverclockable, int benchmarkScore)
    {
        this.cpuType = cpuType;
        this.cpuManufacturer = cpuManufacturer;
        this.cpuModel = cpuModel;
        this.cpuCoreCount = cpuCoreCount;
        this.cpuClockSpeed = cpuClockSpeed;
        this.cpuBoostSpeed = cpuBoostSpeed;
        this.logicalCoreCount = logicalCoreCount;
        this.isOverclockable = isOverclockable;
        this.benchmarkScore = benchmarkScore;
    }
    public CPU(CPU cpu)
    {
        this.cpuType = cpu.getCpuType();
        this.cpuManufacturer = cpu.getCpuManufacturer();
        this.cpuModel = cpu.getCpuModel();
        this.cpuCoreCount = cpu.getCpuCoreCount();
        this.cpuClockSpeed = cpu.getCpuClockSpeed();
        this.cpuBoostSpeed = cpu.getCpuBoostSpeed();
        this.logicalCoreCount = cpu.getLogicalCoreCount();
        this.isOverclockable = cpu.isOverclockable;
        this.benchmarkScore = cpu.benchmarkScore;
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

    public boolean isOverclockable()
    {
        return isOverclockable;
    }

    public void setOverclockable(boolean overclockable)
    {
        isOverclockable = overclockable;
    }

    public int getBenchmarkScore()
    {
        return benchmarkScore;
    }

    public void setBenchmarkScore(int benchmarkScore)
    {
        this.benchmarkScore = benchmarkScore;
    }

    public String getCpuType()
    {
        return cpuType;
    }

    public void setCpuType(String cpuType)
    {
        this.cpuType = cpuType;
    }
}
