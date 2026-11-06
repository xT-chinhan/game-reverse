package com.anythink.core.common.k.e;

import android.content.Context;
import android.view.View;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.c;
import com.anythink.core.common.h.n;
import com.anythink.core.common.k.e.a.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b {
    private c adCacheInfo;
    private int clickType;
    private int clickedArea;

    @Override // com.anythink.core.common.k.e.a.b
    public void onAdDislikeButtonClick() {
    }

    @Override // com.anythink.core.common.k.e.a.b
    public void onAdImpressed() {
    }

    @Override // com.anythink.core.common.k.e.a.b
    public void onAdVideoEnd() {
    }

    @Override // com.anythink.core.common.k.e.a.b
    public void onAdVideoProgress(int i) {
    }

    @Override // com.anythink.core.common.k.e.a.b
    public void onAdVideoStart() {
    }

    @Override // com.anythink.core.common.k.e.a.b
    public void onClose() {
    }

    @Override // com.anythink.core.common.k.e.a.b
    public void onDeeplinkCallback(boolean z) {
    }

    @Override // com.anythink.core.common.k.e.a.b
    public void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
    }

    @Override // com.anythink.core.common.k.e.a.b
    public void onVideoError(String str, String str2) {
    }

    public a() {
    }

    public a(c cVar) {
        this.adCacheInfo = cVar;
    }

    @Override // com.anythink.core.common.k.e.a.b
    public void onAdClicked(View view) {
        ATBaseAdAdapter aTBaseAdAdapterE;
        c cVar = this.adCacheInfo;
        if (cVar == null || (aTBaseAdAdapterE = cVar.e()) == null || aTBaseAdAdapterE.getTrackingInfo() == null) {
            return;
        }
        n trackingInfo = aTBaseAdAdapterE.getTrackingInfo();
        trackingInfo.P(getClickedArea());
        trackingInfo.Q(getClickType());
    }

    public int getClickedArea() {
        return this.clickedArea;
    }

    public void setClickedArea(int i) {
        this.clickedArea = i;
    }

    public int getClickType() {
        return this.clickType;
    }

    public void setClickType(int i) {
        this.clickType = i;
    }
}
