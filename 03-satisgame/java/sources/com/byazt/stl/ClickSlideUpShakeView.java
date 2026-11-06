package com.byazt.stl;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.byazt.lh.tj;
import com.byazt.xta.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2187})
public class ClickSlideUpShakeView extends SlideUpView {
    public ShakeClickView n;

    public ClickSlideUpShakeView(Context context, tj tjVar, boolean z, int i) {
        super(context);
        n(context, tjVar, z, i);
    }

    private void n(Context context, tj tjVar, boolean z, int i) {
        ShakeClickView shakeClickView = new ShakeClickView(context, qg.s(context), tjVar, z, i);
        this.n = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.n.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.n;
    }

    public void setShakeText(String str) {
        if (this.n == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.n.setShakeText("");
        } else {
            this.n.setShakeText(str);
        }
    }
}
