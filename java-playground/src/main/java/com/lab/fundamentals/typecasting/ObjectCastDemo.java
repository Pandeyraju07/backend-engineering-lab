package com.lab.fundamentals.typecasting;

/** Object casting — upcast to Number, safe downcast to Integer / long value extraction. */
public class ObjectCastDemo {

    public static void main(String[] args) {
        Number boxed = Integer.valueOf(42);
        Integer asInt = asInteger(boxed);
        long cents = safeLongValue(Long.valueOf(7_500_000L));
        System.out.printf("Object cast: asInteger=%s, safeLong=%d%n", asInt, cents);
    }

    /** Downcasts Number → Integer when the runtime type is Integer; otherwise null. */
    static Integer asInteger(Number value) {
        if (value instanceof Integer integer) {
            return integer;
        }
        return null;
    }

    /** Reads any Number as long via Number.longValue() (safe for Integer/Long/etc.). */
    static long safeLongValue(Number value) {
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }
}
