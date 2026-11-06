package com.byazt.bn;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.q.AdBaseConstants;
import com.byazt.rz.cp;
import com.byazt.rz.oa;
import com.byazt.s.tj;
import com.byazt.ug.d;
import com.byazt.vl.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1240, 19})
public class n {
    public static final String n = "n";
    public static n qg;
    public String l;
    public boolean q = false;
    public CopyOnWriteArrayList<com.byazt.vl.n> s;
    public qg w;

    /* JADX INFO: renamed from: com.byazt.bn.n$n, reason: collision with other inner class name */
    public interface InterfaceC0138n {
        void n();
    }

    private n() {
        qg qgVar = new qg();
        this.w = qgVar;
        this.s = qgVar.n("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static n n() {
        if (qg == null) {
            qg = new n();
        }
        return qg;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004c A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:4:0x000b, B:8:0x0016, B:13:0x0021, B:15:0x0029, B:18:0x004c, B:20:0x005c, B:21:0x0066, B:23:0x006c, B:25:0x0074, B:27:0x0080, B:29:0x0088, B:31:0x0097, B:34:0x00bd, B:32:0x009b), top: B:38:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:4:0x000b, B:8:0x0016, B:13:0x0021, B:15:0x0029, B:18:0x004c, B:20:0x005c, B:21:0x0066, B:23:0x006c, B:25:0x0074, B:27:0x0080, B:29:0x0088, B:31:0x0097, B:34:0x00bd, B:32:0x009b), top: B:38:0x000b }] */
    private boolean n(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0138n interfaceC0138n) {
        long jLastModified;
        ListIterator<com.byazt.vl.n> listIterator;
        com.byazt.vl.n nVarPrevious;
        if (downloadInfo == null) {
            try {
                if (this.s.isEmpty()) {
                    return false;
                }
                if (activity != null && !activity.isFinishing()) {
                    boolean z2 = true;
                    if (downloadInfo == null && this.s.isEmpty()) {
                        n(activity, new com.byazt.vl.n(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0138n);
                        return true;
                    }
                    if (downloadInfo != null) {
                        jLastModified = new File(downloadInfo.getTargetFilePath()).lastModified();
                    } else {
                        jLastModified = 0;
                    }
                    CopyOnWriteArrayList<com.byazt.vl.n> copyOnWriteArrayList = this.s;
                    listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
                    while (listIterator.hasPrevious()) {
                        nVarPrevious = listIterator.previous();
                        if (nVarPrevious == null && !oa.l(d.getContext(), nVarPrevious.q) && oa.n(nVarPrevious.x)) {
                            if (new File(nVarPrevious.x).lastModified() >= jLastModified) {
                                n(activity, nVarPrevious, z, interfaceC0138n);
                            } else {
                                n(activity, new com.byazt.vl.n(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0138n);
                            }
                            cp.n(n, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
                            return z2;
                        }
                    }
                    z2 = false;
                    cp.n(n, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
                    return z2;
                }
            } catch (Exception unused) {
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
            CopyOnWriteArrayList<com.byazt.vl.n> copyOnWriteArrayList2 = this.s;
            listIterator = copyOnWriteArrayList2.listIterator(copyOnWriteArrayList2.size());
            while (listIterator.hasPrevious()) {
                nVarPrevious = listIterator.previous();
                if (nVarPrevious == null) {
                }
            }
            z3 = false;
            cp.n(n, "tryShowInstallDialog isShow:".concat(String.valueOf(z3)), null);
            return z3;
        }
        return false;
    }

    public boolean n(Activity activity, boolean z, InterfaceC0138n interfaceC0138n) {
        if (d.rv().optInt("disable_install_app_dialog") == 1 || this.q) {
            return false;
        }
        return n(activity, n(activity), z, interfaceC0138n);
    }

    public void n(Context context, com.byazt.vl.n nVar, boolean z, InterfaceC0138n interfaceC0138n) {
        this.s.clear();
        n(context, nVar, interfaceC0138n, z);
        this.q = true;
        tj.n(context).s();
        this.w.qg("sp_ad_install_back_dialog", "key_uninstalled_list");
        cp.n(n, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo n(Context context) {
        DownloadInfo downloadInfo = null;
        try {
            long jQg = tj.n(context).qg();
            if (d.rv().optInt("enable_miniapp_dialog", 0) == 0) {
                return null;
            }
            List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
            if (successedDownloadInfosWithMimeType != null && !successedDownloadInfosWithMimeType.isEmpty()) {
                long j = 0;
                for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                    if (downloadInfo2 != null && !oa.l(context, downloadInfo2.getPackageName()) && oa.n(downloadInfo2.getTargetFilePath())) {
                        long jLastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                        if (jLastModified >= jQg && downloadInfo2.getExtra() != null) {
                            try {
                                if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || jLastModified > j)) {
                                    downloadInfo = downloadInfo2;
                                    j = jLastModified;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return downloadInfo;
    }

    public void n(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.s.size(); i++) {
            com.byazt.vl.n nVar = this.s.get(i);
            if (nVar != null && nVar.qg == j2) {
                this.s.set(i, new com.byazt.vl.n(j, j2, j3, str, str2, str3, str4));
                this.w.n("sp_ad_install_back_dialog", "key_uninstalled_list", this.s);
                return;
            }
        }
        this.s.add(new com.byazt.vl.n(j, j2, j3, str, str2, str3, str4));
        this.w.n("sp_ad_install_back_dialog", "key_uninstalled_list", this.s);
    }

    private void n(final Context context, final com.byazt.vl.n nVar, final InterfaceC0138n interfaceC0138n, boolean z) {
        final com.byazt.h.qg qgVarQ = w.n().q(nVar.qg);
        if (qgVarQ == null) {
            com.byazt.ch.s.n().n("showBackInstallDialog nativeModel null");
            return;
        }
        com.byazt.ky.oa oaVarS = d.s();
        com.byazt.os.qg.n nVarN = new com.byazt.os.qg.n(context).n(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(nVar.l) ? "刚刚下载的应用" : nVar.l;
        oaVarS.qg(nVarN.qg(String.format("%1$s下载完成，是否立即安装？", objArr)).s("立即安装").q(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).n(false).n(oa.n(context, nVar.x)).n(new com.byazt.os.qg.InterfaceC0286qg() { // from class: com.byazt.bn.n.1
            @Override // com.byazt.os.qg.InterfaceC0286qg
            public void n(DialogInterface dialogInterface) {
                com.byazt.vj.n.n().qg("backdialog_install", qgVarQ);
                com.byazt.e.q.n(context, (int) nVar.n);
                dialogInterface.dismiss();
            }

            @Override // com.byazt.os.qg.InterfaceC0286qg
            public void qg(DialogInterface dialogInterface) {
                com.byazt.vj.n.n().qg("backdialog_exit", qgVarQ);
                InterfaceC0138n interfaceC0138n2 = interfaceC0138n;
                if (interfaceC0138n2 != null) {
                    interfaceC0138n2.n();
                }
                n.this.qg("");
                dialogInterface.dismiss();
            }

            @Override // com.byazt.os.qg.InterfaceC0286qg
            public void s(DialogInterface dialogInterface) {
                n.this.qg("");
            }
        }).n(1).n());
        com.byazt.vj.n.n().qg("backdialog_show", qgVarQ);
        this.l = nVar.q;
    }

    public boolean n(String str) {
        return TextUtils.equals(this.l, str);
    }

    public void qg(String str) {
        if (TextUtils.isEmpty(str)) {
            this.l = "";
        } else if (TextUtils.equals(this.l, str)) {
            this.l = "";
        }
    }

    public void n(com.byazt.h.qg qgVar) {
        if (d.rv().optInt("enable_open_app_dialog", 0) == 1 && !qgVar.e() && qgVar.hd() && Build.VERSION.SDK_INT < 34) {
            qgVar.cp(true);
            TTDelegateActivity.n(qgVar);
        }
    }
}
