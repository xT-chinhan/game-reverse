package com.smartdigimkt.sdk.api.format;

import com.anythink.core.common.a.b;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.smartdigimkt.e1.j;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.j1.w;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.smartdigimkt.j1.a {
    final /* synthetic */ SDMSplashAd this$0;
    final /* synthetic */ WeakReference val$finalCacheSplash;

    public a(SDMSplashAd sDMSplashAd, WeakReference weakReference) {
        this.this$0 = sDMSplashAd;
        this.val$finalCacheSplash = weakReference;
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClick(w wVar) {
        this.this$0.printAdStatusLog("click", "success", "");
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdClick();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClosed() {
        int i;
        j jVar;
        Map map;
        this.this$0.printAdStatusLog(ILivePush.ClickType.CLOSE, "success", "");
        WeakReference weakReference = this.val$finalCacheSplash;
        if (weakReference == null || (jVar = (j) weakReference.get()) == null || (map = jVar.h) == null) {
            i = 0;
        } else {
            try {
                int iIntValue = ((Integer) k.a(map, b.C0013b.a, (Object) 1)).intValue();
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
    public void onAdShow(w wVar) {
        this.this$0.printAdStatusLog("impression", "success", "");
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdShow();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onShowFailed(g gVar) {
        String str = gVar != null ? gVar.b : "";
        this.this$0.printAdStatusLog("show_failed", "fail", gVar != null ? gVar.a() : "", new com.smartdigimkt.z3.a(gVar != null ? gVar.a : "", str));
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdShowFail(com.smartdigimkt.z3.b.a("20002", str));
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onDeeplinkCallback(boolean z) {
        this.this$0.printAdStatusLog(SDMAdConst.NETWORK_CUSTOM_KEY.DEEPLINK, z ? "success" : "fail", "");
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onDeeplinkCallback(z);
        }
    }
}
