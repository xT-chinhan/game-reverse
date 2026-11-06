package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.openadsdk.api.ab;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Boolean f4560ms;

    public static boolean ms() {
        Boolean bool = f4560ms;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static synchronized void ms(Context context) {
        if (f4560ms == null) {
            f4560ms = Boolean.valueOf((xr() || xr(context) || ah(context) || !d(context) || ah() || ka(context)) ? false : true);
        }
    }

    public static boolean xr() {
        if (d() == 0) {
            return true;
        }
        return ka();
    }

    public static boolean xr(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
        }
    }

    private static int d() {
        String str = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, ms("726f2e736563757265"));
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return (str == null || !"0".equals(str)) ? 1 : 0;
    }

    private static boolean ka() {
        String[] strArr = {ms("2f7362696e2f7375"), ms("2f73797374656d2f62696e2f7375"), ms("2f73797374656d2f7862696e2f7375"), ms("2f646174612f6c6f63616c2f7862696e2f7375"), ms("2f646174612f6c6f63616c2f62696e2f7375"), ms("2f73797374656d2f73642f7862696e2f7375"), ms("2f73797374656d2f62696e2f6661696c736166652f7375"), ms("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean ah(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentRegisterReceiver != null && intentRegisterReceiver.getIntExtra("plugged", -1) == 2;
    }

    public static boolean d(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
            return (simState == 1 || simState == 0) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static boolean ah() {
        try {
            InetAddress.getByName(ms("3132372e302e302e31"));
            new Socket(ms("3132372e302e302e31"), Integer.parseInt(ms("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean ka(Context context) {
        return c() || c(context);
    }

    private static boolean c() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.endsWith(".so") || line.endsWith(".jar")) {
                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(ms("636f6d2e73617572696b2e737562737472617465")) || str.contains(ms("58706f7365644272696467652e6a6172")) || str.contains(ms("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean c(Context context) {
        List listAsList = Arrays.asList(ms("64652e726f62762e616e64726f69642e78706f736564"), ms("636f6d2e746f706a6f686e77752e6d616769736b"), ms("696f2e76612e6578706f736564"), ms("636f6d2e77696e642e636f74746572"), ms("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), ms("6d652e7765697368752e657870"), ms("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            try {
                if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                ab.ms(e);
            }
        }
        return false;
    }

    private static String ms(String str) {
        return com.ss.android.socialbase.downloader.ny.c.ms(str);
    }
}
