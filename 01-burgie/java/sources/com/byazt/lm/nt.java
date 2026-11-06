package com.byazt.lm;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.cxa.DeepLink;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.km.AdDownloadController;
import com.byazt.km.AdDownloadEventConfig;
import com.byazt.km.AdDownloadModel;
import com.byazt.mdu.DownloadHandlerService;
import com.byazt.ol.TTDownloadField;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.wt.ls;
import com.byazt.zv.DownloadMarketInterceptor;
import com.byazt.zv.IDownloadButtonClickListener;
import com.byazt.zv.OnItemClickListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.mar.sdk.MARCode;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 572, 74})
public final class nt extends com.byazt.ofr.x {
    public static volatile nt pr;
    public Function<SparseArray<Object>, Object> aj;
    public final Context hw;
    public Map<Integer, AdDownloadModel.Builder> hn = new ConcurrentHashMap();
    public Map<Integer, AdDownloadModel> x = new ConcurrentHashMap();
    public Map<Integer, AdDownloadController.Builder> c = new ConcurrentHashMap();
    public Map<Integer, AdDownloadController> uc = new ConcurrentHashMap();
    public Map<Integer, AdDownloadEventConfig.Builder> fw = new ConcurrentHashMap();
    public Map<Integer, AdDownloadEventConfig> zo = new ConcurrentHashMap();

