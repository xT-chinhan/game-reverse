package com.bytedance.sdk.openadsdk.core.xr.ms;

import android.view.View;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private final com.bytedance.sdk.openadsdk.core.xr.d ab;
    private hi ah;
    private View d;
    private volatile int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private List<ms> f3765ms = new ArrayList();
    private Map<String, Object> xr = new HashMap();
    private volatile int c = 0;

    public ah(com.bytedance.sdk.openadsdk.core.xr.d dVar) {
        this.ab = dVar;
    }

    public void ms(View view) {
        this.d = view;
    }

    public void ms(ms msVar) {
        this.f3765ms.add(msVar);
    }

    public void ms(hi hiVar) {
        this.ah = hiVar;
        Iterator<ms> it = this.f3765ms.iterator();
        while (it.hasNext()) {
            it.next().ms(this.ah);
        }
    }

    private void xr() {
        this.ka = 0;
        this.c = 0;
    }

    public void ms() {
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.ab.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(false);
        xr();
        xr(0);
    }

    private void xr(int i) {
        int size = this.f3765ms.size();
        while (i < size) {
            int i2 = i + 1;
            this.ka = i2;
            ms msVar = this.f3765ms.get(i);
            msVar.ms(this.d);
            this.c = msVar.ms(this.xr, this);
            if (this.c != 0) {
                if (this.c == 2) {
                    ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.ab.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(this.xr, this);
                    return;
                }
                return;
            }
            i = i2;
        }
    }

    public void ms(int i) {
        this.c = i;
        if (this.c == 0) {
            xr(this.ka);
        } else if (this.c == 1) {
            this.ka = 0;
        } else {
            sl.xr("ClickHandlerChain", "continueHandle fail for state = " + this.c);
        }
    }

    public <T extends ms> T ms(Class<T> cls) {
        return (T) this.ab.ms(cls);
    }
}
