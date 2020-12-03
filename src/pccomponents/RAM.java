package pccomponents;

public class RAM extends PCComponent
{
    private int ramAmount;
    private int ramCL;
    private double ramClockSpeed;
    private String ramType;
    private String manufacturer;
    private String model;

    public RAM(int ramAmount, int ramCL, double ramClockSpeed, String ramType, String manufacturer, String model)
    {
        this.ramAmount = ramAmount;
        this.ramCL = ramCL;
        this.ramClockSpeed = ramClockSpeed;
        this.ramType = ramType;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    public void printComponentInfo()
    {
        System.out.println("RAM: "+manufacturer+" "+model+", "+ramType+", "+ramAmount+"GB, "+String.format("%.2f",ramClockSpeed)+"Mhz, "+ramCL+"CL");
    }

    public int getRamAmount()
    {
        return ramAmount;
    }

    public void setRamAmount(int ramAmount)
    {
        this.ramAmount = ramAmount;
    }

    public int getRamCL()
    {
        return ramCL;
    }

    public void setRamCL(int ramCL)
    {
        this.ramCL = ramCL;
    }

    public double getRamClockSpeed()
    {
        return ramClockSpeed;
    }

    public void setRamClockSpeed(double ramClockSpeed)
    {
        this.ramClockSpeed = ramClockSpeed;
    }

    public String getRamType()
    {
        return ramType;
    }

    public void setRamType(String ramType)
    {
        this.ramType = ramType;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }
}
