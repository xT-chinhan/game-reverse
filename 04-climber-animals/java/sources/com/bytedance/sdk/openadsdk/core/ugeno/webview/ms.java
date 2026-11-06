package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import com.bytedance.adsdk.ugeno.xr.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<PageWebView> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3571ms;

    public ms(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public PageWebView ms() {
        return new PageWebView(this.xr);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        ((PageWebView) this.ka).setMeta(com.bytedance.sdk.openadsdk.core.ms.ms(ch()));
        ((PageWebView) this.ka).xr(ch());
        ((PageWebView) this.ka).setUGenContext(this.ny);
        ((PageWebView) this.ka).ms();
        ((PageWebView) this.ka).ms(this.f3571ms);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            this.f3571ms = str2;
        }
    }
}
