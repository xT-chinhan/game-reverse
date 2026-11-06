package com.smartdigimkt.u2;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    public static volatile c f;

    public c(Context context) {
        super(context);
    }

    public static c a(Context context) {
        if (f == null) {
            synchronized (c.class) {
                if (f == null) {
                    f = new c(context);
                }
            }
        }
        return f;
    }

    @Override // com.smartdigimkt.u2.a
    public final int a() {
        return 1;
    }
}
