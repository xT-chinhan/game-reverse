package com.smartdigimkt.f2;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static volatile a b;
    public final HashMap a = new HashMap();

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }
}
