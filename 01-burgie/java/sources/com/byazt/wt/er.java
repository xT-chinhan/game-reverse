package com.byazt.wt;

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
import android.support.v4.view.ViewCompat;
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
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.i;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 1620})
public class er {
    public static float zo;
    public static volatile float hw = -1.0f;
    public static volatile int hn = -1;
    public static volatile float x = -1.0f;
    public static volatile int c = -1;
    public static volatile int uc = -1;
    public static int fw = 13;
    public static volatile int pr = -1;

    public interface pr {
        void pr(View view);
    }

    private static boolean uc() {
        return hw < 0.0f || hn < 0 || x < 0.0f || c < 0 || uc < 0;
    }

    public static float pr(Context context) {
        if (context == null) {
            context = com.byazt.sd.a.getContext();
        }
        if (context == null) {
            return Resources.getSystem().getDisplayMetrics().density;
        }
        if (com.byazt.sd.a.hw().sw()) {
            if (Build.VERSION.SDK_INT >= 30 && (context instanceof Activity)) {
                return context.getResources().getConfiguration().densityDpi / 160.0f;
            }
            return context.getResources().getDisplayMetrics().density;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static void hw(Context context) {
        Resources resources;
        if (context == null) {
            context = com.byazt.sd.a.getContext();
        }
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (uc()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            hw = displayMetrics.density;
            hn = displayMetrics.densityDpi;
            x = displayMetrics.scaledDensity;
            c = displayMetrics.widthPixels;
            uc = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (c > uc) {
                    int i = c;
                    c = uc;
                    uc = i;
                    return;
                }
                return;
            }
            if (c < uc) {
                int i2 = c;
                c = uc;
                uc = i2;
            }
        }
    }

    public static float pr(Context context, float f) {
        hw(context);
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static int hw(Context context, float f) {
        hw(context);
        float fZo = zo(context);
        if (fZo <= 0.0f) {
            fZo = 1.0f;
        }
        return (int) ((f / fZo) + 0.5f);
    }

    public static int hn(Context context, float f) {
        hw(context);
        return (int) ((f * pr(context)) + 0.5f);
    }

    public static int x(Context context, float f) {
        hw(context);
        float fPr = pr(context);
        if (fPr <= 0.0f) {
            fPr = 1.0f;
        }
        return (int) ((f / fPr) + 0.5f);
    }

    public static int pr(float f, float f2) {
        return (int) ((f2 * f) + 0.5f);
    }

    public static int hw(float f, float f2) {
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }

    public static int[] hn(Context context) {
        WindowManager windowManager = null;
        if (context == null) {
            return null;
        }
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception e) {
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
                if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    iArr[0] = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    iArr[1] = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                }
            } catch (Throwable th) {
            }
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int[] x(Context context) {
        hw(context);
        return new int[]{c, uc};
    }

    public static int c(Context context) {
        hw(context);
        return c;
    }

    public static int uc(Context context) {
        hw(context);
        return uc;
    }

    public static float fw(Context context) {
        hw(context);
        return hw;
    }

    public static float zo(Context context) {
        hw(context);
        return x;
    }

    public static void pr(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new com.byazt.ca.zo(rect, view));
    }

