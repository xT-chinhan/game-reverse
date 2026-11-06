package com.smartdigimkt.p3;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public final int a;
    public final ArrayList b;
    public long c;
    public final j d;
    public final Map e;
    public final l f;
    public h g;
    public final m h;
    public final Handler i;
    public boolean j;

    public n(int i, int i2) {
        WeakHashMap weakHashMap = new WeakHashMap(10);
        l lVar = new l(i2);
        Handler handler = new Handler(Looper.getMainLooper());
        this.a = 100;
        this.c = 0L;
        this.e = weakHashMap;
        this.f = lVar;
        this.i = handler;
        this.h = new m(this);
        this.b = new ArrayList(50);
        this.d = new j(this);
        this.a = i;
    }

    public final void a(long j) {
        for (Map.Entry entry : this.e.entrySet()) {
            if (((k) entry.getValue()).c < j) {
                this.b.add((View) entry.getKey());
            }
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            this.e.remove((View) it.next());
        }
        this.b.clear();
    }
}
