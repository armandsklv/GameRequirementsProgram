package pccomponents;

public class GPU extends PCComponent
{
    private String gpuModel;
    private String manufacturer;
    private float gpuVRAMAmount;
    private float gpuVRAMClockSpeed;
    private float gpuClockSpeed;
    private float gpuBoostClock;
    private boolean overclockPotential;// yes or no
    private String gpuPower; //LOW, AVERAGE, HIGH
    @Override
    public void printComponentInfo()
    {
        System.out.println("GPU: "+manufacturer+" "+gpuModel+", "+gpuClockSpeed+"Mhz Clock/"+gpuBoostClock+"Mhz Boost, "+gpuVRAMAmount+"GB VRAM, "+gpuVRAMClockSpeed+"Memory clock speed");
    }
}
