package machina.exp;

import machina.EvalCtx;
import machina.IExp;

public class WishExp extends AbstractExp {
	
	private EvalCtx ctx;
	private IExp exp;
	private IExp result;
	
	public WishExp(EvalCtx ctx, IExp exp) {
		this.ctx = ctx;
		this.exp = exp;
	}

	@Override
	public IExp evalStep(EvalCtx ctx) {
		return result == null ?
				exp.evalStep(this.ctx) :
				result;
	}

	public boolean isNormalForm() {
		return false;
	}
	
	public IExp getResult() {
		return result;
	}
	
	public void setResult(IExp result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "{" + ctx + " |- " + exp + "}";
	}

}
