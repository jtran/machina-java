package machina.exp;

import machina.EvalCtx;
import machina.IExp;

public class UndefinedExp extends AbstractExp {
	
	private String cause;
	
	public UndefinedExp() {}
	
	public UndefinedExp(String cause) {
		this.cause = cause;
	}

	public IExp evalStep(EvalCtx ctx) {
		return this;
	}

	public boolean isNormalForm() {
		return true;
	}
	
	public String getCause() {
		return cause;
	}
	
	@Override
	public String toString() {
		return "_|_ (" + cause + ")";
	}
	
	@Override
	public boolean equals(IExp e) {
		if (e == this) return true;
		if (e instanceof UndefinedExp) return true;
		return false;
	}

}
