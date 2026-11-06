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
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.r;
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
    private static Map<String, b> g = new ConcurrentHashMap(3);
    private View b;
    private AtomicBoolean c = new AtomicBoolean(false);
    private Context d;
    private String e;
    private final com.anythink.core.common.f f;
    private a h;

    private static void b() {
    }

    private static void c() {
    }

    private static void d() {
    }

    public static b a(Context context, String str) {
        b bVar = g.get(str);
        if (bVar == null) {
            synchronized (b.class) {
                if (bVar == null) {
                    bVar = new b(context, str);
                    g.put(str, bVar);
                }
            }
        }
        return bVar;
    }

    private b(Context context, String str) {
        this.d = context.getApplicationContext();
        this.e = str;
        this.f = com.anythink.core.common.f.a(context, str, "3");
    }

    private void a(Activity activity) {
        if (activity == null) {
            return;
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.d).b(t.b().p());
        String strY = bVarB.y();
        String strX = bVarB.x();
        if (this.b == null) {
            this.b = LayoutInflater.from(activity.getApplicationContext()).inflate(q.a(activity, "interstitial_loading_layout", "layout"), (ViewGroup) null);
        }
        this.b.setOnTouchListener(new AnonymousClass1());
        ImageView imageView = (ImageView) this.b.findViewById(q.a(activity, "interstitial_iv_loading", "id"));
        TextView textView = (TextView) this.b.findViewById(q.a(activity, "interstitial_tv_loading", "id"));
        int iA = q.a((Context) activity, 30.0f);
        imageView.setMinimumWidth(iA);
        imageView.setMinimumHeight(iA);
        int iA2 = q.a((Context) activity, 90.0f);
        imageView.setMaxWidth(iA2);
        imageView.setMaxHeight(iA2);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iA3 = q.a(activity, "interstitial_loading_default", "drawable");
        if (TextUtils.isEmpty(strY)) {
            imageView.setImageResource(iA3);
        } else {
            com.anythink.core.common.res.b.a(activity.getApplicationContext()).a(new com.anythink.core.common.res.e(3, strY), new AnonymousClass2(new WeakReference(imageView), strY, iA3));
        }
        if (!TextUtils.isEmpty(strX)) {
            textView.setText(strX);
        } else {
            textView.setText(q.a(activity, "interstitial_text_loading_default", "string"));
        }
        View view = this.b;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.b, new FrameLayout.LayoutParams(-1, -1));
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
        ar arVar = new ar();
        arVar.a(context);
        arVar.a(aTAdRequest);
        arVar.c = i;
        arVar.d = cVar;
        arVar.f = aTAdMultipleLoadedListener;
        if (map != null) {
            try {
                arVar.g = new HashMap(map);
            } catch (Throwable unused) {
            }
        }
        if (aTAdRequest != null) {
            arVar.l = aTAdRequest.getATAdxBidFloorInfo();
        }
        this.f.b(this.d, "3", this.e, arVar, aVar);
    }

    public final List<ATAdInfo> a(Context context) {
        return this.f.a(context);
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        return this.f.a(context, map);
    }

    private com.anythink.core.common.h.c a(Context context, ae aeVar) {
        return this.f.b(context, false, true, aeVar);
    }

    public final synchronized void a(Activity activity, ATShowConfig aTShowConfig, ATInterstitialListener aTInterstitialListener, ATEventInterface aTEventInterface, Map<String, Object> map, ATNativeAdCustomRender aTNativeAdCustomRender) {
        if (this.c.get()) {
            return;
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
            this.h = null;
        }
        this.h = new a(activity, aTShowConfig, aTInterstitialListener, aTEventInterface, map, aTNativeAdCustomRender, this.e, this);
        ae aeVar = new ae();
        aeVar.a(map);
        com.anythink.core.common.f fVar = this.f;
        if (fVar != null) {
            aeVar.a(fVar.i());
        }
        if (aTShowConfig != null) {
            aeVar.a(aTShowConfig.getATAdInfo());
        }
        a(activity, this.f.b((Context) activity, false, true, aeVar), aTShowConfig, aTInterstitialListener, aTEventInterface, map, aTNativeAdCustomRender);
    }

    public final com.anythink.core.common.f a() {
        return this.f;
    }

    public final void a(final Activity activity, final com.anythink.core.common.h.c cVar, final ATShowConfig aTShowConfig, final ATInterstitialListener aTInterstitialListener, final ATEventInterface aTEventInterface, final Map<String, Object> map, final ATNativeAdCustomRender aTNativeAdCustomRender) {
        if (cVar != null && (cVar.e() instanceof CustomInterstitialAdapter)) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f.a(cVar);
            cVar.a(cVar.c() + 1);
            final int iAq = cVar.e().getUnitGroupInfo().aq();
            if (iAq > 0) {
                this.c.set(true);
            }
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.interstitial.a.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    String showCustomExt;
                    final String str;
                    final CustomInterstitialAdapter customInterstitialAdapter = (CustomInterstitialAdapter) cVar.e();
                    Activity activity2 = activity;
                    if (activity2 != null) {
                        customInterstitialAdapter.refreshActivityContext(activity2);
                    }
                    final n trackingInfo = cVar.e().getTrackingInfo();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ATShowConfig aTShowConfig2 = aTShowConfig;
                    if (aTShowConfig2 != null) {
                        String scenarioId = aTShowConfig2.getScenarioId();
                        showCustomExt = aTShowConfig.getShowCustomExt();
                        r.a(aTShowConfig.getATCustomContentResult(), trackingInfo);
                        str = scenarioId;
                    } else {
                        showCustomExt = "";
                        str = showCustomExt;
                    }
                    if (trackingInfo != null) {
                        trackingInfo.F = str;
                        trackingInfo.z(showCustomExt);
                        trackingInfo.n(p.a(trackingInfo.aJ(), trackingInfo.M(), jCurrentTimeMillis));
                        aj.a(b.this.d, trackingInfo);
                        aj.a((Map<String, Object>) map, trackingInfo);
                        aj.a(b.this.e, trackingInfo);
                    }
                    com.anythink.core.common.a.a().a(b.this.d, cVar);
                    com.anythink.core.common.u.c.a(b.this.d).a(13, trackingInfo, cVar.e().getUnitGroupInfo(), jCurrentTimeMillis);
                    com.anythink.core.common.v.d.a().a(trackingInfo, cVar.e().getUnitGroupInfo(), com.anythink.core.common.v.d.b);
                    if (iAq > 0) {
                        t.b().b(new Runnable() { // from class: com.anythink.interstitial.a.b.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.a(b.this, activity);
                            }
                        });
                    }
                    t.b().a(new Runnable() { // from class: com.anythink.interstitial.a.b.3.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            customInterstitialAdapter.setScenario(str);
                            s sVarC = t.b().c();
                            if (sVarC != null) {
                                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                                customInterstitialAdapter2.setAdDownloadListener(sVarC.createDataFetchListener(customInterstitialAdapter2, null, aTEventInterface));
                            }
                            f fVar = new f(customInterstitialAdapter, aTInterstitialListener, b.this.h);
                            if (customInterstitialAdapter.isMixNative()) {
                                b.a(b.this, customInterstitialAdapter, activity, fVar, cVar, trackingInfo, str, aTNativeAdCustomRender);
                            } else if (customInterstitialAdapter.isMixSplash()) {
                                b.a(b.this, activity, customInterstitialAdapter, fVar);
                            } else {
                                customInterstitialAdapter.internalShow(activity, null, new c(fVar));
                            }
                            n trackingInfo2 = customInterstitialAdapter.getTrackingInfo();
                            com.anythink.core.common.u.e.a("4", trackingInfo2, trackingInfo2.aJ(), trackingInfo2.aI(), trackingInfo2.M(), trackingInfo2.Y(), 4, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (iAq <= 0 || !b.this.c.get()) {
                                return;
                            }
                            if (b.this.b != null) {
                                ((ViewGroup) b.this.b.getParent()).removeView(b.this.b);
                            }
                            b.this.c.set(false);
                        }
                    }, iAq);
                }
            });
            return;
        }
        if (this.f.a((ATAdStatusInfo) null, 7)) {
            a(t.b().M(), 7, (com.anythink.core.common.d.a) null, (com.anythink.core.common.d.c) null, (ATAdMultipleLoadedListener) null, map, (ATAdRequest) null);
        }
    }

    private ae a(ATShowConfig aTShowConfig, Map<String, Object> map) {
        ae aeVar = new ae();
        aeVar.a(map);
        com.anythink.core.common.f fVar = this.f;
        if (fVar != null) {
            aeVar.a(fVar.i());
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
        com.anythink.core.common.l.c.a.a aVarA = com.anythink.basead.mixad.b.b.a(customInterstitialAdapter, new com.anythink.core.common.l.d.a.C0085a().a(activity).a(baseAdF).a(nVar).a(aTNativeAdCustomRender).a(new AnonymousClass4(cVar, fVar)).a());
        if (!(aVarA instanceof com.anythink.core.common.l.c.a.c)) {
            if (fVar != null) {
                fVar.onInterstitialAdVideoError("", "create interstitial bridge with unknow error.");
                return;
            }
            return;
        }
        com.anythink.core.basead.b.c cVar2 = new com.anythink.core.basead.b.c();
        String strA = (nVar == null || this.f == null) ? "" : com.anythink.core.common.f.a(nVar.aI(), nVar.M(), String.valueOf(nVar.Y()));
        if (TextUtils.isEmpty(strA)) {
            if (fVar != null) {
                fVar.onInterstitialAdVideoError("", "create interstitial bridge with error: eventId is empty.");
            }
        } else {
            cVar2.d = strA;
            cVar2.e = m.f(activity);
            cVar2.b = str;
            cVar2.a = Integer.parseInt("3");
            ((com.anythink.core.common.l.c.a.c) aVarA).a(activity, cVar2, new AnonymousClass5(customInterstitialAdapter));
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.b$4, reason: invalid class name */
    final class AnonymousClass4 extends com.anythink.core.common.l.e.a {
        final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(com.anythink.core.common.h.c cVar, f fVar) {
            super(cVar);
            this.a = fVar;
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onAdImpressed() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdShow();
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onAdClicked(View view) {
            super.onAdClicked(view);
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdClicked();
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onAdVideoStart() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdVideoStart();
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onAdVideoEnd() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onVideoError(String str, String str2) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdVideoError(str, str2);
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onClose() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onInterstitialAdClose();
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onDeeplinkCallback(boolean z) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onDeeplinkCallback(z);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.b$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.core.common.l.e.a.a.InterfaceC0086a {
        final /* synthetic */ CustomInterstitialAdapter a;

        AnonymousClass5(CustomInterstitialAdapter customInterstitialAdapter) {
            this.a = customInterstitialAdapter;
        }

        @Override // com.anythink.core.common.l.e.a.a.InterfaceC0086a
        public final void a(Activity activity) {
            if (b.this.h != null) {
                b.this.h.a(this.a, activity);
            }
        }
    }

    private void a(Activity activity, CustomInterstitialAdapter customInterstitialAdapter, f fVar) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        bv unitGroupInfo = customInterstitialAdapter.getUnitGroupInfo();
        if (unitGroupInfo == null) {
            return;
        }
        com.anythink.core.common.l.c.a.a aVarA = com.anythink.basead.mixad.b.b.a(customInterstitialAdapter, null);
        if (aVarA instanceof com.anythink.core.common.l.c.a.c) {
            cVar.d = com.anythink.core.common.f.a(this.e, unitGroupInfo.z(), String.valueOf(unitGroupInfo.g()));
            ((com.anythink.core.common.l.c.a.c) aVarA).a(activity, cVar, new AnonymousClass6(customInterstitialAdapter, fVar));
        } else if (fVar != null) {
            fVar.onInterstitialAdVideoError("", "create interstitial bridge with unknow error.");
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.b$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.core.common.l.f.a.a.InterfaceC0087a {
        final /* synthetic */ CustomInterstitialAdapter a;
        final /* synthetic */ f b;

        AnonymousClass6(CustomInterstitialAdapter customInterstitialAdapter, f fVar) {
            this.a = customInterstitialAdapter;
            this.b = fVar;
        }

        @Override // com.anythink.core.common.l.f.a.a.InterfaceC0087a
        public final void a(final Activity activity, ViewGroup viewGroup) {
            if (b.this.h != null) {
                b.this.h.a(this.a, activity);
            }
            this.a.internalShow(activity, viewGroup, new c(this.b) { // from class: com.anythink.interstitial.a.b.6.1
                @Override // com.anythink.interstitial.a.c, com.anythink.core.api.ATCommonImpressionListener
                public final void onAdDismiss() {
                    t.b().b(new Runnable() { // from class: com.anythink.interstitial.a.b.6.1.1
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

    static /* synthetic */ void a(b bVar, Activity activity) {
        if (activity != null) {
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(bVar.d).b(t.b().p());
            String strY = bVarB.y();
            String strX = bVarB.x();
            if (bVar.b == null) {
                bVar.b = LayoutInflater.from(activity.getApplicationContext()).inflate(q.a(activity, "interstitial_loading_layout", "layout"), (ViewGroup) null);
            }
            bVar.b.setOnTouchListener(bVar.new AnonymousClass1());
            ImageView imageView = (ImageView) bVar.b.findViewById(q.a(activity, "interstitial_iv_loading", "id"));
            TextView textView = (TextView) bVar.b.findViewById(q.a(activity, "interstitial_tv_loading", "id"));
            int iA = q.a((Context) activity, 30.0f);
            imageView.setMinimumWidth(iA);
            imageView.setMinimumHeight(iA);
            int iA2 = q.a((Context) activity, 90.0f);
            imageView.setMaxWidth(iA2);
            imageView.setMaxHeight(iA2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iA3 = q.a(activity, "interstitial_loading_default", "drawable");
            if (TextUtils.isEmpty(strY)) {
                imageView.setImageResource(iA3);
            } else {
                com.anythink.core.common.res.b.a(activity.getApplicationContext()).a(new com.anythink.core.common.res.e(3, strY), bVar.new AnonymousClass2(new WeakReference(imageView), strY, iA3));
            }
            if (!TextUtils.isEmpty(strX)) {
                textView.setText(strX);
            } else {
                textView.setText(q.a(activity, "interstitial_text_loading_default", "string"));
            }
            View view = bVar.b;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) bVar.b.getParent()).removeView(bVar.b);
            }
            ((ViewGroup) activity.getWindow().getDecorView()).addView(bVar.b, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    static /* synthetic */ void a(b bVar, CustomInterstitialAdapter customInterstitialAdapter, Activity activity, f fVar, com.anythink.core.common.h.c cVar, n nVar, String str, ATNativeAdCustomRender aTNativeAdCustomRender) {
        BaseAd baseAdF = cVar.f();
        if (baseAdF == null) {
            fVar.onInterstitialAdVideoError("", "showThirdPartyNativeInterstitial fail, no ad cache.");
            return;
        }
        com.anythink.core.common.l.c.a.a aVarA = com.anythink.basead.mixad.b.b.a(customInterstitialAdapter, new com.anythink.core.common.l.d.a.C0085a().a(activity).a(baseAdF).a(nVar).a(aTNativeAdCustomRender).a(bVar.new AnonymousClass4(cVar, fVar)).a());
        if (aVarA instanceof com.anythink.core.common.l.c.a.c) {
            com.anythink.core.basead.b.c cVar2 = new com.anythink.core.basead.b.c();
            String strA = (nVar == null || bVar.f == null) ? "" : com.anythink.core.common.f.a(nVar.aI(), nVar.M(), String.valueOf(nVar.Y()));
            if (TextUtils.isEmpty(strA)) {
                fVar.onInterstitialAdVideoError("", "create interstitial bridge with error: eventId is empty.");
                return;
            }
            cVar2.d = strA;
            cVar2.e = m.f(activity);
            cVar2.b = str;
            cVar2.a = Integer.parseInt("3");
            ((com.anythink.core.common.l.c.a.c) aVarA).a(activity, cVar2, bVar.new AnonymousClass5(customInterstitialAdapter));
            return;
        }
        fVar.onInterstitialAdVideoError("", "create interstitial bridge with unknow error.");
    }

    static /* synthetic */ void a(b bVar, Activity activity, CustomInterstitialAdapter customInterstitialAdapter, f fVar) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        bv unitGroupInfo = customInterstitialAdapter.getUnitGroupInfo();
        if (unitGroupInfo != null) {
            com.anythink.core.common.l.c.a.a aVarA = com.anythink.basead.mixad.b.b.a(customInterstitialAdapter, null);
            if (!(aVarA instanceof com.anythink.core.common.l.c.a.c)) {
                fVar.onInterstitialAdVideoError("", "create interstitial bridge with unknow error.");
            } else {
                cVar.d = com.anythink.core.common.f.a(bVar.e, unitGroupInfo.z(), String.valueOf(unitGroupInfo.g()));
                ((com.anythink.core.common.l.c.a.c) aVarA).a(activity, cVar, bVar.new AnonymousClass6(customInterstitialAdapter, fVar));
            }
        }
    }
}
