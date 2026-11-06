package com.tapsdk.tapad.internal.runtime.image;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.fi.BaseConstants;
import com.tapsdk.tapad.internal.runtime.RustResolvedAsset;
import com.tapsdk.tapad.internal.runtime.plugin.utils.BlurHelper;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.cc;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class MechanicalImageLoader {
    private static final int BLOCKING_TIMEOUT_MS = 30000;
    private static final ThreadPoolExecutor CONNECTION_CLEANUP;
    private static final int CONNECT_TIMEOUT_MS = 8000;
    private static final int HARD_MAX_DECODE_DIMENSION_PX = 4096;
    private static final Map<String, InFlight> IN_FLIGHT;
    private static final Object IN_FLIGHT_LOCK;
    private static final WeakHashMap<ImageView, Boolean> LIFECYCLE_TARGETS;
    private static final Handler MAIN;
    private static final int MAX_ANIMATED_IMAGE_BYTES = 8388608;
    private static final int MAX_DECODE_DIMENSION_PX = 2048;
    private static final long MAX_DECODE_PIXELS = 4194304;
    private static final long MAX_HEAP_BYTES;
    private static final int MAX_IMAGE_BYTES = 20971520;
    private static final int MAX_REDIRECTS = 5;
    private static final int MAX_SOURCE_CHARS = 8192;
    private static final int MAX_TARGETS_PER_REQUEST = 64;
    private static final LruCache<String, Decoded> MEMORY_CACHE;
    private static final int MEMORY_CACHE_BYTES;
    private static final AtomicBoolean MEMORY_CALLBACK_REGISTERED;
    private static final int READ_TIMEOUT_MS = 12000;
    private static final AtomicLong REQUEST_SEQUENCE;
    private static final Map<String, SourceFetch> SOURCE_IN_FLIGHT;
    private static final Object SOURCE_IN_FLIGHT_LOCK;
    private static final AtomicLong SOURCE_SEQUENCE;
    private static final String TAG = "DirichletImage";
    private static final Object TARGET_LOCK;
    private static final WeakHashMap<ImageView, Request> TARGET_REQUESTS;
    private static final ThreadPoolExecutor WORKERS;
    private static final int WORKER_COUNT;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$3, reason: invalid class name */
    public class AnonymousClass3 implements View.OnAttachStateChangeListener {
        static /* synthetic */ void lambda$onViewDetachedFromWindow$0(ImageView imageView) {
            if (imageView.isAttachedToWindow()) {
                return;
            }
            MechanicalImageLoader.clear(imageView);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            final ImageView imageView = (ImageView) view;
            MechanicalImageLoader.MAIN.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MechanicalImageLoader.AnonymousClass3.lambda$onViewDetachedFromWindow$0(imageView);
                }
            });
        }
    }

    public interface BitmapCallback {
        void onResult(Request request, Bitmap bitmap, Exception exc);
    }

    public interface DecodeControl {
        void clearConnection(HttpURLConnection httpURLConnection);

        void installConnection(HttpURLConnection httpURLConnection);

        boolean isCancelled();
    }

    public static final class Decoded {
        final byte[] animatedBytes;
        final Bitmap bitmap;
        final Movie movie;

        private Decoded(Bitmap bitmap, Movie movie, byte[] bArr) {
            this.bitmap = bitmap;
            this.movie = movie;
            this.animatedBytes = bArr;
        }

        public static Decoded bitmap(Bitmap bitmap) {
            return new Decoded(bitmap, null, null);
        }

        public static Decoded movie(Movie movie, byte[] bArr) {
            return new Decoded(null, movie, bArr);
        }

        public int byteCount() {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    return Math.max(0, this.bitmap.getByteCount());
                } catch (RuntimeException e) {
                    return 0;
                }
            }
            if (this.animatedBytes == null) {
                return 0;
            }
            long jWidth = 0;
            Movie movie = this.movie;
            if (movie != null) {
                try {
                    jWidth = 4 * ((long) movie.width()) * ((long) this.movie.height());
                } catch (RuntimeException e2) {
                }
            }
            byte[] bArr = this.animatedBytes;
            return (int) Math.min(2147483647L, Math.max(((long) bArr.length) * 2, jWidth + ((long) bArr.length)));
        }

        public boolean isUsable() {
            byte[] bArr;
            Bitmap bitmap = this.bitmap;
            if (bitmap == null || bitmap.isRecycled()) {
                return (this.movie == null || (bArr = this.animatedBytes) == null || bArr.length <= 0) ? false : true;
            }
            return true;
        }
    }

    public static final class InFlight implements DecodeControl {
        final boolean allowAnimated;
        volatile HttpURLConnection connection;
        final Context context;
        volatile long decodeQueuedAtMs;
        volatile long decodeStartedAtMs;
        volatile Future<?> future;
        final String key;
        final Options options;
        final Source source;
        volatile SourceFetch sourceFetch;
        final List<Request> requests = new ArrayList();
        final AtomicBoolean cancelled = new AtomicBoolean(false);
        final long createdAtMs = SystemClock.elapsedRealtime();
        volatile boolean cacheable = true;

        public InFlight(String str, Context context, Source source, Options options, boolean z) {
            this.key = str;
            this.context = context;
            this.source = source;
            this.options = options;
            this.allowAnimated = z;
        }

        private void submitDecode(final byte[] bArr) {
            this.decodeQueuedAtMs = SystemClock.elapsedRealtime();
            MechanicalImageLoader.trace("decode_queue", this.source.traceId, 0L, "variant=" + this.options.decodeKey() + " prefetched=" + (bArr == null ? 0 : 1) + " " + MechanicalImageLoader.executorState());
            try {
                Future<?> futureSubmit = MechanicalImageLoader.WORKERS.submit(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$InFlight$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        this.f$0.m286lambda$submitDecode$0$comtapsdktapadinternalruntimeimageMechanicalImageLoader$InFlight(bArr);
                    }
                });
                this.future = futureSubmit;
                if (isCancelled()) {
                    futureSubmit.cancel(true);
                }
            } catch (RejectedExecutionException e) {
                finish(null, new IOException("image decode queue is full", e));
            }
        }

        public boolean add(Request request) {
            if (request.isCancelled()) {
                return false;
            }
            for (int size = this.requests.size() - 1; size >= 0; size--) {
                if (this.requests.get(size).isCancelled()) {
                    this.requests.remove(size);
                }
            }
            if (this.requests.size() >= 64) {
                return false;
            }
            this.requests.add(request);
            request.inFlight = this;
            if (!request.isCancelled()) {
                return true;
            }
            this.requests.remove(request);
            request.inFlight = null;
            return false;
        }

        public void cancelWork() {
            if (this.cancelled.compareAndSet(false, true)) {
                SourceFetch sourceFetch = this.sourceFetch;
                this.sourceFetch = null;
                if (sourceFetch != null) {
                    sourceFetch.remove(this);
                }
                HttpURLConnection httpURLConnection = this.connection;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                Future<?> future = this.future;
                if (future != null) {
                    future.cancel(true);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.DecodeControl
        public void clearConnection(HttpURLConnection httpURLConnection) {
            if (this.connection == httpURLConnection) {
                this.connection = null;
            }
        }

        public void finish(Decoded decoded, Exception exc) {
            ArrayList arrayList;
            int i;
            SourceFetch sourceFetch = this.sourceFetch;
            this.sourceFetch = null;
            synchronized (MechanicalImageLoader.IN_FLIGHT_LOCK) {
                if (MechanicalImageLoader.IN_FLIGHT.get(this.key) == this) {
                    MechanicalImageLoader.IN_FLIGHT.remove(this.key);
                }
                arrayList = new ArrayList(this.requests);
                this.requests.clear();
                int size = arrayList.size();
                i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((Request) obj).inFlight = null;
                }
                if (decoded != null && decoded.isUsable() && this.cacheable && !arrayList.isEmpty()) {
                    try {
                        MechanicalImageLoader.MEMORY_CACHE.put(this.key, decoded);
                    } catch (OutOfMemoryError e) {
                        MechanicalImageLoader.clearMemoryCache();
                    }
                }
            }
            if (sourceFetch != null) {
                sourceFetch.remove(this);
            }
            MechanicalImageLoader.trace("decode_end", this.source.traceId, 0L, "variant=" + this.options.decodeKey() + " success=" + ((decoded == null || exc != null) ? 0 : 1) + " error=" + MechanicalImageLoader.failureCode(exc) + " decode_ms=" + (this.decodeStartedAtMs > 0 ? MechanicalImageLoader.elapsedSince(this.decodeStartedAtMs) : -1L) + " total_ms=" + MechanicalImageLoader.elapsedSince(this.createdAtMs) + " targets=" + arrayList.size());
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj2 = arrayList.get(i);
                i++;
                ((Request) obj2).deliver(decoded, exc);
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.DecodeControl
        public void installConnection(HttpURLConnection httpURLConnection) throws IOException {
            if (isCancelled()) {
                httpURLConnection.disconnect();
                throw new IOException("image request cancelled");
            }
            this.connection = httpURLConnection;
        }

        @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.DecodeControl
        public boolean isCancelled() {
            return this.cancelled.get();
        }

        /* JADX INFO: renamed from: lambda$submitDecode$0$com-tapsdk-tapad-internal-runtime-image-MechanicalImageLoader$InFlight, reason: not valid java name */
        /* synthetic */ void m286lambda$submitDecode$0$comtapsdktapadinternalruntimeimageMechanicalImageLoader$InFlight(byte[] bArr) throws IOException {
            Exception e;
            this.decodeStartedAtMs = SystemClock.elapsedRealtime();
            MechanicalImageLoader.trace("decode_start", this.source.traceId, 0L, "variant=" + this.options.decodeKey() + " queue_ms=" + MechanicalImageLoader.elapsedSince(this.decodeQueuedAtMs));
            Decoded decodedDecode = null;
            try {
                decodedDecode = MechanicalImageLoader.decode(this.context, this.source, this.options, this.allowAnimated, this, bArr);
                e = null;
            } catch (Exception e2) {
                e = e2;
            } catch (OutOfMemoryError e3) {
                MechanicalImageLoader.clearMemoryCache();
                e = new IOException("image decode exceeded memory budget", e3);
            } catch (Throwable th) {
                e = MechanicalImageLoader.asException(th);
            }
            finish(decodedDecode, e);
        }

        public void onSourceReady(SourceFetch sourceFetch, byte[] bArr, Exception exc) {
            if (this.sourceFetch != sourceFetch || isCancelled()) {
                return;
            }
            if (exc != null) {
                finish(null, exc);
            } else {
                submitDecode(bArr);
            }
        }

        public void remove(Request request) {
            synchronized (MechanicalImageLoader.IN_FLIGHT_LOCK) {
                this.requests.remove(request);
                request.inFlight = null;
                if (this.requests.isEmpty()) {
                    if (MechanicalImageLoader.IN_FLIGHT.get(this.key) == this) {
                        MechanicalImageLoader.IN_FLIGHT.remove(this.key);
                    }
                    cancelWork();
                }
            }
        }

        public void start() {
            if (this.source.isNetworkUri()) {
                SourceFetch.attach(this);
            } else {
                submitDecode(null);
            }
        }
    }

    public static final class MovieDrawable extends Drawable implements Animatable, Runnable {
        private static final int FRAME_DELAY_MS = 16;
        private final Decoded decoded;
        private boolean running;
        private long startTimeMs;

        public MovieDrawable(Decoded decoded) {
            this.decoded = decoded;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Movie movie = this.decoded.movie;
            if (movie == null) {
                return;
            }
            int iSave = -1;
            try {
                try {
                    try {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        if (this.startTimeMs == 0) {
                            this.startTimeMs = jUptimeMillis;
                        }
                        movie.setTime((int) ((jUptimeMillis - this.startTimeMs) % ((long) (movie.duration() > 0 ? movie.duration() : 1000))));
                        Rect bounds = getBounds();
                        int iMax = Math.max(1, movie.width());
                        int iMax2 = Math.max(1, movie.height());
                        iSave = canvas.save();
                        canvas.translate(bounds.left, bounds.top);
                        canvas.scale(bounds.width() / iMax, bounds.height() / iMax2);
                        movie.draw(canvas, 0.0f, 0.0f);
                        if (this.running) {
                            scheduleSelf(this, jUptimeMillis + 16);
                        }
                        if (iSave >= 0) {
                            canvas.restoreToCount(iSave);
                        }
                    } catch (RuntimeException e) {
                    }
                } catch (OutOfMemoryError | RuntimeException e2) {
                    stop();
                    if (iSave >= 0) {
                        canvas.restoreToCount(iSave);
                    }
                }
            } catch (Throwable th) {
                if (-1 >= 0) {
                    try {
                        canvas.restoreToCount(-1);
                    } catch (RuntimeException e3) {
                    }
                }
                throw th;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            try {
                Movie movie = this.decoded.movie;
                if (movie == null) {
                    return -1;
                }
                return movie.height();
            } catch (RuntimeException e) {
                return -1;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            try {
                Movie movie = this.decoded.movie;
                if (movie == null) {
                    return -1;
                }
                return movie.width();
            } catch (RuntimeException e) {
                return -1;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Animatable
        public boolean isRunning() {
            return this.running;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.running) {
                try {
                    invalidateSelf();
                } catch (RuntimeException e) {
                    this.running = false;
                }
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        @Override // android.graphics.drawable.Animatable
        public void start() {
            if (this.running) {
                return;
            }
            this.running = true;
            long jUptimeMillis = SystemClock.uptimeMillis();
            this.startTimeMs = jUptimeMillis;
            try {
                scheduleSelf(this, jUptimeMillis + 16);
            } catch (RuntimeException e) {
                this.running = false;
            }
        }

        @Override // android.graphics.drawable.Animatable
        public void stop() {
            this.running = false;
            try {
                unscheduleSelf(this);
            } catch (RuntimeException e) {
            }
        }
    }

    public static final class Options {
        private final int blurRadius;
        private final int blurSampling;
        private final int cornerRadiusPx;
        private final int errorResId;
        private final int placeholderResId;
        private final int targetHeight;
        private final int targetWidth;

        public static final class Builder {
            private int blurRadius;
            private int blurSampling = 1;
            private int cornerRadiusPx;
            private int errorResId;
            private int placeholderResId;
            private int targetHeight;
            private int targetWidth;

            public Builder blur(int i, int i2) {
                this.blurRadius = i;
                this.blurSampling = i2;
                return this;
            }

            public Options build() {
                return new Options(this);
            }

            public Builder cornerRadiusPx(int i) {
                this.cornerRadiusPx = i;
                return this;
            }

            public Builder errorResId(int i) {
                this.errorResId = i;
                return this;
            }

            public Builder placeholderResId(int i) {
                this.placeholderResId = i;
                return this;
            }

            public Builder targetSize(int i, int i2) {
                this.targetWidth = i;
                this.targetHeight = i2;
                return this;
            }
        }

        public static Builder builder() {
            return new Builder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String decodeKey() {
            return this.targetWidth + "x" + this.targetHeight + ":r" + this.cornerRadiusPx + ":b" + this.blurRadius + "x" + this.blurSampling;
        }

        public static Options defaults() {
            return builder().build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean supportsAnimation() {
            return this.cornerRadiusPx == 0 && this.blurRadius == 0;
        }

        private Options(Builder builder) {
            this.targetWidth = MechanicalImageLoader.clampDimension(builder.targetWidth);
            this.targetHeight = MechanicalImageLoader.clampDimension(builder.targetHeight);
            this.cornerRadiusPx = Math.max(0, builder.cornerRadiusPx);
            this.blurRadius = Math.max(0, Math.min(25, builder.blurRadius));
            this.blurSampling = Math.max(1, builder.blurSampling);
            this.placeholderResId = builder.placeholderResId;
            this.errorResId = builder.errorResId;
        }
    }

    public static final class Request {
        private final BitmapCallback callback;
        private final boolean callbackOnMain;
        private final AtomicBoolean cancelled;
        private final AtomicBoolean complete;
        private final Context context;
        private final long createdAtMs;
        private volatile long deliveredAtMs;
        private final AtomicBoolean firstDrawLogged;
        private volatile InFlight inFlight;
        private final Options options;
        private final long requestId;
        private volatile String sourceTraceId;
        private final WeakReference<ImageView> target;
        private volatile String variantTrace;

        /* JADX INFO: Access modifiers changed from: private */
        public void deliver(final Decoded decoded, final Exception exc) {
            Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$Request$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m287lambda$deliver$0$comtapsdktapadinternalruntimeimageMechanicalImageLoader$Request(exc, decoded);
                }
            };
            if (!this.callbackOnMain) {
                runnable.run();
                return;
            }
            try {
                if (MechanicalImageLoader.MAIN.post(runnable)) {
                    return;
                }
                this.complete.set(true);
            } catch (RuntimeException e) {
                this.complete.set(true);
            }
        }

        private Options resolvedOptions() {
            WeakReference<ImageView> weakReference;
            int i;
            int i2;
            if (this.options.targetWidth > 0 || this.options.targetHeight > 0 || (weakReference = this.target) == null) {
                return this.options;
            }
            ImageView imageView = weakReference.get();
            if (imageView == null) {
                return this.options;
            }
            int width = imageView.getWidth() > 0 ? imageView.getWidth() : imageView.getMeasuredWidth();
            int height = imageView.getHeight() > 0 ? imageView.getHeight() : imageView.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                if (width <= 0 && (i2 = layoutParams.width) > 0) {
                    width = i2;
                }
                if (height <= 0 && (i = layoutParams.height) > 0) {
                    height = i;
                }
            }
            if (width <= 0 || height <= 0) {
                DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
                if (width <= 0) {
                    width = displayMetrics.widthPixels;
                }
                if (height <= 0) {
                    height = displayMetrics.heightPixels;
                }
            }
            return Options.builder().targetSize(width, height).cornerRadiusPx(this.options.cornerRadiusPx).blur(this.options.blurRadius, this.options.blurSampling).placeholderResId(this.options.placeholderResId).errorResId(this.options.errorResId).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start(Source source, boolean z) {
            Decoded decodedCached;
            InFlight inFlight;
            if (isCancelled()) {
                return;
            }
            Options optionsResolvedOptions = resolvedOptions();
            boolean z2 = true;
            boolean z3 = false;
            boolean z4 = z && optionsResolvedOptions.supportsAnimation();
            this.sourceTraceId = source.traceId;
            this.variantTrace = optionsResolvedOptions.decodeKey() + ":a" + (z4 ? '1' : '0');
            String str = source.key() + '|' + optionsResolvedOptions.decodeKey() + ":a" + (z4 ? '1' : '0');
            MechanicalImageLoader.trace("request", this.sourceTraceId, this.requestId, "variant=" + this.variantTrace + " " + MechanicalImageLoader.executorState());
            Decoded decodedCached2 = MechanicalImageLoader.cached(str);
            if (decodedCached2 != null) {
                MechanicalImageLoader.trace("memory_hit", this.sourceTraceId, this.requestId, "variant=" + this.variantTrace);
                deliver(decodedCached2, null);
                return;
            }
            synchronized (MechanicalImageLoader.IN_FLIGHT_LOCK) {
                decodedCached = MechanicalImageLoader.cached(str);
                if (decodedCached != null) {
                    inFlight = null;
                } else {
                    inFlight = (InFlight) MechanicalImageLoader.IN_FLIGHT.get(str);
                    if (inFlight == null) {
                        InFlight inFlight2 = new InFlight(str, this.context, source, optionsResolvedOptions, z4);
                        MechanicalImageLoader.IN_FLIGHT.put(str, inFlight2);
                        inFlight = inFlight2;
                    } else {
                        z2 = false;
                    }
                    if (inFlight.add(this)) {
                        z3 = z2;
                    } else {
                        if (z2 && MechanicalImageLoader.IN_FLIGHT.get(str) == inFlight) {
                            MechanicalImageLoader.IN_FLIGHT.remove(str);
                        }
                        inFlight = null;
                    }
                }
            }
            if (decodedCached != null) {
                MechanicalImageLoader.trace("memory_hit", this.sourceTraceId, this.requestId, "variant=" + this.variantTrace + " raced=1");
                deliver(decodedCached, null);
            } else if (inFlight == null) {
                deliver(null, new IOException("too many image targets for one resource"));
            } else if (!z3) {
                MechanicalImageLoader.trace("variant_join", this.sourceTraceId, this.requestId, "variant=" + this.variantTrace);
            } else {
                MechanicalImageLoader.trace("variant_queue", this.sourceTraceId, this.requestId, "variant=" + this.variantTrace + " " + MechanicalImageLoader.executorState());
                inFlight.start();
            }
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.complete.set(true);
                MechanicalImageLoader.trace(TrackAction.CANCEL, this.sourceTraceId, this.requestId, "total_ms=" + MechanicalImageLoader.elapsedSince(this.createdAtMs));
                InFlight inFlight = this.inFlight;
                if (inFlight != null) {
                    inFlight.remove(this);
                }
            }
        }

        public boolean isCancelled() {
            return this.cancelled.get();
        }

        public boolean isComplete() {
            return this.complete.get();
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0042 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:26:0x0044 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:20:0x0030, B:22:0x0034, B:26:0x0044, B:27:0x0048), top: B:45:0x0030 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x0048 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:20:0x0030, B:22:0x0034, B:26:0x0044, B:27:0x0048), top: B:45:0x0030 }] */
        /* JADX INFO: renamed from: lambda$deliver$0$com-tapsdk-tapad-internal-runtime-image-MechanicalImageLoader$Request, reason: not valid java name */
        /* synthetic */ void m287lambda$deliver$0$comtapsdktapadinternalruntimeimageMechanicalImageLoader$Request(Exception exc, Decoded decoded) {
            if (isCancelled()) {
                return;
            }
            int i = 0;
            if (this.complete.compareAndSet(false, true)) {
                Bitmap bitmap = decoded == null ? null : decoded.bitmap;
                WeakReference<ImageView> weakReference = this.target;
                ImageView imageView = weakReference != null ? weakReference.get() : null;
                if (imageView != null) {
                    if (MechanicalImageLoader.currentRequest(imageView) != this) {
                        return;
                    }
                    if (decoded != null) {
                        try {
                            if (decoded.movie != null) {
                                MovieDrawable movieDrawable = new MovieDrawable(decoded);
                                imageView.setImageDrawable(movieDrawable);
                                movieDrawable.start();
                            } else if (bitmap != null) {
                                imageView.setImageBitmap(bitmap);
                            } else {
                                MechanicalImageLoader.applyResourceOrClear(imageView, this.options.errorResId);
                            }
                        } catch (Throwable th) {
                            exc = MechanicalImageLoader.asException(th);
                            MechanicalImageLoader.applyResourceOrClear(imageView, this.options.errorResId);
                        }
                    } else if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    } else {
                        MechanicalImageLoader.applyResourceOrClear(imageView, this.options.errorResId);
                    }
                } else if (this.target != null) {
                    return;
                }
                BitmapCallback bitmapCallback = this.callback;
                if (bitmapCallback != null) {
                    try {
                        bitmapCallback.onResult(this, bitmap, exc);
                    } catch (Throwable th2) {
                    }
                }
                this.deliveredAtMs = SystemClock.elapsedRealtime();
                String str = this.sourceTraceId;
                long j = this.requestId;
                StringBuilder sbAppend = new StringBuilder("variant=").append(this.variantTrace).append(" success=");
                if (decoded != null && exc == null) {
                    i = 1;
                }
                MechanicalImageLoader.trace("deliver", str, j, sbAppend.append(i).append(" error=").append(MechanicalImageLoader.failureCode(exc)).append(" total_ms=").append(MechanicalImageLoader.elapsedSince(this.createdAtMs)).toString());
            }
        }

        private Request(Context context, ImageView imageView, Options options, BitmapCallback bitmapCallback, boolean z) {
            this.requestId = MechanicalImageLoader.REQUEST_SEQUENCE.incrementAndGet();
            this.createdAtMs = SystemClock.elapsedRealtime();
            this.cancelled = new AtomicBoolean(false);
            this.complete = new AtomicBoolean(false);
            this.firstDrawLogged = new AtomicBoolean(false);
            this.sourceTraceId = "unknown";
            this.variantTrace = "unknown";
            this.deliveredAtMs = -1L;
            Context applicationContext = context.getApplicationContext();
            this.context = applicationContext;
            this.target = imageView == null ? null : new WeakReference<>(imageView);
            this.options = options;
            this.callback = bitmapCallback;
            this.callbackOnMain = z;
            MechanicalImageLoader.ensureMemoryCallback(applicationContext);
        }
    }

    public static final class SourceFetch implements DecodeControl {
        boolean complete;
        volatile HttpURLConnection connection;
        byte[] encoded;
        Exception failure;
        volatile Future<?> future;
        final String key;
        volatile long networkStartedAtMs;
        final String source;
        final List<InFlight> consumers = new ArrayList();
        final AtomicBoolean cancelled = new AtomicBoolean(false);
        final long createdAtMs = SystemClock.elapsedRealtime();

        public SourceFetch(String str, String str2) {
            this.key = str;
            this.source = str2;
        }

        public static void attach(InFlight inFlight) {
            boolean z;
            byte[] bArr;
            Exception exc;
            int size;
            byte[] bArr2;
            synchronized (MechanicalImageLoader.SOURCE_IN_FLIGHT_LOCK) {
                if (inFlight.isCancelled()) {
                    return;
                }
                SourceFetch sourceFetch = (SourceFetch) MechanicalImageLoader.SOURCE_IN_FLIGHT.get(inFlight.source.key());
                boolean z2 = true;
                boolean z3 = false;
                if (sourceFetch == null) {
                    sourceFetch = new SourceFetch(inFlight.source.key(), inFlight.source.uri);
                    MechanicalImageLoader.SOURCE_IN_FLIGHT.put(sourceFetch.key, sourceFetch);
                    z = true;
                } else {
                    z = false;
                }
                if (sourceFetch.consumers.size() >= 64) {
                    size = 0;
                    sourceFetch = null;
                    bArr2 = null;
                    exc = null;
                } else {
                    sourceFetch.consumers.add(inFlight);
                    inFlight.sourceFetch = sourceFetch;
                    if (sourceFetch.complete) {
                        bArr = sourceFetch.encoded;
                        exc = sourceFetch.failure;
                    } else {
                        z2 = false;
                        bArr = null;
                        exc = null;
                    }
                    size = sourceFetch.consumers.size();
                    byte[] bArr3 = bArr;
                    z3 = z2;
                    bArr2 = bArr3;
                }
                if (sourceFetch != null && inFlight.isCancelled()) {
                    sourceFetch.remove(inFlight);
                    return;
                }
                if (sourceFetch == null) {
                    inFlight.finish(null, new IOException("too many image variants for one source"));
                    return;
                }
                if (z3) {
                    MechanicalImageLoader.trace("source_join", inFlight.source.traceId, 0L, "variants=" + size + " ready=1");
                    inFlight.onSourceReady(sourceFetch, bArr2, exc);
                } else if (!z) {
                    MechanicalImageLoader.trace("source_join", inFlight.source.traceId, 0L, "variants=" + size + " ready=0");
                } else {
                    MechanicalImageLoader.trace("source_queue", inFlight.source.traceId, 0L, "variants=" + size + " " + MechanicalImageLoader.executorState());
                    sourceFetch.start();
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.DecodeControl
        public synchronized void clearConnection(HttpURLConnection httpURLConnection) {
            if (this.connection == httpURLConnection) {
                this.connection = null;
            }
        }

        public void finish(byte[] bArr, Exception exc) {
            ArrayList arrayList;
            synchronized (MechanicalImageLoader.SOURCE_IN_FLIGHT_LOCK) {
                this.complete = true;
                this.encoded = bArr;
                this.failure = exc;
                arrayList = new ArrayList(this.consumers);
                if (arrayList.isEmpty()) {
                    if (MechanicalImageLoader.SOURCE_IN_FLIGHT.get(this.key) == this) {
                        MechanicalImageLoader.SOURCE_IN_FLIGHT.remove(this.key);
                    }
                    this.encoded = null;
                }
            }
            int i = 0;
            MechanicalImageLoader.trace("network_end", MechanicalImageLoader.debugSourceId(this.source), 0L, "success=" + ((bArr == null || exc != null) ? 0 : 1) + " error=" + MechanicalImageLoader.failureCode(exc) + " network_ms=" + (this.networkStartedAtMs > 0 ? MechanicalImageLoader.elapsedSince(this.networkStartedAtMs) : -1L) + " total_ms=" + MechanicalImageLoader.elapsedSince(this.createdAtMs) + " bytes=" + (bArr == null ? 0 : bArr.length) + " variants=" + arrayList.size());
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((InFlight) obj).onSourceReady(this, bArr, exc);
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.DecodeControl
        public void installConnection(HttpURLConnection httpURLConnection) throws IOException {
            synchronized (this) {
                if (isCancelled()) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (RuntimeException e) {
                    }
                    throw new IOException("image source request cancelled");
                }
                this.connection = httpURLConnection;
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.DecodeControl
        public boolean isCancelled() {
            return this.cancelled.get();
        }

        /* JADX INFO: renamed from: lambda$start$0$com-tapsdk-tapad-internal-runtime-image-MechanicalImageLoader$SourceFetch, reason: not valid java name */
        /* synthetic */ void m288lambda$start$0$comtapsdktapadinternalruntimeimageMechanicalImageLoader$SourceFetch() throws IOException {
            Exception e;
            this.networkStartedAtMs = SystemClock.elapsedRealtime();
            MechanicalImageLoader.trace("network_start", MechanicalImageLoader.debugSourceId(this.source), 0L, "queue_ms=" + MechanicalImageLoader.elapsedSince(this.createdAtMs));
            byte[] network = null;
            try {
                e = null;
                network = MechanicalImageLoader.readNetwork(this.source, this);
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th) {
                e = MechanicalImageLoader.asException(th);
            }
            finish(network, e);
        }

        public void remove(InFlight inFlight) {
            HttpURLConnection httpURLConnection;
            Future<?> future;
            synchronized (MechanicalImageLoader.SOURCE_IN_FLIGHT_LOCK) {
                this.consumers.remove(inFlight);
                if (this.consumers.isEmpty()) {
                    if (MechanicalImageLoader.SOURCE_IN_FLIGHT.get(this.key) == this) {
                        MechanicalImageLoader.SOURCE_IN_FLIGHT.remove(this.key);
                    }
                    this.encoded = null;
                    boolean z = this.complete;
                    if (z || !this.cancelled.compareAndSet(false, true)) {
                        return;
                    }
                    synchronized (this) {
                        httpURLConnection = this.connection;
                        future = this.future;
                    }
                    if (httpURLConnection != null) {
                        MechanicalImageLoader.disconnectConnection(httpURLConnection);
                    }
                    if (future != null) {
                        future.cancel(true);
                    }
                }
            }
        }

        public void start() {
            try {
                Future<?> futureSubmit = MechanicalImageLoader.WORKERS.submit(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$SourceFetch$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        this.f$0.m288lambda$start$0$comtapsdktapadinternalruntimeimageMechanicalImageLoader$SourceFetch();
                    }
                });
                this.future = futureSubmit;
                if (isCancelled()) {
                    futureSubmit.cancel(true);
                }
            } catch (RejectedExecutionException e) {
                finish(null, new IOException("image source queue is full", e));
            }
        }
    }

    static {
        int i;
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        MAX_HEAP_BYTES = jMaxMemory;
        if (jMaxMemory < 201326592) {
            i = 1;
        } else {
            i = jMaxMemory < 402653184 ? 2 : 3;
        }
        WORKER_COUNT = i;
        int iMax = (int) Math.max(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, Math.min(12582912L, jMaxMemory / 16));
        MEMORY_CACHE_BYTES = iMax;
        MAIN = new Handler(Looper.getMainLooper());
        TARGET_LOCK = new Object();
        IN_FLIGHT_LOCK = new Object();
        SOURCE_IN_FLIGHT_LOCK = new Object();
        MEMORY_CALLBACK_REGISTERED = new AtomicBoolean(false);
        REQUEST_SEQUENCE = new AtomicLong();
        SOURCE_SEQUENCE = new AtomicLong();
        TARGET_REQUESTS = new WeakHashMap<>();
        LIFECYCLE_TARGETS = new WeakHashMap<>();
        IN_FLIGHT = new HashMap();
        SOURCE_IN_FLIGHT = new HashMap();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        int i2 = i;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 30L, timeUnit, new LinkedBlockingQueue(32), new ThreadFactory() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return MechanicalImageLoader.lambda$static$1(runnable);
            }
        });
        WORKERS = threadPoolExecutor;
        CONNECTION_CLEANUP = new ThreadPoolExecutor(0, i2, 30L, timeUnit, new SynchronousQueue(), new ThreadFactory() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return MechanicalImageLoader.lambda$static$3(runnable);
            }
        });
        MEMORY_CACHE = new LruCache<String, Decoded>(iMax) { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.1
            @Override // android.util.LruCache
            public int sizeOf(String str, Decoded decoded) {
                if (decoded == null) {
                    return 0;
                }
                return decoded.byteCount();
            }
        };
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private MechanicalImageLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applyResourceOrClear(ImageView imageView, int i) {
        try {
            stopDrawable(imageView.getDrawable());
            if (i != 0) {
                imageView.setImageResource(i);
            } else {
                imageView.setImageDrawable(null);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Exception asException(Throwable th) {
        return th instanceof Exception ? (Exception) th : new IOException("image binding failed", th);
    }

    private static void bindRequest(ImageView imageView, Request request) {
        synchronized (TARGET_LOCK) {
            TARGET_REQUESTS.put(imageView, request);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Decoded cached(String str) {
        LruCache<String, Decoded> lruCache = MEMORY_CACHE;
        Decoded decoded = lruCache.get(str);
        if (decoded != null && decoded.isUsable()) {
            return decoded;
        }
        if (decoded == null) {
            return null;
        }
        lruCache.remove(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int clampDimension(int i) {
        if (i <= 0) {
            return 0;
        }
        return Math.min(i, 2048);
    }

    public static void clear(final ImageView imageView) {
        if (imageView == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MechanicalImageLoader.lambda$clear$7(imageView);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            MAIN.post(runnable);
        }
    }

    public static void clearMemoryCache() {
        synchronized (IN_FLIGHT_LOCK) {
            Iterator<InFlight> it = IN_FLIGHT.values().iterator();
            while (it.hasNext()) {
                it.next().cacheable = false;
            }
            MEMORY_CACHE.evictAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String contentFingerprint(byte[] bArr) {
        if (bArr == null) {
            return AbstractJsonLexerKt.NULL;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
            char[] cArr = new char[32];
            char[] charArray = "0123456789abcdef".toCharArray();
            for (int i = 0; i < 16; i++) {
                byte b = bArrDigest[i];
                int i2 = i * 2;
                cArr[i2] = charArray[(b & UByte.MAX_VALUE) >>> 4];
                cArr[i2 + 1] = charArray[b & cc.m];
            }
            return new String(cArr);
        } catch (NoSuchAlgorithmException e) {
            return "uncached-" + SOURCE_SEQUENCE.incrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Request currentRequest(ImageView imageView) {
        Request request;
        synchronized (TARGET_LOCK) {
            request = TARGET_REQUESTS.get(imageView);
        }
        return request;
    }

    public static String debugSourceId(String str) {
        if (str == null) {
            str = "";
        }
        return textFingerprint("uri:".concat(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Decoded decode(Context context, Source source, Options options, boolean z, DecodeControl decodeControl, byte[] bArr) throws IOException {
        File fileLocalFile = source.localFile();
        if (fileLocalFile != null && (!z || !isGif(fileLocalFile))) {
            return Decoded.bitmap(decodeBitmap(fileLocalFile, options, decodeControl));
        }
        if (bArr == null) {
            bArr = readSource(context, source, decodeControl);
        }
        requireActive(decodeControl);
        if (z && isGif(bArr)) {
            if (bArr.length > 8388608) {
                throw new IOException("animated image exceeded byte limit");
            }
            Movie movieDecodeByteArray = Movie.decodeByteArray(bArr, 0, bArr.length);
            if (movieDecodeByteArray != null) {
                if (safeDimensions(movieDecodeByteArray.width(), movieDecodeByteArray.height())) {
                    return Decoded.movie(movieDecodeByteArray, bArr);
                }
                throw new IOException("animated image dimensions exceed decode budget");
            }
        }
        return Decoded.bitmap(decodeBitmap(bArr, options, decodeControl));
    }

    private static Bitmap decodeBitmap(File file, Options options, DecodeControl decodeControl) throws IOException {
        Bitmap bitmapDecodeFile;
        long length = file.length();
        if (!file.isFile() || length <= 0 || length > 20971520) {
            throw new IOException("invalid local image asset");
        }
        requireActive(decodeControl);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options2);
        if (options2.outWidth <= 0 || options2.outHeight <= 0) {
            throw new IOException("unsupported image data");
        }
        BitmapFactory.Options optionsDecodeOptions = decodeOptions(options2, options);
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), optionsDecodeOptions);
        } catch (OutOfMemoryError e) {
            clearMemoryCache();
            int i = optionsDecodeOptions.inSampleSize;
            if (i > 1073741823) {
                throw e;
            }
            optionsDecodeOptions.inSampleSize = i * 2;
            bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), optionsDecodeOptions);
        }
        if (bitmapDecodeFile == null) {
            throw new IOException("image decode failed");
        }
        requireActive(decodeControl);
        return transform(bitmapDecodeFile, options);
    }

    private static BitmapFactory.Options decodeOptions(BitmapFactory.Options options, Options options2) {
        int i = options2.targetWidth > 0 ? options2.targetWidth : 2048;
        int i2 = options2.targetHeight > 0 ? options2.targetHeight : 2048;
        BitmapFactory.Options options3 = new BitmapFactory.Options();
        options3.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options3.inSampleSize = sampleSize(options.outWidth, options.outHeight, i, i2);
        return options3;
    }

    private static long decodedPixels(int i, int i2, int i3) {
        return ((long) Math.max(1, i / i3)) * ((long) Math.max(1, i2 / i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void disconnectConnection(final HttpURLConnection httpURLConnection) {
        try {
            CONNECTION_CLEANUP.execute(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    httpURLConnection.disconnect();
                }
            });
        } catch (RejectedExecutionException e) {
        }
    }

    public static void dropDecoded(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String str2 = "uri:" + str + '|';
        synchronized (IN_FLIGHT_LOCK) {
            for (Map.Entry<String, InFlight> entry : IN_FLIGHT.entrySet()) {
                if (entry.getKey().startsWith(str2)) {
                    entry.getValue().cacheable = false;
                }
            }
            for (String str3 : MEMORY_CACHE.snapshot().keySet()) {
                if (str3.startsWith(str2)) {
                    MEMORY_CACHE.remove(str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long elapsedSince(long j) {
        return Math.max(0L, SystemClock.elapsedRealtime() - j);
    }

    private static void ensureDetachCancellation(ImageView imageView) {
        synchronized (TARGET_LOCK) {
            WeakHashMap<ImageView, Boolean> weakHashMap = LIFECYCLE_TARGETS;
            if (weakHashMap.containsKey(imageView)) {
                return;
            }
            weakHashMap.put(imageView, Boolean.TRUE);
            imageView.addOnAttachStateChangeListener(new AnonymousClass3());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ensureMemoryCallback(Context context) {
        if (MEMORY_CALLBACK_REGISTERED.compareAndSet(false, true)) {
            try {
                context.registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.2
                    @Override // android.content.ComponentCallbacks
                    public void onConfigurationChanged(Configuration configuration) {
                    }

                    @Override // android.content.ComponentCallbacks
                    public void onLowMemory() {
                        MechanicalImageLoader.clearMemoryCache();
                    }

                    @Override // android.content.ComponentCallbacks2
                    public void onTrimMemory(int i) {
                        MechanicalImageLoader.onTrimMemory(i);
                    }
                });
            } catch (Throwable th) {
                MEMORY_CALLBACK_REGISTERED.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String executorState() {
        StringBuilder sb = new StringBuilder("active=");
        ThreadPoolExecutor threadPoolExecutor = WORKERS;
        return sb.append(threadPoolExecutor.getActiveCount()).append(" queue=").append(threadPoolExecutor.getQueue().size()).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String failureCode(Exception exc) {
        return exc == null ? "none" : exc.getClass().getSimpleName();
    }

    private static boolean isGif(byte[] bArr) {
        byte b;
        return bArr != null && bArr.length >= 6 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && ((b = bArr[4]) == 55 || b == 57) && bArr[5] == 97;
    }

    private static boolean isRedirect(int i) {
        return i == 301 || i == 302 || i == 303 || i == 307 || i == 308;
    }

    static /* synthetic */ void lambda$clear$7(ImageView imageView) {
        Request requestUnbindRequest = unbindRequest(imageView);
        if (requestUnbindRequest != null) {
            requestUnbindRequest.cancel();
        }
        try {
            stopDrawable(imageView.getDrawable());
            imageView.setImageDrawable(null);
        } catch (Throwable th) {
        }
    }

    static /* synthetic */ void lambda$load$5(Request request, ImageView imageView, Options options, Source source) {
        if (request.isCancelled()) {
            return;
        }
        clear(imageView);
        if (request.isCancelled()) {
            return;
        }
        ensureDetachCancellation(imageView);
        bindRequest(imageView, request);
        applyResourceOrClear(imageView, options.placeholderResId);
        request.start(source, true);
    }

    static /* synthetic */ void lambda$loadBitmapBlocking$6(AtomicReference atomicReference, AtomicReference atomicReference2, CountDownLatch countDownLatch, Request request, Bitmap bitmap, Exception exc) {
        atomicReference.set(bitmap);
        atomicReference2.set(exc);
        countDownLatch.countDown();
    }

    static /* synthetic */ void lambda$static$0(Runnable runnable) {
        try {
            Process.setThreadPriority(10);
        } catch (RuntimeException e) {
        }
        runnable.run();
    }

    static /* synthetic */ Thread lambda$static$1(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MechanicalImageLoader.lambda$static$0(runnable);
            }
        }, TAG);
        thread.setDaemon(true);
        return thread;
    }

    static /* synthetic */ void lambda$static$2(Runnable runnable) {
        try {
            Process.setThreadPriority(10);
        } catch (RuntimeException e) {
        }
        runnable.run();
    }

    static /* synthetic */ Thread lambda$static$3(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MechanicalImageLoader.lambda$static$2(runnable);
            }
        }, "DirichletImageCleanup");
        thread.setDaemon(true);
        return thread;
    }

    public static Request load(ImageView imageView, String str, Options options) {
        return load(imageView, Source.uri(str), options, (BitmapCallback) null);
    }

    public static Request loadBitmap(Context context, String str, Options options, BitmapCallback bitmapCallback) {
        return loadBitmap(context, Source.uri(str), options, bitmapCallback, true);
    }

    public static Bitmap loadBitmapBlocking(Context context, String str, Options options) throws IOException {
        Bitmap bitmap;
        if (context == null) {
            throw new IOException("image context is null");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IOException("blocking image decode on main thread");
        }
        if (options == null) {
            options = Options.defaults();
        }
        Source sourceUri = Source.uri(str);
        Decoded decodedCached = cached(sourceUri.key() + '|' + options.decodeKey() + ":a0");
        if (decodedCached != null && (bitmap = decodedCached.bitmap) != null) {
            return bitmap;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        Request requestLoadBitmap = loadBitmap(context, sourceUri, options, new BitmapCallback() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$$ExternalSyntheticLambda4
            @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.BitmapCallback
            public final void onResult(MechanicalImageLoader.Request request, Bitmap bitmap2, Exception exc) {
                MechanicalImageLoader.lambda$loadBitmapBlocking$6(atomicReference, atomicReference2, countDownLatch, request, bitmap2, exc);
            }
        }, false);
        try {
            if (!countDownLatch.await(30000L, TimeUnit.MILLISECONDS)) {
                requestLoadBitmap.cancel();
                throw new IOException("image request timed out");
            }
            Exception exc = (Exception) atomicReference2.get();
            if (exc != null) {
                if (exc instanceof IOException) {
                    throw ((IOException) exc);
                }
                throw new IOException("image request failed", exc);
            }
            Bitmap bitmap2 = (Bitmap) atomicReference.get();
            if (bitmap2 != null) {
                return bitmap2;
            }
            throw new IOException("image decode failed");
        } catch (InterruptedException e) {
            requestLoadBitmap.cancel();
            Thread.currentThread().interrupt();
            throw new IOException("image request interrupted", e);
        }
    }

    public static void onImageDrawn(ImageView imageView) {
        Request requestCurrentRequest;
        if (imageView == null || imageView.getDrawable() == null || !imageView.isShown() || (requestCurrentRequest = currentRequest(imageView)) == null || !requestCurrentRequest.isComplete() || requestCurrentRequest.deliveredAtMs < 0 || !requestCurrentRequest.firstDrawLogged.compareAndSet(false, true)) {
            return;
        }
        trace("first_draw", requestCurrentRequest.sourceTraceId, requestCurrentRequest.requestId, "variant=" + requestCurrentRequest.variantTrace + " deliver_to_draw_ms=" + elapsedSince(requestCurrentRequest.deliveredAtMs) + " total_ms=" + elapsedSince(requestCurrentRequest.createdAtMs));
    }

    public static void onTrimMemory(int i) {
        if (i >= 40 || i == 15) {
            clearMemoryCache();
            return;
        }
        if (i >= 20 || i == 10) {
            MEMORY_CACHE.trimToSize(MEMORY_CACHE_BYTES / 2);
        } else if (i == 5) {
            MEMORY_CACHE.trimToSize((MEMORY_CACHE_BYTES * 3) / 4);
        }
    }

    private static byte[] readBounded(InputStream inputStream, int i, DecodeControl decodeControl) throws IOException {
        if (inputStream == null) {
            throw new IOException("image stream unavailable");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? Math.min(i, 262144) : 16384);
        byte[] bArr = new byte[16384];
        int i2 = 0;
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 < 0) {
                if (i2 != 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                throw new IOException("empty image stream");
            }
            requireActive(decodeControl);
            if (i3 != 0) {
                i2 += i3;
                if (i2 > MAX_IMAGE_BYTES) {
                    throw new IOException("image stream exceeded byte limit");
                }
                byteArrayOutputStream.write(bArr, 0, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] readNetwork(String str, DecodeControl decodeControl) throws IOException {
        URL url = new URL(str);
        String protocol = url.getProtocol();
        HashSet hashSet = new HashSet();
        int i = 0;
        while (i <= 5) {
            String protocol2 = url.getProtocol();
            if (!BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(protocol2) && !"http".equalsIgnoreCase(protocol2)) {
                throw new IOException("unsupported redirect scheme");
            }
            if (url.getHost() == null || url.getHost().isEmpty() || url.getUserInfo() != null) {
                throw new IOException("invalid image URL authority");
            }
            if (!hashSet.add(url.toExternalForm())) {
                throw new IOException("image redirect loop");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(READ_TIMEOUT_MS);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("User-Agent", "Dirichlet-SDK");
            decodeControl.installConnection(httpURLConnection);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (!isRedirect(responseCode)) {
                    if (responseCode < 200 || responseCode >= 300) {
                        throw new IOException("image request failed: HTTP " + responseCode);
                    }
                    int contentLength = httpURLConnection.getContentLength();
                    if (contentLength > MAX_IMAGE_BYTES) {
                        throw new IOException("image response too large");
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bounded = readBounded(inputStream, contentLength, decodeControl);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        decodeControl.clearConnection(httpURLConnection);
                        httpURLConnection.disconnect();
                        return bounded;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                if (i == 5) {
                    throw new IOException("image redirect limit exceeded");
                }
                String headerField = httpURLConnection.getHeaderField("Location");
                if (headerField == null || headerField.trim().isEmpty()) {
                    throw new IOException("image redirect missing location");
                }
                if (headerField.length() > 8192) {
                    throw new IOException("image redirect location too long");
                }
                URL url2 = new URL(url, headerField);
                if (BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(protocol) && !BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(url2.getProtocol())) {
                    throw new IOException("image redirect downgraded transport security");
                }
                decodeControl.clearConnection(httpURLConnection);
                httpURLConnection.disconnect();
                i++;
                url = url2;
            } catch (Throwable th3) {
                decodeControl.clearConnection(httpURLConnection);
                httpURLConnection.disconnect();
                throw th3;
            }
        }
        throw new IOException("image redirect limit exceeded");
    }

    private static byte[] readSource(Context context, Source source, DecodeControl decodeControl) throws IOException {
        byte[] bArr = source.bytes;
        if (bArr != null) {
            if (bArr.length == 0 || bArr.length > MAX_IMAGE_BYTES) {
                throw new IOException("invalid image byte count");
            }
            return bArr;
        }
        String str = source.uri;
        if (str == null || str.isEmpty()) {
            throw new IOException("empty image URI");
        }
        if (source.uri.length() > 8192) {
            throw new IOException("image URI too long");
        }
        Uri uri = Uri.parse(source.uri);
        String scheme = uri.getScheme();
        if ("file".equalsIgnoreCase(scheme)) {
            return RustResolvedAsset.readBounded(source.uri, MAX_IMAGE_BYTES);
        }
        if (!"android.resource".equalsIgnoreCase(scheme)) {
            if (BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(scheme) || "http".equalsIgnoreCase(scheme)) {
                return readNetwork(source.uri, decodeControl);
            }
            throw new IOException("unsupported image URI scheme");
        }
        if (!context.getPackageName().equals(uri.getAuthority())) {
            throw new IOException("foreign resource authority");
        }
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        try {
            byte[] bounded = readBounded(inputStreamOpenInputStream, -1, decodeControl);
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            return bounded;
        } catch (Throwable th) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static void requireActive(DecodeControl decodeControl) throws IOException {
        if (decodeControl.isCancelled() || Thread.currentThread().isInterrupted()) {
            throw new IOException("image request cancelled");
        }
    }

    private static boolean safeDimensions(int i, int i2) {
        return i > 0 && i2 > 0 && i <= 4096 && i2 <= 4096 && ((long) i) * ((long) i2) <= MAX_DECODE_PIXELS;
    }

    private static void safeRecycle(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        try {
            bitmap.recycle();
        } catch (RuntimeException e) {
        }
    }

    private static int sampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        while (i5 <= 1073741823) {
            int i6 = i5 * 2;
            if (i / i6 < i3 || i2 / i6 < i4) {
                break;
            }
            i5 = i6;
        }
        while (i5 <= 1073741823 && (i / i5 > 4096 || i2 / i5 > 4096 || decodedPixels(i, i2, i5) > MAX_DECODE_PIXELS)) {
            i5 *= 2;
        }
        return Math.max(1, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void stopDrawable(Drawable drawable) {
        if (drawable instanceof Animatable) {
            try {
                ((Animatable) drawable).stop();
            } catch (RuntimeException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String textFingerprint(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8));
            char[] cArr = new char[16];
            char[] charArray = "0123456789abcdef".toCharArray();
            for (int i = 0; i < 8; i++) {
                byte b = bArrDigest[i];
                int i2 = i * 2;
                cArr[i2] = charArray[(b & UByte.MAX_VALUE) >>> 4];
                cArr[i2 + 1] = charArray[b & cc.m];
            }
            return new String(cArr);
        } catch (NoSuchAlgorithmException e) {
            return "source-" + Integer.toHexString(str.hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void trace(String str, String str2, long j, String str3) {
        Log.isLoggable(TAG, 3);
    }

    private static Bitmap transform(Bitmap bitmap, Options options) {
        Bitmap bitmapCreateScaledBitmap;
        OutOfMemoryError e;
        if (options.blurRadius > 0 && bitmap.getWidth() >= 50 && bitmap.getHeight() >= 50) {
            try {
                bitmapCreateScaledBitmap = options.blurSampling > 1 ? Bitmap.createScaledBitmap(bitmap, Math.max(1, bitmap.getWidth() / options.blurSampling), Math.max(1, bitmap.getHeight() / options.blurSampling), false) : bitmap;
                try {
                    Bitmap bitmapFastBlur = BlurHelper.fastBlur(bitmapCreateScaledBitmap);
                    if (bitmapCreateScaledBitmap != bitmap && bitmapCreateScaledBitmap != bitmapFastBlur) {
                        safeRecycle(bitmapCreateScaledBitmap);
                    }
                    if (bitmapFastBlur != null && bitmapFastBlur != bitmap) {
                        safeRecycle(bitmap);
                        bitmap = bitmapFastBlur;
                    }
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    clearMemoryCache();
                    if (bitmapCreateScaledBitmap != null && bitmapCreateScaledBitmap != bitmap) {
                        safeRecycle(bitmapCreateScaledBitmap);
                    }
                    if (bitmap.isRecycled()) {
                        throw e;
                    }
                } catch (RuntimeException e3) {
                    if (bitmapCreateScaledBitmap != null && bitmapCreateScaledBitmap != bitmap) {
                        safeRecycle(bitmapCreateScaledBitmap);
                    }
                }
            } catch (OutOfMemoryError e4) {
                e = e4;
                bitmapCreateScaledBitmap = bitmap;
            } catch (RuntimeException e5) {
                bitmapCreateScaledBitmap = bitmap;
            }
        }
        if (options.cornerRadiusPx <= 0 || bitmap.isRecycled()) {
            return bitmap;
        }
        try {
            int width = options.targetWidth > 0 ? options.targetWidth : bitmap.getWidth();
            int iMax = Math.max(1, Math.round(options.cornerRadiusPx * (width > 0 ? bitmap.getWidth() / width : 1.0f)));
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint(1);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            float f = iMax;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), f, f, paint);
            safeRecycle(bitmap);
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError e6) {
            clearMemoryCache();
            if (bitmap.isRecycled()) {
                throw e6;
            }
            return bitmap;
        } catch (RuntimeException e7) {
            return bitmap;
        }
    }

    private static Request unbindRequest(ImageView imageView) {
        Request requestRemove;
        synchronized (TARGET_LOCK) {
            requestRemove = TARGET_REQUESTS.remove(imageView);
        }
        return requestRemove;
    }

    private static boolean isGif(File file) throws IOException {
        byte[] bArr = new byte[6];
        FileInputStream fileInputStream = new FileInputStream(file);
        int i = 0;
        while (i < 6) {
            try {
                int i2 = fileInputStream.read(bArr, i, 6 - i);
                if (i2 < 0) {
                    fileInputStream.close();
                    return false;
                }
                i += i2;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        fileInputStream.close();
        return isGif(bArr);
    }

    public static Request load(ImageView imageView, String str, Options options, BitmapCallback bitmapCallback) {
        return load(imageView, Source.uri(str), options, bitmapCallback);
    }

    public static Request loadBitmap(Context context, byte[] bArr, Options options, BitmapCallback bitmapCallback) {
        return loadBitmap(context, Source.bytes(bArr), options, bitmapCallback, true);
    }

    public static final class Source {
        final byte[] bytes;
        final String key;
        final String traceId;
        final String uri;

        private Source(String str, byte[] bArr, String str2) {
            this.uri = str;
            this.bytes = bArr;
            this.key = str2;
            this.traceId = MechanicalImageLoader.textFingerprint(str2);
        }

        public static Source bytes(byte[] bArr) {
            return new Source(null, bArr, "bytes:" + (bArr == null ? 0 : bArr.length) + AbstractJsonLexerKt.COLON + MechanicalImageLoader.SOURCE_SEQUENCE.incrementAndGet());
        }

        public static Source uri(String str) {
            return new Source(str, null, "uri:".concat(str == null ? "" : str));
        }

        public boolean isNetworkUri() {
            String str = this.uri;
            if (str == null || str.isEmpty() || this.uri.length() > 8192) {
                return false;
            }
            String scheme = Uri.parse(this.uri).getScheme();
            return BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(scheme) || "http".equalsIgnoreCase(scheme);
        }

        public String key() {
            return this.key;
        }

        public File localFile() throws IOException {
            String str = this.uri;
            if (str == null) {
                return null;
            }
            if (str.length() > 8192) {
                throw new IOException("image URI too long");
            }
            if ("file".equalsIgnoreCase(Uri.parse(this.uri).getScheme())) {
                return RustResolvedAsset.requireLocalFile(this.uri);
            }
            return null;
        }

        public static Source bytes(String str, byte[] bArr) {
            if (str == null) {
                str = "";
            }
            return new Source(null, bArr, "bytes-key:" + str + AbstractJsonLexerKt.COLON + (bArr == null ? 0 : bArr.length) + AbstractJsonLexerKt.COLON + MechanicalImageLoader.contentFingerprint(bArr));
        }
    }

    public static Request load(ImageView imageView, byte[] bArr, Options options) {
        return load(imageView, Source.bytes(bArr), options, (BitmapCallback) null);
    }

    public static Request loadBitmap(Context context, String str, byte[] bArr, Options options, BitmapCallback bitmapCallback) {
        return loadBitmap(context, Source.bytes(str, bArr), options, bitmapCallback, true);
    }

    public static Request load(ImageView imageView, String str, byte[] bArr, Options options) {
        return load(imageView, Source.bytes(str, bArr), options, (BitmapCallback) null);
    }

    private static Request loadBitmap(Context context, Source source, Options options, BitmapCallback bitmapCallback, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException("image context is null");
        }
        Request request = new Request(context, null, options == null ? Options.defaults() : options, bitmapCallback, z);
        request.start(source, false);
        return request;
    }

    public static Request load(ImageView imageView, String str, byte[] bArr, Options options, BitmapCallback bitmapCallback) {
        return load(imageView, Source.bytes(str, bArr), options, bitmapCallback);
    }

    private static Request load(final ImageView imageView, final Source source, final Options options, BitmapCallback bitmapCallback) {
        if (imageView != null) {
            if (options == null) {
                options = Options.defaults();
            }
            final Request request = new Request(imageView.getContext(), imageView, options, bitmapCallback, true);
            Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    MechanicalImageLoader.lambda$load$5(request, imageView, options, source);
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
                return request;
            }
            try {
                if (!MAIN.post(runnable)) {
                    request.cancel();
                }
                return request;
            } catch (RuntimeException e) {
                request.cancel();
                return request;
            }
        }
        throw new IllegalArgumentException("image target is null");
    }

    private static Bitmap decodeBitmap(byte[] bArr, Options options, DecodeControl decodeControl) throws IOException {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
        if (options2.outWidth > 0 && options2.outHeight > 0) {
            BitmapFactory.Options optionsDecodeOptions = decodeOptions(options2, options);
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, optionsDecodeOptions);
            } catch (OutOfMemoryError e) {
                clearMemoryCache();
                int i = optionsDecodeOptions.inSampleSize;
                if (i <= 1073741823) {
                    optionsDecodeOptions.inSampleSize = i * 2;
                    bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, optionsDecodeOptions);
                } else {
                    throw e;
                }
            }
            if (bitmapDecodeByteArray != null) {
                requireActive(decodeControl);
                return transform(bitmapDecodeByteArray, options);
            }
            throw new IOException("image decode failed");
        }
        throw new IOException("unsupported image data");
    }
}
