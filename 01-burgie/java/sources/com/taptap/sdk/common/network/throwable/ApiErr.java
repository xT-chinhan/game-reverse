package com.taptap.sdk.common.network.throwable;

import android.support.v4.app.NotificationCompat;
import com.taptap.sdk.kit.internal.http.TapErrorConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ApiErr.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00062\u00020\u0001:\t\u0006\u0007\b\t\n\u000b\f\r\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr;", "", NotificationCompat.CATEGORY_ERROR, "", "getErr", "()Ljava/lang/String;", "Companion", "ERROR_BUSINESS_ERROR", "ERROR_SERVER_ERROR", "INVALID_CLIENT", "INVALID_GRANT", "INVALID_REQUEST", "INVALID_TIME", "JSON_PARSE_ERROR", "UNKNOWN_ERROR", "Lcom/taptap/sdk/common/network/throwable/ApiErr$ERROR_BUSINESS_ERROR;", "Lcom/taptap/sdk/common/network/throwable/ApiErr$ERROR_SERVER_ERROR;", "Lcom/taptap/sdk/common/network/throwable/ApiErr$INVALID_CLIENT;", "Lcom/taptap/sdk/common/network/throwable/ApiErr$INVALID_GRANT;", "Lcom/taptap/sdk/common/network/throwable/ApiErr$INVALID_REQUEST;", "Lcom/taptap/sdk/common/network/throwable/ApiErr$INVALID_TIME;", "Lcom/taptap/sdk/common/network/throwable/ApiErr$JSON_PARSE_ERROR;", "Lcom/taptap/sdk/common/network/throwable/ApiErr$UNKNOWN_ERROR;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ApiErr {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String getErr();

    /* JADX INFO: compiled from: ApiErr.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr$JSON_PARSE_ERROR;", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", "()V", NotificationCompat.CATEGORY_ERROR, "", "getErr", "()Ljava/lang/String;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class JSON_PARSE_ERROR implements ApiErr {
        public static final JSON_PARSE_ERROR INSTANCE = new JSON_PARSE_ERROR();

        private JSON_PARSE_ERROR() {
        }

        @Override // com.taptap.sdk.common.network.throwable.ApiErr
        public String getErr() {
            return "json parse error";
        }
    }

    /* JADX INFO: compiled from: ApiErr.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr$ERROR_SERVER_ERROR;", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", "()V", NotificationCompat.CATEGORY_ERROR, "", "getErr", "()Ljava/lang/String;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ERROR_SERVER_ERROR implements ApiErr {
        public static final ERROR_SERVER_ERROR INSTANCE = new ERROR_SERVER_ERROR();

        private ERROR_SERVER_ERROR() {
        }

        @Override // com.taptap.sdk.common.network.throwable.ApiErr
        public String getErr() {
            return TapErrorConstants.ERROR_SERVER_ERROR;
        }
    }

    /* JADX INFO: compiled from: ApiErr.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr$ERROR_BUSINESS_ERROR;", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", "()V", NotificationCompat.CATEGORY_ERROR, "", "getErr", "()Ljava/lang/String;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ERROR_BUSINESS_ERROR implements ApiErr {
        public static final ERROR_BUSINESS_ERROR INSTANCE = new ERROR_BUSINESS_ERROR();

        private ERROR_BUSINESS_ERROR() {
        }

        @Override // com.taptap.sdk.common.network.throwable.ApiErr
        public String getErr() {
            return TapErrorConstants.ERROR_BUSINESS_ERROR;
        }
    }

    /* JADX INFO: compiled from: ApiErr.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr$INVALID_TIME;", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", "()V", NotificationCompat.CATEGORY_ERROR, "", "getErr", "()Ljava/lang/String;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class INVALID_TIME implements ApiErr {
        public static final INVALID_TIME INSTANCE = new INVALID_TIME();

        private INVALID_TIME() {
        }

        @Override // com.taptap.sdk.common.network.throwable.ApiErr
        public String getErr() {
            return TapErrorConstants.ERROR_INVALID_TIME;
        }
    }

    /* JADX INFO: compiled from: ApiErr.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr$INVALID_CLIENT;", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", "()V", NotificationCompat.CATEGORY_ERROR, "", "getErr", "()Ljava/lang/String;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class INVALID_CLIENT implements ApiErr {
        public static final INVALID_CLIENT INSTANCE = new INVALID_CLIENT();

        private INVALID_CLIENT() {
        }

        @Override // com.taptap.sdk.common.network.throwable.ApiErr
        public String getErr() {
            return TapErrorConstants.ERROR_INVALID_CLIENT;
        }
    }

    /* JADX INFO: compiled from: ApiErr.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr$INVALID_REQUEST;", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", "()V", NotificationCompat.CATEGORY_ERROR, "", "getErr", "()Ljava/lang/String;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class INVALID_REQUEST implements ApiErr {
        public static final INVALID_REQUEST INSTANCE = new INVALID_REQUEST();

        private INVALID_REQUEST() {
        }

        @Override // com.taptap.sdk.common.network.throwable.ApiErr
        public String getErr() {
            return TapErrorConstants.ERROR_INVALID_REQUEST;
        }
    }

    /* JADX INFO: compiled from: ApiErr.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr$INVALID_GRANT;", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", "()V", NotificationCompat.CATEGORY_ERROR, "", "getErr", "()Ljava/lang/String;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class INVALID_GRANT implements ApiErr {
        public static final INVALID_GRANT INSTANCE = new INVALID_GRANT();

        private INVALID_GRANT() {
        }

        @Override // com.taptap.sdk.common.network.throwable.ApiErr
        public String getErr() {
            return TapErrorConstants.ERROR_INVALID_GRANT;
        }
    }

    /* JADX INFO: compiled from: ApiErr.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr$UNKNOWN_ERROR;", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", NotificationCompat.CATEGORY_ERROR, "", "(Ljava/lang/String;)V", "getErr", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class UNKNOWN_ERROR implements ApiErr {
        private final String err;

        public static /* synthetic */ UNKNOWN_ERROR copy$default(UNKNOWN_ERROR unknown_error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknown_error.err;
            }
            return unknown_error.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getErr() {
            return this.err;
        }

        public final UNKNOWN_ERROR copy(String err) {
            Intrinsics.checkNotNullParameter(err, "err");
            return new UNKNOWN_ERROR(err);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UNKNOWN_ERROR) && Intrinsics.areEqual(this.err, ((UNKNOWN_ERROR) other).err);
        }

        public int hashCode() {
            return this.err.hashCode();
        }

        public String toString() {
            return "UNKNOWN_ERROR(err=" + this.err + ')';
        }

        public UNKNOWN_ERROR(String err) {
            Intrinsics.checkNotNullParameter(err, "err");
            this.err = err;
        }

        @Override // com.taptap.sdk.common.network.throwable.ApiErr
        public String getErr() {
            return this.err;
        }
    }

    /* JADX INFO: compiled from: ApiErr.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/ApiErr$Companion;", "", "()V", "DEFINED", "", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", "from", "error", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final List<ApiErr> DEFINED = CollectionsKt.listOf((Object[]) new ApiErr[]{ERROR_SERVER_ERROR.INSTANCE, ERROR_BUSINESS_ERROR.INSTANCE, INVALID_TIME.INSTANCE, INVALID_CLIENT.INSTANCE, INVALID_REQUEST.INSTANCE, INVALID_GRANT.INSTANCE});

        private Companion() {
        }

        public final ApiErr from(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            Iterable $this$associateBy$iv = DEFINED;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associateBy$iv) {
                ApiErr it = (ApiErr) element$iv$iv;
                destination$iv$iv.put(it.getErr(), element$iv$iv);
            }
            ApiErr apiErr = (ApiErr) destination$iv$iv.get(error);
            return apiErr == null ? new UNKNOWN_ERROR(error) : apiErr;
        }
    }
}
