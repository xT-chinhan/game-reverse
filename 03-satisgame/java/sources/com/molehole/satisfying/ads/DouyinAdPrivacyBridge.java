package com.molehole.satisfying.ads;

import com.anythink.network.ks.KSATCustomController;
import com.anythink.network.ks.KSATInitManager;
import com.kwad.sdk.api.KsCustomController;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class DouyinAdPrivacyBridge {
    private DouyinAdPrivacyBridge() {
    }

    public static synchronized boolean disableAppInstallStatusCollection() {
        HashMap map = new HashMap();
        map.put("hieib", false);
        GlobalSetting.setConvOptimizeInfo(map);
        GlobalSetting.setEnableCollectAppInstallStatus(false);
        KSATInitManager.getInstance().setKSATCustomController(new KSATCustomController() { // from class: com.molehole.satisfying.ads.DouyinAdPrivacyBridge.1
            @Override // com.anythink.network.ks.KSATCustomController
            public KsCustomController getKsCustomeController() {
                return new KsCustomController() { // from class: com.molehole.satisfying.ads.DouyinAdPrivacyBridge.1.1
                    @Override // com.kwad.sdk.api.KsCustomController
                    public boolean canReadInstalledPackages() {
                        return false;
                    }
                };
            }
        });
        return true;
    }
}
