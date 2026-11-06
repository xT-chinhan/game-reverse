package com.smartdigimkt.h1;

import com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener;
import com.smartdigimkt.t4.v;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends n {
    public final /* synthetic */ SDMNativeAdMediaViewListener a;
    public final /* synthetic */ o b;

    public m(o oVar, v vVar) {
        this.b = oVar;
        this.a = vVar;
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
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = this.a;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onVideoAdComplete();
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
    public final void onVideoAdStartPlay(long j) {
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = this.a;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onVideoAdStartPlay(j);
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
    public final void onVideoError(String str, String str2) {
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = this.a;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onVideoError(str, str2);
        }
    }
}
