package machina.frame;

import machina.EvalCtx;
import machina.Observable;
import machina.IExp;
import machina.IObservable;
import machina.IObserver;
import machina.exp.UndefinedExp;

public class EvalFrame implements IObservable<EvalFrame> {

	private EvalCtx ctx;
	private IExp exp;
	private IExp result = new UndefinedExp();
	private Observable<EvalFrame> observable = new Observable<EvalFrame>(this);
	
	public EvalFrame(EvalCtx ctx, IExp exp) {
		this.ctx = ctx;
		this.exp = exp;
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
	
	public void registerObserver(IObserver<EvalFrame> observer) {
		observable.registerObserver(observer);
	}

	public EvalCtx getCtx() {
		return ctx;
	}

	public IExp getExp() {
		return exp;
	}

	public IExp getResult() {
		return result;
	}

	public void setResult(IExp result) {
		this.result = result;
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return getExp() + " => " + getResult();
	}
	
}
