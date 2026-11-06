package com.bytedance.adsdk.ugeno.widget.scroll;

import android.content.Context;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.adsdk.ugeno.xr.ms<ScrollView> {
    public ms(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: am, reason: merged with bridge method [inline-methods] */
    public ScrollView ms() {
        UGScrollView uGScrollView = new UGScrollView(this.xr);
        uGScrollView.ms(this);
        return uGScrollView;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    public com.bytedance.adsdk.ugeno.xr.ms.C0201ms x() {
        return new com.bytedance.adsdk.ugeno.widget.frame.ms.C0198ms(this);
    }
}
