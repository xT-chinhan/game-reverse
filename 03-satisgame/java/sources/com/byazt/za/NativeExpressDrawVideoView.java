package com.byazt.za;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 1117})
public class NativeExpressDrawVideoView extends NativeExpressVideoView {
    public int wm;

    public NativeExpressDrawVideoView(Context context, pk pkVar, com.byazt.zq.qg qgVar, String str) {
        super(context, pkVar, qgVar, str);
        this.wm = getResources().getConfiguration().orientation;
    }

    @Override // com.byazt.za.NativeExpressVideoView
    public ExpressVideoView n(Context context, pk pkVar, String str) {
        return new ExpressVideoView(context, pkVar, str, true);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        wm();
    }

    private void wm() {
        int i = getResources().getConfiguration().orientation;
        if (this.wm != i) {
            this.wm = i;
            com.byazt.okk.s.n(this, new com.byazt.okk.s.n() { // from class: com.byazt.za.NativeExpressDrawVideoView.1
                @Override // com.byazt.okk.s.n
                public void n(View view) {
                    int width = NativeExpressDrawVideoView.this.getWidth();
                    int height = NativeExpressDrawVideoView.this.getHeight();
                    NativeExpressDrawVideoView nativeExpressDrawVideoView = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView.n(nativeExpressDrawVideoView.sz, width, height);
                    View viewFindViewById = NativeExpressDrawVideoView.this.sz.findViewById(2114387714);
                    NativeExpressDrawVideoView.this.n(viewFindViewById, width, height);
                    if (viewFindViewById != null) {
                        viewFindViewById.requestLayout();
                    }
                    NativeExpressDrawVideoView nativeExpressDrawVideoView2 = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView2.n(nativeExpressDrawVideoView2.getWebView(), width, height);
                    if (NativeExpressDrawVideoView.this.cp != null) {
                        NativeExpressDrawVideoView.this.cp.n(width, height);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.byazt.za.NativeExpressVideoView, com.byazt.za.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        wm();
    }

    @Override // com.byazt.za.NativeExpressView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        wm();
    }
}
