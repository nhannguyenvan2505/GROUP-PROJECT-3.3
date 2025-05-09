package JDice;
import java.util.*;



public class DieRoll {
    private int ndice;
    private int nsides;
    private int bonus;
    private static Random rnd;
    static{
// static mo dau //
	rnd=new Random();
    }
    public DieRoll(int ndice,
		   int nsides,
		   int bonus) {
	this.ndice=ndice;
// thisndice thieu dau .
	this.nsides=nsides;
	this.bonus=bonus;
    }
    public RollResult makeRoll() {
	RollResult r =new RollResult(bonus);
	for(int i=0;i<ndice;i++) {
	    int roll=rnd.nextInt(nsides)+1;
	    r.addResult(roll);
// thieu dau ; cuoi doan code
	}
	return r;
    }
    public String toString() {
	String ans =ndice+"d"+nsides;
	if(bonus>0) {
	    ans= ans+"+"+bonus;
	}
	else if(bonus<0) {
	    ans=ans+bonus;
// ans:=ans+bonus; sua thanh ans=ans+bonus;
	}
	return ans;
    }

}
