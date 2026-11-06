package com.byazt.fj;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.byazt.gct.pk;
import com.byazt.gct.rv;
import com.byazt.hm.q;
import com.byazt.oh.l;
import com.byazt.vf.oa;
import com.byazt.vh.a;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 695, 8})
public class s extends n implements a {
    public long cp;
    public com.byazt.ih.s d;
    public float fs;
    public float rv;
    public float tj;
    public boolean w;
    public float x;

    public s(Activity activity, ViewGroup viewGroup, q qVar, pk pkVar, String str, int i, com.byazt.cs.n nVar) {
        super(activity, viewGroup, qVar, pkVar, str, i, nVar);
    }

    @Override // com.byazt.fj.n
    public void n(JSONObject jSONObject) {
        this.qg.n((a) this);
        try {
            jSONObject.put("isPlayable", "true");
            jSONObject.put("remainTime", l());
        } catch (Exception unused) {
        }
    }

    private int l() {
        return (int) (((double) (com.byazt.qq.qg.l(this.n) * this.n.gr())) / 100.0d);
    }

    @Override // com.byazt.fj.n
    public void n(com.byazt.ih.s<View> sVar) {
        this.d = sVar.q("fl_count_down");
    }

    private void n(MotionEvent motionEvent) {
        if (!this.w) {
            int iA = ((oa) com.byazt.qp.q.n("device_info_new")).a();
            com.byazt.hm.n.n("click", this.n, new rv.n().w(this.x).l(this.fs).q(this.rv).s(this.tj).qg(this.cp).n(motionEvent.getEventTime()).q(motionEvent.getToolType(0)).l(motionEvent.getDeviceId()).w(this.l).s(com.byazt.vyf.s.cy().qg() ? 1 : 2).qg(iA).n(com.byazt.okk.s.x(com.byazt.nf.rv.getContext())).qg(com.byazt.okk.s.fs(com.byazt.nf.rv.getContext())).n(l.qg(this.n)).n(), this.q, true, (Map<String, Object>) null, -1, false, false);
        }
        this.w = true;
    }

    @Override // com.byazt.fj.n
    public void q() {
        super.q();
        w();
    }

    private void w() {
        Animation animation;
        com.byazt.ih.s sVar = this.d;
        if (sVar != null) {
            sVar.qg(8);
            View viewRv = this.d.rv();
            if (viewRv == null || (animation = viewRv.getAnimation()) == null) {
                return;
            }
            animation.cancel();
        }
    }

    @Override // com.byazt.vh.a
    public void n(com.byazt.ih.s sVar, MotionEvent motionEvent) {
        if (motionEvent == null || this.w) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.cp = motionEvent.getDownTime();
            this.x = motionEvent.getRawX();
            this.fs = motionEvent.getRawY();
            w();
            return;
        }
        if (action != 1) {
            return;
        }
        this.rv = motionEvent.getRawX();
        this.tj = motionEvent.getRawY();
        n(motionEvent);
    }
}
