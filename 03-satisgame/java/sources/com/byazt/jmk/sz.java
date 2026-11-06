package com.byazt.jmk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.ShakeAnimationView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 110})
public class sz implements k, x<ShakeAnimationView> {
    public boolean fs;
    public com.byazt.lh.x l;
    public int n;
    public DynamicBaseWidget q;
    public ShakeAnimationView qg;
    public Context s;
    public String w;
    public com.byazt.lh.tj x;

    public sz(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar, String str, com.byazt.lh.tj tjVar, boolean z, int i) {
        this.s = context;
        this.q = dynamicBaseWidget;
        this.l = xVar;
        this.w = str;
        this.x = tjVar;
        this.fs = z;
        this.n = i;
        w();
    }

    private void w() {
        final com.byazt.xnr.n dynamicClickListener = this.q.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.n(jSONObject);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.w)) {
            Context context = this.s;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.byazt.xta.qg.fs(context), this.x, this.fs, this.n);
            this.qg = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.qg.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.s;
            this.qg = new ShakeAnimationView(context2, com.byazt.xta.qg.x(context2), this.x, this.fs, this.n);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.qg.setGravity(17);
        layoutParams.gravity = 17;
        this.qg.setLayoutParams(layoutParams);
        this.qg.setTranslationY(com.byazt.cq.fs.n(this.s, this.l.hf()));
        this.qg.setShakeText(this.l.b());
        this.qg.setClipChildren(false);
        this.qg.setOnShakeViewListener(new ShakeAnimationView.n() { // from class: com.byazt.jmk.sz.1
            @Override // com.byazt.stl.ShakeAnimationView.n
            public void n(boolean z) {
                com.byazt.xnr.n nVar = dynamicClickListener;
                if (nVar != null) {
                    nVar.n(z, sz.this);
                }
                sz.this.qg.setOnClickListener((View.OnClickListener) dynamicClickListener);
                sz.this.qg.performClick();
                if (sz.this.l == null || !sz.this.l.pe()) {
                    return;
                }
                sz.this.qg.setOnClickListener(null);
            }
        });
    }

    @Override // com.byazt.jmk.x
    public void n() {
        this.qg.n();
    }

    @Override // com.byazt.jmk.x
    public void qg() {
        this.qg.clearAnimation();
    }

    @Override // com.byazt.jmk.x
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public ShakeAnimationView s() {
        return this.qg;
    }

    @Override // com.byazt.jmk.k
    public void l() {
        if (this.qg.getParent() != null) {
            ((ViewGroup) this.qg.getParent()).setVisibility(8);
        }
    }
}
