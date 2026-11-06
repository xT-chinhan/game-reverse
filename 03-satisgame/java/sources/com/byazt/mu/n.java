package com.byazt.mu;

import android.graphics.Rect;
import android.view.View;
import com.byazt.hb.fs;
import com.byazt.prf.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1123, 19})
public class n {
    public static int n = 0;
    public static int qg = 1;
    public l.n s;
    public int q = 60;
    public int l = qg;

    public int n(RecyclerView recyclerView) {
        l.n nVar;
        View viewS;
        l.n nVar2 = null;
        com.byazt.prf.w wVar = recyclerView.getLayoutManager() instanceof com.byazt.prf.w ? (com.byazt.prf.w) recyclerView.getLayoutManager() : null;
        if (wVar != null) {
            int iOa = wVar.oa();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int iD = wVar.d(); iD <= iOa; iD++) {
                Object objS = recyclerView.s(iD);
                if ((objS instanceof l.n) && (viewS = (nVar = (l.n) objS).s()) != null && n(viewS, this.q)) {
                    if (this.l == n) {
                        nVar.W_();
                        this.s = nVar;
                        return iD;
                    }
                    linkedHashMap.put(Integer.valueOf(iD), nVar);
                }
            }
            int i = Integer.MAX_VALUE;
            int iIntValue = -1;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iQg = qg(((l.n) entry.getValue()).s());
                if (iQg < i) {
                    l.n nVar3 = (l.n) entry.getValue();
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    nVar2 = nVar3;
                    i = iQg;
                }
            }
            l.n nVar4 = this.s;
            if (nVar4 != nVar2) {
                if (nVar4 != null) {
                    nVar4.V_();
                }
                this.s = nVar2;
            }
            l.n nVar5 = this.s;
            if (nVar5 != null) {
                nVar5.W_();
                return iIntValue;
            }
        }
        return -1;
    }

    public void n() {
        l.n nVar = this.s;
        if (nVar == null || nVar.s() == null || n(this.s.s(), this.q)) {
            return;
        }
        this.s.V_();
    }

    private int n(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean n(View view, int i) {
        return view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && n(view) >= i;
    }

    private int qg(View view) {
        int iN = (int) (((double) fs.n(view.getContext())) / 2.3d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs((iArr[1] + (view.getHeight() / 2)) - iN);
    }
}
