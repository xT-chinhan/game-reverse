package com.byazt.ug;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.anythink.china.b.c;
import com.byazt.e.DownloadHandlerService;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.je.IDownloadListener;
import com.byazt.ky.IDownloadButtonClickListener;
import com.byazt.ky.OnItemClickListener;
import com.byazt.ky.py;
import com.byazt.os.DownloadShortInfo;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.y.AdDownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 18})
public class l implements com.byazt.rz.sz.n, x {
    public static final String n = "l";
    public final boolean a;
    public SoftReference<OnItemClickListener> cd;
    public boolean cp;
    public DownloadEventConfig cy;
    public long d;
    public DownloadInfo fs;
    public DownloadController hd;
    public DownloadModel k;
    public WeakReference<Context> l;
    public String oa;
    public SoftReference<IDownloadButtonClickListener> py;
    public q q;
    public final com.byazt.rz.sz qg;
    public s rv;
    public fs s;
    public long sz;
    public final IDownloadListener tj;
    public boolean um;
    public final Map<Integer, Object> w;
    public DownloadShortInfo x;

    interface n {
        void n();
    }

    interface qg {
        void n(long j);
    }

    public l() {
        com.byazt.rz.sz szVar = new com.byazt.rz.sz(Looper.getMainLooper(), this);
        this.qg = szVar;
        this.w = new ConcurrentHashMap();
        this.tj = new fs.n(szVar);
        this.sz = -1L;
        this.k = null;
        this.cy = null;
        this.hd = null;
        this.s = new fs(this);
        this.q = new q(szVar);
        this.a = com.byazt.f.n.s().n("ttdownloader_callback_twice");
    }

    @Override // com.byazt.ug.x
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public l qg(Context context) {
        if (context != null) {
            this.l = new WeakReference<>(context);
        }
        d.qg(context);
        return this;
    }

