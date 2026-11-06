package com.bytedance.sdk.openadsdk.core.xr.ms;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    public xr() {
    }

    public xr(lm lmVar, Context context) {
        this.f3767ms = lmVar;
        this.xr = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(Map<String, Object> map, ah ahVar) {
        return !xr(this.d) ? 1 : 0;
    }

    public boolean xr(View view) {
        if (view != null && this.f3767ms != null) {
            String strValueOf = String.valueOf(view.getTag(2097610717));
            if (view.getTag(2097610717) != null && !TextUtils.isEmpty(strValueOf)) {
                if ("click".equals(strValueOf)) {
                    return this.ah.ka();
                }
                return true;
            }
            if (ms(view, this.xr != null ? this.xr : re.getContext())) {
                return this.f3767ms.m() != 1 || this.ah.ka();
            }
            if (this.f3767ms.az() == 1 && !this.ah.ka()) {
                return false;
            }
        }
        return true;
    }

    public boolean ms(View view, Context context) {
        int id = view.getId();
        List<Integer> listHi = this.ah.hi();
        if (listHi != null && listHi.size() == 0) {
            listHi.add(2114387836);
            listHi.add(2114387870);
            listHi.add(2114387639);
            listHi.add(2114387472);
            listHi.add(2114387474);
            listHi.add(2114387962);
            listHi.add(2114387631);
        }
        return listHi != null && listHi.contains(Integer.valueOf(id));
    }

    public boolean ms(View view, Point point) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (ms(childAt, this.xr != null ? this.xr : re.getContext())) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return point.x >= iArr[0] && point.x <= iArr[0] + childAt.getWidth() && point.y >= iArr[1] && point.y <= iArr[1] + childAt.getHeight();
                }
                if (ms(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
