package com.byazt.osr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.hne.ThemeStatusBroadcastReceiver;
import com.byazt.lh.fs;
import com.byazt.lh.w;
import com.byazt.udb.cp;
import com.byazt.udb.oa;
import com.byazt.udb.sz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1495})
public class DynamicRootView extends FrameLayout implements com.byazt.tq.q, com.byazt.hne.n {
    public Map<Integer, String> cd;
    public List<com.byazt.tq.s> cp;
    public Context cy;
    public com.byazt.tq.l d;
    public com.byazt.tq.qg fs;
    public String hd;
    public oa k;
    public DynamicBaseWidget l;
    public final sz n;
    public int oa;
    public cp q;
    public boolean qg;
    public ViewGroup rv;
    public View s;
    public int sz;
    public int tj;
    public com.byazt.xnr.n w;
    public ThemeStatusBroadcastReceiver x;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, oa oaVar, com.byazt.xnr.n nVar) {
        super(context);
        this.rv = null;
        this.tj = 0;
        this.cp = new ArrayList();
        this.oa = 0;
        this.sz = 0;
        this.cy = context;
        sz szVar = new sz();
        this.n = szVar;
        szVar.n(2);
        this.w = nVar;
        nVar.n(this);
        this.x = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.n(this);
        this.qg = z;
        this.k = oaVar;
    }

    public String getBgColor() {
        return this.hd;
    }

    public void setBgColor(String str) {
        this.hd = str;
    }

    public void setRenderListener(cp cpVar) {
        this.q = cpVar;
        this.w.n(cpVar);
    }

    public void n(fs fsVar, int i) {
        this.l = n(fsVar, this, i);
        this.n.n(true);
        this.n.n(this.l.l);
        this.n.qg(this.l.w);
        this.n.n(this.s);
        this.q.n(this.n);
    }

    public DynamicBaseWidget n(fs fsVar, ViewGroup viewGroup, int i) {
        if (fsVar == null) {
            return null;
        }
        List<fs> listCp = fsVar.cp();
        DynamicBaseWidget dynamicBaseWidgetN = com.byazt.iv.qg.n(this.cy, this, fsVar);
        if (dynamicBaseWidgetN instanceof DynamicUnKnowView) {
            n(i == 3 ? 128 : 118, "unknow widget");
            return null;
        }
        n(fsVar);
        dynamicBaseWidgetN.n();
        if (viewGroup != null) {
            viewGroup.addView(dynamicBaseWidgetN);
            n(viewGroup, fsVar);
        }
        if (listCp == null || listCp.size() <= 0) {
            return null;
        }
        Iterator<fs> it = listCp.iterator();
        while (it.hasNext()) {
            n(it.next(), dynamicBaseWidgetN, i);
        }
        return dynamicBaseWidgetN;
    }

    private void n(fs fsVar) {
        w wVarL;
        com.byazt.lh.l lVarTj = fsVar.tj();
        if (lVarTj == null || (wVarL = lVarTj.l()) == null) {
            return;
        }
        this.n.qg(wVarL.xd());
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.cd;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.cd = map;
    }

    private void n(ViewGroup viewGroup, fs fsVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !fsVar.m()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void n(double d, double d2, double d3, double d4, float f) {
        this.n.s(d);
        this.n.q(d2);
        this.n.l(d3);
        this.n.w(d4);
        this.n.n(f);
        this.n.qg(f);
        this.n.s(f);
        this.n.q(f);
    }

    public void n(int i, String str) {
        this.n.n(false);
        this.n.qg(i);
        this.n.n(str);
        this.q.n(this.n);
    }

    public void setMuteListener(com.byazt.tq.qg qgVar) {
        this.fs = qgVar;
    }

    public void setDislikeView(View view) {
        this.w.qg(view);
    }

    public cp getRenderListener() {
        return this.q;
    }

    public com.byazt.xnr.n getDynamicClickListener() {
        return this.w;
    }

    @Override // com.byazt.hne.n
    public void b_(int i) {
        DynamicBaseWidget dynamicBaseWidget = this.l;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.n(i);
    }

    public void n() {
        n(this.l, 0);
    }

    public void qg() {
        n(this.l, 4);
    }

    public void n(DynamicBaseWidget dynamicBaseWidget, int i) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i);
            if (dynamicBaseWidget.k != null) {
                dynamicBaseWidget.k.setVisibility(i);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (dynamicBaseWidget.getChildAt(i2) instanceof DynamicBaseWidget) {
                n((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i2), i);
            }
        }
    }

    @Override // com.byazt.tq.q
    public void n(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.cp.size(); i3++) {
            if (this.cp.get(i3) != null) {
                this.cp.get(i3).n(charSequence, i == 1, i2, z);
            }
        }
    }

    @Override // com.byazt.tq.q
    public void setSoundMute(boolean z) {
        com.byazt.tq.qg qgVar = this.fs;
        if (qgVar != null) {
            qgVar.setSoundMute(z);
        }
    }

    public void setTimeUpdate(int i) {
        this.d.setTimeUpdate(i);
    }

    public ViewGroup getTimeOut() {
        return this.rv;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.rv = viewGroup;
    }

    public int getTimedown() {
        return this.tj;
    }

    public void setTimedown(int i) {
        this.tj = i;
    }

    public List<com.byazt.tq.s> getTimeOutListener() {
        return this.cp;
    }

    public void setTimeOutListener(com.byazt.tq.s sVar) {
        this.cp.add(sVar);
    }

    public void setVideoListener(com.byazt.tq.l lVar) {
        this.d = lVar;
    }

    public int getScoreCountWithIcon() {
        return this.sz;
    }

    public void setScoreCountWithIcon(int i) {
        this.sz = i;
    }

    public int getLogoUnionHeight() {
        return this.oa;
    }

    public void setLogoUnionHeight(int i) {
        this.oa = i;
    }

    public oa getRenderRequest() {
        return this.k;
    }
}
