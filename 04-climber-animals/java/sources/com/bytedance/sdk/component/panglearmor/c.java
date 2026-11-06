package com.bytedance.sdk.component.panglearmor;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.sl;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static ab ch;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f1304ms;
    private static AtomicBoolean xr = new AtomicBoolean(false);
    private static final AtomicBoolean ah = new AtomicBoolean(false);
    private static String d = "";
    private static long ka = 0;
    private static int c = 0;
    private static xr ab = null;
    private static volatile DisplayManager.DisplayListener x = null;
    private static volatile boolean ny = false;

    public static void ms(ab abVar) {
        ch = abVar;
    }

    public static void ms() {
        try {
            Context contextD = d();
            if (!ka() || ah.getAndSet(true) || contextD == null) {
                return;
            }
            if (ab != null) {
                xr.ms((Application) contextD).xr((Application) contextD);
                ab = null;
            }
            if (x != null) {
                ((DisplayManager) contextD.getSystemService("display")).unregisterDisplayListener(x);
                ny = false;
                x = null;
            }
        } catch (Throwable unused) {
        }
    }

    @DungeonFlag
    public static String xr() {
        if (ny.xr() && ch != null) {
            final Handler handlerMs = com.bytedance.sdk.component.utils.x.ms();
            final x xVarAb = ab();
            handlerMs.post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!c.ah.get()) {
                            xr unused = c.ab = xr.ms((Application) c.ch.ms());
                            c.xr(handlerMs);
                        }
                        ka.ms(c.ch.ms());
                        if (SoftDecTool.acs == -1.0d) {
                            SoftDecTool.ua();
                        }
                        Object objMs = c.ms(1001, new Object[]{c.ch.ms()});
                        if (objMs instanceof String) {
                            String unused2 = c.d = (String) objMs;
                        }
                    } catch (Throwable th) {
                        String unused3 = c.d = c.xr(th);
                    }
                    if (xVarAb == null || c.xr.getAndSet(true)) {
                        return;
                    }
                    JSONObject jSONObjectMs = com.bytedance.sdk.component.panglearmor.ms.ms.ms().ms(c.ch.ms(), c.ch.xr());
                    if (jSONObjectMs != null && jSONObjectMs.length() > 0) {
                        xVarAb.ms("detailed_app_info", jSONObjectMs);
                    }
                    c.xr.set(false);
                }
            });
        }
        if (TextUtils.isEmpty(d)) {
            String strGc = SoftDecTool.gc();
            if (!TextUtils.isEmpty(strGc)) {
                d = strGc;
            }
        }
        return TextUtils.isEmpty(d) ? "eyJzdHRzIjoxfQ==" : d;
    }

    @DungeonFlag
    public static Object ms(int i, Object[] objArr) {
        return SoftDecTool.cn(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static void xr(Handler handler) {
        if (!ny.xr() || ny || d() == null) {
            return;
        }
        ny = true;
        if (x == null) {
            x = new DisplayManager.DisplayListener() { // from class: com.bytedance.sdk.component.panglearmor.c.2
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i) {
                    if (i != 0) {
                        try {
                            c.ms(1003, new Object[]{Integer.valueOf(i), c.d()});
                        } catch (Throwable th) {
                            sl.ms(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i) {
                    if (i != 0) {
                        try {
                            c.ms(1004, new Object[]{Integer.valueOf(i), c.d()});
                        } catch (Throwable th) {
                            sl.ms(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i) {
                    if (i != 0) {
                        try {
                            c.ms(1005, new Object[]{Integer.valueOf(i), c.d()});
                        } catch (Throwable th) {
                            sl.ms(th);
                        }
                    }
                }
            };
        }
        ((DisplayManager) d().getSystemService("display")).registerDisplayListener(x, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static String xr(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            d = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            sl.ms(th2);
            d = "eyJzdHRzIjozfQ==";
        }
        return d;
    }

    @DungeonFlag
    public static void ms(final MotionEvent motionEvent) {
        if (motionEvent == null || !ny.xr() || d() == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.ms(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), c.d()});
                }
            });
        }
    }

    @DungeonFlag
    public static void ms(long j, int i) {
        ka = j;
        c = i;
    }

    public static String ms(String str, long j, int i, boolean z) {
        try {
            xr xrVar = ab;
            if (xrVar != null) {
                return xrVar.ms(str, j, i, z);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String ms(String str, String str2) {
        Object objMs = ms(1010, new String[]{str, str2});
        return objMs instanceof String ? (String) objMs : str2;
    }

    public static String ah() {
        if (f1304ms == null) {
            Object objMs = ms(1011, new Object[0]);
            if (objMs instanceof String) {
                f1304ms = (String) objMs;
            }
        }
        String str = f1304ms;
        return str != null ? str : "";
    }

    public static Context d() {
        ab abVar = ch;
        if (abVar != null) {
            return abVar.ms();
        }
        return null;
    }

    public static boolean ka() {
        ab abVar = ch;
        if (abVar != null) {
            return abVar.ah();
        }
        return false;
    }

    public static String c() {
        ab abVar = ch;
        if (abVar != null) {
            return abVar.xr();
        }
        return null;
    }

    public static x ab() {
        ab abVar = ch;
        if (abVar != null) {
            return abVar.d();
        }
        return null;
    }

    public static long x() {
        return ka;
    }

    public static int ny() {
        return c;
    }
}