    private Function<SparseArray<Object>, Object> hw() {
        Function<SparseArray<Object>, Object> function = this.aj;
        if (function != null) {
            return function;
        }
        Function<SparseArray<Object>, Object> functionUc = com.byazt.sd.zo.nt().uc(3);
        this.aj = functionUc;
        if (functionUc == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("n", com.byazt.sd.zo.nt().ls());
        this.aj.apply(com.byazt.xi.hw.pr().pr(159).pr(Map.class).pr(0, map).hw());
        return this.aj;
    }

    private void eh(int i) {
        this.hn.remove(Integer.valueOf(i));
        this.x.remove(Integer.valueOf(i));
        this.c.remove(Integer.valueOf(i));
        this.uc.remove(Integer.valueOf(i));
        this.fw.remove(Integer.valueOf(i));
        this.zo.remove(Integer.valueOf(i));
    }

    private AdDownloadModel.Builder na(int i) {
        return this.hn.get(Integer.valueOf(i));
    }

    private AdDownloadModel rk(int i) {
        return this.x.get(Integer.valueOf(i));
    }

    private AdDownloadController mr(int i) {
        return this.uc.get(Integer.valueOf(i));
    }

    private AdDownloadEventConfig ag(int i) {
        return this.zo.get(Integer.valueOf(i));
    }

    private nt(Context context) {
        this.hw = context;
    }

    public static nt pr(Context context) {
        if (pr == null) {
            synchronized (nt.class) {
                if (pr == null) {
                    pr = new nt(context);
                }
            }
        }
        return pr;
    }

    public <T> T pr(Class<T> cls, int i, Map<String, Object> map) {
        int iIntValue;
        DownloadEventConfig downloadEventConfigC;
        Context context;
        DownloadModel downloadModelX;
        DownloadController downloadControllerUc;
        DownloadEventConfig downloadEventConfigC2;
        DownloadEventConfig downloadEventConfigC3;
        Object obj = map.get("hashCode");
        if (!(obj instanceof Integer)) {
            iIntValue = 0;
        } else {
            iIntValue = ((Integer) obj).intValue();
        }
        DownloadModel downloadModelRk = rk(iIntValue);
        switch (i) {
            case 0:
                return (T) Boolean.valueOf(ho.pr(getActivity(map.get(TTDownloadField.TT_ACTIVITY)), zo(map.get(TTDownloadField.TT_EXIT_INSTALL_LISTENER))));
            case 1:
                return (T) ho.hw().uc();
            case 2:
                try {
                    return (T) Boolean.valueOf(ho.pr((String) map.get("tagIntercept"), (String) map.get("label"), new JSONObject((String) map.get("meta")), new HashMap()));
                } catch (JSONException e) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                ho.pr(((Integer) map.get("hid")).intValue());
                return null;
            case 4:
                ho.hw().pr(downloadModelRk == null ? (String) map.get("downloadUrl") : downloadModelRk.getDownloadUrl(), iIntValue);
                eh(iIntValue);
                return null;
            case 5:
                if (downloadModelRk == null) {
                    downloadModelRk = x(map.get("downloadModel"));
                }
                DownloadStatusChangeListener downloadStatusChangeListenerHw = hw(map.get("downloadStatusChangeListener"));
                DownloadController downloadControllerMr = mr(iIntValue);
                if (downloadControllerMr == null) {
                    downloadControllerMr = uc(map.get("downloadController"));
                }
                com.byazt.bek.hw hwVarHn = hn(map.get("marketStatusChangeListener"));
                if (hwVarHn != null && (downloadControllerMr instanceof AdDownloadController)) {
                    ((AdDownloadController) downloadControllerMr).setMarketStatusChangeListener(hwVarHn);
                }
                ho.hw().pr(this.hw, iIntValue, downloadStatusChangeListenerHw, downloadModelRk);
                return null;
            case 6:
                return (T) Boolean.valueOf(ho.pr(this.hw, downloadModelRk == null ? (String) map.get("downloadUrl") : downloadModelRk.getDownloadUrl()));
            case 7:
                ho.hn();
                return null;
            case 8:
                ho.hw().pr(downloadModelRk == null ? (String) map.get("downloadUrl") : downloadModelRk.getDownloadUrl(), ((Boolean) map.get("force")).booleanValue());
                return null;
            case 9:
                ho.pr(((Integer) map.get("hid")).intValue(), (hn.pr) map.get("onEventLogHandler"));
                return null;
            case 10:
                ho.pr((String) map.get("downloadPath"));
                return null;
            case 11:
            case 20:
            case 21:
            case 22:
            case 43:
            case 77:
            case 126:
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME /* 138 */:
            case 155:
            case 156:
            case 159:
            case 161:
            default:
                return null;
            case 12:
                Uri uri = (Uri) map.get(ContentProviderManager.PROVIDER_URI);
                if (downloadModelRk == null) {
                    downloadModelRk = x(map.get("downloadModel"));
                }
                AdDownloadEventConfig adDownloadEventConfigAg = ag(iIntValue);
                if (adDownloadEventConfigAg == null) {
                    downloadEventConfigC = c(map.get("downloadEventConfig"));
                } else {
                    downloadEventConfigC = adDownloadEventConfigAg;
                }
                DownloadController downloadControllerMr2 = mr(iIntValue);
                if (downloadControllerMr2 == null) {
                    downloadControllerMr2 = uc(map.get("downloadController"));
                }
                Activity activity = getActivity(map.get(TTDownloadField.TT_ACTIVITY));
                boolean zFw = fw(map.get("open_market_in_app"));
                Context context2 = this.hw;
                if ((downloadControllerMr2 instanceof AdDownloadController) && activity != null && zFw) {
                    context = activity;
                } else {
                    context = context2;
                }
                IDownloadButtonClickListener iDownloadButtonClickListenerW = w(map.get("downloadButtonClickListener"));
                if (pr(iDownloadButtonClickListenerW)) {
                    return (T) Boolean.valueOf(ho.pr(context, uri, downloadModelRk, downloadEventConfigC, downloadControllerMr2, iDownloadButtonClickListenerW));
                }
                return (T) Boolean.valueOf(ho.pr(context, uri, downloadModelRk, downloadEventConfigC, downloadControllerMr2));
            case 13:
                boolean zBooleanValue = ((Boolean) map.get("isDisableDialog")).booleanValue();
                String str = (String) map.get("userAgent");
                if (downloadModelRk == null) {
                    downloadModelX = x(map.get("downloadModel"));
                } else {
                    downloadModelX = downloadModelRk;
                }
                DownloadEventConfig downloadEventConfigAg = ag(iIntValue);
                if (downloadEventConfigAg == null) {
                    downloadEventConfigAg = c(map.get("downloadEventConfig"));
                }
                AdDownloadController adDownloadControllerMr = mr(iIntValue);
                if (adDownloadControllerMr == null) {
                    downloadControllerUc = uc(map.get("downloadController"));
                } else {
                    downloadControllerUc = adDownloadControllerMr;
                }
                DownloadStatusChangeListener downloadStatusChangeListenerHw2 = hw(map.get("downloadStatusChangeListener"));
                IDownloadButtonClickListener iDownloadButtonClickListenerW2 = w(map.get("downloadButtonClickListener"));
                if (pr(iDownloadButtonClickListenerW2)) {
                    ho.hw().c().pr(this.hw, str, zBooleanValue, downloadModelX, downloadEventConfigAg, downloadControllerUc, downloadStatusChangeListenerHw2, iIntValue, iDownloadButtonClickListenerW2);
                    return null;
                }
                ho.hw().c().pr(this.hw, str, zBooleanValue, downloadModelX, downloadEventConfigAg, downloadControllerUc, downloadStatusChangeListenerHw2, iIntValue);
                return null;
            case 14:
                return (T) Boolean.valueOf(ho.hw().c().pr(this.hw, downloadModelRk == null ? ((Long) map.get("id")).longValue() : downloadModelRk.getId(), downloadModelRk == null ? (String) map.get("logExtra") : downloadModelRk.getLogExtra(), (DownloadStatusChangeListener) null, iIntValue));
            case 15:
                return (T) Boolean.valueOf(ho.pr((Uri) map.get(ContentProviderManager.PROVIDER_URI)));
            case 16:
                String downloadUrl = downloadModelRk == null ? (String) map.get("downloadUrl") : downloadModelRk.getDownloadUrl();
                long jLongValue = downloadModelRk == null ? ((Long) map.get("id")).longValue() : downloadModelRk.getId();
                int iIntValue2 = ((Integer) map.get("action_type_button")).intValue();
                AdDownloadEventConfig adDownloadEventConfigAg2 = ag(iIntValue);
                if (adDownloadEventConfigAg2 == null) {
                    downloadEventConfigC2 = c(map.get("downloadEventConfig"));
                } else {
                    downloadEventConfigC2 = adDownloadEventConfigAg2;
                }
                DownloadController downloadControllerMr3 = mr(iIntValue);
                if (downloadControllerMr3 == null) {
                    downloadControllerMr3 = uc(map.get("downloadController"));
                }
                Activity activity2 = getActivity(map.get(TTDownloadField.TT_ACTIVITY));
                boolean zFw2 = fw(map.get("open_market_in_app"));
                if ((downloadControllerMr3 instanceof AdDownloadController) && activity2 != null && zFw2) {
                    ((AdDownloadController) downloadControllerMr3).setWeakActivity(activity2);
                }
                ho.hw().pr(downloadUrl, jLongValue, iIntValue2, downloadEventConfigC2, downloadControllerMr3);
                return null;
            case 17:
                String downloadUrl2 = downloadModelRk == null ? (String) map.get("downloadUrl") : downloadModelRk.getDownloadUrl();
                long jLongValue2 = ((Long) map.get("id")).longValue();
                int iIntValue3 = ((Integer) map.get("action_type_button")).intValue();
                AdDownloadEventConfig adDownloadEventConfigAg3 = ag(iIntValue);
                if (adDownloadEventConfigAg3 == null) {
                    downloadEventConfigC3 = c(map.get("downloadEventConfig"));
                } else {
                    downloadEventConfigC3 = adDownloadEventConfigAg3;
                }
                DownloadController downloadControllerMr4 = mr(iIntValue);
                if (downloadControllerMr4 == null) {
                    downloadControllerMr4 = uc(map.get("downloadController"));
                }
                OnItemClickListener onItemClickListenerVk = vk(map.get("itemClickListener"));
                IDownloadButtonClickListener iDownloadButtonClickListenerW3 = w(map.get("downloadButtonClickListener"));
                Activity activity3 = getActivity(map.get(TTDownloadField.TT_ACTIVITY));
                boolean zFw3 = fw(map.get("open_market_in_app"));
                if ((downloadControllerMr4 instanceof AdDownloadController) && activity3 != null && zFw3) {
                    ((AdDownloadController) downloadControllerMr4).setWeakActivity(activity3);
                }
                ho.hw().pr(downloadUrl2, jLongValue2, iIntValue3, downloadEventConfigC3, downloadControllerMr4, onItemClickListenerVk, iDownloadButtonClickListenerW3);
                return null;
            case 18:
                T t = (T) Boolean.valueOf(ho.hw().c().pr(downloadModelRk == null ? ((Long) map.get("id")).longValue() : downloadModelRk.getId(), iIntValue));
                eh(iIntValue);
                return t;
            case 19:
                return (T) Boolean.valueOf(ho.hw().c().pr(downloadModelRk == null ? ((Long) map.get("id")).longValue() : downloadModelRk.getId()));
            case 23:
                if (((Boolean) map.get("mateIsEmpty")).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.hn.put(Integer.valueOf(iIntValue), builder);
                    this.x.put(Integer.valueOf(iIntValue), builder.build());
                    return null;
                }
                hw(iIntValue, map);
                return null;
            case 24:
                pr(iIntValue, (String) map.get("appIcon"), (String) map.get("appName"), (String) map.get(BillingClientConstants.PACKAGE_NAME));
                return null;
            case 25:
                pr(iIntValue, ((Integer) map.get("autoOpen")).intValue(), ((Integer) map.get("downloadMode")).intValue(), ((Boolean) map.get("isHaveDownloadSdkConfig")).booleanValue(), ((Boolean) map.get("isEnableAH")).booleanValue(), ((Boolean) map.get("isEnableAM")).booleanValue());
                return null;
            case 26:
                uc(iIntValue, ((Integer) map.get("downloadMode")).intValue());
                return null;
            case 27:
                return (T) Integer.valueOf(fe(iIntValue));
            case 28:
                pr(iIntValue, ((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue(), aj(map.get("downloadMarketInterceptor")));
                return null;
            case 29:
                x(iIntValue, map);
                return null;
            case 30:
                hw(iIntValue, ((Integer) map.get("downloadScene")).intValue());
                return null;
            case 31:
                c(iIntValue, ((Boolean) map.get("isShowToast")).booleanValue());
                return null;
            case 32:
                hn(iIntValue, map);
                return null;
            case 33:
                return (T) Integer.valueOf(pr(iIntValue));
            case 34:
                return (T) Boolean.valueOf(hw(iIntValue));
            case 35:
                return (T) Boolean.valueOf(hn(iIntValue));
            case 36:
                return (T) x(iIntValue);
            case 37:
                return (T) Boolean.valueOf(c(iIntValue));
            case 38:
                return (T) Integer.valueOf(uc(iIntValue));
            case 39:
                return (T) Boolean.valueOf(fw(iIntValue));
            case 40:
                return (T) Integer.valueOf(zo(iIntValue));
            case 41:
                return (T) aj(iIntValue);
            case 42:
                return (T) vk(iIntValue);
            case 44:
                pr(iIntValue, ((Integer) map.get("linkMode")).intValue());
                return null;
            case 45:
                return (T) Boolean.valueOf(w(iIntValue));
            case 46:
                pr(iIntValue, ((Boolean) map.get("enableShowComplianceDialog")).booleanValue());
                return null;
            case 47:
                return (T) Boolean.valueOf(k(iIntValue));
            case 48:
                return (T) Boolean.valueOf(m(iIntValue));
            case 49:
                hw(iIntValue, ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue());
                return null;
            case 50:
                hn(iIntValue, ((Boolean) map.get("enableNewActivity")).booleanValue());
                return null;
            case 51:
                return (T) Boolean.valueOf(g(iIntValue));
            case 52:
                return (T) Boolean.valueOf(ho(iIntValue));
            case 53:
                pr(iIntValue, map.get("extraObject"));
                return null;
            case 54:
                pr(iIntValue, (JSONObject) map.get("extraJson"));
                return null;
            case 55:
                return (T) Boolean.valueOf(nt(iIntValue));
            case 56:
                c(iIntValue, map);
                return null;
            case 57:
                return (T) String.valueOf(yb(iIntValue));
            case 58:
                return (T) String.valueOf(lb(iIntValue));
            case 59:
                return (T) String.valueOf(qa(iIntValue));
            case 60:
                return (T) String.valueOf(a(iIntValue));
            case 61:
                return (T) String.valueOf(cz(iIntValue));
            case 62:
                return (T) String.valueOf(ny(iIntValue));
            case 63:
                return (T) String.valueOf(fo(iIntValue));
            case 64:
                return (T) String.valueOf(rc(iIntValue));
            case 65:
                return (T) String.valueOf(z(iIntValue));
            case 66:
                return (T) b(iIntValue);
            case 67:
                return (T) Integer.valueOf(iu(iIntValue));
            case 68:
                return (T) Boolean.valueOf(ve(iIntValue));
            case 69:
                return (T) Boolean.valueOf(gz(iIntValue));
            case 70:
                return (T) nl(iIntValue);
            case 71:
                return (T) y(iIntValue);
            case 72:
                hw(iIntValue, map.get("extraEventObject"));
                return null;
            case 73:
                pr(iIntValue, (String) map.get("clickButtonTag"));
                return null;
            case 74:
                hw(iIntValue, (JSONObject) map.get("eventConfigExtraJson"));
                return null;
            case 75:
                hn(iIntValue, (JSONObject) map.get("paramsJson"));
                return null;
            case 76:
                hw(iIntValue, (String) map.get("clickItemTag"));
                return null;
            case 78:
                hn(iIntValue, (String) map.get("refer"));
                return null;
            case 79:
                x(iIntValue, (String) map.get("quickAppEventTag"));
                return null;
            case 80:
                uc(iIntValue, map);
                return null;
            case 81:
                return (T) Long.valueOf(ww(iIntValue));
            case 82:
                return (T) String.valueOf(n(iIntValue));
            case 83:
                return (T) Long.valueOf(e(iIntValue));
            case 84:
                return (T) Long.valueOf(s(iIntValue));
            case 85:
                return (T) String.valueOf(ls(iIntValue));
            case 86:
                return (T) er(iIntValue);
            case 87:
                return (T) String.valueOf(v(iIntValue));
            case 88:
                return (T) String.valueOf(qi(iIntValue));
            case 89:
                return (T) String.valueOf(qn(iIntValue));
            case 90:
                return (T) of(iIntValue);
            case 91:
                return (T) Boolean.valueOf(ii(iIntValue));
            case 92:
                return (T) Boolean.valueOf(i(iIntValue));
            case 93:
                return (T) Boolean.valueOf(r(iIntValue));
            case 94:
                return (T) Boolean.valueOf(hs(iIntValue));
            case 95:
                return (T) Boolean.valueOf(nw(iIntValue));
            case 96:
                return (T) String.valueOf(ie(iIntValue));
            case 97:
                return (T) String.valueOf(o(iIntValue));
            case 98:
                f(iIntValue);
                return null;
            case 99:
                return (T) bm(iIntValue);
            case 100:
                jn(iIntValue);
                return null;
            case 101:
                l(iIntValue);
                return null;
            case 102:
                return (T) Boolean.valueOf(lv(iIntValue));
            case 103:
                return (T) Integer.valueOf(od(iIntValue));
            case 104:
                return (T) String.valueOf(vj(iIntValue));
            case 105:
                return (T) Boolean.valueOf(mw(iIntValue));
            case 106:
                return (T) String.valueOf(sv(iIntValue));
            case 107:
                return (T) String.valueOf(gu(iIntValue));
            case 108:
                return (T) String.valueOf(d(iIntValue));
            case 109:
                return (T) pq(iIntValue);
            case 110:
                return (T) jw(iIntValue);
            case 111:
                return (T) wt(iIntValue);
            case 112:
                return (T) Integer.valueOf(aa(iIntValue));
            case 113:
                return (T) iy(iIntValue);
            case 114:
                return (T) Boolean.valueOf(cr(iIntValue));
            case 115:
                return (T) Boolean.valueOf(j(iIntValue));
            case 116:
                return (T) Integer.valueOf(qo(iIntValue));
            case 117:
                return (T) Integer.valueOf(bh(iIntValue));
            case 118:
                return (T) String.valueOf(pj(iIntValue));
            case 119:
                return (T) String.valueOf(ey(iIntValue));
            case 120:
                return (T) Boolean.valueOf(qv(iIntValue));
            case 121:
                return (T) Boolean.valueOf(u(iIntValue));
            case 122:
                return (T) Boolean.valueOf(np(iIntValue));
            case MARCode.CODE_VIVOCHANNEL_CALLBACK /* 123 */:
                c(iIntValue, (String) map.get("md5"));
                return null;
            case 124:
                pr(iIntValue, ((Long) map.get("expectFileLength")).longValue());
                return null;
            case 125:
                x(iIntValue, ((Boolean) map.get("needWifi")).booleanValue());
                return null;
            case WorkQueueKt.MASK /* 127 */:
                hw(iIntValue, ((Long) map.get("extraValue")).longValue());
                return null;
            case 128:
                uc(iIntValue, (String) map.get("appName"));
                return null;
            case 129:
                x(iIntValue, (JSONObject) map.get("extraJson"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE /* 130 */:
                fw(iIntValue, (String) map.get("startToast"));
                return null;
            case 131:
                zo(iIntValue, (String) map.get("sdkMonitorScene"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA /* 132 */:
                hn(iIntValue, ((Long) map.get("id")).longValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START /* 133 */:
                uc(iIntValue, ((Boolean) map.get("isAd")).booleanValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS /* 134 */:
                hn(iIntValue, ((Integer) map.get("modelType")).intValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET /* 135 */:
                aj(iIntValue, (String) map.get("logExtra"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                vk(iIntValue, (String) map.get(BillingClientConstants.PACKAGE_NAME));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME /* 137 */:
                w(iIntValue, (String) map.get("appIcon"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE /* 139 */:
                pr(iIntValue, (List<String>) map.get("clickTrackUrl"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID /* 140 */:
                k(iIntValue, (String) map.get("downloadUrl"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID /* 141 */:
                hw(iIntValue, (List<String>) map.get("backupUrls"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO /* 142 */:
                m(iIntValue, (String) map.get("notificationJumpUrl"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE /* 143 */:
                g(iIntValue, (String) map.get("mimeType"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SPADE /* 144 */:
                pr(iIntValue, (Map<String, String>) map.get("headers"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES /* 145 */:
                fw(iIntValue, ((Boolean) map.get("isShowNotification")).booleanValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                ho(iIntValue, (String) map.get("filePath"));
                return null;
            case 147:
                nt(iIntValue, (String) map.get("fileName"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK /* 148 */:
                zo(iIntValue, ((Boolean) map.get("isNeedIndependentProcess")).booleanValue());
                return null;
            case 149:
                x(iIntValue, ((Integer) map.get("versionCode")).intValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS /* 150 */:
                yb(iIntValue, (String) map.get("versionName"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS /* 151 */:
                pr(iIntValue, new com.byazt.cxa.x.pr().pr((String) map.get("quickAppModelOpenUrl")).hw((String) map.get("quickAppModelExtraData")).pr());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF /* 152 */:
                aj(iIntValue, ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT /* 153 */:
                c(iIntValue, ((Integer) map.get("funnelType")).intValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET /* 154 */:
                pr(iIntValue, aj(map.get("downloadMarketInterceptor")));
                return null;
            case 157:
                if (map != null) {
                    Object obj2 = map.get(an.aB);
                    if (obj2 instanceof Service) {
                        com.byazt.lj.hn.pr((Context) obj2);
                    }
                }
                return null;
            case 158:
                if (map != null) {
                    try {
                        Object obj3 = map.get(an.aC);
                        map.get(an.aF);
                        if (obj3 instanceof Intent) {
                            if (TextUtils.equals(((Intent) obj3).getAction(), "com.csj.install")) {
                                pr((Intent) obj3);
                            } else {
                                ((Intent) obj3).setComponent(new ComponentName(com.byazt.lj.hn.of(), (Class<?>) DownloadHandlerService.class));
                                com.byazt.lj.hn.of().startService((Intent) obj3);
                            }
                        }
                    } catch (Exception e2) {
                        com.byazt.xk.hw.pr().pr("start_service", e2);
                    }
                    break;
                }
                return null;
            case 160:
                pr(map);
                return null;
            case 162:
                Object obj4 = map.get("listener");
                if (obj4 instanceof com.byazt.rkl.hw) {
                    ho.pr((com.byazt.rkl.hw) obj4);
                }
                return null;
        }
    }

    private void pr(Intent intent) {
        String str;
        String str2;
        intent.getAction();
        int intExtra = intent.getIntExtra("extra_click_download_ids", -1);
        intent.getIntExtra("extra_click_download_type", -1);
        intent.getStringExtra("extra_tag");
        String stringExtra = intent.getStringExtra("extra_value");
        String stringExtra2 = intent.getStringExtra("extra_log_extra");
        String stringExtra3 = intent.getStringExtra("extra_package_name");
        boolean zHw = ls.hw(stringExtra3);
        NotificationManager notificationManager = (NotificationManager) this.hw.getSystemService("notification");
        com.byazt.vo.pr prVar = new com.byazt.vo.pr();
        prVar.fw(stringExtra);
        prVar.x(stringExtra2);
        prVar.hn(stringExtra3);
        String str3 = TrackAction.SUCCESS;
        if (zHw) {
            com.byazt.uk.aj.pr(stringExtra3);
            str = "open";
            str2 = TrackAction.SUCCESS;
        } else {
            if (!com.byazt.mdu.x.pr(this.hw, intExtra)) {
                str3 = "failure";
            }
            str = "install";
            str2 = str3;
        }
        com.byazt.jx.c.pr("notification", prVar, str, "click_other", null, str2);
        notificationManager.cancel(qx(intExtra));
    }

    private void pr(int i, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return;
        }
        adDownloadControllerMr.setDownloadMarketInterceptor(downloadMarketInterceptor);
    }

    private static boolean pr(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            return false;
        }
        if (TextUtils.equals(iu.zo, UMModuleRegister.INNER)) {
            return hn();
        }
        return true;
    }

    private static boolean hn() {
        try {
            Field declaredField = com.byazt.cvl.x.class.getDeclaredField("hw");
            declaredField.setAccessible(true);
            return declaredField.get(null) instanceof Integer;
        } catch (Exception e) {
            try {
                Field declaredField2 = com.byazt.cvl.x.class.getDeclaredField("pr");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(null);
                if (obj instanceof Integer) {
                    int iIntValue = ((Integer) obj).intValue();
                    return iIntValue > 107000925 || (iIntValue <= 4061200 && iIntValue > 3000000);
                }
            } catch (Exception e2) {
            }
        }
    }

    public void pr(Bundle bundle) {
        ho.pr(this.hw);
        hw();
    }

    private DownloadStatusChangeListener hw(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        return null;
    }

    private com.byazt.bek.hw hn(Object obj) {
        if (obj instanceof com.byazt.bek.hw) {
            return (com.byazt.bek.hw) obj;
        }
        return null;
    }

    private DownloadModel x(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private DownloadEventConfig c(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private DownloadController uc(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private boolean fw(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    private com.byazt.rkl.pr zo(Object obj) {
        if (obj instanceof Function) {
            return new com.byazt.rkl.pr(obj);
        }
        return null;
    }

    private DownloadMarketInterceptor aj(Object obj) {
        if (obj instanceof DownloadMarketInterceptor) {
            return (DownloadMarketInterceptor) obj;
        }
        return null;
    }

    private OnItemClickListener vk(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        return null;
    }

    private IDownloadButtonClickListener w(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        return null;
    }

    private AdDownloadModel.Builder pr(long j, String str, boolean z, boolean z2, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.byazt.lm.nt.1
            @Override // com.byazt.fn.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return nt.this.pr(str10, str11);
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z3);
        fileUriProvider.setDeepLink(pr(j, str7, str8, str9));
        return fileUriProvider;
    }

    private void pr(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> functionHw = hw();
        if (functionHw == null) {
            com.byazt.ca.ho.hw("xgc_dl", "false");
            return;
        }
        try {
            int iIntValue = 0;
            Map map2 = (Map) functionHw.apply(com.byazt.xi.hw.pr().pr(161).pr(Map.class).pr(0, map).hw());
            if (map2 != null) {
                Notification notification = (Notification) map2.get("notification");
                NotificationManager notificationManager = (NotificationManager) a.getContext().getSystemService("notification");
                Object obj = map.get("install_download_id");
                if (obj instanceof Integer) {
                    iIntValue = ((Integer) obj).intValue();
                }
                notificationManager.notify(qx(iIntValue), notification);
            }
        } catch (Throwable th) {
            com.byazt.ca.ho.hw("xgc_dl", "e:" + th.getMessage());
            com.byazt.xk.hw.pr().pr("csj_install_notification", th);
        }
    }

    private int qx(int i) {
        return i + 1;
    }

    public Map<String, Object> pr(Object obj) {
        HashMap map = new HashMap();
        map.put("params", obj);
        Function<SparseArray<Object>, Object> functionHw = hw();
        if (functionHw == null) {
            return null;
        }
        try {
            return (Map) functionHw.apply(com.byazt.xi.hw.pr().pr(156).pr(Map.class).pr(0, map).hw());
        } catch (Throwable th) {
            com.byazt.xk.hw.pr().pr("csj_install_notification", th);
            return null;
        }
    }

    public Uri pr(String str, String str2) {
        HashMap map = new HashMap();
        map.put("custom_authority", str);
        map.put("custom_file_path", str2);
        Function<SparseArray<Object>, Object> functionHw = hw();
        if (functionHw == null) {
            return null;
        }
        try {
            return (Uri) functionHw.apply(com.byazt.xi.hw.pr().pr(155).pr(Uri.class).pr(0, map).hw());
        } catch (Throwable th) {
            com.byazt.xk.hw.pr().pr("csj_custom_uri", th);
            return null;
        }
    }

    private DeepLink pr(long j, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void pr(int i, String str, String str2, String str3) {
        AdDownloadModel.Builder builderNa = na(i);
        if (builderNa == null) {
            return;
        }
        this.x.put(Integer.valueOf(i), builderNa.setAppIcon(str).setAppName(str2).setPackageName(str3).build());
    }

    private void hw(int i, Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            AdDownloadModel.Builder builderPr = pr(((Long) map.get("id")).longValue(), (String) map.get("appIcon"), ((Boolean) map.get("isShowNotification")).booleanValue(), ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue(), (String) map.get("logExtra"), (JSONObject) map.get("extraJson"), (JSONObject) map.get("downloadSettings"), (String) map.get("filePath"), (String) map.get("downloadUrl"), (String) map.get("appName"), (String) map.get(BillingClientConstants.PACKAGE_NAME), ((Boolean) map.get("isNeedIndependentProcess")).booleanValue(), (String) map.get("openUrl"), (String) map.get("webTitle"), (String) map.get("webUrl"));
            this.hn.put(Integer.valueOf(i), builderPr);
            this.x.put(Integer.valueOf(i), builderPr.build());
        }
    }

    private void pr(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i2).setDownloadMode(i3).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.c.put(Integer.valueOf(i), isAddToDownloadManage);
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            isAddToDownloadManage.setEnableAM(z3);
        }
        this.uc.put(Integer.valueOf(i), isAddToDownloadManage.build());
    }

    private void hn(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int iIntValue = ((Integer) map.get("linkMode")).intValue();
        int iIntValue2 = ((Integer) map.get("downloadMode")).intValue();
        boolean zBooleanValue = ((Boolean) map.get("isEnableBackDialog")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isAddToDownloadManage")).booleanValue();
        map.get("extraOperation");
        boolean zBooleanValue3 = ((Boolean) map.get("shouldUseNewWebView")).booleanValue();
        int iIntValue3 = ((Integer) map.get("interceptFlag")).intValue();
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        Object obj = map.get("extraObject");
        boolean zBooleanValue4 = ((Boolean) map.get("enableShowComplianceDialog")).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get("enableNewActivity")).booleanValue();
        boolean zBooleanValue7 = ((Boolean) map.get("isEnableAH")).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get("isEnableAM")).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(iIntValue).setDownloadMode(iIntValue2).setIsEnableBackDialog(zBooleanValue).setIsAddToDownloadManage(zBooleanValue2).setShouldUseNewWebView(zBooleanValue3).setInterceptFlag(iIntValue3).setExtraJson(jSONObject).setExtraObject(obj).setEnableShowComplianceDialog(zBooleanValue4).setIsAutoDownloadOnCardShow(zBooleanValue5).setEnableNewActivity(zBooleanValue6).setEnableAH(zBooleanValue7).setEnableAM(zBooleanValue8).setEnableOppoAutoDownload(((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue());
        this.c.put(Integer.valueOf(i), enableOppoAutoDownload);
        this.uc.put(Integer.valueOf(i), enableOppoAutoDownload.build());
    }

    private void uc(int i, int i2) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return;
        }
        adDownloadControllerMr.setDownloadMode(i2);
    }

    private int fe(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return 0;
        }
        return adDownloadControllerMr.getDownloadMode();
    }

    private void x(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickStartLabel");
        String str4 = (String) map.get("clickContinueLabel");
        String str5 = (String) map.get("clickPauseLabel");
        String str6 = (String) map.get("storageDenyLabel");
        String str7 = (String) map.get("clickInstallLabel");
        boolean zBooleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(zBooleanValue).setIsEnableV3Event(zBooleanValue2);
        this.fw.put(Integer.valueOf(i), isEnableV3Event);
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.zo.put(Integer.valueOf(i), isEnableV3Event.build());
    }

    private void c(int i, Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            String str = (String) map.get("clickButtonTag");
            String str2 = (String) map.get("clickItemTag");
            String str3 = (String) map.get("clickLabel");
            int iIntValue = ((Integer) map.get("downloadScene")).intValue();
            String str4 = (String) map.get("refer");
            JSONObject jSONObject = (JSONObject) map.get("extraJson");
            JSONObject jSONObject2 = (JSONObject) map.get("paramsJson");
            String str5 = (String) map.get("clickStartLabel");
            String str6 = (String) map.get("clickContinueLabel");
            String str7 = (String) map.get("clickPauseLabel");
            String str8 = (String) map.get("storageDenyLabel");
            String str9 = (String) map.get("clickInstallLabel");
            boolean zBooleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
            boolean zBooleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
            JSONObject jSONObject3 = (JSONObject) map.get("extraEventObject");
            AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(zBooleanValue).setDownloadScene(iIntValue).setIsEnableV3Event(zBooleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
            this.fw.put(Integer.valueOf(i), paramsJson);
            if (jSONObject3 != null) {
                paramsJson.setExtraEventObject(jSONObject3);
            }
            this.zo.put(Integer.valueOf(i), paramsJson.build());
        }
    }

    public int pr(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return 0;
        }
        return adDownloadControllerMr.getLinkMode();
    }

    public boolean hw(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.isEnableBackDialog();
    }

    public boolean hn(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.isAddToDownloadManage();
    }

    public Object x(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return null;
        }
        return adDownloadControllerMr.getExtraClickOperation();
    }

    public boolean c(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.isEnableMultipleDownload();
    }

    public int uc(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return 1;
        }
        return adDownloadControllerMr.getDowloadChunkCount();
    }

    public boolean fw(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.shouldUseNewWebView();
    }

    public int zo(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return 0;
        }
        return adDownloadControllerMr.getInterceptFlag();
    }

    public JSONObject aj(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return null;
        }
        return adDownloadControllerMr.getExtraJson();
    }

    public Object vk(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return null;
        }
        return adDownloadControllerMr.getExtraObject();
    }

    public void pr(int i, int i2) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return;
        }
        adDownloadControllerMr.setLinkMode(i2);
    }

    public boolean w(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.enableShowComplianceDialog();
    }

    public void pr(int i, boolean z) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return;
        }
        adDownloadControllerMr.setEnableShowComplianceDialog(z);
    }

    public boolean k(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.isAutoDownloadOnCardShow();
    }

    public boolean m(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.enableNewActivity();
    }

    public void hw(int i, boolean z) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return;
        }
        adDownloadControllerMr.setIsAutoDownloadOnCardShow(z);
    }

    public void hn(int i, boolean z) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (this.uc == null) {
            return;
        }
        adDownloadControllerMr.setEnableNewActivity(z);
    }

    public boolean g(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.enableAH();
    }

    public boolean ho(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.enableAM();
    }

    public void pr(int i, Object obj) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return;
        }
        adDownloadControllerMr.setExtraObject(obj);
    }

    public void pr(int i, JSONObject jSONObject) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return;
        }
        adDownloadControllerMr.setExtraJson(jSONObject);
    }

    public boolean nt(int i) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return false;
        }
        return adDownloadControllerMr.enableOppoAutoDownload();
    }

    private void pr(int i, boolean z, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController adDownloadControllerMr = mr(i);
        if (adDownloadControllerMr == null) {
            return;
        }
        try {
            adDownloadControllerMr.setDownloadMarketInterceptor(downloadMarketInterceptor);
            adDownloadControllerMr.setEnableOppoAutoDownload(z);
        } catch (Throwable th) {
        }
    }

    public String yb(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return "";
        }
        return adDownloadEventConfigAg.getRefer();
    }

    public String lb(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return "";
        }
        return adDownloadEventConfigAg.getClickButtonTag();
    }

    public String qa(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return "";
        }
        return adDownloadEventConfigAg.getClickItemTag();
    }

    public String a(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return "";
        }
        return adDownloadEventConfigAg.getClickLabel();
    }

    public String cz(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return "";
        }
        return adDownloadEventConfigAg.getClickStartLabel();
    }

    public String ny(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return "";
        }
        return adDownloadEventConfigAg.getClickPauseLabel();
    }

    public String fo(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return "";
        }
        return adDownloadEventConfigAg.getClickPauseLabel();
    }

    public String rc(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return "";
        }
        return adDownloadEventConfigAg.getClickInstallLabel();
    }

    public String z(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return "";
        }
        return adDownloadEventConfigAg.getStorageDenyLabel();
    }

    public Object b(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return null;
        }
        return adDownloadEventConfigAg.getExtraEventObject();
    }

    public int iu(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return 0;
        }
        return adDownloadEventConfigAg.getDownloadScene();
    }

    public boolean ve(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return true;
        }
        return adDownloadEventConfigAg.isEnableClickEvent();
    }

