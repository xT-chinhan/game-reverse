package com.byazt.sg;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.byazt.fvm.d;
import com.byazt.fvm.x;
import com.byazt.fz.cp;
import com.byazt.fz.fs;
import com.byazt.fz.tj;
import com.byazt.fz.w;
import com.byazt.gf.q;
import com.byazt.kv.l;
import com.byazt.vy.sz;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 27, 8})
public abstract class s extends q implements Comparable<s> {
    public double a;
    public String ae;
    public String an;
    public int b;
    public String bb;
    public String cd;
    public String cp;
    public int cx;
    public int cy;
    public String d;
    public Map<String, Object> df;
    public double dg;
    public int dh;
    public volatile boolean dm;
    public String dw;
    public String e;
    public volatile boolean ei;
    public int el;
    public n eq;
    public String f;
    public Map<String, String> fi;
    public String fl;
    public com.byazt.us.n fs;
    public int g;
    public int ha;
    public int hd;
    public int he;
    public int hu;
    public boolean i;
    public String il;
    public long j;
    public String ju;
    public int k;
    public w l;
    public String la;
    public String lh;
    public boolean ln;
    public String m;
    public String mz;
    public com.byazt.fz.qg n;
    public String nf;
    public String nk;
    public String np;
    public String o;
    public String oa;
    public double oj;
    public String ou;
    public String pe;
    public l q;
    public tj qg;
    public String qh;
    public String r;
    public String rf;
    public String ri;
    public com.byazt.kt.w rv;
    public int ry;
    public com.byazt.kv.qg s;
    public boolean sq;
    public int sz;
    public int t;
    public String ta;
    public String tj;
    public int u;
    public String um;
    public boolean ur;
    public String v;
    public int vb;
    public long vo;
    public fs w;
    public double wm;
    public int wv;
    public cp x;
    public com.byazt.lr.n xd;
    public boolean yw;
    public List<String> py = new ArrayList();
    public int h = -1;
    public int pk = 1;
    public int wo = 1;
    public int sh = 1;
    public int y = 1;
    public volatile boolean lq = false;
    public volatile boolean ic = false;
    public volatile boolean ci = false;
    public volatile boolean hf = false;
    public final Map<String, Object> kc = new sz();
    public boolean z = false;
    public boolean dn = false;
    public boolean su = false;
    public String xi = "1";
    public Map<String, Object> ze = new HashMap();
    public Map<String, Object> qn = new HashMap();
    public Map bz = new HashMap();
    public Map<String, Object> ox = new ConcurrentHashMap();

    public interface n {
        void n();

        void n(s sVar);
    }

    public boolean a() {
        return false;
    }

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    public long c() {
        return 0L;
    }

    public void cp() {
    }

    public void cy() {
    }

    public String di() {
        return null;
    }

    public Bitmap dx() {
        return null;
    }

    public long dz() {
        return 0L;
    }

    public void ed() {
    }

    public d es() {
        return null;
    }

    public void f(String str) {
    }

    public com.byazt.fz.l fs() {
        return null;
    }

    public void hd() {
    }

    public com.byazt.fvm.l ki() {
        return null;
    }

    public abstract boolean l();

    public x n(Activity activity) {
        return null;
    }

    public void n() {
    }

    public void n(Activity activity, Object obj, String str) {
    }

    public void n(Dialog dialog, Integer[] numArr) {
    }

    public void n(Bitmap bitmap, int i) {
    }

    public void n(ViewGroup viewGroup) {
    }

    public void n(ViewGroup viewGroup, Activity activity) {
    }

    public void n(com.byazt.fx.s sVar) {
    }

    public void n(com.byazt.mi.qg qgVar) {
    }

    public void n(com.byazt.mi.s sVar) {
    }

    public void n(com.byazt.vd.n nVar) {
    }

    public void n(Map<String, Object> map) {
    }

    public boolean oj() {
        return false;
    }

    public double on() {
        return 0.0d;
    }

    public String oo() {
        return null;
    }

    public int q() {
        return -1;
    }

    public com.byazt.fvm.q qd() {
        return null;
    }

