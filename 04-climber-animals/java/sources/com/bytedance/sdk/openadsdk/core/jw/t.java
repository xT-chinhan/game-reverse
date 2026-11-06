package com.bytedance.sdk.openadsdk.core.jw;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static void ms(final Uri uri, final com.bytedance.sdk.openadsdk.core.pc pcVar) {
        if (pcVar == null || !pcVar.ms(uri)) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.t.1
                @Override // java.lang.Runnable
                public void run() {
                    pcVar.xr(uri);
                }
            });
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.xr("WebView", "TTAndroidObj handleUri exception: ".concat(String.valueOf(e)));
        }
    }

    public static void ms(final com.bytedance.sdk.component.zb.ah ahVar, final int i, final boolean z) {
        if (ahVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.t.2
            @Override // java.lang.Runnable
            public void run() {
                String userAgentString = ahVar.getUserAgentString();
                if (TextUtils.isEmpty(userAgentString)) {
                    return;
                }
                StringBuilder sb = new StringBuilder(userAgentString);
                sb.append(" open_news open_news_u_s/").append(i);
                if (z) {
                    sb.append("/").append(f.ch());
                }
                ahVar.setUserAgentString(sb.toString());
            }
        });
    }
}
