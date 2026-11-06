package com.taptap.sdk.login.impl.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudGameException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\n\u000b\f\r\u000eB\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0001\u0005\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/login/impl/exception/CloudGameException;", "", "message", "", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "getMessage", "()Ljava/lang/String;", "InitializeFailed", "LoginFailed", "ReceiptFailed", "ServiceDisconnected", "UnsupportedVersion", "Lcom/taptap/sdk/login/impl/exception/CloudGameException$InitializeFailed;", "Lcom/taptap/sdk/login/impl/exception/CloudGameException$LoginFailed;", "Lcom/taptap/sdk/login/impl/exception/CloudGameException$ReceiptFailed;", "Lcom/taptap/sdk/login/impl/exception/CloudGameException$ServiceDisconnected;", "Lcom/taptap/sdk/login/impl/exception/CloudGameException$UnsupportedVersion;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class CloudGameException extends Throwable {
    private final Throwable cause;
    private final String message;

    public /* synthetic */ CloudGameException(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th);
    }

    public /* synthetic */ CloudGameException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th, null);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    private CloudGameException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    /* JADX INFO: compiled from: CloudGameException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/login/impl/exception/CloudGameException$ServiceDisconnected;", "Lcom/taptap/sdk/login/impl/exception/CloudGameException;", "message", "", "(Ljava/lang/String;)V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ServiceDisconnected extends CloudGameException {
        /* JADX WARN: Multi-variable type inference failed */
        public ServiceDisconnected() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ ServiceDisconnected(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Cloud game service disconnected" : str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ServiceDisconnected(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    /* JADX INFO: compiled from: CloudGameException.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/login/impl/exception/CloudGameException$InitializeFailed;", "Lcom/taptap/sdk/login/impl/exception/CloudGameException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class InitializeFailed extends CloudGameException {
        /* JADX WARN: Multi-variable type inference failed */
        public InitializeFailed() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ InitializeFailed(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Cloud game initialize failed" : str, (i & 2) != 0 ? null : th);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitializeFailed(String message, Throwable cause) {
            super(message, cause, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    /* JADX INFO: compiled from: CloudGameException.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/login/impl/exception/CloudGameException$LoginFailed;", "Lcom/taptap/sdk/login/impl/exception/CloudGameException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LoginFailed extends CloudGameException {
        /* JADX WARN: Multi-variable type inference failed */
        public LoginFailed() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ LoginFailed(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Cloud game login failed" : str, (i & 2) != 0 ? null : th);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoginFailed(String message, Throwable cause) {
            super(message, cause, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    /* JADX INFO: compiled from: CloudGameException.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/login/impl/exception/CloudGameException$ReceiptFailed;", "Lcom/taptap/sdk/login/impl/exception/CloudGameException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ReceiptFailed extends CloudGameException {
        /* JADX WARN: Multi-variable type inference failed */
        public ReceiptFailed() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ ReceiptFailed(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Cloud game receipt message failed" : str, (i & 2) != 0 ? null : th);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReceiptFailed(String message, Throwable cause) {
            super(message, cause, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    /* JADX INFO: compiled from: CloudGameException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/login/impl/exception/CloudGameException$UnsupportedVersion;", "Lcom/taptap/sdk/login/impl/exception/CloudGameException;", "version", "", "(Ljava/lang/String;)V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UnsupportedVersion extends CloudGameException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public UnsupportedVersion(String version) {
            super("Cloud game protocol version: " + version + " is not supported", null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(version, "version");
        }
    }
}
