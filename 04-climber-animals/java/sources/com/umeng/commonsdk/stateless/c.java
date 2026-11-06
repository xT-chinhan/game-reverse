package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.ce;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* JADX INFO: compiled from: UMSLNetWorkSenderHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private Context a;

    public c(Context context) {
        this.a = context;
    }

    public void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.a, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.h = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    public void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.a, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.a, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.g = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.j = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.h = a.j;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.h = a.g;
        }
    }

    public boolean a(byte[] bArr, String str, String str2, String str3) throws Throwable {
        String strA = str2 + "/" + str;
        if (SdkVersion.SDK_TYPE == 1) {
            return a(bArr, strA, str3);
        }
        if (ca.a().b()) {
            if (!strA.contains("preulogs")) {
                strA = strA.replace("ulogs", "cnlogs");
            }
            String strC = ce.b().c();
            if (!TextUtils.isEmpty(strC)) {
                strA = ca.a(strC, str);
            }
            boolean zA = a(bArr, strA, str3);
            if (!zA) {
                String strA2 = ca.a().a(str);
                if (!TextUtils.isEmpty(strA2) && !strA.equalsIgnoreCase(strA2)) {
                    return a(bArr, strA2, str3);
                }
            }
            return zA;
        }
        return a(bArr, strA, str3);
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00cd, code lost:
    
        if (r11 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00cf, code lost:
    
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
        r11.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0115, code lost:
    
        if (r11 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(byte[] r16, java.lang.String r17, java.lang.String r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String):boolean");
    }
}
