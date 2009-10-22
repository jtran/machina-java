package machina;

public interface IObserver<T> {
	
	void observedUpdate(T observable);

}
