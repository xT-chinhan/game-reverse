package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static volatile String a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            synchronized (d.class) {
                if (TextUtils.isEmpty(a)) {
                    String strB = b(context);
                    a = strB;
                    if (TextUtils.isEmpty(strB)) {
                        a = c(context);
                    }
                }
            }
        }
        return a;
    }

    private static String b(Context context) {
        try {
            File file = new File(a.a(context), "efsid");
            if (!file.exists()) {
                return null;
            }
            return b.a(file);
        } catch (Exception e) {
            Log.e("efs.base", "get uuid error", e);
            return null;
        }
    }

    private static String c(Context context) {
        String str = "";
        for (int i = 0; i < 3; i++) {
            try {
                String string = UUID.randomUUID().toString();
                try {
                    if (TextUtils.isEmpty(string)) {
                        str = string;
                    } else {
                        str = string;
                        break;
                    }
                } catch (Throwable th) {
                    str = string;
                }
            } catch (Throwable th2) {
            }
        }
        try {
            File fileA = a.a(context);
            File file = new File(fileA, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            b.a(file, str);
            if (file.renameTo(new File(fileA, "efsid"))) {
                file.delete();
            }
        } catch (Exception e) {
            Log.e("efs.base", "save uuid '" + str + "' error", e);
        }
        return str;
    }
}
