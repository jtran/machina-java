package machina;

public interface IObservable<T> {

	void registerObserver(IObserver<T> observer);
	
}
