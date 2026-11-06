package com.anythink.network.ks;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kwad.sdk.api.KsDrawAd;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATDrawAd extends CustomNativeAd {
    Context a;
    KsDrawAd b;
    View c;

    class a implements KsDrawAd.AdInteractionListener {
        final /* synthetic */ KsDrawAd a;

        a(KsDrawAd ksDrawAd) {
            this.a = ksDrawAd;
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdClicked() {
            KSATDrawAd.this.notifyAdClicked();
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdShow() {
            KSATInitManager.getInstance().a(KSATDrawAd.this.getShowId(), new WeakReference(this.a));
            KSATDrawAd.this.notifyAdImpression();
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayEnd() {
            KSATDrawAd.this.notifyAdVideoEnd();
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayError() {
            KSATDrawAd.this.notifyAdVideoVideoPlayFail("", "KS Native Video Play Error");
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayPause() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayResume() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayStart() {
            KSATDrawAd.this.notifyAdVideoStart();
        }
    }

    public KSATDrawAd(Context context, KsDrawAd ksDrawAd, boolean z) {
        this.a = context;
        this.b = ksDrawAd;
        int i = 0;
        if (ksDrawAd != null) {
            i = ksDrawAd.getInteractionType() == 2 ? 2 : ksDrawAd.getInteractionType() == 1 ? 1 : 0;
            setNetworkInfoMap(KSATInitManager.getInstance().a(ksDrawAd.getMediaExtraInfo(), (Map<String, Object>) null));
        }
        setNativeInteractionType(i);
        if (ksDrawAd != null) {
            ksDrawAd.setVideoSoundEnable(z);
            ksDrawAd.setAdInteractionListener(new a(ksDrawAd));
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
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
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
    }
}
