package com.tapsdk.tapad.internal.runtime.plugin;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tapsdk.tapad.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SurfaceWindowFocus {
    private boolean closed;
    private Boolean lastFocus;
    private final Listener listener;
    private final View root;
    private final Handler main = new Handler(Looper.getMainLooper());
    private final List<ObservedWindow> windows = new ArrayList();
    private final Runnable publish = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.SurfaceWindowFocus$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.publish();
        }
    };

    public interface Listener {
        void onFocusChanged(boolean z);
    }

    public final class ObservedWindow implements View.OnAttachStateChangeListener, ViewTreeObserver.OnWindowFocusChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserver observer;
        final View view;

        public ObservedWindow(View view) {
            this.view = view;
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                observe();
            }
        }

        public void close() {
            stop();
            this.view.removeOnAttachStateChangeListener(this);
        }

        public void observe() {
            stop();
            ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            this.observer = viewTreeObserver;
            if (viewTreeObserver.isAlive()) {
                this.observer.addOnWindowFocusChangeListener(this);
                this.observer.addOnGlobalLayoutListener(this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            SurfaceWindowFocus.this.schedule();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            observe();
            SurfaceWindowFocus.this.schedule();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            stop();
            SurfaceWindowFocus.this.schedule();
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            SurfaceWindowFocus.this.schedule();
        }

        public void stop() {
            ViewTreeObserver viewTreeObserver = this.observer;
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                this.observer.removeOnWindowFocusChangeListener(this);
                this.observer.removeOnGlobalLayoutListener(this);
            }
            this.observer = null;
        }
    }

    public SurfaceWindowFocus(View view, Listener listener) {
        this.root = view;
        this.listener = listener;
        view.setTag(R.id.tapad_dirichlet_surface_window_focus_tag, this);
        addWindow(view);
    }

    public static SurfaceWindowFocus find(View view) {
        Object tag = view == null ? null : view.getTag(R.id.tapad_dirichlet_surface_window_focus_tag);
        if (tag instanceof SurfaceWindowFocus) {
            return (SurfaceWindowFocus) tag;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publish() {
        if (this.closed) {
            return;
        }
        boolean zHasFocus = hasFocus();
        Boolean bool = this.lastFocus;
        if (bool == null || bool.booleanValue() != zHasFocus) {
            this.lastFocus = Boolean.valueOf(zHasFocus);
            this.listener.onFocusChanged(zHasFocus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule() {
        if (this.closed) {
            return;
        }
        this.main.removeCallbacks(this.publish);
        this.main.post(this.publish);
    }

    public void addWindow(View view) {
        if (this.closed || view == null) {
            return;
        }
        Iterator<ObservedWindow> it = this.windows.iterator();
        while (it.hasNext()) {
            if (it.next().view == view) {
                return;
            }
        }
        this.windows.add(new ObservedWindow(view));
        schedule();
    }

    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.main.removeCallbacks(this.publish);
        Iterator<ObservedWindow> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        this.windows.clear();
        if (find(this.root) == this) {
            this.root.setTag(R.id.tapad_dirichlet_surface_window_focus_tag, null);
        }
    }

    public boolean hasFocus() {
        if (!this.closed && this.root.isAttachedToWindow() && this.root.getWindowVisibility() == 0) {
            for (ObservedWindow observedWindow : this.windows) {
                if (observedWindow.view.isAttachedToWindow() && observedWindow.view.hasWindowFocus()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeWindow(View view) {
        for (int size = this.windows.size() - 1; size >= 0; size--) {
            if (this.windows.get(size).view == view) {
                this.windows.remove(size).close();
            }
        }
        schedule();
    }
}
