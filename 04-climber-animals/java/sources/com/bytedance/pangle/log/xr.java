package com.bytedance.pangle.log;

import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ka.d;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.sl;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static void ms(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        String strMs = Zeus.getAppApplication() != null ? d.ms(d.ms(Zeus.getAppApplication())) : null;
        String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
        if (strMs == null) {
            strMs = "unknown";
        }
        try {
            jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, ms(strMs));
            jSONObject.putOpt("host_package_name", packageName);
            Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
            jSONObject.putOpt("plugin_api_version", ms(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
            jSONObject.putOpt("zeus_sdk_version", ms("0.0.1-beta.4200.115-bugfix.33"));
            ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
            IZeusReporter reporter = GlobalParam.getInstance().getReporter();
            if (reporter != null) {
                JSONObject jSONObject4 = new JSONObject();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject4.putOpt(next, jSONObject.opt(next));
                }
                Iterator<String> itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                }
                Iterator<String> itKeys3 = jSONObject3.keys();
                while (itKeys3.hasNext()) {
                    String next3 = itKeys3.next();
                    jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                }
                reporter.report(str, jSONObject4);
            }
        } catch (JSONException e) {
            ZeusLogger.w(ZeusLogger.TAG_REPORTER, e.getMessage(), e);
        }
    }

    public static String ms(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static int xr(Object obj) {
        if (obj == null) {
            return -1;
        }
        return sl.ms(obj.toString(), -1);
    }

    public static String ms(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
