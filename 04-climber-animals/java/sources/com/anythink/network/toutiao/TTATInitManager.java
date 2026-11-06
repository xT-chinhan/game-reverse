package com.anythink.network.toutiao;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingListenerExt;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATCustomLoadListenerExt;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.e.f;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.taptap.sdk.db.constant.Common;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTATInitManager extends ATInitMediation {
    public static final String TAG = "TTATInitManager";
    private static volatile TTATInitManager e;
    TTCustomController a;
    Map<String, Map<String, TTATBiddingInfo>> b;
    private boolean h;
    private List<MediationInitCallback> j;
    private Map<String, WeakReference> g = new ConcurrentHashMap();
    private final Object k = new Object();
    private final long l = 100;
    int c = 1;
    String d = "price";
    private boolean f = true;
    private AtomicBoolean i = new AtomicBoolean(false);

    @Override // com.anythink.core.api.ATInitMediation
    public String getAdapterVersion() {
        return "UA_6.5.10";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "CSJ";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.bytedance.sdk.openadsdk.TTAdSdk";
    }

    static /* synthetic */ boolean b(TTATInitManager tTATInitManager) {
        tTATInitManager.h = true;
        return true;
    }

    private TTATInitManager() {
    }

    public static TTATInitManager getInstance() {
        if (e == null) {
            synchronized (TTATInitManager.class) {
                if (e == null) {
                    e = new TTATInitManager();
                }
            }
        }
        return e;
    }

    public void setTtCustomController(TTCustomController tTCustomController) {
        this.a = tTCustomController;
    }

    public void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        if (TTAdSdk.isSdkReady() || this.h) {
            String strA = a();
            if (!TextUtils.isEmpty(strA)) {
                TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(strA).build());
            }
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.k) {
            if (this.i.get()) {
                if (mediationInitCallback != null) {
                    this.j.add(mediationInitCallback);
                }
                return;
            }
            if (this.j == null) {
                this.j = new ArrayList();
            }
            this.i.set(true);
            String stringFromMap = getStringFromMap(map, "app_id");
            if (mediationInitCallback != null) {
                this.j.add(mediationInitCallback);
            }
            runOnMainThread(new AnonymousClass1(stringFromMap, context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString(), this.f ? new int[]{1, 2, 3, 4, 5} : new int[]{2}, context.getApplicationContext()));
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATInitManager$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ int[] c;
        final /* synthetic */ Context d;

        AnonymousClass1(String str, String str2, int[] iArr, Context context) {
            this.a = str;
            this.b = str2;
            this.c = iArr;
            this.d = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                TTAdConfig.Builder builderSupportMultiProcess = new TTAdConfig.Builder().appId(this.a).appName(this.b).titleBarTheme(1).directDownloadNetworkType(this.c).supportMultiProcess(false);
                String strA = TTATInitManager.this.a();
                if (!TextUtils.isEmpty(strA)) {
                    builderSupportMultiProcess.data(strA);
                }
                if (TTATInitManager.this.a != null) {
                    builderSupportMultiProcess.customController(TTATInitManager.this.a);
                }
                TTAdSdk.init(this.d, builderSupportMultiProcess.build());
                TTAdSdk.start(new TTAdSdk.Callback() { // from class: com.anythink.network.toutiao.TTATInitManager.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                    public final void success() {
                        TTATInitManager.this.runOnThreadPool(new Runnable() { // from class: com.anythink.network.toutiao.TTATInitManager.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                TTATInitManager.b(TTATInitManager.this);
                                TTATInitManager.a(TTATInitManager.this, true, (String) null, (String) null);
                            }
                        });
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                    public final void fail(int i, String str) {
                        TTATInitManager.a(TTATInitManager.this, false, String.valueOf(i), str);
                    }
                });
            } catch (Throwable th) {
                TTATInitManager.a(TTATInitManager.this, false, "", th.getMessage());
            }
        }
    }

    private void a(boolean z, String str, String str2) {
        synchronized (this.k) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                MediationInitCallback mediationInitCallback = this.j.get(i);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            this.j.clear();
            this.i.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        try {
            this.c = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused) {
        }
        try {
            JSONArray jSONArray = new JSONArray();
            String str = "0";
            Object obj = this.c == 2 ? "0" : "1";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Common.System.NAME, "personal_ads_type");
            jSONObject.put(f.a.d, obj);
            jSONArray.put(jSONObject);
            Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(15);
            if (boolIsShakeEnabled == null) {
                str = "-1";
            } else if (boolIsShakeEnabled.booleanValue()) {
                str = "1";
            }
            if (!str.equals("-1")) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Common.System.NAME, "is_shake_ads");
                jSONObject2.put(f.a.d, str);
                jSONArray.put(jSONObject2);
            }
            String string = jSONArray.toString();
            if (ATSDK.isNetworkLogDebug()) {
                Log.i(TAG, "TTPrivateData:".concat(String.valueOf(string)));
            }
            return string;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void setIsOpenDirectDownload(boolean z) {
        this.f = z;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return TTATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getProviderStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider");
        arrayList.add("com.bytedance.sdk.openadsdk.TTFileProvider");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getPermissionStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }

    protected final synchronized void a(Map<String, Object> map, TTClientBidding tTClientBidding, ATBiddingListener aTBiddingListener) {
        a(map, (BaseAd) null, tTClientBidding, aTBiddingListener);
    }

    protected final synchronized void a(Map<String, Object> map, BaseAd baseAd, TTClientBidding tTClientBidding, ATBiddingListener aTBiddingListener) {
        double d;
        if (aTBiddingListener != null) {
            if (map != null) {
                if (map.containsKey(this.d)) {
                    try {
                        d = Double.parseDouble(String.valueOf(map.get(this.d)));
                    } catch (Throwable th) {
                        th.printStackTrace();
                        d = 0.0d;
                    }
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new TTATBiddingNotify(tTClientBidding), ATAdConst.CURRENCY.RMB_CENT), baseAd);
                }
            }
            d = 0.0d;
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new TTATBiddingNotify(tTClientBidding), ATAdConst.CURRENCY.RMB_CENT), baseAd);
        }
    }

    public synchronized void notifyAdDataLoad(boolean z, Map<String, Object> map, TTClientBidding tTClientBidding, ATCustomLoadListener aTCustomLoadListener, ATBiddingListener aTBiddingListener, BaseAd... baseAdArr) {
        map.size();
        try {
            if (z) {
                if (baseAdArr != null && baseAdArr.length != 0) {
                    b(map, baseAdArr[0], tTClientBidding, aTBiddingListener);
                    return;
                }
                b(map, null, tTClientBidding, aTBiddingListener);
                return;
            }
            if (aTCustomLoadListener instanceof ATCustomLoadListenerExt) {
                ((ATCustomLoadListenerExt) aTCustomLoadListener).onAdDataLoadedWithAds(baseAdArr);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void b(Map<String, Object> map, BaseAd baseAd, TTClientBidding tTClientBidding, ATBiddingListener aTBiddingListener) {
        double d;
        if (aTBiddingListener instanceof ATBiddingListenerExt) {
            if (map == null || !map.containsKey(this.d)) {
                d = 0.0d;
            } else {
                try {
                    d = Double.parseDouble(String.valueOf(map.get(this.d)));
                } catch (Throwable th) {
                    th.printStackTrace();
                    d = 0.0d;
                }
            }
            ((ATBiddingListenerExt) aTBiddingListener).onC2SBiddingResultWithData(ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new TTATBiddingNotify(tTClientBidding), ATAdConst.CURRENCY.RMB_CENT), baseAd);
        }
    }

    static /* synthetic */ void a(TTATInitManager tTATInitManager, boolean z, String str, String str2) {
        synchronized (tTATInitManager.k) {
            int size = tTATInitManager.j.size();
            for (int i = 0; i < size; i++) {
                MediationInitCallback mediationInitCallback = tTATInitManager.j.get(i);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            tTATInitManager.j.clear();
            tTATInitManager.i.set(false);
        }
    }
}
