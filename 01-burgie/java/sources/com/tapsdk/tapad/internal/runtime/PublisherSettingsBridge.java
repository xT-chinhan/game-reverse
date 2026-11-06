package com.tapsdk.tapad.internal.runtime;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class PublisherSettingsBridge {
    private static final String EXPORT_REPLACE = "adn_publisher_settings_replace_v1";
    private static final String TAG = "PublisherSettingsBridge";

    private PublisherSettingsBridge() {
    }

    public static synchronized boolean put(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            if (!DirichletRuntime.putPublisherSetting(str, str2)) {
                return false;
            }
            DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
            if (dirichletRuntime.isOnRuntimeQueue()) {
                refreshCore();
            } else {
                dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.PublisherSettingsBridge$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PublisherSettingsBridge.refreshCore();
                    }
                });
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void refreshCore() {
        try {
            WasmModule module = DirichletRuntime.getInstance().getModule("core");
            if (module == null || module.isUnloaded() || !module.hasFunction(EXPORT_REPLACE)) {
                return;
            }
            module.callVoidSync(EXPORT_REPLACE, snapshot().toString());
        } catch (Throwable th) {
        }
    }

    public static JSONObject snapshot() {
        try {
            String strPublisherSettingsSnapshot = DirichletRuntime.publisherSettingsSnapshot();
            if (strPublisherSettingsSnapshot == null) {
                strPublisherSettingsSnapshot = "{}";
            }
            return new JSONObject(strPublisherSettingsSnapshot);
        } catch (Throwable th) {
            return new JSONObject();
        }
    }

    public static Map<String, String> snapshotMap() {
        JSONObject jSONObjectSnapshot = snapshot();
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObjectSnapshot.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObjectSnapshot.optString(next, "");
            if (!strOptString.isEmpty()) {
                map.put(next, strOptString);
            }
        }
        return map;
    }
}
