package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ah f1303ms;
    private final ArrayList<String> xr = new ArrayList<>();
    private final AtomicBoolean ah = new AtomicBoolean(false);
    private long d = System.currentTimeMillis();
    private long ka = 0;
    private long c = 0;
    private String ab = "";
    private String x = "";
    private String ny = "";
    private boolean ch = false;
    private boolean hi = false;

    public static ah ms(Application application) {
        if (f1303ms == null) {
            synchronized (ah.class) {
                if (f1303ms == null) {
                    ah ahVar = new ah();
                    f1303ms = ahVar;
                    ahVar.ch = ch.ms(application);
                    f1303ms.hi = ch.ms(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    f1303ms.ms();
                }
            }
        }
        return f1303ms;
    }

    public void ms(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.xr.size() == 0) {
            this.ab = localClassName;
            this.ka = System.currentTimeMillis();
            this.c = System.currentTimeMillis() - this.d;
            this.ah.set(false);
        }
        if (!this.xr.contains(localClassName)) {
            this.xr.add(localClassName);
        }
        this.ny = localClassName;
    }

    public void xr(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.xr.contains(localClassName)) {
            this.xr.remove(localClassName);
        }
        if (this.xr.size() == 0) {
            this.d = System.currentTimeMillis();
            this.ah.set(true);
            this.x = localClassName;
        }
    }

    private void ms() {
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
                Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object objValueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                        if (!this.xr.contains(localClassName)) {
                            this.xr.add(localClassName);
                        }
                    }
                }
                this.ah.set(this.xr.size() <= 0);
            }
        } catch (Exception unused) {
        }
    }

    public String ms(String str, long j, int i, boolean z) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.ka;
        long j3 = jCurrentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.ah.get() && this.hi) {
            i2 |= 2;
        }
        if (!this.ah.get() && this.c >= 5000 && j2 < 1000) {
            i2 = this.x.equals(this.ny) ? i2 | 4 : i2 | 8;
        }
        try {
            string = new JSONObject().put("rst", i2).put("bakdur", this.c).put("popt", j2).put("uct", j3).put("isbak", this.ah).put("alert", this.hi).put("rit", i).put(TTDownloadField.TT_TAG, str).put(NotificationCompat.CATEGORY_SYSTEM, this.ch).put("size", this.xr.size()).put("mutipro", z).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.ab = "";
        this.c = 0L;
        this.ka = 0L;
        this.d = System.currentTimeMillis();
        return string;
    }
}
