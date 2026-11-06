package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class SimplePlayerBannerMediaView extends SimplePlayerMediaView {
    public SimplePlayerBannerMediaView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.SimplePlayerMediaView
    public final void a() {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_simple_player_banner_media_ad_view", "layout"), this);
    }

    public SimplePlayerBannerMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimplePlayerBannerMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
