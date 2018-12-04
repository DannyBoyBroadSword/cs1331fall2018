/**
 * The foundation for any AI Doctor CS creates.
 *
 * @author ahennessy6
 * @version 1.0
 */
public abstract class AI {

    private boolean destructed = false;
    private Coordinates cannonTarget;
    private Coordinates secretHQ;

    /**
     * @return boolean should swap cannon
     */
    public abstract boolean shouldSwapCannonTarget();

    /**
     * @return boolean shouldSelf destruct
     */
    public abstract boolean shouldSelfDestruct();

    /**
     * Constructor for AI.
     * @param cannonTarget Coordintes of Cannontarget
     * @param secretHQ coordinates of secretHQ
     */
    public AI(Coordinates cannonTarget, Coordinates secretHQ) {
        this.cannonTarget = cannonTarget;
        this.secretHQ = secretHQ;
    }

    /**
     * Attempts to change cannonTarget instance Var.
     * @param newCoords new coords for cannon
     * @return boolean if the cannon target was swapped
     */
    public boolean swapCannonTarget(Coordinates newCoords) {
        if ((!this.getDestructed()) && newCoords != this.getCannonTarget()) {
            if (this.shouldSwapCannonTarget()) {
                this.cannonTarget = newCoords;
                return true;
            } else if (this.shouldSelfDestruct()) {
                this.selfDestruct();
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * getDestructed getter for destructed instance var.
     *
     * @return destructed if the target was destructed
     */
    public boolean getDestructed() {
        return destructed;
    }

    /**
     * getCannonTarget getter for cannonTarget instance var.
     *
     * @return cannonTarget is the coords of the cannontarget
     */
    public Coordinates getCannonTarget() {
        return cannonTarget;
    }

    /**
     * getSecretHQ getter for secretHQ instance var.
     *
     * @return secretHQ coords of secrethq
     */
    public Coordinates getSecretHQ() {
        return secretHQ;
    }

    /**
     *
     * invoke for self destruct
     *
     */
    public void selfDestruct() {
        this.destructed = true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format(
                "Dr. Chipotle's guacamole cannon is currently pointed at %s.",
                this.getCannonTarget());
    }

}
