package systemupgrade;

public class OverclockGPU implements ISystemUpgradePath
{

    @Override
    public String getUpgradePath()
    {
        return "Your GPU is not as powerful as necessary, but it can be overclocked to gain the power difference.\n";
    }
}
