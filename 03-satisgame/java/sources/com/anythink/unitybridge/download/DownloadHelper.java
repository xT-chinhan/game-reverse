package com.anythink.unitybridge.download;

import com.anythink.china.api.ATAppDownloadListener;
import com.anythink.core.api.ATAdInfo;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.utils.TaskManager;

/* JADX INFO: loaded from: classes.dex */
public class DownloadHelper {
    public static DownloadListener sDownloadListener;

    public DownloadHelper(DownloadListener downloadListener) {
        MsgTools.printMsg("DownloadHelper init");
        if (sDownloadListener == null) {
            sDownloadListener = downloadListener;
        }
    }

    public static ATAppDownloadListener getDownloadListener(final String str) {
        return new ATAppDownloadListener() { // from class: com.anythink.unitybridge.download.DownloadHelper.1
            @Override // com.anythink.china.api.ATAppDownloadListener
            public void onDownloadStart(final ATAdInfo aTAdInfo, final long j, final long j2, final String str2, final String str3) {
                MsgTools.printMsg("onDownloadStart: " + str + ", totalBytes: " + j + ", currBytes: " + j2 + ", fileName: " + str2 + ", appName: " + str3);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.download.DownloadHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DownloadHelper.sDownloadListener != null) {
                            synchronized (DownloadHelper.sDownloadListener) {
                                DownloadHelper.sDownloadListener.onDownloadStart(str, aTAdInfo.toString(), j, j2, str2, str3);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.china.api.ATAppDownloadListener
            public void onDownloadUpdate(final ATAdInfo aTAdInfo, final long j, final long j2, final String str2, final String str3) {
                MsgTools.printMsg("onDownloadUpdate: " + str + ", totalBytes: " + j + ", currBytes: " + j2 + ", fileName: " + str2 + ", appName: " + str3);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.download.DownloadHelper.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DownloadHelper.sDownloadListener != null) {
                            synchronized (DownloadHelper.sDownloadListener) {
                                DownloadHelper.sDownloadListener.onDownloadUpdate(str, aTAdInfo.toString(), j, j2, str2, str3);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.china.api.ATAppDownloadListener
            public void onDownloadPause(final ATAdInfo aTAdInfo, final long j, final long j2, final String str2, final String str3) {
                MsgTools.printMsg("onDownloadPause: " + str + ", totalBytes: " + j + ", currBytes: " + j2 + ", fileName: " + str2 + ", appName: " + str3);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.download.DownloadHelper.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DownloadHelper.sDownloadListener != null) {
                            synchronized (DownloadHelper.sDownloadListener) {
                                DownloadHelper.sDownloadListener.onDownloadPause(str, aTAdInfo.toString(), j, j2, str2, str3);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.china.api.ATAppDownloadListener
            public void onDownloadFinish(final ATAdInfo aTAdInfo, final long j, final String str2, final String str3) {
                MsgTools.printMsg("onDownloadFinish: " + str + ", totalBytes: " + j + ", fileName: " + str2 + ", appName: " + str3);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.download.DownloadHelper.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DownloadHelper.sDownloadListener != null) {
                            synchronized (DownloadHelper.sDownloadListener) {
                                DownloadHelper.sDownloadListener.onDownloadFinish(str, aTAdInfo.toString(), j, str2, str3);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.china.api.ATAppDownloadListener
            public void onDownloadFail(final ATAdInfo aTAdInfo, final long j, final long j2, final String str2, final String str3) {
                MsgTools.printMsg("onDownloadFail: " + str + ", totalBytes: " + j + ", currBytes: " + j2 + ", fileName: " + str2 + ", appName: " + str3);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.download.DownloadHelper.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DownloadHelper.sDownloadListener != null) {
                            synchronized (DownloadHelper.sDownloadListener) {
                                DownloadHelper.sDownloadListener.onDownloadFail(str, aTAdInfo.toString(), j, j2, str2, str3);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.china.api.ATAppDownloadListener
            public void onInstalled(final ATAdInfo aTAdInfo, final String str2, final String str3) {
                MsgTools.printMsg("onInstalled: " + str + ", fileName: " + str2 + ", appName: " + str3);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.download.DownloadHelper.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DownloadHelper.sDownloadListener != null) {
                            synchronized (DownloadHelper.sDownloadListener) {
                                DownloadHelper.sDownloadListener.onInstalled(str, aTAdInfo.toString(), str2, str3);
                            }
                        }
                    }
                });
            }
        };
    }
}
