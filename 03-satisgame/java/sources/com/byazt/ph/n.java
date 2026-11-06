package com.byazt.ph;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.je.IDownloadListener;
import com.byazt.nf.rv;
import com.byazt.qx.BaseException;
import com.byazt.sk.EnqueueType;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import com.byazt.xv.Downloader;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 513, 19})
public class n implements IDownloadListener {
    public String l;
    public String n;
    public InterfaceC0293n q;
    public String qg;
    public String s;
    public boolean w;
    public int x = 0;
    public boolean fs = true;

    /* JADX INFO: renamed from: com.byazt.ph.n$n, reason: collision with other inner class name */
    public interface InterfaceC0293n {
        void n(DownloadInfo downloadInfo);

        void n(DownloadInfo downloadInfo, int i);

        void n(DownloadInfo downloadInfo, BaseException baseException);

        void n(DownloadInfo downloadInfo, BaseException baseException, int i);

        void qg(DownloadInfo downloadInfo);

        void qg(DownloadInfo downloadInfo, int i);
    }

    @Override // com.byazt.je.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.je.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.je.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.je.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.je.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.je.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.je.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
    }

    @Override // com.byazt.je.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
    }

    public n(String str, String str2, String str3, String str4, boolean z, InterfaceC0293n interfaceC0293n) {
        this.n = str2;
        this.qg = str3;
        this.s = str4;
        this.q = interfaceC0293n;
        this.l = str;
        this.w = z;
    }

    public void n(Context context) {
        DownloadTask downloadTaskMonitorScene = Downloader.with(context).url(this.n).name(this.s).onlyWifi(this.w).savePath(new File(this.qg).getAbsolutePath()).downloadSetting(n()).enqueueType(EnqueueType.ENQUEUE_TAIL).needIndependentProcess(false).subThreadListener(this).monitorScene("plugin_downloader");
        com.byazt.f.n.n(com.byazt.xv.s.n(this.n, new File(this.qg).getAbsolutePath()), n());
        downloadTaskMonitorScene.asyncDownload(null);
    }

    private JSONObject n() {
        JSONObject jSONObjectPv = rv.qg().pv();
        if (jSONObjectPv == null) {
            return null;
        }
        String strOptString = jSONObjectPv.optString("config");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(this.l);
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("default");
            if (jSONObjectOptJSONObject2 != null) {
                return jSONObjectOptJSONObject2;
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    @Override // com.byazt.je.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        int i = this.x + 1;
        this.x = i;
        InterfaceC0293n interfaceC0293n = this.q;
        if (interfaceC0293n != null) {
            if (this.fs) {
                interfaceC0293n.n(downloadInfo);
            } else {
                interfaceC0293n.qg(downloadInfo, i);
            }
        }
    }

    @Override // com.byazt.je.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (this.fs) {
            this.fs = false;
            InterfaceC0293n interfaceC0293n = this.q;
            if (interfaceC0293n != null) {
                interfaceC0293n.qg(downloadInfo);
                return;
            }
            return;
        }
        InterfaceC0293n interfaceC0293n2 = this.q;
        if (interfaceC0293n2 != null) {
            interfaceC0293n2.n(downloadInfo, this.x);
        }
    }

    @Override // com.byazt.je.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (this.fs) {
            this.fs = false;
            InterfaceC0293n interfaceC0293n = this.q;
            if (interfaceC0293n != null) {
                interfaceC0293n.n(downloadInfo, baseException);
                return;
            }
            return;
        }
        InterfaceC0293n interfaceC0293n2 = this.q;
        if (interfaceC0293n2 != null) {
            interfaceC0293n2.n(downloadInfo, baseException, this.x);
        }
    }
}
