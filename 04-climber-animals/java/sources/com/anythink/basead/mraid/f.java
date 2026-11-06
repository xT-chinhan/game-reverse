package com.anythink.basead.mraid;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.anythink.core.express.d.a {
    private static f a;

    @Override // com.anythink.core.express.d.b
    public final void a(Object obj, String str) {
    }

    @Override // com.anythink.core.express.d.b
    public final void a(Object obj, String str, String str2) {
    }

    @Override // com.anythink.core.express.d.b
    public final void b(Object obj, String str) {
    }

    private f() {
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }
}
