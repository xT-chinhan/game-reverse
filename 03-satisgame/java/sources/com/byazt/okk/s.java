package com.byazt.okk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.byazt.gct.pk;
import com.byazt.kfh.SSWebView;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.tk.fs;
import com.byazt.tk.k;
import com.byazt.vf.oa;
import com.byazt.vf.u;
import com.byazt.vgx.w;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 52, 8})
public class s {
    public static float fs = 0.0f;
    public static volatile int l = -1;
    public static volatile int n = -1;
    public static volatile float q = -1.0f;
    public static volatile float qg = -1.0f;
    public static volatile int s = -1;
    public static volatile int w = -1;
    public static int x = 13;

    public interface n {
        void n(View view);
    }

    public static int n(float f, float f2) {
        return (int) ((f2 * f) + 0.5f);
    }

    private static boolean n(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static int qg(float f, float f2) {
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }

    private static boolean w() {
        return qg < 0.0f || s < 0 || q < 0.0f || l < 0 || w < 0;
    }

    public static float n(Context context) {
        if (context == null) {
            context = rv.getContext();
        }
        if (context == null) {
            return Resources.getSystem().getDisplayMetrics().density;
        }
        if (rv.qg().gy()) {
            if (Build.VERSION.SDK_INT >= 30 && (context instanceof Activity)) {
                return context.getResources().getConfiguration().densityDpi / 160.0f;
            }
            return context.getResources().getDisplayMetrics().density;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static void qg(Context context) {
        Resources resources;
        if (context == null) {
            context = rv.getContext();
        }
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (w()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            qg = displayMetrics.density;
            s = displayMetrics.densityDpi;
            q = displayMetrics.scaledDensity;
            l = displayMetrics.widthPixels;
            w = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (l > w) {
                    int i = l;
                    l = w;
                    w = i;
                    return;
                }
                return;
            }
            if (l < w) {
                int i2 = l;
                l = w;
                w = i2;
            }
        }
    }

    public static float n(Context context, float f) {
        qg(context);
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static int qg(Context context, float f) {
        qg(context);
        float fFs = fs(context);
        if (fFs <= 0.0f) {
            fFs = 1.0f;
        }
        return (int) ((f / fFs) + 0.5f);
    }

    public static int s(Context context, float f) {
        qg(context);
        return (int) ((f * n(context)) + 0.5f);
    }

    public static int q(Context context, float f) {
        qg(context);
        float fN = n(context);
        if (fN <= 0.0f) {
            fN = 1.0f;
        }
        return (int) ((f / fN) + 0.5f);
    }

    public static int[] s(Context context) {
        WindowManager windowManager = null;
        if (context == null) {
            return null;
        }
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused) {
        }
        int[] iArr = new int[2];
        if (windowManager != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
                    iArr[0] = bounds.width();
                    iArr[1] = bounds.height();
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    iArr[0] = displayMetrics.widthPixels;
                    iArr[1] = displayMetrics.heightPixels;
                }
            } catch (Throwable unused2) {
            }
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int[] q(Context context) {
        qg(context);
        return new int[]{l, w};
    }

    public static int l(Context context) {
        qg(context);
        return l;
    }

    public static int w(Context context) {
        qg(context);
        return w;
    }

    public static float x(Context context) {
        qg(context);
        return qg;
    }

    public static float fs(Context context) {
        qg(context);
        return q;
    }

    public static void n(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new fs(rect, view));
    }

    public static int[] n(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] qg(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] s(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static void n(View view, int i) {
        if (view == null || view.getVisibility() == i || !n(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static void n(View view, float f) {
        if (view == null) {
            return;
        }
        view.setAlpha(f);
    }

    public static boolean q(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean n(SSWebView sSWebView) {
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return false;
        }
        sSWebView.goBack();
        return true;
    }

    public static void n(final com.byazt.uad.q qVar) {
        if (qVar == null) {
            return;
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.okk.s.1
            @Override // java.lang.Runnable
            public void run() {
                WebSettings settings;
                WebView webView = qVar.getWebView();
                if (webView == null || (settings = webView.getSettings()) == null) {
                    return;
                }
                settings.setTextZoom(100);
            }
        });
    }

    public static void n(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void qg(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        n(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    private static void n(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static boolean n() {
        try {
            return !((KeyguardManager) rv.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject n(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i = 1;
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.byazt.vyf.s.cy().n() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                if (!(!n())) {
                    i = 0;
                }
                jSONObject.put("lock_scene", i);
            }
            if (str != null && !str.isEmpty() && !jSONObject.has("auto_show_check")) {
                jSONObject.put("auto_show_check", str);
            }
        } catch (Throwable th) {
            k.n("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    public static void l(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.okk.s.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                s.n(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static void w(View view) {
        if (view == null) {
            return;
        }
        n(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.okk.s.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static int rv(Context context) {
        if (context == null) {
            context = rv.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int tj(Context context) {
        if (context == null) {
            context = rv.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float cp(Context context) {
        if (context == null) {
            context = rv.getContext();
        }
        try {
            int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
            }
            return 0.0f;
        } catch (Throwable th) {
            th.getMessage();
            return 0.0f;
        }
    }

    public static void n(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            qg(activity);
        } catch (Exception unused) {
        }
    }

    public static void qg(Activity activity) {
        try {
            s(activity);
            activity.getWindow().addFlags(134217728);
        } catch (Exception unused) {
        }
    }

    public static void s(Activity activity) {
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(2050);
        } catch (Exception unused) {
        }
    }

    private static boolean tj(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && activity.getWindow().getDecorView().getHeight() > 0 && activity.getWindow().getDecorView().getWidth() > 0) {
                return rv((Context) activity) - activity.getWindow().getDecorView().getHeight() > 0 || tj((Context) activity) - activity.getWindow().getDecorView().getWidth() > 0;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean q(Activity activity) {
        return w(activity) || n("ro.miui.notch") == 1 || d(activity) || oa(activity) || q() || l() || tj(activity) || sz(activity);
    }

    public static void l(Activity activity) {
        if (s()) {
            return;
        }
        try {
            final WeakReference weakReference = new WeakReference(activity);
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.byazt.okk.s.4
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.ag.qg.n(new x("check_notch") { // from class: com.byazt.okk.s.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Activity activity2 = (Activity) weakReference.get();
                                if (activity2 != null && !s.s()) {
                                    s.n = s.q(activity2) ? 1 : 0;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean qg() {
        return n == 1 || n == -1;
    }

    public static boolean s() {
        return n != -1;
    }

    public static void n(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && fs == 0.0f) {
                WindowInsets rootWindowInsets = view.getRootWindowInsets();
                DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
                if (displayCutout != null) {
                    fs = displayCutout.getSafeInsetTop();
                }
            }
            if (fs == 0.0f) {
                return;
            }
            float fMax = Math.max(cp(view2.getContext()), fs);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = (int) (layoutParams2.topMargin + fMax);
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.topMargin = (int) (layoutParams3.topMargin + fMax);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams4.topMargin = (int) (layoutParams4.topMargin + fMax);
            }
            view2.setLayoutParams(layoutParams);
        } catch (Throwable unused) {
        }
    }

    public static boolean w(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int n(String str) {
        u uVar;
        if (!com.byazt.ehw.rv.a() || (uVar = (u) com.byazt.qp.q.n("system_info")) == null) {
            return 0;
        }
        return uVar.qg(str);
    }

    public static boolean d(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean oa(Context context) {
        try {
            if ("V1938CT".equals(((oa) com.byazt.qp.q.n("device_info_new")).qg())) {
                return false;
            }
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean sz(Context context) {
        String strD = w.d("com.kllk.feature.screen.heteromorphism");
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature(strD);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean q() {
        String strQg = ((oa) com.byazt.qp.q.n("device_info_new")).qg();
        return strQg.equals("IN2010") || strQg.equals("IN2020") || strQg.equals("KB2000");
    }

    public static boolean l() {
        return Build.MANUFACTURER.equals("samsung");
    }

    public static void n(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            k.qg("OnclickListener ", str + " is null , can not set OnClickListener !!!");
        } else {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void n(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            k.qg("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
        } else {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static void n(final View view, final n nVar) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.okk.s.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(view);
                }
            }
        });
    }

    public static void n(View view, final pk pkVar) {
        if (view == null || pkVar == null) {
            return;
        }
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.okk.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.byazt.okk.n.n(rv.getContext(), pkVar);
            }
        });
    }

    public static void n(TextView textView, String str, Context context) {
        if (textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1F161823"));
        gradientDrawable.setCornerRadius(s(context, 3.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(-1073741825);
        textView.setGravity(17);
        textView.setPadding(s(context, 2.0f), s(context, 3.0f), s(context, 2.0f), s(context, 3.0f));
    }

    public static void n(TextView textView, pk pkVar) {
        if (textView == null || pkVar == null) {
            n(textView);
            return;
        }
        String strFw = pkVar.fw();
        if (TextUtils.isEmpty(strFw)) {
            n(textView);
            n((View) textView, pkVar);
        } else {
            n(textView, strFw, rv.getContext());
        }
    }

    public static void n(TextView textView, pk pkVar, int i, int i2) {
        if (textView == null || pkVar == null) {
            n(textView, i, i2);
            return;
        }
        String strFw = pkVar.fw();
        if (TextUtils.isEmpty(strFw)) {
            n(textView, i, i2);
            n((View) textView, pkVar);
        } else {
            n(textView, strFw, rv.getContext());
        }
    }

    public static Bitmap x(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.draw(canvas);
        canvas.save();
        return bitmapCreateBitmap;
    }

    private static void n(TextView textView) {
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = s(rv.getContext(), 32.0f);
        layoutParams.height = s(rv.getContext(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    private static void n(TextView textView, int i, int i2) {
        if (i <= 0) {
            i = 32;
        }
        if (i2 <= 0) {
            i2 = 14;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = s(rv.getContext(), i);
        layoutParams.height = s(rv.getContext(), i2);
        textView.setLayoutParams(layoutParams);
    }

    public static void x(Activity activity) {
        try {
            cp(activity);
        } catch (Throwable unused) {
        }
    }

    public static void fs(Activity activity) {
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }

    private static void cp(Activity activity) {
        Object objInvoke;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            objInvoke = declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            objInvoke = null;
        }
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().startsWith("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, objInvoke);
        } catch (Throwable unused2) {
        }
    }

    public static void qg(View view, final float f) {
        if (view != null && f > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.okk.s.7
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            view.setClipToOutline(true);
        }
    }

    @Deprecated
    public static void n(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.byazt.nnl.n.qg().n(context, 4.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iS = s(context, 20.0f);
        int iS2 = s(context, 11.0f);
        textView.setPadding(iS, iS2, iS, iS2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(x);
        textView.setGravity(17);
        textView.setText(str);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        toast.show();
    }

    public static TextView k(Context context) {
        if (context == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.byazt.nnl.n.qg().n(context, 4.0f));
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) (((double) w(context)) * (-0.3d));
        int iS = s(context, 20.0f);
        int iS2 = s(context, 11.0f);
        textView.setPadding(iS, iS2, iS, iS2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(x);
        textView.setGravity(17);
        return textView;
    }

    public static void fs(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static boolean rv(Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static int cy(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
