package com.tapsdk.tapad.internal.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static String a(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                exc.printStackTrace(printWriter);
                printWriter.flush();
                stringWriter.flush();
                String string = stringWriter.toString();
                try {
                    printWriter.close();
                } catch (Throwable unused) {
                }
                try {
                    stringWriter.close();
                } catch (Throwable unused2) {
                }
                return string;
            } catch (Throwable unused3) {
                try {
                    stringWriter.close();
                    return "";
                } catch (Throwable unused4) {
                    return "";
                }
            }
        } catch (Throwable unused5) {
            printWriter.close();
            stringWriter.close();
            return "";
        }
    }
}
