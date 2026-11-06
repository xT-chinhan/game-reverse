package com.byazt.tka;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.byakv.z.SoftDecTool;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static String n;
    public static cp tj;
    public static AtomicBoolean qg = new AtomicBoolean(false);
    public static final AtomicBoolean s = new AtomicBoolean(false);
    public static String q = "";
    public static long l = 0;
    public static int w = 0;
    public static q x = null;
    public static volatile DisplayManager.DisplayListener fs = null;
    public static volatile boolean rv = false;
    public static final AtomicBoolean cp = new AtomicBoolean(false);

    public static void n(cp cpVar) {
        tj = cpVar;
    }

    @DungeonFlag
    public static String n() {
        if (d.qg() && tj != null) {
            final Handler handlerQ = ((wo) com.byazt.qp.q.n("thread_service")).q();
            AtomicBoolean atomicBoolean = cp;
            if (atomicBoolean.get()) {
                if (TextUtils.isEmpty(q)) {
                    String strGc = SoftDecTool.gc();
                    if (!TextUtils.isEmpty(strGc)) {
                        q = strGc;
                    }
                }
                return TextUtils.isEmpty(q) ? "eyJzdHRzIjoxfQ==" : q;
            }
            atomicBoolean.set(true);
            handlerQ.post(new Runnable() { // from class: com.byazt.tka.tj.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!tj.s.get()) {
                            q unused = tj.x = q.n((Application) tj.tj.n());
                            tj.qg(handlerQ);
                        }
                        rv.n(tj.tj.n());
                        if (SoftDecTool.acs == -1.0d) {
                            SoftDecTool.ua();
                        }
                        Object objN = tj.n(1001, new Object[]{tj.tj.n(), Long.valueOf(tj.tj.s())});
                        if (objN instanceof String) {
                            String unused2 = tj.q = (String) objN;
                        }
                        if (!tj.qg.getAndSet(true)) {
                            JSONObject jSONObjectN = com.byazt.wx.n.n().n(tj.tj.n(), tj.tj.qg());
                            if (jSONObjectN != null && jSONObjectN.length() > 0) {
                                d.n("detailed_app_info", jSONObjectN);
                            }
                            tj.qg.set(false);
                        }
                        JSONObject jSONObjectT = SoftDecTool.t();
                        if (jSONObjectT != null && jSONObjectT.length() > 0) {
                            d.n("tc_info", jSONObjectT);
                        }
                    } catch (Throwable th) {
                        try {
                            String unused3 = tj.q = tj.qg(th);
                        } finally {
                            tj.cp.set(false);
                        }
                    }
                }
            });
        }
        if (TextUtils.isEmpty(q)) {
            String strGc2 = SoftDecTool.gc();
            if (!TextUtils.isEmpty(strGc2)) {
                q = strGc2;
            }
        }
        return TextUtils.isEmpty(q) ? "eyJzdHRzIjoxfQ==" : q;
    }

    @DungeonFlag
    public static Object n(int i, Object[] objArr) {
        return SoftDecTool.cn(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static void qg(Handler handler) {
        if (!d.qg() || rv || s() == null) {
            return;
        }
        rv = true;
        if (fs == null) {
            fs = new DisplayManager.DisplayListener() { // from class: com.byazt.tka.tj.2
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i) {
                    if (i != 0) {
                        try {
                            tj.n(1003, new Object[]{Integer.valueOf(i), tj.s()});
                        } catch (Throwable unused) {
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i) {
                    if (i != 0) {
                        try {
                            tj.n(1004, new Object[]{Integer.valueOf(i), tj.s()});
                        } catch (Throwable unused) {
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i) {
                    if (i != 0) {
                        try {
                            tj.n(1005, new Object[]{Integer.valueOf(i), tj.s()});
                        } catch (Throwable unused) {
                        }
                    }
                }
            };
        }
        ((DisplayManager) s().getSystemService("display")).registerDisplayListener(fs, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static String qg(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            q = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable unused) {
            q = "eyJzdHRzIjozfQ==";
        }
        return q;
    }

    @DungeonFlag
    public static void n(final MotionEvent motionEvent) {
        if (motionEvent == null || !d.qg() || s() == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            ((wo) com.byazt.qp.q.n("thread_service")).q().post(new Runnable() { // from class: com.byazt.tka.tj.3
                @Override // java.lang.Runnable
                public void run() {
                    tj.n(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), tj.s()});
                }
            });
        }
    }

    @DungeonFlag
    public static void n(long j, int i) {
        l = j;
        w = i;
    }

    public static String n(String str, long j, int i, boolean z) {
        try {
            q qVar = x;
            if (qVar != null) {
                return qVar.n(str, j, i, z);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String n(String str, String str2) {
        Object objN = n(1010, new String[]{str, str2});
        return objN instanceof String ? (String) objN : str2;
    }

    public static String qg() {
        if (n == null) {
            Object objN = n(1011, new Object[0]);
            if (objN instanceof String) {
                n = (String) objN;
            }
        }
        String str = n;
        return str != null ? str : "";
    }

    public static Context s() {
        cp cpVar = tj;
        if (cpVar != null) {
            return cpVar.n();
        }
        return null;
    }

    public static String q() {
        cp cpVar = tj;
        if (cpVar != null) {
            return cpVar.qg();
        }
        return null;
    }

    public static long l() {
        return l;
    }

    public static int w() {
        return w;
    }
}
