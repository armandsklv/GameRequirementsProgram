package systemupgrade;

public class UpgradeGPU implements ISystemUpgradePath
{
    @Override
    public String getUpgradePath()
    {
        return "Your GGU should be upgraded to meet the requirements of the game.";
    }
}
