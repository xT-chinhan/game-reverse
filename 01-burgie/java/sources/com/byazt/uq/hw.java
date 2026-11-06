package com.byazt.uq;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.byazt.hg.bh;
import com.byazt.hg.nt;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 13})
public abstract class hw {
    public com.byazt.fq.pr hn;
    public pr hw;
    public of pr;
    public EasyPlayableContainer x;

    public abstract com.byazt.hg.m hw();

    public abstract fw pr();

    public hw(of ofVar, pr prVar) {
        this.pr = ofVar;
        this.hw = prVar;
    }

    public void pr(com.byazt.ti.hw hwVar) {
        com.byazt.fq.pr prVar = this.hn;
        if (prVar != null) {
            prVar.pr(hwVar);
        }
    }

    public void pr(final ViewGroup viewGroup, final View view, final View view2, final float[] fArr) {
        final HashMap map = new HashMap();
        final com.byazt.hg.m mVarHw = hw();
        if (viewGroup == null || view == null) {
            com.byazt.qd.uc.hn(com.byazt.ewt.fw.pr(this.pr), 2);
            hn.hw(this.pr, mVarHw, false, 101, null);
        } else if (view2 == null) {
            com.byazt.qd.uc.hn(com.byazt.ewt.fw.pr(this.pr), 2);
            hn.hw(this.pr, mVarHw, false, 102, null);
        } else {
            view.post(new Runnable() { // from class: com.byazt.uq.hw.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.hg.m mVar = mVarHw;
                    if (mVar == null) {
                        return;
                    }
                    nt ntVarPr = null;
                    if (mVar.hw()) {
                        boolean[] zArr = {true};
                        ntVarPr = x.pr(zArr, fArr, hw.this.hn, view.getWidth(), view.getHeight(), 0.8d);
                        if (!zArr[0]) {
                            com.byazt.qd.uc.hn(com.byazt.ewt.fw.pr(hw.this.pr), 2);
                            hw hwVar = hw.this;
                            hwVar.pr(hwVar.hn);
                            return;
                        }
                    }
                    if (view2.getParent() != null) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                    }
                    hw.this.x = new EasyPlayableContainer(a.getContext(), hw.this.pr(), ntVarPr, hw.this.pr, mVarHw);
                    com.byazt.hg.m mVar2 = mVarHw;
                    if (mVar2 instanceof bh) {
                        hw.this.x.setIfStayTop(((bh) mVar2).uc());
                    }
                    switch (mVarHw.pr()) {
                        case 1:
                        case 2:
                            hw.this.x.setTag("easy_play_tag");
                            break;
                        case 3:
                            hw.this.x.setTag("overlay_tag");
                            break;
                        case 4:
                            hw.this.x.setTag("effects_tag");
                            break;
                        case 5:
                            hw.this.x.setTag("fullscreen_tag");
                            break;
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                    layoutParams.gravity = 17;
                    hw.this.x.addView(view2, layoutParams);
                    map.put("container_name", viewGroup.getClass().getName());
                    map.put("enable_layout_restrict", Boolean.valueOf(a.hw().yc()));
                    hw hwVar2 = hw.this;
                    if (hwVar2.pr(viewGroup, view, hwVar2.x)) {
                        EasyPlayableContainer.pr(viewGroup);
                        if (mVarHw.pr() == 1) {
                            hw hwVar3 = hw.this;
                            hwVar3.pr(hwVar3.hn, ntVarPr);
                        }
                        com.byazt.qd.uc.hn(com.byazt.ewt.fw.pr(hw.this.pr), 1);
                        hn.pr(hw.this.pr, mVarHw, true, new JSONObject(map));
                        hw.this.hn();
                        return;
                    }
                    com.byazt.qd.uc.hn(com.byazt.ewt.fw.pr(hw.this.pr), 2);
                    hn.hw(hw.this.pr, mVarHw, false, 202, new JSONObject(map));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(ViewGroup viewGroup, View view, View view2) {
        if (x.pr(viewGroup) || viewGroup == null || view == null || view2 == null) {
            return false;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr);
        viewGroup.getLocationInWindow(iArr2);
        int i = iArr[0] - iArr2[0];
        int i2 = iArr[1] - iArr2[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return false;
        }
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
            layoutParams.setMargins(i, i2, 0, 0);
            viewGroup.addView(view2, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(width, height);
            layoutParams2.setMargins(i, i2, 0, 0);
            viewGroup.addView(view2, layoutParams2);
        } else {
            x.pr(viewGroup, view2, width, height, i, i2);
        }
        return true;
    }

    public void hn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.fq.pr prVar, nt ntVar) {
        if (prVar != null) {
            prVar.pr(true, nt.pr(ntVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.fq.pr prVar) {
        if (prVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.ERROR_CODE_FIELD, 1);
            } catch (JSONException e) {
                e.getMessage();
            }
            prVar.pr(false, jSONObject);
        }
    }
}
