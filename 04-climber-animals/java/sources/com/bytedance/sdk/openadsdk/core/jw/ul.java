package com.bytedance.sdk.openadsdk.core.jw;

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
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.umeng.analytics.pro.l;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ul {
    private static int ab = 13;
    private static volatile int ah = -1;
    private static volatile int c = -1;
    private static volatile float d = -1.0f;
    private static volatile int ka = -1;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile int f2738ms = -1;
    private static float x = 0.0f;
    private static volatile float xr = -1.0f;

    public interface ms {
        void ms(View view);
    }

    public static int ms(float f, float f2) {
        return (int) ((f2 * f) + 0.5f);
    }

    private static boolean ms(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static int xr(float f, float f2) {
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }

    private static boolean d() {
        return xr < 0.0f || ah < 0 || d < 0.0f || ka < 0 || c < 0;
    }

    private static float y(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.re.getContext();
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static void ms(Context context) {
        Resources resources;
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.re.getContext();
        }
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (d()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            xr = displayMetrics.density;
            ah = displayMetrics.densityDpi;
            d = displayMetrics.scaledDensity;
            ka = displayMetrics.widthPixels;
            c = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (ka > c) {
                    int i = ka;
                    ka = c;
                    c = i;
                    return;
                }
                return;
            }
            if (ka < c) {
                int i2 = ka;
                ka = c;
                c = i2;
            }
        }
    }

    public static float ms(Context context, float f) {
        ms(context);
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static int xr(Context context, float f) {
        ms(context);
        float fAb = ab(context);
        if (fAb <= 0.0f) {
            fAb = 1.0f;
        }
        return (int) ((f / fAb) + 0.5f);
    }

    public static int ah(Context context, float f) {
        ms(context);
        return (int) ((f * y(context)) + 0.5f);
    }

    public static int d(Context context, float f) {
        ms(context);
        float fY = y(context);
        if (fY <= 0.0f) {
            fY = 1.0f;
        }
        return (int) ((f / fY) + 0.5f);
    }

    public static int[] xr(Context context) {
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

    public static int[] ah(Context context) {
        ms(context);
        return new int[]{ka, c};
    }

    public static int d(Context context) {
        ms(context);
        return ka;
    }

    public static int ka(Context context) {
        ms(context);
        return c;
    }

    public static float c(Context context) {
        ms(context);
        return xr;
    }

    public static float ab(Context context) {
        ms(context);
        return d;
    }

    public static int x(Context context) {
        ms(context);
        return ah;
    }

    public static void ms(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new com.bytedance.sdk.component.utils.ab(rect, view));
    }

    public static int[] ms(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] xr(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] ah(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static void ms(View view, int i) {
        if (view == null || view.getVisibility() == i || !ms(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static void ms(View view, float f) {
        if (view == null) {
            return;
        }
        view.setAlpha(f);
    }

    public static boolean d(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean ms(SSWebView sSWebView) {
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return false;
        }
        sSWebView.goBack();
        return true;
    }

    public static void ms(final com.bytedance.sdk.component.zb.ah ahVar) {
        if (ahVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.ul.1
            @Override // java.lang.Runnable
            public void run() {
                WebSettings settings;
                WebView webView = ahVar.getWebView();
                if (webView == null || (settings = webView.getSettings()) == null) {
                    return;
                }
                settings.setTextZoom(100);
            }
        });
    }

    public static void ms(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void xr(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ms(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    private static void ms(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
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

    public static boolean ms() {
        try {
            return !((KeyguardManager) com.bytedance.sdk.openadsdk.core.re.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject ms(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i = 1;
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.bytedance.sdk.openadsdk.core.ch.ub().ms() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                if (!(!ms())) {
                    i = 0;
                }
                jSONObject.put("lock_scene", i);
            }
            if (str != null && !str.isEmpty() && !jSONObject.has("auto_show_check")) {
                jSONObject.put("auto_show_check", str);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.xr("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    public static void ka(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.jw.ul.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ul.ms(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static void c(View view) {
        if (view == null) {
            return;
        }
        ms(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.jw.ul.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static int ny(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.re.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int ch(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.re.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float hi(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.re.getContext();
        }
        try {
            int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
            }
            return 0.0f;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.xr("TTUtils", "Get StatusBarHeight failed:" + th.getMessage());
            return 0.0f;
        }
    }

    public static void ms(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            xr(activity);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public static void xr(Activity activity) {
        try {
            ah(activity);
            activity.getWindow().addFlags(134217728);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public static void ah(Activity activity) {
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(l.b);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private static boolean ch(Activity activity) {
        try {
            if (activity.getWindow().getDecorView().getHeight() > 0 && activity.getWindow().getDecorView().getWidth() > 0) {
                return ny((Context) activity) - activity.getWindow().getDecorView().getHeight() > 0 || ch((Context) activity) - activity.getWindow().getDecorView().getWidth() > 0;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean d(Activity activity) {
        return c(activity) || ms("ro.miui.notch", activity) == 1 || sl(activity) || zb(activity) || ub(activity) || ao(activity) || ch(activity) || u(activity);
    }

    public static void ka(Activity activity) {
        if (ah()) {
            return;
        }
        try {
            final WeakReference weakReference = new WeakReference(activity);
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.ul.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny("check_notch") { // from class: com.bytedance.sdk.openadsdk.core.jw.ul.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Activity activity2 = (Activity) weakReference.get();
                                if (activity2 != null && !ul.ah()) {
                                    ul.f2738ms = ul.d(activity2) ? 1 : 0;
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

    public static boolean xr() {
        return f2738ms == 1 || f2738ms == -1;
    }

    public static boolean ah() {
        return f2738ms != -1;
    }

    public static void ms(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && x == 0.0f) {
                WindowInsets rootWindowInsets = view.getRootWindowInsets();
                DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
                if (displayCutout != null) {
                    x = displayCutout.getSafeInsetTop();
                }
            }
            if (x == 0.0f) {
                return;
            }
            float fMax = Math.max(hi(view2.getContext()), x);
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

    public static boolean c(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return false;
        }
    }

    public static int ms(String str, Activity activity) {
        com.bytedance.sdk.component.d.ah ahVar;
        if (!w.ao() || (ahVar = (com.bytedance.sdk.component.d.ah) AutoService.ms(com.bytedance.sdk.component.d.ah.class)) == null) {
            return 0;
        }
        return ahVar.xr(str);
    }

    public static boolean sl(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zb(Context context) {
        try {
            if ("V1938CT".equals(com.bytedance.sdk.openadsdk.core.t.re())) {
                return false;
            }
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean u(Context context) {
        String strHi = f.hi("com.kllk.feature.screen.heteromorphism");
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature(strHi);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean ub(Context context) {
        String strRe = com.bytedance.sdk.openadsdk.core.t.re();
        return strRe.equals("IN2010") || strRe.equals("IN2020") || strRe.equals("KB2000");
    }

    public static boolean ao(Context context) {
        return Build.MANUFACTURER.equals("samsung");
    }

    public static void ms(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.sl.d("OnclickListener ", str + " is null , can not set OnClickListener !!!");
        } else {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void ms(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.sl.d("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
        } else {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static void ms(final View view, final ms msVar) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.jw.ul.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms(view);
                }
            }
        });
    }

    public static void ms(View view, final com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (view == null || lmVar == null) {
            return;
        }
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.jw.ul.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.ms(com.bytedance.sdk.openadsdk.core.re.getContext(), lmVar);
            }
        });
    }

    public static void ms(TextView textView, String str, Context context) {
        if (textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1F161823"));
        gradientDrawable.setCornerRadius(ah(context, 3.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(com.bytedance.sdk.component.utils.t.ny(context, "tt_adx_logo_desc"));
        textView.setGravity(17);
        textView.setPadding(ah(context, 2.0f), ah(context, 3.0f), ah(context, 2.0f), ah(context, 3.0f));
    }

    public static void ms(TextView textView, com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (textView == null || lmVar == null) {
            ms(textView);
            return;
        }
        String strZe = lmVar.ze();
        if (TextUtils.isEmpty(strZe)) {
            ms(textView);
            ms((View) textView, lmVar);
        } else {
            ms(textView, strZe, com.bytedance.sdk.openadsdk.core.re.getContext());
        }
    }

    public static void ms(TextView textView, com.bytedance.sdk.openadsdk.core.nw.lm lmVar, int i, int i2) {
        if (textView == null || lmVar == null) {
            ms(textView, i, i2);
            return;
        }
        String strZe = lmVar.ze();
        if (TextUtils.isEmpty(strZe)) {
            ms(textView, i, i2);
            ms((View) textView, lmVar);
        } else {
            ms(textView, strZe, com.bytedance.sdk.openadsdk.core.re.getContext());
        }
    }

    public static Bitmap ab(View view) {
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

    private static void ms(TextView textView) {
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = ah(com.bytedance.sdk.openadsdk.core.re.getContext(), 32.0f);
        layoutParams.height = ah(com.bytedance.sdk.openadsdk.core.re.getContext(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    private static void ms(TextView textView, int i, int i2) {
        if (i <= 0) {
            i = 32;
        }
        if (i2 <= 0) {
            i2 = 14;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = ah(com.bytedance.sdk.openadsdk.core.re.getContext(), i);
        layoutParams.height = ah(com.bytedance.sdk.openadsdk.core.re.getContext(), i2);
        textView.setLayoutParams(layoutParams);
    }

    public static void ab(Activity activity) {
        try {
            hi(activity);
        } catch (Throwable unused) {
        }
    }

    public static void x(Activity activity) {
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

    private static void hi(Activity activity) {
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

    public static void xr(View view, final float f) {
        if (view != null && f > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.jw.ul.7
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
    public static void ms(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.ms.ms.xr().ms(context, 4.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iAh = ah(context, 20.0f);
        int iAh2 = ah(context, 11.0f);
        textView.setPadding(iAh, iAh2, iAh, iAh2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(ab);
        textView.setGravity(17);
        textView.setText(str);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        toast.show();
    }

    public static TextView h(Context context) {
        if (context == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.ms.ms.xr().ms(context, 4.0f));
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) (((double) ka(context)) * (-0.3d));
        int iAh = ah(context, 20.0f);
        int iAh2 = ah(context, 11.0f);
        textView.setPadding(iAh, iAh2, iAh, iAh2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(ab);
        textView.setGravity(17);
        return textView;
    }

    public static void x(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static boolean ny(Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static int qv(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
