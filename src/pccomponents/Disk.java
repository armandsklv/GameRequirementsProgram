package pccomponents;

public class Disk extends PCComponent
{
    private String diskModel;
    private String diskManufacturer;
    private String diskType;
    private short diskSpace;
    @Override
    public void printComponentInfo()
    {
        System.out.println("Disk drive: "+diskManufacturer+" "+diskModel+", type: "+diskType+", size: "+diskSpace+"GB");
    }
}
