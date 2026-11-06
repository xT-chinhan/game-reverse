package com.tapsdk.tapad;

import android.content.Context;
import com.tapsdk.tapad.internal.utils.TapADLogger;

/* JADX INFO: loaded from: classes3.dex */
public class NativeTapADKitPlugin {
    private static final String TAG = "NativeTapADKitPlugin";

    class a extends TapAdCustomController {
        final /* synthetic */ CustomController a;

        a(CustomController customController) {
            this.a = customController;
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public boolean alist() {
            return this.a.alist();
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public String getDevImei() {
            return this.a.getDevImei();
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public String getDevOaid() {
            return this.a.getDevOaid();
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public TapAdLocation getTapAdLocation() {
            return this.a.getTapAdLocation();
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public boolean isCanUseAndroidId() {
            return this.a.isCanUseAndroidId();
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public boolean isCanUseLocation() {
            return this.a.isCanUseLocation();
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public boolean isCanUsePhoneState() {
            return this.a.isCanUsePhoneState();
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public boolean isCanUseWifiState() {
            return this.a.isCanUseWifiState();
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public boolean isCanUseWriteExternal() {
            return this.a.isCanUseWriteExternal();
        }

        @Override // com.tapsdk.tapad.TapAdCustomController
        public CustomUser provideCustomUser() {
            return this.a.provideCustomUser();
        }
    }

    public void configWaterFlow() {
        com.tapsdk.tapad.internal.j.a.b().a("exp_banner_ui_style", 2);
    }

    public void init(Context context, TapAdConfig tapAdConfig, CustomController customController) {
        TapAdConfig tapAdConfigBuild = new TapAdConfig.Builder().withMediaId(tapAdConfig.mMediaId).withMediaName(tapAdConfig.mMediaName).withMediaKey(tapAdConfig.mMediaKey).enableDebug(tapAdConfig.mIsDebug).withMediaVersion(tapAdConfig.mMediaVersion).withGameChannel(tapAdConfig.gameChannel).withTapClientId(tapAdConfig.mTapClientId).shakeEnabled(tapAdConfig.shakeEnabled).withCustomController(new a(customController)).withData(tapAdConfig.data).build();
        if (customController != null) {
            TapADLogger.d("Unity init: \nisCanUseLocation:" + customController.isCanUseLocation() + "\ngetTapAdLocation:" + customController.getTapAdLocation() + "\nisCanUsePhoneState:" + customController.isCanUsePhoneState() + "\ngetDevImei:" + customController.getDevImei() + "\nisCanUseWifiState:" + customController.isCanUseWifiState() + "\nisCanUseWriteExternal:" + customController.isCanUseWriteExternal() + "\ngetDevOaid:" + customController.getDevOaid() + "\naslist:" + customController.alist() + "\nisCanUseAndroidId:" + customController.isCanUseAndroidId() + "\nprovideCustomUser:" + customController.provideCustomUser() + "\nshakeEnabled:" + tapAdConfigBuild.shakeEnabled + "\n");
        }
        TapAdSdk.init(context, tapAdConfigBuild);
    }

    public void resetExperiment() {
        com.tapsdk.tapad.internal.j.a.b().a();
    }

    public void updateAdConfig(TapAdConfig tapAdConfig) {
        String str = tapAdConfig.data;
        if (str != null && str.length() > 0) {
            String str2 = tapAdConfig.data;
        }
        TapAdSdk.updateAdConfig(new TapAdConfig.Builder().withData(tapAdConfig.data).build());
    }
}
