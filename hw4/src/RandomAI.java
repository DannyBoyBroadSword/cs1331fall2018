import java.util.Random;
/**
 * RandomAI class.
 *
 * @author ahennessy6
 * @version 1.0
 */
public class RandomAI extends AI {
    private static final Random RANDOMIZER = new Random();

    /**
     * Constructor for RandomAI.
     * @param cannonTarget cannontarget object
     * @param secretHQ secret hq target object
     */
    public RandomAI(Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
    }

    /* (non-Javadoc)
     * @see AI#shouldSwapCannonTarget()
     */
    @Override
    public boolean shouldSwapCannonTarget() {
        return RANDOMIZER.nextInt(2) == 0;
    }

    /* (non-Javadoc)
     * @see AI#shouldSelfDestruct()
     */
    @Override
    public boolean shouldSelfDestruct() {
        return RANDOMIZER.nextInt(2) == 0;
    }

}
