package com.byazt.pfl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, 1906})
public class TTDislikeToast extends FrameLayout {
    public TextView hw;
    public Handler pr;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pr = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        pr(context);
    }

    private void pr(Context context) {
        TextView textView = new TextView(context);
        this.hw = textView;
        textView.setClickable(false);
        this.hw.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iPr = com.byazt.rc.pr.hw().pr(getContext(), 20.0f);
        int iPr2 = com.byazt.rc.pr.hw().pr(getContext(), 12.0f);
        this.hw.setPadding(iPr, iPr2, iPr, iPr2);
        this.hw.setLayoutParams(layoutParams);
        this.hw.setTextColor(-1);
        this.hw.setTextSize(16.0f);
        this.hw.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.byazt.rc.pr.hw().pr(getContext(), 6.0f));
        this.hw.setBackgroundDrawable(gradientDrawable);
        addView(this.hw);
    }

    public void pr(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.pr.removeCallbacksAndMessages(null);
        this.pr.post(new Runnable() { // from class: com.byazt.pfl.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.hw != null) {
                    TTDislikeToast.this.hw.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.pr.postDelayed(new Runnable() { // from class: com.byazt.pfl.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void pr() {
        setVisibility(8);
        this.pr.removeCallbacksAndMessages(null);
    }
}
