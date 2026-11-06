package com.byazt.xt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.v;
import com.byazt.hg.y;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.oc.UpieImageView;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 62})
public class fw extends hw {
    public ImageView g;
    public TTRoundRectImageView ho;
    public TextView lb;
    public TextView nt;
    public UpieImageView qa;
    public TextView yb;

    public fw(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, z);
    }

    @Override // com.byazt.xt.hw
    public void pr() {
        super.pr();
        this.aj = (FrameLayout) this.hw.findViewById(2114387915);
        pr((View) this.fw);
        if (com.byazt.lpk.pr.pr(this.hn)) {
            x();
        } else {
            hn();
            hw();
        }
    }

    private void hw() {
        int i = (int) (this.c * 1000.0f);
        if (i != 666 && i != 1500 && i != 1777 && i != 562 && i != 1000) {
            pr(this.x == 1 ? 0.562f : 1.777f);
        }
    }

    private void pr(View view) {
        if (this.hn == null || view == null) {
            return;
        }
        final float fBo = this.hn.bo();
        if (fBo <= 0.0f) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.xt.fw.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), er.hn(a.getContext(), fBo));
                }
            });
            view.setClipToOutline(true);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(er.hn(a.getContext(), fBo));
        view.setBackground(gradientDrawable);
    }

    private void hn() {
        TextView textView;
        this.g = (ImageView) this.hw.findViewById(2114387712);
        this.ho = (TTRoundRectImageView) this.hw.findViewById(2114387722);
        this.nt = (TextView) this.hw.findViewById(2114387702);
        this.yb = (TextView) this.hw.findViewById(2114387962);
        this.lb = (TextView) this.hw.findViewById(2114387719);
        if (this.g != null && com.byazt.ja.pr.x(this.hn)) {
            UpieImageView upieImageView = new UpieImageView(this.g.getContext(), com.byazt.ja.pr.vk(this.hn), com.byazt.vr.pr.pr(this.hn), com.byazt.ja.pr.w(this.hn));
            this.qa = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (!TextUtils.isEmpty(this.hn.se()) && (textView = this.yb) != null) {
            textView.setText(this.hn.se());
        }
        if (qv.ho(this.hn) != null && of.hn(this.hn)) {
            er.pr((View) this.g, 8);
            er.pr((View) this.aj, 0);
        } else {
            pr(this.g, this.qa);
            er.pr((View) this.g, 0);
            er.pr((View) this.aj, 8);
        }
        y yVarMo = this.hn.mo();
        if (yVarMo != null) {
            com.byazt.ub.hw.pr(yVarMo).pr(this.ho);
        }
        TextView textView2 = this.nt;
        if (textView2 != null) {
            textView2.setText(g());
        }
        TextView textView3 = this.lb;
        if (textView3 != null) {
            textView3.setText(ho());
        }
        er.pr((TextView) this.hw.findViewById(2114387658), this.hn);
    }

    @Override // com.byazt.xt.hw
    public void x(int i) {
        er.pr((View) this.w, i);
    }

    private void x() {
        this.w = (RelativeLayout) this.hw.findViewById(2114387844);
        this.k = (TextView) this.hw.findViewById(2114387716);
        if (!v.pr(this.hn)) {
            return;
        }
        String strZo = v.zo(this.hn);
        if (!TextUtils.isEmpty(strZo)) {
            com.byazt.ub.hw.pr(strZo).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.xt.fw.2
                @Override // com.byazt.ld.rc
                public void pr(nt<Bitmap> ntVar) {
                    Bitmap bitmapPr = com.byazt.js.hw.pr(fw.this.hw, ntVar.hn(), 25);
                    if (bitmapPr == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(fw.this.hw.getResources(), bitmapPr);
                    com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.xt.fw.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (fw.this.fw != null) {
                                fw.this.fw.setBackground(bitmapDrawable);
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

    private void pr(float f) {
        float fMin;
        float fMax;
        int iMax;
        float fC = c();
        float fUc = uc();
        if (this.x == 2) {
            fMin = Math.max(fC, fUc);
            fMax = Math.min(fC, fUc);
        } else {
            fMin = Math.min(fC, fUc);
            fMax = Math.max(fC, fUc);
        }
        int iMin = (int) (Math.min(fMin, fMax) * this.hn.ul());
        if (this.x != 2) {
            fMax -= er.x(this.hw, er.w((Context) this.hw));
        }
        if (this.x != 2) {
            float f2 = iMin;
            iMin = (int) Math.max((fMax - (((fMin - f2) - f2) / f)) / 2.0f, 0.0f);
            iMax = iMin;
        } else {
            float f3 = iMin;
            iMax = (int) Math.max((fMin - (((fMax - f3) - f3) * f)) / 2.0f, 0.0f);
        }
        float f4 = iMin;
        float f5 = iMax;
        try {
            this.hw.getWindow().getDecorView().setPadding(er.hn(this.hw, f5), er.hn(this.hw, f4), er.hn(this.hw, f5), er.hn(this.hw, f4));
        } catch (Throwable th) {
        }
    }

    private float c() {
        return er.x(this.hw, er.aj((Context) this.hw));
    }

    private float uc() {
        return er.x(this.hw, er.vk((Context) this.hw));
    }

    @Override // com.byazt.xt.hw
    public void pr(com.byazt.az.hw hwVar, com.byazt.az.hw hwVar2) {
        pr(this.yb, hwVar, hwVar);
        pr(this.k, hwVar, hwVar);
        pr(this.aj, hwVar2, hwVar2);
        pr(this.g, hwVar2, hwVar2);
        pr(this.ho, hwVar2, hwVar2);
        pr(this.nt, hwVar2, hwVar2);
        pr(this.lb, hwVar2, hwVar2);
        pr(this.fw, hwVar2, hwVar2);
        pr(this.qa, hwVar2, hwVar2);
    }

    private void pr(View view, com.byazt.az.hw hwVar, View.OnTouchListener onTouchListener) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(hwVar);
    }
}
