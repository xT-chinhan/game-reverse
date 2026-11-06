package com.bytedance.adsdk.ugeno.yoga.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.yoga.ab;
import com.bytedance.adsdk.ugeno.yoga.ch;
import com.bytedance.adsdk.ugeno.yoga.hi;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class VirtualYogaLayout extends ViewGroup {
    private final ch ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<View> f448ms;
    private final Map<View, ch> xr;

    public ch getYogaNode() {
        return this.ah;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.ms(this);
            ch yogaNode = virtualYogaLayout.getYogaNode();
            ch chVar = this.ah;
            chVar.ms(yogaNode, chVar.ms());
            return;
        }
        ch chVarMs = hi.ms();
        YogaLayout.ms(new YogaLayout.ms(layoutParams), chVarMs, view);
        chVarMs.ms(view);
        chVarMs.ms((ab) new YogaLayout.xr());
        ch chVar2 = this.ah;
        chVar2.ms(chVarMs, chVar2.ms());
        ms(view, chVarMs);
    }

    public void ms(View view, ch chVar) {
        this.f448ms.add(view);
        this.xr.put(view, chVar);
    }

    protected void ms(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.f448ms) {
                ((VirtualYogaLayout) viewGroup).ms(view, this.xr.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.f448ms) {
                ((YogaLayout) viewGroup).ms(view2, this.xr.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.f448ms.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.ms(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.ms(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.ms;
    }
}
