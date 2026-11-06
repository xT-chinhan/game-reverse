package com.kwad.sdk.core.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.e.a.b;
import com.kwad.sdk.core.e.a.d;
import com.kwad.sdk.core.e.a.e;
import com.kwad.sdk.core.e.a.f;
import com.kwad.sdk.core.e.a.g;
import com.kwad.sdk.core.e.a.j;
import com.kwad.sdk.core.e.a.k;
import com.kwad.sdk.core.e.a.l;
import com.kwad.sdk.core.e.a.m;
import com.kwad.sdk.core.e.a.n;
import com.kwad.sdk.oaid.NewOAIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.s;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.ek;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    static /* synthetic */ void Ig() {
    }

    public static String getAppOAID(Context context) {
        if (bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid())) {
            return bc.getDevOaid();
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (bc.useOaidDisable() || !s.PU()) {
            String strIe = Ie();
            sOAID = strIe;
            return strIe;
        }
        initAsync(context);
        return sOAID;
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.core.e.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                String unused = a.sOAID = a.Ie();
                if (TextUtils.isEmpty(a.sOAID)) {
                    a.getOAIDNormal(context);
                    if (NewOAIDSDKHelper.isSupport()) {
                        NewOAIDSDKHelper.a(context, new NewOAIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                            @Override // com.kwad.sdk.oaid.NewOAIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eu(str);
                                a.Ig();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eu(str);
                                a.Ig();
                            }
                        });
                    }
                    a.sInitIng.set(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Ie() {
        if (sHasReadSp.getAndSet(true)) {
            return sOAID;
        }
        String strH = ag.h("ksadsdk_pref", "kasd_oaid_key", "");
        sOAID = strH;
        return strH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eu(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ag.g("ksadsdk_pref", "kasd_oaid_key", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:61:0x00d3  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void getOAIDNormal(Context context) {
        byte b;
        if (!TextUtils.isEmpty(sOAID) || context == null || sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            switch (upperCase.hashCode()) {
                case -2053026509:
                    if (!upperCase.equals("LENOVO")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case -1712043046:
                    if (!upperCase.equals("SAMSUNG")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case -1706170181:
                    if (!upperCase.equals("XIAOMI")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case -1134767290:
                    if (!upperCase.equals("BLACKSHARK")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case -602397472:
                    if (!upperCase.equals("ONEPLUS")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 89163:
                    if (!upperCase.equals("ZTE")) {
                        b = -1;
                    } else {
                        b = ek.k;
                    }
                    break;
                case 2018896:
                    if (!upperCase.equals("ASUS")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                case 2432928:
                    if (!upperCase.equals(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 2555124:
                    if (!upperCase.equals("SSUI")) {
                        b = -1;
                    } else {
                        b = ek.m;
                    }
                    break;
                case 2634924:
                    if (!upperCase.equals("VIVO")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 68924490:
                    if (!upperCase.equals("HONOR")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 73239724:
                    if (!upperCase.equals("MEIZU")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 74632627:
                    if (!upperCase.equals("NUBIA")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 630905871:
                    if (!upperCase.equals("MOTOLORA")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 976565563:
                    if (!upperCase.equals("FERRMEOS")) {
                        b = -1;
                    } else {
                        b = ek.l;
                    }
                    break;
                case 2141820391:
                    if (!upperCase.equals("HUAWEI")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    sOAID = new d(applicationContext).getOAID();
                    break;
                case 1:
                    sOAID = new b(applicationContext).getOAID();
                    break;
                case 2:
                case 3:
                    sOAID = new m(applicationContext).getOAID();
                    break;
                case 4:
                case 5:
                    sOAID = new j(applicationContext).getOAID();
                    break;
                case 6:
                    sOAID = new l(applicationContext).getOAID();
                    break;
                case 7:
                case 8:
                    sOAID = new e(applicationContext).getOAID();
                    break;
                case 9:
                    sOAID = new f(applicationContext).getOAID();
                    break;
                case 10:
                    sOAID = new g(applicationContext).getOAID();
                    break;
                case 11:
                    sOAID = new k(applicationContext).getOAID();
                    break;
                case 12:
                    sOAID = new com.kwad.sdk.core.e.a.a(applicationContext).getOAID();
                    break;
                case 13:
                case 14:
                case 15:
                    sOAID = new n(applicationContext).getOAID();
                    break;
            }
            c.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + sOAID);
            if (TextUtils.isEmpty(sOAID)) {
                sGetOaidFail = true;
            }
            eu(sOAID);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }
}