    public boolean gz(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return false;
        }
        return adDownloadEventConfigAg.isEnableV3Event();
    }

    public JSONObject nl(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return null;
        }
        return adDownloadEventConfigAg.getExtraJson();
    }

    public JSONObject y(int i) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return null;
        }
        return adDownloadEventConfigAg.getParamsJson();
    }

    public void hw(int i, Object obj) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return;
        }
        adDownloadEventConfigAg.setExtraEventObject(obj);
    }

    public void pr(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return;
        }
        adDownloadEventConfigAg.setClickButtonTag(str);
    }

    public void hw(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return;
        }
        adDownloadEventConfigAg.setExtraJson(jSONObject);
    }

    public void hn(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return;
        }
        adDownloadEventConfigAg.setParamsJson(jSONObject);
    }

    public void hw(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return;
        }
        adDownloadEventConfigAg.setClickItemTag(str);
    }

    public void hw(int i, int i2) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return;
        }
        adDownloadEventConfigAg.setDownloadScene(i2);
    }

    public void hn(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return;
        }
        adDownloadEventConfigAg.setRefer(str);
    }

    public void x(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigAg = ag(i);
        if (adDownloadEventConfigAg == null) {
            return;
        }
        adDownloadEventConfigAg.setQuickAppEventTag(str);
    }

    private void uc(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long jLongValue = ((Long) map.get("expectFileLength")).longValue();
        String str = (String) map.get("md5");
        long jLongValue2 = ((Long) map.get("extraValue")).longValue();
        boolean zBooleanValue = ((Boolean) map.get("isAd")).booleanValue();
        int iIntValue = ((Integer) map.get("modelType")).intValue();
        List<String> list = (List) map.get("clickTrackUrl");
        List<String> list2 = (List) map.get("backupUrls");
        String str2 = (String) map.get("notificationJumpUrl");
        String str3 = (String) map.get("mimeType");
        Map<String, String> map2 = (Map) map.get("headers");
        boolean zBooleanValue2 = ((Boolean) map.get("isShowToast")).booleanValue();
        boolean zBooleanValue3 = ((Boolean) map.get("needWifi")).booleanValue();
        String str4 = (String) map.get("fileName");
        int iIntValue2 = ((Integer) map.get("versionCode")).intValue();
        String str5 = (String) map.get("versionName");
        String str6 = (String) map.get("quickAppModelOpenUrl");
        com.byazt.cxa.x xVarPr = new com.byazt.cxa.x.pr().pr(str6).hw((String) map.get("quickAppModelExtraData")).pr();
        int iIntValue3 = ((Integer) map.get("executorGroup")).intValue();
        String str7 = (String) map.get("startToast");
        String str8 = (String) map.get("sdkMonitorScene");
        boolean zBooleanValue4 = ((Boolean) map.get("autoInstall")).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get("distinctDir")).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get("enablePause")).booleanValue();
        long jLongValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get("appIcon");
        boolean zBooleanValue7 = ((Boolean) map.get("isShowNotification")).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue();
        String str10 = (String) map.get("logExtra");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("downloadSettings");
        String str11 = (String) map.get("filePath");
        String str12 = (String) map.get("downloadUrl");
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get(BillingClientConstants.PACKAGE_NAME);
        boolean zBooleanValue9 = ((Boolean) map.get("isNeedIndependentProcess")).booleanValue();
        String str15 = (String) map.get("openUrl");
        String str16 = (String) map.get("webTitle");
        String str17 = (String) map.get("webUrl");
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(jLongValue).setMd5(str).setId(jLongValue3).setExtraValue(jLongValue2).setIsAd(zBooleanValue).setModelType(iIntValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(zBooleanValue2).setIsShowNotification(zBooleanValue7).setNeedWifi(zBooleanValue3).setFileName(str4).setVersionCode(iIntValue2).setVersionName(str5).setQuickAppModel(xVarPr).setAutoInstallWithoutNotification(zBooleanValue8).setExecutorGroup(iIntValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(zBooleanValue4).setDistinctDir(zBooleanValue5).setEnablePause(zBooleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.byazt.lm.nt.2
            @Override // com.byazt.fn.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str19) {
                return nt.this.pr(str18, str19);
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            fileUriProvider.setFilePath(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            fileUriProvider.setDownloadUrl(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            fileUriProvider.setAppName(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            fileUriProvider.setPackageName(str14);
        }
        fileUriProvider.setNeedIndependentProcess(zBooleanValue9);
        fileUriProvider.setDeepLink(pr(jLongValue3, str15, str16, str17));
        this.hn.put(Integer.valueOf(i), fileUriProvider);
        this.x.put(Integer.valueOf(i), fileUriProvider.build());
    }

    public long ww(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return 0L;
        }
        return adDownloadModelRk.getId();
    }

    public String n(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getMd5();
    }

    public long e(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return 0L;
        }
        return adDownloadModelRk.getExpectFileLength();
    }

    public long s(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return 0L;
        }
        return adDownloadModelRk.getExtraValue();
    }

    public String ls(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getDownloadUrl();
    }

    public List<String> er(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.getBackupUrls();
    }

    public String v(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getNotificationJumpUrl();
    }

    public String qi(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getName();
    }

    public String qn(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getMimeType();
    }

    public Map<String, String> of(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.getHeaders();
    }

    public boolean ii(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return true;
        }
        return adDownloadModelRk.isShowToast();
    }

    public boolean i(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return true;
        }
        return adDownloadModelRk.isShowNotification();
    }

    public boolean r(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return false;
        }
        return adDownloadModelRk.isNeedWifi();
    }

    public boolean hs(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return false;
        }
        return adDownloadModelRk.isInExternalPublicDir();
    }

    public boolean nw(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return false;
        }
        return adDownloadModelRk.isInExternalPublicDir();
    }

    public String ie(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getFilePath();
    }

    public String o(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getFileName();
    }

    public void f(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.forceWifi();
    }

    public JSONObject bm(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.getDownloadSettings();
    }

    public void jn(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.forceHideToast();
    }

    public void l(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.forceHideNotification();
    }

    public boolean lv(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return false;
        }
        return adDownloadModelRk.needIndependentProcess();
    }

    public int od(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return 0;
        }
        return adDownloadModelRk.getVersionCode();
    }

    public String vj(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getVersionName();
    }

    public boolean mw(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return true;
        }
        return adDownloadModelRk.isAd();
    }

    public String sv(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getLogExtra();
    }

    public String gu(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getPackageName();
    }

    public String d(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getAppIcon();
    }

    public DeepLink pq(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.getDeepLink();
    }

    public List<String> jw(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.getClickTrackUrl();
    }

    public JSONObject wt(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.getExtra();
    }

    public int aa(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return 0;
        }
        return adDownloadModelRk.getModelType();
    }

    public com.byazt.cxa.x iy(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.getQuickAppModel();
    }

    public boolean cr(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return false;
        }
        return adDownloadModelRk.autoInstallWithoutNotification();
    }

    public boolean j(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return com.byazt.snv.hw.pr(com.byazt.ew.pr.pr(bm(i)), qn(i));
        }
        return adDownloadModelRk.shouldDownloadWithPatchApply();
    }

    public int qo(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return 2;
        }
        return adDownloadModelRk.getExecutorGroup();
    }

    public int bh(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return 1;
        }
        return adDownloadModelRk.getFunnelType();
    }

    public String pj(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getStartToast();
    }

    public String ey(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return "";
        }
        return adDownloadModelRk.getStartToast();
    }

    public boolean qv(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return true;
        }
        return adDownloadModelRk.isAutoInstall();
    }

    public boolean u(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return false;
        }
        return adDownloadModelRk.distinctDir();
    }

    public boolean np(int i) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return true;
        }
        return adDownloadModelRk.enablePause();
    }

    public void c(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.setMd5(str);
    }

    public void pr(int i, long j) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.setExpectFileLength(j);
    }

    public void x(int i, boolean z) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.setNeedWifi(z);
    }

    public void c(int i, boolean z) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.setIsShowToast(z);
    }

    public void hw(int i, long j) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.setExtraValue(j);
    }

    public void uc(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.setAppName(str);
    }

    public void x(int i, JSONObject jSONObject) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.setExtra(jSONObject);
    }

    public void fw(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.setStartToast(str);
    }

    public void zo(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return;
        }
        adDownloadModelRk.setSdkMonitorScene(str);
    }

    public AdDownloadModel hn(int i, long j) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setId(j);
    }

    public AdDownloadModel uc(int i, boolean z) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setIsAd(z);
    }

    public AdDownloadModel hn(int i, int i2) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setModelType(i2);
    }

    public AdDownloadModel aj(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setLogExtra(str);
    }

    public AdDownloadModel vk(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setPackageName(str);
    }

    public AdDownloadModel w(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setAppIcon(str);
    }

    public AdDownloadModel pr(int i, List<String> list) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setClickTrackUrl(list);
    }

    public AdDownloadModel k(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setDownloadUrl(str);
    }

    public AdDownloadModel hw(int i, List<String> list) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setBackupUrls(list);
    }

    public AdDownloadModel m(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setNotificationJumpUrl(str);
    }

    public AdDownloadModel g(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setMimeType(str);
    }

    public AdDownloadModel pr(int i, Map<String, String> map) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setHeaders(map);
    }

    public AdDownloadModel fw(int i, boolean z) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setIsShowNotification(z);
    }

    public AdDownloadModel ho(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setFilePath(str);
    }

    public AdDownloadModel nt(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setFileName(str);
    }

    public AdDownloadModel zo(int i, boolean z) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setNeedIndependentProcess(z);
    }

    public AdDownloadModel x(int i, int i2) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setVersionCode(i2);
    }

    public AdDownloadModel yb(int i, String str) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setVersionName(str);
    }

    public AdDownloadModel pr(int i, com.byazt.cxa.x xVar) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setQuickAppModel(xVar);
    }

    public AdDownloadModel aj(int i, boolean z) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setAutoInstallWithoutNotification(z);
    }

    public AdDownloadModel c(int i, int i2) {
        AdDownloadModel adDownloadModelRk = rk(i);
        if (adDownloadModelRk == null) {
            return null;
        }
        return adDownloadModelRk.setFunnelType(i2);
    }

    @Override // com.byazt.ofr.x
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) pr().sparseArray();
        }
        return (T) call(i, pluginValueSet, cls);
    }

    public PluginValueSet pr() {
        return com.byazt.ij.pr.pr().pr(0, ho.pr).pr(1, Boolean.valueOf(ho.hw)).pr(10000, 3).hw();
    }

    public <T> T call(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        Map<String, Object> map;
        if (i == 20) {
            pr((Bundle) pluginValueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (pluginValueSet != null && pluginValueSet.objectValue(0, Map.class) != null) {
            map = (Map) pluginValueSet.objectValue(0, Map.class);
        } else {
            map = new HashMap<>();
        }
        return (T) pr(cls, i, map);
    }
}
