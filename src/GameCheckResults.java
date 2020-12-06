public class GameCheckResults
{
    private final String checkedGameName;
    private final String minUpgradePath;
    private final String recommendedUpgradePath;
    private final boolean minimumRequirementsPass;
    private final boolean recommendedRequirementsPass;

    public GameCheckResults(String checkedGameName, String minUpgradePath, String recommendedUpgradePath)
    {
        this.checkedGameName = checkedGameName;
        this.minUpgradePath = minUpgradePath;
        this.recommendedUpgradePath = recommendedUpgradePath;
        minimumRequirementsPass = this.minUpgradePath.isEmpty();
        recommendedRequirementsPass = this.recommendedUpgradePath.isEmpty();
    }

    public String getCheckedGameName()
    {
        return checkedGameName;
    }

    public String getMinUpgradePath()
    {
        return minUpgradePath;
    }

    public String getRecommendedUpgradePath()
    {
        return recommendedUpgradePath;
    }

    public boolean isMinimumRequirementsPass()
    {
        return minimumRequirementsPass;
    }

    public boolean isRecommendedRequirementsPass()
    {
        return recommendedRequirementsPass;
    }
}
