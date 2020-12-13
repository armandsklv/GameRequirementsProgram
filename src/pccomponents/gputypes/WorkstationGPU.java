package pccomponents.gputypes;

import pccomponents.GPU;
import pccomponents.IGPUGrade;

public class WorkstationGPU extends GPU implements IGPUGrade
{
    private boolean overclockPotential;// yes or no
    private String gpuPower; //LOW, AVERAGE, HIGH
    public WorkstationGPU(String gpuType, String gpuModel, String manufacturer, double gpuVRAMAmount, double gpuVRAMClockSpeed, double gpuClockSpeed, double gpuBoostClock, int benchmarkScore)
    {
        super(gpuType, gpuModel, manufacturer, gpuVRAMAmount, gpuVRAMClockSpeed, gpuClockSpeed, gpuBoostClock, benchmarkScore);
        setOverclockPotential();
        gpuPower = "HIGH";
    }
    public WorkstationGPU(GPU gpu)
    {
        super(gpu);
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

    }

    @Override
    public String getGpuPower()
    {
        return gpuPower;
    }

}
