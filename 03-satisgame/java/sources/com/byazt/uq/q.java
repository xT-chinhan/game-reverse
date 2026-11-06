package com.byazt.uq;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 5})
public final class q {
    public static Field fs;
    public static WeakReference<View> w;
    public static final Map<View, l.C0366l> n = new WeakHashMap();
    public static final Map<View, Boolean> qg = new WeakHashMap();
    public static volatile int s = -1;
    public static long q = 0;
    public static boolean l = false;
    public static final Rect x = new Rect();
    public static boolean rv = false;
    public static long tj = 0;
    public static int cp = 0;
    public static volatile String d = null;
    public static final AtomicBoolean oa = new AtomicBoolean(false);
    public static final AtomicBoolean sz = new AtomicBoolean(false);
    public static final Runnable k = new Runnable() { // from class: com.byazt.uq.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.oa.set(false);
            try {
                q.sz();
            } catch (Throwable unused) {
            }
        }
    };

    public static void n() {
        s = -1;
        l = false;
        x();
        sz.set(false);
        cp = 0;
        qg.clear();
    }

    public static int qg() {
        return s;
    }

    public static void s() {
        n.clear();
    }

    public static void n(int i) {
        s = i;
        qg(qg(i));
    }

    public static void q() {
        l = true;
    }

    public static void l() {
        l = false;
    }

    public static void n(View view) {
        w = view != null ? new WeakReference<>(view) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String sz() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = d;
        boolean z = str != null && str.startsWith("Tab-");
        boolean z2 = z && cp >= 3;
        if (str != null && ((!z || z2) && jCurrentTimeMillis - tj < 15000)) {
            return str;
        }
        fs();
        if (d == null && (l.s() == null || l.s().isEmpty())) {
            k();
        }
        String str2 = d;
        if (str2 == null) {
            str2 = "";
        }
        if (!str2.startsWith("Tab-")) {
            cp = 0;
        } else if (z) {
            cp++;
        } else {
            cp = 1;
        }
        d = str2;
        tj = jCurrentTimeMillis;
        return str2;
    }

    private static void k() {
        AtomicBoolean atomicBoolean = sz;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        try {
            Activity activityN = x.n();
            if (activityN == null) {
                return;
            }
            l.qg qgVarN = l.n(activityN);
            if (!((qgVarN == null || qgVarN.q == null || qgVarN.q.isEmpty()) ? false : true) || qgVarN.qg < 0 || qgVarN.qg >= qgVarN.q.size()) {
                return;
            }
            l = true;
            n(qgVarN.qg);
        } catch (Throwable unused) {
        }
    }

    public static String w() {
        if (hd()) {
            return sz();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = d;
        boolean z = str != null && jCurrentTimeMillis - tj < 15000;
        if (!z && oa.compareAndSet(false, true)) {
            com.byazt.ag.qg.n(k);
        }
        if (z || str != null) {
            return str;
        }
        String strCy = cy();
        return strCy != null ? strCy : "";
    }

    private static String cy() {
        l.C0366l c0366l;
        int i = s;
        if (i < 0) {
            return null;
        }
        List<l.C0366l> listQ = l.q();
        if (listQ != null && i < listQ.size() && (c0366l = listQ.get(i)) != null && !TextUtils.isEmpty(c0366l.s)) {
            return c0366l.s + "-Tab-" + i;
        }
        return "Tab-".concat(String.valueOf(i));
    }

    public static void x() {
        d = null;
        tj = 0L;
        cp = 0;
    }

    public static void fs() {
        int iL;
        if (l && cd() && (iL = l.l()) >= 0) {
            boolean z = iL != s;
            boolean z2 = s < 0;
            if (z) {
                s = iL;
            } else if (!z2) {
                return;
            }
            qg(qg(iL));
        }
    }

    public static void n(View view, l.C0366l c0366l) {
        if (view == null) {
            return;
        }
        n.put(view, c0366l);
        qg(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                n(viewGroup.getChildAt(i), c0366l);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static final class n extends View.AccessibilityDelegate {
        public final View.AccessibilityDelegate n;
        public boolean qg;

        public n(View.AccessibilityDelegate accessibilityDelegate) {
            this.n = accessibilityDelegate;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            if (this.qg) {
                super.sendAccessibilityEvent(view, i);
                return;
            }
            this.qg = true;
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.n;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i);
                } else {
                    super.sendAccessibilityEvent(view, i);
                }
                this.qg = false;
                if (i == 1 || i == 4) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - q.q < 300) {
                        return;
                    }
                    long unused = q.q = jCurrentTimeMillis;
                    l.C0366l c0366l = (l.C0366l) q.n.get(view);
                    if (c0366l != null) {
                        int unused2 = q.s = c0366l.n;
                        q.qg(c0366l.n());
                        int unused3 = q.s;
                    }
                }
            } catch (Throwable th) {
                this.qg = false;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(String str) {
        if (str == null) {
            str = "";
        }
        d = str;
        tj = System.currentTimeMillis();
    }

    private static boolean hd() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private static boolean cd() {
        View view;
        WeakReference<View> weakReference = w;
        if (weakReference != null && (view = weakReference.get()) != null && view.isAttachedToWindow() && view.getVisibility() == 0 && view.getWidth() > 0 && view.getHeight() > 0) {
            return view.getGlobalVisibleRect(x);
        }
        return false;
    }

    public static String qg(int i) {
        String strConcat = "Tab-".concat(String.valueOf(i));
        List<l.C0366l> listS = l.s();
        if (listS == null || i < 0 || i >= listS.size()) {
            return strConcat;
        }
        String strN = listS.get(i).n();
        return !TextUtils.isEmpty(strN) ? strN : strConcat;
    }

    private static void qg(View view) {
        Map<View, Boolean> map = qg;
        if (map.containsKey(view)) {
            return;
        }
        View.AccessibilityDelegate accessibilityDelegateS = s(view);
        if (accessibilityDelegateS instanceof n) {
            return;
        }
        view.setAccessibilityDelegate(new n(accessibilityDelegateS));
        map.put(view, Boolean.TRUE);
    }

    private static View.AccessibilityDelegate s(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (rv) {
            return null;
        }
        try {
            if (fs == null) {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                fs = declaredField;
                declaredField.setAccessible(true);
            }
            Object obj = fs.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
        } catch (Throwable unused) {
            rv = true;
        }
        return null;
    }
}
