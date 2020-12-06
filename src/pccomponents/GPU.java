package pccomponents;

public class GPU extends PCComponent
{
    private String gpuModel;
    private String manufacturer;
    private double gpuVRAMAmount;
    private double gpuVRAMClockSpeed;
    private double gpuClockSpeed;
    private double gpuBoostClock;
    private int benchmarkScore;


    public GPU(String gpuModel, String manufacturer, double gpuVRAMAmount, double gpuVRAMClockSpeed, double gpuClockSpeed, double gpuBoostClock, int benchmarkScore)
    {
        this.gpuModel = gpuModel;
        this.manufacturer = manufacturer;
        this.gpuVRAMAmount = gpuVRAMAmount;
        this.gpuVRAMClockSpeed = gpuVRAMClockSpeed;
        this.gpuClockSpeed = gpuClockSpeed;
        this.gpuBoostClock = gpuBoostClock;
        this.benchmarkScore = benchmarkScore;
    }

    @Override
    public void printComponentInfo()
    {
        System.out.println("GPU: "+manufacturer+" "+gpuModel+", "+String.format("%.2f",gpuClockSpeed)+"Mhz Clock/"+String.format("%.2f",gpuBoostClock)+"Mhz Boost, "+gpuVRAMAmount+"GB VRAM, "+String.format("%.2f",gpuVRAMClockSpeed)+" Mhz emory clock speed");
    }

    public String getGpuModel()
    {
        return gpuModel;
    }

    public void setGpuModel(String gpuModel)
    {
        this.gpuModel = gpuModel;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public double getGpuVRAMAmount()
    {
        return gpuVRAMAmount;
    }

    public void setGpuVRAMAmount(double gpuVRAMAmount)
    {
        this.gpuVRAMAmount = gpuVRAMAmount;
    }

    public double getGpuVRAMClockSpeed()
    {
        return gpuVRAMClockSpeed;
    }

    public void setGpuVRAMClockSpeed(double gpuVRAMClockSpeed)
    {
        this.gpuVRAMClockSpeed = gpuVRAMClockSpeed;
    }

    public double getGpuClockSpeed()
    {
        return gpuClockSpeed;
    }

    public void setGpuClockSpeed(double gpuClockSpeed)
    {
        this.gpuClockSpeed = gpuClockSpeed;
    }

    public double getGpuBoostClock()
    {
        return gpuBoostClock;
    }

    public void setGpuBoostClock(double gpuBoostClock)
    {
        this.gpuBoostClock = gpuBoostClock;
    }

    public int getBenchmarkScore()
    {
        return benchmarkScore;
    }

    public void setBenchmarkScore(int benchmarkScore)
    {
        this.benchmarkScore = benchmarkScore;
    }
}
