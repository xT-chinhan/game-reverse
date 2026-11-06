package com.smartdigimkt.d0;

import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ n e;

    public m(n nVar, String str, String str2, String str3, long j) {
        this.e = nVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object aVar;
        try {
            WTWebView wTWebView = new WTWebView(SDKContext.getInstance().d());
            try {
                int i = this.e.d.h.c;
                if (i == 1 || i == 3) {
                    aVar = new com.smartdigimkt.m2.a();
                } else {
                    aVar = i != 4 ? null : new com.smartdigimkt.n2.a();
                }
                Object obj = aVar;
                long jCurrentTimeMillis = System.currentTimeMillis();
                String str = this.b;
                String string = new File(this.c).toURI().toString();
                l lVar = new l(this, jCurrentTimeMillis);
                q qVar = this.e.d;
                com.smartdigimkt.k2.y.a(1, qVar.h, qVar.f, lVar, wTWebView, obj, str, string);
            } catch (Throwable th) {
                n nVar = this.e;
                th.getMessage();
                String str2 = com.anythink.core.common.inner.b.b.U + th.getMessage();
                String str3 = this.a;
                if (nVar.a) {
                    return;
                }
                nVar.a = true;
                com.smartdigimkt.m3.g.a().a(nVar.b);
                q qVar2 = nVar.d;
                com.smartdigimkt.n3.k.a(qVar2.f, qVar2.h, false, System.currentTimeMillis() - nVar.c, 6, str2, 0L, str3);
                nVar.d.a(5);
            }
        } catch (Throwable th2) {
            n nVar2 = this.e;
            th2.getMessage();
            String str4 = com.anythink.core.common.inner.b.b.U + th2.getMessage();
            String str5 = this.a;
            if (nVar2.a) {
                return;
            }
            nVar2.a = true;
            com.smartdigimkt.m3.g.a().a(nVar2.b);
            q qVar3 = nVar2.d;
            com.smartdigimkt.n3.k.a(qVar3.f, qVar3.h, false, System.currentTimeMillis() - nVar2.c, 6, str4, 0L, str5);
            nVar2.d.a(5);
        }
    }
}
