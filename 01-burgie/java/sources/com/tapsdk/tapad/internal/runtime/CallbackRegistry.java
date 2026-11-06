package com.tapsdk.tapad.internal.runtime;

import android.util.SparseArray;
import java.util.EnumMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class CallbackRegistry {
    private static final String TAG = "CallbackRegistry";
    private static volatile CallbackRegistry sInstance;
    private final SparseArray<HandleCallbacks> mRegistry = new SparseArray<>();
    private final Object mLock = new Object();

    public enum CallbackType {
        VIDEO_PROGRESS,
        VIDEO_COMPLETE,
        VIDEO_ERROR,
        VIDEO_READY,
        VIDEO_FIRST_FRAME,
        VIDEO_SIZE_CHANGED,
        ANIMATION_COMPLETE,
        TIMER_FIRE,
        DOWNLOAD_PROGRESS,
        DOWNLOAD_COMPLETE,
        DOWNLOAD_ERROR,
        VIEW_CLICK,
        VIEW_TOUCH,
        DIALOG_DISMISS,
        DIALOG_CONFIRM,
        DIALOG_CANCEL,
        SENSOR_DATA,
        SHAKE_TRIGGER
    }

    public static class HandleCallbacks {
        private final EnumMap<CallbackType, Integer> callbacks;

        private HandleCallbacks() {
            this.callbacks = new EnumMap<>(CallbackType.class);
        }

        public void clear() {
            this.callbacks.clear();
        }

        public Integer get(CallbackType callbackType) {
            return this.callbacks.get(callbackType);
        }

        public boolean isEmpty() {
            return this.callbacks.isEmpty();
        }

        public void put(CallbackType callbackType, int i) {
            this.callbacks.put(callbackType, Integer.valueOf(i));
        }

        public void remove(CallbackType callbackType) {
            this.callbacks.remove(callbackType);
        }

        public int size() {
            return this.callbacks.size();
        }
    }

    private CallbackRegistry() {
    }

    public static CallbackRegistry getInstance() {
        if (sInstance == null) {
            synchronized (CallbackRegistry.class) {
                if (sInstance == null) {
                    sInstance = new CallbackRegistry();
                }
            }
        }
        return sInstance;
    }

    public void clear() {
        synchronized (this.mLock) {
            this.mRegistry.size();
            this.mRegistry.clear();
        }
    }

    public Integer get(int i, CallbackType callbackType) {
        synchronized (this.mLock) {
            HandleCallbacks handleCallbacks = this.mRegistry.get(i);
            if (handleCallbacks == null) {
                return null;
            }
            return handleCallbacks.get(callbackType);
        }
    }

    public int getHandleCount() {
        int size;
        synchronized (this.mLock) {
            size = this.mRegistry.size();
        }
        return size;
    }

    public String getStats() {
        String string;
        synchronized (this.mLock) {
            StringBuilder sb = new StringBuilder();
            sb.append("CallbackRegistry Stats:\n");
            sb.append("  Total handles: ").append(this.mRegistry.size()).append("\n");
            sb.append("  Total callbacks: ").append(getTotalCallbackCount()).append("\n");
            EnumMap enumMap = new EnumMap(CallbackType.class);
            for (int i = 0; i < this.mRegistry.size(); i++) {
                HandleCallbacks handleCallbacksValueAt = this.mRegistry.valueAt(i);
                for (CallbackType callbackType : CallbackType.values()) {
                    if (handleCallbacksValueAt.get(callbackType) != null) {
                        Integer num = (Integer) enumMap.get(callbackType);
                        int iIntValue = 1;
                        if (num != null) {
                            iIntValue = 1 + num.intValue();
                        }
                        enumMap.put(callbackType, Integer.valueOf(iIntValue));
                    }
                }
            }
            sb.append("  By type:\n");
            for (CallbackType callbackType2 : CallbackType.values()) {
                Integer num2 = (Integer) enumMap.get(callbackType2);
                if (num2 != null && num2.intValue() > 0) {
                    sb.append("    ").append(callbackType2).append(": ").append(num2).append("\n");
                }
            }
            string = sb.toString();
        }
        return string;
    }

    public int getTotalCallbackCount() {
        int size;
        synchronized (this.mLock) {
            size = 0;
            for (int i = 0; i < this.mRegistry.size(); i++) {
                size += this.mRegistry.valueAt(i).size();
            }
        }
        return size;
    }

    public boolean hasCallback(int i, CallbackType callbackType) {
        return get(i, callbackType) != null;
    }

    public void register(int i, CallbackType callbackType, int i2) {
        synchronized (this.mLock) {
            HandleCallbacks handleCallbacks = this.mRegistry.get(i);
            if (handleCallbacks == null) {
                handleCallbacks = new HandleCallbacks();
                this.mRegistry.put(i, handleCallbacks);
            }
            handleCallbacks.put(callbackType, i2);
            Objects.toString(callbackType);
        }
    }

    public void unregister(int i, CallbackType callbackType) {
        synchronized (this.mLock) {
            HandleCallbacks handleCallbacks = this.mRegistry.get(i);
            if (handleCallbacks != null) {
                handleCallbacks.remove(callbackType);
                if (handleCallbacks.isEmpty()) {
                    this.mRegistry.remove(i);
                }
                Objects.toString(callbackType);
            }
        }
    }

    public void unregisterAll(int i) {
        synchronized (this.mLock) {
            HandleCallbacks handleCallbacks = this.mRegistry.get(i);
            if (handleCallbacks != null) {
                handleCallbacks.size();
                this.mRegistry.remove(i);
            }
        }
    }
}
