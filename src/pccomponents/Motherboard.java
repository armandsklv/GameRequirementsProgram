package pccomponents;

public class Motherboard extends PCComponent
{
    private String chipsetType;
    private String cpuManufacturer;
    private String model;
    private String manufacturer;
    private String socketType;

    public Motherboard(String chipsetType, String cpuManufacturer, String model, String manufacturer, String socketType)
    {
        this.chipsetType = chipsetType;
        this.cpuManufacturer = cpuManufacturer;
        this.model = model;
        this.manufacturer = manufacturer;
        this.socketType = socketType;
    }

    @Override
    public void printComponentInfo()
    {
        System.out.println("Motherboard: "+manufacturer+" "+model+" "+socketType+"socket, "+chipsetType+" chipset");
    }

    public String getChipsetType()
    {
        return chipsetType;
    }

    public void setChipsetType(String chipsetType)
    {
        this.chipsetType = chipsetType;
    }

    public String getCpuManufacturer()
    {
        return cpuManufacturer;
    }

    public void setCpuManufacturer(String cpuManufacturer)
    {
        this.cpuManufacturer = cpuManufacturer;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getSocketType()
    {
        return socketType;
    }

    public void setSocketType(String socketType)
    {
        this.socketType = socketType;
    }
}
