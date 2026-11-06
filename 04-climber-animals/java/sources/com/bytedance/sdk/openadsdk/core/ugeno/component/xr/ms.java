package com.bytedance.sdk.openadsdk.core.ugeno.component.xr;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f3490ms = 0;
    public static int xr = 1;
    private ka.ms ah;
    private int d = 60;
    private int ka = xr;

    public int ms(RecyclerView recyclerView) {
        ka.ms msVar;
        View viewAh;
        ka.ms msVar2 = null;
        com.bytedance.sdk.component.widget.recycler.ka kaVar = recyclerView.getLayoutManager() instanceof com.bytedance.sdk.component.widget.recycler.ka ? (com.bytedance.sdk.component.widget.recycler.ka) recyclerView.getLayoutManager() : null;
        if (kaVar != null) {
            int iHi = kaVar.hi();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int iCh = kaVar.ch(); iCh <= iHi; iCh++) {
                Object objAh = recyclerView.ah(iCh);
                if ((objAh instanceof ka.ms) && (viewAh = (msVar = (ka.ms) objAh).ah()) != null && ms(viewAh, this.d)) {
                    if (this.ka == f3490ms) {
                        msVar.L_();
                        this.ah = msVar;
                        return iCh;
                    }
                    linkedHashMap.put(Integer.valueOf(iCh), msVar);
                }
            }
            int i = Integer.MAX_VALUE;
            int iIntValue = -1;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iXr = xr(((ka.ms) entry.getValue()).ah());
                if (iXr < i) {
                    ka.ms msVar3 = (ka.ms) entry.getValue();
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    msVar2 = msVar3;
                    i = iXr;
                }
            }
            ka.ms msVar4 = this.ah;
            if (msVar4 != msVar2) {
                if (msVar4 != null) {
                    msVar4.K_();
                }
                this.ah = msVar2;
            }
            ka.ms msVar5 = this.ah;
            if (msVar5 != null) {
                msVar5.L_();
                return iIntValue;
            }
        }
        return -1;
    }

    public void ms() {
        ka.ms msVar = this.ah;
        if (msVar == null || msVar.ah() == null || ms(this.ah.ah(), this.d)) {
            return;
        }
        this.ah.K_();
    }

    private int ms(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean ms(View view, int i) {
        return view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && ms(view) >= i;
    }

    private int xr(View view) {
        int iMs = (int) (((double) x.ms(view.getContext())) / 2.3d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs((iArr[1] + (view.getHeight() / 2)) - iMs);
    }
}
