package com.smartdigimkt.j1;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements Serializable {
    public final Map a;
    public int b;
    public volatile boolean c = false;

    public d() {
    }

    public abstract void a();

    public abstract void a(com.smartdigimkt.h0.g gVar);

    public abstract void a(w wVar);

    public abstract void a(boolean z);

    public abstract void b();

    public abstract void b(w wVar);

    public void c() {
    }

    public abstract void d();

    public abstract void e();

    public d(String str, Map map) {
        this.a = map;
        com.smartdigimkt.n3.a aVarA = com.smartdigimkt.n3.a.a();
        c cVar = new c(this, str);
        aVarA.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        aVarA.a.put(str, cVar);
    }
}
