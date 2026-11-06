package com.bytedance.sdk.openadsdk.core.xr.ms.xr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.re;
import com.bytedance.sdk.openadsdk.core.ul;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends com.bytedance.sdk.openadsdk.core.xr.ms.ms {
    private int ab;
    private String c;
    private i ka;
    private com.bytedance.sdk.openadsdk.core.xr.d x;

    public ka() {
    }

    public ka(lm lmVar, Context context, com.bytedance.sdk.openadsdk.core.xr.d dVar) {
        this.x = dVar;
        this.f3767ms = lmVar;
        this.xr = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        Boolean boolMs = ms();
        if (boolMs == null) {
            return 0;
        }
        if (boolMs.booleanValue() && ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map, ahVar) == 0) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class)).ms(map, ahVar);
        }
        return boolMs.booleanValue() ? 1 : 0;
    }

    private Boolean ms() {
        boolean zAh;
        i iVar = this.ka;
        if (iVar == null || TextUtils.isEmpty(iVar.h) || !re.ms(this.f3767ms, this.ka.h)) {
            return null;
        }
        if (re.xr(this.f3767ms, this.ka.h) == 1) {
            zAh = ah();
        } else {
            zAh = xr();
        }
        return Boolean.valueOf(zAh);
    }

    public void ms(i iVar) {
        this.ka = iVar;
    }

    private boolean xr() {
        String strAh = re.ah(this.f3767ms, this.ka.h);
        if (TextUtils.isEmpty(strAh)) {
            return false;
        }
        Uri uri = Uri.parse(com.bytedance.sdk.openadsdk.core.hi.ah.ms(this.f3767ms, strAh));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        f.xr(intent);
        HashMap map = new HashMap();
        map.put("source", "DpaSubClickHandler");
        if (f.xr(this.xr)) {
            if (!f.ms(this.xr, intent)) {
                return false;
            }
            com.bytedance.sdk.component.utils.xr.ms(this.xr, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka.1
                @Override // com.bytedance.sdk.component.utils.xr.ms
                public void ms() {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(ka.this.f3767ms, ka.this.c, "deeplink_success_realtime", (Throwable) null);
                }

                @Override // com.bytedance.sdk.component.utils.xr.ms
                public void ms(Throwable th) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(ka.this.f3767ms, ka.this.c, "deeplink_fail_realtime", th);
                }
            }, TextUtils.equals("main", UMModuleRegister.INNER));
            com.bytedance.sdk.openadsdk.core.zb.ah.x(this.f3767ms, this.c, "open_url_app", map);
            com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(this.f3767ms, this.c, false);
            return true;
        }
        try {
            com.bytedance.sdk.openadsdk.core.zb.ah.x(this.f3767ms, this.c, "open_url_app", map);
            com.bytedance.sdk.component.utils.xr.startActivity(this.xr, intent, TextUtils.equals("main", UMModuleRegister.INNER));
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.f3767ms, this.c, "deeplink_success_realtime", (Throwable) null);
            com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(this.f3767ms, this.c, false);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean ah() {
        return ul.ms(this.xr, re.ah(this.f3767ms, this.ka.h), this.f3767ms, this.ab, this.c);
    }

    public void ms(String str) {
        this.c = str;
    }

    public void ms(int i) {
        this.ab = i;
    }
}
