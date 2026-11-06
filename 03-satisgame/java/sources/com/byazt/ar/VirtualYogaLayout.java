package com.byazt.ar;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.gr.cp;
import com.byazt.gr.tj;
import com.byazt.gr.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 206, 2439})
public class VirtualYogaLayout extends ViewGroup {
    public final List<View> n;
    public final Map<View, tj> qg;
    public final tj s;

    public tj getYogaNode() {
        return this.s;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.n(this);
            tj yogaNode = virtualYogaLayout.getYogaNode();
            tj tjVar = this.s;
            tjVar.n(yogaNode, tjVar.n());
            return;
        }
        tj tjVarN = cp.n();
        YogaLayout.n(new YogaLayout.n(layoutParams), tjVarN, view);
        tjVarN.n(view);
        tjVarN.n((x) new YogaLayout.qg());
        tj tjVar2 = this.s;
        tjVar2.n(tjVarN, tjVar2.n());
        n(view, tjVarN);
    }

    public void n(View view, tj tjVar) {
        this.n.add(view);
        this.qg.put(view, tjVar);
    }

    public void n(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.n) {
                ((VirtualYogaLayout) viewGroup).n(view, this.qg.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.n) {
                ((YogaLayout) viewGroup).n(view2, this.qg.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.n.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.n(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.n(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.n;
    }
}
