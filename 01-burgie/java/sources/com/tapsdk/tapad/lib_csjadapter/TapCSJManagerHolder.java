package com.tapsdk.tapad.lib_csjadapter;

import android.content.Context;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import com.tapsdk.tapad.group.adapter.AdapterInitCallback;
import com.tapsdk.tapad.group.adapter.AdapterInitConfig;
import com.tapsdk.tapad.group.adapter.AdapterInitializer;
import com.tapsdk.tapad.group.adapter.AdapterLocation;
import com.tapsdk.tapad.lib_csjadapter.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class TapCSJManagerHolder implements AdapterInitializer {
    private static final int MIN_SUPPORTED_SDK_INT = 24;
    private static final String SUPPORTED_CSJ_VERSION = "7.7.1.4";
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
        return "7.7.1.4";
    }

    public static String dirichletActualPartnerVersion() {
        return TTAdSdk.getAdManager().getSDKVersion();
    }

    public static boolean dirichletPlatformSupported() {
        return Build.VERSION.SDK_INT >= 24 && Os.sysconf(OsConstants._SC_PAGE_SIZE) != PlaybackStateCompat.ACTION_PREPARE;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterInitializer
    public void initialize(Context context, final AdapterInitConfig config, final AdapterInitCallback callback) {
        String oldAppId = Utils.getAppId();
        if (!TextUtils.isEmpty(oldAppId) && !config.getMediaId().equals(oldAppId)) {
            Log.e("DirichletAD", "有历史非Dirichlet聚合穿山甲appId，请迁移");
            callback.onFailure(-1, "有历史非Dirichlet聚合穿山甲appId，请迁移, 历史old app_id:" + oldAppId);
            return;
        }
        List<Integer> networkStatus = new ArrayList<>();
        int directDownloadType = config.getDirectDownloadNetworkType();
        if ((directDownloadType & 1) != 0) {
            networkStatus.add(1);
        }
        if ((directDownloadType & 2) != 0) {
            networkStatus.add(4);
        }
        if ((directDownloadType & 4) != 0) {
            networkStatus.add(2);
        }
        if ((directDownloadType & 8) != 0) {
            networkStatus.add(3);
        }
        if ((directDownloadType & 16) != 0) {
            networkStatus.add(5);
        }
        if ((directDownloadType & 32) != 0) {
            networkStatus.add(6);
        }
        int[] netStatus = new int[networkStatus.isEmpty() ? 1 : networkStatus.size()];
        for (int i = 0; i < networkStatus.size(); i++) {
            netStatus[i] = networkStatus.get(i).intValue();
        }
        if (networkStatus.isEmpty()) {
            netStatus[0] = 4;
        }
        TTAdSdk.init(context, new TTAdConfig.Builder().appId(config.getMediaId()).appName(config.getMediaName()).titleBarTheme(config.getTheme()).allowShowNotify(config.isAllowShowNotify()).debug(config.isDebug()).data(config.getData()).directDownloadNetworkType(netStatus).supportMultiProcess(config.isSupportMultiProcess()).customController(new TTCustomController() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJManagerHolder.1
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                return config.isCanUseCoarseWifiLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public LocationProvider getTTLocation() {
                final AdapterLocation location;
                if (config.isCanUseCoarseWifiLocation() && (location = config.getLocation()) != null) {
                    return new LocationProvider() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJManagerHolder.1.1
                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                        public double getLatitude() {
                            return location.getLatitude();
                        }

                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                        public double getLongitude() {
                            return location.getLongitude();
                        }
                    };
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                return config.isCanGetInstallList();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                return config.isCanUsePhoneState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevImei() {
                return config.getImei();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                return config.isCanUseCoarseWifiLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getMacAddress() {
                return config.isCanUseCoarseWifiLocation() ? super.getMacAddress() : "";
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                return config.isCanUseWriteExternal();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                return config.getOaid();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                return config.isCanUseAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public IMediationPrivacyConfig getMediationPrivacyConfig() {
                return new MediationPrivacyConfig() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJManagerHolder.1.2
                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public List<String> getCustomDevImeis() {
                        String imei = config.getImei();
                        return TextUtils.isEmpty(imei) ? Collections.emptyList() : Collections.singletonList(imei);
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public List<String> getCustomAppList() {
                        return Collections.emptyList();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isLimitPersonalAds() {
                        return !config.isPersonalizedAdEnabled();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isProgrammaticRecommend() {
                        return config.isPersonalizedAdEnabled();
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getAndroidId() {
                return "";
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePermissionRecordAudio() {
                return config.isCanUseRecordAudio();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public Map<String, Object> userPrivacyConfig() {
                HashMap<String, Object> privacyConfig = new HashMap<>();
                privacyConfig.put("mcod", "0");
                privacyConfig.put("motion_info", config.isCanUseSensor() ? "1" : "0");
                return privacyConfig;
            }
        }).build());
        TTAdSdk.start(new TTAdSdk.Callback() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJManagerHolder.2
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                TapCSJManagerHolder.initSuccess.set(true);
                callback.onSuccess();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i2, String s) {
                TapCSJManagerHolder.initSuccess.set(false);
                callback.onFailure(i2, s);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterInitializer
    public void updateGlobalSettings(AdapterInitConfig config, String key, String value) {
        TTAdConfig ttAdConfig = new TTAdConfig.Builder().data(config.getData()).build();
        TTAdSdk.updateAdConfig(ttAdConfig);
    }
}
