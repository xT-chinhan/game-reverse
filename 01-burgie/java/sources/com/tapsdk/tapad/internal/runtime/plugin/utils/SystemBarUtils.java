package com.tapsdk.tapad.internal.runtime.plugin.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemBarUtils {
    private static final int LEGACY_FULLSCREEN_FLAGS = 5894;
    private static final int LEGACY_FULLSCREEN_LAYOUT_FLAGS = 1792;
    private static final int LEGACY_HIDE_NAVIGATION_FLAGS = 4866;
    private static final int LEGACY_HIDE_STATUS_BAR_FLAGS = 1284;
    private static final String TAG = "SystemBarUtils";

    private SystemBarUtils() {
    }

    private static void enableNotchSupport(Window window) {
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
    }

    public static void hideNavigationBar(Activity activity) {
        hideNavigationBar(activity, true);
    }

    private static void hideNavigationBarLegacy(Window window, boolean z) {
        final View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(LEGACY_HIDE_NAVIGATION_FLAGS);
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.utils.SystemBarUtils$$ExternalSyntheticLambda4
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                SystemBarUtils.lambda$hideNavigationBarLegacy$4(decorView, i);
            }
        });
    }

    private static void hideNavigationBarModern(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                window.setDecorFitsSystemWindows(false);
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController == null) {
                    hideNavigationBarLegacy(window, z);
                } else {
                    insetsController.hide(WindowInsets.Type.navigationBars());
                    insetsController.setSystemBarsBehavior(2);
                }
            } catch (Exception e) {
                hideNavigationBarLegacy(window, z);
            }
        }
    }

    public static void hideStatusBar(Activity activity) {
        hideStatusBar(activity, true);
    }

    private static void hideStatusBarLegacy(Window window, boolean z) {
        window.getDecorView().setSystemUiVisibility(LEGACY_HIDE_STATUS_BAR_FLAGS);
        if (z) {
            enableNotchSupport(window);
        }
    }

    private static void hideStatusBarModern(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                window.setDecorFitsSystemWindows(false);
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    insetsController.hide(WindowInsets.Type.statusBars());
                    insetsController.setSystemBarsBehavior(2);
                } else {
                    hideStatusBarLegacy(window, z);
                }
            } catch (Exception e) {
                hideStatusBarLegacy(window, z);
            }
            if (z) {
                enableNotchSupport(window);
            }
        }
    }

    public static void hideSystemBars(Activity activity) {
        hideSystemBars(activity, true);
    }

    public static void hideSystemBarsDelayed(final Activity activity, final boolean z) {
        Window window;
        if (activity == null || activity.isFinishing() || (window = activity.getWindow()) == null) {
            return;
        }
        window.addFlags(1152);
        hideSystemBars(activity, z);
        try {
            window.getDecorView().post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.utils.SystemBarUtils$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    SystemBarUtils.hideSystemBars(activity, z);
                }
            });
        } catch (Exception e) {
        }
    }

    private static void hideSystemBarsLegacy(Window window, boolean z) {
        final View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(LEGACY_FULLSCREEN_FLAGS);
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.utils.SystemBarUtils$$ExternalSyntheticLambda3
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                SystemBarUtils.lambda$hideSystemBarsLegacy$2(decorView, i);
            }
        });
        if (z) {
            enableNotchSupport(window);
        }
    }

    private static void hideSystemBarsModern(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                window.setDecorFitsSystemWindows(false);
                if (window.getDecorView() == null) {
                    hideSystemBarsLegacy(window, z);
                    return;
                }
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController == null) {
                    hideSystemBarsLegacy(window, z);
                    return;
                }
                insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
                if (z) {
                    enableNotchSupport(window);
                }
            } catch (Exception e) {
                hideSystemBarsLegacy(window, z);
            }
        }
    }

    static /* synthetic */ void lambda$hideNavigationBarLegacy$3(View view) {
        if (view.isAttachedToWindow()) {
            view.setSystemUiVisibility(LEGACY_HIDE_NAVIGATION_FLAGS);
        }
    }

    static /* synthetic */ void lambda$hideNavigationBarLegacy$4(final View view, int i) {
        if ((i & 2) == 0) {
            view.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.utils.SystemBarUtils$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SystemBarUtils.lambda$hideNavigationBarLegacy$3(view);
                }
            }, 500L);
        }
    }

    static /* synthetic */ void lambda$hideSystemBarsLegacy$1(View view) {
        if (view.isAttachedToWindow()) {
            view.setSystemUiVisibility(LEGACY_FULLSCREEN_FLAGS);
        }
    }

    static /* synthetic */ void lambda$hideSystemBarsLegacy$2(final View view, int i) {
        if ((i & 4) == 0) {
            view.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.utils.SystemBarUtils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SystemBarUtils.lambda$hideSystemBarsLegacy$1(view);
                }
            }, 500L);
        }
    }

    private static void prepareFullscreenWindow(Window window, boolean z) {
        window.clearFlags(201326592);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            window.setNavigationBarDividerColor(0);
        }
        if (i >= 29) {
            window.setStatusBarContrastEnforced(false);
            window.setNavigationBarContrastEnforced(false);
        }
        if (i >= 30) {
            window.setDecorFitsSystemWindows(false);
        } else {
            View decorView = window.getDecorView();
            if (decorView != null) {
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | LEGACY_FULLSCREEN_LAYOUT_FLAGS);
            }
        }
        if (z) {
            enableNotchSupport(window);
        }
    }

    public static void setNavigationBarColor(Activity activity, int i) {
        Window window;
        if (activity == null || activity.isFinishing() || (window = activity.getWindow()) == null) {
            return;
        }
        window.setNavigationBarColor(i);
    }

    public static void setStatusBarColor(Activity activity, int i) {
        Window window;
        if (activity == null || activity.isFinishing() || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
    }

    public static void setupFullscreenAdActivity(Activity activity, boolean z, boolean z2) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            if (activity.getActionBar() != null) {
                activity.getActionBar().hide();
            }
        } catch (Exception e) {
        }
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        try {
            window.requestFeature(1);
        } catch (Exception e2) {
        }
        window.addFlags(1024);
        window.clearFlags(2048);
        prepareFullscreenWindow(window, z);
        if (z2) {
            window.addFlags(8192);
        }
        hideSystemBarsDelayed(activity, z);
    }

    public static void setupFullscreenDialog(Window window) {
        if (window == null) {
            return;
        }
        window.addFlags(1024);
        if (Build.VERSION.SDK_INT >= 30) {
            hideSystemBarsModern(window, true);
        } else {
            hideSystemBarsLegacy(window, true);
        }
    }

    public static void setupTranslucentAdActivity(Activity activity, boolean z) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            if (activity.getActionBar() != null) {
                activity.getActionBar().hide();
            }
        } catch (Exception e) {
        }
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        try {
            window.requestFeature(1);
        } catch (Exception e2) {
        }
        window.addFlags(1024);
        window.clearFlags(2048);
        prepareFullscreenWindow(window, z);
        window.setFlags(16777216, 16777216);
        hideSystemBarsDelayed(activity, z);
    }

    public static void showSystemBars(Activity activity) {
        Window window;
        if (activity == null || activity.isFinishing() || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(1024);
        if (Build.VERSION.SDK_INT >= 30) {
            showSystemBarsModern(window);
        } else {
            showSystemBarsLegacy(window);
        }
    }

    private static void showSystemBarsLegacy(Window window) {
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(0);
        decorView.setOnSystemUiVisibilityChangeListener(null);
    }

    private static void showSystemBarsModern(Window window) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                window.setDecorFitsSystemWindows(true);
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    insetsController.show(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                }
            } catch (Exception e) {
            }
        }
    }

    public static void hideNavigationBar(Activity activity, boolean z) {
        Window window;
        if (activity == null || activity.isFinishing() || (window = activity.getWindow()) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            hideNavigationBarModern(window, z);
        } else {
            hideNavigationBarLegacy(window, z);
        }
    }

    public static void hideStatusBar(Activity activity, boolean z) {
        Window window;
        if (activity == null || activity.isFinishing() || (window = activity.getWindow()) == null) {
            return;
        }
        window.addFlags(1024);
        if (Build.VERSION.SDK_INT >= 30) {
            hideStatusBarModern(window, z);
        } else {
            hideStatusBarLegacy(window, z);
        }
    }

    public static void hideSystemBars(Activity activity, boolean z) {
        Window window;
        if (activity == null || activity.isFinishing() || (window = activity.getWindow()) == null) {
            return;
        }
        window.addFlags(1152);
        if (Build.VERSION.SDK_INT >= 30) {
            hideSystemBarsModern(window, z);
        } else {
            hideSystemBarsLegacy(window, z);
        }
    }

    public static void setupTranslucentAdActivity(Activity activity) {
        setupTranslucentAdActivity(activity, true);
    }

    public static void setupFullscreenAdActivity(Activity activity) {
        setupFullscreenAdActivity(activity, true, false);
    }
}
