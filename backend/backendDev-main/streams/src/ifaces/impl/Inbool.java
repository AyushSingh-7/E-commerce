package ifaces.impl;

import ifaces.Ibool;

public class Inbool implements Ibool<Integer> {


    @Override
    public boolean test(Integer input) {
        return input%2==0;
    }
}
