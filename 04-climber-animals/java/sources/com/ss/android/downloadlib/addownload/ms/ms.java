package com.ss.android.downloadlib.addownload.ms;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.download.api.config.sl;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.downloadlib.addownload.xr.c;
import com.ss.android.downloadlib.ch;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4432ms = "ms";
    private static ms xr;
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.xr.ms> ah;
    private xr c;
    private boolean d = false;
    private String ka;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.ms.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0535ms {
        void ms();
    }

    private ms() {
        xr xrVar = new xr();
        this.c = xrVar;
        this.ah = xrVar.ms("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static ms ms() {
        if (xr == null) {
            xr = new ms();
        }
        return xr;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004f A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:20:0x004f, B:22:0x005f, B:23:0x0069, B:25:0x006f, B:27:0x0077, B:29:0x0083, B:31:0x008b, B:33:0x009a, B:36:0x00c0, B:34:0x009e), top: B:40:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:21:0x005d  */
    /* JADX WARN: Code duplicated, block: B:25:0x006f A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:20:0x004f, B:22:0x005f, B:23:0x0069, B:25:0x006f, B:27:0x0077, B:29:0x0083, B:31:0x008b, B:33:0x009a, B:36:0x00c0, B:34:0x009e), top: B:40:0x000b }] */
    private boolean ms(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0535ms interfaceC0535ms) {
        long jLastModified;
        ListIterator<com.ss.android.downloadlib.addownload.xr.ms> listIterator;
        com.ss.android.downloadlib.addownload.xr.ms msVarPrevious;
        if (downloadInfo == null) {
            try {
                if (this.ah.isEmpty()) {
                    return false;
                }
                if (activity != null && !activity.isFinishing()) {
                    boolean z2 = true;
                    if (downloadInfo == null && this.ah.isEmpty()) {
                        ms(activity, new com.ss.android.downloadlib.addownload.xr.ms(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0535ms);
                        return true;
                    }
                    if (downloadInfo != null) {
                        jLastModified = new File(downloadInfo.getTargetFilePath()).lastModified();
                    } else {
                        jLastModified = 0;
                    }
                    CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.xr.ms> copyOnWriteArrayList = this.ah;
                    listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
                    while (listIterator.hasPrevious()) {
                        msVarPrevious = listIterator.previous();
                        if (msVarPrevious == null && !zb.ka(hi.getContext(), msVarPrevious.d) && zb.ms(msVarPrevious.ab)) {
                            if (new File(msVarPrevious.ab).lastModified() >= jLastModified) {
                                ms(activity, msVarPrevious, z, interfaceC0535ms);
                            } else {
                                ms(activity, new com.ss.android.downloadlib.addownload.xr.ms(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0535ms);
                            }
                            com.ss.android.downloadlib.ab.hi.ms(f4432ms, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
                            return z2;
                        }
                    }
                    z2 = false;
                    com.ss.android.downloadlib.ab.hi.ms(f4432ms, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
                    return z2;
                }
            } catch (Exception e) {
                ab.ms(e);
            }
        } else if (activity != null) {
            boolean z3 = true;
            if (downloadInfo == null) {
            }
            if (downloadInfo != null) {
                jLastModified = new File(downloadInfo.getTargetFilePath()).lastModified();
            } else {
                jLastModified = 0;
            }
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.xr.ms> copyOnWriteArrayList2 = this.ah;
            listIterator = copyOnWriteArrayList2.listIterator(copyOnWriteArrayList2.size());
            while (listIterator.hasPrevious()) {
                msVarPrevious = listIterator.previous();
                if (msVarPrevious == null) {
                }
            }
            z3 = false;
            com.ss.android.downloadlib.ab.hi.ms(f4432ms, "tryShowInstallDialog isShow:".concat(String.valueOf(z3)), null);
            return z3;
        }
        return false;
    }

    public boolean ms(Activity activity, boolean z, InterfaceC0535ms interfaceC0535ms) {
        if (hi.ny().optInt("disable_install_app_dialog") == 1 || this.d) {
            return false;
        }
        return ms(activity, ms(activity), z, interfaceC0535ms);
    }

    public void ms(Context context, com.ss.android.downloadlib.addownload.xr.ms msVar, boolean z, InterfaceC0535ms interfaceC0535ms) {
        this.ah.clear();
        ms(context, msVar, interfaceC0535ms, z);
        this.d = true;
        ch.ms(context).ah();
        this.c.xr("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.ab.hi.ms(f4432ms, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo ms(Context context) {
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            long jXr = ch.ms(context).xr();
            if (hi.ny().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
                long j = 0;
                for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                    if (downloadInfo2 != null && !zb.ka(context, downloadInfo2.getPackageName()) && zb.ms(downloadInfo2.getTargetFilePath())) {
                        long jLastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                        if (jLastModified >= jXr && downloadInfo2.getExtra() != null) {
                            try {
                                if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || jLastModified > j)) {
                                    downloadInfo = downloadInfo2;
                                    j = jLastModified;
                                }
                            } catch (Exception e) {
                                ab.ms(e);
                            }
                        }
                    }
                }
                return downloadInfo;
            }
            return null;
        } catch (Exception e2) {
            ab.ms(e2);
        }
    }

    public void ms(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.ah.size(); i++) {
            com.ss.android.downloadlib.addownload.xr.ms msVar = this.ah.get(i);
            if (msVar != null && msVar.xr == j2) {
                this.ah.set(i, new com.ss.android.downloadlib.addownload.xr.ms(j, j2, j3, str, str2, str3, str4));
                this.c.ms("sp_ad_install_back_dialog", "key_uninstalled_list", this.ah);
                return;
            }
        }
        this.ah.add(new com.ss.android.downloadlib.addownload.xr.ms(j, j2, j3, str, str2, str3, str4));
        this.c.ms("sp_ad_install_back_dialog", "key_uninstalled_list", this.ah);
    }

    private void ms(final Context context, final com.ss.android.downloadlib.addownload.xr.ms msVar, final InterfaceC0535ms interfaceC0535ms, boolean z) {
        final com.ss.android.downloadad.api.ms.xr xrVarD = c.ms().d(msVar.xr);
        if (xrVarD == null) {
            com.ss.android.downloadlib.ka.ah.ms().ms("showBackInstallDialog nativeModel null");
            return;
        }
        sl slVarAh = hi.ah();
        com.ss.android.download.api.model.xr.ms msVarMs = new com.ss.android.download.api.model.xr.ms(context).ms(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(msVar.ka) ? "刚刚下载的应用" : msVar.ka;
        slVarAh.xr(msVarMs.xr(String.format("%1$s下载完成，是否立即安装？", objArr)).ah("立即安装").d(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).ms(false).ms(zb.ms(context, msVar.ab)).ms(new com.ss.android.download.api.model.xr.InterfaceC0531xr() { // from class: com.ss.android.downloadlib.addownload.ms.ms.1
            @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
            public void ms(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.ms.ms().xr("backdialog_install", xrVarD);
                com.ss.android.socialbase.appdownloader.d.ms(context, (int) msVar.f4455ms);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
            public void xr(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.ms.ms().xr("backdialog_exit", xrVarD);
                InterfaceC0535ms interfaceC0535ms2 = interfaceC0535ms;
                if (interfaceC0535ms2 != null) {
                    interfaceC0535ms2.ms();
                }
                ms.this.xr("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
            public void ah(DialogInterface dialogInterface) {
                ms.this.xr("");
            }
        }).ms(1).ms());
        com.ss.android.downloadlib.d.ms.ms().xr("backdialog_show", xrVarD);
        this.ka = msVar.d;
    }

    public boolean ms(String str) {
        return TextUtils.equals(this.ka, str);
    }

    public void xr(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ka = "";
        } else if (TextUtils.equals(this.ka, str)) {
            this.ka = "";
        }
    }

    public void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        if (hi.ny().optInt("enable_open_app_dialog", 0) == 1 && !xrVar.s() && xrVar.h() && Build.VERSION.SDK_INT < 34) {
            xrVar.hi(true);
            TTDelegateActivity.ms(xrVar);
        }
    }
}
