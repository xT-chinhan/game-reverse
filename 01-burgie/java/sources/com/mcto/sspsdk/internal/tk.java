package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyFullScreenAd;
import com.mcto.unionsdk.QiAd;

/* JADX INFO: loaded from: classes2.dex */
public final class tk implements QiAd.InteractionListener {
    public final /* synthetic */ uk a;

    public tk(uk ukVar) {
        this.a = ukVar;
    }

    public final void onAdClick() {
        uk ukVar = this.a;
        n0.a(1, ukVar, ukVar.a.a());
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.a.c;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClick();
        }
    }

    public final void onAdClose() {
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.a.c;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClose();
        }
    }

    public final void onAdShow() {
        za zaVarD = za.d();
        String str = this.a.a.n;
        String str2 = "adt:7;" + this.a.a.b();
        zaVarD.getClass();
        za.a(41, (p) null, str, "onShow", str2);
        uk ukVar = this.a;
        n0.a(0, ukVar, ukVar.a.a());
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.a.c;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    public final void onDownloadStatusChanged(int i, int i2) {
    }

    public final void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
    }

    public final void onSkippedVideo() {
    }

    public final void onVideoComplete() {
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.a.c;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoComplete();
        }
    }

    public final void onVideoError(int i, String str) {
        r9.a("ssp_sdk", "show error!", null);
        za zaVarD = za.d();
        String str2 = this.a.a.n;
        String str3 = "adt:7;" + this.a.a.b();
        zaVarD.getClass();
        za.a(41, (p) null, str2, "show_error", str3);
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.a.c;
        if (adInteractionListener != null) {
            adInteractionListener.onError(i, str);
        }
    }
}
