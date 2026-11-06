package com.tapsdk.tapad.internal.oaid;

import com.tapsdk.tapad.internal.observability.AdnTelemetryHost;
import com.tapsdk.tapad.oaid.OAIDErrorReporter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OAIDErrorReporterImpl implements OAIDErrorReporter {
    @Override // com.tapsdk.tapad.oaid.OAIDErrorReporter
    public boolean sendLog(Map<String, String> map) {
        AdnTelemetryHost.reportFact(5, new HashMap(map));
        return true;
    }
}
