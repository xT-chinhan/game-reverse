package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements SDMNativeAdMediaViewListener {
    public final /* synthetic */ SDMNativeAdMediaViewListener a;
    public final /* synthetic */ x b;

    public v(x xVar, SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener) {
        this.b = xVar;
        this.a = sDMNativeAdMediaViewListener;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
    public final void onProgressUpdate(long j, long j2) {
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = this.a;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onProgressUpdate(j, j2);
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
    public final void onVideoAdComplete() {
        com.smartdigimkt.h1.k kVar = this.b.c;
        if (kVar instanceof com.smartdigimkt.h1.k) {
            kVar.getClass();
        }
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = this.a;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onVideoAdComplete();
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
    public final void onVideoAdStartPlay(long j) {
        com.smartdigimkt.h1.k kVar = this.b.c;
        if (kVar instanceof com.smartdigimkt.h1.k) {
            kVar.getClass();
        }
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = this.a;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onVideoAdStartPlay(j);
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
    public final void onVideoError(String str, String str2) {
        com.smartdigimkt.h1.k kVar = this.b.c;
        if (kVar instanceof com.smartdigimkt.h1.k) {
            kVar.getClass();
        }
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = this.a;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onVideoError(str, str2);
        }
    }
}
