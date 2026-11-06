package com.byazt.le;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.byazt.ch.a;
import com.byazt.hg.aj;
import com.byazt.hg.of;
import com.byazt.pj.x;
import com.byazt.ri.c;
import com.byazt.sd.zo;
import com.byazt.vkw.g;
import com.byazt.wt.er;
import com.byazt.wt.ny;
import com.byazt.zs.uc;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 953, 20})
public class hn extends pr implements a {
    public float aj;
    public float fw;
    public com.byazt.ik.hn k;
    public boolean uc;
    public float vk;
    public long w;
    public float zo;

    public hn(Activity activity, ViewGroup viewGroup, x xVar, of ofVar, String str, int i, com.byazt.mm.pr prVar) {
        super(activity, viewGroup, xVar, ofVar, str, i, prVar);
    }

    @Override // com.byazt.le.pr
    public void pr(JSONObject jSONObject) {
        this.hw.pr((a) this);
        try {
            jSONObject.put("isPlayable", "true");
            jSONObject.put("remainTime", c());
        } catch (Exception e) {
        }
    }

    private int c() {
        return (int) (((double) (ny.c(this.pr) * this.pr.bt())) / 100.0d);
    }

    @Override // com.byazt.le.pr
    public void pr(com.byazt.ik.hn<View> hnVar) {
        this.k = hnVar.x("fl_count_down");
    }

    private void pr(MotionEvent motionEvent) {
        if (!this.uc) {
            int iA = ((g) uc.pr("device_info_new")).a();
            com.byazt.pj.pr.pr("click", this.pr, new aj.pr().uc(this.fw).c(this.zo).x(this.aj).hn(this.vk).hw(this.w).pr(motionEvent.getEventTime()).x(motionEvent.getToolType(0)).c(motionEvent.getDeviceId()).uc(this.c).hn(zo.nt().hw() ? 1 : 2).hw(iA).pr(er.fw(com.byazt.sd.a.getContext())).hw(er.zo(com.byazt.sd.a.getContext())).pr(c.hw(this.pr)).pr(), this.x, true, (Map<String, Object>) null, -1, false, false);
        }
        this.uc = true;
    }

    @Override // com.byazt.le.pr
    public void x() {
        super.x();
        uc();
    }

    private void uc() {
        Animation animation;
        com.byazt.ik.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.hw(8);
            View viewAj = this.k.aj();
            if (viewAj != null && (animation = viewAj.getAnimation()) != null) {
                animation.cancel();
            }
        }
    }

    @Override // com.byazt.ch.a
    public void pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent) {
        if (motionEvent == null || this.uc) {
            return;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.w = motionEvent.getDownTime();
                this.fw = motionEvent.getRawX();
                this.zo = motionEvent.getRawY();
                uc();
                break;
            case 1:
                this.aj = motionEvent.getRawX();
                this.vk = motionEvent.getRawY();
                pr(motionEvent);
                break;
        }
    }
}
