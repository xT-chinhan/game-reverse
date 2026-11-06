package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SimplePlayerNoG2CMediaView extends SimplePlayerMediaView {
    public SimplePlayerNoG2CMediaView(Context context) {
        super(context);
    }

    public SimplePlayerNoG2CMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimplePlayerNoG2CMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.SimplePlayerMediaView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_simple_player_no_g2c_media_ad_view", "layout"), this);
    }
}
