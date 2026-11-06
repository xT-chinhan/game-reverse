package com.byazt.su;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.ca.ve;
import com.byazt.fj.TTProgressBar;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends FrameLayout {
    public final TTProgressBar hn;
    public final View hw;
    public final Runnable pr;

    public c(Context context, Runnable runnable) {
        super(context);
        this.pr = runnable;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View viewPr = pr(context);
        this.hw = viewPr;
        addView(viewPr);
        TTProgressBar tTProgressBarHw = hw(context);
        this.hn = tTProgressBarHw;
        addView(tTProgressBarHw);
        hw();
    }

    public void pr() {
        this.hn.setVisibility(0);
    }

    public void hw() {
        this.hn.setVisibility(8);
    }

    public void hn() {
        setVisibility(0);
    }

    public void x() {
        setVisibility(8);
    }

    public void pr(boolean z) {
        this.hw.setVisibility(z ? 0 : 8);
    }

    private View pr(Context context) {
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int iPr = ve.pr(context, 5.0f);
        layoutParams.gravity = 8388659;
        layoutParams.setMargins(iPr, iPr, iPr, iPr);
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(true);
        imageView.setFocusable(true);
        int iPr2 = ve.pr(context, 5.0f);
        imageView.setPadding(iPr2, iPr2, iPr2, iPr2);
        imageView.setImageDrawable(hn(context));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.su.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.pr != null) {
                    c.this.pr.run();
                }
            }
        });
        return imageView;
    }

    private TTProgressBar hw(final Context context) {
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        int iPr = ve.pr(context, 60.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iPr, iPr);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        int iPr2 = ve.pr(context, 10.0f);
        tTProgressBar.setPadding(iPr2, iPr2, iPr2, iPr2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(ve.pr(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        tTProgressBar.setIndeterminate(true);
        g.pr(context, "tt_normalscreen_loading", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.su.c.2
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.pr(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        return tTProgressBar;
    }

    private Drawable hn(Context context) {
        int iPr = ve.pr(context, 2.0f);
        com.byazt.il.pr prVar = new com.byazt.il.pr(48);
        prVar.pr(Color.parseColor("#484848"));
        float f = iPr;
        prVar.pr(f);
        com.byazt.il.pr prVar2 = new com.byazt.il.pr(48);
        prVar2.pr(Color.parseColor("#666666"));
        prVar2.pr(f);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, prVar);
        stateListDrawable.addState(new int[0], prVar2);
        return stateListDrawable;
    }
}
