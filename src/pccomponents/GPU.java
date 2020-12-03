package pccomponents;

public class GPU extends PCComponent
{
    private String gpuModel;
    private String manufacturer;
    private double gpuVRAMAmount;
    private double gpuVRAMClockSpeed;
    private double gpuClockSpeed;
    private double gpuBoostClock;
    private boolean overclockPotential;// yes or no
    private String gpuPower; //LOW, AVERAGE, HIGH

    public GPU(String gpuModel, String manufacturer, double gpuVRAMAmount, double gpuVRAMClockSpeed, double gpuClockSpeed, double gpuBoostClock)
    {
        this.gpuModel = gpuModel;
        this.manufacturer = manufacturer;
        this.gpuVRAMAmount = gpuVRAMAmount;
        this.gpuVRAMClockSpeed = gpuVRAMClockSpeed;
        this.gpuClockSpeed = gpuClockSpeed;
        this.gpuBoostClock = gpuBoostClock;
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

    public boolean isOverclockPotential()
    {
        return overclockPotential;
    }

    public void setOverclockPotential(boolean overclockPotential)
    {
        this.overclockPotential = overclockPotential;
    }

    public String getGpuPower()
    {
        return gpuPower;
    }

    public void setGpuPower(String gpuPower)
    {
        this.gpuPower = gpuPower;
    }
}
