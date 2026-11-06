package com.byazt.wc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.cvl.vk;
import com.byazt.eld.k;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.lj.Downloader;
import com.byazt.shh.uc;
import com.byazt.uk.m;
import com.byazt.uk.w;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1487, 37})
public class pr {
    public static pr hw;
    public static final String pr = pr.class.getSimpleName();
    public String c;
    public CopyOnWriteArrayList<com.byazt.shh.pr> hn;
    public hw uc;
    public boolean x = false;

    /* JADX INFO: renamed from: com.byazt.wc.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0221pr {
        void pr();
    }

    private pr() {
        hw hwVar = new hw();
        this.uc = hwVar;
        this.hn = hwVar.pr("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static pr pr() {
        if (hw == null) {
            hw = new pr();
        }
        return hw;
    }

    private boolean pr(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0221pr interfaceC0221pr) {
        if (downloadInfo == null) {
            try {
                if (this.hn.isEmpty()) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.hn.isEmpty()) {
                pr(activity, new com.byazt.shh.pr(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0221pr);
                return true;
            }
            long jLastModified = 0;
            if (downloadInfo != null) {
                jLastModified = new File(downloadInfo.getTargetFilePath()).lastModified();
            }
            CopyOnWriteArrayList<com.byazt.shh.pr> copyOnWriteArrayList = this.hn;
            ListIterator<com.byazt.shh.pr> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (listIterator.hasPrevious()) {
                com.byazt.shh.pr prVarPrevious = listIterator.previous();
                if (prVarPrevious != null && !m.c(k.getContext(), prVarPrevious.x) && m.pr(prVarPrevious.fw)) {
                    if (new File(prVarPrevious.fw).lastModified() >= jLastModified) {
                        pr(activity, prVarPrevious, z, interfaceC0221pr);
                    } else {
                        pr(activity, new com.byazt.shh.pr(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0221pr);
                    }
                    w.pr(pr, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
                    return z2;
                }
            }
            z2 = false;
            w.pr(pr, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
            return z2;
        }
        return false;
    }

    public boolean pr(Activity activity, boolean z, InterfaceC0221pr interfaceC0221pr) {
        if (k.aj().optInt("disable_install_app_dialog") == 1 || this.x) {
            return false;
        }
        return pr(activity, pr(activity), z, interfaceC0221pr);
    }

    public void pr(Context context, com.byazt.shh.pr prVar, boolean z, InterfaceC0221pr interfaceC0221pr) {
        this.hn.clear();
        pr(context, prVar, interfaceC0221pr, z);
        this.x = true;
        vk.pr(context).hn();
        this.uc.hw("sp_ad_install_back_dialog", "key_uninstalled_list");
        w.pr(pr, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo pr(Context context) {
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            long jHw = vk.pr(context).hw();
            if (k.aj().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK)) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
                long j = 0;
                for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                    if (downloadInfo2 != null && !m.c(context, downloadInfo2.getPackageName()) && m.pr(downloadInfo2.getTargetFilePath())) {
                        long jLastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                        if (jLastModified >= jHw && downloadInfo2.getExtra() != null) {
                            try {
                                if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp")) {
                                    if (j == 0) {
                                        downloadInfo = downloadInfo2;
                                        j = jLastModified;
                                    } else if (jLastModified > j) {
                                        downloadInfo = downloadInfo2;
                                        j = jLastModified;
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
                return downloadInfo;
            }
            return null;
        } catch (Exception e2) {
        }
    }

    public void pr(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.hn.size(); i++) {
            com.byazt.shh.pr prVar = this.hn.get(i);
            if (prVar != null && prVar.hw == j2) {
                this.hn.set(i, new com.byazt.shh.pr(j, j2, j3, str, str2, str3, str4));
                this.uc.pr("sp_ad_install_back_dialog", "key_uninstalled_list", this.hn);
                return;
            }
        }
        this.hn.add(new com.byazt.shh.pr(j, j2, j3, str, str2, str3, str4));
        this.uc.pr("sp_ad_install_back_dialog", "key_uninstalled_list", this.hn);
    }

    private void pr(final Context context, final com.byazt.shh.pr prVar, final InterfaceC0221pr interfaceC0221pr, boolean z) {
        final com.byazt.tia.hw hwVarX = uc.pr().x(prVar.hw);
        if (hwVarX == null) {
            com.byazt.vi.hn.pr().pr("showBackInstallDialog nativeModel null");
            return;
        }
        com.byazt.zv.m mVarHn = k.hn();
        com.byazt.cxa.hw.pr prVarPr = new com.byazt.cxa.hw.pr(context).pr(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(prVar.c) ? "刚刚下载的应用" : prVar.c;
        mVarHn.hw(prVarPr.hw(String.format("%1$s下载完成，是否立即安装？", objArr)).hn("立即安装").x(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).pr(false).pr(m.pr(context, prVar.fw)).pr(new com.byazt.cxa.hw.InterfaceC0036hw() { // from class: com.byazt.wc.pr.1
            @Override // com.byazt.cxa.hw.InterfaceC0036hw
            public void pr(DialogInterface dialogInterface) {
                com.byazt.mf.pr.pr().hw("backdialog_install", hwVarX);
                com.byazt.mdu.x.pr(context, (int) prVar.pr);
                dialogInterface.dismiss();
            }

            @Override // com.byazt.cxa.hw.InterfaceC0036hw
            public void hw(DialogInterface dialogInterface) {
                com.byazt.mf.pr.pr().hw("backdialog_exit", hwVarX);
                InterfaceC0221pr interfaceC0221pr2 = interfaceC0221pr;
                if (interfaceC0221pr2 != null) {
                    interfaceC0221pr2.pr();
                }
                pr.this.hw("");
                dialogInterface.dismiss();
            }

            @Override // com.byazt.cxa.hw.InterfaceC0036hw
            public void hn(DialogInterface dialogInterface) {
                pr.this.hw("");
            }
        }).pr(1).pr());
        com.byazt.mf.pr.pr().hw("backdialog_show", hwVarX);
        this.c = prVar.x;
    }

    public boolean pr(String str) {
        return TextUtils.equals(this.c, str);
    }

    public void hw(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = "";
        } else if (TextUtils.equals(this.c, str)) {
            this.c = "";
        }
    }

    public void pr(com.byazt.tia.hw hwVar) {
        if (k.aj().optInt("enable_open_app_dialog", 0) == 1 && !hwVar.l() && hwVar.yb() && Build.VERSION.SDK_INT < 34) {
            hwVar.w(true);
            TTDelegateActivity.pr(hwVar);
        }
    }
}
