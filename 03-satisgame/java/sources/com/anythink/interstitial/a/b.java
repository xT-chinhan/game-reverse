package com.anythink.interstitial.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.api.ATAdCreateConfig;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.r;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.l;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.p;
import com.anythink.core.common.u.q;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String a = "b";
    private static Map<String, b> h = new ConcurrentHashMap(3);
    ATAdCreateConfig b;
    private View c;
    private AtomicBoolean d;
    private Context e;
    private String f;
    private final com.anythink.core.common.f g;
    private a i;

    private static void d() {
    }

    private static void e() {
    }

    private static void f() {
    }

    public static b a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = h.get(str);
        if (bVar == null) {
            synchronized (b.class) {
                if (bVar == null) {
                    bVar = new b(context, str);
                    h.put(str, bVar);
                }
            }
        }
        return bVar;
    }

    private b(Context context, String str) {
        this(context, str, null);
    }

    public b(Context context, String str, ATAdCreateConfig aTAdCreateConfig) {
        this.d = new AtomicBoolean(false);
        this.e = context.getApplicationContext();
        this.f = str;
        this.b = aTAdCreateConfig;
        if (aTAdCreateConfig != null) {
            if (aTAdCreateConfig.isMultiton()) {
                com.anythink.core.common.f fVar = new com.anythink.core.common.f(context, str, "3");
                this.g = fVar;
                fVar.u();
                return;
            }
            this.g = com.anythink.core.common.f.a(context, str, "3");
            return;
        }
        this.g = com.anythink.core.common.f.a(context, str, "3");
    }

    private void a(Activity activity) {
        if (activity == null) {
            return;
        }
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.e).b(s.b().p());
        String strQ = bVarB.q();
        String strP = bVarB.p();
        if (this.c == null) {
            this.c = LayoutInflater.from(activity.getApplicationContext()).inflate(p.a(activity, "interstitial_loading_layout", "layout"), (ViewGroup) null);
        }
        this.c.setOnTouchListener(new AnonymousClass1());
        ImageView imageView = (ImageView) this.c.findViewById(p.a(activity, "interstitial_iv_loading", "id"));
        TextView textView = (TextView) this.c.findViewById(p.a(activity, "interstitial_tv_loading", "id"));
        int iA = p.a((Context) activity, 30.0f);
        imageView.setMinimumWidth(iA);
        imageView.setMinimumHeight(iA);
        int iA2 = p.a((Context) activity, 90.0f);
        imageView.setMaxWidth(iA2);
        imageView.setMaxHeight(iA2);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iA3 = p.a(activity, "interstitial_loading_default", "drawable");
        if (TextUtils.isEmpty(strQ)) {
            imageView.setImageResource(iA3);
        } else {
            com.anythink.core.common.res.b.a(activity.getApplicationContext()).a(new com.anythink.core.common.res.e(3, strQ), new AnonymousClass2(new WeakReference(imageView), strQ, iA3));
        }
        if (!TextUtils.isEmpty(strP)) {
            textView.setText(strP);
        } else {
            textView.setText(p.a(activity, "interstitial_text_loading_default", "string"));
        }
        View view = this.c;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.b$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }

        AnonymousClass1() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.b$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ WeakReference a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        AnonymousClass2(WeakReference weakReference, String str, int i) {
            this.a = weakReference;
            this.b = str;
            this.c = i;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            ImageView imageView = (ImageView) this.a.get();
            if (!TextUtils.equals(this.b, str) || imageView == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            Log.e(b.a, "load: image load fail:".concat(String.valueOf(str2)));
            ImageView imageView = (ImageView) this.a.get();
            if (!TextUtils.equals(this.b, str) || imageView == null) {
                return;
            }
            imageView.setImageResource(this.c);
        }
    }

    public final void a(Context context, int i, com.anythink.core.common.d.a aVar, com.anythink.core.common.d.c cVar, ATAdMultipleLoadedListener aTAdMultipleLoadedListener, Map<String, Object> map, ATAdRequest aTAdRequest) {
        as asVar = new as();
        asVar.a(context);
        asVar.a(aTAdRequest);
        asVar.c = i;
        asVar.d = cVar;
        asVar.f = aTAdMultipleLoadedListener;
        if (map != null) {
            try {
                asVar.g = new HashMap(map);
            } catch (Throwable unused) {
            }
        }
        if (aTAdRequest != null) {
            asVar.l = aTAdRequest.getATAdxBidFloorInfo();
        }
        this.g.b(this.e, "3", this.f, asVar, aVar);
    }

    public final List<ATAdInfo> a(Context context) {
        return this.g.a(context);
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        return this.g.a(context, map);
    }

    private com.anythink.core.common.h.c a(Context context, ae aeVar) {
        return this.g.b(context, false, true, aeVar);
    }

    public final com.anythink.core.common.h.c a(Map<String, Object> map) {
        ae aeVarA = a((ATShowConfig) null, map);
        aeVarA.f();
        com.anythink.core.common.f fVar = this.g;
        if (fVar != null) {
            return fVar.b(this.e, false, false, aeVarA);
        }
        return null;
    }

    public final synchronized void a(Activity activity, ATShowConfig aTShowConfig, ATInterstitialListener aTInterstitialListener, ATEventInterface aTEventInterface, Map<String, Object> map, ATNativeAdCustomRender aTNativeAdCustomRender) {
        if (this.d.get()) {
            return;
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.a();
            this.i = null;
        }
        this.i = new a(activity, aTShowConfig, aTInterstitialListener, aTEventInterface, map, aTNativeAdCustomRender, this.f, this);
        a(activity, this.g.b((Context) activity, false, true, a(aTShowConfig, map)), aTShowConfig, aTInterstitialListener, aTEventInterface, map, aTNativeAdCustomRender);
    }

    public final boolean a() {
        ATAdCreateConfig aTAdCreateConfig = this.b;
        return aTAdCreateConfig != null && aTAdCreateConfig.isMultiton();
    }

    public final com.anythink.core.common.f b() {
        return this.g;
    }

    public final void a(final Activity activity, final com.anythink.core.common.h.c cVar, final ATShowConfig aTShowConfig, final ATInterstitialListener aTInterstitialListener, final ATEventInterface aTEventInterface, final Map<String, Object> map, final ATNativeAdCustomRender aTNativeAdCustomRender) {
        if (cVar != null && (cVar.e() instanceof CustomInterstitialAdapter)) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.g.a(cVar);
            cVar.a(cVar.c() + 1);
            final int iAy = cVar.e().getUnitGroupInfo().ay();
            if (iAy > 0) {
                this.d.set(true);
            }
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.r, new Runnable() { // from class: com.anythink.interstitial.a.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    final String scenarioId;
                    String showCustomExt;
                    final CustomInterstitialAdapter customInterstitialAdapter = (CustomInterstitialAdapter) cVar.e();
                    Activity activity2 = activity;
                    if (activity2 != null) {
                        customInterstitialAdapter.refreshActivityContext(activity2);
                    }
                    final n trackingInfo = cVar.e().getTrackingInfo();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ATShowConfig aTShowConfig2 = aTShowConfig;
                    if (aTShowConfig2 != null) {
                        scenarioId = aTShowConfig2.getScenarioId();
                        showCustomExt = aTShowConfig.getShowCustomExt();
                        q.a(aTShowConfig.getATCustomContentResult(), trackingInfo);
                    } else {
                        scenarioId = "";
                        showCustomExt = "";
                    }
                    if (trackingInfo != null) {
                        com.anythink.core.common.f fVarA = trackingInfo.a();
                        if (fVarA != null) {
                            trackingInfo.z = fVarA.m();
                        }
                        ai.a(b.this.g.n(), trackingInfo);
                        trackingInfo.H = scenarioId;
                        trackingInfo.y(showCustomExt);
                        trackingInfo.n(o.a(trackingInfo.aR(), trackingInfo.N(), jCurrentTimeMillis));
                        ai.a(b.this.e, trackingInfo);
                        ai.a((Map<String, Object>) map, trackingInfo);
                        ai.a(b.this.f, trackingInfo);
                        if (fVarA != null && fVarA.e() != null) {
                            fVarA.e().a(b.this.e, cVar);
                        }
                    }
                    com.anythink.core.common.t.e.a(b.this.e);
                    com.anythink.core.common.t.e.a(13, trackingInfo, cVar.e().getUnitGroupInfo(), jCurrentTimeMillis);
                    com.anythink.core.common.u.d.a().a(trackingInfo, cVar.e().getUnitGroupInfo(), com.anythink.core.common.u.d.b);
                    if (iAy > 0) {
                        s.b();
                        s.b(new Runnable() { // from class: com.anythink.interstitial.a.b.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.a(b.this, activity);
                            }
                        });
                    }
                    s.b();
                    s.a(new Runnable() { // from class: com.anythink.interstitial.a.b.3.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            customInterstitialAdapter.setScenario(scenarioId);
                            r rVarC = s.b().c();
                            if (rVarC != null) {
                                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                                customInterstitialAdapter2.setAdDownloadListener(rVarC.createDataFetchListener(customInterstitialAdapter2, null, aTEventInterface));
                            }
                            f fVar = new f(customInterstitialAdapter, aTInterstitialListener, b.this.i, b.this.g);
                            if (customInterstitialAdapter.isMixNative()) {
                                b.a(b.this, customInterstitialAdapter, activity, fVar, cVar, trackingInfo, scenarioId, aTNativeAdCustomRender);
                            } else if (customInterstitialAdapter.isMixSplash()) {
                                b.a(b.this, activity, customInterstitialAdapter, fVar);
                            } else {
                                customInterstitialAdapter.internalShow(activity, null, new c(fVar));
                            }
                            n trackingInfo2 = customInterstitialAdapter.getTrackingInfo();
                            com.anythink.core.common.t.f.a("4", trackingInfo2, trackingInfo2.aR(), trackingInfo2.aQ(), trackingInfo2.N(), trackingInfo2.Z(), 4, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (iAy <= 0 || !b.this.d.get()) {
                                return;
                            }
                            if (b.this.c != null) {
                                ((ViewGroup) b.this.c.getParent()).removeView(b.this.c);
                            }
                            b.this.d.set(false);
                        }
                    }, iAy);
                }
            }));
            return;
        }
        if (this.g.a((ATAdStatusInfo) null, 7)) {
            a(s.b().M(), 7, (com.anythink.core.common.d.a) null, (com.anythink.core.common.d.c) null, (ATAdMultipleLoadedListener) null, map, (ATAdRequest) null);
        }
    }

    private ae a(ATShowConfig aTShowConfig, Map<String, Object> map) {
        ae aeVar = new ae();
        aeVar.a(map);
        com.anythink.core.common.f fVar = this.g;
        if (fVar != null) {
            aeVar.a(fVar.n());
        }
        if (aTShowConfig != null) {
            aeVar.a(aTShowConfig.getATAdInfo());
        }
        return aeVar;
    }

    private void a(CustomInterstitialAdapter customInterstitialAdapter, Activity activity, f fVar, com.anythink.core.common.h.c cVar, n nVar, String str, ATNativeAdCustomRender aTNativeAdCustomRender) {
        BaseAd baseAdF = cVar.f();
        if (baseAdF == null) {
            if (fVar != null) {
                fVar.onInterstitialAdVideoError("", "showThirdPartyNativeInterstitial fail, no ad cache.");
                return;
            }
            return;
        }
        com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customInterstitialAdapter, new com.anythink.core.common.k.d.a.C0028a().a(activity).a(baseAdF).a(nVar).a(aTNativeAdCustomRender).a(new AnonymousClass4(cVar, fVar)).a());
        if (!(aVarA instanceof com.anythink.core.common.k.c.a.c)) {
            if (fVar != null) {
                fVar.onInterstitialAdVideoError("", "create interstitial bridge with unknow error.");
                return;
            }
            return;
        }
        com.anythink.core.basead.b.c cVar2 = new com.anythink.core.basead.b.c();
        String strA = (nVar == null || this.g == null) ? "" : com.anythink.core.common.f.a(nVar.aQ(), nVar.N(), String.valueOf(nVar.Z()));
        if (TextUtils.isEmpty(strA)) {
            if (fVar != null) {
                fVar.onInterstitialAdVideoError("", "create interstitial bridge with error: eventId is empty.");
            }
        } else {
            cVar2.d = strA;
            cVar2.e = l.f(activity);
            cVar2.b = str;
            cVar2.a = Integer.parseInt("3");
            ((com.anythink.core.common.k.c.a.c) aVarA).a(activity, cVar2, new AnonymousClass5(customInterstitialAdapter));
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.b$4, reason: invalid class name */
    final class AnonymousClass4 extends com.anythink.core.common.k.e.a {
        final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(com.anythink.core.common.h.c cVar, f fVar) {
            super(cVar);
            this.a = fVar;
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdImpressed() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdShow();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdClicked(View view) {
            super.onAdClicked(view);
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdClicked();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdVideoStart() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdVideoStart();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdVideoEnd() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onVideoError(String str, String str2) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdVideoError(str, str2);
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onClose() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdClose();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onDeeplinkCallback(boolean z) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onDeeplinkCallback(z);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.b$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.core.common.k.e.a.a.InterfaceC0029a {
        final /* synthetic */ CustomInterstitialAdapter a;

        AnonymousClass5(CustomInterstitialAdapter customInterstitialAdapter) {
            this.a = customInterstitialAdapter;
        }

        @Override // com.anythink.core.common.k.e.a.a.InterfaceC0029a
        public final void a(Activity activity) {
            if (b.this.i != null) {
                b.this.i.a(this.a, activity);
            }
        }
    }

    private void a(Activity activity, CustomInterstitialAdapter customInterstitialAdapter, f fVar) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        by unitGroupInfo = customInterstitialAdapter.getUnitGroupInfo();
        if (unitGroupInfo == null) {
            return;
        }
        com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customInterstitialAdapter, null);
        if (aVarA instanceof com.anythink.core.common.k.c.a.c) {
            cVar.d = com.anythink.core.common.f.a(this.f, unitGroupInfo.G(), String.valueOf(unitGroupInfo.n()));
            ((com.anythink.core.common.k.c.a.c) aVarA).a(activity, cVar, new AnonymousClass6(customInterstitialAdapter, fVar));
        } else if (fVar != null) {
            fVar.onInterstitialAdVideoError("", "create interstitial bridge with unknow error.");
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.b$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.core.common.k.f.a.a.InterfaceC0030a {
        final /* synthetic */ CustomInterstitialAdapter a;
        final /* synthetic */ f b;

        AnonymousClass6(CustomInterstitialAdapter customInterstitialAdapter, f fVar) {
            this.a = customInterstitialAdapter;
            this.b = fVar;
        }

        @Override // com.anythink.core.common.k.f.a.a.InterfaceC0030a
        public final void a(final Activity activity, ViewGroup viewGroup) {
            if (b.this.i != null) {
                b.this.i.a(this.a, activity);
            }
            this.a.internalShow(activity, viewGroup, new c(this.b) { // from class: com.anythink.interstitial.a.b.6.1
                @Override // com.anythink.interstitial.a.c, com.anythink.core.api.ATCommonImpressionListener
                public final void onAdDismiss() {
                    s.b();
                    s.b(new Runnable() { // from class: com.anythink.interstitial.a.b.6.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (activity.isFinishing()) {
                                return;
                            }
                            activity.finish();
                            activity.overridePendingTransition(0, 0);
                        }
                    });
                    super.onAdDismiss();
                }
            });
        }
    }

    public final void a(int i) {
        com.anythink.core.common.f fVar = this.g;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    public final void a(List<ATAdInfo> list) {
        com.anythink.core.common.f fVar = this.g;
        if (fVar != null) {
            fVar.a(list);
        }
    }

    public final void b(Map<String, Object> map) {
        com.anythink.core.common.f fVar = this.g;
        if (fVar != null) {
            fVar.a(map);
        }
    }

    public final void c() {
        com.anythink.core.common.f fVar;
        ATAdCreateConfig aTAdCreateConfig = this.b;
        if (aTAdCreateConfig == null || !aTAdCreateConfig.isMultiton() || (fVar = this.g) == null) {
            return;
        }
        fVar.p();
    }

    public final void c(Map<String, Object> map) {
        com.anythink.core.common.f fVar = this.g;
        if (fVar != null) {
            fVar.b(map);
        }
    }

    static /* synthetic */ void a(b bVar, Activity activity) {
        if (activity != null) {
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(bVar.e).b(s.b().p());
            String strQ = bVarB.q();
            String strP = bVarB.p();
            if (bVar.c == null) {
                bVar.c = LayoutInflater.from(activity.getApplicationContext()).inflate(p.a(activity, "interstitial_loading_layout", "layout"), (ViewGroup) null);
            }
            bVar.c.setOnTouchListener(bVar.new AnonymousClass1());
            ImageView imageView = (ImageView) bVar.c.findViewById(p.a(activity, "interstitial_iv_loading", "id"));
            TextView textView = (TextView) bVar.c.findViewById(p.a(activity, "interstitial_tv_loading", "id"));
            int iA = p.a((Context) activity, 30.0f);
            imageView.setMinimumWidth(iA);
            imageView.setMinimumHeight(iA);
            int iA2 = p.a((Context) activity, 90.0f);
            imageView.setMaxWidth(iA2);
            imageView.setMaxHeight(iA2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iA3 = p.a(activity, "interstitial_loading_default", "drawable");
            if (TextUtils.isEmpty(strQ)) {
                imageView.setImageResource(iA3);
            } else {
                com.anythink.core.common.res.b.a(activity.getApplicationContext()).a(new com.anythink.core.common.res.e(3, strQ), bVar.new AnonymousClass2(new WeakReference(imageView), strQ, iA3));
            }
            if (!TextUtils.isEmpty(strP)) {
                textView.setText(strP);
            } else {
                textView.setText(p.a(activity, "interstitial_text_loading_default", "string"));
            }
            View view = bVar.c;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) bVar.c.getParent()).removeView(bVar.c);
            }
            ((ViewGroup) activity.getWindow().getDecorView()).addView(bVar.c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    static /* synthetic */ void a(b bVar, CustomInterstitialAdapter customInterstitialAdapter, Activity activity, f fVar, com.anythink.core.common.h.c cVar, n nVar, String str, ATNativeAdCustomRender aTNativeAdCustomRender) {
        BaseAd baseAdF = cVar.f();
        if (baseAdF == null) {
            fVar.onInterstitialAdVideoError("", "showThirdPartyNativeInterstitial fail, no ad cache.");
            return;
        }
        com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customInterstitialAdapter, new com.anythink.core.common.k.d.a.C0028a().a(activity).a(baseAdF).a(nVar).a(aTNativeAdCustomRender).a(bVar.new AnonymousClass4(cVar, fVar)).a());
        if (aVarA instanceof com.anythink.core.common.k.c.a.c) {
            com.anythink.core.basead.b.c cVar2 = new com.anythink.core.basead.b.c();
            String strA = (nVar == null || bVar.g == null) ? "" : com.anythink.core.common.f.a(nVar.aQ(), nVar.N(), String.valueOf(nVar.Z()));
            if (TextUtils.isEmpty(strA)) {
                fVar.onInterstitialAdVideoError("", "create interstitial bridge with error: eventId is empty.");
                return;
            }
            cVar2.d = strA;
            cVar2.e = l.f(activity);
            cVar2.b = str;
            cVar2.a = Integer.parseInt("3");
            ((com.anythink.core.common.k.c.a.c) aVarA).a(activity, cVar2, bVar.new AnonymousClass5(customInterstitialAdapter));
            return;
        }
        fVar.onInterstitialAdVideoError("", "create interstitial bridge with unknow error.");
    }

    static /* synthetic */ void a(b bVar, Activity activity, CustomInterstitialAdapter customInterstitialAdapter, f fVar) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        by unitGroupInfo = customInterstitialAdapter.getUnitGroupInfo();
        if (unitGroupInfo != null) {
            com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customInterstitialAdapter, null);
            if (!(aVarA instanceof com.anythink.core.common.k.c.a.c)) {
                fVar.onInterstitialAdVideoError("", "create interstitial bridge with unknow error.");
            } else {
                cVar.d = com.anythink.core.common.f.a(bVar.f, unitGroupInfo.G(), String.valueOf(unitGroupInfo.n()));
                ((com.anythink.core.common.k.c.a.c) aVarA).a(activity, cVar, bVar.new AnonymousClass6(customInterstitialAdapter, fVar));
            }
        }
    }
}
