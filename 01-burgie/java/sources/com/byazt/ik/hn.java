package com.byazt.ik;

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
import com.byazt.aa.zo;
import com.byazt.ch.a;
import com.byazt.ch.aj;
import com.byazt.ch.fw;
import com.byazt.ch.g;
import com.byazt.ch.lb;
import com.byazt.ch.m;
import com.byazt.ch.nt;
import com.byazt.ch.ny;
import com.byazt.ch.yb;
import com.byazt.dd.ho;
import com.byazt.dd.vk;
import com.byazt.iza.uc;
import com.byazt.llk.c;
import com.byazt.qi.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, 20})
public abstract class hn<T extends View> implements View.OnTouchListener, c, lb.hw, lb.pr {
    public float a;
    public float aa;
    public vk ag;
    public g aj;
    public float b;
    public JSONObject bg;
    public float bh;
    public boolean bm;
    public T c;
    public com.byazt.dd.g cb;
    public boolean cl;
    public float cr;
    public float cz;
    public uc d;
    public boolean e;
    public fw eh;
    public String er;
    public float ey;
    public boolean f;
    public boolean fe;
    public long fj;
    public boolean fo;
    public GradientDrawable fs;
    public pr<ViewGroup> fw;
    public float g;
    public boolean gg;
    public com.byazt.iza.pr gu;
    public float gz;

    @Deprecated
    public com.byazt.qi.uc h;
    public boolean hg;
    public JSONObject hn;
    public float ho;
    public float hs;
    public Context hw;
    public float i;
    public boolean ie;
    public float ii;
    public float iu;
    public float iy;
    public float j;
    public float jl;
    public float jn;
    public float jw;
    public String k;
    public boolean kl;
    public boolean ks;
    public boolean ku;
    public int l;
    public float lb;
    public com.byazt.ch.pr lj;
    public int ls;
    public String lv;
    public float m;
    public com.byazt.aa.pr.C0005pr mr;
    public boolean mw;
    public boolean n;
    public Map<Integer, nt> na;
    public float nl;
    public a np;
    public float nt;
    public float nw;
    public boolean ny;
    public boolean o;
    public int od;
    public boolean of;
    public com.byazt.njk.hn oj;
    public boolean ok;
    public m om;
    public boolean ou;
    public boolean p;
    public float pj;
    public boolean pp;
    public float pq;
    public boolean pr;
    public boolean q;
    public float qa;
    public float qi;
    public boolean qn;
    public float qo;
    public com.byazt.ch.vk qv;
    public boolean qx;
    public float r;
    public boolean rc;
    public boolean rk;
    public boolean s;
    public boolean sr;
    public ny su;
    public ViewGroup.LayoutParams sv;
    public String sx;

    @Deprecated
    public com.byazt.qi.hw t;

    @Deprecated
    public x.pr tv;
    public lb u;
    public pr<ViewGroup> uc;
    public com.byazt.afx.pr uk;
    public ImageView.ScaleType v;
    public float ve;
    public float vj;
    public boolean vk;

    @Deprecated
    public com.byazt.qi.c vv;
    public String w;
    public String wm;
    public boolean wo;
    public float wt;
    public boolean ww;
    public boolean wz;
    public JSONObject x;
    public boolean xb;
    public boolean xg;
    public boolean xi;
    public boolean xk;
    public ho xy;
    public boolean y;
    public float yb;
    public com.byazt.mj.pr yc;

    @Deprecated
    public com.byazt.qi.hn yj;
    public boolean z;
    public aj.pr zo;

    public hn(Context context) {
        this(context, null);
    }

    public hn(Context context, pr<ViewGroup> prVar) {
        this.m = -2.0f;
        this.g = -2.0f;
        this.lv = "solid";
        this.od = 0;
        this.mw = true;
        this.pq = 0.0f;
        this.jw = 0.0f;
        this.wt = 0.0f;
        this.aa = 1.0f;
        this.iy = 1.0f;
        this.cr = 1.0f;
        this.j = 0.0f;
        this.qo = 0.0f;
        this.bh = 0.0f;
        this.pj = 0.0f;
        this.ey = 1.0f;
        this.ku = true;
        this.q = true;
        this.ok = false;
        this.xk = false;
        this.ou = false;
        this.cl = false;
        this.jl = 12.0f;
        this.hw = context;
        this.uc = prVar;
        this.na = new HashMap();
        this.fs = new GradientDrawable();
        this.c = (T) pr();
    }

    public T pr() {
        return null;
    }

    public T aj() {
        return this.c;
    }

    public void hw(JSONObject jSONObject) {
        this.x = jSONObject;
        w();
    }

