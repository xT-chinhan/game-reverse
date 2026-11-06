package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.u.x;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private x f3797ms;
    private com.bytedance.sdk.openadsdk.u.ms xr;

    public x ms(Context context, SSWebView sSWebView, com.bytedance.sdk.openadsdk.u.ah ahVar, com.bytedance.sdk.openadsdk.u.ms msVar, Set<String> set, x.ms msVar2) {
        if (this.f3797ms == null) {
            x xVarMs = x.ms(context, sSWebView, ahVar, msVar, set, msVar2, true);
            this.f3797ms = xVarMs;
            xVarMs.d(false);
        }
        this.xr = msVar;
        return this.f3797ms;
    }
}
