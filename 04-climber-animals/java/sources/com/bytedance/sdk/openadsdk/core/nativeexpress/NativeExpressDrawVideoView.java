package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressDrawVideoView extends NativeExpressVideoView {
    private int nw;

    public NativeExpressDrawVideoView(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str) {
        super(context, lmVar, xrVar, str);
        this.nw = getResources().getConfiguration().orientation;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView
    protected ExpressVideoView ms(Context context, lm lmVar, String str) {
        return new ExpressVideoView(context, lmVar, str, true);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        re();
    }

    private void re() {
        int i = getResources().getConfiguration().orientation;
        if (this.nw != i) {
            this.nw = i;
            ul.ms(this, new ul.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressDrawVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.jw.ul.ms
                public void ms(View view) {
                    int width = NativeExpressDrawVideoView.this.getWidth();
                    int height = NativeExpressDrawVideoView.this.getHeight();
                    NativeExpressDrawVideoView nativeExpressDrawVideoView = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView.ms(nativeExpressDrawVideoView.zb, width, height);
                    View viewFindViewById = NativeExpressDrawVideoView.this.zb.findViewById(2114387720);
                    NativeExpressDrawVideoView.this.ms(viewFindViewById, width, height);
                    if (viewFindViewById != null) {
                        viewFindViewById.requestLayout();
                    }
                    NativeExpressDrawVideoView nativeExpressDrawVideoView2 = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView2.ms(nativeExpressDrawVideoView2.getWebView(), width, height);
                    if (NativeExpressDrawVideoView.this.ch != null) {
                        NativeExpressDrawVideoView.this.ch.ms(width, height);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView, com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        re();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        re();
    }
}
