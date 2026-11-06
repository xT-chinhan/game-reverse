package com.tapsdk.tapad.internal.ui.views.web;

import android.webkit.URLUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    String a;
    String b;
    long c;
    String d;
    String e;
    String f;

    private b() {
        this.a = "";
        this.b = "";
        this.c = 0L;
        this.d = "";
        this.e = "";
        this.f = "";
    }

    public b(String str) {
        this.b = "";
        this.c = 0L;
        this.d = "";
        this.e = "";
        this.f = "";
        this.a = str;
    }

    public b(String str, String str2, String str3, String str4, long j) {
        this.b = "";
        this.a = str;
        this.e = str4;
        this.f = str3;
        this.c = j;
        this.d = str2;
        this.b = a(str, str3, str4);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0018  */
    private String a(String str, String str2, String str3) {
        String strGuessFileName;
        if (str2 != null) {
            Matcher matcher = Pattern.compile("filename=\"?([^\"]+)\"?").matcher(str2);
            if (matcher.find()) {
                strGuessFileName = matcher.group(1);
            } else {
                strGuessFileName = null;
            }
        } else {
            strGuessFileName = null;
        }
        if (strGuessFileName == null) {
            strGuessFileName = URLUtil.guessFileName(str, str2, str3);
        }
        return strGuessFileName == null ? "" : strGuessFileName;
    }
}
