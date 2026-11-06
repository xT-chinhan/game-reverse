package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTDislikeToast extends FrameLayout {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Handler f2474ms;
    private TextView xr;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2474ms = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        ms(context);
    }

    private void ms(Context context) {
        TextView textView = new TextView(context);
        this.xr = textView;
        textView.setClickable(false);
        this.xr.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iMs = com.bytedance.sdk.openadsdk.core.dislike.ms.ms.xr().ms(getContext(), 20.0f);
        int iMs2 = com.bytedance.sdk.openadsdk.core.dislike.ms.ms.xr().ms(getContext(), 12.0f);
        this.xr.setPadding(iMs, iMs2, iMs, iMs2);
        this.xr.setLayoutParams(layoutParams);
        this.xr.setTextColor(-1);
        this.xr.setTextSize(16.0f);
        this.xr.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.ms.ms.xr().ms(getContext(), 6.0f));
        this.xr.setBackgroundDrawable(gradientDrawable);
        addView(this.xr);
    }

    public void ms(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f2474ms.removeCallbacksAndMessages(null);
        this.f2474ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.xr != null) {
                    TTDislikeToast.this.xr.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.f2474ms.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, a.f);
    }

    public void ms() {
        ms(t.ms(getContext(), "tt_dislike_feedback_success"));
    }

    public void xr() {
        try {
            ms(t.ms(getContext(), "tt_dislike_feedback_repeat"));
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    public void ah() {
        setVisibility(8);
        this.f2474ms.removeCallbacksAndMessages(null);
    }
}
