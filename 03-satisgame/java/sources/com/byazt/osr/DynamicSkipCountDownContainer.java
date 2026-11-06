package com.byazt.osr;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.lh.fs;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2568})
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements com.byazt.tq.s {
    public int a;
    public int n;
    public int qg;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        rv();
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.s()), (int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.qg()), (int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.q()), (int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.n()));
        return true;
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public void l() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.rv;
        layoutParams.topMargin = this.tj;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a == 0) {
            setMeasuredDimension(this.qg, this.fs);
        } else {
            setMeasuredDimension(this.n, this.fs);
        }
    }

    @Override // com.byazt.tq.s
    public void n(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.a = i;
    }

    private void rv() {
        List<fs> listCp = this.oa.cp();
        if (listCp == null || listCp.size() <= 0) {
            return;
        }
        for (fs fsVar : listCp) {
            if (fsVar.tj().n() == 21) {
                this.n = (int) (this.x - com.byazt.cq.fs.n(this.cp, fsVar.fs()));
            }
            if (fsVar.tj().n() == 20) {
                this.qg = (int) (this.x - com.byazt.cq.fs.n(this.cp, fsVar.fs()));
            }
        }
    }
}
