package machina.exp;

import machina.EvalCtx;
import machina.IExp;

public class ClosureExp extends AbstractExp {
	
	private EvalCtx ctx;
	private FnExp fn;

	public ClosureExp(EvalCtx ctx, FnExp fn) {
		this.ctx = ctx;
		this.fn = fn;
	}

	public IExp evalStep(EvalCtx ctx) {
		return this;
	}

	public boolean isNormalForm() {
		return true;
	}

	public EvalCtx getCtx() {
		return ctx;
	}

	public FnExp getFn() {
		return fn;
	}
	
	@Override
	public String toString() {
		return "<" + getCtx() + ", " + getFn() + ">";
	}

}
