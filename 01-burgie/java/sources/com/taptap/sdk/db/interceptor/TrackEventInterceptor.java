package com.taptap.sdk.db.interceptor;

import android.support.v4.app.NotificationCompat;
import com.taptap.sdk.core.TapTapEvent;
import com.taptap.sdk.db.EventContext;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.model.EventType;
import com.taptap.sdk.db.data.model.WrapEvent;
import com.taptap.sdk.db.properties.AsyncPredefinedProvider;
import com.taptap.sdk.db.properties.NonCachedPredefinedProvider;
import com.taptap.sdk.db.utils.JSONObjectUtils;
import com.taptap.sdk.db.utils.MapUtils2;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TrackEventInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JF\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0015H\u0096@¢\u0006\u0002\u0010\u0016J,\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0018JF\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001aj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f`\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/db/interceptor/TrackEventInterceptor;", "Lcom/taptap/sdk/db/interceptor/Interceptor;", "Lcom/taptap/sdk/db/data/model/WrapEvent;", "Lcom/taptap/sdk/db/data/model/Event;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "buildNewEvent", NotificationCompat.CATEGORY_EVENT, "eventProperties", "", "", "", "userId", d.R, "Lcom/taptap/sdk/db/EventContext;", "isAutomatically", "", "(Lcom/taptap/sdk/db/data/model/Event;Ljava/util/Map;Ljava/lang/String;Lcom/taptap/sdk/db/EventContext;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "chain", "Lcom/taptap/sdk/db/interceptor/Interceptor$Chain;", "(Lcom/taptap/sdk/db/interceptor/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "providePredefinedProperties", "(Lcom/taptap/sdk/db/EventContext;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provideUserProperties", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "eventContext", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrackEventInterceptor implements Interceptor<WrapEvent, Event> {
    private final TapTapSdkOptions options;

    /* JADX INFO: compiled from: TrackEventInterceptor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.TRACK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.interceptor.TrackEventInterceptor$buildNewEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrackEventInterceptor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.interceptor.TrackEventInterceptor", f = "TrackEventInterceptor.kt", i = {0, 0, 0, 0, 0, 0}, l = {61}, m = "buildNewEvent", n = {"this", NotificationCompat.CATEGORY_EVENT, "eventProperties", d.R, "sendProperties", "tapSdkProperties"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrackEventInterceptor.this.buildNewEvent(null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.interceptor.TrackEventInterceptor$providePredefinedProperties$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrackEventInterceptor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.interceptor.TrackEventInterceptor", f = "TrackEventInterceptor.kt", i = {0, 0}, l = {90}, m = "providePredefinedProperties", n = {"properties1", "properties2"}, s = {"L$0", "L$1"})
    static final class C03371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03371(Continuation<? super C03371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrackEventInterceptor.this.providePredefinedProperties(null, false, this);
        }
    }

    public TrackEventInterceptor(TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
    }

    @Override // com.taptap.sdk.db.interceptor.Interceptor
    public Object intercept(Interceptor.Chain<WrapEvent, Event> chain, Continuation<? super Event> continuation) throws JSONException {
        WrapEvent request = chain.getRequest();
        if (request == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        WrapEvent originRequest = request;
        if (WhenMappings.$EnumSwitchMapping$0[originRequest.getEventType().ordinal()] == 1) {
            Event event = originRequest.getEvent();
            Map<String, Object> map = JSONObjectUtils.INSTANCE.toMap(originRequest.getEvent().getProperties());
            String userId = originRequest.getUserId();
            EventContext eventContext = originRequest.getEventContext();
            if (eventContext != null) {
                return buildNewEvent(event, map, userId, eventContext, originRequest.getIsAutomatically(), continuation);
            }
            throw new IllegalStateException("you must set EventContext by use TapDB#submitEvent method...".toString());
        }
        return chain.process(originRequest, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object buildNewEvent(Event event, Map<String, ? extends Object> map, String userId, EventContext eventContext, boolean isAutomatically, Continuation<? super Event> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        TrackEventInterceptor trackEventInterceptor;
        Map<String, ? extends Object> map2;
        EventContext context;
        Object objProvidePredefinedProperties;
        Map tapSdkProperties;
        Event event2;
        Map tapSdkProperties2;
        if (continuation instanceof AnonymousClass1) {
            AnonymousClass1 anonymousClass2 = (AnonymousClass1) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
                anonymousClass1 = anonymousClass2;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object $result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                trackEventInterceptor = this;
                map2 = map;
                context = eventContext;
                Map sendProperties = new HashMap();
                sendProperties.putAll(context.getSystemProvider().provide(event, userId));
                Map tapSdkProperties3 = MapsKt.emptyMap();
                boolean isAutomatically2 = isAutomatically;
                anonymousClass1.L$0 = trackEventInterceptor;
                anonymousClass1.L$1 = event;
                anonymousClass1.L$2 = map2;
                anonymousClass1.L$3 = context;
                anonymousClass1.L$4 = sendProperties;
                anonymousClass1.L$5 = tapSdkProperties3;
                anonymousClass1.label = 1;
                objProvidePredefinedProperties = trackEventInterceptor.providePredefinedProperties(context, isAutomatically2, anonymousClass1);
                if (objProvidePredefinedProperties == coroutine_suspended) {
                    return coroutine_suspended;
                }
                tapSdkProperties = tapSdkProperties3;
                event2 = event;
                tapSdkProperties2 = sendProperties;
                break;
                break;
            case 1:
                tapSdkProperties = (Map) anonymousClass1.L$5;
                tapSdkProperties2 = (HashMap) anonymousClass1.L$4;
                context = (EventContext) anonymousClass1.L$3;
                map2 = (Map) anonymousClass1.L$2;
                Event event3 = (Event) anonymousClass1.L$1;
                trackEventInterceptor = (TrackEventInterceptor) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result);
                objProvidePredefinedProperties = $result;
                event2 = event3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map predefinedProperties = (Map) objProvidePredefinedProperties;
        Map tapSdkProperties4 = MapsKt.plus(tapSdkProperties, predefinedProperties);
        Map predefinedProperties2 = trackEventInterceptor.provideUserProperties(context, map2);
        Map userProperties = predefinedProperties2;
        Pair pair = TuplesKt.to(Common.Predefined.PROPERTIES, trackEventInterceptor.options.getOverrideBuiltInParameters() ? false : true ? MapsKt.plus(userProperties, tapSdkProperties4) : MapsKt.plus(tapSdkProperties4, userProperties));
        tapSdkProperties2.put(pair.getFirst(), pair.getSecond());
        return Event.copy$default(event2, null, null, null, 0L, new JSONObject(tapSdkProperties2), 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object providePredefinedProperties(EventContext context, boolean isAutomatically, Continuation<? super Map<String, ? extends Object>> continuation) throws Throwable {
        C03371 c03371;
        Map<String, Object> cachedPredefinedProperties;
        Map<String, Object> mapProvide;
        Object objProvide;
        if (continuation instanceof C03371) {
            c03371 = (C03371) continuation;
            if ((c03371.label & Integer.MIN_VALUE) != 0) {
                c03371.label -= Integer.MIN_VALUE;
            } else {
                c03371 = new C03371(continuation);
            }
        } else {
            c03371 = new C03371(continuation);
        }
        C03371 c03372 = c03371;
        Object $result = c03372.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03372.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                cachedPredefinedProperties = context.getCachedPredefinedProperties();
                NonCachedPredefinedProvider nonCachedPredefinedProvider = context.getNonCachedPredefinedProvider();
                boolean isAutomatically2 = isAutomatically;
                mapProvide = nonCachedPredefinedProvider.provide(context, isAutomatically2);
                AsyncPredefinedProvider asyncPredefinedProvider = context.getAsyncPredefinedProvider();
                c03372.L$0 = cachedPredefinedProperties;
                c03372.L$1 = mapProvide;
                c03372.label = 1;
                objProvide = asyncPredefinedProvider.provide(c03372);
                if (objProvide == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                Map<String, Object> map = (Map) c03372.L$1;
                Map<String, Object> map2 = (Map) c03372.L$0;
                ResultKt.throwOnFailure($result);
                cachedPredefinedProperties = map2;
                mapProvide = map;
                objProvide = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map properties3 = (Map) objProvide;
        return MapsKt.plus(MapsKt.plus(cachedPredefinedProperties, mapProvide), properties3);
    }

    private static final Map<String, Object> provideUserProperties$provideDynamicProperties(TapTapEvent.TapEventDynamicProperties propertiesGetter) {
        JSONObject dynamicProperties;
        Map<String, Object> map;
        if (propertiesGetter != null && (dynamicProperties = propertiesGetter.getDynamicProperties()) != null && (map = JSONObjectUtils.INSTANCE.toMap(dynamicProperties)) != null) {
            return map;
        }
        return MapsKt.emptyMap();
    }

    private final HashMap<String, Object> provideUserProperties(EventContext eventContext, Map<String, ? extends Object> eventProperties) {
        HashMap<String, Object> map = new HashMap<>();
        map.putAll(eventContext.getCustomExtras());
        map.putAll(MapUtils2.filterRecursively$default(MapUtils2.INSTANCE, provideUserProperties$provideDynamicProperties(eventContext.getDynamicPropertiesGetter()), null, 1, null));
        map.putAll(eventProperties);
        return map;
    }
}
