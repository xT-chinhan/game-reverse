package com.byazt.ua;

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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 121})
public final class x {
    public static WeakReference<View> uc;
    public static Field zo;
    public static final Map<View, c.C0203c> pr = new WeakHashMap();
    public static final Map<View, Boolean> hw = new WeakHashMap();
    public static int hn = -1;
    public static long x = 0;
    public static boolean c = false;
    public static final Rect fw = new Rect();
    public static boolean aj = false;
    public static long vk = 0;
    public static int w = 0;
    public static volatile String k = null;
    public static final AtomicBoolean m = new AtomicBoolean(false);
    public static final AtomicBoolean g = new AtomicBoolean(false);
    public static final Runnable ho = new Runnable() { // from class: com.byazt.ua.x.1
        @Override // java.lang.Runnable
        public void run() {
            x.m.set(false);
            try {
                x.g();
            } catch (Throwable th) {
            }
        }
    };

    public static void pr() {
        hn = -1;
        c = false;
        fw();
        g.set(false);
        w = 0;
        hw.clear();
    }

    public static int hw() {
        return hn;
    }

    public static void hn() {
        pr.clear();
    }

    public static void pr(int i) {
        hn = i;
        hw(hn(i));
    }

    public static void x() {
        c = true;
    }

    public static void c() {
        c = false;
    }

    public static void pr(View view) {
        uc = view != null ? new WeakReference<>(view) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = k;
        boolean z = str != null && str.startsWith("Tab_");
        boolean z2 = z && w >= 3;
        if (str != null && ((!z || z2) && jCurrentTimeMillis - vk < 60000)) {
            return str;
        }
        zo();
        if (k == null && (c.hn() == null || c.hn().isEmpty())) {
            ho();
        }
        String str2 = k;
        if (str2 == null) {
            str2 = "";
        }
        if (str2.startsWith("Tab_")) {
            if (z) {
                w++;
            } else {
                w = 1;
            }
        } else {
            w = 0;
        }
        k = str2;
        vk = jCurrentTimeMillis;
        return str2;
    }

    private static void ho() {
        AtomicBoolean atomicBoolean = g;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        try {
            Activity activityPr = fw.pr();
            if (activityPr == null) {
                return;
            }
            c.hw hwVarPr = c.pr(activityPr);
            if (((hwVarPr == null || hwVarPr.x == null || hwVarPr.x.isEmpty()) ? false : true) && hwVarPr.hw >= 0 && hwVarPr.hw < hwVarPr.x.size()) {
                c = true;
                pr(hwVarPr.hw);
            }
        } catch (Throwable th) {
        }
    }

    public static String uc() {
        if (nt()) {
            return g();
        }
        String str = k;
        if ((str == null || System.currentTimeMillis() - vk >= 60000) && m.compareAndSet(false, true)) {
            com.byazt.zp.zo.pr(ho);
        }
        return str != null ? str : " ";
    }

    public static void fw() {
        k = null;
        vk = 0L;
        w = 0;
    }

    public static void zo() {
        int iX;
        if (c && yb() && (iX = c.x()) >= 0) {
            int i = hn;
            boolean z = iX != i;
            boolean z2 = i < 0;
            if (z) {
                hn = iX;
            } else if (!z2) {
                return;
            }
            hw(hn(iX));
        }
    }

    public static void pr(View view, c.C0203c c0203c) {
        if (view == null) {
            return;
        }
        pr.put(view, c0203c);
        hw(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                pr(viewGroup.getChildAt(i), c0203c);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private static final class pr extends View.AccessibilityDelegate {
        public boolean hw;
        public final View.AccessibilityDelegate pr;

        public pr(View.AccessibilityDelegate accessibilityDelegate) {
            this.pr = accessibilityDelegate;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            if (this.hw) {
                super.sendAccessibilityEvent(view, i);
                return;
            }
            this.hw = true;
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.pr;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i);
                } else {
                    super.sendAccessibilityEvent(view, i);
                }
                this.hw = false;
                if (i != 1 && i != 4) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - x.x >= 300) {
                    long unused = x.x = jCurrentTimeMillis;
                    c.C0203c c0203c = (c.C0203c) x.pr.get(view);
                    if (c0203c != null) {
                        int unused2 = x.hn = c0203c.pr;
                        x.hw(c0203c.pr());
                        int unused3 = x.hn;
                    }
                }
            } catch (Throwable th) {
                this.hw = false;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(String str) {
        if (str == null) {
            str = "";
        }
        k = str;
        vk = System.currentTimeMillis();
    }

    private static boolean nt() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private static boolean yb() {
        View view;
        WeakReference<View> weakReference = uc;
        if (weakReference == null || (view = weakReference.get()) == null || !view.isAttachedToWindow() || view.getVisibility() != 0 || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return false;
        }
        return view.getGlobalVisibleRect(fw);
    }

    private static String hn(int i) {
        String strConcat = "Tab_".concat(String.valueOf(i));
        List<c.C0203c> listHn = c.hn();
        if (listHn != null && i >= 0 && i < listHn.size()) {
            String strPr = listHn.get(i).pr();
            if (!TextUtils.isEmpty(strPr)) {
                return strPr;
            }
            return strConcat;
        }
        return strConcat;
    }

    private static void hw(View view) {
        Map<View, Boolean> map = hw;
        if (map.containsKey(view)) {
            return;
        }
        View.AccessibilityDelegate accessibilityDelegateHn = hn(view);
        if (accessibilityDelegateHn instanceof pr) {
            return;
        }
        view.setAccessibilityDelegate(new pr(accessibilityDelegateHn));
        map.put(view, Boolean.TRUE);
    }

    private static View.AccessibilityDelegate hn(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (aj) {
            return null;
        }
        try {
            if (zo == null) {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                zo = declaredField;
                declaredField.setAccessible(true);
            }
            Object obj = zo.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
        } catch (Throwable th) {
            aj = true;
        }
        return null;
    }
}
