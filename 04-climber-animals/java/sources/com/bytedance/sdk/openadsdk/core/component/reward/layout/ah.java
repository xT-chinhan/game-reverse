package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.widget.sl;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends xr {
    private TextView ao;
    private TextView h;
    private FrameLayout nw;
    private TextView qv;
    private FrameLayout t;
    protected final AtomicBoolean u;
    private TTRoundRectImageView ub;
    private TTRatingBar y;
    protected int zb;

    public ah(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, z);
        this.zb = 0;
        this.u = new AtomicBoolean(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms() {
        super.ms();
        this.x = (RelativeLayout) this.xr.findViewById(2114387655);
        this.ub = (TTRoundRectImageView) this.xr.findViewById(2114387799);
        this.ao = (TextView) this.xr.findViewById(2114387881);
        this.h = (TextView) this.xr.findViewById(2114387636);
        this.qv = (TextView) this.xr.findViewById(2114387836);
        TTRatingBar tTRatingBar = (TTRatingBar) this.xr.findViewById(2114387615);
        this.y = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.y.setStarFillNum(4);
            this.y.setStarImageWidth(ul.ah(this.xr, 15.0f));
            this.y.setStarImageHeight(ul.ah(this.xr, 14.0f));
            this.y.setStarImagePadding(ul.ah(this.xr, 4.0f));
            this.y.ms();
        }
        this.ch = (TextView) this.xr.findViewById(2114387664);
        this.ny = (FrameLayout) this.xr.findViewById(2114387648);
        this.t = (FrameLayout) this.xr.findViewById(2114387964);
        this.nw = (FrameLayout) this.xr.findViewById(2114387931);
        ul.ms(this.ch, this.ah);
        try {
            if (this.d == 2 && this.ah.vm() == 1 && (this.qv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.qv.getLayoutParams();
                layoutParams.height = ul.ah(this.xr, 55.0f);
                layoutParams.topMargin = ul.ah(this.xr, 20.0f);
                this.qv.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
                layoutParams2.bottomMargin = ul.ah(this.xr, 12.0f);
                this.x.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.ah.vm() == 1 && this.ny != null && (this.ny.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ny.getLayoutParams();
            int iD = ul.d((Context) this.xr);
            layoutParams3.width = iD;
            int i = (iD * 9) / 16;
            layoutParams3.height = i;
            this.ny.setLayoutParams(layoutParams3);
            this.zb = (ul.ka((Context) this.xr) - i) / 2;
        }
        ah();
        d();
        ka();
        c();
        ab();
        hi();
    }

    private void ah() {
        if (this.ub != null) {
            g gVarQd = this.ah.qd();
            if (gVarQd != null && !TextUtils.isEmpty(gVarQd.ms())) {
                com.bytedance.sdk.openadsdk.x.xr.ms(gVarQd).ms(this.ub);
            } else {
                t.ms((Context) this.xr, "tt_ad_logo_small", (ImageView) this.ub);
            }
        }
        if (this.ao != null) {
            if (this.d == 1 && this.ah.zh() != null && !TextUtils.isEmpty(this.ah.zh().ah())) {
                this.ao.setText(this.ah.zh().ah());
            } else {
                this.ao.setText(this.ah.eh());
            }
        }
    }

    private void d() {
        if (this.h == null) {
            return;
        }
        int iC = this.ah.zh() != null ? this.ah.zh().c() : 6870;
        this.h.setText(String.format("%1$s个评分", iC > 10000 ? (iC / 10000) + "万" : String.valueOf(iC)));
    }

    private void ka() {
        TextView textView = this.qv;
        if (textView != null) {
            textView.setText(this.ah.vm() == 3 ? x() : xr());
        }
    }

    private void c() {
        if (this.d == 1) {
            TextView textView = this.ao;
            if (textView != null) {
                textView.setMaxWidth(ul.ah(this.xr, 153.0f));
            }
        } else {
            TextView textView2 = this.ao;
            if (textView2 != null) {
                textView2.setMaxWidth(ul.ah(this.xr, 404.0f));
            }
        }
        if (this.c) {
            return;
        }
        ul.ms((View) this.x, 0);
    }

    private void ab() {
        if (this.ah.vm() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            sl.ms((LinearLayout) this.xr.findViewById(2114387904), new sl.ms().ms(iArr[0]).xr(Color.parseColor("#80000000")).ms(iArr).ah(ul.ah(this.xr, 17.0f)).d(0).ka(ul.ah(this.xr, 3.0f)));
        }
    }

    protected String xr() {
        if (this.ah == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(this.ah.bn())) {
            return this.ah.jr() != 4 ? "查看详情" : "立即下载";
        }
        return this.ah.bn();
    }

    private String x() {
        boolean z;
        boolean zEquals;
        String strMs = f.ms(this.xr);
        if (strMs == null) {
            strMs = "";
        }
        try {
            z = strMs.equals(Locale.CHINESE.getLanguage()) || strMs.equals(Locale.CHINA.getLanguage()) || strMs.equals(Locale.TRADITIONAL_CHINESE.getLanguage());
            try {
                zEquals = strMs.equals(Locale.ENGLISH.getLanguage());
            } catch (Throwable unused) {
                zEquals = false;
            }
        } catch (Throwable unused2) {
            z = true;
        }
        String strBn = "下载";
        if (!z && zEquals) {
            strBn = "Install";
        }
        if (this.ah == null) {
            return strBn;
        }
        if (TextUtils.isEmpty(this.ah.bn())) {
            if (this.ah.jr() != 4) {
                if (z) {
                    strBn = "查看";
                } else if (zEquals) {
                    strBn = "View";
                }
            }
        } else {
            strBn = this.ah.bn();
            if (strBn != null) {
                if (!f.x(strBn) || strBn.length() <= 2) {
                    if (!f.x(strBn) && strBn.length() > 7) {
                        if (z) {
                            strBn = ms(true);
                        } else if (zEquals) {
                            strBn = ms(false);
                        }
                    }
                } else if (z) {
                    strBn = ms(true);
                } else if (zEquals) {
                    strBn = ms(false);
                }
            }
        }
        if (zEquals && !f.x(strBn)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qv.getLayoutParams();
            layoutParams.bottomMargin = ul.ah(this.xr, 4.0f);
            this.qv.setLayoutParams(layoutParams);
        }
        return strBn;
    }

    private String ms(boolean z) {
        if (this.ah == null) {
            return null;
        }
        if (z) {
            return this.ah.jr() == 4 ? "下载" : "查看";
        }
        return this.ah.jr() == 4 ? "Install" : "View";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.xr.xr xrVar2) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        if (this.ah != null && this.ah.zf() != null) {
            if (this.ah.zf().ka) {
                ul.ms((View) this.qv, (View.OnClickListener) xrVar, (String) null);
                ul.ms((View) this.qv, (View.OnTouchListener) xrVar, (String) null);
            } else {
                ul.ms((View) this.qv, (View.OnClickListener) xrVar2, (String) null);
                ul.ms((View) this.qv, (View.OnTouchListener) xrVar2, (String) null);
            }
            if (this.ah.vm() == 1) {
                if (this.ah.zf().f3071ms) {
                    ms((View.OnTouchListener) xrVar);
                    ms((View.OnClickListener) xrVar);
                } else {
                    ms((View.OnTouchListener) xrVar2);
                    ms((View.OnClickListener) xrVar2);
                }
            } else if (this.ah.zf().ah) {
                ul.ms((View) this.x, (View.OnClickListener) xrVar, "TTBaseVideoActivity#mRlDownloadBar");
                ul.ms((View) this.x, (View.OnTouchListener) xrVar, "TTBaseVideoActivity#mRlDownloadBar");
            } else {
                ul.ms((View) this.x, (View.OnClickListener) xrVar2, "TTBaseVideoActivity#mRlDownloadBar");
                ul.ms((View) this.x, (View.OnTouchListener) xrVar2, (String) null);
            }
        }
        if (this.ah != null && this.ah.zf() != null) {
            if (this.ah.zf().c) {
                ul.ms((View) this.ny, (View.OnClickListener) xrVar, "TTBaseVideoActivity#mVideoNativeFrame");
                ul.ms((View) this.ny, (View.OnTouchListener) xrVar, "TTBaseVideoActivity#mVideoNativeFrame");
            } else {
                ul.ms((View) this.ny, (View.OnClickListener) xrVar2, "TTBaseVideoActivity#mVideoNativeFrame");
                ul.ms((View) this.ny, (View.OnTouchListener) xrVar2, "TTBaseVideoActivity#mVideoNativeFrame");
            }
        }
        if (this.ah == null || this.ah.vm() != 1) {
            return;
        }
        if (this.ah.zf() != null && (frameLayout2 = this.t) != null) {
            ul.ms((View) frameLayout2, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.height = this.zb;
            this.t.setLayoutParams(layoutParams);
            if (this.ah.zf().xr) {
                this.t.setOnClickListener(xrVar);
                this.t.setOnTouchListener(xrVar);
            } else {
                this.t.setOnClickListener(xrVar2);
                this.t.setOnTouchListener(xrVar2);
            }
        }
        if (this.ah.zf() == null || (frameLayout = this.nw) == null) {
            return;
        }
        ul.ms((View) frameLayout, 0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nw.getLayoutParams();
        layoutParams2.height = this.zb;
        this.nw.setLayoutParams(layoutParams2);
        if (this.ah.zf().d) {
            this.nw.setOnClickListener(xrVar);
            this.nw.setOnTouchListener(xrVar);
        } else {
            this.nw.setOnClickListener(xrVar2);
            this.nw.setOnTouchListener(xrVar2);
        }
    }

    private void ms(View.OnTouchListener onTouchListener) {
        ul.ms(this.x, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        ul.ms(this.ao, onTouchListener, (String) null);
        ul.ms(this.ub, onTouchListener, (String) null);
        ul.ms(this.h, onTouchListener, (String) null);
        ul.ms(this.y, onTouchListener, (String) null);
    }

    private void ms(View.OnClickListener onClickListener) {
        ul.ms(this.x, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
        ul.ms(this.ao, onClickListener, (String) null);
        ul.ms(this.ub, onClickListener, (String) null);
        ul.ms(this.h, onClickListener, (String) null);
        ul.ms(this.y, onClickListener, (String) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void xr(int i) {
        if (this.x == null || this.sl == -1 || i != this.sl || this.u.getAndSet(true)) {
            return;
        }
        ul.ms((View) this.x, 0);
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.x, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
        objectAnimatorOfPropertyValuesHolder.start();
    }
}
