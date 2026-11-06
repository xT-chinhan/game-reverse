package com.byazt.qza;

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
import com.byazt.kfh.TTProgressBar;
import com.byazt.tk.sz;
import com.byazt.tk.ur;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE, 18})
public class l extends FrameLayout {
    public final Runnable n;
    public final View qg;
    public final TTProgressBar s;

    public l(Context context, Runnable runnable) {
        super(context);
        this.n = runnable;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View viewN = n(context);
        this.qg = viewN;
        addView(viewN);
        TTProgressBar tTProgressBarQg = qg(context);
        this.s = tTProgressBarQg;
        addView(tTProgressBarQg);
        qg();
    }

    public void n() {
        this.s.setVisibility(0);
    }

    public void qg() {
        this.s.setVisibility(8);
    }

    public void s() {
        setVisibility(0);
    }

    public void q() {
        setVisibility(8);
    }

    public void n(boolean z) {
        this.qg.setVisibility(z ? 0 : 8);
    }

    private View n(Context context) {
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int iN = ur.n(context, 5.0f);
        layoutParams.gravity = 8388659;
        layoutParams.setMargins(iN, iN, iN, iN);
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(true);
        imageView.setFocusable(true);
        int iN2 = ur.n(context, 5.0f);
        imageView.setPadding(iN2, iN2, iN2, iN2);
        imageView.setImageDrawable(s(context));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.qza.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.n != null) {
                    l.this.n.run();
                }
            }
        });
        return imageView;
    }

    private TTProgressBar qg(final Context context) {
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        int iN = ur.n(context, 60.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iN, iN);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        int iN2 = ur.n(context, 10.0f);
        tTProgressBar.setPadding(iN2, iN2, iN2, iN2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(ur.n(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        tTProgressBar.setIndeterminate(true);
        sz.n(context, "tt_normalscreen_loading", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.qza.l.2
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.n(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        return tTProgressBar;
    }

    private Drawable s(Context context) {
        int iN = ur.n(context, 2.0f);
        com.byazt.jjh.n nVar = new com.byazt.jjh.n(48);
        nVar.n(Color.parseColor("#484848"));
        float f = iN;
        nVar.n(f);
        com.byazt.jjh.n nVar2 = new com.byazt.jjh.n(48);
        nVar2.n(Color.parseColor("#666666"));
        nVar2.n(f);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, nVar);
        stateListDrawable.addState(new int[0], nVar2);
        return stateListDrawable;
    }
}
