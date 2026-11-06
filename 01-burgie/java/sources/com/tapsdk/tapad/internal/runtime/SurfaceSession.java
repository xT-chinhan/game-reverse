package com.tapsdk.tapad.internal.runtime;

import android.os.Looper;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SurfaceSession {
    private static final String TAG = "SurfaceSession";
    private final Object mAdImpl;
    private final AdCallbackListener mCallbackListener;
    private final BaseAdActivity.AdActivityConfig mConfig;
    private boolean mDestroyed;
    private byte[] mFallbackDisplaySpec;
    private final int mInstanceId;
    private final WasmModule mModule;
    private ViewRenderer mRenderer;
    private final int mSurfaceId;
    private final String mWasmFunction;
    private final Object mLock = new Object();
    private final List<WeakReference<CallbackHandler>> mHandlers = new ArrayList();

    public interface CallbackHandler {
        void finishSurface();

        boolean isSurfaceGone();

        void onSurfaceCallback(String str, String str2);
    }

    public SurfaceSession(int i, int i2, WasmModule wasmModule, Object obj, String str, BaseAdActivity.AdActivityConfig adActivityConfig, AdCallbackListener adCallbackListener) {
        this.mSurfaceId = i;
        this.mInstanceId = i2;
        this.mModule = wasmModule;
        this.mAdImpl = obj;
        this.mWasmFunction = str;
        this.mConfig = adActivityConfig == null ? new BaseAdActivity.AdActivityConfig() : adActivityConfig;
        this.mCallbackListener = adCallbackListener;
    }

    private void pruneHandlersLocked() {
        Iterator<WeakReference<CallbackHandler>> it = this.mHandlers.iterator();
        while (it.hasNext()) {
            CallbackHandler callbackHandler = it.next().get();
            if (callbackHandler == null || callbackHandler.isSurfaceGone()) {
                it.remove();
            }
        }
    }

    public Object adImpl() {
        return this.mAdImpl;
    }

    public void attachRenderer(ViewRenderer viewRenderer) {
        if (viewRenderer == null) {
            return;
        }
        synchronized (this.mLock) {
            if (!this.mDestroyed) {
                this.mRenderer = viewRenderer;
            }
        }
    }

    public AdCallbackListener callbackListener() {
        return this.mCallbackListener;
    }

    public BaseAdActivity.AdActivityConfig config() {
        return this.mConfig;
    }

    public boolean detachRenderer(ViewRenderer viewRenderer) {
        synchronized (this.mLock) {
            if (this.mRenderer != viewRenderer) {
                return false;
            }
            this.mRenderer = null;
            return true;
        }
    }

    public void dispatchCallback(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            if (this.mDestroyed) {
                return;
            }
            AdCallbackListener adCallbackListener = this.mCallbackListener;
            Iterator<WeakReference<CallbackHandler>> it = this.mHandlers.iterator();
            while (it.hasNext()) {
                CallbackHandler callbackHandler = it.next().get();
                if (callbackHandler == null || callbackHandler.isSurfaceGone()) {
                    it.remove();
                } else {
                    arrayList.add(callbackHandler);
                }
            }
            int i = 0;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((CallbackHandler) obj).onSurfaceCallback(str, str2);
            }
            if (adCallbackListener != null) {
                adCallbackListener.onCallback(str, str2);
            }
        }
    }

    public byte[] fallbackDisplaySpecCopy() {
        byte[] bArrCopyOf;
        byte[] bArr;
        synchronized (this.mLock) {
            bArrCopyOf = (this.mDestroyed || (bArr = this.mFallbackDisplaySpec) == null) ? null : Arrays.copyOf(bArr, bArr.length);
        }
        return bArrCopyOf;
    }

    public void finishHandlers() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            Iterator<WeakReference<CallbackHandler>> it = this.mHandlers.iterator();
            while (it.hasNext()) {
                CallbackHandler callbackHandler = it.next().get();
                if (callbackHandler == null || callbackHandler.isSurfaceGone()) {
                    it.remove();
                } else {
                    arrayList.add(callbackHandler);
                }
            }
        }
        int i = 0;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((CallbackHandler) obj).finishSurface();
        }
    }

    public int instanceId() {
        return this.mInstanceId;
    }

    public boolean isAlive() {
        boolean z;
        synchronized (this.mLock) {
            z = !this.mDestroyed;
        }
        return z;
    }

    public void markDestroyed() {
        synchronized (this.mLock) {
            this.mDestroyed = true;
            this.mRenderer = null;
            this.mFallbackDisplaySpec = null;
            this.mHandlers.clear();
        }
    }

    public WasmModule module() {
        return this.mModule;
    }

    public boolean refreshFallbackDisplaySpecFromCore() {
        WasmModule.FallbackDisplaySnapshotResult fallbackDisplaySnapshotResultSnapshotFallbackDisplaySpec;
        if (Looper.myLooper() == Looper.getMainLooper() || (fallbackDisplaySnapshotResultSnapshotFallbackDisplaySpec = this.mModule.snapshotFallbackDisplaySpec(this.mInstanceId, this.mSurfaceId)) == null || !fallbackDisplaySnapshotResultSnapshotFallbackDisplaySpec.isSuccess() || fallbackDisplaySnapshotResultSnapshotFallbackDisplaySpec.output.length == 0) {
            return false;
        }
        synchronized (this.mLock) {
            if (this.mDestroyed) {
                return false;
            }
            byte[] bArr = fallbackDisplaySnapshotResultSnapshotFallbackDisplaySpec.output;
            this.mFallbackDisplaySpec = Arrays.copyOf(bArr, bArr.length);
            return true;
        }
    }

    public void registerHandler(CallbackHandler callbackHandler) {
        if (callbackHandler == null) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mDestroyed) {
                return;
            }
            pruneHandlersLocked();
            this.mHandlers.add(new WeakReference<>(callbackHandler));
        }
    }

    public ViewRenderer renderer() {
        ViewRenderer viewRenderer;
        synchronized (this.mLock) {
            viewRenderer = this.mDestroyed ? null : this.mRenderer;
        }
        return viewRenderer;
    }

    public int surfaceId() {
        return this.mSurfaceId;
    }

    public void unregisterHandler(CallbackHandler callbackHandler) {
        if (callbackHandler == null) {
            return;
        }
        synchronized (this.mLock) {
            Iterator<WeakReference<CallbackHandler>> it = this.mHandlers.iterator();
            while (it.hasNext()) {
                CallbackHandler callbackHandler2 = it.next().get();
                if (callbackHandler2 == null || callbackHandler2 == callbackHandler) {
                    it.remove();
                }
            }
        }
    }

    public String wasmFunction() {
        return this.mWasmFunction;
    }
}
