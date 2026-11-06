package com.byazt.fg;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.apo.hn;
import com.byazt.ca.qa;
import com.byazt.fp.DeviceInfoUtils;
import com.byazt.fp.aj;
import com.byazt.fp.fw;
import com.byazt.fp.uc;
import com.byazt.fp.vk;
import com.byazt.fp.w;
import com.byazt.vkw.g;
import com.byazt.vkw.y;
import com.byazt.vlp.x;
import com.umeng.analytics.pro.an;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1035, 37})
public class pr implements g, Function {
    public static final int DEVICE_OS_ANDROID_TYPE = 1;
    public static final int MAIN_VERSION = 7600;
    public static AtomicBoolean mIsNeedUpdateIp = new AtomicBoolean(false);
    public static volatile boolean pr;
    public volatile String a;
    public volatile String aj;
    public hn b;
    public volatile String c;
    public volatile String cz;
    public volatile String fo;
    public volatile String fw;
    public volatile String g;
    public volatile String hn;
    public volatile String ho;
    public volatile String hw;
    public Context iu;
    public volatile String k;
    public volatile String lb;
    public volatile String m;
    public volatile String nt;
    public String ny;
    public volatile String qa;
    public volatile String rc;
    public volatile String uc;
    public x ve;
    public volatile String vk;
    public volatile String w;
    public volatile String x = "";
    public volatile String yb;
    public volatile long z;
    public volatile String zo;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -3:
                pr((SparseArray) sparseArray.get(1));
                return null;
            case -2:
                return ls();
            case -1:
                s();
                return null;
            case 0:
            default:
                return null;
            case 1:
                return pr();
            case 2:
                return hw();
            case 3:
                return hn();
            case 4:
                return x();
            case 5:
                return c();
            case 6:
                return uc();
            case 7:
                return fw();
            case 8:
                return Integer.valueOf(zo());
            case 9:
                return aj();
            case 10:
                return vk();
            case 11:
                return w();
            case 12:
                return k();
            case 13:
                return m();
            case 14:
                return g();
            case 15:
                return ho();
            case 16:
                return nt();
            case 17:
                return yb();
            case 18:
                return Integer.valueOf(lb());
            case 19:
                return Integer.valueOf(pr(((Boolean) sparseArray.get(1)).booleanValue()));
            case 20:
                return hw(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                return hn(((Boolean) sparseArray.get(1)).booleanValue());
            case 22:
                return pr((Boolean) sparseArray.get(1));
            case 23:
                com.byazt.apo.pr prVarX = x(((Boolean) sparseArray.get(1)).booleanValue());
                return prVarX != null ? new com.byazt.apo.hw(prVarX) : prVarX;
            case 24:
                return hw((Boolean) sparseArray.get(1));
            case 25:
                return hn((Boolean) sparseArray.get(1));
            case 26:
                return x((Boolean) sparseArray.get(1));
            case 27:
                return c((Boolean) sparseArray.get(1));
            case 28:
                return qa();
            case 29:
                return Integer.valueOf(a());
            case 30:
                return Integer.valueOf(cz());
            case 31:
                return Integer.valueOf(ny());
            case 32:
                return fo();
            case 33:
                return rc();
            case 34:
                return z();
            case 35:
                return b();
            case 36:
                return Integer.valueOf(pr(((Long) sparseArray.get(1)).longValue()));
            case 37:
                Object xVar = sparseArray.get(1);
                if (xVar != null) {
                    xVar = new com.byazt.apo.x((Function) xVar);
                }
                pr((hn) xVar);
                return null;
            case 38:
                Object xVar2 = sparseArray.get(1);
                if (xVar2 != null) {
                    xVar2 = new com.byazt.apo.x((Function) xVar2);
                }
                hw((hn) xVar2);
                return null;
            case 39:
                return iu();
            case 40:
                return Boolean.valueOf(ve());
            case 41:
                return Float.valueOf(gz());
            case 42:
                return c(((Boolean) sparseArray.get(1)).booleanValue());
            case 43:
                return pr(((Integer) sparseArray.get(1)).intValue());
            case 44:
                return nl();
            case 45:
                return y();
            case 46:
                return Long.valueOf(ww());
            case 47:
                return Boolean.valueOf(n());
            case 48:
                return Boolean.valueOf(e());
        }
    }

    public SparseArray ls() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.hw);
        sparseArray.put(2, this.hn);
        sparseArray.put(3, this.x);
        sparseArray.put(4, this.c);
        sparseArray.put(5, this.uc);
        sparseArray.put(6, this.fw);
        sparseArray.put(7, this.zo);
        sparseArray.put(8, this.aj);
        sparseArray.put(9, this.vk);
        sparseArray.put(10, this.w);
        sparseArray.put(11, this.k);
        sparseArray.put(12, this.m);
        sparseArray.put(13, this.g);
        sparseArray.put(14, this.ho);
        sparseArray.put(15, this.nt);
        sparseArray.put(16, this.yb);
        sparseArray.put(18, this.lb);
        sparseArray.put(19, this.qa);
        sparseArray.put(20, this.a);
        sparseArray.put(21, this.cz);
        sparseArray.put(24, this.ny);
        sparseArray.put(25, mIsNeedUpdateIp);
        sparseArray.put(26, this.fo);
        sparseArray.put(27, this.rc);
        sparseArray.put(28, Long.valueOf(this.z));
        return sparseArray;
    }

    public void pr(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.hw = (String) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            this.hn = (String) obj2;
        }
        Object obj3 = sparseArray.get(3);
        if (obj3 != null) {
            this.x = (String) obj3;
        }
        Object obj4 = sparseArray.get(4);
        if (obj4 != null) {
            this.c = (String) obj4;
        }
        Object obj5 = sparseArray.get(5);
        if (obj5 != null) {
            this.uc = (String) obj5;
        }
        Object obj6 = sparseArray.get(6);
        if (obj6 != null) {
            this.fw = (String) obj6;
        }
        Object obj7 = sparseArray.get(7);
        if (obj7 != null) {
            this.zo = (String) obj7;
        }
        Object obj8 = sparseArray.get(8);
        if (obj8 != null) {
            this.aj = (String) obj8;
        }
        Object obj9 = sparseArray.get(9);
        if (obj9 != null) {
            this.vk = (String) obj9;
        }
        Object obj10 = sparseArray.get(10);
        if (obj10 != null) {
            this.w = (String) obj10;
        }
        Object obj11 = sparseArray.get(11);
        if (obj11 != null) {
            this.k = (String) obj11;
        }
        Object obj12 = sparseArray.get(12);
        if (obj12 != null) {
            this.m = (String) obj12;
        }
        Object obj13 = sparseArray.get(13);
        if (obj13 != null) {
            this.g = (String) obj13;
        }
        Object obj14 = sparseArray.get(14);
        if (obj14 != null) {
            this.ho = (String) obj14;
        }
        Object obj15 = sparseArray.get(15);
        if (obj15 != null) {
            this.nt = (String) obj15;
        }
        Object obj16 = sparseArray.get(16);
        if (obj16 != null) {
            this.yb = (String) obj16;
        }
        Object obj17 = sparseArray.get(18);
        if (obj17 != null) {
            this.lb = (String) obj17;
        }
        Object obj18 = sparseArray.get(19);
        if (obj18 != null) {
            this.qa = (String) obj18;
        }
        Object obj19 = sparseArray.get(20);
        if (obj19 != null) {
            this.a = (String) obj19;
        }
        Object obj20 = sparseArray.get(21);
        if (obj20 != null) {
            this.cz = (String) obj20;
        }
        Object obj21 = sparseArray.get(24);
        if (obj21 != null) {
            this.ny = (String) obj21;
        }
        Object obj22 = sparseArray.get(25);
        if (obj22 != null) {
            mIsNeedUpdateIp = (AtomicBoolean) obj22;
        }
        Object obj23 = sparseArray.get(26);
        if (obj23 != null) {
            this.fo = (String) obj23;
        }
        Object obj24 = sparseArray.get(27);
        if (obj24 != null) {
            this.rc = (String) obj24;
        }
        Object obj25 = sparseArray.get(28);
        if (obj25 != null) {
            this.z = ((Long) obj25).longValue();
        }
    }

    public pr(Context context, x xVar) {
        this.iu = context;
        this.ve = xVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        DeviceInfoUtils.pr(this.iu, new DeviceInfoUtils.ScreenStatusReceiver(), intentFilter);
        DeviceInfoUtils.pr prVar = new DeviceInfoUtils.pr(this.ve);
        this.b = prVar;
        aj.pr(prVar, this.iu);
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                qa.pr();
                aj.pr(new hw());
            } catch (Exception e) {
            }
        }
        com.byazt.fp.hw.pr(new com.byazt.fp.hw.pr() { // from class: com.byazt.fg.pr.1
            @Override // com.byazt.fp.hw.pr
            public void pr(String str) {
                if (!TextUtils.isEmpty(str)) {
                    pr.this.fo = str;
                }
            }

            @Override // com.byazt.fp.hw.pr
            public void hw(String str) {
                if (!TextUtils.isEmpty(str)) {
                    pr.this.rc = str;
                }
            }
        });
    }

    @Override // com.byazt.vkw.g
    public String pr() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.pr();
        }
        if (!TextUtils.isEmpty(this.hw)) {
            return this.hw;
        }
        com.byazt.vlp.hw hwVarW = this.ve.pr().w();
        if (hwVarW != null && !hwVarW.vk()) {
            return hwVarW.k();
        }
        if (pr) {
            return this.hw;
        }
        synchronized (this) {
            if (pr) {
                return this.hw;
            }
            this.hw = com.byazt.fp.hn.hn(this.iu);
            pr = true;
            return this.hw;
        }
    }

    @Override // com.byazt.vkw.g
    public String hw() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.hn();
        }
        if (TextUtils.isEmpty(this.hn)) {
            this.hn = Build.MODEL;
        }
        return this.hn;
    }

    @Override // com.byazt.vkw.g
    public String hn() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.x();
        }
        if (this.iu == null) {
            return "";
        }
        if (!TextUtils.isEmpty(this.x)) {
            return this.x;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.x = Settings.Global.getString(this.iu.getContentResolver(), an.J);
        }
        return this.x;
    }

    @Override // com.byazt.vkw.g
    public String x() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.byazt.vkw.g
    public String c() {
        String languageTag = Locale.getDefault().toLanguageTag();
        if (!TextUtils.isEmpty(languageTag)) {
            return languageTag;
        }
        return "";
    }

    @Override // com.byazt.vkw.g
    public String uc() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.fw();
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = com.byazt.fp.hn.c(this.ve.pr(), this.iu);
        }
        return this.c;
    }

    @Override // com.byazt.vkw.g
    public String fw() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.zo();
        }
        if (TextUtils.isEmpty(this.uc)) {
            this.uc = com.byazt.fp.hn.fw(this.ve.pr(), this.iu);
        }
        return this.uc;
    }

    @Override // com.byazt.vkw.g
    public int zo() {
        return 1;
    }

    @Override // com.byazt.vkw.g
    public String aj() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.vk();
        }
        if (TextUtils.isEmpty(this.nt)) {
            this.nt = Build.VERSION.RELEASE;
        }
        return this.nt;
    }

    @Override // com.byazt.vkw.g
    public String vk() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            return "";
        }
    }

    @Override // com.byazt.vkw.g
    public String w() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.g();
        }
        if (TextUtils.isEmpty(this.yb)) {
            this.yb = Build.MANUFACTURER;
        }
        return this.yb;
    }

    @Override // com.byazt.vkw.g
    public String k() {
        String string;
        double dCurrentTimeMillis = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d;
        try {
            string = new Formatter().format("%.6f", Double.valueOf(dCurrentTimeMillis)).toString();
        } catch (Exception e) {
            string = "";
        }
        if (TextUtils.isEmpty(string)) {
            try {
                return new DecimalFormat("#0.000000").format(dCurrentTimeMillis);
            } catch (Exception e2) {
                return string;
            }
        }
        return string;
    }

    @Override // com.byazt.vkw.g
    public String m() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.nt();
        }
        if (TextUtils.isEmpty(this.g)) {
            this.g = com.byazt.fp.hn.aj(this.ve.pr(), this.iu);
        }
        return this.g;
    }

    @Override // com.byazt.vkw.g
    public String g() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.qa();
        }
        if (TextUtils.isEmpty(this.ho)) {
            this.ho = String.valueOf(Build.TIME);
        }
        return this.ho;
    }

    @Override // com.byazt.vkw.g
    public String ho() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.a();
        }
        if (TextUtils.isEmpty(this.m)) {
            this.m = com.byazt.fp.hn.pr(this.ve.pr());
        }
        return this.m;
    }

    @Override // com.byazt.vkw.g
    public String nt() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.cz();
        }
        if (TextUtils.isEmpty(this.lb)) {
            this.lb = vk.pr();
        }
        return this.lb;
    }

    @Override // com.byazt.vkw.g
    public String yb() {
        y yVarV;
        if (qi() && (yVarV = v()) != null) {
            return yVarV.ny();
        }
        if (TextUtils.isEmpty(this.qa)) {
            this.qa = uc.pr(this.ve.pr());
        }
        return this.qa;
    }

    @Override // com.byazt.vkw.g
    public int lb() {
        return DeviceInfoUtils.pr();
    }

    @Override // com.byazt.vkw.g
    public int pr(boolean z) {
        y yVarV;
        if (qn() && qi() && (yVarV = v()) != null) {
            return yVarV.pr(z);
        }
        return DeviceInfoUtils.pr(this.iu, z, this.ve.pr());
    }

    @Override // com.byazt.vkw.g
    public String hw(boolean z) {
        y yVarV;
        if (qn() && qi() && (yVarV = v()) != null && !z) {
            return yVarV.z();
        }
        if (TextUtils.isEmpty(this.a)) {
            this.a = vk.pr(this.iu, this.ve.pr(), z, this.ve.uc());
        }
        return this.a;
    }

    @Override // com.byazt.vkw.g
    public String[] hn(boolean z) {
        y yVarV;
        if (qn() && qi() && (yVarV = v()) != null) {
            return yVarV.hw(z);
        }
        if (er()) {
            return new String[]{this.fo, this.rc};
        }
        String[] strArrPr = com.byazt.fp.hw.pr(z, mIsNeedUpdateIp, this.ve.pr(), this.ve.hn(), this.ve);
        this.z = System.currentTimeMillis();
        if (strArrPr.length >= 2) {
            this.fo = strArrPr[0];
            this.rc = strArrPr[1];
        }
        return strArrPr;
    }

    @Override // com.byazt.vkw.g
    public com.byazt.apo.pr x(boolean z) {
        y yVarV;
        if (qn() && qi() && (yVarV = v()) != null) {
            return yVarV.b();
        }
        return com.byazt.fp.pr.pr(this.iu, z, this.ve.pr());
    }

    @Override // com.byazt.vkw.g
    public String pr(Boolean bool) {
        y yVarV;
        if (qn() && qi() && (yVarV = v()) != null) {
            return yVarV.pr(bool);
        }
        if (TextUtils.isEmpty(this.w)) {
            this.w = com.byazt.fp.hn.x(bool, this.ve.pr(), this.iu);
        }
        return this.w;
    }

    @Override // com.byazt.vkw.g
    public String hw(Boolean bool) {
        y yVarV;
        if (qn() && qi() && (yVarV = v()) != null) {
            return yVarV.hw(bool);
        }
        if (TextUtils.isEmpty(this.aj)) {
            this.aj = com.byazt.fp.hn.pr(bool, this.ve.pr(), this.iu);
        }
        return this.aj;
    }

    @Override // com.byazt.vkw.g
    public String hn(Boolean bool) {
        y yVarV;
        if (qn() && qi() && (yVarV = v()) != null) {
            return yVarV.hn(bool);
        }
        if (TextUtils.isEmpty(this.cz)) {
            this.cz = com.byazt.fp.hn.pr(bool, this.ve.pr(), this.ve.hn(), this.ve);
        }
        return this.cz;
    }

    @Override // com.byazt.vkw.g
    public String x(Boolean bool) {
        y yVarV;
        if (qn() && qi() && (yVarV = v()) != null) {
            return yVarV.x(bool);
        }
        if (TextUtils.isEmpty(this.vk)) {
            this.vk = com.byazt.fp.hn.hn(bool, this.ve.pr(), this.iu);
        }
        return this.vk;
    }

    @Override // com.byazt.vkw.g
    public String c(Boolean bool) {
        y yVarV;
        if (qn() && qi() && (yVarV = v()) != null) {
            return yVarV.c(bool);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = com.byazt.fp.hn.hw(bool, this.ve.pr(), this.iu);
        }
        return this.k;
    }

    public void s() {
        DeviceInfoUtils.hn(this.iu);
        DeviceInfoUtils.x(this.iu);
        DeviceInfoUtils.c(this.iu);
        com.byazt.fp.hw.pr((com.byazt.fp.hw.pr) null);
        aj.pr(this.b);
        this.b = null;
    }

    @Override // com.byazt.vkw.g
    public String qa() {
        if (TextUtils.isEmpty(this.ny)) {
            this.ny = uc.hn();
        }
        return this.ny;
    }

    @Override // com.byazt.vkw.g
    public int a() {
        return w.hw(this.iu);
    }

    @Override // com.byazt.vkw.g
    public int cz() {
        return w.x(this.iu);
    }

    @Override // com.byazt.vkw.g
    public int ny() {
        return w.hn(this.iu);
    }

    @Override // com.byazt.vkw.g
    public String fo() {
        y yVarV;
        if (of() && qi() && (yVarV = v()) != null) {
            return yVarV.n();
        }
        if (TextUtils.isEmpty(this.fw)) {
            this.fw = com.byazt.fp.hn.uc(this.ve.pr(), this.iu);
        }
        return this.fw;
    }

    @Override // com.byazt.vkw.g
    public String rc() {
        y yVarV;
        if (of() && qi() && (yVarV = v()) != null) {
            return yVarV.e();
        }
        if (TextUtils.isEmpty(this.zo)) {
            this.zo = com.byazt.fp.hn.zo(this.ve.pr(), this.iu);
        }
        return this.zo;
    }

    @Override // com.byazt.vkw.g
    public String z() {
        return com.byazt.fp.hn.hw(this.ve.pr(), this.iu);
    }

    @Override // com.byazt.vkw.g
    public String b() {
        return com.byazt.fp.hn.x(this.ve.pr(), this.iu);
    }

    @Override // com.byazt.vkw.g
    public int pr(long j) {
        return aj.pr(this.iu, j);
    }

    @Override // com.byazt.vkw.g
    public void pr(hn hnVar) {
        aj.pr(hnVar, this.iu);
    }

    @Override // com.byazt.vkw.g
    public void hw(hn hnVar) {
        aj.pr(hnVar);
    }

    @Override // com.byazt.vkw.g
    public String iu() {
        return uc.hw(this.ve.pr());
    }

    @Override // com.byazt.vkw.g
    public boolean ve() {
        return DeviceInfoUtils.uc(this.iu);
    }

    @Override // com.byazt.vkw.g
    public float gz() {
        return DeviceInfoUtils.fw(this.iu);
    }

    @Override // com.byazt.vkw.g
    public Map<String, String> c(boolean z) {
        return com.byazt.fp.hw.pr(z, this.ve.pr(), this.ve.hn(), this.ve);
    }

    @Override // com.byazt.vkw.g
    public String pr(int i) {
        return DeviceInfoUtils.pr(i, this.ve.pr(), this.iu);
    }

    @Override // com.byazt.vkw.g
    public String nl() {
        return fw.pr(this.iu, this.ve.pr());
    }

    @Override // com.byazt.vkw.g
    public String y() {
        return fw.pr(this.ve.pr(), this.iu);
    }

    @Override // com.byazt.vkw.g
    public long ww() {
        return DeviceInfoUtils.hw();
    }

    @Override // com.byazt.vkw.g
    public boolean n() {
        return com.byazt.fp.hw.x(this.ve.pr(), this.ve.hn(), this.ve);
    }

    @Override // com.byazt.vkw.g
    public boolean e() {
        return com.byazt.fp.hw.c(this.ve.pr(), this.ve.hn(), this.ve);
    }

    private boolean er() {
        return (mIsNeedUpdateIp.get() || DeviceInfoUtils.pr(this.z, 1800000L) || TextUtils.isEmpty(this.fo)) ? false : true;
    }

    private y v() {
        return (y) com.byazt.zs.uc.pr("device_info");
    }

    private boolean qi() {
        return this.ve.x() && this.ve.hw() < 7600;
    }

    private boolean qn() {
        return this.ve.x() && this.ve.hw() >= 7100;
    }

    private boolean of() {
        return this.ve.x() && this.ve.hw() >= 7500;
    }
}
