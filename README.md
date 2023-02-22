# com.aflac.wiget Assessment
[![Java CI with Maven](https://github.com/roatanrich/aflac/actions/workflows/maven.yml/badge.svg)](https://github.com/roatanrich/aflac/actions/workflows/maven.yml)

## My Instructions:
- Please review the attached code and write down *everything* that is wrong and include your explanation of why.
- Make the corrections to the identified areas from step 1, as well as any other optimizations of your choosing, and return the corrected code.
## Initial Thoughts
I just recieved two java classes with no other context except to review the code. Are we required to use java docs?
*Note: there are no unit tests included so I will need to create my own to verify the behavior.*

 **Widget.java**
- The widget.java class seems very simple. It implements Comparable so it must be used within a List in the final implementation. 
- The code is not organized as I would like it.
- The single variable, named *value*, is located at the bottom of the file and not decorated with the private modifier even thought I see a setter and getter.
- The equals and hashCode overrides look different from what I'm used to seeing so these will need further review.
- The compareTo override has a comment which is good as it describes the intent of the method. The override annotation I think will need to be removed.

 **WidgetUtils.java**
- This class, based on its name, should perform actions on the Widget class. The class contains three methods; removeDuplicates, doubleValues, and getTwoWidgetsOfValue. There are plenty of comments in the code.
- The removeDuplicates method first sorts the passed in list, then loops looking at the next item in the list, this method seems like it can be optimized using a Lambda.
- The doubleValues method is very straight forward, again can be optimized using a Lambda. A concrete ArrayList is passed in as parameter versus the List interface. *Note: this method is not compiling due to the private modifier added to the Widget class earlier.*
- The getTwoWidgetsOfValue method has a *TODO* and additional comments stating issues with the comparator. I need to check the unit tests as to the developers concern using the comparator versus a primitive. Typically, a variable being returned within a method is named result, so a rename of widgetPairs to result is needed.
## Thoughts Moving Forward
- What are the AFLAC coding conventions, are we following BDD?  If using BDD, the amount of comments in the code would be reduced significantly. Can we follow a **clean code** approach?
- Do we need to create java docs? If true, then the code would need this update
## My Process
- Using Eclipse, I created a new Maven console app, including JUnit and Log4j dependencies
- I first formatted the widget,java code, moved the **value** variable to the top, and added the **private** modifier
- I reviewed the equals and hashCode methods. I tend to always roll my own equals and hashCode methods so using Eclipse, I commented out the existing methods and let Eclipse create the new methods. After review, the code change in both methods was the use of `Objects.equals(value, other.value);` and `Objects.hash(value);` respecfully.
- I created two BDD unit test classes with the convention of classname + Tester, Ex: WidgetTester, WidgetUtilsTester. 
- I use the moniker *sut* (System Under Test) within the test class to **show intent** of what class is being tested. 
- Each test method name follows the convention of sut.method + Test, Ex: removeDuplicatesTest.

## The Code
The doubleValuesTest needed some work, the index was off by one and the doubling code error from earlier ended up being a reference exception. 
Here is the new code:
```
public  void doubleValues(List<Widget> widgetList) {
   for (int  i = 0; i < widgetList.size(); i++) {
     double  value = widgetList.get(i).getValue();
     widgetList.get(i).setValue(value *= 2);
   }
 }
 ```
The removeDuplicates was changed greatly from its original source. The signature was changed from void to returning a `List<Widget>` for clarity.
Here is the new code:
```
public List<Widget> removeDuplicates(List<Widget> widgetList) {
   List<Widget> result = new ArrayList<Widget>(new HashSet<>(widgetList));
   
   return  result;
 }
 ```
The getWidgetsOfValue had the most changes.  The return value is now a single `List<Widget>` which is a change from `List<List<Widget>>` originally. The TODO comment was removed and the method implements multiple counts of widgets. *NOTE: name was changed from getTwoWidgetsOfValue*
Here is the new code:
```
public List<Widget> getWidgetsOfValue(List<Widget> widgetList, Double combinedValue) {
  List<Widget> secondWidgetList = widgetList;
  List<Widget> result = widgetList.stream().filter(x -> secondWidgetList.stream()
   .anyMatch(y -> x.getValue() + y.getValue() == combinedValue))
   .collect(Collectors.toList());
   
  return  result;
}
```
Code coverage: Widget = 96%, WidgetUtils = 100%
