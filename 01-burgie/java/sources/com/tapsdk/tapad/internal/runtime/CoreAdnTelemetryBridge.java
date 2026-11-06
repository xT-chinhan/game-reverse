package com.tapsdk.tapad.internal.runtime;

import com.tapsdk.tapad.internal.observability.AdnTelemetryHost;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class CoreAdnTelemetryBridge {
    private CoreAdnTelemetryBridge() {
    }

    public static boolean reportEvents(String str) {
        try {
            if (str == null) {
                str = "[]";
            }
            return AdnTelemetryHost.deliverCoreEvents(new JSONArray(str));
        } catch (Throwable th) {
            return false;
        }
    }
}
