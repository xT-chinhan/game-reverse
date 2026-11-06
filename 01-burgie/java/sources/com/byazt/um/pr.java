package com.byazt.um;

import android.graphics.Rect;
import android.view.View;
import com.byazt.aa.zo;
import com.byazt.hr.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1296, 37})
public class pr {
    public c.pr hn;
    public static int pr = 0;
    public static int hw = 1;
    public int x = 60;
    public int c = hw;

    public int pr(RecyclerView recyclerView) {
        com.byazt.hr.c cVar;
        c.pr prVar;
        View viewHn;
        c.pr prVar2 = null;
        if (!(recyclerView.getLayoutManager() instanceof com.byazt.hr.c)) {
            cVar = null;
        } else {
            cVar = (com.byazt.hr.c) recyclerView.getLayoutManager();
        }
        if (cVar != null) {
            int iW = cVar.w();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int iVk = cVar.vk(); iVk <= iW; iVk++) {
                Object objHn = recyclerView.hn(iVk);
                if ((objHn instanceof c.pr) && (viewHn = (prVar = (c.pr) objHn).hn()) != null && pr(viewHn, this.x)) {
                    if (this.c == pr) {
                        prVar.W_();
                        this.hn = prVar;
                        return iVk;
                    }
                    linkedHashMap.put(Integer.valueOf(iVk), prVar);
                }
            }
            int i = Integer.MAX_VALUE;
            int iIntValue = -1;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iHw = hw(((c.pr) entry.getValue()).hn());
                if (iHw < i) {
                    c.pr prVar3 = (c.pr) entry.getValue();
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    prVar2 = prVar3;
                    i = iHw;
                }
            }
            c.pr prVar4 = this.hn;
            if (prVar4 != prVar2) {
                if (prVar4 != null) {
                    prVar4.V_();
                }
                this.hn = prVar2;
            }
            c.pr prVar5 = this.hn;
            if (prVar5 != null) {
                prVar5.W_();
                return iIntValue;
            }
        }
        return -1;
    }

    public void pr() {
        c.pr prVar = this.hn;
        if (prVar != null && prVar.hn() != null && !pr(this.hn.hn(), this.x)) {
            this.hn.V_();
        }
    }

    private int pr(View view) {
        Rect rect = new Rect();
        if (view.getLocalVisibleRect(rect) && view.getMeasuredHeight() > 0) {
            return (rect.height() * 100) / view.getMeasuredHeight();
        }
        return -1;
    }

    private boolean pr(View view, int i) {
        if (!view.getLocalVisibleRect(new Rect()) || view.getVisibility() != 0 || pr(view) < i) {
            return false;
        }
        return true;
    }

    private int hw(View view) {
        int iPr = (int) (((double) zo.pr(view.getContext())) / 2.3d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs((iArr[1] + (view.getHeight() / 2)) - iPr);
    }
}
