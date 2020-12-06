package systemupgrade;

public class UpgradeOS implements ISystemUpgradePath
{
    @Override
    public String getUpgradePath()
    {
        return "Your operating system should be upgraded to a newer one in order to play the game.";
    }
}
