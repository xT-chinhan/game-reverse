package com.anythink.basead.webtemplet;

import com.tapsdk.tapad.constants.Constants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static HashMap<String, Class> a = new HashMap<>();
    private Object b;
    private WTWebView c;

    public f(WTWebView wTWebView) {
        this.c = wTWebView;
        try {
            a(com.anythink.core.common.m.e.Y, Class.forName("com.anythink.basead.webtemplet.adformat.WTCommonJSBridgePlugin"));
            a("splash", Class.forName("com.anythink.basead.webtemplet.adformat.splash.WTSplashJSBridgePlugin"));
            Class<?> cls = Class.forName("com.anythink.basead.webtemplet.adformat.intestitial.WTScreenJSBridgePlugin");
            a("inter", cls);
            a(Constants.AdTypeName.REWARD, cls);
        } catch (ClassNotFoundException unused) {
        }
    }

    private void a(Object obj) {
        this.b = obj;
    }

    private static Object a(String str, WTWebView wTWebView) {
        Class cls = a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!d.class.isAssignableFrom(cls)) {
                return null;
            }
            d dVar = (d) cls.newInstance();
            dVar.initialize(wTWebView);
            return dVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(String str, Class cls) {
        if (a == null) {
            a = new HashMap<>();
        }
        a.put(str, cls);
    }

    public final Object a(String str) {
        if (a == null) {
            a = new HashMap<>();
        }
        return a(str, this.c);
    }

    private static void b(String str) {
        if (a == null) {
            a = new HashMap<>();
        }
        a.remove(str);
    }

    private static void a() {
        try {
            a(com.anythink.core.common.m.e.Y, Class.forName("com.anythink.basead.webtemplet.adformat.WTCommonJSBridgePlugin"));
            a("splash", Class.forName("com.anythink.basead.webtemplet.adformat.splash.WTSplashJSBridgePlugin"));
            Class<?> cls = Class.forName("com.anythink.basead.webtemplet.adformat.intestitial.WTScreenJSBridgePlugin");
            a("inter", cls);
            a(Constants.AdTypeName.REWARD, cls);
        } catch (ClassNotFoundException unused) {
        }
    }
}
