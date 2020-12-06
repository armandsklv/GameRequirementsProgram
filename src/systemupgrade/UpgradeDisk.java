package systemupgrade;

public class UpgradeDisk implements ISystemUpgradePath
{
    @Override
    public String getUpgradePath()
    {
        return "Your disk does not have enough space for the game, it should be upgraded!";
    }
}
