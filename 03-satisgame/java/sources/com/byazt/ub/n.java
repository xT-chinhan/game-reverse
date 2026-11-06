package com.byazt.ub;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.l.f;
import com.byazt.yw.sz;
import com.byazt.yw.tj;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1675, 19})
public class n {
    public JSONObject n;

    public n() {
        this.n = new JSONObject();
    }

    public n(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public static n n(long j, Context context, Thread thread, Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        n nVar = new n();
        nVar.n("isJava", (Object) 1);
        nVar.n("event_type", "java_crash");
        nVar.n(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        nVar.n(f.R, sz.n(th));
        nVar.n("isOOM", Boolean.valueOf(sz.qg(th)));
        nVar.n("crash_time", Long.valueOf(j));
        nVar.n(ContentProviderManager.PLUGIN_PROCESS_NAME, com.byazt.yw.n.q(context));
        if (!com.byazt.yw.n.qg(context)) {
            nVar.n("remote_process", (Object) 1);
        }
        com.byazt.yw.n.n(context, nVar.n());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            nVar.n("crash_thread_name", name);
        }
        nVar.n("all_thread_stacks", sz.n(name));
        return nVar;
    }

    public JSONObject n() {
        return this.n;
    }

    public n n(qg qgVar) {
        n("header", qgVar.n());
        return this;
    }

    public n n(long j) {
        try {
            n(com.anythink.core.common.d.f.a, Long.valueOf(j));
            n("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception unused) {
        }
        return this;
    }

    public n n(String str) {
        if (!TextUtils.isEmpty(str)) {
            n(f.bo, str);
        }
        return this;
    }

    public n n(com.byazt.pd.qg qgVar) {
        n("activity_trace", qgVar.n());
        n("running_tasks", qgVar.qg());
        return this;
    }

    public n n(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            if (map == null) {
                this.n.put("plugin_info", jSONArray);
                return this;
            }
            for (String str : map.keySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("package_name", str);
                jSONObject.put("version_code", map.get(str));
                jSONArray.put(jSONObject);
            }
            this.n.put("plugin_info", jSONArray);
            return this;
        } catch (Exception unused) {
        }
    }

    public n qg(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    tj.qg(e);
                }
            }
            try {
                this.n.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, jSONObject);
            } catch (JSONException unused) {
            }
        }
        return this;
    }

    public n n(int i, String str) {
        try {
            this.n.put("miniapp_id", i);
            this.n.put("miniapp_version", str);
        } catch (JSONException unused) {
        }
        return this;
    }

    public n n(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            n("patch_info", jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        n("patch_info", jSONArray);
        return this;
    }

    public n n(JSONObject jSONObject) {
        n("storage", jSONObject);
        return this;
    }

    public n qg(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        n("logcat", jSONArray);
        return this;
    }

    public n s(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException unused) {
                }
            }
            n("filters", jSONObject);
        }
        return this;
    }

    public void n(String str, Object obj) {
        try {
            this.n.put(str, obj);
        } catch (Exception e) {
            tj.qg(e);
        }
    }
}
