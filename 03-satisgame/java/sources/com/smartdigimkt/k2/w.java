package com.smartdigimkt.k2;

import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {
    public final /* synthetic */ com.smartdigimkt.b3.c a;
    public final /* synthetic */ com.smartdigimkt.a3.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ WTWebView d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;
    public final /* synthetic */ x g;
    public final /* synthetic */ Object h;

    public w(int i, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, x xVar, WTWebView wTWebView, Object obj, String str, String str2) {
        this.a = cVar;
        this.b = aVar;
        this.c = str;
        this.d = wTWebView;
        this.e = i;
        this.f = str2;
        this.g = xVar;
        this.h = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.c cVar = this.a;
        if (cVar == null || (eVar = cVar.w) == null) {
            com.smartdigimkt.a3.a aVar = this.b;
            eVar = aVar != null ? aVar.s : null;
        }
        boolean z = eVar != null && eVar.y1 == 1;
        this.d.initData(cVar, this.b, this.e == 1);
        boolean[] zArr = {false};
        this.d.setWebViewListener(new v(this, z, zArr));
        Object obj = this.h;
        if (obj instanceof com.smartdigimkt.l2.f) {
            com.smartdigimkt.l2.f fVar = (com.smartdigimkt.l2.f) obj;
            com.smartdigimkt.b3.c cVar2 = this.a;
            com.smartdigimkt.a3.a aVar2 = this.b;
            fVar.c = cVar2;
            fVar.d = aVar2;
        }
        this.d.setJsCommunicationObject(obj);
        this.d.loadUrl(this.c);
        if (this.e == 1 && z) {
            com.smartdigimkt.d0.s.b.put(this.f, this.d);
            zArr[0] = true;
            x xVar = this.g;
            if (xVar != null) {
                xVar.a();
            }
        }
    }
}
