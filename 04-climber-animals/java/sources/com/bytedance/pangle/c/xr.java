package com.bytedance.pangle.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.anythink.core.common.d.j;
import com.anythink.dlopt.common.a.a;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.ny;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f629ms = 1;
    public static int xr = 2;

    public static SharedPreferences ms(Context context) {
        return com.bytedance.sdk.openadsdk.ats.ah.ms(context.getApplicationContext(), "plugin_oat_info", 0);
    }

    static String[] ms(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        arrayList.add("--runtime-arg");
        arrayList.add("-classpath");
        arrayList.add("--runtime-arg");
        arrayList.add("&");
        arrayList.add("--instruction-set=" + ms());
        if (i == f629ms) {
            if (ny.u()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == xr) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String ms() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    public static String ms(String str) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf(j.z));
        if (".dex".equals(strSubstring2)) {
            return strSubstring;
        }
        if (".zip".equals(strSubstring2) || a.h.equals(strSubstring2)) {
            return strSubstring.replace(strSubstring2, ".odex");
        }
        return strSubstring + ".odex";
    }

    public static String xr(String str) {
        String strSubstring = str.substring(str.lastIndexOf(j.z));
        if (".dex".equals(strSubstring)) {
            return strSubstring;
        }
        return (".zip".equals(strSubstring) || a.h.equals(strSubstring)) ? ".odex" : str + ".odex";
    }

    public static boolean ms(String str, String str2) {
        return ms.ms(ms(str, str2, f629ms));
    }

    public static boolean ms(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !x.ms(file)) {
                return false;
            }
        }
        return true;
    }

    public static boolean ms(String str, String... strArr) {
        for (String str2 : strArr) {
            if (!new File(str + File.separator + ms(str2)).exists()) {
                return false;
            }
        }
        return true;
    }
}
