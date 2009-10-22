package machina.exp;

import machina.EvalCtx;
import machina.IExp;
import machina.Symbol;

public class SymExp extends AbstractExp {
	
	private Symbol sym;

	public SymExp(Symbol sym) {
		this.sym = sym;
	}

	public IExp evalStep(EvalCtx ctx) {
		IExp result = ctx.get(getSym());
		return result == null ?
				new UndefinedExp(getSym() + " is undefined in context.") :
				result;
	}

	public boolean isNormalForm() {
		return false;
	}

	public Symbol getSym() {
		return sym;
	}
	
	@Override
	public String toString() {
		return getSym().toString();
	}
	
	@Override
	public int hashCode() {
		return getSym().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof SymExp)) return false;
		
		SymExp s = (SymExp)o;
		return getSym().equals(s.getSym());
	}

}
