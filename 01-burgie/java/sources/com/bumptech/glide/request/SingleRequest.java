package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback, FactoryPools.Poolable {
    private static final String GLIDE_TAG = "Glide";
    private TransitionFactory<? super R> animationFactory;
    private Executor callbackExecutor;
    private Context context;
    private Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private List<RequestListener<R>> requestListeners;
    private BaseRequestOptions<?> requestOptions;
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private Target<R> target;
    private RequestListener<R> targetListener;
    private Class<R> transcodeClass;
    private int width;
    private static final Pools.Pool<SingleRequest<?>> POOL = FactoryPools.threadSafe(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS, new FactoryPools.Factory<SingleRequest<?>>() { // from class: com.bumptech.glide.request.SingleRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public SingleRequest<?> create() {
            return new SingleRequest<>();
        }
    });
    private static final String TAG = "Request";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object model, Class<R> transcodeClass, BaseRequestOptions<?> requestOptions, int overrideWidth, int overrideHeight, Priority priority, Target<R> target, RequestListener<R> targetListener, List<RequestListener<R>> requestListeners, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> animationFactory, Executor callbackExecutor) {
        SingleRequest<R> request = (SingleRequest) POOL.acquire();
        if (request == null) {
            request = new SingleRequest<>();
        }
        request.init(context, glideContext, model, transcodeClass, requestOptions, overrideWidth, overrideHeight, priority, target, targetListener, requestListeners, requestCoordinator, engine, animationFactory, callbackExecutor);
        return request;
    }

    SingleRequest() {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
    }

    private synchronized void init(Context context, GlideContext glideContext, Object model, Class<R> transcodeClass, BaseRequestOptions<?> requestOptions, int overrideWidth, int overrideHeight, Priority priority, Target<R> target, RequestListener<R> targetListener, List<RequestListener<R>> requestListeners, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> animationFactory, Executor callbackExecutor) {
        this.context = context;
        this.glideContext = glideContext;
        this.model = model;
        this.transcodeClass = transcodeClass;
        this.requestOptions = requestOptions;
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
        this.priority = priority;
        this.target = target;
        this.targetListener = targetListener;
        this.requestListeners = requestListeners;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = animationFactory;
        this.callbackExecutor = callbackExecutor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext.isLoggingRequestOriginsEnabled()) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void recycle() {
        assertNotCallingCallbacks();
        this.context = null;
        this.glideContext = null;
        this.model = null;
        this.transcodeClass = null;
        this.requestOptions = null;
        this.overrideWidth = -1;
        this.overrideHeight = -1;
        this.target = null;
        this.requestListeners = null;
        this.targetListener = null;
        this.requestCoordinator = null;
        this.animationFactory = null;
        this.loadStatus = null;
        this.errorDrawable = null;
        this.placeholderDrawable = null;
        this.fallbackDrawable = null;
        this.width = -1;
        this.height = -1;
        this.requestOrigin = null;
        POOL.release(this);
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void begin() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.startTime = LogTime.getLogTime();
        if (this.model == null) {
            if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                this.width = this.overrideWidth;
                this.height = this.overrideHeight;
            }
            int logLevel = getFallbackDrawable() == null ? 5 : 3;
            onLoadFailed(new GlideException("Received null model"), logLevel);
            return;
        }
        if (this.status == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        }
        if (this.status == Status.COMPLETE) {
            onResourceReady(this.resource, DataSource.MEMORY_CACHE);
            return;
        }
        this.status = Status.WAITING_FOR_SIZE;
        if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
            onSizeReady(this.overrideWidth, this.overrideHeight);
        } else {
            this.target.getSize(this);
        }
        if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
            this.target.onLoadStarted(getPlaceholderDrawable());
        }
        if (IS_VERBOSE_LOGGABLE) {
            logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
        }
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void clear() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        if (this.status == Status.CLEARED) {
            return;
        }
        cancel();
        Resource<R> resource = this.resource;
        if (resource != null) {
            releaseResource(resource);
        }
        if (canNotifyCleared()) {
            this.target.onLoadCleared(getPlaceholderDrawable());
        }
        this.status = Status.CLEARED;
    }

    private void releaseResource(Resource<?> resource) {
        this.engine.release(resource);
        this.resource = null;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isRunning() {
        return this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isResourceSet() {
        return isComplete();
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isCleared() {
        return this.status == Status.CLEARED;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isFailed() {
        return this.status == Status.FAILED;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(int resourceId) {
        Resources.Theme theme = this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme();
        return DrawableDecoderCompat.getDrawable(this.glideContext, resourceId, theme);
    }

    private synchronized void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable error = null;
            if (this.model == null) {
                error = getFallbackDrawable();
            }
            if (error == null) {
                error = getErrorDrawable();
            }
            if (error == null) {
                error = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(error);
        }
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public synchronized void onSizeReady(int width, int height) throws Throwable {
        try {
            this.stateVerifier.throwIfRecycled();
            boolean z = IS_VERBOSE_LOGGABLE;
            if (z) {
                logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
            }
            if (this.status != Status.WAITING_FOR_SIZE) {
                return;
            }
            this.status = Status.RUNNING;
            float sizeMultiplier = this.requestOptions.getSizeMultiplier();
            this.width = maybeApplySizeMultiplier(width, sizeMultiplier);
            this.height = maybeApplySizeMultiplier(height, sizeMultiplier);
            if (z) {
                logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
            }
            try {
                try {
                    this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                    if (this.status != Status.RUNNING) {
                        this.loadStatus = null;
                    }
                    if (z) {
                        logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        throw th;
    }

    private static int maybeApplySizeMultiplier(int size, float sizeMultiplier) {
        return size == Integer.MIN_VALUE ? size : Math.round(size * sizeMultiplier);
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public synchronized void onResourceReady(Resource<?> resource, DataSource dataSource) {
        this.stateVerifier.throwIfRecycled();
        this.loadStatus = null;
        if (resource == null) {
            GlideException exception = new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null.");
            onLoadFailed(exception);
            return;
        }
        Object received = resource.get();
        if (received != null && this.transcodeClass.isAssignableFrom(received.getClass())) {
            if (!canSetResource()) {
                releaseResource(resource);
                this.status = Status.COMPLETE;
                return;
            } else {
                onResourceReady(resource, received, dataSource);
                return;
            }
        }
        releaseResource(resource);
        GlideException exception2 = new GlideException("Expected to receive an object of " + this.transcodeClass + " but instead got " + (received != null ? received.getClass() : "") + "{" + received + "} inside Resource{" + resource + "}." + (received != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data."));
        onLoadFailed(exception2);
    }

    private synchronized void onResourceReady(Resource<R> resource, R result, DataSource dataSource) {
        boolean anyListenerHandledUpdatingTarget;
        boolean isFirstResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.getLogLevel() <= 3) {
            Log.d(GLIDE_TAG, "Finished loading " + result.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
        }
        boolean z = true;
        this.isCallingCallbacks = true;
        try {
            List<RequestListener<R>> list = this.requestListeners;
            if (list == null) {
                anyListenerHandledUpdatingTarget = false;
            } else {
                Iterator<RequestListener<R>> it = list.iterator();
                anyListenerHandledUpdatingTarget = false;
                while (anyListenerHandledUpdatingTarget) {
                    RequestListener<R> listener = it.next();
                    anyListenerHandledUpdatingTarget |= listener.onResourceReady(result, this.model, this.target, dataSource, isFirstResource);
                }
            }
            RequestListener<R> requestListener = this.targetListener;
            if (requestListener == null || !requestListener.onResourceReady(result, this.model, this.target, dataSource, isFirstResource)) {
                z = false;
            }
            if (!(anyListenerHandledUpdatingTarget | z)) {
                Transition<? super R> animation = this.animationFactory.build(dataSource, isFirstResource);
                this.target.onResourceReady(result, animation);
            }
            this.isCallingCallbacks = false;
            notifyLoadSuccess();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public synchronized void onLoadFailed(GlideException e) {
        onLoadFailed(e, 5);
    }

    private synchronized void onLoadFailed(GlideException e, int maxLogLevel) {
        this.stateVerifier.throwIfRecycled();
        e.setOrigin(this.requestOrigin);
        int logLevel = this.glideContext.getLogLevel();
        if (logLevel <= maxLogLevel) {
            Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + "]", e);
            if (logLevel <= 4) {
                e.logRootCauses(GLIDE_TAG);
            }
        }
        this.loadStatus = null;
        this.status = Status.FAILED;
        boolean z = true;
        this.isCallingCallbacks = true;
        boolean anyListenerHandledUpdatingTarget = false;
        try {
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                for (RequestListener<R> listener : list) {
                    anyListenerHandledUpdatingTarget |= listener.onLoadFailed(e, this.model, this.target, isFirstReadyResource());
                }
            }
            RequestListener<R> requestListener = this.targetListener;
            if (requestListener == null || !requestListener.onLoadFailed(e, this.model, this.target, isFirstReadyResource())) {
                z = false;
            }
            if (!(z | anyListenerHandledUpdatingTarget)) {
                setErrorPlaceholder();
            }
            this.isCallingCallbacks = false;
            notifyLoadFailed();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0049 */
    @Override // com.bumptech.glide.request.Request
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isEquivalentTo(com.bumptech.glide.request.Request r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r5 instanceof com.bumptech.glide.request.SingleRequest     // Catch: java.lang.Throwable -> L4d
            r1 = 0
            if (r0 == 0) goto L4b
            r0 = r5
            com.bumptech.glide.request.SingleRequest r0 = (com.bumptech.glide.request.SingleRequest) r0     // Catch: java.lang.Throwable -> L4d
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L4d
            int r2 = r4.overrideWidth     // Catch: java.lang.Throwable -> L46
            int r3 = r0.overrideWidth     // Catch: java.lang.Throwable -> L46
            if (r2 != r3) goto L42
            int r2 = r4.overrideHeight     // Catch: java.lang.Throwable -> L46
            int r3 = r0.overrideHeight     // Catch: java.lang.Throwable -> L46
            if (r2 != r3) goto L42
            java.lang.Object r2 = r4.model     // Catch: java.lang.Throwable -> L46
            java.lang.Object r3 = r0.model     // Catch: java.lang.Throwable -> L46
            boolean r2 = com.bumptech.glide.util.Util.bothModelsNullEquivalentOrEquals(r2, r3)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L42
            java.lang.Class<R> r2 = r4.transcodeClass     // Catch: java.lang.Throwable -> L46
            java.lang.Class<R> r3 = r0.transcodeClass     // Catch: java.lang.Throwable -> L46
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L42
            com.bumptech.glide.request.BaseRequestOptions<?> r2 = r4.requestOptions     // Catch: java.lang.Throwable -> L46
            com.bumptech.glide.request.BaseRequestOptions<?> r3 = r0.requestOptions     // Catch: java.lang.Throwable -> L46
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L42
            com.bumptech.glide.Priority r2 = r4.priority     // Catch: java.lang.Throwable -> L46
            com.bumptech.glide.Priority r3 = r0.priority     // Catch: java.lang.Throwable -> L46
            if (r2 != r3) goto L42
            boolean r2 = r4.listenerCountEquals(r0)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L42
            r1 = 1
            goto L43
        L42:
        L43:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r4)
            return r1
        L46:
            r1 = move-exception
        L47:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L49
            throw r1     // Catch: java.lang.Throwable -> L4d
        L49:
            r1 = move-exception
            goto L47
        L4b:
            monitor-exit(r4)
            return r1
        L4d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0020 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean listenerCountEquals(com.bumptech.glide.request.SingleRequest<?> r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L22
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r3.requestListeners     // Catch: java.lang.Throwable -> L1d
            r1 = 0
            if (r0 != 0) goto L9
            r0 = r1
            goto Ld
        L9:
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L1d
        Ld:
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r2 = r4.requestListeners     // Catch: java.lang.Throwable -> L1d
            if (r2 != 0) goto L13
            r2 = r1
            goto L17
        L13:
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L1d
        L17:
            if (r0 != r2) goto L1a
            r1 = 1
        L1a:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)
            return r1
        L1d:
            r0 = move-exception
        L1e:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L20
            throw r0     // Catch: java.lang.Throwable -> L22
        L20:
            r0 = move-exception
            goto L1e
        L22:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.listenerCountEquals(com.bumptech.glide.request.SingleRequest):boolean");
    }

    private void logV(String message) {
        Log.v(TAG, message + " this: " + this.tag);
    }
}
