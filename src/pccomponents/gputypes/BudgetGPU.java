package pccomponents.gputypes;

import pccomponents.GPU;
import pccomponents.IGPUGrade;
import pccomponents.cputypes.BudgetCPU;

public class BudgetGPU extends GPU implements IGPUGrade
{
    private boolean overclockPotential;// yes or no
    private String gpuPower; //LOW, AVERAGE, HIGH
    public BudgetGPU(String gpuType, String gpuModel, String manufacturer, double gpuVRAMAmount, double gpuVRAMClockSpeed, double gpuClockSpeed, double gpuBoostClock, int benchmarkScore)
    {
        super(gpuType, gpuModel, manufacturer, gpuVRAMAmount, gpuVRAMClockSpeed, gpuClockSpeed, gpuBoostClock, benchmarkScore);
        setOverclockPotential();
        gpuPower = "LOW";
    }
    public BudgetGPU(GPU gpu)
    {
        super(gpu);
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
