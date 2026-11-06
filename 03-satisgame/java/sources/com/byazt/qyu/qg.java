package com.byazt.qyu;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1178, 26})
public final class qg {
    private static File n(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File n(Context context) {
        return n(new File(context.getFilesDir(), "pangle_com.byted.pangle"));
    }

    public static File qg(Context context) {
        return n(new File(context.getNoBackupFilesDir(), "pangle_com.byted.pangle"));
    }

    public static File n(Context context, String str) {
        return n(new File(context.getExternalFilesDir(str), "pangle_com.byted.pangle"));
    }

    public static File s(Context context) {
        return n(new File(context.getCacheDir(), "pangle_com.byted.pangle"));
    }

    public static File q(Context context) {
        return n(new File(context.getExternalCacheDir(), "pangle_com.byted.pangle"));
    }

    public static File n(Context context, String str, int i) {
        return i == 0 ? n(new File(context.getDir(str, i), "pangle_com.byted.pangle")) : context.getDir(str, i);
    }

    public static SharedPreferences qg(Context context, String str, int i) {
        return i == 0 ? com.byazt.qp.x.n(context, n(str), i) : com.byazt.qp.x.n(context, str, i);
    }

    private static String n(String str) {
        return "pangle_com.byted.pangle_" + str;
    }

    public static boolean l(Context context) {
        File file = new File(context.getFilesDir(), "/pangle_p/com.byted.pangle");
        if (!file.exists()) {
            return false;
        }
        final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.byazt.qyu.qg.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                try {
                    Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                    String strGroup = matcher.find() ? matcher.group() : "";
                    return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > 7814;
                } catch (Exception e) {
                    com.byazt.vx.w.n(e);
                    return file2.getName().matches(sb.toString());
                }
            }
        });
        return (fileArrListFiles == null || fileArrListFiles.length == 0) ? false : true;
    }
}
