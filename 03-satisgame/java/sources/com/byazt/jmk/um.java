package com.byazt.jmk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.WriggleGuideAnimationView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 33})
public class um implements x<WriggleGuideAnimationView> {
    public boolean fs;
    public com.byazt.lh.x l;
    public int n;
    public DynamicBaseWidget q;
    public WriggleGuideAnimationView qg;
    public Context s;
    public String w;
    public com.byazt.lh.tj x;

    public um(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar, String str, com.byazt.lh.tj tjVar, boolean z, int i) {
        this.s = context;
        this.q = dynamicBaseWidget;
        this.l = xVar;
        this.w = str;
        this.x = tjVar;
        this.fs = z;
        this.n = i;
        l();
    }

    private void l() {
        int iSh = this.l.sh();
        final com.byazt.xnr.n dynamicClickListener = this.q.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.n(jSONObject);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.w)) {
            Context context = this.s;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.byazt.xta.qg.rv(context), this.x, this.fs, this.n);
            this.qg = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.qg.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.qg.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.l.kc())) {
                    this.qg.getTopTextView().setText("扭动手机 或 点击图标");
                } else {
                    this.qg.getTopTextView().setText(this.l.kc());
                }
            }
        } else {
            Context context2 = this.s;
            this.qg = new WriggleGuideAnimationView(context2, com.byazt.xta.qg.rv(context2), this.x, this.fs, this.n);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.qg.setTranslationY(-((int) com.byazt.cq.fs.n(this.s, iSh)));
        this.qg.setLayoutParams(layoutParams);
        this.qg.setShakeText(this.l.b());
        this.qg.setClipChildren(false);
        final View wriggleProgressIv = this.qg.getWriggleProgressIv();
        this.qg.setOnShakeViewListener(new WriggleGuideAnimationView.n() { // from class: com.byazt.jmk.um.1
            @Override // com.byazt.stl.WriggleGuideAnimationView.n
            public void n() {
                if (wriggleProgressIv != null) {
                    if (um.this.qg != null) {
                        um.this.qg.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        um.this.qg.performClick();
                    }
                    if (um.this.l == null || !um.this.l.pe()) {
                        return;
                    }
                    um.this.qg.setOnClickListener(null);
                }
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
    public WriggleGuideAnimationView s() {
        return this.qg;
    }
}
