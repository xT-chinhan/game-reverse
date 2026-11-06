package com.byazt.ce;

import android.text.TextUtils;
import com.byazt.gct.x;
import com.byazt.tk.k;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1259, 19})
public class n {
    public static String n(String str) {
        if (!k.s() || TextUtils.isEmpty(str)) {
            return str;
        }
        x xVar = new x(com.byazt.vyf.s.cy().ur());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = xVar.qg().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append("&").append(xVar.n());
                } else {
                    sb.append("?").append(xVar.n());
                }
            }
        }
        return sb.toString();
    }
}
