package JDice;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DieRoll {
    private static final Logger logger = Logger.getLogger(DieRoll.class.getName());

    private int ndice;
    private int nsides;
    private int bonus;
    private static Random rnd;

    static {
        rnd = new Random();
    }

    public DieRoll(int ndice, int nsides, int bonus) {
        if (ndice <= 0 || nsides <= 0) {
            logger.severe("Invalid dice configuration: ndice and nsides must be > 0");
            throw new IllegalArgumentException("Number of dice and sides must be greater than 0.");
        }

        this.ndice = ndice;
        this.nsides = nsides;
        this.bonus = bonus;

        logger.info("Created DieRoll with: " + ndice + " dice, " + nsides + " sides, bonus: " + bonus);
    }

    public RollResult makeRoll() {
        RollResult r = new RollResult(bonus);
        for (int i = 0; i < ndice; i++) {
            int roll = rnd.nextInt(nsides) + 1;
            r.addResult(roll);
            logger.fine("Rolled a " + roll);
        }
        return r;
    }

    public String toString() {
        String ans = ndice + "d" + nsides;
        if (bonus > 0) {
            ans = ans + "+" + bonus;
        } else if (bonus < 0) {
            ans = ans + bonus;
        }
        return ans;
    }
}
