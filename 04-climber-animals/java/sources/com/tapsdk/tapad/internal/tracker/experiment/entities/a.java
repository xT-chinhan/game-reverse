package com.tapsdk.tapad.internal.tracker.experiment.entities;

/* JADX INFO: loaded from: classes3.dex */
public class a<A, B> {
    public final A a;
    public final B b;

    public a(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public static <A, B> a<A, B> a(A a, B b) {
        return new a<>(a, b);
    }
}
