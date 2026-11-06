package com.anythink.banner.b;

import android.text.TextUtils;
import com.anythink.banner.a.c;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bv;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class a {
    String a;
    WeakReference<c> b;
    com.anythink.core.common.t.c c;
    CustomBannerAdapter d;
    private boolean f = false;
    private Runnable e = new Runnable() { // from class: com.anythink.banner.b.a.1
        @Override // java.lang.Runnable
        public final void run() {
            a.a(a.this);
            a.b(a.this);
        }
    };

    static /* synthetic */ boolean a(a aVar) {
        aVar.f = false;
        return false;
    }

    public a(c cVar) {
        this.b = new WeakReference<>(cVar);
    }

    public final void a(String str) {
        this.a = str;
    }

    public final boolean a() {
        return this.f;
    }

    public final synchronized void b() {
        CustomBannerAdapter customBannerAdapter;
        bv unitGroupInfo;
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        l lVarA = n.a(t.b().g()).a(this.a);
        if (this.c != null) {
            c();
        }
        if (lVarA != null && lVarA.ao() == 1) {
            this.f = true;
            long jAE = (lVarA.k() != 2 || (customBannerAdapter = this.d) == null || (unitGroupInfo = customBannerAdapter.getUnitGroupInfo()) == null) ? 0L : unitGroupInfo.aE();
            if (jAE <= 0) {
                jAE = lVarA.ap();
            }
            if (jAE <= com.anythink.basead.exoplayer.i.a.f) {
                jAE = 2000;
            }
            com.anythink.core.common.t.c cVar = new com.anythink.core.common.t.c(jAE, this.e, false);
            this.c = cVar;
            cVar.a();
        }
    }

    private void d() {
        WeakReference<c> weakReference = this.b;
        c cVar = weakReference != null ? weakReference.get() : null;
        if (cVar != null) {
            cVar.timeUpRefreshView();
        } else {
            c();
        }
    }

    public final void a(CustomBannerAdapter customBannerAdapter) {
        this.d = customBannerAdapter;
    }

    public final synchronized void c() {
        com.anythink.core.common.t.c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
        this.c = null;
    }

    static /* synthetic */ void b(a aVar) {
        WeakReference<c> weakReference = aVar.b;
        c cVar = weakReference != null ? weakReference.get() : null;
        if (cVar != null) {
            cVar.timeUpRefreshView();
        } else {
            aVar.c();
        }
    }
}
