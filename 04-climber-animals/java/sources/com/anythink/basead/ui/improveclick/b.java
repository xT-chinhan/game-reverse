package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.improveclick.ambience.BaseAmbienceView;
import com.anythink.basead.ui.improveclick.ambience.BubbleDropAnimView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.m;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private BaseAmbienceView l;
    private com.anythink.basead.ui.improveclick.ambience.a m;
    private boolean n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;

    @Override // com.anythink.basead.ui.improveclick.c
    public final void a(Context context, w wVar, x xVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, c.a aVar) {
        super.a(context, wVar, xVar, viewGroup, relativeLayout, view, i, aVar);
        this.n = false;
        this.o = 1;
        if (this.h == 3) {
            this.o = this.f.o.A();
        } else {
            this.o = m.f(this.d);
        }
        this.p = 1;
        this.q = false;
        this.r = false;
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a(int i, Map<String, Object> map) {
        boolean z = true;
        switch (i) {
            case 110:
                BaseAmbienceView baseAmbienceView = this.l;
                if (baseAmbienceView != null) {
                    baseAmbienceView.onResume();
                }
                break;
            case 111:
                BaseAmbienceView baseAmbienceView2 = this.l;
                if (baseAmbienceView2 != null) {
                    baseAmbienceView2.onPause();
                }
                break;
            case 112:
            case 115:
                a();
                break;
            case 113:
                Object obj = map.get("click_type");
                Object obj2 = map.get(g.a.g);
                if (obj != null && (obj instanceof Integer) && obj2 != null && (obj2 instanceof Integer)) {
                    int iIntValue = ((Integer) obj).intValue();
                    int iIntValue2 = ((Integer) obj2).intValue();
                    if (iIntValue != 5 && iIntValue != 6 && iIntValue != 7) {
                        int iA = com.anythink.basead.ui.f.c.a(iIntValue, iIntValue2);
                        if (iA == 0 || iA == 1) {
                            this.r = true;
                            break;
                        } else if (iA == 2) {
                            this.q = true;
                            break;
                        }
                    }
                }
                break;
            case 114:
                Object obj3 = map.get(g.a.e);
                if (obj3 != null && (obj3 instanceof Integer)) {
                    this.p = ((Integer) obj3).intValue();
                }
                int iBs = this.f.o.bs();
                if (iBs == 2) {
                    if (this.l == null) {
                        BubbleDropAnimView bubbleDropAnimView = new BubbleDropAnimView(this.d);
                        this.l = bubbleDropAnimView;
                        bubbleDropAnimView.initSetting(this.f, this.k);
                        if (this.f.o.bs() == 2) {
                            if (this.h == 2) {
                                if (this.g.getParent() != null && (this.g.getParent() instanceof ViewGroup)) {
                                    ((ViewGroup) this.g.getParent()).addView(this.l, -1, -1);
                                }
                            } else {
                                this.g.addView(this.l, -1, -1);
                            }
                        }
                    }
                } else if (iBs == 3 && this.h == 2) {
                    com.anythink.basead.ui.improveclick.ambience.a aVar = new com.anythink.basead.ui.improveclick.ambience.a();
                    this.m = aVar;
                    aVar.a(this.g, this.o);
                } else {
                    z = false;
                }
                this.n = z;
                break;
        }
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a() {
        if (this.n) {
            x xVar = this.f;
            w wVar = this.e;
            com.anythink.basead.b.e.a(this.f);
            com.anythink.core.common.u.e.a(xVar, wVar, this.o, this.p, this.f.o.bs() == 2 ? 3 : 4, this.q, this.r);
        }
        BaseAmbienceView baseAmbienceView = this.l;
        if (baseAmbienceView != null) {
            baseAmbienceView.release();
            am.a(this.l);
        }
    }

    private boolean b() {
        int iBs = this.f.o.bs();
        if (iBs == 2) {
            if (this.l == null) {
                BubbleDropAnimView bubbleDropAnimView = new BubbleDropAnimView(this.d);
                this.l = bubbleDropAnimView;
                bubbleDropAnimView.initSetting(this.f, this.k);
                if (this.f.o.bs() == 2) {
                    if (this.h == 2) {
                        if (this.g.getParent() != null && (this.g.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) this.g.getParent()).addView(this.l, -1, -1);
                        }
                    } else {
                        this.g.addView(this.l, -1, -1);
                    }
                }
            }
            return true;
        }
        if (iBs != 3 || this.h != 2) {
            return false;
        }
        com.anythink.basead.ui.improveclick.ambience.a aVar = new com.anythink.basead.ui.improveclick.ambience.a();
        this.m = aVar;
        aVar.a(this.g, this.o);
        return true;
    }
}
