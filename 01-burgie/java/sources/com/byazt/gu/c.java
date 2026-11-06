package com.byazt.gu;

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
import com.byazt.ca.ny;
import com.byazt.ch.a;
import com.byazt.ch.aj;
import com.byazt.ch.ho;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.byazt.hg.bh;
import com.byazt.hg.fo;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.hg.vk;
import com.byazt.is.w;
import com.byazt.mq.g;
import com.byazt.mq.zo;
import com.byazt.uq.k;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 665, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements a, lb, com.byazt.imd.x, com.byazt.mq.x<View> {
    public ny a;
    public zo aj;
    public com.byazt.uq.pr b;
    public JSONObject c;
    public com.byazt.bk.pr cz;
    public String fo;
    public hw fw;
    public boolean gz;
    public com.byazt.ik.hn<View> hn;
    public WeakReference<ViewGroup> ho;
    public Context hw;
    public final com.byazt.nk.pr iu;
    public com.byazt.uq.fw lb;
    public com.byazt.fy.hw m;
    public com.byazt.ik.hn nt;
    public List<com.byazt.ik.hn<View>> ny;
    public ho pr;
    public AtomicBoolean qa;
    public String rc;
    public of uc;
    public com.byazt.ak.hw ve;
    public com.byazt.uq.zo vk;
    public g w;
    public JSONObject x;
    public com.byazt.ik.hn yb;
    public com.byazt.tg.c z;
    public UGTimerContainer zo;
    public List<com.byazt.ch.zo> k = new ArrayList();
    public vk g = new vk();

    public c(Context context, of ofVar, hw hwVar, ViewGroup viewGroup) {
        of ofVar2;
        com.byazt.qe.hw hwVarP;
        JSONObject jSONObjectOptJSONObject;
        this.gz = false;
        this.hw = context;
        this.pr = new ho(context);
        this.uc = ofVar;
        this.fw = hwVar;
        com.byazt.nk.pr prVar = new com.byazt.nk.pr(ofVar);
        this.iu = prVar;
        this.zo = new UGTimerContainer(context, prVar);
        this.ho = new WeakReference<>(viewGroup);
        this.qa = new AtomicBoolean(false);
        JSONObject jSONObjectPr = pr();
        this.x = jSONObjectPr;
        if (ofVar != null && jSONObjectPr != null && (jSONObjectOptJSONObject = jSONObjectPr.optJSONObject("event_template")) != null) {
            this.gz = true;
            com.byazt.re.hw.INSTANCE.pr(jSONObjectOptJSONObject);
        }
        if (com.byazt.ja.pr.x(ofVar)) {
            pr(new com.byazt.ch.zo() { // from class: com.byazt.gu.c.1
                @Override // com.byazt.ch.zo
                public void pr(aj.pr prVar2) {
                    com.byazt.ja.pr.pr(true, prVar2);
                }

                @Override // com.byazt.ch.zo
                public void hw(aj.pr prVar2) {
                    com.byazt.ja.pr.pr(false, prVar2);
                }
            });
        }
        this.pr.pr(new com.byazt.ch.zo() { // from class: com.byazt.gu.c.2
            @Override // com.byazt.ch.zo
            public void pr(aj.pr prVar2) {
                Iterator<com.byazt.ch.zo> it = c.this.k.iterator();
                while (it.hasNext()) {
                    it.next().pr(prVar2);
                }
            }

            @Override // com.byazt.ch.zo
            public void hw(aj.pr prVar2) {
                Iterator<com.byazt.ch.zo> it = c.this.k.iterator();
                while (it.hasNext()) {
                    it.next().hw(prVar2);
                }
            }
        });
        if (com.byazt.ak.x.fw().hn() && (ofVar2 = this.uc) != null && (hwVarP = ofVar2.p()) != null) {
            int iA = hwVarP.a();
            this.ve = new com.byazt.ak.hw(iA <= 0 ? ls.k(this.uc) : iA, this.uc.le(), this.uc.z());
        }
    }

    public boolean hn() {
        if (this.fw == null) {
            return false;
        }
        w wVarHw = com.byazt.sd.a.hw();
        int iS = this.fw.s();
        boolean z = this instanceof fw;
        if (z && iS == 1) {
            return wVarHw.ou();
        }
        if (z && iS == 2) {
            return wVarHw.cl();
        }
        if (z || iS != 2) {
            return false;
        }
        return wVarHw.fj();
    }

    public void pr(com.byazt.fy.hw hwVar) {
        this.m = hwVar;
    }

    public void pr(zo zoVar) {
        this.aj = zoVar;
    }

    public void pr(com.byazt.uq.zo zoVar) {
        this.vk = zoVar;
    }

    public void pr(com.byazt.uq.pr prVar) {
        this.b = prVar;
    }

    public void x() {
        List<com.byazt.ik.hn<View>> list = this.ny;
        if (list != null && list.size() != 0) {
            Iterator<com.byazt.ik.hn<View>> it = this.ny.iterator();
            while (it.hasNext()) {
                it.next().ii();
            }
        }
    }

    private void pr(com.byazt.ik.hn<View> hnVar, List<com.byazt.ik.hn<View>> list) {
        if (hnVar instanceof com.byazt.ik.pr) {
            if (hnVar.pr(4)) {
                list.add(hnVar);
            }
            List<com.byazt.ik.hn<View>> listFw = ((com.byazt.ik.pr) hnVar).fw();
            if (listFw != null && listFw.size() != 0) {
                Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
                while (it.hasNext()) {
                    pr(it.next(), list);
                }
                return;
            }
            return;
        }
        if (hnVar != null && hnVar.pr(4)) {
            list.add(hnVar);
        }
    }

    @Override // com.byazt.mq.x
    public void pr(com.byazt.mq.fw fwVar) {
        this.fw.n().pr();
        this.x = pr();
        JSONObject jSONObjectW = w();
        this.c = jSONObjectW;
        if (this.x == null || jSONObjectW == null) {
            fwVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, (String) null);
            return;
        }
        hw(fwVar);
        if (this.hn != null) {
            hn hnVar = new hn();
            this.w = hnVar;
            hnVar.pr(true);
            this.w.pr(hw());
            com.byazt.ik.hn hnVarFw = fw();
            this.nt = hnVarFw;
            if (hnVarFw != null && (hnVarFw instanceof com.byazt.he.pr)) {
                ((hn) this.w).pr((FrameLayout) hnVarFw.aj());
            }
            com.byazt.ik.hn hnVarZo = zo();
            this.yb = hnVarZo;
            if (hnVarZo != null && (hnVarZo instanceof com.byazt.ajv.pr)) {
                ((hn) this.w).hw((FrameLayout) hnVarZo.aj());
            }
            g gVar = this.w;
            if (gVar instanceof hn) {
                ((hn) gVar).pr(this.cz);
            }
            this.zo.setTimerHolder(this.cz);
            int iE = this.hn.e();
            int iS = this.hn.s();
            ArrayList arrayList = new ArrayList();
            this.ny = arrayList;
            pr(this.hn, arrayList);
            View viewAj = this.hn.aj();
            ViewGroup viewGroup = (ViewGroup) viewAj.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(viewAj);
            }
            this.zo.addView(this.hn.aj(), new FrameLayout.LayoutParams(iE, iS));
            float fNl = this.fw.nl();
            float fY = this.fw.y();
            float fHn = er.hn(this.hw, fNl);
            float fHn2 = er.hn(this.hw, fY);
            int iC = er.c(this.hw);
            int iAj = (int) (er.aj(this.hw) + er.w(this.hw));
            float f = iC;
            if (fHn > f) {
                fHn = f;
            }
            float f2 = iAj;
            if (fHn2 > f2) {
                fHn2 = f2;
            }
            if (fY <= 0.0f) {
                this.zo.setLayoutParams(new FrameLayout.LayoutParams((int) fHn, -2));
            } else {
                this.zo.setLayoutParams(new FrameLayout.LayoutParams((int) fHn, (int) fHn2));
            }
            if (fY <= 0.0f) {
                this.zo.measure(View.MeasureSpec.makeMeasureSpec((int) fHn, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                int iX = er.x(this.hw, this.zo.getMeasuredWidth());
                int iX2 = er.x(this.hw, this.zo.getMeasuredHeight());
                this.w.pr(iX);
                this.w.hw(iX2);
            } else {
                this.w.pr(er.x(this.hw, fHn));
                this.w.hw(er.x(this.hw, fHn2));
            }
            if (this.qa.get()) {
                fwVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, (String) null);
                return;
            } else {
                fwVar.pr(this.zo, this.w);
                return;
            }
        }
        fwVar.pr(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, (String) null);
    }

    public float[] c() {
        com.byazt.ik.hn<View> hnVar = this.hn;
        if (hnVar == null) {
            return null;
        }
        lb.hw hwVarC = hnVar.c("InteractContainerView");
        if (hwVarC instanceof k) {
            return ((k) hwVarC).od();
        }
        return null;
    }

    public com.byazt.ik.hn fw() {
        com.byazt.ik.hn<View> hnVar = this.hn;
        if (hnVar == null) {
            return null;
        }
        return hnVar.c("VideoPlaceholder");
    }

    public com.byazt.ik.hn zo() {
        com.byazt.ik.hn<View> hnVar = this.hn;
        if (hnVar == null) {
            return null;
        }
        return hnVar.c("PlayableComponent");
    }

    public void hw(com.byazt.mq.fw fwVar) {
        this.pr.pr((lb) this);
        this.pr.pr((a) this);
        this.hn = this.pr.pr(this.x);
        this.fw.n().hw();
        this.fw.n().hn();
        this.pr.hw(this.c);
    }

    public List<com.byazt.ik.hn<View>> aj() {
        return this.ny;
    }

    public boolean vk() {
        return this.gz;
    }

    public JSONObject pr() {
        return this.fw.c();
    }

    public JSONObject w() {
        return this.fw.ww();
    }

    public void hw(boolean z) {
        this.qa.set(z);
    }

    @Override // com.byazt.mq.x
    public View uc() {
        return this.zo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nt() {
        of ofVar = this.uc;
        if (ofVar != null) {
            return ofVar.nl();
        }
        return 0;
    }

    @Override // com.byazt.mq.x
    public void pr(boolean z) {
        this.qa.set(false);
        ny nyVar = this.a;
        if (nyVar != null) {
            nyVar.hw(nt());
        }
        com.byazt.bk.pr prVar = this.cz;
        if (prVar != null) {
            prVar.hw();
        }
        List<com.byazt.ch.zo> list = this.k;
        if (list != null) {
            list.clear();
        }
        if (z) {
            this.iu.hw();
            this.iu.pr((com.byazt.ak.hn) null);
            com.byazt.ak.hw hwVar = this.ve;
            if (hwVar != null) {
                hwVar.zo();
                this.ve = null;
            }
        }
    }

    @Override // com.byazt.mq.x
    public int hw() {
        return ie.hn(this.uc);
    }

    @Override // com.byazt.ch.lb
    public void pr(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        if (ntVar == null) {
            return;
        }
        if (ntVar.hw() == 18) {
            hn(ntVar, hwVar, prVar);
        } else if (ntVar.hw() == 3) {
            x(ntVar, hwVar, prVar);
        } else if (ntVar.hw() == 9) {
            hw(ntVar.hn());
        } else if (ntVar.hw() == 10) {
            pr(ntVar.hn());
        } else if (ntVar.hw() == 21) {
            hw(ntVar);
        } else if (ntVar.hw() == 19) {
            hw(ntVar, hwVar, prVar);
            hn(ntVar);
        } else if (ntVar.hw() == 20 || x(ntVar)) {
            hw(ntVar, hwVar, prVar);
        } else if (ntVar.hw() == 22) {
            pr(ntVar);
        } else {
            pr(ntVar, hwVar, prVar, 0, false);
        }
        if (ntVar.hn() != null) {
            String strOptString = ntVar.hn().optString("next");
            try {
                if (!TextUtils.isEmpty(strOptString)) {
                    nt ntVar2 = new nt();
                    ntVar2.pr(1);
                    ntVar2.pr(new JSONObject(strOptString));
                    ntVar2.pr(this.hn);
                    pr(ntVar2, (lb.hw) null, (lb.pr) null);
                }
            } catch (JSONException e) {
            }
        }
    }

    private void pr(nt ntVar) {
        JSONObject jSONObjectHn;
        if (ntVar != null && (jSONObjectHn = ntVar.hn()) != null) {
            String strOptString = jSONObjectHn.optString("type");
            String strOptString2 = jSONObjectHn.optString("uchain");
            JSONObject jSONObjectOptJSONObject = jSONObjectHn.optJSONObject("params");
            JSONObject jSONObject = new JSONObject();
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, com.byazt.tn.hw.pr(jSONObjectOptJSONObject.optString(next), w()));
                }
            }
            if ("true".equals(strOptString2)) {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                map2.put("material_meta", this.uc);
                HashMap map3 = new HashMap();
                map3.put("ugen_event_params", jSONObject);
                String strHw = ls.hw(this.uc);
                ls.ve();
                com.byazt.lx.hw.pr(this.uc, map, strOptString, map2, strHw, map3, -1L);
            }
        }
    }

    private void hw(nt ntVar) {
        JSONObject jSONObjectHn;
        if (ntVar != null && (jSONObjectHn = ntVar.hn()) != null) {
            com.byazt.xk.hw.pr().hw(this.uc, jSONObjectHn.optString("uttieUrl"));
        }
    }

    private void hn(nt ntVar) {
        JSONObject jSONObjectHn;
        if (ntVar != null && (jSONObjectHn = ntVar.hn()) != null) {
            com.byazt.xk.hw.pr().pr(this.uc, jSONObjectHn.optString("uttieUrl"), jSONObjectHn.optLong("duration"));
        }
    }

    private boolean x(nt ntVar) {
        JSONObject jSONObjectHn;
        return ntVar != null && ntVar.hw() == 1 && (jSONObjectHn = ntVar.hn()) != null && jSONObjectHn.optBoolean("lottieEvent", false);
    }

    /* JADX WARN: switch over string: strings are not added: [[emptyEvent]] */
    private void hw(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        JSONObject jSONObjectHn = ntVar.hn();
        if (jSONObjectHn == null) {
        }
        String strOptString = jSONObjectHn.optString("type", null);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        switch (strOptString) {
            case "close":
                com.byazt.uq.zo zoVar = this.vk;
                if (zoVar != null) {
                    zoVar.pr();
                }
                com.byazt.xk.hw.pr().hn(this.uc, jSONObjectHn.optString("uttieUrl"));
                break;
            case "clickEvent":
                pr(ntVar, hwVar, prVar, 0, true);
                break;
        }
    }

    @Override // com.byazt.ch.lb
    public void pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
    }

    private void hn(final nt ntVar, final lb.hw hwVar, final lb.pr prVar) {
        if (this.a == null) {
            ny nyVar = new ny(com.byazt.sd.a.getContext(), 2, this.fw.aj());
            this.a = nyVar;
            nyVar.pr(this.uc.tm());
            this.a.hn(this.uc.fu());
            this.a.hw(this.uc.qz());
            this.a.pr(this.uc.gv());
            this.a.uc(this.uc.kl());
            this.a.c(this.uc.gg());
            this.a.hw(this.uc.yd());
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final float[] fArr = {0.0f};
        this.a.pr(new ny.pr() { // from class: com.byazt.gu.c.3
            @Override // com.byazt.ca.ny.pr
            public void pr(int i) {
                switch (i) {
                    case 2:
                        c.this.a.hw(c.this.nt());
                        fArr[0] = 0.0f;
                        View viewAj = ((com.byazt.ik.hn) hwVar).aj();
                        if (viewAj != null) {
                            viewAj.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.byazt.gu.c.3.1
                                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                                public void onWindowFocusChanged(boolean z) {
                                    if (z) {
                                        c.this.a.pr(c.this.nt());
                                    } else {
                                        c.this.a.hw(c.this.nt());
                                        fArr[0] = 0.0f;
                                    }
                                }
                            });
                        }
                        AtomicBoolean atomicBoolean2 = atomicBoolean;
                        if (atomicBoolean2 != null) {
                            atomicBoolean2.set(true);
                        }
                        c.this.pr(ntVar, hwVar, prVar, 2, false);
                        break;
                }
            }
        });
        this.a.pr(new ny.hw() { // from class: com.byazt.gu.c.4
            public float pr = 0.0f;
            public float hw = 0.0f;
            public float hn = 0.0f;
            public float x = 0.0f;
            public float c = 0.0f;
            public float uc = 0.0f;
            public long fw = System.currentTimeMillis();

            @Override // com.byazt.ca.ny.hw
            public void pr(float f, float f2, float f3) {
                JSONObject jSONObjectHn;
                View viewAj;
                boolean z;
                float f4;
                float fCeil;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.fw < 100) {
                    return;
                }
                this.fw = jCurrentTimeMillis;
                nt ntVar2 = ntVar;
                if (ntVar2 == null || (jSONObjectHn = ntVar2.hn()) == null) {
                    return;
                }
                double dOptDouble = jSONObjectHn.optDouble("rotateZ", -1.0d);
                if (dOptDouble == -1.0d) {
                    return;
                }
                lb.hw hwVar2 = hwVar;
                if (!(hwVar2 instanceof com.byazt.ik.hn) || (viewAj = ((com.byazt.ik.hn) hwVar2).aj()) == null || !viewAj.isShown()) {
                    return;
                }
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                float fAbs3 = Math.abs(f3);
                AtomicBoolean atomicBoolean2 = atomicBoolean;
                if (atomicBoolean2 != null && atomicBoolean2.get()) {
                    if (f != 0.0f && f2 != 0.0f && f3 != 0.0f) {
                        atomicBoolean.set(false);
                    }
                    this.pr = fAbs;
                    this.hw = fAbs2;
                    this.hn = fAbs3;
                    this.x = f;
                    this.c = f2;
                    this.uc = f3;
                    return;
                }
                float fMax = Math.max(Math.abs(fAbs - this.pr), Math.max(Math.abs(fAbs2 - this.hw), Math.abs(fAbs3 - this.hn)));
                int iQz = c.this.uc.qz();
                if (iQz <= 0) {
                    iQz = 50;
                }
                if (Math.abs(fAbs - this.pr) != fMax) {
                    z = false;
                    f4 = 0.0f;
                } else {
                    f4 = f >= this.x ? fMax : -fMax;
                    z = true;
                }
                if (Math.abs(fAbs2 - this.hw) == fMax) {
                    f4 = f2 >= this.c ? fMax : -fMax;
                    z = true;
                }
                if (Math.abs(fAbs3 - this.hn) != fMax) {
                    fMax = f4;
                } else if (f3 < this.uc) {
                    fMax = -fMax;
                }
                if (c.this.uc.kl() == 0) {
                    fCeil = (float) Math.ceil(((double) (fMax * 180.0f)) / dOptDouble);
                } else {
                    double degrees = Math.toDegrees(fMax);
                    float fCeil2 = (float) Math.ceil(degrees / dOptDouble);
                    if (z && Math.abs(degrees) < iQz - 8) {
                        return;
                    }
                    if (!z) {
                        fCeil = fCeil2;
                    } else {
                        fCeil = -Math.abs(fCeil2);
                    }
                }
                if (Math.abs(fCeil - fArr[0]) < 1.3d) {
                    return;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewAj, "rotation", fArr[0], fCeil);
                objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat.setDuration(100L);
                objectAnimatorOfFloat.start();
                fArr[0] = fCeil;
            }
        });
        this.a.pr(nt());
    }

    private void pr(JSONObject jSONObject) {
        com.byazt.ik.hn<View> hnVar;
        com.byazt.ik.hn hnVarX;
        if (jSONObject == null) {
            return;
        }
        String strPr = com.byazt.tn.hw.pr(jSONObject.optString("type"), w());
        String strPr2 = com.byazt.tn.hw.pr(jSONObject.optString("nodeId"), w());
        if (!TextUtils.isEmpty(strPr2) && (hnVar = this.hn) != null && (hnVarX = hnVar.hw(hnVar).x(strPr2)) != null) {
            if (TextUtils.equals(strPr, "onShow")) {
                hnVarX.hw(0);
                return;
            }
            if (TextUtils.equals(strPr, "onDismiss")) {
                hnVarX.hw(8);
            } else if (TextUtils.equals(strPr, "haptic")) {
                hn(jSONObject);
            } else if (TextUtils.equals(strPr, "dismissScene")) {
                c(jSONObject);
            }
        }
    }

    private void hw(JSONObject jSONObject) {
        com.byazt.ik.hn<View> hnVar;
        com.byazt.ik.hn hnVarX;
        if (jSONObject == null) {
            return;
        }
        String strPr = com.byazt.tn.hw.pr(jSONObject.optString("type"), w());
        String strPr2 = com.byazt.tn.hw.pr(jSONObject.optString("nodeId"), w());
        if (!TextUtils.isEmpty(strPr2) && (hnVar = this.hn) != null && (hnVarX = hnVar.hw(hnVar).x(strPr2)) != null) {
            if (TextUtils.equals(strPr, "onDismiss")) {
                hnVarX.hw(8);
                return;
            }
            if (TextUtils.equals(strPr, "onShow")) {
                hnVarX.hw(0);
            } else if (TextUtils.equals(strPr, "haptic")) {
                hn(jSONObject);
            } else if (TextUtils.equals(strPr, "dismissScene")) {
                c(jSONObject);
            }
        }
    }

    private void x(final nt ntVar, final lb.hw hwVar, final lb.pr prVar) {
        WeakReference<ViewGroup> weakReference = this.ho;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        n.pr(this.ho, new com.byazt.az.hn() { // from class: com.byazt.gu.c.5
            @Override // com.byazt.az.hn
            public void pr() {
                if (c.this.ho != null && c.this.ho.get() != null && n.pr(c.this.ho.get())) {
                    c.this.pr(ntVar, hwVar, prVar, 1, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(nt ntVar, lb.hw hwVar, lb.pr prVar, int i, boolean z) {
        com.byazt.ik.hn hnVarPr;
        int iOptInt;
        JSONObject jSONObjectWw;
        CharSequence text;
        if (ntVar == null || (hnVarPr = ntVar.pr()) == null) {
            return;
        }
        JSONObject jSONObjectHn = ntVar.hn();
        String strPr = com.byazt.tn.hw.pr(jSONObjectHn.optString("nodeId"), w());
        String strPr2 = com.byazt.tn.hw.pr(jSONObjectHn.optString("type"), w());
        if (hn()) {
            HashMap map = new HashMap();
            map.put("ugen_click_event_params", this.g);
            map.put("convert_action_type", Integer.valueOf(i));
            if (com.byazt.fy.pr.pr().pr(ntVar, this.uc, this.hw, hnVarPr, w(), this.m, map)) {
                return;
            }
        }
        int i2 = 8;
        String strOptString = "";
        if (TextUtils.equals(strPr2, "clickEvent")) {
            i2 = 2;
            strOptString = jSONObjectHn.optString("subConvertLinkTag");
            iOptInt = jSONObjectHn.optInt("dpaPosition", -1);
        } else if (TextUtils.equals(strPr2, "muteVideo")) {
            i2 = 5;
            this.fo = jSONObjectHn.optString("muteSrc");
            this.rc = jSONObjectHn.optString("unmuteSrc");
            iOptInt = -1;
        } else if (TextUtils.equals(strPr2, com.byazt.pfl.hw.AD_TAG_DISLIKE)) {
            i2 = 3;
            iOptInt = -1;
        } else if (TextUtils.equals(strPr2, "skip")) {
            i2 = 6;
            iOptInt = -1;
        } else if (TextUtils.equals(strPr2, "openPolicy")) {
            i2 = 7;
            iOptInt = -1;
        } else if (TextUtils.equals(strPr2, "openAppPolicy")) {
            i2 = 9;
            iOptInt = -1;
        } else if (TextUtils.equals(strPr2, "openAppPermission")) {
            i2 = 10;
            iOptInt = -1;
        } else if (TextUtils.equals(strPr2, ILivePush.ClickType.CLOSE)) {
            iOptInt = -1;
        } else if (TextUtils.equals(strPr2, "openAppFunctionDesc")) {
            i2 = 12;
            iOptInt = -1;
        } else if (TextUtils.equals(strPr2, "videoControl") || TextUtils.equals(strPr2, "pauseVideo")) {
            i2 = 4;
            iOptInt = -1;
        } else if (TextUtils.equals(strPr2, "openCommonUrl")) {
            i2 = 13;
            iOptInt = -1;
        } else {
            if (TextUtils.equals(strPr2, "onDismiss")) {
                com.byazt.ik.hn hnVarX = ntVar.pr().hw(ntVar.pr()).x(strPr);
                if (hnVarX != null) {
                    hnVarX.hw(8);
                    return;
                }
                return;
            }
            if (TextUtils.equals(strPr2, "onShow")) {
                com.byazt.ik.hn hnVarX2 = ntVar.pr().hw(ntVar.pr()).x(strPr);
                if (hnVarX2 != null) {
                    hnVarX2.hw(0);
                    return;
                }
                return;
            }
            if (TextUtils.equals(strPr2, "haptic")) {
                hn(ntVar.hn());
                return;
            }
            if (TextUtils.equals(strPr2, "closeWidget")) {
                com.byazt.uq.fw fwVar = this.lb;
                if (fwVar != null) {
                    fwVar.c();
                    return;
                }
                return;
            }
            if (TextUtils.equals(strPr2, "dismiss")) {
                hnVarPr.hw(8);
                return;
            }
            if (TextUtils.equals(strPr2, "renderScene")) {
                x(jSONObjectHn);
                return;
            } else if (!TextUtils.equals(strPr2, "dismissScene")) {
                i2 = 0;
                iOptInt = -1;
            } else {
                c(jSONObjectHn);
                return;
            }
        }
        fo.pr prVarC = new fo.pr().x(this.g.lb()).hn(this.g.qa()).hw(this.g.a()).pr(this.g.cz()).pr(hnVarPr.ww()).hw(this.g.nt()).pr(this.g.yb()).c(strOptString).c(iOptInt);
        JSONObject jSONObject = new JSONObject();
        if (i > 0) {
            try {
                jSONObject.put("convertActionType", i);
            } catch (Throwable th) {
            }
        }
        View viewAj = hnVarPr.aj();
        try {
            if ((viewAj instanceof TextView) && (text = ((TextView) viewAj).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException e) {
        }
        try {
            if (this.uc != null && this.gz && jSONObjectHn.optBoolean("uchain", false)) {
                jSONObject.put("uchain_event_name", strPr2);
            }
        } catch (JSONException e2) {
        }
        try {
            hw hwVar2 = this.fw;
            if (hwVar2 != null && (jSONObjectWw = hwVar2.ww()) != null) {
                jSONObject.put("ugen_id", jSONObjectWw.optString("ugen_id"));
            }
        } catch (JSONException e3) {
        }
        try {
            String strPr3 = com.byazt.tn.hw.pr(jSONObjectHn.optString("webUrl"), w());
            String strPr4 = com.byazt.tn.hw.pr(jSONObjectHn.optString("webTitle"), w());
            jSONObject.put("openCommonWebUrl", strPr3);
            jSONObject.put("openCommonWebTitle", strPr4);
        } catch (JSONException e4) {
        }
        if (z) {
            try {
                jSONObject.put("isLottieInternalClick", true);
            } catch (JSONException e5) {
            }
        }
        prVarC.pr(jSONObject);
        fo foVarPr = prVarC.pr();
        zo zoVar = this.aj;
        if (zoVar != null) {
            zoVar.pr(viewAj, i2, foVarPr, -1);
        }
        if (hwVar != null && ntVar.x() != null) {
            hwVar.pr(ntVar.x());
        }
    }

    private void hn(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return;
        }
        com.byazt.tm.hn.pr(jSONObjectOptJSONObject, this.hw, this.uc);
    }

    private void x(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return;
        }
        pr(jSONObjectOptJSONObject.optString("scene"), jSONObjectOptJSONObject.optString("ugen_id"), jSONObjectOptJSONObject.optString("ugen_md5"), jSONObjectOptJSONObject.optString("ugen_url"), jSONObjectOptJSONObject.optString("displayAreaAndroid"), jSONObjectOptJSONObject.optString("render_sequence"));
    }

    public void pr(String str, String str2, String str3, String str4, String str5, String str6) {
        int i;
        int i2;
        bh bhVarPr;
        String strPr = com.byazt.tn.hw.pr(str, w());
        String strPr2 = com.byazt.tn.hw.pr(str2, w());
        String strPr3 = com.byazt.tn.hw.pr(str3, w());
        String strPr4 = com.byazt.tn.hw.pr(str4, w());
        try {
            i = Integer.parseInt(com.byazt.tn.hw.pr(str5, w()));
        } catch (Exception e) {
            i = 0;
        }
        try {
            i2 = Integer.parseInt(com.byazt.tn.hw.pr(str6, w()));
        } catch (Exception e2) {
            i2 = 2;
        }
        if (!pr(strPr, i)) {
            return;
        }
        com.byazt.ik.hn<View> hnVar = this.hn;
        View viewAj = hnVar != null ? hnVar.aj() : null;
        if (viewAj == null || this.uc == null || (bhVarPr = com.byazt.uq.x.pr(strPr2, strPr3, strPr4, i, i2, 5)) == null || !bhVarPr.k()) {
            return;
        }
        com.byazt.tg.c cVar = new com.byazt.tg.c(this.uc, this.b, bhVarPr);
        this.z = cVar;
        cVar.pr(viewAj);
    }

    private void c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return;
        }
        pr(jSONObjectOptJSONObject.optString("scene"));
    }

    public void pr(String str) {
        com.byazt.uq.fw fwVar;
        if (TextUtils.equals("scene1", com.byazt.tn.hw.pr(str, w())) && (fwVar = this.lb) != null) {
            fwVar.c();
        }
    }

    private boolean pr(String str, int i) {
        return TextUtils.equals("scene1", str) && com.byazt.uq.x.pr(i);
    }

    public void pr(com.byazt.uq.fw fwVar) {
        this.lb = fwVar;
    }

    public void k() {
        com.byazt.ik.hn<T> hnVarX;
        com.byazt.ik.hn<View> hnVar = this.hn;
        if (hnVar != null && (hnVarX = hnVar.x("corver_container")) != 0 && hnVarX.aj() != null) {
            hnVarX.aj().setVisibility(0);
        }
    }

    public void m() {
        com.byazt.ik.hn<T> hnVarX;
        com.byazt.ik.hn<View> hnVar = this.hn;
        if (hnVar != null && (hnVarX = hnVar.x("corver_container")) != 0 && hnVarX.aj() != null) {
            hnVarX.aj().setVisibility(8);
        }
    }

    public void pr(long j, long j2) {
        com.byazt.ik.hn hnVar = this.nt;
        if (hnVar instanceof com.byazt.he.pr) {
            ((com.byazt.he.pr) hnVar).pr(j, j2);
        }
    }

    @Override // com.byazt.imd.x
    public void pr(CharSequence charSequence, int i, int i2, boolean z) {
        com.byazt.ik.hn<View> hnVar = this.hn;
        if (hnVar == null) {
            return;
        }
        com.byazt.ik.hn<T> hnVarX = hnVar.x("count_down_skip_container");
        if (hnVarX != 0 && hnVarX.aj() != null) {
            hnVarX.aj().setVisibility(0);
        }
        lb.hw hwVarX = this.hn.x("count_down");
        lb.hw hwVarX2 = this.hn.x("skip");
        if ((hwVarX instanceof com.byazt.id.hw) && (hwVarX2 instanceof com.byazt.id.hw)) {
            if (i2 != 0) {
                ((com.byazt.id.hw) hwVarX).k(((Object) charSequence) + "s ");
                return;
            }
            if (!TextUtils.equals(charSequence, "0") && !z) {
                ((com.byazt.id.hw) hwVarX).k(((Object) charSequence) + "s ");
                com.byazt.id.hw hwVar = (com.byazt.id.hw) hwVarX2;
                hwVar.k("| 跳过");
                hwVar.aj().setVisibility(0);
                return;
            }
            ((com.byazt.id.hw) hwVarX).aj().setVisibility(8);
            ((com.byazt.id.hw) hwVarX2).k("跳过");
        }
    }

    @Override // com.byazt.imd.x
    public void setSoundMute(boolean z) {
        com.byazt.ik.hn<T> hnVarX;
        com.byazt.ik.hn<View> hnVar = this.hn;
        if (hnVar != null && (hnVarX = hnVar.x("mute_image")) != 0) {
            if (z) {
                if (!TextUtils.isEmpty(this.fo)) {
                    ((com.byazt.hl.hw) hnVarX).k(this.fo);
                }
            } else if (!TextUtils.isEmpty(this.rc)) {
                ((com.byazt.hl.hw) hnVarX).k(this.rc);
            }
            hnVarX.hw();
        }
    }

    @Override // com.byazt.ch.a
    public void pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.g.c((int) motionEvent.getRawX());
                this.g.uc((int) motionEvent.getRawY());
                this.g.pr(motionEvent.getRawX());
                this.g.hw(motionEvent.getRawY());
                this.g.pr(System.currentTimeMillis());
                this.g.hw(motionEvent.getToolType(0));
                this.g.hn(motionEvent.getDeviceId());
                this.g.x(motionEvent.getSource());
                break;
            case 1:
                this.g.hn(motionEvent.getRawX());
                this.g.x(motionEvent.getRawY());
                this.g.hw(System.currentTimeMillis());
                break;
        }
    }

    public void pr(com.byazt.ch.zo zoVar) {
        this.k.add(zoVar);
    }

    public void g() {
        com.byazt.ik.hn<View> hnVar = this.hn;
        if (hnVar == null) {
            return;
        }
        this.iu.pr(hnVar);
        com.byazt.ak.hw hwVar = this.ve;
        if (hwVar != null) {
            this.iu.pr(hwVar);
            this.ve.c();
        }
    }

    public void pr(com.byazt.cy.pr prVar) {
        com.byazt.ak.hw hwVar = this.ve;
        if (hwVar != null) {
            hwVar.pr(prVar);
        }
    }

    public void ho() {
        this.iu.hw();
    }
}
