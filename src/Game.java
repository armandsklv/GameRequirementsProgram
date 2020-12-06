public class Game
{
    private final String name;
    private final MinimumRequirements minimumRequirements;
    private final RecommendedRequirements recommendedRequirements;

    public Game(String name, MinimumRequirements minimumRequirements, RecommendedRequirements recommendedRequirements)
    {
        this.name = name;
        this.minimumRequirements = minimumRequirements;
        this.recommendedRequirements = recommendedRequirements;
    }

    public String getName()
    {
        return name;
    }

    public MinimumRequirements getMinimumRequirements()
    {
        return minimumRequirements;
    }

    public RecommendedRequirements getRecommendedRequirements()
    {
        return recommendedRequirements;
    }
}
