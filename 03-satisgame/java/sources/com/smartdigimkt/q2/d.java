package com.smartdigimkt.q2;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.n3.a0;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.l;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.bridge.entity.AppInfoEntity;
import com.smartdigimkt.x.i;
import com.smartdigimkt.x.j;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ SDKContext a;

    public d(SDKContext sDKContext) {
        this.a = sDKContext;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a.H.compareAndSet(false, true)) {
                com.smartdigimkt.f3.a aVar = new com.smartdigimkt.f3.a();
                aVar.v = h.z();
                com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(21, aVar, -1L);
            }
            com.smartdigimkt.v3.f.a().a(this.a.c);
            SDKContext sDKContext = this.a;
            SDKContext.a(sDKContext, sDKContext.c);
            SDKContext.c(this.a);
            Context context = this.a.c;
            if (l.c == null) {
                synchronized (l.class) {
                    if (l.c == null) {
                        l.c = new l(context);
                    }
                }
            }
            l lVar = l.c;
            lVar.getClass();
            com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
            if (aVarA == null || aVarA.x != 0) {
                try {
                    lVar.b();
                    if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof l)) {
                        lVar.a = Thread.getDefaultUncaughtExceptionHandler();
                    }
                    Thread.setDefaultUncaughtExceptionHandler(lVar);
                } catch (Exception unused) {
                }
            }
            SDKContext sDKContext2 = this.a;
            sDKContext2.a(sDKContext2.c, this.a.a);
            j jVarA = j.a();
            jVarA.getClass();
            com.smartdigimkt.q3.f.a().getClass();
            if (com.smartdigimkt.q3.f.c()) {
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.x.e(jVarA, null));
            } else {
                jVarA.a((i) null);
            }
            com.smartdigimkt.w2.b bVarE = this.a.e();
            if (bVarE != null) {
                bVarE.cleanExpiredInfo();
            }
            a0.a().b();
            com.smartdigimkt.o4.e.c().a((com.smartdigimkt.h3.b) null);
            SDKContext sDKContext3 = this.a;
            sDKContext3.a(sDKContext3.c, this.a.A);
            if (this.a.j()) {
                h.b(this.a.c);
                com.smartdigimkt.r4.j.a();
                AppInfoEntity appInfoEntity = h.X;
                if (!TextUtils.isEmpty(appInfoEntity != null ? appInfoEntity.getMediationVersion() : com.smartdigimkt.r4.j.a())) {
                    AppInfoEntity appInfoEntity2 = h.X;
                    if (appInfoEntity2 != null) {
                        appInfoEntity2.getMediationVersion();
                    } else {
                        com.smartdigimkt.r4.j.a();
                    }
                }
                com.smartdigimkt.r4.j.a();
            }
            SDKContext.b(this.a);
        } catch (Throwable unused2) {
        }
    }
}
