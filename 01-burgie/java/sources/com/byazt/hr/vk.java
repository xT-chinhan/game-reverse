package com.byazt.hr;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 50})
public class vk {
    public static int pr(RecyclerView.a aVar, zo zoVar, View view, View view2, RecyclerView.aj ajVar, boolean z, boolean z2) {
        if (ajVar.qa() == 0 || aVar.x() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (aVar.x() - Math.max(ajVar.x(view), ajVar.x(view2))) - 1) : Math.max(0, Math.min(ajVar.x(view), ajVar.x(view2)));
        if (!z) {
            return iMax;
        }
        return Math.round((iMax * (Math.abs(zoVar.hw(view2) - zoVar.pr(view)) / (Math.abs(ajVar.x(view) - ajVar.x(view2)) + 1))) + (zoVar.hn() - zoVar.pr(view)));
    }

    public static int pr(RecyclerView.a aVar, zo zoVar, View view, View view2, RecyclerView.aj ajVar, boolean z) {
        if (ajVar.qa() != 0 && aVar.x() != 0 && view != null && view2 != null) {
            if (!z) {
                return Math.abs(ajVar.x(view) - ajVar.x(view2)) + 1;
            }
            return Math.min(zoVar.uc(), zoVar.hw(view2) - zoVar.pr(view));
        }
        return 0;
    }

    public static int hw(RecyclerView.a aVar, zo zoVar, View view, View view2, RecyclerView.aj ajVar, boolean z) {
        if (ajVar.qa() != 0 && aVar.x() != 0 && view != null && view2 != null) {
            if (!z) {
                return aVar.x();
            }
            return (int) (((zoVar.hw(view2) - zoVar.pr(view)) / (Math.abs(ajVar.x(view) - ajVar.x(view2)) + 1)) * aVar.x());
        }
        return 0;
    }
}
