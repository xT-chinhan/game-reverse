package com.anythink.core.mg.api;

import com.anythink.core.common.s.c;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class MgPreLoadCallbackRegister {
    private static final String TAG = "MgPreLoadCallbackRegister";
    private volatile d timeoutRunnable;
    private final Object timeoutLock = new Object();
    private final Object callbackLock = new Object();
    private final List<MgPreLoadCallback> preLoadCallbackList = new CopyOnWriteArrayList();
    private final AtomicBoolean isCallback = new AtomicBoolean(false);
    private final AtomicReference<MgAdInfo> mgAdInfoRef = new AtomicReference<>();

    public void startTimeoutCountDown(long j) {
        synchronized (this.timeoutLock) {
            if (this.timeoutRunnable != null) {
                c.a().a(this.timeoutRunnable);
            }
            if (j <= 0) {
                notifyCallback(false);
            } else if (!this.isCallback.get()) {
                this.timeoutRunnable = new d(e.dw, new Runnable() { // from class: com.anythink.core.mg.api.MgPreLoadCallbackRegister.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MgPreLoadCallbackRegister.this.notifyCallback(true);
                    }
                });
                c.a().a(this.timeoutRunnable, j);
            }
        }
    }

    public void registerPreLoadCallback(MgPreLoadCallback mgPreLoadCallback) {
        if (mgPreLoadCallback == null) {
            return;
        }
        synchronized (this.callbackLock) {
            this.isCallback.set(false);
            this.preLoadCallbackList.add(mgPreLoadCallback);
        }
    }

    public void notifyPreLoadCallback(MgAdInfo mgAdInfo) {
        this.mgAdInfoRef.set(mgAdInfo);
        synchronized (this.timeoutLock) {
            if (this.timeoutRunnable != null) {
                c.a().a(this.timeoutRunnable);
                this.timeoutRunnable = null;
            }
        }
        notifyCallback(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(boolean z) {
        notifyCallback(z, false);
    }

    private void notifyCallback(final boolean z, boolean z2) {
        CopyOnWriteArrayList<MgPreLoadCallback> copyOnWriteArrayList;
        if (this.preLoadCallbackList.isEmpty()) {
            return;
        }
        synchronized (this.callbackLock) {
            if (this.preLoadCallbackList.isEmpty() || this.isCallback.get()) {
                copyOnWriteArrayList = null;
            } else {
                this.isCallback.set(true);
                copyOnWriteArrayList = new CopyOnWriteArrayList(this.preLoadCallbackList);
                this.preLoadCallbackList.clear();
            }
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        final MgAdInfo mgAdInfo = this.mgAdInfoRef.get();
        try {
            for (final MgPreLoadCallback mgPreLoadCallback : copyOnWriteArrayList) {
                if (mgPreLoadCallback != null) {
                    if (z || z2) {
                        com.anythink.core.common.u.b.c.a().b(new d(e.bE, new Runnable() { // from class: com.anythink.core.mg.api.MgPreLoadCallbackRegister.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                mgPreLoadCallback.onMgAdInfo(mgAdInfo, z);
                            }
                        }));
                    } else {
                        mgPreLoadCallback.onMgAdInfo(mgAdInfo, false);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public MgAdInfo getMgAdInfo() {
        return this.mgAdInfoRef.get();
    }
}