    public x qg(Dialog dialog, Integer[] numArr) {
        return null;
    }

    public void qg() {
    }

    public void qg(Activity activity) {
    }

    public void qg(Map<String, Object> map) {
    }

    public boolean rm() {
        return false;
    }

    public View rv() {
        return null;
    }

    public void s() {
    }

    public View tj() {
        return null;
    }

    public void tj(boolean z) {
    }

    public void wm(int i) {
    }

    public String x() {
        return null;
    }

    public int yp() {
        return 0;
    }

    public void n(String str) {
        this.dw = str;
    }

    public String py() {
        return this.dw;
    }

    public void n(boolean z) {
        this.i = z;
    }

    public boolean ou() {
        return this.i;
    }

    public void qg(String str) {
        this.fl = str;
    }

    public String wm() {
        return this.fl;
    }

    public void n(int i) {
        this.vb = i;
    }

    public int m() {
        return this.vb;
    }

    public int hu() {
        return this.el;
    }

    public void qg(int i) {
        this.el = i;
    }

    public void s(int i) {
        this.he = i;
    }

    public int h() {
        return this.he;
    }

    public boolean t() {
        return this.dn;
    }

    public void qg(boolean z) {
        this.dn = z;
    }

    public boolean ur() {
        return this.z;
    }

    public void s(boolean z) {
        this.z = z;
    }

    public void s(Map<String, Object> map) {
        if (map != null) {
            this.kc.putAll(map);
        }
    }

    public Map<String, Object> bb() {
        return this.kc;
    }

    public boolean ln() {
        if (this.lq) {
            return true;
        }
        this.lq = true;
        return false;
    }

    public boolean lh() {
        if (this.ic) {
            return true;
        }
        this.ic = true;
        return false;
    }

    public boolean v() {
        if (this.ci) {
            return true;
        }
        this.ci = true;
        return false;
    }

    public int j() {
        return this.cx;
    }

    public void q(int i) {
        this.cx = i;
    }

    public void q(boolean z) {
        this.yw = z;
    }

    public boolean an() {
        return this.yw;
    }

    public String ae() {
        return this.pe;
    }

    public void s(String str) {
        this.pe = str;
    }

    public String f() {
        return this.e;
    }

    public void q(String str) {
        this.e = str;
    }

    public String fi() {
        return this.ri;
    }

    public void l(String str) {
        this.ri = str;
    }

    public String df() {
        return this.nf;
    }

    public void w(String str) {
        this.nf = str;
    }

    public int dg() {
        return this.b;
    }

    public void l(int i) {
        this.b = i;
    }

    public int u() {
        return this.dh;
    }

    public void w(int i) {
        this.dh = i;
    }

    public void x(String str) {
        this.rf = str;
    }

    public void x(int i) {
        this.sh = i;
    }

    public void fs(int i) {
        this.y = i;
    }

    public int fs(String str) {
        if (TextUtils.equals(str, this.rf)) {
            return this.sh;
        }
        return this.pk;
    }

    public void rv(int i) {
        this.pk = i;
    }

    public int rv(String str) {
        if (TextUtils.equals(str, this.rf)) {
            return this.y;
        }
        return this.wo;
    }

    public void tj(int i) {
        this.wo = i;
    }

    public String pk() {
        return this.la;
    }

    public void tj(String str) {
        this.la = str;
    }

    public String wo() {
        return this.qh;
    }

    public void cp(String str) {
        this.qh = str;
    }

    public String sh() {
        return this.il;
    }

    public void d(String str) {
        this.il = str;
    }

    public void n(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.ze.put(str, obj);
    }

    public void q(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.ze.putAll(map);
    }

