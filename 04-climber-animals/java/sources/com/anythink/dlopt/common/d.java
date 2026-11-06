package com.anythink.dlopt.common;

import android.os.SystemClock;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.o;
import com.anythink.core.common.q;
import com.anythink.dlopt.api.ATAppDownloadListener;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class d implements CustomAdapterDownloadListener {
    ATBaseAdAdapter a;
    BaseAd b;
    ATAdInfo c;
    WeakReference<ATAppDownloadListener> d;
    long e;
    boolean f;
    boolean g;

    public d(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, ATEventInterface aTEventInterface) {
        this.a = aTBaseAdAdapter;
        this.b = baseAd;
        if (aTEventInterface == null || !(aTEventInterface instanceof ATAppDownloadListener)) {
            return;
        }
        this.d = new WeakReference<>((ATAppDownloadListener) aTEventInterface);
    }

    @Override // com.anythink.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadStart(long j, long j2, String str, String str2) {
        if (this.c == null) {
            a();
        }
        this.e = SystemClock.elapsedRealtime();
        a(18, 0L, str2);
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadStart(this.c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadUpdate(long j, long j2, String str, String str2) {
        if (this.c == null) {
            a();
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadUpdate(this.c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadPause(long j, long j2, String str, String str2) {
        if (this.c == null) {
            a();
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadPause(this.c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadFinish(long j, String str, String str2) {
        if (this.c == null) {
            a();
        }
        if (this.e != 0 && !this.g) {
            this.g = true;
            a(19, SystemClock.elapsedRealtime() - this.e, str2);
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadFinish(this.c, j, str, str2);
        }
    }

    @Override // com.anythink.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadFail(long j, long j2, String str, String str2) {
        if (this.c == null) {
            a();
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadFail(this.c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.dlopt.api.CustomAdapterDownloadListener
    public final void onInstalled(String str, String str2) {
        if (this.c == null) {
            a();
        }
        if (!this.f) {
            this.f = true;
            a(20, 0L, str2);
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onInstalled(this.c, str, str2);
        }
    }

    private void a() {
        BaseAd baseAd = this.b;
        if (baseAd != null) {
            this.c = l.a(baseAd, this.a);
        } else {
            this.c = l.a(this.a);
        }
    }

    private void a(final int i, final long j, final String str) {
        com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.dlopt.common.d.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    o oVar = new o();
                    oVar.b = d.this.b != null ? d.this.b.getDetail() : d.this.a.getTrackingInfo();
                    oVar.a = i;
                    oVar.c = System.currentTimeMillis();
                    if (oVar.b instanceof n) {
                        ((n) oVar.b).e(str);
                        ((n) oVar.b).p(j);
                    }
                    q.a(t.b().g()).a(i, oVar, com.anythink.core.d.d.a(t.b().g()).b(t.b().p()));
                } catch (Throwable unused) {
                }
            }
        });
    }
}
