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
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GDTATInitManager extends ATInitMediation {
    public static final String TAG = "GDTATInitManager";
    private static volatile GDTATInitManager k;
    private String d;
    private boolean f;
    private List<MediationInitCallback> i;
    private Map<String, WeakReference> a = new ConcurrentHashMap();
    private Map<String, RewardVideoAD> b = new ConcurrentHashMap();
    private Map<String, UnifiedInterstitialAD> c = new ConcurrentHashMap();
    private final Object e = new Object();
    private final Object h = new Object();
    int j = 0;
    private AtomicBoolean g = new AtomicBoolean(false);

    class a implements GDTAdSdk.OnStartListener {

        /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATInitManager$a$a, reason: collision with other inner class name */
        class RunnableC0067a implements Runnable {
            RunnableC0067a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GDTATInitManager.this.f = true;
                GDTATInitManager.this.a(true, null, null);
            }
        }

        class b implements Runnable {
            final /* synthetic */ Exception a;

            b(Exception exc) {
                this.a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                GDTATInitManager.this.a(false, "", "GDT initSDK failed." + this.a.getMessage());
            }
        }

        a() {
        }

        @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
        public void onStartFailed(Exception exc) {
            GDTATInitManager.this.runOnThreadPool(new b(exc));
        }

        @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
        public void onStartSuccess() {
            GDTATInitManager.this.runOnThreadPool(new RunnableC0067a());
        }
    }

    class b implements MediationInitCallback {
        final /* synthetic */ Map a;
        final /* synthetic */ Map b;
        final /* synthetic */ ATBidRequestInfoListener c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GDTBidRequestInfo gDTBidRequestInfo;
                synchronized (GDTATInitManager.this.e) {
                    b bVar = b.this;
                    gDTBidRequestInfo = new GDTBidRequestInfo(bVar.a, bVar.b);
                }
                if (gDTBidRequestInfo.isValid()) {
                    ATBidRequestInfoListener aTBidRequestInfoListener = b.this.c;
                    if (aTBidRequestInfoListener != null) {
                        aTBidRequestInfoListener.onSuccess(gDTBidRequestInfo);
                        return;
                    }
                    return;
                }
                ATBidRequestInfoListener aTBidRequestInfoListener2 = b.this.c;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed(ATBidRequestInfo.BIDTOKEN_EMPTY_ERROR_TYPE);
                }
            }
        }

        b(Map map, Map map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
            this.a = map;
            this.b = map2;
            this.c = aTBidRequestInfoListener;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            ATBidRequestInfoListener aTBidRequestInfoListener = this.c;
            if (aTBidRequestInfoListener != null) {
                aTBidRequestInfoListener.onFailed(ATBidRequestInfo.INIT_ERROR_TYPE);
            }
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            GDTATInitManager.this.runOnThreadPool(new a());
        }
    }

    private GDTATInitManager() {
    }

    public static GDTATInitManager getInstance() {
        if (k == null) {
            synchronized (GDTATInitManager.class) {
                if (k == null) {
                    k = new GDTATInitManager();
                }
            }
        }
        return k;
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
    public int getAdapterBridgeVersion() {
        return 1;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getAdapterVersion() {
        return "4.710.1580.1.0";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Tencent";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.qq.e.ads.ADActivity";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return GDTATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getServiceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.qq.e.comm.DownloadService");
        return arrayList;
    }

    public synchronized void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    public boolean isPlayMute(int i) {
        Boolean bool = ATSDKGlobalSetting.isGlobalMute;
        if (bool != null) {
            return bool.booleanValue();
        }
        return i == 1;
    }

    public void setExtraUserData(Map<String, Object> map) {
        try {
            HashMap map2 = new HashMap();
            Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(8);
            if (boolIsShakeEnabled != null) {
                map2.put("shakable", boolIsShakeEnabled.booleanValue() ? "1" : "0");
            }
            if (map != null) {
                Object obj = map.get(GDTATConst.EXTRA_DATA.LNG);
                if (obj instanceof String) {
                    map2.put(GDTATConst.EXTRA_DATA.LNG, (String) obj);
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
            Log.i(TAG, "GlobalSetting.setExtraUserData():" + map2);
            if (map2.isEmpty()) {
                return;
            }
            GlobalSetting.setExtraUserData(map2);
        } catch (Exception unused) {
        }
    }

    public void setGDTATCustomController(GDTATCustomController gDTATCustomController) {
        if (gDTATCustomController != null) {
            GlobalSetting.setAgreePrivacyStrategy(gDTATCustomController.getAgreePrivacyStrategy());
            try {
                HashMap map = new HashMap();
                map.put("mac_address", Boolean.valueOf(gDTATCustomController.isCanUseMacAddress()));
                map.put("android_id", Boolean.valueOf(gDTATCustomController.isCanUseAndroidId()));
                map.put(TapEventParamConstants.PARAM_DEVICE_ID, Boolean.valueOf(gDTATCustomController.isCanUseDeviceId()));
                GlobalSetting.setAgreeReadPrivacyInfo(map);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    protected void b() {
        this.c.clear();
    }

    protected void c() {
        this.b.clear();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public synchronized void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        try {
            this.j = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused) {
        }
        if (this.j == 2) {
            GlobalSetting.setPersonalizedState(1);
        } else {
            GlobalSetting.setPersonalizedState(0);
        }
        if (ATSDK.isNetworkLogDebug()) {
            Log.i(TAG, "GlobalSetting.getPersonalizedState():" + GlobalSetting.getPersonalizedState());
        }
        a();
        if (this.f) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
            }
            return;
        }
        synchronized (this.h) {
            if (this.g.get()) {
                if (mediationInitCallback != null) {
                    this.i.add(mediationInitCallback);
                }
                return;
            }
            if (this.i == null) {
                this.i = new ArrayList();
            }
            this.g.set(true);
            String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
            if (mediationInitCallback != null) {
                this.i.add(mediationInitCallback);
            }
            if (map.containsKey(ATInitMediation.KEY_LOCAL)) {
                this.d = stringFromMap;
            } else {
                String str = this.d;
                if (str != null && !TextUtils.equals(str, stringFromMap)) {
                    checkToSaveInitData(getNetworkName(), map, this.d);
                    this.d = null;
                }
            }
            GDTAdSdk.initWithoutStart(context.getApplicationContext(), stringFromMap);
            GDTAdSdk.start(new a());
        }
    }

    protected boolean b(Map map, Map<String, Object> map2) {
        try {
            map.put("meSrc", "299");
            Object obj = map2.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.MEDIATION_WF_ID);
            map.put("thrmei", obj != null ? obj.toString() : "");
            if (ATInitMediation.getIntFromMap(map2, "load_params_switch", 1) == 2) {
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

    protected void a(String str, WeakReference weakReference) {
        try {
            this.a.put(str, weakReference);
        } catch (Throwable unused) {
        }
    }

    protected void a(String str, RewardVideoAD rewardVideoAD) {
        this.b.clear();
        this.b.put(str, rewardVideoAD);
    }

    protected void a(String str, UnifiedInterstitialAD unifiedInterstitialAD) {
        this.c.clear();
        this.c.put(str, unifiedInterstitialAD);
    }

    protected void a() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.a.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.a.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, String str2) {
        synchronized (this.h) {
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                MediationInitCallback mediationInitCallback = this.i.get(i);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            this.i.clear();
            this.g.set(false);
        }
    }

    protected int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    void a(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        getInstance().initSDK(context, map, new b(map, map2, aTBidRequestInfoListener));
    }

    protected LoadAdParams a(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (!b(map2, map)) {
            return null;
        }
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setDevExtra(map2);
        return loadAdParams;
    }

    protected Map<String, Object> a(Map<String, Object> map, Map<String, Object> map2) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    if (map2 == null) {
                        map2 = new HashMap();
                    }
                    map2.putAll(map);
                    Object obj = map.get("request_id");
                    if (obj != null) {
                        Object obj2 = map2.get("nw_extra_info");
                        JSONObject jSONObject = obj2 instanceof JSONObject ? (JSONObject) obj2 : new JSONObject();
                        jSONObject.put("request_id", obj.toString());
                        map2.put("nw_extra_info", jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return map2;
    }
}