    public void l(Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.qn.clear();
        for (Object obj : map.entrySet()) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key instanceof String) {
                    String str = (String) key;
                    if (!TextUtils.isEmpty(str) && n(value)) {
                        this.qn.put(str, value);
                    }
                }
            }
        }
    }

    private static boolean n(Object obj) {
        return (obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean);
    }

    public Map<String, Object> y() {
        return this.qn;
    }

    public void w(Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.bz.clear();
        this.bz.putAll(map);
    }

    public Map rf() {
        return this.bz;
    }

    public final Map<String, Object> dh() {
        return this.ze;
    }

    public String b() {
        return this.nk;
    }

    public void oa(String str) {
        this.nk = str;
    }

    public String ri() {
        return this.o;
    }

    public void sz(String str) {
        this.o = str;
    }

    public boolean nf() {
        return this.ei;
    }

    public void l(boolean z) {
        this.ei = z;
    }

    public boolean pe() {
        return this.dm;
    }

    public void w(boolean z) {
        this.dm = z;
    }

    public final void n(long j) {
        if (this.vo == 0) {
            this.vo = j;
        }
    }

    public final long e() {
        return this.vo;
    }

    public Map<String, Object> yw() {
        return this.ox;
    }

    public void qg(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.ox.put(str, obj);
    }

    public void k(String str) {
        this.xi = str;
    }

    public String cx() {
        return this.xi;
    }

    public void cy(String str) {
        this.r = str;
    }

    public String lq() {
        return this.r;
    }

    public void hd(String str) {
        this.mz = str;
    }

    public String ic() {
        return this.mz;
    }

    public String ci() {
        return TextUtils.isEmpty(this.r) ? this.mz : this.r;
    }

    public void cd(String str) {
        this.np = str;
    }

    public String hf() {
        return this.np;
    }

    public void x(boolean z) {
        this.ur = z;
    }

    public boolean kc() {
        return this.ur;
    }

    public void cp(int i) {
        this.hu = i;
    }

    public void d(int i) {
        this.h = i;
    }

    public int z() {
        return this.h;
    }

    public int dn() {
        return this.hu;
    }

    public int he() {
        return this.wv;
    }

    public void oa(int i) {
        this.wv = i;
    }

    public void um(String str) {
        this.ju = str;
    }

    public String el() {
        return this.ta;
    }

    public void a(String str) {
        this.ta = str;
    }

    public void py(String str) {
        this.bb = str;
    }

    public void fs(boolean z) {
        this.ln = z;
    }

    public boolean vb() {
        if (!TextUtils.isEmpty(this.lh) || !TextUtils.isEmpty(this.v) || this.j > 0 || !TextUtils.isEmpty(this.an)) {
            return true;
        }
        Map<String, String> map = this.fi;
        return ((map == null || map.size() <= 0) && TextUtils.isEmpty(this.ae) && TextUtils.isEmpty(this.f) && TextUtils.isEmpty(this.il)) ? false : true;
    }

    public String fl() {
        return this.lh;
    }

    public void ou(String str) {
        this.lh = str;
    }

    public String i() {
        return this.v;
    }

    public void wm(String str) {
        this.v = str;
    }

    public long dw() {
        return this.j;
    }

    public void qg(long j) {
        this.j = j;
    }

    public String su() {
        return this.an;
    }

    public void m(String str) {
        this.an = str;
    }

    public String ha() {
        return this.ae;
    }

    public void hu(String str) {
        this.ae = str;
    }

    public String g() {
        return this.f;
    }

    public void h(String str) {
        this.f = str;
    }

    public Map<String, String> ry() {
        return this.fi;
    }

    public void x(Map<String, String> map) {
        this.fi = map;
    }

    public Map<String, Object> ju() {
        return this.df;
    }

    public double ta() {
        try {
            if (dm()) {
                if (r() < 0.0d) {
                    return 0.0d;
                }
                return r();
            }
            if (o() || nk()) {
                return this.wm * Double.valueOf(this.xi).doubleValue();
            }
            return this.wm;
        } catch (NumberFormatException unused) {
        }
    }

    public String wv() {
        return this.m;
    }

    public void t(String str) {
        this.m = str;
    }

    public double xi() {
        if (TextUtils.isEmpty(this.m)) {
            return ta();
        }
        try {
            double d = Double.parseDouble(this.m);
            if (d > 0.0d && d <= 100.0d) {
                return (ta() * d) / 100.0d;
            }
            return ta();
        } catch (Exception unused) {
            return ta();
        }
    }

    public void n(double d) {
        this.wm = d;
    }

    public double np() {
        if (!dm()) {
            return this.wm;
        }
        if (r() < 0.0d) {
            return 0.0d;
        }
        return r();
    }

    public double r() {
        return this.oj;
    }

    public void qg(double d) {
        this.oj = d;
    }

    public double mz() {
        return this.dg;
    }

    public void s(double d) {
        this.dg = d;
    }

    public String sq() {
        if (dm()) {
            return r() < 0.0d ? "-1" : String.valueOf(r());
        }
        return String.valueOf(ta());
    }

    public String ei() {
        if (dm()) {
            return mz() < 0.0d ? "-1" : String.valueOf(mz());
        }
        return String.valueOf(ta());
    }

    public boolean dm() {
        return this.ry == 2;
    }

    public boolean vo() {
        int i = this.ry;
        return i == 0 || i == 100;
    }

    public boolean o() {
        return this.ry == 1;
    }

    public boolean nk() {
        return this.ry == 3;
    }

    public boolean ze() {
        return this.ry == 0;
    }

    public boolean qn() {
        return this.ry == 100;
    }

    public void sz(int i) {
        this.t = i;
    }

    public int bz() {
        return this.ry;
    }

    public void k(int i) {
        this.ry = i;
    }

    public void cy(int i) {
        this.ha = i;
    }

    public int il() {
        return this.ha;
    }

    public void hd(int i) {
        this.g = i;
    }

    public int la() {
        return this.g;
    }

    public List<String> qh() {
        return this.py;
    }

    public void n(List<String> list) {
        if (list != null) {
            this.py.addAll(list);
        }
    }

    public void ur(String str) {
        this.d = str;
    }

    public String eq() {
        return this.d;
    }

    public String ox() {
        return this.oa;
    }

    public void bb(String str) {
        this.oa = str;
    }

    public int xd() {
        return this.sz;
    }

    public void cd(int i) {
        this.sz = i;
    }

    public int ti() {
        return this.k;
    }

    public void um(int i) {
        this.k = i;
    }

    public String lg() {
        return this.cd;
    }

    public void ln(String str) {
        this.cd = str;
    }

    public String jh() {
        return this.um;
    }

    public void lh(String str) {
        this.um = str;
    }

    public void a(int i) {
        this.u = i;
    }

    public int xb() {
        return this.u;
    }

    public int ct() {
        return this.t;
    }

    public String ca() {
        return this.tj;
    }

    public void v(String str) {
        this.tj = str;
    }

    public void j(String str) {
        this.cp = str;
    }

    public String tr() {
        return this.cp;
    }

    public double iz() {
        return this.a;
    }

    public void q(double d) {
        this.a = d;
    }

    public void an(String str) {
        this.ou = str;
    }

    public String of() {
        return this.ou;
    }

    public final boolean ae(String str) {
        Integer numW = w();
        if (numW.intValue() == 1) {
            return !com.byazt.ra.n.n().n(str, this);
        }
        return numW.intValue() == 2;
    }

    public Integer w() {
        return 1;
    }

    public void py(int i) {
        this.cy = i;
    }

    public int wf() {
        return this.cy;
    }

    public void ou(int i) {
        this.hd = i;
    }

    public int lr() {
        return this.hd;
    }

    public boolean jw() {
        return this.sq;
    }

    public void rv(boolean z) {
        this.sq = z;
    }

    private void n(ViewGroup viewGroup, com.byazt.fz.d dVar) {
        qg(viewGroup);
        View viewFindViewById = viewGroup.findViewById(R.id.tt_mediation_mtg_ad_choice);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (dVar != null) {
            n(viewGroup.findViewById(dVar.d));
        }
    }

    public void n(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
        n(viewGroup, (com.byazt.fz.d) null);
    }

    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.fz.d dVar, List<View> list4) {
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        n(viewGroup, dVar);
    }

    public void n(View view) {
        if (view != null) {
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(null);
            }
        }
    }

    public void qg(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception unused) {
            }
        }
    }

    private void qg(ViewGroup viewGroup) {
        try {
            if (viewGroup.getChildCount() == 0 || he() == 3) {
                return;
            }
            int i = 0;
            if (viewGroup.getChildAt(0) instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                if (MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG.equals(viewGroup2.getTag(R.id.tt_mediation_gdt_developer_view_root_tag_key)) || MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG.equals(viewGroup2.getTag(2114387452))) {
                    viewGroup.removeView(viewGroup2);
                    while (i < viewGroup2.getChildCount()) {
                        View childAt = viewGroup2.getChildAt(i);
                        if (childAt == null || !(MediationConstant.TT_GDT_NATIVE_VIEW_TAG.equals(childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key)) || MediationConstant.TT_GDT_NATIVE_VIEW_TAG.equals(childAt.getTag(2114387451)))) {
                            i++;
                        } else {
                            viewGroup2.removeView(childAt);
                            viewGroup.addView(childAt, childAt.getLayoutParams());
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void cd() {
        this.n = null;
        this.qg = null;
        this.s = null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(s sVar) {
        if (sVar == null || this.g > sVar.la()) {
            return 1;
        }
        if (this.g < sVar.la()) {
            return -1;
        }
        if (this.ha > sVar.il()) {
            return 1;
        }
        return this.ha < sVar.il() ? -1 : 0;
    }

    public com.byazt.fz.qg d() {
        return this.n;
    }

    public com.byazt.us.n k() {
        return this.fs;
    }

    public tj oa() {
        return this.qg;
    }

    public com.byazt.kv.qg sz() {
        return this.s;
    }

    public void n(cp cpVar) {
        this.x = cpVar;
    }

    public void n(w wVar) {
        this.l = wVar;
    }

    public void n(fs fsVar) {
        this.w = fsVar;
    }

    public void n(l lVar) {
        this.q = lVar;
    }

    public void n(com.byazt.fz.qg qgVar) {
        this.n = qgVar;
    }

    public void n(tj tjVar) {
        this.qg = tjVar;
    }

    public void n(final com.byazt.kv.qg qgVar) {
        if (qgVar != null) {
            this.s = new com.byazt.kv.qg() { // from class: com.byazt.sg.s.1
                @Override // com.byazt.kv.qg
                public void n() {
                    com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.sg.s.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            qgVar.n();
                        }
                    });
                }

                @Override // com.byazt.kv.qg
                public void qg() {
                    com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.sg.s.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            qgVar.qg();
                        }
                    });
                }

                @Override // com.byazt.kv.qg
                public void n(final long j, final long j2, final int i, final int i2, final String str, final String str2) {
                    com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.sg.s.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            qgVar.n(j, j2, i, i2, str, str2);
                        }
                    });
                }

                @Override // com.byazt.kv.qg
                public void n(final long j, final long j2, final String str, final String str2) {
                    com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.sg.s.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            qgVar.n(j, j2, str, str2);
                        }
                    });
                }

                @Override // com.byazt.kv.qg
                public void qg(final long j, final long j2, final String str, final String str2) {
                    com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.sg.s.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            qgVar.qg(j, j2, str, str2);
                        }
                    });
                }

                @Override // com.byazt.kv.qg
                public void n(final long j, final String str, final String str2) {
                    com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.sg.s.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            qgVar.n(j, str, str2);
                        }
                    });
                }

                @Override // com.byazt.kv.qg
                public void n(final String str, final String str2) {
                    com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.sg.s.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            qgVar.n(str, str2);
                        }
                    });
                }
            };
        }
    }

    public void n(com.byazt.us.n nVar) {
        this.fs = nVar;
    }

    public void n(com.byazt.kt.w wVar) {
        this.rv = wVar;
    }

    public com.byazt.kt.w rn() {
        return this.rv;
    }

    public boolean rg() {
        return (this instanceof com.byazt.cn.qg) || (this instanceof com.byazt.kf.s);
    }

    public void n(Activity activity, com.byazt.lr.n nVar) {
        this.xd = nVar;
    }

    public com.byazt.lr.n um() {
        return this.xd;
    }

    public boolean hc() {
        return this.su;
    }

    public void cp(boolean z) {
        this.su = z;
    }

    public n du() {
        return this.eq;
    }

    public void n(n nVar) {
        this.eq = nVar;
    }
}
