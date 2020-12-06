package systemupgrade;

public class UpgradeRAM implements ISystemUpgradePath
{
    @Override
    public String getUpgradePath()
    {
        return "Your system does not have enough ram to play the game, it should be upgraded.";
    }
}
