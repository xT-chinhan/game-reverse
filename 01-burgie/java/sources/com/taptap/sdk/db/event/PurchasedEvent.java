package com.taptap.sdk.db.event;

import com.mar.sdk.IAction;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.TapDB;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.model.EventType;
import com.taptap.sdk.db.data.model.WrapEvent;
import com.taptap.sdk.db.utils.JSONObjectUtils;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: PurchasedEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\b\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/db/event/PurchasedEvent;", "", "builder", "Lcom/taptap/sdk/db/event/PurchasedEvent$Builder;", "(Lcom/taptap/sdk/db/event/PurchasedEvent$Builder;)V", Common.Predefined.PROPERTIES, "", "", "isAutomatically", "", "(Ljava/util/Map;Z)V", "submit", "", "Builder", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PurchasedEvent {
    private final boolean isAutomatically;
    private final Map<String, Object> properties;

    public /* synthetic */ PurchasedEvent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PurchasedEvent(Map<String, ? extends Object> map, boolean isAutomatically) {
        this.properties = map;
        this.isAutomatically = isAutomatically;
    }

    private PurchasedEvent(Builder builder) {
        this((Map<String, ? extends Object>) MapsKt.toMap(builder.getProperties$tap_db_release()), builder.getIsAutomatically());
    }

    public final void submit() {
        TapDB companion = TapDB.INSTANCE.getInstance();
        WrapEvent.Builder builder = new WrapEvent.Builder();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        companion.submitEvent(builder.setEvent(new Event(string, "charge", EventType.TRACK.getValue(), System.currentTimeMillis(), new JSONObject(this.properties))).setEventType(EventType.TRACK).isAutomatically(this.isAutomatically).build());
    }

    /* JADX INFO: compiled from: PurchasedEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR:\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/db/event/PurchasedEvent$Builder;", "", "eventProperties", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "<set-?>", "", "isAutomatically", "isAutomatically$tap_db_release", "()Z", "", "", Common.Predefined.PROPERTIES, "getProperties$tap_db_release", "()Ljava/util/Map;", "build", "Lcom/taptap/sdk/db/event/PurchasedEvent;", Constants.VALUE_FIELD, "setAmount", IAction.BuyKey.CostAmount, "", "setCurrencyType", "currencyType", "setOrderId", "orderId", "setPaymentMethod", "paymentMethod", "setProductName", IAction.PurchaseKey.ProductName, "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private boolean isAutomatically;
        private Map<String, ? extends Object> properties;

        public Builder(JSONObject eventProperties) {
            Map<String, Object> map;
            this.properties = (eventProperties == null || (map = JSONObjectUtils.INSTANCE.toMap(eventProperties)) == null) ? MapsKt.emptyMap() : map;
        }

        public final Map<String, Object> getProperties$tap_db_release() {
            return this.properties;
        }

        /* JADX INFO: renamed from: isAutomatically$tap_db_release, reason: from getter */
        public final boolean getIsAutomatically() {
            return this.isAutomatically;
        }

        public final Builder isAutomatically(boolean value) {
            Builder $this$isAutomatically_u24lambda_u240 = this;
            $this$isAutomatically_u24lambda_u240.isAutomatically = value;
            return this;
        }

        public final Builder setOrderId(String orderId) {
            Builder $this$setOrderId_u24lambda_u241 = this;
            $this$setOrderId_u24lambda_u241.properties = MapsKt.plus($this$setOrderId_u24lambda_u241.properties, TuplesKt.to("order_id", orderId));
            return this;
        }

        public final Builder setProductName(String productName) {
            Builder $this$setProductName_u24lambda_u242 = this;
            $this$setProductName_u24lambda_u242.properties = MapsKt.plus($this$setProductName_u24lambda_u242.properties, TuplesKt.to("product", productName));
            return this;
        }

        public final Builder setAmount(double amount) {
            Builder $this$setAmount_u24lambda_u243 = this;
            $this$setAmount_u24lambda_u243.properties = MapsKt.plus($this$setAmount_u24lambda_u243.properties, TuplesKt.to(IAction.BuyKey.CostAmount, Double.valueOf(amount)));
            return this;
        }

        public final Builder setCurrencyType(String currencyType) {
            Builder $this$setCurrencyType_u24lambda_u244 = this;
            $this$setCurrencyType_u24lambda_u244.properties = MapsKt.plus($this$setCurrencyType_u24lambda_u244.properties, TuplesKt.to("currency_type", currencyType));
            return this;
        }

        public final Builder setPaymentMethod(String paymentMethod) {
            Builder $this$setPaymentMethod_u24lambda_u245 = this;
            $this$setPaymentMethod_u24lambda_u245.properties = MapsKt.plus($this$setPaymentMethod_u24lambda_u245.properties, TuplesKt.to("payment", paymentMethod));
            return this;
        }

        public final PurchasedEvent build() {
            return new PurchasedEvent(this, (DefaultConstructorMarker) null);
        }
    }
}
