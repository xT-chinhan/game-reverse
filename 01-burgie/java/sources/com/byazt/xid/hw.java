package com.byazt.xid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.byazt.zs.aj;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 582, 13})
public class hw {
    public static int pr = 1;
    public static int hw = 2;

    public static SharedPreferences pr(Context context) {
        return aj.pr(context.getApplicationContext(), "plugin_oat_info", 0);
    }

    public static String[] pr(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--instruction-set=" + pr());
        if (i == pr) {
            if (com.byazt.gs.aj.m()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == hw) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String pr() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            com.byazt.dea.uc.pr(e);
            return null;
        }
    }

    public static String pr(String str) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (!".dex".equals(strSubstring2)) {
            if (".zip".equals(strSubstring2) || ".apk".equals(strSubstring2)) {
                return strSubstring.replace(strSubstring2, str2);
            }
            return strSubstring + str2;
        }
        return strSubstring;
    }

    public static String hw(String str) {
        String strSubstring = str.substring(str.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(strSubstring)) {
            return strSubstring;
        }
        if (".zip".equals(strSubstring) || ".apk".equals(strSubstring)) {
            return str2;
        }
        return str + str2;
    }

    public static boolean pr(String str, String str2) {
        return pr.pr(pr(str, str2, pr));
    }

    public static boolean pr(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !uc.pr(file)) {
                return false;
            }
        }
        return true;
    }
}
