package com.bytedance.sdk.openadsdk.core.live.ah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.zb.ah;
import com.bytedance.sdk.openadsdk.core.zb.c;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f2830ms = "";

    public ms ms(String str) {
        this.f2830ms = str;
        return this;
    }

    public void ms(final Context context, final lm lmVar) {
        if (lmVar == null || lmVar.tc() == null || TextUtils.isEmpty(lmVar.tc().xr())) {
            return;
        }
        nw.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.ah.ms.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(lmVar.tc().xr()));
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                    if (com.bytedance.sdk.component.utils.xr.ms(context, intent, null, TextUtils.equals("main", UMModuleRegister.INNER))) {
                        ah.ms(lmVar, ms.this.f2830ms, "deeplink_success_realtime", (Throwable) null);
                    } else {
                        ah.ms(lmVar, ms.this.f2830ms, "deeplink_fail_realtime", (Throwable) null);
                    }
                    HashMap map = new HashMap();
                    map.put("source", "LiveDoubleOpenProcessor");
                    ah.x(lmVar, ms.this.f2830ms, "open_url_app", map);
                    c.ms().ms(lmVar, ms.this.f2830ms, false);
                } catch (Throwable th) {
                    sl.ms(th);
                }
            }
        }, 50L);
    }
}
