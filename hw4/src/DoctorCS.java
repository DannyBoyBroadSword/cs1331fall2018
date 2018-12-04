/**
 * 1.The following method recipe stated forces us to use downcasting which means
 * treating a reference as an instance of one of its sub classes. Is not safe in
 * general because subclasses may add methods not present in super Classes.
 * Hence why java doesn't implicitly downcast in assignment statements. 2.
 * 2. add abstract methods to AI to ensure that savetheday's associated method
 * calls are part of RogueAI instances.
 * @author ahennessy6
 * @version 1.0
 */
public class DoctorCS {
    private AI ai;
    private final String secretIdentity;
    private final int jlaid;
    private boolean safe;

    /**
     * getter for ai instance Var.
     * @return ai returns AI object
     */
    public AI getAI() {
        return ai;
    }

    /**
     * getter for jlaid instance Var.
     * @return jlaid returns jlaid int
     */
    public int getJlaid() {
        return jlaid;
    }

    /**
     * Constructor for DoctorCS
     * @param ai             ai object
     * @param secretIdentity private secret idenitity
     * @param jlaid          jlaid value.
     */
    public DoctorCS(AI ai, String secretIdentity, int jlaid) {
        this.ai = ai;
        this.secretIdentity = secretIdentity;
        this.jlaid = jlaid;
        this.safe = false;
    }

    /**
     * saveTheDay non-returning method.
     */
    public void saveTheDay() {
        if (this.ai instanceof RogueAI) {
            while (((RogueAI) this.ai).getFirewallProtection() > 0) {
                ((RogueAI) this.ai).lowerFirewall();
            }
            this.safe = this.ai.swapCannonTarget(this.ai.getSecretHQ());
        }
        if (this.ai instanceof RandomAI) {
            this.safe = this.ai.swapCannonTarget(this.ai.getSecretHQ());
        }
    }

    /**
     * get status
     * @return string status.
     */
    public String getStatus() {
        if (this.safe) {
            return "Doctor CS has saved the day!";
        } else if (!this.safe && this.ai.getDestructed()) {
            return "Dr.Chipotle has succeeded in his plan...";
        } else {
            return "Georgia Tech is still in danger!";
        }
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s aka Doctor CS with JLAID: %d",
                this.secretIdentity, this.getJlaid());
    }

}
