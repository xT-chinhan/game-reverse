package com.tapsdk.tapad.lib_iqyadapter;

import android.content.Context;
import com.mcto.sspsdk.QyCustomMade;
import com.mcto.sspsdk.QyLocation;
import com.mcto.sspsdk.QySdk;
import com.mcto.sspsdk.QySdkConfig;
import com.tapsdk.tapad.group.adapter.AdapterInitCallback;
import com.tapsdk.tapad.group.adapter.AdapterInitConfig;
import com.tapsdk.tapad.group.adapter.AdapterInitializer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class TapIQYManagerHolder implements AdapterInitializer {
    static AtomicBoolean initSuccess = new AtomicBoolean(false);

    public static int dirichletAdapterVersionRule() {
        return 0;
    }

    public static int dirichletPartnerVersionRule() {
        return 0;
    }

    public static int dirichletCapabilityMask() {
        return 63;
    }

    public static String dirichletPinnedPartnerVersion() {
        return "";
    }

    public static String dirichletActualPartnerVersion() {
        return QySdk.SDK_VERSION;
    }

    public static boolean dirichletPlatformSupported() {
        return true;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterInitializer
    public void initialize(Context context, final AdapterInitConfig config, final AdapterInitCallback callback) {
        QyCustomMade customMade = new QyCustomMade() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYManagerHolder.1
            @Override // com.mcto.sspsdk.QyCustomMade
            public boolean alist() {
                return config.isCanGetInstallList();
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public String getOaid() {
                return config.getOaid();
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public boolean isCanUsePhoneIMEI() {
                return config.isCanUsePhoneState();
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public boolean isCanUsePhoneAndroidId() {
                return config.isCanUseAndroidId();
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public boolean isCanUsePhoneMacAddress() {
                return config.isCanUsePhoneMacAddress();
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public boolean isCanUsePhoneWifiSSID() {
                return config.isCanUseSsid();
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public String getDevImei() {
                return config.getImei();
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public String getDevMac() {
                return "";
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public String getDevAndroidId() {
                return "";
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public String getWifiSSID() {
                return "";
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public QyLocation getQyLocation() {
                return null;
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public String getPersonalAdSwitch() {
                return config.isPersonalServerAd() ? "0" : "1";
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public String getAdxAdSwitch() {
                return config.isAdxServerAd() ? "1" : "0";
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public boolean canUseNotification() {
                return config.isAllowShowNotify();
            }

            @Override // com.mcto.sspsdk.QyCustomMade
            public boolean canListeningBackground() {
                return config.isCanListeningInstall();
            }
        };
        QySdk.InitCallBack sdkCallback = new QySdk.InitCallBack() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYManagerHolder.2
            @Override // com.mcto.sspsdk.QySdk.InitCallBack
            public void success() {
                TapIQYManagerHolder.initSuccess.set(true);
                callback.onSuccess();
            }

            @Override // com.mcto.sspsdk.QySdk.InitCallBack
            public void fail(int code, String message) {
                TapIQYManagerHolder.initSuccess.set(false);
                callback.onFailure(code, message);
            }
        };
        QySdkConfig sdkConfig = QySdkConfig.newAdConfig().appId(config.getMediaId()).appName(config.getMediaName()).debug(config.isDebug()).qyCustomMade(customMade).build();
        sdkConfig.setForceRequestHttps(true);
        QySdk.init(context, sdkConfig, sdkCallback);
    }
}
