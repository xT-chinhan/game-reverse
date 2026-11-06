package com.bytedance.sdk.openadsdk.core.hi.ah;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ny {
    public ah(Context context, lm lmVar, String str, boolean z) {
        super(context, lmVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.x
    public boolean d() {
        if (this.ka.tc() == null) {
            return false;
        }
        String strXr = this.ka.tc().xr();
        if (!TextUtils.isEmpty(strXr)) {
            h.ms((String) null);
            Uri uri = Uri.parse(strXr);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            f.xr(intent);
            if (this.h) {
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ka, this.c, "lp_open_dpl", ms(strXr));
            }
            try {
                Context context = getContext();
                if (!(context instanceof Activity)) {
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                }
                if (!ms(this.c, "open_url_app", this.ka)) {
                    HashMap map = new HashMap();
                    map.put("source", "AndroidRDMLicManager");
                    com.bytedance.sdk.openadsdk.core.zb.ah.x(this.ka, this.c, "open_url_app", map);
                }
                f.ms(this.h, this.ka, this.c);
                com.bytedance.sdk.component.utils.xr.startActivity(context, intent, TextUtils.equals("main", UMModuleRegister.INNER));
                com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(this.ka, this.c, this.h);
                if (this.h) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ah(this.ka, this.c, "lp_openurl");
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, this.c, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, this.c, "deeplink_success_realtime", (Throwable) null);
                }
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ah(this.ka, this.c, "open_fallback_download");
                if (this.h) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ah(this.ka, this.c, "lp_openurl_failed");
                    ms(this.ka, this.c, "lp_deeplink_fail_realtime", th);
                } else {
                    ms(this.ka, this.c, "deeplink_fail_realtime", th);
                }
            }
        }
        if (this.ab.get() == 4 || this.ab.get() == 3) {
            return false;
        }
        if (this.ny && !this.x.get()) {
            return false;
        }
        this.ny = true;
        if (ms(this.c, "open_fallback_url", this.ka)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.x(this.ka, this.c, "open_fallback_url", null);
        return false;
    }
}
