package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyFullScreenAd;
import com.mcto.unionsdk.QiAd;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class sj implements QiAd.InteractionListener {
    public final /* synthetic */ tj a;

    public sj(tj tjVar) {
        this.a = tjVar;
    }

    public final void onAdClick() {
        HashMap map = new HashMap(1);
        map.put(v5.KEY_CLICK_AREA, z3.GRAPHIC);
        l lVarA = l.a();
        p pVar = this.a.b;
        lVarA.getClass();
        l.a(21, pVar, map);
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
        l lVarA = l.a();
        p pVar = this.a.b;
        lVarA.getClass();
        l.a(12, pVar, null);
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
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.a.c;
        if (adInteractionListener != null) {
            adInteractionListener.onError(i, str);
        }
    }
}
