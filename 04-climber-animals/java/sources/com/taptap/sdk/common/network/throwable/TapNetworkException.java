package com.taptap.sdk.common.network.throwable;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapNetworkException.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/TapNetworkException;", "", NotificationCompat.CATEGORY_ERROR, "Lcom/taptap/sdk/common/network/throwable/TapNetworkException$Err;", "cause", "(Lcom/taptap/sdk/common/network/throwable/TapNetworkException$Err;Ljava/lang/Throwable;)V", "getErr", "()Lcom/taptap/sdk/common/network/throwable/TapNetworkException$Err;", "Err", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapNetworkException extends Throwable {
    private final Err err;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapNetworkException(Err err, Throwable th) {
        super(err.convertAsMessage(), th);
        Intrinsics.checkNotNullParameter(err, "err");
        this.err = err;
    }

    public /* synthetic */ TapNetworkException(Err err, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(err, (i & 2) != 0 ? null : th);
    }

    public final Err getErr() {
        return this.err;
    }

    /* JADX INFO: compiled from: TapNetworkException.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0006\u0010\u0015\u001a\u00020\u0007J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/common/network/throwable/TapNetworkException$Err;", "", "apiErr", "Lcom/taptap/sdk/common/network/throwable/ApiErr;", "code", "", "msg", "", BundleKey.DESCRIPTION, "(Lcom/taptap/sdk/common/network/throwable/ApiErr;ILjava/lang/String;Ljava/lang/String;)V", "getApiErr", "()Lcom/taptap/sdk/common/network/throwable/ApiErr;", "getCode", "()I", BillingClientConstants.METHOD_GET_PRODUCT_DESCRIPTION, "()Ljava/lang/String;", "getMsg", "component1", "component2", "component3", "component4", "convertAsMessage", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Err {
        private final ApiErr apiErr;
        private final int code;
        private final String description;
        private final String msg;

        public static /* synthetic */ Err copy$default(Err err, ApiErr apiErr, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                apiErr = err.apiErr;
            }
            if ((i2 & 2) != 0) {
                i = err.code;
            }
            if ((i2 & 4) != 0) {
                str = err.msg;
            }
            if ((i2 & 8) != 0) {
                str2 = err.description;
            }
            return err.copy(apiErr, i, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ApiErr getApiErr() {
            return this.apiErr;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final Err copy(ApiErr apiErr, int code, String msg, String description) {
            Intrinsics.checkNotNullParameter(apiErr, "apiErr");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return new Err(apiErr, code, msg, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Err)) {
                return false;
            }
            Err err = (Err) other;
            return Intrinsics.areEqual(this.apiErr, err.apiErr) && this.code == err.code && Intrinsics.areEqual(this.msg, err.msg) && Intrinsics.areEqual(this.description, err.description);
        }

        public int hashCode() {
            int iHashCode = ((((this.apiErr.hashCode() * 31) + Integer.hashCode(this.code)) * 31) + this.msg.hashCode()) * 31;
            String str = this.description;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Err(apiErr=" + this.apiErr + ", code=" + this.code + ", msg=" + this.msg + ", description=" + this.description + ')';
        }

        public Err(ApiErr apiErr, int i, String msg, String str) {
            Intrinsics.checkNotNullParameter(apiErr, "apiErr");
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.apiErr = apiErr;
            this.code = i;
            this.msg = msg;
            this.description = str;
        }

        public final ApiErr getApiErr() {
            return this.apiErr;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String convertAsMessage() {
            return "apiError: " + this.apiErr + ", code: " + this.code + ", msg: " + this.msg;
        }
    }
}
