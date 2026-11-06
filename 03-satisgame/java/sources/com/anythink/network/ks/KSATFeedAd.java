package com.anythink.network.ks;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kwad.sdk.api.KsFeedAd;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATFeedAd extends CustomNativeAd {
    Context a;
    KsFeedAd b;
    View c;

    class a implements KsFeedAd.AdInteractionListener {
        a() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
            KSATFeedAd.this.notifyAdClicked();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
            KSATInitManager.getInstance().a(KSATFeedAd.this.getShowId(), new WeakReference(KSATFeedAd.this.b));
            KSATFeedAd.this.notifyAdImpression();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
            KSATFeedAd.this.notifyAdDislikeClick();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    public KSATFeedAd(Context context, KsFeedAd ksFeedAd, boolean z) {
        this.a = context.getApplicationContext();
        this.b = ksFeedAd;
        a(z);
    }

    private void a(boolean z) {
        try {
            this.b.setVideoSoundEnable(z);
            int i = this.b.getInteractionType() == 1 ? 1 : 0;
            if (this.b.getInteractionType() == 2) {
                i = 2;
            }
            setNetworkInfoMap(KSATInitManager.getInstance().a(this.b.getMediaExtraInfo(), (Map<String, Object>) null));
            setNativeInteractionType(i);
            if (this.b.getMaterialType() == 1) {
                this.mAdSourceType = "1";
            } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2) {
                this.mAdSourceType = "2";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b.setAdInteractionListener(new a());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        KsFeedAd ksFeedAd = this.b;
        if (ksFeedAd != null) {
            ksFeedAd.setAdInteractionListener(null);
            this.b = null;
        }
        this.a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        try {
            if (this.c == null) {
                this.c = this.b.getFeedView(this.a);
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
