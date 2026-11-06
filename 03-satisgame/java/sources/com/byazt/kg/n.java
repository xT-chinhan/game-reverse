package com.byazt.kg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.byazt.xz.cy;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1238, 19})
public class n extends AnimatorListenerAdapter {
    public String fs;
    public int l;
    public com.byazt.ih.s n;
    public Context q;
    public s qg;
    public ValueAnimator s;
    public com.byazt.pw.n x;
    public int w = 1;
    public List<qg> rv = new CopyOnWriteArrayList();

    public n(Context context, com.byazt.ih.s sVar, s sVar2) {
        this.n = sVar;
        this.qg = sVar2;
        this.q = context;
    }

    public void n() {
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator == null || this.w == 0 || this.l == Integer.MIN_VALUE) {
            return;
        }
        valueAnimator.start();
    }

    public void n(qg qgVar) {
        if (qgVar == null || this.rv.contains(qgVar)) {
            return;
        }
        this.rv.add(qgVar);
    }

    public void qg(qg qgVar) {
        if (qgVar != null) {
            this.rv.remove(qgVar);
        }
    }

    public void qg() {
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void s() {
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public ValueAnimator q() {
        com.byazt.bt.n sVar;
        s sVar2 = this.qg;
        if (sVar2 == null || this.n == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> mapQg = sVar2.qg();
        ArrayList arrayList = new ArrayList();
        if (mapQg != null && !mapQg.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : mapQg.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String strS = l.n(key).s();
                    strS.hashCode();
                    switch (strS) {
                        case "int":
                            sVar = new com.byazt.bt.s(this.q, this.n, key, entry.getValue());
                            break;
                        case "float":
                            sVar = new com.byazt.bt.qg(this.q, this.n, key, entry.getValue());
                            break;
                        case "point":
                            sVar = new com.byazt.bt.q(this.q, this.n, key, entry.getValue());
                            break;
                        default:
                            sVar = null;
                            break;
                    }
                    if (sVar != null) {
                        arrayList.addAll(sVar.l());
                    }
                }
            }
        }
        JSONObject jSONObjectN = this.qg.n();
        if (jSONObjectN != null) {
            com.byazt.pw.n nVarN = com.byazt.pw.n.C0307n.n(this.n, jSONObjectN);
            this.x = nVarN;
            if (nVarN != null) {
                arrayList.addAll(nVarN.s());
            }
        }
        final View viewRv = this.n.rv();
        if (viewRv == null) {
            return null;
        }
        final s.n nVarX = this.qg.x();
        if (nVarX != null) {
            viewRv.post(new Runnable() { // from class: com.byazt.kg.n.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = viewRv.getWidth();
                    int height = viewRv.getHeight();
                    viewRv.setPivotX(q.n(nVarX.n, width));
                    viewRv.setPivotY(q.n(nVarX.qg, height));
                }
            });
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewRv, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.l = q.n(this.qg.q());
        objectAnimatorOfPropertyValuesHolder.setDuration(this.qg.s());
        int i = this.l;
        if (i != Integer.MIN_VALUE) {
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(i);
        }
        this.w = this.qg.tj();
        this.fs = this.qg.rv();
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.qg.w());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(q.n(this.qg.l()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(q.qg(this.qg.fs()));
        objectAnimatorOfPropertyValuesHolder.addListener(this);
        this.s = objectAnimatorOfPropertyValuesHolder;
        return objectAnimatorOfPropertyValuesHolder;
    }

    public void n(Canvas canvas) {
        com.byazt.pw.n nVar = this.x;
        if (nVar != null) {
            nVar.n(canvas);
        }
    }

    public void qg(Canvas canvas) {
        com.byazt.pw.n nVar = this.x;
        if (nVar != null) {
            nVar.qg(canvas);
        }
    }

    public void n(int i, int i2) {
        com.byazt.pw.n nVar = this.x;
        if (nVar != null) {
            nVar.n(i, i2);
        }
    }

    public String l() {
        return this.fs;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        com.byazt.ih.s sVar = this.n;
        cy cyVarS = (sVar == null || sVar.f() == null) ? null : this.n.f().s();
        if (cyVarS != null && cyVarS.n("animateState", "")) {
            n("start");
        }
        for (qg qgVar : this.rv) {
            if (qgVar != null) {
                qgVar.n();
            }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        com.byazt.ih.s sVar = this.n;
        cy cyVarS = (sVar == null || sVar.f() == null) ? null : this.n.f().s();
        if (cyVarS != null && cyVarS.n("animateState", "")) {
            n("complete");
        }
        for (qg qgVar : this.rv) {
            if (qgVar != null) {
                qgVar.qg();
            }
        }
    }

    private void n(String str) {
        cy cyVarS;
        com.byazt.ih.s sVar = this.n;
        if (sVar == null || sVar.f() == null || (cyVarS = this.n.f().s()) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(TapEventParamConstants.PARAM_NAME, this.fs);
        map.put(WebLoginFragment.QUERY_KEY_ID, str);
        cyVarS.n(this.n.f().q(), "animateState", map);
    }
}
