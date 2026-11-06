package com.byazt.yi;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.ArrayMap;
import com.byazt.ol.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static volatile c pr = null;
    public final ArrayList<String> hw = new ArrayList<>();
    public final AtomicBoolean hn = new AtomicBoolean(false);
    public long x = System.currentTimeMillis();
    public long c = 0;
    public long uc = 0;
    public String fw = "";
    public String zo = "";
    public String aj = "";
    public boolean vk = false;
    public boolean w = false;

    public static c pr(Application application) {
        if (pr == null) {
            synchronized (c.class) {
                if (pr == null) {
                    c cVar = new c();
                    pr = cVar;
                    cVar.vk = k.pr(application);
                    pr.w = k.pr(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    pr.pr();
                }
            }
        }
        return pr;
    }

    public void pr(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.hw.size() == 0) {
            this.fw = localClassName;
            this.c = System.currentTimeMillis();
            this.uc = System.currentTimeMillis() - this.x;
            this.hn.set(false);
        }
        if (!this.hw.contains(localClassName)) {
            this.hw.add(localClassName);
        }
        this.aj = localClassName;
    }

    public void hw(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.hw.contains(localClassName)) {
            this.hw.remove(localClassName);
        }
        if (this.hw.size() == 0) {
            this.x = System.currentTimeMillis();
            this.hn.set(true);
            this.zo = localClassName;
        }
    }

    private void pr() {
        int size;
        if (Build.VERSION.SDK_INT >= 19) {
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
                            if (!this.hw.contains(localClassName)) {
                                this.hw.add(localClassName);
                            }
                        }
                    }
                    this.hn.set(this.hw.size() <= 0);
                }
            } catch (Exception e) {
            }
        }
    }

    public String pr(String str, long j, int i, boolean z) {
        int i2;
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.c;
        long j3 = jCurrentTimeMillis - j;
        if (j3 >= 500) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.hn.get() && this.w) {
            i2 |= 2;
        }
        if (!this.hn.get() && this.uc >= 5000 && j2 < 1000) {
            if (this.zo.equals(this.aj)) {
                i2 |= 4;
            } else {
                i2 |= 8;
            }
        }
        try {
            string = new JSONObject().put("rst", i2).put("bakdur", this.uc).put("popt", j2).put("uct", j3).put("isbak", this.hn).put("alert", this.w).put("rit", i).put("tag", str).put(NotificationCompat.CATEGORY_SYSTEM, this.vk).put("size", this.hw.size()).put("mutipro", z).toString();
        } catch (JSONException e) {
            string = "";
        }
        this.fw = "";
        this.uc = 0L;
        this.c = 0L;
        this.x = System.currentTimeMillis();
        return string;
    }
}
