package pccomponents.gputypes;

import pccomponents.GPU;
import pccomponents.IGPUGrade;

public class ConsumerGPU extends GPU implements IGPUGrade
{
    private boolean overclockPotential;// yes or no
    private String gpuPower; //LOW, AVERAGE, HIGH
    public ConsumerGPU(String gpuModel, String manufacturer, double gpuVRAMAmount, double gpuVRAMClockSpeed, double gpuClockSpeed, double gpuBoostClock)
    {
        super(gpuModel, manufacturer, gpuVRAMAmount, gpuVRAMClockSpeed, gpuClockSpeed, gpuBoostClock);
        setOverclockPotential();
        gpuPower = "AVERAGE";
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
