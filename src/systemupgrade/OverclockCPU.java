package systemupgrade;

public class OverclockCPU implements ISystemUpgradePath
{

    @Override
    public String getUpgradePath()
    {
        return "Your CPU is not as powerful as necessary, but it can be overclocked to gain the power difference.\n";
    }
}
