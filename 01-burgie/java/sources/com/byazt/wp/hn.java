package com.byazt.wp;

import com.byazt.gs.k;
import com.byazt.wo.x;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1678, 20})
public class hn {
    public static void pr(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        String packageName;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        String strPr = null;
        if (Zeus.getAppApplication() != null) {
            strPr = x.pr(x.pr(Zeus.getAppApplication()));
        }
        if (Zeus.getAppApplication() == null) {
            packageName = "";
        } else {
            packageName = Zeus.getAppApplication().getPackageName();
        }
        if (strPr == null) {
            strPr = "unknown";
        }
        try {
            jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, pr(strPr));
            jSONObject.putOpt("host_package_name", packageName);
            Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
            int apiVersionCode = -1;
            if (plugin != null) {
                apiVersionCode = plugin.getApiVersionCode();
            }
            jSONObject.putOpt("plugin_api_version", pr(Integer.valueOf(apiVersionCode)));
            jSONObject.putOpt("zeus_sdk_version", pr("7.6.0.0-alpha.0"));
            ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
            pr reporter = GlobalParam.getInstance().getReporter();
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
                reporter.pr(str, jSONObject4);
            }
        } catch (JSONException e) {
            ZeusLogger.w(ZeusLogger.TAG_REPORTER, e.getMessage(), e);
        }
    }

    public static String pr(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static int hw(Object obj) {
        if (obj == null) {
            return -1;
        }
        return k.pr(obj.toString(), -1);
    }

    public static String pr(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
