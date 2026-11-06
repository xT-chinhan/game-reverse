package com.byazt.cvl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.eld.k;
import com.byazt.fi.BaseConstants;
import com.byazt.km.AdDownloadController;
import com.byazt.km.AdDownloadEventConfig;
import com.byazt.km.AdDownloadModel;
import com.byazt.uk.m;
import com.byazt.uk.w;
import com.byazt.zv.IDownloadButtonClickListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, 13})
public class hw implements com.byazt.wqt.hw {
    public static volatile hw hw;
    public static String pr = hw.class.getSimpleName();
    public vk hn = vk.pr(k.getContext());

    private hw() {
    }

    public static hw pr() {
        if (hw == null) {
            synchronized (hw.class) {
                if (hw == null) {
                    hw = new hw();
                }
            }
        }
        return hw;
    }

    @Override // com.byazt.wqt.hw
    public Dialog pr(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return pr(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    @Override // com.byazt.wqt.hw
    public Dialog pr(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return pr(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false, iDownloadButtonClickListener);
    }

    public Dialog pr(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        return pr(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, null);
    }

    public Dialog pr(final Context context, final String str, final boolean z, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i, final boolean z2, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.byazt.vi.hw.pr(new com.byazt.vi.hw.pr<Dialog>() { // from class: com.byazt.cvl.hw.1
            @Override // com.byazt.vi.hw.pr
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Dialog hw() {
                return hw.this.hw(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, iDownloadButtonClickListener);
            }
        });
    }

    public Dialog hw(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (pr(downloadModel.getId())) {
            if (z2) {
                pr(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                hw(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.hn.pr(context, i, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) m.pr(downloadEventConfig, hn());
        final DownloadController downloadController2 = (DownloadController) m.pr(downloadController, hw());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.byazt.xqu.hw.pr().pr(downloadModel)) ? true : (k.aj().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.hn.pr(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        w.pr(pr, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog dialogHw = k.hn().hw(new com.byazt.cxa.hw.pr(context).pr(downloadModel.getName()).hw("确认要下载此应用吗？").hn("确认").x("取消").pr(new com.byazt.cxa.hw.InterfaceC0036hw() { // from class: com.byazt.cvl.hw.2
            @Override // com.byazt.cxa.hw.InterfaceC0036hw
            public void pr(DialogInterface dialogInterface) {
                hw.this.hn.pr(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.byazt.mf.pr.pr().pr("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.byazt.cxa.hw.InterfaceC0036hw
            public void hw(DialogInterface dialogInterface) {
                com.byazt.mf.pr.pr().pr("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.byazt.cxa.hw.InterfaceC0036hw
            public void hn(DialogInterface dialogInterface) {
                com.byazt.mf.pr.pr().pr("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }
        }).pr(0).pr());
        com.byazt.mf.pr.pr().pr("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return dialogHw;
    }

    @Override // com.byazt.wqt.hw
    public boolean pr(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(j);
        if (hwVarX != null) {
            this.hn.pr(context, i, downloadStatusChangeListener, hwVarX.jw());
            return true;
        }
        DownloadModel downloadModelPr = com.byazt.shh.uc.pr().pr(j);
        if (downloadModelPr != null) {
            this.hn.pr(context, i, downloadStatusChangeListener, downloadModelPr);
            return true;
        }
        return false;
    }

    @Override // com.byazt.wqt.hw
    public boolean pr(long j, int i) {
        DownloadModel downloadModelPr = com.byazt.shh.uc.pr().pr(j);
        if (downloadModelPr != null) {
            this.hn.pr(downloadModelPr.getDownloadUrl(), i);
            return true;
        }
        return false;
    }

    public void pr(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel downloadModelPr = com.byazt.shh.uc.pr().pr(j);
        com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(j);
        if (downloadModelPr == null && hwVarX != null) {
            downloadModelPr = hwVarX.jw();
        }
        if (downloadModelPr == null) {
            return;
        }
        if (downloadEventConfig == null || downloadController == null || (downloadEventConfig instanceof com.byazt.bek.x) || (downloadController instanceof com.byazt.bek.hn)) {
            hw(j);
        } else {
            downloadEventConfig.setDownloadScene(1);
            this.hn.pr(downloadModelPr.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
        }
    }

    public void hw(long j) {
        DownloadEventConfig downloadEventConfig;
        DownloadController downloadControllerAa;
        DownloadModel downloadModelPr = com.byazt.shh.uc.pr().pr(j);
        com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(j);
        if (downloadModelPr == null && hwVarX != null) {
            downloadModelPr = hwVarX.jw();
        }
        if (downloadModelPr == null) {
            return;
        }
        DownloadEventConfig downloadEventConfigHw = com.byazt.shh.uc.pr().hw(j);
        DownloadController downloadControllerHn = com.byazt.shh.uc.pr().hn(j);
        if (downloadEventConfigHw instanceof com.byazt.bek.x) {
            downloadEventConfigHw = null;
        }
        if (downloadControllerHn instanceof com.byazt.bek.hn) {
            downloadControllerHn = null;
        }
        if (hwVarX == null) {
            if (downloadEventConfigHw == null) {
                downloadEventConfigHw = hn();
            }
            if (downloadControllerHn != null) {
                downloadEventConfig = downloadEventConfigHw;
                downloadControllerAa = downloadControllerHn;
            } else {
                downloadEventConfig = downloadEventConfigHw;
                downloadControllerAa = hw();
            }
        } else {
            if (downloadEventConfigHw == null) {
                downloadEventConfigHw = new AdDownloadEventConfig.Builder().setClickButtonTag(hwVarX.vk()).setRefer(hwVarX.aj()).setIsEnableV3Event(hwVarX.m()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (downloadControllerHn != null) {
                downloadEventConfig = downloadEventConfigHw;
                downloadControllerAa = downloadControllerHn;
            } else {
                downloadEventConfig = downloadEventConfigHw;
                downloadControllerAa = hwVarX.aa();
            }
        }
        downloadEventConfig.setDownloadScene(1);
        this.hn.pr(downloadModelPr.getDownloadUrl(), j, 2, downloadEventConfig, downloadControllerAa);
    }

    @Override // com.byazt.wqt.hw
    public boolean pr(long j) {
        return (com.byazt.shh.uc.pr().pr(j) == null && com.byazt.shh.uc.pr().x(j) == null) ? false : true;
    }

    @Override // com.byazt.wqt.hw
    public boolean pr(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return pr(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.byazt.wqt.hw
    public boolean pr(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.byazt.vi.hw.pr(new com.byazt.vi.hw.pr<Boolean>() { // from class: com.byazt.cvl.hw.3
            @Override // com.byazt.vi.hw.pr
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean hw() {
                return Boolean.valueOf(hw.this.hw(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hw(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        Context context2;
        DownloadController downloadControllerHw;
        if (!com.byazt.snv.pr.pr(uri) || k.aj().optInt("disable_market") == 1) {
            return false;
        }
        if (context != null) {
            context2 = context;
        } else {
            context2 = k.getContext();
        }
        String strHw = com.byazt.snv.pr.hw(uri);
        if (downloadModel == null) {
            return com.byazt.uk.aj.pr(context2, strHw).getType() == 5;
        }
        if (!TextUtils.isEmpty(strHw) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(strHw);
        }
        if (downloadController != null) {
            downloadController.setDownloadMode(2);
            downloadControllerHw = downloadController;
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadControllerHw = pr(true);
        } else if (downloadModel.getDownloadUrl().startsWith(BaseConstants.SCHEME_MARKET)) {
            downloadControllerHw = pr(true);
        } else {
            downloadControllerHw = hw();
        }
        com.byazt.shh.c cVar = new com.byazt.shh.c(downloadModel.getId(), downloadModel, (DownloadEventConfig) m.pr(downloadEventConfig, hn()), downloadControllerHw);
        com.byazt.shh.uc.pr().pr(cVar.hw);
        com.byazt.shh.uc.pr().pr(cVar.pr, cVar.hn);
        com.byazt.shh.uc.pr().pr(cVar.pr, cVar.x);
        if (m.pr(downloadModel) && com.byazt.ew.pr.hn().hw("app_link_opt") == 1 && com.byazt.ds.pr.pr(cVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        m.pr(jSONObject, "market_url", uri.toString());
        m.pr(jSONObject, "download_scene", (Object) 1);
        com.byazt.bek.hw marketStatusChangeListener = cVar.x.getMarketStatusChangeListener();
        com.byazt.mf.pr.pr().hw("market_click_open", jSONObject, cVar);
        com.byazt.shh.fw fwVarPr = com.byazt.uk.aj.pr(context2, cVar, strHw);
        String strPr = m.pr(fwVarPr.hw(), "open_market");
        if (fwVarPr.getType() == 5) {
            com.byazt.ds.pr.pr(strPr, jSONObject, cVar, true);
            return true;
        }
        if (fwVarPr.getType() != 6) {
            return true;
        }
        m.pr(jSONObject, Constants.ERROR_CODE_FIELD, Integer.valueOf(fwVarPr.pr()));
        if (marketStatusChangeListener != null) {
            marketStatusChangeListener.hw();
        }
        com.byazt.mf.pr.pr().hw("market_open_failed", jSONObject, cVar);
        if (com.byazt.eld.aj.pr(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController hw() {
        return pr(false);
    }

    public static DownloadController pr(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    public static DownloadEventConfig hn() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }
}
