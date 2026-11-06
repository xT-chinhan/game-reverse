package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.umeng.analytics.pro.bv;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
@ATS(single = true, value = {com.anythink.basead.webtemplet.a.b.c.d})
public class ny {
    @ATSMethod(11)
    public int ch() {
        return 1;
    }

    @ATSMethod(1)
    public String ms() {
        return com.bytedance.sdk.openadsdk.core.t.c();
    }

    @ATSMethod(2)
    public String xr() {
        return new StringBuilder().append(Build.VERSION.SDK_INT).toString();
    }

    @ATSMethod(3)
    public int ah() {
        return com.bytedance.sdk.component.utils.u.ah(com.bytedance.sdk.openadsdk.core.re.getContext());
    }

    @ATSMethod(4)
    public String d() {
        return com.bytedance.sdk.openadsdk.core.t.re();
    }

    @ATSMethod(5)
    public String ka() {
        Context context = com.bytedance.sdk.openadsdk.core.re.getContext();
        return context == null ? "" : Settings.Global.getString(context.getContentResolver(), bv.J);
    }

    @ATSMethod(7)
    public String c() {
        return Locale.getDefault().getLanguage();
    }

    @ATSMethod(8)
    public String ab() {
        return ch.hi();
    }

    @ATSMethod(9)
    public String x() {
        return com.bytedance.sdk.openadsdk.core.t.h();
    }

    @ATSMethod(10)
    public String ny() {
        return com.bytedance.sdk.openadsdk.core.t.y();
    }

    @ATSMethod(12)
    public String hi() {
        return Build.VERSION.RELEASE;
    }

    @ATSMethod(13)
    public String sl() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return "";
        }
    }

    @ATSMethod(14)
    public String zb() {
        return String.valueOf(Long.parseLong(f.zb()) * 1024);
    }

    @ATSMethod(15)
    public String u() {
        return String.valueOf(f.qv());
    }

    @ATSMethod(16)
    public String ub() {
        return Build.MANUFACTURER;
    }

    @ATSMethod(17)
    public String ao() {
        String string;
        double dCurrentTimeMillis = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d;
        try {
            string = new Formatter().format("%.6f", Double.valueOf(dCurrentTimeMillis)).toString();
        } catch (Exception unused) {
            string = "";
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return new DecimalFormat("#0.000000").format(dCurrentTimeMillis);
        } catch (Exception unused2) {
            return string;
        }
    }

    @ATSMethod(18)
    public String h() {
        return com.bytedance.sdk.openadsdk.core.t.nw();
    }

    @ATSMethod(19)
    public String qv() {
        return com.bytedance.sdk.openadsdk.core.t.ab();
    }

    @ATSMethod(20)
    public String y() {
        return ch.c();
    }

    @ATSMethod(21)
    public String t() {
        return com.bytedance.sdk.openadsdk.core.ah.ms.ah();
    }

    @ATSMethod(22)
    public String nw() {
        return com.bytedance.sdk.openadsdk.core.t.x();
    }

    @ATSMethod(23)
    public String b() {
        return com.bytedance.sdk.openadsdk.core.t.ch();
    }

    @ATSMethod(24)
    public String re() {
        return com.bytedance.sdk.openadsdk.core.t.ny();
    }

    @ATSMethod(25)
    public String i() {
        return com.bytedance.sdk.openadsdk.core.t.d();
    }

    @ATSMethod(26)
    public String w() {
        return com.bytedance.sdk.openadsdk.core.t.sl();
    }

    @ATSMethod(27)
    public String yu() {
        return com.bytedance.sdk.openadsdk.core.t.b();
    }

    @ATSMethod(28)
    public int op() {
        return ch.ms(com.bytedance.sdk.openadsdk.core.re.getContext(), false);
    }

    @ATSMethod(29)
    public String le() {
        return f.c();
    }

    @ATSMethod(30)
    public String cv() {
        return com.bytedance.sdk.openadsdk.core.t.ms.hi();
    }

    @ATSMethod(31)
    public int g() {
        return com.bytedance.sdk.openadsdk.core.t.ms.sl();
    }

    @ATSMethod(32)
    public String of() {
        return com.bytedance.sdk.openadsdk.core.t.ms.ms(ul.x(com.bytedance.sdk.openadsdk.core.re.getContext()));
    }
}
