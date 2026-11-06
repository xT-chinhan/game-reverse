package com.taptap.sdk.login.impl.data.model;

import com.tapsdk.tapad.group.constants.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ResponseType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/ResponseType;", "", "(Ljava/lang/String;I)V", Constants.VALUE_FIELD, "", "getValue", "()Ljava/lang/String;", "LOGIN", "RECEIPT_MESSAGE", "INIT_MESSAGE", "MIDDLE_LAYER_INIT_FINISH", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum ResponseType {
    LOGIN { // from class: com.taptap.sdk.login.impl.data.model.ResponseType.LOGIN
        @Override // com.taptap.sdk.login.impl.data.model.ResponseType
        public String getValue() {
            return "login_taptap_finish";
        }
    },
    RECEIPT_MESSAGE { // from class: com.taptap.sdk.login.impl.data.model.ResponseType.RECEIPT_MESSAGE
        @Override // com.taptap.sdk.login.impl.data.model.ResponseType
        public String getValue() {
            return "message_result";
        }
    },
    INIT_MESSAGE { // from class: com.taptap.sdk.login.impl.data.model.ResponseType.INIT_MESSAGE
        @Override // com.taptap.sdk.login.impl.data.model.ResponseType
        public String getValue() {
            return "initialize_finish";
        }
    },
    MIDDLE_LAYER_INIT_FINISH { // from class: com.taptap.sdk.login.impl.data.model.ResponseType.MIDDLE_LAYER_INIT_FINISH
        @Override // com.taptap.sdk.login.impl.data.model.ResponseType
        public String getValue() {
            return "middle_layer_init_finish";
        }
    };


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* synthetic */ ResponseType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getValue();

    /* JADX INFO: compiled from: ResponseType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/ResponseType$Companion;", "", "()V", "from", "Lcom/taptap/sdk/login/impl/data/model/ResponseType;", Constants.VALUE_FIELD, "", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ResponseType from(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ResponseType[] responseTypeArrValues = ResponseType.values();
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(responseTypeArrValues.length), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (ResponseType responseType : responseTypeArrValues) {
                destination$iv$iv.put(responseType.getValue(), responseType);
            }
            return (ResponseType) destination$iv$iv.get(value);
        }
    }
}
