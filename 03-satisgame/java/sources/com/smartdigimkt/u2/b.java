package com.smartdigimkt.u2;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {
    public static volatile b f;

    public b(Context context) {
        super(context);
    }

    public static a a(Context context) {
        if (f == null) {
            synchronized (a.class) {
                if (f == null) {
                    f = new b(context);
                }
            }
        }
        return f;
    }

    @Override // com.smartdigimkt.u2.a
    public final int a() {
        return 2;
    }
}
