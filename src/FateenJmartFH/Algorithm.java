package FateenJmartFH;

import java.util.Iterator;

public class Algorithm {
    private Algorithm(){

    }
    public static <T> int count(T[] array,T value){

        return array.length;
    }
    public static <T> int count(Iterable<T> iterable, T value){
        int counter = 0;
        for(Object i : iterable){
            counter++;
        }
        return counter;
    }

    public static <T> int count(Iterator<T> iterator, T value){
        int counter = 0;
        while (iterator.hasNext()){
            counter++;
        }
        return counter;
    }
    public static <T> int count(T[] array, Predicate<T> pred){
        int counter = 0;
        if (pred.equals(false)) {
            return 0;
        }else{
            for (T a:array){
                counter++;
            }
        }
        return counter;
    }
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        int counter = 0;
        if (pred.equals(false)) {
            return 0;
        }else{
            for (T a:iterable){
                counter++;
            }
        }
        return counter;
    }
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int counter = 0;
        if (pred.equals(false)) {
            return 0;
        }else{
            while (iterator.hasNext()){
                counter++;
            }
        }
        return counter;
    }


    public static <T> boolean exists(T[] array, T value) {
        for (T a : array){
            if(a.equals(value)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterable<T> iterable, T value){
        for (T a : iterable){
            if(a.equals(value)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterator<T> iterator, T value){
        while (iterator.hasNext()){
            if (iterator.next().equals(value)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(T[] array, Predicate<T> pred){
        for (T a : array){
            if(a.equals(pred)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        for (T a : iterable){
            if(a.equals(pred)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()){
            if (iterator.next().equals(pred)){
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] array, T value) {
        for (T a : array){
            if(a.equals(value)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterable<T> iterable, T value) {
        for (T a : iterable){
            if(a.equals(value)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterator<T> iterator, T value) {
        while (iterator.hasNext()){
            if(iterator.next().equals(value)){
                return iterator.next();
            }
        }
        return null;
    }
    public static <T> T find(T[] array, Predicate<T> pred) {
        for (T a : array){
            if(a.equals(pred)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        for (T a : iterable){
            if(a.equals(pred)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            if(iterator.next().equals(pred)){
                return iterator.next();
            }
        }
        return null;
    }

    public static <T> T max(T first, T second) {
        if(first.hashCode()>second.hashCode()){
            return first;
        }else {
            return second;
        }
    }
    public static <T> T min(T first, T second) {
        if(first.hashCode()>second.hashCode()){
            return second;
        }else {
            return first;
        }
    }

}
