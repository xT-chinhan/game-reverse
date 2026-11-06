package com.smartdigimkt.t4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.smartdigimkt.sdk.api.format.SDMAd;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import com.smartdigimkt.sdk.api.format.SDMNativeAd;
import com.smartdigimkt.sdk.api.format.SDMNativeAdListener;
import com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener;
import com.smartdigimkt.sdk.api.format.SDMWinInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements SDMNativeAd {
    public final com.smartdigimkt.k1.l a;

    public u(com.smartdigimkt.k1.l lVar) {
        this.a = lVar;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void destroy() {
        this.a.c();
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final View generateShakeViewContainer() {
        return null;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getAdChoiceIconUrl() {
        com.smartdigimkt.e3.a aVar = this.a.e;
        return aVar != null ? aVar.g : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdImageHeight() {
        int i;
        com.smartdigimkt.e3.a aVar = this.a.e;
        if (aVar == null) {
            return 0;
        }
        synchronized (aVar) {
            i = aVar.F;
        }
        return i;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdImageWidth() {
        int i;
        com.smartdigimkt.e3.a aVar = this.a.e;
        if (aVar == null) {
            return 0;
        }
        synchronized (aVar) {
            i = aVar.E;
        }
        return i;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdType() {
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdVideoHeight() {
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdVideoWidth() {
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getAppName() {
        return "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getAppVersion() {
        return "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getCallToAction() {
        com.smartdigimkt.e3.a aVar = this.a.e;
        return aVar != null ? aVar.h : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final ViewGroup getCustomAdContainer() {
        return null;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getDescription() {
        com.smartdigimkt.e3.a aVar = this.a.e;
        return aVar != null ? aVar.d : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getDownloadStatus() {
        com.smartdigimkt.e3.a aVar = this.a.e;
        if (aVar != null) {
            return aVar.D;
        }
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getFunctionUrl() {
        return "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getIcon() {
        com.smartdigimkt.e3.a aVar = this.a.e;
        return aVar != null ? aVar.e : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getInteractionType() {
        com.smartdigimkt.e3.a aVar = this.a.e;
        if (aVar != null) {
            return aVar.o;
        }
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getMainImageUrl() {
        com.smartdigimkt.e3.a aVar = this.a.e;
        return aVar != null ? aVar.f : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final View getMediaView(Context context, SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener) {
        this.a.getClass();
        return null;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getPermissionUrl() {
        return "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getPrivacyUrl() {
        return "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getPublisher() {
        return "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public final SDMAd getSDMAd() {
        return null;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getTitle() {
        com.smartdigimkt.e3.a aVar = this.a.e;
        return aVar != null ? aVar.c : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final long getVideoCurrentPosition() {
        return 0L;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final long getVideoDuration() {
        return 0L;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final boolean isAdReady() {
        com.smartdigimkt.k1.l lVar = this.a;
        if (lVar != null) {
            return lVar.d();
        }
        return false;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final boolean isDownloadApp() {
        return false;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final boolean isTemplateAd() {
        return false;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public final void notifyLoss(SDMLossInfo sDMLossInfo) {
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public final void notifyWin(SDMWinInfo sDMWinInfo) {
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void onPause() {
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void onResume() {
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void pauseVideo() {
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void registerAdView(View view, List list, List list2, FrameLayout.LayoutParams layoutParams, View view2) {
        com.smartdigimkt.e3.a aVar;
        com.smartdigimkt.a3.a aVar2;
        com.smartdigimkt.k1.l lVar = this.a;
        if (lVar != null) {
            lVar.e();
            lVar.l = view;
            if (view != null && (view instanceof ViewGroup) && (aVar = lVar.e) != null && (aVar2 = lVar.b) != null) {
                lVar.q = new com.smartdigimkt.k1.k(lVar, (ViewGroup) view, aVar, aVar2, new com.smartdigimkt.k1.j(lVar));
            }
            com.smartdigimkt.p3.e eVar = lVar.b.a;
            if (eVar != null) {
                eVar.a(view, lVar);
            }
            if (view == null) {
                return;
            }
            if (list == null || list.size() <= 0) {
                com.smartdigimkt.k1.l.a(view, lVar.o);
            } else {
                View[] viewArr = new View[1];
                lVar.a(view, viewArr);
                View view3 = viewArr[0];
                if (view3 != null) {
                    lVar.n = view3;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    View view4 = (View) it.next();
                    if (view4 != null) {
                        view4.setOnClickListener(lVar.o);
                    }
                }
            }
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                View view5 = (View) it2.next();
                if (view5 != null) {
                    view5.setOnClickListener(lVar.p);
                }
            }
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void resumeVideo() {
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void setAutoPlay(String str) {
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void setListener(SDMNativeAdListener sDMNativeAdListener) {
        this.a.i = new t(sDMNativeAdListener);
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void setMute(boolean z) {
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void unregisterView() {
        com.smartdigimkt.p3.e eVar = this.a.b.a;
        if (eVar != null) {
            eVar.c();
        }
    }
}
