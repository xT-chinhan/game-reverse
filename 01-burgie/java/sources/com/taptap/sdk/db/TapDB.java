package com.taptap.sdk.db;

import android.content.SharedPreferences;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker;
import com.taptap.sdk.common.gaid.GAIDManager;
import com.taptap.sdk.common.gaid.data.model.GAID;
import com.taptap.sdk.common.network.NetworkClientKt;
import com.taptap.sdk.common.oaid.OAIDManager;
import com.taptap.sdk.core.TapTapEvent;
import com.taptap.sdk.db.biz.gameplay.GameDurationService;
import com.taptap.sdk.db.biz.gameplay.reporter.DefaultGameDurationReporter;
import com.taptap.sdk.db.biz.gameplay.storage.PrefsGameDurationStorage;
import com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker;
import com.taptap.sdk.db.biz.iap.IAPService;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.model.WrapEvent;
import com.taptap.sdk.db.interceptor.Interceptor;
import com.taptap.sdk.db.interceptor.RealChain;
import com.taptap.sdk.db.processor.EventProcessor;
import com.taptap.sdk.db.properties.AsyncPredefinedProvider;
import com.taptap.sdk.db.properties.CachedPredefinedProvider;
import com.taptap.sdk.db.properties.NonCachedPredefinedProvider;
import com.taptap.sdk.db.properties.SystemProvider;
import com.taptap.sdk.db.repository.EventApi;
import com.taptap.sdk.db.repository.EventRepository;
import com.taptap.sdk.db.storage.PersistentQueue;
import com.taptap.sdk.db.utils.MapUtils2;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.retrofit2.Retrofit;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: TapDB.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 n2\u00020\u0001:\u0002mnB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BQ\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u0012¢\u0006\u0002\u0010\u0016J\u001c\u0010O\u001a\u00020P2\u0014\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aJ\u0006\u0010R\u001a\u00020PJ\u0014\u0010S\u001a\u00020P2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001b0UJ\b\u0010V\u001a\u0004\u0018\u00010\u001bJ\b\u0010W\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010X\u001a\u0004\u0018\u00010\u001bH\u0086@¢\u0006\u0002\u0010YJ\u0010\u0010Z\u001a\u0004\u0018\u00010\u001bH\u0086@¢\u0006\u0002\u0010YJ\b\u0010[\u001a\u00020PH\u0002J\b\u0010\\\u001a\u00020PH\u0002J\u001c\u0010]\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u001b2\b\u0010_\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010`\u001a\u00020PH\u0002J\b\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020P2\b\u0010d\u001a\u0004\u0018\u000104J\u0010\u0010e\u001a\u00020P2\b\u0010f\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010g\u001a\u00020P2\b\u0010h\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010i\u001a\u00020P2\u0006\u0010j\u001a\u00020\u0014J\u0016\u0010k\u001a\u00020P2\u0006\u0010j\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010lR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010&\u001a\u0004\u0018\u00010\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u001c\u00100\u001a\u0004\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\u001c\u00103\u001a\u0004\u0018\u000104X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020<X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010(R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010N¨\u0006o"}, d2 = {"Lcom/taptap/sdk/db/TapDB;", "Lcom/taptap/sdk/db/EventContext;", "builder", "Lcom/taptap/sdk/db/TapDB$Builder;", "(Lcom/taptap/sdk/db/TapDB$Builder;)V", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "config", "Lcom/taptap/sdk/db/processor/EventProcessor$Config;", "cachedPredefinedProvider", "Lcom/taptap/sdk/db/properties/CachedPredefinedProvider;", "nonCachedPredefinedProvider", "Lcom/taptap/sdk/db/properties/NonCachedPredefinedProvider;", "asyncPredefinedProvider", "Lcom/taptap/sdk/db/properties/AsyncPredefinedProvider;", "systemProvider", "Lcom/taptap/sdk/db/properties/SystemProvider;", "interceptors", "", "Lcom/taptap/sdk/db/interceptor/Interceptor;", "Lcom/taptap/sdk/db/data/model/WrapEvent;", "Lcom/taptap/sdk/db/data/model/Event;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;Lcom/taptap/sdk/db/processor/EventProcessor$Config;Lcom/taptap/sdk/db/properties/CachedPredefinedProvider;Lcom/taptap/sdk/db/properties/NonCachedPredefinedProvider;Lcom/taptap/sdk/db/properties/AsyncPredefinedProvider;Lcom/taptap/sdk/db/properties/SystemProvider;Ljava/util/List;)V", "getAsyncPredefinedProvider", "()Lcom/taptap/sdk/db/properties/AsyncPredefinedProvider;", "cachedPredefinedProperties", "", "", "", "getCachedPredefinedProperties", "()Ljava/util/Map;", "setCachedPredefinedProperties", "(Ljava/util/Map;)V", "chain", "Lcom/taptap/sdk/db/interceptor/RealChain;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "currentUserId", "getCurrentUserId", "()Ljava/lang/String;", "setCurrentUserId", "(Ljava/lang/String;)V", "currentUserId$delegate", "Lkotlin/properties/ReadWriteProperty;", "customExtras", "getCustomExtras", "setCustomExtras", "customOAID", "getCustomOAID", "setCustomOAID", "dynamicPropertiesGetter", "Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;", "getDynamicPropertiesGetter", "()Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;", "setDynamicPropertiesGetter", "(Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;)V", "eventChannel", "Lkotlinx/coroutines/channels/Channel;", "eventIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "getEventIndex", "()Ljava/util/concurrent/atomic/AtomicLong;", "setEventIndex", "(Ljava/util/concurrent/atomic/AtomicLong;)V", "eventProcessor", "Lcom/taptap/sdk/db/processor/EventProcessor;", "gameDurationService", "Lcom/taptap/sdk/db/biz/gameplay/GameDurationService;", "iapService", "Lcom/taptap/sdk/db/biz/iap/IAPService;", "getInterceptors", "()Ljava/util/List;", "getNonCachedPredefinedProvider", "()Lcom/taptap/sdk/db/properties/NonCachedPredefinedProvider;", "sessionId", "getSessionId", "getSystemProvider", "()Lcom/taptap/sdk/db/properties/SystemProvider;", "addCommon", "", Common.Predefined.PROPERTIES, "clearAllCommonProperties", "clearCommonProperties", "keys", "", "getCurrentGAID", "getCurrentOAID", "getGAID", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOAID", "initializeEventChannelConsumer", "initializeServices", "onUserIdChange", "oldValue", "newValue", "preWarmDeviceInfoCache", "provideNetworkApi", "Lcom/taptap/sdk/db/repository/EventApi;", "registerDynamicPropertiesGetter", "propertiesGetter", "setOAID", Constants.VALUE_FIELD, "setUserId", "userId", "submitEvent", "wrapEvent", "submitEventInternal", "(Lcom/taptap/sdk/db/data/model/WrapEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Builder", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapDB implements EventContext {
    private static final String TAG = "TapDB";
    private static volatile boolean _isInstanceInitialized;
    private static volatile Builder tapDBBuilder;
    private final AsyncPredefinedProvider asyncPredefinedProvider;
    private Map<String, ? extends Object> cachedPredefinedProperties;
    private final CachedPredefinedProvider cachedPredefinedProvider;
    private final RealChain<WrapEvent, Event> chain;
    private final EventProcessor.Config config;
    private final CoroutineScope coroutineScope;

    /* JADX INFO: renamed from: currentUserId$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty currentUserId;
    private Map<String, ? extends Object> customExtras;
    private String customOAID;
    private TapTapEvent.TapEventDynamicProperties dynamicPropertiesGetter;
    private final Channel<WrapEvent> eventChannel;
    private AtomicLong eventIndex;
    private final EventProcessor eventProcessor;
    private GameDurationService gameDurationService;
    private IAPService iapService;
    private final List<Interceptor<WrapEvent, Event>> interceptors;
    private final NonCachedPredefinedProvider nonCachedPredefinedProvider;
    private final TapTapSdkOptions options;
    private final String sessionId;
    private final SystemProvider systemProvider;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TapDB.class, "currentUserId", "getCurrentUserId()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReadWriteProperty<Object, TapTapSdkOptions> options$delegate = Delegates.INSTANCE.notNull();
    private static final Lazy<TapDB> INSTANCE$delegate = LazyKt.lazy(new Function0<TapDB>() { // from class: com.taptap.sdk.db.TapDB$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TapDB invoke() {
            TapDB.Builder builder = TapDB.tapDBBuilder;
            if (builder == null) {
                throw new IllegalStateException("TapDB is not configured, please call TapDB.configure(Builder) first".toString());
            }
            TapDB instance = new TapDB(builder, null);
            instance.initializeEventChannelConsumer();
            instance.initializeServices();
            TapDB.Companion companion = TapDB.INSTANCE;
            TapDB._isInstanceInitialized = true;
            return instance;
        }
    });

    /* JADX INFO: compiled from: TapDB.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegionType.values().length];
            try {
                iArr[RegionType.CN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RegionType.GLOBAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.TapDB$getGAID$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapDB.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.TapDB", f = "TapDB.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS}, m = "getGAID", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapDB.this.getGAID(this);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.TapDB$submitEventInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapDB.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.TapDB", f = "TapDB.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME}, m = "submitEventInternal", n = {"this"}, s = {"L$0"})
    static final class C03281 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03281(Continuation<? super C03281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapDB.this.submitEventInternal(null, this);
        }
    }

    public /* synthetic */ TapDB(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TapDB(TapTapSdkOptions options, EventProcessor.Config config, CachedPredefinedProvider cachedPredefinedProvider, NonCachedPredefinedProvider nonCachedPredefinedProvider, AsyncPredefinedProvider asyncPredefinedProvider, SystemProvider systemProvider, List<? extends Interceptor<WrapEvent, Event>> list) {
        this.options = options;
        this.config = config;
        this.cachedPredefinedProvider = cachedPredefinedProvider;
        this.nonCachedPredefinedProvider = nonCachedPredefinedProvider;
        this.asyncPredefinedProvider = asyncPredefinedProvider;
        this.systemProvider = systemProvider;
        this.interceptors = list;
        this.coroutineScope = config.getCoroutineScope();
        Delegates delegates = Delegates.INSTANCE;
        final Object initialValue$iv = null;
        this.currentUserId = new ObservableProperty<String>(initialValue$iv) { // from class: com.taptap.sdk.db.TapDB$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TapDB tapDB = this;
                tapDB.onUserIdChange(oldValue, newValue);
            }
        };
        this.cachedPredefinedProperties = MapsKt.emptyMap();
        this.customExtras = MapsKt.emptyMap();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.sessionId = string;
        this.eventIndex = new AtomicLong(0L);
        this.eventProcessor = new EventProcessor(config, new EventRepository(new PersistentQueue(config), provideNetworkApi()));
        this.eventChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.chain = new RealChain<>(getInterceptors(), 0, null, 6, null);
    }

    @Override // com.taptap.sdk.db.EventContext
    public NonCachedPredefinedProvider getNonCachedPredefinedProvider() {
        return this.nonCachedPredefinedProvider;
    }

    @Override // com.taptap.sdk.db.EventContext
    public AsyncPredefinedProvider getAsyncPredefinedProvider() {
        return this.asyncPredefinedProvider;
    }

    @Override // com.taptap.sdk.db.EventContext
    public SystemProvider getSystemProvider() {
        return this.systemProvider;
    }

    @Override // com.taptap.sdk.db.EventContext
    public List<Interceptor<WrapEvent, Event>> getInterceptors() {
        return this.interceptors;
    }

    @Override // com.taptap.sdk.db.EventContext
    public String getCustomOAID() {
        return this.customOAID;
    }

    @Override // com.taptap.sdk.db.EventContext
    public void setCustomOAID(String str) {
        this.customOAID = str;
    }

    @Override // com.taptap.sdk.db.EventContext
    public String getCurrentUserId() {
        return (String) this.currentUserId.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.taptap.sdk.db.EventContext
    public void setCurrentUserId(String str) {
        this.currentUserId.setValue(this, $$delegatedProperties[0], str);
    }

    @Override // com.taptap.sdk.db.EventContext
    public Map<String, Object> getCachedPredefinedProperties() {
        return this.cachedPredefinedProperties;
    }

    @Override // com.taptap.sdk.db.EventContext
    public void setCachedPredefinedProperties(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.cachedPredefinedProperties = map;
    }

    @Override // com.taptap.sdk.db.EventContext
    public Map<String, Object> getCustomExtras() {
        return this.customExtras;
    }

    @Override // com.taptap.sdk.db.EventContext
    public void setCustomExtras(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.customExtras = map;
    }

    @Override // com.taptap.sdk.db.EventContext
    public TapTapEvent.TapEventDynamicProperties getDynamicPropertiesGetter() {
        return this.dynamicPropertiesGetter;
    }

    @Override // com.taptap.sdk.db.EventContext
    public void setDynamicPropertiesGetter(TapTapEvent.TapEventDynamicProperties tapEventDynamicProperties) {
        this.dynamicPropertiesGetter = tapEventDynamicProperties;
    }

    @Override // com.taptap.sdk.db.EventContext
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.taptap.sdk.db.EventContext
    public AtomicLong getEventIndex() {
        return this.eventIndex;
    }

    @Override // com.taptap.sdk.db.EventContext
    public void setEventIndex(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, "<set-?>");
        this.eventIndex = atomicLong;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private TapDB(Builder builder) {
        TapTapSdkOptions options = builder.getOptions();
        EventProcessor.Config config = builder.getConfig();
        if (config == null) {
            throw new IllegalStateException("you must set config for TapDB".toString());
        }
        List<Interceptor<WrapEvent, Event>> interceptors$tap_db_release = builder.getInterceptors$tap_db_release();
        SystemProvider systemProvider = builder.getSystemProvider();
        if (systemProvider == null) {
            throw new IllegalStateException("you must set systemProvider for TapDB".toString());
        }
        CachedPredefinedProvider cachedPredefinedProvider = builder.getCachedPredefinedProvider();
        if (cachedPredefinedProvider == null) {
            throw new IllegalStateException("you must set cachedPredefinedProvider for TapDB".toString());
        }
        NonCachedPredefinedProvider nonCachedPredefinedProvider = builder.getNonCachedPredefinedProvider();
        if (nonCachedPredefinedProvider == null) {
            throw new IllegalStateException("you must set nonCachedPredefinedProvider for TapDB".toString());
        }
        AsyncPredefinedProvider asyncPredefinedProvider = builder.getAsyncPredefinedProvider();
        if (asyncPredefinedProvider == null) {
            throw new IllegalStateException("you must set asyncPredefinedProvider for TapDB".toString());
        }
        this(options, config, cachedPredefinedProvider, nonCachedPredefinedProvider, asyncPredefinedProvider, systemProvider, interceptors$tap_db_release);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.TapDB$initializeEventChannelConsumer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapDB.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.TapDB$initializeEventChannelConsumer$1", f = "TapDB.kt", i = {0, 1, 1}, l = {580, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv", "wrapEvent"}, s = {"L$1", "L$1", "L$3"})
    static final class C03271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C03271(Continuation<? super C03271> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TapDB.this.new C03271(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0089 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x008a  */
        /* JADX WARN: Code duplicated, block: B:24:0x0096 A[Catch: all -> 0x010b, TRY_LEAVE, TryCatch #5 {all -> 0x010b, blocks: (B:22:0x008e, B:24:0x0096), top: B:59:0x008e }] */
        /* JADX WARN: Code duplicated, block: B:28:0x00b1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x00b2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b2 -> B:30:0x00bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00f1 -> B:35:0x00f9). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taptap.sdk.db.TapDB.C03271.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeEventChannelConsumer() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03271(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeServices() {
        INSTANCE.setOptions$tap_db_release(this.options);
        if (!this.options.getEnableTapTapEvent()) {
            return;
        }
        preWarmDeviceInfoCache();
        this.eventProcessor.flushEvents();
        GameDurationService.Builder builder = new GameDurationService.Builder(this.options.getContext());
        SharedPreferences sharedPreferences = this.options.getContext().getSharedPreferences(PrefsGameDurationStorage.SP_FILE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "options.context.getShare…                        )");
        this.gameDurationService = builder.setTracker(new DefaultGameDurationTracker(new PrefsGameDurationStorage(sharedPreferences, Json.INSTANCE), new DefaultGameDurationReporter(), TapActivityLifecycleTracker.INSTANCE, this)).build().initialize();
        this.iapService = new IAPService.Builder(this.options).build().initialize();
    }

    private final void preWarmDeviceInfoCache() {
        setCachedPredefinedProperties(this.cachedPredefinedProvider.provide());
    }

    public final void submitEvent(WrapEvent wrapEvent) {
        Intrinsics.checkNotNullParameter(wrapEvent, "wrapEvent");
        if (!INSTANCE.checkEnable()) {
            return;
        }
        Object result = this.eventChannel.mo2031trySendJP2dKIU(wrapEvent);
        if (ChannelResult.m2045isFailureimpl(result)) {
            Log.e(TAG, "Failed to enqueue wrapEvent: " + wrapEvent.getEvent().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0068 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object submitEventInternal(WrapEvent wrapEvent, Continuation<? super Unit> continuation) throws Exception {
        C03281 c03281;
        final TapDB tapDB;
        Object objProcess;
        Event event;
        EventProcessor eventProcessor;
        if (continuation instanceof C03281) {
            c03281 = (C03281) continuation;
            if ((c03281.label & Integer.MIN_VALUE) != 0) {
                c03281.label -= Integer.MIN_VALUE;
            } else {
                c03281 = new C03281(continuation);
            }
        } else {
            c03281 = new C03281(continuation);
        }
        C03281 c03282 = c03281;
        Object $result = c03282.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03282.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                tapDB = this;
                RealChain<WrapEvent, Event> realChain = tapDB.chain;
                WrapEvent wrapEventNewBuilder = wrapEvent.newBuilder(new Function1<WrapEvent.Builder, Unit>() { // from class: com.taptap.sdk.db.TapDB$submitEventInternal$event$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WrapEvent.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WrapEvent.Builder newBuilder) {
                        Intrinsics.checkNotNullParameter(newBuilder, "$this$newBuilder");
                        String userId = newBuilder.getUserId();
                        if (userId == null) {
                            userId = this.this$0.getCurrentUserId();
                        }
                        newBuilder.setUserId(userId);
                        newBuilder.setEventContext(this.this$0);
                    }
                });
                c03282.L$0 = tapDB;
                c03282.label = 1;
                objProcess = realChain.process(wrapEventNewBuilder, c03282);
                if (objProcess == coroutine_suspended) {
                    return coroutine_suspended;
                }
                event = (Event) objProcess;
                eventProcessor = tapDB.eventProcessor;
                c03282.L$0 = null;
                c03282.label = 2;
                if (eventProcessor.submitEvent(event, c03282) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                TapDB tapDB2 = (TapDB) c03282.L$0;
                ResultKt.throwOnFailure($result);
                tapDB = tapDB2;
                objProcess = $result;
                event = (Event) objProcess;
                eventProcessor = tapDB.eventProcessor;
                c03282.L$0 = null;
                c03282.label = 2;
                if (eventProcessor.submitEvent(event, c03282) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setUserId(String userId) {
        setCurrentUserId(userId);
    }

    public final void setOAID(String value) {
        if (!this.options.getDisableReflectionOAID()) {
            Log.e(TAG, "setOAID is not allowed when disableReflectionOAID is false");
        }
        setCustomOAID(value);
    }

    public final void addCommon(Map<String, ? extends Object> properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        setCustomExtras(MapsKt.plus(getCustomExtras(), MapUtils2.filterRecursively$default(MapUtils2.INSTANCE, properties, null, 1, null)));
    }

    public final void registerDynamicPropertiesGetter(TapTapEvent.TapEventDynamicProperties propertiesGetter) {
        setDynamicPropertiesGetter(propertiesGetter);
    }

    public final void clearCommonProperties(Set<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Map<String, Object> customExtras = getCustomExtras();
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : customExtras.entrySet()) {
            String it = entry.getKey();
            if (!keys.contains(it)) {
                result$iv.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap $this$filterKeys$iv = result$iv;
        setCustomExtras($this$filterKeys$iv);
    }

    public final void clearAllCommonProperties() {
        setCustomExtras(MapsKt.emptyMap());
    }

    public final Object getOAID(Continuation<? super String> continuation) {
        if (!this.options.getDisableReflectionOAID()) {
            return OAIDManager.INSTANCE.getInstance().getOAID(continuation);
        }
        return getCustomOAID();
    }

    public final String getCurrentOAID() {
        if (!this.options.getDisableReflectionOAID()) {
            return OAIDManager.INSTANCE.getInstance().getCurrentOAID();
        }
        return getCustomOAID();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getGAID(Continuation<? super String> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object gaid;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                GAIDManager companion = GAIDManager.INSTANCE.getInstance();
                anonymousClass2.label = 1;
                gaid = companion.getGAID(anonymousClass2);
                if (gaid == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                gaid = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GAID gaid2 = (GAID) gaid;
        if (gaid2 == null) {
            return null;
        }
        return gaid2.getAndroidAdvertiserIdValue();
    }

    public final String getCurrentGAID() {
        GAID gaid = GAIDManager.INSTANCE.getInstance().getCurrentGAID();
        if (gaid == null) {
            return null;
        }
        return gaid.getAndroidAdvertiserIdValue();
    }

    private static final String provideNetworkApi$getBaseUrl(TapDB this$0) {
        switch (WhenMappings.$EnumSwitchMapping$0[this$0.options.getRegion().ordinal()]) {
            case 1:
                return "https://e.tapdb.net";
            case 2:
                return "https://e.tapdb.ap-sg.tapapis.com";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final EventApi provideNetworkApi() {
        Retrofit retrofit = NetworkClientKt.provideRetrofitForTapDB(provideNetworkApi$getBaseUrl(this));
        Object objCreate = retrofit.create(EventApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "retrofit.create(EventApi::class.java)");
        return (EventApi) objCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUserIdChange(String oldValue, String newValue) {
        GameDurationService gameDurationService;
        GameDurationService gameDurationService2;
        Log.d(TAG, "userId changed from " + oldValue + " to " + newValue);
        if (oldValue != null && !Intrinsics.areEqual(oldValue, newValue) && (gameDurationService2 = this.gameDurationService) != null) {
            gameDurationService2.submitOldUserGameDuration(oldValue, newValue);
        }
        String currentUserId = getCurrentUserId();
        if ((currentUserId == null || currentUserId.length() == 0) || (gameDurationService = this.gameDurationService) == null) {
            return;
        }
        gameDurationService.setUserStartTimeAtInMillis(System.currentTimeMillis());
    }

    /* JADX INFO: compiled from: TapDB.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010#\u001a\u00020\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001fR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011RB\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u00122\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u0012@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u0019@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006-"}, d2 = {"Lcom/taptap/sdk/db/TapDB$Builder;", "", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "<set-?>", "Lcom/taptap/sdk/db/properties/AsyncPredefinedProvider;", "asyncPredefinedProvider", "getAsyncPredefinedProvider$tap_db_release", "()Lcom/taptap/sdk/db/properties/AsyncPredefinedProvider;", "Lcom/taptap/sdk/db/properties/CachedPredefinedProvider;", "cachedPredefinedProvider", "getCachedPredefinedProvider$tap_db_release", "()Lcom/taptap/sdk/db/properties/CachedPredefinedProvider;", "Lcom/taptap/sdk/db/processor/EventProcessor$Config;", "config", "getConfig$tap_db_release", "()Lcom/taptap/sdk/db/processor/EventProcessor$Config;", "", "Lcom/taptap/sdk/db/interceptor/Interceptor;", "Lcom/taptap/sdk/db/data/model/WrapEvent;", "Lcom/taptap/sdk/db/data/model/Event;", "interceptors", "getInterceptors$tap_db_release", "()Ljava/util/List;", "Lcom/taptap/sdk/db/properties/NonCachedPredefinedProvider;", "nonCachedPredefinedProvider", "getNonCachedPredefinedProvider$tap_db_release", "()Lcom/taptap/sdk/db/properties/NonCachedPredefinedProvider;", "getOptions", "()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "Lcom/taptap/sdk/db/properties/SystemProvider;", "systemProvider", "getSystemProvider$tap_db_release", "()Lcom/taptap/sdk/db/properties/SystemProvider;", "addInterceptor", "interceptor", "applyConfig", "build", "Lcom/taptap/sdk/db/TapDB;", "setAsyncPredefinedProvider", "provider", "setCachedPredefinedProvider", "setNonCachedPredefinedProvider", "setSystemProvider", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private AsyncPredefinedProvider asyncPredefinedProvider;
        private CachedPredefinedProvider cachedPredefinedProvider;
        private EventProcessor.Config config;
        private List<? extends Interceptor<WrapEvent, Event>> interceptors;
        private NonCachedPredefinedProvider nonCachedPredefinedProvider;
        private final TapTapSdkOptions options;
        private SystemProvider systemProvider;

        public Builder(TapTapSdkOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.options = options;
            this.interceptors = CollectionsKt.emptyList();
        }

        public final TapTapSdkOptions getOptions() {
            return this.options;
        }

        /* JADX INFO: renamed from: getConfig$tap_db_release, reason: from getter */
        public final EventProcessor.Config getConfig() {
            return this.config;
        }

        public final List<Interceptor<WrapEvent, Event>> getInterceptors$tap_db_release() {
            return this.interceptors;
        }

        /* JADX INFO: renamed from: getCachedPredefinedProvider$tap_db_release, reason: from getter */
        public final CachedPredefinedProvider getCachedPredefinedProvider() {
            return this.cachedPredefinedProvider;
        }

        /* JADX INFO: renamed from: getNonCachedPredefinedProvider$tap_db_release, reason: from getter */
        public final NonCachedPredefinedProvider getNonCachedPredefinedProvider() {
            return this.nonCachedPredefinedProvider;
        }

        /* JADX INFO: renamed from: getAsyncPredefinedProvider$tap_db_release, reason: from getter */
        public final AsyncPredefinedProvider getAsyncPredefinedProvider() {
            return this.asyncPredefinedProvider;
        }

        /* JADX INFO: renamed from: getSystemProvider$tap_db_release, reason: from getter */
        public final SystemProvider getSystemProvider() {
            return this.systemProvider;
        }

        public final Builder applyConfig(EventProcessor.Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            Builder $this$applyConfig_u24lambda_u240 = this;
            $this$applyConfig_u24lambda_u240.config = config;
            return this;
        }

        public final Builder addInterceptor(Interceptor<WrapEvent, Event> interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            Builder $this$addInterceptor_u24lambda_u241 = this;
            $this$addInterceptor_u24lambda_u241.interceptors = CollectionsKt.plus((Collection<? extends Interceptor<WrapEvent, Event>>) $this$addInterceptor_u24lambda_u241.interceptors, interceptor);
            return this;
        }

        public final Builder setCachedPredefinedProvider(CachedPredefinedProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            Builder $this$setCachedPredefinedProvider_u24lambda_u242 = this;
            $this$setCachedPredefinedProvider_u24lambda_u242.cachedPredefinedProvider = provider;
            return this;
        }

        public final Builder setNonCachedPredefinedProvider(NonCachedPredefinedProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            Builder $this$setNonCachedPredefinedProvider_u24lambda_u243 = this;
            $this$setNonCachedPredefinedProvider_u24lambda_u243.nonCachedPredefinedProvider = provider;
            return this;
        }

        public final Builder setAsyncPredefinedProvider(AsyncPredefinedProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            Builder $this$setAsyncPredefinedProvider_u24lambda_u244 = this;
            $this$setAsyncPredefinedProvider_u24lambda_u244.asyncPredefinedProvider = provider;
            return this;
        }

        public final Builder setSystemProvider(SystemProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            Builder $this$setSystemProvider_u24lambda_u245 = this;
            $this$setSystemProvider_u24lambda_u245.systemProvider = provider;
            return this;
        }

        public final TapDB build() {
            return new TapDB(this, null);
        }
    }

    /* JADX INFO: compiled from: TapDB.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0017R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/taptap/sdk/db/TapDB$Companion;", "", "()V", "INSTANCE", "Lcom/taptap/sdk/db/TapDB;", "getINSTANCE", "()Lcom/taptap/sdk/db/TapDB;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "_isInstanceInitialized", "", "<set-?>", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "options", "getOptions$tap_db_release", "()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "setOptions$tap_db_release", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "options$delegate", "Lkotlin/properties/ReadWriteProperty;", "tapDBBuilder", "Lcom/taptap/sdk/db/TapDB$Builder;", "checkEnable", "configure", "", "builder", "getInstance", "initialize", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "options", "getOptions$tap_db_release()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TapTapSdkOptions getOptions$tap_db_release() {
            return (TapTapSdkOptions) TapDB.options$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final void setOptions$tap_db_release(TapTapSdkOptions tapTapSdkOptions) {
            Intrinsics.checkNotNullParameter(tapTapSdkOptions, "<set-?>");
            TapDB.options$delegate.setValue(this, $$delegatedProperties[0], tapTapSdkOptions);
        }

        private final TapDB getINSTANCE() {
            return (TapDB) TapDB.INSTANCE$delegate.getValue();
        }

        private final void configure(Builder builder) {
            if (TapDB.tapDBBuilder == null) {
                TapDB.tapDBBuilder = builder;
            } else {
                TapLogger.logw$default(TapDB.TAG, "TapDB is already configured, ignoring subsequent configuration", false, 4, null);
            }
        }

        public final TapDB getInstance() {
            return getINSTANCE();
        }

        public final boolean checkEnable() {
            if (TapTapKit.INSTANCE.isInitialized() && !TapTapKit.INSTANCE.getSdkOptions().getEnableTapTapEvent()) {
                TapLogger.loge$default(TapDB.TAG, TapTapKit.INSTANCE.getContext().getString(R.string.tap_event_switch_tips), null, 4, null);
                return false;
            }
            return true;
        }

        public final TapDB initialize(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            configure(builder);
            return getInstance();
        }
    }
}
