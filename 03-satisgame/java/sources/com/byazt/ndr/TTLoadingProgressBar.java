package com.byazt.ndr;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 2491})
public class TTLoadingProgressBar extends LinearLayout {
    public View n;
    public ImageView qg;
    public View s;

    public View getProgressBar() {
        return this.n;
    }

    public ImageView getProgressIcon() {
        return this.qg;
    }

    public void setProgress(int i) {
        if (this.qg.getVisibility() == 0 && i > 3) {
            ((LinearLayout.LayoutParams) this.qg.getLayoutParams()).leftMargin = n(this.n.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        float f = i / 100.0f;
        layoutParams.weight = f;
        this.n.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams2.weight = 1.0f - f;
        this.s.setLayoutParams(layoutParams2);
        requestLayout();
    }

    private int n(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
