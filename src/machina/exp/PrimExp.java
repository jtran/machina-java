package machina.exp;

import machina.EvalCtx;
import machina.IExp;

public class PrimExp extends AbstractExp {

	private String op;
	
	public PrimExp(String op) {
		this.op = op;
	}

	public IExp evalStep(EvalCtx ctx) {
		return this;
	}

	public boolean isNormalForm() {
		return true;
	}

	public String getOp() {
		return op;
	}
	
	@Override
	public String toString() {
		return getOp().toString();
	}

}
