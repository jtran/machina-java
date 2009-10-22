package machina.exp;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import machina.EvalCtx;
import machina.IExp;

public class ListExp extends AbstractExp {
	
	public List<? extends IExp> es;
	
	public ListExp(IExp... es) {
		this(Arrays.asList(es));
	}

	public ListExp(List<? extends IExp> es) {
		this.es = es;
	}

	public IExp evalStep(EvalCtx ctx) {
		return this;
	}

	public boolean isNormalForm() {
		// Normal if all elements are normal.
		for (IExp e : getEs()) {
			if (!e.isNormalForm()) return false;
		}
		return true;
	}

	@Override
	public boolean isWeakHeadNormalForm() {
		return true;
	}

	public List<? extends IExp> getEs() {
		return es;
	}
	
	@Override
	public String toString() {
		return "[" + StringUtils.join(getEs(), ", ") + "]";
	}

}
