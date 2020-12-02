package pccomponents;

public class Motherboard extends PCComponent
{
    private String chipsetType;
    private String cpuManufacturer;
    private String model;
    private String manufacturer;
    private String socketType;

    @Override
    public void printComponentInfo()
    {
        System.out.println("Motherboard: "+manufacturer+" "+model+" "+socketType+"socket, "+chipsetType+" chipset");
    }
}
