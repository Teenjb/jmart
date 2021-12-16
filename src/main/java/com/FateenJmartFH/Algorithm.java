package com.FateenJmartFH;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Algorithm is a class that have many type of logic and algorithm
 * @author Fateen Najib Indramustika
 */

public class Algorithm {
    private Algorithm() {

    }

    /**
     * Method to count the number of certain value in an array
     * @param array The array which we want to count the certain value with.
     * @param value The value we want to check.
     * @param <T> This describes the type parameter
     * @return the number of certain value in an array.
     */
    public static <T> int count(T[] array, T value) {
        final Iterator<T> var = Arrays.stream(array).iterator();
        return count(var, value);
    }

    /**
     * Method to count the number of certain value in an Iterable object
     * @param iterable The object which we want to count the certain value with.
     * @param value The value we want to check.
     * @param <T> This describes the type parameter.
     * @return the number of certain value in an object.
     */
    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator <T> var = iterable.iterator();
        return count(var, value);
    }

    /**
     * Method to count the number of certain value in an Iterator object
     * @param iterator The object which we want to count the certain value with.
     * @param value The value we want to check.
     * @param <T> This describes the type parameter.
     * @return the number of certain value in an object.
     */
    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate <T> var = value::equals;
        return count(iterator, var);
    }

    /**
     * Method to count the number of array's item which match to certain criteria
     * @param array The array which we want to count the items with certain criteria.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return the number of item which match the certain criteria in an object.
     */
    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> var = Arrays.stream(array).iterator();
        return count(var, pred);
    }

    /**
     * Method to count the number of iterable object's item which match to certain criteria
     *
     * @param iterable The object which we want to count the items with certain criteria.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return The number of item which match the certain criteria in an object.
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> var = iterable.iterator();
        return count(var, pred);
    }

    /**
     *  Method to count the number of iterator object's item which match to certain criteria
     * @param iterator The object which we want to count the items with certain criteria.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return The number of item which match the certain criteria in an object.
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        while (iterator.hasNext())
            if (pred.predicate(iterator.next()))
                ++count;
        return count;
    }

    /**
     * Method to check if a certain value exist in the collection
     * @param array The collection to check.
     * @param value The value to check.
     * @param <T> This describes the type parameter.
     * @return true if the certain value exist, otherwise false
     */
    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> var = Arrays.stream(array).iterator();
        return exists(var, value);
    }


    /**
     * Method to check if a certain value exist in the collection
     * @param iterable The collection to check.
     * @param value The value to check.
     * @param <T> This describes the type parameter.
     * @return true if the certain value exist, otherwise false
     */
    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> var = iterable.iterator();
        return exists(var, value);
    }

    /**
     * Method to check if a certain value exist in the collection
     * @param iterator The collection to check.
     * @param value The value to check.
     * @param <T> This describes the type parameter.
     * @return true if the certain value exist, otherwise false
     */
    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate <T> var = value::equals;
        return exists(iterator, var);
    }

    /**
     * Method to check if a certain value which match the predicate exist in the collection
     * @param array The collection to check.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return true if the certain value exist, otherwise false
     */
    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> var = Arrays.stream(array).iterator();
        return exists(var, pred);
    }

    /**
     * Method to check if a certain value which match the predicate exist in the collection
     * @param iterable The collection to check.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return true if the certain value exist, otherwise false
     */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator <T> var = iterable.iterator();
        return exists(var, pred);
    }

    /**
     * Method to check if a certain value which match the predicate exist in the collection
     * @param iterator The collection to check.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return true if the certain value exist, otherwise false
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        return exists(iterator, pred);
    }

    /**
     * Method to find a value in an array
     * @param array The array we want to check.
     * @param value The value we want to find
     * @param <T> This describes the type parameter.
     * @return the matched object we find in array
     */
    public static <T> T find(T[] array, T value) {
        for(T i : array){
            if(i == value){
                return i;
            }
        }
        return null;
    }

    /**
     * Method to find a value in an object
     * @param iterable The object we want to check.
     * @param value The value we want to find
     * @param <T> This describes the type parameter.
     * @return the matched object we find in Iterable object
     */
    public static <T> T find(Iterable<T> iterable, T value) {
        for(T i : iterable){
            if(i == value){
                return i;
            }
        }
        return null;
    }

    /**
     * Method to find a value in an object
     * @param iterator The object we want to check.
     * @param value The value we want to find.
     * @param <T> This describes the type parameter.
     * @return the matched object we find in Iterator object.
     */
    public static <T> T find(Iterator<T> iterator, T value) {
        while (iterator.hasNext()){
            if(iterator.next() == value){
                return iterator.next();
            }
        }
        return null;
    }

    /**
     * Method to find an object with criteria in an array
     * @param array The array we want to check.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return the matched object we find in array.
     */
    public static <T> T find(T[] array, Predicate<T> pred) {
        for(T i : array){
            if(pred.predicate(i)){
                return i;
            }
        }
        return null;
    }

    /**
     * Method to find an object with criteria in an Iterable object.
     * @param iterable The object we want to check.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return the matched object we find in Iterable object.
     */
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        for(T i : iterable){
            if(pred.predicate(i)){
                return i;
            }
        }
        return null;
    }

    /**
     * Method to find an object with criteria in an Iterator object.
     * @param iterator The object we want to check.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return the matched object we find in Iterator object.
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            if(pred.predicate(iterator.next())){
                return iterator.next();
            }
        }
        return null;
    }

    /**
     * Method to find object which has the maximum value.
     * @param first The object being compared.
     * @param second The object being compared.
     * @param <T> This describes the type parameter.
     * @return object which has the maximum value
     */
    public static <T extends Comparable<? super T>> T max(T first, T  second) {
        if(first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }

    /**
     * Method to find object which has the maximum value.
     * @param array collection to compare all of the item
     * @param <T> This describes the type parameter.
     * @return object which has the maximum value
     */
    public static <T extends Comparable<? super T>> T max(T[] array) {
        T maximum = array[0];

        for (T each : array) {
            if(each.compareTo(maximum) > 0)
            {
                maximum = each;
            }
            else {
                maximum = maximum;
            }
        }

        return maximum;
    }

    /**
     * Method to find object which has the maximum value.
     * @param iterable collection to compare all of the item
     * @param <T> This describes the type parameter.
     * @return object which has the maximum value
     */
    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable) {
        final Iterator <T> each  = iterable.iterator();
        T maximum = null;
        while(each.hasNext()) {
            if (each.next().compareTo(maximum) > 0)
            {
                maximum = each.next();
            }
        }

        return maximum;
    }

    /**
     * Method to find object which has the maximum value.
     * @param iterator collection to compare all of the item
     * @param <T> This describes the type parameter.
     * @return object which has the maximum value
     */
    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator) {
        T maximum = null;
        while(iterator.hasNext()) {
            if(iterator.next().compareTo(maximum) >= 0) {

            }
        }
        return maximum;
    }

    /**
     * Method to find object which has the maximum value with Comparator.
     * @param first The object being compared.
     * @param second The object being compared.
     * @param comparator The comparator
     * @param <T> This describes the type parameter.
     * @return object which has the maximum value
     */
    public static <T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator) {
        T maximum;
        if(comparator.compare(first, second) >= 0)
        {
            maximum = first;
        }
        else {
            maximum = second;
        }
        return maximum;
    }

    /**
     * Method to find object which has the maximum value with Comparator.
     * @param array collection to compare all of the item
     * @param comparator The comparator
     * @param <T> This describes the type parameter.
     * @return object which has the maximum value.
     */
    public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator) {
        T maximum = null;

        for (T each : array) {
            if(comparator.compare(each, maximum) >= 0)
            {
                maximum = each;
            }
            else {
                maximum = maximum;
            }
        }

        return maximum;
    }

    /**
     * Method to find object which has the maximum value with Comparator.
     * @param iterable collection to compare all of the item
     * @param comparator The comparator
     * @param <T> This describes the type parameter.
     * @return object which has the maximum value.
     */
    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator) {
        final Iterator <T> each  = iterable.iterator();
        T maximum = null;
        while(each.hasNext()) {
            if (comparator.compare(each.next(), maximum) >= 0) {
                maximum = each.next();
            }
        }

        return maximum;
    }

    /**
     * Method to find object which has the maximum value with Comparator.
     * @param iterator collection to compare all of the item
     * @param comparator The comparator
     * @param <T> This describes the type parameter.
     * @return object which has the maximum value.
     */
    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator) {
        T maximum = null;
        while(iterator.hasNext()) {
            if(comparator.compare(iterator.next(), maximum)>= 0) {
                maximum = iterator.next();
            }
        }
        return maximum;
    }

    /**
     * Method to find object which has the minimum value.
     * @param first The object being compared.
     * @param second The object being compared.
     * @param <T> This describes the type parameter.
     * @return object which has the minimum value
     */
    public static <T extends Comparable<? super T>> T min(T  first, T  second) {
        if(first.compareTo(second) < 0) {
            return first;
        }
        return second;
    }

    /**
     * Method to find object which has the minimum value.
     * @param array collection to compare all of the item
     * @param <T> This describes the type parameter.
     * @return object which has the minimum value
     */
    public static <T extends Comparable<? super T>> T min(T[] array) {
        T minimum = null;

        for (T each : array) {
            if(each.compareTo(minimum) < 0) {
                minimum = each;
            }
            else {
                minimum = minimum;
            }
        }

        return minimum;
    }

    /**
     * Method to find object which has the minimum value.
     * @param iterable collection to compare all of the item
     * @param <T> This describes the type parameter.
     * @return object which has the minimum value
     */
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable) {
        final Iterator <T> each  = iterable.iterator();
        T minimum = null;
        while(each.hasNext()) {
            if (each.next().compareTo(minimum) < 0) {
                minimum = each.next();
            }
        }

        return minimum;
    }

    /**
     * Method to find object which has the minimum value.
     * @param iterator collection to compare all of the item
     * @param <T> This describes the type parameter.
     * @return object which has the minimum value
     */
    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator) {
        T minimum = null;
        while(iterator.hasNext()) {
            if(iterator.next().compareTo(minimum) >= 0) {
                minimum = iterator.next();
            }
        }
        return minimum;
    }

    /**
     * Method to find object which has the minimum value with Comparator.
     * @param first The object being compared.
     * @param second The object being compared.
     * @param comparator The comparator
     * @param <T> This describes the type parameter.
     * @return object which has the minimum value
     */
    public static <T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator) {
        T minimum;
        if(comparator.compare(first, second) >= 0) {
            minimum = first;
        }
        else {
            minimum = second;
        }
        return minimum;
    }

    /**
     * Method to find object which has the minimum value with Comparator.
     * @param array collection to compare all of the item
     * @param comparator The comparator
     * @param <T> This describes the type parameter.
     * @return object which has the minimum value.
     */
    public static <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator) {
        T minimum = null;

        for (T each : array) {
            if(comparator.compare(each, minimum) <= 0) {
                minimum = each;
            }
            else {
                minimum = minimum;
            }
        }

        return minimum;
    }


    /**
     * Method to find object which has the minimum value with Comparator.
     * @param iterable collection to compare all of the item
     * @param comparator The comparator
     * @param <T> This describes the type parameter.
     * @return object which has the minimum value.
     */
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator) {
        final Iterator <T> each  = iterable.iterator();
        T minimum = null;
        while(each.hasNext()) {
            if (comparator.compare(each.next(), minimum) <= 0)
            {
                minimum = each.next();
            }
        }

        return minimum;
    }

    /**
     * Method to find object which has the minimum value with Comparator.
     * @param iterator collection to compare all of the item
     * @param comparator The comparator
     * @param <T> This describes the type parameter.
     * @return object which has the minimum value.
     */
    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator) {
        T minimum = null;
        while(iterator.hasNext()) {
            if(comparator.compare(iterator.next(), minimum)>= 0) {
                minimum = iterator.next();
            }
        }
        return minimum;
    }

    /**
     * Method to collect certain value in array
     * @param array The array we want to check.
     * @param value The value we want to collect.
     * @param <T> This describes the type parameter.
     * @return List of certain value in array
     */
    public static<T> List<T> collect(T[] array, T value) {
        List<T> list = new ArrayList<T>();
        for (T each: array) {
            if(each.equals(value)) {
                list.add(each);
            }
        }
        return list;
    }

    /**
     * Method to collect certain value in Iterable object
     * @param iterable The Iterable object we want to check.
     * @param value The value we want to collect.
     * @param <T> This describes the type parameter.
     * @return List of certain value in object
     */
    public static<T> List<T> collect(Iterable<T> iterable, T value) {
        List<T> list = new ArrayList<T>();
        for (T each: iterable) {
            if(each.equals(value)) {
                list.add(each);
            }
        }
        return list;
    }

    /**
     * Method to collect certain value in Iterator object
     * @param iterator The Iterator object we want to check.
     * @param value The value we want to collect.
     * @param <T> This describes the type parameter.
     * @return List of certain value in object.
     */
    public static<T> List<T> collect(Iterator<T> iterator, T value) {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {
            T each = iterator.next();
            if(each.equals(value)) {
                list.add(each);
            }
        }
        return list;
    }

    /**
     *  Method to collect value which match the predicate in array
     * @param array The array we want to check.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> List of certain value in array
     * @return List of certain value in object
     */
    public static<T> List<T> collect(T[] array, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T each: array) {
            if(pred.predicate(each)) {
                list.add(each);
            }
        }
        return list;
    }

    /**
     * Method to collect value which match the predicate in Iterable object
     * @param iterable The Iterable object we want to check.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return List of certain value in object
     */
    public static<T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T each: iterable) {
            if(pred.predicate(each)) {
                list.add(each);
            }
        }
        return list;
    }

    /**
     * Method to collect value which match the predicate in Iterator object
     * @param iterator The Iterator object we want to check.
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return List of certain value in object
     */
    public static<T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {
            T each = iterator.next();
            if(pred.predicate(each)) {
                list.add(each);
            }
        }
        return list;
    }

    /**
     * Method to do pagination
     * @param array the collection we want to paginate
     * @param page the page to collect
     * @param pageSize the page size in pagination
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return list in certain page and page size
     */
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred){
        return Arrays.stream(array).filter(pred::predicate).skip(pageSize*page).limit(pageSize).collect(Collectors.toList());
    }

    /**
     * Method to do pagination
     * @param iterable the collection we want to paginate
     * @param page the page to collect
     * @param pageSize the page size in pagination
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return list in certain page and page size
     */
    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){
        List<T> list = new ArrayList<T>();
        int counter = 0, counterPrint = 0;
        int size = pageSize * page;
        for (T each : iterable){
            if (counter < size && pred.predicate(each)){
                counter++;
                continue;
            }
            if (counterPrint < pageSize && pred.predicate(each)){
                list.add(each);
                counterPrint++;
            }else{
                break;
            }
        }
        return list;
    }

    /**
     * Method to do pagination
     * @param iterator the collection we want to paginate
     * @param page the page to collect
     * @param pageSize the page size in pagination
     * @param pred The predicate (boolean-valued function) we want to check.
     * @param <T> This describes the type parameter.
     * @return list in certain page and page size
     */
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        int iteration = 0;
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);

        List<T> array = new ArrayList<T>();

        iterator.forEachRemaining(array::add);

        for (; iteration < array.size() && occurences < startingIdx; ++iteration) {
            if (pred.predicate(array.get(iteration))) {
                ++occurences;
            }
        }
        for (int i = 0; i < array.size() && pageList.size() < pageSize; ++i) {
            if (pred.predicate(array.get(iteration))) {
                pageList.add(array.get(iteration));
            }
        }
        return pageList;
    }
}
