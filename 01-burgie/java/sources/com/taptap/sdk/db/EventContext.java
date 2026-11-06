package com.taptap.sdk.db;

import com.taptap.sdk.core.TapTapEvent;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.model.WrapEvent;
import com.taptap.sdk.db.interceptor.Interceptor;
import com.taptap.sdk.db.properties.AsyncPredefinedProvider;
import com.taptap.sdk.db.properties.NonCachedPredefinedProvider;
import com.taptap.sdk.db.properties.SystemProvider;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R&\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u00020\u001fX¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&0%X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u000fR\u0012\u00101\u001a\u000202X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/taptap/sdk/db/EventContext;", "", "asyncPredefinedProvider", "Lcom/taptap/sdk/db/properties/AsyncPredefinedProvider;", "getAsyncPredefinedProvider", "()Lcom/taptap/sdk/db/properties/AsyncPredefinedProvider;", "cachedPredefinedProperties", "", "", "getCachedPredefinedProperties", "()Ljava/util/Map;", "setCachedPredefinedProperties", "(Ljava/util/Map;)V", "currentUserId", "getCurrentUserId", "()Ljava/lang/String;", "setCurrentUserId", "(Ljava/lang/String;)V", "customExtras", "getCustomExtras", "setCustomExtras", "customOAID", "getCustomOAID", "setCustomOAID", "dynamicPropertiesGetter", "Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;", "getDynamicPropertiesGetter", "()Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;", "setDynamicPropertiesGetter", "(Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;)V", "eventIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "getEventIndex", "()Ljava/util/concurrent/atomic/AtomicLong;", "setEventIndex", "(Ljava/util/concurrent/atomic/AtomicLong;)V", "interceptors", "", "Lcom/taptap/sdk/db/interceptor/Interceptor;", "Lcom/taptap/sdk/db/data/model/WrapEvent;", "Lcom/taptap/sdk/db/data/model/Event;", "getInterceptors", "()Ljava/util/List;", "nonCachedPredefinedProvider", "Lcom/taptap/sdk/db/properties/NonCachedPredefinedProvider;", "getNonCachedPredefinedProvider", "()Lcom/taptap/sdk/db/properties/NonCachedPredefinedProvider;", "sessionId", "getSessionId", "systemProvider", "Lcom/taptap/sdk/db/properties/SystemProvider;", "getSystemProvider", "()Lcom/taptap/sdk/db/properties/SystemProvider;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface EventContext {
    AsyncPredefinedProvider getAsyncPredefinedProvider();

    Map<String, Object> getCachedPredefinedProperties();

    String getCurrentUserId();

    Map<String, Object> getCustomExtras();

    String getCustomOAID();

    TapTapEvent.TapEventDynamicProperties getDynamicPropertiesGetter();

    AtomicLong getEventIndex();

    List<Interceptor<WrapEvent, Event>> getInterceptors();

    NonCachedPredefinedProvider getNonCachedPredefinedProvider();

    String getSessionId();

    SystemProvider getSystemProvider();

    void setCachedPredefinedProperties(Map<String, ? extends Object> map);

    void setCurrentUserId(String str);

    void setCustomExtras(Map<String, ? extends Object> map);

    void setCustomOAID(String str);

    void setDynamicPropertiesGetter(TapTapEvent.TapEventDynamicProperties tapEventDynamicProperties);

    void setEventIndex(AtomicLong atomicLong);
}
