package com.byazt.za;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 2314})
public class FullRewardExpressBackupView extends BackupView {
    public FrameLayout k;
    public View oa;
    public NativeExpressView sz;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.n = context;
    }

    public void n(pk pkVar, NativeExpressView nativeExpressView) {
        setBackgroundColor(-1);
        this.qg = pkVar;
        this.sz = nativeExpressView;
        if (com.byazt.vgx.w.d(this.qg) == 7) {
            this.l = "rewarded_video";
        } else {
            this.l = "fullscreen_interstitial_ad";
        }
        n();
        this.sz.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void n() {
        this.w = com.byazt.okk.s.s(this.n, this.sz.getExpectExpressWidth());
        this.x = com.byazt.okk.s.s(this.n, this.sz.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.w, this.x);
        }
        layoutParams.width = this.w;
        layoutParams.height = this.x;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        qg();
    }

    private void qg() {
        FrameLayout frameLayout = new FrameLayout(this.n);
        this.oa = frameLayout;
        frameLayout.setId(2114387734);
        addView(this.oa);
        FrameLayout frameLayout2 = (FrameLayout) this.oa.findViewById(2114387734);
        this.k = frameLayout2;
        frameLayout2.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.k;
    }

    @Override // com.byazt.za.BackupView
    public void n(View view, int i, com.byazt.gct.wm wmVar) {
        NativeExpressView nativeExpressView = this.sz;
        if (nativeExpressView != null) {
            nativeExpressView.n(view, i, wmVar, -1);
        }
    }
}
