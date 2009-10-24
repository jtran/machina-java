package machina.exp;

import machina.EvalCtx;
import machina.IExp;

public class IntExp extends AbstractExp {
	
	private int n;

	public IntExp(int n) {
		this.n = n;
	}

	public IExp evalStep(EvalCtx ctx) {
		return this;
	}

	public boolean isNormalForm() {
		return true;
	}

	public int getN() {
		return n;
	}
	
	@Override
	public boolean equals(IExp e) {
		if (!(e instanceof IntExp)) return false;
		
		IntExp n = (IntExp)e;
		return getN() == n.getN();
	}
	
	@Override
	public String toString() {
		return String.valueOf(n);
	}

}
