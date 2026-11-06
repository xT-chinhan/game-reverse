package com.bytedance.adsdk.ugeno.xr;

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
import com.anythink.core.express.b.a;
import com.bytedance.adsdk.ugeno.ah.ao;
import com.bytedance.adsdk.ugeno.ah.ch;
import com.bytedance.adsdk.ugeno.ah.hi;
import com.bytedance.adsdk.ugeno.ah.qv;
import com.bytedance.adsdk.ugeno.ah.u;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.x;
import com.bytedance.adsdk.ugeno.ah.xr.c;
import com.bytedance.adsdk.ugeno.ah.xr.d;
import com.bytedance.adsdk.ugeno.ah.xr.ka;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.ka.ny;
import com.bytedance.sdk.component.utils.sl;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import com.umeng.analytics.pro.ek;
import com.umeng.analytics.pro.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah<T extends View> implements View.OnTouchListener, com.bytedance.adsdk.ugeno.ah, ub.ms, ub.xr {

    @Deprecated
    private c a;
    protected ms<ViewGroup> ab;
    protected JSONObject ah;
    protected boolean am;
    protected float ao;
    protected String az;
    protected boolean b;
    protected float bz;
    protected ms<ViewGroup> c;
    private boolean cc;
    protected float ce;
    protected boolean ch;
    private boolean cj;
    protected float cv;
    protected JSONObject d;
    private com.bytedance.adsdk.ugeno.ah.ms di;
    private String dv;
    protected boolean e;
    protected ny ec;
    protected float eg;
    protected boolean f;
    private com.bytedance.adsdk.ugeno.ka.ms.ms fk;
    protected float fm;
    protected float g;
    private boolean gs;
    protected float gy;
    protected float h;
    protected String hi;
    protected boolean i;
    protected float ih;
    protected float il;
    private boolean ir;
    protected float j;
    private boolean jj;
    protected float jm;
    private boolean jr;
    protected boolean jw;
    protected float jy;
    protected boolean k;
    protected T ka;

    @Deprecated
    private ka kk;
    private boolean kl;
    protected boolean l;
    protected float le;
    protected float lm;
    protected ImageView.ScaleType m;

    @Deprecated
    private com.bytedance.adsdk.ugeno.ah.xr.xr mh;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f431ms;
    protected com.bytedance.adsdk.ugeno.c.ms.C0192ms n;
    private boolean nl;
    protected Map<Integer, zb> nn;
    private boolean nq;
    protected float nw;
    protected hi ny;
    protected boolean o;
    protected boolean of;
    protected float oh;
    private boolean oi;
    protected float op;
    private boolean oy;
    protected boolean p;
    protected boolean pc;

    @Deprecated
    private d.ms ph;
    private String pl;
    private boolean qd;
    private float qe;
    protected float qf;
    protected int qk;
    private boolean qo;
    protected float qr;
    protected float qv;
    private boolean r;
    protected boolean re;
    protected ViewGroup.LayoutParams rt;
    protected int s;
    protected boolean sa;
    private GradientDrawable si;
    protected float sk;
    protected String sl;
    private JSONObject so;
    protected float t;
    protected float ti;
    protected ao tk;
    protected boolean tz;
    protected float u;
    protected float ub;
    private boolean uc;
    protected int ul;
    protected String v;
    private boolean vf;
    protected float vl;
    protected float vm;
    private qv vx;
    protected com.bytedance.adsdk.ugeno.ms.ms vy;
    protected boolean w;
    private boolean wc;
    private boolean we;

    @Deprecated
    private com.bytedance.adsdk.ugeno.ah.xr.ah wp;
    private boolean wq;
    protected x.ms x;
    protected float xn;
    protected Context xr;
    protected float y;
    protected float yu;
    protected ub z;
    protected float zb;
    protected com.bytedance.adsdk.ugeno.ah.ny zd;
    protected boolean zf;
    private ch zx;

    protected void e() {
    }

    protected void lm() {
    }

    public T ms() {
        return null;
    }

    public ah(Context context) {
        this(context, null);
    }

    public ah(Context context, ms<ViewGroup> msVar) {
        this.zb = -2.0f;
        this.u = -2.0f;
        this.v = "solid";
        this.qk = 0;
        this.zf = true;
        this.sk = 0.0f;
        this.gy = 0.0f;
        this.vl = 0.0f;
        this.qr = 1.0f;
        this.ce = 1.0f;
        this.jm = 1.0f;
        this.bz = 0.0f;
        this.jy = 0.0f;
        this.j = 0.0f;
        this.ih = 0.0f;
        this.oh = 1.0f;
        this.cj = true;
        this.jj = true;
        this.uc = false;
        this.we = false;
        this.wc = false;
        this.qe = 12.0f;
        this.xr = context;
        this.c = msVar;
        this.nn = new HashMap();
        this.si = new GradientDrawable();
        this.ka = (T) ms();
    }

    public T ny() {
        return this.ka;
    }

    public void xr(JSONObject jSONObject) {
        this.d = jSONObject;
        hi();
    }

    public void ms(JSONObject jSONObject) {
        this.d = jSONObject;
        hi();
        JSONObject jSONObject2 = this.ah;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        ms<ViewGroup> msVar = this.c;
        ms.C0201ms c0201msX = msVar instanceof ms ? msVar.x() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(this.ah.optString(next), jSONObject);
            ms(next, strMs);
            if (c0201msX != null) {
                c0201msX.ms(this.xr, next, strMs);
            }
        }
        if (c0201msX != null) {
            ms(c0201msX.ms());
        }
        if (this.so == null || this.d == null) {
            return;
        }
        try {
            if (cv()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("i18n", this.so);
                this.d.put("xNode", jSONObject3);
                return;
            }
            this.d.put("i18n", this.so);
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    public JSONObject ch() {
        return this.d;
    }

    public void hi() {
        this.wc = this.d.optBoolean("gesture_through_enable", false);
    }

    public void xr() {
        i();
        sl();
        xr(this.qk);
        ab();
        x();
        ny nyVar = this.ec;
        if (nyVar != null) {
            nyVar.ms();
            this.ec.xr();
            this.ec.ah();
        }
        this.ka.setOnTouchListener(this);
        sa();
        ViewGroup viewGroup = (ViewGroup) this.ka.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.cj);
        }
        com.bytedance.adsdk.ugeno.ms.ms msVar = this.vy;
        if (msVar != null) {
            msVar.ah();
        }
        if (this.z == null || !ms(22)) {
            return;
        }
        this.z.ms(this.nn.get(22), this, this);
    }

    protected void sl() {
        this.ka.setPadding((int) (this.p ? this.op : this.yu), (int) (this.jw ? this.cv : this.yu), (int) (this.pc ? this.le : this.yu), (int) (this.f ? this.g : this.yu));
    }

    private void ab() {
        if (this.f431ms) {
            this.ka.setTranslationX(this.gy);
        }
        if (this.vf) {
            this.ka.setTranslationY(this.vl);
        }
        if (this.kl) {
            this.ka.setScaleX(this.ce);
        }
        if (this.gs) {
            this.ka.setScaleY(this.jm);
        }
        if (this.r) {
            this.ka.setRotation(this.bz);
        }
        if (this.nl) {
            this.ka.setRotationX(this.jy);
        }
        if (this.qo) {
            this.ka.setRotationY(-this.j);
        }
        if (this.cc) {
            this.ka.setAlpha(this.oh);
        }
        float f = this.ih;
        if (f != 0.0f) {
            this.ka.setRotation(f);
        }
        if (this.r || this.nl || this.qo) {
            this.ka.setCameraDistance(10000.0f);
        }
    }

    public float zb() {
        return this.gy;
    }

    public float u() {
        return this.vl;
    }

    public float ub() {
        return this.ce;
    }

    public float ao() {
        return this.jm;
    }

    public float h() {
        return this.jy;
    }

    public float qv() {
        return this.j;
    }

    public float y() {
        return this.ih;
    }

    public float t() {
        return this.oh;
    }

    public float nw() {
        return this.eg;
    }

    @Deprecated
    private void x() {
        d dVarD;
        this.ka.setVisibility(this.qk);
        float f = this.ih;
        if (f != 0.0f) {
            this.ka.setRotation(f);
        }
        x.ms msVar = this.x;
        if (msVar != null && TextUtils.isEmpty(msVar.xr())) {
            this.ka.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.xr.ah.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ah.this.zd == null || !ah.this.jj) {
                        return;
                    }
                    ah.this.zd.ms(ah.this);
                }
            });
        } else if (ms(1) && !this.oy) {
            this.ka.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.xr.ah.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ah.this.z == null || !ah.this.jj) {
                        return;
                    }
                    ub ubVar = ah.this.z;
                    zb zbVar = ah.this.nn.get(1);
                    ah ahVar = ah.this;
                    ubVar.ms(zbVar, ahVar, ahVar);
                }
            });
        }
        if (this.z != null && ms(4)) {
            if (ms(1)) {
                this.oi = true;
                this.kk = new ka(this.xr, this.nn.get(4), this.nn.get(1), this.oi, l());
            } else {
                this.kk = new ka(this.xr, this.nn.get(4), this.oi, l());
            }
        }
        if (this.z != null && ms(1) && this.oy) {
            this.wp = new com.bytedance.adsdk.ugeno.ah.xr.ah(this.xr, this.nn.get(1));
        }
        am();
        if (this.z != null && ms(3) && (dVarD = com.bytedance.adsdk.ugeno.d.ms().d()) != null) {
            d.ms msVar2 = this.ph;
            if (msVar2 != null) {
                msVar2.xr();
            }
            d.ms msVarMs = dVarD.ms(this.xr, this);
            this.ph = msVarMs;
            msVarMs.ms(this.qe);
            this.ph.ms();
            this.ph.ms(new d.xr() { // from class: com.bytedance.adsdk.ugeno.xr.ah.3
                @Override // com.bytedance.adsdk.ugeno.ah.xr.d.xr
                public void ms(int i) {
                    ah.this.ph.xr();
                    if (ah.this.ka.isShown() && ah.this.z != null && i == 1) {
                        ub ubVar = ah.this.z;
                        zb zbVar = ah.this.nn.get(3);
                        ah ahVar = ah.this;
                        ubVar.ms(zbVar, ahVar, ahVar);
                    }
                }
            });
        }
        if (this.z != null && ms(9)) {
            c cVar = new c(this.xr, this.nn.get(9), this);
            this.a = cVar;
            cVar.ms(this.z);
        }
        if (ms(10)) {
            com.bytedance.adsdk.ugeno.ah.xr.xr xrVar = new com.bytedance.adsdk.ugeno.ah.xr.xr(this.xr, this.nn.get(10), this);
            this.mh = xrVar;
            xrVar.ms(this.z);
        }
    }

    private void am() {
        zb zbVar;
        if (this.z == null || !ms(18) || (zbVar = this.nn.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectAh = zbVar.ah();
        if (jSONObjectAh != null) {
            try {
                jSONObjectAh.put("rotateZ", com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectAh.optString("rotateZ"), this.d));
            } catch (JSONException unused) {
            }
        }
        this.z.ms(zbVar, this, this);
    }

    private void sa() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hi);
        this.ka.setContentDescription(sb);
    }

    public void ms(qv qvVar) {
        this.vx = qvVar;
    }

    public void ka() {
        if (this.di != null) {
            ch chVar = new ch(this.ka, this.di);
            this.zx = chVar;
            chVar.ms();
        }
        com.bytedance.adsdk.ugeno.ms.ms msVar = this.vy;
        if (msVar != null) {
            msVar.ms();
        }
        qv qvVar = this.vx;
        if (qvVar != null) {
            qvVar.d();
        }
        ny nyVar = this.ec;
        if (nyVar != null) {
            nyVar.d();
        }
        if (this.mh != null && ms(10)) {
            this.mh.ms();
        }
        if (this.a == null || !ms(9)) {
            return;
        }
        this.a.ms();
    }

    public void c() {
        ch chVar = this.zx;
        if (chVar != null) {
            chVar.xr();
        }
        com.bytedance.adsdk.ugeno.ms.ms msVar = this.vy;
        if (msVar != null) {
            msVar.xr();
        }
        qv qvVar = this.vx;
        if (qvVar != null) {
            qvVar.ka();
        }
        d.ms msVar2 = this.ph;
        if (msVar2 != null) {
            msVar2.xr();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah
    public void ms(boolean z) {
        qv qvVar = this.vx;
        if (qvVar != null) {
            qvVar.ms(z);
        }
    }

    public ub b() {
        return this.z;
    }

    public void xr(boolean z) {
        this.oy = z;
    }

    public boolean ms(int i) {
        Map<Integer, zb> map = this.nn;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void xr(int i) {
        ViewParent viewParent = (ViewGroup) this.ka.getParent();
        if (viewParent instanceof xr) {
            ((xr) viewParent).ah(this.ka, i);
        } else {
            this.ka.setVisibility(i);
        }
    }

    public void ms(ao aoVar) {
        this.tk = aoVar;
    }

    public void ms(ub ubVar) {
        this.z = ubVar;
    }

    public void ah(JSONObject jSONObject) {
        this.ah = jSONObject;
    }

    public JSONObject re() {
        return this.ah;
    }

    protected void i() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapMs;
        if (TextUtils.isEmpty(this.az)) {
            if (this.o) {
                ms(this.n);
                return;
            } else {
                this.si.setColor(this.ul);
                ah(this.ul);
                return;
            }
        }
        if (this.az.startsWith("local://")) {
            String strReplace = this.az.replace("local://", "");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = this.e ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.xr.getResources().openRawResource(com.bytedance.adsdk.ugeno.c.d.ms(this.xr, strReplace)), null, options);
                if (this.e && (bitmapMs = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, bitmapDecodeStream, (int) this.lm)) != null) {
                    bitmapDrawable = new BitmapDrawable(this.xr.getResources(), bitmapMs);
                } else {
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.xr.getResources(), bitmapDecodeStream);
                    bitmapDrawable = bitmapDrawable2;
                }
                ms(bitmapDrawable);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        w();
    }

    protected void w() {
        com.bytedance.adsdk.ugeno.d.ms().xr().ms(this.ny, this.az, new com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms() { // from class: com.bytedance.adsdk.ugeno.xr.ah.4
            @Override // com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms
            public void ms(final Bitmap bitmap) {
                if (bitmap != null) {
                    if (ah.this.e) {
                        final Bitmap bitmapMs = com.bytedance.adsdk.ugeno.c.x.ms(ah.this.xr, bitmap, (int) ah.this.lm);
                        if (bitmapMs != null) {
                            com.bytedance.adsdk.ugeno.c.x.ms(new Runnable() { // from class: com.bytedance.adsdk.ugeno.xr.ah.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ah.this.ms(new BitmapDrawable(bitmapMs));
                                }
                            });
                            return;
                        }
                        return;
                    }
                    com.bytedance.adsdk.ugeno.c.x.ms(new Runnable() { // from class: com.bytedance.adsdk.ugeno.xr.ah.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ah.this.ms(new BitmapDrawable(bitmap));
                        }
                    });
                }
            }
        });
    }

    protected void ms(com.bytedance.adsdk.ugeno.c.ms.C0192ms c0192ms) {
        if (c0192ms == null) {
            return;
        }
        this.si.setShape(0);
        if (c0192ms != null) {
            this.si.setOrientation(c0192ms.f349ms);
            if (Build.VERSION.SDK_INT >= 29) {
                this.si.setColors(c0192ms.xr, c0192ms.ah);
            } else {
                this.si.setColors(c0192ms.xr);
            }
        }
        ti();
        tz();
        this.ka.setBackground(this.si);
    }

    protected void ah(int i) {
        this.si.setShape(0);
        this.si.setColor(i);
        ti();
        tz();
        this.ka.setBackground(this.si);
    }

    private void tz() {
        if (TextUtils.equals("dashed", this.v)) {
            GradientDrawable gradientDrawable = this.si;
            float f = this.ti;
            gradientDrawable.setStroke((int) f, this.s, 3.0f * f, f);
        } else {
            if (TextUtils.equals("dotted", this.v)) {
                GradientDrawable gradientDrawable2 = this.si;
                float f2 = this.ti;
                gradientDrawable2.setStroke((int) f2, this.s, f2 / 2.0f, f2);
                return;
            }
            this.si.setStroke((int) this.ti, this.s);
        }
    }

    private void ti() {
        float f = this.l ? this.fm : this.eg;
        float f2 = this.am ? this.il : this.eg;
        float f3 = this.sa ? this.xn : this.eg;
        float f4 = this.tz ? this.qf : this.eg;
        this.si.setCornerRadii(new float[]{f, f, f2, f2, f4, f4, f3, f3});
    }

    protected void ms(Drawable drawable) {
        this.ka.setBackground(drawable);
    }

    public void ms(ViewGroup.LayoutParams layoutParams) {
        T t = this.ka;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.rt = layoutParams;
    }

    public ViewGroup.LayoutParams yu() {
        return this.rt;
    }

    public void op() {
        if (this.ka != null) {
            ms(this.rt);
            d((int) this.zb);
            ka((int) this.u);
        }
    }

    public void ms(x.ms msVar) {
        this.x = msVar;
    }

    public x.ms le() {
        return this.x;
    }

    public ah<T> ah(String str) {
        return ms(str);
    }

    protected ah<T> ms(String str) {
        if (TextUtils.isEmpty(this.hi) || !TextUtils.equals(this.hi, str)) {
            return null;
        }
        return this;
    }

    public ah<T> d(String str) {
        return xr(str);
    }

    protected ah<T> xr(String str) {
        if (TextUtils.isEmpty(this.sl) || !TextUtils.equals(this.sl, str)) {
            return null;
        }
        return this;
    }

    public void ah(boolean z) {
        this.ch = z;
    }

    public boolean cv() {
        return this.ch;
    }

    public ms g() {
        return this.c;
    }

    public void ms(ms msVar) {
        this.c = msVar;
    }

    public void ka(String str) {
        this.hi = str;
    }

    public String of() {
        return this.hi;
    }

    public void c(String str) {
        this.sl = str;
    }

    public String p() {
        return this.sl;
    }

    public int pc() {
        return (int) this.zb;
    }

    public int jw() {
        return (int) this.u;
    }

    public hi f() {
        return this.ny;
    }

    public void ms(hi hiVar) {
        this.ny = hiVar;
    }

    public boolean ul() {
        return this.zf;
    }

    public void ms(com.bytedance.adsdk.ugeno.ah.ny nyVar) {
        this.zd = nyVar;
    }

    public int az() {
        return this.ul;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void ms(String str, String str2) {
        ms<ViewGroup> msVar;
        ms<ViewGroup> msVar2;
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
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
                if (str.equals(g.ax)) {
                    b = 12;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b = ek.k;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b = ek.l;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b = ek.m;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    b = ek.n;
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
            case -806339567:
                if (str.equals("padding")) {
                    b = 23;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    b = 24;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    b = 25;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    b = 26;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    b = 27;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    b = 28;
                }
                break;
            case 3373707:
                if (str.equals(Common.System.NAME)) {
                    b = 29;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    b = 30;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    b = 31;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b = 32;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    b = 33;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    b = 34;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b = 35;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 36;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    b = 37;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    b = 38;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b = 39;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    b = 40;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b = 41;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b = 42;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    b = 43;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    b = 44;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b = 45;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    b = 46;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    b = 47;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    b = 48;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 49;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    b = 50;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    b = 51;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    b = 52;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    b = 53;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    b = 54;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    b = 55;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    b = 56;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = 57;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    b = 58;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    b = 59;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    b = 60;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    b = 61;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    b = 62;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    b = com.anythink.core.common.s.a.c.c;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    b = com.anythink.core.common.s.a.c.b;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    b = 65;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    b = 66;
                }
                break;
        }
        switch (b) {
            case 0:
                this.jj = com.bytedance.adsdk.ugeno.c.ah.ms(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 18:
            case 33:
            case 38:
            case 47:
            case 50:
            case 53:
            case 61:
            case 63:
                xr(str, str2);
                break;
            case 2:
                this.f431ms = true;
                this.gy = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f));
                break;
            case 3:
                this.vf = true;
                this.vl = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f));
                break;
            case 4:
                this.op = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.p = true;
                break;
            case 5:
                this.t = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 11:
            case 54:
                if (com.bytedance.adsdk.ugeno.c.ms.ah(str2)) {
                    this.o = true;
                    this.n = com.bytedance.adsdk.ugeno.c.ms.xr(str2);
                } else {
                    this.ul = com.bytedance.adsdk.ugeno.c.ms.ms(str2, 0);
                    this.o = false;
                }
                break;
            case 12:
                this.ec = ny.ms(this, str2);
                break;
            case 13:
                this.cc = true;
                this.oh = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 1.0f);
                break;
            case 14:
                this.fm = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.l = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    if (cv() && (msVar = this.c) != null && msVar.jw() == -2) {
                        this.u = -2.0f;
                    } else {
                        this.u = -1.0f;
                    }
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.u = -2.0f;
                } else {
                    this.u = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                }
                this.we = true;
                break;
            case 16:
                this.ub = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                break;
            case 17:
                this.qv = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.i = true;
                break;
            case 19:
            case 55:
                this.az = str2;
                break;
            case 20:
                this.r = true;
                this.bz = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 21:
                this.kl = true;
                this.ce = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 22:
                this.gs = true;
                this.jm = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 23:
                this.yu = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.of = true;
                break;
            case 24:
                this.dv = str2;
                break;
            case 25:
                this.y = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.w = true;
                break;
            case 26:
                this.nw = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 27:
                this.hi = str2;
                break;
            case 28:
                this.so = com.bytedance.adsdk.ugeno.c.xr.ms(str2, (JSONObject) null);
                break;
            case 29:
                this.sl = str2;
                break;
            case 30:
                float fMs = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                this.lm = fMs;
                if (fMs > 0.0f) {
                    this.e = true;
                }
                break;
            case 31:
                this.cv = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.jw = true;
                break;
            case 32:
                this.pl = str2;
                break;
            case 34:
                this.vm = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 35:
                this.kl = true;
                this.gs = true;
                float[] fArrAh = com.bytedance.adsdk.ugeno.ms.ah.ah(str2);
                this.ce = fArrAh[0];
                this.jm = fArrAh[1];
                break;
            case 36:
                if (TextUtils.equals(str2, "match_parent")) {
                    if (cv() && (msVar2 = this.c) != null && msVar2.pc() == -2) {
                        this.zb = -2.0f;
                    } else {
                        this.zb = -1.0f;
                    }
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.zb = -2.0f;
                } else {
                    this.zb = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                }
                this.uc = true;
                break;
            case 37:
                this.g = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.f = true;
                break;
            case 39:
                this.il = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.am = true;
                break;
            case 40:
                this.cj = ny(str2);
                break;
            case 41:
                this.xn = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.sa = true;
                break;
            case 42:
                this.qf = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.tz = true;
                break;
            case 43:
                this.le = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.pc = true;
                break;
            case 44:
                this.s = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case 45:
                this.v = str2;
                break;
            case 46:
                this.ti = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                break;
            case 48:
                this.h = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.re = true;
                break;
            case 49:
                this.f431ms = true;
                this.vf = true;
                float[] fArrAh2 = com.bytedance.adsdk.ugeno.ms.ah.ah(str2);
                this.gy = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, fArrAh2[0]);
                this.vl = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, fArrAh2[1]);
                break;
            case 51:
                try {
                    this.vy = new com.bytedance.adsdk.ugeno.ms.ms(this.xr, this, com.bytedance.adsdk.ugeno.ms.ah.ms(new JSONObject(str2)));
                } catch (JSONException e) {
                    sl.ms(e);
                    return;
                }
                break;
            case 52:
                this.di = com.bytedance.adsdk.ugeno.ah.ms.ms(str2, this);
                break;
            case 56:
                this.k = true;
                this.m = x(str2);
                break;
            case 57:
                this.eg = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                break;
            case 58:
                this.nl = true;
                this.jy = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 59:
                this.qo = true;
                this.j = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 60:
                this.ih = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 62:
                this.wq = com.bytedance.adsdk.ugeno.c.ah.ms(str2, false);
                break;
            case 64:
                if (TextUtils.equals("visible", str2)) {
                    this.qk = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.qk = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals(a.h, str2)) {
                    this.qk = 8;
                }
                this.ka.setVisibility(this.qk);
                break;
            case 65:
                this.ao = com.bytedance.adsdk.ugeno.c.x.ms(this.xr, str2);
                this.b = true;
                break;
            case 66:
                this.zf = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    private ImageView.ScaleType x(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.m = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.m = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.m = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.m = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.m;
    }

    private boolean ny(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, a.h);
    }

    protected void xr(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.nn == null) {
            return;
        }
        try {
            int type = u.ms(str).getType();
            zb zbVar = new zb();
            zbVar.ms(type);
            zbVar.ms(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (type == 3) {
                try {
                    this.qe = Float.parseFloat(com.bytedance.adsdk.ugeno.d.xr.ms(jSONObject.optString("shakeAmplitude"), this.d));
                } catch (NumberFormatException unused) {
                    this.qe = 12.0f;
                }
            }
            ub ubVar = this.z;
            if (!(ubVar instanceof com.bytedance.adsdk.ugeno.ah.ms.xr)) {
                ms(type, jSONObject, zbVar);
            } else if (!((com.bytedance.adsdk.ugeno.ah.ms.xr) ubVar).ms()) {
                ms(type, jSONObject, zbVar);
            } else {
                zbVar.ms(jSONObject);
                this.nn.put(Integer.valueOf(type), zbVar);
            }
        } catch (JSONException unused2) {
        }
    }

    @Deprecated
    protected void ms(int i, JSONObject jSONObject, zb zbVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
        if (jSONObjectOptJSONObject != null) {
            zb zbVar2 = new zb();
            zbVar2.ms(jSONObjectOptJSONObject);
            zbVar2.ms(this);
            zbVar.ms(zbVar2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(TrackAction.FAIL);
        if (jSONObjectOptJSONObject2 != null) {
            zb zbVar3 = new zb();
            zbVar3.ms(jSONObjectOptJSONObject2);
            zbVar3.ms(this);
            zbVar.xr(zbVar3);
        }
        zbVar.ms(jSONObject);
        this.nn.put(Integer.valueOf(i), zbVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ah
    public void ah() {
        if (this.vx == null || this.nq) {
            return;
        }
        this.nq = true;
    }

    @Override // com.bytedance.adsdk.ugeno.ah
    public void d() {
        if (this.vx == null || this.qd) {
            return;
        }
        this.qd = true;
    }

    @Override // com.bytedance.adsdk.ugeno.ah
    public int[] ms(int i, int i2) {
        if (this.vm > 0.0f) {
            if (this.uc) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.vm;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                }
            } else if (this.we) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.vm;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                }
            }
        }
        if (this.vx != null && !this.jr) {
            this.jr = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.bytedance.adsdk.ugeno.ah
    public void ms(int i, int i2, int i3, int i4) {
        if (this.vx == null || this.ir) {
            return;
        }
        this.ir = true;
    }

    @Override // com.bytedance.adsdk.ugeno.ah
    public void ms(Canvas canvas, com.bytedance.adsdk.ugeno.ah.ka kaVar) {
        ch chVar = this.zx;
        if (chVar != null) {
            chVar.ms(canvas, kaVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah
    public void ms(Canvas canvas) {
        com.bytedance.adsdk.ugeno.ms.ms msVar = this.vy;
        if (msVar != null) {
            msVar.ms(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah
    public void xr(int i, int i2, int i3, int i4) {
        ch chVar = this.zx;
        if (chVar != null) {
            chVar.ms(i, i2);
        }
        com.bytedance.adsdk.ugeno.ms.ms msVar = this.vy;
        if (msVar != null) {
            msVar.ms(i, i2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub.xr
    public void ms(zb zbVar) {
        ms<ViewGroup> msVar;
        ah<T> ahVarAh;
        if (zbVar == null || zbVar.ah() == null) {
            return;
        }
        d.ms msVar2 = this.ph;
        if (msVar2 != null) {
            msVar2.xr();
        }
        if (TextUtils.equals(zbVar.ah().optString("type"), "onDismiss")) {
            String strOptString = zbVar.ah().optString("nodeId");
            xr(8);
            this.ab = (ms) xr(this);
            if (TextUtils.isEmpty(strOptString) || (msVar = this.ab) == null || (ahVarAh = msVar.ah(strOptString)) == null) {
                return;
            }
            ahVarAh.xr(8);
        }
    }

    public void ms(com.bytedance.adsdk.ugeno.ka.ms.ms msVar) {
        this.fk = msVar;
    }

    public com.bytedance.adsdk.ugeno.ka.ms.ms m() {
        return this.fk;
    }

    public ah xr(ah ahVar) {
        return (ahVar.g() == null && (ahVar instanceof ms)) ? ahVar : xr(ahVar.g());
    }

    public void k() {
        ka kaVar = this.kk;
        if (kaVar != null) {
            kaVar.ms();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ka kaVar;
        ub ubVar;
        com.bytedance.adsdk.ugeno.ah.xr.ah ahVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            lm();
        } else if (action == 1 || action == 3) {
            e();
        }
        ao aoVar = this.tk;
        if (aoVar != null) {
            aoVar.ms(this, motionEvent);
        }
        if (ms(17) && motionEvent.getAction() == 0) {
            this.z.ms(this.nn.get(17), this, this);
        }
        if (ms(1) && this.oy && (ubVar = this.z) != null && (ahVar = this.wp) != null) {
            return ahVar.ms(ubVar, this, motionEvent);
        }
        ub ubVar2 = this.z;
        if (ubVar2 != null && (kaVar = this.kk) != null) {
            return kaVar.ms(ubVar2, this, motionEvent, l());
        }
        ny nyVar = this.ec;
        if (nyVar != null) {
            return nyVar.ms(motionEvent);
        }
        return false;
    }

    public float eg() {
        T t = this.ka;
        if (t instanceof com.bytedance.adsdk.ugeno.ms.ka) {
            return ((com.bytedance.adsdk.ugeno.ms.ka) t).getRipple();
        }
        return 0.0f;
    }

    public float fm() {
        T t = this.ka;
        if (t instanceof com.bytedance.adsdk.ugeno.ms.ka) {
            return ((com.bytedance.adsdk.ugeno.ms.ka) t).getShine();
        }
        return 0.0f;
    }

    public float xn() {
        T t = this.ka;
        if (t instanceof com.bytedance.adsdk.ugeno.ms.ka) {
            return ((com.bytedance.adsdk.ugeno.ms.ka) t).getStretch();
        }
        return 0.0f;
    }

    public float il() {
        T t = this.ka;
        if (t instanceof com.bytedance.adsdk.ugeno.ms.ka) {
            return ((com.bytedance.adsdk.ugeno.ms.ka) t).getRubIn();
        }
        return 0.0f;
    }

    public void d(int i) {
        if (cv()) {
            T t = this.ka;
            if (t instanceof xr) {
                ((xr) t).ms(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof xr) {
                ((xr) viewParent).ms(this.ka, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.ka.getLayoutParams();
        layoutParams.width = i;
        this.ka.setLayoutParams(layoutParams);
    }

    public void ka(int i) {
        if (cv()) {
            T t = this.ka;
            if (t instanceof xr) {
                ((xr) t).xr(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof xr) {
                ((xr) viewParent).xr(this.ka, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.ka.getLayoutParams();
        layoutParams.height = i;
        this.ka.setLayoutParams(layoutParams);
    }

    public boolean qf() {
        return this.wq;
    }

    public com.bytedance.adsdk.ugeno.ka.ah.ms ab(String str) {
        ny nyVar;
        if (TextUtils.isEmpty(str) || (nyVar = this.ec) == null) {
            return null;
        }
        return nyVar.ms(str);
    }

    public void ms(String str, Object... objArr) {
        com.bytedance.adsdk.ugeno.ka.ah.ms msVarAb = ab(str);
        if (msVarAb == null) {
            return;
        }
        msVarAb.ms(this.ec);
        msVarAb.ms(objArr);
    }

    public void ms(com.bytedance.adsdk.ugeno.ah.c cVar) {
        ny nyVar = this.ec;
        if (nyVar != null) {
            nyVar.ms(cVar);
        }
    }

    public boolean l() {
        return this.wc;
    }
}
