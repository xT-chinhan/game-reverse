package com.byazt.yyw;

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
import com.byazt.cp.n;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.v;
import com.byazt.kfh.SSWebView;
import com.byazt.mgr.w;
import com.byazt.ndr.TTRoundRectImageView;
import com.byazt.okk.s;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.tk.sz;
import com.byazt.uz.RewardJointBottomView;
import com.byazt.ys.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, 1298, 1915})
public class RewardJointEndCardFrameLayout extends AbstractEndCardFrameLayout implements w {
    public RewardJointBottomView l;
    public View q;
    public FrameLayout s;
    public FrameLayout w;

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return null;
    }

    public RewardJointEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
    }

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public void n() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        n(linearLayout);
        qg(linearLayout);
        s(linearLayout);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.l.getWebView();
    }

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.w;
    }

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public void setClickListener(qg qgVar) {
        s.n(this.q, (View.OnClickListener) qgVar, "bar_view");
        this.l.setClickListener(qgVar);
    }

    private void n(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.s = frameLayout;
        if (q()) {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        } else {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, s.s(getContext(), 200.0f)));
        }
        s();
        if (!pk.s(this.qg)) {
            final ImageView imageView = new ImageView(getContext());
            frameLayout.addView(imageView, -1, -1);
            com.byazt.imu.s.n(this.qg.jo().get(0)).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.yyw.RewardJointEndCardFrameLayout.1
                @Override // com.byazt.si.m
                public void n(int i, String str, Throwable th) {
                }

                @Override // com.byazt.si.m
                public void n(cy<Bitmap> cyVar) {
                    imageView.setImageBitmap(cyVar.s());
                }
            });
        } else {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            this.w = frameLayout2;
        }
    }

    private void s() {
        if (!pk.s(this.qg)) {
            com.byazt.imu.s.n(this.qg.jo().get(0)).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.yyw.RewardJointEndCardFrameLayout.2
                @Override // com.byazt.si.m
                public void n(int i, String str, Throwable th) {
                }

                @Override // com.byazt.si.m
                public void n(cy<Bitmap> cyVar) {
                    Bitmap bitmapN = com.byazt.cq.qg.n(RewardJointEndCardFrameLayout.this.getContext(), cyVar.s(), 25);
                    if (bitmapN == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapN);
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.yyw.RewardJointEndCardFrameLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.s != null) {
                                RewardJointEndCardFrameLayout.this.s.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        } else {
            com.byazt.imu.s.n(ta.qg(this.qg)).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.yyw.RewardJointEndCardFrameLayout.3
                @Override // com.byazt.si.m
                public void n(int i, String str, Throwable th) {
                }

                @Override // com.byazt.si.m
                public void n(cy<Bitmap> cyVar) {
                    Bitmap bitmapN = com.byazt.cq.qg.n(RewardJointEndCardFrameLayout.this.getContext(), cyVar.s(), 25);
                    if (bitmapN == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapN);
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.yyw.RewardJointEndCardFrameLayout.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.w != null) {
                                RewardJointEndCardFrameLayout.this.w.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void qg(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(s.s(getContext(), 15.0f), 0, 0, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(getContext());
        tTRoundRectImageView.setBackgroundColor(0);
        linearLayout.addView(tTRoundRectImageView, new RelativeLayout.LayoutParams(s.s(getContext(), 40.0f), s.s(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setMaxWidth(s.s(getContext(), 153.0f));
        textView.setSingleLine(true);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, s.s(getContext(), 27.0f)));
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(true);
        textView2.setTextColor(Color.parseColor("#4A4A4A"));
        textView2.setTextSize(2, 11.0f);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(s.s(getContext(), 14.0f));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#1A73E8"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 13.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(s.s(getContext(), 70.0f), s.s(getContext(), 24.0f));
        layoutParams2.setMarginEnd(s.s(getContext(), 15.0f));
        linearLayout.addView(textView3, layoutParams2);
        viewGroup.addView(linearLayout, new LinearLayout.LayoutParams(-1, s.s(getContext(), 60.0f)));
        this.q = linearLayout;
        v vVarXu = this.qg.xu();
        if (vVarXu != null && !TextUtils.isEmpty(vVarXu.n())) {
            com.byazt.imu.s.n(vVarXu).n(tTRoundRectImageView);
        } else {
            sz.n(getContext(), "tt_ad_logo_small", (ImageView) tTRoundRectImageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        if (this.qg.k() != null && !TextUtils.isEmpty(this.qg.k().s())) {
            textView.setText(this.qg.k().s());
        } else {
            textView.setText(this.qg.yr());
        }
        textView2.setText(this.qg.E_());
        textView3.setText(this.qg.jb());
    }

    private void s(ViewGroup viewGroup) {
        RewardJointBottomView rewardJointBottomView = new RewardJointBottomView(getContext(), this.qg);
        this.l = rewardJointBottomView;
        if (q()) {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, s.s(getContext(), 160.0f)));
        } else {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        rewardJointBottomView.n(com.byazt.qq.qg.n(this.qg));
    }

    private boolean q() {
        if (this.qg.ge() == 15) {
            return true;
        }
        if (this.qg.ge() == 5) {
            return false;
        }
        if (this.qg.jo() == null || this.qg.jo().isEmpty()) {
            return true;
        }
        v vVar = this.qg.jo().get(0);
        return vVar.s() > vVar.qg();
    }

    @Override // com.byazt.mgr.w
    public boolean n(View view, View view2, int i, int i2) {
        return q();
    }

    @Override // com.byazt.mgr.w
    public void n(View view, int i, int i2, int[] iArr, int i3) {
        int iN = n(i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams.height -= iN;
        this.l.setLayoutParams(layoutParams);
        if (iN != 0) {
            this.n.b().df();
        }
        iArr[1] = iArr[1] + iN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.byazt.mgr.l
    public boolean onNestedPreFling(View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    private int n(int i) {
        if (i > 0) {
            int height = this.l.getHeight() - s.s(getContext(), 200.0f);
            if (height <= 0) {
                i = 0;
            } else if (height < Math.abs(i)) {
                i = height;
            }
        } else {
            int height2 = this.s.getHeight() - s.s(getContext(), 160.0f);
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

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public void qg() {
        super.qg();
        RewardJointBottomView rewardJointBottomView = this.l;
        if (rewardJointBottomView != null) {
            rewardJointBottomView.qg();
        }
    }
}
