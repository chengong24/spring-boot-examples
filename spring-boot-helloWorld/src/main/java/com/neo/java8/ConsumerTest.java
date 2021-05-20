//package com.neo.java8;
//
//import java.util.function.Consumer;
//
///**
// * @author chengong
// * @date 2020/7/26 3:12 下午
// */
//public class ConsumerTest {
//
//
//    static class Person {
//        public Person() {
//        }
//
//        private String aaa;
//
//        public String getAaa() {
//            return aaa;
//        }
//
//        public void setAaa(String aaa) {
//            this.aaa = aaa;
//        }
//    }
//
//    public static void modifyTheValue3(int value, Consumer<Integer> consumer) {
//        consumer.andThen(consumer2()).accept(2);
//        consumer.accept(value);
//    }
//
//    public static void main(String[] args) {
//        // (x) -> System.out.println(x * 2)接受一个输入参数x
//        // 直接输出，并没有返回结果
//        // 所以该lambda表达式可以实现Consumer接口
////        modifyTheValue3(3, consumer());
//        Person person = new Person();
//        personConsumer().accept(person);
//        System.out.println(person.getAaa());
//        System.out.println(consumer(this::));
//
//    }
//
//
//    private static Consumer<Integer> consumer() {
//        return (x) -> System.out.println(x * 2);
//    }
//
//
//
//
//    private static void consumer(Consumer<Integer> consumer) {
//        consumer.accept(1);
//    }
//
//    private static Consumer<Integer> consumer2() {
//        return (x) -> System.out.println(x * 3);
//    }
//
//    private static Consumer<Person> personConsumer() {
//        return (p) -> p.setAaa("dfdfdf");
//    }
//
//
//}
