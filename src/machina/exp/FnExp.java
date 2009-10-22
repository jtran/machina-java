package machina.exp;

import machina.EvalCtx;
import machina.IExp;
import machina.Symbol;

public class FnExp extends AbstractExp {
	
	private Symbol param;
	private IExp body;

	public FnExp(Symbol param, IExp body) {
		this.param = param;
		this.body = body;
	}

	public IExp evalStep(EvalCtx ctx) {
		return new ClosureExp(ctx, this);
	}

	public boolean isNormalForm() {
		return false;
	}

	public Symbol getParam() {
		return param;
	}

	public IExp getBody() {
		return body;
	}
	
	@Override
	public String toString() {
		return "(λ" + getParam() + ". " + getBody() + ")";
	}

}
