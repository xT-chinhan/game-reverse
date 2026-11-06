package com.bytedance.sdk.openadsdk.core.component.reward.ka;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.nw.ab;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static String ms(String str) {
        if (!sl.ah() || TextUtils.isEmpty(str)) {
            return str;
        }
        ab abVar = new ab(ch.ub().yu());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = abVar.xr().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append("&").append(abVar.ms());
                } else {
                    sb.append("?").append(abVar.ms());
                }
            }
        }
        return sb.toString();
    }
}
