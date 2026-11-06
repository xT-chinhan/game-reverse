package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Color;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.sdk.basead.ui.GuideToClickView;
import com.smartdigimkt.y1.i;

/* JADX INFO: loaded from: classes3.dex */
public class FingerG2CV2View extends BaseG2CV2View {
    public GuideToClickView h;
    public int i;

    public FingerG2CV2View(Context context) {
        super(context);
        this.i = MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        setGravity(17);
        GuideToClickView guideToClickView = new GuideToClickView(getContext());
        this.h = guideToClickView;
        guideToClickView.setFingerViewMode(this.i);
        addView(this.h, -2, -2);
        setClipChildren(false);
        if (this.e != null) {
            setOnClickListener(new i(this));
        }
    }

    public void setFingerViewMode(int i) {
        if (i == 503) {
            setBackgroundColor(Color.parseColor("#66000000"));
        }
        this.i = i;
        GuideToClickView guideToClickView = this.h;
        if (guideToClickView != null) {
            guideToClickView.setFingerViewMode(i);
        }
    }
}
