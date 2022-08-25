package ifaces.impl;
import  ifaces.Ibool;
public class GenericBool<T>implements  Ibool<T> {

    @Override
    public boolean test(T input) {
        return false;
    }
}
