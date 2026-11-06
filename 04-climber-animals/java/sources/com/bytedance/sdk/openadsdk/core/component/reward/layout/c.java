package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.RatioImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public class c extends xr {
    private TextView ao;
    private TextView h;
    private TTRatingBar qv;
    private UpieImageView t;
    private TTRoundRectImageView u;
    private TextView ub;
    private TextView y;
    private RatioImageView zb;

    public c(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms() {
        super.ms();
        this.ny = (FrameLayout) this.ab.findViewById(2114387648);
        this.zb = (RatioImageView) this.ab.findViewById(2114387772);
        this.u = (TTRoundRectImageView) this.ab.findViewById(2114387728);
        this.ub = (TextView) this.ab.findViewById(2114387708);
        this.ao = (TextView) this.ab.findViewById(2114387940);
        this.h = (TextView) this.ab.findViewById(2114387795);
        this.y = (TextView) this.ab.findViewById(2114387962);
        this.qv = (TTRatingBar) this.ab.findViewById(2114387793);
        if (com.bytedance.sdk.openadsdk.ka.ms.d(this.ah)) {
            UpieImageView upieImageView = new UpieImageView(this.zb.getContext(), com.bytedance.sdk.openadsdk.ka.ms.ny(this.ah), com.bytedance.sdk.openadsdk.ka.ms.ch(this.ah));
            this.t = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.xr.xr xrVar2) {
        ms(this.zb, xrVar, xrVar);
        ms(this.u, xrVar, xrVar);
        ms(this.ub, xrVar, xrVar);
        ms(this.ao, xrVar, xrVar);
        ms(this.y, xrVar, xrVar);
        ms(this.h, xrVar, xrVar);
        ms(this.qv, xrVar, xrVar);
        ms(this.t, xrVar, xrVar);
    }

    protected void ms(View view, com.bytedance.sdk.openadsdk.core.xr.xr xrVar, View.OnTouchListener onTouchListener) {
        if (view == null || this.xr == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(xrVar);
    }

    private void xr() {
        g gVarQd;
        ul.ms((TextView) this.xr.findViewById(2114387664), this.ah);
        if (this.zb != null) {
            int iKz = this.ah.kz();
            if (iKz == 3) {
                this.zb.setRatio(1.91f);
            } else if (iKz == 33) {
                this.zb.setRatio(1.0f);
            } else {
                this.zb.setRatio(0.56f);
            }
            ms(this.zb, this.t);
        }
        if (this.u != null && (gVarQd = this.ah.qd()) != null) {
            com.bytedance.sdk.openadsdk.x.xr.ms(gVarQd).ms(this.u);
        }
        TextView textView = this.ub;
        if (textView != null) {
            textView.setText(u());
        }
        TextView textView2 = this.ao;
        if (textView2 != null) {
            textView2.setText(ub());
        }
        ah();
        d();
    }

    private void ah() {
        TTRatingBar tTRatingBar = this.qv;
        if (tTRatingBar == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.qv.setStarFillNum(4);
        this.qv.setStarImageWidth(ul.ah(this.xr, 16.0f));
        this.qv.setStarImageHeight(ul.ah(this.xr, 16.0f));
        this.qv.setStarImagePadding(ul.ah(this.xr, 4.0f));
        this.qv.ms();
    }

    private void d() {
        if (this.h == null) {
            return;
        }
        int iC = this.ah.zh() != null ? this.ah.zh().c() : 6870;
        this.h.setText(String.format(t.ms(this.xr, "tt_comment_num_backup"), iC > 10000 ? (iC / 10000) + "万" : String.valueOf(iC)));
    }
}
