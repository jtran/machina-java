package machina;

public class Symbol {

	private String name;

	public Symbol(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Symbol)) return false;
		
		Symbol s = (Symbol)o;
		return getName().equals(s.getName());
	}
}
