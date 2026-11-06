package com.anythink.network.ks;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kwad.sdk.api.KsDrawAd;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class KSATDrawAd extends CustomNativeAd {
    Context a;
    KsDrawAd b;
    View c;

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
    }

    public KSATDrawAd(Context context, final KsDrawAd ksDrawAd) {
        this.a = context;
        this.b = ksDrawAd;
        int i = 0;
        if (ksDrawAd != null) {
            i = ksDrawAd.getInteractionType() == 1 ? 1 : 0;
            if (ksDrawAd.getInteractionType() == 2) {
                i = 2;
            }
        }
        setNativeInteractionType(i);
        ksDrawAd.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.anythink.network.ks.KSATDrawAd.1
            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayPause() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayResume() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onAdClicked() {
                KSATDrawAd.this.notifyAdClicked();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onAdShow() {
                KSATInitManager.getInstance().a(KSATDrawAd.this.getShowId(), new WeakReference(ksDrawAd));
                KSATDrawAd.this.notifyAdImpression();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayStart() {
                KSATDrawAd.this.notifyAdVideoStart();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayEnd() {
                KSATDrawAd.this.notifyAdVideoEnd();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayError() {
                KSATDrawAd.this.notifyAdVideoVideoPlayFail("", "KS Native Video Play Error");
            }
        });
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        try {
            if (this.c == null) {
                this.c = this.b.getDrawView(this.a);
            }
            return this.c;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        KsDrawAd ksDrawAd = this.b;
        if (ksDrawAd != null) {
            ksDrawAd.setAdInteractionListener(null);
            this.b = null;
        }
        this.a = null;
    }
}
