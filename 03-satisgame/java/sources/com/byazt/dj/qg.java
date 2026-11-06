package com.byazt.dj;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1976, 26})
public class qg extends n {
    public qg() {
    }

    public qg(pk pkVar, Context context) {
        this.n = pkVar;
        this.qg = context;
    }

    @Override // com.byazt.dj.n
    public int n(Map<String, Object> map, s sVar) {
        return !qg(this.q) ? 1 : 0;
    }

    public boolean qg(View view) {
        if (view != null && this.n != null) {
            String strValueOf = String.valueOf(view.getTag(2097610717));
            if (view.getTag(2097610717) != null && !TextUtils.isEmpty(strValueOf)) {
                if ("click".equals(strValueOf)) {
                    return this.s.rv();
                }
                return true;
            }
            if (n(view, this.qg != null ? this.qg : rv.getContext())) {
                return this.n.xi() != 1 || this.s.rv();
            }
            if (this.n.wv() == 1 && !this.s.rv()) {
                return false;
            }
        }
        return true;
    }

    public boolean n(View view, Context context) {
        int id = view.getId();
        List<Integer> listK = this.s.k();
        if (listK != null && listK.size() == 0) {
            listK.add(2114387830);
            listK.add(2114387864);
            listK.add(2114387633);
            listK.add(2114387466);
            listK.add(2114387468);
            listK.add(2114387962);
            listK.add(2114387625);
        }
        return listK != null && listK.contains(Integer.valueOf(id));
    }

    public boolean n(View view, Point point) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (n(childAt, this.qg != null ? this.qg : rv.getContext())) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return point.x >= iArr[0] && point.x <= iArr[0] + childAt.getWidth() && point.y >= iArr[1] && point.y <= iArr[1] + childAt.getHeight();
                }
                if (n(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
