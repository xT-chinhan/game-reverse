package com.byazt.iza;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.byazt.dd.nt;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 124, 37})
public class pr extends AnimatorListenerAdapter {
    public int c;
    public com.byazt.vf.pr fw;
    public ValueAnimator hn;
    public hn hw;
    public com.byazt.ik.hn pr;
    public Context x;
    public String zo;
    public int uc = 1;
    public List<hw> aj = new CopyOnWriteArrayList();

    public pr(Context context, com.byazt.ik.hn hnVar, hn hnVar2) {
        this.pr = hnVar;
        this.hw = hnVar2;
        this.x = context;
    }

    public void pr() {
        ValueAnimator valueAnimator = this.hn;
        if (valueAnimator != null && this.uc != 0 && this.c != Integer.MIN_VALUE) {
            valueAnimator.start();
        }
    }

    public void pr(hw hwVar) {
        if (hwVar != null && !this.aj.contains(hwVar)) {
            this.aj.add(hwVar);
        }
    }

    public void hw(hw hwVar) {
        if (hwVar != null) {
            this.aj.remove(hwVar);
        }
    }

    public void hw() {
        ValueAnimator valueAnimator = this.hn;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void hn() {
        ValueAnimator valueAnimator = this.hn;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public ValueAnimator x() {
        com.byazt.ahr.pr hwVar;
        hn hnVar = this.hw;
        if (hnVar == null || this.pr == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> mapHw = hnVar.hw();
        ArrayList arrayList = new ArrayList();
        if (mapHw != null && !mapHw.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : mapHw.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    switch (c.pr(key).hn()) {
                        case "float":
                            hwVar = new com.byazt.ahr.hw(this.x, this.pr, key, entry.getValue());
                            break;
                        case "int":
                            hwVar = new com.byazt.ahr.hn(this.x, this.pr, key, entry.getValue());
                            break;
                        case "point":
                            hwVar = new com.byazt.ahr.x(this.x, this.pr, key, entry.getValue());
                            break;
                        default:
                            hwVar = null;
                            break;
                    }
                    if (hwVar != null) {
                        arrayList.addAll(hwVar.c());
                    }
                }
            }
        }
        JSONObject jSONObjectPr = this.hw.pr();
        if (jSONObjectPr != null) {
            com.byazt.vf.pr prVarPr = com.byazt.vf.pr.C0211pr.pr(this.pr, jSONObjectPr);
            this.fw = prVarPr;
            if (prVarPr != null) {
                arrayList.addAll(prVarPr.hn());
            }
        }
        final View viewAj = this.pr.aj();
        if (viewAj == null) {
            return null;
        }
        final hn.pr prVarFw = this.hw.fw();
        if (prVarFw != null) {
            viewAj.post(new Runnable() { // from class: com.byazt.iza.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = viewAj.getWidth();
                    int height = viewAj.getHeight();
                    viewAj.setPivotX(x.pr(prVarFw.pr, width));
                    viewAj.setPivotY(x.pr(prVarFw.hw, height));
                }
            });
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewAj, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.c = x.pr(this.hw.x());
        objectAnimatorOfPropertyValuesHolder.setDuration(this.hw.hn());
        int i = this.c;
        if (i != Integer.MIN_VALUE) {
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(i);
        }
        this.uc = this.hw.vk();
        this.zo = this.hw.aj();
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.hw.uc());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(x.pr(this.hw.c()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(x.hw(this.hw.zo()));
        objectAnimatorOfPropertyValuesHolder.addListener(this);
        this.hn = objectAnimatorOfPropertyValuesHolder;
        return objectAnimatorOfPropertyValuesHolder;
    }

    public void pr(Canvas canvas) {
        com.byazt.vf.pr prVar = this.fw;
        if (prVar != null) {
            prVar.pr(canvas);
        }
    }

    public void hw(Canvas canvas) {
        com.byazt.vf.pr prVar = this.fw;
        if (prVar != null) {
            prVar.hw(canvas);
        }
    }

    public void pr(int i, int i2) {
        com.byazt.vf.pr prVar = this.fw;
        if (prVar != null) {
            prVar.pr(i, i2);
        }
    }

    public String c() {
        return this.zo;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        com.byazt.ik.hn hnVar = this.pr;
        nt ntVarHn = (hnVar == null || hnVar.ls() == null) ? null : this.pr.ls().hn();
        if (ntVarHn != null && ntVarHn.pr("animateState", "")) {
            pr(TrackAction.START);
        }
        for (hw hwVar : this.aj) {
            if (hwVar != null) {
                hwVar.pr();
            }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        com.byazt.ik.hn hnVar = this.pr;
        nt ntVarHn = (hnVar == null || hnVar.ls() == null) ? null : this.pr.ls().hn();
        if (ntVarHn != null && ntVarHn.pr("animateState", "")) {
            pr("complete");
        }
        for (hw hwVar : this.aj) {
            if (hwVar != null) {
                hwVar.hw();
            }
        }
    }

    private void pr(String str) {
        nt ntVarHn;
        com.byazt.ik.hn hnVar = this.pr;
        if (hnVar == null || hnVar.ls() == null || (ntVarHn = this.pr.ls().hn()) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(Common.System.NAME, this.zo);
        map.put("state", str);
        ntVarHn.pr(this.pr.ls().x(), "animateState", map);
    }
}
