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
	public String toString() {
		return String.valueOf(n);
	}
	
	@Override
	public int hashCode() {
		return getN();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof IntExp)) return false;
		
		IntExp e = (IntExp)o;
		return getN() == e.getN();
	}

}
