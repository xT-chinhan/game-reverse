package com.byazt.tka;

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
@com.byazt.cp.n(n = {0, 1, 689, 8})
public class s extends View.AccessibilityDelegate {
    public static Field qg;
    public View.AccessibilityDelegate w;
    public View x;
    public static s n = new s(null, null);
    public static int s = 0;
    public static String q = "";
    public static Set<Integer> l = new HashSet();

    static {
        qg = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                qg = declaredField;
            } catch (Throwable unused) {
            }
        }
    }

    public s(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.w = accessibilityDelegate;
        this.x = view;
        SoftDecTool.h = true;
    }

    public static void n(View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (l.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                Field field = qg;
                if (field != null) {
                    accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
                } else {
                    z = false;
                    accessibilityDelegate = null;
                }
            } catch (Throwable unused) {
            }
        }
        if (!(accessibilityDelegate instanceof s) && z) {
            view.setAccessibilityDelegate(new s(accessibilityDelegate, view));
            l.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        s = hashCode();
        q = String.valueOf(this.w);
        view.setAccessibilityDelegate(this.w);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.w;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        s = hashCode();
        q = String.valueOf(this.w);
        SoftDecTool.a = true;
        view.setAccessibilityDelegate(this.w);
        View.AccessibilityDelegate accessibilityDelegate = this.w;
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
        s = hashCode();
        q = String.valueOf(this.w);
        view.setAccessibilityDelegate(this.w);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.w;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        boolean zDispatchPopulateAccessibilityEvent;
        s = hashCode();
        q = String.valueOf(this.w);
        view.setAccessibilityDelegate(this.w);
        view.setAccessibilityDelegate(this.w);
        View.AccessibilityDelegate accessibilityDelegate = this.w;
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
        s = hashCode();
        q = String.valueOf(this.w);
        if (n()) {
            return;
        }
        view.setAccessibilityDelegate(this.w);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.w;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        s = hashCode();
        q = String.valueOf(this.w);
        view.setAccessibilityDelegate(this.w);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.w;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f = true;
        s = hashCode();
        q = String.valueOf(this.w);
        view.setAccessibilityDelegate(this.w);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.w;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        s = hashCode();
        q = String.valueOf(this.w);
        view.setAccessibilityDelegate(this.w);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.w;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                } else {
                    super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                }
            } catch (Throwable unused) {
            }
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        boolean zOnRequestSendAccessibilityEvent;
        s = hashCode();
        q = String.valueOf(this.w);
        viewGroup.setAccessibilityDelegate(this.w);
        View.AccessibilityDelegate accessibilityDelegate = this.w;
        if (accessibilityDelegate != null) {
            zOnRequestSendAccessibilityEvent = accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        } else {
            zOnRequestSendAccessibilityEvent = super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        viewGroup.setAccessibilityDelegate(this);
        return zOnRequestSendAccessibilityEvent;
    }

    public boolean n() {
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
