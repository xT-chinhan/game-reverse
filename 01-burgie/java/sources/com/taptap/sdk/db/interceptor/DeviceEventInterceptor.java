package com.taptap.sdk.db.interceptor;

import android.support.v4.app.NotificationCompat;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.model.EventType;
import com.taptap.sdk.db.data.model.WrapEvent;
import com.taptap.sdk.db.utils.JSONObjectUtils;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceEventInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0002J\"\u0010\r\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/db/interceptor/DeviceEventInterceptor;", "Lcom/taptap/sdk/db/interceptor/Interceptor;", "Lcom/taptap/sdk/db/data/model/WrapEvent;", "Lcom/taptap/sdk/db/data/model/Event;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "buildNewEvent", NotificationCompat.CATEGORY_EVENT, "eventProperties", "", "", "", "intercept", "chain", "Lcom/taptap/sdk/db/interceptor/Interceptor$Chain;", "(Lcom/taptap/sdk/db/interceptor/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceEventInterceptor implements Interceptor<WrapEvent, Event> {
    private final TapTapSdkOptions options;

    /* JADX INFO: compiled from: DeviceEventInterceptor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.DEVICE_INITIALISE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.DEVICE_UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.DEVICE_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DeviceEventInterceptor(TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
    }

    @Override // com.taptap.sdk.db.interceptor.Interceptor
    public Object intercept(Interceptor.Chain<WrapEvent, Event> chain, Continuation<? super Event> continuation) {
        WrapEvent request = chain.getRequest();
        if (request == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        WrapEvent originRequest = request;
        switch (WhenMappings.$EnumSwitchMapping$0[originRequest.getEventType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return buildNewEvent(originRequest.getEvent(), JSONObjectUtils.INSTANCE.toMap(originRequest.getEvent().getProperties()));
            default:
                return chain.process(originRequest, continuation);
        }
    }

    private final Event buildNewEvent(Event event, Map<String, ? extends Object> eventProperties) {
        HashMap sendProperties = new HashMap();
        Pair pair = TuplesKt.to("type", event.getType());
        sendProperties.put(pair.getFirst(), pair.getSecond());
        Pair pair2 = TuplesKt.to("client_id", this.options.getClientId());
        sendProperties.put(pair2.getFirst(), pair2.getSecond());
        Pair pair3 = TuplesKt.to("device_id", TapIdentifierUtil.INSTANCE.getDeviceId(this.options.getContext()));
        sendProperties.put(pair3.getFirst(), pair3.getSecond());
        HashMap properties = new HashMap();
        properties.putAll(eventProperties);
        Pair pair4 = TuplesKt.to(Common.Predefined.PROPERTIES, properties);
        sendProperties.put(pair4.getFirst(), pair4.getSecond());
        return Event.copy$default(event, null, null, null, 0L, new JSONObject(sendProperties), 13, null);
    }
}
