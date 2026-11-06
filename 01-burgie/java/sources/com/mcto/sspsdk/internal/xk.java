package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class xk {
    public static volatile xk b;
    public final zk a = new zk();

    public static xk a() {
        if (b == null) {
            synchronized (xk.class) {
                if (b == null) {
                    b = new xk();
                }
            }
        }
        return b;
    }
}
