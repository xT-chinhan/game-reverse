package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class FullRewardExpressBackupView extends BackupView {
    private NativeExpressView u;
    private FrameLayout ub;
    private View zb;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.f2933ms = context;
    }

    public void ms(lm lmVar, NativeExpressView nativeExpressView) {
        setBackgroundColor(-1);
        this.xr = lmVar;
        this.u = nativeExpressView;
        if (f.x(this.xr) == 7) {
            this.ka = "rewarded_video";
        } else {
            this.ka = "fullscreen_interstitial_ad";
        }
        ms();
        this.u.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void ms() {
        this.c = ul.ah(this.f2933ms, this.u.getExpectExpressWidth());
        this.ab = ul.ah(this.f2933ms, this.u.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.c, this.ab);
        }
        layoutParams.width = this.c;
        layoutParams.height = this.ab;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        xr();
    }

    private void xr() {
        FrameLayout frameLayout = new FrameLayout(this.f2933ms);
        this.zb = frameLayout;
        frameLayout.setId(2114387740);
        addView(this.zb);
        FrameLayout frameLayout2 = (FrameLayout) this.zb.findViewById(2114387740);
        this.ub = frameLayout2;
        frameLayout2.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.ub;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void ms(View view, int i, com.bytedance.sdk.openadsdk.core.nw.i iVar) {
        NativeExpressView nativeExpressView = this.u;
        if (nativeExpressView != null) {
            nativeExpressView.ms(view, i, iVar);
        }
    }
}
