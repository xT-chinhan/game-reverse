package com.byazt.uw;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1462, 8})
public final class s {
    public Application k;
    public View l;
    public final Context n;
    public com.byazt.uw.n q;
    public qg qg;
    public boolean rv;
    public l s;
    public boolean w;
    public boolean x;
    public boolean fs = true;
    public final Rect tj = new Rect();
    public final View.OnLayoutChangeListener cp = new View.OnLayoutChangeListener() { // from class: com.byazt.uw.s.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (s.this.q != null) {
                s.this.q.setBounds(0, 0, i3 - i, i4 - i2);
            }
            s.this.fs();
        }
    };
    public final ViewTreeObserver.OnScrollChangedListener d = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.uw.s.2
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            s.this.fs();
        }
    };
    public final ViewTreeObserver.OnWindowFocusChangeListener oa = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.byazt.uw.s.3
        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            s.this.fs();
        }
    };
    public final View.OnAttachStateChangeListener sz = new View.OnAttachStateChangeListener() { // from class: com.byazt.uw.s.4
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            s.this.l();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            s.this.w();
        }
    };
    public final Application.ActivityLifecycleCallbacks cy = new n() { // from class: com.byazt.uw.s.5
        @Override // com.byazt.uw.s.n, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity == s.this.cy()) {
                s.this.fs = true;
                s.this.fs();
            }
        }

        @Override // com.byazt.uw.s.n, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity == s.this.cy()) {
                s.this.fs = false;
                s.this.fs();
            }
        }
    };

    private static boolean k() {
        return true;
    }

    public s(Context context) {
        this.n = context != null ? context.getApplicationContext() : null;
    }

    public void n(String str) {
        qg qgVarN = qg.n(this.n, str);
        if (qgVarN == null || !qgVarN.s()) {
            if (this.qg != null) {
                oa();
                sz();
                this.qg = null;
                return;
            }
            return;
        }
        if (this.qg == qgVarN) {
            return;
        }
        oa();
        sz();
        this.qg = qgVarN;
        if (!this.w || this.l == null) {
            return;
        }
        d();
        boolean z = this.x;
        this.x = false;
        n(z || x());
    }

    public boolean n() {
        return this.qg != null;
    }

    public void n(View view) {
        if (this.l == view) {
            return;
        }
        qg();
        this.l = view;
        if (view == null || this.qg == null || !k()) {
            return;
        }
        tj();
        if (this.l.getWindowToken() != null) {
            l();
        }
    }

    public void qg() {
        w();
        this.l = null;
        sz();
    }

    public void s() {
        l();
    }

    public void q() {
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.w || this.l == null || this.qg == null || !k()) {
            return;
        }
        tj();
        this.w = true;
        d();
        ViewTreeObserver viewTreeObserver = this.l.getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnScrollChangedListener(this.d);
            if (this.oa != null) {
                viewTreeObserver.addOnWindowFocusChangeListener(this.oa);
            }
        }
        hd();
        fs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        View view = this.l;
        if (view == null) {
            this.w = false;
            this.x = false;
            cd();
            this.rv = false;
            return;
        }
        if (this.w) {
            this.w = false;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this.d);
                if (this.oa != null) {
                    viewTreeObserver.removeOnWindowFocusChangeListener(this.oa);
                }
            }
            n(false);
            oa();
        }
        cp();
        cd();
    }

    private boolean x() {
        View view;
        return this.w && (view = this.l) != null && this.fs && view.getVisibility() == 0 && this.l.getWindowVisibility() == 0 && this.l.getWidth() > 0 && this.l.getHeight() > 0 && this.l.getAlpha() > 0.0f && this.l.getGlobalVisibleRect(this.tj) && this.tj.width() > 1 && this.tj.height() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs() {
        n(x());
    }

    private void n(boolean z) {
        if (this.x == z) {
            return;
        }
        this.x = z;
        if (z) {
            rv();
            l lVar = this.s;
            if (lVar != null) {
                lVar.q();
            }
            com.byazt.uw.n nVar = this.q;
            if (nVar != null) {
                nVar.n();
                return;
            }
            return;
        }
        com.byazt.uw.n nVar2 = this.q;
        if (nVar2 != null) {
            nVar2.qg();
        }
        l lVar2 = this.s;
        if (lVar2 != null) {
            lVar2.l();
        }
    }

    private void rv() {
        if (this.qg == null) {
            return;
        }
        if (this.s == null) {
            this.s = new l(this.qg);
        }
        View view = this.l;
        if (view != null) {
            this.s.n(view.getWidth(), this.l.getHeight());
        }
    }

    private void tj() {
        View view = this.l;
        if (view == null || this.rv) {
            return;
        }
        view.addOnLayoutChangeListener(this.cp);
        this.l.addOnAttachStateChangeListener(this.sz);
        this.rv = true;
    }

    private void cp() {
        View view = this.l;
        if (view == null || !this.rv) {
            return;
        }
        view.removeOnLayoutChangeListener(this.cp);
        this.l.removeOnAttachStateChangeListener(this.sz);
        this.rv = false;
    }

    private void d() {
        if (this.l == null || this.qg == null || !k()) {
            return;
        }
        rv();
        if (this.q == null) {
            this.q = new com.byazt.uw.n(this.s);
        }
        int width = this.l.getWidth();
        int height = this.l.getHeight();
        if (width > 0 && height > 0) {
            this.q.setBounds(0, 0, width, height);
        }
        this.l.getOverlay().add(this.q);
    }

    private void oa() {
        if (this.l == null || this.q == null || !k()) {
            return;
        }
        this.l.getOverlay().remove(this.q);
    }

    private void sz() {
        com.byazt.uw.n nVar = this.q;
        if (nVar != null) {
            nVar.qg();
        }
        l lVar = this.s;
        if (lVar != null) {
            lVar.w();
            this.s = null;
        }
        this.q = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity cy() {
        View view = this.l;
        if (view == null) {
            return null;
        }
        return n(view.getContext());
    }

    private static Activity n(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == context) {
                return null;
            }
            context = baseContext;
        }
        return null;
    }

    private void hd() {
        Activity activityCy;
        Application application;
        if (this.k != null || (activityCy = cy()) == null || (application = activityCy.getApplication()) == null) {
            return;
        }
        this.k = application;
        application.registerActivityLifecycleCallbacks(this.cy);
    }

    private void cd() {
        Application application = this.k;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.cy);
            this.k = null;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1462, 546})
    private static abstract class n implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        private n() {
        }
    }
}
