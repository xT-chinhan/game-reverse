package com.tapsdk.tapad.lib_gdtadapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.tapsdk.tapad.group.adapter.AdapterInitCallback;
import com.tapsdk.tapad.group.adapter.AdapterInitConfig;
import com.tapsdk.tapad.group.adapter.AdapterInitializer;
import com.tapsdk.tapad.lib_gdtadapter.utils.Utils;
import com.taptap.sdk.db.constant.Common;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class TapGDTManagerHolder implements AdapterInitializer {
    private static final String SUPPORTED_GDT_VERSION = "4.701.1571";
    static AtomicBoolean initSuccess = new AtomicBoolean(false);

    public static int dirichletAdapterVersionRule() {
        return 1;
    }

    public static int dirichletPartnerVersionRule() {
        return 1;
    }

    public static int dirichletCapabilityMask() {
        return 63;
    }

    public static String dirichletPinnedPartnerVersion() {
        return SUPPORTED_GDT_VERSION;
    }

    public static String dirichletActualPartnerVersion() {
        return SDKStatus.getIntegrationSDKVersion();
    }

    public static boolean dirichletPlatformSupported() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tapsdk.tapad.group.adapter.AdapterInitializer
    public void initialize(Context context, AdapterInitConfig adapterInitConfig, final AdapterInitCallback adapterInitCallback) {
        String oldAppId = Utils.getOldAppId();
        if (!TextUtils.isEmpty(oldAppId) && !adapterInitConfig.getMediaId().equals(oldAppId)) {
            Log.e("DirichletAD", "有历史非Dirichlet聚合优量汇appId，请迁移");
            adapterInitCallback.onFailure(-1, "有历史非Dirichlet聚合优量汇appId，请迁移, 历史old app_id:" + oldAppId);
            return;
        }
        if (adapterInitConfig.isSupportMultiProcess()) {
            MultiProcessFlag.setMultiProcess(true);
        }
        GlobalSetting.setAgreeReadDeviceId(adapterInitConfig.isCanUsePhoneState());
        GlobalSetting.setAgreeReadAndroidId(adapterInitConfig.isCanUseAndroidId());
        GlobalSetting.setEnableCollectAppInstallStatus(adapterInitConfig.isCanGetInstallList());
        GlobalSetting.setAgreeReadPrivacyInfo(getPrivacyInfo(adapterInitConfig));
        GlobalSetting.setPersonalizedState(!adapterInitConfig.isPersonalizedAdEnabled() ? 1 : 0);
        HashMap map = new HashMap();
        map.put("soate", Boolean.valueOf(adapterInitConfig.isSoate()));
        map.put("hieib", false);
        GlobalSetting.setConvOptimizeInfo(map);
        GlobalSetting.setChannel((int) adapterInitConfig.getChannel());
        HashMap map2 = new HashMap();
        map2.put("sensor_ts", (adapterInitConfig.isCanUseSensor() && adapterInitConfig.isEnableShake()) ? "1" : "0");
        map2.put("shakable", (adapterInitConfig.isCanUseSensor() && adapterInitConfig.isEnableShake()) ? "1" : "0");
        GlobalSetting.setExtraUserData(map2);
        GDTAdSdk.initWithoutStart(context, adapterInitConfig.getMediaId());
        GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTManagerHolder.1
            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartSuccess() {
                TapGDTManagerHolder.initSuccess.set(true);
                adapterInitCallback.onSuccess();
            }

            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartFailed(Exception error) {
                String stackTraceString;
                TapGDTManagerHolder.initSuccess.set(false);
                Log.e("DirichletAD", "GDT SDK start failed", error);
                AdapterInitCallback adapterInitCallback2 = adapterInitCallback;
                if (error == null) {
                    stackTraceString = "GDT SDK start failed without exception";
                } else {
                    stackTraceString = Log.getStackTraceString(error);
                }
                adapterInitCallback2.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, stackTraceString);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterInitializer
    public void updateGlobalSettings(AdapterInitConfig adapterInitConfig, String str, String str2) {
        GlobalSetting.setPersonalizedState(!adapterInitConfig.isPersonalizedAdEnabled() ? 1 : 0);
    }

    private static Map<String, Boolean> getPrivacyInfo(AdapterInitConfig config) {
        Map<String, Boolean> privacyInfo = new HashMap<>();
        privacyInfo.put("cell_id", false);
        privacyInfo.put("device_id", Boolean.valueOf(config.isCanUsePhoneState()));
        privacyInfo.put(Common.Predefined.SUB_ANDROID_ID, Boolean.valueOf(config.isCanUseAndroidId()));
        privacyInfo.put("mipaddr", Boolean.valueOf(config.isCanUseWifiState()));
        privacyInfo.put("wipaddr", Boolean.valueOf(config.isCanUseWifiState()));
        return privacyInfo;
    }
}