    public void pr(JSONObject jSONObject) {
        this.x = jSONObject;
        w();
        JSONObject jSONObject2 = this.hn;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        pr.C0097pr c0097prZo = null;
        pr<ViewGroup> prVar = this.uc;
        if (prVar instanceof pr) {
            c0097prZo = prVar.zo();
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strPr = com.byazt.tn.hw.pr(this.hn.optString(next), jSONObject);
            pr(next, strPr);
            if (c0097prZo != null) {
                c0097prZo.pr(this.hw, next, strPr);
            }
        }
        if (c0097prZo != null) {
            pr(c0097prZo.pr());
        }
        if (this.bg != null && this.x != null) {
            try {
                if (nl()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("i18n", this.bg);
                    this.x.put("xNode", jSONObject3);
                    return;
                }
                this.x.put("i18n", this.bg);
            } catch (JSONException e) {
            }
        }
    }

    public JSONObject vk() {
        return this.x;
    }

    public void w() {
        boolean zOptBoolean = this.x.optBoolean("gesture_through_enable", false);
        aj.pr prVar = this.zo;
        this.ou = zOptBoolean && (prVar == null || prVar.hn());
        this.cl = this.x.optBoolean("is_adapt_two_finger", false);
    }

    public void hw() {
        z();
        k();
        hw(this.od);
        fw();
        zo();
        vk vkVar = this.ag;
        if (vkVar != null) {
            vkVar.hw();
            this.ag.hn();
            this.ag.x();
        }
        this.c.setOnTouchListener(this);
        od();
        ViewGroup viewGroup = (ViewGroup) this.c.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.ku);
        }
        com.byazt.iza.pr prVar = this.gu;
        if (prVar != null) {
            prVar.x();
        }
        uc ucVar = this.d;
        if (ucVar != null) {
            ucVar.pr();
        }
        vk vkVar2 = this.ag;
        if (vkVar2 != null) {
            vkVar2.c();
            this.ag.fw();
            this.ag.uc();
        }
        if (this.u != null && pr(22)) {
            this.u.pr(this.na.get(22), this, this);
        }
        com.byazt.njk.hn hnVar = this.oj;
        if (hnVar != null && hnVar.pr()) {
            this.oj.pr(this.c);
        }
    }

    public void k() {
        this.c.setPadding((int) (this.ww ? this.iu : this.b), (int) (this.e ? this.gz : this.b), (int) (this.n ? this.ve : this.b), (int) (this.s ? this.nl : this.b));
    }

    private void fw() {
        if (this.pr) {
            this.c.setTranslationX(this.jw);
        }
        if (this.qx) {
            this.c.setTranslationY(this.wt);
        }
        if (this.fe) {
            this.c.setScaleX(this.iy);
        }
        if (this.ks) {
            this.c.setScaleY(this.cr);
        }
        if (this.sr) {
            this.c.setRotation(this.j);
        }
        if (this.wz) {
            this.c.setRotationX(this.qo);
        }
        if (this.xb) {
            this.c.setRotationY(-this.bh);
        }
        if (this.p) {
            this.c.setAlpha(this.ey);
        }
        float f = this.pj;
        if (f != 0.0f) {
            this.c.setRotation(f);
        }
        if (this.sr || this.wz || this.xb) {
            this.c.setCameraDistance(10000.0f);
        }
    }

    public float m() {
        return this.jw;
    }

    public float g() {
        return this.wt;
    }

    public float ho() {
        return this.iy;
    }

    public float nt() {
        return this.cr;
    }

    public float yb() {
        return this.qo;
    }

    public float lb() {
        return this.bh;
    }

    public float qa() {
        return this.pj;
    }

    public float a() {
        return this.ey;
    }

    public float cz() {
        return this.ii;
    }

    @Deprecated
    private void zo() {
        x xVarC;
        this.c.setVisibility(this.od);
        float f = this.pj;
        if (f != 0.0f) {
            this.c.setRotation(f);
        }
        aj.pr prVar = this.zo;
        if (prVar != null && TextUtils.isEmpty(prVar.hw())) {
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ik.hn.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (hn.this.qv != null && hn.this.q) {
                        hn.this.qv.pr(hn.this);
                    }
                }
            });
        } else if (pr(1) && !this.wo) {
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ik.hn.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (hn.this.u != null && hn.this.q) {
                        lb lbVar = hn.this.u;
                        nt ntVar = hn.this.na.get(1);
                        hn hnVar = hn.this;
                        lbVar.pr(ntVar, hnVar, hnVar);
                    }
                }
            });
        }
        if (this.u != null && pr(4)) {
            if (!pr(1)) {
                this.vv = new com.byazt.qi.c(this.hw, this.na.get(4), this.hg, f(), this.cl);
            } else {
                this.hg = true;
                this.vv = new com.byazt.qi.c(this.hw, this.na.get(4), this.na.get(1), this.hg, f(), this.cl);
            }
        }
        if (this.u != null && pr(1) && this.wo) {
            this.yj = new com.byazt.qi.hn(this.hw, this.na.get(1));
        }
        lv();
        if (this.u != null && pr(3) && (xVarC = com.byazt.llk.uc.pr().c()) != null) {
            x.pr prVar2 = this.tv;
            if (prVar2 != null) {
                prVar2.hw();
            }
            x.pr prVarPr = xVarC.pr(this.hw, this);
            this.tv = prVarPr;
            prVarPr.pr(this.jl);
            this.tv.pr();
            this.tv.pr(new x.hw() { // from class: com.byazt.ik.hn.3
                @Override // com.byazt.qi.x.hw
                public void pr(int i) {
                    hn.this.tv.hw();
                    if (hn.this.c.isShown() && hn.this.u != null && i == 1) {
                        lb lbVar = hn.this.u;
                        nt ntVar = hn.this.na.get(3);
                        hn hnVar = hn.this;
                        lbVar.pr(ntVar, hnVar, hnVar);
                    }
                }
            });
        }
        if (this.u != null && pr(9)) {
            com.byazt.qi.uc ucVar = new com.byazt.qi.uc(this.hw, this.na.get(9), this);
            this.h = ucVar;
            ucVar.pr(this.u);
        }
        if (pr(10)) {
            com.byazt.qi.hw hwVar = new com.byazt.qi.hw(this.hw, this.na.get(10), this);
            this.t = hwVar;
            hwVar.pr(this.u);
        }
    }

    private void lv() {
        nt ntVar;
        if (this.u == null || !pr(18) || (ntVar = this.na.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectHn = ntVar.hn();
        if (jSONObjectHn != null) {
            try {
                jSONObjectHn.put("rotateZ", com.byazt.tn.hw.pr(jSONObjectHn.optString("rotateZ"), this.x));
            } catch (JSONException e) {
            }
        }
        this.u.pr(ntVar, this, this);
    }

    private void od() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.w);
        this.c.setContentDescription(sb);
    }

    public void pr(ny nyVar) {
        this.su = nyVar;
    }

    public void c() {
        com.byazt.ch.pr prVar = this.lj;
        if (prVar != null) {
            m mVar = new m(this.c, prVar);
            this.om = mVar;
            mVar.pr();
        }
        com.byazt.iza.pr prVar2 = this.gu;
        if (prVar2 != null) {
            prVar2.pr();
        }
        uc ucVar = this.d;
        if (ucVar != null) {
            ucVar.hw();
        }
        ny nyVar = this.su;
        if (nyVar != null) {
            nyVar.x();
        }
        vk vkVar = this.ag;
        if (vkVar != null) {
            vkVar.zo();
        }
        if (this.t != null && pr(10)) {
            this.t.pr();
        }
        if (this.h != null && pr(9)) {
            this.h.pr();
        }
        com.byazt.qi.c cVar = this.vv;
        if (cVar != null) {
            cVar.pr();
        }
        com.byazt.afx.pr prVar3 = this.uk;
        if (prVar3 != null) {
            prVar3.hn();
        }
        com.byazt.njk.hn hnVar = this.oj;
        if (hnVar != null) {
            hnVar.hn();
        }
        this.fj = System.currentTimeMillis();
    }

    public void uc() {
        m mVar = this.om;
        if (mVar != null) {
            mVar.hw();
        }
        com.byazt.iza.pr prVar = this.gu;
        if (prVar != null) {
            prVar.hn();
        }
        uc ucVar = this.d;
        if (ucVar != null) {
            ucVar.hn();
        }
        ny nyVar = this.su;
        if (nyVar != null) {
            nyVar.c();
        }
        x.pr prVar2 = this.tv;
        if (prVar2 != null) {
            prVar2.hw();
        }
        com.byazt.afx.pr prVar3 = this.uk;
        if (prVar3 != null) {
            prVar3.x();
        }
        com.byazt.njk.hn hnVar = this.oj;
        if (hnVar != null) {
            hnVar.x();
        }
    }

    public void pr(boolean z) {
        ny nyVar = this.su;
        if (nyVar != null) {
            nyVar.pr(z);
        }
        vk vkVar = this.ag;
        if (vkVar != null) {
            vkVar.hw(z);
        }
    }

    public lb ny() {
        return this.u;
    }

    public long fo() {
        return this.fj;
    }

    public void hw(boolean z) {
        this.wo = z;
    }

    public boolean pr(int i) {
        Map<Integer, nt> map = this.na;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void hw(int i) {
        ViewParent viewParent = (ViewGroup) this.c.getParent();
        if (viewParent instanceof hw) {
            ((hw) viewParent).hn(this.c, i);
        } else {
            this.c.setVisibility(i);
        }
        vk vkVar = this.ag;
        if (vkVar != null) {
            vkVar.pr(i);
        }
    }

    public void pr(a aVar) {
        this.np = aVar;
    }

    public void pr(lb lbVar) {
        this.u = lbVar;
    }

    public void hn(JSONObject jSONObject) {
        this.hn = jSONObject;
    }

    public JSONObject rc() {
        return this.hn;
    }

    public void z() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapPr;
        if (TextUtils.isEmpty(this.er)) {
            if (this.rk) {
                pr(this.mr);
                return;
            } else {
                this.fs.setColor(this.ls);
                hn(this.ls);
                return;
            }
        }
        if (this.er.startsWith("local://")) {
            String strReplace = this.er.replace("local://", "");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = this.qn ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.hw.getResources().openRawResource(com.byazt.aa.x.hw(this.hw, strReplace)), null, options);
                if (this.qn && (bitmapPr = zo.pr(this.hw, bitmapDecodeStream, (int) this.qi)) != null) {
                    bitmapDrawable = new BitmapDrawable(this.hw.getResources(), bitmapPr);
                } else {
                    bitmapDrawable = new BitmapDrawable(this.hw.getResources(), bitmapDecodeStream);
                }
                pr(bitmapDrawable);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        b();
    }

    public void b() {
        fw fwVar = this.eh;
        if (fwVar != null) {
            fwVar.pr();
        }
        com.byazt.llk.uc.pr().hw().pr(this.aj, this.er, new com.byazt.llk.hw.pr() { // from class: com.byazt.ik.hn.4
            @Override // com.byazt.llk.hw.pr
            public void pr(final Bitmap bitmap) {
                if (bitmap == null) {
                    if (hn.this.eh != null) {
                        fw fwVar2 = hn.this.eh;
                        hn hnVar = hn.this;
                        fwVar2.hw(hnVar, hnVar.er);
                        return;
                    }
                    return;
                }
                if (hn.this.eh != null) {
                    fw fwVar3 = hn.this.eh;
                    hn hnVar2 = hn.this;
                    fwVar3.pr(hnVar2, hnVar2.er);
                }
                if (hn.this.qn) {
                    final Bitmap bitmapPr = zo.pr(hn.this.hw, bitmap, (int) hn.this.qi);
                    if (bitmapPr != null) {
                        zo.pr(new Runnable() { // from class: com.byazt.ik.hn.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                hn.this.pr(new BitmapDrawable(bitmapPr));
                            }
                        });
                        return;
                    }
                    return;
                }
                zo.pr(new Runnable() { // from class: com.byazt.ik.hn.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        hn.this.pr(new BitmapDrawable(bitmap));
                    }
                });
            }
        });
    }

    public void pr(com.byazt.aa.pr.C0005pr c0005pr) {
        if (c0005pr == null) {
            return;
        }
        this.fs.setShape(0);
        if (c0005pr != null) {
            this.fs.setOrientation(c0005pr.pr);
            if (Build.VERSION.SDK_INT >= 29) {
                this.fs.setColors(c0005pr.hw, c0005pr.hn);
            } else {
                this.fs.setColors(c0005pr.hw);
            }
        }
        gu();
        sv();
        vj();
    }

    public void hn(int i) {
        this.fs.setShape(0);
        this.fs.setColor(i);
        gu();
        sv();
        vj();
    }

    private void vj() {
        com.byazt.afx.pr prVar = this.uk;
        if (prVar != null && prVar.hw()) {
            this.uk.pr(this.c, this.fs, this.jn, d());
        } else {
            this.c.setBackground(this.fs);
        }
    }

    private com.byazt.afx.pr mw() {
        if (this.uk == null) {
            this.uk = new com.byazt.afx.pr();
        }
        return this.uk;
    }

    private void sv() {
        com.byazt.afx.pr prVar = this.uk;
        if (prVar != null && prVar.pr()) {
            return;
        }
        if (TextUtils.equals("dashed", this.lv)) {
            GradientDrawable gradientDrawable = this.fs;
            float f = this.jn;
            gradientDrawable.setStroke((int) f, this.l, 3.0f * f, f);
        } else {
            if (TextUtils.equals("dotted", this.lv)) {
                GradientDrawable gradientDrawable2 = this.fs;
                float f2 = this.jn;
                gradientDrawable2.setStroke((int) f2, this.l, f2 / 2.0f, f2);
                return;
            }
            this.fs.setStroke((int) this.jn, this.l);
        }
    }

    private void gu() {
        this.fs.setCornerRadii(d());
    }

    private float[] d() {
        float f = this.ie ? this.i : this.ii;
        float f2 = this.o ? this.hs : this.ii;
        float f3 = this.f ? this.r : this.ii;
        float f4 = this.bm ? this.nw : this.ii;
        return new float[]{f, f, f2, f2, f4, f4, f3, f3};
    }

    public void pr(Drawable drawable) {
        this.c.setBackground(drawable);
    }

    public void pr(ViewGroup.LayoutParams layoutParams) {
        T t = this.c;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.sv = layoutParams;
    }

    public ViewGroup.LayoutParams iu() {
        return this.sv;
    }

    public void pr(boolean z, boolean z2) {
        if (this.c != null) {
            pr(this.sv);
            if (z) {
                x((int) this.m);
            }
            if (z2) {
                c((int) this.g);
            }
        }
    }

    public void pr(aj.pr prVar) {
        this.zo = prVar;
    }

    public aj.pr ve() {
        return this.zo;
    }

    public pr gz() {
        return this.fw;
    }

    public hn<T> x(String str) {
        return pr(str);
    }

    public hn<T> pr(String str) {
        if (!TextUtils.isEmpty(this.w) && TextUtils.equals(this.w, str)) {
            return this;
        }
        return null;
    }

    public hn<T> c(String str) {
        return hw(str);
    }

    public hn<T> hw(String str) {
        if (!TextUtils.isEmpty(this.k) && TextUtils.equals(this.k, str)) {
            return this;
        }
        return null;
    }

    public hn<T> uc(String str) {
        return hn(str);
    }

    public hn<T> hn(String str) {
        if (vk(str) != null) {
            return this;
        }
        return null;
    }

    public void hn(boolean z) {
        this.vk = z;
    }

    public boolean nl() {
        return this.vk;
    }

    public pr y() {
        return this.uc;
    }

    public void pr(pr prVar) {
        this.uc = prVar;
    }

    public void fw(String str) {
        this.w = str;
    }

    public String ww() {
        return this.w;
    }

    public void zo(String str) {
        this.k = str;
    }

    public String n() {
        return this.k;
    }

    public int e() {
        return (int) this.m;
    }

    public int s() {
        return (int) this.g;
    }

    public g ls() {
        return this.aj;
    }

    public void pr(g gVar) {
        this.aj = gVar;
    }

    public boolean er() {
        return this.mw;
    }

    public void pr(com.byazt.ch.vk vkVar) {
        this.qv = vkVar;
    }

    public int v() {
        return this.ls;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    b = 18;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    b = 61;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    b = 37;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    b = 38;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    b = 11;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    b = 70;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    b = 58;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    b = 50;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    b = 52;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    b = 56;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    b = 51;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    b = cc.n;
                }
                break;
            case -1291329255:
                if (str.equals(d.ar)) {
                    b = 64;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b = 45;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b = 21;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b = 3;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    b = 5;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    b = 9;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    b = 60;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    b = 31;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    b = 42;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b = 40;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b = 41;
                }
                break;
            case -882862153:
                if (str.equals("particleEffect")) {
                    b = 28;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    b = 10;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    b = 63;
                }
                break;
            case -389160068:
                if (str.equals("borderGradient")) {
                    b = 25;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    b = 8;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    b = 71;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    b = 0;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    b = 46;
                }
                break;
            case 3373707:
                if (str.equals(Common.System.NAME)) {
                    b = 1;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    b = 33;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    b = cc.k;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b = 34;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    b = 48;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    b = 35;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b = 39;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 2;
                }
                break;
            case 197402866:
                if (str.equals("borderFog")) {
                    b = 27;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    b = cc.l;
                }
                break;
            case 314070383:
                if (str.equals("animations")) {
                    b = 68;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    b = 57;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b = 23;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    b = 65;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b = 20;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b = 22;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    b = 12;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    b = 24;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b = 69;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    b = 29;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    b = 53;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    b = 7;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 36;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    b = 59;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    b = 67;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    b = 62;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    b = 55;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    b = 17;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    b = 30;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    b = 32;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = 19;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    b = 43;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    b = 44;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    b = 47;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    b = 54;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    b = 66;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    b = 49;
                }
                break;
            case 1824519034:
                if (str.equals("borderFlow")) {
                    b = 26;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    b = 4;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    b = 6;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    b = cc.m;
                }
                break;
        }
        switch (b) {
            case 0:
                this.w = str2;
                break;
            case 1:
                this.k = str2;
                break;
            case 2:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.m = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.m = -2.0f;
                } else {
                    this.m = zo.pr(this.hw, str2);
                }
                this.ok = true;
                break;
            case 3:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.g = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.g = -2.0f;
                } else {
                    this.g = zo.pr(this.hw, str2);
                }
                this.xk = true;
                break;
            case 4:
                if (TextUtils.equals("visible", str2)) {
                    this.od = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.od = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.od = 8;
                }
                this.c.setVisibility(this.od);
                vk vkVar = this.ag;
                if (vkVar != null) {
                    vkVar.pr(this.od);
                }
                break;
            case 5:
                this.ho = zo.pr(this.hw, str2);
                break;
            case 6:
                this.nt = zo.pr(this.hw, str2);
                this.ny = true;
                break;
            case 7:
                this.yb = zo.pr(this.hw, str2);
                this.fo = true;
                break;
            case 8:
                this.qa = zo.pr(this.hw, str2);
                this.z = true;
                break;
            case 9:
                this.lb = zo.pr(this.hw, str2);
                this.rc = true;
                break;
            case 10:
                this.b = zo.pr(this.hw, str2);
                this.y = true;
                break;
            case 11:
                this.iu = zo.pr(this.hw, str2);
                this.ww = true;
                break;
            case 12:
                this.ve = zo.pr(this.hw, str2);
                this.n = true;
                break;
            case 13:
                this.gz = zo.pr(this.hw, str2);
                this.e = true;
                break;
            case 14:
                this.nl = zo.pr(this.hw, str2);
                this.s = true;
                break;
            case 15:
                this.mw = !TextUtils.equals(str2, "unavailable");
                break;
            case 16:
            case 17:
                if (com.byazt.aa.pr.hn(str2)) {
                    this.rk = true;
                    this.mr = com.byazt.aa.pr.hw(str2);
                } else {
                    this.ls = com.byazt.aa.pr.pr(str2, 0);
                    this.rk = false;
                }
                break;
            case 18:
                this.q = com.byazt.aa.hn.pr(str2, true);
                break;
            case 19:
                this.ii = zo.pr(this.hw, str2);
                break;
            case 20:
                this.r = zo.pr(this.hw, str2);
                this.f = true;
                break;
            case 21:
                this.i = zo.pr(this.hw, str2);
                this.ie = true;
                break;
            case 22:
                this.nw = zo.pr(this.hw, str2);
                this.bm = true;
                break;
            case 23:
                this.hs = zo.pr(this.hw, str2);
                this.o = true;
                break;
            case 24:
                this.l = com.byazt.aa.pr.pr(str2);
                break;
            case 25:
                mw().pr(str2);
                break;
            case 26:
                mw().hw(str2);
                break;
            case 27:
                mw().pr(str2, this.hw);
                break;
            case 28:
                if (this.oj == null) {
                    this.oj = new com.byazt.njk.hn(this.hw);
                }
                this.oj.pr(str2);
                break;
            case 29:
                this.jn = zo.pr(this.hw, str2);
                break;
            case 30:
            case 31:
                this.er = str2;
                break;
            case 32:
                this.of = true;
                this.v = w(str2);
                break;
            case 33:
                float fPr = com.byazt.aa.hn.pr(str2, 0.0f);
                this.qi = fPr;
                if (fPr > 0.0f) {
                    this.qn = true;
                }
                break;
            case 34:
                this.sx = str2;
                break;
            case 35:
                this.vj = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 36:
                this.pr = true;
                this.qx = true;
                float[] fArrHw = com.byazt.iza.x.hw(str2, this.x);
                this.jw = zo.pr(this.hw, fArrHw[0]);
                this.wt = zo.pr(this.hw, fArrHw[1]);
                break;
            case 37:
                this.pr = true;
                this.jw = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 38:
                this.qx = true;
                this.wt = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 39:
                this.fe = true;
                this.ks = true;
                float[] fArrHw2 = com.byazt.iza.x.hw(str2, this.x);
                this.iy = fArrHw2[0];
                this.cr = fArrHw2[1];
                break;
            case 40:
                this.fe = true;
                this.iy = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 41:
                this.ks = true;
                this.cr = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 42:
                this.sr = true;
                this.j = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 43:
                this.wz = true;
                this.qo = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 44:
                this.xb = true;
                this.bh = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 45:
                this.p = true;
                this.ey = com.byazt.aa.hn.pr(str2, 1.0f);
                break;
            case 46:
                this.bg = com.byazt.aa.hw.pr(str2, (JSONObject) null);
                break;
            case 47:
                this.pj = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                hw(str, str2);
                break;
            case 62:
                this.lj = com.byazt.ch.pr.pr(str2, this);
                break;
            case 63:
                this.wm = str2;
                break;
            case 64:
                this.ag = vk.pr(this, str2);
                break;
            case 65:
                this.ku = k(str2);
                break;
            case 66:
                this.xg = com.byazt.aa.hn.pr(str2, false);
                break;
            case 67:
                try {
                    this.gu = new com.byazt.iza.pr(this.hw, this, com.byazt.iza.x.pr(new JSONObject(str2), this.x));
                } catch (JSONException e) {
                    return;
                }
                break;
            case 68:
                List<com.byazt.iza.hn> listPr = com.byazt.iza.x.pr(str2, this.x);
                if (listPr != null && !listPr.isEmpty()) {
                    this.d = new uc(this.hw, this, listPr);
                    break;
                }
                break;
            case 69:
                this.lv = str2;
                break;
            case 70:
                this.a = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 71:
                this.cz = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    private ImageView.ScaleType w(String str) {
        switch (str) {
            case "fit":
                this.v = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.v = ImageView.ScaleType.CENTER_CROP;
                break;
            case "center":
                this.v = ImageView.ScaleType.CENTER;
                break;
            default:
                this.v = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.v;
    }

    private boolean k(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    public void hw(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.na == null) {
            return;
        }
        try {
            int type = yb.pr(str).getType();
            nt ntVar = new nt();
            ntVar.pr(type);
            ntVar.pr(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (type == 3) {
                try {
                    this.jl = Float.parseFloat(com.byazt.tn.hw.pr(jSONObject.optString("shakeAmplitude"), this.x));
                } catch (NumberFormatException e) {
                    this.jl = 12.0f;
                }
            }
            lb lbVar = this.u;
            if (!(lbVar instanceof com.byazt.ef.hw)) {
                pr(type, jSONObject, ntVar);
            } else if (!((com.byazt.ef.hw) lbVar).pr()) {
                pr(type, jSONObject, ntVar);
            } else {
                ntVar.pr(jSONObject);
                this.na.put(Integer.valueOf(type), ntVar);
            }
        } catch (JSONException e2) {
        }
    }

    @Deprecated
    public void pr(int i, JSONObject jSONObject, nt ntVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(TrackAction.SUCCESS);
        if (jSONObjectOptJSONObject != null) {
            nt ntVar2 = new nt();
            ntVar2.pr(jSONObjectOptJSONObject);
            ntVar2.pr(this);
            ntVar.pr(ntVar2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(TrackAction.FAIL);
        if (jSONObjectOptJSONObject2 != null) {
            nt ntVar3 = new nt();
            ntVar3.pr(jSONObjectOptJSONObject2);
            ntVar3.pr(this);
            ntVar.hw(ntVar3);
        }
        ntVar.pr(jSONObject);
        this.na.put(Integer.valueOf(i), ntVar);
    }

    @Override // com.byazt.llk.c
    public void hn() {
        if (this.su != null && !this.gg) {
            this.gg = true;
        }
    }

    @Override // com.byazt.llk.c
    public void x() {
        if (this.su != null && !this.xi) {
            this.xi = true;
        }
    }

    @Override // com.byazt.llk.c
    public int[] pr(int i, int i2) {
        if (this.vj > 0.0f) {
            if (this.ok) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.vj;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                }
            } else if (this.xk) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.vj;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                }
            }
        }
        if (this.su != null && !this.kl) {
            this.kl = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.byazt.llk.c
    public void pr(int i, int i2, int i3, int i4) {
        if (this.su != null && !this.pp) {
            this.pp = true;
        }
    }

    @Override // com.byazt.llk.c
    public void pr(Canvas canvas, com.byazt.ch.c cVar) {
        m mVar = this.om;
        if (mVar != null) {
            mVar.pr(canvas, cVar);
        }
    }

    @Override // com.byazt.llk.c
    public void pr(Canvas canvas) {
        if (!(this instanceof pr)) {
            com.byazt.iza.pr prVar = this.gu;
            if (prVar != null) {
                prVar.pr(canvas);
            }
            uc ucVar = this.d;
            if (ucVar != null) {
                ucVar.pr(canvas);
            }
        }
    }

    @Override // com.byazt.llk.c
    public void hw(Canvas canvas) {
        if (this instanceof pr) {
            com.byazt.iza.pr prVar = this.gu;
            if (prVar != null) {
                prVar.hw(canvas);
            }
            uc ucVar = this.d;
            if (ucVar != null) {
                ucVar.hw(canvas);
            }
        }
    }

    @Override // com.byazt.llk.c
    public void hw(int i, int i2, int i3, int i4) {
        m mVar = this.om;
        if (mVar != null) {
            mVar.pr(i, i2);
        }
        com.byazt.iza.pr prVar = this.gu;
        if (prVar != null) {
            prVar.pr(i, i2);
        }
        uc ucVar = this.d;
        if (ucVar != null) {
            ucVar.pr(i, i2);
        }
    }

    public void pr(String str, Map<String, Object> map) {
    }

    @Override // com.byazt.ch.lb.hw
    public void pr(nt ntVar) {
        pr<ViewGroup> prVar;
        hn<T> hnVarX;
        if (ntVar == null || ntVar.hn() == null) {
            return;
        }
        x.pr prVar2 = this.tv;
        if (prVar2 != null) {
            prVar2.hw();
        }
        if (TextUtils.equals(ntVar.hn().optString("type"), "onDismiss")) {
            String strOptString = ntVar.hn().optString("nodeId");
            hw(8);
            this.fw = (pr) hw(this);
            if (!TextUtils.isEmpty(strOptString) && (prVar = this.fw) != null && (hnVarX = prVar.x(strOptString)) != null) {
                hnVarX.hw(8);
            }
        }
    }

    public void pr(com.byazt.mj.pr prVar) {
        this.yc = prVar;
    }

    public com.byazt.mj.pr qi() {
        return this.yc;
    }

    public hn hw(hn hnVar) {
        if (hnVar.y() == null && (hnVar instanceof pr)) {
            return hnVar;
        }
        return hw(hnVar.y());
    }

    public void qn() {
    }

    public void of() {
    }

    public void ii() {
        com.byazt.qi.c cVar = this.vv;
        if (cVar != null) {
            cVar.hw();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.qi.c cVar;
        lb lbVar;
        com.byazt.qi.hn hnVar;
        switch (motionEvent.getAction()) {
            case 0:
                qn();
                break;
            case 1:
            case 3:
                of();
                break;
        }
        a aVar = this.np;
        if (aVar != null) {
            aVar.pr(this, motionEvent);
        }
        if (pr(17) && motionEvent.getAction() == 0) {
            this.u.pr(this.na.get(17), this, this);
        }
        if (pr(1) && this.wo && (lbVar = this.u) != null && (hnVar = this.yj) != null) {
            return hnVar.pr(lbVar, this, motionEvent);
        }
        lb lbVar2 = this.u;
        if (lbVar2 != null && (cVar = this.vv) != null) {
            return cVar.pr(lbVar2, this, motionEvent, f());
        }
        vk vkVar = this.ag;
        if (vkVar != null) {
            return vkVar.pr(motionEvent);
        }
        return false;
    }

    public boolean i() {
        return this.vj > 0.0f;
    }

    public float r() {
        T t = this.c;
        if (t instanceof com.byazt.iza.fw) {
            return ((com.byazt.iza.fw) t).getRipple();
        }
        return 0.0f;
    }

    public float hs() {
        T t = this.c;
        if (t instanceof com.byazt.iza.fw) {
            return ((com.byazt.iza.fw) t).getShine();
        }
        return 0.0f;
    }

    public float nw() {
        T t = this.c;
        if (t instanceof com.byazt.iza.fw) {
            return ((com.byazt.iza.fw) t).getStretch();
        }
        return 0.0f;
    }

    public float ie() {
        T t = this.c;
        if (t instanceof com.byazt.iza.fw) {
            return ((com.byazt.iza.fw) t).getRubIn();
        }
        return 0.0f;
    }

    public void x(int i) {
        if (nl()) {
            T t = this.c;
            if (t instanceof hw) {
                ((hw) t).pr(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof hw) {
                ((hw) viewParent).pr(this.c, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = i;
        this.c.setLayoutParams(layoutParams);
    }

    public void c(int i) {
        if (nl()) {
            T t = this.c;
            if (t instanceof hw) {
                ((hw) t).hw(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof hw) {
                ((hw) viewParent).hw(this.c, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.height = i;
        this.c.setLayoutParams(layoutParams);
    }

    public boolean o() {
        return this.xg;
    }

    public List<com.byazt.xv.hw> aj(String str) {
        vk vkVar;
        if (TextUtils.isEmpty(str) || (vkVar = this.ag) == null) {
            return null;
        }
        return vkVar.hw(str);
    }

    public void pr(String str, Object... objArr) {
        List<com.byazt.xv.hw> listAj = aj(str);
        if (listAj == null || listAj.isEmpty()) {
            return;
        }
        for (com.byazt.xv.hw hwVar : listAj) {
            hwVar.pr(this.ag);
            hwVar.pr(objArr);
        }
    }

    public void pr(com.byazt.ch.uc ucVar) {
        vk vkVar = this.ag;
        if (vkVar != null) {
            vkVar.pr(ucVar);
        }
    }

    public com.byazt.iza.pr vk(String str) {
        com.byazt.iza.pr prVar = this.gu;
        if (prVar != null && TextUtils.equals(str, prVar.c())) {
            return this.gu;
        }
        uc ucVar = this.d;
        if (ucVar != null) {
            return ucVar.pr(str);
        }
        return null;
    }

    public void pr(fw fwVar) {
        this.eh = fwVar;
    }

    public boolean f() {
        return this.ou;
    }

    public void pr(ho hoVar) {
        vk vkVar = this.ag;
        if (vkVar != null) {
            vkVar.pr(hoVar);
        }
        this.xy = hoVar;
    }

    public void pr(com.byazt.dd.g gVar) {
        vk vkVar = this.ag;
        if (vkVar != null) {
            vkVar.pr(gVar);
        }
        this.cb = gVar;
    }

    public ho bm() {
        return this.xy;
    }

    public com.byazt.dd.g jn() {
        return this.cb;
    }

    public vk l() {
        return this.ag;
    }
}
