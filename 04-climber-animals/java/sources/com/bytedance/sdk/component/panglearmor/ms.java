package com.bytedance.sdk.component.panglearmor;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bytedance.sdk.component.utils.sl;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends View.AccessibilityDelegate {
    public static Field xr;
    public View ab;
    public View.AccessibilityDelegate c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static ms f1310ms = new ms(null, null);
    public static int ah = 0;
    public static String d = "";
    public static Set<Integer> ka = new HashSet();

    static {
        xr = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                xr = declaredField;
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
    }

    public ms(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.c = accessibilityDelegate;
        this.ab = view;
        SoftDecTool.h = true;
    }

    public static void ms(View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (ka.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                Field field = xr;
                if (field != null) {
                    accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
                } else {
                    z = false;
                    accessibilityDelegate = null;
                }
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
        if (!(accessibilityDelegate instanceof ms) && z) {
            view.setAccessibilityDelegate(new ms(accessibilityDelegate, view));
            ka.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        ah = hashCode();
        d = String.valueOf(this.c);
        view.setAccessibilityDelegate(this.c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        ah = hashCode();
        d = String.valueOf(this.c);
        SoftDecTool.a = true;
        view.setAccessibilityDelegate(this.c);
        View.AccessibilityDelegate accessibilityDelegate = this.c;
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
        ah = hashCode();
        d = String.valueOf(this.c);
        view.setAccessibilityDelegate(this.c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        boolean zDispatchPopulateAccessibilityEvent;
        ah = hashCode();
        d = String.valueOf(this.c);
        view.setAccessibilityDelegate(this.c);
        view.setAccessibilityDelegate(this.c);
        View.AccessibilityDelegate accessibilityDelegate = this.c;
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
        ah = hashCode();
        d = String.valueOf(this.c);
        if (ms()) {
            return;
        }
        view.setAccessibilityDelegate(this.c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ah = hashCode();
        d = String.valueOf(this.c);
        view.setAccessibilityDelegate(this.c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f = true;
        ah = hashCode();
        d = String.valueOf(this.c);
        view.setAccessibilityDelegate(this.c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        ah = hashCode();
        d = String.valueOf(this.c);
        view.setAccessibilityDelegate(this.c);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.c;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
            } else {
                super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        boolean zOnRequestSendAccessibilityEvent;
        ah = hashCode();
        d = String.valueOf(this.c);
        viewGroup.setAccessibilityDelegate(this.c);
        View.AccessibilityDelegate accessibilityDelegate = this.c;
        if (accessibilityDelegate != null) {
            zOnRequestSendAccessibilityEvent = accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        } else {
            zOnRequestSendAccessibilityEvent = super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        viewGroup.setAccessibilityDelegate(this);
        return zOnRequestSendAccessibilityEvent;
    }

    public boolean ms() {
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
