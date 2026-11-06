package com.byazt.wo;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.dea.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, 121})
public class x {
    public static List<String> hw = new CopyOnWriteArrayList();
    public static String pr;

    private static String pr() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i <= 0) {
                        break;
                    }
                    sb.append((char) i);
                }
                if (ZeusLogger.isDebug()) {
                    ZeusLogger.d("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                }
                return string;
            } catch (Throwable th) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            bufferedReader = null;
        }
    }

    public static String pr(Context context) {
        if (!TextUtils.isEmpty(pr)) {
            return pr;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName)) {
                pr = processName;
            }
            return pr;
        }
        try {
            Object objInvokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) objInvokeStaticMethod)) {
                pr = (String) objInvokeStaticMethod;
            }
            return pr;
        } catch (Exception e) {
            uc.pr(e);
            String strPr = pr();
            pr = strPr;
            return strPr;
        }
    }

    public static boolean hw(Context context) {
        String strPr = pr(context);
        return (strPr == null || !strPr.contains(":")) && strPr != null && strPr.equals(context.getPackageName());
    }

    public static String pr(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(":")) {
            return "main";
        }
        return str.split(":")[1];
    }
}
