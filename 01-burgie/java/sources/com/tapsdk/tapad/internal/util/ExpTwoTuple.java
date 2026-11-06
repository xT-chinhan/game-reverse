package com.tapsdk.tapad.internal.util;

/* JADX INFO: loaded from: classes3.dex */
public class ExpTwoTuple<A, B> {
    public final A paramA;
    public final B paramB;

    public ExpTwoTuple(A a, B b) {
        this.paramA = a;
        this.paramB = b;
    }

    public static <A, B> ExpTwoTuple<A, B> create(A a, B b) {
        return new ExpTwoTuple<>(a, b);
    }
}
