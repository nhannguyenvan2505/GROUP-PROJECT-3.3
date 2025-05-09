package JDice;
import java.util.*;

public class RollResult {
    int total;
    int modifier;
    Vector<Integer> rolls; // thieu dau ;
    private RollResult(int total, 
		       int modifier,
		       Vector<Integer> rolls) { // Vector<Integer> rolls { thieu dau ')'
	this.total=total;
	this.modifier=modifier;
	this.rolls=rolls;  // thisrolls thieu dam .

    }
    public RollResult(int bonus) {
	this.total=bonus;
	this.modifier=bonus;
	rolls=new Vector<Integer>();
    }
    public void addResult(int res){ // bo dau // 
	total+=res;
	rolls.add(res);
    }
    public RollResult andThen(RollResult r2) {
	int total=this.total+r2.total;
	Vector<Integer> rolls=new Vector<Integer>();
	rolls.addAll(this.rolls);
	rolls.addAll(r2.rolls);
	return new RollResult(total,
			      this.modifier+r2.modifier,
			      rolls);
    }
    public String toString() {
	return total +"  <= " +rolls.toString()+ 
	    (modifier>0?("+"+modifier):
	     modifier<0?modifier:"");
    }
} // thieu dau '}'



