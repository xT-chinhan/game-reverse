package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class UGTimerContainer extends FrameLayout {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.ch.ms f3499ms;

    public UGTimerContainer(Context context) {
        super(context);
    }

    void setTimerHolder(com.bytedance.sdk.openadsdk.core.ugeno.ch.ms msVar) {
        this.f3499ms = msVar;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.bytedance.sdk.openadsdk.core.ugeno.ch.ms msVar = this.f3499ms;
        if (msVar != null) {
            if (i == 0) {
                msVar.ms();
            } else {
                msVar.xr();
            }
        }
    }
}
