package com.taptap.sdk.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapFirstPartyLoginOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/login/TapFirstPartyLoginOptions;", "", "builder", "Lcom/taptap/sdk/login/TapFirstPartyLoginOptions$Builder;", "(Lcom/taptap/sdk/login/TapFirstPartyLoginOptions$Builder;)V", "isPreApproved", "", "phoneVerifyToken", "", "preferLoginType", "(ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getPhoneVerifyToken", "()Ljava/lang/String;", "getPreferLoginType", "Builder", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapFirstPartyLoginOptions {
    private final boolean isPreApproved;
    private final String phoneVerifyToken;
    private final String preferLoginType;

    private TapFirstPartyLoginOptions(boolean isPreApproved, String phoneVerifyToken, String preferLoginType) {
        this.isPreApproved = isPreApproved;
        this.phoneVerifyToken = phoneVerifyToken;
        this.preferLoginType = preferLoginType;
    }

    /* JADX INFO: renamed from: isPreApproved, reason: from getter */
    public final boolean getIsPreApproved() {
        return this.isPreApproved;
    }

    public final String getPhoneVerifyToken() {
        return this.phoneVerifyToken;
    }

    public final String getPreferLoginType() {
        return this.preferLoginType;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TapFirstPartyLoginOptions(Builder builder) {
        this(builder.getIsPreApproved(), builder.getPhoneVerifyToken(), builder.getPreferLoginType());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    /* JADX INFO: compiled from: TapFirstPartyLoginOptions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/login/TapFirstPartyLoginOptions$Builder;", "", "()V", "<set-?>", "", "isPreApproved", "()Z", "", "phoneVerifyToken", "getPhoneVerifyToken", "()Ljava/lang/String;", "preferLoginType", "getPreferLoginType", "build", "Lcom/taptap/sdk/login/TapFirstPartyLoginOptions;", "setPhoneVerifyToken", "setPreferLoginType", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private boolean isPreApproved;
        private String phoneVerifyToken;
        private String preferLoginType;

        /* JADX INFO: renamed from: isPreApproved, reason: from getter */
        public final boolean getIsPreApproved() {
            return this.isPreApproved;
        }

        public final String getPhoneVerifyToken() {
            return this.phoneVerifyToken;
        }

        public final String getPreferLoginType() {
            return this.preferLoginType;
        }

        public final Builder isPreApproved(boolean isPreApproved) {
            Builder $this$isPreApproved_u24lambda_u240 = this;
            $this$isPreApproved_u24lambda_u240.isPreApproved = isPreApproved;
            return $this$isPreApproved_u24lambda_u240;
        }

        public final Builder setPhoneVerifyToken(String phoneVerifyToken) {
            Intrinsics.checkNotNullParameter(phoneVerifyToken, "phoneVerifyToken");
            Builder $this$setPhoneVerifyToken_u24lambda_u241 = this;
            $this$setPhoneVerifyToken_u24lambda_u241.phoneVerifyToken = phoneVerifyToken;
            return $this$setPhoneVerifyToken_u24lambda_u241;
        }

        public final Builder setPreferLoginType(String preferLoginType) {
            Intrinsics.checkNotNullParameter(preferLoginType, "preferLoginType");
            Builder $this$setPreferLoginType_u24lambda_u242 = this;
            $this$setPreferLoginType_u24lambda_u242.preferLoginType = preferLoginType;
            return $this$setPreferLoginType_u24lambda_u242;
        }

        public final TapFirstPartyLoginOptions build() {
            return new TapFirstPartyLoginOptions(this);
        }
    }
}
