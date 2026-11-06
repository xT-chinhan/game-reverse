package com.bytedance.ms.xr.ka.ms;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private static com.bytedance.ms.xr.d h;
    private String ab;
    private long ao;
    private long ch;
    private String hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Application f578ms;
    private String ny;
    private long sl;
    private long u;
    private String ub;
    private long x;
    private Context xr;
    private String zb;
    private List<String> ah = new ArrayList();
    private List<Long> d = new ArrayList();
    private List<String> ka = new ArrayList();
    private List<Long> c = new ArrayList();
    private int qv = 0;
    private boolean y = false;
    private final Application.ActivityLifecycleCallbacks t = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.ms.xr.ka.ms.xr.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String strMs;
            xr xrVar = xr.this;
            if (xr.h != null) {
                strMs = xr.h.ms(activity);
            } else {
                strMs = activity.getClass().getName();
            }
            xrVar.ab = strMs;
            xr.this.x = System.currentTimeMillis();
            xr.this.ah.add(xr.this.ab);
            xr.this.d.add(Long.valueOf(xr.this.x));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            String strMs;
            xr xrVar = xr.this;
            if (xr.h != null) {
                strMs = xr.h.ms(activity);
            } else {
                strMs = activity.getClass().getName();
            }
            xrVar.ny = strMs;
            xr.this.ch = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String strMs;
            xr xrVar = xr.this;
            if (xr.h != null) {
                strMs = xr.h.ms(activity);
            } else {
                strMs = activity.getClass().getName();
            }
            xrVar.hi = strMs;
            xr.this.sl = System.currentTimeMillis();
            xr.this.y = true;
            xr.ka(xr.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String strMs;
            xr xrVar = xr.this;
            if (xr.h != null) {
                strMs = xr.h.ms(activity);
            } else {
                strMs = activity.getClass().getName();
            }
            xrVar.zb = strMs;
            xr.this.u = System.currentTimeMillis();
            xr.c(xr.this);
            if (xr.this.qv <= 0) {
                xr.this.y = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            String strMs;
            xr xrVar = xr.this;
            if (xr.h != null) {
                strMs = xr.h.ms(activity);
            } else {
                strMs = activity.getClass().getName();
            }
            xrVar.ub = strMs;
            xr.this.ao = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String strMs;
            if (xr.h != null) {
                strMs = xr.h.ms(activity);
            } else {
                strMs = activity.getClass().getName();
            }
            int iIndexOf = xr.this.ah.indexOf(strMs);
            if (iIndexOf >= 0 && iIndexOf < xr.this.ah.size()) {
                xr.this.ah.remove(iIndexOf);
                xr.this.d.remove(iIndexOf);
            }
            xr.this.ka.add(strMs);
            xr.this.c.add(Long.valueOf(System.currentTimeMillis()));
        }
    };

    static /* synthetic */ int c(xr xrVar) {
        int i = xrVar.qv;
        xrVar.qv = i - 1;
        return i;
    }

    static /* synthetic */ int ka(xr xrVar) {
        int i = xrVar.qv;
        xrVar.qv = i + 1;
        return i;
    }

    xr(Context context) {
        this.xr = context;
        if (context instanceof Application) {
            this.f578ms = (Application) context;
        }
        ka();
    }

    private void ka() {
        Application application = this.f578ms;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.t);
        }
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.ah;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.ah.size(); i++) {
                try {
                    jSONArray.put(ms(this.ah.get(i), this.d.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray ab() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.ka;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.ka.size(); i++) {
                try {
                    jSONArray.put(ms(this.ka.get(i), this.c.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONObject ms(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Common.System.NAME, str);
            jSONObject.put("time", j);
        } catch (JSONException e) {
            sl.ms(e);
        }
        return jSONObject;
    }

    public JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", ms(this.ab, this.x));
            jSONObject.put("last_start_activity", ms(this.ny, this.ch));
            jSONObject.put("last_resume_activity", ms(this.hi, this.sl));
            jSONObject.put("last_pause_activity", ms(this.zb, this.u));
            jSONObject.put("last_stop_activity", ms(this.ub, this.ao));
            jSONObject.put("alive_activities", c());
            jSONObject.put("finish_activities", ab());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONArray xr() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.xr.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(5)) == null) {
                return jSONArray;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null && runningTaskInfo.baseActivity != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", runningTaskInfo.id);
                        jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
                        jSONObject.put(BundleKey.DESCRIPTION, runningTaskInfo.description);
                        jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                        jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                        jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                        jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    public boolean ah() {
        return this.y;
    }
}
