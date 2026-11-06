package com.anythink.china.b;

import android.os.SystemClock;
import com.anythink.china.api.ATAppDownloadListener;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.k;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.o;
import com.anythink.core.common.q;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class b implements CustomAdapterDownloadListener {
    ATBaseAdAdapter a;
    BaseAd b;
    ATAdInfo c;
    WeakReference<ATAppDownloadListener> d;
    long e;
    boolean f;
    boolean g;

    public b(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, ATEventInterface aTEventInterface) {
        this.a = aTBaseAdAdapter;
        this.b = baseAd;
        if (aTEventInterface instanceof ATAppDownloadListener) {
            this.d = new WeakReference<>((ATAppDownloadListener) aTEventInterface);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
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

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
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

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
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

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
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

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
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

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
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
            this.c = k.a(baseAd, this.a);
        } else {
            this.c = k.a(this.a);
        }
    }

    private void a(final int i, final long j, final String str) {
        com.anythink.core.common.u.b.c.a().a(new d(e.R, new Runnable() { // from class: com.anythink.china.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    o oVar = new o();
                    oVar.b = b.this.b != null ? b.this.b.getDetail() : b.this.a.getTrackingInfo();
                    oVar.a = i;
                    oVar.c = System.currentTimeMillis();
                    if (oVar.b instanceof n) {
                        ((n) oVar.b).e(str);
                        ((n) oVar.b).q(j);
                    }
                    q.a(s.b().g()).a(i, oVar, com.anythink.core.e.d.a(s.b().g()).b(s.b().p()));
                } catch (Throwable unused) {
                }
            }
        }));
    }
}
