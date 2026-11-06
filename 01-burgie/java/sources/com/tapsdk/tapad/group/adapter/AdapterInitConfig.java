package com.tapsdk.tapad.group.adapter;

import com.tapsdk.tapad.TapAdCustomController;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterInitConfig {
    private final boolean adxServerAd;
    private final boolean allowShowNotify;
    private final boolean canGetInstallList;
    private final boolean canListenForInstalls;
    private final boolean canUseAndroidId;
    private final boolean canUseLocation;
    private final boolean canUsePhoneMacAddress;
    private final boolean canUsePhoneState;
    private final boolean canUseRecordAudio;
    private final boolean canUseWifiState;
    private final boolean canUseWriteExternal;
    private final long channel;
    private volatile String data;
    private final boolean debug;
    private final DeviceSource deviceSource;
    private final int directDownloadNetworkType;
    private final boolean enableShake;
    private final String mediaId;
    private final String mediaKey;
    private final String mediaName;
    private final boolean personalServerAdAllowed;
    private volatile boolean personalizedAdEnabled;
    private final TapAdCustomController rawPrivacyController;
    private final boolean soate;
    private final boolean supportMultiProcess;
    private final String tapClientId;
    private final int theme;

    public interface DeviceSource {
        String getImei();

        AdapterLocation getLocation();

        String getOaid();
    }

    public AdapterInitConfig(String str, String str2, String str3, String str4, String str5, long j, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i, int i2, boolean z16, boolean z17, DeviceSource deviceSource, TapAdCustomController tapAdCustomController) {
        this.mediaId = safe(str);
        this.mediaName = safe(str2);
        this.mediaKey = safe(str3);
        this.tapClientId = safe(str4);
        this.data = safe(str5);
        this.channel = j;
        this.canUsePhoneState = z;
        this.canUseWifiState = z2;
        this.canUseWriteExternal = z3;
        this.canGetInstallList = z4;
        this.debug = z5;
        this.canUseAndroidId = z6;
        this.canUseLocation = z7;
        this.enableShake = z8;
        this.canUseRecordAudio = z9;
        this.allowShowNotify = z10;
        this.canUsePhoneMacAddress = z11;
        this.personalServerAdAllowed = z12;
        this.personalizedAdEnabled = z13;
        this.adxServerAd = z14;
        this.canListenForInstalls = z15;
        this.theme = i;
        this.directDownloadNetworkType = i2;
        this.supportMultiProcess = z16;
        this.soate = z17;
        this.deviceSource = deviceSource;
        this.rawPrivacyController = tapAdCustomController;
    }

    public static AdapterInitConfig minimal(String str, String str2, boolean z) {
        return new AdapterInitConfig(str, str2, "", "", "", 0L, false, false, false, false, z, false, false, false, false, false, false, false, false, false, false, 0, 0, false, false, null, null);
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    public long getChannel() {
        return this.channel;
    }

    public String getData() {
        return this.data;
    }

    public int getDirectDownloadNetworkType() {
        return this.directDownloadNetworkType;
    }

    public String getImei() {
        DeviceSource deviceSource;
        return (!this.canUsePhoneState || (deviceSource = this.deviceSource) == null) ? "" : safe(deviceSource.getImei());
    }

    public AdapterLocation getLocation() {
        DeviceSource deviceSource;
        if (!isCanUseLocation() || (deviceSource = this.deviceSource) == null) {
            return null;
        }
        return deviceSource.getLocation();
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getMediaKey() {
        return this.mediaKey;
    }

    public String getMediaName() {
        return this.mediaName;
    }

    public String getOaid() {
        DeviceSource deviceSource;
        return (!AndroidPrivacyPolicy.allowsOaid() || (deviceSource = this.deviceSource) == null) ? "" : deviceSource.getOaid();
    }

    public TapAdCustomController getRawPrivacyController() {
        TapAdCustomController tapAdCustomController = this.rawPrivacyController;
        return tapAdCustomController == null ? new TapAdCustomController() { // from class: com.tapsdk.tapad.group.adapter.AdapterInitConfig.1
            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean alist() {
                return false;
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public String getDevImei() {
                return "";
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseAndroidId() {
                return false;
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseBssid() {
                return false;
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseLocation() {
                return false;
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUsePhoneMacAddress() {
                return false;
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUsePhoneState() {
                return false;
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseSensor() {
                return false;
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseSsid() {
                return false;
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseWifiState() {
                return false;
            }

            @Override // com.tapsdk.tapad.TapAdCustomController
            public boolean isCanUseWriteExternal() {
                return false;
            }
        } : tapAdCustomController;
    }

    public String getTapClientId() {
        return this.tapClientId;
    }

    public int getTheme() {
        return this.theme;
    }

    public boolean isAdxServerAd() {
        return this.adxServerAd;
    }

    public boolean isAllowShowNotify() {
        return this.allowShowNotify;
    }

    public boolean isCanGetInstallList() {
        return this.canGetInstallList && AndroidPrivacyPolicy.allowsInstalledApps();
    }

    public boolean isCanListeningInstall() {
        return this.canListenForInstalls && isCanGetInstallList();
    }

    public boolean isCanUseAndroidId() {
        return this.canUseAndroidId && AndroidPrivacyPolicy.allowsAndroidId();
    }

    public boolean isCanUseBssid() {
        TapAdCustomController tapAdCustomController;
        return this.canUseWifiState && (tapAdCustomController = this.rawPrivacyController) != null && tapAdCustomController.isCanUseBssid() && AndroidPrivacyPolicy.allowsBssid();
    }

    public boolean isCanUseCoarseWifiLocation() {
        return isCanUseLocation() && isCanUseBssid() && isCanUseSsid() && isCanUsePhoneMacAddress();
    }

    public boolean isCanUseLocation() {
        return this.canUseLocation && AndroidPrivacyPolicy.allowsLocation();
    }

    public boolean isCanUsePhoneMacAddress() {
        return this.canUsePhoneMacAddress;
    }

    public boolean isCanUsePhoneState() {
        return this.canUsePhoneState;
    }

    public boolean isCanUseRecordAudio() {
        return this.canUseRecordAudio;
    }

    public boolean isCanUseSensor() {
        TapAdCustomController tapAdCustomController = this.rawPrivacyController;
        return tapAdCustomController != null && tapAdCustomController.isCanUseSensor() && AndroidPrivacyPolicy.allowsSensor();
    }

    public boolean isCanUseSsid() {
        TapAdCustomController tapAdCustomController;
        return this.canUseWifiState && (tapAdCustomController = this.rawPrivacyController) != null && tapAdCustomController.isCanUseSsid() && AndroidPrivacyPolicy.allowsSsid();
    }

    public boolean isCanUseWifiState() {
        return this.canUseWifiState;
    }

    public boolean isCanUseWriteExternal() {
        return this.canUseWriteExternal;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isEnableShake() {
        return this.enableShake;
    }

    public boolean isPersonalServerAd() {
        return this.personalizedAdEnabled && this.personalServerAdAllowed;
    }

    public boolean isPersonalizedAdEnabled() {
        return this.personalizedAdEnabled;
    }

    public boolean isSoate() {
        return this.soate;
    }

    public boolean isSupportMultiProcess() {
        return this.supportMultiProcess;
    }

    public void refreshRuntimeSettings(String str, boolean z) {
        this.data = safe(str);
        this.personalizedAdEnabled = z;
    }
}
