package machina;

import java.util.concurrent.Callable;

import machina.exp.WishExp;

public class EvalWishGranter implements Callable<Boolean> {

	public EvalCtx ctx;
	public WishExp exp;
	
	public EvalWishGranter(EvalCtx ctx, WishExp exp) {
		this.ctx = ctx;
		this.exp = exp;
	}

	public Boolean call() throws Exception {
		IExp e = exp.evalStep(ctx);
		exp.setResult(e);
		return ! e.isNormalForm();
	}
	
	@Override
	public String toString() {
		return ctx + " |- " + exp;
	}
	
}
