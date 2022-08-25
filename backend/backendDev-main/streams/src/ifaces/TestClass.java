package ifaces;

import ifaces.impl.Inbool;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestClass {
    public static void main(String[] args) {
        Inbool inbool=new Inbool();
        System.out.println(inbool.test(5));
        System.out.println(inbool.test(50));
        testmethod();



    }
    public static  void testmethod() {
        List<Integer> integerList = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            integerList.add(index);
        }


        Inbool inbool= new Inbool();
        for (int index = 0; index < 20; index++) {
            if (inbool.test(integerList.get(index))) {
//                System.out.println(integerList.get(index));
            }
        }


        integerList.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer!=5;
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer !=6;
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "mutthu diamond : "+ integer;
            }
        }).max(new F).forEach(System.out::println);
//                .filter(inbool::test)
//                .filter(integer->{return integer!=12;})
//                .forEach(System.out::println);

    }
}
