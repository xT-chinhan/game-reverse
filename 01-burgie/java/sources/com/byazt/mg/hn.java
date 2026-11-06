package com.byazt.mg;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.io.File;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, 20})
public class hn {
    public static volatile hn hn;
    public final Function<SparseArray<Object>, Object> c = new aj.hn();
    public volatile boolean fw;
    public zo.pr uc;
    public final Context x;
    public static final String pr = File.separator + "next";
    public static final String hw = File.separator + "tmp";

    private hn(Context context) {
        this.x = context;
    }

    public static hn pr(Context context) {
        if (hn == null) {
            synchronized (hn.class) {
                if (hn == null) {
                    hn = new hn(context);
                }
            }
        }
        return hn;
    }

    public void pr(List<zo.pr> list) {
        if (list == null || list.isEmpty()) {
            c.pr("plugin_download", "plugin is empty");
            return;
        }
        zo.pr prVar = list.get(0);
        this.uc = prVar;
        if (TextUtils.isEmpty(prVar.hn)) {
            return;
        }
        String str = this.uc.pr + "-" + this.uc.hw + "-" + this.uc.uc + "-" + this.uc.fw + ".apk";
        File fileHn = hn();
        File file = new File(fileHn, str);
        if (file.exists()) {
            c.pr("plugin_download", "plugin file already exists");
            com.byazt.dea.uc.hw("FileDownloadTask", "Plugin file already exists.");
            this.uc.aj = file.getAbsolutePath();
            zo.pr prVar2 = this.uc;
            prVar2.vk = prVar2.hw < 7714;
            pr(true, this.uc.pr, this.uc.toString());
            return;
        }
        File fileHw = hw();
        if (!fileHn.exists()) {
            fileHn.mkdirs();
        }
        if (!fileHw.exists()) {
            fileHw.mkdirs();
        }
        pr(this.uc.hn, fileHn.getAbsolutePath(), fileHw.getAbsolutePath(), str);
    }

    private void pr(String str, String str2, String str3, String str4) {
        if (this.fw) {
            com.byazt.dea.uc.hw("FileDownloadTask", "Downloading...");
            return;
        }
        this.fw = true;
        try {
            File file = new File(str2 + "/" + str4);
            if (file.exists()) {
                file.delete();
            }
            com.byazt.bj.hn.pr().pr(str, str2, str4, new EventListener() { // from class: com.byazt.mg.hn.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    hn.this.fw = false;
                    if (i == 0) {
                        c.pr("plugin_download", "download success");
                        hn.this.uc.aj = result.message();
                        com.byazt.dea.uc.hw("FileDownloadTask", "Download end." + hn.this.uc.aj);
                        hn.this.uc.vk = hn.this.uc.hw < 7714;
                        hn hnVar = hn.this;
                        hnVar.pr(true, hnVar.uc.pr, hn.this.uc.toString());
                        return null;
                    }
                    String strMessage = result.message();
                    c.pr("plugin_download", "download failed: ".concat(String.valueOf(strMessage)));
                    com.byazt.dea.uc.c("FileDownloadTask", "Download failed. ".concat(String.valueOf(strMessage)));
                    hn hnVar2 = hn.this;
                    hnVar2.pr(false, hnVar2.uc.pr, hn.this.uc.toString());
                    return null;
                }
            });
            c.pr("plugin_download", "start download");
            com.byazt.dea.uc.hw("FileDownloadTask", "Download start.");
        } catch (Throwable th) {
            c.pr("plugin_download", "download error: ".concat(String.valueOf(th)));
            com.byazt.dea.uc.c("FileDownloadTask", "Download file error: ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z, String str, String str2) {
        ValueSet valueSetHw = com.byazt.ij.hn.pr().pr(-999900, z ? 0 : 1004).pr(-999903, z).pr(-999902, com.byazt.ij.hn.pr().pr(2, str2).pr(3, str).hw().sparseArray()).hw();
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(-99999979, valueSetHw.sparseArray());
        this.c.apply(sparseArray);
    }

    private File pr() {
        return hw.pr(this.x, "tt_pangle_bykv_file", 0);
    }

    private File hw() {
        return new File(pr(), hw);
    }

    private File hn() {
        return new File(pr(), pr);
    }
}
