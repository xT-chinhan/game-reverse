package com.byazt.ln;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.of;
import com.byazt.sd.a;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 573, 13})
public class hw extends pr {
    public hw() {
    }

    public hw(of ofVar, Context context) {
        this.pr = ofVar;
        this.hw = context;
    }

    @Override // com.byazt.ln.pr
    public int pr(Map<String, Object> map, hn hnVar) {
        if (!hw(this.x)) {
            return 1;
        }
        return 0;
    }

    public boolean hw(View view) {
        if (view == null || this.pr == null) {
            return true;
        }
        String strValueOf = String.valueOf(view.getTag(2097610717));
        if (view.getTag(2097610717) == null || TextUtils.isEmpty(strValueOf)) {
            if (pr(view, this.hw != null ? this.hw : a.getContext())) {
                return this.pr.qo() != 1 || this.hn.aj();
            }
            return this.pr.j() != 1 || this.hn.aj();
        }
        if (!"click".equals(strValueOf)) {
            return true;
        }
        return this.hn.aj();
    }

    public boolean pr(View view, Context context) {
        int id = view.getId();
        List<Integer> listHo = this.hn.ho();
        if (listHo != null && listHo.size() == 0) {
            listHo.add(2114387830);
            listHo.add(2114387864);
            listHo.add(2114387633);
            listHo.add(2114387466);
            listHo.add(2114387468);
            listHo.add(2114387962);
            listHo.add(2114387625);
        }
        return listHo != null && listHo.contains(Integer.valueOf(id));
    }

    public boolean pr(View view, Point point) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (pr(childAt, this.hw != null ? this.hw : a.getContext())) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return point.x >= iArr[0] && point.x <= iArr[0] + childAt.getWidth() && point.y >= iArr[1] && point.y <= iArr[1] + childAt.getHeight();
                }
                if (pr(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
