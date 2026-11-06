package com.byazt.yq;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.sd.a;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1396, 37})
public class pr {
    public static volatile pr pr;

    private pr() {
    }

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    private void hw(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent("com.bytedance.minigame.preload.action");
            x xVarPr = hw.pr().pr(context);
            intent.putExtra("key_preload_info", hn.pr(xVarPr.hw, xVarPr.pr, str));
            intent.putExtra("key_preload_code", xVarPr.hn);
            context.sendBroadcast(intent);
            ho.hw("onPreloadFinish", "tryPreload finish1");
        } catch (Exception e) {
        }
    }

    public void pr(Context context, String str) {
        if (a.hw().x() && !TextUtils.isEmpty(str)) {
            pr().hw(context, str);
        }
    }
}
