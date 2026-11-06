package com.anythink.basead.b;

import android.content.Context;
import com.anythink.core.common.d.t;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    private static volatile k a;
    private Context b = t.b().g();
    private com.anythink.core.common.v.a.c c = new com.anythink.core.common.v.a.c(1, 50);
    private com.anythink.core.common.v.a.f.b d = new com.anythink.core.common.v.a.f.b(1);

    private k() {
    }

    public static k a() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new k();
                }
            }
        }
        return a;
    }

    public final com.anythink.core.common.v.a.c b() {
        return this.c;
    }

    public final com.anythink.core.common.v.a.f.b c() {
        return this.d;
    }
}
