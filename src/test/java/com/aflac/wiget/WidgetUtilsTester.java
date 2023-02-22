package com.aflac.wiget;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WidgetUtilsTester {

    private WidgetUtils sut = new WidgetUtils();

    @Test
    void getTwoWidgetsOfValueTest() {

	// given
	int expectedCount = 4;
	double combinedValue = 21;
	Widget one = new Widget(10d);
	Widget two = new Widget(11d);
	Widget three = new Widget(12d);
	Widget four = new Widget(11d);
	Widget five = new Widget(10d);

	List<Widget> list = new ArrayList<Widget>();
	list.add(one);
	list.add(two);
	list.add(three);
	list.add(four);
	list.add(five);

	// when
	List<Widget> result = sut.getWidgetsOfValue(list, combinedValue);

	// then
	assertThat(result.size(), is(equalTo(expectedCount)));
    }

    @Test
    void removeDuplicatesTest() {

	// given
	int expectedResult = 3;
	Widget one = new Widget(10d);
	Widget two = new Widget(11d);
	Widget three = new Widget(12d);
	Widget four = new Widget(11d);
	Widget five = new Widget(10d);

	List<Widget> list = new ArrayList<Widget>();
	list.add(one);
	list.add(two);
	list.add(three);
	list.add(four);
	list.add(five);

	// when
	List<Widget> result = sut.removeDuplicates(list);

	// then
	assertThat(result.size(), is(equalTo(expectedResult)));
    }

    @Test
    void doubleValuesTest() {

	// given
	double expectedResult = 42;
	Widget one = new Widget(10d);
	Widget two = new Widget(11d);

	List<Widget> list = new ArrayList<Widget>();
	list.add(one);
	list.add(two);

	// when
	sut.doubleValues(list);
	double result = list.stream().mapToDouble(x -> x.getValue()).sum();

	// then
	assertThat(result, is(equalTo(expectedResult)));
    }

}