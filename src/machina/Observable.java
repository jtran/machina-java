package machina;

import java.util.Map;
import java.util.TreeMap;

public class Observable<T> implements IObservable<T> {
	
	private final T observable;
	private final Map<IObserver<T>, Object> observers = new TreeMap<IObserver<T>, Object>();
	
	public Observable(T observable) {
		this.observable = observable;
	}

	public void notifyObservers() {
		for (IObserver<T> observer : observers.keySet()) {
			observer.observedUpdate(observable);
		}
	}

	public void registerObserver(IObserver<T> observer) {
		observers.put(observer, null);
	}

}
