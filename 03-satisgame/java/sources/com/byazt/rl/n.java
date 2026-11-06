package com.byazt.rl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 488, 19})
public class n {
    public static volatile n n;

    private n() {
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    private void qg(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent("com.bytedance.minigame.preload.action");
            q qVarN = qg.n().n(context);
            intent.putExtra("key_preload_info", s.n(qVarN.qg, qVarN.n, str));
            intent.putExtra("key_preload_code", qVarN.s);
            context.sendBroadcast(intent);
            k.qg("onPreloadFinish", "tryPreload finish1");
        } catch (Exception unused) {
        }
    }

    public void n(Context context, String str) {
        if (!rv.qg().q() || TextUtils.isEmpty(str)) {
            return;
        }
        n().qg(context, str);
    }
}
