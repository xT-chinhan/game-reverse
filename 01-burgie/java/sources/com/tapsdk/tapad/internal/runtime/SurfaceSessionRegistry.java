package com.tapsdk.tapad.internal.runtime;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SurfaceSessionRegistry {
    private final Object mLock = new Object();
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final SparseArray<SurfaceSession> mBySurfaceId = new SparseArray<>();
    private final SparseArray<List<Integer>> mSurfaceIdsByInstanceId = new SparseArray<>();
    private int mNextSurfaceId = 1;

    private void finishSessionHandlers(SurfaceSession surfaceSession) {
        if (surfaceSession == null) {
            return;
        }
        surfaceSession.finishHandlers();
    }

    private int nextSurfaceIdLocked() {
        if (this.mNextSurfaceId == Integer.MAX_VALUE) {
            this.mNextSurfaceId = 1;
        }
        int i = this.mNextSurfaceId;
        this.mNextSurfaceId = i + 1;
        return i;
    }

    private void removeSurfaceFromInstanceLocked(int i, int i2) {
        List<Integer> list = this.mSurfaceIdsByInstanceId.get(i);
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            Integer num = list.get(size);
            if (num == null || num.intValue() == i2) {
                list.remove(size);
            }
        }
        if (list.isEmpty()) {
            this.mSurfaceIdsByInstanceId.remove(i);
        }
    }

    public int activeSurfaceIdForInstance(int i) {
        List<SurfaceSession> listSessionsForInstance = sessionsForInstance(i);
        int iSurfaceId = -1;
        for (int size = listSessionsForInstance.size() - 1; size >= 0; size--) {
            SurfaceSession surfaceSession = listSessionsForInstance.get(size);
            if (surfaceSession != null && surfaceSession.isAlive()) {
                if (iSurfaceId < 0) {
                    iSurfaceId = surfaceSession.surfaceId();
                }
                if (surfaceSession.renderer() != null) {
                    return surfaceSession.surfaceId();
                }
            }
        }
        return iSurfaceId;
    }

    public boolean attachRenderer(int i, ViewRenderer viewRenderer) {
        SurfaceSession live = getLive(i);
        if (live == null || viewRenderer == null) {
            return false;
        }
        live.attachRenderer(viewRenderer);
        return true;
    }

    public void clear() {
        int i;
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            i = 0;
            for (int i2 = 0; i2 < this.mBySurfaceId.size(); i2++) {
                SurfaceSession surfaceSessionValueAt = this.mBySurfaceId.valueAt(i2);
                if (surfaceSessionValueAt != null) {
                    arrayList.add(surfaceSessionValueAt);
                }
            }
            this.mBySurfaceId.clear();
            this.mSurfaceIdsByInstanceId.clear();
            this.mNextSurfaceId = 1;
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SurfaceSession surfaceSession = (SurfaceSession) obj;
            finishSessionHandlers(surfaceSession);
            surfaceSession.markDestroyed();
        }
    }

    public int createSurface(int i, WasmModule wasmModule, Object obj, String str, BaseAdActivity.AdActivityConfig adActivityConfig, AdCallbackListener adCallbackListener) {
        int iNextSurfaceIdLocked;
        if (i < 0 || wasmModule == null) {
            return -1;
        }
        synchronized (this.mLock) {
            iNextSurfaceIdLocked = nextSurfaceIdLocked();
            this.mBySurfaceId.put(iNextSurfaceIdLocked, new SurfaceSession(iNextSurfaceIdLocked, i, wasmModule, obj, str, adActivityConfig, adCallbackListener));
            List<Integer> arrayList = this.mSurfaceIdsByInstanceId.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.mSurfaceIdsByInstanceId.put(i, arrayList);
            }
            arrayList.add(Integer.valueOf(iNextSurfaceIdLocked));
        }
        return iNextSurfaceIdLocked;
    }

    public SurfaceSession destroySurface(int i) {
        return destroySurface(i, true);
    }

    public List<SurfaceSession> destroySurfacesForInstance(int i) {
        SurfaceSession surfaceSessionDestroySurface;
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            List<Integer> list = this.mSurfaceIdsByInstanceId.get(i);
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(list);
                int i2 = 0;
                int size = arrayList2.size();
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    Integer num = (Integer) obj;
                    if (num != null && (surfaceSessionDestroySurface = destroySurface(num.intValue(), true)) != null) {
                        arrayList.add(surfaceSessionDestroySurface);
                    }
                }
                return arrayList;
            }
            return arrayList;
        }
    }

    public boolean detachRenderer(int i, ViewRenderer viewRenderer) {
        SurfaceSession surfaceSession = get(i);
        return surfaceSession != null && surfaceSession.detachRenderer(viewRenderer);
    }

    public boolean dispatchSurfaceCallback(int i, final String str, final String str2) {
        final SurfaceSession live = getLive(i);
        if (live == null) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.SurfaceSessionRegistry$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                live.dispatchCallback(str, str2);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return true;
        }
        this.mMainHandler.post(runnable);
        return true;
    }

    public void finishSurfacesForInstance(int i) {
        Iterator<SurfaceSession> it = sessionsForInstance(i).iterator();
        while (it.hasNext()) {
            finishSessionHandlers(it.next());
        }
    }

    public SurfaceSession get(int i) {
        SurfaceSession surfaceSession;
        synchronized (this.mLock) {
            surfaceSession = this.mBySurfaceId.get(i);
        }
        return surfaceSession;
    }

    public SurfaceSession getLive(int i) {
        SurfaceSession surfaceSession = get(i);
        if (surfaceSession == null || !surfaceSession.isAlive()) {
            return null;
        }
        return surfaceSession;
    }

    public boolean hasLiveRenderedSurface() {
        synchronized (this.mLock) {
            for (int i = 0; i < this.mBySurfaceId.size(); i++) {
                SurfaceSession surfaceSessionValueAt = this.mBySurfaceId.valueAt(i);
                if (surfaceSessionValueAt != null && surfaceSessionValueAt.isAlive() && surfaceSessionValueAt.renderer() != null) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isLive(int i) {
        return getLive(i) != null;
    }

    public void registerCallbackHandler(int i, SurfaceSession.CallbackHandler callbackHandler) {
        SurfaceSession live = getLive(i);
        if (live != null) {
            live.registerHandler(callbackHandler);
        }
    }

    public ViewRenderer rendererForSurface(int i) {
        SurfaceSession live = getLive(i);
        if (live != null) {
            return live.renderer();
        }
        return null;
    }

    public List<SurfaceSession> sessionsForInstance(int i) {
        SurfaceSession live;
        synchronized (this.mLock) {
            List<Integer> list = this.mSurfaceIdsByInstanceId.get(i);
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList(list);
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int i2 = 0;
                int size = arrayList.size();
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    Integer num = (Integer) obj;
                    if (num != null && (live = getLive(num.intValue())) != null) {
                        arrayList2.add(live);
                    }
                }
                return arrayList2;
            }
            return new ArrayList();
        }
    }

    public void unregisterCallbackHandler(int i, SurfaceSession.CallbackHandler callbackHandler) {
        SurfaceSession surfaceSession = get(i);
        if (surfaceSession != null) {
            surfaceSession.unregisterHandler(callbackHandler);
        }
    }

    public SurfaceSession destroySurface(int i, boolean z) {
        synchronized (this.mLock) {
            SurfaceSession surfaceSession = this.mBySurfaceId.get(i);
            if (surfaceSession == null) {
                return null;
            }
            this.mBySurfaceId.remove(i);
            removeSurfaceFromInstanceLocked(surfaceSession.instanceId(), i);
            if (z) {
                finishSessionHandlers(surfaceSession);
            }
            surfaceSession.markDestroyed();
            return surfaceSession;
        }
    }
}
