package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.sdk.mvp.a {
    public KsAdVideoPlayConfig bU;
    public com.kwad.sdk.core.video.videoview.a cq;
    public KSFrameLayout fV;
    public com.kwad.components.ad.interstitial.g.b kO;
    public KsInterstitialAd.AdInteractionListener kQ;
    public com.kwad.components.ad.interstitial.d kW;
    public AdResultData mAdResultData;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public com.kwad.components.ad.interstitial.h.d mk;
    public boolean ml;
    public boolean mm;
    public boolean mn;
    public a mo;
    public com.kwad.components.core.webview.tachikoma.f.g mq;
    public e mr;
    public boolean mv;
    public boolean mw;
    public List<b> mp = new CopyOnWriteArrayList();
    private Handler iK = new Handler(Looper.getMainLooper());
    public volatile boolean mu = false;
    public int mx = -1;
    public List<com.kwad.components.core.video.a.c> mt = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public List<d> f4320ms = new ArrayList();

    public interface a {
        void a(long j, long j2, boolean z);
    }

    public interface b {
        void c(long j, long j2);
    }

    public interface d {
        void eb();
    }

    public interface e {
        void ec();
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void a(com.kwad.components.core.video.a.c cVar) {
        if (this.mt.contains(cVar)) {
            return;
        }
        this.mt.add(cVar);
    }

    public final void b(com.kwad.components.core.video.a.c cVar) {
        this.mt.remove(cVar);
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.iK.removeCallbacksAndMessages(null);
        this.mt.clear();
        this.f4320ms.clear();
        com.kwad.components.ad.interstitial.g.b bVar = this.kO;
        if (bVar != null) {
            bVar.wj();
        }
    }

    public final boolean a(final C0377c c0377c) {
        com.kwad.components.ad.interstitial.report.a.eO().a(this.mAdTemplate, 1L, c0377c.mI);
        boolean z = c0377c.dW() == 1;
        boolean z2 = com.kwad.components.ad.interstitial.b.b.dK() || z || c0377c.dY() || c0377c.mM;
        if (z2) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0426a(c0377c.getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(z).az(1).aA(c0377c.mI).A(this.cq.getCurrentPosition()).aB(c0377c.dW()).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.interstitial.f.c.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.b(c0377c);
                    if (c.this.kW == null || !com.kwad.components.ad.interstitial.d.b.t(c.this.mAdTemplate)) {
                        return;
                    }
                    c cVar = c.this;
                    cVar.a(false, -1, cVar.cq);
                    c.this.iK.postDelayed(new bg() { // from class: com.kwad.components.ad.interstitial.f.c.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            c.this.kW.dismiss();
                            c.this.Y();
                        }
                    }, 500L);
                }
            }));
        }
        return z2;
    }

    public final void b(C0377c c0377c) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.f(c0377c.getTouchCoords());
        if (!c0377c.dX() && !c0377c.mJ) {
            c0377c.M(153);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().dd(c0377c.dZ()).f(c0377c.getTouchCoords()).dr(aq.QW() ? 2 : 1).l(c0377c.ea()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar != null) {
            long jA = a(aVar);
            int iB = b(this.cq);
            bVar.aw(jA);
            bVar.dl(iB);
        }
        this.ml = true;
        c(1L, c0377c.mI);
    }

    public final void a(final Context context, final int i, int i2, int i3) {
        com.kwad.components.ad.interstitial.report.a.eO().a(this.mAdTemplate, 6L, i);
        final int i4 = 9;
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0426a(context).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aB(2).az(6).aA(i).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.interstitial.f.c.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c cVar = c.this;
                int i5 = i4;
                int i6 = i;
                cVar.a(i5, i6, context, 6L, i6);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Context context, long j, long j2) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().dk(i).dd(i2).dr(aq.QW() ? 2 : 1).EM(), (JSONObject) null);
        this.ml = true;
        c(j, j2);
    }

    public final void Y() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kQ;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.mp.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.mp.remove(bVar);
    }

    public final void c(long j, long j2) {
        Iterator<b> it = this.mp.iterator();
        while (it.hasNext()) {
            it.next().c(j, j2);
        }
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kQ;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        a aVar = this.mo;
        if (aVar != null) {
            aVar.a(j, j2, true);
        }
    }

    public final void dT() {
        e eVar = this.mr;
        if (eVar != null) {
            eVar.ec();
        }
    }

    public final void dU() {
        Iterator<d> it = this.f4320ms.iterator();
        while (it.hasNext()) {
            it.next().eb();
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.aW(adInfo) && !aq.QW();
    }

    public final boolean M(Context context) {
        if (this.mAdTemplate == null || context == null) {
            com.kwad.sdk.core.d.c.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
            return false;
        }
        return com.kwad.sdk.core.response.b.a.bK(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.bu(adInfo).getUrl();
        if (bp.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass3(context, view));
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.f.c$3, reason: invalid class name */
    final class AnonymousClass3 implements ImageLoadingListener {
        final /* synthetic */ Context dq;
        final /* synthetic */ View eu;

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }

        AnonymousClass3(Context context, View view) {
            this.dq = context;
            this.eu = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            h.execute(new bg() { // from class: com.kwad.components.ad.interstitial.f.c.3.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap bitmapStackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass3.this.dq.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    final RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(AnonymousClass3.this.dq.getResources(), bitmapStackBlur);
                    roundedBitmapDrawableCreate.setCornerRadius(dimension);
                    AnonymousClass3.this.eu.post(new bg() { // from class: com.kwad.components.ad.interstitial.f.c.3.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            AnonymousClass3.this.eu.setBackground(roundedBitmapDrawableCreate);
                        }
                    });
                }
            });
        }
    }

    public final boolean dV() {
        com.kwad.components.ad.interstitial.h.d dVar = this.mk;
        boolean z = dVar == null || dVar.getParent() == null;
        com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }

    public final void c(Context context, AdTemplate adTemplate) {
        if (this.mu) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.mu = true;
    }

    public final void a(boolean z, int i, com.kwad.sdk.core.video.videoview.a aVar) {
        long jA;
        int iA;
        com.kwad.components.ad.interstitial.report.a.eO().a(this.mAdTemplate, bz.k(this.fV, true));
        if (aVar != null) {
            jA = a(aVar);
            iA = b(aVar);
        } else {
            jA = i;
            iA = a(jA, this.mAdTemplate);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, z ? 14 : 1, jA, iA, this.kW.getTimerHelper().getTime(), null);
    }

    private static long a(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    private static int b(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((currentPosition / duration) * 100.0f);
        }
        return -1;
    }

    private static int a(long j, AdTemplate adTemplate) {
        if (j == -1) {
            return -1;
        }
        float fM = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.el(adTemplate)) / 1000.0f;
        if (fM != 0.0f) {
            return Math.round((j / fM) * 100.0f);
        }
        return -1;
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.f.c$c, reason: collision with other inner class name */
    public static class C0377c {
        private final Context context;
        private int mG;
        private boolean mH;
        private int mI;
        private boolean mJ;
        private aj.a mK;
        public double mL;
        public boolean mM;

        public C0377c(Context context) {
            this.context = context;
        }

        public final Context getContext() {
            return this.context;
        }

        public final int dW() {
            return this.mG;
        }

        public final C0377c L(int i) {
            this.mG = i;
            return this;
        }

        public final boolean dX() {
            return this.mH;
        }

        public final C0377c l(boolean z) {
            this.mH = z;
            return this;
        }

        public final boolean dY() {
            return this.mJ;
        }

        public final C0377c m(boolean z) {
            this.mJ = true;
            return this;
        }

        public final C0377c n(boolean z) {
            this.mM = true;
            return this;
        }

        public final int dZ() {
            return this.mI;
        }

        public final C0377c M(int i) {
            this.mI = i;
            return this;
        }

        public final aj.a getTouchCoords() {
            return this.mK;
        }

        public final C0377c a(aj.a aVar) {
            this.mK = aVar;
            return this;
        }

        public final double ea() {
            return this.mL;
        }

        public final C0377c c(double d) {
            this.mL = d;
            return this;
        }
    }
}
