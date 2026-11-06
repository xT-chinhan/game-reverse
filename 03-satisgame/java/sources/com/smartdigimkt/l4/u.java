package com.smartdigimkt.l4;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u {
    public static com.smartdigimkt.m4.a a = new n();
    public static volatile Executor b;

    public static Executor a() {
        if (b == null) {
            synchronized (u.class) {
                if (b == null) {
                    b = Executors.newCachedThreadPool();
                }
            }
        }
        return b;
    }
}
