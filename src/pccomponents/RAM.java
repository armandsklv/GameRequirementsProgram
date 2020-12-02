package pccomponents;

public class RAM extends PCComponent
{
    private short ramAmount;
    private byte ramCL;
    private float ramClockSpeed;
    private String ramType;
    private String manufacturer;
    private String model;
    @Override
    public void printComponentInfo()
    {
        System.out.println("RAM: "+manufacturer+" "+model+", "+ramType+", "+ramAmount+"GB, "+ramClockSpeed+"Mhz, "+ramCL+"CL");
    }
}
