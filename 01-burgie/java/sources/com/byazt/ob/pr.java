package com.byazt.ob;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ca.ho;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.ga.hw;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.vk;
import com.byazt.js.zo;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 527, 37})
public class pr {
    public ObjectAnimator aj;
    public View c;
    public TextView fw;
    public ImageView hn;
    public final of hw;
    public final TTBaseVideoActivity pr;
    public LinearLayout uc;
    public final hw vk;
    public ViewGroup x;
    public ObjectAnimator zo;

    public pr(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, hw hwVar) {
        this.pr = tTBaseVideoActivity;
        this.hw = ofVar;
        this.vk = hwVar;
    }

    public void pr(ViewGroup viewGroup, View view) {
        this.x = viewGroup;
        this.c = view;
        this.hn = new ImageView(this.pr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, er.hn(this.pr, 76.0f));
        layoutParams.gravity = 80;
        this.hn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.x.addView(this.hn, layoutParams);
    }

    public void pr() {
        int iNt;
        LinearLayout linearLayout = new LinearLayout(this.pr);
        this.uc = linearLayout;
        linearLayout.setGravity(1);
        this.uc.setPadding(0, er.hn(this.pr, 16.0f), 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, er.hn(this.pr, 76.0f));
        TextView textView = new TextView(this.pr);
        this.fw = textView;
        textView.setTextSize(12.0f);
        this.fw.setTextColor(-1);
        this.fw.setSingleLine();
        this.fw.setEllipsize(TextUtils.TruncateAt.START);
        this.fw.setGravity(5);
        this.fw.setMaxWidth(er.hn(this.pr, 260.0f));
        this.uc.addView(this.fw);
        TextView textView2 = new TextView(this.pr);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        textView2.setSingleLine();
        textView2.setText("取消");
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ob.pr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pr.this.x();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = er.hn(this.pr, 10.0f);
        this.uc.addView(textView2, layoutParams2);
        pr(25, qv.hw(this.hw));
        int iHn = er.hn(this.pr, 76.0f);
        this.x.addView(this.uc, layoutParams);
        try {
            int iHw = zo.hw(this.pr);
            if (er.x((Activity) this.pr)) {
                iNt = (zo.hn(this.pr) - iHw) - hw();
            } else {
                iNt = er.nt(this.pr);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.uc, "translationY", iHw, (iHw - iHn) + iNt);
            this.zo = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(300L);
            this.zo.start();
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, -iHn);
            this.aj = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(300L);
            this.aj.start();
        } catch (Throwable th) {
            ho.hw("layout", th.getMessage());
        }
    }

    public int hw() {
        int identifier = this.pr.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return this.pr.getResources().getDimensionPixelSize(identifier);
    }

    public void pr(final int i, String str) {
        com.byazt.ub.hw.pr(str).hn(2).pr(Bitmap.Config.ARGB_8888).pr(new rc<Bitmap>() { // from class: com.byazt.ob.pr.2
            @Override // com.byazt.ld.rc
            public void pr(nt<Bitmap> ntVar) {
                try {
                    Bitmap bitmapHn = ntVar.hn();
                    if (bitmapHn == null) {
                        return;
                    }
                    if (bitmapHn.getConfig() == Bitmap.Config.RGB_565) {
                        bitmapHn = bitmapHn.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    Bitmap bitmapPr = com.byazt.js.hw.pr(pr.this.pr, bitmapHn, i);
                    if (bitmapPr == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(pr.this.pr.getResources(), bitmapPr);
                    com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.ob.pr.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (pr.this.uc != null) {
                                pr.this.uc.setBackgroundColor(Color.parseColor("#66000000"));
                            }
                            if (pr.this.hn != null) {
                                pr.this.hn.setImageDrawable(bitmapDrawable);
                            }
                        }
                    });
                } catch (Throwable th) {
                    ho.hw("layout", th.getMessage());
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i2, String str2, Throwable th) {
            }
        }, 4);
    }

    public void hn() {
        x();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "alpha", 1.0f, 0.3f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.ob.pr.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                pr.this.c.setAlpha(1.0f);
                pr.this.vk.aj();
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void pr(com.byazt.az.hw hwVar) {
        vk vkVar = new vk();
        vkVar.hn(true);
        if (hwVar != null) {
            hwVar.pr(vkVar);
            hwVar.pr(null, vkVar);
        }
    }

    public void x() {
        ObjectAnimator objectAnimator = this.zo;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.zo.cancel();
            this.zo = null;
        }
        ObjectAnimator objectAnimator2 = this.aj;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.aj.cancel();
            this.aj = null;
        }
        LinearLayout linearLayout = this.uc;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.c;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ImageView imageView = this.hn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.vk.zo();
    }

    public void pr(long j) {
        TextView textView = this.fw;
        if (textView != null) {
            textView.setText("已为您加载更多详情，" + j + "秒后拉起展示");
        }
    }
}
