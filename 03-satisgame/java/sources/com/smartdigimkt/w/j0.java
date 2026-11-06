package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.format.SDMSplashAdExtraInfo;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferSplashAd;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements com.smartdigimkt.j1.a {
    final /* synthetic */ SDMMyOfferSplashAd this$0;
    final /* synthetic */ WeakReference val$finalCacheSplash;

    public j0(SDMMyOfferSplashAd sDMMyOfferSplashAd, WeakReference weakReference) {
        this.this$0 = sDMMyOfferSplashAd;
        this.val$finalCacheSplash = weakReference;
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClick(com.smartdigimkt.j1.w wVar) {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdClick();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClosed() {
        int i;
        com.smartdigimkt.k1.p pVar;
        Map map;
        WeakReference weakReference = this.val$finalCacheSplash;
        if (weakReference == null || (pVar = (com.smartdigimkt.k1.p) weakReference.get()) == null || (map = pVar.h) == null) {
            i = 0;
        } else {
            try {
                int iIntValue = ((Integer) com.smartdigimkt.r4.k.a(map, com.anythink.core.common.a.b.C0013b.a, (Object) 1)).intValue();
                i = 3;
                if (iIntValue != 2) {
                    if (iIntValue == 3 || iIntValue == 5) {
                        i = 99;
                    } else {
                        i = iIntValue != 6 ? 2 : 4;
                    }
                }
            } catch (Throwable unused) {
                i = 0;
            }
        }
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdClose(new SDMSplashAdExtraInfo(i));
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdShow(com.smartdigimkt.j1.w wVar) {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdShow();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onDeeplinkCallback(boolean z) {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onDeeplinkCallback(z);
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onShowFailed(com.smartdigimkt.h0.g gVar) {
        String str = gVar != null ? gVar.b : "";
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdShowFail(com.smartdigimkt.z3.b.a("20002", str));
        }
    }
}
