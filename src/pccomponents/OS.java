package pccomponents;

public class OS extends PCComponent
{
    private String osName;
    private int osBits;

    public OS(String osName, int osBits)
    {
        this.osName = osName;
        this.osBits = osBits;
    }

    @Override
    public void printComponentInfo()
    {
        System.out.println("OS: "+osName+", "+osBits);
    }

    public String getOsName()
    {
        return osName;
    }

    public void setOsName(String osName)
    {
        this.osName = osName;
    }

    public int getOsBits()
    {
        return osBits;
    }

    public void setOsBits(int osBits)
    {
        this.osBits = osBits;
    }
}
