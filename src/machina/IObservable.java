package machina;

public interface IObservable<T> {

	void notifyObservers();
	void registerObserver(IObserver<T> observer);
	
}
