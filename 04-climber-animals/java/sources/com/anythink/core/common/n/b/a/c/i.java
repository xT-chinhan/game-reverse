package com.anythink.core.common.n.b.a.c;

import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.v;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    private i() {
    }

    private static String a(ad adVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(adVar.b());
        sb.append(' ');
        if (!adVar.g() && type == Proxy.Type.HTTP) {
            sb.append(adVar.a());
        } else {
            sb.append(a(adVar.a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(ad adVar, Proxy.Type type) {
        return !adVar.g() && type == Proxy.Type.HTTP;
    }

    public static String a(v vVar) {
        String strH = vVar.h();
        String strJ = vVar.j();
        return strJ != null ? strH + '?' + strJ : strH;
    }
}
