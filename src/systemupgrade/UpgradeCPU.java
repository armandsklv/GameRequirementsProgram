package systemupgrade;

public class UpgradeCPU implements ISystemUpgradePath
{
    @Override
    public String getUpgradePath()
    {
        return "Your CPU should be upgraded to meet the requirements of the game.";
    }
}
