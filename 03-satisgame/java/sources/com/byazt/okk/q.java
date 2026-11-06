package com.byazt.okk;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.byazt.ehw.DeviceUtils;
import com.byazt.nf.rv;
import com.bytedance.JProtect;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 52, 5})
@JProtect
public class q {
    public static String n(int i) {
        switch (i) {
            case 1:
                return "view不可见";
            case 2:
            case 5:
            default:
                return "";
            case 3:
                return "view可见区域比例不够";
            case 4:
                return "屏幕关闭";
            case 6:
                return "view可见宽高不够";
            case 7:
                return "show检测发生崩溃";
            case 8:
                return "设置为了不需要检测";
            case 9:
                return "没有在检测";
            case 10:
                return "没有在检测，已show";
        }
    }

    private static boolean n(View view, int i) {
        float fQg = qg(view);
        return fQg > 0.0f && fQg >= ((float) i) / 100.0f;
    }

    public static boolean n(View view, Rect rect, Point point) {
        if (view == null) {
            return false;
        }
        int right = view.getRight() - view.getLeft();
        int bottom = view.getBottom() - view.getTop();
        if (right <= 0 || bottom <= 0) {
            return false;
        }
        rect.set(0, 0, right, bottom);
        if (point != null) {
            point.set(-view.getScrollX(), -view.getScrollY());
        }
        return view.getParent() == null || view.getParent().getChildVisibleRect(view, rect, point);
    }

    private static boolean s(View view) {
        return view != null && view.isShown();
    }

    private static boolean qg(View view, int i) {
        return view.getWidth() >= s(view, i) && view.getHeight() >= q(view, i);
    }

    private static int s(View view, int i) {
        if (i == 3) {
            return (int) (((double) s.l(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    private static int q(View view, int i) {
        if (i == 3) {
            return s.w(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    public static int n(View view, int i, int i2) throws Throwable {
        if (!DeviceUtils.n()) {
            return 4;
        }
        if (!s(view)) {
            return 1;
        }
        if (qg(view, i2)) {
            return !n(view, i) ? 3 : 0;
        }
        return 6;
    }

    public static boolean qg(View view, int i, int i2) {
        try {
            return n(view, i, i2) == 0;
        } catch (Throwable unused) {
        }
    }

    public static boolean n(View view) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            return n(view, 20);
        }
        return false;
    }

    public static float qg(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect) && (!rv.qg().ri() || !n(view, new Rect(), (Point) null))) {
                        return -1.0f;
                    }
                    long jHeight = ((long) rect.height()) * ((long) rect.width());
                    long height = ((long) view.getHeight()) * ((long) view.getWidth());
                    if (height <= 0) {
                        return -1.0f;
                    }
                    return jHeight / height;
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }
}
