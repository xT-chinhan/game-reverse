package com.byazt.njk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, 20})
public final class hn {
    public boolean aj;
    public View c;
    public boolean fw;
    public final View.OnAttachStateChangeListener g;
    public c hn;
    public Application ho;
    public hw hw;
    public final ViewTreeObserver.OnWindowFocusChangeListener m;
    public final Application.ActivityLifecycleCallbacks nt;
    public final Context pr;
    public boolean uc;
    public com.byazt.njk.pr x;
    public boolean zo = true;
    public final Rect vk = new Rect();
    public final View.OnLayoutChangeListener w = new View.OnLayoutChangeListener() { // from class: com.byazt.njk.hn.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (hn.this.x != null) {
                hn.this.x.setBounds(0, 0, i3 - i, i4 - i2);
            }
            hn.this.zo();
        }
    };
    public final ViewTreeObserver.OnScrollChangedListener k = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.njk.hn.2
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            hn.this.zo();
        }
    };

    public hn(Context context) {
        ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener;
        if (Build.VERSION.SDK_INT >= 18) {
            onWindowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.byazt.njk.hn.3
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z) {
                    hn.this.zo();
                }
            };
        } else {
            onWindowFocusChangeListener = null;
        }
        this.m = onWindowFocusChangeListener;
        this.g = new View.OnAttachStateChangeListener() { // from class: com.byazt.njk.hn.4
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                hn.this.c();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                hn.this.uc();
            }
        };
        this.nt = new pr() { // from class: com.byazt.njk.hn.5
            @Override // com.byazt.njk.hn.pr, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (activity == hn.this.nt()) {
                    hn.this.zo = true;
                    hn.this.zo();
                }
            }

            @Override // com.byazt.njk.hn.pr, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (activity == hn.this.nt()) {
                    hn.this.zo = false;
                    hn.this.zo();
                }
            }
        };
        this.pr = context != null ? context.getApplicationContext() : null;
    }

    public void pr(String str) {
        hw hwVarPr = hw.pr(this.pr, str);
        if (hwVarPr == null || !hwVarPr.hn()) {
            if (this.hw != null) {
                m();
                g();
                this.hw = null;
                return;
            }
            return;
        }
        if (this.hw == hwVarPr) {
            return;
        }
        m();
        g();
        this.hw = hwVarPr;
        if (this.uc && this.c != null) {
            k();
            boolean z = this.fw;
            this.fw = false;
            pr(z || fw());
        }
    }

    public boolean pr() {
        return this.hw != null;
    }

    public void pr(View view) {
        if (this.c == view) {
            return;
        }
        hw();
        this.c = view;
        if (view == null || this.hw == null || !ho()) {
            return;
        }
        vk();
        if (this.c.getWindowToken() != null) {
            c();
        }
    }

    public void hw() {
        uc();
        this.c = null;
        g();
    }

    public void hn() {
        c();
    }

    public void x() {
        uc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.uc || this.c == null || this.hw == null || !ho()) {
            return;
        }
        vk();
        this.uc = true;
        k();
        ViewTreeObserver viewTreeObserver = this.c.getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnScrollChangedListener(this.k);
            if (this.m != null && Build.VERSION.SDK_INT >= 18) {
                viewTreeObserver.addOnWindowFocusChangeListener(this.m);
            }
        }
        yb();
        zo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc() {
        View view = this.c;
        if (view == null) {
            this.uc = false;
            this.fw = false;
            lb();
            this.aj = false;
            return;
        }
        if (this.uc) {
            this.uc = false;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this.k);
                if (this.m != null && Build.VERSION.SDK_INT >= 18) {
                    viewTreeObserver.removeOnWindowFocusChangeListener(this.m);
                }
            }
            pr(false);
            m();
        }
        w();
        lb();
    }

    private boolean fw() {
        View view;
        return this.uc && (view = this.c) != null && this.zo && view.getVisibility() == 0 && this.c.getWindowVisibility() == 0 && this.c.getWidth() > 0 && this.c.getHeight() > 0 && this.c.getAlpha() > 0.0f && this.c.getGlobalVisibleRect(this.vk) && this.vk.width() > 1 && this.vk.height() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zo() {
        pr(fw());
    }

    private void pr(boolean z) {
        if (this.fw == z) {
            return;
        }
        this.fw = z;
        if (z) {
            aj();
            c cVar = this.hn;
            if (cVar != null) {
                cVar.x();
            }
            com.byazt.njk.pr prVar = this.x;
            if (prVar != null) {
                prVar.pr();
                return;
            }
            return;
        }
        com.byazt.njk.pr prVar2 = this.x;
        if (prVar2 != null) {
            prVar2.hw();
        }
        c cVar2 = this.hn;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    private void aj() {
        hw hwVar = this.hw;
        if (hwVar == null) {
            return;
        }
        if (this.hn == null) {
            this.hn = new c(hwVar);
        }
        View view = this.c;
        if (view != null) {
            this.hn.pr(view.getWidth(), this.c.getHeight());
        }
    }

    private void vk() {
        View view = this.c;
        if (view == null || this.aj) {
            return;
        }
        view.addOnLayoutChangeListener(this.w);
        this.c.addOnAttachStateChangeListener(this.g);
        this.aj = true;
    }

    private void w() {
        View view = this.c;
        if (view == null || !this.aj) {
            return;
        }
        view.removeOnLayoutChangeListener(this.w);
        this.c.removeOnAttachStateChangeListener(this.g);
        this.aj = false;
    }

    private void k() {
        if (this.c == null || this.hw == null || !ho()) {
            return;
        }
        aj();
        if (this.x == null) {
            this.x = new com.byazt.njk.pr(this.hn);
        }
        int width = this.c.getWidth();
        int height = this.c.getHeight();
        if (width > 0 && height > 0) {
            this.x.setBounds(0, 0, width, height);
        }
        this.c.getOverlay().add(this.x);
    }

    private void m() {
        if (this.c != null && this.x != null && ho()) {
            this.c.getOverlay().remove(this.x);
        }
    }

    private void g() {
        com.byazt.njk.pr prVar = this.x;
        if (prVar != null) {
            prVar.hw();
        }
        c cVar = this.hn;
        if (cVar != null) {
            cVar.uc();
            this.hn = null;
        }
        this.x = null;
    }

    private static boolean ho() {
        return Build.VERSION.SDK_INT >= 18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity nt() {
        View view = this.c;
        if (view == null) {
            return null;
        }
        return pr(view.getContext());
    }

    private static Activity pr(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext != context) {
                context = baseContext;
            } else {
                return null;
            }
        }
        return null;
    }

    private void yb() {
        Activity activityNt;
        Application application;
        if (this.ho != null || (activityNt = nt()) == null || (application = activityNt.getApplication()) == null) {
            return;
        }
        this.ho = application;
        application.registerActivityLifecycleCallbacks(this.nt);
    }

    private void lb() {
        Application application = this.ho;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.nt);
            this.ho = null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, 116})
    private static abstract class pr implements Application.ActivityLifecycleCallbacks {
        private pr() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }
    }
}
