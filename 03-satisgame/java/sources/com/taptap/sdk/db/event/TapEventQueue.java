package com.taptap.sdk.db.event;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.l.f;
import com.byazt.ho.BaseConstants;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.db.event.model.TapEventBean;
import com.taptap.sdk.db.event.utils.TapEventLogger;
import com.taptap.sdk.db.event.utils.TapOpenlogHelper;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.TapHttpExtKt;
import com.taptap.sdk.kit.internal.http.TapLogInterceptor;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpSign;
import com.taptap.sdk.kit.internal.store.TapDataStore;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapEventQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001dH\u0007J\r\u0010$\u001a\u00020\"H\u0000¢\u0006\u0002\b%J\b\u0010&\u001a\u00020\"H\u0007J\b\u0010'\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/taptap/sdk/db/event/TapEventQueue;", "", "()V", "FLUSH_PERIOD_IN_SECONDS", "", "HOST_CN", "", "HOST_IO", "NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER", "TAG", "URL_PATH", "flushRunnable", "Ljava/lang/Runnable;", "http", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", "getHttp", "()Lcom/taptap/sdk/kit/internal/http/TapHttp;", "http$delegate", "Lkotlin/Lazy;", "scheduledFuture", "Ljava/util/concurrent/ScheduledFuture;", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "getSingleThreadExecutor$tap_db_release$annotations", "getSingleThreadExecutor$tap_db_release", "()Ljava/util/concurrent/ScheduledExecutorService;", "store", "Lcom/taptap/sdk/kit/internal/store/TapDataStore;", "Lcom/taptap/sdk/db/event/model/TapEventBean;", "getStore", "()Lcom/taptap/sdk/kit/internal/store/TapDataStore;", "store$delegate", "add", "", NotificationCompat.CATEGORY_EVENT, "flush", "flush$tap_db_release", "flushAndWait", "getHost", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapEventQueue {
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final String HOST_CN = "e.tapdb.net";
    private static final String HOST_IO = "e.tapdb.ap-sg.tapapis.com";
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 50;
    private static final String TAG = "TapEventQueue";
    private static final String URL_PATH = "v2/batch";
    private static ScheduledFuture<?> scheduledFuture;
    public static final TapEventQueue INSTANCE = new TapEventQueue();
    private static final Runnable flushRunnable = new Runnable() { // from class: com.taptap.sdk.db.event.TapEventQueue$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() throws JSONException {
            TapEventQueue.flushRunnable$lambda$0();
        }
    };
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.taptap.sdk.db.event.TapEventQueue$singleThreadExecutor$1
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Intrinsics.checkNotNullParameter(r, "r");
            return new Thread(r, "TapEventLoggerTask #" + this.mCount.getAndIncrement());
        }
    });

    /* JADX INFO: renamed from: store$delegate, reason: from kotlin metadata */
    private static final Lazy store = LazyKt.lazy(new Function0<TapDataStore<TapEventBean>>() { // from class: com.taptap.sdk.db.event.TapEventQueue$store$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TapDataStore<TapEventBean> invoke() {
            return new TapDataStore<>(TapTapKit.INSTANCE.getContext(), "TapEvent_persistedData", 1000, 10485760L);
        }
    });

    /* JADX INFO: renamed from: http$delegate, reason: from kotlin metadata */
    private static final Lazy http = LazyKt.lazy(new Function0<TapHttp>() { // from class: com.taptap.sdk.db.event.TapEventQueue$http$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TapHttp invoke() {
            return TapHttp.INSTANCE.newBuilder("TapSDKCore", "4.5.0").domain(TapEventQueue.INSTANCE.getHost()).signHandler(new TapHttpSign.None()).debugLogLevel(TapLogInterceptor.Level.HEADERS).setTechnicalLogEnable(true).build();
        }
    });

    @JvmStatic
    public static /* synthetic */ void getSingleThreadExecutor$tap_db_release$annotations() {
    }

    private TapEventQueue() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void flushRunnable$lambda$0() throws JSONException {
        scheduledFuture = null;
        flushAndWait();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapDataStore<TapEventBean> getStore() {
        return (TapDataStore) store.getValue();
    }

    private final TapHttp getHttp() {
        return (TapHttp) http.getValue();
    }

    @JvmStatic
    public static final void add(TapEventBean event) throws JSONException {
        Intrinsics.checkNotNullParameter(event, "event");
        TapEventQueue tapEventQueue = INSTANCE;
        tapEventQueue.getStore().addData(event);
        if (tapEventQueue.getStore().getAccumulatedDataCount() >= 50) {
            flushAndWait();
        } else if (scheduledFuture == null) {
            scheduledFuture = singleThreadExecutor.schedule(flushRunnable, 15L, TimeUnit.SECONDS);
        }
    }

    @JvmStatic
    public static final void flushAndWait() throws JSONException {
        TapLogger.logd(TAG, "flushAndWait start");
        TapEventQueue tapEventQueue = INSTANCE;
        final List listObtainData$default = TapDataStore.obtainData$default(tapEventQueue.getStore(), 0, 1, null);
        if (listObtainData$default.isEmpty()) {
            TapLogger.logd(TAG, "reportedEvents.isEmpty() , flushAndWait end");
            return;
        }
        TapLogger.logi(TapLogger.TAG, "TapEvent flush events start");
        final String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        final String string2 = new Uri.Builder().scheme(BaseConstants.SCHEME_HTTPS).authority(tapEventQueue.getHost()).path(URL_PATH).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "Builder().scheme(\"https\"…path(URL_PATH).toString()");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator it = listObtainData$default.iterator();
        while (it.hasNext()) {
            jSONArray.put(((TapEventBean) it.next()).getProperties());
        }
        jSONObject.put(f.R, jSONArray);
        TapOpenlogHelper.INSTANCE.reportTechnicalLog("core__http_execute", new Function0<Map<String, ? extends String>>() { // from class: com.taptap.sdk.db.event.TapEventQueue.flushAndWait.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends String> invoke() {
                return MapsKt.mapOf(TuplesKt.to(ImagesContract.URL, string2), TuplesKt.to("method", TapHttp.METHOD_POST), TuplesKt.to("requestUUID", string));
            }
        });
        TapEventQueue tapEventQueue2 = INSTANCE;
        if (Result.m187exceptionOrNullimpl(TapHttpExtKt.executeResult(TapHttpExtKt.toEventCall(tapEventQueue2.getHttp().postJson(URL_PATH).addBody(jSONObject)), new Function1<Boolean, Unit>() { // from class: com.taptap.sdk.db.event.TapEventQueue.flushAndWait.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("TapTapEvent report " + listObtainData$default.size() + " logs ↓ ↓ ↓\n");
                    Iterator<T> it2 = listObtainData$default.iterator();
                    while (it2.hasNext()) {
                        sb.append(new StringBuilder().append(((TapEventBean) it2.next()).getProperties()).append('\n').toString());
                    }
                    TapLogger.logi(TapLogger.TAG, sb.toString());
                } catch (Exception unused) {
                }
                TapEventQueue.INSTANCE.getStore().clearInFlightAndStats(false);
                if (TapEventQueue.INSTANCE.getStore().getAccumulatedDataCount() < 50 || TapEventQueue.scheduledFuture != null) {
                    return;
                }
                TapEventQueue tapEventQueue3 = TapEventQueue.INSTANCE;
                TapEventQueue.scheduledFuture = TapEventQueue.singleThreadExecutor.schedule(TapEventQueue.flushRunnable, 0L, TimeUnit.SECONDS);
            }
        })) != null) {
            tapEventQueue2.getStore().clearInFlightAndStats(true);
            TapLogger.loge$default(null, "TapTapSdk report failure, Wait for the next event and try again.", null, 5, null);
        }
    }

    public final void flush$tap_db_release() {
        singleThreadExecutor.execute(new Runnable() { // from class: com.taptap.sdk.db.event.TapEventQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                TapEventQueue.flushAndWait();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getHost() {
        int region = TapEventLogger.INSTANCE.getSdkOptions().getRegion();
        return (region == 0 || region != 1) ? HOST_CN : HOST_IO;
    }
}
