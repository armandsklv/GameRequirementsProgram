package pccomponents;

public class Disk extends PCComponent
{
    private String diskModel;
    private String diskManufacturer;
    private String diskType;
    private int diskSpace;

    public Disk(String diskModel, String diskManufacturer, String diskType, int diskSpace)
    {
        this.diskModel = diskModel;
        this.diskManufacturer = diskManufacturer;
        this.diskType = diskType;
        this.diskSpace = diskSpace;
    }

    @Override
    public void printComponentInfo()
    {
        System.out.println("Disk drive: "+diskManufacturer+" "+diskModel+", type: "+diskType+", size: "+diskSpace+"GB");
    }

    public String getDiskModel()
    {
        return diskModel;
    }

    public void setDiskModel(String diskModel)
    {
        this.diskModel = diskModel;
    }

    public String getDiskManufacturer()
    {
        return diskManufacturer;
    }

    public void setDiskManufacturer(String diskManufacturer)
    {
        this.diskManufacturer = diskManufacturer;
    }

    public String getDiskType()
    {
        return diskType;
    }

    public void setDiskType(String diskType)
    {
        this.diskType = diskType;
    }

    public int getDiskSpace()
    {
        return diskSpace;
    }

    public void setDiskSpace(int diskSpace)
    {
        this.diskSpace = diskSpace;
    }
}
