package com.bytedance.sdk.openadsdk.core.live.ka;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static boolean ms(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        return ms(lmVar.tc());
    }

    public static boolean ms(h hVar) {
        if (hVar == null) {
            return false;
        }
        String strXr = hVar.xr();
        if (TextUtils.isEmpty(strXr)) {
            return false;
        }
        return strXr.startsWith("snssdk2329") || strXr.startsWith("snssdk1128");
    }

    public static boolean ms(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("snssdk1128")) {
            return f.ms("com.ss.android.ugc.aweme");
        }
        if (str.startsWith("snssdk2329")) {
            return f.ms("com.ss.android.ugc.aweme.lite");
        }
        return false;
    }
}
