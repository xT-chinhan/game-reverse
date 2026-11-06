package com.anythink.interstitial.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.m;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.q;
import com.anythink.core.d.l;
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
    private int p;
    private int u;
    private int n = 0;
    private int o = 1;
    private final List<Integer> q = Arrays.asList(8, 15, 22, 28);
    private final List<CustomInterstitialAdapter> r = new ArrayList();
    private final List<CustomInterstitialAdapter> s = new ArrayList();
    private final Map<CustomInterstitialAdapter, WeakReference<Activity>> t = new HashMap();
    private int v = 3;
    private int w = -1;
    private final Handler x = new Handler(Looper.getMainLooper()) { // from class: com.anythink.interstitial.a.a.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                ab.b(j.s, "handleMessage:0x002:" + a.this.n);
                if (a.this.n == 1) {
                    if (message.obj instanceof Integer) {
                        try {
                            int iIntValue = ((Integer) message.obj).intValue() / 1000;
                            com.anythink.core.common.h.c cVarI = a.this.i();
                            if (cVarI != null) {
                                a.this.m = cVarI;
                                if (a.this.m.e() != null) {
                                    ab.b(j.s, "handleMessage:nextPlayAdCacheInfo:" + a.this.m.e().getNetworkName());
                                }
                                Context contextG = t.b().g();
                                if (contextG == null) {
                                    contextG = a.this.g();
                                }
                                if (contextG != null) {
                                    String string = "";
                                    try {
                                        string = contextG.getString(q.a(contextG, "interstitial_text_next_play", "string"));
                                    } catch (Exception unused) {
                                    }
                                    a.a(contextG, string, iIntValue);
                                    return;
                                }
                                return;
                            }
                            a.o(a.this);
                            ab.b(j.s, "handleMessage:0x002:没有可以轮播的广告了终止轮播");
                            return;
                        } catch (Throwable th) {
                            a.o(a.this);
                            th.printStackTrace();
                            return;
                        }
                    }
                    a.o(a.this);
                    ab.b(j.s, "handleMessage:0x002:msg.obj is not Integer");
                    return;
                }
                ab.b(j.s, "handleMessage:0x002:carouselState!=1");
                return;
            }
            try {
                ab.b(j.s, "handleMessage:0x001:" + a.this.n);
                if (a.this.m == null || !a.this.m.k() || a.this.n != 1) {
                    if (a.this.m != null) {
                        ab.b(j.s, "handleMessage:0x001:nextPlayAdCacheInfo:" + a.this.m.k() + ":carouselState:" + a.this.n);
                    } else {
                        ab.b(j.s, "handleMessage:0x001:nextPlayAdCacheInfo is null and carouselState=" + a.this.n);
                    }
                    a.o(a.this);
                    return;
                }
                if (a.this.o < a.this.p) {
                    String strE = a.e(a.this);
                    if (TextUtils.isEmpty(strE)) {
                        ab.b(j.s, "handleMessage:0x001:close:success");
                        if (a.this.k != null) {
                            ATBaseAdAdapter aTBaseAdAdapterE = a.this.m.e();
                            if (aTBaseAdAdapterE != null) {
                                ab.b(j.s, "handleMessage:0x001:internalShow:" + aTBaseAdAdapterE.getNetworkName());
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
                    com.anythink.core.common.u.e.a("1", a.this.l != null ? a.this.l.getTrackingInfo() : null, t.b().W(), strE);
                    ab.b(j.s, "handleMessage:0x001:close is exception:".concat(String.valueOf(strE)));
                    return;
                }
                a.o(a.this);
                ab.b(j.s, "handleMessage:0x001:rotation_num is out");
            } catch (Throwable th2) {
                a.o(a.this);
                th2.printStackTrace();
            }
        }
    };
    private final m y = new m() { // from class: com.anythink.interstitial.a.a.2
        @Override // com.anythink.core.common.d.m
        public final void a(boolean z) {
            ab.b(j.s, "backToForeground:".concat(String.valueOf(z)));
            if (z) {
                return;
            }
            a.o(a.this);
            if (a.this.l == null || a.this.l.getTrackingInfo() == null) {
                return;
            }
            com.anythink.core.common.u.e.a(a.this.l.getTrackingInfo(), String.valueOf(a.this.f()));
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
        return activity == null ? t.b().N() : activity;
    }

    private static void b(Context context, String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Toast.makeText(context, str.replace("_SEC_", String.valueOf(i)), 1).show();
            } else {
                Toast.makeText(context, i + "秒后展示下一个广告", 1).show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    private void h() {
        boolean z;
        n trackingInfo;
        bv unitGroupInfo;
        try {
            CustomInterstitialAdapter customInterstitialAdapter = this.l;
            if (customInterstitialAdapter == null || (trackingInfo = customInterstitialAdapter.getTrackingInfo()) == null || (unitGroupInfo = customInterstitialAdapter.getUnitGroupInfo()) == null) {
                z = false;
            } else {
                if (trackingInfo.ad() == 3) {
                    int iAh = unitGroupInfo.ah();
                    if (!this.q.contains(Integer.valueOf(trackingInfo.Y())) || iAh != 1) {
                        z = false;
                    }
                }
                z = true;
            }
            ab.b(j.s, "startCarouse:canCarouse:".concat(String.valueOf(z)));
            if (z) {
                t.b().a(this.y);
                ab.b(j.s, "startCarouse:" + this.n);
                l lVarA = com.anythink.core.d.n.a(t.b().g()).a(this.f);
                CustomInterstitialAdapter customInterstitialAdapter2 = this.l;
                bv unitGroupInfo2 = customInterstitialAdapter2 != null ? customInterstitialAdapter2.getUnitGroupInfo() : null;
                if (lVarA != null && unitGroupInfo2 != null) {
                    this.p = lVarA.bB();
                    ab.b(j.s, "startCarouse:" + this.p + ":" + this.o);
                    int i = this.p;
                    if (i >= 2) {
                        if (this.o < i) {
                            int iBC = lVarA.bC();
                            int iAi = unitGroupInfo2.ai();
                            if (iAi == 0) {
                                iAi = iBC;
                            }
                            int iBD = lVarA.bD();
                            this.u = iBC;
                            if (this.l.isMixSplash()) {
                                this.u = iAi;
                            }
                            int i2 = this.u - iBD;
                            ab.b(j.s, "startCarouse:interval:" + this.u + ":" + i2);
                            if (this.u > 0 && i2 > 0) {
                                this.x.removeCallbacksAndMessages(null);
                                this.x.sendEmptyMessageDelayed(1, this.u);
                                Handler handler = this.x;
                                handler.sendMessageDelayed(Message.obtain(handler, 2, Integer.valueOf(iBD)), i2);
                                this.n = 1;
                                return;
                            }
                            ab.b(j.s, "startCarouse:服务端下发间隔异常");
                            this.n = 0;
                            return;
                        }
                        this.n = 2;
                        ab.b(j.s, "startCarouse:轮播个数超限终止轮播");
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
                ab.b(j.s, "checkNextAdCacheInfo:" + listJ.size());
            }
            if (listJ == null || listJ.isEmpty()) {
                return null;
            }
            if (this.p - this.o == 1) {
                ab.b(j.s, "checkNextAdCacheInfo:播到最后一个了随便播");
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
        com.anythink.core.common.f fVarA;
        List<com.anythink.core.common.h.c> listB;
        try {
            b bVar = this.k;
            if (bVar == null || (fVarA = bVar.a()) == null) {
                return null;
            }
            Context contextG = t.b().g();
            if (contextG == null) {
                contextG = g();
            }
            if (contextG == null || (listB = fVarA.b(contextG)) == null || listB.isEmpty()) {
                return null;
            }
            ab.b(j.s, "getAllAdCacheInfoList:" + listB.size());
            return listB;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private List<com.anythink.core.common.h.c> a(List<com.anythink.core.common.h.c> list) {
        bv unitGroupInfo;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            try {
                com.anythink.core.common.h.c cVar = list.get(i);
                ATBaseAdAdapter aTBaseAdAdapterE = cVar.e();
                n nVarI = cVar.i();
                if (nVarI != null && aTBaseAdAdapterE != null && (unitGroupInfo = aTBaseAdAdapterE.getUnitGroupInfo()) != null) {
                    int iAh = unitGroupInfo.ah();
                    if (nVarI.ad() != 3) {
                        if (iAh == 1) {
                            arrayList.add(cVar);
                        }
                    } else if (this.q.contains(Integer.valueOf(nVarI.Y())) && iAh == 1) {
                        arrayList.add(cVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ab.b(j.s, "getAdSupportCacheInfoList:" + arrayList.size());
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
        ab.b(j.s, "notifyAdPlay:hashCode:" + hashCode());
        if (customInterstitialAdapter != null) {
            ab.b(j.s, "notifyAdPlay::" + customInterstitialAdapter.getNetworkName());
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
                        ab.b(j.s, "notifyAdPlay:当前属于轮播禁止状态");
                        return;
                    }
                }
                ab.b(j.s, "notifyAdPlay:adapter == currentPlayAdapter");
            }
        }
    }

    private boolean d(CustomInterstitialAdapter customInterstitialAdapter) {
        n trackingInfo;
        bv unitGroupInfo;
        if (customInterstitialAdapter != null && (trackingInfo = customInterstitialAdapter.getTrackingInfo()) != null && (unitGroupInfo = customInterstitialAdapter.getUnitGroupInfo()) != null) {
            if (trackingInfo.ad() != 3) {
                return true;
            }
            int iAh = unitGroupInfo.ah();
            if (this.q.contains(Integer.valueOf(trackingInfo.Y())) && iAh == 1) {
                return true;
            }
        }
        return false;
    }

    public final void b(CustomInterstitialAdapter customInterstitialAdapter) {
        n trackingInfo;
        if (customInterstitialAdapter != null && customInterstitialAdapter == this.l) {
            ab.b(j.s, "notifyAdClick:" + customInterstitialAdapter.getNetworkName());
            this.n = 2;
            bv unitGroupInfo = this.l.getUnitGroupInfo();
            if (unitGroupInfo == null || unitGroupInfo.ag() != 1 || (trackingInfo = this.l.getTrackingInfo()) == null) {
                return;
            }
            if (trackingInfo.ad() != 3 || this.q.contains(Integer.valueOf(trackingInfo.Y()))) {
                String strA = a(2);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                com.anythink.core.common.u.e.a("2", trackingInfo, t.b().W(), strA);
                return;
            }
            return;
        }
        ab.b(j.s, "notifyAdClick:adapter != currentPlayAdapter");
    }

    public final void c(CustomInterstitialAdapter customInterstitialAdapter) {
        ab.b(j.s, "notifyAdClose:hashCode:" + hashCode());
        if (customInterstitialAdapter != null && customInterstitialAdapter == this.l) {
            if (this.r.contains(customInterstitialAdapter)) {
                this.v = 1;
                ab.b(j.s, "notifyAdClose:轮播广告触发的关闭:" + customInterstitialAdapter.getNetworkName() + ":" + this.n);
                return;
            } else if (this.s.contains(customInterstitialAdapter)) {
                this.n = 2;
                this.v = 2;
                ab.b(j.s, "notifyAdClose:服务端点击关闭触发的close:" + customInterstitialAdapter.getNetworkName() + ":" + this.n);
                return;
            } else {
                this.n = 2;
                this.v = 3;
                ab.b(j.s, "notifyAdClose:用户点击关闭按钮触发的关闭:" + customInterstitialAdapter.getNetworkName() + ":" + this.n);
                return;
            }
        }
        ab.b(j.s, "notifyAdClose:adapter != currentPlayAdapter");
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
            ab.b(j.s, "closeAd:" + i + ":" + this.l.getNetworkName());
            int i2 = this.v;
            if (i2 == 1) {
                this.r.add(this.l);
            } else if (i2 == 2) {
                this.n = 2;
                this.s.add(this.l);
            } else {
                this.n = 2;
            }
            if (!this.l.isMixFormatAd()) {
                return this.l.closeAd();
            }
            WeakReference<Activity> weakReferenceRemove = this.t.remove(this.l);
            Activity activity = weakReferenceRemove != null ? weakReferenceRemove.get() : null;
            if (activity == null) {
                return "mixActivityMap get is null";
            }
            ab.b(j.s, "removeMixActivity:" + this.n + ":" + activity.getClass().getName());
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
            ab.b(j.s, "destroy:hashCode:" + hashCode() + ":carouselState:" + this.n);
            this.n = 0;
            this.o = 1;
            this.v = 3;
            this.w = -1;
            this.t.clear();
            this.r.clear();
            this.s.clear();
            this.z.clear();
            this.x.removeCallbacksAndMessages(null);
            t.b().b(this.y);
        } catch (Throwable unused) {
        }
    }

    public final void a(CustomInterstitialAdapter customInterstitialAdapter, Activity activity) {
        if (customInterstitialAdapter == null || activity == null) {
            return;
        }
        ab.b(j.s, "saveMixActivity:" + this.n + ":" + activity.getClass().getName());
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
                Toast.makeText(context, i + "秒后展示下一个广告", 1).show();
            }
        } catch (Throwable unused) {
        }
    }
}
