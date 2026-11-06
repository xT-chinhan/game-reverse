package com.byazt.rg;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.byazt.gct.cy;
import com.byazt.gct.g;
import com.byazt.gct.pk;
import com.byazt.prf.RecyclerView;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 5})
public final class q {
    public static boolean n(int i) {
        return i == 3;
    }

    public static boolean n(pk pkVar, boolean z) {
        int iD = com.byazt.vgx.w.d(pkVar);
        if (iD == 5 || iD == 9) {
            return true;
        }
        if (iD == 3 || iD == 4) {
            return z;
        }
        return iD == 7 || iD == 8;
    }

    public static boolean n(View view) {
        if (view == null) {
            return true;
        }
        if (com.byazt.nf.rv.qg().ed()) {
            return ((view instanceof FrameLayout) || (view instanceof RelativeLayout)) ? false : true;
        }
        return (view instanceof RecyclerView) || (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || qg(view);
    }

    public static boolean qg(View view) {
        return "androidx.viewpager.widget.ViewPager".equals(view.getClass().getName()) || "androidx.viewpager.widget.ViewPager".equals(view.getClass().getName());
    }

    public static void n(final ViewGroup viewGroup, final View view, final int i, final int i2, final int i3, final int i4) {
        if (viewGroup == null || view == null || i <= 0 || i2 <= 0) {
            return;
        }
        viewGroup.addView(view, new ViewGroup.LayoutParams(0, 0));
        final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.byazt.rg.q.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                if (view.getParent() != viewGroup) {
                    return;
                }
                q.n(view, i3, i4, i, i2);
            }
        };
        viewGroup.addOnLayoutChangeListener(onLayoutChangeListener);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.rg.q.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                viewGroup.removeOnLayoutChangeListener(onLayoutChangeListener);
            }
        });
        viewGroup.post(new Runnable() { // from class: com.byazt.rg.q.3
            @Override // java.lang.Runnable
            public void run() {
                if (view.getParent() != viewGroup) {
                    return;
                }
                q.n(view, i3, i4, i, i2);
            }
        });
    }

    public static void n(View view, int i, int i2, int i3, int i4) {
        if (view == null) {
            return;
        }
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3, C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(i4, C.ENCODING_PCM_32BIT));
            view.layout(i, i2, i3 + i, i4 + i2);
            view.invalidate();
        } catch (Throwable unused) {
        }
    }

    public static cy n(boolean[] zArr, float[] fArr, com.byazt.whi.n nVar, float f, float f2, double d) {
        cy cyVarN = nVar != null ? cy.n(nVar.s()) : null;
        if (fArr == null) {
            if (cyVarN == null) {
                return new cy(0.0d, 0.0d, com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), f), com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), f2));
            }
            return cyVarN;
        }
        final cy cyVarN2 = n(fArr, f, f2);
        if (cyVarN == null) {
            return cyVarN2;
        }
        double dN = cy.n(cyVarN, cyVarN2);
        final double d2 = cyVarN2.s * cyVarN2.q;
        final double d3 = cyVarN.s * cyVarN.q;
        final cy cyVarQg = cy.qg(cyVarN, cyVarN2);
        final double d4 = cyVarQg != null ? cyVarQg.s * cyVarQg.q : 0.0d;
        if (nVar != null) {
            nVar.n(new com.byazt.whi.qg() { // from class: com.byazt.rg.q.4
                @Override // com.byazt.whi.qg
                public JSONObject getMaxRectJson() {
                    return cy.n(cyVarQg);
                }

                @Override // com.byazt.whi.qg
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

                @Override // com.byazt.whi.qg
                public JSONObject getActualRectJson() {
                    return cy.n(cyVarN2);
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
        if (dN / d2 >= d) {
            return cyVarQg;
        }
        zArr[0] = false;
        return null;
    }

    private static cy n(float[] fArr, float f, float f2) {
        int iQ = com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), f);
        int iQ2 = com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), f2);
        float f3 = fArr[1];
        float f4 = fArr[0];
        float f5 = (iQ - f3) - fArr[3];
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        float f6 = (iQ2 - f4) - fArr[2];
        return new cy(f3, f4, f5, f6 >= 0.0f ? f6 : 0.0f);
    }

    public static g n(String str, String str2, String str3, int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ugen_md5", str2);
            jSONObject.put("ugen_id", str);
            jSONObject.put("ugen_url", str3);
            jSONObject.put("displayAreaAndroid", i);
            jSONObject.put("render_sequence", i2);
        } catch (JSONException unused) {
        }
        return new g(jSONObject, i3);
    }

    public static ViewGroup s(View view) {
        Window window;
        Activity activityL = l(view);
        if (activityL != null && (window = activityL.getWindow()) != null) {
            View decorView = window.getDecorView();
            if (decorView instanceof ViewGroup) {
                return (ViewGroup) decorView;
            }
        }
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        if (rootView instanceof ViewGroup) {
            return (ViewGroup) rootView;
        }
        return null;
    }

    private static Activity l(View view) {
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

    public static void n(View view, String str) {
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (str.equals(viewGroup.getTag())) {
                q(viewGroup);
            }
        }
    }

    public static void q(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(4);
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            try {
                ((ViewGroup) parent).removeView(view);
            } catch (Exception unused) {
            }
        }
    }

    public static int n(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            int i = Integer.parseInt(str.trim());
            if (i > 0) {
                return i;
            }
            return 0;
        } catch (NumberFormatException unused) {
        }
    }

    public static double qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0d;
        }
        try {
            double d = Double.parseDouble(str.trim());
            if (d > 0.0d) {
                return d;
            }
            return 0.0d;
        } catch (NumberFormatException unused) {
        }
    }
}
