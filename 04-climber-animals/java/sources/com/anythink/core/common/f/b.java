package com.anythink.core.common.f;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    protected static volatile a c;

    private b(Context context) {
        super(context);
        this.b = 2;
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new b(context);
                }
            }
        }
        return c;
    }
}
