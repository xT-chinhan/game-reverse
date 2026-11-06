package com.bytedance.sdk.openadsdk.core.ugeno.ah;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.bytedance.adsdk.ugeno.ah.ao;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.ch;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.zb.ka;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms implements ao {
    private float ab;
    private boolean c;
    private float ch;
    private long hi;
    private float ny;
    private com.bytedance.adsdk.ugeno.xr.ah sl;
    private float x;

    public ah(Activity activity, ViewGroup viewGroup, ka kaVar, lm lmVar, String str, int i, com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar) {
        super(activity, viewGroup, kaVar, lmVar, str, i, msVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ah.ms
    protected void ms(JSONObject jSONObject) {
        this.xr.ms((ao) this);
        try {
            jSONObject.put("isPlayable", "true");
            jSONObject.put("remainTime", ka());
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    private int ka() {
        return (int) (((double) (nw.ka(this.f3401ms) * this.f3401ms.cb())) / 100.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ah.ms
    protected void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
        this.sl = ahVar.ah("fl_count_down");
    }

    private void ms(MotionEvent motionEvent) {
        if (!this.c) {
            int iX = ul.x(re.getContext());
            com.bytedance.sdk.openadsdk.core.zb.ah.ms("click", this.f3401ms, new ch.ms().c(this.ab).ka(this.x).d(this.ny).ah(this.ch).xr(this.hi).ms(motionEvent.getEventTime()).ah(motionEvent.getToolType(0)).d(motionEvent.getDeviceId()).ka(this.ka).xr(com.bytedance.sdk.openadsdk.core.ch.ub().ah() ? 1 : 2).ms(iX).ms(ul.c(re.getContext())).xr(ul.ab(re.getContext())).ms(), this.d, true, null, -1, false);
        }
        this.c = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ah.ms
    public void d() {
        super.d();
        c();
    }

    private void c() {
        Animation animation;
        com.bytedance.adsdk.ugeno.xr.ah ahVar = this.sl;
        if (ahVar != null) {
            ahVar.xr(8);
            View viewNy = this.sl.ny();
            if (viewNy == null || (animation = viewNy.getAnimation()) == null) {
                return;
            }
            animation.cancel();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ao
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, MotionEvent motionEvent) {
        if (motionEvent == null || this.c) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.hi = motionEvent.getDownTime();
            this.ab = motionEvent.getRawX();
            this.x = motionEvent.getRawY();
            c();
            return;
        }
        if (action != 1) {
            return;
        }
        this.ny = motionEvent.getRawX();
        this.ch = motionEvent.getRawY();
        ms(motionEvent);
    }
}
