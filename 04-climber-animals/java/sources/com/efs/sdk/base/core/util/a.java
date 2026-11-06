package com.efs.sdk.base.core.util;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static String a = "efs";
    private static File b;

    public static void a(String str) {
        a = str;
    }

    public static File a(Context context) {
        File dir = context.getDir(a, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    private static File j(Context context, String str) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = a(context);
                }
            }
        }
        File file = new File(b, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File a(Context context, String str) {
        return new File(j(context, str), "efs_cst");
    }

    public static File b(Context context, String str) {
        return new File(j(context, str), "efs_config");
    }

    public static File c(Context context, String str) {
        return new File(j(context, str), "efs_flow");
    }

    public static File d(Context context, String str) {
        File file = new File(j(context, str), "ready");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File e(Context context, String str) {
        File file = new File(j(context, str), "ready_codelog");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f(Context context, String str) {
        File file = new File(d(context, str), String.valueOf(ProcessUtil.myPid()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File g(Context context, String str) {
        File file = new File(e(context, str), String.valueOf(ProcessUtil.myPid()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File h(Context context, String str) {
        File file = new File(j(context, str), "upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File i(Context context, String str) {
        File file = new File(j(context, str), "upload_codelog");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
