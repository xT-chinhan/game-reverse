package com.bytedance.sdk.openadsdk.core.hi.ah;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ub {
    public static int ms(lm lmVar) {
        if (lmVar == null || lmVar.oy() != 1) {
            return 0;
        }
        if (lmVar.dv() == 0) {
            return 1;
        }
        if (lmVar.dv() == 1) {
            return ah(lmVar) ? 0 : 1;
        }
        return lmVar.dv() == 2 ? 2 : 1;
    }

    public static String xr(lm lmVar) {
        if (lmVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = lmVar.zh();
        if (kaVarZh != null && !TextUtils.isEmpty(kaVarZh.ah())) {
            return kaVarZh.ah();
        }
        if (!TextUtils.isEmpty(lmVar.nq())) {
            return lmVar.nq();
        }
        if (TextUtils.isEmpty(lmVar.fs())) {
            return !TextUtils.isEmpty(lmVar.yw()) ? lmVar.yw() : "";
        }
        return lmVar.fs();
    }

    public static boolean ah(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        return d(lmVar);
    }

    public static boolean d(lm lmVar) {
        com.bytedance.sdk.openadsdk.core.nw.c cVarPh = lmVar.ph();
        return (cVarPh == null || TextUtils.isEmpty(cVarPh.u()) || TextUtils.isEmpty(cVarPh.ka()) || TextUtils.isEmpty(cVarPh.ab()) || cVarPh.ms() == null || cVarPh.ms().size() <= 0 || TextUtils.isEmpty(cVarPh.x()) || TextUtils.isEmpty(cVarPh.ny())) ? false : true;
    }

    public static void ms(final Context context) {
        if (context == null) {
            context = re.getContext();
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            op.ms(context, "应用信息缺失，暂无法响应下载", 1);
        } else {
            nw.c().post(new com.bytedance.sdk.component.ch.ny("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.ub.1
                @Override // java.lang.Runnable
                public void run() {
                    op.ms(context, "应用信息缺失，暂无法响应下载", 1);
                }
            });
        }
    }
}
