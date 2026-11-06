package com.byazt.qyu;

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
@com.byazt.cp.n(n = {0, 1, 1178, 8})
public class s {
    public static final String n = File.separator + "next";
    public static final String qg = File.separator + "tmp";
    public static volatile s s;
    public final Function<SparseArray<Object>, Object> l = new rv.s();
    public final Context q;
    public fs.n w;
    public volatile boolean x;

    private s(Context context) {
        this.q = context;
    }

    public static s n(Context context) {
        if (s == null) {
            synchronized (s.class) {
                if (s == null) {
                    s = new s(context);
                }
            }
        }
        return s;
    }

    public void n(List<fs.n> list) {
        if (list == null || list.isEmpty()) {
            l.n("plugin_download", "plugin is empty");
            return;
        }
        fs.n nVar = list.get(0);
        this.w = nVar;
        if (TextUtils.isEmpty(nVar.s)) {
            return;
        }
        String str = this.w.n + "-" + this.w.qg + "-" + this.w.w + "-" + this.w.x + ".apk";
        File fileS = s();
        File file = new File(fileS, str);
        if (file.exists()) {
            l.n("plugin_download", "plugin file already exists");
            com.byazt.vx.w.qg("FileDownloadTask", "Plugin file already exists.");
            this.w.rv = file.getAbsolutePath();
            fs.n nVar2 = this.w;
            nVar2.tj = nVar2.qg < 7814;
            n(true, this.w.n, this.w.toString());
            return;
        }
        File fileQg = qg();
        if (!fileS.exists()) {
            fileS.mkdirs();
        }
        if (!fileQg.exists()) {
            fileQg.mkdirs();
        }
        n(this.w.s, fileS.getAbsolutePath(), fileQg.getAbsolutePath(), str);
    }

    private void n(String str, String str2, String str3, String str4) {
        if (this.x) {
            com.byazt.vx.w.qg("FileDownloadTask", "Downloading...");
            return;
        }
        this.x = true;
        try {
            File file = new File(str2 + "/" + str4);
            if (file.exists()) {
                file.delete();
            }
            com.byazt.jn.s.n().n(str, str2, str4, new EventListener() { // from class: com.byazt.qyu.s.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    s.this.x = false;
                    if (i == 0) {
                        l.n("plugin_download", "download success");
                        s.this.w.rv = result.message();
                        com.byazt.vx.w.qg("FileDownloadTask", "Download end." + s.this.w.rv);
                        s.this.w.tj = s.this.w.qg < 7814;
                        s sVar = s.this;
                        sVar.n(true, sVar.w.n, s.this.w.toString());
                        return null;
                    }
                    String strMessage = result.message();
                    l.n("plugin_download", "download failed: ".concat(String.valueOf(strMessage)));
                    com.byazt.vx.w.l("FileDownloadTask", "Download failed. ".concat(String.valueOf(strMessage)));
                    s sVar2 = s.this;
                    sVar2.n(false, sVar2.w.n, s.this.w.toString());
                    return null;
                }
            });
            l.n("plugin_download", "start download");
            com.byazt.vx.w.qg("FileDownloadTask", "Download start.");
        } catch (Throwable th) {
            l.n("plugin_download", "download error: ".concat(String.valueOf(th)));
            com.byazt.vx.w.l("FileDownloadTask", "Download file error: ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, String str, String str2) {
        ValueSet valueSetQg = com.byazt.qvu.s.n().n(-999900, z ? 0 : 1004).n(-999903, z).n(-999902, com.byazt.qvu.s.n().n(2, str2).n(3, str).qg().sparseArray()).qg();
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(-99999979, valueSetQg.sparseArray());
        this.l.apply(sparseArray);
    }

    private File n() {
        return qg.n(this.q, "tt_pangle_bykv_file", 0);
    }

    private File qg() {
        return new File(n(), qg);
    }

    private File s() {
        return new File(n(), n);
    }
}
