package com.byazt.toz;

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
import com.byazt.cq.fs;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.tj;
import com.byazt.okk.s;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.tk.k;
import com.byazt.zx.qg;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1826, 19})
public class n {
    public ObjectAnimator fs;
    public View l;
    public final TTBaseVideoActivity n;
    public ViewGroup q;
    public final pk qg;
    public ObjectAnimator rv;
    public ImageView s;
    public final qg tj;
    public LinearLayout w;
    public TextView x;

    public n(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, qg qgVar) {
        this.n = tTBaseVideoActivity;
        this.qg = pkVar;
        this.tj = qgVar;
    }

    public void n(ViewGroup viewGroup, View view) {
        this.q = viewGroup;
        this.l = view;
        this.s = new ImageView(this.n);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, s.s(this.n, 76.0f));
        layoutParams.gravity = 80;
        this.s.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.q.addView(this.s, layoutParams);
    }

    public void n() {
        int iCy;
        LinearLayout linearLayout = new LinearLayout(this.n);
        this.w = linearLayout;
        linearLayout.setGravity(1);
        this.w.setPadding(0, s.s(this.n, 16.0f), 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, s.s(this.n, 76.0f));
        TextView textView = new TextView(this.n);
        this.x = textView;
        textView.setTextSize(12.0f);
        this.x.setTextColor(-1);
        this.x.setSingleLine();
        this.x.setEllipsize(TextUtils.TruncateAt.START);
        this.x.setGravity(5);
        this.x.setMaxWidth(s.s(this.n, 260.0f));
        this.w.addView(this.x);
        TextView textView2 = new TextView(this.n);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        textView2.setSingleLine();
        textView2.setText("取消");
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.toz.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.q();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = s.s(this.n, 10.0f);
        this.w.addView(textView2, layoutParams2);
        n(25, ta.qg(this.qg));
        int iS = s.s(this.n, 76.0f);
        this.q.addView(this.w, layoutParams);
        try {
            int iQg = fs.qg(this.n);
            if (s.q((Activity) this.n)) {
                iCy = (fs.s(this.n) - iQg) - qg();
            } else {
                iCy = s.cy(this.n);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.w, "translationY", iQg, (iQg - iS) + iCy);
            this.fs = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(300L);
            this.fs.start();
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.l, "translationY", 0.0f, -iS);
            this.rv = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(300L);
            this.rv.start();
        } catch (Throwable th) {
            k.qg("layout", th.getMessage());
        }
    }

    public int qg() {
        int identifier = this.n.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.n.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void n(final int i, String str) {
        com.byazt.imu.s.n(str).s(2).n(Bitmap.Config.ARGB_8888).n(new m<Bitmap>() { // from class: com.byazt.toz.n.2
            @Override // com.byazt.si.m
            public void n(int i2, String str2, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy<Bitmap> cyVar) {
                try {
                    Bitmap bitmapS = cyVar.s();
                    if (bitmapS == null) {
                        return;
                    }
                    if (bitmapS.getConfig() == Bitmap.Config.RGB_565) {
                        bitmapS = bitmapS.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    Bitmap bitmapN = com.byazt.cq.qg.n(n.this.n, bitmapS, i);
                    if (bitmapN == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(n.this.n.getResources(), bitmapN);
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.toz.n.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.w != null) {
                                n.this.w.setBackgroundColor(Color.parseColor("#66000000"));
                            }
                            if (n.this.s != null) {
                                n.this.s.setImageDrawable(bitmapDrawable);
                            }
                        }
                    });
                } catch (Throwable th) {
                    k.qg("layout", th.getMessage());
                }
            }
        }, 4);
    }

    public void s() {
        q();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.l, "alpha", 1.0f, 0.3f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.toz.n.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                n.this.l.setAlpha(1.0f);
                n.this.tj.rv();
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void n(com.byazt.ys.qg qgVar) {
        tj tjVar = new tj();
        tjVar.s(true);
        if (qgVar != null) {
            qgVar.n(tjVar);
            qgVar.n(null, tjVar);
        }
    }

    public void q() {
        ObjectAnimator objectAnimator = this.fs;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.fs.cancel();
            this.fs = null;
        }
        ObjectAnimator objectAnimator2 = this.rv;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.rv.cancel();
            this.rv = null;
        }
        LinearLayout linearLayout = this.w;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.l;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.tj.fs();
    }

    public void n(long j) {
        TextView textView = this.x;
        if (textView != null) {
            textView.setText("已为您加载更多详情，" + j + "秒后拉起展示");
        }
    }
}