    @Override // com.byazt.ug.x
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public l qg(int i, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (d.rv().optInt("back_use_softref_listener") == 1) {
                this.w.put(Integer.valueOf(i), downloadStatusChangeListener);
            } else if (d.rv().optInt("use_weakref_listener") == 1) {
                this.w.put(Integer.valueOf(i), new WeakReference(downloadStatusChangeListener));
            } else {
                this.w.put(Integer.valueOf(i), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.byazt.ug.x
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public l qg(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.byazt.ch.s.n().n("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.byazt.ch.s.n().n(false, "setDownloadModel id=0");
                if (com.byazt.f.n.s().n("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.byazt.vl.w.n().n(downloadModel);
            this.sz = downloadModel.getId();
            this.k = downloadModel;
            if (rv.n(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(this.sz);
                if (qgVarQ != null && qgVarQ.d() != 3) {
                    qgVarQ.l(3L);
                    com.byazt.vl.rv.n().n(qgVarQ);
                }
            }
        }
        return this;
    }

    @Override // com.byazt.ug.x
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public l qg(DownloadController downloadController) {
        JSONObject extra;
        this.hd = downloadController;
        if (com.byazt.rz.l.qg(this.k).qg("force_auto_open") == 1) {
            oa().setLinkMode(1);
        }
        if (com.byazt.f.n.s().n("fix_show_dialog") && (extra = this.k.getExtra()) != null && extra.optInt("subprocess") > 0) {
            oa().setEnableNewActivity(false);
        }
        com.byazt.vl.w.n().n(this.sz, oa());
        return this;
    }

    @Override // com.byazt.ug.x
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public l qg(DownloadEventConfig downloadEventConfig) {
        this.cy = downloadEventConfig;
        this.um = d().getDownloadScene() == 0;
        com.byazt.vl.w.n().n(this.sz, d());
        return this;
    }

    @Override // com.byazt.ug.x
    public x n(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.cd = null;
        } else {
            this.cd = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.byazt.ug.x
    public void n() {
        this.cp = true;
        com.byazt.vl.w.n().n(this.sz, d());
        com.byazt.vl.w.n().n(this.sz, oa());
        this.s.n(this.sz);
        cy();
        if (d.rv().optInt("enable_empty_listener", 1) == 1 && this.w.get(Integer.MIN_VALUE) == null) {
            qg(Integer.MIN_VALUE, new com.byazt.ky.n());
        }
    }

    @Override // com.byazt.ug.x
    public boolean n(int i) {
        if (i == 0) {
            this.w.clear();
        } else {
            this.w.remove(Integer.valueOf(i));
        }
        if (this.w.isEmpty()) {
            this.cp = false;
            this.d = System.currentTimeMillis();
            if (this.fs != null) {
                Downloader.getInstance(d.getContext()).removeTaskMainListener(this.fs.getId());
            }
            s sVar = this.rv;
            if (sVar != null && sVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.rv.cancel(true);
            }
            this.s.n(this.fs);
            String str = n;
            StringBuilder sb = new StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.fs;
            com.byazt.rz.cp.n(str, sb.append(downloadInfo == null ? "" : downloadInfo.getUrl()).toString(), null);
            this.qg.removeCallbacksAndMessages(null);
            this.x = null;
            this.fs = null;
            return true;
        }
        if (this.w.size() == 1 && this.w.containsKey(Integer.MIN_VALUE)) {
            this.s.qg(this.fs);
        }
        return false;
    }

    @Override // com.byazt.ug.x
    public void n(boolean z) {
        if (this.fs != null) {
            if (z) {
                com.byazt.z.l lVarS = com.byazt.e.q.cp().s();
                if (lVarS != null) {
                    lVarS.n(this.fs);
                }
                Downloader.getInstance(com.byazt.xv.s.u()).cancel(this.fs.getId(), true);
                return;
            }
            Intent intent = new Intent(d.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.fs.getId());
            d.getContext().startService(intent);
        }
    }

    @Override // com.byazt.ug.x
    public boolean qg() {
        return this.cp;
    }

    public boolean s() {
        DownloadInfo downloadInfo = this.fs;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    @Override // com.byazt.ug.x
    public long q() {
        return this.d;
    }

    @Override // com.byazt.ug.x
    public x n(long j) {
        if (j != 0) {
            DownloadModel downloadModelN = com.byazt.vl.w.n().n(j);
            if (downloadModelN != null) {
                this.k = downloadModelN;
                this.sz = j;
                this.s.n(j);
            }
        } else {
            com.byazt.ch.s.n().n(false, "setModelId");
        }
        return this;
    }

    @Override // com.byazt.ug.x
    public void qg(final int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.s.n(this.sz);
        if (!com.byazt.vl.w.n().l(this.sz).hu()) {
            com.byazt.ch.s.n().n("handleDownload ModelBox !isStrictValid");
        }
        if (this.s.n(i, this.k)) {
            com.byazt.su.w.n().n(this.s.n, new com.byazt.su.fs() { // from class: com.byazt.ug.l.1
                @Override // com.byazt.su.fs
                public void n(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (!com.byazt.rz.fs.n(l.this.getContext(), l.this.s.n, str, jSONObject, true, i)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.byazt.su.w.n().n(1, l.this.s.n, jSONObject);
                            int i2 = i;
                            if (i2 == 1) {
                                com.byazt.fe.n.n(l.n, "miui new rollback fail: handleDownload id:" + l.this.sz + ",tryPerformButtonClick:", null);
                                l.this.s(true);
                                return;
                            } else {
                                if (i2 != 2) {
                                    return;
                                }
                                com.byazt.fe.n.n(l.n, "miui new rollback fail: handleDownload id:" + l.this.sz + ",tryPerformButtonClick:", null);
                                l.this.qg(true);
                                return;
                            }
                        }
                        jSONObject.putOpt("download_miui_jump_market_success", 1);
                        com.byazt.su.w.n().n(0, l.this.s.n, jSONObject);
                    } catch (Exception e) {
                        com.byazt.ch.s.n().n(e, "generate miui new market param error");
                    }
                }

                @Override // com.byazt.su.fs
                public void n() {
                    int i2 = i;
                    if (i2 == 1) {
                        com.byazt.fe.n.n(l.n, "miui new get miui deeplink fail: handleDownload id:" + l.this.sz + ",tryPerformButtonClick:", null);
                        l.this.s(true);
                    } else {
                        if (i2 != 2) {
                            return;
                        }
                        com.byazt.fe.n.n(l.n, "miui new get miui deeplink fail: handleDownload id:" + l.this.sz + ",tryPerformButtonClick:", null);
                        l.this.qg(true);
                    }
                }
            });
            return;
        }
        if (this.s.n(getContext(), i, this.um)) {
            return;
        }
        boolean zS = s(i);
        if (i == 1) {
            if (zS) {
                return;
            }
            com.byazt.rz.cp.n(n, "handleDownload id:" + this.sz + ",pIC:", null);
            s(true);
            return;
        }
        if (i == 2 && !zS) {
            com.byazt.rz.cp.n(n, "handleDownload id:" + this.sz + ",pBC:", null);
            qg(true);
        }
    }

    public boolean l() {
        return d.rv().optInt("quick_app_enable_switch", 0) == 0 && this.k.getQuickAppModel() != null && !TextUtils.isEmpty(this.k.getQuickAppModel().n()) && com.byazt.ug.s.n(this.fs) && com.byazt.rz.oa.n(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.k.getQuickAppModel().n())));
    }

    private boolean s(int i) {
        int i2;
        if (!l()) {
            return false;
        }
        String strN = this.k.getQuickAppModel().n();
        if (i != 1) {
            i2 = i != 2 ? -1 : 4;
        } else {
            i2 = 5;
        }
        DownloadModel downloadModel = this.k;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean zS = com.byazt.rz.rv.s(d.getContext(), strN);
        if (zS) {
            com.byazt.vj.n.n().n(this.sz, i);
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.obj = Long.valueOf(this.k.getId());
            com.byazt.ug.s.n().n(this, i2, this.k);
        } else {
            com.byazt.vj.n.n().n(this.sz, false, 0);
        }
        return zS;
    }

    public void qg(boolean z) {
        l(z);
    }

    private void cp() {
        SoftReference<OnItemClickListener> softReference = this.cd;
        if (softReference != null && softReference.get() != null) {
            this.cd.get().onItemClick(this.k, d(), oa());
            this.cd = null;
        } else {
            d.qg();
            getContext();
            oa();
            d();
        }
    }

    public void s(boolean z) {
        if (z) {
            com.byazt.vj.n.n().n(this.sz, 1);
        }
        sz();
    }

    private void l(boolean z) {
        if (com.byazt.rz.l.qg(this.k).qg("notification_opt_2") == 1 && this.fs != null) {
            com.byazt.av.qg.n().w(this.fs.getId());
        }
        w(z);
    }

    public void w() {
        this.qg.post(new Runnable() { // from class: com.byazt.ug.l.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = fs.n((Map<Integer, Object>) l.this.w).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(l.this.hd());
                }
            }
        });
    }

    @Override // com.byazt.rz.sz.n
    public void n(Message message) {
        if (message != null && this.cp && message.what == 3) {
            this.fs = (DownloadInfo) message.obj;
            this.s.n(message, hd(), this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.l;
        if (weakReference != null && weakReference.get() != null) {
            return this.l.get();
        }
        return d.getContext();
    }

    private DownloadEventConfig d() {
        DownloadEventConfig downloadEventConfig = this.cy;
        return downloadEventConfig == null ? new com.byazt.hj.q.n().n() : downloadEventConfig;
    }

    private DownloadController oa() {
        if (this.hd == null) {
            this.hd = new com.byazt.hj.s();
        }
        return this.hd;
    }

    private void sz() {
        String str = n;
        com.byazt.rz.cp.n(str, "pICD", null);
        if (this.s.q(this.fs)) {
            com.byazt.rz.cp.n(str, "pICD BC", null);
            w(false);
        } else {
            com.byazt.rz.cp.n(str, "pICD IC", null);
            cp();
        }
    }

    private void w(final boolean z) {
        DownloadModel downloadModel;
        String str = n;
        com.byazt.rz.cp.n(str, "pBCD", null);
        if (k()) {
            com.byazt.vl.l lVarL = com.byazt.vl.w.n().l(this.sz);
            if (this.um) {
                if (rv()) {
                    if (q(false) && lVarL.q != null && lVarL.q.isAutoDownloadOnCardShow()) {
                        n(z, true);
                        return;
                    }
                    return;
                }
                n(z, true);
                return;
            }
            if (this.k.isAd() && lVarL.q != null && lVarL.q.enableShowComplianceDialog() && lVarL.qg != null && com.byazt.su.qg.n().n(lVarL.qg) && com.byazt.su.qg.n().n(lVarL)) {
                return;
            }
            n(z, true);
            return;
        }
        com.byazt.rz.cp.n(str, "pBCD continue download, status:" + this.fs.getStatus(), null);
        DownloadInfo downloadInfo = this.fs;
        if (downloadInfo != null && (downloadModel = this.k) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.fs.getStatus();
        final int id = this.fs.getId();
        final com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(this.fs);
        if (status == -2 || status == -1) {
            this.s.n(this.fs, z);
            if (qgVarN != null) {
                qgVarN.fs(System.currentTimeMillis());
                qgVarN.rv(this.fs.getCurBytes());
            }
            this.fs.setDownloadFromReserveWifi(false);
            this.q.n(new com.byazt.vl.l(this.sz, this.k, d(), oa()));
            this.q.n(id, this.fs.getCurBytes(), this.fs.getTotalBytes(), new n() { // from class: com.byazt.ug.l.3
                @Override // com.byazt.ug.l.n
                public void n() {
                    if (l.this.q.n()) {
                        return;
                    }
                    l lVar = l.this;
                    lVar.n(id, status, lVar.fs);
                }
            });
            if (status == -2 && com.byazt.rz.l.n((com.byazt.h.n) qgVarN).n("show_pause_continue_toast", 0) == 1) {
                com.byazt.s.fs.n().qg().postDelayed(new Runnable() { // from class: com.byazt.ug.l.4
                    @Override // java.lang.Runnable
                    public void run() {
                        d.s().n(13, d.getContext(), l.this.k, "已恢复下载", null, 0);
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (k.n(status)) {
            if (this.k.enablePause()) {
                this.q.n(true);
                com.byazt.ht.fs.n().qg(com.byazt.vl.w.n().q(this.sz));
                if (com.byazt.rz.l.n((com.byazt.h.n) qgVarN).n("cancel_pause_optimise_switch", 0) == 1) {
                    com.byazt.mx.q.n().n(qgVarN, status, new com.byazt.mx.fs() { // from class: com.byazt.ug.l.6
                        @Override // com.byazt.mx.fs
                        public void n(com.byazt.h.qg qgVar) {
                            if (l.this.fs == null && com.byazt.f.n.s().n("fix_handle_pause")) {
                                l.this.fs = Downloader.getInstance(d.getContext()).getDownloadInfo(id);
                            }
                            l.this.s.n(l.this.fs, z);
                            if (l.this.fs == null || !com.byazt.ta.w.qg(d.getContext()) || !l.this.fs.isPauseReserveOnWifi()) {
                                cp.n().n(l.this.k, l.this.fs);
                                qgVar.cp(System.currentTimeMillis());
                                l lVar = l.this;
                                lVar.n(id, status, lVar.fs);
                                return;
                            }
                            l.this.fs.stopPauseReserveOnWifi();
                            com.byazt.vj.n.n().n("cancel_pause_reserve_wifi_cancel_on_wifi", qgVarN);
                        }
                    }, new com.byazt.bn.s() { // from class: com.byazt.ug.l.5
                        @Override // com.byazt.bn.s
                        public void delete() {
                            l.this.n(true);
                        }
                    });
                    return;
                } else {
                    com.byazt.mx.cp.n().n(qgVarN, status, new com.byazt.mx.fs() { // from class: com.byazt.ug.l.7
                        @Override // com.byazt.mx.fs
                        public void n(com.byazt.h.qg qgVar) {
                            if (l.this.fs == null && com.byazt.f.n.s().n("fix_handle_pause")) {
                                l.this.fs = Downloader.getInstance(d.getContext()).getDownloadInfo(id);
                            }
                            l.this.s.n(l.this.fs, z);
                            if (l.this.fs == null || !com.byazt.ta.w.qg(d.getContext()) || !l.this.fs.isPauseReserveOnWifi()) {
                                cp.n().n(l.this.k, l.this.fs);
                                qgVar.cp(System.currentTimeMillis());
                                l lVar = l.this;
                                lVar.n(id, status, lVar.fs);
                                return;
                            }
                            l.this.fs.stopPauseReserveOnWifi();
                            com.byazt.vj.n.n().qg("pause_reserve_wifi_cancel_on_wifi", qgVarN);
                        }
                    });
                    return;
                }
            }
            return;
        }
        this.s.n(this.fs, z);
        n(id, status, this.fs);
    }

    public void n(boolean z, final boolean z2) {
        if (z) {
            com.byazt.vj.n.n().n(this.sz, 2);
        }
        if (!com.byazt.rz.oa.n()) {
            if (!com.byazt.rz.tj.qg(c.b) && !oa().enableNewActivity()) {
                this.k.setFilePath(this.s.qg());
            }
        } else if (!com.byazt.rz.tj.qg("android.permission.READ_MEDIA_IMAGES") && !com.byazt.rz.tj.qg("android.permission.READ_MEDIA_AUDIO") && !com.byazt.rz.tj.qg("android.permission.READ_MEDIA_VIDEO") && !oa().enableNewActivity()) {
            this.k.setFilePath(this.s.qg());
        }
        if (com.byazt.rz.l.s(this.k) == 0) {
            com.byazt.rz.cp.n(n, "pBCD not start", null);
            this.s.n(new py() { // from class: com.byazt.ug.l.8
                @Override // com.byazt.ky.py
                public void n() {
                    com.byazt.rz.cp.n(l.n, "pBCD start download", null);
                    l.this.x(z2);
                }

                @Override // com.byazt.ky.py
                public void n(String str) {
                    com.byazt.rz.cp.n(l.n, "pBCD onDenied", null);
                }
            });
        } else {
            x(z2);
        }
    }

    private boolean k() {
        if (com.byazt.f.n.s().n("fix_click_start")) {
            DownloadInfo downloadInfo = this.fs;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.fs.getCurBytes() <= 0) || this.fs.getStatus() == 0 || this.fs.getStatus() == -4) {
                return true;
            }
            try {
                return com.byazt.ta.w.n(this.fs.getStatus(), this.fs.getSavePath(), this.fs.getName());
            } catch (Exception unused) {
            }
        } else {
            DownloadInfo downloadInfo2 = this.fs;
            if (downloadInfo2 == null) {
                return true;
            }
            return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(d.getContext()).canResume(this.fs.getId())) || this.fs.getStatus() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, DownloadInfo downloadInfo) {
        if (com.byazt.f.n.s().n("fix_click_start")) {
            if (i2 != -3 && !com.byazt.xv.q.n().l(i)) {
                n(false, false);
                return;
            } else {
                com.byazt.e.q.cp().n(d.getContext(), i, i2);
                return;
            }
        }
        com.byazt.e.q.cp().n(d.getContext(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final boolean z) {
        this.q.n(new com.byazt.vl.l(this.sz, this.k, d(), oa()));
        this.q.n(0, 0L, 0L, new n() { // from class: com.byazt.ug.l.9
            @Override // com.byazt.ug.l.n
            public void n() {
                if (l.this.q.n()) {
                    return;
                }
                l.this.fs(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        Iterator<DownloadStatusChangeListener> it = fs.n(this.w).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.k, oa());
        }
        int iN = this.s.n(d.getContext(), this.tj);
        String str = n;
        com.byazt.rz.cp.n(str, "beginDown id:" + iN, null);
        if (iN != 0) {
            if (this.fs != null && !com.byazt.f.n.s().n("fix_click_start")) {
                this.s.n(this.fs, false);
            } else if (z) {
                this.s.n();
            }
        } else {
            DownloadInfo downloadInfoN = new DownloadInfo.n(this.k.getDownloadUrl()).n();
            downloadInfoN.setStatus(-1);
            n(downloadInfoN);
            com.byazt.vj.n.n().n(this.sz, new BaseException(2, "start download failed, id=0"));
            com.byazt.ch.s.n().qg("beginDown");
        }
        if (this.s.n(s())) {
            com.byazt.rz.cp.n(str, "beginDown IC id:" + iN, null);
            cp();
        }
    }

    public void x() {
        if (this.w.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = fs.n(this.w).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.fs;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 1721})
    private class s extends com.byazt.xis.qg<String, Void, DownloadInfo> {
        private s() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length > 0 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
            String str2 = strArr[0];
            if (l.this.k != null && !TextUtils.isEmpty(l.this.k.getFilePath())) {
                if (TextUtils.isEmpty(str)) {
                    downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(str2, l.this.k.getFilePath());
                } else {
                    downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(Downloader.getInstance(d.getContext()).getDownloadId(str, l.this.k.getFilePath()));
                }
            }
            if (downloadInfo != null) {
                return downloadInfo;
            }
            if (!TextUtils.isEmpty(str)) {
                return com.byazt.e.q.cp().n(d.getContext(), str);
            }
            return com.byazt.e.q.cp().n(d.getContext(), str2);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || l.this.k == null) {
                return;
            }
            try {
                com.byazt.vl.s sVarN = com.byazt.rz.oa.n(l.this.k.getPackageName(), l.this.k.getVersionCode(), l.this.k.getVersionName());
                com.byazt.vl.fs.n().n(l.this.k.getVersionCode(), sVarN.qg(), com.byazt.vl.w.n().n(downloadInfo));
                boolean zN = sVarN.n();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (zN || !Downloader.getInstance(d.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(d.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (l.this.fs == null || l.this.fs.getStatus() != -4) {
                        l.this.fs = downloadInfo;
                        if (l.this.a) {
                            Downloader.getInstance(d.getContext()).setMainThreadListener(l.this.fs.getId(), l.this.tj, false);
                        } else {
                            Downloader.getInstance(d.getContext()).setMainThreadListener(l.this.fs.getId(), l.this.tj);
                        }
                    } else {
                        l.this.fs = null;
                    }
                    l.this.s.n(l.this.fs, l.this.hd(), fs.n((Map<Integer, Object>) l.this.w), zN);
                } else {
                    if (downloadInfo != null && Downloader.getInstance(d.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.byazt.av.qg.n().w(downloadInfo.getId());
                        l.this.fs = null;
                    }
                    if (l.this.fs != null) {
                        Downloader.getInstance(d.getContext()).removeTaskMainListener(l.this.fs.getId());
                        if (l.this.a) {
                            Downloader.getInstance(l.this.getContext()).setMainThreadListener(l.this.fs.getId(), l.this.tj, false);
                        } else {
                            Downloader.getInstance(l.this.getContext()).setMainThreadListener(l.this.fs.getId(), l.this.tj);
                        }
                    }
                    if (!zN) {
                        Iterator<DownloadStatusChangeListener> it = fs.n((Map<Integer, Object>) l.this.w).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        l.this.fs = null;
                    } else {
                        l.this.fs = new DownloadInfo.n(l.this.k.getDownloadUrl()).n();
                        l.this.fs.setStatus(-3);
                        l.this.s.n(l.this.fs, l.this.hd(), fs.n((Map<Integer, Object>) l.this.w), zN);
                    }
                }
                l.this.s.s(l.this.fs);
            } catch (Exception unused) {
            }
        }
    }

    private void n(DownloadInfo downloadInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = downloadInfo;
        this.qg.sendMessage(messageObtain);
    }

    private void cy() {
        s sVar = this.rv;
        if (sVar != null && sVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.rv.cancel(true);
        }
        this.rv = new s();
        if (!TextUtils.isEmpty(this.oa)) {
            com.byazt.rz.qg.n(this.rv, this.k.getDownloadUrl(), this.k.getPackageName(), this.oa);
        } else {
            com.byazt.rz.qg.n(this.rv, this.k.getDownloadUrl(), this.k.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo hd() {
        if (this.x == null) {
            this.x = new DownloadShortInfo();
        }
        return this.x;
    }

    @Override // com.byazt.ug.x
    public void fs() {
        com.byazt.vl.w.n().w(this.sz);
    }

    @Override // com.byazt.ug.x
    public x n(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oa = str;
        }
        return this;
    }

    @Override // com.byazt.ug.x
    public x n(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.py = null;
        } else {
            this.py = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }

    public boolean rv() {
        SoftReference<IDownloadButtonClickListener> softReference = this.py;
        if (softReference == null) {
            return false;
        }
        return rv.n(this.k, softReference.get());
    }

    public boolean q(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.py;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.py.get().handleComplianceDialog(true);
                } else {
                    this.py.get().handleMarketFailedComplianceDialog();
                }
                this.py = null;
                return true;
            } catch (Exception unused) {
                com.byazt.ch.s.n().qg("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.byazt.ch.s.n().qg("mDownloadButtonClickListener has recycled");
        return false;
    }
}
