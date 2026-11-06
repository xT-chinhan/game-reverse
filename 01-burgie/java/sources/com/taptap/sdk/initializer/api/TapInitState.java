package com.taptap.sdk.initializer.api;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapInitState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/initializer/api/TapInitState;", "", "()V", "Failed", "Idle", "InProgress", "Success", "Lcom/taptap/sdk/initializer/api/TapInitState$Failed;", "Lcom/taptap/sdk/initializer/api/TapInitState$Idle;", "Lcom/taptap/sdk/initializer/api/TapInitState$InProgress;", "Lcom/taptap/sdk/initializer/api/TapInitState$Success;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class TapInitState {
    public /* synthetic */ TapInitState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TapInitState() {
    }

    /* JADX INFO: compiled from: TapInitState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/taptap/sdk/initializer/api/TapInitState$Idle;", "Lcom/taptap/sdk/initializer/api/TapInitState;", "()V", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Idle extends TapInitState {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: TapInitState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/taptap/sdk/initializer/api/TapInitState$InProgress;", "Lcom/taptap/sdk/initializer/api/TapInitState;", "()V", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class InProgress extends TapInitState {
        public static final InProgress INSTANCE = new InProgress();

        private InProgress() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: TapInitState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/taptap/sdk/initializer/api/TapInitState$Success;", "Lcom/taptap/sdk/initializer/api/TapInitState;", "()V", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Success extends TapInitState {
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: TapInitState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/initializer/api/TapInitState$Failed;", "Lcom/taptap/sdk/initializer/api/TapInitState;", MediationConstant.KEY_ERROR_CODE, "", MediationConstant.KEY_ERROR_MSG, "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Failed extends TapInitState {
        private final int errorCode;
        private final String errorMsg;

        public static /* synthetic */ Failed copy$default(Failed failed, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = failed.errorCode;
            }
            if ((i2 & 2) != 0) {
                str = failed.errorMsg;
            }
            return failed.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public final Failed copy(int errorCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            return new Failed(errorCode, errorMsg);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failed)) {
                return false;
            }
            Failed failed = (Failed) other;
            return this.errorCode == failed.errorCode && Intrinsics.areEqual(this.errorMsg, failed.errorMsg);
        }

        public int hashCode() {
            return (Integer.hashCode(this.errorCode) * 31) + this.errorMsg.hashCode();
        }

        public String toString() {
            return "Failed(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(int errorCode, String errorMsg) {
            super(null);
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            this.errorCode = errorCode;
            this.errorMsg = errorMsg;
        }
    }
}
