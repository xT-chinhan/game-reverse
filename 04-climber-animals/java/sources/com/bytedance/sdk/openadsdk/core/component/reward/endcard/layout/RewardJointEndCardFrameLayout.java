package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.ms.ah.c;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.xr.xr;
import com.bytedance.sdk.openadsdk.op.ab;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public class RewardJointEndCardFrameLayout extends AbstractEndCardFrameLayout implements c {
    private FrameLayout ah;
    private FrameLayout c;
    private View d;
    private RewardJointBottomView ka;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return null;
    }

    public RewardJointEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    void ms() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        ms(linearLayout);
        xr(linearLayout);
        ah(linearLayout);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.ka.getWebView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(xr xrVar) {
        ul.ms(this.d, (View.OnClickListener) xrVar, "bar_view");
        this.ka.setClickListener(xrVar);
    }

    private void ms(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.ah = frameLayout;
        if (d()) {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        } else {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, ul.ah(getContext(), 200.0f)));
        }
        ah();
        if (!lm.xr(this.xr)) {
            final ImageView imageView = new ImageView(getContext());
            frameLayout.addView(imageView, -1, -1);
            com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.fk().get(0)).ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.1
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi<Bitmap> hiVar) {
                    imageView.setImageBitmap(hiVar.ah());
                }
            });
        } else {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            this.c = frameLayout2;
        }
    }

    private void ah() {
        if (!lm.xr(this.xr)) {
            com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.fk().get(0)).ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi<Bitmap> hiVar) {
                    Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(RewardJointEndCardFrameLayout.this.getContext(), hiVar.ah(), 25);
                    if (bitmapMs == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapMs);
                    ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.ah != null) {
                                RewardJointEndCardFrameLayout.this.ah.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        } else {
            com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.xr)).ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi<Bitmap> hiVar) {
                    Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(RewardJointEndCardFrameLayout.this.getContext(), hiVar.ah(), 25);
                    if (bitmapMs == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapMs);
                    ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.c != null) {
                                RewardJointEndCardFrameLayout.this.c.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void xr(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(ul.ah(getContext(), 15.0f), 0, 0, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(getContext());
        tTRoundRectImageView.setBackgroundColor(0);
        linearLayout.addView(tTRoundRectImageView, new RelativeLayout.LayoutParams(ul.ah(getContext(), 40.0f), ul.ah(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setMaxWidth(ul.ah(getContext(), 153.0f));
        textView.setSingleLine(true);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, ul.ah(getContext(), 27.0f)));
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(true);
        textView2.setTextColor(Color.parseColor("#4A4A4A"));
        textView2.setTextSize(2, 11.0f);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(ul.ah(getContext(), 14.0f));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#1A73E8"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 13.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ul.ah(getContext(), 70.0f), ul.ah(getContext(), 24.0f));
        layoutParams2.setMarginEnd(ul.ah(getContext(), 15.0f));
        linearLayout.addView(textView3, layoutParams2);
        viewGroup.addView(linearLayout, new LinearLayout.LayoutParams(-1, ul.ah(getContext(), 60.0f)));
        this.d = linearLayout;
        g gVarQd = this.xr.qd();
        if (gVarQd != null && !TextUtils.isEmpty(gVarQd.ms())) {
            com.bytedance.sdk.openadsdk.x.xr.ms(gVarQd).ms(tTRoundRectImageView);
        } else {
            t.ms(getContext(), "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
        }
        if (this.xr.zh() != null && !TextUtils.isEmpty(this.xr.zh().ah())) {
            textView.setText(this.xr.zh().ah());
        } else {
            textView.setText(this.xr.nq());
        }
        textView2.setText(this.xr.eh());
        textView3.setText(this.xr.bn());
    }

    private void ah(ViewGroup viewGroup) {
        RewardJointBottomView rewardJointBottomView = new RewardJointBottomView(getContext(), this.xr);
        this.ka = rewardJointBottomView;
        if (d()) {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, ul.ah(getContext(), 160.0f)));
        } else {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        rewardJointBottomView.ms(nw.ms(this.xr));
    }

    private boolean d() {
        if (this.xr.kz() == 15) {
            return true;
        }
        if (this.xr.kz() == 5) {
            return false;
        }
        if (this.xr.fk() == null || this.xr.fk().isEmpty()) {
            return true;
        }
        g gVar = this.xr.fk().get(0);
        return gVar.ah() > gVar.xr();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ms.ah.c
    public boolean ms(View view, View view2, int i, int i2) {
        return d();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ms.ah.c
    public void ms(View view, int i, int i2, int[] iArr, int i3) {
        int iMs = ms(i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ka.getLayoutParams();
        layoutParams.height -= iMs;
        this.ka.setLayoutParams(layoutParams);
        if (iMs != 0) {
            this.f2171ms.l().k();
        }
        iArr[1] = iArr[1] + iMs;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.bytedance.sdk.component.widget.recycler.ms.ah.ka
    public boolean onNestedPreFling(View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    private int ms(int i) {
        if (i > 0) {
            int height = this.ka.getHeight() - ul.ah(getContext(), 200.0f);
            if (height <= 0) {
                i = 0;
            } else if (height < Math.abs(i)) {
                i = height;
            }
        } else {
            int height2 = this.ah.getHeight() - ul.ah(getContext(), 160.0f);
            if (height2 <= 0) {
                i = 0;
            } else if (height2 < Math.abs(i)) {
                i = -height2;
            }
        }
        if (Math.abs(i) > 400) {
            return 0;
        }
        return i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void xr() {
        super.xr();
        RewardJointBottomView rewardJointBottomView = this.ka;
        if (rewardJointBottomView != null) {
            rewardJointBottomView.xr();
        }
    }
}
