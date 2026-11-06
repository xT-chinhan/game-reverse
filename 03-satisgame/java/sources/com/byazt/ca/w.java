package com.byazt.ca;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.nf.fs;
import com.byazt.pmn.AppDownloadListener;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 730, 13})
public class w extends fs.n {
    public volatile AppDownloadListener n;
    public Handler qg = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(AppDownloadListener appDownloadListener) {
        return appDownloadListener != null;
    }

    private Handler q() {
        Handler handler = this.qg;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.qg = handler2;
        return handler2;
    }

    public w(AppDownloadListener appDownloadListener) {
        this.n = appDownloadListener;
    }

    @Override // com.byazt.nf.fs
    public void n() throws RemoteException {
        if (this.n != null) {
            q().post(new Runnable() { // from class: com.byazt.ca.w.1
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadListener appDownloadListener = w.this.n;
                    if (w.this.n(appDownloadListener)) {
                        appDownloadListener.onIdle();
                    }
                }
            });
        }
    }

    @Override // com.byazt.nf.fs
    public void n(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.n != null) {
            q().post(new Runnable() { // from class: com.byazt.ca.w.2
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadListener appDownloadListener = w.this.n;
                    if (w.this.n(appDownloadListener)) {
                        appDownloadListener.onDownloadActive(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nf.fs
    public void qg(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.n != null) {
            q().post(new Runnable() { // from class: com.byazt.ca.w.3
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadListener appDownloadListener = w.this.n;
                    if (w.this.n(appDownloadListener)) {
                        appDownloadListener.onDownloadPaused(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nf.fs
    public void s(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.n != null) {
            q().post(new Runnable() { // from class: com.byazt.ca.w.4
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadListener appDownloadListener = w.this.n;
                    if (w.this.n(appDownloadListener)) {
                        appDownloadListener.onDownloadFailed(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nf.fs
    public void n(final long j, final String str, final String str2) throws RemoteException {
        if (this.n != null) {
            q().post(new Runnable() { // from class: com.byazt.ca.w.5
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadListener appDownloadListener = w.this.n;
                    if (w.this.n(appDownloadListener)) {
                        appDownloadListener.onDownloadFinished(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nf.fs
    public void n(final String str, final String str2) throws RemoteException {
        if (this.n != null) {
            q().post(new Runnable() { // from class: com.byazt.ca.w.6
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadListener appDownloadListener = w.this.n;
                    if (w.this.n(appDownloadListener)) {
                        String str3 = str;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = str2;
                        appDownloadListener.onInstalled(str3, str4 != null ? str4 : "");
                    }
                }
            });
        }
    }

    public void s() {
        this.n = null;
        this.qg = null;
    }
}
