package com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ms {
    private AdDownloadController ch;
    private DownloadModel hi;

    public ab(lm lmVar, Context context, String str, com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVar, String str2, AdDownloadController adDownloadController, DownloadModel downloadModel) {
        this.ch = adDownloadController;
        this.hi = downloadModel;
        this.f3140ms = lmVar;
        this.xr = context;
        this.ah = str;
        this.d = ahVar;
        this.ka = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms
    public com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms d(final Map<String, Object> map) {
        final int iAh = ms.ah(map);
        DownloadEventConfig downloadEventConfigMs = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(this.ah).build(), f.y(this.f3140ms));
        map.put("id", Long.valueOf(this.hi.getId()));
        map.put(TTDownloadField.TT_ACTION_TYPE_BUTTON, 2);
        map.put(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG, downloadEventConfigMs);
        map.put(TTDownloadField.TT_DOWNLOAD_CONTROLLER, this.ch);
        if (!ah(iAh)) {
            ms(map, true);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ab.1
            @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms, com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
            public void handleComplianceDialog(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms, com.bytedance.sdk.openadsdk.core.le.ms.ms.ms
            public void handleMarketFailedComplianceDialog() {
                if (map == null || ab.this.ch == null) {
                    return;
                }
                ab.this.ch.setDownloadMode(0);
                ab.this.d.ms(ab.this.xr(iAh));
                map.remove(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER);
                if (ab.this.ms((com.bytedance.sdk.openadsdk.core.nw.d) null, (com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ms) null, map)) {
                    return;
                }
                ab.this.ms(map, true);
            }
        };
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(map, msVar);
        return msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms
    protected boolean ms() {
        if (this.ch == null || this.hi == null) {
            return false;
        }
        return super.ms();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms
    public void xr(boolean z, int i) {
        if (this.ch == null) {
            return;
        }
        try {
            xr();
            this.ch.setEnableOppoAutoDownload(z);
        } catch (Throwable unused) {
        }
    }

    private void xr() {
        if (this.f3140ms == null) {
            return;
        }
        String strDa = this.f3140ms.da();
        if (TextUtils.isEmpty(strDa) || g.xr < 6400 || g.c()) {
            return;
        }
        final String strEu = this.f3140ms.eu();
        final String strCz = this.f3140ms.cz();
        final com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar = (com.bytedance.sdk.openadsdk.ao.xr.ms.ms) i.ms(strDa, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
        if (msVar != null && !TextUtils.isEmpty(this.f3140ms.zm()) && this.f3140ms.mh().d() == 1) {
            this.ch.setDownloadMarketInterceptor(new DownloadMarketInterceptor() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ab.2
                @Override // com.ss.android.download.api.config.DownloadMarketInterceptor
                public Map<String, Object> interceptObmMarket(Map<String, Object> map) {
                    if (map != null) {
                        if (!ab.this.c) {
                            map.put("is_button", Boolean.FALSE);
                        }
                        Object obj = map.get("is_button");
                        msVar.ms(100, map);
                        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(map, obj, strEu, strCz);
                    } else {
                        u uVarMs = u.ms();
                        Boolean bool = Boolean.FALSE;
                        uVarMs.ms(bool, bool, "uchain param is null", strEu, strCz);
                    }
                    return map;
                }
            });
        } else {
            this.ch.setDownloadMarketInterceptor(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms
    public boolean ah(int i) {
        AdDownloadController adDownloadController = this.ch;
        return adDownloadController != null && adDownloadController.getDownloadMode() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms
    public com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.xr ms(final Map<String, Object> map, final of<String, Object> ofVar) {
        return new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ab.3
            @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.xr, com.ss.android.download.api.config.OnItemClickListener
            public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
                if (!ab.this.ab && !ab.this.f3140ms.sh()) {
                    com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.ms(ab.this.f3140ms, ab.this.xr, ab.this.ah, f.xr(ab.this.ah));
                    msVar.ah(true);
                    msVar.ms((Map<String, Object>) new HashMap());
                } else {
                    Object obj = map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG);
                    if (obj instanceof DownloadEventConfig) {
                        ((DownloadEventConfig) obj).setDownloadScene(1);
                        ofVar.remove(TTDownloadField.TT_ITEM_CLICK_LISTENER);
                        ab.this.ny.call(17, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ofVar).xr(), Void.class);
                    }
                }
            }
        };
    }
}
