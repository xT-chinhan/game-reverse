package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.byazt.cq.x;
import com.byazt.lh.fs;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1414})
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.byazt.tq.s {
    public int a;
    public int n;
    public boolean ou;
    public int py;
    public boolean qg;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.py = 0;
        setTag(Integer.valueOf(getClickArea()));
        rv();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().t()) {
            return;
        }
        if (this.k != null) {
            this.k.setVisibility(8);
        }
        setVisibility(8);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public void l() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.qg) {
            layoutParams.leftMargin = this.rv;
        } else {
            layoutParams.leftMargin = this.rv + this.py;
        }
        if (this.ou && this.d != null) {
            layoutParams.leftMargin = ((this.rv + this.py) - ((int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.s()))) - ((int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.q()));
        }
        if (com.byazt.twc.q.n()) {
            layoutParams.topMargin = this.tj - ((int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.qg()));
        } else {
            layoutParams.topMargin = this.tj;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        if (x.qg(this.sz.getRenderRequest().w())) {
            return true;
        }
        super.fs();
        setPadding((int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.s()), (int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.qg()), (int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.q()), (int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.n()));
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ou && this.d != null) {
            setMeasuredDimension(this.a + ((int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.s())) + ((int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.q())), this.fs);
        } else if (this.qg) {
            setMeasuredDimension(this.x, this.fs);
        } else {
            setMeasuredDimension(this.n, this.fs);
        }
    }

    private void rv() {
        List<fs> listCp = this.oa.cp();
        if (listCp == null || listCp.size() <= 0) {
            return;
        }
        for (fs fsVar : listCp) {
            if (TextUtils.equals("skip-with-time-skip-btn", fsVar.tj().getType())) {
                this.a = (int) com.byazt.cq.fs.n(this.cp, fsVar.fs() + (com.byazt.twc.q.n() ? fsVar.oa() : 0));
                this.n = this.x - this.a;
                break;
            }
        }
        this.py = this.x - this.n;
    }

    @Override // com.byazt.tq.s
    public void n(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.ou != z2) {
            this.ou = z2;
            l();
            return;
        }
        if (z && this.qg != z) {
            this.qg = z;
            l();
        }
        this.qg = z;
    }
}
