package com.byazt.osx;

import com.byazt.jv.b;
import com.byazt.jv.qa;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 442, 61})
public final class aj {
    public static String pr(b bVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.hw());
        sb.append(' ');
        if (hw(bVar, type)) {
            sb.append(bVar.pr());
        } else {
            sb.append(pr(bVar.pr()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean hw(b bVar, Proxy.Type type) {
        return !bVar.zo() && type == Proxy.Type.HTTP;
    }

    public static String pr(qa qaVar) {
        String strZo = qaVar.zo();
        try {
            String strVk = qaVar.vk();
            return strVk != null ? strZo + '?' + strVk : strZo;
        } catch (OutOfMemoryError e) {
            return strZo;
        }
    }
}
