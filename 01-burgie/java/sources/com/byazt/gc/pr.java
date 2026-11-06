package com.byazt.gc;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.fn.IDownloadListener;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.mrs.EnqueueType;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, 37})
public class pr implements IDownloadListener {
    public String c;
    public String hn;
    public String hw;
    public String pr;
    public boolean uc;
    public InterfaceC0076pr x;
    public int fw = 0;
    public boolean zo = true;

    /* JADX INFO: renamed from: com.byazt.gc.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0076pr {
        void hw(DownloadInfo downloadInfo);

        void hw(DownloadInfo downloadInfo, int i);

        void pr(DownloadInfo downloadInfo);

        void pr(DownloadInfo downloadInfo, int i);

        void pr(DownloadInfo downloadInfo, BaseException baseException);

        void pr(DownloadInfo downloadInfo, BaseException baseException, int i);
    }

    public pr(String str, String str2, String str3, String str4, boolean z, InterfaceC0076pr interfaceC0076pr) {
        this.pr = str2;
        this.hw = str3;
        this.hn = str4;
        this.x = interfaceC0076pr;
        this.c = str;
        this.uc = z;
    }

    public void pr(Context context) {
        DownloadTask downloadTaskMonitorScene = Downloader.with(context).url(this.pr).name(this.hn).onlyWifi(this.uc).savePath(new File(this.hw).getAbsolutePath()).downloadSetting(pr()).enqueueType(EnqueueType.ENQUEUE_TAIL).needIndependentProcess(false).subThreadListener(this).monitorScene("plugin_downloader");
        com.byazt.ew.pr.pr(com.byazt.lj.hn.pr(this.pr, new File(this.hw).getAbsolutePath()), pr());
        downloadTaskMonitorScene.asyncDownload(null);
    }

    private JSONObject pr() {
        JSONObject jSONObjectUv = a.hw().uv();
        if (jSONObjectUv == null) {
            return null;
        }
        String strOptString = jSONObjectUv.optString("config");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(this.c);
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("default");
            if (jSONObjectOptJSONObject2 == null) {
                return null;
            }
            return jSONObjectOptJSONObject2;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        int i = this.fw + 1;
        this.fw = i;
        InterfaceC0076pr interfaceC0076pr = this.x;
        if (interfaceC0076pr != null) {
            if (this.zo) {
                interfaceC0076pr.pr(downloadInfo);
            } else {
                interfaceC0076pr.hw(downloadInfo, i);
            }
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (this.zo) {
            this.zo = false;
            InterfaceC0076pr interfaceC0076pr = this.x;
            if (interfaceC0076pr != null) {
                interfaceC0076pr.hw(downloadInfo);
                return;
            }
            return;
        }
        InterfaceC0076pr interfaceC0076pr2 = this.x;
        if (interfaceC0076pr2 != null) {
            interfaceC0076pr2.pr(downloadInfo, this.fw);
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (this.zo) {
            this.zo = false;
            InterfaceC0076pr interfaceC0076pr = this.x;
            if (interfaceC0076pr != null) {
                interfaceC0076pr.pr(downloadInfo, baseException);
                return;
            }
            return;
        }
        InterfaceC0076pr interfaceC0076pr2 = this.x;
        if (interfaceC0076pr2 != null) {
            interfaceC0076pr2.pr(downloadInfo, baseException, this.fw);
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
    }
}
