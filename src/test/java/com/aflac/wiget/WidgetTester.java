package com.aflac.wiget;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class WidgetTester {

    @Test
    void defaultCtorTest() {

	// given
	double testValue = 123;

	Widget widget = new Widget();
	widget.setValue(testValue);

	// when
	double result = widget.getValue();

	// then
	assertThat(result, is(equalTo(testValue)));
    }

    @Test
    void compareTest() {

	// given
	int expectedResult = 1;
	double testValue = 123;

	Widget widgetOne = new Widget(testValue);
	Widget widgetTwo = new Widget(testValue);

	// when
	int result = widgetOne.compareTo(widgetTwo);

	// then
	assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    void attemptCompareTest() {

	// given
	int expectedResult = -1;
	double testValueOne = 123;
	double testValueTwo = 124;

	Widget widgetOne = new Widget(testValueOne);
	Widget widgetTwo = new Widget(testValueTwo);

	// when
	int result = widgetOne.compareTo(widgetTwo);

	// then
	assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    void equalsNullTest() {

	// given
	Widget widgetOne = new Widget(null);

	// when
	boolean result = widgetOne.equals(null);

	// then
	assertThat(result, is(equalTo(false)));
    }

    @Test
    void equalsInvalidTest() {

	// given
	Widget widgetOne = new Widget(null);

	// when
	boolean result = widgetOne.equals(new String());

	// then
	assertThat(result, is(equalTo(false)));
    }

    @Test
    void equalsTest() {

	// given
	double testValue = 123;

	Widget widgetOne = new Widget(testValue);
	Widget widgetTwo = new Widget(testValue);

	// when
	boolean result = widgetOne.equals(widgetTwo);

	// then
	assertThat(result, is(equalTo(true)));
    }

    @Test
    void hashCodeTest() {

	// given
	double testValue = 123;

	Widget widgetOne = new Widget(testValue);
	Widget widgetTwo = new Widget(testValue);

	// when
	int resultOne = widgetOne.hashCode();
	int resultTwo = widgetTwo.hashCode();

	// then
	assertThat(resultOne, is(equalTo(resultTwo)));
    }

    @Test
    void alternateCtorTest() {

	// given
	double testValue = 123;

	Widget widget = new Widget(testValue);

	// when
	double result = widget.getValue();

	// then
	assertThat(result, is(equalTo(testValue)));
    }

}