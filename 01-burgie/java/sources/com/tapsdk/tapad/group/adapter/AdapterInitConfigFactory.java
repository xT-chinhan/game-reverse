package com.tapsdk.tapad.group.adapter;

import com.tapsdk.tapad.TapAdCustomController;
import com.tapsdk.tapad.TapAdLocation;
import com.tapsdk.tapad.group.DirichletAdConfig;
import com.tapsdk.tapad.group.DirichletAdCustomController;
import com.tapsdk.tapad.group.DirichletAdLocation;
import com.tapsdk.tapad.internal.oaid.OaidHelper;
import com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterInitConfigFactory {
    private static final int DIRECT_CHANNEL = 999;
    private static final int DIRECT_DOWNLOAD_NETWORK_TYPE = 4;
    private static final int DIRECT_TITLE_BAR_THEME = 0;

    private AdapterInitConfigFactory() {
    }

    public static void bindPrivacyController(DirichletAdCustomController dirichletAdCustomController) {
        if (dirichletAdCustomController == null) {
            throw new IllegalArgumentException("missing privacy controller");
        }
        AndroidEnvironmentHost.bindAdnController(rawPrivacyController(dirichletAdCustomController));
    }

    private static AdapterInitConfig create(DirichletAdConfig dirichletAdConfig, DirichletAdCustomController dirichletAdCustomController, String str, String str2, String str3, long j, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, int i2, boolean z8, boolean z9) {
        return new AdapterInitConfig(str, dirichletAdConfig.mMediaName, str2, dirichletAdConfig.mTapClientId, str3, j, dirichletAdCustomController.isCanUsePhoneState(), dirichletAdCustomController.isCanUseWifiState(), dirichletAdCustomController.isCanUseWriteExternal(), dirichletAdCustomController.alist(), dirichletAdConfig.mIsDebug, dirichletAdCustomController.isCanUseAndroidId(), dirichletAdCustomController.isCanUseLocation(), dirichletAdConfig.shakeEnabled, z, z2, z3 && dirichletAdCustomController.isCanUsePhoneMacAddress(), z4, z7, z5, z6, i, i2, z8, z9, deviceSource(dirichletAdCustomController), rawPrivacyController(dirichletAdCustomController));
    }

    private static AdapterInitConfig.DeviceSource deviceSource(final DirichletAdCustomController dirichletAdCustomController) {
        return new AdapterInitConfig.DeviceSource() { // from class: com.tapsdk.tapad.group.adapter.AdapterInitConfigFactory.1
            @Override // com.tapsdk.tapad.group.adapter.AdapterInitConfig.DeviceSource
            public String getImei() {
                return dirichletAdCustomController.isCanUsePhoneState() ? dirichletAdCustomController.getDevImei() : "";
            }

            @Override // com.tapsdk.tapad.group.adapter.AdapterInitConfig.DeviceSource
            public AdapterLocation getLocation() {
                DirichletAdLocation dirichletAdLocation = dirichletAdCustomController.getDirichletAdLocation();
                if (dirichletAdLocation == null) {
                    return null;
                }
                return new AdapterLocation(dirichletAdLocation.latitude, dirichletAdLocation.longitude, dirichletAdLocation.accuracy);
            }

            @Override // com.tapsdk.tapad.group.adapter.AdapterInitConfig.DeviceSource
            public String getOaid() {
                return OaidHelper.getInstance().getOaid();
            }
        };
    }

    public static AdapterInitConfig direct(DirichletAdConfig dirichletAdConfig, JSONObject jSONObject) {
        DirichletAdCustomController dirichletAdCustomControllerRequireController = requireController(dirichletAdConfig);
        validatePublisherProjection(jSONObject);
        return create(dirichletAdConfig, dirichletAdCustomControllerRequireController, String.valueOf(dirichletAdConfig.mMediaId), dirichletAdConfig.mMediaKey, jSONObject.getString("effective_data"), 999L, true, true, true, true, true, true, jSONObject.getBoolean("is_personalized_ad_enabled"), 0, 4, false, true);
    }

    public static AdapterInitConfig fromCoreProjection(JSONObject jSONObject, DirichletAdConfig dirichletAdConfig, JSONObject jSONObject2) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("missing adapter init projection");
        }
        DirichletAdCustomController dirichletAdCustomControllerRequireController = requireController(dirichletAdConfig);
        validatePublisherProjection(jSONObject2);
        return create(dirichletAdConfig, dirichletAdCustomControllerRequireController, jSONObject.getString("network_media_id"), "", jSONObject2.getString("effective_data"), jSONObject.getLong("channel"), jSONObject.getBoolean("is_can_user_record_audio"), jSONObject.getBoolean("is_allow_show_notify"), jSONObject.getBoolean("is_can_use_phone_mac_address"), jSONObject.getBoolean("is_personal_sever_ad"), jSONObject.getBoolean("is_adx_server_ad"), jSONObject.getBoolean("is_can_listening_install"), jSONObject2.getBoolean("is_personalized_ad_enabled"), jSONObject.getInt("theme"), jSONObject.getInt("direct_download_net_type"), jSONObject.getBoolean("is_support_multi_process"), jSONObject.getBoolean("is_soate"));
    }

    private static TapAdCustomController rawPrivacyController(final DirichletAdCustomController dirichletAdCustomController) {
        return new TapAdCustomController() { // from class: com.tapsdk.tapad.group.adapter.AdapterInitConfigFactory.2
            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean alist() {
                return dirichletAdCustomController.alist();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public String getDevImei() {
                return "";
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public String getDevOaid() {
                return dirichletAdCustomController.getDevOaid();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public TapAdLocation getTapAdLocation() {
                DirichletAdLocation dirichletAdLocation = dirichletAdCustomController.getDirichletAdLocation();
                if (dirichletAdLocation == null) {
                    return null;
                }
                return new TapAdLocation(dirichletAdLocation.latitude, dirichletAdLocation.longitude, dirichletAdLocation.accuracy);
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseAndroidId() {
                return dirichletAdCustomController.isCanUseAndroidId();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseBssid() {
                return dirichletAdCustomController.isCanUseBssid();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseLocation() {
                return dirichletAdCustomController.isCanUseLocation();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUsePhoneMacAddress() {
                return dirichletAdCustomController.isCanUsePhoneMacAddress();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUsePhoneState() {
                return dirichletAdCustomController.isCanUsePhoneState();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseSensor() {
                return dirichletAdCustomController.isCanUseSensor();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseSsid() {
                return dirichletAdCustomController.isCanUseSsid();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseWifiState() {
                return dirichletAdCustomController.isCanUseWifiState();
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseWriteExternal() {
                return dirichletAdCustomController.isCanUseWriteExternal();
            }
        };
    }

    public static void refreshPublisherSettings(AdapterInitConfig adapterInitConfig, JSONObject jSONObject) {
        if (adapterInitConfig == null) {
            return;
        }
        validatePublisherProjection(jSONObject);
        adapterInitConfig.refreshRuntimeSettings(jSONObject.getString("effective_data"), jSONObject.getBoolean("is_personalized_ad_enabled"));
    }

    private static DirichletAdCustomController requireController(DirichletAdConfig dirichletAdConfig) {
        DirichletAdCustomController dirichletAdCustomController;
        if (dirichletAdConfig == null || (dirichletAdCustomController = dirichletAdConfig.mCustomController) == null) {
            throw new IllegalArgumentException("missing SDK config facts");
        }
        return dirichletAdCustomController;
    }

    private static void validatePublisherProjection(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.getInt("schema_version") != 1 || !"shared_rust".equals(jSONObject.getString("owner")) || !"publisher_settings".equals(jSONObject.getString("kind"))) {
            throw new IllegalArgumentException("invalid publisher settings projection");
        }
    }
}
