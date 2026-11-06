package com.byazt.lee;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.wf.g;
import com.byazt.wf.vk;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.umeng.analytics.pro.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 424, 37})
public class pr {
    public JSONObject pr;

    public pr() {
        this.pr = new JSONObject();
    }

    public pr(JSONObject jSONObject) {
        this.pr = jSONObject;
    }

    public static pr pr(long j, Context context, Thread thread, Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        pr prVar = new pr();
        prVar.pr("isJava", (Object) 1);
        prVar.pr("event_type", "java_crash");
        prVar.pr("timestamp", Long.valueOf(System.currentTimeMillis()));
        prVar.pr("data", g.pr(th));
        prVar.pr("isOOM", Boolean.valueOf(g.hw(th)));
        prVar.pr("crash_time", Long.valueOf(j));
        prVar.pr(ContentProviderManager.PLUGIN_PROCESS_NAME, com.byazt.wf.pr.x(context));
        if (!com.byazt.wf.pr.hw(context)) {
            prVar.pr("remote_process", (Object) 1);
        }
        com.byazt.wf.pr.pr(context, prVar.pr());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            prVar.pr("crash_thread_name", name);
        }
        prVar.pr("all_thread_stacks", g.pr(name));
        return prVar;
    }

    public JSONObject pr() {
        return this.pr;
    }

    public pr pr(hw hwVar) {
        pr("header", hwVar.pr());
        return this;
    }

    public pr pr(long j) {
        try {
            pr(d.p, Long.valueOf(j));
            pr("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
        }
        return this;
    }

    public pr pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            pr("session_id", str);
        }
        return this;
    }

    public pr pr(com.byazt.se.hw hwVar) {
        pr("activity_trace", hwVar.pr());
        pr("running_tasks", hwVar.hw());
        return this;
    }

    public pr pr(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            if (map == null) {
                this.pr.put("plugin_info", jSONArray);
                return this;
            }
            for (String str : map.keySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("package_name", str);
                jSONObject.put("version_code", map.get(str));
                jSONArray.put(jSONObject);
            }
            this.pr.put("plugin_info", jSONArray);
            return this;
        } catch (Exception e) {
        }
    }

    public pr hw(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    vk.hw(e);
                }
            }
            try {
                this.pr.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
            }
        }
        return this;
    }

    public pr pr(int i, String str) {
        try {
            this.pr.put("miniapp_id", i);
            this.pr.put("miniapp_version", str);
        } catch (JSONException e) {
        }
        return this;
    }

    public pr pr(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            pr("patch_info", jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        pr("patch_info", jSONArray);
        return this;
    }

    public pr pr(JSONObject jSONObject) {
        pr("storage", jSONObject);
        return this;
    }

    public pr hw(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        pr("logcat", jSONArray);
        return this;
    }

    public pr hn(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                }
            }
            pr("filters", jSONObject);
        }
        return this;
    }

    public void pr(String str, Object obj) {
        try {
            this.pr.put(str, obj);
        } catch (Exception e) {
            vk.hw(e);
        }
    }
}
