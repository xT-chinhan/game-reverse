package com.byazt.osr;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.lh.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, MediaPlayer.MEIDA_PLAYER_OPTION_NATIVE_RENDER_ROTATION_ADAPT})
public class DynamicLeisureWidget extends DynamicBaseWidgetImp {
    public DynamicLeisureWidget(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        this.x = 0;
        this.fs = 0;
        return super.getWidgetLayoutParams();
    }
}
