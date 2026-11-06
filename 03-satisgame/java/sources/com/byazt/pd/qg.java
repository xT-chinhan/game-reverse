package com.byazt.pd;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 24, 26})
public class qg {
    public static com.byazt.qf.q hd;
    public String cp;
    public long cy;
    public long d;
    public long fs;
    public String k;
    public Application n;
    public String oa;
    public Context qg;
    public String rv;
    public long sz;
    public long tj;
    public String x;
    public List<String> s = new ArrayList();
    public List<Long> q = new ArrayList();
    public List<String> l = new ArrayList();
    public List<Long> w = new ArrayList();
    public int cd = 0;
    public boolean um = false;
    public final Application.ActivityLifecycleCallbacks a = new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.pd.qg.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String strN;
            qg qgVar = qg.this;
            if (qg.hd != null) {
                strN = qg.hd.n(activity);
            } else {
                strN = activity.getClass().getName();
            }
            qgVar.x = strN;
            qg.this.fs = System.currentTimeMillis();
            qg.this.s.add(qg.this.x);
            qg.this.q.add(Long.valueOf(qg.this.fs));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            String strN;
            qg qgVar = qg.this;
            if (qg.hd != null) {
                strN = qg.hd.n(activity);
            } else {
                strN = activity.getClass().getName();
            }
            qgVar.rv = strN;
            qg.this.tj = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String strN;
            qg qgVar = qg.this;
            if (qg.hd != null) {
                strN = qg.hd.n(activity);
            } else {
                strN = activity.getClass().getName();
            }
            qgVar.cp = strN;
            qg.this.d = System.currentTimeMillis();
            qg.this.um = true;
            qg.l(qg.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String strN;
            qg qgVar = qg.this;
            if (qg.hd != null) {
                strN = qg.hd.n(activity);
            } else {
                strN = activity.getClass().getName();
            }
            qgVar.oa = strN;
            qg.this.sz = System.currentTimeMillis();
            qg.w(qg.this);
            if (qg.this.cd <= 0) {
                qg.this.um = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            String strN;
            qg qgVar = qg.this;
            if (qg.hd != null) {
                strN = qg.hd.n(activity);
            } else {
                strN = activity.getClass().getName();
            }
            qgVar.k = strN;
            qg.this.cy = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String strN;
            if (qg.hd != null) {
                strN = qg.hd.n(activity);
            } else {
                strN = activity.getClass().getName();
            }
            int iIndexOf = qg.this.s.indexOf(strN);
            if (iIndexOf >= 0 && iIndexOf < qg.this.s.size()) {
                qg.this.s.remove(iIndexOf);
                qg.this.q.remove(iIndexOf);
            }
            qg.this.l.add(strN);
            qg.this.w.add(Long.valueOf(System.currentTimeMillis()));
        }
    };

    public static /* synthetic */ int l(qg qgVar) {
        int i = qgVar.cd;
        qgVar.cd = i + 1;
        return i;
    }

    public static /* synthetic */ int w(qg qgVar) {
        int i = qgVar.cd;
        qgVar.cd = i - 1;
        return i;
    }

    public qg(Context context) {
        this.qg = context;
        if (context instanceof Application) {
            this.n = (Application) context;
        }
        l();
    }

    private void l() {
        Application application = this.n;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.a);
        }
    }

    private JSONArray w() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.s;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.s.size(); i++) {
                try {
                    jSONArray.put(n(this.s.get(i), this.q.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray x() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.l;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.l.size(); i++) {
                try {
                    jSONArray.put(n(this.l.get(i), this.w.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONObject n(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TapEventParamConstants.PARAM_NAME, str);
            jSONObject.put("time", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", n(this.x, this.fs));
            jSONObject.put("last_start_activity", n(this.rv, this.tj));
            jSONObject.put("last_resume_activity", n(this.cp, this.d));
            jSONObject.put("last_pause_activity", n(this.oa, this.sz));
            jSONObject.put("last_stop_activity", n(this.k, this.cy));
            jSONObject.put("alive_activities", w());
            jSONObject.put("finish_activities", x());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONArray qg() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.qg.getSystemService("activity");
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

    public boolean s() {
        return this.um;
    }
}
