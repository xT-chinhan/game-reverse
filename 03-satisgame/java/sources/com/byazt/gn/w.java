package com.byazt.gn;

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
import androidx.core.app.NotificationCompat;
import com.byazt.gct.g;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import com.byazt.gct.wm;
import com.byazt.tk.ou;
import com.byazt.udb.sz;
import com.byazt.vh.a;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.k;
import com.byazt.vh.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.compilance.bean.IdentityVerifyStateKt;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 13})
public class w implements a, cd, com.byazt.tq.q, com.byazt.udb.q<View> {
    public AtomicBoolean a;
    public com.byazt.vhv.qg bb;
    public com.byazt.ih.s cd;
    public sz cp;
    public com.byazt.ih.s cy;
    public UGTimerContainer fs;
    public com.byazt.ou.l h;
    public com.byazt.ih.s hd;
    public String hu;
    public WeakReference<ViewGroup> k;
    public JSONObject l;
    public boolean ln;
    public String m;
    public k n;
    public com.byazt.li.qg oa;
    public com.byazt.ve.n ou;
    public ou py;
    public JSONObject q;
    public Context qg;
    public com.byazt.udb.fs rv;
    public com.byazt.ih.s<View> s;
    public com.byazt.rg.n t;
    public com.byazt.rg.w tj;
    public com.byazt.rg.l um;
    public final com.byazt.cv.n ur;
    public pk w;
    public List<com.byazt.ih.s<View>> wm;
    public s x;
    public List<com.byazt.vh.fs> d = new ArrayList();
    public tj sz = new tj();
    public Boolean lh = null;

