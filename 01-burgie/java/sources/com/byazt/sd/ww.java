package com.byazt.sd;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.er;
import com.bytedance.JProtect;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 576})
@JProtect
public class ww {
    public static String pr(int i) {
        switch (i) {
            case 0:
                return "";
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

    private static boolean pr(View view, int i) {
        float fHw = hw(view);
        return fHw > 0.0f && fHw >= ((float) i) / 100.0f;
    }

    public static boolean pr(View view, Rect rect, Point point) {
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

    private static boolean hn(View view) {
        return view != null && view.isShown();
    }

    private static boolean hw(View view, int i) {
        return view.getWidth() >= hn(view, i) && view.getHeight() >= x(view, i);
    }

    private static int hn(View view, int i) {
        if (i == 3) {
            return (int) (((double) er.c(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    private static int x(View view, int i) {
        if (i == 3) {
            return er.uc(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    public static int pr(View view, int i, int i2) throws Throwable {
        if (!DeviceUtils.pr()) {
            return 4;
        }
        if (!hn(view)) {
            return 1;
        }
        if (!hw(view, i2)) {
            return 6;
        }
        if (pr(view, i)) {
            return 0;
        }
        return 3;
    }

    public static boolean hw(View view, int i, int i2) {
        try {
            return pr(view, i, i2) == 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean pr(View view) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || !view.isShown() || !view.getGlobalVisibleRect(new Rect())) {
            return false;
        }
        return pr(view, 20);
    }

    public static float hw(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect) && (!a.hw().ie() || !pr(view, new Rect(), (Point) null))) {
                        return -1.0f;
                    }
                    long jHeight = ((long) rect.height()) * ((long) rect.width());
                    long height = ((long) view.getHeight()) * ((long) view.getWidth());
                    if (height <= 0) {
                        return -1.0f;
                    }
                    return jHeight / height;
                }
            } catch (Throwable th) {
                return -1.0f;
            }
        }
        return -1.0f;
    }
}
