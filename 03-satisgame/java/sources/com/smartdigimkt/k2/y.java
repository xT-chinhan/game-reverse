package com.smartdigimkt.k2;

import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y {
    public static final /* synthetic */ int a = 0;

    public static void a(int i, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, x xVar, WTWebView wTWebView, Object obj, String str, String str2) {
        if (wTWebView == null) {
            com.smartdigimkt.h0.g gVar = new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.b, "wtWebView is null");
            gVar.a();
            xVar.a(gVar);
        } else {
            if (obj == null) {
                com.smartdigimkt.h0.g gVar2 = new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.b, "h5 template not support this format");
                gVar2.a();
                xVar.a(gVar2);
            }
            com.smartdigimkt.q3.f.a().a(new w(i, aVar, cVar, xVar, wTWebView, obj, str2, str));
        }
    }
}
