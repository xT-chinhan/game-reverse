package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class MuteImageView extends ImageView {
    public MuteImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setMute(boolean z) {
        if (z) {
            setSelected(true);
        } else {
            setSelected(false);
        }
    }
}
