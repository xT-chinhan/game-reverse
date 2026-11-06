package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.umeng.analytics.pro.g;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class ab implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "download_popup_manager")
    protected com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah c;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "download_url")
    private String ch;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "event_tag")
    protected String d;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "download_conf")
    private JSONObject hi;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "download_status_listener")
    protected DownloadStatusChangeListener ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    protected lm f3155ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "is_click_button")
    private volatile boolean ny;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "app_info")
    private JSONObject sl;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.xr.xr u;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "is_open_oppo_market_auto_download")
    private volatile boolean x;

    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    protected Context xr;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "dialog_to_landing_page_convert")
    private com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms zb;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "convert_from_landing_page")
    protected volatile boolean ah = false;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "need_check_compliance")
    private int ab = 0;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        if (!ms()) {
            msVar.xr(map2);
            return true;
        }
        int iAh = com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ms.ah(map2);
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.d dVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.d(this.f3155ms, this.xr, this.d, this.c, this.ch);
        dVar.xr(this.ny);
        dVar.ms(this.x, iAh);
        dVar.ms(this.ka);
        dVar.ms(this.ah);
        dVar.ms(this.ab);
        dVar.ms(this.zb);
        dVar.ms(new nw(this.hi));
        if (new com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.xr(dVar, this.u).ms(map2)) {
            msVar.ms(map2);
        } else {
            msVar.xr(map2);
        }
        return true;
    }

    private boolean ms() {
        if (this.f3155ms == null || this.xr == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.ch)) {
            return (TextUtils.isEmpty(this.d) || this.c == null) ? false : true;
        }
        com.bytedance.sdk.openadsdk.core.nw.ka kaVarXr = com.bytedance.sdk.openadsdk.core.ms.xr(this.sl);
        if (kaVarXr != null) {
            this.ch = kaVarXr.xr();
        }
        return false;
    }
}
