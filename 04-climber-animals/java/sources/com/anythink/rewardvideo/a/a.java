package com.anythink.rewardvideo.a;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.r;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "a";
    private static Map<String, a> e = new ConcurrentHashMap(3);
    private Context b;
    private String c;
    private final com.anythink.core.common.f d;

    public static a a(Context context, String str) {
        a aVar = e.get(str);
        if (aVar == null) {
            synchronized (a.class) {
                if (aVar == null) {
                    aVar = new a(context, str);
                    e.put(str, aVar);
                }
            }
        }
        return aVar;
    }

    private a(Context context, String str) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.d = com.anythink.core.common.f.a(context, str, "1");
    }

    public final synchronized void a(final Activity activity, final ATShowConfig aTShowConfig, final ATRewardVideoListener aTRewardVideoListener, final ATEventInterface aTEventInterface, final Map<String, Object> map) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ae aeVar = new ae();
        aeVar.a(map);
        if (aTShowConfig != null) {
            aeVar.a(aTShowConfig.getATAdInfo());
        }
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            aeVar.a(fVar.i());
        }
        final com.anythink.core.common.h.c cVarB = this.d.b((Context) activity, false, true, aeVar);
        if (cVarB != null && (cVarB.e() instanceof CustomRewardVideoAdapter)) {
            this.d.a(cVarB);
            cVarB.a(cVarB.c() + 1);
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    String showCustomExt;
                    final String str;
                    n trackingInfo = cVarB.e().getTrackingInfo();
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
                        aj.a(a.this.b, trackingInfo);
                        aj.a((Map<String, Object>) map, trackingInfo);
                        aj.a(a.this.c, trackingInfo);
                    }
                    com.anythink.core.common.a.a().a(a.this.b, cVarB);
                    com.anythink.core.common.u.c.a(a.this.b).a(13, trackingInfo, cVarB.e().getUnitGroupInfo(), jCurrentTimeMillis);
                    com.anythink.core.common.v.d.a().a(trackingInfo, cVarB.e().getUnitGroupInfo(), com.anythink.core.common.v.d.b);
                    final CustomRewardVideoAdapter customRewardVideoAdapter = (CustomRewardVideoAdapter) cVarB.e();
                    Activity activity2 = activity;
                    if (activity2 != null) {
                        customRewardVideoAdapter.refreshActivityContext(activity2);
                    }
                    t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            customRewardVideoAdapter.setScenario(str);
                            s sVarC = t.b().c();
                            if (sVarC != null) {
                                CustomRewardVideoAdapter customRewardVideoAdapter2 = customRewardVideoAdapter;
                                customRewardVideoAdapter2.setAdDownloadListener(sVarC.createDataFetchListener(customRewardVideoAdapter2, null, aTEventInterface));
                            }
                            if (customRewardVideoAdapter.isMixSplash()) {
                                a.a(a.this, activity, customRewardVideoAdapter, aTRewardVideoListener);
                            } else {
                                CustomRewardVideoAdapter customRewardVideoAdapter3 = customRewardVideoAdapter;
                                Activity activity3 = activity;
                                CustomRewardVideoAdapter customRewardVideoAdapter4 = customRewardVideoAdapter;
                                t.b();
                                customRewardVideoAdapter3.internalShow(activity3, null, new e(new f(customRewardVideoAdapter4, t.G(), aTRewardVideoListener), customRewardVideoAdapter.isMixFormatAd(), customRewardVideoAdapter.getAdRewardCallbackType()));
                            }
                            n trackingInfo2 = customRewardVideoAdapter.getTrackingInfo();
                            com.anythink.core.common.u.e.a("4", trackingInfo2, trackingInfo2.aJ(), trackingInfo2.aI(), trackingInfo2.M(), trackingInfo2.Y(), 4, SystemClock.elapsedRealtime() - jElapsedRealtime);
                        }
                    });
                }
            });
        } else {
            if (this.d.a((ATAdStatusInfo) null, 7)) {
                a(t.b().M(), 7, null, null, null, map, null);
            }
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noADError, "", "No Cache.");
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, l.a((com.anythink.core.common.d.f) null));
            }
        }
    }

    private ae a(ATShowConfig aTShowConfig, Map<String, Object> map) {
        ae aeVar = new ae();
        aeVar.a(map);
        if (aTShowConfig != null) {
            aeVar.a(aTShowConfig.getATAdInfo());
        }
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            aeVar.a(fVar.i());
        }
        return aeVar;
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
        this.d.b(this.b, "1", this.c, arVar, aVar);
    }

    public final List<ATAdInfo> a(Context context) {
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            return fVar.a(context);
        }
        return null;
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            return fVar.a(context, map);
        }
        return null;
    }

    private void a(Activity activity, CustomRewardVideoAdapter customRewardVideoAdapter, ATRewardVideoListener aTRewardVideoListener) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        bv unitGroupInfo = customRewardVideoAdapter.getUnitGroupInfo();
        if (unitGroupInfo == null) {
            return;
        }
        com.anythink.core.common.l.c.a.a aVarA = com.anythink.basead.mixad.b.b.a(customRewardVideoAdapter, null);
        if (!(aVarA instanceof com.anythink.core.common.l.c.a.e)) {
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noADError, "", "create reward video bridge with unknow error.");
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, l.a((com.anythink.core.common.d.f) null));
                return;
            }
            return;
        }
        cVar.d = com.anythink.core.common.f.a(this.c, unitGroupInfo.z(), String.valueOf(unitGroupInfo.g()));
        ((com.anythink.core.common.l.c.a.e) aVarA).a(activity, cVar, new AnonymousClass2(customRewardVideoAdapter, aTRewardVideoListener, activity));
    }

    /* JADX INFO: renamed from: com.anythink.rewardvideo.a.a$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.l.f.a.a.InterfaceC0087a {
        final /* synthetic */ CustomRewardVideoAdapter a;
        final /* synthetic */ ATRewardVideoListener b;
        final /* synthetic */ Activity c;

        AnonymousClass2(CustomRewardVideoAdapter customRewardVideoAdapter, ATRewardVideoListener aTRewardVideoListener, Activity activity) {
            this.a = customRewardVideoAdapter;
            this.b = aTRewardVideoListener;
            this.c = activity;
        }

        @Override // com.anythink.core.common.l.f.a.a.InterfaceC0087a
        public final void a(final Activity activity, ViewGroup viewGroup) {
            CustomRewardVideoAdapter customRewardVideoAdapter = this.a;
            CustomRewardVideoAdapter customRewardVideoAdapter2 = this.a;
            t.b();
            customRewardVideoAdapter.internalShow(activity, viewGroup, new e(new f(customRewardVideoAdapter2, t.G(), this.b), this.a.isMixFormatAd(), this.a.getAdRewardCallbackType()) { // from class: com.anythink.rewardvideo.a.a.2.1
                @Override // com.anythink.rewardvideo.a.d, com.anythink.core.api.ATCommonImpressionListener
                public final void onAdDismiss() {
                    t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.a.a.2.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (AnonymousClass2.this.c.isFinishing()) {
                                return;
                            }
                            activity.finish();
                        }
                    });
                    super.onAdDismiss();
                }
            });
        }
    }

    static /* synthetic */ void a(a aVar, Activity activity, CustomRewardVideoAdapter customRewardVideoAdapter, ATRewardVideoListener aTRewardVideoListener) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        bv unitGroupInfo = customRewardVideoAdapter.getUnitGroupInfo();
        if (unitGroupInfo != null) {
            com.anythink.core.common.l.c.a.a aVarA = com.anythink.basead.mixad.b.b.a(customRewardVideoAdapter, null);
            if (!(aVarA instanceof com.anythink.core.common.l.c.a.e)) {
                AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noADError, "", "create reward video bridge with unknow error.");
                if (aTRewardVideoListener != null) {
                    aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, l.a((com.anythink.core.common.d.f) null));
                    return;
                }
                return;
            }
            cVar.d = com.anythink.core.common.f.a(aVar.c, unitGroupInfo.z(), String.valueOf(unitGroupInfo.g()));
            ((com.anythink.core.common.l.c.a.e) aVarA).a(activity, cVar, aVar.new AnonymousClass2(customRewardVideoAdapter, aTRewardVideoListener, activity));
        }
    }
}
