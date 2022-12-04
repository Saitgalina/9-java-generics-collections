package com.example.task01;

import java.util.Objects;
import java.util.function.BiConsumer;

public class Pair<T1, T2> {
    private T1 valueT1;
    private T2 valueT2;

    private Pair(T1 valueT1, T2 valueT2) {
        this.valueT1 = valueT1;
        this.valueT2 = valueT2;
    }

    public T1 getFirst() {
        return valueT1;
    }

    public T2 getSecond() {
        return valueT2;
    }

    public void setFirst(T1 valueT1) {
        this.valueT1 = valueT1;
    }

    public void setSecond(T2 valueT2) {
        this.valueT2 = valueT2;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        Pair<T1,T2> newP = (Pair<T1, T2>)obj;
        if (this.valueT1 == newP.valueT1 && this.valueT2 ==newP.valueT2)
            return true;
        else
            return false;
    }


    public int hashCode(){
        return Objects.hash(this.valueT1,this.valueT2);
    }

    public static <T1, T2> Pair<T1, T2> of(T1 valueT1, T2 valueT2) {
        return new Pair<>(valueT1, valueT2);
    }

    public void ifPresent(BiConsumer biConsumer) {
        if (this.valueT1 != null && this.valueT2 != null) {
            biConsumer.accept(this.valueT1, this.valueT2);
        }
    }

}
