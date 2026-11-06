package com.bytedance.sdk.openadsdk.core.hi;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final LruCache<String, com.bytedance.sdk.openadsdk.core.nw.d> f2639ms = new LruCache<>(10);

    public static void ms(String str, com.bytedance.sdk.openadsdk.core.nw.d dVar) {
        if (re.xr().br() && !TextUtils.isEmpty(str) && dVar != null && dVar.ka()) {
            f2639ms.put(str, dVar);
        }
    }

    public static com.bytedance.sdk.openadsdk.core.nw.d ms(String str) {
        com.bytedance.sdk.openadsdk.core.nw.d dVar;
        if (re.xr().br() && (dVar = f2639ms.get(str)) != null && dVar.ka()) {
            return dVar;
        }
        return null;
    }

    public static void ms(final lm lmVar) {
        if (re.xr().br() && lmVar != null) {
            final String strXr = lmVar.zh() != null ? lmVar.zh().xr() : "";
            if (!TextUtils.isEmpty(strXr) && lmVar.jr() == 4 && TextUtils.isEmpty(lmVar.zm())) {
                if ((lmVar.mh() == null || lmVar.mh().xr() == 0) && ub.ms(lmVar) == 2) {
                    com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny("preloadAppInfo") { // from class: com.bytedance.sdk.openadsdk.core.hi.ms.1
                        @Override // java.lang.Runnable
                        public void run() {
                            re.ms().ms(lmVar, strXr);
                        }
                    });
                }
            }
        }
    }
}
