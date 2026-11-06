package com.tapsdk.tapad.internal.observability;

import com.tapsdk.tapad.internal.InterErrCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class InterErrorUtils {
    public static void trackInternalError(InterErrCode interErrCode, Throwable th, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        map2.put("adn_inter_error_code", Integer.valueOf(interErrCode.getCode()));
        map2.put("adn_inter_error_desc", interErrCode.getDesc());
        map2.putAll(map);
        AdnTelemetryHost.reportThrowable("adn_internal_error", th, map2);
    }

    public static void trackInternalError(InterErrCode interErrCode, Throwable th) {
        trackInternalError(interErrCode, th, Collections.EMPTY_MAP);
    }
}
