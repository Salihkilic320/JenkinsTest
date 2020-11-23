/**
 * A letter which can be delivered to the depot and then added to a deliverer.
 * It extends the Package class the only difference is that the weight is always 2.
 */
public class Letter extends Package
{
    /**
     * Creates an instance of a letter
     * @param packageNumber The number of the letter.
     * @param sender The sender of the letter.
     * @param receiver The reciever of the letter.
     */
    public Letter(int packageNumber, String sender, String receiver)
    {
        super(packageNumber, 2, sender, receiver);
    }
}
