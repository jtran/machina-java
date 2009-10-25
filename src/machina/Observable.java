package machina;

import java.util.Set;
import java.util.TreeSet;

public class Observable<T> implements IObservable<T> {
	
	private final T observable;
	private final Set<IObserver<T>> observers = new TreeSet<IObserver<T>>();
	
	public Observable(T observable) {
		this.observable = observable;
	}

	public void notifyObservers() {
		notifyObservers(observable);
	}

	public void notifyObservers(T observable) {
		for (IObserver<T> observer : observers) {
			observer.observedUpdate(observable);
		}
	}

	public void registerObserver(IObserver<T> observer) {
		observers.add(observer);
	}

}
