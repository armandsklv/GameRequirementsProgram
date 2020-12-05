package pccomponents.gputypes;

import pccomponents.GPU;
import pccomponents.IGPUGrade;

public class BudgetGPU extends GPU implements IGPUGrade
{
    private boolean overclockPotential;// yes or no
    private String gpuPower; //LOW, AVERAGE, HIGH
    public BudgetGPU(String gpuModel, String manufacturer, double gpuVRAMAmount, double gpuVRAMClockSpeed, double gpuClockSpeed, double gpuBoostClock)
    {
        super(gpuModel, manufacturer, gpuVRAMAmount, gpuVRAMClockSpeed, gpuClockSpeed, gpuBoostClock);
        setOverclockPotential();
        gpuPower = "LOW";
    }

    @Override
    public boolean hasOverclockPotential()
    {
        return overclockPotential;
    }

    @Override
    public void setOverclockPotential()
    {
        overclockPotential = false;
    }

    @Override
    public String getGpuPower()
    {
        return gpuPower;
    }
}
