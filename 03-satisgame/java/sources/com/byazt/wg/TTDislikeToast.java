package com.byazt.wg;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 204, 2091})
public class TTDislikeToast extends FrameLayout {
    public Handler n;
    public TextView qg;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        n(context);
    }

    private void n(Context context) {
        TextView textView = new TextView(context);
        this.qg = textView;
        textView.setClickable(false);
        this.qg.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iN = com.byazt.nnl.n.qg().n(getContext(), 20.0f);
        int iN2 = com.byazt.nnl.n.qg().n(getContext(), 12.0f);
        this.qg.setPadding(iN, iN2, iN, iN2);
        this.qg.setLayoutParams(layoutParams);
        this.qg.setTextColor(-1);
        this.qg.setTextSize(16.0f);
        this.qg.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.byazt.nnl.n.qg().n(getContext(), 6.0f));
        this.qg.setBackgroundDrawable(gradientDrawable);
        addView(this.qg);
    }

    public void n(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n.removeCallbacksAndMessages(null);
        this.n.post(new Runnable() { // from class: com.byazt.wg.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.qg != null) {
                    TTDislikeToast.this.qg.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.n.postDelayed(new Runnable() { // from class: com.byazt.wg.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void n() {
        setVisibility(8);
        this.n.removeCallbacksAndMessages(null);
    }
}
