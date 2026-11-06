package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends com.bytedance.adsdk.ugeno.xr.ah<InteractWebView> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3459ms;
    private Map<String, Object> vf;

    public sl(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public InteractWebView ms() {
        this.ka = new InteractWebView(this.xr);
        return (InteractWebView) this.ka;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        this.vf = this.ny.xr();
        ((InteractWebView) this.ka).setUGenExtraMap(this.vf);
        ((InteractWebView) this.ka).setUGenContext(this.ny);
        ((InteractWebView) this.ka).c();
        ((InteractWebView) this.ka).ab();
        JSONObject jSONObjectCh = ch();
        if (jSONObjectCh != null) {
            com.bytedance.sdk.component.widget.xr.ms msVar = new com.bytedance.sdk.component.widget.xr.ms();
            msVar.ms(jSONObjectCh.optInt("meta_hashcode", 0));
            ((InteractWebView) this.ka).setMaterialMeta(msVar);
        }
        x();
    }

    public void x() {
        if (TextUtils.isEmpty(this.f3459ms)) {
            this.f3459ms = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
        }
        ((InteractWebView) this.ka).loadUrl(this.f3459ms);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            if (TextUtils.isEmpty(this.f3459ms) || !this.f3459ms.startsWith("http")) {
                this.f3459ms = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
            } else {
                this.f3459ms = str2;
            }
        }
    }
}
