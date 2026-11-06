package com.mar.sdk.log;

/* JADX INFO: loaded from: classes2.dex */
public class ULocalLog implements ILog {
    @Override // com.mar.sdk.log.ILog
    public void d(String tag, String msg) {
        android.util.Log.d(tag, msg);
    }

    @Override // com.mar.sdk.log.ILog
    public void i(String tag, String msg) {
        android.util.Log.i(tag, msg);
    }

    @Override // com.mar.sdk.log.ILog
    public void w(String tag, String msg) {
        android.util.Log.w(tag, msg);
    }

    @Override // com.mar.sdk.log.ILog
    public void e(String tag, String msg) {
        android.util.Log.e(tag, msg);
    }

    @Override // com.mar.sdk.log.ILog
    public void w(String tag, String msg, Throwable e) {
        android.util.Log.w(tag, msg, e);
    }

    @Override // com.mar.sdk.log.ILog
    public void e(String tag, String msg, Throwable e) {
        android.util.Log.e(tag, msg, e);
    }

    @Override // com.mar.sdk.log.ILog
    public void destory() {
    }
}
