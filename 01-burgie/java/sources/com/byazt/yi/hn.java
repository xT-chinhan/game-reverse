package com.byazt.yi;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.byakv.z.SoftDecTool;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, 20})
public class hn extends View.AccessibilityDelegate {
    public static Field hw;
    public View fw;
    public View.AccessibilityDelegate uc;
    public static hn pr = new hn(null, null);
    public static int hn = 0;
    public static String x = "";
    public static Set<Integer> c = new HashSet();

    static {
        hw = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                hw = declaredField;
            } catch (Throwable th) {
            }
        }
    }

    public hn(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.uc = accessibilityDelegate;
        this.fw = view;
        SoftDecTool.h = true;
    }

    public static void pr(View view) {
        if (c.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z = true;
        View.AccessibilityDelegate accessibilityDelegate = null;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                Field field = hw;
                if (field == null) {
                    z = false;
                } else {
                    accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
                }
            } catch (Throwable th) {
                z = false;
            }
        }
        if (!(accessibilityDelegate instanceof hn) && z) {
            view.setAccessibilityDelegate(new hn(accessibilityDelegate, view));
            c.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        hn = hashCode();
        x = String.valueOf(this.uc);
        view.setAccessibilityDelegate(this.uc);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.uc;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        } catch (Throwable th) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        hn = hashCode();
        x = String.valueOf(this.uc);
        SoftDecTool.a = true;
        view.setAccessibilityDelegate(this.uc);
        View.AccessibilityDelegate accessibilityDelegate = this.uc;
        if (accessibilityDelegate != null) {
            zPerformAccessibilityAction = accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        } else {
            zPerformAccessibilityAction = super.performAccessibilityAction(view, i, bundle);
        }
        view.setAccessibilityDelegate(this);
        return zPerformAccessibilityAction;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        hn = hashCode();
        x = String.valueOf(this.uc);
        view.setAccessibilityDelegate(this.uc);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.uc;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable th) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        boolean zDispatchPopulateAccessibilityEvent;
        hn = hashCode();
        x = String.valueOf(this.uc);
        view.setAccessibilityDelegate(this.uc);
        view.setAccessibilityDelegate(this.uc);
        View.AccessibilityDelegate accessibilityDelegate = this.uc;
        if (accessibilityDelegate != null) {
            zDispatchPopulateAccessibilityEvent = accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        } else {
            zDispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        view.setAccessibilityDelegate(this);
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        hn = hashCode();
        x = String.valueOf(this.uc);
        if (pr()) {
            return;
        }
        view.setAccessibilityDelegate(this.uc);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.uc;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        hn = hashCode();
        x = String.valueOf(this.uc);
        view.setAccessibilityDelegate(this.uc);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.uc;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f = true;
        hn = hashCode();
        x = String.valueOf(this.uc);
        view.setAccessibilityDelegate(this.uc);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.uc;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable th) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        hn = hashCode();
        x = String.valueOf(this.uc);
        view.setAccessibilityDelegate(this.uc);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.uc;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                } else {
                    super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                }
            } catch (Throwable th) {
            }
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        boolean zOnRequestSendAccessibilityEvent;
        hn = hashCode();
        x = String.valueOf(this.uc);
        viewGroup.setAccessibilityDelegate(this.uc);
        View.AccessibilityDelegate accessibilityDelegate = this.uc;
        if (accessibilityDelegate != null) {
            zOnRequestSendAccessibilityEvent = accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        } else {
            zOnRequestSendAccessibilityEvent = super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        viewGroup.setAccessibilityDelegate(this);
        return zOnRequestSendAccessibilityEvent;
    }

    public boolean pr() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4 || (stackTraceElement = stackTrace[3]) == null) {
            return false;
        }
        for (int i = 4; i < stackTrace.length; i++) {
            if (stackTrace[i] != null && stackTraceElement.getMethodName().equals(stackTrace[i].getMethodName()) && stackTraceElement.getClassName().equals(stackTrace[i].getClassName())) {
                return true;
            }
        }
        return false;
    }
}
