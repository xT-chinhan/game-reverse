package com.anythink.network.gdt;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.d.j;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class GDTATInitManager extends ATInitMediation {
    public static final String TAG = "GDTATInitManager";
    private static volatile GDTATInitManager b;
    private String f;
    private boolean h;
    private List<MediationInitCallback> k;
    private Map<String, WeakReference> c = new ConcurrentHashMap();
    private Map<String, RewardVideoAD> d = new ConcurrentHashMap();
    private Map<String, UnifiedInterstitialAD> e = new ConcurrentHashMap();
    private final Object g = new Object();
    private final Object j = new Object();
    int a = 0;
    private AtomicBoolean i = new AtomicBoolean(false);

    @Override // com.anythink.core.api.ATInitMediation
    public String getAdapterVersion() {
        return "UA_6.5.10";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Tencent";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.qq.e.ads.ADActivity";
    }

    static /* synthetic */ boolean a(GDTATInitManager gDTATInitManager) {
        gDTATInitManager.h = true;
        return true;
    }

    private GDTATInitManager() {
    }

    public static GDTATInitManager getInstance() {
        if (b == null) {
            synchronized (GDTATInitManager.class) {
                if (b == null) {
                    b = new GDTATInitManager();
                }
            }
        }
        return b;
    }

    public void setGDTATCustomController(GDTATCustomController gDTATCustomController) {
        if (gDTATCustomController != null) {
            GlobalSetting.setAgreePrivacyStrategy(gDTATCustomController.getAgreePrivacyStrategy());
            try {
                HashMap map = new HashMap();
                map.put("mac_address", Boolean.valueOf(gDTATCustomController.isCanUseMacAddress()));
                map.put("android_id", Boolean.valueOf(gDTATCustomController.isCanUseAndroidId()));
                map.put("device_id", Boolean.valueOf(gDTATCustomController.isCanUseDeviceId()));
                GlobalSetting.setAgreeReadPrivacyInfo(map);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    protected final void a(String str, WeakReference weakReference) {
        try {
            this.c.put(str, weakReference);
        } catch (Throwable unused) {
        }
    }

    public void setExtraUserData(Map<String, Object> map) {
        try {
            HashMap map2 = new HashMap();
            Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(8);
            if (boolIsShakeEnabled != null) {
                map2.put("sensor_ts", boolIsShakeEnabled.booleanValue() ? "1" : "0");
            }
            if (map != null) {
                Object obj = map.get("lng");
                if (obj instanceof String) {
                    map2.put("lng", (String) obj);
                }
                Object obj2 = map.get("lat");
                if (obj2 instanceof String) {
                    map2.put("lat", (String) obj2);
                }
                Object obj3 = map.get(GDTATConst.EXTRA_DATA.LOC_TIME);
                if (obj3 instanceof String) {
                    map2.put(GDTATConst.EXTRA_DATA.LOC_TIME, (String) obj3);
                }
                Object obj4 = map.get(GDTATConst.EXTRA_DATA.WXOPENID);
                if (obj4 instanceof String) {
                    map2.put(GDTATConst.EXTRA_DATA.WXOPENID, (String) obj4);
                }
            }
            Log.i(TAG, "GlobalSetting.setExtraUserData():".concat(String.valueOf(map2)));
            if (map2.isEmpty()) {
                return;
            }
            GlobalSetting.setExtraUserData(map2);
        } catch (Exception unused) {
        }
    }

    protected final void a(String str, RewardVideoAD rewardVideoAD) {
        this.d.clear();
        this.d.put(str, rewardVideoAD);
    }

    protected final void a() {
        this.d.clear();
    }

    protected final void a(String str, UnifiedInterstitialAD unifiedInterstitialAD) {
        this.e.clear();
        this.e.put(str, unifiedInterstitialAD);
    }

    protected final void b() {
        this.e.clear();
    }

    private void c() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.c.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.c.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    @Override // com.anythink.core.api.ATInitMediation
    public synchronized void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        try {
            this.a = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused) {
        }
        if (this.a == 2) {
            GlobalSetting.setPersonalizedState(1);
        } else {
            GlobalSetting.setPersonalizedState(0);
        }
        if (ATSDK.isNetworkLogDebug()) {
            Log.i(TAG, "GlobalSetting.getPersonalizedState():" + GlobalSetting.getPersonalizedState());
        }
        c();
        if (this.h) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
            }
            return;
        }
        synchronized (this.j) {
            if (this.i.get()) {
                if (mediationInitCallback != null) {
                    this.k.add(mediationInitCallback);
                }
                return;
            }
            if (this.k == null) {
                this.k = new ArrayList();
            }
            this.i.set(true);
            String stringFromMap = getStringFromMap(map, "app_id");
            if (mediationInitCallback != null) {
                this.k.add(mediationInitCallback);
            }
            if (map.containsKey(ATInitMediation.KEY_LOCAL)) {
                this.f = stringFromMap;
            } else {
                String str = this.f;
                if (str != null && !TextUtils.equals(str, stringFromMap)) {
                    checkToSaveInitData(getNetworkName(), map, this.f);
                    this.f = null;
                }
            }
            GDTAdSdk.initWithoutStart(context.getApplicationContext(), stringFromMap);
            GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: com.anythink.network.gdt.GDTATInitManager.1
                @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                public final void onStartSuccess() {
                    GDTATInitManager.a(GDTATInitManager.this);
                    GDTATInitManager.a(GDTATInitManager.this, true, (String) null, (String) null);
                }

                @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                public final void onStartFailed(Exception exc) {
                    GDTATInitManager.a(GDTATInitManager.this, false, "", "GDT initSDK failed." + exc.getMessage());
                }
            });
        }
    }

    private void a(boolean z, String str, String str2) {
        synchronized (this.j) {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                MediationInitCallback mediationInitCallback = this.k.get(i);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            this.k.clear();
            this.i.set(false);
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return GDTATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getActivityStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.qq.e.ads.ADActivity");
        arrayList.add("com.qq.e.ads.PortraitADActivity");
        arrayList.add("com.qq.e.ads.LandscapeADActivity");
        arrayList.add("com.qq.e.ads.RewardvideoPortraitADActivity");
        arrayList.add("com.qq.e.ads.RewardvideoLandscapeADActivity");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getServiceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.qq.e.comm.DownloadService");
        return arrayList;
    }

    protected static int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    final void a(Context context, final Map<String, Object> map, final Map<String, Object> map2, final ATBidRequestInfoListener aTBidRequestInfoListener) {
        getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATInitManager.2
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                GDTATInitManager.this.runOnThreadPool(new Runnable() { // from class: com.anythink.network.gdt.GDTATInitManager.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GDTBidRequestInfo gDTBidRequestInfo;
                        synchronized (GDTATInitManager.this.g) {
                            gDTBidRequestInfo = new GDTBidRequestInfo(map);
                        }
                        if (!gDTBidRequestInfo.isValid()) {
                            if (aTBidRequestInfoListener != null) {
                                aTBidRequestInfoListener.onFailed(ATBidRequestInfo.BIDTOKEN_EMPTY_ERROR_TYPE);
                            }
                        } else if (aTBidRequestInfoListener != null) {
                            aTBidRequestInfoListener.onSuccess(gDTBidRequestInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed(ATBidRequestInfo.INIT_ERROR_TYPE);
                }
            }
        });
    }

    protected static LoadAdParams a(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        a(map2, map);
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setDevExtra(map2);
        return loadAdParams;
    }

    protected static boolean a(Map map, Map<String, Object> map2) {
        try {
            map.put("meSrc", "299");
            Object obj = map2.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.MEDIATION_WF_ID);
            Object[] objArr = new Object[1];
            map.put("thrmei", obj != null ? obj.toString() : "");
            if (getIntFromMap(map2, j.w.y, 1) == 2) {
                new StringBuilder("fillRequestMap() >>> ").append(map);
                return true;
            }
            Object obj2 = map2.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.STACK_INFO);
            map.put("staIn", obj2 != null ? obj2.toString() : "");
            new StringBuilder("fillRequestMap() >>> ").append(map);
            return true;
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(GDTATInitManager gDTATInitManager, boolean z, String str, String str2) {
        synchronized (gDTATInitManager.j) {
            int size = gDTATInitManager.k.size();
            for (int i = 0; i < size; i++) {
                MediationInitCallback mediationInitCallback = gDTATInitManager.k.get(i);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            gDTATInitManager.k.clear();
            gDTATInitManager.i.set(false);
        }
    }
}
