package com.tapsdk.tapad.internal.install;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class InstallPermissionCompat {
    private static final AtomicBoolean DID_LOG_NOT_DECLARED = new AtomicBoolean(false);
    private static final AtomicBoolean DID_LOG_UNKNOWN = new AtomicBoolean(false);

    public static final class FrameworkPermissionQuery implements PermissionQuery {
        private final Context context;

        public FrameworkPermissionQuery(Context context) {
            this.context = context;
        }

        @Override // com.tapsdk.tapad.internal.install.InstallPermissionCompat.PermissionQuery
        public boolean canRequestPackageInstalls() {
            return this.context.getPackageManager().canRequestPackageInstalls();
        }
    }

    public interface PermissionQuery {
        boolean canRequestPackageInstalls();
    }

    public enum State {
        NOT_REQUIRED,
        GRANTED,
        DENIED,
        NOT_DECLARED,
        UNKNOWN
    }

    private InstallPermissionCompat() {
    }

    public static State getState(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return State.NOT_REQUIRED;
        }
        State stateQuery = query(i, context == null ? null : new FrameworkPermissionQuery(context));
        logUnavailableStateOnce(stateQuery);
        return stateQuery;
    }

    private static void logUnavailableStateOnce(State state) {
        if (!(state == State.NOT_DECLARED && DID_LOG_NOT_DECLARED.compareAndSet(false, true)) && state == State.UNKNOWN) {
            DID_LOG_UNKNOWN.compareAndSet(false, true);
        }
    }

    public static State query(int i, PermissionQuery permissionQuery) {
        if (i < 26) {
            return State.NOT_REQUIRED;
        }
        if (permissionQuery == null) {
            return State.UNKNOWN;
        }
        try {
            return permissionQuery.canRequestPackageInstalls() ? State.GRANTED : State.DENIED;
        } catch (SecurityException e) {
            return State.NOT_DECLARED;
        } catch (Throwable th) {
            return State.UNKNOWN;
        }
    }
}
