package com.byazt.ih;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.anythink.core.common.r.a.c;
import com.byazt.gu.l;
import com.byazt.hb.fs;
import com.byazt.kg.w;
import com.byazt.uy.q;
import com.byazt.vh.a;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.hd;
import com.byazt.vh.oa;
import com.byazt.vh.ou;
import com.byazt.vh.rv;
import com.byazt.vh.x;
import com.byazt.xz.k;
import com.byazt.xz.sz;
import com.byazt.xz.tj;
import com.bykv.vk.component.ttvideo.player.C;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 219, 8})
public abstract class s<T extends View> implements View.OnTouchListener, l, cd.n, cd.qg {
    public float a;
    public boolean ae;
    public boolean an;
    public boolean b;
    public float bb;
    public boolean bz;
    public boolean c;
    public String ca;
    public float cd;
    public ViewGroup.LayoutParams ci;
    public String cp;
    public oa ct;
    public int cx;
    public float cy;
    public String d;
    public ImageView.ScaleType df;
    public boolean dg;
    public boolean dh;
    public boolean di;
    public boolean dm;
    public float dn;
    public float dw;
    public float dx;
    public boolean dz;
    public int e;
    public sz ed;
    public boolean ei;
    public float el;
    public com.byazt.uw.s eq;
    public k es;
    public int f;
    public String fi;
    public float fl;
    public rv.n fs;
    public float g;
    public float h;
    public float ha;
    public float hd;
    public float he;
    public com.byazt.kg.n hf;
    public boolean hu;
    public float i;
    public boolean ic;
    public GradientDrawable il;
    public boolean iz;
    public boolean j;

    @Deprecated
    public com.byazt.uy.l jh;
    public cd ju;
    public boolean jw;
    public float k;
    public w kc;
    public T l;
    public String la;

    @Deprecated
    public com.byazt.uy.s lg;
    public boolean lh;
    public float ln;
    public float lq;
    public JSONObject lr;
    public boolean m;
    public tj mz;
    public boolean n;
    public boolean nf;
    public boolean nk;
    public boolean np;
    public boolean o;
    public float oa;
    public ou of;
    public float oj;
    public long on;
    public boolean oo;
    public boolean ou;
    public com.byazt.vh.n ox;
    public float pe;
    public float pk;
    public float py;
    public JSONObject q;
    public boolean qd;
    public Context qg;
    public com.byazt.rc.n qh;
    public boolean qn;
    public com.byazt.hb.n.C0188n r;
    public float rf;
    public boolean rg;
    public boolean ri;
    public boolean rm;
    public com.byazt.vt.n rn;
    public com.byazt.vh.sz rv;
    public com.byazt.vh.tj ry;
    public JSONObject s;
    public float sh;
    public boolean sq;
    public float su;
    public float sz;
    public float t;
    public a ta;

    @Deprecated
    public com.byazt.uy.qg ti;
    public boolean tj;
    public boolean tr;
    public boolean u;
    public float um;
    public float ur;
    public boolean v;
    public float vb;
    public boolean vo;
    public n<ViewGroup> w;
    public boolean wf;
    public boolean wm;
    public float wo;
    public x wv;
    public n<ViewGroup> x;

    @Deprecated
    public q.n xb;

    @Deprecated
    public com.byazt.uy.w xd;
    public Map<Integer, cy> xi;
    public float y;
    public String yw;
    public float z;
    public boolean ze;

    public void dg() {
    }

    public T n() {
        return null;
    }

    @Override // com.byazt.gu.l
    public void n(String str, Map<String, Object> map) {
    }

    public void u() {
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, n<ViewGroup> nVar) {
        this.oa = -2.0f;
        this.sz = -2.0f;
        this.yw = "solid";
        this.cx = 0;
        this.ic = true;
        this.z = 0.0f;
        this.dn = 0.0f;
        this.he = 0.0f;
        this.el = 1.0f;
        this.vb = 1.0f;
        this.fl = 1.0f;
        this.i = 0.0f;
        this.dw = 0.0f;
        this.su = 0.0f;
        this.ha = 0.0f;
        this.g = 1.0f;
        this.qn = true;
        this.wf = true;
        this.rm = false;
        this.jw = false;
        this.rg = false;
        this.qd = false;
        this.dx = 12.0f;
        this.qg = context;
        this.w = nVar;
        this.xi = new HashMap();
        this.il = new GradientDrawable();
        this.l = (T) n();
    }

    public T rv() {
        return this.l;
    }

    public void qg(JSONObject jSONObject) {
        this.q = jSONObject;
        cp();
    }