    public static int[] pr(View view) {
        if (view != null && view.getVisibility() == 0) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return iArr;
        }
        return null;
    }

    public static int[] hw(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] hn(View view) {
        if (view == null) {
            return null;
        }
        return new int[]{view.getWidth(), view.getHeight()};
    }

    private static boolean pr(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static void pr(View view, int i) {
        if (view == null || view.getVisibility() == i || !pr(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static void pr(View view, float f) {
        if (view == null) {
            return;
        }
        view.setAlpha(f);
    }

    public static boolean x(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean pr(SSWebView sSWebView) {
        if (sSWebView != null && sSWebView.canGoBack()) {
            sSWebView.goBack();
            return true;
        }
        return false;
    }

    public static void pr(final com.byazt.son.x xVar) {
        if (xVar == null) {
            return;
        }
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.wt.er.1
            @Override // java.lang.Runnable
            public void run() {
                WebSettings settings;
                WebView webView = xVar.getWebView();
                if (webView == null || (settings = webView.getSettings()) == null) {
                    return;
                }
                settings.setTextZoom(100);
            }
        });
    }

    public static void pr(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void hw(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            pr(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
        }
    }

    private static void pr(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
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

    public static boolean pr() {
        try {
            return !((KeyguardManager) com.byazt.sd.a.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable th) {
            return false;
        }
    }

    public static JSONObject pr(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i = 1;
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.byazt.sd.zo.nt().pr() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                if (!(!pr())) {
                    i = 0;
                }
                jSONObject.put("lock_scene", i);
            }
            if (str != null && !str.isEmpty() && !jSONObject.has("auto_show_check")) {
                jSONObject.put("auto_show_check", str);
            }
        } catch (Throwable th) {
            com.byazt.ca.ho.pr("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    public static void c(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.wt.er.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                er.pr(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static void uc(View view) {
        if (view == null) {
            return;
        }
        pr(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.wt.er.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static int aj(Context context) {
        if (context == null) {
            context = com.byazt.sd.a.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int vk(Context context) {
        if (context == null) {
            context = com.byazt.sd.a.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float w(Context context) {
        if (context == null) {
            context = com.byazt.sd.a.getContext();
        }
        try {
            int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier <= 0) {
                return 0.0f;
            }
            return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        } catch (Throwable th) {
            th.getMessage();
            return 0.0f;
        }
    }

    public static void pr(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (Build.VERSION.SDK_INT >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3846);
                hw(activity);
            }
        } catch (Exception e) {
        }
    }

    public static void hw(Activity activity) {
        try {
            hn(activity);
            activity.getWindow().addFlags(134217728);
        } catch (Exception e) {
        }
    }

    public static void hn(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (Build.VERSION.SDK_INT >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(i.b);
            }
        } catch (Exception e) {
        }
    }

    private static boolean vk(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && activity.getWindow().getDecorView().getHeight() > 0 && activity.getWindow().getDecorView().getWidth() > 0) {
                if (aj((Context) activity) - activity.getWindow().getDecorView().getHeight() <= 0 && vk((Context) activity) - activity.getWindow().getDecorView().getWidth() <= 0) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean x(Activity activity) {
        return uc(activity) || pr("ro.miui.notch") == 1 || k(activity) || m(activity) || x() || c() || vk(activity) || g(activity);
    }

    public static void c(Activity activity) {
        if (hn()) {
            return;
        }
        try {
            final WeakReference weakReference = new WeakReference(activity);
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.byazt.wt.er.4
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.zp.zo.pr(new com.byazt.xlm.fw("check_notch") { // from class: com.byazt.wt.er.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Activity activity2 = (Activity) weakReference.get();
                                if (activity2 != null && !er.hn()) {
                                    er.pr = er.x(activity2) ? 1 : 0;
                                }
                            } catch (Throwable th) {
                            }
                        }
                    });
                }
            });
        } catch (Throwable th) {
        }
    }

    public static boolean hw() {
        return pr == 1 || pr == -1;
    }

    public static boolean hn() {
        return pr != -1;
    }

    public static void pr(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && zo == 0.0f) {
                DisplayCutout displayCutout = null;
                WindowInsets rootWindowInsets = view.getRootWindowInsets();
                if (rootWindowInsets != null) {
                    displayCutout = rootWindowInsets.getDisplayCutout();
                }
                if (displayCutout != null) {
                    zo = displayCutout.getSafeInsetTop();
                }
            }
            if (zo == 0.0f) {
                return;
            }
            float fMax = Math.max(w(view2.getContext()), zo);
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
        } catch (Throwable th) {
        }
    }

    public static boolean uc(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        DisplayCutout displayCutout = null;
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets != null) {
                displayCutout = rootWindowInsets.getDisplayCutout();
            }
            return displayCutout != null;
        } catch (Throwable th) {
            return false;
        }
    }

    public static int pr(String str) {
        com.byazt.vkw.er erVar;
        if (z.a() && (erVar = (com.byazt.vkw.er) com.byazt.zs.uc.pr("system_info")) != null) {
            return erVar.hw(str);
        }
        return 0;
    }

    public static boolean k(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e2) {
            return false;
        } catch (Exception e3) {
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean m(Context context) {
        try {
            if ("V1938CT".equals(((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw())) {
                return false;
            }
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e2) {
            return false;
        } catch (Exception e3) {
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean g(Context context) {
        String strK = ls.k("com.kllk.feature.screen.heteromorphism");
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature(strK);
        } catch (Throwable th) {
            return true;
        }
    }

    public static boolean x() {
        String strHw = ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw();
        return strHw.equals("IN2010") || strHw.equals("IN2020") || strHw.equals("KB2000");
    }

    public static boolean c() {
        return Build.MANUFACTURER.equals("samsung");
    }

    public static void pr(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.byazt.ca.ho.hw("OnclickListener ", str + " is null , can not set OnClickListener !!!");
        } else {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void pr(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.byazt.ca.ho.hw("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
        } else {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static void pr(final View view, final pr prVar) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.wt.er.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(view);
                }
            }
        });
    }

    public static void pr(View view, final of ofVar) {
        if (view == null || ofVar == null) {
            return;
        }
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.wt.er.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.pr(com.byazt.sd.a.getContext(), ofVar);
            }
        });
    }

    public static void pr(TextView textView, String str, Context context) {
        if (textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1F161823"));
        gradientDrawable.setCornerRadius(hn(context, 3.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(-1073741825);
        textView.setGravity(17);
        textView.setPadding(hn(context, 2.0f), hn(context, 3.0f), hn(context, 2.0f), hn(context, 3.0f));
    }

    public static void pr(TextView textView, of ofVar) {
        if (textView == null || ofVar == null) {
            pr(textView);
            return;
        }
        String strJr = ofVar.jr();
        if (TextUtils.isEmpty(strJr)) {
            pr(textView);
            pr((View) textView, ofVar);
        } else {
            pr(textView, strJr, com.byazt.sd.a.getContext());
        }
    }

    public static void pr(TextView textView, of ofVar, int i, int i2) {
        if (textView == null || ofVar == null) {
            pr(textView, i, i2);
            return;
        }
        String strJr = ofVar.jr();
        if (TextUtils.isEmpty(strJr)) {
            pr(textView, i, i2);
            pr((View) textView, ofVar);
        } else {
            pr(textView, strJr, com.byazt.sd.a.getContext());
        }
    }

    public static Bitmap fw(View view) {
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

    private static void pr(TextView textView) {
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = hn(com.byazt.sd.a.getContext(), 32.0f);
        layoutParams.height = hn(com.byazt.sd.a.getContext(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    private static void pr(TextView textView, int i, int i2) {
        if (i <= 0) {
            i = 32;
        }
        if (i2 <= 0) {
            i2 = 14;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = hn(com.byazt.sd.a.getContext(), i);
        layoutParams.height = hn(com.byazt.sd.a.getContext(), i2);
        textView.setLayoutParams(layoutParams);
    }

    public static void fw(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                w(activity);
            } else {
                zo(activity);
            }
        } catch (Throwable th) {
        }
    }

    public static void zo(Activity activity) {
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
        } catch (Throwable th) {
        }
    }

    private static void w(Activity activity) {
        Object objInvoke;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            objInvoke = declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable th) {
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
        } catch (Throwable th2) {
        }
    }

    public static void hw(View view, final float f) {
        if (view == null || f <= 0.0f) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.wt.er.7
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            view.setClipToOutline(true);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(f);
        view.setBackground(gradientDrawable);
    }

    @Deprecated
    public static void pr(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.byazt.rc.pr.hw().pr(context, 4.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iHn = hn(context, 20.0f);
        int iHn2 = hn(context, 11.0f);
        textView.setPadding(iHn, iHn2, iHn, iHn2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(fw);
        textView.setGravity(17);
        textView.setText(str);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        toast.show();
    }

    public static TextView ho(Context context) {
        if (context == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.byazt.rc.pr.hw().pr(context, 4.0f));
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) (((double) uc(context)) * (-0.3d));
        int iHn = hn(context, 20.0f);
        int iHn2 = hn(context, 11.0f);
        textView.setPadding(iHn, iHn2, iHn, iHn2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(fw);
        textView.setGravity(17);
        return textView;
    }

    public static void zo(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static boolean aj(Activity activity) {
        if (activity.isFinishing()) {
            return false;
        }
        return Build.VERSION.SDK_INT < 17 || !activity.isDestroyed();
    }

    public static int nt(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }
}
