package JDice;

import JDice.DieRoll;


public class DiceSum extends DieRoll {
    private DieRoll r1; // thieu dau ; o cuoi doan code
    private DieRoll r2;
    public DiceSum(DieRoll r1,DieRoll r2) { // thieu dau , o truoc DieRoll r2
	super(0,0,0);
	this.r1=r1;
	this.r2=r2;
    }
    public RollResult makeRoll() { // bo dau //
	return r1.makeRoll().andThen(r2.makeRoll()); // r1makeRoll va r2makeRoll thieu dau .
    }
    public String toString() {
	return r1.toString() + " & "+r2.toString(); // r1toString thieu dau .
    }
}

// loi cu phap nghiem trong: class makeRoll va toString dat ngoai class DiceSum

