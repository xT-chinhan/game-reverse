package com.byazt.now;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1862, 5})
public class uc {
    public static Boolean pr = null;

    public static boolean pr() {
        Boolean bool = pr;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static synchronized void pr(Context context) {
        if (pr == null) {
            pr = Boolean.valueOf((hw() || hw(context) || hn(context) || !x(context) || hn() || c(context)) ? false : true);
        }
    }

    public static boolean hw() {
        if (x() == 0) {
            return true;
        }
        return c();
    }

    public static boolean hw(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    private static int x() {
        String str = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, pr("726f2e736563757265"));
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Exception e) {
        }
        return (str == null || !"0".equals(str)) ? 1 : 0;
    }

    private static boolean c() {
        String[] strArr = {pr("2f7362696e2f7375"), pr("2f73797374656d2f62696e2f7375"), pr("2f73797374656d2f7862696e2f7375"), pr("2f646174612f6c6f63616c2f7862696e2f7375"), pr("2f646174612f6c6f63616c2f62696e2f7375"), pr("2f73797374656d2f73642f7862696e2f7375"), pr("2f73797374656d2f62696e2f6661696c736166652f7375"), pr("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean hn(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentRegisterReceiver != null && intentRegisterReceiver.getIntExtra("plugged", -1) == 2;
    }

    public static boolean x(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
            if (simState == 1 || simState == 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean hn() {
        try {
            InetAddress.getByName(pr("3132372e302e302e31"));
            new Socket(pr("3132372e302e302e31"), Integer.parseInt(pr("3237303432")));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean c(Context context) {
        if (uc() || uc(context)) {
            return true;
        }
        return false;
    }

    private static boolean uc() {
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
                if (str.contains(pr("636f6d2e73617572696b2e737562737472617465")) || str.contains(pr("58706f7365644272696467652e6a6172")) || str.contains(pr("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean uc(Context context) {
        List listAsList = Arrays.asList(pr("64652e726f62762e616e64726f69642e78706f736564"), pr("636f6d2e746f706a6f686e77752e6d616769736b"), pr("696f2e76612e6578706f736564"), pr("636f6d2e77696e642e636f74746572"), pr("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), pr("6d652e7765697368752e657870"), pr("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            try {
                if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return false;
    }

    private static String pr(String str) {
        return com.byazt.tuy.uc.pr(str);
    }
}
