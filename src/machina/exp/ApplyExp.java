package machina.exp;

import java.util.List;

import machina.EvalCtx;
import machina.Evaluator;
import machina.IExp;

public class ApplyExp extends AbstractExp {
	
	private IExp fn;
	private IExp arg;

	public ApplyExp(IExp fn, IExp arg) {
		this.fn = fn;
		this.arg = arg;
	}

	public IExp evalStep(EvalCtx ctx) {
		Evaluator evalr = ctx.getEvaluator();
		
		IExp fn = evalr.wish(ctx, getFn());
		IExp arg = evalr.wish(ctx, getArg());
		
		if (fn.isNormalForm()) {
			return apply(evalr, ctx, fn, arg);
		}
		return new ApplyExp(fn, arg);
	}
	
	private static IExp apply(Evaluator evalr, EvalCtx ctx, IExp fn, IExp arg) {
		if (fn instanceof ClosureExp) {
			ClosureExp cls = (ClosureExp)fn;
			FnExp f = cls.getFn();
			return evalr.wish(cls.getCtx().bind(f.getParam(), arg),
																 f.getBody());
		}
		else if (fn instanceof PrimExp) {
			PrimExp prim = (PrimExp)fn;
			if (prim.getOp().equals("+")) {
				// Try to get args in normal form.
				List<? extends IExp> args = getNormalArgs(arg);
				// If null, that means we are still waiting on some args.
				if (args == null) return new ApplyExp(fn, arg);
				
				int sum = 0;
				for (IExp e : args) {
					sum += ((IntExp)e).getN();
				}
				return new IntExp(sum);
			}
		}
		return new UndefinedExp("Don't know how to apply to a function with class "
				+ fn.getClass().getCanonicalName() + ", fn: " + fn
				+ ", arg: " + arg
				+ ", ctx: " + ctx);
	}
	
	private static List<? extends IExp> getNormalArgs(IExp arg) {
		// Expecting a list; If it's not weak-head, then it needs to be evaled.
		if (! arg.isWeakHeadNormalForm()) return null;
		
		// If any element of the list is not normal, then we must wait.
		ListExp lst = (ListExp)arg;
		for (IExp e : lst.getEs()) {
			if (! e.isNormalForm()) return null;
		}
		
		return lst.getEs();
	}

	public boolean isNormalForm() {
		return false;
	}

	public IExp getFn() {
		return fn;
	}

	public IExp getArg() {
		return arg;
	}
	
	@Override
	public String toString() {
		return "(" + getFn() + " " + getArg() + ")";
	}

}
