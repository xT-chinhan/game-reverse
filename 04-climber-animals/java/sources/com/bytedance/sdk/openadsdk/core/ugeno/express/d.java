package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.ah.ab;
import com.bytedance.adsdk.ugeno.ah.ao;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.p;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.x;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ao, ub, com.bytedance.sdk.component.adexpress.dynamic.d, com.bytedance.sdk.component.adexpress.xr.d<View> {
    protected xr ab;
    protected com.bytedance.adsdk.ugeno.xr.ah<View> ah;
    private boolean b;
    protected lm c;
    protected x ch;
    protected JSONObject d;
    protected b h;
    protected u hi;
    protected JSONObject ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected sl f3502ms;
    private String nw;
    protected com.bytedance.sdk.component.adexpress.xr.x ny;
    protected com.bytedance.sdk.openadsdk.core.ugeno.ch.ms qv;
    private String t;
    protected com.bytedance.adsdk.ugeno.xr.ah u;
    protected com.bytedance.adsdk.ugeno.xr.ah ub;
    protected UGTimerContainer x;
    protected Context xr;
    private List<com.bytedance.adsdk.ugeno.xr.ah<View>> y;
    protected WeakReference<ViewGroup> zb;
    protected hi sl = new hi();
    protected AtomicBoolean ao = new AtomicBoolean(false);

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, com.bytedance.adsdk.ugeno.ka.c.ms msVar) {
    }

    public d(Context context, lm lmVar, xr xrVar, ViewGroup viewGroup) {
        JSONObject jSONObjectOptJSONObject;
        this.b = false;
        this.xr = context;
        this.f3502ms = new sl(context);
        this.c = lmVar;
        this.ab = xrVar;
        this.x = new UGTimerContainer(context);
        this.zb = new WeakReference<>(viewGroup);
        JSONObject jSONObjectMs = ms();
        this.d = jSONObjectMs;
        if (lmVar != null && jSONObjectMs != null && (jSONObjectOptJSONObject = jSONObjectMs.optJSONObject("event_template")) != null) {
            this.b = true;
            com.bytedance.sdk.component.hi.ah.xr.INSTANCE.ms(jSONObjectOptJSONObject);
        }
        if (com.bytedance.sdk.openadsdk.ka.ms.d(lmVar)) {
            this.f3502ms.ms(new ab() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.d.1
                @Override // com.bytedance.adsdk.ugeno.ah.ab
                public void ms(com.bytedance.adsdk.ugeno.ah.x.ms msVar) {
                    com.bytedance.sdk.openadsdk.ka.ms.ms(true, msVar);
                }

                @Override // com.bytedance.adsdk.ugeno.ah.ab
                public void xr(com.bytedance.adsdk.ugeno.ah.x.ms msVar) {
                    com.bytedance.sdk.openadsdk.ka.ms.ms(false, msVar);
                }
            });
        }
    }

    public void ms(com.bytedance.sdk.component.adexpress.xr.x xVar) {
        this.ny = xVar;
    }

    public void ms(x xVar) {
        this.ch = xVar;
    }

    public void xr() {
        List<com.bytedance.adsdk.ugeno.xr.ah<View>> list = this.y;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.xr.ah<View>> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    private void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar, List<com.bytedance.adsdk.ugeno.xr.ah<View>> list) {
        if (ahVar instanceof com.bytedance.adsdk.ugeno.xr.ms) {
            if (ahVar.ms(4)) {
                list.add(ahVar);
            }
            List<com.bytedance.adsdk.ugeno.xr.ah<View>> listAb = ((com.bytedance.adsdk.ugeno.xr.ms) ahVar).ab();
            if (listAb == null || listAb.size() == 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.xr.ah<View>> it = listAb.iterator();
            while (it.hasNext()) {
                ms(it.next(), list);
            }
            return;
        }
        if (ahVar == null || !ahVar.ms(4)) {
            return;
        }
        list.add(ahVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    public void ms(com.bytedance.sdk.component.adexpress.xr.ab abVar) {
        this.ab.pc().ms();
        this.d = ms();
        JSONObject jSONObjectCh = ch();
        this.ka = jSONObjectCh;
        if (this.d == null || jSONObjectCh == null) {
            abVar.ms(133, (String) null);
            return;
        }
        xr(abVar);
        if (this.ah != null) {
            ah ahVar = new ah();
            this.hi = ahVar;
            ahVar.ms(true);
            this.hi.ms(ah());
            com.bytedance.adsdk.ugeno.xr.ah ahVarKa = ka();
            this.u = ahVarKa;
            if (ahVarKa != null && (ahVarKa instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.d.ms)) {
                ((ah) this.hi).ms((FrameLayout) ahVarKa.ny());
            }
            com.bytedance.adsdk.ugeno.xr.ah ahVarC = c();
            this.ub = ahVarC;
            if (ahVarC != null && (ahVarC instanceof com.bytedance.adsdk.ugeno.widget.frame.ms)) {
                ((ah) this.hi).xr((FrameLayout) ahVarC.ny());
            }
            u uVar = this.hi;
            if (uVar instanceof ah) {
                ((ah) uVar).ms(this.qv);
            }
            this.x.setTimerHolder(this.qv);
            int iPc = this.ah.pc();
            int iJw = this.ah.jw();
            ArrayList arrayList = new ArrayList();
            this.y = arrayList;
            ms(this.ah, arrayList);
            View viewNy = this.ah.ny();
            ViewGroup viewGroup = (ViewGroup) viewNy.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(viewNy);
            }
            this.x.addView(this.ah.ny(), new FrameLayout.LayoutParams(iPc, iJw));
            float fG = this.ab.g();
            float fOf = this.ab.of();
            float fAh = ul.ah(this.xr, fG);
            float fAh2 = ul.ah(this.xr, fOf);
            int iD = ul.d(this.xr);
            int iNy = (int) (ul.ny(this.xr) + ul.hi(this.xr));
            float f = iD;
            if (fAh > f) {
                fAh = f;
            }
            float f2 = iNy;
            if (fAh2 > f2) {
                fAh2 = f2;
            }
            if (fOf <= 0.0f) {
                this.x.setLayoutParams(new FrameLayout.LayoutParams((int) fAh, -2));
            } else {
                this.x.setLayoutParams(new FrameLayout.LayoutParams((int) fAh, (int) fAh2));
            }
            if (fOf <= 0.0f) {
                this.x.measure(View.MeasureSpec.makeMeasureSpec((int) fAh, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                int iD2 = ul.d(this.xr, this.x.getMeasuredWidth());
                int iD3 = ul.d(this.xr, this.x.getMeasuredHeight());
                this.hi.ms(iD2);
                this.hi.xr(iD3);
            } else {
                this.hi.ms(ul.d(this.xr, fAh));
                this.hi.xr(ul.d(this.xr, fAh2));
            }
            if (this.ao.get()) {
                abVar.ms(137, (String) null);
                return;
            } else {
                abVar.ms(this.x, this.hi);
                return;
            }
        }
        abVar.ms(138, (String) null);
    }

    public float[] d() {
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar = this.ah;
        if (ahVar == null) {
            return null;
        }
        ub.xr xrVarD = ahVar.d("InteractContainerView");
        if (xrVarD instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hi) {
            return ((com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hi) xrVarD).sa();
        }
        return null;
    }

    protected com.bytedance.adsdk.ugeno.xr.ah ka() {
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar = this.ah;
        if (ahVar == null) {
            return null;
        }
        return ahVar.d("VideoPlaceholder");
    }

    protected com.bytedance.adsdk.ugeno.xr.ah c() {
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar = this.ah;
        if (ahVar == null) {
            return null;
        }
        return ahVar.d("PlayableComponent");
    }

    protected void xr(com.bytedance.sdk.component.adexpress.xr.ab abVar) {
        this.f3502ms.ms((ub) this);
        this.f3502ms.ms((ao) this);
        this.ah = this.f3502ms.ms(this.d);
        this.ab.pc().xr();
        this.ab.pc().ah();
        this.f3502ms.xr(this.ka);
    }

    public List<com.bytedance.adsdk.ugeno.xr.ah<View>> x() {
        return this.y;
    }

    public boolean ny() {
        return this.b;
    }

    protected JSONObject ms() {
        return this.ab.ka();
    }

    protected JSONObject ch() {
        return this.ab.p();
    }

    public void ms(boolean z) {
        this.ao.set(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    public View ab() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u() {
        lm lmVar = this.c;
        if (lmVar != null) {
            return lmVar.ka();
        }
        return 0;
    }

    public void hi() {
        this.ao.set(false);
        b bVar = this.h;
        if (bVar != null) {
            bVar.xr(u());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ch.ms msVar = this.qv;
        if (msVar != null) {
            msVar.xr();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    public int ah() {
        return this.c.du();
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        if (zbVar == null) {
            return;
        }
        if (zbVar.xr() == 18) {
            ah(zbVar, xrVar, msVar);
        } else if (zbVar.xr() == 3) {
            d(zbVar, xrVar, msVar);
        } else if (zbVar.xr() == 9) {
            xr(zbVar.ah());
        } else if (zbVar.xr() == 10) {
            ms(zbVar.ah());
        } else if (zbVar.xr() == 21) {
            xr(zbVar);
        } else if (zbVar.xr() == 19) {
            ah(zbVar);
        } else if (zbVar.xr() != 20) {
            if (d(zbVar)) {
                xr(zbVar, xrVar, msVar);
            } else if (zbVar.xr() == 22) {
                ms(zbVar);
            } else {
                ms(zbVar, xrVar, msVar, 0);
            }
        }
        if (zbVar.ah() != null) {
            String strOptString = zbVar.ah().optString("next");
            try {
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                zb zbVar2 = new zb();
                zbVar2.ms(1);
                zbVar2.ms(new JSONObject(strOptString));
                zbVar2.ms(this.ah);
                ms(zbVar2, (ub.xr) null, (ub.ms) null);
            } catch (JSONException unused) {
            }
        }
    }

    private void ms(zb zbVar) {
        JSONObject jSONObjectAh;
        if (zbVar == null || (jSONObjectAh = zbVar.ah()) == null) {
            return;
        }
        String strOptString = jSONObjectAh.optString("type");
        String strOptString2 = jSONObjectAh.optString("uchain");
        JSONObject jSONObjectOptJSONObject = jSONObjectAh.optJSONObject("params");
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    jSONObject.put(next, com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectOptJSONObject.optString(next), ch()));
                } catch (Throwable unused) {
                }
            }
        }
        if ("true".equals(strOptString2)) {
            if (com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms()) {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                map2.put("material_meta", this.c);
                HashMap map3 = new HashMap();
                map3.put("ugen_event_params", jSONObject);
                String strXr = f.xr(this.c);
                f.le();
                com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms(this.c, map, strOptString, map2, strXr, map3);
                return;
            }
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.c, f.xr(this.c), "ugen_view_visibility", jSONObject);
        }
    }

    private void xr(zb zbVar) {
        JSONObject jSONObjectAh;
        if (zbVar == null || (jSONObjectAh = zbVar.ah()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.t.u.ms().ms(this.c, jSONObjectAh.optString("uttieUrl"));
    }

    private void ah(zb zbVar) {
        JSONObject jSONObjectAh;
        if (zbVar == null || (jSONObjectAh = zbVar.ah()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.t.u.ms().ms(this.c, jSONObjectAh.optString("uttieUrl"), jSONObjectAh.optLong("duration"));
    }

    private boolean d(zb zbVar) {
        JSONObject jSONObjectAh;
        return zbVar != null && zbVar.xr() == 1 && (jSONObjectAh = zbVar.ah()) != null && jSONObjectAh.optBoolean("lottieEvent", false);
    }

    private void xr(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        JSONObject jSONObjectAh = zbVar.ah();
        if (jSONObjectAh == null) {
            return;
        }
        String strOptString = jSONObjectAh.optString("type", null);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        strOptString.hashCode();
        if (strOptString.equals("clickEvent")) {
            ms(zbVar, xrVar, msVar, 0);
            return;
        }
        if (strOptString.equals(ILivePush.ClickType.CLOSE)) {
            x xVar = this.ch;
            if (xVar != null) {
                xVar.ms();
            }
            com.bytedance.sdk.openadsdk.core.t.u.ms().xr(this.c, jSONObjectAh.optString("uttieUrl"));
        }
    }

    private void ah(final zb zbVar, final ub.xr xrVar, final ub.ms msVar) {
        if (this.h == null) {
            b bVar = new b(re.getContext(), 2, this.ab.ny());
            this.h = bVar;
            bVar.ms(this.c.on());
            this.h.ah(this.c.iw());
            this.h.xr(this.c.ia());
            this.h.ms(this.c.ax());
            this.h.c(this.c.ec());
            this.h.ka(this.c.n());
            this.h.xr(this.c.rg());
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final float[] fArr = {0.0f};
        this.h.ms(new b.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.d.2
            @Override // com.bytedance.sdk.component.utils.b.ms
            public void ms(int i) {
                if (i != 2) {
                    return;
                }
                d.this.h.xr(d.this.u());
                fArr[0] = 0.0f;
                View viewNy = ((com.bytedance.adsdk.ugeno.xr.ah) xrVar).ny();
                if (viewNy != null) {
                    viewNy.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.d.2.1
                        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                        public void onWindowFocusChanged(boolean z) {
                            if (z) {
                                d.this.h.ms(d.this.u());
                            } else {
                                d.this.h.xr(d.this.u());
                                fArr[0] = 0.0f;
                            }
                        }
                    });
                }
                AtomicBoolean atomicBoolean2 = atomicBoolean;
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(true);
                }
                d.this.ms(zbVar, xrVar, msVar, 2);
            }
        });
        this.h.ms(new b.xr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.d.3

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            float f3506ms = 0.0f;
            float xr = 0.0f;
            float ah = 0.0f;
            float d = 0.0f;
            float ka = 0.0f;
            float c = 0.0f;
            long ab = System.currentTimeMillis();

            @Override // com.bytedance.sdk.component.utils.b.xr
            public void ms(float f, float f2, float f3) {
                JSONObject jSONObjectAh;
                View viewNy;
                boolean z;
                float f4;
                float fCeil;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.ab < 100) {
                    return;
                }
                this.ab = jCurrentTimeMillis;
                zb zbVar2 = zbVar;
                if (zbVar2 == null || (jSONObjectAh = zbVar2.ah()) == null) {
                    return;
                }
                double dOptDouble = jSONObjectAh.optDouble("rotateZ", -1.0d);
                if (dOptDouble == -1.0d) {
                    return;
                }
                ub.xr xrVar2 = xrVar;
                if ((xrVar2 instanceof com.bytedance.adsdk.ugeno.xr.ah) && (viewNy = ((com.bytedance.adsdk.ugeno.xr.ah) xrVar2).ny()) != null && viewNy.isShown()) {
                    float fAbs = Math.abs(f);
                    float fAbs2 = Math.abs(f2);
                    float fAbs3 = Math.abs(f3);
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    if (atomicBoolean2 != null && atomicBoolean2.get()) {
                        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f) {
                            atomicBoolean.set(false);
                        }
                        this.f3506ms = fAbs;
                        this.xr = fAbs2;
                        this.ah = fAbs3;
                        this.d = f;
                        this.ka = f2;
                        this.c = f3;
                        return;
                    }
                    float fMax = Math.max(Math.abs(fAbs - this.f3506ms), Math.max(Math.abs(fAbs2 - this.xr), Math.abs(fAbs3 - this.ah)));
                    int iIa = d.this.c.ia();
                    if (iIa <= 0) {
                        iIa = 50;
                    }
                    if (Math.abs(fAbs - this.f3506ms) == fMax) {
                        f4 = f >= this.d ? fMax : -fMax;
                        z = true;
                    } else {
                        z = false;
                        f4 = 0.0f;
                    }
                    if (Math.abs(fAbs2 - this.xr) == fMax) {
                        f4 = f2 >= this.ka ? fMax : -fMax;
                        z = true;
                    }
                    if (Math.abs(fAbs3 - this.ah) != fMax) {
                        fMax = f4;
                    } else if (f3 < this.c) {
                        fMax = -fMax;
                    }
                    if (d.this.c.ec() == 0) {
                        fCeil = (float) Math.ceil(((double) (fMax * 180.0f)) / dOptDouble);
                    } else {
                        double degrees = Math.toDegrees(fMax);
                        float fCeil2 = (float) Math.ceil(degrees / dOptDouble);
                        if (z && Math.abs(degrees) < iIa - 8) {
                            return;
                        } else {
                            fCeil = z ? -Math.abs(fCeil2) : fCeil2;
                        }
                    }
                    if (Math.abs(fCeil - fArr[0]) < 1.3d) {
                        return;
                    }
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewNy, "rotation", fArr[0], fCeil);
                    objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    objectAnimatorOfFloat.setDuration(100L);
                    objectAnimatorOfFloat.start();
                    fArr[0] = fCeil;
                }
            }
        });
        this.h.ms(u());
    }

    private void ms(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar;
        com.bytedance.adsdk.ugeno.xr.ah ahVarAh;
        if (jSONObject == null) {
            return;
        }
        String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObject.optString("type"), ch());
        String strMs2 = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObject.optString("nodeId"), ch());
        if (TextUtils.isEmpty(strMs2) || (ahVar = this.ah) == null || (ahVarAh = ahVar.xr(ahVar).ah(strMs2)) == null) {
            return;
        }
        if (TextUtils.equals(strMs, "onShow")) {
            ahVarAh.xr(0);
        } else if (TextUtils.equals(strMs, "onDismiss")) {
            ahVarAh.xr(8);
        }
    }

    private void xr(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar;
        com.bytedance.adsdk.ugeno.xr.ah ahVarAh;
        if (jSONObject == null) {
            return;
        }
        String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObject.optString("type"), ch());
        String strMs2 = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObject.optString("nodeId"), ch());
        if (TextUtils.isEmpty(strMs2) || (ahVar = this.ah) == null || (ahVarAh = ahVar.xr(ahVar).ah(strMs2)) == null) {
            return;
        }
        if (TextUtils.equals(strMs, "onDismiss")) {
            ahVarAh.xr(8);
        } else if (TextUtils.equals(strMs, "onShow")) {
            ahVarAh.xr(0);
        }
    }

    private void d(final zb zbVar, final ub.xr xrVar, final ub.ms msVar) {
        WeakReference<ViewGroup> weakReference = this.zb;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        p.ms(this.zb, new com.bytedance.sdk.openadsdk.core.xr.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.d.4
            @Override // com.bytedance.sdk.openadsdk.core.xr.ah
            public void ms() {
                if (d.this.zb == null || d.this.zb.get() == null || !p.ms(d.this.zb.get())) {
                    return;
                }
                d.this.ms(zbVar, xrVar, msVar, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(zb zbVar, ub.xr xrVar, ub.ms msVar, int i) {
        com.bytedance.adsdk.ugeno.xr.ah ahVarMs;
        int i2;
        String strOptString;
        JSONObject jSONObjectP;
        CharSequence text;
        if (zbVar == null || (ahVarMs = zbVar.ms()) == null) {
            return;
        }
        JSONObject jSONObjectAh = zbVar.ah();
        String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectAh.optString("nodeId"), ch());
        String strMs2 = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectAh.optString("type"), ch());
        int iOptInt = -1;
        if (TextUtils.equals(strMs2, "clickEvent")) {
            strOptString = jSONObjectAh.optString("subConvertLinkTag");
            iOptInt = jSONObjectAh.optInt("dpaPosition", -1);
            i2 = 2;
        } else {
            if (TextUtils.equals(strMs2, "muteVideo")) {
                this.t = jSONObjectAh.optString("muteSrc");
                this.nw = jSONObjectAh.optString("unmuteSrc");
                i2 = 5;
            } else if (TextUtils.equals(strMs2, "dislike")) {
                i2 = 3;
            } else if (TextUtils.equals(strMs2, "skip")) {
                i2 = 6;
            } else if (TextUtils.equals(strMs2, "openPolicy")) {
                i2 = 7;
            } else if (TextUtils.equals(strMs2, "openAppPolicy")) {
                i2 = 9;
            } else if (TextUtils.equals(strMs2, "openAppPermission")) {
                i2 = 10;
            } else if (TextUtils.equals(strMs2, ILivePush.ClickType.CLOSE)) {
                strOptString = "";
                i2 = 8;
            } else if (TextUtils.equals(strMs2, "openAppFunctionDesc")) {
                i2 = 12;
            } else if (TextUtils.equals(strMs2, "videoControl") || TextUtils.equals(strMs2, "pauseVideo")) {
                i2 = 4;
            } else if (TextUtils.equals(strMs2, "openCommonUrl")) {
                i2 = 13;
            } else {
                if (TextUtils.equals(strMs2, "onDismiss")) {
                    com.bytedance.adsdk.ugeno.xr.ah ahVarAh = zbVar.ms().xr(zbVar.ms()).ah(strMs);
                    if (ahVarAh != null) {
                        ahVarAh.xr(8);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(strMs2, "onShow")) {
                    com.bytedance.adsdk.ugeno.xr.ah ahVarAh2 = zbVar.ms().xr(zbVar.ms()).ah(strMs);
                    if (ahVarAh2 != null) {
                        ahVarAh2.xr(0);
                        return;
                    }
                    return;
                }
                i2 = 0;
            }
            strOptString = "";
        }
        i.ms msVarKa = new i.ms().d(this.sl.u()).ah(this.sl.ub()).xr(this.sl.ao()).ms(this.sl.h()).ms(ahVarMs.of()).xr(this.sl.sl()).ms(this.sl.zb()).ka(strOptString).ka(iOptInt);
        JSONObject jSONObject = new JSONObject();
        if (i > 0) {
            try {
                jSONObject.put("convertActionType", i);
            } catch (Throwable unused) {
            }
        }
        View viewNy = ahVarMs.ny();
        try {
            if ((viewNy instanceof TextView) && (text = ((TextView) viewNy).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused2) {
        }
        try {
            if (this.c != null && this.b && jSONObjectAh.optBoolean("uchain", false)) {
                jSONObject.put("uchain_event_name", strMs2);
            }
        } catch (JSONException unused3) {
        }
        try {
            xr xrVar2 = this.ab;
            if (xrVar2 != null && (jSONObjectP = xrVar2.p()) != null) {
                jSONObject.put("ugen_id", jSONObjectP.optString("ugen_id"));
            }
        } catch (JSONException unused4) {
        }
        try {
            String strMs3 = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectAh.optString(TTDownloadField.TT_WEB_URL), ch());
            String strMs4 = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectAh.optString(TTDownloadField.TT_WEB_TITLE), ch());
            jSONObject.put("openCommonWebUrl", strMs3);
            jSONObject.put("openCommonWebTitle", strMs4);
        } catch (JSONException unused5) {
        }
        msVarKa.ms(jSONObject);
        i iVarMs = msVarKa.ms();
        com.bytedance.sdk.component.adexpress.xr.x xVar = this.ny;
        if (xVar != null) {
            xVar.ms(viewNy, i2, iVarMs);
        }
        if (xrVar == null || zbVar.d() == null) {
            return;
        }
        xrVar.ms(zbVar.d());
    }

    public void sl() {
        com.bytedance.adsdk.ugeno.xr.ah<T> ahVarAh;
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar = this.ah;
        if (ahVar == null || (ahVarAh = ahVar.ah("corver_container")) == 0 || ahVarAh.ny() == null) {
            return;
        }
        ahVarAh.ny().setVisibility(0);
    }

    public void zb() {
        com.bytedance.adsdk.ugeno.xr.ah<T> ahVarAh;
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar = this.ah;
        if (ahVar == null || (ahVarAh = ahVar.ah("corver_container")) == 0 || ahVarAh.ny() == null) {
            return;
        }
        ahVarAh.ny().setVisibility(8);
    }

    public void ms(long j, long j2) {
        com.bytedance.adsdk.ugeno.xr.ah ahVar = this.u;
        if (ahVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.d.ms) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.d.ms) ahVar).ms(j, j2);
        }
    }

    public void ms(CharSequence charSequence, int i, int i2, boolean z) {
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar = this.ah;
        if (ahVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.xr.ah<T> ahVarAh = ahVar.ah("count_down_skip_container");
        if (ahVarAh != 0 && ahVarAh.ny() != null) {
            ahVarAh.ny().setVisibility(0);
        }
        ub.xr xrVarAh = this.ah.ah("count_down");
        ub.xr xrVarAh2 = this.ah.ah("skip");
        if ((xrVarAh instanceof com.bytedance.adsdk.ugeno.widget.text.xr) && (xrVarAh2 instanceof com.bytedance.adsdk.ugeno.widget.text.xr)) {
            if (i2 == 0) {
                if (TextUtils.equals(charSequence, "0") || z) {
                    ((com.bytedance.adsdk.ugeno.widget.text.xr) xrVarAh).ny().setVisibility(8);
                    ((com.bytedance.adsdk.ugeno.widget.text.xr) xrVarAh2).x("跳过");
                    return;
                } else {
                    ((com.bytedance.adsdk.ugeno.widget.text.xr) xrVarAh).x(((Object) charSequence) + "s ");
                    com.bytedance.adsdk.ugeno.widget.text.xr xrVar = (com.bytedance.adsdk.ugeno.widget.text.xr) xrVarAh2;
                    xrVar.x("| 跳过");
                    xrVar.ny().setVisibility(0);
                    return;
                }
            }
            ((com.bytedance.adsdk.ugeno.widget.text.xr) xrVarAh).x(((Object) charSequence) + "s ");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.d
    public void setSoundMute(boolean z) {
        com.bytedance.adsdk.ugeno.xr.ah<T> ahVarAh;
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar = this.ah;
        if (ahVar == null || (ahVarAh = ahVar.ah("mute_image")) == 0) {
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(this.t)) {
                ((com.bytedance.adsdk.ugeno.widget.image.xr) ahVarAh).ny(this.t);
            }
        } else if (!TextUtils.isEmpty(this.nw)) {
            ((com.bytedance.adsdk.ugeno.widget.image.xr) ahVarAh).ny(this.nw);
        }
        ahVarAh.xr();
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ao
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                return;
            }
            this.sl.ah(motionEvent.getRawX());
            this.sl.d(motionEvent.getRawY());
            this.sl.xr(System.currentTimeMillis());
            return;
        }
        this.sl.ka((int) motionEvent.getRawX());
        this.sl.c((int) motionEvent.getRawY());
        this.sl.ms(motionEvent.getRawX());
        this.sl.xr(motionEvent.getRawY());
        this.sl.ms(System.currentTimeMillis());
        this.sl.xr(motionEvent.getToolType(0));
        this.sl.ah(motionEvent.getDeviceId());
        this.sl.d(motionEvent.getSource());
    }
}
