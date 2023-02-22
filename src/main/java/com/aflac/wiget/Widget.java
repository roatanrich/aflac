package com.aflac.wiget;

import java.util.Objects;

/**
 * @author richard.henry
 *
 */
public class Widget implements Comparable<Widget> {

    private Double value;

    public Widget() {
    }

    public Widget(Double value) {
	this.value = value;
    }

    public Double getValue() {
	return this.value;
    }

    public void setValue(Double value) {
	this.value = value;
    }

    @Override
    public int hashCode() {
	return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Widget other = (Widget) obj;
	return Objects.equals(value, other.value);
    }

    /**
     * If this has a value less than w, then return -1, otherwise, since this is not
     * less than w, return 1
     * 
     * @param w Widget to compare
     * @return -1 if value is less than w, otherwise 1
     */
    public int compareTo(Widget w) {
	if (this.getValue() < w.getValue()) {
	    return -1;
	}

	return 1;
    }

}
