package pccomponents;

public class OS extends PCComponent
{
    private String os;
    private byte osBits;
    @Override
    public void printComponentInfo()
    {
        System.out.println("OS: "+os+", "+osBits);
    }
}
