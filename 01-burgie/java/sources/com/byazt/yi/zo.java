package com.byazt.yi;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bumptech.glide.load.Key;
import com.byakv.z.SoftDecTool;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static aj w;
    public static String pr = null;
    public static AtomicBoolean hw = new AtomicBoolean(false);
    public static final AtomicBoolean hn = new AtomicBoolean(false);
    public static final AtomicBoolean x = new AtomicBoolean(false);
    public static String c = "";
    public static long uc = 0;
    public static int fw = 0;
    public static x zo = null;
    public static volatile DisplayManager.DisplayListener aj = null;
    public static volatile boolean vk = false;
    public static final AtomicBoolean k = new AtomicBoolean(false);

    public static void pr(aj ajVar) {
        w = ajVar;
    }

    public static void pr() {
        try {
            Context contextHn = hn();
            if (x() && !hn.getAndSet(true) && contextHn != null) {
                if (zo != null) {
                    x.pr((Application) contextHn).hw((Application) contextHn);
                    zo = null;
                }
                if (Build.VERSION.SDK_INT >= 17 && aj != null) {
                    ((DisplayManager) contextHn.getSystemService("display")).unregisterDisplayListener(aj);
                    vk = false;
                    aj = null;
                }
            }
        } catch (Throwable th) {
        }
    }

    @DungeonFlag
    public static String pr(final long j) {
        if (w.hw() && w != null) {
            final Handler handlerX = ((qi) com.byazt.zs.uc.pr("thread_service")).x();
            final vk vkVarUc = uc();
            AtomicBoolean atomicBoolean = k;
            if (atomicBoolean.get()) {
                if (TextUtils.isEmpty(c)) {
                    String strGc = SoftDecTool.gc();
                    if (!TextUtils.isEmpty(strGc)) {
                        c = strGc;
                    }
                }
                return TextUtils.isEmpty(c) ? "eyJzdHRzIjoxfQ==" : c;
            }
            atomicBoolean.set(true);
            handlerX.post(new Runnable() { // from class: com.byazt.yi.zo.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObjectT;
                    try {
                        if (!zo.hn.get()) {
                            x unused = zo.zo = x.pr((Application) zo.w.pr());
                            zo.hw(handlerX);
                        }
                        fw.pr(zo.w.pr());
                        if (SoftDecTool.acs == -1.0d) {
                            SoftDecTool.ua();
                        }
                        AtomicLong atomicLong = new AtomicLong(j);
                        if (vkVarUc != null && !zo.x.getAndSet(true)) {
                            atomicLong.set(vkVarUc.pr());
                        }
                        Object objPr = zo.pr(1001, new Object[]{zo.w.pr(), Long.valueOf(atomicLong.get())});
                        if (objPr instanceof String) {
                            String unused2 = zo.c = (String) objPr;
                        }
                        if (vkVarUc != null && !zo.hw.getAndSet(true)) {
                            JSONObject jSONObjectPr = com.byazt.je.pr.pr().pr(zo.w.pr(), zo.w.hw());
                            if (jSONObjectPr != null && jSONObjectPr.length() > 0) {
                                vkVarUc.pr("detailed_app_info", jSONObjectPr);
                            }
                            zo.hw.set(false);
                        }
                        if (vkVarUc != null && (jSONObjectT = SoftDecTool.t()) != null && jSONObjectT.length() > 0) {
                            vkVarUc.pr("tc_info", jSONObjectT);
                        }
                    } catch (Throwable th) {
                        try {
                            String unused3 = zo.c = zo.hw(th);
                        } finally {
                            zo.k.set(false);
                        }
                    }
                }
            });
        }
        if (TextUtils.isEmpty(c)) {
            String strGc2 = SoftDecTool.gc();
            if (!TextUtils.isEmpty(strGc2)) {
                c = strGc2;
            }
        }
        return TextUtils.isEmpty(c) ? "eyJzdHRzIjoxfQ==" : c;
    }

    @DungeonFlag
    public static Object pr(int i, Object[] objArr) {
        return SoftDecTool.cn(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static void hw(Handler handler) {
        if (!w.hw() || vk || hn() == null) {
            return;
        }
        vk = true;
        if (Build.VERSION.SDK_INT >= 17) {
            if (aj == null) {
                aj = new DisplayManager.DisplayListener() { // from class: com.byazt.yi.zo.2
                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayAdded(int i) {
                        if (i != 0) {
                            try {
                                zo.pr(1003, new Object[]{Integer.valueOf(i), zo.hn()});
                            } catch (Throwable th) {
                            }
                        }
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayRemoved(int i) {
                        if (i != 0) {
                            try {
                                zo.pr(1004, new Object[]{Integer.valueOf(i), zo.hn()});
                            } catch (Throwable th) {
                            }
                        }
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayChanged(int i) {
                        if (i != 0) {
                            try {
                                zo.pr(1005, new Object[]{Integer.valueOf(i), zo.hn()});
                            } catch (Throwable th) {
                            }
                        }
                    }
                };
            }
            ((DisplayManager) hn().getSystemService("display")).registerDisplayListener(aj, handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static String hw(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            c = Base64.encodeToString(jSONObject.toString().getBytes(Key.STRING_CHARSET_NAME), 0);
        } catch (Throwable th2) {
            c = "eyJzdHRzIjozfQ==";
        }
        return c;
    }

    @DungeonFlag
    public static void pr(final MotionEvent motionEvent) {
        if (motionEvent == null || !w.hw() || hn() == null) {
            return;
        }
        if (motionEvent.getRawX() <= 0.0f && motionEvent.getRawY() <= 0.0f) {
            return;
        }
        ((qi) com.byazt.zs.uc.pr("thread_service")).x().post(new Runnable() { // from class: com.byazt.yi.zo.3
            @Override // java.lang.Runnable
            public void run() {
                zo.pr(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), zo.hn()});
            }
        });
    }

    @DungeonFlag
    public static void pr(long j, int i) {
        uc = j;
        fw = i;
    }

    public static String pr(String str, long j, int i, boolean z) {
        try {
            x xVar = zo;
            if (xVar != null) {
                return xVar.pr(str, j, i, z);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String pr(String str, String str2) {
        Object objPr = pr(1010, new String[]{str, str2});
        if (objPr instanceof String) {
            return (String) objPr;
        }
        return str2;
    }

    public static String hw() {
        if (pr == null) {
            Object objPr = pr(1011, new Object[0]);
            if (objPr instanceof String) {
                pr = (String) objPr;
            }
        }
        String str = pr;
        return str != null ? str : "";
    }

    public static Context hn() {
        aj ajVar = w;
        if (ajVar != null) {
            return ajVar.pr();
        }
        return null;
    }

    public static boolean x() {
        aj ajVar = w;
        if (ajVar != null) {
            return ajVar.hn();
        }
        return false;
    }

    public static String c() {
        aj ajVar = w;
        if (ajVar != null) {
            return ajVar.hw();
        }
        return null;
    }

    public static vk uc() {
        aj ajVar = w;
        if (ajVar != null) {
            return ajVar.x();
        }
        return null;
    }

    public static long fw() {
        return uc;
    }

    public static int zo() {
        return fw;
    }
}
