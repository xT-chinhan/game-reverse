package com.tapsdk.tapad.internal.runtime;

import com.tapsdk.tapad.internal.network.utils.JsonUtil;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class CoreMediationTelemetryBridge {
    private static final int MAX_ENVELOPE_BYTES = 16384;
    private static volatile EnvelopeSink envelopeSink;
    private static volatile FactSink factSink;
    private static volatile Sink sink;

    public interface EnvelopeSink {
        boolean report(JSONObject jSONObject);
    }

    public interface FactSink {
        void report(int i, Map<String, Object> map);
    }

    public interface Sink {
        void report(String str, Map<String, Object> map);
    }

    private CoreMediationTelemetryBridge() {
    }

    public static boolean hasEnvelopeSink() {
        return envelopeSink != null;
    }

    public static void install(Sink sink2) {
        sink = sink2;
    }

    public static void installEnvelopeSink(EnvelopeSink envelopeSink2) {
        envelopeSink = envelopeSink2;
    }

    public static void installFactSink(FactSink factSink2) {
        factSink = factSink2;
    }

    public static boolean report(String str, Map<String, Object> map) {
        Sink sink2 = sink;
        if (sink2 != null && str != null && !str.isEmpty()) {
            try {
                sink2.report(str, map);
                return true;
            } catch (LinkageError e) {
            } catch (RuntimeException e2) {
            }
        }
        return false;
    }

    public static boolean reportFact(int i, Map<String, Object> map) {
        FactSink factSink2 = factSink;
        if (factSink2 != null && i > 0) {
            try {
                factSink2.report(i, map);
                return true;
            } catch (LinkageError e) {
            } catch (RuntimeException e2) {
            }
        }
        return false;
    }

    public static boolean report(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        EnvelopeSink envelopeSink2 = envelopeSink;
        if (envelopeSink2 != null) {
            try {
                return envelopeSink2.report(jSONObject);
            } catch (LinkageError | RuntimeException e) {
                return false;
            }
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("fields");
        if (jSONObjectOptJSONObject == null) {
            return false;
        }
        try {
            return report(jSONObject.optString("event_hash", ""), JsonUtil.toMap(jSONObjectOptJSONObject));
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean report(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && bArr.length <= 16384) {
            try {
                return report(new JSONObject(new String(bArr, StandardCharsets.UTF_8)));
            } catch (Exception e) {
            }
        }
        return false;
    }
}
