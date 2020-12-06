package systemupgrade;

public class Context
{
   private ISystemUpgradePath strategy;
   public Context(ISystemUpgradePath strategy)
   {
       this.strategy = strategy;
   }
   public String executeStrategy()
   {
       return strategy.getUpgradePath();
   }
}
