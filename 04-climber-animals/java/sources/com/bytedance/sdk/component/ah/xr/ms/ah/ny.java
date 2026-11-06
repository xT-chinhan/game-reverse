package com.bytedance.sdk.component.ah.xr.ms.ah;

import com.bytedance.sdk.component.ah.xr.y;
import com.bytedance.sdk.component.ah.xr.yu;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class ny {
    public static String ms(yu yuVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yuVar.xr());
        sb.append(' ');
        if (xr(yuVar, type)) {
            sb.append(yuVar.ms());
        } else {
            sb.append(ms(yuVar.ms()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean xr(yu yuVar, Proxy.Type type) {
        return !yuVar.x() && type == Proxy.Type.HTTP;
    }

    public static String ms(y yVar) {
        String strNy = yVar.ny();
        try {
            String strHi = yVar.hi();
            if (strHi != null) {
                return strNy + '?' + strHi;
            }
        } catch (OutOfMemoryError unused) {
        }
        return strNy;
    }
}
