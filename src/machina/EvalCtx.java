package machina;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EvalCtx {
	
	private Map<Symbol, IExp> map;
	private Evaluator evaluator;

	public EvalCtx() {
		this(null, null);
	}

	public EvalCtx(Map<Symbol, IExp> map, Evaluator evaluator) {
		this.map = map == null ? new HashMap<Symbol, IExp>() : new HashMap<Symbol, IExp>(map);
		this.evaluator = evaluator == null ? Evaluator.getInstance() : evaluator;
	}

	public EvalCtx(EvalCtx ctx, Symbol s, IExp e) {
		this(ctx.getMap(), ctx.getEvaluator());
		map.put(s, e);
	}

	public EvalCtx bind(Symbol s, IExp e) {
		return new EvalCtx(this, s, e);
	}
	
	public IExp get(Symbol s) {
		return map.get(s);
	}

	protected Map<Symbol, IExp> getMap() {
		return map;
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Entry<Symbol, IExp> entry : getMap().entrySet()) {
			if (!first) sb.append(",");
			sb.append(entry.getKey()).append("=").append(entry.getValue());
		}
		return sb.toString();
	}
}
