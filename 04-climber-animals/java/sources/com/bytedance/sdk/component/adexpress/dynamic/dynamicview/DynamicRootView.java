package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.ah.c;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.xr.hi;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.component.adexpress.xr.zb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.d, com.bytedance.sdk.component.adexpress.theme.ms {
    private ThemeStatusBroadcastReceiver ab;
    public View ah;
    private Context ao;
    private com.bytedance.sdk.component.adexpress.dynamic.ka.ms c;
    private int ch;
    private hi d;
    private String h;
    private List<com.bytedance.sdk.component.adexpress.dynamic.ah> hi;
    private DynamicBaseWidget ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final u f827ms;
    private ViewGroup ny;
    private Map<Integer, String> qv;
    private com.bytedance.sdk.component.adexpress.dynamic.ka sl;
    private int u;
    private zb ub;
    private com.bytedance.sdk.component.adexpress.dynamic.xr x;
    boolean xr;
    private int zb;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, zb zbVar, com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar) {
        super(context);
        this.ny = null;
        this.ch = 0;
        this.hi = new ArrayList();
        this.zb = 0;
        this.u = 0;
        this.ao = context;
        u uVar = new u();
        this.f827ms = uVar;
        uVar.ms(2);
        this.c = msVar;
        msVar.ms(this);
        this.ab = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.ms(this);
        this.xr = z;
        this.ub = zbVar;
    }

    public String getBgColor() {
        return this.h;
    }

    public void setBgColor(String str) {
        this.h = str;
    }

    public void setRenderListener(hi hiVar) {
        this.d = hiVar;
        this.c.ms(hiVar);
    }

    public void ms(x xVar, int i) {
        this.ka = ms(xVar, this, i);
        this.f827ms.ms(true);
        this.f827ms.ms(this.ka.ka);
        this.f827ms.xr(this.ka.c);
        this.f827ms.ms(this.ah);
        this.d.ms(this.f827ms);
    }

    public DynamicBaseWidget ms(x xVar, ViewGroup viewGroup, int i) {
        if (xVar == null) {
            return null;
        }
        List<x> listHi = xVar.hi();
        DynamicBaseWidget dynamicBaseWidgetMs = com.bytedance.sdk.component.adexpress.dynamic.ms.xr.ms(this.ao, this, xVar);
        if (dynamicBaseWidgetMs instanceof DynamicUnKnowView) {
            ms(i == 3 ? 128 : 118, "unknow widget");
            return null;
        }
        ms(xVar);
        dynamicBaseWidgetMs.ms();
        if (viewGroup != null) {
            viewGroup.addView(dynamicBaseWidgetMs);
            ms(viewGroup, xVar);
        }
        if (listHi == null || listHi.size() <= 0) {
            return null;
        }
        Iterator<x> it = listHi.iterator();
        while (it.hasNext()) {
            ms(it.next(), dynamicBaseWidgetMs, i);
        }
        return dynamicBaseWidgetMs;
    }

    private void ms(x xVar) {
        c cVarKa;
        com.bytedance.sdk.component.adexpress.dynamic.ah.ka kaVarCh = xVar.ch();
        if (kaVarCh == null || (cVarKa = kaVarCh.ka()) == null) {
            return;
        }
        this.f827ms.xr(cVarKa.ph());
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.qv;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.qv = map;
    }

    private void ms(ViewGroup viewGroup, x xVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !xVar.i()) {
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

    public void ms(double d, double d2, double d3, double d4, float f) {
        this.f827ms.ah(d);
        this.f827ms.d(d2);
        this.f827ms.ka(d3);
        this.f827ms.c(d4);
        this.f827ms.ms(f);
        this.f827ms.xr(f);
        this.f827ms.ah(f);
        this.f827ms.d(f);
    }

    public void ms(int i, String str) {
        this.f827ms.ms(false);
        this.f827ms.xr(i);
        this.f827ms.ms(str);
        this.d.ms(this.f827ms);
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.xr xrVar) {
        this.x = xrVar;
    }

    public void setDislikeView(View view) {
        this.c.xr(view);
    }

    public hi getRenderListener() {
        return this.d;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ka.ms getDynamicClickListener() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.ms
    public void b_(int i) {
        DynamicBaseWidget dynamicBaseWidget = this.ka;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.ms(i);
    }

    public void ms() {
        ms(this.ka, 0);
    }

    public void xr() {
        ms(this.ka, 4);
    }

    public void ms(DynamicBaseWidget dynamicBaseWidget, int i) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i);
            if (dynamicBaseWidget.ub != null) {
                dynamicBaseWidget.ub.setVisibility(i);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (dynamicBaseWidget.getChildAt(i2) instanceof DynamicBaseWidget) {
                ms((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i2), i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.d
    public void ms(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.hi.size(); i3++) {
            if (this.hi.get(i3) != null) {
                this.hi.get(i3).ms(charSequence, i == 1, i2, z);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.d
    public void setSoundMute(boolean z) {
        com.bytedance.sdk.component.adexpress.dynamic.xr xrVar = this.x;
        if (xrVar != null) {
            xrVar.setSoundMute(z);
        }
    }

    public void setTimeUpdate(int i) {
        this.sl.setTimeUpdate(i);
    }

    public ViewGroup getTimeOut() {
        return this.ny;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.ny = viewGroup;
    }

    public int getTimedown() {
        return this.ch;
    }

    public void setTimedown(int i) {
        this.ch = i;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.ah> getTimeOutListener() {
        return this.hi;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.ah ahVar) {
        this.hi.add(ahVar);
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.ka kaVar) {
        this.sl = kaVar;
    }

    public int getScoreCountWithIcon() {
        return this.u;
    }

    public void setScoreCountWithIcon(int i) {
        this.u = i;
    }

    public int getLogoUnionHeight() {
        return this.zb;
    }

    public void setLogoUnionHeight(int i) {
        this.zb = i;
    }

    public zb getRenderRequest() {
        return this.ub;
    }
}
