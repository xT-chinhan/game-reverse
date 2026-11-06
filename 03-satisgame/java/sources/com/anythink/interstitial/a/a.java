package com.anythink.interstitial.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.p;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String b = "a";
    private static final int c = 1;
    private static final int d = 2;
    ATNativeAdCustomRender a;
    private final WeakReference<Activity> e;
    private final String f;
    private final ATShowConfig g;
    private final ATInterstitialListener h;
    private final ATEventInterface i;
    private final Map<String, Object> j;
    private final b k;
    private CustomInterstitialAdapter l;
    private com.anythink.core.common.h.c m;
    private volatile int p;
    private int u;
    private volatile int n = 0;
    private volatile int o = 1;
    private final List<Integer> q = Arrays.asList(8, 15, 22, 28);
    private final List<CustomInterstitialAdapter> r = new ArrayList();
    private final List<CustomInterstitialAdapter> s = new ArrayList();
    private final Map<CustomInterstitialAdapter, WeakReference<Activity>> t = new HashMap();
    private volatile int v = 3;
    private volatile int w = -1;
    private final Handler x = new Handler(Looper.getMainLooper()) { // from class: com.anythink.interstitial.a.a.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                aa.b(i.x, "handleMessage:0x002:" + a.this.n);
                if (a.this.n == 1) {
                    if (message.obj instanceof Integer) {
                        try {
                            int iIntValue = ((Integer) message.obj).intValue() / 1000;
                            com.anythink.core.common.h.c cVarI = a.this.i();
                            if (cVarI != null) {
                                a.this.m = cVarI;
                                if (a.this.m.e() != null) {
                                    aa.b(i.x, "handleMessage:nextPlayAdCacheInfo:" + a.this.m.e().getNetworkName());
                                }
                                Context contextG = s.b().g();
                                if (contextG == null) {
                                    contextG = a.this.g();
                                }
                                if (contextG != null) {
                                    String string = "";
                                    try {
                                        string = contextG.getString(p.a(contextG, "interstitial_text_next_play", "string"));
                                    } catch (Exception unused) {
                                    }
                                    a.a(contextG, string, iIntValue);
                                    return;
                                }
                                return;
                            }
                            a.o(a.this);
                            aa.b(i.x, "handleMessage:0x002:There are no ads available for carousel, so the carousel is terminated.");
                            return;
                        } catch (Throwable th) {
                            a.o(a.this);
                            th.printStackTrace();
                            return;
                        }
                    }
                    a.o(a.this);
                    aa.b(i.x, "handleMessage:0x002:msg.obj is not Integer");
                    return;
                }
                aa.b(i.x, "handleMessage:0x002:carouselState!=1");
                return;
            }
            try {
                aa.b(i.x, "handleMessage:0x001:" + a.this.n);
                if (a.this.m == null || !a.this.m.k() || a.this.n != 1) {
                    if (a.this.m != null) {
                        aa.b(i.x, "handleMessage:0x001:nextPlayAdCacheInfo:" + a.this.m.k() + ":carouselState:" + a.this.n);
                    } else {
                        aa.b(i.x, "handleMessage:0x001:nextPlayAdCacheInfo is null and carouselState=" + a.this.n);
                    }
                    a.o(a.this);
                    return;
                }
                if (a.this.o < a.this.p) {
                    String strE = a.e(a.this);
                    if (TextUtils.isEmpty(strE)) {
                        aa.b(i.x, "handleMessage:0x001:close:success");
                        if (a.this.k != null) {
                            ATBaseAdAdapter aTBaseAdAdapterE = a.this.m.e();
                            if (aTBaseAdAdapterE != null) {
                                aa.b(i.x, "handleMessage:0x001:internalShow:" + aTBaseAdAdapterE.getNetworkName());
                                aTBaseAdAdapterE.setCarouselShowType(1);
                            }
                            if (a.this.w > 0) {
                                a.h(a.this);
                            }
                            a.i(a.this);
                            a.this.k.a(a.this.g(), a.this.m, a.this.g, a.this.h, a.this.i, a.this.j, a.this.a);
                            return;
                        }
                        a.o(a.this);
                        return;
                    }
                    a.o(a.this);
                    com.anythink.core.common.t.f.a("1", a.this.l != null ? a.this.l.getTrackingInfo() : null, s.b().W(), strE);
                    aa.b(i.x, "handleMessage:0x001:close is exception:".concat(String.valueOf(strE)));
                    return;
                }
                a.o(a.this);
                aa.b(i.x, "handleMessage:0x001:rotation_num is out");
            } catch (Throwable th2) {
                a.o(a.this);
                th2.printStackTrace();
            }
        }
    };
    private final l y = new l() { // from class: com.anythink.interstitial.a.a.2
        @Override // com.anythink.core.common.d.l
        public final void a(boolean z) {
            aa.b(i.x, "backToForeground:".concat(String.valueOf(z)));
            if (z) {
                return;
            }
            a.o(a.this);
            if (a.this.l == null || a.this.l.getTrackingInfo() == null) {
                return;
            }
            com.anythink.core.common.t.f.a(a.this.l.getTrackingInfo(), String.valueOf(a.this.f()));
        }
    };
    private final Map<CustomInterstitialAdapter, CustomInterstitialEventListener> z = new HashMap();

    static /* synthetic */ String e(a aVar) {
        return aVar.a(1);
    }

    static /* synthetic */ int h(a aVar) {
        int i = aVar.w;
        aVar.w = i - 1;
        return i;
    }

    static /* synthetic */ int i(a aVar) {
        int i = aVar.o;
        aVar.o = i + 1;
        return i;
    }

    static /* synthetic */ int o(a aVar) {
        aVar.n = 2;
        return 2;
    }

    public a(Activity activity, ATShowConfig aTShowConfig, ATInterstitialListener aTInterstitialListener, ATEventInterface aTEventInterface, Map<String, Object> map, ATNativeAdCustomRender aTNativeAdCustomRender, String str, b bVar) {
        this.e = new WeakReference<>(activity);
        this.g = aTShowConfig;
        this.h = aTInterstitialListener;
        this.i = aTEventInterface;
        this.j = map;
        this.a = aTNativeAdCustomRender;
        this.f = str;
        this.k = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity g() {
        Activity activity = this.e.get() != null ? this.e.get() : null;
        return activity == null ? s.b().N() : activity;
    }

    private static void b(Context context, String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Toast.makeText(context, str.replace("_SEC_", String.valueOf(i)), 1).show();
            } else {
                Toast.makeText(context, "Show the next ad after " + i + " seconds", 1).show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    private void h() {
        boolean z;
        n trackingInfo;
        by unitGroupInfo;
        try {
            CustomInterstitialAdapter customInterstitialAdapter = this.l;
            if (customInterstitialAdapter == null || (trackingInfo = customInterstitialAdapter.getTrackingInfo()) == null || (unitGroupInfo = customInterstitialAdapter.getUnitGroupInfo()) == null) {
                z = false;
            } else {
                if (trackingInfo.ae() == 3) {
                    int iAn = unitGroupInfo.an();
                    if (!this.q.contains(Integer.valueOf(trackingInfo.Z())) || iAn != 1) {
                        z = false;
                    }
                }
                z = true;
            }
            aa.b(i.x, "startCarouse:canCarouse:".concat(String.valueOf(z)));
            if (z) {
                s.b().a(this.y);
                aa.b(i.x, "startCarouse:" + this.n);
                com.anythink.core.e.l lVarA = com.anythink.core.e.n.a(s.b().g()).a(this.f);
                CustomInterstitialAdapter customInterstitialAdapter2 = this.l;
                by unitGroupInfo2 = customInterstitialAdapter2 != null ? customInterstitialAdapter2.getUnitGroupInfo() : null;
                if (lVarA != null && unitGroupInfo2 != null) {
                    this.p = lVarA.bB();
                    aa.b(i.x, "startCarouse:" + this.p + ":" + this.o);
                    if (this.p >= 2) {
                        if (this.o < this.p) {
                            int iBC = lVarA.bC();
                            int iAo = unitGroupInfo2.ao();
                            if (iAo == 0) {
                                iAo = iBC;
                            }
                            int iBD = lVarA.bD();
                            this.u = iBC;
                            if (this.l.isMixSplash()) {
                                this.u = iAo;
                            }
                            int i = this.u - iBD;
                            aa.b(i.x, "startCarouse:interval:" + this.u + ":" + i);
                            if (this.u > 0 && i > 0) {
                                this.x.removeCallbacksAndMessages(null);
                                this.x.sendEmptyMessageDelayed(1, this.u);
                                Handler handler = this.x;
                                handler.sendMessageDelayed(Message.obtain(handler, 2, Integer.valueOf(iBD)), i);
                                this.n = 1;
                                return;
                            }
                            aa.b(i.x, "startCarouse:currentInterval is exception");
                            this.n = 0;
                            return;
                        }
                        this.n = 2;
                        aa.b(i.x, "startCarouse:The number of carousel items exceeds the limit, so the carousel is terminated.");
                        return;
                    }
                    this.n = 0;
                    return;
                }
                this.n = 0;
            }
        } catch (Throwable unused) {
            this.n = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.core.common.h.c i() {
        try {
            List<com.anythink.core.common.h.c> listJ = j();
            if (listJ != null) {
                aa.b(i.x, "checkNextAdCacheInfo:" + listJ.size());
            }
            if (listJ == null || listJ.isEmpty()) {
                return null;
            }
            if (this.p - this.o == 1) {
                aa.b(i.x, "checkNextAdCacheInfo:When it comes to the last item, just play randomly.");
                List<com.anythink.core.common.h.c> listB = b(listJ);
                if (listB.isEmpty()) {
                    return null;
                }
                return listB.get(0);
            }
            List<com.anythink.core.common.h.c> listA = a(listJ);
            if (listA.isEmpty()) {
                return null;
            }
            this.w = listA.size();
            List<com.anythink.core.common.h.c> listB2 = b(listA);
            if (listB2 == null || listB2.isEmpty()) {
                return null;
            }
            return listB2.get(0);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private List<com.anythink.core.common.h.c> j() {
        com.anythink.core.common.f fVarB;
        List<com.anythink.core.common.h.c> listB;
        try {
            b bVar = this.k;
            if (bVar == null || (fVarB = bVar.b()) == null) {
                return null;
            }
            Context contextG = s.b().g();
            if (contextG == null) {
                contextG = g();
            }
            if (contextG == null || (listB = fVarB.b(contextG)) == null || listB.isEmpty()) {
                return null;
            }
            aa.b(i.x, "getAllAdCacheInfoList:" + listB.size());
            return listB;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private List<com.anythink.core.common.h.c> a(List<com.anythink.core.common.h.c> list) {
        by unitGroupInfo;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            try {
                com.anythink.core.common.h.c cVar = list.get(i);
                ATBaseAdAdapter aTBaseAdAdapterE = cVar.e();
                n nVarI = cVar.i();
                if (nVarI != null && aTBaseAdAdapterE != null && (unitGroupInfo = aTBaseAdAdapterE.getUnitGroupInfo()) != null) {
                    int iAn = unitGroupInfo.an();
                    if (nVarI.ae() != 3) {
                        if (iAn == 1) {
                            arrayList.add(cVar);
                        }
                    } else if (this.q.contains(Integer.valueOf(nVarI.Z())) && iAn == 1) {
                        arrayList.add(cVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        aa.b(i.x, "getAdSupportCacheInfoList:" + arrayList.size());
        return arrayList;
    }

    private static List<com.anythink.core.common.h.c> b(List<com.anythink.core.common.h.c> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    Collections.sort(list);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return list;
    }

    public final void a(CustomInterstitialAdapter customInterstitialAdapter) {
        aa.b(i.x, "notifyAdPlay:hashCode:" + hashCode());
        if (customInterstitialAdapter != null) {
            aa.b(i.x, "notifyAdPlay::" + customInterstitialAdapter.getNetworkName());
            CustomInterstitialAdapter customInterstitialAdapter2 = this.l;
            if (customInterstitialAdapter2 == null) {
                this.l = customInterstitialAdapter;
                h();
            } else {
                if (customInterstitialAdapter != customInterstitialAdapter2) {
                    this.l = customInterstitialAdapter;
                    if (this.n == 1) {
                        h();
                        return;
                    } else {
                        aa.b(i.x, "notifyAdPlay:Currently in a carousel-disabled state.");
                        return;
                    }
                }
                aa.b(i.x, "notifyAdPlay:adapter == currentPlayAdapter");
            }
        }
    }

    private boolean d(CustomInterstitialAdapter customInterstitialAdapter) {
        n trackingInfo;
        by unitGroupInfo;
        if (customInterstitialAdapter != null && (trackingInfo = customInterstitialAdapter.getTrackingInfo()) != null && (unitGroupInfo = customInterstitialAdapter.getUnitGroupInfo()) != null) {
            if (trackingInfo.ae() != 3) {
                return true;
            }
            int iAn = unitGroupInfo.an();
            if (this.q.contains(Integer.valueOf(trackingInfo.Z())) && iAn == 1) {
                return true;
            }
        }
        return false;
    }

    public final void b(CustomInterstitialAdapter customInterstitialAdapter) {
        n trackingInfo;
        if (customInterstitialAdapter != null && customInterstitialAdapter == this.l) {
            aa.b(i.x, "notifyAdClick:" + customInterstitialAdapter.getNetworkName());
            this.n = 2;
            by unitGroupInfo = this.l.getUnitGroupInfo();
            if (unitGroupInfo == null || unitGroupInfo.am() != 1 || (trackingInfo = this.l.getTrackingInfo()) == null) {
                return;
            }
            if (trackingInfo.ae() != 3 || this.q.contains(Integer.valueOf(trackingInfo.Z()))) {
                String strA = a(2);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                com.anythink.core.common.t.f.a("2", trackingInfo, s.b().W(), strA);
                return;
            }
            return;
        }
        aa.b(i.x, "notifyAdClick:adapter != currentPlayAdapter");
    }

    public final void c(CustomInterstitialAdapter customInterstitialAdapter) {
        aa.b(i.x, "notifyAdClose:hashCode:" + hashCode());
        if (customInterstitialAdapter != null && customInterstitialAdapter == this.l) {
            if (this.r.contains(customInterstitialAdapter)) {
                this.v = 1;
                aa.b(i.x, "notifyAdClose:The closure triggered by the carousel ad:" + customInterstitialAdapter.getNetworkName() + ":" + this.n);
                return;
            } else if (this.s.contains(customInterstitialAdapter)) {
                this.n = 2;
                this.v = 2;
                aa.b(i.x, "notifyAdClose:The close triggered by the server-side click shutdown:" + customInterstitialAdapter.getNetworkName() + ":" + this.n);
                return;
            } else {
                this.n = 2;
                this.v = 3;
                aa.b(i.x, "notifyAdClose:The closure triggered by the user clicking the close button:" + customInterstitialAdapter.getNetworkName() + ":" + this.n);
                return;
            }
        }
        aa.b(i.x, "notifyAdClose:adapter != currentPlayAdapter");
    }

    public final void a(CustomInterstitialAdapter customInterstitialAdapter, CustomInterstitialEventListener customInterstitialEventListener) {
        if (customInterstitialAdapter != null) {
            this.z.put(customInterstitialAdapter, customInterstitialEventListener);
        }
    }

    private String a(int i) {
        try {
            this.v = i;
            if (this.l == null) {
                return "closeAd currentPlayAdapter is null";
            }
            aa.b(i.x, "closeAd:" + i + ":" + this.l.getNetworkName());
            if (this.v == 1) {
                this.r.add(this.l);
            } else if (this.v == 2) {
                this.n = 2;
                this.s.add(this.l);
            } else {
                this.n = 2;
            }
            if (!this.l.isMixFormatAd()) {
                return this.l.internalCloseAd();
            }
            WeakReference<Activity> weakReferenceRemove = this.t.remove(this.l);
            Activity activity = weakReferenceRemove != null ? weakReferenceRemove.get() : null;
            if (activity == null) {
                return "mixActivityMap get is null";
            }
            aa.b(i.x, "removeMixActivity:" + this.n + ":" + activity.getClass().getName());
            activity.finish();
            activity.overridePendingTransition(0, 0);
            CustomInterstitialEventListener customInterstitialEventListener = this.z.get(this.l);
            if (customInterstitialEventListener == null) {
                return "";
            }
            customInterstitialEventListener.onInterstitialAdClose();
            return "";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public final void a() {
        try {
            aa.b(i.x, "destroy:hashCode:" + hashCode() + ":carouselState:" + this.n);
            this.n = 0;
            this.o = 1;
            this.v = 3;
            this.w = -1;
            this.t.clear();
            this.r.clear();
            this.s.clear();
            this.z.clear();
            this.x.removeCallbacksAndMessages(null);
            s.b().b(this.y);
        } catch (Throwable unused) {
        }
    }

    public final void a(CustomInterstitialAdapter customInterstitialAdapter, Activity activity) {
        if (customInterstitialAdapter == null || activity == null) {
            return;
        }
        aa.b(i.x, "saveMixActivity:" + this.n + ":" + activity.getClass().getName());
        this.t.put(customInterstitialAdapter, new WeakReference<>(activity));
    }

    private Activity e(CustomInterstitialAdapter customInterstitialAdapter) {
        WeakReference<Activity> weakReferenceRemove = this.t.remove(customInterstitialAdapter);
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }

    public final int b() {
        return this.n;
    }

    public final int c() {
        return this.o;
    }

    public final int d() {
        return this.u;
    }

    public final int e() {
        return this.v;
    }

    public final int f() {
        return this.w;
    }

    static /* synthetic */ void a(Context context, String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Toast.makeText(context, str.replace("_SEC_", String.valueOf(i)), 1).show();
            } else {
                Toast.makeText(context, "Show the next ad after " + i + " seconds", 1).show();
            }
        } catch (Throwable unused) {
        }
    }
}
