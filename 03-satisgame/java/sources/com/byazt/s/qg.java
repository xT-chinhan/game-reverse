package com.byazt.s;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.ky.IDownloadButtonClickListener;
import com.byazt.rz.cp;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.y.AdDownloadController;
import com.byazt.y.AdDownloadEventConfig;
import com.byazt.y.AdDownloadModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 8, 26})
public class qg implements com.byazt.w.qg {
    public static String n = "qg";
    public static volatile qg qg;
    public tj s = tj.n(d.getContext());

    private qg() {
    }

    public static qg n() {
        if (qg == null) {
            synchronized (qg.class) {
                if (qg == null) {
                    qg = new qg();
                }
            }
        }
        return qg;
    }

    @Override // com.byazt.w.qg
    public Dialog n(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return n(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    @Override // com.byazt.w.qg
    public Dialog n(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return n(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false, iDownloadButtonClickListener);
    }

    public Dialog n(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        return n(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, null);
    }

    public Dialog n(final Context context, final String str, final boolean z, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i, final boolean z2, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.byazt.ch.qg.n(new com.byazt.ch.qg.n<Dialog>() { // from class: com.byazt.s.qg.1
            @Override // com.byazt.ch.qg.n
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Dialog qg() {
                return qg.this.qg(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, iDownloadButtonClickListener);
            }
        });
    }

    public Dialog qg(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (n(downloadModel.getId())) {
            if (z2) {
                n(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                qg(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.s.n(context, i, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) oa.n(downloadEventConfig, s());
        final DownloadController downloadController2 = (DownloadController) oa.n(downloadController, qg());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.byazt.su.qg.n().n(downloadModel)) ? true : (d.rv().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.s.n(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        cp.n(n, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog dialogQg = d.s().qg(new com.byazt.os.qg.n(context).n(downloadModel.getName()).qg("确认要下载此应用吗？").s("确认").q("取消").n(new com.byazt.os.qg.InterfaceC0286qg() { // from class: com.byazt.s.qg.2
            @Override // com.byazt.os.qg.InterfaceC0286qg
            public void n(DialogInterface dialogInterface) {
                qg.this.s.n(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.byazt.vj.n.n().n("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.byazt.os.qg.InterfaceC0286qg
            public void qg(DialogInterface dialogInterface) {
                com.byazt.vj.n.n().n("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.byazt.os.qg.InterfaceC0286qg
            public void s(DialogInterface dialogInterface) {
                com.byazt.vj.n.n().n("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }
        }).n(0).n());
        com.byazt.vj.n.n().n("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return dialogQg;
    }

    @Override // com.byazt.w.qg
    public boolean n(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(j);
        if (qgVarQ != null) {
            this.s.n(context, i, downloadStatusChangeListener, qgVarQ.dn());
            return true;
        }
        DownloadModel downloadModelN = com.byazt.vl.w.n().n(j);
        if (downloadModelN == null) {
            return false;
        }
        this.s.n(context, i, downloadStatusChangeListener, downloadModelN);
        return true;
    }

    @Override // com.byazt.w.qg
    public boolean n(long j, int i) {
        DownloadModel downloadModelN = com.byazt.vl.w.n().n(j);
        if (downloadModelN == null) {
            return false;
        }
        this.s.n(downloadModelN.getDownloadUrl(), i);
        return true;
    }

    public void n(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel downloadModelN = com.byazt.vl.w.n().n(j);
        com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(j);
        if (downloadModelN == null && qgVarQ != null) {
            downloadModelN = qgVarQ.dn();
        }
        if (downloadModelN == null) {
            return;
        }
        if (downloadEventConfig == null || downloadController == null || (downloadEventConfig instanceof com.byazt.hj.q) || (downloadController instanceof com.byazt.hj.s)) {
            qg(j);
        } else {
            downloadEventConfig.setDownloadScene(1);
            this.s.n(downloadModelN.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
        }
    }

    public void qg(long j) {
        DownloadModel downloadModelN = com.byazt.vl.w.n().n(j);
        com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(j);
        if (downloadModelN == null && qgVarQ != null) {
            downloadModelN = qgVarQ.dn();
        }
        if (downloadModelN == null) {
            return;
        }
        DownloadEventConfig downloadEventConfigQg = com.byazt.vl.w.n().qg(j);
        DownloadController downloadControllerS = com.byazt.vl.w.n().s(j);
        if (downloadEventConfigQg instanceof com.byazt.hj.q) {
            downloadEventConfigQg = null;
        }
        if (downloadControllerS instanceof com.byazt.hj.s) {
            downloadControllerS = null;
        }
        if (qgVarQ == null) {
            if (downloadEventConfigQg == null) {
                downloadEventConfigQg = s();
            }
            if (downloadControllerS == null) {
                downloadControllerS = qg();
            }
        } else {
            if (downloadEventConfigQg == null) {
                downloadEventConfigQg = new AdDownloadEventConfig.Builder().setClickButtonTag(qgVarQ.tj()).setRefer(qgVarQ.rv()).setIsEnableV3Event(qgVarQ.oa()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (downloadControllerS == null) {
                downloadControllerS = qgVarQ.el();
            }
        }
        DownloadEventConfig downloadEventConfig = downloadEventConfigQg;
        downloadEventConfig.setDownloadScene(1);
        this.s.n(downloadModelN.getDownloadUrl(), j, 2, downloadEventConfig, downloadControllerS);
    }

    @Override // com.byazt.w.qg
    public boolean n(long j) {
        return (com.byazt.vl.w.n().n(j) == null && com.byazt.vl.w.n().q(j) == null) ? false : true;
    }

    @Override // com.byazt.w.qg
    public boolean n(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return n(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.byazt.w.qg
    public boolean n(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.byazt.ch.qg.n(new com.byazt.ch.qg.n<Boolean>() { // from class: com.byazt.s.qg.3
            @Override // com.byazt.ch.qg.n
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean qg() {
                return Boolean.valueOf(qg.this.qg(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qg(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadControllerQg = downloadController;
        if (!com.byazt.es.n.n(uri) || d.rv().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? d.getContext() : context;
        String strQg = com.byazt.es.n.qg(uri);
        if (downloadModel == null) {
            return com.byazt.rz.rv.n(context2, strQg).getType() == 5;
        }
        if (!TextUtils.isEmpty(strQg) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(strQg);
        }
        if (downloadControllerQg != null) {
            downloadControllerQg.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadControllerQg = n(true);
        } else if (downloadModel.getDownloadUrl().startsWith("market")) {
            downloadControllerQg = n(true);
        } else {
            downloadControllerQg = qg();
        }
        com.byazt.vl.l lVar = new com.byazt.vl.l(downloadModel.getId(), downloadModel, (DownloadEventConfig) oa.n(downloadEventConfig, s()), downloadControllerQg);
        com.byazt.vl.w.n().n(lVar.qg);
        com.byazt.vl.w.n().n(lVar.n, lVar.s);
        com.byazt.vl.w.n().n(lVar.n, lVar.q);
        if (oa.n(downloadModel) && com.byazt.f.n.s().qg("app_link_opt") == 1 && com.byazt.t.n.n(lVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        oa.n(jSONObject, "market_url", uri.toString());
        oa.n(jSONObject, "download_scene", (Object) 1);
        com.byazt.hj.qg marketStatusChangeListener = lVar.q.getMarketStatusChangeListener();
        com.byazt.vj.n.n().qg("market_click_open", jSONObject, lVar);
        com.byazt.vl.x xVarN = com.byazt.rz.rv.n(context2, lVar, strQg);
        String strN = oa.n(xVarN.qg(), "open_market");
        if (xVarN.getType() == 5) {
            com.byazt.t.n.n(strN, jSONObject, lVar, true);
            return true;
        }
        if (xVarN.getType() != 6) {
            return true;
        }
        oa.n(jSONObject, "error_code", Integer.valueOf(xVarN.n()));
        if (marketStatusChangeListener != null) {
            marketStatusChangeListener.qg();
        }
        com.byazt.vj.n.n().qg("market_open_failed", jSONObject, lVar);
        if (com.byazt.ug.rv.n(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController qg() {
        return n(false);
    }

    public static DownloadController n(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    public static DownloadEventConfig s() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }
}
