package com.byazt.ee;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 84, 1903})
public class CSJGameRunnerView extends FrameLayout {
    public int l;
    public final float n;
    public int q;
    public ImageView qg;
    public LottieAnimationView s;

    public CSJGameRunnerView(Context context) {
        super(context);
        this.n = context.getResources().getDisplayMetrics().density;
        setClickable(false);
        setFocusable(false);
    }

    public void n(Bitmap bitmap, double d, double d2, double d3, double d4) {
        if (bitmap == null) {
            return;
        }
        if (this.qg == null) {
            ImageView imageView = new ImageView(getContext());
            this.qg = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            addView(this.qg);
        }
        this.qg.setImageBitmap(bitmap);
        n(this.qg, d3, d4);
        setVisibility(0);
        n(d, d2, 1.0d);
    }

    public void n(w wVar, JSONObject jSONObject, double d, double d2, double d3, double d4) {
        if (wVar == null) {
            return;
        }
        if (this.s == null) {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
            this.s = lottieAnimationView;
            addView(lottieAnimationView);
        }
        n(this.s, d3, d4);
        this.s.setMaintainOriginalImageBounds(true);
        this.s.setImageAssetDelegate(new n(this.s, jSONObject));
        this.s.setComposition(wVar);
        this.s.n(true);
        this.s.n();
        setVisibility(0);
        n(d, d2, 1.0d);
    }

    public void n(double d, double d2, double d3) {
        setTranslationX(((float) (d * ((double) this.n))) - this.q);
        setTranslationY(((float) (d2 * ((double) this.n))) - this.l);
        setAlpha((float) d3);
    }

    public void n() {
        LottieAnimationView lottieAnimationView = this.s;
        if (lottieAnimationView != null) {
            lottieAnimationView.w();
        }
        setVisibility(8);
    }

    private void n(View view, double d, double d2) {
        float f = this.n;
        int i = (int) (d * ((double) f));
        int i2 = (int) (d2 * ((double) f));
        this.q = i / 2;
        this.l = i2 / 2;
        setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
}