    public void n(JSONObject jSONObject) {
        this.q = jSONObject;
        cp();
        JSONObject jSONObject2 = this.s;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        n<ViewGroup> nVar = this.w;
        n.C0202n c0202nFs = nVar instanceof n ? nVar.fs() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strN = com.byazt.mcb.qg.n(this.s.optString(next), jSONObject);
            n(next, strN);
            if (c0202nFs != null) {
                c0202nFs.n(this.qg, next, strN);
            }
        }
        if (c0202nFs != null) {
            n(c0202nFs.n());
        }
        if (this.lr == null || this.q == null) {
            return;
        }
        try {
            if (ln()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("i18n", this.lr);
                this.q.put("xNode", jSONObject3);
                return;
            }
            this.q.put("i18n", this.lr);
        } catch (JSONException unused) {
        }
    }

    public JSONObject tj() {
        return this.q;
    }

    public void cp() {
        boolean zOptBoolean = this.q.optBoolean("gesture_through_enable", false);
        rv.n nVar = this.fs;
        this.rg = zOptBoolean && (nVar == null || nVar.q());
        this.qd = this.q.optBoolean("is_adapt_two_finger", false);
    }

    public void qg() {
        hu();
        d();
        qg(this.cx);
        x();
        fs();
        tj tjVar = this.mz;
        if (tjVar != null) {
            tjVar.s();
            this.mz.q();
            this.mz.l();
        }
        this.l.setOnTouchListener(this);
        lq();
        ViewGroup viewGroup = (ViewGroup) this.l.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.qn);
        }
        com.byazt.kg.n nVar = this.hf;
        if (nVar != null) {
            nVar.q();
        }
        w wVar = this.kc;
        if (wVar != null) {
            wVar.n();
        }
        tj tjVar2 = this.mz;
        if (tjVar2 != null) {
            tjVar2.w();
            this.mz.fs();
            this.mz.x();
            this.mz.qg();
        }
        if (this.ju != null && n(22)) {
            this.ju.n(this.xi.get(22), this, this);
        }
        com.byazt.uw.s sVar = this.eq;
        if (sVar == null || !sVar.n()) {
            return;
        }
        this.eq.n(this.l);
    }

    public void d() {
        this.l.setPadding((int) (this.v ? this.t : this.h), (int) (this.an ? this.bb : this.h), (int) (this.j ? this.ur : this.h), (int) (this.ae ? this.ln : this.h));
    }

    private void x() {
        if (this.n) {
            this.l.setTranslationX(this.dn);
        }
        if (this.sq) {
            this.l.setTranslationY(this.he);
        }
        if (this.ei) {
            this.l.setScaleX(this.vb);
        }
        if (this.dm) {
            this.l.setScaleY(this.fl);
        }
        if (this.vo) {
            this.l.setRotation(this.i);
        }
        if (this.o) {
            this.l.setRotationX(this.dw);
        }
        if (this.nk) {
            this.l.setRotationY(-this.su);
        }
        if (this.ze) {
            this.l.setAlpha(this.g);
        }
        float f = this.ha;
        if (f != 0.0f) {
            this.l.setRotation(f);
        }
        if (this.vo || this.o || this.nk) {
            this.l.setCameraDistance(10000.0f);
        }
    }

    public float oa() {
        return this.dn;
    }

    public float sz() {
        return this.he;
    }

    public float k() {
        return this.vb;
    }

    public float cy() {
        return this.fl;
    }

    public float hd() {
        return this.dw;
    }

    public float cd() {
        return this.su;
    }

    public float um() {
        return this.ha;
    }

    public float a() {
        return this.g;
    }

    public float py() {
        return this.pk;
    }

    @Deprecated
    private void fs() {
        q qVarL;
        this.l.setVisibility(this.cx);
        float f = this.ha;
        if (f != 0.0f) {
            this.l.setRotation(f);
        }
        rv.n nVar = this.fs;
        if (nVar != null && TextUtils.isEmpty(nVar.s())) {
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ih.s.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (s.this.ry == null || !s.this.wf) {
                        return;
                    }
                    s.this.ry.n(s.this);
                }
            });
        } else if (n(1) && !this.tr) {
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ih.s.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (s.this.ju == null || !s.this.wf) {
                        return;
                    }
                    cd cdVar = s.this.ju;
                    cy cyVar = s.this.xi.get(1);
                    s sVar = s.this;
                    cdVar.n(cyVar, sVar, sVar);
                }
            });
        }
        if (this.ju != null && n(4)) {
            if (n(1)) {
                this.iz = true;
                this.jh = new com.byazt.uy.l(this.qg, this.xi.get(4), this.xi.get(1), this.iz, nf(), this.qd);
            } else {
                this.jh = new com.byazt.uy.l(this.qg, this.xi.get(4), this.iz, nf(), this.qd);
            }
        }
        if (this.ju != null && n(1) && this.tr) {
            this.lg = new com.byazt.uy.s(this.qg, this.xi.get(1));
        }
        cx();
        if (this.ju != null && n(3) && (qVarL = com.byazt.gu.w.n().l()) != null) {
            q.n nVar2 = this.xb;
            if (nVar2 != null) {
                nVar2.qg();
            }
            q.n nVarN = qVarL.n(this.qg, this);
            this.xb = nVarN;
            nVarN.n(this.dx);
            this.xb.n();
            this.xb.n(new q.qg() { // from class: com.byazt.ih.s.3
                @Override // com.byazt.uy.q.qg
                public void n(int i) {
                    s.this.xb.qg();
                    if (s.this.l.isShown() && s.this.ju != null && i == 1) {
                        cd cdVar = s.this.ju;
                        cy cyVar = s.this.xi.get(3);
                        s sVar = s.this;
                        cdVar.n(cyVar, sVar, sVar);
                    }
                }
            });
        }
        if (this.ju != null && n(9)) {
            com.byazt.uy.w wVar = new com.byazt.uy.w(this.qg, this.xi.get(9), this);
            this.xd = wVar;
            wVar.n(this.ju);
        }
        if (n(10)) {
            com.byazt.uy.qg qgVar = new com.byazt.uy.qg(this.qg, this.xi.get(10), this);
            this.ti = qgVar;
            qgVar.n(this.ju);
        }
    }

    private void cx() {
        cy cyVar;
        if (this.ju == null || !n(18) || (cyVar = this.xi.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectS = cyVar.s();
        if (jSONObjectS != null) {
            try {
                jSONObjectS.put("rotateZ", com.byazt.mcb.qg.n(jSONObjectS.optString("rotateZ"), this.q));
            } catch (JSONException unused) {
            }
        }
        this.ju.n(cyVar, this, this);
    }

    private void lq() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.cp);
        this.l.setContentDescription(sb);
    }

    public void n(ou ouVar) {
        this.of = ouVar;
    }

    @Override // com.byazt.gu.l
    public void l() {
        if (this.ox != null) {
            oa oaVar = new oa(this.l, this.ox);
            this.ct = oaVar;
            oaVar.n();
        }
        com.byazt.kg.n nVar = this.hf;
        if (nVar != null) {
            nVar.n();
        }
        w wVar = this.kc;
        if (wVar != null) {
            wVar.qg();
        }
        ou ouVar = this.of;
        if (ouVar != null) {
            ouVar.q();
        }
        tj tjVar = this.mz;
        if (tjVar != null) {
            tjVar.rv();
        }
        if (this.ti != null && n(10)) {
            this.ti.n();
        }
        if (this.xd != null && n(9)) {
            this.xd.n();
        }
        com.byazt.uy.l lVar = this.jh;
        if (lVar != null) {
            lVar.n();
        }
        com.byazt.rc.n nVar2 = this.qh;
        if (nVar2 != null) {
            nVar2.s();
        }
        com.byazt.uw.s sVar = this.eq;
        if (sVar != null) {
            sVar.s();
        }
        this.on = System.currentTimeMillis();
    }

    public void w() {
        oa oaVar = this.ct;
        if (oaVar != null) {
            oaVar.qg();
        }
        com.byazt.kg.n nVar = this.hf;
        if (nVar != null) {
            nVar.s();
        }
        w wVar = this.kc;
        if (wVar != null) {
            wVar.s();
        }
        ou ouVar = this.of;
        if (ouVar != null) {
            ouVar.l();
        }
        q.n nVar2 = this.xb;
        if (nVar2 != null) {
            nVar2.qg();
        }
        com.byazt.rc.n nVar3 = this.qh;
        if (nVar3 != null) {
            nVar3.q();
        }
        com.byazt.uw.s sVar = this.eq;
        if (sVar != null) {
            sVar.q();
        }
    }

    @Override // com.byazt.gu.l
    public void n(boolean z) {
        ou ouVar = this.of;
        if (ouVar != null) {
            ouVar.n(z);
        }
        tj tjVar = this.mz;
        if (tjVar != null) {
            tjVar.qg(z);
        }
    }

    public cd ou() {
        return this.ju;
    }

    public long wm() {
        return this.on;
    }

    public void qg(boolean z) {
        this.tr = z;
    }

    public boolean n(int i) {
        Map<Integer, cy> map = this.xi;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void qg(int i) {
        T t = this.l;
        if (t == null) {
            this.cx = i;
            return;
        }
        if (this.cx == i && t.getVisibility() == i) {
            return;
        }
        this.cx = i;
        ViewParent viewParent = (ViewGroup) this.l.getParent();
        if (viewParent instanceof qg) {
            ((qg) viewParent).s(this.l, i);
        } else {
            this.l.setVisibility(i);
        }
        tj tjVar = this.mz;
        if (tjVar != null) {
            tjVar.n(i);
        }
    }

    public void n(a aVar) {
        this.ta = aVar;
    }

    public void n(cd cdVar) {
        this.ju = cdVar;
    }

    public void s(JSONObject jSONObject) {
        this.s = jSONObject;
    }

    public JSONObject m() {
        return this.s;
    }

    public void hu() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapN;
        if (TextUtils.isEmpty(this.fi)) {
            if (this.np) {
                n(this.r);
                return;
            } else {
                this.il.setColor(this.f);
                s(this.f);
                return;
            }
        }
        if (this.fi.startsWith("local://")) {
            String strReplace = this.fi.replace("local://", "");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = this.dg ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.qg.getResources().openRawResource(com.byazt.hb.q.qg(this.qg, strReplace)), null, options);
                if (this.dg && (bitmapN = fs.n(this.qg, bitmapDecodeStream, (int) this.oj)) != null) {
                    bitmapDrawable = new BitmapDrawable(this.qg.getResources(), bitmapN);
                } else {
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.qg.getResources(), bitmapDecodeStream);
                    bitmapDrawable = bitmapDrawable2;
                }
                n(bitmapDrawable);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        h();
    }

    public void h() {
        x xVar = this.wv;
        if (xVar != null) {
            xVar.n();
        }
        com.byazt.gu.w.n().qg().n(this.rv, this.fi, new com.byazt.gu.qg.n() { // from class: com.byazt.ih.s.4
            @Override // com.byazt.gu.qg.n
            public void n(final Bitmap bitmap) {
                if (bitmap == null) {
                    if (s.this.wv != null) {
                        x xVar2 = s.this.wv;
                        s sVar = s.this;
                        xVar2.qg(sVar, sVar.fi);
                        return;
                    }
                    return;
                }
                if (s.this.wv != null) {
                    x xVar3 = s.this.wv;
                    s sVar2 = s.this;
                    xVar3.n(sVar2, sVar2.fi);
                }
                if (s.this.dg) {
                    final Bitmap bitmapN = fs.n(s.this.qg, bitmap, (int) s.this.oj);
                    if (bitmapN != null) {
                        fs.n(new Runnable() { // from class: com.byazt.ih.s.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                s.this.n(new BitmapDrawable(bitmapN));
                            }
                        });
                        return;
                    }
                    return;
                }
                fs.n(new Runnable() { // from class: com.byazt.ih.s.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        s.this.n(new BitmapDrawable(bitmap));
                    }
                });
            }
        });
    }

    public void n(com.byazt.hb.n.C0188n c0188n) {
        if (c0188n == null) {
            return;
        }
        this.il.setShape(0);
        if (c0188n != null) {
            this.il.setOrientation(c0188n.n);
            if (Build.VERSION.SDK_INT >= 29) {
                this.il.setColors(c0188n.qg, c0188n.s);
            } else {
                this.il.setColors(c0188n.qg);
            }
        }
        kc();
        hf();
        ic();
    }

    public void s(int i) {
        this.il.setShape(0);
        this.il.setColor(i);
        kc();
        hf();
        ic();
    }

    private void ic() {
        com.byazt.rc.n nVar = this.qh;
        if (nVar != null && nVar.qg()) {
            this.qh.n(this.l, this.il, this.pe, z());
        } else {
            this.l.setBackground(this.il);
        }
    }

    private com.byazt.rc.n ci() {
        if (this.qh == null) {
            this.qh = new com.byazt.rc.n();
        }
        return this.qh;
    }

    private void hf() {
        com.byazt.rc.n nVar = this.qh;
        if (nVar == null || !nVar.n()) {
            if (TextUtils.equals("dashed", this.yw)) {
                GradientDrawable gradientDrawable = this.il;
                float f = this.pe;
                gradientDrawable.setStroke((int) f, this.e, 3.0f * f, f);
            } else {
                if (TextUtils.equals("dotted", this.yw)) {
                    GradientDrawable gradientDrawable2 = this.il;
                    float f2 = this.pe;
                    gradientDrawable2.setStroke((int) f2, this.e, f2 / 2.0f, f2);
                    return;
                }
                this.il.setStroke((int) this.pe, this.e);
            }
        }
    }

    private void kc() {
        this.il.setCornerRadii(z());
    }

    private float[] z() {
        float f = this.dh ? this.wo : this.pk;
        float f2 = this.b ? this.y : this.pk;
        float f3 = this.ri ? this.sh : this.pk;
        float f4 = this.nf ? this.rf : this.pk;
        return new float[]{f, f, f2, f2, f4, f4, f3, f3};
    }

    public void n(Drawable drawable) {
        this.l.setBackground(drawable);
    }

    public void n(ViewGroup.LayoutParams layoutParams) {
        T t = this.l;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.ci = layoutParams;
    }

    public ViewGroup.LayoutParams t() {
        return this.ci;
    }

    public void n(boolean z, boolean z2) {
        if (this.l != null) {
            n(this.ci);
            if (z) {
                q((int) this.oa);
            }
            if (z2) {
                l((int) this.sz);
            }
        }
    }

    public void n(rv.n nVar) {
        this.fs = nVar;
    }

    public rv.n ur() {
        return this.fs;
    }

    public n bb() {
        return this.x;
    }

    public s<T> q(String str) {
        return n(str);
    }

    public s<T> n(String str) {
        if (TextUtils.isEmpty(this.cp) || !TextUtils.equals(this.cp, str)) {
            return null;
        }
        return this;
    }

    public s<T> l(String str) {
        return qg(str);
    }

    public s<T> qg(String str) {
        if (TextUtils.isEmpty(this.d) || !TextUtils.equals(this.d, str)) {
            return null;
        }
        return this;
    }

    public s<T> w(String str) {
        return s(str);
    }

    public s<T> s(String str) {
        if (tj(str) != null) {
            return this;
        }
        return null;
    }

    public void s(boolean z) {
        this.tj = z;
    }

    public boolean ln() {
        return this.tj;
    }

    public n lh() {
        return this.w;
    }

    public void n(n nVar) {
        this.w = nVar;
    }

    public void x(String str) {
        this.cp = str;
    }

    public String v() {
        return this.cp;
    }

    public void fs(String str) {
        this.d = str;
    }

    public String j() {
        return this.d;
    }

    public int an() {
        return (int) this.oa;
    }

    public int ae() {
        return (int) this.sz;
    }

    public com.byazt.vh.sz f() {
        return this.rv;
    }

    public void n(com.byazt.vh.sz szVar) {
        this.rv = szVar;
    }

    public boolean fi() {
        return this.ic;
    }

    public void n(com.byazt.vh.tj tjVar) {
        this.ry = tjVar;
    }

    public int df() {
        return this.f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        int i = 8;
        byte b = -1;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    b = 0;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    b = 1;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    b = 2;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    b = 3;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    b = 4;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    b = 5;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    b = 6;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    b = 7;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    b = 8;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    b = 9;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    b = 10;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    b = 11;
                }
                break;
            case -1291329255:
                if (str.equals("events")) {
                    b = 12;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b = 13;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b = 14;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b = 15;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    b = 16;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    b = 17;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    b = 18;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    b = 19;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    b = 20;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b = 21;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b = 22;
                }
                break;
            case -882862153:
                if (str.equals("particleEffect")) {
                    b = 23;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    b = 24;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    b = 25;
                }
                break;
            case -389160068:
                if (str.equals("borderGradient")) {
                    b = 26;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    b = 27;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    b = 28;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    b = 29;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    b = 30;
                }
                break;
            case 3373707:
                if (str.equals(TapEventParamConstants.PARAM_NAME)) {
                    b = 31;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    b = 32;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    b = 33;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b = 34;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    b = 35;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    b = 36;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b = 37;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 38;
                }
                break;
            case 197402866:
                if (str.equals("borderFog")) {
                    b = 39;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    b = 40;
                }
                break;
            case 314070383:
                if (str.equals("animations")) {
                    b = 41;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    b = 42;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b = 43;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    b = 44;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b = 45;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b = 46;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    b = 47;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    b = 48;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b = 49;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    b = 50;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    b = 51;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    b = 52;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 53;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    b = 54;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    b = 55;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    b = 56;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    b = 57;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    b = 58;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    b = 59;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    b = 60;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = 61;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    b = 62;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    b = c.c;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    b = c.b;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    b = 65;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    b = 66;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    b = 67;
                }
                break;
            case 1824519034:
                if (str.equals("borderFlow")) {
                    b = 68;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    b = 69;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    b = 70;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    b = 71;
                }
                break;
        }
        switch (b) {
            case 0:
                this.wf = com.byazt.hb.s.n(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 18:
            case 35:
            case 42:
            case 51:
            case 54:
            case 57:
            case 65:
            case 67:
                qg(str, str2);
                break;
            case 2:
                this.n = true;
                this.dn = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case 3:
                this.sq = true;
                this.he = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case 4:
                this.t = fs.n(this.qg, str2);
                this.v = true;
                break;
            case 5:
                this.a = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case 11:
            case 58:
                if (com.byazt.hb.n.s(str2)) {
                    this.np = true;
                    this.r = com.byazt.hb.n.qg(str2);
                } else {
                    this.f = com.byazt.hb.n.n(str2, 0);
                    this.np = false;
                }
                break;
            case 12:
                this.mz = tj.n(this, str2);
                break;
            case 13:
                this.ze = true;
                this.g = com.byazt.hb.s.n(str2, 1.0f);
                break;
            case 14:
                this.wo = fs.n(this.qg, str2);
                this.dh = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.sz = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.sz = -2.0f;
                } else {
                    this.sz = fs.n(this.qg, str2);
                }
                this.jw = true;
                break;
            case 16:
                this.k = fs.n(this.qg, str2);
                break;
            case 17:
                this.cd = fs.n(this.qg, str2);
                this.m = true;
                break;
            case 19:
            case 59:
                this.fi = str2;
                break;
            case 20:
                this.vo = true;
                this.i = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case 21:
                this.ei = true;
                this.vb = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case 22:
                this.dm = true;
                this.fl = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case 23:
                if (this.eq == null) {
                    this.eq = new com.byazt.uw.s(this.qg);
                }
                this.eq.n(str2);
                break;
            case 24:
                this.h = fs.n(this.qg, str2);
                this.lh = true;
                break;
            case 25:
                this.ca = str2;
                break;
            case 26:
                ci().n(str2);
                break;
            case 27:
                this.um = fs.n(this.qg, str2);
                this.hu = true;
                break;
            case 28:
                this.py = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case 29:
                this.cp = str2;
                break;
            case 30:
                this.lr = com.byazt.hb.qg.n(str2, (JSONObject) null);
                break;
            case 31:
                this.d = str2;
                break;
            case 32:
                float fN = com.byazt.hb.s.n(str2, 0.0f);
                this.oj = fN;
                if (fN > 0.0f) {
                    this.dg = true;
                }
                break;
            case 33:
                this.bb = fs.n(this.qg, str2);
                this.an = true;
                break;
            case 34:
                this.la = str2;
                break;
            case 36:
                this.lq = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case 37:
                this.ei = true;
                this.dm = true;
                float[] fArrQg = com.byazt.kg.q.qg(str2, this.q);
                this.vb = fArrQg[0];
                this.fl = fArrQg[1];
                break;
            case 38:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.oa = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.oa = -2.0f;
                } else {
                    this.oa = fs.n(this.qg, str2);
                }
                this.rm = true;
                break;
            case 39:
                ci().n(str2, this.qg);
                break;
            case 40:
                this.ln = fs.n(this.qg, str2);
                this.ae = true;
                break;
            case 41:
                List<com.byazt.kg.s> listN = com.byazt.kg.q.n(str2, this.q);
                if (listN != null && !listN.isEmpty()) {
                    this.kc = new w(this.qg, this, listN);
                    break;
                }
                break;
            case 43:
                this.y = fs.n(this.qg, str2);
                this.b = true;
                break;
            case 44:
                this.qn = oa(str2);
                break;
            case 45:
                this.sh = fs.n(this.qg, str2);
                this.ri = true;
                break;
            case 46:
                this.rf = fs.n(this.qg, str2);
                this.nf = true;
                break;
            case 47:
                this.ur = fs.n(this.qg, str2);
                this.j = true;
                break;
            case 48:
                this.e = com.byazt.hb.n.n(str2);
                break;
            case 49:
                this.yw = str2;
                break;
            case 50:
                this.pe = fs.n(this.qg, str2);
                break;
            case 52:
                this.hd = fs.n(this.qg, str2);
                this.wm = true;
                break;
            case 53:
                this.n = true;
                this.sq = true;
                float[] fArrQg2 = com.byazt.kg.q.qg(str2, this.q);
                this.dn = fs.n(this.qg, fArrQg2[0]);
                this.he = fs.n(this.qg, fArrQg2[1]);
                break;
            case 55:
                try {
                    this.hf = new com.byazt.kg.n(this.qg, this, com.byazt.kg.q.n(new JSONObject(str2), this.q));
                } catch (JSONException unused) {
                    return;
                }
                break;
            case 56:
                this.ox = com.byazt.vh.n.n(str2, this);
                break;
            case 60:
                this.u = true;
                this.df = d(str2);
                break;
            case 61:
                this.pk = fs.n(this.qg, str2);
                break;
            case 62:
                this.o = true;
                this.dw = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case 63:
                this.nk = true;
                this.su = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case 64:
                this.ha = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case 66:
                this.bz = com.byazt.hb.s.n(str2, false);
                break;
            case 68:
                ci().qg(str2);
                break;
            case 69:
                int i2 = this.cx;
                if (TextUtils.equals("visible", str2)) {
                    i = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    i = 4;
                } else if (!TextUtils.equals("gone", str2) && !TextUtils.equals("hidden", str2)) {
                    i = i2;
                }
                qg(i);
                break;
            case 70:
                this.cy = fs.n(this.qg, str2);
                this.ou = true;
                break;
            case 71:
                this.ic = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    private ImageView.ScaleType d(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.df = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.df = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.df = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.df = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.df;
    }

    private boolean oa(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    public void qg(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.xi == null) {
            return;
        }
        try {
            int type = hd.n(str).getType();
            cy cyVar = new cy();
            cyVar.n(type);
            cyVar.n(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (type == 3) {
                try {
                    this.dx = Float.parseFloat(com.byazt.mcb.qg.n(jSONObject.optString("shakeAmplitude"), this.q));
                } catch (NumberFormatException unused) {
                    this.dx = 12.0f;
                }
            }
            cd cdVar = this.ju;
            if (!(cdVar instanceof com.byazt.ey.qg)) {
                n(type, jSONObject, cyVar);
            } else if (!((com.byazt.ey.qg) cdVar).n()) {
                n(type, jSONObject, cyVar);
            } else {
                cyVar.n(jSONObject);
                this.xi.put(Integer.valueOf(type), cyVar);
            }
        } catch (JSONException unused2) {
        }
    }

    @Deprecated
    public void n(int i, JSONObject jSONObject, cy cyVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
        if (jSONObjectOptJSONObject != null) {
            cy cyVar2 = new cy();
            cyVar2.n(jSONObjectOptJSONObject);
            cyVar2.n(this);
            cyVar.n(cyVar2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
        if (jSONObjectOptJSONObject2 != null) {
            cy cyVar3 = new cy();
            cyVar3.n(jSONObjectOptJSONObject2);
            cyVar3.n(this);
            cyVar.qg(cyVar3);
        }
        cyVar.n(jSONObject);
        this.xi.put(Integer.valueOf(i), cyVar);
    }

    @Override // com.byazt.gu.l
    public void s() {
        if (this.of == null || this.dz) {
            return;
        }
        this.dz = true;
    }

    @Override // com.byazt.gu.l
    public void q() {
        if (this.of == null || this.di) {
            return;
        }
        this.di = true;
    }

    @Override // com.byazt.gu.l
    public int[] n(int i, int i2) {
        if (this.lq > 0.0f) {
            if (this.rm) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.lq;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), C.ENCODING_PCM_32BIT);
                }
            } else if (this.jw) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.lq;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), C.ENCODING_PCM_32BIT);
                }
            }
        }
        if (this.of != null && !this.c) {
            this.c = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.byazt.gu.l
    public void n(int i, int i2, int i3, int i4) {
        if (this.of == null || this.oo) {
            return;
        }
        this.oo = true;
    }

    @Override // com.byazt.gu.l
    public void n(Canvas canvas, com.byazt.vh.l lVar) {
        oa oaVar = this.ct;
        if (oaVar != null) {
            oaVar.n(canvas, lVar);
        }
    }

    @Override // com.byazt.gu.l
    public void n(Canvas canvas) {
        if (this instanceof n) {
            return;
        }
        com.byazt.kg.n nVar = this.hf;
        if (nVar != null) {
            nVar.n(canvas);
        }
        w wVar = this.kc;
        if (wVar != null) {
            wVar.n(canvas);
        }
    }

    @Override // com.byazt.gu.l
    public void qg(Canvas canvas) {
        if (this instanceof n) {
            com.byazt.kg.n nVar = this.hf;
            if (nVar != null) {
                nVar.qg(canvas);
            }
            w wVar = this.kc;
            if (wVar != null) {
                wVar.qg(canvas);
            }
        }
    }

    @Override // com.byazt.gu.l
    public void qg(int i, int i2, int i3, int i4) {
        oa oaVar = this.ct;
        if (oaVar != null) {
            oaVar.n(i, i2);
        }
        com.byazt.kg.n nVar = this.hf;
        if (nVar != null) {
            nVar.n(i, i2);
        }
        w wVar = this.kc;
        if (wVar != null) {
            wVar.n(i, i2);
        }
    }

    @Override // com.byazt.vh.cd.qg
    public void n(cy cyVar) {
        n<ViewGroup> nVar;
        s<T> sVarQ;
        if (cyVar == null || cyVar.s() == null) {
            return;
        }
        q.n nVar2 = this.xb;
        if (nVar2 != null) {
            nVar2.qg();
        }
        if (TextUtils.equals(cyVar.s().optString("type"), "onDismiss")) {
            String strOptString = cyVar.s().optString("nodeId");
            qg(8);
            this.x = (n) qg(this);
            if (TextUtils.isEmpty(strOptString) || (nVar = this.x) == null || (sVarQ = nVar.q(strOptString)) == null) {
                return;
            }
            sVarQ.qg(8);
        }
    }

    public void n(com.byazt.vt.n nVar) {
        this.rn = nVar;
    }

    public com.byazt.vt.n oj() {
        return this.rn;
    }

    public s qg(s sVar) {
        return (sVar.lh() == null && (sVar instanceof n)) ? sVar : qg(sVar.lh());
    }

    public void pk() {
        com.byazt.uy.l lVar = this.jh;
        if (lVar != null) {
            lVar.qg();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.uy.l lVar;
        cd cdVar;
        com.byazt.uy.s sVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            dg();
        } else if (action == 1 || action == 3) {
            u();
        }
        a aVar = this.ta;
        if (aVar != null) {
            aVar.n(this, motionEvent);
        }
        if (n(17) && motionEvent.getAction() == 0) {
            this.ju.n(this.xi.get(17), this, this);
        }
        if (n(1) && this.tr && (cdVar = this.ju) != null && (sVar = this.lg) != null) {
            return sVar.n(cdVar, this, motionEvent);
        }
        cd cdVar2 = this.ju;
        if (cdVar2 != null && (lVar = this.jh) != null) {
            return lVar.n(cdVar2, this, motionEvent, nf());
        }
        tj tjVar = this.mz;
        if (tjVar != null) {
            return tjVar.n(motionEvent);
        }
        return false;
    }

    public boolean wo() {
        return this.lq > 0.0f;
    }

    public float sh() {
        T t = this.l;
        if (t instanceof com.byazt.kg.x) {
            return ((com.byazt.kg.x) t).getRipple();
        }
        return 0.0f;
    }

    public float y() {
        T t = this.l;
        if (t instanceof com.byazt.kg.x) {
            return ((com.byazt.kg.x) t).getShine();
        }
        return 0.0f;
    }

    public float rf() {
        T t = this.l;
        if (t instanceof com.byazt.kg.x) {
            return ((com.byazt.kg.x) t).getStretch();
        }
        return 0.0f;
    }

    public float dh() {
        T t = this.l;
        if (t instanceof com.byazt.kg.x) {
            return ((com.byazt.kg.x) t).getRubIn();
        }
        return 0.0f;
    }

    public void q(int i) {
        if (ln()) {
            T t = this.l;
            if (t instanceof qg) {
                ((qg) t).n(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof qg) {
                ((qg) viewParent).n(this.l, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        layoutParams.width = i;
        this.l.setLayoutParams(layoutParams);
    }

    public void l(int i) {
        if (ln()) {
            T t = this.l;
            if (t instanceof qg) {
                ((qg) t).qg(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof qg) {
                ((qg) viewParent).qg(this.l, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        layoutParams.height = i;
        this.l.setLayoutParams(layoutParams);
    }

    public void b() {
        if (this.l == null || !ln()) {
            return;
        }
        ViewParent viewParent = (ViewGroup) this.l.getParent();
        if (viewParent instanceof qg) {
            ((qg) viewParent).n(this.l);
        }
    }

    public boolean ri() {
        return this.bz;
    }

    public List<com.byazt.et.qg> rv(String str) {
        tj tjVar;
        if (TextUtils.isEmpty(str) || (tjVar = this.mz) == null) {
            return null;
        }
        return tjVar.l(str);
    }

    public void n(String str, Object... objArr) {
        List<com.byazt.et.qg> listRv = rv(str);
        if (listRv == null || listRv.isEmpty()) {
            return;
        }
        for (com.byazt.et.qg qgVar : listRv) {
            qgVar.n(this.mz);
            qgVar.n(objArr);
        }
    }

    public void n(com.byazt.vh.w wVar) {
        tj tjVar = this.mz;
        if (tjVar != null) {
            tjVar.n(wVar);
        }
    }

    public com.byazt.kg.n tj(String str) {
        com.byazt.kg.n nVar = this.hf;
        if (nVar != null && TextUtils.equals(str, nVar.l())) {
            return this.hf;
        }
        w wVar = this.kc;
        if (wVar != null) {
            return wVar.n(str);
        }
        return null;
    }

    public void n(x xVar) {
        this.wv = xVar;
    }

    public boolean nf() {
        return this.rg;
    }

    public void n(k kVar) {
        tj tjVar = this.mz;
        if (tjVar != null) {
            tjVar.n(kVar);
        }
        this.es = kVar;
    }

    public void n(sz szVar) {
        tj tjVar = this.mz;
        if (tjVar != null) {
            tjVar.n(szVar);
        }
        this.ed = szVar;
    }

    public k pe() {
        return this.es;
    }

    public sz e() {
        return this.ed;
    }

    public tj yw() {
        return this.mz;
    }

    public void cp(String str) {
        tj tjVar = this.mz;
        if (tjVar != null) {
            tjVar.n(str);
        }
    }
}
