package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class MuteImageView extends ImageView {
    private boolean a;

    public MuteImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
    }

    public void setMute(boolean z) {
        if (z) {
            setSelected(true);
        } else {
            setSelected(false);
        }
    }
}
