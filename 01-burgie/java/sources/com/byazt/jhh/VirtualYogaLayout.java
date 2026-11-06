package com.byazt.jhh;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.fty.fw;
import com.byazt.fty.vk;
import com.byazt.fty.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 2252})
public class VirtualYogaLayout extends ViewGroup {
    public final vk hn;
    public final Map<View, vk> hw;
    public final List<View> pr;

    public vk getYogaNode() {
        return this.hn;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.pr(this);
            vk yogaNode = virtualYogaLayout.getYogaNode();
            vk vkVar = this.hn;
            vkVar.pr(yogaNode, vkVar.pr());
            return;
        }
        vk vkVarPr = w.pr();
        YogaLayout.pr(new YogaLayout.pr(layoutParams), vkVarPr, view);
        vkVarPr.pr(view);
        vkVarPr.pr((fw) new YogaLayout.hw());
        vk vkVar2 = this.hn;
        vkVar2.pr(vkVarPr, vkVar2.pr());
        pr(view, vkVarPr);
    }

    public void pr(View view, vk vkVar) {
        this.pr.add(view);
        this.hw.put(view, vkVar);
    }

    public void pr(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.pr) {
                ((VirtualYogaLayout) viewGroup).pr(view, this.hw.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.pr) {
                ((YogaLayout) viewGroup).pr(view2, this.hw.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.pr.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.pr(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.pr(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.pr;
    }
}
