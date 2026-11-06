package com.smartdigimkt.t4;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.smartdigimkt.n1.i3;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.SDMAd;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import com.smartdigimkt.sdk.api.format.SDMNativeAd;
import com.smartdigimkt.sdk.api.format.SDMNativeAdListener;
import com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener;
import com.smartdigimkt.sdk.api.format.SDMWinInfo;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements SDMNativeAd {
    public final a a = new a();
    public final com.smartdigimkt.e1.g b;
    public final com.smartdigimkt.h1.k c;
    public boolean d;
    public WeakReference e;
    public volatile boolean f;
    public SDMNativeAdListener g;

    public x(com.smartdigimkt.e1.g gVar) {
        com.smartdigimkt.h1.k oVar;
        com.smartdigimkt.e1.e eVar;
        this.b = gVar;
        if (gVar.i != null) {
            Context context = gVar.b;
            com.smartdigimkt.b3.b bVar = gVar.e;
            com.smartdigimkt.a3.a aVar = gVar.c;
            boolean z = gVar.p;
            oVar = z ? new com.smartdigimkt.h1.o(context, bVar, aVar, z) : new com.smartdigimkt.h1.l(context, bVar, aVar, z);
        } else {
            oVar = null;
        }
        if (oVar != null && (eVar = gVar.d) != null) {
            int i = eVar.h;
            int i2 = eVar.i;
            oVar.j = i;
            oVar.k = i2;
            oVar.l = eVar.m;
            boolean z2 = eVar.a == 0;
            oVar.g = z2;
            i3 i3Var = oVar.s;
            if (i3Var != null) {
                i3Var.setIsMuted(z2);
            }
            oVar.h = gVar.d.n;
        }
        this.c = oVar;
        this.d = false;
    }

    public static boolean a(x xVar) {
        return (xVar.f || xVar.g == null) ? false : true;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void destroy() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.g = null;
        com.smartdigimkt.h1.k kVar = this.c;
        if (kVar != null) {
            kVar.e();
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final View generateShakeViewContainer() {
        return this.c.b();
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getAdChoiceIconUrl() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.g : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdImageHeight() {
        int i;
        com.smartdigimkt.b3.l lVar = this.c.b;
        if (lVar == null) {
            return 0;
        }
        synchronized (lVar) {
            i = lVar.F;
        }
        return i;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdImageWidth() {
        int i;
        com.smartdigimkt.b3.l lVar = this.c.b;
        if (lVar == null) {
            return 0;
        }
        synchronized (lVar) {
            i = lVar.E;
        }
        return i;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdType() {
        return this.c.i;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdVideoHeight() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        if (lVar != null) {
            return lVar.H;
        }
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getAdVideoWidth() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        if (lVar != null) {
            return lVar.G;
        }
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getAppName() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.X : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getAppVersion() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.s : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getCallToAction() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.h : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final ViewGroup getCustomAdContainer() {
        return this.c.c();
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getDescription() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.d : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getDownloadStatus() {
        com.smartdigimkt.b3.l lVar;
        com.smartdigimkt.h1.k kVar = this.c;
        if (kVar.d || (lVar = kVar.b) == null) {
            return 0;
        }
        return lVar.D;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getFunctionUrl() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.v : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getIcon() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.e : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final int getInteractionType() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        if (lVar != null) {
            return lVar.o;
        }
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getMainImageUrl() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.f : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final View getMediaView(Context context, SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener) {
        View viewA = this.c.a(context, new v(this, sDMNativeAdMediaViewListener));
        this.e = new WeakReference(viewA);
        return viewA;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getPermissionUrl() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.u : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getPrivacyUrl() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.t : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getPublisher() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.r : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public final SDMAd getSDMAd() {
        com.smartdigimkt.e1.g gVar = this.b;
        if (gVar != null) {
            return new l(gVar);
        }
        return null;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final String getTitle() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        return lVar != null ? lVar.c : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final long getVideoCurrentPosition() {
        i3 i3Var = this.c.s;
        if (i3Var != null) {
            return i3Var.getVideoCurrentPosition();
        }
        return 0L;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final long getVideoDuration() {
        com.smartdigimkt.b3.l lVar = this.c.b;
        if (lVar == null) {
            return 0L;
        }
        long j = lVar.I;
        return j > 0 ? j : lVar.S * 1000;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final boolean isAdReady() {
        boolean zA;
        int i;
        String str;
        int i2;
        String str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.e1.g gVar = this.b;
        if (gVar != null) {
            com.smartdigimkt.f3.a aVar = gVar.l;
            String str3 = aVar != null ? aVar.b : "";
            int iB = gVar.b();
            zA = this.b.a(iB);
            if (iB == 1) {
                com.smartdigimkt.e1.g gVar2 = this.b;
                SDMLossInfo sDMLossInfoNewInternalLossInfo = SDMLossInfo.newInternalLossInfo(4);
                if (gVar2 != null && sDMLossInfoNewInternalLossInfo != null) {
                    d0.a(gVar2, sDMLossInfoNewInternalLossInfo);
                }
                destroy();
            }
            i = iB;
            str = str3;
        } else {
            zA = false;
            i = 0;
            str = "";
        }
        com.smartdigimkt.n3.k.a(zA, str, this.b, System.currentTimeMillis() - jCurrentTimeMillis, i);
        com.smartdigimkt.e1.g gVar3 = this.b;
        if (gVar3 != null) {
            com.smartdigimkt.a3.a aVar2 = gVar3.c;
            str2 = aVar2 != null ? aVar2.b : "";
            i2 = aVar2 != null ? aVar2.c : 0;
        } else {
            i2 = 0;
            str2 = "";
        }
        if (zA) {
            com.smartdigimkt.r4.w.a(str2, com.smartdigimkt.r4.j.a(String.valueOf(i2)), "isready", String.valueOf(true), "");
        } else {
            com.smartdigimkt.r4.w.a(str2, com.smartdigimkt.r4.j.a(String.valueOf(i2)), "isready", String.valueOf(false), "");
        }
        return zA;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final boolean isDownloadApp() {
        com.smartdigimkt.h1.k kVar = this.c;
        com.smartdigimkt.b3.l lVar = kVar.b;
        return (lVar == null || (TextUtils.isEmpty(lVar.r) && TextUtils.isEmpty(kVar.b.X) && TextUtils.isEmpty(kVar.b.u) && TextUtils.isEmpty(kVar.b.t) && TextUtils.isEmpty(kVar.b.v) && TextUtils.isEmpty(kVar.b.s))) ? false : true;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final boolean isTemplateAd() {
        return this.c.d;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public final void notifyLoss(SDMLossInfo sDMLossInfo) {
        com.smartdigimkt.e1.g gVar = this.b;
        if (gVar == null || sDMLossInfo == null) {
            return;
        }
        if (SDMLossInfo.isInternalLossReason(sDMLossInfo.getLossReasonCode())) {
            sDMLossInfo.getLossReasonCode();
        } else {
            d0.a(gVar, sDMLossInfo);
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdHandler
    public final void notifyWin(SDMWinInfo sDMWinInfo) {
        d0.a(this.b, sDMWinInfo);
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void onPause() {
        i3 i3Var = this.c.s;
        if (i3Var != null) {
            i3Var.pauseVideo();
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void onResume() {
        i3 i3Var = this.c.s;
        if (i3Var != null) {
            i3Var.resumeVideo();
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void pauseVideo() {
        i3 i3Var = this.c.s;
        if (i3Var != null) {
            i3Var.pauseVideo();
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void registerAdView(View view, List list, List list2, FrameLayout.LayoutParams layoutParams, View view2) {
        com.smartdigimkt.b3.b bVar;
        com.smartdigimkt.p3.e eVar;
        com.smartdigimkt.e1.g gVar = this.b;
        if (gVar != null) {
            gVar.d();
        }
        com.smartdigimkt.h1.k kVar = this.c;
        if ((kVar instanceof com.smartdigimkt.h1.k) && (eVar = kVar.c.a) != null) {
            eVar.a(kVar.d ? kVar.q : view, kVar);
            if (kVar.f) {
                kVar.c.a.c();
            }
        }
        if (!this.d) {
            this.d = true;
            com.smartdigimkt.e1.g gVar2 = this.b;
            if (gVar2 != null) {
                d0.b(gVar2);
                this.b.c();
            }
        }
        i3 i3Var = this.c.s;
        if (i3Var != null) {
            i3Var.resumeVideo();
        }
        this.c.a(view, list, list2, layoutParams, view2);
        if (this.c.d || (bVar = this.b.e) == null || bVar.e() != 2 || !(this.b.e instanceof com.smartdigimkt.b3.l)) {
            return;
        }
        WeakReference weakReference = this.e;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        boolean z = (view3 == null || view3.getParent() == null) ? false : true;
        com.smartdigimkt.e1.g gVar3 = this.b;
        com.smartdigimkt.f3.a aVar = gVar3.l;
        com.smartdigimkt.b3.b bVar2 = gVar3.e;
        String str = bVar2.c0;
        String str2 = bVar2.a;
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "1004710";
        cVar.a(aVar);
        cVar.l = String.valueOf(aVar.P);
        cVar.m = aVar.Q;
        cVar.n = str;
        cVar.o = str2;
        cVar.p = z ? "1" : "2";
        com.smartdigimkt.n3.k.a(cVar);
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void resumeVideo() {
        i3 i3Var = this.c.s;
        if (i3Var != null) {
            i3Var.resumeVideo();
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void setAutoPlay(String str) {
        this.c.h = str;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void setListener(SDMNativeAdListener sDMNativeAdListener) {
        this.g = sDMNativeAdListener;
        w wVar = new w(this);
        this.c.e = new com.smartdigimkt.j1.t(this.b, wVar);
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void setMute(boolean z) {
        com.smartdigimkt.h1.k kVar = this.c;
        kVar.g = z;
        i3 i3Var = kVar.s;
        if (i3Var != null) {
            i3Var.setIsMuted(z);
        }
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMNativeAd
    public final void unregisterView() {
        this.c.getClass();
    }

    public final void a(String str, String str2, String str3, AdError adError) {
        a aVar = this.a;
        aVar.a = this.b;
        a.a(aVar, str, str2, adError);
        com.smartdigimkt.e1.g gVar = this.b;
        com.smartdigimkt.r4.w.a(gVar != null ? gVar.l : null, str, str2, str3);
    }
}
