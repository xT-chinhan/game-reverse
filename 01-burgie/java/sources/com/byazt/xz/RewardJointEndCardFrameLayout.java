package com.byazt.xz;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ar.RewardJointBottomView;
import com.byazt.az.hw;
import com.byazt.ca.g;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.y;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.vu.uc;
import com.byazt.vzx.pr;
import com.byazt.wt.er;
import com.byazt.wt.ny;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 1173, 1757})
public class RewardJointEndCardFrameLayout extends AbstractEndCardFrameLayout implements uc {
    public RewardJointBottomView c;
    public FrameLayout hn;
    public FrameLayout uc;
    public View x;

    public RewardJointEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public void pr() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        pr(linearLayout);
        hw(linearLayout);
        hn(linearLayout);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return null;
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.c.getWebView();
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.uc;
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public void setClickListener(hw hwVar) {
        er.pr(this.x, (View.OnClickListener) hwVar, "bar_view");
        this.c.setClickListener(hwVar);
    }

    private void pr(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.hn = frameLayout;
        if (x()) {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        } else {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, er.hn(getContext(), 200.0f)));
        }
        hn();
        if (!of.hn(this.hw)) {
            final ImageView imageView = new ImageView(getContext());
            frameLayout.addView(imageView, -1, -1);
            com.byazt.ub.hw.pr(this.hw.de().get(0)).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.xz.RewardJointEndCardFrameLayout.1
                @Override // com.byazt.ld.rc
                public void pr(nt<Bitmap> ntVar) {
                    imageView.setImageBitmap(ntVar.hn());
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str, Throwable th) {
                }
            });
        } else {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            this.uc = frameLayout2;
        }
    }

    private void hn() {
        if (!of.hn(this.hw)) {
            com.byazt.ub.hw.pr(this.hw.de().get(0)).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.xz.RewardJointEndCardFrameLayout.2
                @Override // com.byazt.ld.rc
                public void pr(nt<Bitmap> ntVar) {
                    Bitmap bitmapPr = com.byazt.js.hw.pr(RewardJointEndCardFrameLayout.this.getContext(), ntVar.hn(), 25);
                    if (bitmapPr == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapPr);
                    zo.pr(new Runnable() { // from class: com.byazt.xz.RewardJointEndCardFrameLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.hn != null) {
                                RewardJointEndCardFrameLayout.this.hn.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str, Throwable th) {
                }
            }, 4);
        } else {
            com.byazt.ub.hw.pr(qv.hw(this.hw)).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.xz.RewardJointEndCardFrameLayout.3
                @Override // com.byazt.ld.rc
                public void pr(nt<Bitmap> ntVar) {
                    Bitmap bitmapPr = com.byazt.js.hw.pr(RewardJointEndCardFrameLayout.this.getContext(), ntVar.hn(), 25);
                    if (bitmapPr == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapPr);
                    zo.pr(new Runnable() { // from class: com.byazt.xz.RewardJointEndCardFrameLayout.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.uc != null) {
                                RewardJointEndCardFrameLayout.this.uc.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str, Throwable th) {
                }
            }, 4);
        }
    }

    private void hw(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(er.hn(getContext(), 15.0f), 0, 0, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(getContext());
        tTRoundRectImageView.setBackgroundColor(0);
        linearLayout.addView(tTRoundRectImageView, new RelativeLayout.LayoutParams(er.hn(getContext(), 40.0f), er.hn(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setMaxWidth(er.hn(getContext(), 153.0f));
        textView.setSingleLine(true);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, er.hn(getContext(), 27.0f)));
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(true);
        textView2.setTextColor(Color.parseColor("#4A4A4A"));
        textView2.setTextSize(2, 11.0f);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(er.hn(getContext(), 14.0f));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#1A73E8"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 13.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(er.hn(getContext(), 70.0f), er.hn(getContext(), 24.0f));
        layoutParams2.setMarginEnd(er.hn(getContext(), 15.0f));
        linearLayout.addView(textView3, layoutParams2);
        viewGroup.addView(linearLayout, new LinearLayout.LayoutParams(-1, er.hn(getContext(), 60.0f)));
        this.x = linearLayout;
        y yVarMo = this.hw.mo();
        if (yVarMo != null && !TextUtils.isEmpty(yVarMo.pr())) {
            com.byazt.ub.hw.pr(yVarMo).pr(tTRoundRectImageView);
        } else {
            g.pr(getContext(), "tt_ad_logo_small", (ImageView) tTRoundRectImageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        if (this.hw.ho() != null && !TextUtils.isEmpty(this.hw.ho().hn())) {
            textView.setText(this.hw.ho().hn());
        } else {
            textView.setText(this.hw.zj());
        }
        textView2.setText(this.hw.A_());
        textView3.setText(this.hw.se());
    }

    private void hn(ViewGroup viewGroup) {
        RewardJointBottomView rewardJointBottomView = new RewardJointBottomView(getContext(), this.hw);
        this.c = rewardJointBottomView;
        if (x()) {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, er.hn(getContext(), 160.0f)));
        } else {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        rewardJointBottomView.pr(ny.pr(this.hw));
    }

    private boolean x() {
        if (this.hw.jg() == 15) {
            return true;
        }
        if (this.hw.jg() == 5) {
            return false;
        }
        if (this.hw.de() == null || this.hw.de().isEmpty()) {
            return true;
        }
        y yVar = this.hw.de().get(0);
        return yVar.hn() > yVar.hw();
    }

    @Override // com.byazt.vu.uc
    public boolean pr(View view, View view2, int i, int i2) {
        return x();
    }

    @Override // com.byazt.vu.uc
    public void pr(View view, int i, int i2, int[] iArr, int i3) {
        int iPr = pr(i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.height -= iPr;
        this.c.setLayoutParams(layoutParams);
        if (iPr != 0) {
            this.pr.o().v();
        }
        iArr[1] = iArr[1] + iPr;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.byazt.vu.c
    public boolean onNestedPreFling(View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    private int pr(int i) {
        if (i > 0) {
            int height = this.c.getHeight() - er.hn(getContext(), 200.0f);
            if (height <= 0) {
                i = 0;
            } else if (height < Math.abs(i)) {
                i = height;
            }
        } else {
            int height2 = this.hn.getHeight() - er.hn(getContext(), 160.0f);
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

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public void hw() {
        super.hw();
        RewardJointBottomView rewardJointBottomView = this.c;
        if (rewardJointBottomView != null) {
            rewardJointBottomView.hw();
        }
    }
}
