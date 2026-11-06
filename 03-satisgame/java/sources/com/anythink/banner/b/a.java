package com.anythink.banner.b;

import android.text.TextUtils;
import android.util.Pair;
import com.anythink.banner.a.c;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.common.b.e;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.common.s.b;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String e = "a";
    String a;
    WeakReference<c> b;
    b c;
    CustomBannerAdapter d;
    private boolean g = false;
    private Runnable f = new Runnable() { // from class: com.anythink.banner.b.a.1
        @Override // java.lang.Runnable
        public final void run() {
            a.a(a.this);
            a.b(a.this);
        }
    };

    static /* synthetic */ boolean a(a aVar) {
        aVar.g = false;
        return false;
    }

    public a(c cVar) {
        this.b = new WeakReference<>(cVar);
    }

    public final void a(String str) {
        this.a = str;
    }

    public final boolean a() {
        return this.g;
    }

    public final synchronized void b() {
        CustomBannerAdapter customBannerAdapter;
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        l lVarA = n.a(s.b().g()).a(this.a);
        if (this.c != null) {
            c();
        }
        Pair<Boolean, Long> pairA = e.a(lVarA, lVarA != null && lVarA.an() == 1);
        boolean zBooleanValue = ((Boolean) pairA.first).booleanValue();
        long jLongValue = ((Long) pairA.second).longValue();
        if (zBooleanValue) {
            this.g = true;
            if (jLongValue <= 0) {
                jLongValue = 0;
            }
            if (jLongValue <= 0 && lVarA.l() == 2 && (customBannerAdapter = this.d) != null) {
                by unitGroupInfo = customBannerAdapter.getUnitGroupInfo();
                jLongValue = unitGroupInfo != null ? unitGroupInfo.aM() : 0L;
            }
            if (jLongValue <= 0) {
                jLongValue = lVarA.ao();
            }
            if (jLongValue <= 2000) {
                jLongValue = 2000;
            }
            b bVar = new b(jLongValue, this.f, (byte) 0);
            this.c = bVar;
            bVar.a();
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
        b bVar = this.c;
        if (bVar != null) {
            bVar.b();
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
