package machina.exp;

import machina.IExp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public abstract class AbstractExp implements IExp {

	public boolean isWeakHeadNormalForm() {
		return isNormalForm();
	}
	
	public boolean equals(IExp e) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

}
