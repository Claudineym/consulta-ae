/**
 * 
 */
package br.gov.fazenda.mg.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author claudiney.viana
 *
 */
public class StandardObject implements Serializable, Comparable<Object>{

	private static final long serialVersionUID = 2130179970982533933L;

	public boolean equals(Object obj) {
	        return EqualsBuilder.reflectionEquals(this, obj);
	    }

	    public int hashCode() {
	        return HashCodeBuilder.reflectionHashCode(this);
	    }

	    public String toString() {
	        return ToStringBuilder.reflectionToString(this);
	    }

	    public int compareTo(Object obj) {
	        return CompareToBuilder.reflectionCompare(this, obj);
	    }
}
