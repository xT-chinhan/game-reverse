package com.byazt.vu;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 733, 62})
public class fw {
    public static boolean c;
    public static boolean hn;
    public static Method hw;
    public static Field pr;
    public static Field x;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                hw = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception e) {
            }
        }
    }

    public static int pr(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void pr(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void pr(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    public static float pr(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : hn(viewConfiguration, context);
    }

    public static float hw(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : hn(viewConfiguration, context);
    }

    private static float hn(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = hw) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception e) {
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int hw(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void pr(View view, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            if (Build.VERSION.SDK_INT >= 16) {
                if (i == 4) {
                    i = 2;
                }
            } else {
                return;
            }
        }
        view.setImportantForAccessibility(i);
    }

    public static void hn(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static int x(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!hn) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                pr = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            hn = true;
        }
        Field field = pr;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception e2) {
                return 0;
            }
        }
        return 0;
    }

    public static int c(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                x = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            c = true;
        }
        Field field = x;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception e2) {
                return 0;
            }
        }
        return 0;
    }

    public static boolean uc(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static Display fw(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (zo(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static boolean zo(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static int aj(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void hw(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static boolean pr(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void vk(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof hw) {
            ((hw) view).stopNestedScroll();
        }
    }
}
