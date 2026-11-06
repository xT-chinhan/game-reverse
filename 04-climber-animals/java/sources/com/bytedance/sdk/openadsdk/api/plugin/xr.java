package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class xr {
    private static File ms(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File ms(Context context) {
        return ms(new File(context.getFilesDir(), "pangle_com.byted.pangle"));
    }

    public static File ms(Context context, String str) {
        return ms(new File(context.getExternalFilesDir(str), "pangle_com.byted.pangle"));
    }

    public static File xr(Context context) {
        return ms(new File(context.getCacheDir(), "pangle_com.byted.pangle"));
    }

    public static File ah(Context context) {
        return ms(new File(context.getExternalCacheDir(), "pangle_com.byted.pangle"));
    }

    public static File ms(Context context, String str, int i) {
        return i == 0 ? ms(new File(context.getDir(str, i), "pangle_com.byted.pangle")) : context.getDir(str, i);
    }

    public static SharedPreferences xr(Context context, String str, int i) {
        return i == 0 ? com.bytedance.sdk.openadsdk.ats.ah.ms(context, ms(str), i) : com.bytedance.sdk.openadsdk.ats.ah.ms(context, str, i);
    }

    private static String ms(String str) {
        return "pangle_com.byted.pangle_" + str;
    }

    public static boolean d(Context context) {
        File file = new File(context.getFilesDir(), "/pangle_p/com.byted.pangle");
        if (!file.exists()) {
            return false;
        }
        final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.xr.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                try {
                    Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                    String strGroup = matcher.find() ? matcher.group() : "";
                    return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > 6923;
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    return file2.getName().matches(sb.toString());
                }
            }
        });
        return (fileArrListFiles == null || fileArrListFiles.length == 0) ? false : true;
    }
}
