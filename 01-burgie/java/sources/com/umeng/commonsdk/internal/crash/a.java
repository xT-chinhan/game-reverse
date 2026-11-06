package com.umeng.commonsdk.internal.crash;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: UMCrashUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a(Throwable th) {
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            String string = stringWriter.toString();
            try {
                printWriter.close();
                stringWriter.close();
                return string;
            } catch (Exception e) {
                return string;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
