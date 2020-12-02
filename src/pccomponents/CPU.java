package pccomponents;

public class CPU extends PCComponent
{
    private String cpuManufacturer;
    private String cpuModel;
    private short cpuCoreCount;
    private float cpuClockSpeed;
    private float cpuBoostSpeed;
    private boolean cpuHasHyperthread;
    private short logicalCoreCount;
    private boolean overclockPotential;// yes or no
    private String cpuPower; //LOW, AVERAGE, HIGH
    public CPU()
    {
        logicalCoreCount = cpuHasHyperthread ? (short) (cpuCoreCount * 2) : cpuCoreCount;
    }
    @Override
    public void printComponentInfo()
    {
        System.out.println("CPU: "+cpuManufacturer+" "+cpuModel+", "+cpuClockSpeed+"Ghz Clock/"+cpuBoostSpeed+"Ghz Boost, "+cpuCoreCount+"C/"+logicalCoreCount+"T");
    }
}
