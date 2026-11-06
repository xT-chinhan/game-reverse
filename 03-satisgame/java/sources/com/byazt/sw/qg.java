package com.byazt.sw;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.anythink.core.common.d.i;
import com.byazt.gx.rv;
import com.byazt.qp.x;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 96, 26})
public class qg {
    public static int n = 1;
    public static int qg = 2;

    public static SharedPreferences n(Context context) {
        return x.n(context.getApplicationContext(), "plugin_oat_info", 0);
    }

    public static String[] n(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        arrayList.add("--runtime-arg");
        arrayList.add("-classpath");
        arrayList.add("--runtime-arg");
        arrayList.add("&");
        arrayList.add("--instruction-set=" + n());
        if (i == n) {
            if (rv.oa()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == qg) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String n() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            com.byazt.vx.w.n(e);
            return null;
        }
    }

    public static String n(String str) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf(i.E));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(strSubstring2)) {
            return strSubstring;
        }
        if (".zip".equals(strSubstring2) || ".apk".equals(strSubstring2)) {
            return strSubstring.replace(strSubstring2, str2);
        }
        return strSubstring + str2;
    }

    public static String qg(String str) {
        String strSubstring = str.substring(str.lastIndexOf(i.E));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(strSubstring)) {
            return strSubstring;
        }
        return (".zip".equals(strSubstring) || ".apk".equals(strSubstring)) ? str2 : str + str2;
    }

    public static boolean n(String str, String str2) {
        return n.n(n(str, str2, n));
    }

    public static boolean n(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !w.n(file)) {
                return false;
            }
        }
        return true;
    }
}
