package com.byazt.tka;

import android.app.Activity;
import android.app.Application;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, 18})
public class l {
    public static volatile l n;
    public final ArrayList<String> qg = new ArrayList<>();
    public final AtomicBoolean s = new AtomicBoolean(false);
    public long q = System.currentTimeMillis();
    public long l = 0;
    public long w = 0;
    public String x = "";
    public String fs = "";
    public String rv = "";
    public boolean tj = false;
    public boolean cp = false;

    public static l n(Application application) {
        if (n == null) {
            synchronized (l.class) {
                if (n == null) {
                    l lVar = new l();
                    n = lVar;
                    lVar.tj = oa.n(application);
                    n.cp = oa.n(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    n.n();
                }
            }
        }
        return n;
    }

    public void n(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.qg.size() == 0) {
            this.x = localClassName;
            this.l = System.currentTimeMillis();
            this.w = System.currentTimeMillis() - this.q;
            this.s.set(false);
        }
        if (!this.qg.contains(localClassName)) {
            this.qg.add(localClassName);
        }
        this.rv = localClassName;
    }

    public void qg(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.qg.contains(localClassName)) {
            this.qg.remove(localClassName);
        }
        if (this.qg.size() == 0) {
            this.q = System.currentTimeMillis();
            this.s.set(true);
            this.fs = localClassName;
        }
    }

    private void n() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object objValueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                        if (!this.qg.contains(localClassName)) {
                            this.qg.add(localClassName);
                        }
                    }
                }
                this.s.set(this.qg.size() <= 0);
            }
        } catch (Exception unused) {
        }
    }

    public String n(String str, long j, int i, boolean z) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.l;
        long j3 = jCurrentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.s.get() && this.cp) {
            i2 |= 2;
        }
        if (!this.s.get() && this.w >= 5000 && j2 < 1000) {
            i2 = this.fs.equals(this.rv) ? i2 | 4 : i2 | 8;
        }
        try {
            string = new JSONObject().put("rst", i2).put("bakdur", this.w).put("popt", j2).put("uct", j3).put("isbak", this.s).put("alert", this.cp).put("rit", i).put("tag", str).put(NotificationCompat.CATEGORY_SYSTEM, this.tj).put("size", this.qg.size()).put("mutipro", z).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.x = "";
        this.w = 0L;
        this.l = 0L;
        this.q = System.currentTimeMillis();
        return string;
    }
}
