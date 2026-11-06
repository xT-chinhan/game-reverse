package com.byazt.gwg;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.g.c;
import com.byazt.bq.DeviceInfoUtils;
import com.byazt.bq.cp;
import com.byazt.bq.rv;
import com.byazt.bq.tj;
import com.byazt.bq.w;
import com.byazt.bq.x;
import com.byazt.hsi.l;
import com.byazt.hsi.s;
import com.byazt.qp.q;
import com.byazt.tk.um;
import com.byazt.vf.lh;
import com.byazt.vf.oa;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1164, 19})
public class n implements oa, Function {
    public static final int DEVICE_OS_ANDROID_TYPE = 1;
    public static final int MAIN_VERSION = 7600;
    public static AtomicBoolean mIsNeedUpdateIp = new AtomicBoolean(false);
    public static volatile boolean n;
    public volatile String a;
    public volatile String cd;
    public volatile String cp;
    public volatile String cy;
    public volatile String d;
    public volatile String fs;
    public s h;
    public volatile String hd;
    public volatile long hu;
    public volatile String k;
    public volatile String l;
    public volatile String m;
    public volatile String oa;
    public String ou;
    public volatile String py;
    public volatile String q = "";
    public volatile String qg;
    public volatile String rv;
    public volatile String s;
    public volatile String sz;
    public Context t;
    public volatile String tj;
    public volatile String um;
    public com.byazt.tbi.s ur;
    public volatile String w;
    public volatile String wm;
    public volatile String x;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -3:
                n((SparseArray) sparseArray.get(1));
                return null;
            case -2:
                return f();
            case -1:
                ae();
                return null;
            case 0:
            default:
                return null;
            case 1:
                return n();
            case 2:
                return qg();
            case 3:
                return s();
            case 4:
                return q();
            case 5:
                return l();
            case 6:
                return w();
            case 7:
                return x();
            case 8:
                return Integer.valueOf(fs());
            case 9:
                return rv();
            case 10:
                return tj();
            case 11:
                return cp();
            case 12:
                return d();
            case 13:
                return oa();
            case 14:
                return sz();
            case 15:
                return k();
            case 16:
                return cy();
            case 17:
                return hd();
            case 18:
                return Integer.valueOf(cd());
            case 19:
                return Integer.valueOf(n(((Boolean) sparseArray.get(1)).booleanValue()));
            case 20:
                return qg(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                return s(((Boolean) sparseArray.get(1)).booleanValue());
            case 22:
                return n((Boolean) sparseArray.get(1));
            case 23:
                com.byazt.hsi.n nVarQ = q(((Boolean) sparseArray.get(1)).booleanValue());
                return nVarQ != null ? new com.byazt.hsi.qg(nVarQ) : nVarQ;
            case 24:
                return qg((Boolean) sparseArray.get(1));
            case 25:
                return s((Boolean) sparseArray.get(1));
            case 26:
                return q((Boolean) sparseArray.get(1));
            case 27:
                return l((Boolean) sparseArray.get(1));
            case 28:
                return um();
            case 29:
                return Integer.valueOf(a());
            case 30:
                return Integer.valueOf(py());
            case 31:
                return Integer.valueOf(ou());
            case 32:
                return wm();
            case 33:
                return m();
            case 34:
                return hu();
            case 35:
                return h();
            case 36:
                return Integer.valueOf(n(((Long) sparseArray.get(1)).longValue()));
            case 37:
                Object lVar = sparseArray.get(1);
                if (lVar != null) {
                    lVar = new l((Function) lVar);
                }
                n((s) lVar);
                return null;
            case 38:
                Object lVar2 = sparseArray.get(1);
                if (lVar2 != null) {
                    lVar2 = new l((Function) lVar2);
                }
                qg((s) lVar2);
                return null;
            case 39:
                return t();
            case 40:
                return Boolean.valueOf(ur());
            case 41:
                return Float.valueOf(bb());
            case 42:
                return l(((Boolean) sparseArray.get(1)).booleanValue());
            case 43:
                return n(((Integer) sparseArray.get(1)).intValue());
            case 44:
                return ln();
            case 45:
                return lh();
            case 46:
                return Long.valueOf(v());
            case 47:
                return Boolean.valueOf(j());
            case 48:
                return Boolean.valueOf(an());
        }
    }

    public SparseArray f() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.qg);
        sparseArray.put(2, this.s);
        sparseArray.put(3, this.q);
        sparseArray.put(4, this.l);
        sparseArray.put(5, this.w);
        sparseArray.put(6, this.x);
        sparseArray.put(7, this.fs);
        sparseArray.put(8, this.rv);
        sparseArray.put(9, this.tj);
        sparseArray.put(10, this.cp);
        sparseArray.put(11, this.d);
        sparseArray.put(12, this.oa);
        sparseArray.put(13, this.sz);
        sparseArray.put(14, this.k);
        sparseArray.put(15, this.cy);
        sparseArray.put(16, this.hd);
        sparseArray.put(18, this.cd);
        sparseArray.put(19, this.um);
        sparseArray.put(20, this.a);
        sparseArray.put(21, this.py);
        sparseArray.put(24, this.ou);
        sparseArray.put(25, mIsNeedUpdateIp);
        sparseArray.put(26, this.wm);
        sparseArray.put(27, this.m);
        sparseArray.put(28, Long.valueOf(this.hu));
        return sparseArray;
    }

    @Override // com.byazt.vf.oa
    public int fs() {
        return 1;
    }

    public void n(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.qg = (String) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            this.s = (String) obj2;
        }
        Object obj3 = sparseArray.get(3);
        if (obj3 != null) {
            this.q = (String) obj3;
        }
        Object obj4 = sparseArray.get(4);
        if (obj4 != null) {
            this.l = (String) obj4;
        }
        Object obj5 = sparseArray.get(5);
        if (obj5 != null) {
            this.w = (String) obj5;
        }
        Object obj6 = sparseArray.get(6);
        if (obj6 != null) {
            this.x = (String) obj6;
        }
        Object obj7 = sparseArray.get(7);
        if (obj7 != null) {
            this.fs = (String) obj7;
        }
        Object obj8 = sparseArray.get(8);
        if (obj8 != null) {
            this.rv = (String) obj8;
        }
        Object obj9 = sparseArray.get(9);
        if (obj9 != null) {
            this.tj = (String) obj9;
        }
        Object obj10 = sparseArray.get(10);
        if (obj10 != null) {
            this.cp = (String) obj10;
        }
        Object obj11 = sparseArray.get(11);
        if (obj11 != null) {
            this.d = (String) obj11;
        }
        Object obj12 = sparseArray.get(12);
        if (obj12 != null) {
            this.oa = (String) obj12;
        }
        Object obj13 = sparseArray.get(13);
        if (obj13 != null) {
            this.sz = (String) obj13;
        }
        Object obj14 = sparseArray.get(14);
        if (obj14 != null) {
            this.k = (String) obj14;
        }
        Object obj15 = sparseArray.get(15);
        if (obj15 != null) {
            this.cy = (String) obj15;
        }
        Object obj16 = sparseArray.get(16);
        if (obj16 != null) {
            this.hd = (String) obj16;
        }
        Object obj17 = sparseArray.get(18);
        if (obj17 != null) {
            this.cd = (String) obj17;
        }
        Object obj18 = sparseArray.get(19);
        if (obj18 != null) {
            this.um = (String) obj18;
        }
        Object obj19 = sparseArray.get(20);
        if (obj19 != null) {
            this.a = (String) obj19;
        }
        Object obj20 = sparseArray.get(21);
        if (obj20 != null) {
            this.py = (String) obj20;
        }
        Object obj21 = sparseArray.get(24);
        if (obj21 != null) {
            this.ou = (String) obj21;
        }
        Object obj22 = sparseArray.get(25);
        if (obj22 != null) {
            mIsNeedUpdateIp = (AtomicBoolean) obj22;
        }
        Object obj23 = sparseArray.get(26);
        if (obj23 != null) {
            this.wm = (String) obj23;
        }
        Object obj24 = sparseArray.get(27);
        if (obj24 != null) {
            this.m = (String) obj24;
        }
        Object obj25 = sparseArray.get(28);
        if (obj25 != null) {
            this.hu = ((Long) obj25).longValue();
        }
    }

    public n(Context context, com.byazt.tbi.s sVar) {
        this.t = context;
        this.ur = sVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        DeviceInfoUtils.n(this.t, new DeviceInfoUtils.ScreenStatusReceiver(), intentFilter);
        DeviceInfoUtils.n nVar = new DeviceInfoUtils.n(this.ur);
        this.h = nVar;
        rv.n(nVar, this.t);
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                um.n();
                rv.n(new qg());
            } catch (Exception unused) {
            }
        }
        com.byazt.bq.qg.n(new com.byazt.bq.qg.n() { // from class: com.byazt.gwg.n.1
            @Override // com.byazt.bq.qg.n
            public void n(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                n.this.wm = str;
            }

            @Override // com.byazt.bq.qg.n
            public void qg(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                n.this.m = str;
            }
        });
    }

    @Override // com.byazt.vf.oa
    public String n() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.n();
        }
        if (!TextUtils.isEmpty(this.qg)) {
            return this.qg;
        }
        com.byazt.tbi.n nVarCp = this.ur.n().cp();
        if (nVarCp != null && !nVarCp.tj()) {
            return nVarCp.d();
        }
        if (n) {
            return this.qg;
        }
        synchronized (this) {
            if (n) {
                return this.qg;
            }
            this.qg = com.byazt.bq.s.s(this.t);
            n = true;
            return this.qg;
        }
    }

    @Override // com.byazt.vf.oa
    public String qg() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.s();
        }
        if (TextUtils.isEmpty(this.s)) {
            this.s = Build.MODEL;
        }
        return this.s;
    }

    @Override // com.byazt.vf.oa
    public String s() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.q();
        }
        if (this.t == null) {
            return "";
        }
        if (!TextUtils.isEmpty(this.q)) {
            return this.q;
        }
        this.q = Settings.Global.getString(this.t.getContentResolver(), "device_name");
        return this.q;
    }

    @Override // com.byazt.vf.oa
    public String q() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.byazt.vf.oa
    public String l() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    @Override // com.byazt.vf.oa
    public String w() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.x();
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.l)) {
            this.l = com.byazt.bq.s.l(this.ur.n(), this.t);
        }
        return this.l;
    }

    @Override // com.byazt.vf.oa
    public String x() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.fs();
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.w)) {
            this.w = com.byazt.bq.s.x(this.ur.n(), this.t);
        }
        return this.w;
    }

    @Override // com.byazt.vf.oa
    public String rv() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.tj();
        }
        if (TextUtils.isEmpty(this.cy)) {
            this.cy = Build.VERSION.RELEASE;
        }
        return this.cy;
    }

    @Override // com.byazt.vf.oa
    public String tj() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.byazt.vf.oa
    public String cp() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.sz();
        }
        if (TextUtils.isEmpty(this.hd)) {
            this.hd = Build.MANUFACTURER;
        }
        return this.hd;
    }

    @Override // com.byazt.vf.oa
    public String d() {
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

    @Override // com.byazt.vf.oa
    public String oa() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.cy();
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.sz)) {
            this.sz = com.byazt.bq.s.rv(this.ur.n(), this.t);
        }
        return this.sz;
    }

    @Override // com.byazt.vf.oa
    public String sz() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.um();
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = String.valueOf(Build.TIME);
        }
        return this.k;
    }

    @Override // com.byazt.vf.oa
    public String k() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.a();
        }
        if (TextUtils.isEmpty(this.oa)) {
            this.oa = com.byazt.bq.s.n(this.ur.n());
        }
        return this.oa;
    }

    @Override // com.byazt.vf.oa
    public String cy() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.py();
        }
        if (TextUtils.isEmpty(this.cd)) {
            this.cd = tj.n();
        }
        return this.cd;
    }

    @Override // com.byazt.vf.oa
    public String hd() {
        lh lhVarDf;
        if (oj() && (lhVarDf = df()) != null) {
            return lhVarDf.ou();
        }
        if (TextUtils.isEmpty(this.um)) {
            this.um = w.n(this.ur.n());
        }
        return this.um;
    }

    @Override // com.byazt.vf.oa
    public int cd() {
        return DeviceInfoUtils.n();
    }

    @Override // com.byazt.vf.oa
    public int n(boolean z) {
        lh lhVarDf;
        if (dg() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.n(z);
        }
        Context context = this.t;
        if (context == null) {
            return 1;
        }
        return DeviceInfoUtils.n(context, z, this.ur.n());
    }

    @Override // com.byazt.vf.oa
    public String qg(boolean z) {
        lh lhVarDf;
        if (dg() && oj() && (lhVarDf = df()) != null && !z) {
            return lhVarDf.hu();
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.a)) {
            this.a = tj.n(this.t, this.ur.n(), z, this.ur.w());
        }
        return this.a;
    }

    @Override // com.byazt.vf.oa
    public String[] s(boolean z) {
        lh lhVarDf;
        if (dg() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.qg(z);
        }
        if (fi()) {
            return new String[]{this.wm, this.m};
        }
        String[] strArrN = com.byazt.bq.qg.n(z, mIsNeedUpdateIp, this.ur.n(), this.ur.s(), this.ur);
        this.hu = System.currentTimeMillis();
        if (strArrN.length >= 2) {
            this.wm = strArrN[0];
            this.m = strArrN[1];
        }
        return strArrN;
    }

    @Override // com.byazt.vf.oa
    public com.byazt.hsi.n q(boolean z) {
        lh lhVarDf;
        if (dg() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.h();
        }
        Context context = this.t;
        if (context == null) {
            return null;
        }
        return com.byazt.bq.n.n(context, z, this.ur.n());
    }

    @Override // com.byazt.vf.oa
    public String n(Boolean bool) {
        lh lhVarDf;
        if (dg() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.n(bool);
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.cp)) {
            this.cp = com.byazt.bq.s.q(bool, this.ur.n(), this.t);
        }
        return this.cp;
    }

    @Override // com.byazt.vf.oa
    public String qg(Boolean bool) {
        lh lhVarDf;
        if (dg() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.qg(bool);
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.rv)) {
            this.rv = com.byazt.bq.s.n(bool, this.ur.n(), this.t);
        }
        return this.rv;
    }

    @Override // com.byazt.vf.oa
    public String s(Boolean bool) {
        lh lhVarDf;
        if (dg() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.s(bool);
        }
        if (TextUtils.isEmpty(this.py)) {
            this.py = com.byazt.bq.s.n(bool, this.ur.n(), this.ur.s(), this.ur);
        }
        return this.py;
    }

    @Override // com.byazt.vf.oa
    public String q(Boolean bool) {
        lh lhVarDf;
        if (dg() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.q(bool);
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.tj)) {
            this.tj = com.byazt.bq.s.s(bool, this.ur.n(), this.t);
        }
        return this.tj;
    }

    @Override // com.byazt.vf.oa
    public String l(Boolean bool) {
        lh lhVarDf;
        if (dg() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.l(bool);
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = com.byazt.bq.s.qg(bool, this.ur.n(), this.t);
        }
        return this.d;
    }

    public void ae() {
        DeviceInfoUtils.s(this.t);
        DeviceInfoUtils.q(this.t);
        DeviceInfoUtils.l(this.t);
        com.byazt.bq.qg.n((com.byazt.bq.qg.n) null);
        rv.n(this.h);
        this.h = null;
    }

    @Override // com.byazt.vf.oa
    public String um() {
        if (TextUtils.isEmpty(this.ou)) {
            this.ou = w.s();
        }
        return this.ou;
    }

    @Override // com.byazt.vf.oa
    public int a() {
        Context context = this.t;
        if (context == null) {
            return 0;
        }
        return cp.qg(context);
    }

    @Override // com.byazt.vf.oa
    public int py() {
        Context context = this.t;
        if (context == null) {
            return 0;
        }
        return cp.q(context);
    }

    @Override // com.byazt.vf.oa
    public int ou() {
        Context context = this.t;
        if (context == null) {
            return 0;
        }
        return cp.s(context);
    }

    @Override // com.byazt.vf.oa
    public String wm() {
        lh lhVarDf;
        if (u() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.j();
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.x)) {
            this.x = com.byazt.bq.s.w(this.ur.n(), this.t);
        }
        return this.x;
    }

    @Override // com.byazt.vf.oa
    public String m() {
        lh lhVarDf;
        if (u() && oj() && (lhVarDf = df()) != null) {
            return lhVarDf.an();
        }
        if (this.t == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.fs)) {
            this.fs = com.byazt.bq.s.fs(this.ur.n(), this.t);
        }
        return this.fs;
    }

    @Override // com.byazt.vf.oa
    public String hu() {
        return this.t == null ? "" : com.byazt.bq.s.qg(this.ur.n(), this.t);
    }

    @Override // com.byazt.vf.oa
    public String h() {
        return this.t == null ? "" : com.byazt.bq.s.q(this.ur.n(), this.t);
    }

    @Override // com.byazt.vf.oa
    public int n(long j) {
        Context context = this.t;
        if (context == null) {
            return 1;
        }
        return rv.n(context, j);
    }

    @Override // com.byazt.vf.oa
    public void n(s sVar) {
        Context context = this.t;
        if (context == null) {
            return;
        }
        rv.n(sVar, context);
    }

    @Override // com.byazt.vf.oa
    public void qg(s sVar) {
        rv.n(sVar);
    }

    @Override // com.byazt.vf.oa
    public String t() {
        return w.qg(this.ur.n());
    }

    @Override // com.byazt.vf.oa
    public boolean ur() {
        Context context = this.t;
        if (context == null) {
            return false;
        }
        return DeviceInfoUtils.w(context);
    }

    @Override // com.byazt.vf.oa
    public float bb() {
        Context context = this.t;
        if (context == null) {
            return -1.0f;
        }
        return DeviceInfoUtils.x(context);
    }

    @Override // com.byazt.vf.oa
    public Map<String, String> l(boolean z) {
        return com.byazt.bq.qg.n(z, this.ur.n(), this.ur.s(), this.ur);
    }

    @Override // com.byazt.vf.oa
    public String n(int i) {
        return this.t == null ? "" : DeviceInfoUtils.n(i, this.ur.n(), this.t);
    }

    @Override // com.byazt.vf.oa
    public String ln() {
        Context context = this.t;
        return context == null ? "" : x.n(context, this.ur.n());
    }

    @Override // com.byazt.vf.oa
    public String lh() {
        return this.t == null ? "4" : x.n(this.ur.n(), this.t);
    }

    @Override // com.byazt.vf.oa
    public long v() {
        return DeviceInfoUtils.qg();
    }

    @Override // com.byazt.vf.oa
    public boolean j() {
        return com.byazt.bq.qg.q(this.ur.n(), this.ur.s(), this.ur);
    }

    @Override // com.byazt.vf.oa
    public boolean an() {
        return com.byazt.bq.qg.l(this.ur.n(), this.ur.s(), this.ur);
    }

    private boolean fi() {
        return (mIsNeedUpdateIp.get() || DeviceInfoUtils.n(this.hu, c.a) || TextUtils.isEmpty(this.wm)) ? false : true;
    }

    private lh df() {
        return (lh) q.n("device_info");
    }

    private boolean oj() {
        return this.ur.q() && this.ur.qg() < 7600;
    }

    private boolean dg() {
        return this.ur.q() && this.ur.qg() >= 7100;
    }

    private boolean u() {
        return this.ur.q() && this.ur.qg() >= 7500;
    }
}
