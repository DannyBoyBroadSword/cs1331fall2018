/**
 * RogueAI class.
 *
 * @author ahennessy6
 * @version 1.0
 */
public class RogueAI extends AI {
    private int firewallProtection;
    private int alertLevel;
    private final int maxAlert;

    /**
     * Constructor for RogueAI
     * @param firewallProtection firewall protection
     * @param alertLevel alert level
     * @param maxAlert max alert
     * @param cannonTarget cannon target
     * @param secretHQ secret hq
     */
    public RogueAI(int firewallProtection, int alertLevel, int maxAlert,
            Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        this.alertLevel = alertLevel;
        this.maxAlert = maxAlert;
    }

    /**
     * Constructor for RogueAI
     * @param firewallProtection firewall protection
     * @param maxAlert max alert
     * @param cannonTarget cannon target
     * @param secretHQ secret hq
     */
    public RogueAI(int firewallProtection, int maxAlert,
            Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        this.alertLevel = 0;
        this.maxAlert = maxAlert;
    }

    /**
     * Constructor for RogueAI
     * @param firewallProtection firewall protection
     * @param cannonTarget cannon target
     * @param secretHQ secret hq
     */
    public RogueAI(int firewallProtection, Coordinates cannonTarget,
            Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        this.alertLevel = 0;
        this.maxAlert = 10;
    }

    /**
     * getter for FirewallProtection instance var.
     * @return firewallProtection firewall protection
     */
    public int getFirewallProtection() {
        return firewallProtection;
    }

    /**
     * getter for alertLevel instance var.
     * @return alertLevel alert level
     */
    public int getAlertLevel() {
        return alertLevel;
    }

    /**
     * getter for maxAlert instance var.
     * @return maxAlert. max alert
     */
    public int getMaxAlert() {
        return maxAlert;
    }

    /**
     * lowerfirewall non-returning method.
     */
    public void lowerFirewall() {
        this.firewallProtection = this.firewallProtection - 2;
        this.alertLevel++;
    }

    /* (non-Javadoc)
     * @see AI#shouldSwapCannonTarget()
     * @return boolean firewall protection
     */
    @Override
    public boolean shouldSwapCannonTarget() {
        return this.getFirewallProtection() >= 0;
    }

    /* (non-Javadoc)
     * @see AI#shouldSelfDestruct()
     * @return boolean should selfDestruct
     */
    @Override
    public boolean shouldSelfDestruct() {
        return this.getAlertLevel() >= this.getMaxAlert();
    }

    /* (non-Javadoc)
     * @see AI#toString()
     * @return String override
     */
    @Override
    public String toString() {
        return String.format(
                "Dr. Chipotle’s guacamole cannon is currently pointed at "
                + "%s, and is at alert level %d with firewall protection %d.",
                this.getCannonTarget(), this.getAlertLevel(),
                this.getFirewallProtection());
    }

}
