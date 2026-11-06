package com.anythink.network.toutiao;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATSDK;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTATCustomAdSlotBuilder extends AdSlot.Builder {
    private final String a;

    private TTATCustomAdSlotBuilder() {
        this.a = getClass().getSimpleName();
    }

    public TTATCustomAdSlotBuilder(String str, Map<String, Object> map, Map<String, Object> map2) {
        String simpleName = getClass().getSimpleName();
        this.a = simpleName;
        setCodeId(str);
        try {
            if (map.containsKey(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_LOAD_SEQ)) {
                int iIntValue = ((Integer) map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_LOAD_SEQ)).intValue();
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i(simpleName, "adLoadSeq: ".concat(String.valueOf(iIntValue)));
                }
                setAdloadSeq(iIntValue);
            }
        } catch (Throwable unused) {
        }
        try {
            if (map.containsKey(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.CONTENT)) {
                String strOptString = new JSONObject((String) map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.CONTENT)).optString("slot_id", "");
                if (!TextUtils.isEmpty(strOptString)) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i(this.a, "primeRit: ".concat(String.valueOf(strOptString)));
                    }
                    setPrimeRit(strOptString);
                }
            }
        } catch (Throwable unused2) {
        }
        if (map2 == null || !map2.containsKey(TTATConst.AD_LOAD_TYPE)) {
            return;
        }
        Object obj = map2.get(TTATConst.AD_LOAD_TYPE);
        if (obj instanceof TTAdLoadType) {
            setAdLoadType((TTAdLoadType) obj);
        }
    }
}
