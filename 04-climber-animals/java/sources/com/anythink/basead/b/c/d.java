package com.anythink.basead.b.c;

import android.text.TextUtils;
import com.anythink.basead.mraid.MraidWebView;
import com.anythink.basead.webtemplet.WTWebView;
import com.anythink.core.common.a.o;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final int a = 0;
    public static final int b = -1;
    public static final int c = 100;
    private static Map<String, Integer> d = new HashMap();
    private static ConcurrentHashMap<String, MraidWebView> e = new ConcurrentHashMap<>(3);
    private static ConcurrentHashMap<String, WTWebView> f = new ConcurrentHashMap<>(3);

    public static boolean a(String str) {
        Integer num = d.get(str);
        return num != null && num.intValue() == 0;
    }

    public static void a(String str, int i) {
        Integer num = d.get(str);
        if (num == null || num.intValue() < i) {
            d.put(str, Integer.valueOf(i));
        }
    }

    public static void a(String str, MraidWebView mraidWebView) {
        e.put(str, mraidWebView);
    }

    public static MraidWebView b(String str) {
        return e.remove(str);
    }

    public static void a(String str, WTWebView wTWebView) {
        f.put(str, wTWebView);
    }

    public static WTWebView c(String str) {
        return f.remove(str);
    }

    public static WTWebView d(String str) {
        return f.get(str);
    }

    public static void e(String str) {
        final WTWebView wTWebViewC = c(str);
        t.b().b(new Runnable() { // from class: com.anythink.basead.b.c.d.1
            @Override // java.lang.Runnable
            public final void run() {
                WTWebView wTWebView = wTWebViewC;
                if (wTWebView != null) {
                    wTWebView.release();
                }
            }
        });
    }

    public static boolean a(w wVar) {
        if (wVar != null) {
            return f.containsKey(a((x) null, wVar, 3));
        }
        return false;
    }

    public static boolean a(x xVar, w wVar) {
        if (xVar == null || wVar == null) {
            return false;
        }
        return e.containsKey(a(xVar, wVar, 2));
    }

    public static String b(x xVar, w wVar) {
        return a(xVar, wVar, 2);
    }

    public static String a(x xVar, w wVar, int i) {
        if (xVar != null) {
            return xVar.d + "_" + wVar.v() + "_" + i;
        }
        return wVar.q() + "_" + wVar.v() + "_" + i;
    }

    public static boolean f(String str) {
        return b(str, 1);
    }

    public static boolean a(w wVar, y yVar) {
        int iAa = yVar.aa();
        String strE = wVar.E();
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        if (iAa == 0) {
            return true;
        }
        boolean zA = o.a().a(strE, iAa);
        if (zA) {
            h.a(wVar, yVar);
        }
        return zA;
    }

    public static boolean a(w wVar, x xVar) {
        if (wVar == null) {
            return false;
        }
        if (wVar.aa() == -1) {
            s sVarC = t.b().c();
            if (sVarC != null && sVarC.a()) {
                sVarC.fillDataFetchStatus(t.b().g(), wVar, xVar);
            } else {
                wVar.m(0);
            }
        }
        y yVarR = xVar.o;
        if (wVar.r() != null) {
            yVarR = wVar.r();
        }
        return a(wVar, xVar.j, yVarR);
    }

    public static boolean a(w wVar, int i, y yVar) {
        boolean zC;
        if (TextUtils.equals(String.valueOf(i), "1")) {
            if (!TextUtils.isEmpty(wVar.E())) {
                boolean zA = a(wVar, yVar);
                if (wVar.ao() == 3) {
                    return zA && (yVar.bC() == 1 || b(wVar));
                }
                return zA;
            }
            if (yVar.an() == 1 || yVar.ao() > 0) {
                if (TextUtils.isEmpty(wVar.B())) {
                    return wVar.ao() == 2 && yVar.ao() == 1;
                }
                return c(wVar);
            }
            return c(wVar);
        }
        if (TextUtils.equals(String.valueOf(i), "3")) {
            if (wVar.J() == 1 && !TextUtils.isEmpty(wVar.E())) {
                zC = a(wVar, yVar);
            } else {
                if (wVar.ao() == 2) {
                    return true;
                }
                zC = c(wVar);
            }
            if (wVar.ao() == 3) {
                return zC && (yVar.bC() == 1 || b(wVar));
            }
            return zC;
        }
        if (!TextUtils.equals(String.valueOf(i), "4") || wVar.ao() == 2) {
            return true;
        }
        boolean z = a(wVar, yVar) || c(wVar);
        if (wVar.ao() == 3) {
            return z && (yVar.bC() == 1 || b(wVar));
        }
        return z;
    }

    private static boolean c(w wVar) {
        if (TextUtils.isEmpty(wVar.B())) {
            return false;
        }
        return com.anythink.core.common.res.d.a(t.b().g()).b(1, com.anythink.core.common.v.o.a(wVar.B()));
    }

    public static boolean b(w wVar) {
        if (wVar != null && wVar.ao() == 3) {
            if (a(wVar)) {
                return true;
            }
            if (wVar.r() != null && wVar.r().bB() != 1 && !TextUtils.isEmpty(com.anythink.core.common.res.d.a(t.b().g()).a(wVar.an()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str, int i) {
        return com.anythink.core.common.res.d.a(t.b().g()).b(i, com.anythink.core.common.v.o.a(str));
    }
}
