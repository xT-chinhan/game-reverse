package com.byazt.stl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.byazt.lh.tj;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2350})
public class ShakeClickView extends ShakeAnimationView {
    public TextView qg;

    public ShakeClickView(Context context, View view, tj tjVar, boolean z, int i) {
        super(context, view, tjVar, z, i);
    }

    @Override // com.byazt.stl.ShakeAnimationView
    public void n(Context context, View view) {
        addView(view);
        this.qg = (TextView) findViewById(2097610747);
    }

    @Override // com.byazt.stl.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.qg == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                this.qg.setText("摇一摇或点击了解更多");
                return;
            } catch (Exception e) {
                k.qg("shakeClickView", e.getMessage());
                return;
            }
        }
        this.qg.setText(str);
    }
}
