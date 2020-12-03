public class Memento
{
    private final UserPCSystem state;

    Memento(UserPCSystem state)
    {
        this.state = state;
    }
    UserPCSystem getSavedState()
    {
        return this.state;
    }
}
