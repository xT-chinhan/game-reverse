package com.byazt.gx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.mo.ThemeStatusBroadcastReceiver;
import com.byazt.mq.g;
import com.byazt.mq.m;
import com.byazt.mq.w;
import com.byazt.rk.uc;
import com.byazt.rk.zo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1383})
public class DynamicRootView extends FrameLayout implements com.byazt.imd.x, com.byazt.mo.pr {
    public ViewGroup aj;
    public DynamicBaseWidget c;
    public ThemeStatusBroadcastReceiver fw;
    public int g;
    public View hn;
    public m ho;
    public boolean hw;
    public com.byazt.imd.c k;
    public Map<Integer, String> lb;
    public int m;
    public Context nt;
    public final g pr;
    public com.byazt.mft.pr uc;
    public int vk;
    public List<com.byazt.imd.hn> w;
    public w x;
    public String yb;
    public com.byazt.imd.hw zo;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, m mVar, com.byazt.mft.pr prVar) {
        super(context);
        this.aj = null;
        this.vk = 0;
        this.w = new ArrayList();
        this.m = 0;
        this.g = 0;
        this.nt = context;
        g gVar = new g();
        this.pr = gVar;
        gVar.pr(2);
        this.uc = prVar;
        prVar.pr(this);
        this.fw = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.pr(this);
        this.hw = z;
        this.ho = mVar;
    }

    public String getBgColor() {
        return this.yb;
    }

    public void setBgColor(String str) {
        this.yb = str;
    }

    public void setRenderListener(w wVar) {
        this.x = wVar;
        this.uc.pr(wVar);
    }

    public void pr(zo zoVar, int i) {
        this.c = pr(zoVar, this, i);
        this.pr.pr(true);
        this.pr.pr(this.c.c);
        this.pr.hw(this.c.uc);
        this.pr.pr(this.hn);
        this.x.pr(this.pr);
    }

    public DynamicBaseWidget pr(zo zoVar, ViewGroup viewGroup, int i) {
        int i2;
        if (zoVar == null) {
            return null;
        }
        List<zo> listW = zoVar.w();
        DynamicBaseWidget dynamicBaseWidgetPr = com.byazt.qq.hw.pr(this.nt, this, zoVar);
        if (dynamicBaseWidgetPr instanceof DynamicUnKnowView) {
            if (i == 3) {
                i2 = 128;
            } else {
                i2 = 118;
            }
            pr(i2, "unknow widget");
            return null;
        }
        pr(zoVar);
        dynamicBaseWidgetPr.pr();
        if (viewGroup != null) {
            viewGroup.addView(dynamicBaseWidgetPr);
            pr(viewGroup, zoVar);
        }
        if (listW == null || listW.size() <= 0) {
            return null;
        }
        Iterator<zo> it = listW.iterator();
        while (it.hasNext()) {
            pr(it.next(), dynamicBaseWidgetPr, i);
        }
        return dynamicBaseWidgetPr;
    }

    private void pr(zo zoVar) {
        uc ucVarC;
        com.byazt.rk.c cVarVk = zoVar.vk();
        if (cVarVk == null || (ucVarC = cVarVk.c()) == null) {
            return;
        }
        this.pr.hw(ucVarC.h());
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.lb;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.lb = map;
    }

    private void pr(ViewGroup viewGroup, zo zoVar) {
        ViewGroup viewGroup2;
        if (viewGroup != null && (viewGroup2 = (ViewGroup) viewGroup.getParent()) != null && zoVar.rc()) {
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 != null) {
                viewGroup3.setClipChildren(false);
                viewGroup3.setClipToPadding(false);
            }
        }
    }

    public void pr(double d, double d2, double d3, double d4, float f) {
        this.pr.hn(d);
        this.pr.x(d2);
        this.pr.c(d3);
        this.pr.uc(d4);
        this.pr.pr(f);
        this.pr.hw(f);
        this.pr.hn(f);
        this.pr.x(f);
    }

    public void pr(int i, String str) {
        this.pr.pr(false);
        this.pr.hw(i);
        this.pr.pr(str);
        this.x.pr(this.pr);
    }

    public void setMuteListener(com.byazt.imd.hw hwVar) {
        this.zo = hwVar;
    }

    public void setDislikeView(View view) {
        this.uc.hw(view);
    }

    public w getRenderListener() {
        return this.x;
    }

    public com.byazt.mft.pr getDynamicClickListener() {
        return this.uc;
    }

    @Override // com.byazt.mo.pr
    public void b_(int i) {
        DynamicBaseWidget dynamicBaseWidget = this.c;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.pr(i);
    }

    public void pr() {
        pr(this.c, 0);
    }

    public void hw() {
        pr(this.c, 4);
    }

    public void pr(DynamicBaseWidget dynamicBaseWidget, int i) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i);
            if (dynamicBaseWidget.ho != null) {
                dynamicBaseWidget.ho.setVisibility(i);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (dynamicBaseWidget.getChildAt(i2) instanceof DynamicBaseWidget) {
                pr((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i2), i);
            }
        }
    }

    @Override // com.byazt.imd.x
    public void pr(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.w.size(); i3++) {
            if (this.w.get(i3) != null) {
                this.w.get(i3).pr(charSequence, i == 1, i2, z);
            }
        }
    }

    @Override // com.byazt.imd.x
    public void setSoundMute(boolean z) {
        com.byazt.imd.hw hwVar = this.zo;
        if (hwVar != null) {
            hwVar.setSoundMute(z);
        }
    }

    public void setTimeUpdate(int i) {
        this.k.setTimeUpdate(i);
    }

    public ViewGroup getTimeOut() {
        return this.aj;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.aj = viewGroup;
    }

    public int getTimedown() {
        return this.vk;
    }

    public void setTimedown(int i) {
        this.vk = i;
    }

    public List<com.byazt.imd.hn> getTimeOutListener() {
        return this.w;
    }

    public void setTimeOutListener(com.byazt.imd.hn hnVar) {
        this.w.add(hnVar);
    }

    public void setVideoListener(com.byazt.imd.c cVar) {
        this.k = cVar;
    }

    public int getScoreCountWithIcon() {
        return this.g;
    }

    public void setScoreCountWithIcon(int i) {
        this.g = i;
    }

    public int getLogoUnionHeight() {
        return this.m;
    }

    public void setLogoUnionHeight(int i) {
        this.m = i;
    }

    public m getRenderRequest() {
        return this.ho;
    }
}
