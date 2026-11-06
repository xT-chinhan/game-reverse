package com.bytedance.ms.xr.ah;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.e.a;
import com.bytedance.ms.xr.x.ch;
import com.bytedance.ms.xr.x.u;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.utils.sl;
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
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected JSONObject f559ms;

    public ms() {
        this.f559ms = new JSONObject();
    }

    public ms(JSONObject jSONObject) {
        this.f559ms = jSONObject;
    }

    public static ms ms(long j, Context context, Thread thread, Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        ms msVar = new ms();
        msVar.ms("isJava", (Object) 1);
        msVar.ms(a.C0080a.b, "java_crash");
        msVar.ms("timestamp", Long.valueOf(System.currentTimeMillis()));
        msVar.ms("data", u.ms(th));
        msVar.ms("isOOM", Boolean.valueOf(u.xr(th)));
        msVar.ms("crash_time", Long.valueOf(j));
        msVar.ms(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.ms.xr.x.ms.d(context));
        if (!com.bytedance.ms.xr.x.ms.xr(context)) {
            msVar.ms("remote_process", (Object) 1);
        }
        com.bytedance.ms.xr.x.ms.ms(context, msVar.ms());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            msVar.ms("crash_thread_name", name);
        }
        msVar.ms("all_thread_stacks", u.ms(name));
        return msVar;
    }

    public JSONObject ms() {
        return this.f559ms;
    }

    public ms ms(xr xrVar) {
        ms("header", xrVar.ms());
        return this;
    }

    public ms ms(long j) {
        try {
            ms("start_time", Long.valueOf(j));
            ms("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            sl.ms(e);
        }
        return this;
    }

    public ms ms(String str) {
        if (!TextUtils.isEmpty(str)) {
            ms("session_id", str);
        }
        return this;
    }

    public ms ms(com.bytedance.ms.xr.ka.ms.xr xrVar) {
        ms("activity_trace", xrVar.ms());
        ms("running_tasks", xrVar.xr());
        return this;
    }

    public ms ms(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            if (map == null) {
                this.f559ms.put("plugin_info", jSONArray);
                return this;
            }
            for (String str : map.keySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("package_name", str);
                jSONObject.put("version_code", map.get(str));
                jSONArray.put(jSONObject);
            }
            this.f559ms.put("plugin_info", jSONArray);
            return this;
        } catch (Exception unused) {
        }
    }

    public ms xr(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    ch.xr(e);
                }
            }
            try {
                this.f559ms.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, jSONObject);
            } catch (JSONException e2) {
                sl.ms(e2);
            }
        }
        return this;
    }

    public ms ms(int i, String str) {
        try {
            this.f559ms.put("miniapp_id", i);
            this.f559ms.put("miniapp_version", str);
        } catch (JSONException e) {
            sl.ms(e);
        }
        return this;
    }

    public ms ms(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            ms("patch_info", jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        ms("patch_info", jSONArray);
        return this;
    }

    public ms ms(JSONObject jSONObject) {
        ms("storage", jSONObject);
        return this;
    }

    public ms xr(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        ms("logcat", jSONArray);
        return this;
    }

    public ms ah(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                    sl.ms(e);
                }
            }
            ms("filters", jSONObject);
        }
        return this;
    }

    public void ms(String str, Object obj) {
        try {
            this.f559ms.put(str, obj);
        } catch (Exception e) {
            ch.xr(e);
        }
    }
}
