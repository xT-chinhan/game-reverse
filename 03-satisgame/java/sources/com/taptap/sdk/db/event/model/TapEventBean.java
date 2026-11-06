package com.taptap.sdk.db.event.model;

import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.store.ITapData;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapEventBean.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002 !B1\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/taptap/sdk/db/event/model/TapEventBean;", "Lcom/taptap/sdk/kit/internal/store/ITapData;", "eventType", "", "eventName", "eventUUID", "timeMillis", "", "jsonString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", TapEventParamConstants.PARAM_PROPERTIES, "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getEventName", "()Ljava/lang/String;", "getEventType", "getEventUUID", "getProperties", "()Lorg/json/JSONObject;", "setProperties", "(Lorg/json/JSONObject;)V", "getTimeMillis", "()J", "compareTo", "", AdnName.OTHER, "equals", "", "", "hashCode", "toString", "writeReplace", "Companion", "SerializationProxy", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapEventBean implements ITapData<TapEventBean> {
    private static final String TAG = "TapEventBean";
    private final String eventName;
    private final String eventType;
    private final String eventUUID;
    private JSONObject properties;
    private final long timeMillis;

    public /* synthetic */ TapEventBean(String str, String str2, String str3, long j, String str4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, str4);
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getEventUUID() {
        return this.eventUUID;
    }

    public final long getTimeMillis() {
        return this.timeMillis;
    }

    public final JSONObject getProperties() {
        return this.properties;
    }

    public final void setProperties(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.properties = jSONObject;
    }

    private TapEventBean(String str, String str2, String str3, long j, String str4) {
        this.eventType = str;
        this.eventName = str2;
        this.eventUUID = str3;
        this.timeMillis = j;
        try {
            this.properties = new JSONObject(str4);
        } catch (Exception e) {
            this.properties = new JSONObject();
            TapLogger.logd(TAG, e);
        }
    }

    public TapEventBean(String eventType, String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.eventType = eventType;
        this.eventName = str;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.eventUUID = string;
        this.timeMillis = System.currentTimeMillis();
        this.properties = jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // java.lang.Comparable
    public int compareTo(TapEventBean other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.timeMillis, other.timeMillis);
    }

    public String toString() {
        return String.valueOf(this.properties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.taptap.sdk.db.event.model.TapEventBean");
        TapEventBean tapEventBean = (TapEventBean) other;
        return Intrinsics.areEqual(this.eventType, tapEventBean.eventType) && Intrinsics.areEqual(this.eventName, tapEventBean.eventName) && Intrinsics.areEqual(this.eventUUID, tapEventBean.eventUUID) && this.timeMillis == tapEventBean.timeMillis;
    }

    public int hashCode() {
        return super.hashCode();
    }

    private final Object writeReplace() throws ObjectStreamException {
        String str = this.eventType;
        String str2 = this.eventName;
        String str3 = this.eventUUID;
        long j = this.timeMillis;
        String string = this.properties.toString();
        Intrinsics.checkNotNullExpressionValue(string, "properties.toString()");
        return new SerializationProxy(str, str2, str3, j, string);
    }

    /* JADX INFO: compiled from: TapEventBean.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/db/event/model/TapEventBean$SerializationProxy;", "Ljava/io/Serializable;", "eventType", "", "eventName", "eventUUID", "timeMillis", "", "jsonString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "getEventType", "getEventUUID", "getJsonString", "getTimeMillis", "()J", "readResolve", "", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20230323002L;
        private final String eventName;
        private final String eventType;
        private final String eventUUID;
        private final String jsonString;
        private final long timeMillis;

        public SerializationProxy(String eventType, String str, String eventUUID, long j, String jsonString) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(eventUUID, "eventUUID");
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            this.eventType = eventType;
            this.eventName = str;
            this.eventUUID = eventUUID;
            this.timeMillis = j;
            this.jsonString = jsonString;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final String getEventUUID() {
            return this.eventUUID;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        public final String getJsonString() {
            return this.jsonString;
        }

        private final Object readResolve() throws ObjectStreamException, JSONException {
            return new TapEventBean(this.eventType, this.eventName, this.eventUUID, this.timeMillis, this.jsonString, null);
        }
    }
}
