package com.byazt.mg;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, 13})
public final class hw {
    private static File pr(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File pr(Context context) {
        return pr(new File(context.getFilesDir(), "pangle_com.byted.pangle"));
    }

    public static File pr(Context context, String str) {
        return pr(new File(context.getExternalFilesDir(str), "pangle_com.byted.pangle"));
    }

    public static File hw(Context context) {
        return pr(new File(context.getCacheDir(), "pangle_com.byted.pangle"));
    }

    public static File hn(Context context) {
        return pr(new File(context.getExternalCacheDir(), "pangle_com.byted.pangle"));
    }

    public static File pr(Context context, String str, int i) {
        return i == 0 ? pr(new File(context.getDir(str, i), "pangle_com.byted.pangle")) : context.getDir(str, i);
    }

    public static SharedPreferences hw(Context context, String str, int i) {
        return i == 0 ? com.byazt.zs.aj.pr(context, pr(str), i) : com.byazt.zs.aj.pr(context, str, i);
    }

    private static String pr(String str) {
        return "pangle_com.byted.pangle_" + str;
    }

    public static boolean x(Context context) {
        File file = new File(context.getFilesDir(), "/pangle_p/com.byted.pangle");
        if (!file.exists()) {
            return false;
        }
        final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.byazt.mg.hw.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                try {
                    Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                    String strGroup = matcher.find() ? matcher.group() : "";
                    return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > 7714;
                } catch (Exception e) {
                    com.byazt.dea.uc.pr(e);
                    return file2.getName().matches(sb.toString());
                }
            }
        });
        return (fileArrListFiles == null || fileArrListFiles.length == 0) ? false : true;
    }
}
