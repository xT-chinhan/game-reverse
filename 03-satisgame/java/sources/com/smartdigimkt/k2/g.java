package com.smartdigimkt.k2;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.sdk.basead.webtemplet.adformat.WTCommonJSBridgePlugin;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public Pattern a;
    public final Context b;
    public final WTWebView c;

    public g(WTWebView wTWebView) {
        this.b = wTWebView != null ? wTWebView.getContext().getApplicationContext() : SDKContext.getInstance().d();
        this.c = wTWebView;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0049  */
    public final void a(String str) throws com.smartdigimkt.p2.a {
        d dVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            dVar = null;
        } else {
            Matcher matcher = this.a.matcher(str);
            if (matcher.matches()) {
                dVar = new d();
                int iGroupCount = matcher.groupCount();
                if (iGroupCount >= 5) {
                    dVar.f = matcher.group(5);
                }
                if (iGroupCount >= 3) {
                    dVar.d = matcher.group(1);
                    dVar.g = matcher.group(2);
                    dVar.e = matcher.group(3);
                    dVar.a = this.c;
                } else {
                    dVar = null;
                }
            } else {
                dVar = null;
            }
        }
        if (dVar == null) {
            return;
        }
        com.smartdigimkt.r4.e.a(dVar.f);
        WTWebView wTWebView = dVar.a;
        Object jsObject = wTWebView != null ? wTWebView.getJsObject(dVar.d) : null;
        if (jsObject == null) {
            return;
        }
        try {
            try {
                com.smartdigimkt.p2.b bVar = new com.smartdigimkt.p2.b(this.b.getClassLoader().loadClass(jsObject.getClass().getName()), dVar.e, new Class[]{Object.class, String.class});
                if (jsObject instanceof WTCommonJSBridgePlugin) {
                    dVar.c = bVar;
                    dVar.b = jsObject;
                    com.smartdigimkt.q3.f.a().a(new f(dVar));
                }
            } catch (Exception e) {
                throw new com.smartdigimkt.p2.a(e);
            }
        } catch (Throwable unused) {
        }
    }
}
