package com.byazt.uq;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.byazt.hg.bh;
import com.byazt.hg.nt;
import com.byazt.hg.of;
import com.byazt.hr.RecyclerView;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 121})
public final class x {
    public static boolean pr(of ofVar, boolean z) {
        int iK = ls.k(ofVar);
        if (iK == 5 || iK == 9) {
            return true;
        }
        if (iK == 3 || iK == 4) {
            return z;
        }
        if (iK == 7 || iK == 8) {
            return true;
        }
        return false;
    }

    public static boolean pr(View view) {
        if (view == null) {
            return true;
        }
        if (a.hw().yc()) {
            if (!(view instanceof FrameLayout) && !(view instanceof RelativeLayout)) {
                return true;
            }
            return false;
        }
        if ((view instanceof RecyclerView) || (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || hw(view)) {
            return true;
        }
        return false;
    }

    public static boolean hw(View view) {
        return "androidx.viewpager.widget.ViewPager".equals(view.getClass().getName()) || "android.support.v4.view.ViewPager".equals(view.getClass().getName());
    }

    public static void pr(final ViewGroup viewGroup, final View view, final int i, final int i2, final int i3, final int i4) {
        if (viewGroup == null || view == null || i <= 0 || i2 <= 0) {
            return;
        }
        viewGroup.addView(view, new ViewGroup.LayoutParams(0, 0));
        final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.byazt.uq.x.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                if (view.getParent() != viewGroup) {
                    return;
                }
                x.pr(view, i3, i4, i, i2);
            }
        };
        viewGroup.addOnLayoutChangeListener(onLayoutChangeListener);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.uq.x.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                viewGroup.removeOnLayoutChangeListener(onLayoutChangeListener);
            }
        });
        viewGroup.post(new Runnable() { // from class: com.byazt.uq.x.3
            @Override // java.lang.Runnable
            public void run() {
                if (view.getParent() != viewGroup) {
                    return;
                }
                x.pr(view, i3, i4, i, i2);
            }
        });
    }

    public static void pr(View view, int i, int i2, int i3, int i4) {
        if (view == null) {
            return;
        }
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            view.layout(i, i2, i3 + i, i4 + i2);
            view.invalidate();
        } catch (Throwable th) {
        }
    }

    public static nt pr(boolean[] zArr, float[] fArr, com.byazt.fq.pr prVar, float f, float f2, double d) {
        nt ntVarPr;
        if (prVar == null) {
            ntVarPr = null;
        } else {
            ntVarPr = nt.pr(prVar.hw());
        }
        if (fArr == null) {
            if (ntVarPr == null) {
                return new nt(0.0d, 0.0d, er.x(a.getContext(), f), er.x(a.getContext(), f2));
            }
            return ntVarPr;
        }
        final nt ntVarPr2 = pr(fArr, f, f2);
        if (ntVarPr == null) {
            return ntVarPr2;
        }
        double dPr = nt.pr(ntVarPr, ntVarPr2);
        final double d2 = ntVarPr2.hn * ntVarPr2.x;
        final double d3 = ntVarPr.hn * ntVarPr.x;
        final nt ntVarHw = nt.hw(ntVarPr, ntVarPr2);
        final double d4 = ntVarHw != null ? ntVarHw.hn * ntVarHw.x : 0.0d;
        if (prVar != null) {
            prVar.pr(new com.byazt.fq.hw() { // from class: com.byazt.uq.x.4
                @Override // com.byazt.fq.hw
                public JSONObject getMaxRectJson() {
                    return nt.pr(ntVarHw);
                }

                @Override // com.byazt.fq.hw
                public double getExceedAreaRate() {
                    double d5 = d3;
                    if (d5 <= 0.0d) {
                        return 1.0d;
                    }
                    if (d2 <= 0.0d) {
                        return -1.0d;
                    }
                    return (d4 - d5) / d5;
                }

                @Override // com.byazt.fq.hw
                public JSONObject getActualRectJson() {
                    return nt.pr(ntVarPr2);
                }
            });
        }
        if (d3 <= 0.0d) {
            zArr[0] = false;
            return null;
        }
        if (d2 <= 0.0d) {
            zArr[0] = false;
            return null;
        }
        if (!(dPr / d2 >= d)) {
            zArr[0] = false;
            return null;
        }
        return ntVarHw;
    }

    private static nt pr(float[] fArr, float f, float f2) {
        int iX = er.x(a.getContext(), f);
        int iX2 = er.x(a.getContext(), f2);
        float f3 = fArr[1];
        float f4 = fArr[0];
        float f5 = (iX - f3) - fArr[3];
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        float f6 = (iX2 - f4) - fArr[2];
        return new nt(f3, f4, f5, f6 >= 0.0f ? f6 : 0.0f);
    }

    public static boolean pr(int i) {
        return i == 3;
    }

    public static bh pr(String str, String str2, String str3, int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ugen_md5", str2);
            jSONObject.put("ugen_id", str);
            jSONObject.put("ugen_url", str3);
            jSONObject.put("displayAreaAndroid", i);
            jSONObject.put("render_sequence", i2);
        } catch (JSONException e) {
        }
        return new bh(jSONObject, i3);
    }

    public static ViewGroup hn(View view) {
        Window window;
        Activity activityC = c(view);
        if (activityC != null && (window = activityC.getWindow()) != null) {
            View decorView = window.getDecorView();
            if (decorView instanceof ViewGroup) {
                return (ViewGroup) decorView;
            }
        }
        if (view != null) {
            View rootView = view.getRootView();
            if (rootView instanceof ViewGroup) {
                return (ViewGroup) rootView;
            }
            return null;
        }
        return null;
    }

    private static Activity c(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static void pr(View view, String str) {
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (str.equals(viewGroup.getTag())) {
                x(viewGroup);
            }
        }
    }

    public static void x(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(4);
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            try {
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
            }
        }
    }
}
