package pccomponents.gputypes;

import pccomponents.GPU;
import pccomponents.IGPUGrade;

public class EnthusiastGPU extends GPU implements IGPUGrade
{
    private boolean overclockPotential;// yes or no
    private String gpuPower; //LOW, AVERAGE, HIGH
    public EnthusiastGPU(String gpuModel, String manufacturer, double gpuVRAMAmount, double gpuVRAMClockSpeed, double gpuClockSpeed, double gpuBoostClock)
    {
        super(gpuModel, manufacturer, gpuVRAMAmount, gpuVRAMClockSpeed, gpuClockSpeed, gpuBoostClock);
        setOverclockPotential();
        gpuPower = "HIGH";
    }

    @Override
    public boolean hasOverclockPotential()
    {
        return overclockPotential;
    }

    @Override
    public void setOverclockPotential()
    {
        overclockPotential = true;
    }

    @Override
    public String getGpuPower()
    {
        return gpuPower;
    }

}
