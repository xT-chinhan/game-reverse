package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements com.ss.android.downloadad.api.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f4526ms = "xr";
    private static volatile xr xr;
    private ch ah = ch.ms(hi.getContext());

    private xr() {
    }

    public static xr ms() {
        if (xr == null) {
            synchronized (xr.class) {
                if (xr == null) {
                    xr = new xr();
                }
            }
        }
        return xr;
    }

    @Override // com.ss.android.downloadad.api.xr
    public Dialog ms(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return ms(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    @Override // com.ss.android.downloadad.api.xr
    public Dialog ms(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ms(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false, iDownloadButtonClickListener);
    }

    public Dialog ms(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        return ms(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, null);
    }

    public Dialog ms(final Context context, final String str, final boolean z, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i, final boolean z2, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.ka.xr.ms(new com.ss.android.downloadlib.ka.xr.ms<Dialog>() { // from class: com.ss.android.downloadlib.xr.1
            @Override // com.ss.android.downloadlib.ka.xr.ms
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Dialog xr() {
                return xr.this.xr(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, iDownloadButtonClickListener);
            }
        });
    }

    public Dialog xr(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (ms(downloadModel.getId())) {
            if (z2) {
                ms(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                xr(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.ah.ms(context, i, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) zb.ms(downloadEventConfig, ah());
        final DownloadController downloadController2 = (DownloadController) zb.ms(downloadController, xr());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.xr.ms().ms(downloadModel)) ? true : (hi.ny().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.ah.ms(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        com.ss.android.downloadlib.ab.hi.ms(f4526ms, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog dialogXr = hi.ah().xr(new com.ss.android.download.api.model.xr.ms(context).ms(downloadModel.getName()).xr("确认要下载此应用吗？").ah("确认").d("取消").ms(new com.ss.android.download.api.model.xr.InterfaceC0531xr() { // from class: com.ss.android.downloadlib.xr.2
            @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
            public void ms(DialogInterface dialogInterface) {
                xr.this.ah.ms(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.ss.android.downloadlib.d.ms.ms().ms("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
            public void xr(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.ms.ms().ms("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
            public void ah(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.ms.ms().ms("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }
        }).ms(0).ms());
        com.ss.android.downloadlib.d.ms.ms().ms("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return dialogXr;
    }

    @Override // com.ss.android.downloadad.api.xr
    public boolean ms(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        com.ss.android.downloadad.api.ms.xr xrVarD = com.ss.android.downloadlib.addownload.xr.c.ms().d(j);
        if (xrVarD != null) {
            this.ah.ms(context, i, downloadStatusChangeListener, xrVarD.vl());
            return true;
        }
        DownloadModel downloadModelMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(j);
        if (downloadModelMs == null) {
            return false;
        }
        this.ah.ms(context, i, downloadStatusChangeListener, downloadModelMs);
        return true;
    }

    @Override // com.ss.android.downloadad.api.xr
    public boolean ms(long j, int i) {
        DownloadModel downloadModelMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(j);
        if (downloadModelMs == null) {
            return false;
        }
        this.ah.ms(downloadModelMs.getDownloadUrl(), i);
        return true;
    }

    public void ms(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel downloadModelMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(j);
        com.ss.android.downloadad.api.ms.xr xrVarD = com.ss.android.downloadlib.addownload.xr.c.ms().d(j);
        if (downloadModelMs == null && xrVarD != null) {
            downloadModelMs = xrVarD.vl();
        }
        if (downloadModelMs == null) {
            return;
        }
        if (downloadEventConfig == null || downloadController == null || (downloadEventConfig instanceof com.ss.android.download.api.download.ah) || (downloadController instanceof com.ss.android.download.api.download.xr)) {
            xr(j);
        } else {
            downloadEventConfig.setDownloadScene(1);
            this.ah.ms(downloadModelMs.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
        }
    }

    public void xr(long j) {
        DownloadModel downloadModelMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(j);
        com.ss.android.downloadad.api.ms.xr xrVarD = com.ss.android.downloadlib.addownload.xr.c.ms().d(j);
        if (downloadModelMs == null && xrVarD != null) {
            downloadModelMs = xrVarD.vl();
        }
        if (downloadModelMs == null) {
            return;
        }
        DownloadEventConfig downloadEventConfigXr = com.ss.android.downloadlib.addownload.xr.c.ms().xr(j);
        DownloadController downloadControllerAh = com.ss.android.downloadlib.addownload.xr.c.ms().ah(j);
        if (downloadEventConfigXr instanceof com.ss.android.download.api.download.ah) {
            downloadEventConfigXr = null;
        }
        if (downloadControllerAh instanceof com.ss.android.download.api.download.xr) {
            downloadControllerAh = null;
        }
        if (xrVarD == null) {
            if (downloadEventConfigXr == null) {
                downloadEventConfigXr = ah();
            }
            if (downloadControllerAh == null) {
                downloadControllerAh = xr();
            }
        } else {
            if (downloadEventConfigXr == null) {
                downloadEventConfigXr = new AdDownloadEventConfig.Builder().setClickButtonTag(xrVarD.ch()).setRefer(xrVarD.ny()).setIsEnableV3Event(xrVarD.zb()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (downloadControllerAh == null) {
                downloadControllerAh = xrVarD.ce();
            }
        }
        DownloadEventConfig downloadEventConfig = downloadEventConfigXr;
        downloadEventConfig.setDownloadScene(1);
        this.ah.ms(downloadModelMs.getDownloadUrl(), j, 2, downloadEventConfig, downloadControllerAh);
    }

    @Override // com.ss.android.downloadad.api.xr
    public boolean ms(long j) {
        return (com.ss.android.downloadlib.addownload.xr.c.ms().ms(j) == null && com.ss.android.downloadlib.addownload.xr.c.ms().d(j) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.xr
    public boolean ms(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return ms(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.xr
    public boolean ms(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.ka.xr.ms(new com.ss.android.downloadlib.ka.xr.ms<Boolean>() { // from class: com.ss.android.downloadlib.xr.3
            @Override // com.ss.android.downloadlib.ka.xr.ms
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean xr() {
                return Boolean.valueOf(xr.this.xr(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xr(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadControllerXr = downloadController;
        if (!com.ss.android.download.api.ah.ms.ms(uri) || hi.ny().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? hi.getContext() : context;
        String strXr = com.ss.android.download.api.ah.ms.xr(uri);
        if (downloadModel == null) {
            return com.ss.android.downloadlib.ab.ny.ms(context2, strXr).getType() == 5;
        }
        if (!TextUtils.isEmpty(strXr) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(strXr);
        }
        if (downloadControllerXr != null) {
            downloadControllerXr.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadControllerXr = ms(true);
        } else if (downloadModel.getDownloadUrl().startsWith("market")) {
            downloadControllerXr = ms(true);
        } else {
            downloadControllerXr = xr();
        }
        com.ss.android.downloadlib.addownload.xr.ka kaVar = new com.ss.android.downloadlib.addownload.xr.ka(downloadModel.getId(), downloadModel, (DownloadEventConfig) zb.ms(downloadEventConfig, ah()), downloadControllerXr);
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(kaVar.xr);
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(kaVar.f4454ms, kaVar.ah);
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(kaVar.f4454ms, kaVar.d);
        if (zb.ms(downloadModel) && com.ss.android.socialbase.downloader.ab.ms.ah().xr("app_link_opt") == 1 && com.ss.android.downloadlib.xr.ms.ms(kaVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        zb.ms(jSONObject, "market_url", uri.toString());
        zb.ms(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.d.ms.ms().xr("market_click_open", jSONObject, kaVar);
        com.ss.android.downloadlib.addownload.xr.ab abVarMs = com.ss.android.downloadlib.ab.ny.ms(context2, kaVar, strXr);
        String strMs = zb.ms(abVarMs.xr(), "open_market");
        if (abVarMs.getType() == 5) {
            com.ss.android.downloadlib.xr.ms.ms(strMs, jSONObject, kaVar, true);
            return true;
        }
        if (abVarMs.getType() != 6) {
            return true;
        }
        zb.ms(jSONObject, "error_code", Integer.valueOf(abVarMs.ms()));
        com.ss.android.downloadlib.d.ms.ms().xr("market_open_failed", jSONObject, kaVar);
        if (com.ss.android.downloadlib.addownload.ny.ms(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController xr() {
        return ms(false);
    }

    public static DownloadController ms(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    public static DownloadEventConfig ah() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }
}
