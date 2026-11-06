package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ka implements com.ss.android.downloadlib.ab.u.ms, ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4416ms = "ka";
    private DownloadShortInfo ab;
    private x ah;
    private DownloadEventConfig ao;
    private final Map<Integer, Object> c;
    private final IDownloadListener ch;
    private d d;
    private DownloadController h;
    private boolean hi;
    private WeakReference<Context> ka;
    private SoftReference<IDownloadButtonClickListener> nw;
    private ah ny;
    private SoftReference<OnItemClickListener> qv;
    private long sl;
    private final boolean t;
    private long u;
    private DownloadModel ub;
    private DownloadInfo x;
    private final com.ss.android.downloadlib.ab.u xr;
    private boolean y;
    private String zb;

    interface ms {
        void ms();
    }

    interface xr {
        void ms(long j);
    }

    public ka() {
        com.ss.android.downloadlib.ab.u uVar = new com.ss.android.downloadlib.ab.u(Looper.getMainLooper(), this);
        this.xr = uVar;
        this.c = new ConcurrentHashMap();
        this.ch = new x.ms(uVar);
        this.u = -1L;
        this.ub = null;
        this.ao = null;
        this.h = null;
        this.ah = new x(this);
        this.d = new d(uVar);
        this.t = com.ss.android.socialbase.downloader.ab.ms.ah().ms("ttdownloader_callback_twice");
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public ka xr(Context context) {
        if (context != null) {
            this.ka = new WeakReference<>(context);
        }
        hi.xr(context);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public ka xr(int i, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (hi.ny().optInt("back_use_softref_listener") == 1) {
                this.c.put(Integer.valueOf(i), downloadStatusChangeListener);
            } else if (hi.ny().optInt("use_weakref_listener") == 1) {
                this.c.put(Integer.valueOf(i), new WeakReference(downloadStatusChangeListener));
            } else {
                this.c.put(Integer.valueOf(i), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public ka xr(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.ka.ah.ms().ms("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.ka.ah.ms().ms(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadModel);
            this.u = downloadModel.getId();
            this.ub = downloadModel;
            if (ny.ms(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.ms.xr xrVarD = com.ss.android.downloadlib.addownload.xr.c.ms().d(this.u);
                if (xrVarD != null && xrVarD.sl() != 3) {
                    xrVarD.ka(3L);
                    com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVarD);
                }
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public ka xr(DownloadController downloadController) {
        JSONObject extra;
        this.h = downloadController;
        if (com.ss.android.downloadlib.ab.ka.xr(this.ub).xr("force_auto_open") == 1) {
            zb().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_show_dialog") && (extra = this.ub.getExtra()) != null && extra.optInt("subprocess") > 0) {
            zb().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(this.u, zb());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public ka xr(DownloadEventConfig downloadEventConfig) {
        this.ao = downloadEventConfig;
        this.y = sl().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(this.u, sl());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public ab ms(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.qv = null;
        } else {
            this.qv = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public void ms() {
        this.hi = true;
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(this.u, sl());
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(this.u, zb());
        this.ah.ms(this.u);
        ao();
        if (hi.ny().optInt("enable_empty_listener", 1) == 1 && this.c.get(Integer.MIN_VALUE) == null) {
            xr(Integer.MIN_VALUE, new com.ss.android.download.api.config.ms());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public boolean ms(int i) {
        if (i == 0) {
            this.c.clear();
        } else {
            this.c.remove(Integer.valueOf(i));
        }
        if (this.c.isEmpty()) {
            this.hi = false;
            this.sl = System.currentTimeMillis();
            if (this.x != null) {
                Downloader.getInstance(hi.getContext()).removeTaskMainListener(this.x.getId());
            }
            ah ahVar = this.ny;
            if (ahVar != null && ahVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.ny.cancel(true);
            }
            this.ah.ms(this.x);
            String str = f4416ms;
            StringBuilder sb = new StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.x;
            com.ss.android.downloadlib.ab.hi.ms(str, sb.append(downloadInfo == null ? "" : downloadInfo.getUrl()).toString(), null);
            this.xr.removeCallbacksAndMessages(null);
            this.ab = null;
            this.x = null;
            return true;
        }
        if (this.c.size() == 1 && this.c.containsKey(Integer.MIN_VALUE)) {
            this.ah.xr(this.x);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public void ms(boolean z) {
        if (this.x != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.ah.d dVarXr = com.ss.android.socialbase.appdownloader.d.ch().xr();
                if (dVarXr != null) {
                    dVarXr.ms(this.x);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).cancel(this.x.getId(), true);
                return;
            }
            Intent intent = new Intent(hi.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.x.getId());
            hi.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public boolean xr() {
        return this.hi;
    }

    public boolean ah() {
        DownloadInfo downloadInfo = this.x;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public long d() {
        return this.sl;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public ab ms(long j) {
        if (j != 0) {
            DownloadModel downloadModelMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(j);
            if (downloadModelMs != null) {
                this.ub = downloadModelMs;
                this.u = j;
                this.ah.ms(j);
            }
        } else {
            com.ss.android.downloadlib.ka.ah.ms().ms(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public void xr(final int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.ah.ms(this.u);
        if (!com.ss.android.downloadlib.addownload.xr.c.ms().ka(this.u).w()) {
            com.ss.android.downloadlib.ka.ah.ms().ms("handleDownload ModelBox !isStrictValid");
        }
        if (this.ah.ms(i, this.ub)) {
            com.ss.android.downloadlib.addownload.compliance.c.ms().ms(this.ah.f4440ms, new com.ss.android.downloadlib.addownload.compliance.x() { // from class: com.ss.android.downloadlib.addownload.ka.1
                @Override // com.ss.android.downloadlib.addownload.compliance.x
                public void ms(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (!com.ss.android.downloadlib.ab.x.ms(ka.this.getContext(), ka.this.ah.f4440ms, str, jSONObject, true, i)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.ss.android.downloadlib.addownload.compliance.c.ms().ms(1, ka.this.ah.f4440ms, jSONObject);
                            int i2 = i;
                            if (i2 == 1) {
                                com.ss.android.socialbase.downloader.ah.ms.ms(ka.f4416ms, "miui new rollback fail: handleDownload id:" + ka.this.u + ",tryPerformButtonClick:", null);
                                ka.this.ah(true);
                                return;
                            } else {
                                if (i2 != 2) {
                                    return;
                                }
                                com.ss.android.socialbase.downloader.ah.ms.ms(ka.f4416ms, "miui new rollback fail: handleDownload id:" + ka.this.u + ",tryPerformButtonClick:", null);
                                ka.this.xr(true);
                                return;
                            }
                        }
                        jSONObject.putOpt("download_miui_jump_market_success", 1);
                        com.ss.android.downloadlib.addownload.compliance.c.ms().ms(0, ka.this.ah.f4440ms, jSONObject);
                    } catch (Exception e) {
                        com.ss.android.downloadlib.ka.ah.ms().ms(e, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.x
                public void ms() {
                    int i2 = i;
                    if (i2 == 1) {
                        com.ss.android.socialbase.downloader.ah.ms.ms(ka.f4416ms, "miui new get miui deeplink fail: handleDownload id:" + ka.this.u + ",tryPerformButtonClick:", null);
                        ka.this.ah(true);
                    } else {
                        if (i2 != 2) {
                            return;
                        }
                        com.ss.android.socialbase.downloader.ah.ms.ms(ka.f4416ms, "miui new get miui deeplink fail: handleDownload id:" + ka.this.u + ",tryPerformButtonClick:", null);
                        ka.this.xr(true);
                    }
                }
            });
            return;
        }
        if (this.ah.ms(getContext(), i, this.y)) {
            return;
        }
        boolean zAh = ah(i);
        if (i == 1) {
            if (zAh) {
                return;
            }
            com.ss.android.downloadlib.ab.hi.ms(f4416ms, "handleDownload id:" + this.u + ",pIC:", null);
            ah(true);
            return;
        }
        if (i == 2 && !zAh) {
            com.ss.android.downloadlib.ab.hi.ms(f4416ms, "handleDownload id:" + this.u + ",pBC:", null);
            xr(true);
        }
    }

    public boolean ka() {
        return hi.ny().optInt("quick_app_enable_switch", 0) == 0 && this.ub.getQuickAppModel() != null && !TextUtils.isEmpty(this.ub.getQuickAppModel().ms()) && com.ss.android.downloadlib.addownload.ah.ms(this.x) && com.ss.android.downloadlib.ab.zb.ms(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.ub.getQuickAppModel().ms())));
    }

    private boolean ah(int i) {
        int i2;
        if (!ka()) {
            return false;
        }
        String strMs = this.ub.getQuickAppModel().ms();
        if (i != 1) {
            i2 = i != 2 ? -1 : 4;
        } else {
            i2 = 5;
        }
        DownloadModel downloadModel = this.ub;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean zAh = com.ss.android.downloadlib.ab.ny.ah(hi.getContext(), strMs);
        if (zAh) {
            com.ss.android.downloadlib.d.ms.ms().ms(this.u, i);
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.obj = Long.valueOf(this.ub.getId());
            com.ss.android.downloadlib.addownload.ah.ms().ms(this, i2, this.ub);
        } else {
            com.ss.android.downloadlib.d.ms.ms().ms(this.u, false, 0);
        }
        return zAh;
    }

    public void xr(boolean z) {
        ka(z);
    }

    private void hi() {
        SoftReference<OnItemClickListener> softReference = this.qv;
        if (softReference != null && softReference.get() != null) {
            this.qv.get().onItemClick(this.ub, sl(), zb());
            this.qv = null;
        } else {
            hi.xr();
            getContext();
            zb();
            sl();
        }
    }

    public void ah(boolean z) {
        if (z) {
            com.ss.android.downloadlib.d.ms.ms().ms(this.u, 1);
        }
        u();
    }

    private void ka(boolean z) {
        if (com.ss.android.downloadlib.ab.ka.xr(this.ub).xr("notification_opt_2") == 1 && this.x != null) {
            com.ss.android.socialbase.downloader.notification.xr.ms().c(this.x.getId());
        }
        c(z);
    }

    public void c() {
        this.xr.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.ka.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = x.ms((Map<Integer, Object>) ka.this.c).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(ka.this.h());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.ab.u.ms
    public void ms(Message message) {
        if (message != null && this.hi && message.what == 3) {
            this.x = (DownloadInfo) message.obj;
            this.ah.ms(message, h(), this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.ka;
        if (weakReference != null && weakReference.get() != null) {
            return this.ka.get();
        }
        return hi.getContext();
    }

    private DownloadEventConfig sl() {
        DownloadEventConfig downloadEventConfig = this.ao;
        return downloadEventConfig == null ? new com.ss.android.download.api.download.ah.ms().ms() : downloadEventConfig;
    }

    private DownloadController zb() {
        if (this.h == null) {
            this.h = new com.ss.android.download.api.download.xr();
        }
        return this.h;
    }

    private void u() {
        String str = f4416ms;
        com.ss.android.downloadlib.ab.hi.ms(str, "pICD", null);
        if (this.ah.d(this.x)) {
            com.ss.android.downloadlib.ab.hi.ms(str, "pICD BC", null);
            c(false);
        } else {
            com.ss.android.downloadlib.ab.hi.ms(str, "pICD IC", null);
            hi();
        }
    }

    private void c(final boolean z) {
        DownloadModel downloadModel;
        String str = f4416ms;
        com.ss.android.downloadlib.ab.hi.ms(str, "pBCD", null);
        if (ub()) {
            com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(this.u);
            if (this.y) {
                if (ny()) {
                    if (d(false) && kaVarKa.d != null && kaVarKa.d.isAutoDownloadOnCardShow()) {
                        ms(z, true);
                        return;
                    }
                    return;
                }
                ms(z, true);
                return;
            }
            if (this.ub.isAd() && kaVarKa.d != null && kaVarKa.d.enableShowComplianceDialog() && kaVarKa.xr != null && com.ss.android.downloadlib.addownload.compliance.xr.ms().ms(kaVarKa.xr) && com.ss.android.downloadlib.addownload.compliance.xr.ms().ms(kaVarKa)) {
                return;
            }
            ms(z, true);
            return;
        }
        com.ss.android.downloadlib.ab.hi.ms(str, "pBCD continue download, status:" + this.x.getStatus(), null);
        DownloadInfo downloadInfo = this.x;
        if (downloadInfo != null && (downloadModel = this.ub) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.x.getStatus();
        final int id = this.x.getId();
        final com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(this.x);
        if (status == -2 || status == -1) {
            this.ah.ms(this.x, z);
            if (xrVarMs != null) {
                xrVarMs.x(System.currentTimeMillis());
                xrVarMs.ny(this.x.getCurBytes());
            }
            this.x.setDownloadFromReserveWifi(false);
            this.d.ms(new com.ss.android.downloadlib.addownload.xr.ka(this.u, this.ub, sl(), zb()));
            this.d.ms(id, this.x.getCurBytes(), this.x.getTotalBytes(), new ms() { // from class: com.ss.android.downloadlib.addownload.ka.3
                @Override // com.ss.android.downloadlib.addownload.ka.ms
                public void ms() {
                    if (ka.this.d.ms()) {
                        return;
                    }
                    ka kaVar = ka.this;
                    kaVar.ms(id, status, kaVar.x);
                }
            });
            if (status == -2 && com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVarMs).ms("show_pause_continue_toast", 0) == 1) {
                com.ss.android.downloadlib.x.ms().xr().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.ka.4
                    @Override // java.lang.Runnable
                    public void run() {
                        hi.ah().ms(13, hi.getContext(), ka.this.ub, "已恢复下载", null, 0);
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (u.ms(status)) {
            if (this.ub.enablePause()) {
                this.d.ms(true);
                com.ss.android.downloadlib.ah.x.ms().xr(com.ss.android.downloadlib.addownload.xr.c.ms().d(this.u));
                if (com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVarMs).ms("cancel_pause_optimise_switch", 0) == 1) {
                    com.ss.android.downloadlib.addownload.d.d.ms().ms(xrVarMs, status, new com.ss.android.downloadlib.addownload.d.x() { // from class: com.ss.android.downloadlib.addownload.ka.6
                        @Override // com.ss.android.downloadlib.addownload.d.x
                        public void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
                            if (ka.this.x == null && com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_handle_pause")) {
                                ka.this.x = Downloader.getInstance(hi.getContext()).getDownloadInfo(id);
                            }
                            ka.this.ah.ms(ka.this.x, z);
                            if (ka.this.x != null && com.ss.android.socialbase.downloader.ny.c.xr(hi.getContext()) && ka.this.x.isPauseReserveOnWifi()) {
                                ka.this.x.stopPauseReserveOnWifi();
                                com.ss.android.downloadlib.d.ms.ms().ms("cancel_pause_reserve_wifi_cancel_on_wifi", xrVarMs);
                            } else {
                                ka kaVar = ka.this;
                                kaVar.ms(id, status, kaVar.x);
                            }
                        }
                    }, new com.ss.android.downloadlib.addownload.ms.ah() { // from class: com.ss.android.downloadlib.addownload.ka.5
                        @Override // com.ss.android.downloadlib.addownload.ms.ah
                        public void delete() {
                            ka.this.ms(true);
                        }
                    });
                    return;
                } else {
                    com.ss.android.downloadlib.addownload.d.hi.ms().ms(xrVarMs, status, new com.ss.android.downloadlib.addownload.d.x() { // from class: com.ss.android.downloadlib.addownload.ka.7
                        @Override // com.ss.android.downloadlib.addownload.d.x
                        public void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
                            if (ka.this.x == null && com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_handle_pause")) {
                                ka.this.x = Downloader.getInstance(hi.getContext()).getDownloadInfo(id);
                            }
                            ka.this.ah.ms(ka.this.x, z);
                            if (ka.this.x != null && com.ss.android.socialbase.downloader.ny.c.xr(hi.getContext()) && ka.this.x.isPauseReserveOnWifi()) {
                                ka.this.x.stopPauseReserveOnWifi();
                                com.ss.android.downloadlib.d.ms.ms().xr("pause_reserve_wifi_cancel_on_wifi", xrVarMs);
                            } else {
                                ka kaVar = ka.this;
                                kaVar.ms(id, status, kaVar.x);
                            }
                        }
                    });
                    return;
                }
            }
            return;
        }
        this.ah.ms(this.x, z);
        ms(id, status, this.x);
    }

    public void ms(boolean z, final boolean z2) {
        if (z) {
            com.ss.android.downloadlib.d.ms.ms().ms(this.u, 2);
        }
        if (!com.ss.android.downloadlib.ab.zb.ms()) {
            if (!com.ss.android.downloadlib.ab.ch.xr("android.permission.WRITE_EXTERNAL_STORAGE") && !zb().enableNewActivity()) {
                this.ub.setFilePath(this.ah.xr());
            }
        } else if (!com.ss.android.downloadlib.ab.ch.xr("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.ab.ch.xr("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.ab.ch.xr("android.permission.READ_MEDIA_VIDEO") && !zb().enableNewActivity()) {
            this.ub.setFilePath(this.ah.xr());
        }
        if (com.ss.android.downloadlib.ab.ka.ah(this.ub) == 0) {
            com.ss.android.downloadlib.ab.hi.ms(f4416ms, "pBCD not start", null);
            this.ah.ms(new t() { // from class: com.ss.android.downloadlib.addownload.ka.8
                @Override // com.ss.android.download.api.config.t
                public void ms() {
                    com.ss.android.downloadlib.ab.hi.ms(ka.f4416ms, "pBCD start download", null);
                    ka.this.ab(z2);
                }

                @Override // com.ss.android.download.api.config.t
                public void ms(String str) {
                    com.ss.android.downloadlib.ab.hi.ms(ka.f4416ms, "pBCD onDenied", null);
                }
            });
        } else {
            ab(z2);
        }
    }

    private boolean ub() {
        if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_click_start")) {
            DownloadInfo downloadInfo = this.x;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.x.getCurBytes() <= 0) || this.x.getStatus() == 0 || this.x.getStatus() == -4) {
                return true;
            }
            try {
                return com.ss.android.socialbase.downloader.ny.c.ms(this.x.getStatus(), this.x.getSavePath(), this.x.getName());
            } catch (Exception unused) {
            }
        } else {
            DownloadInfo downloadInfo2 = this.x;
            if (downloadInfo2 == null) {
                return true;
            }
            return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(hi.getContext()).canResume(this.x.getId())) || this.x.getStatus() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, int i2, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_click_start")) {
            if (i2 != -3 && !com.ss.android.socialbase.downloader.downloader.d.ms().ka(i)) {
                ms(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.d.ch().ms(hi.getContext(), i, i2);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.d.ch().ms(hi.getContext(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(final boolean z) {
        this.d.ms(new com.ss.android.downloadlib.addownload.xr.ka(this.u, this.ub, sl(), zb()));
        this.d.ms(0, 0L, 0L, new ms() { // from class: com.ss.android.downloadlib.addownload.ka.9
            @Override // com.ss.android.downloadlib.addownload.ka.ms
            public void ms() {
                if (ka.this.d.ms()) {
                    return;
                }
                ka.this.x(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        Iterator<DownloadStatusChangeListener> it = x.ms(this.c).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.ub, zb());
        }
        int iMs = this.ah.ms(hi.getContext(), this.ch);
        String str = f4416ms;
        com.ss.android.downloadlib.ab.hi.ms(str, "beginDown id:" + iMs, null);
        if (iMs != 0) {
            if (this.x != null && !com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_click_start")) {
                this.ah.ms(this.x, false);
            } else if (z) {
                this.ah.ms();
            }
        } else {
            DownloadInfo downloadInfoMs = new DownloadInfo.ms(this.ub.getDownloadUrl()).ms();
            downloadInfoMs.setStatus(-1);
            ms(downloadInfoMs);
            com.ss.android.downloadlib.d.ms.ms().ms(this.u, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.ka.ah.ms().xr("beginDown");
        }
        if (this.ah.ms(ah())) {
            com.ss.android.downloadlib.ab.hi.ms(str, "beginDown IC id:" + iMs, null);
            hi();
        }
    }

    public void ab() {
        if (this.c.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = x.ms(this.c).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.x;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    private class ah extends com.bytedance.sdk.component.ch.d.xr<String, Void, DownloadInfo> {
        private ah() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
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
            if (ka.this.ub != null && !TextUtils.isEmpty(ka.this.ub.getFilePath())) {
                if (TextUtils.isEmpty(str)) {
                    downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(str2, ka.this.ub.getFilePath());
                } else {
                    downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(Downloader.getInstance(hi.getContext()).getDownloadId(str, ka.this.ub.getFilePath()));
                }
            }
            if (downloadInfo != null) {
                return downloadInfo;
            }
            if (!TextUtils.isEmpty(str)) {
                return com.ss.android.socialbase.appdownloader.d.ch().ms(hi.getContext(), str);
            }
            return com.ss.android.socialbase.appdownloader.d.ch().ms(hi.getContext(), str2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || ka.this.ub == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.xr.ah ahVarMs = com.ss.android.downloadlib.ab.zb.ms(ka.this.ub.getPackageName(), ka.this.ub.getVersionCode(), ka.this.ub.getVersionName());
                com.ss.android.downloadlib.addownload.xr.x.ms().ms(ka.this.ub.getVersionCode(), ahVarMs.xr(), com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo));
                boolean zMs = ahVarMs.ms();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (zMs || !Downloader.getInstance(hi.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(hi.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (ka.this.x == null || ka.this.x.getStatus() != -4) {
                        ka.this.x = downloadInfo;
                        if (ka.this.t) {
                            Downloader.getInstance(hi.getContext()).setMainThreadListener(ka.this.x.getId(), ka.this.ch, false);
                        } else {
                            Downloader.getInstance(hi.getContext()).setMainThreadListener(ka.this.x.getId(), ka.this.ch);
                        }
                    } else {
                        ka.this.x = null;
                    }
                    ka.this.ah.ms(ka.this.x, ka.this.h(), x.ms((Map<Integer, Object>) ka.this.c), zMs);
                } else {
                    if (downloadInfo != null && Downloader.getInstance(hi.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.xr.ms().c(downloadInfo.getId());
                        ka.this.x = null;
                    }
                    if (ka.this.x != null) {
                        Downloader.getInstance(hi.getContext()).removeTaskMainListener(ka.this.x.getId());
                        if (ka.this.t) {
                            Downloader.getInstance(ka.this.getContext()).setMainThreadListener(ka.this.x.getId(), ka.this.ch, false);
                        } else {
                            Downloader.getInstance(ka.this.getContext()).setMainThreadListener(ka.this.x.getId(), ka.this.ch);
                        }
                    }
                    if (!zMs) {
                        Iterator<DownloadStatusChangeListener> it = x.ms((Map<Integer, Object>) ka.this.c).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        ka.this.x = null;
                    } else {
                        ka.this.x = new DownloadInfo.ms(ka.this.ub.getDownloadUrl()).ms();
                        ka.this.x.setStatus(-3);
                        ka.this.ah.ms(ka.this.x, ka.this.h(), x.ms((Map<Integer, Object>) ka.this.c), zMs);
                    }
                }
                ka.this.ah.ah(ka.this.x);
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
    }

    private void ms(DownloadInfo downloadInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = downloadInfo;
        this.xr.sendMessage(messageObtain);
    }

    private void ao() {
        ah ahVar = this.ny;
        if (ahVar != null && ahVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.ny.cancel(true);
        }
        this.ny = new ah();
        if (!TextUtils.isEmpty(this.zb)) {
            com.ss.android.downloadlib.ab.xr.ms(this.ny, this.ub.getDownloadUrl(), this.ub.getPackageName(), this.zb);
        } else {
            com.ss.android.downloadlib.ab.xr.ms(this.ny, this.ub.getDownloadUrl(), this.ub.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo h() {
        if (this.ab == null) {
            this.ab = new DownloadShortInfo();
        }
        return this.ab;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public void x() {
        com.ss.android.downloadlib.addownload.xr.c.ms().c(this.u);
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public ab ms(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.zb = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.ab
    public ab ms(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.nw = null;
        } else {
            this.nw = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }

    public boolean ny() {
        SoftReference<IDownloadButtonClickListener> softReference = this.nw;
        if (softReference == null) {
            return false;
        }
        return ny.ms(this.ub, softReference.get());
    }

    public boolean d(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.nw;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.nw.get().handleComplianceDialog(true);
                } else {
                    this.nw.get().handleMarketFailedComplianceDialog();
                }
                this.nw = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.ka.ah.ms().xr("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.ka.ah.ms().xr("mDownloadButtonClickListener has recycled");
        return false;
    }
}
