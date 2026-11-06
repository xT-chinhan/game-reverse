package com.byazt.eld;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.cxa.DownloadShortInfo;
import com.byazt.fn.IDownloadListener;
import com.byazt.km.AdDownloadModel;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.mdu.DownloadHandlerService;
import com.byazt.zv.IDownloadButtonClickListener;
import com.byazt.zv.OnItemClickListener;
import com.byazt.zv.cz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements fw, com.byazt.uk.g.pr {
    public static final String pr = c.class.getSimpleName();
    public final boolean a;
    public hn aj;
    public WeakReference<Context> c;
    public SoftReference<IDownloadButtonClickListener> cz;
    public DownloadShortInfo fw;
    public long g;
    public zo hn;
    public DownloadModel ho;
    public final com.byazt.uk.g hw;
    public long k;
    public SoftReference<OnItemClickListener> lb;
    public String m;
    public DownloadEventConfig nt;
    public boolean qa;
    public final Map<Integer, Object> uc;
    public final IDownloadListener vk;
    public boolean w;
    public x x;
    public DownloadController yb;
    public DownloadInfo zo;

    interface hw {
        void pr(long j);
    }

    interface pr {
        void pr();
    }

    public c() {
        com.byazt.uk.g gVar = new com.byazt.uk.g(Looper.getMainLooper(), this);
        this.hw = gVar;
        this.uc = new ConcurrentHashMap();
        this.vk = new zo.pr(gVar);
        this.g = -1L;
        this.ho = null;
        this.nt = null;
        this.yb = null;
        this.hn = new zo(this);
        this.x = new x(gVar);
        this.a = com.byazt.ew.pr.hn().pr("ttdownloader_callback_twice");
    }

    @Override // com.byazt.eld.fw
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public c hw(Context context) {
        if (context != null) {
            this.c = new WeakReference<>(context);
        }
        k.hw(context);
        return this;
    }

    @Override // com.byazt.eld.fw
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public c hw(int i, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (k.aj().optInt("back_use_softref_listener") == 1) {
                this.uc.put(Integer.valueOf(i), downloadStatusChangeListener);
            } else if (k.aj().optInt("use_weakref_listener") == 1) {
                this.uc.put(Integer.valueOf(i), new WeakReference(downloadStatusChangeListener));
            } else {
                this.uc.put(Integer.valueOf(i), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.byazt.eld.fw
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public c hw(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.byazt.vi.hn.pr().pr("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.byazt.vi.hn.pr().pr(false, "setDownloadModel id=0");
                if (com.byazt.ew.pr.hn().pr("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.byazt.shh.uc.pr().pr(downloadModel);
            this.g = downloadModel.getId();
            this.ho = downloadModel;
            if (aj.pr(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(this.g);
                if (hwVarX != null && hwVarX.k() != 3) {
                    hwVarX.c(3L);
                    com.byazt.shh.aj.pr().pr(hwVarX);
                }
            }
        }
        return this;
    }

    @Override // com.byazt.eld.fw
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public c hw(DownloadController downloadController) {
        JSONObject extra;
        this.yb = downloadController;
        if (com.byazt.uk.c.hw(this.ho).hw("force_auto_open") == 1) {
            m().setLinkMode(1);
        }
        if (com.byazt.ew.pr.hn().pr("fix_show_dialog") && (extra = this.ho.getExtra()) != null && extra.optInt("subprocess") > 0) {
            m().setEnableNewActivity(false);
        }
        com.byazt.shh.uc.pr().pr(this.g, m());
        return this;
    }

    @Override // com.byazt.eld.fw
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public c hw(DownloadEventConfig downloadEventConfig) {
        this.nt = downloadEventConfig;
        this.qa = k().getDownloadScene() == 0;
        com.byazt.shh.uc.pr().pr(this.g, k());
        return this;
    }

    @Override // com.byazt.eld.fw
    public fw pr(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.lb = null;
        } else {
            this.lb = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.byazt.eld.fw
    public void pr() {
        this.w = true;
        com.byazt.shh.uc.pr().pr(this.g, k());
        com.byazt.shh.uc.pr().pr(this.g, m());
        this.hn.pr(this.g);
        nt();
        if (k.aj().optInt("enable_empty_listener", 1) == 1 && this.uc.get(Integer.MIN_VALUE) == null) {
            hw(Integer.MIN_VALUE, new com.byazt.zv.pr());
        }
    }

    @Override // com.byazt.eld.fw
    public boolean pr(int i) {
        if (i == 0) {
            this.uc.clear();
        } else {
            this.uc.remove(Integer.valueOf(i));
        }
        if (this.uc.isEmpty()) {
            this.w = false;
            this.k = System.currentTimeMillis();
            if (this.zo != null) {
                Downloader.getInstance(k.getContext()).removeTaskMainListener(this.zo.getId());
            }
            hn hnVar = this.aj;
            if (hnVar != null && hnVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.aj.cancel(true);
            }
            this.hn.pr(this.zo);
            String str = pr;
            StringBuilder sb = new StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.zo;
            com.byazt.uk.w.pr(str, sb.append(downloadInfo == null ? "" : downloadInfo.getUrl()).toString(), null);
            this.hw.removeCallbacksAndMessages(null);
            this.fw = null;
            this.zo = null;
            return true;
        }
        if (this.uc.size() == 1 && this.uc.containsKey(Integer.MIN_VALUE)) {
            this.hn.hw(this.zo);
        }
        return false;
    }

    @Override // com.byazt.eld.fw
    public void pr(boolean z) {
        if (this.zo != null) {
            if (z) {
                com.byazt.zkm.c cVarHn = com.byazt.mdu.x.w().hn();
                if (cVarHn != null) {
                    cVarHn.pr(this.zo);
                }
                Downloader.getInstance(com.byazt.lj.hn.of()).cancel(this.zo.getId(), true);
                return;
            }
            Intent intent = new Intent(k.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.zo.getId());
            k.getContext().startService(intent);
        }
    }

    @Override // com.byazt.eld.fw
    public boolean hw() {
        return this.w;
    }

    public boolean hn() {
        DownloadInfo downloadInfo = this.zo;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    @Override // com.byazt.eld.fw
    public long x() {
        return this.k;
    }

    @Override // com.byazt.eld.fw
    public fw pr(long j) {
        if (j != 0) {
            DownloadModel downloadModelPr = com.byazt.shh.uc.pr().pr(j);
            if (downloadModelPr != null) {
                this.ho = downloadModelPr;
                this.g = j;
                this.hn.pr(j);
            }
        } else {
            com.byazt.vi.hn.pr().pr(false, "setModelId");
        }
        return this;
    }

    @Override // com.byazt.eld.fw
    public void hw(final int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.hn.pr(this.g);
        if (!com.byazt.shh.uc.pr().c(this.g).z()) {
            com.byazt.vi.hn.pr().pr("handleDownload ModelBox !isStrictValid");
        }
        if (this.hn.pr(i, this.ho)) {
            com.byazt.xqu.uc.pr().pr(this.hn.pr, new com.byazt.xqu.zo() { // from class: com.byazt.eld.c.1
                @Override // com.byazt.xqu.zo
                public void pr(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (!com.byazt.uk.zo.pr(c.this.getContext(), c.this.hn.pr, str, jSONObject, true, i)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.byazt.xqu.uc.pr().pr(1, c.this.hn.pr, jSONObject);
                            switch (i) {
                                case 1:
                                    com.byazt.p000do.pr.pr(c.pr, "miui new rollback fail: handleDownload id:" + c.this.g + ",tryPerformButtonClick:", null);
                                    c.this.hn(true);
                                    break;
                                case 2:
                                    com.byazt.p000do.pr.pr(c.pr, "miui new rollback fail: handleDownload id:" + c.this.g + ",tryPerformButtonClick:", null);
                                    c.this.hw(true);
                                    break;
                            }
                            return;
                        }
                        jSONObject.putOpt("download_miui_jump_market_success", 1);
                        com.byazt.xqu.uc.pr().pr(0, c.this.hn.pr, jSONObject);
                    } catch (Exception e) {
                        com.byazt.vi.hn.pr().pr(e, "generate miui new market param error");
                    }
                }

                @Override // com.byazt.xqu.zo
                public void pr() {
                    switch (i) {
                        case 1:
                            com.byazt.p000do.pr.pr(c.pr, "miui new get miui deeplink fail: handleDownload id:" + c.this.g + ",tryPerformButtonClick:", null);
                            c.this.hn(true);
                            break;
                        case 2:
                            com.byazt.p000do.pr.pr(c.pr, "miui new get miui deeplink fail: handleDownload id:" + c.this.g + ",tryPerformButtonClick:", null);
                            c.this.hw(true);
                            break;
                    }
                }
            });
            return;
        }
        if (!this.hn.pr(getContext(), i, this.qa)) {
            boolean zHn = hn(i);
            switch (i) {
                case 1:
                    if (!zHn) {
                        com.byazt.uk.w.pr(pr, "handleDownload id:" + this.g + ",pIC:", null);
                        hn(true);
                        return;
                    }
                    return;
                case 2:
                    if (!zHn) {
                        com.byazt.uk.w.pr(pr, "handleDownload id:" + this.g + ",pBC:", null);
                        hw(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public boolean c() {
        return k.aj().optInt("quick_app_enable_switch", 0) == 0 && this.ho.getQuickAppModel() != null && !TextUtils.isEmpty(this.ho.getQuickAppModel().pr()) && com.byazt.eld.hn.pr(this.zo) && com.byazt.uk.m.pr(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.ho.getQuickAppModel().pr())));
    }

    private boolean hn(int i) {
        if (!c()) {
            return false;
        }
        int i2 = -1;
        String strPr = this.ho.getQuickAppModel().pr();
        switch (i) {
            case 1:
                i2 = 5;
                break;
            case 2:
                i2 = 4;
                break;
        }
        DownloadModel downloadModel = this.ho;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean zHn = com.byazt.uk.aj.hn(k.getContext(), strPr);
        if (zHn) {
            com.byazt.mf.pr.pr().pr(this.g, i);
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.obj = Long.valueOf(this.ho.getId());
            com.byazt.eld.hn.pr().pr(this, i2, this.ho);
        } else {
            com.byazt.mf.pr.pr().pr(this.g, false, 0);
        }
        return zHn;
    }

    public void hw(boolean z) {
        c(z);
    }

    private void w() {
        SoftReference<OnItemClickListener> softReference = this.lb;
        if (softReference != null && softReference.get() != null) {
            this.lb.get().onItemClick(this.ho, k(), m());
            this.lb = null;
        } else {
            k.hw();
            getContext();
            m();
            k();
        }
    }

    public void hn(boolean z) {
        if (z) {
            com.byazt.mf.pr.pr().pr(this.g, 1);
        }
        g();
    }

    private void c(boolean z) {
        if (com.byazt.uk.c.hw(this.ho).hw("notification_opt_2") == 1 && this.zo != null) {
            com.byazt.lxs.hw.pr().uc(this.zo.getId());
        }
        uc(z);
    }

    public void uc() {
        this.hw.post(new Runnable() { // from class: com.byazt.eld.c.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = zo.pr((Map<Integer, Object>) c.this.uc).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(c.this.yb());
                }
            }
        });
    }

    @Override // com.byazt.uk.g.pr
    public void pr(Message message) {
        if (message == null || !this.w) {
            return;
        }
        switch (message.what) {
            case 3:
                this.zo = (DownloadInfo) message.obj;
                this.hn.pr(message, yb(), this.uc);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            return this.c.get();
        }
        return k.getContext();
    }

    private DownloadEventConfig k() {
        DownloadEventConfig downloadEventConfig = this.nt;
        return downloadEventConfig == null ? new com.byazt.bek.x.pr().pr() : downloadEventConfig;
    }

    private DownloadController m() {
        if (this.yb == null) {
            this.yb = new com.byazt.bek.hn();
        }
        return this.yb;
    }

    private void g() {
        String str = pr;
        com.byazt.uk.w.pr(str, "pICD", null);
        if (this.hn.x(this.zo)) {
            com.byazt.uk.w.pr(str, "pICD BC", null);
            uc(false);
        } else {
            com.byazt.uk.w.pr(str, "pICD IC", null);
            w();
        }
    }

    private void uc(final boolean z) {
        DownloadModel downloadModel;
        String str = pr;
        com.byazt.uk.w.pr(str, "pBCD", null);
        if (ho()) {
            com.byazt.shh.c cVarC = com.byazt.shh.uc.pr().c(this.g);
            if (this.qa) {
                if (aj()) {
                    if (x(false) && cVarC.x != null && cVarC.x.isAutoDownloadOnCardShow()) {
                        pr(z, true);
                        return;
                    }
                    return;
                }
                pr(z, true);
                return;
            }
            if (this.ho.isAd() && cVarC.x != null && cVarC.x.enableShowComplianceDialog() && cVarC.hw != null && com.byazt.xqu.hw.pr().pr(cVarC.hw) && com.byazt.xqu.hw.pr().pr(cVarC)) {
                return;
            }
            pr(z, true);
            return;
        }
        com.byazt.uk.w.pr(str, "pBCD continue download, status:" + this.zo.getStatus(), null);
        DownloadInfo downloadInfo = this.zo;
        if (downloadInfo != null && (downloadModel = this.ho) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.zo.getStatus();
        final int id = this.zo.getId();
        final com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(this.zo);
        if (status == -2 || status == -1) {
            this.hn.pr(this.zo, z);
            if (hwVarPr != null) {
                hwVarPr.zo(System.currentTimeMillis());
                hwVarPr.aj(this.zo.getCurBytes());
            }
            this.zo.setDownloadFromReserveWifi(false);
            this.x.pr(new com.byazt.shh.c(this.g, this.ho, k(), m()));
            this.x.pr(id, this.zo.getCurBytes(), this.zo.getTotalBytes(), new pr() { // from class: com.byazt.eld.c.3
                @Override // com.byazt.eld.c.pr
                public void pr() {
                    if (c.this.x.pr()) {
                        return;
                    }
                    c cVar = c.this;
                    cVar.pr(id, status, cVar.zo);
                }
            });
            if (status == -2 && com.byazt.uk.c.pr((com.byazt.tia.pr) hwVarPr).pr("show_pause_continue_toast", 0) == 1) {
                com.byazt.cvl.zo.pr().hw().postDelayed(new Runnable() { // from class: com.byazt.eld.c.4
                    @Override // java.lang.Runnable
                    public void run() {
                        k.hn().pr(13, k.getContext(), c.this.ho, "已恢复下载", null, 0);
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (ho.pr(status)) {
            if (!this.ho.enablePause()) {
                return;
            }
            this.x.pr(true);
            com.byazt.sxm.zo.pr().hw(com.byazt.shh.uc.pr().x(this.g));
            if (com.byazt.uk.c.pr((com.byazt.tia.pr) hwVarPr).pr("cancel_pause_optimise_switch", 0) == 1) {
                com.byazt.yey.x.pr().pr(hwVarPr, status, new com.byazt.yey.zo() { // from class: com.byazt.eld.c.6
                    @Override // com.byazt.yey.zo
                    public void pr(com.byazt.tia.hw hwVar) {
                        if (c.this.zo == null && com.byazt.ew.pr.hn().pr("fix_handle_pause")) {
                            c.this.zo = Downloader.getInstance(k.getContext()).getDownloadInfo(id);
                        }
                        c.this.hn.pr(c.this.zo, z);
                        if (c.this.zo == null || !com.byazt.tuy.uc.hw(k.getContext()) || !c.this.zo.isPauseReserveOnWifi()) {
                            w.pr().pr(c.this.ho, c.this.zo);
                            hwVar.w(System.currentTimeMillis());
                            c cVar = c.this;
                            cVar.pr(id, status, cVar.zo);
                            return;
                        }
                        c.this.zo.stopPauseReserveOnWifi();
                        com.byazt.mf.pr.pr().pr("cancel_pause_reserve_wifi_cancel_on_wifi", hwVarPr);
                    }
                }, new com.byazt.wc.hn() { // from class: com.byazt.eld.c.5
                    @Override // com.byazt.wc.hn
                    public void delete() {
                        c.this.pr(true);
                    }
                });
                return;
            } else {
                com.byazt.yey.w.pr().pr(hwVarPr, status, new com.byazt.yey.zo() { // from class: com.byazt.eld.c.7
                    @Override // com.byazt.yey.zo
                    public void pr(com.byazt.tia.hw hwVar) {
                        if (c.this.zo == null && com.byazt.ew.pr.hn().pr("fix_handle_pause")) {
                            c.this.zo = Downloader.getInstance(k.getContext()).getDownloadInfo(id);
                        }
                        c.this.hn.pr(c.this.zo, z);
                        if (c.this.zo == null || !com.byazt.tuy.uc.hw(k.getContext()) || !c.this.zo.isPauseReserveOnWifi()) {
                            w.pr().pr(c.this.ho, c.this.zo);
                            hwVar.w(System.currentTimeMillis());
                            c cVar = c.this;
                            cVar.pr(id, status, cVar.zo);
                            return;
                        }
                        c.this.zo.stopPauseReserveOnWifi();
                        com.byazt.mf.pr.pr().hw("pause_reserve_wifi_cancel_on_wifi", hwVarPr);
                    }
                });
                return;
            }
        }
        this.hn.pr(this.zo, z);
        pr(id, status, this.zo);
    }

    public void pr(boolean z, final boolean z2) {
        if (z) {
            com.byazt.mf.pr.pr().pr(this.g, 2);
        }
        if (!com.byazt.uk.m.pr()) {
            if (!com.byazt.uk.vk.hw("android.permission.WRITE_EXTERNAL_STORAGE") && !m().enableNewActivity()) {
                this.ho.setFilePath(this.hn.hw());
            }
        } else if (!com.byazt.uk.vk.hw("android.permission.READ_MEDIA_IMAGES") && !com.byazt.uk.vk.hw("android.permission.READ_MEDIA_AUDIO") && !com.byazt.uk.vk.hw("android.permission.READ_MEDIA_VIDEO") && !m().enableNewActivity()) {
            this.ho.setFilePath(this.hn.hw());
        }
        if (com.byazt.uk.c.hn(this.ho) == 0) {
            com.byazt.uk.w.pr(pr, "pBCD not start", null);
            this.hn.pr(new cz() { // from class: com.byazt.eld.c.8
                @Override // com.byazt.zv.cz
                public void pr() {
                    com.byazt.uk.w.pr(c.pr, "pBCD start download", null);
                    c.this.fw(z2);
                }

                @Override // com.byazt.zv.cz
                public void pr(String str) {
                    com.byazt.uk.w.pr(c.pr, "pBCD onDenied", null);
                }
            });
        } else {
            fw(z2);
        }
    }

    private boolean ho() {
        if (com.byazt.ew.pr.hn().pr("fix_click_start")) {
            DownloadInfo downloadInfo = this.zo;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.zo.getCurBytes() <= 0) || this.zo.getStatus() == 0 || this.zo.getStatus() == -4) {
                return true;
            }
            try {
                return com.byazt.tuy.uc.pr(this.zo.getStatus(), this.zo.getSavePath(), this.zo.getName());
            } catch (Exception e) {
            }
        } else {
            DownloadInfo downloadInfo2 = this.zo;
            if (downloadInfo2 == null) {
                return true;
            }
            return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(k.getContext()).canResume(this.zo.getId())) || this.zo.getStatus() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, int i2, DownloadInfo downloadInfo) {
        if (com.byazt.ew.pr.hn().pr("fix_click_start")) {
            if (i2 != -3 && !com.byazt.lj.x.pr().c(i)) {
                pr(false, false);
                return;
            } else {
                com.byazt.mdu.x.w().pr(k.getContext(), i, i2);
                return;
            }
        }
        com.byazt.mdu.x.w().pr(k.getContext(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw(final boolean z) {
        this.x.pr(new com.byazt.shh.c(this.g, this.ho, k(), m()));
        this.x.pr(0, 0L, 0L, new pr() { // from class: com.byazt.eld.c.9
            @Override // com.byazt.eld.c.pr
            public void pr() {
                if (!c.this.x.pr()) {
                    c.this.zo(z);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zo(boolean z) {
        Iterator<DownloadStatusChangeListener> it = zo.pr(this.uc).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.ho, m());
        }
        int iPr = this.hn.pr(k.getContext(), this.vk);
        String str = pr;
        com.byazt.uk.w.pr(str, "beginDown id:" + iPr, null);
        if (iPr != 0) {
            if (this.zo == null || com.byazt.ew.pr.hn().pr("fix_click_start")) {
                if (z) {
                    this.hn.pr();
                }
            } else {
                this.hn.pr(this.zo, false);
            }
        } else {
            DownloadInfo downloadInfoPr = new DownloadInfo.pr(this.ho.getDownloadUrl()).pr();
            downloadInfoPr.setStatus(-1);
            pr(downloadInfoPr);
            com.byazt.mf.pr.pr().pr(this.g, new BaseException(2, "start download failed, id=0"));
            com.byazt.vi.hn.pr().hw("beginDown");
        }
        if (this.hn.pr(hn())) {
            com.byazt.uk.w.pr(str, "beginDown IC id:" + iPr, null);
            w();
        }
    }

    public void fw() {
        if (this.uc.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = zo.pr(this.uc).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.zo;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 128, 917})
    private class hn extends com.byazt.fr.hw<String, Void, DownloadInfo> {
        private hn() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public DownloadInfo doInBackground(String... strArr) {
            String str;
            DownloadInfo downloadInfo = null;
            if (strArr == null || (strArr.length > 0 && TextUtils.isEmpty(strArr[0]))) {
                return null;
            }
            if (strArr.length >= 3 && !TextUtils.isEmpty(strArr[2])) {
                str = strArr[2];
            } else {
                str = "";
            }
            String str2 = strArr[0];
            if (c.this.ho != null && !TextUtils.isEmpty(c.this.ho.getFilePath())) {
                if (!TextUtils.isEmpty(str)) {
                    downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(Downloader.getInstance(k.getContext()).getDownloadId(str, c.this.ho.getFilePath()));
                } else {
                    downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(str2, c.this.ho.getFilePath());
                }
            }
            if (downloadInfo == null) {
                if (!TextUtils.isEmpty(str)) {
                    return com.byazt.mdu.x.w().pr(k.getContext(), str);
                }
                return com.byazt.mdu.x.w().pr(k.getContext(), str2);
            }
            return downloadInfo;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (!isCancelled() && c.this.ho != null) {
                try {
                    com.byazt.shh.hn hnVarPr = com.byazt.uk.m.pr(c.this.ho.getPackageName(), c.this.ho.getVersionCode(), c.this.ho.getVersionName());
                    com.byazt.shh.zo.pr().pr(c.this.ho.getVersionCode(), hnVarPr.hw(), com.byazt.shh.uc.pr().pr(downloadInfo));
                    boolean zPr = hnVarPr.pr();
                    if (downloadInfo != null && downloadInfo.getId() != 0 && (zPr || !Downloader.getInstance(k.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                        Downloader.getInstance(k.getContext()).removeTaskMainListener(downloadInfo.getId());
                        if (c.this.zo == null || c.this.zo.getStatus() != -4) {
                            c.this.zo = downloadInfo;
                            if (!c.this.a) {
                                Downloader.getInstance(k.getContext()).setMainThreadListener(c.this.zo.getId(), c.this.vk);
                            } else {
                                Downloader.getInstance(k.getContext()).setMainThreadListener(c.this.zo.getId(), c.this.vk, false);
                            }
                        } else {
                            c.this.zo = null;
                        }
                        c.this.hn.pr(c.this.zo, c.this.yb(), zo.pr((Map<Integer, Object>) c.this.uc), zPr);
                    } else {
                        if (downloadInfo != null && Downloader.getInstance(k.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                            com.byazt.lxs.hw.pr().uc(downloadInfo.getId());
                            c.this.zo = null;
                        }
                        if (c.this.zo != null) {
                            Downloader.getInstance(k.getContext()).removeTaskMainListener(c.this.zo.getId());
                            if (!c.this.a) {
                                Downloader.getInstance(c.this.getContext()).setMainThreadListener(c.this.zo.getId(), c.this.vk);
                            } else {
                                Downloader.getInstance(c.this.getContext()).setMainThreadListener(c.this.zo.getId(), c.this.vk, false);
                            }
                        }
                        if (!zPr) {
                            Iterator<DownloadStatusChangeListener> it = zo.pr((Map<Integer, Object>) c.this.uc).iterator();
                            while (it.hasNext()) {
                                it.next().onIdle();
                            }
                            c.this.zo = null;
                        } else {
                            c cVar = c.this;
                            cVar.zo = new DownloadInfo.pr(cVar.ho.getDownloadUrl()).pr();
                            c.this.zo.setStatus(-3);
                            c.this.hn.pr(c.this.zo, c.this.yb(), zo.pr((Map<Integer, Object>) c.this.uc), zPr);
                        }
                    }
                    c.this.hn.hn(c.this.zo);
                } catch (Exception e) {
                }
            }
        }
    }

    private void pr(DownloadInfo downloadInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = downloadInfo;
        this.hw.sendMessage(messageObtain);
    }

    private void nt() {
        hn hnVar = this.aj;
        if (hnVar != null && hnVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.aj.cancel(true);
        }
        this.aj = new hn();
        if (!TextUtils.isEmpty(this.m)) {
            com.byazt.uk.hw.pr(this.aj, this.ho.getDownloadUrl(), this.ho.getPackageName(), this.m);
        } else {
            com.byazt.uk.hw.pr(this.aj, this.ho.getDownloadUrl(), this.ho.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo yb() {
        if (this.fw == null) {
            this.fw = new DownloadShortInfo();
        }
        return this.fw;
    }

    @Override // com.byazt.eld.fw
    public void zo() {
        com.byazt.shh.uc.pr().uc(this.g);
    }

    @Override // com.byazt.eld.fw
    public fw pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.m = str;
        }
        return this;
    }

    @Override // com.byazt.eld.fw
    public fw pr(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.cz = null;
        } else {
            this.cz = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }

    public boolean aj() {
        SoftReference<IDownloadButtonClickListener> softReference = this.cz;
        if (softReference == null) {
            return false;
        }
        return aj.pr(this.ho, softReference.get());
    }

    public boolean x(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.cz;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.cz.get().handleComplianceDialog(true);
                } else {
                    this.cz.get().handleMarketFailedComplianceDialog();
                }
                this.cz = null;
                return true;
            } catch (Exception e) {
                com.byazt.vi.hn.pr().hw("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.byazt.vi.hn.pr().hw("mDownloadButtonClickListener has recycled");
        return false;
    }
}