    public void n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
    }

    public w(Context context, pk pkVar, s sVar, ViewGroup viewGroup) {
        com.byazt.zq.qg qgVarXd;
        JSONObject jSONObjectOptJSONObject;
        this.ln = false;
        this.qg = context;
        this.n = new k(context);
        this.w = pkVar;
        this.x = sVar;
        com.byazt.cv.n nVar = new com.byazt.cv.n(pkVar);
        this.ur = nVar;
        this.fs = new UGTimerContainer(context, nVar);
        this.k = new WeakReference<>(viewGroup);
        this.a = new AtomicBoolean(false);
        JSONObject jSONObjectN = n();
        this.q = jSONObjectN;
        if (pkVar != null && jSONObjectN != null && (jSONObjectOptJSONObject = jSONObjectN.optJSONObject("event_template")) != null) {
            this.ln = true;
            com.byazt.fm.qg.INSTANCE.n(jSONObjectOptJSONObject);
        }
        if (com.byazt.aci.n.q(pkVar)) {
            n(new com.byazt.vh.fs() { // from class: com.byazt.gn.w.1
                @Override // com.byazt.vh.fs
                public void n(rv.n nVar2) {
                    com.byazt.aci.n.n(true, nVar2);
                }

                @Override // com.byazt.vh.fs
                public void qg(rv.n nVar2) {
                    com.byazt.aci.n.n(false, nVar2);
                }
            });
        }
        this.n.n(new com.byazt.vh.fs() { // from class: com.byazt.gn.w.2
            @Override // com.byazt.vh.fs
            public void n(rv.n nVar2) {
                Iterator<com.byazt.vh.fs> it = w.this.d.iterator();
                while (it.hasNext()) {
                    it.next().n(nVar2);
                }
            }

            @Override // com.byazt.vh.fs
            public void qg(rv.n nVar2) {
                Iterator<com.byazt.vh.fs> it = w.this.d.iterator();
                while (it.hasNext()) {
                    it.next().qg(nVar2);
                }
            }
        });
        if (!com.byazt.vhv.q.x().s() || this.w == null || !nf.rv(pkVar) || (qgVarXd = this.w.xd()) == null) {
            return;
        }
        int iA = qgVarXd.a();
        this.bb = new com.byazt.vhv.qg(iA <= 0 ? com.byazt.vgx.w.d(this.w) : iA, this.w.ih(), this.w.h());
    }

    public boolean s() {
        if (this.x == null) {
            return false;
        }
        com.byazt.ivn.w wVarQg = com.byazt.nf.rv.qg();
        int iAe = this.x.ae();
        boolean z = this instanceof fs;
        if (z && iAe == 1) {
            return wVarQg.yp();
        }
        if (z && iAe == 2) {
            return wVarQg.ki();
        }
        if (z || iAe != 2) {
            return false;
        }
        return wVarQg.hc();
    }

    public void n(com.byazt.li.qg qgVar) {
        this.oa = qgVar;
    }

    public void n(com.byazt.udb.fs fsVar) {
        this.rv = fsVar;
    }

    public void n(com.byazt.rg.w wVar) {
        this.tj = wVar;
    }

    public void n(com.byazt.rg.n nVar) {
        this.t = nVar;
    }

    public void q() {
        List<com.byazt.ih.s<View>> list = this.wm;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = this.wm.iterator();
        while (it.hasNext()) {
            it.next().pk();
        }
    }

    private void n(com.byazt.ih.s<View> sVar, List<com.byazt.ih.s<View>> list) {
        if (sVar instanceof com.byazt.ih.n) {
            if (sVar.n(4)) {
                list.add(sVar);
            }
            List<com.byazt.ih.s<View>> listX = ((com.byazt.ih.n) sVar).x();
            if (listX == null || listX.size() == 0) {
                return;
            }
            Iterator<com.byazt.ih.s<View>> it = listX.iterator();
            while (it.hasNext()) {
                n(it.next(), list);
            }
            return;
        }
        if (sVar == null || !sVar.n(4)) {
            return;
        }
        list.add(sVar);
    }

    @Override // com.byazt.udb.q
    public void n(com.byazt.udb.x xVar) {
        this.x.j().n();
        this.q = n();
        JSONObject jSONObjectD = d();
        this.l = jSONObjectD;
        if (this.q == null || jSONObjectD == null) {
            xVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, (String) null);
            return;
        }
        qg(xVar);
        if (this.s != null) {
            q qVar = new q();
            this.cp = qVar;
            qVar.n(true);
            this.cp.n(qg());
            com.byazt.ih.s sVarX = x();
            this.cy = sVarX;
            if (sVarX != null && (sVarX instanceof com.byazt.hp.n)) {
                ((q) this.cp).n((FrameLayout) sVarX.rv());
            }
            com.byazt.ih.s sVarFs = fs();
            this.hd = sVarFs;
            if (sVarFs != null && (sVarFs instanceof com.byazt.om.n)) {
                ((q) this.cp).qg((FrameLayout) sVarFs.rv());
            }
            com.byazt.ih.s sVarRv = rv();
            this.cd = sVarRv;
            if (sVarRv != null && (sVarRv instanceof com.byazt.sj.qg)) {
                ((q) this.cp).s((FrameLayout) sVarRv.rv());
            }
            sz szVar = this.cp;
            if (szVar instanceof q) {
                ((q) szVar).n(this.ou);
            }
            this.fs.setTimerHolder(this.ou);
            int iAn = this.s.an();
            int iAe = this.s.ae();
            ArrayList arrayList = new ArrayList();
            this.wm = arrayList;
            n(this.s, arrayList);
            View viewRv = this.s.rv();
            ViewGroup viewGroup = (ViewGroup) viewRv.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(viewRv);
            }
            this.fs.addView(this.s.rv(), new FrameLayout.LayoutParams(iAn, iAe));
            float fLn = this.x.ln();
            float fLh = this.x.lh();
            float fS = com.byazt.okk.s.s(this.qg, fLn);
            float fS2 = com.byazt.okk.s.s(this.qg, fLh);
            int iL = com.byazt.okk.s.l(this.qg);
            int iRv = (int) (com.byazt.okk.s.rv(this.qg) + com.byazt.okk.s.cp(this.qg));
            float f = iL;
            if (fS > f) {
                fS = f;
            }
            float f2 = iRv;
            if (fS2 > f2) {
                fS2 = f2;
            }
            if (fLh <= 0.0f) {
                this.fs.setLayoutParams(new FrameLayout.LayoutParams((int) fS, -2));
            } else {
                this.fs.setLayoutParams(new FrameLayout.LayoutParams((int) fS, (int) fS2));
            }
            if (fLh <= 0.0f) {
                this.fs.measure(View.MeasureSpec.makeMeasureSpec((int) fS, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                int iQ = com.byazt.okk.s.q(this.qg, this.fs.getMeasuredWidth());
                int iQ2 = com.byazt.okk.s.q(this.qg, this.fs.getMeasuredHeight());
                this.cp.n(iQ);
                this.cp.qg(iQ2);
            } else {
                this.cp.n(com.byazt.okk.s.q(this.qg, fS));
                this.cp.qg(com.byazt.okk.s.q(this.qg, fS2));
            }
            if (this.a.get()) {
                xVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, (String) null);
                return;
            } else {
                xVar.n(this.fs, this.cp);
                return;
            }
        }
        xVar.n(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, (String) null);
    }

    public float[] l() {
        com.byazt.ih.s<View> sVar = this.s;
        if (sVar == null) {
            return null;
        }
        cd.n nVarL = sVar.l("InteractContainerView");
        if (nVarL instanceof com.byazt.rg.rv) {
            return ((com.byazt.rg.rv) nVarL).lq();
        }
        return null;
    }

    public com.byazt.ih.s x() {
        com.byazt.ih.s<View> sVar = this.s;
        if (sVar == null) {
            return null;
        }
        return sVar.l("VideoPlaceholder");
    }

    public com.byazt.ih.s fs() {
        com.byazt.ih.s<View> sVar = this.s;
        if (sVar == null) {
            return null;
        }
        return sVar.l("PlayableComponent");
    }

    public com.byazt.ih.s rv() {
        com.byazt.ih.s<View> sVar = this.s;
        if (sVar == null) {
            return null;
        }
        return sVar.l("SpriteView");
    }

    public void qg(com.byazt.udb.x xVar) {
        this.n.n((cd) this);
        this.n.n((a) this);
        this.s = this.n.n(this.q);
        this.x.j().qg();
        this.x.j().s();
        this.n.qg(this.l);
    }

    public List<com.byazt.ih.s<View>> tj() {
        return this.wm;
    }

    public boolean cp() {
        return this.ln;
    }

    public JSONObject n() {
        return this.x.l();
    }

    public JSONObject d() {
        return this.x.v();
    }

    public void qg(boolean z) {
        this.a.set(z);
    }

    @Override // com.byazt.udb.q
    public View w() {
        return this.fs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int py() {
        pk pkVar = this.w;
        if (pkVar != null) {
            return pkVar.v();
        }
        return 0;
    }

    public void n(boolean z) {
        this.a.set(false);
        ou ouVar = this.py;
        if (ouVar != null) {
            ouVar.qg(py());
        }
        com.byazt.ve.n nVar = this.ou;
        if (nVar != null) {
            nVar.s();
        }
        List<com.byazt.vh.fs> list = this.d;
        if (list != null) {
            list.clear();
        }
        if (z) {
            this.ur.qg();
            this.ur.n((com.byazt.vhv.s) null);
            com.byazt.vhv.qg qgVar = this.bb;
            if (qgVar != null) {
                qgVar.rv();
                this.bb = null;
            }
        }
    }

    @Override // com.byazt.udb.q
    public int qg() {
        return nf.s(this.w);
    }

    @Override // com.byazt.vh.cd
    public void n(cy cyVar, cd.qg qgVar, cd.n nVar) {
        if (cyVar == null) {
            return;
        }
        if (cyVar.qg() == 18) {
            s(cyVar, qgVar, nVar);
        } else if (cyVar.qg() == 3) {
            q(cyVar, qgVar, nVar);
        } else if (cyVar.qg() == 9) {
            qg(cyVar.s());
        } else if (cyVar.qg() == 10) {
            n(cyVar.s());
        } else if (cyVar.qg() == 21) {
            qg(cyVar);
        } else if (cyVar.qg() == 19) {
            qg(cyVar, qgVar, nVar);
            s(cyVar);
        } else if (cyVar.qg() == 20 || q(cyVar)) {
            qg(cyVar, qgVar, nVar);
        } else if (cyVar.qg() == 22) {
            n(cyVar);
        } else {
            n(cyVar, qgVar, nVar, 0, false);
        }
        if (cyVar.s() != null) {
            String strOptString = cyVar.s().optString("next");
            try {
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                cy cyVar2 = new cy();
                cyVar2.n(1);
                cyVar2.n(new JSONObject(strOptString));
                cyVar2.n(this.s);
                n(cyVar2, (cd.qg) null, (cd.n) null);
            } catch (JSONException unused) {
            }
        }
    }

    private void n(cy cyVar) {
        JSONObject jSONObjectS;
        if (cyVar == null || (jSONObjectS = cyVar.s()) == null) {
            return;
        }
        String strOptString = jSONObjectS.optString("type");
        String strOptString2 = jSONObjectS.optString("uchain");
        JSONObject jSONObjectOptJSONObject = jSONObjectS.optJSONObject("params");
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    jSONObject.put(next, com.byazt.mcb.qg.n(jSONObjectOptJSONObject.optString(next), d()));
                } catch (Throwable unused) {
                }
            }
        }
        if ("true".equals(strOptString2)) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            map2.put("material_meta", this.w);
            HashMap map3 = new HashMap();
            map3.put("ugen_event_params", jSONObject);
            String strQg = com.byazt.vgx.w.qg(this.w);
            com.byazt.vgx.w.ur();
            com.byazt.ukb.qg.n(this.w, map, strOptString, map2, strQg, map3, -1L);
        }
    }

    private void qg(cy cyVar) {
        JSONObject jSONObjectS;
        if (cyVar == null || (jSONObjectS = cyVar.s()) == null) {
            return;
        }
        com.byazt.eji.s.n().qg(this.w, jSONObjectS.optString("uttieUrl"));
    }

    private void s(cy cyVar) {
        JSONObject jSONObjectS;
        if (cyVar == null || (jSONObjectS = cyVar.s()) == null) {
            return;
        }
        com.byazt.eji.s.n().n(this.w, jSONObjectS.optString("uttieUrl"), jSONObjectS.optLong(MediationConstant.EXTRA_DURATION));
    }

    private boolean q(cy cyVar) {
        JSONObject jSONObjectS;
        return cyVar != null && cyVar.qg() == 1 && (jSONObjectS = cyVar.s()) != null && jSONObjectS.optBoolean("lottieEvent", false);
    }

    private void qg(cy cyVar, cd.qg qgVar, cd.n nVar) {
        JSONObject jSONObjectS = cyVar.s();
        if (jSONObjectS == null) {
            return;
        }
        String strOptString = jSONObjectS.optString("type", null);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        strOptString.hashCode();
        if (strOptString.equals("clickEvent")) {
            n(cyVar, qgVar, nVar, 0, true);
            return;
        }
        if (strOptString.equals(ILivePush.ClickType.CLOSE)) {
            com.byazt.rg.w wVar = this.tj;
            if (wVar != null) {
                wVar.n();
            }
            com.byazt.eji.s.n().s(this.w, jSONObjectS.optString("uttieUrl"));
        }
    }

    private void s(final cy cyVar, final cd.qg qgVar, final cd.n nVar) {
        if (this.py == null) {
            ou ouVar = new ou(com.byazt.nf.rv.getContext(), 2, this.x.rv());
            this.py = ouVar;
            ouVar.n(this.w.mp());
            this.py.s(this.w.im());
            this.py.qg(this.w.eu());
            this.py.n(this.w.kv());
            this.py.w(this.w.on());
            this.py.l(this.w.qd());
            this.py.qg(this.w.bs());
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final float[] fArr = {0.0f};
        this.py.n(new ou.n() { // from class: com.byazt.gn.w.3
            @Override // com.byazt.tk.ou.n
            public void n(int i) {
                if (i != 2) {
                    return;
                }
                w.this.py.qg(w.this.py());
                fArr[0] = 0.0f;
                View viewRv = ((com.byazt.ih.s) qgVar).rv();
                if (viewRv != null) {
                    viewRv.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.byazt.gn.w.3.1
                        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                        public void onWindowFocusChanged(boolean z) {
                            if (z) {
                                w.this.py.n(w.this.py());
                            } else {
                                w.this.py.qg(w.this.py());
                                fArr[0] = 0.0f;
                            }
                        }
                    });
                }
                AtomicBoolean atomicBoolean2 = atomicBoolean;
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(true);
                }
                w.this.n(cyVar, qgVar, nVar, 2, false);
            }
        });
        this.py.n(new ou.qg() { // from class: com.byazt.gn.w.4
            public float n = 0.0f;
            public float qg = 0.0f;
            public float s = 0.0f;
            public float q = 0.0f;
            public float l = 0.0f;
            public float w = 0.0f;
            public long x = System.currentTimeMillis();

            @Override // com.byazt.tk.ou.qg
            public void n(float f, float f2, float f3) {
                JSONObject jSONObjectS;
                View viewRv;
                boolean z;
                float f4;
                float fCeil;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.x < 100) {
                    return;
                }
                this.x = jCurrentTimeMillis;
                cy cyVar2 = cyVar;
                if (cyVar2 == null || (jSONObjectS = cyVar2.s()) == null) {
                    return;
                }
                double dOptDouble = jSONObjectS.optDouble("rotateZ", -1.0d);
                if (dOptDouble == -1.0d) {
                    return;
                }
                cd.qg qgVar2 = qgVar;
                if ((qgVar2 instanceof com.byazt.ih.s) && (viewRv = ((com.byazt.ih.s) qgVar2).rv()) != null && viewRv.isShown()) {
                    float fAbs = Math.abs(f);
                    float fAbs2 = Math.abs(f2);
                    float fAbs3 = Math.abs(f3);
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    if (atomicBoolean2 != null && atomicBoolean2.get()) {
                        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f) {
                            atomicBoolean.set(false);
                        }
                        this.n = fAbs;
                        this.qg = fAbs2;
                        this.s = fAbs3;
                        this.q = f;
                        this.l = f2;
                        this.w = f3;
                        return;
                    }
                    float fMax = Math.max(Math.abs(fAbs - this.n), Math.max(Math.abs(fAbs2 - this.qg), Math.abs(fAbs3 - this.s)));
                    int iEu = w.this.w.eu();
                    if (iEu <= 0) {
                        iEu = 50;
                    }
                    if (Math.abs(fAbs - this.n) == fMax) {
                        f4 = f >= this.q ? fMax : -fMax;
                        z = true;
                    } else {
                        z = false;
                        f4 = 0.0f;
                    }
                    if (Math.abs(fAbs2 - this.qg) == fMax) {
                        f4 = f2 >= this.l ? fMax : -fMax;
                        z = true;
                    }
                    if (Math.abs(fAbs3 - this.s) != fMax) {
                        fMax = f4;
                    } else if (f3 < this.w) {
                        fMax = -fMax;
                    }
                    if (w.this.w.on() == 0) {
                        fCeil = (float) Math.ceil(((double) (fMax * 180.0f)) / dOptDouble);
                    } else {
                        double degrees = Math.toDegrees(fMax);
                        float fCeil2 = (float) Math.ceil(degrees / dOptDouble);
                        if (z && Math.abs(degrees) < iEu - 8) {
                            return;
                        } else {
                            fCeil = z ? -Math.abs(fCeil2) : fCeil2;
                        }
                    }
                    if (Math.abs(fCeil - fArr[0]) < 1.3d) {
                        return;
                    }
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewRv, "rotation", fArr[0], fCeil);
                    objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    objectAnimatorOfFloat.setDuration(100L);
                    objectAnimatorOfFloat.start();
                    fArr[0] = fCeil;
                }
            }
        });
        this.py.n(py());
    }

    private void n(JSONObject jSONObject) {
        com.byazt.ih.s<View> sVar;
        com.byazt.ih.s sVarQ;
        if (jSONObject == null) {
            return;
        }
        String strN = com.byazt.mcb.qg.n(jSONObject.optString("type"), d());
        String strN2 = com.byazt.mcb.qg.n(jSONObject.optString("nodeId"), d());
        if (TextUtils.isEmpty(strN2) || (sVar = this.s) == null || (sVarQ = sVar.qg(sVar).q(strN2)) == null) {
            return;
        }
        if (TextUtils.equals(strN, "onShow")) {
            sVarQ.qg(0);
            return;
        }
        if (TextUtils.equals(strN, "onDismiss")) {
            sVarQ.qg(8);
        } else if (TextUtils.equals(strN, "haptic")) {
            s(jSONObject);
        } else if (TextUtils.equals(strN, "dismissScene")) {
            l(jSONObject);
        }
    }

    private void qg(JSONObject jSONObject) {
        com.byazt.ih.s<View> sVar;
        com.byazt.ih.s sVarQ;
        if (jSONObject == null) {
            return;
        }
        String strN = com.byazt.mcb.qg.n(jSONObject.optString("type"), d());
        String strN2 = com.byazt.mcb.qg.n(jSONObject.optString("nodeId"), d());
        if (TextUtils.isEmpty(strN2) || (sVar = this.s) == null || (sVarQ = sVar.qg(sVar).q(strN2)) == null) {
            return;
        }
        if (TextUtils.equals(strN, "onDismiss")) {
            sVarQ.qg(8);
            return;
        }
        if (TextUtils.equals(strN, "onShow")) {
            sVarQ.qg(0);
        } else if (TextUtils.equals(strN, "haptic")) {
            s(jSONObject);
        } else if (TextUtils.equals(strN, "dismissScene")) {
            l(jSONObject);
        }
    }

    private void q(final cy cyVar, final cd.qg qgVar, final cd.n nVar) {
        WeakReference<ViewGroup> weakReference = this.k;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.byazt.cd.qg.n(this.k, new com.byazt.ys.q() { // from class: com.byazt.gn.w.5
            @Override // com.byazt.ys.q
            public void n() {
                if (w.this.k == null || w.this.k.get() == null || !com.byazt.cd.qg.n(w.this.k.get())) {
                    return;
                }
                w.this.n(cyVar, qgVar, nVar, 1, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(cy cyVar, cd.qg qgVar, cd.n nVar, int i, boolean z) {
        com.byazt.ih.s sVarN;
        int i2;
        String strOptString;
        int iOptInt;
        JSONObject jSONObjectV;
        CharSequence text;
        if (cyVar == null || (sVarN = cyVar.n()) == null) {
            return;
        }
        JSONObject jSONObjectS = cyVar.s();
        String strN = com.byazt.mcb.qg.n(jSONObjectS.optString("nodeId"), d());
        String strN2 = com.byazt.mcb.qg.n(jSONObjectS.optString("type"), d());
        if (s()) {
            HashMap map = new HashMap();
            map.put("ugen_click_event_params", this.sz);
            map.put("convert_action_type", Integer.valueOf(i));
            if (com.byazt.li.n.n().n(cyVar, this.w, this.qg, sVarN, d(), this.oa, map)) {
                return;
            }
        }
        if (TextUtils.equals(strN2, "clickEvent")) {
            strOptString = jSONObjectS.optString("subConvertLinkTag");
            iOptInt = jSONObjectS.optInt("dpaPosition", -1);
            i2 = 2;
        } else {
            if (TextUtils.equals(strN2, "muteVideo")) {
                this.m = jSONObjectS.optString("muteSrc");
                this.hu = jSONObjectS.optString("unmuteSrc");
                i2 = 5;
            } else if (TextUtils.equals(strN2, com.byazt.wg.qg.AD_TAG_DISLIKE)) {
                i2 = 3;
            } else if (TextUtils.equals(strN2, "skip")) {
                i2 = 6;
            } else if (TextUtils.equals(strN2, "openPolicy")) {
                i2 = 7;
            } else if (TextUtils.equals(strN2, "openAppPolicy")) {
                i2 = 9;
            } else if (TextUtils.equals(strN2, "openAppPermission")) {
                i2 = 10;
            } else {
                i2 = 8;
                if (!TextUtils.equals(strN2, ILivePush.ClickType.CLOSE)) {
                    if (TextUtils.equals(strN2, "openAppFunctionDesc")) {
                        i2 = 12;
                    } else if (TextUtils.equals(strN2, "videoControl") || TextUtils.equals(strN2, "pauseVideo")) {
                        i2 = 4;
                    } else if (TextUtils.equals(strN2, "openCommonUrl")) {
                        i2 = 13;
                    } else {
                        if (TextUtils.equals(strN2, "onDismiss")) {
                            com.byazt.ih.s sVarQ = cyVar.n().qg(cyVar.n()).q(strN);
                            if (sVarQ != null) {
                                sVarQ.qg(8);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(strN2, "onShow")) {
                            com.byazt.ih.s sVarQ2 = cyVar.n().qg(cyVar.n()).q(strN);
                            if (sVarQ2 != null) {
                                sVarQ2.qg(0);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(strN2, "haptic")) {
                            s(cyVar.s());
                            return;
                        }
                        if (TextUtils.equals(strN2, "closeWidget")) {
                            com.byazt.rg.l lVar = this.um;
                            if (lVar != null) {
                                lVar.l();
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(strN2, "dismiss")) {
                            sVarN.qg(8);
                            return;
                        } else if (TextUtils.equals(strN2, "renderScene")) {
                            q(jSONObjectS);
                            return;
                        } else {
                            if (TextUtils.equals(strN2, "dismissScene")) {
                                l(jSONObjectS);
                                return;
                            }
                            i2 = 0;
                        }
                    }
                }
            }
            strOptString = "";
            iOptInt = -1;
        }
        wm.n nVarL = new wm.n().q(this.sz.cd()).s(this.sz.um()).qg(this.sz.a()).n(this.sz.py()).n(sVarN.v()).qg(this.sz.cy()).n(this.sz.hd()).l(strOptString).l(iOptInt);
        JSONObject jSONObject = new JSONObject();
        if (i > 0) {
            try {
                jSONObject.put("convertActionType", i);
            } catch (Throwable unused) {
            }
        }
        View viewRv = sVarN.rv();
        try {
            if ((viewRv instanceof TextView) && (text = ((TextView) viewRv).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused2) {
        }
        try {
            if (this.w != null && this.ln && jSONObjectS.optBoolean("uchain", false)) {
                jSONObject.put("uchain_event_name", strN2);
            }
        } catch (JSONException unused3) {
        }
        try {
            s sVar = this.x;
            if (sVar != null && (jSONObjectV = sVar.v()) != null) {
                jSONObject.put("ugen_id", jSONObjectV.optString("ugen_id"));
            }
        } catch (JSONException unused4) {
        }
        try {
            String strN3 = com.byazt.mcb.qg.n(jSONObjectS.optString("webUrl"), d());
            String strN4 = com.byazt.mcb.qg.n(jSONObjectS.optString("webTitle"), d());
            jSONObject.put("openCommonWebUrl", strN3);
            jSONObject.put("openCommonWebTitle", strN4);
        } catch (JSONException unused5) {
        }
        if (z) {
            try {
                jSONObject.put("isLottieInternalClick", true);
            } catch (JSONException unused6) {
            }
        }
        nVarL.n(jSONObject);
        wm wmVarN = nVarL.n();
        com.byazt.udb.fs fsVar = this.rv;
        if (fsVar != null) {
            fsVar.n(viewRv, i2, wmVarN, -1);
        }
        if (qgVar == null || cyVar.q() == null) {
            return;
        }
        qgVar.n(cyVar.q());
    }

    private void s(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return;
        }
        com.byazt.bz.s.n(jSONObjectOptJSONObject, this.qg, this.w);
    }

    private void q(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return;
        }
        n(jSONObjectOptJSONObject.optString("scene"), jSONObjectOptJSONObject.optString("ugen_id"), jSONObjectOptJSONObject.optString("ugen_md5"), jSONObjectOptJSONObject.optString("ugen_url"), jSONObjectOptJSONObject.optString("displayAreaAndroid"), jSONObjectOptJSONObject.optString("render_sequence"));
    }

    public void n(String str, String str2, String str3, String str4, String str5, String str6) {
        int i;
        int i2;
        g gVarN;
        String strN = com.byazt.mcb.qg.n(str, d());
        String strN2 = com.byazt.mcb.qg.n(str2, d());
        String strN3 = com.byazt.mcb.qg.n(str3, d());
        String strN4 = com.byazt.mcb.qg.n(str4, d());
        try {
            i = Integer.parseInt(com.byazt.mcb.qg.n(str5, d()));
        } catch (Exception unused) {
            i = 0;
        }
        int i3 = i;
        try {
            i2 = Integer.parseInt(com.byazt.mcb.qg.n(str6, d()));
        } catch (Exception unused2) {
            i2 = 2;
        }
        int i4 = i2;
        if (n(strN, i3)) {
            com.byazt.ih.s<View> sVar = this.s;
            View viewRv = sVar != null ? sVar.rv() : null;
            if (viewRv == null || this.w == null || (gVarN = com.byazt.rg.q.n(strN2, strN3, strN4, i3, i4, 5)) == null || !gVarN.k()) {
                return;
            }
            com.byazt.ou.l lVar = new com.byazt.ou.l(this.w, this.t, gVarN, this.oa);
            this.h = lVar;
            lVar.n(viewRv);
        }
    }

    private void l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return;
        }
        n(jSONObjectOptJSONObject.optString("scene"));
    }

    public void n(String str) {
        com.byazt.rg.l lVar;
        if (!TextUtils.equals("scene1", com.byazt.mcb.qg.n(str, d())) || (lVar = this.um) == null) {
            return;
        }
        lVar.l();
    }

    private boolean n(String str, int i) {
        return TextUtils.equals("scene1", str) && com.byazt.rg.q.n(i);
    }

    public void n(com.byazt.rg.l lVar) {
        this.um = lVar;
    }

    public void oa() {
        com.byazt.ih.s<T> sVarQ;
        com.byazt.ih.s<View> sVar = this.s;
        if (sVar == null || (sVarQ = sVar.q("corver_container")) == 0 || sVarQ.rv() == null) {
            return;
        }
        sVarQ.rv().setVisibility(0);
    }

    public void sz() {
        com.byazt.ih.s<T> sVarQ;
        com.byazt.ih.s<View> sVar = this.s;
        if (sVar == null || (sVarQ = sVar.q("corver_container")) == 0 || sVarQ.rv() == null) {
            return;
        }
        sVarQ.rv().setVisibility(8);
    }

    public void k() {
        qg("finished");
    }

    public void n(long j, long j2) {
        com.byazt.ih.s sVar = this.cy;
        if (sVar instanceof com.byazt.hp.n) {
            ((com.byazt.hp.n) sVar).n(j, j2);
        }
        qg(j, j2);
    }

    public void cy() {
        qg("paused");
    }

    public void hd() {
        qg("playing");
    }

    public void cd() {
        qg("started");
        qg("playing");
    }

    public void s(boolean z) {
        String strOu;
        if (wm() && (strOu = ou()) != null) {
            Boolean bool = this.lh;
            if (bool == null || bool.booleanValue() != z) {
                this.lh = Boolean.valueOf(z);
                String str = z ? "visible" : "invisible";
                HashMap map = new HashMap();
                map.put(WebLoginFragment.QUERY_KEY_ID, str);
                try {
                    com.byazt.sx.q.n().n(strOu, "adViewVisible", map);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        }
    }

    private void qg(String str) {
        String strOu;
        if (wm() && (strOu = ou()) != null) {
            HashMap map = new HashMap();
            map.put(WebLoginFragment.QUERY_KEY_ID, str);
            try {
                com.byazt.sx.q.n().n(strOu, "videoState", map);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    private void qg(long j, long j2) {
        String strOu;
        if (wm() && (strOu = ou()) != null) {
            HashMap map = new HashMap();
            map.put("current", Long.valueOf(j));
            map.put(MediationConstant.EXTRA_DURATION, Long.valueOf(j2));
            try {
                com.byazt.sx.q.n().n(strOu, "videoProgress", map);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public void n(int i, long j) {
        String strOu;
        String str;
        if (wm() && (strOu = ou()) != null) {
            switch (i) {
                case 1:
                    str = "started";
                    break;
                case 2:
                    str = "paused";
                    break;
                case 3:
                    str = "downloading";
                    break;
                case 4:
                    str = IdentityVerifyStateKt.VERIFY_STATE_FAILED;
                    break;
                case 5:
                    str = "finished";
                    break;
                case 6:
                    str = "installed";
                    break;
                default:
                    return;
            }
            HashMap map = new HashMap();
            map.put(WebLoginFragment.QUERY_KEY_ID, str);
            map.put(NotificationCompat.CATEGORY_PROGRESS, Long.valueOf(j));
            try {
                com.byazt.sx.q.n().n(strOu, "downloadStatus", map);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    private String ou() {
        pk pkVar = this.w;
        if (pkVar == null) {
            return null;
        }
        return pkVar.py();
    }

    private static boolean wm() {
        com.byazt.ivn.w wVarQg = com.byazt.nf.rv.qg();
        return wVarQg != null && wVarQg.du();
    }

    public void n(CharSequence charSequence, int i, int i2, boolean z) {
        com.byazt.ih.s<View> sVar = this.s;
        if (sVar == null) {
            return;
        }
        com.byazt.ih.s<T> sVarQ = sVar.q("count_down_skip_container");
        if (sVarQ != 0 && sVarQ.rv() != null) {
            sVarQ.rv().setVisibility(0);
        }
        cd.n nVarQ = this.s.q("count_down");
        cd.n nVarQ2 = this.s.q("skip");
        if ((nVarQ instanceof com.byazt.ud.qg) && (nVarQ2 instanceof com.byazt.ud.qg)) {
            if (i2 == 0) {
                if (TextUtils.equals(charSequence, "0") || z) {
                    ((com.byazt.ud.qg) nVarQ).rv().setVisibility(8);
                    ((com.byazt.ud.qg) nVarQ2).oa("跳过");
                    return;
                } else {
                    ((com.byazt.ud.qg) nVarQ).oa(((Object) charSequence) + "s ");
                    com.byazt.ud.qg qgVar = (com.byazt.ud.qg) nVarQ2;
                    qgVar.oa("| 跳过");
                    qgVar.rv().setVisibility(0);
                    return;
                }
            }
            ((com.byazt.ud.qg) nVarQ).oa(((Object) charSequence) + "s ");
        }
    }

    @Override // com.byazt.tq.q
    public void setSoundMute(boolean z) {
        com.byazt.ih.s<T> sVarQ;
        com.byazt.ih.s<View> sVar = this.s;
        if (sVar == null || (sVarQ = sVar.q("mute_image")) == 0) {
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(this.m)) {
                ((com.byazt.jm.s) sVarQ).oa(this.m);
            }
        } else if (!TextUtils.isEmpty(this.hu)) {
            ((com.byazt.jm.s) sVarQ).oa(this.hu);
        }
        sVarQ.qg();
    }

    @Override // com.byazt.vh.a
    public void n(com.byazt.ih.s sVar, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                return;
            }
            this.sz.s(motionEvent.getRawX());
            this.sz.q(motionEvent.getRawY());
            this.sz.qg(System.currentTimeMillis());
            return;
        }
        this.sz.l((int) motionEvent.getRawX());
        this.sz.w((int) motionEvent.getRawY());
        this.sz.n(motionEvent.getRawX());
        this.sz.qg(motionEvent.getRawY());
        this.sz.n(System.currentTimeMillis());
        this.sz.qg(motionEvent.getToolType(0));
        this.sz.s(motionEvent.getDeviceId());
        this.sz.q(motionEvent.getSource());
    }

    public void n(com.byazt.vh.fs fsVar) {
        this.d.add(fsVar);
    }

    public void um() {
        com.byazt.ih.s<View> sVar = this.s;
        if (sVar == null) {
            return;
        }
        this.ur.n(sVar);
        com.byazt.vhv.qg qgVar = this.bb;
        if (qgVar != null) {
            this.ur.n(qgVar);
            this.bb.w();
        }
    }

    public void n(com.byazt.mkl.n nVar) {
        com.byazt.vhv.qg qgVar = this.bb;
        if (qgVar != null) {
            qgVar.n(nVar);
        }
    }

    public void a() {
        this.ur.qg();
    }
}
