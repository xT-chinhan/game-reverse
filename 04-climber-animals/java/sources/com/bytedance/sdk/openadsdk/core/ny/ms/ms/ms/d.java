package com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {
    public d(lm lmVar, Context context, String str, com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVar, String str2) {
        this.f3140ms = lmVar;
        this.xr = context;
        this.ah = str;
        this.d = ahVar;
        this.ka = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms
    public com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms d(final Map<String, Object> map) {
        final int iAh = ms.ah(map);
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.ah, this.ah, f.y(this.f3140ms), iAh);
        map.put(TTDownloadField.TT_ACTION_TYPE_BUTTON, 2);
        if (this.f3140ms != null && !TextUtils.isEmpty(this.f3140ms.df())) {
            map.put("id", Long.valueOf(Double.valueOf(this.f3140ms.df()).longValue()));
        }
        if (!ah(iAh)) {
            ms(map, true);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.d.1
            @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms, com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
            public void handleComplianceDialog(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms, com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
            public void handleMarketFailedComplianceDialog() {
                if (map == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(0, iAh);
                d.this.d.ms(d.this.xr(iAh));
                map.remove(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER);
                if (d.this.ms((com.bytedance.sdk.openadsdk.core.nw.d) null, (com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms) null, map)) {
                    return;
                }
                d.this.ms(map, true);
            }
        };
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(map, msVar);
        return msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms
    public boolean ah(int i) {
        return this.ny != null && com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.ny, i) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms
    public void xr(boolean z, int i) {
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(z, com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(this.f3140ms, this.c), i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms
    public com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.xr ms(Map<String, Object> map, final of<String, Object> ofVar) {
        final int iAh = ms.ah(ofVar);
        return new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.d.2
            @Override // com.bytedance.sdk.openadsdk.core.le.ms.ms.d
            public void ms(Bridge bridge, Bridge bridge2, Bridge bridge3) {
                if (!d.this.ab && !d.this.f3140ms.sh()) {
                    com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.ms(d.this.f3140ms, d.this.xr, d.this.ah, f.xr(d.this.ah));
                    msVar.ah(true);
                    msVar.ms((Map<String, Object>) new HashMap());
                } else {
                    com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.xr(1, iAh);
                    ofVar.remove(TTDownloadField.TT_ITEM_CLICK_LISTENER);
                    d.this.ny.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVar).xr(), Void.class);
                }
            }
        };
    }
}
