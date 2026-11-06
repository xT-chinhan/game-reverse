package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.net.URL;

/* JADX INFO: compiled from: DomainSelector.java */
/* JADX INFO: loaded from: classes4.dex */
public class ca {
    public static final String a = "resolve.umeng.com";
    public static final int b = 15000;
    private static ce c = null;
    private static volatile int d = -1;

    /* JADX INFO: compiled from: DomainSelector.java */
    private static class a {
        public static final ca a = new ca();

        private a() {
        }
    }

    public static ca a() {
        return a.a;
    }

    private ca() {
    }

    public synchronized boolean b() {
        if (d < 0) {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), "cj_domain", "0");
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> cj_domain读取值：" + strImprintProperty);
            if ("1".equalsIgnoreCase(strImprintProperty)) {
                d = 1;
            } else {
                d = 0;
            }
        }
        return d <= 0;
    }

    private String c() {
        if (c == null) {
            c = ce.b();
        }
        cc ccVar = new cc("https://resolve.umeng.com/resolve", cc.a.GET, null, c);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 发送domain下发请求。");
        return ccVar.a(15000, "");
    }

    public synchronized String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        c();
        String strC = ce.b().c();
        return TextUtils.isEmpty(strC) ? "" : "https://" + strC + "/" + str;
    }

    private static String c(String str) {
        try {
            return new URL(str).getHost();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            String strC = c(str);
            return str.substring(str.indexOf(strC) + strC.length() + 1);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : "https://" + str + "/" + str2;
    }
}
