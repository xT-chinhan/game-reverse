package com.anythink.network.adx;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.ATUserDeviceInfo;
import com.anythink.core.api.MediationInitCallback;
import com.smartdigimkt.sdk.api.ISDMAdManager;
import com.smartdigimkt.sdk.api.IntegrationCheckListener;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMInitConfig;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.api.SDMSetting;
import com.smartdigimkt.sdk.api.SDMUserDeviceInfo;
import com.smartdigimkt.sdk.api.format.SDMAdHandler;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import com.smartdigimkt.sdk.api.format.SDMWinInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AdxATInitManager extends ATInitMediation {
    private static String e = "AdxATInitManager";
    private static volatile AdxATInitManager f;
    private boolean a;
    private List<MediationInitCallback> c;
    private AtomicBoolean b = new AtomicBoolean(false);
    private final Object d = new Object();

    class a implements IntegrationCheckListener {
        final /* synthetic */ MediationInitCallback a;

        a(MediationInitCallback mediationInitCallback) {
            this.a = mediationInitCallback;
        }

        @Override // com.smartdigimkt.sdk.api.IntegrationCheckListener
        public void onValidationFail(String str) {
            MediationInitCallback mediationInitCallback = this.a;
            if (mediationInitCallback != null) {
                mediationInitCallback.onFail(str);
            }
        }

        @Override // com.smartdigimkt.sdk.api.IntegrationCheckListener
        public void onValidationSucceed() {
            MediationInitCallback mediationInitCallback = this.a;
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
            }
        }
    }

    class b implements SDMSDK.InitCallBack {
        b() {
        }

        @Override // com.smartdigimkt.sdk.api.SDMSDK.InitCallBack
        public void fail(String str) {
            String unused = AdxATInitManager.e;
            AdxATInitManager.this.a(false, str);
        }

        @Override // com.smartdigimkt.sdk.api.SDMSDK.InitCallBack
        public void success() {
            AdxATInitManager.this.a = true;
            AdxATRewardRetryTaskContractManager.install();
            AdxATInitManager.this.a(true, "");
        }
    }

    class c implements MediationInitCallback {
        final /* synthetic */ Map a;
        final /* synthetic */ Map b;
        final /* synthetic */ boolean c;
        final /* synthetic */ ATBidRequestInfoListener d;

        class a implements ISDMAdManager.BidTokenCallBack {
            a() {
            }

            @Override // com.smartdigimkt.sdk.api.ISDMAdManager.BidTokenCallBack
            public void onComplete(JSONObject jSONObject) {
                if (jSONObject == null) {
                    c.this.d.onFailed("Adx getBidTokenJSONObject fail");
                    return;
                }
                AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(jSONObject);
                c cVar = c.this;
                adxBidRequestInfo.fillLocalExtra(cVar.b, cVar.c);
                c.this.d.onSuccess(adxBidRequestInfo);
            }
        }

        c(Map map, Map map2, boolean z, ATBidRequestInfoListener aTBidRequestInfoListener) {
            this.a = map;
            this.b = map2;
            this.c = z;
            this.d = aTBidRequestInfoListener;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            ATBidRequestInfoListener aTBidRequestInfoListener = this.d;
            if (aTBidRequestInfoListener != null) {
                aTBidRequestInfoListener.onFailed(str);
            }
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            SDMSDK.getInstance().getSDMAdManager().getBidTokenJSONObject(this.a, new a());
        }
    }

    private SDMUserDeviceInfo b(Map<String, Object> map) {
        Object obj = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_USER_DEVICE_INFO);
        if (!(obj instanceof ATUserDeviceInfo)) {
            return null;
        }
        ATUserDeviceInfo aTUserDeviceInfo = (ATUserDeviceInfo) obj;
        SDMUserDeviceInfo sDMUserDeviceInfo = new SDMUserDeviceInfo();
        sDMUserDeviceInfo.setDevImei(aTUserDeviceInfo.getDevImei());
        sDMUserDeviceInfo.setDevOaid(aTUserDeviceInfo.getDevOaid());
        sDMUserDeviceInfo.setDevUID2Token(aTUserDeviceInfo.getDevUID2Token());
        return sDMUserDeviceInfo;
    }

    public static AdxATInitManager getInstance() {
        if (f == null) {
            synchronized (AdxATInitManager.class) {
                if (f == null) {
                    f = new AdxATInitManager();
                }
            }
        }
        return f;
    }

    protected void c(Map<String, Object> map) {
        SDMSetting setting = SDMSDK.getInstance().getSetting();
        Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(66);
        if (boolIsShakeEnabled != null) {
            if (boolIsShakeEnabled.booleanValue()) {
                setting.undeniedUploadDeviceInfo("sensor_deny");
            } else {
                setting.deniedUploadDeviceInfo("sensor_deny");
            }
        }
        setting.setPersonalizedAdStatus(ATSDK.getPersionalizedAdStatus());
        Object obj = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_EXCLUDE_PKG_LIST);
        if (obj == null || !(obj instanceof List)) {
            return;
        }
        try {
            setting.setExcludePkgList((List) obj);
        } catch (Throwable unused) {
        }
    }

    public Map<String, Object> fillNetworkInfoMap(Map<String, Object> map, Map<String, Object> map2) {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        String strValueOf = "";
        if (map != null) {
            try {
                Object obj = map.get("creative_id");
                if (obj != null) {
                    strValueOf = String.valueOf(obj);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(strValueOf)) {
            return map2;
        }
        Object obj2 = map2.get("nw_extra_info");
        JSONObject jSONObject = obj2 instanceof JSONObject ? (JSONObject) obj2 : new JSONObject();
        jSONObject.put("creative_id", strValueOf);
        map2.put("nw_extra_info", jSONObject);
        return map2;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public int getAdapterBridgeVersion() {
        return 1;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getAdapterVersion() {
        return "6.5.90.1.0";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Adx";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.smartdigimkt.sdk.api.SDMSDK";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return SDMSDK.getInstance().getSDKVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getResourceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("sdm_myoffer_full_screen");
        arrayList.add("sdm_myoffer_splash_ad_layout_asseblem_vertical_port");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        if (ATInitMediation.getIntFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PRECHECK_MODE, 0) == 1) {
            a(context, map);
            SDMSDK.getInstance().integrationChecking(context, map, new a(mediationInitCallback));
            return;
        }
        c(map);
        if (this.a) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.d) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (mediationInitCallback != null) {
                this.c.add(mediationInitCallback);
            }
            if (this.b.get()) {
                return;
            }
            this.b.set(true);
            a(context, map);
            SDMInitConfig.Builder builder = new SDMInitConfig.Builder(ATInitMediation.getStringFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_APP_ID, ""), ATInitMediation.getStringFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_APP_KEY, ""));
            String bundleName = getBundleName();
            if (!TextUtils.isEmpty(bundleName)) {
                builder.setBundleName(bundleName);
            }
            String stringFromMap = ATInitMediation.getStringFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_SYSTEM_DEV_FRAMEWORK_TYPE);
            if (!TextUtils.isEmpty(stringFromMap)) {
                builder.setSystemDevFrameworkType(stringFromMap);
            }
            builder.setExtraMap(map);
            SDMSDK.getInstance().init(context, builder.build());
            SDMSDK.getInstance().start(new b());
        }
    }

    public void notifyWLInfo(int i, Map<String, Object> map, SDMAdHandler sDMAdHandler) {
        if (map == null || map.isEmpty() || sDMAdHandler == null) {
            return;
        }
        if (i == 1) {
            sDMAdHandler.notifyWin(new SDMWinInfo(0.0d, SDMAdConst.CURRENCY.USD, map));
        } else if (i == 2) {
            sDMAdHandler.notifyLoss(new SDMLossInfo(SDMLossInfo.LOSS_REASON.LOSS_TO_OTHER, 0.0d, SDMLossInfo.SEAT_ID.SELF_SALE, SDMAdConst.CURRENCY.USD, map));
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public boolean setUserDataConsent(Context context, boolean z, boolean z2) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        synchronized (this.d) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                MediationInitCallback mediationInitCallback = this.c.get(i);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str);
                    }
                }
            }
            this.c.clear();
            this.b.set(false);
        }
    }

    void a(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener, boolean z) {
        getInstance().initSDK(context, map, new c(map, map2, z, aTBidRequestInfoListener));
    }

    private void a(Context context, Map<String, Object> map) {
        SDMSetting setting = SDMSDK.getInstance().getSetting();
        setting.setDebug(ATSDK.isNetworkLogDebug());
        setting.setUserDeviceInfo(b(map));
        setting.deniedUploadDeviceInfo(a(map));
        if (map.containsKey(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_LOCATION)) {
            Object obj = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_LOCATION);
            if (obj instanceof Location) {
                setting.setLocation((Location) obj);
            }
        }
        setting.setWxInstallStatus(ATInitMediation.getBooleanFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_WX_INSTALL_STATUS));
        setting.setEnableGetRunningAppProcesses(ATInitMediation.getBooleanFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_ENABLE_GET_RUNNING_APP_PROCESSES));
        setting.setEnableGetDeviceInfoInBg(ATInitMediation.getBooleanFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_ENABLE_GET_DEVICE_INFO_IN_BG));
        setting.setInspectInterval(ATInitMediation.getLongFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_INSPECT_INTERVAL));
        setting.setDelayInspectTime(ATInitMediation.getLongFromMap(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_DELAY_INSPECT_TIME));
        setting.setPersonalizedAdStatus(ATSDK.getPersionalizedAdStatus());
        setting.setWxAppId(ATInitMediation.getStringFromMap(map, ATAdConst.KEY.WECHAT_APPID));
    }

    private String[] a(Map<String, Object> map) {
        if (map != null && map.containsKey(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_DENNY_DEVICE_INFO)) {
            Object obj = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_DENNY_DEVICE_INFO);
            if (obj instanceof String[]) {
                return (String[]) obj;
            }
        }
        return null;
    }
}
