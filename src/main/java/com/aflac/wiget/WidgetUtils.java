package com.aflac.wiget;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetUtils {

    // This will walk through a list of widgets and remove any duplicates.
    public List<Widget> removeDuplicates(List<Widget> widgetList) {
	List<Widget> result = new ArrayList<Widget>(new HashSet<>(widgetList));

	return result;
    }

    // This will double the value of each widget in the given list
    public void doubleValues(List<Widget> widgetList) {
	for (int i = 0; i < widgetList.size(); i++) {
	    double value = widgetList.get(i).getValue();
	    widgetList.get(i).setValue(value *= 2);
	}
    }

    // This will give us widgets whose combined value equals the given value
    public List<Widget> getWidgetsOfValue(List<Widget> widgetList, Double combinedValue) {

	List<Widget> secondWidgetList = widgetList;
	List<Widget> result = widgetList.stream()
		.filter(x -> secondWidgetList.stream().anyMatch(y -> x.getValue() + y.getValue() == combinedValue))
		.collect(Collectors.toList());

	return result;
    }
}
