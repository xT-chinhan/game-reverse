package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import com.kwad.sdk.api.ApiDMAction;
import com.kwad.sdk.api.SDKApiHolder;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class AutoRevertHandler implements Thread.UncaughtExceptionHandler {
    private static AutoRevertHandler INSTANCE;
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;
    private int mMaxDuration;
    private long mStartCheckTime;
    private boolean DEBUG = false;
    private final AtomicBoolean mIsCancel = new AtomicBoolean();

    public static AutoRevertHandler getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AutoRevertHandler.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AutoRevertHandler(context);
                }
            }
        }
        return INSTANCE;
    }

    private AutoRevertHandler(Context context) {
        this.mContext = context;
    }

    public void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.mDefaultUncaughtExceptionHandler = uncaughtExceptionHandler;
        }
    }

    public void startCheck(int i) {
        this.mStartCheckTime = System.currentTimeMillis();
        this.mMaxDuration = i;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.mIsCancel.set(true);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.mStartCheckTime + ",mMaxDuration:" + this.mMaxDuration + ",mIsCancel:" + this.mIsCancel.get());
            }
            if (!this.mIsCancel.get() && this.mStartCheckTime > 0 && System.currentTimeMillis() - this.mStartCheckTime <= this.mMaxDuration) {
                Boolean bool = (Boolean) SDKApiHolder.doAction(ApiDMAction.filterStack, th);
                boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && zBooleanValue) {
                    ApiSpUtils.setBoolean(context, DVersionUtils.AUTOREVERT, true);
                }
            }
            uncaughtExceptionHandler = this.mDefaultUncaughtExceptionHandler;
            if (uncaughtExceptionHandler == null) {
                return;
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                uncaughtExceptionHandler = this.mDefaultUncaughtExceptionHandler;
                if (uncaughtExceptionHandler == null) {
                    return;
                }
            } catch (Throwable th3) {
                if (this.mDefaultUncaughtExceptionHandler != null) {
                    this.mDefaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
                throw th3;
            }
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
