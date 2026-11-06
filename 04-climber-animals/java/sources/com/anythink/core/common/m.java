package com.anythink.core.common;

import android.content.Context;
import android.os.Handler;
import com.anythink.core.common.h.av;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class m<T extends av> {
    protected Context d;
    final String a = getClass().getSimpleName();
    ArrayList<T> b = new ArrayList<>();
    private final AtomicBoolean g = new AtomicBoolean(false);
    Runnable f = new Runnable() { // from class: com.anythink.core.common.m.1
        @Override // java.lang.Runnable
        public final void run() {
            m.this.g.set(false);
            m.this.a(true);
        }
    };
    String c = com.anythink.core.common.d.t.b().p();
    protected final Handler e = com.anythink.core.common.v.b.b.a().a(9);

    protected abstract void a(List<T> list);

    protected m(Context context) {
        this.d = context.getApplicationContext();
    }

    public final synchronized void a(T t, boolean z) {
        Handler handler;
        if (!com.anythink.core.common.d.t.b().a()) {
            this.b.add(t);
            return;
        }
        boolean z2 = true;
        if (z) {
            this.b.add(t);
            a(true);
            return;
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.d).b(this.c);
        if (!this.g.compareAndSet(false, true)) {
            z2 = false;
        } else if (bVarB.ao() > 0 && (handler = this.e) != null) {
            handler.removeCallbacks(this.f);
            this.e.postDelayed(this.f, bVarB.ao());
            z2 = false;
        }
        this.b.add(t);
        a(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        Handler handler;
        try {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.b);
                if (arrayList.size() > 0) {
                    a(arrayList);
                }
                this.b.clear();
            } else {
                com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.d).b(this.c);
                ArrayList arrayList2 = new ArrayList();
                if (this.b.size() >= bVarB.am()) {
                    for (int iAm = bVarB.am() - 1; iAm >= 0; iAm--) {
                        arrayList2.add(this.b.get(iAm));
                        this.b.remove(iAm);
                    }
                    if (arrayList2.size() > 0) {
                        a(arrayList2);
                    }
                }
            }
            if (this.b.isEmpty() && (handler = this.e) != null) {
                handler.removeCallbacks(this.f);
                this.g.set(false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
