package com.tapsdk.tapad.internal.runtime.plugin.stub;

import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.SurfaceSession;
import com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderActionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.plugin.SurfaceWindowFocus;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class InlineAdSurfaceHost {
    private static final String TAG = "InlineAdSurfaceHost";
    private static final AtomicInteger NEXT_TOKEN = new AtomicInteger(1);
    private static final SparseArray<WeakReference<Controller>> CONTROLLERS = new SparseArray<>();

    public static final class Controller implements SurfaceSession.CallbackHandler, View.OnAttachStateChangeListener, View.OnLayoutChangeListener, ViewTreeObserver.OnWindowFocusChangeListener {
        private final AdType adType;
        private boolean closed;
        private boolean foreground;
        private boolean overlayPaused;
        private ProviderActionSlots providerActionSlots;
        private ProviderActionSlots.Listener providerActionSlotsListener;
        private boolean providerActionUpdateScheduled;
        private View providerBoundMedia;
        private ProviderInteractionViews registeredProviderInteractionViews;
        private boolean rendered;
        private DefaultViewRenderer renderer;
        private final FrameLayout root;
        private SurfaceSession session;
        private final int token;
        private SurfaceWindowFocus windowFocus;
        private int surfaceId = -1;
        private int instanceId = -1;
        private int lastWidth = -1;
        private int lastHeight = -1;
        private final Runnable providerActionUpdate = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m333lambda$new$0$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller();
            }
        };

        public Controller(int i, FrameLayout frameLayout, AdType adType) {
            this.token = i;
            this.root = frameLayout;
            this.adType = adType;
        }

        private void bindProviderSurface() {
            SurfaceSession surfaceSession = this.session;
            if (surfaceSession == null || !(surfaceSession.adImpl() instanceof SplashProviderHost)) {
                return;
            }
            SplashProviderHost splashProviderHost = (SplashProviderHost) this.session.adImpl();
            View viewFindViewByDebugKey = this.renderer.findViewByDebugKey("splash.role.media");
            if (viewFindViewByDebugKey == null) {
                splashProviderHost.onSplashSurfaceBindFailed("Splash media slot is unavailable");
                return;
            }
            ProviderInteractionViews providerInteractionViewsSnapshot = this.renderer.getProviderActionSlots().snapshot(this.root);
            Iterator<View> it = providerInteractionViewsSnapshot.allViews().iterator();
            while (it.hasNext()) {
                ProviderInteractionOwnership.transfer(it.next());
            }
            try {
                if (this.providerBoundMedia != viewFindViewByDebugKey) {
                    splashProviderHost.bindSplashSurface(this.root.getContext(), this.root, viewFindViewByDebugKey, providerInteractionViewsSnapshot, this.renderer.getProviderAttributionSlots());
                    this.providerBoundMedia = viewFindViewByDebugKey;
                    this.registeredProviderInteractionViews = providerInteractionViewsSnapshot;
                    observeProviderActionSlots(this.renderer.getProviderActionSlots());
                    return;
                }
                if (providerInteractionViewsSnapshot.sameViews(this.registeredProviderInteractionViews) || !splashProviderHost.updateSplashInteractionViews(providerInteractionViewsSnapshot)) {
                    return;
                }
                this.registeredProviderInteractionViews = providerInteractionViewsSnapshot;
            } catch (Throwable th) {
                splashProviderHost.onSplashSurfaceBindFailed(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage());
            }
        }

        private void dispatchForeground() {
            SurfaceWindowFocus surfaceWindowFocus;
            boolean z = !this.closed && !this.overlayPaused && this.rendered && this.root.isAttachedToWindow() && this.root.getWindowVisibility() == 0 && (surfaceWindowFocus = this.windowFocus) != null && surfaceWindowFocus.hasFocus();
            if (z == this.foreground || this.instanceId < 0 || this.surfaceId < 0) {
                return;
            }
            this.foreground = z;
            DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
            if (z) {
                dirichletRuntime.triggerResume(this.instanceId, this.surfaceId);
            } else {
                dirichletRuntime.triggerPause(this.instanceId, this.surfaceId);
            }
        }

        private void observeProviderActionSlots(ProviderActionSlots providerActionSlots) {
            if (this.providerActionSlots != providerActionSlots || this.providerActionSlotsListener == null) {
                stopObservingProviderActionSlots();
                this.providerActionSlots = providerActionSlots;
                ProviderActionSlots.Listener listener = new ProviderActionSlots.Listener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda5
                    @Override // com.tapsdk.tapad.internal.runtime.plugin.ProviderActionSlots.Listener
                    public final void onSlotsChanged(List list) {
                        this.f$0.m334lambda$observeProviderActionSlots$2$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller(list);
                    }
                };
                this.providerActionSlotsListener = listener;
                providerActionSlots.addListener(listener);
            }
        }

        private void observeWindowFocus() {
            if (this.windowFocus != null) {
                return;
            }
            this.windowFocus = new SurfaceWindowFocus(this.root, new SurfaceWindowFocus.Listener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda6
                @Override // com.tapsdk.tapad.internal.runtime.plugin.SurfaceWindowFocus.Listener
                public final void onFocusChanged(boolean z) {
                    this.f$0.onWindowFocusChanged(z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void renderIfReady() {
            SurfaceWindowFocus surfaceWindowFocus;
            if (this.closed || this.session == null || this.renderer == null || !this.root.isAttachedToWindow() || this.root.getWindowVisibility() != 0 || (surfaceWindowFocus = this.windowFocus) == null || !surfaceWindowFocus.hasFocus() || this.root.getWidth() <= 0 || this.root.getHeight() <= 0) {
                dispatchForeground();
                return;
            }
            int width = this.root.getWidth();
            int height = this.root.getHeight();
            dispatchForeground();
            if (this.rendered && width == this.lastWidth && height == this.lastHeight) {
                return;
            }
            this.lastWidth = width;
            this.lastHeight = height;
            this.rendered = true;
            float f = this.root.getResources().getDisplayMetrics().density;
            if (f <= 0.0f) {
                f = 1.0f;
            }
            String strWasmFunction = this.session.wasmFunction();
            if (strWasmFunction == null || strWasmFunction.length() == 0) {
                strWasmFunction = "ad_render_splash";
            }
            this.session.module().callVoid(strWasmFunction, Integer.valueOf(this.instanceId), Integer.valueOf(this.surfaceId), Float.valueOf(width / f), Float.valueOf(height / f));
            dispatchForeground();
        }

        private void scheduleProviderActionUpdate() {
            if (this.closed || this.providerActionUpdateScheduled) {
                return;
            }
            this.providerActionUpdateScheduled = true;
            this.root.post(this.providerActionUpdate);
        }

        private void stopObservingProviderActionSlots() {
            ProviderActionSlots.Listener listener;
            this.root.removeCallbacks(this.providerActionUpdate);
            this.providerActionUpdateScheduled = false;
            ProviderActionSlots providerActionSlots = this.providerActionSlots;
            if (providerActionSlots != null && (listener = this.providerActionSlotsListener) != null) {
                providerActionSlots.removeListener(listener);
            }
            this.providerActionSlots = null;
            this.providerActionSlotsListener = null;
            this.registeredProviderInteractionViews = null;
        }

        private void stopObservingWindowFocus() {
            SurfaceWindowFocus surfaceWindowFocus = this.windowFocus;
            if (surfaceWindowFocus != null) {
                surfaceWindowFocus.close();
            }
            this.windowFocus = null;
        }

        public boolean bind(int i) {
            if (!this.closed && i >= 0 && this.surfaceId < 0) {
                DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
                SurfaceSession live = dirichletRuntime.surfaceSessions().getLive(i);
                if (live != null && live.module() != null) {
                    this.session = live;
                    this.surfaceId = i;
                    this.instanceId = live.instanceId();
                    DefaultViewRenderer defaultViewRenderer = new DefaultViewRenderer(this.root.getContext(), this.root);
                    this.renderer = defaultViewRenderer;
                    if (!dirichletRuntime.attachSurfaceRenderer(this.surfaceId, defaultViewRenderer)) {
                        this.renderer.destroy();
                        this.renderer = null;
                        this.session = null;
                        this.surfaceId = -1;
                        this.instanceId = -1;
                        return false;
                    }
                    dirichletRuntime.surfaceSessions().registerCallbackHandler(this.surfaceId, this);
                    this.root.addOnAttachStateChangeListener(this);
                    this.root.addOnLayoutChangeListener(this);
                    if (this.root.isAttachedToWindow()) {
                        observeWindowFocus();
                    }
                    this.root.post(new InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda2(this));
                    return true;
                }
            }
            return false;
        }

        public void close(boolean z, boolean z2) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            InlineAdSurfaceHost.remove(this.token);
            stopObservingWindowFocus();
            this.root.removeOnAttachStateChangeListener(this);
            this.root.removeOnLayoutChangeListener(this);
            stopObservingProviderActionSlots();
            DefaultViewRenderer defaultViewRenderer = this.renderer;
            this.renderer = null;
            this.providerBoundMedia = null;
            if (this.surfaceId >= 0) {
                DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
                if (z && this.rendered && dirichletRuntime.isInstanceLive(this.instanceId)) {
                    dirichletRuntime.triggerDestroy(this.instanceId, this.surfaceId);
                }
                dirichletRuntime.surfaceSessions().unregisterCallbackHandler(this.surfaceId, this);
                if (defaultViewRenderer != null) {
                    dirichletRuntime.detachSurfaceRenderer(this.surfaceId, defaultViewRenderer);
                }
                dirichletRuntime.destroySurfaceSessionFromActivity(this.surfaceId);
            }
            if (defaultViewRenderer != null) {
                defaultViewRenderer.destroy();
            }
            if (!z2) {
                if (this.root.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.root.getParent()).removeView(this.root);
                } else {
                    this.root.removeAllViews();
                }
            }
            this.root.setTag(R.id.tapad_dirichlet_inline_surface_host_tag, null);
            this.session = null;
            this.surfaceId = -1;
            this.instanceId = -1;
        }

        @Override // com.tapsdk.tapad.internal.runtime.SurfaceSession.CallbackHandler
        public void finishSurface() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                close(false, false);
            } else {
                this.root.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m332lambda$finishSurface$4$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller();
                    }
                });
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.SurfaceSession.CallbackHandler
        public boolean isSurfaceGone() {
            return this.closed;
        }

        /* JADX INFO: renamed from: lambda$finishSurface$4$com-tapsdk-tapad-internal-runtime-plugin-stub-InlineAdSurfaceHost$Controller, reason: not valid java name */
        /* synthetic */ void m332lambda$finishSurface$4$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller() {
            close(false, false);
        }

        /* JADX INFO: renamed from: lambda$new$0$com-tapsdk-tapad-internal-runtime-plugin-stub-InlineAdSurfaceHost$Controller, reason: not valid java name */
        /* synthetic */ void m333lambda$new$0$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller() {
            this.providerActionUpdateScheduled = false;
            bindProviderSurface();
        }

        /* JADX INFO: renamed from: lambda$observeProviderActionSlots$2$com-tapsdk-tapad-internal-runtime-plugin-stub-InlineAdSurfaceHost$Controller, reason: not valid java name */
        /* synthetic */ void m334lambda$observeProviderActionSlots$2$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller(List list) {
            scheduleProviderActionUpdate();
        }

        /* JADX INFO: renamed from: lambda$onSurfaceCallback$3$com-tapsdk-tapad-internal-runtime-plugin-stub-InlineAdSurfaceHost$Controller, reason: not valid java name */
        /* synthetic */ void m335lambda$onSurfaceCallback$3$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller() {
            close(true, false);
        }

        /* JADX INFO: renamed from: lambda$setOverlayPaused$1$com-tapsdk-tapad-internal-runtime-plugin-stub-InlineAdSurfaceHost$Controller, reason: not valid java name */
        /* synthetic */ void m336lambda$setOverlayPaused$1$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller(boolean z) {
            if (this.closed || this.overlayPaused == z) {
                return;
            }
            this.overlayPaused = z;
            dispatchForeground();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
                dispatchForeground();
            } else {
                this.root.post(new InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda2(this));
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.SurfaceSession.CallbackHandler
        public void onSurfaceCallback(String str, String str2) {
            if (this.closed) {
                return;
            }
            if (InternalWebViewCallbackActuator.handles(str)) {
                InternalWebViewCallbackActuator.open(this.root.getContext(), str2, this.adType, this.instanceId, this.surfaceId);
                return;
            }
            if ("onProviderSplashSurfaceReady".equals(str)) {
                bindProviderSurface();
                return;
            }
            if (!"onCoreRuntimeFatal".equals(str)) {
                if ("onAdClose".equals(str)) {
                    this.root.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m335lambda$onSurfaceCallback$3$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller();
                        }
                    });
                }
            } else {
                SurfaceSession surfaceSession = this.session;
                if (surfaceSession == null || !(surfaceSession.adImpl() instanceof SplashProviderHost)) {
                    return;
                }
                ((SplashProviderHost) this.session.adImpl()).onSplashCoreUnavailable();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            observeWindowFocus();
            this.root.post(new InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda2(this));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            dispatchForeground();
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            dispatchForeground();
            if (z) {
                this.root.post(new InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda2(this));
            }
        }

        public void setOverlayPaused(final boolean z) {
            Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost$Controller$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m336lambda$setOverlayPaused$1$comtapsdktapadinternalruntimepluginstubInlineAdSurfaceHost$Controller(z);
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.root.post(runnable);
            }
        }
    }

    private InlineAdSurfaceHost() {
    }

    public static boolean attach(int i, int i2) {
        Controller controllerFind = find(i2);
        return controllerFind != null && controllerFind.bind(i);
    }

    private static Controller find(int i) {
        Controller controller = null;
        if (i <= 0) {
            return null;
        }
        SparseArray<WeakReference<Controller>> sparseArray = CONTROLLERS;
        synchronized (sparseArray) {
            WeakReference<Controller> weakReference = sparseArray.get(i);
            if (weakReference != null) {
                controller = weakReference.get();
            }
            if (controller == null) {
                sparseArray.remove(i);
            }
        }
        return controller;
    }

    private static int nextToken() {
        while (true) {
            AtomicInteger atomicInteger = NEXT_TOKEN;
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement > 0) {
                return andIncrement;
            }
            atomicInteger.compareAndSet(andIncrement + 1, 1);
        }
    }

    public static void pause(int i) {
        Controller controllerFind = find(i);
        if (controllerFind != null) {
            controllerFind.setOverlayPaused(true);
        }
    }

    private static void pruneLocked() {
        for (int size = CONTROLLERS.size() - 1; size >= 0; size--) {
            SparseArray<WeakReference<Controller>> sparseArray = CONTROLLERS;
            WeakReference<Controller> weakReferenceValueAt = sparseArray.valueAt(size);
            if (weakReferenceValueAt == null || weakReferenceValueAt.get() == null) {
                sparseArray.removeAt(size);
            }
        }
    }

    public static int register(FrameLayout frameLayout, AdType adType) {
        if (frameLayout == null || adType == null) {
            return -1;
        }
        int iNextToken = nextToken();
        Controller controller = new Controller(iNextToken, frameLayout, adType);
        SparseArray<WeakReference<Controller>> sparseArray = CONTROLLERS;
        synchronized (sparseArray) {
            pruneLocked();
            sparseArray.put(iNextToken, new WeakReference<>(controller));
        }
        frameLayout.setTag(R.id.tapad_dirichlet_inline_surface_host_tag, controller);
        return iNextToken;
    }

    public static void release(int i) {
        final Controller controllerRemove = remove(i);
        if (controllerRemove == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            controllerRemove.close(true, false);
        } else {
            controllerRemove.root.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    controllerRemove.close(true, false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Controller remove(int i) {
        Controller controller;
        SparseArray<WeakReference<Controller>> sparseArray = CONTROLLERS;
        synchronized (sparseArray) {
            WeakReference<Controller> weakReference = sparseArray.get(i);
            sparseArray.remove(i);
            controller = weakReference == null ? null : weakReference.get();
        }
        return controller;
    }

    public static void resume(int i) {
        Controller controllerFind = find(i);
        if (controllerFind != null) {
            controllerFind.setOverlayPaused(false);
        }
    }

    public static FrameLayout takeOverForFallback(int i) {
        Controller controllerRemove = remove(i);
        if (controllerRemove == null || Looper.myLooper() != Looper.getMainLooper()) {
            return null;
        }
        controllerRemove.close(false, true);
        return controllerRemove.root;
    }
}
