package com.byazt.se;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.byazt.ol.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 13})
public class hw {
    public static com.byazt.vlj.x yb = null;
    public String aj;
    public String fw;
    public long g;
    public String ho;
    public Context hw;
    public long k;
    public String m;
    public long nt;
    public Application pr;
    public long vk;
    public String w;
    public long zo;
    public List<String> hn = new ArrayList();
    public List<Long> x = new ArrayList();
    public List<String> c = new ArrayList();
    public List<Long> uc = new ArrayList();
    public int lb = 0;
    public boolean qa = false;
    public final Application.ActivityLifecycleCallbacks a = new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.se.hw.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String strPr;
            hw hwVar = hw.this;
            if (hw.yb != null) {
                strPr = hw.yb.pr(activity);
            } else {
                strPr = activity.getClass().getName();
            }
            hwVar.fw = strPr;
            hw.this.zo = System.currentTimeMillis();
            hw.this.hn.add(hw.this.fw);
            hw.this.x.add(Long.valueOf(hw.this.zo));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            String strPr;
            hw hwVar = hw.this;
            if (hw.yb != null) {
                strPr = hw.yb.pr(activity);
            } else {
                strPr = activity.getClass().getName();
            }
            hwVar.aj = strPr;
            hw.this.vk = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String strPr;
            hw hwVar = hw.this;
            if (hw.yb != null) {
                strPr = hw.yb.pr(activity);
            } else {
                strPr = activity.getClass().getName();
            }
            hwVar.w = strPr;
            hw.this.k = System.currentTimeMillis();
            hw.this.qa = true;
            hw.c(hw.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String strPr;
            hw hwVar = hw.this;
            if (hw.yb != null) {
                strPr = hw.yb.pr(activity);
            } else {
                strPr = activity.getClass().getName();
            }
            hwVar.m = strPr;
            hw.this.g = System.currentTimeMillis();
            hw.uc(hw.this);
            if (hw.this.lb <= 0) {
                hw.this.qa = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            String strPr;
            hw hwVar = hw.this;
            if (hw.yb != null) {
                strPr = hw.yb.pr(activity);
            } else {
                strPr = activity.getClass().getName();
            }
            hwVar.ho = strPr;
            hw.this.nt = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String strPr;
            if (hw.yb != null) {
                strPr = hw.yb.pr(activity);
            } else {
                strPr = activity.getClass().getName();
            }
            int iIndexOf = hw.this.hn.indexOf(strPr);
            if (iIndexOf >= 0 && iIndexOf < hw.this.hn.size()) {
                hw.this.hn.remove(iIndexOf);
                hw.this.x.remove(iIndexOf);
            }
            hw.this.c.add(strPr);
            hw.this.uc.add(Long.valueOf(System.currentTimeMillis()));
        }
    };

    public static /* synthetic */ int c(hw hwVar) {
        int i = hwVar.lb;
        hwVar.lb = i + 1;
        return i;
    }

    public static /* synthetic */ int uc(hw hwVar) {
        int i = hwVar.lb;
        hwVar.lb = i - 1;
        return i;
    }

    public hw(Context context) {
        this.hw = context;
        if (context instanceof Application) {
            this.pr = (Application) context;
        }
        c();
    }

    private void c() {
        Application application;
        if (Build.VERSION.SDK_INT >= 14 && (application = this.pr) != null) {
            application.registerActivityLifecycleCallbacks(this.a);
        }
    }

    private JSONArray uc() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.hn;
        if (list == null || list.isEmpty()) {
            return jSONArray;
        }
        for (int i = 0; i < this.hn.size(); i++) {
            try {
                jSONArray.put(pr(this.hn.get(i), this.x.get(i).longValue()));
            } catch (Throwable th) {
            }
        }
        return jSONArray;
    }

    private JSONArray fw() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.c;
        if (list == null || list.isEmpty()) {
            return jSONArray;
        }
        for (int i = 0; i < this.c.size(); i++) {
            try {
                jSONArray.put(pr(this.c.get(i), this.uc.get(i).longValue()));
            } catch (Throwable th) {
            }
        }
        return jSONArray;
    }

    private JSONObject pr(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Common.System.NAME, str);
            jSONObject.put("time", j);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", pr(this.fw, this.zo));
            jSONObject.put("last_start_activity", pr(this.aj, this.vk));
            jSONObject.put("last_resume_activity", pr(this.w, this.k));
            jSONObject.put("last_pause_activity", pr(this.m, this.g));
            jSONObject.put("last_stop_activity", pr(this.ho, this.nt));
            jSONObject.put("alive_activities", uc());
            jSONObject.put("finish_activities", fw());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public JSONArray hw() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.hw.getSystemService(TTDownloadField.TT_ACTIVITY);
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
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Exception e2) {
        }
        return jSONArray;
    }

    public boolean hn() {
        return this.qa;
    }
}
