package com.byazt.te;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 1417})
public class TTLottieVideoContainer extends FrameLayout implements com.byazt.c.hw {
    public com.byazt.c.hw.pr pr;

    public TTLottieVideoContainer(Context context) {
        super(context);
    }

    @Override // com.byazt.c.hw
    public void pr(com.byazt.c.pr prVar) {
    }

    @Override // com.byazt.c.hw
    public void pr(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.byazt.c.hw
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(com.byazt.c.hw.pr prVar) {
        this.pr = prVar;
    }
}
