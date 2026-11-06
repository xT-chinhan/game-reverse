package com.smartdigimkt.sdk.api;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class SDMAdxSetting {
    public static final int MODE_MEDIATION = 0;
    public static final int MODE_NETWORK = 1;
    public static final String TAG = "sdm_adx_setting";
    private static volatile SDMAdxSetting instance;
    private Map<String, Integer> modeMap;

    public static SDMAdxSetting getInstance() {
        if (instance == null) {
            synchronized (SDMAdxSetting.class) {
                if (instance == null) {
                    instance = new SDMAdxSetting();
                }
            }
        }
        return instance;
    }

    public boolean isAdxNetworkMode(String str) {
        Integer num;
        return (this.modeMap == null || TextUtils.isEmpty(str) || (num = this.modeMap.get(str)) == null || num.intValue() != 1) ? false : true;
    }

    public void openAdxNetworkMode(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.modeMap == null) {
            this.modeMap = new ConcurrentHashMap();
        }
        this.modeMap.put(str, 1);
    }
}
