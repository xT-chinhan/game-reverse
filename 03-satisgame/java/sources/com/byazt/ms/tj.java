package com.byazt.ms;

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
import com.byazt.e.DownloadHandlerService;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.ky.DownloadMarketInterceptor;
import com.byazt.ky.IDownloadButtonClickListener;
import com.byazt.ky.OnItemClickListener;
import com.byazt.os.DeepLink;
import com.byazt.tk.k;
import com.byazt.y.AdDownloadController;
import com.byazt.y.AdDownloadEventConfig;
import com.byazt.y.AdDownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
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
@com.byazt.cp.n(n = {0, 1, 238, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj extends com.byazt.gf.q {
    public static volatile tj n;
    public final Context qg;
    public Function<SparseArray<Object>, Object> rv;
    public Map<Integer, AdDownloadModel.Builder> s = new ConcurrentHashMap();
    public Map<Integer, AdDownloadModel> q = new ConcurrentHashMap();
    public Map<Integer, AdDownloadController.Builder> l = new ConcurrentHashMap();
    public Map<Integer, AdDownloadController> w = new ConcurrentHashMap();
    public Map<Integer, AdDownloadEventConfig.Builder> x = new ConcurrentHashMap();
    public Map<Integer, AdDownloadEventConfig> fs = new ConcurrentHashMap();

    private int ei(int i) {
        return i + 1;
    }

    private Function<SparseArray<Object>, Object> qg() {
        Function<SparseArray<Object>, Object> function = this.rv;
        if (function != null) {
            return function;
        }
        Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(3);
        this.rv = functionW;
        if (functionW == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(com.byazt.ug.n.n, com.byazt.vyf.s.cy().fi());
        this.rv.apply(com.byazt.of.qg.n().n(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FRAMES_DROP).n(Map.class).n(0, map).qg());
        return this.rv;
    }

    private void wv(int i) {
        sq(i);
        this.s.remove(Integer.valueOf(i));
        this.q.remove(Integer.valueOf(i));
        this.l.remove(Integer.valueOf(i));
        this.w.remove(Integer.valueOf(i));
        this.x.remove(Integer.valueOf(i));
        this.fs.remove(Integer.valueOf(i));
    }

    private AdDownloadModel.Builder xi(int i) {
        return this.s.get(Integer.valueOf(i));
    }

    private AdDownloadModel np(int i) {
        return this.q.get(Integer.valueOf(i));
    }

    private AdDownloadController r(int i) {
        return this.w.get(Integer.valueOf(i));
    }

    private AdDownloadEventConfig mz(int i) {
        return this.fs.get(Integer.valueOf(i));
    }

    private tj(Context context) {
        this.qg = context;
    }

    public static tj n(Context context) {
        if (n == null) {
            synchronized (tj.class) {
                if (n == null) {
                    n = new tj(context);
                }
            }
        }
        return n;
    }

    public <T> T n(Class<T> cls, int i, Map<String, Object> map) {
        Object obj = map.get("hashCode");
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        DownloadModel downloadModelNp = np(iIntValue);
        switch (i) {
            case 0:
                return (T) Boolean.valueOf(rv.n(getActivity(map.get("activity")), fs(map.get("exitInstallListener"))));
            case 1:
                return (T) rv.qg().w();
            case 2:
                try {
                    return (T) Boolean.valueOf(rv.n((String) map.get("tagIntercept"), (String) map.get("label"), new JSONObject((String) map.get("meta")), new HashMap()));
                } catch (JSONException unused) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                rv.n(((Integer) map.get("hid")).intValue());
                return null;
            case 4:
                rv.qg().n(downloadModelNp == null ? (String) map.get("downloadUrl") : downloadModelNp.getDownloadUrl(), iIntValue);
                wv(iIntValue);
                return null;
            case 5:
                if (downloadModelNp == null) {
                    downloadModelNp = q(map.get("downloadModel"));
                }
                DownloadStatusChangeListener downloadStatusChangeListenerQg = qg(map.get("downloadStatusChangeListener"));
                DownloadController downloadControllerR = r(iIntValue);
                if (downloadControllerR == null) {
                    downloadControllerR = w(map.get("downloadController"));
                }
                com.byazt.hj.qg qgVarS = s(map.get("marketStatusChangeListener"));
                if (qgVarS != null && (downloadControllerR instanceof AdDownloadController)) {
                    ((AdDownloadController) downloadControllerR).setMarketStatusChangeListener(qgVarS);
                }
                rv.qg().n(this.qg, iIntValue, downloadStatusChangeListenerQg, downloadModelNp);
                return null;
            case 6:
                return (T) Boolean.valueOf(rv.n(this.qg, downloadModelNp == null ? (String) map.get("downloadUrl") : downloadModelNp.getDownloadUrl()));
            case 7:
                rv.s();
                return null;
            case 8:
                rv.qg().n(downloadModelNp == null ? (String) map.get("downloadUrl") : downloadModelNp.getDownloadUrl(), ((Boolean) map.get("force")).booleanValue());
                return null;
            case 9:
                rv.n(((Integer) map.get("hid")).intValue(), (n.InterfaceC0249n) map.get("onEventLogHandler"));
                return null;
            case 10:
                rv.n((String) map.get("downloadPath"));
                return null;
            case 11:
            case 20:
            case 21:
            case 22:
            case 43:
            case 77:
            case 126:
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME /* 138 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME /* 155 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME /* 156 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_FRAMES_DROP /* 159 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_DECODE_SECOND_VIDEO_FRAME_TIME /* 161 */:
            default:
                return null;
            case 12:
                Uri uri = (Uri) map.get(ContentProviderManager.PROVIDER_URI);
                if (downloadModelNp == null) {
                    downloadModelNp = q(map.get("downloadModel"));
                }
                AdDownloadEventConfig adDownloadEventConfigMz = mz(iIntValue);
                DownloadEventConfig downloadEventConfigL = adDownloadEventConfigMz == null ? l(map.get("downloadEventConfig")) : adDownloadEventConfigMz;
                DownloadController downloadControllerR2 = r(iIntValue);
                if (downloadControllerR2 == null) {
                    downloadControllerR2 = w(map.get("downloadController"));
                }
                Activity activity = getActivity(map.get("activity"));
                Context context = ((downloadControllerR2 instanceof AdDownloadController) && activity != null && x(map.get("open_market_in_app"))) ? activity : this.qg;
                IDownloadButtonClickListener iDownloadButtonClickListenerCp = cp(map.get("downloadButtonClickListener"));
                if (n(iDownloadButtonClickListenerCp)) {
                    return (T) Boolean.valueOf(rv.n(context, uri, downloadModelNp, downloadEventConfigL, downloadControllerR2, iDownloadButtonClickListenerCp));
                }
                return (T) Boolean.valueOf(rv.n(context, uri, downloadModelNp, downloadEventConfigL, downloadControllerR2));
            case 13:
                boolean zBooleanValue = ((Boolean) map.get("isDisableDialog")).booleanValue();
                String str = (String) map.get("userAgent");
                if (downloadModelNp == null) {
                    downloadModelNp = q(map.get("downloadModel"));
                }
                DownloadModel downloadModel = downloadModelNp;
                DownloadEventConfig downloadEventConfigMz = mz(iIntValue);
                if (downloadEventConfigMz == null) {
                    downloadEventConfigMz = l(map.get("downloadEventConfig"));
                }
                DownloadController downloadControllerR3 = r(iIntValue);
                if (downloadControllerR3 == null) {
                    downloadControllerR3 = w(map.get("downloadController"));
                }
                DownloadController downloadController = downloadControllerR3;
                DownloadStatusChangeListener downloadStatusChangeListenerQg2 = qg(map.get("downloadStatusChangeListener"));
                IDownloadButtonClickListener iDownloadButtonClickListenerCp2 = cp(map.get("downloadButtonClickListener"));
                if (n(iDownloadButtonClickListenerCp2)) {
                    rv.qg().l().n(this.qg, str, zBooleanValue, downloadModel, downloadEventConfigMz, downloadController, downloadStatusChangeListenerQg2, iIntValue, iDownloadButtonClickListenerCp2);
                    return null;
                }
                rv.qg().l().n(this.qg, str, zBooleanValue, downloadModel, downloadEventConfigMz, downloadController, downloadStatusChangeListenerQg2, iIntValue);
                return null;
            case 14:
                return (T) Boolean.valueOf(rv.qg().l().n(this.qg, downloadModelNp == null ? ((Long) map.get("id")).longValue() : downloadModelNp.getId(), downloadModelNp == null ? (String) map.get("logExtra") : downloadModelNp.getLogExtra(), (DownloadStatusChangeListener) null, iIntValue));
            case 15:
                return (T) Boolean.valueOf(rv.n((Uri) map.get(ContentProviderManager.PROVIDER_URI)));
            case 16:
                String downloadUrl = downloadModelNp == null ? (String) map.get("downloadUrl") : downloadModelNp.getDownloadUrl();
                long jLongValue = downloadModelNp == null ? ((Long) map.get("id")).longValue() : downloadModelNp.getId();
                int iIntValue2 = ((Integer) map.get("action_type_button")).intValue();
                DownloadEventConfig downloadEventConfigMz2 = mz(iIntValue);
                if (downloadEventConfigMz2 == null) {
                    downloadEventConfigMz2 = l(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig = downloadEventConfigMz2;
                DownloadController downloadControllerR4 = r(iIntValue);
                if (downloadControllerR4 == null) {
                    downloadControllerR4 = w(map.get("downloadController"));
                }
                Activity activity2 = getActivity(map.get("activity"));
                boolean zX = x(map.get("open_market_in_app"));
                if ((downloadControllerR4 instanceof AdDownloadController) && activity2 != null && zX) {
                    ((AdDownloadController) downloadControllerR4).setWeakActivity(activity2);
                }
                rv.qg().n(downloadUrl, jLongValue, iIntValue2, downloadEventConfig, downloadControllerR4);
                return null;
            case 17:
                String downloadUrl2 = downloadModelNp == null ? (String) map.get("downloadUrl") : downloadModelNp.getDownloadUrl();
                long jLongValue2 = ((Long) map.get("id")).longValue();
                int iIntValue3 = ((Integer) map.get("action_type_button")).intValue();
                DownloadEventConfig downloadEventConfigMz3 = mz(iIntValue);
                if (downloadEventConfigMz3 == null) {
                    downloadEventConfigMz3 = l(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig2 = downloadEventConfigMz3;
                DownloadController downloadControllerR5 = r(iIntValue);
                if (downloadControllerR5 == null) {
                    downloadControllerR5 = w(map.get("downloadController"));
                }
                OnItemClickListener onItemClickListenerTj = tj(map.get("itemClickListener"));
                IDownloadButtonClickListener iDownloadButtonClickListenerCp3 = cp(map.get("downloadButtonClickListener"));
                Activity activity3 = getActivity(map.get("activity"));
                boolean zX2 = x(map.get("open_market_in_app"));
                if ((downloadControllerR5 instanceof AdDownloadController) && activity3 != null && zX2) {
                    ((AdDownloadController) downloadControllerR5).setWeakActivity(activity3);
                }
                rv.qg().n(downloadUrl2, jLongValue2, iIntValue3, downloadEventConfig2, downloadControllerR5, onItemClickListenerTj, iDownloadButtonClickListenerCp3);
                return null;
            case 18:
                T t = (T) Boolean.valueOf(rv.qg().l().n(downloadModelNp == null ? ((Long) map.get("id")).longValue() : downloadModelNp.getId(), iIntValue));
                wv(iIntValue);
                return t;
            case 19:
                return (T) Boolean.valueOf(rv.qg().l().n(downloadModelNp == null ? ((Long) map.get("id")).longValue() : downloadModelNp.getId()));
            case 23:
                if (((Boolean) map.get("mateIsEmpty")).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.s.put(Integer.valueOf(iIntValue), builder);
                    this.q.put(Integer.valueOf(iIntValue), builder.build());
                    return null;
                }
                qg(iIntValue, map);
                return null;
            case 24:
                n(iIntValue, (String) map.get("appIcon"), (String) map.get("appName"), (String) map.get(BillingClientConstants.PACKAGE_NAME));
                return null;
            case 25:
                n(iIntValue, ((Integer) map.get("autoOpen")).intValue(), ((Integer) map.get("downloadMode")).intValue(), ((Boolean) map.get("isHaveDownloadSdkConfig")).booleanValue(), ((Boolean) map.get("isEnableAH")).booleanValue(), ((Boolean) map.get("isEnableAM")).booleanValue());
                return null;
            case 26:
                w(iIntValue, ((Integer) map.get("downloadMode")).intValue());
                return null;
            case 27:
                return (T) Integer.valueOf(dm(iIntValue));
            case 28:
                n(iIntValue, ((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue(), rv(map.get("downloadMarketInterceptor")));
                return null;
            case 29:
                q(iIntValue, map);
                return null;
            case 30:
                qg(iIntValue, ((Integer) map.get("downloadScene")).intValue());
                return null;
            case 31:
                l(iIntValue, ((Boolean) map.get("isShowToast")).booleanValue());
                return null;
            case 32:
                s(iIntValue, map);
                return null;
            case 33:
                return (T) Integer.valueOf(n(iIntValue));
            case 34:
                return (T) Boolean.valueOf(qg(iIntValue));
            case 35:
                return (T) Boolean.valueOf(s(iIntValue));
            case 36:
                return (T) q(iIntValue);
            case 37:
                return (T) Boolean.valueOf(l(iIntValue));
            case 38:
                return (T) Integer.valueOf(w(iIntValue));
            case 39:
                return (T) Boolean.valueOf(x(iIntValue));
            case 40:
                return (T) Integer.valueOf(fs(iIntValue));
            case 41:
                return (T) rv(iIntValue);
            case 42:
                return (T) tj(iIntValue);
            case 44:
                n(iIntValue, ((Integer) map.get("linkMode")).intValue());
                return null;
            case 45:
                return (T) Boolean.valueOf(cp(iIntValue));
            case 46:
                n(iIntValue, ((Boolean) map.get("enableShowComplianceDialog")).booleanValue());
                return null;
            case 47:
                return (T) Boolean.valueOf(d(iIntValue));
            case 48:
                return (T) Boolean.valueOf(oa(iIntValue));
            case 49:
                qg(iIntValue, ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue());
                return null;
            case 50:
                s(iIntValue, ((Boolean) map.get("enableNewActivity")).booleanValue());
                return null;
            case 51:
                return (T) Boolean.valueOf(sz(iIntValue));
            case 52:
                return (T) Boolean.valueOf(k(iIntValue));
            case 53:
                n(iIntValue, map.get("extraObject"));
                return null;
            case 54:
                n(iIntValue, (JSONObject) map.get("extraJson"));
                return null;
            case 55:
                return (T) Boolean.valueOf(cy(iIntValue));
            case 56:
                l(iIntValue, map);
                return null;
            case 57:
                return (T) String.valueOf(hd(iIntValue));
            case 58:
                return (T) String.valueOf(cd(iIntValue));
            case 59:
                return (T) String.valueOf(um(iIntValue));
            case 60:
                return (T) String.valueOf(a(iIntValue));
            case 61:
                return (T) String.valueOf(py(iIntValue));
            case 62:
                return (T) String.valueOf(ou(iIntValue));
            case 63:
                return (T) String.valueOf(wm(iIntValue));
            case 64:
                return (T) String.valueOf(m(iIntValue));
            case 65:
                return (T) String.valueOf(hu(iIntValue));
            case 66:
                return (T) h(iIntValue);
            case 67:
                return (T) Integer.valueOf(t(iIntValue));
            case 68:
                return (T) Boolean.valueOf(ur(iIntValue));
            case 69:
                return (T) Boolean.valueOf(bb(iIntValue));
            case 70:
                return (T) ln(iIntValue);
            case 71:
                return (T) lh(iIntValue);
            case 72:
                qg(iIntValue, map.get("extraEventObject"));
                return null;
            case 73:
                n(iIntValue, (String) map.get("clickButtonTag"));
                return null;
            case 74:
                qg(iIntValue, (JSONObject) map.get("eventConfigExtraJson"));
                return null;
            case 75:
                s(iIntValue, (JSONObject) map.get("paramsJson"));
                return null;
            case 76:
                qg(iIntValue, (String) map.get("clickItemTag"));
                return null;
            case 78:
                s(iIntValue, (String) map.get("refer"));
                return null;
            case 79:
                q(iIntValue, (String) map.get("quickAppEventTag"));
                return null;
            case 80:
                w(iIntValue, map);
                return null;
            case 81:
                return (T) Long.valueOf(v(iIntValue));
            case 82:
                return (T) String.valueOf(j(iIntValue));
            case 83:
                return (T) Long.valueOf(an(iIntValue));
            case 84:
                return (T) Long.valueOf(ae(iIntValue));
            case 85:
                return (T) String.valueOf(f(iIntValue));
            case 86:
                return (T) fi(iIntValue);
            case 87:
                return (T) String.valueOf(df(iIntValue));
            case 88:
                return (T) String.valueOf(oj(iIntValue));
            case 89:
                return (T) String.valueOf(dg(iIntValue));
            case 90:
                return (T) u(iIntValue);
            case 91:
                return (T) Boolean.valueOf(pk(iIntValue));
            case 92:
                return (T) Boolean.valueOf(wo(iIntValue));
            case 93:
                return (T) Boolean.valueOf(sh(iIntValue));
            case 94:
                return (T) Boolean.valueOf(y(iIntValue));
            case 95:
                return (T) Boolean.valueOf(rf(iIntValue));
            case 96:
                return (T) String.valueOf(dh(iIntValue));
            case 97:
                return (T) String.valueOf(b(iIntValue));
            case 98:
                ri(iIntValue);
                return null;
            case 99:
                return (T) nf(iIntValue);
            case 100:
                pe(iIntValue);
                return null;
            case 101:
                e(iIntValue);
                return null;
            case 102:
                return (T) Boolean.valueOf(yw(iIntValue));
            case 103:
                return (T) Integer.valueOf(cx(iIntValue));
            case 104:
                return (T) String.valueOf(lq(iIntValue));
            case 105:
                return (T) Boolean.valueOf(ic(iIntValue));
            case 106:
                return (T) String.valueOf(ci(iIntValue));
            case 107:
                return (T) String.valueOf(hf(iIntValue));
            case 108:
                return (T) String.valueOf(kc(iIntValue));
            case 109:
                return (T) z(iIntValue);
            case 110:
                return (T) dn(iIntValue);
            case 111:
                return (T) he(iIntValue);
            case 112:
                return (T) Integer.valueOf(el(iIntValue));
            case 113:
                return (T) vb(iIntValue);
            case 114:
                return (T) Boolean.valueOf(fl(iIntValue));
            case 115:
                return (T) Boolean.valueOf(i(iIntValue));
            case 116:
                return (T) Integer.valueOf(dw(iIntValue));
            case 117:
                return (T) Integer.valueOf(su(iIntValue));
            case 118:
                return (T) String.valueOf(ha(iIntValue));
            case 119:
                return (T) String.valueOf(g(iIntValue));
            case 120:
                return (T) Boolean.valueOf(ry(iIntValue));
            case 121:
                return (T) Boolean.valueOf(ju(iIntValue));
            case 122:
                return (T) Boolean.valueOf(ta(iIntValue));
            case 123:
                l(iIntValue, (String) map.get("md5"));
                return null;
            case 124:
                n(iIntValue, ((Long) map.get("expectFileLength")).longValue());
                return null;
            case 125:
                q(iIntValue, ((Boolean) map.get("needWifi")).booleanValue());
                return null;
            case WorkQueueKt.MASK /* 127 */:
                qg(iIntValue, ((Long) map.get("extraValue")).longValue());
                return null;
            case 128:
                w(iIntValue, (String) map.get("appName"));
                return null;
            case 129:
                q(iIntValue, (JSONObject) map.get("extraJson"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE /* 130 */:
                x(iIntValue, (String) map.get("startToast"));
                return null;
            case 131:
                fs(iIntValue, (String) map.get("sdkMonitorScene"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA /* 132 */:
                s(iIntValue, ((Long) map.get("id")).longValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START /* 133 */:
                w(iIntValue, ((Boolean) map.get("isAd")).booleanValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS /* 134 */:
                s(iIntValue, ((Integer) map.get("modelType")).intValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET /* 135 */:
                rv(iIntValue, (String) map.get("logExtra"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                tj(iIntValue, (String) map.get(BillingClientConstants.PACKAGE_NAME));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME /* 137 */:
                cp(iIntValue, (String) map.get("appIcon"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE /* 139 */:
                n(iIntValue, (List<String>) map.get("clickTrackUrl"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID /* 140 */:
                d(iIntValue, (String) map.get("downloadUrl"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID /* 141 */:
                qg(iIntValue, (List<String>) map.get("backupUrls"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO /* 142 */:
                oa(iIntValue, (String) map.get("notificationJumpUrl"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE /* 143 */:
                sz(iIntValue, (String) map.get("mimeType"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SPADE /* 144 */:
                n(iIntValue, (Map<String, String>) map.get("headers"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES /* 145 */:
                x(iIntValue, ((Boolean) map.get("isShowNotification")).booleanValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                k(iIntValue, (String) map.get("filePath"));
                return null;
            case 147:
                cy(iIntValue, (String) map.get("fileName"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK /* 148 */:
                fs(iIntValue, ((Boolean) map.get("isNeedIndependentProcess")).booleanValue());
                return null;
            case 149:
                q(iIntValue, ((Integer) map.get("versionCode")).intValue());
                return null;
            case 150:
                hd(iIntValue, (String) map.get("versionName"));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS /* 151 */:
                n(iIntValue, new com.byazt.os.q.n().n((String) map.get("quickAppModelOpenUrl")).qg((String) map.get("quickAppModelExtraData")).n());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF /* 152 */:
                rv(iIntValue, ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT /* 153 */:
                l(iIntValue, ((Integer) map.get("funnelType")).intValue());
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET /* 154 */:
                n(iIntValue, rv(map.get("downloadMarketInterceptor")));
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME /* 157 */:
                if (map != null) {
                    Object obj2 = map.get(com.anythink.core.common.s.a);
                    if (obj2 instanceof Service) {
                        com.byazt.xv.s.n((Context) obj2);
                    }
                }
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME /* 158 */:
                if (map != null) {
                    try {
                        Object obj3 = map.get("i");
                        map.get("c");
                        if (obj3 instanceof Intent) {
                            if (TextUtils.equals(((Intent) obj3).getAction(), "com.csj.install")) {
                                n((Intent) obj3);
                            } else {
                                ((Intent) obj3).setComponent(new ComponentName(com.byazt.xv.s.u(), (Class<?>) DownloadHandlerService.class));
                                com.byazt.xv.s.u().startService((Intent) obj3);
                            }
                        }
                    } catch (Exception e) {
                        com.byazt.eji.s.n().n("start_service", e);
                    }
                    break;
                }
                return null;
            case 160:
                n(map);
                return null;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME /* 162 */:
                Object obj4 = map.get(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                if (obj4 instanceof com.byazt.mi.qg) {
                    rv.n((com.byazt.mi.qg) obj4);
                }
                return null;
        }
    }

    private void n(Intent intent) {
        String str;
        intent.getAction();
        int intExtra = intent.getIntExtra("extra_click_download_ids", -1);
        intent.getIntExtra("extra_click_download_type", -1);
        intent.getStringExtra("extra_tag");
        String stringExtra = intent.getStringExtra("extra_value");
        String stringExtra2 = intent.getStringExtra("extra_log_extra");
        String stringExtra3 = intent.getStringExtra("extra_package_name");
        boolean zQg = com.byazt.vgx.w.qg(stringExtra3);
        NotificationManager notificationManager = (NotificationManager) this.qg.getSystemService("notification");
        com.byazt.esa.n nVar = new com.byazt.esa.n();
        nVar.x(stringExtra);
        nVar.q(stringExtra2);
        nVar.s(stringExtra3);
        String str2 = "success";
        if (zQg) {
            com.byazt.rz.rv.n(stringExtra3);
            str = "open";
        } else {
            str2 = com.byazt.e.q.n(this.qg, intExtra) ? "success" : "failure";
            str = "install";
        }
        com.byazt.iz.l.n("notification", nVar, str, "click_other", null, str2);
        notificationManager.cancel(ei(intExtra));
    }

    private void n(int i, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return;
        }
        adDownloadControllerR.setDownloadMarketInterceptor(downloadMarketInterceptor);
    }

    private void sq(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return;
        }
        adDownloadControllerR.setMarketStatusChangeListener(null);
    }

    private static boolean n(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            return false;
        }
        if (TextUtils.equals(com.byazt.nf.tj.rv, "internal")) {
            return s();
        }
        return true;
    }

    private static boolean s() {
        try {
            try {
                Field declaredField = com.byazt.s.q.class.getDeclaredField("qg");
                declaredField.setAccessible(true);
                return declaredField.get(null) instanceof Integer;
            } catch (Exception unused) {
                Field declaredField2 = com.byazt.s.q.class.getDeclaredField(com.byazt.ug.n.n);
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(null);
                if (obj instanceof Integer) {
                    int iIntValue = ((Integer) obj).intValue();
                    return iIntValue > 107000925 || (iIntValue <= 4061200 && iIntValue > 3000000);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public void n(Bundle bundle) {
        rv.n(this.qg);
        qg();
    }

    private DownloadStatusChangeListener qg(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        return null;
    }

    private com.byazt.hj.qg s(Object obj) {
        if (obj instanceof com.byazt.hj.qg) {
            return (com.byazt.hj.qg) obj;
        }
        return null;
    }

    private DownloadModel q(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private DownloadEventConfig l(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private DownloadController w(Object obj) {
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

    private boolean x(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    private com.byazt.mi.n fs(Object obj) {
        if (obj instanceof Function) {
            return new com.byazt.mi.n(obj);
        }
        return null;
    }

    private DownloadMarketInterceptor rv(Object obj) {
        if (obj instanceof DownloadMarketInterceptor) {
            return (DownloadMarketInterceptor) obj;
        }
        return null;
    }

    private OnItemClickListener tj(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        return null;
    }

    private IDownloadButtonClickListener cp(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        return null;
    }

    private AdDownloadModel.Builder n(long j, String str, boolean z, boolean z2, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.byazt.ms.tj.1
            @Override // com.byazt.je.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return tj.this.n(str10, str11);
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
        fileUriProvider.setDeepLink(n(j, str7, str8, str9));
        return fileUriProvider;
    }

    private void n(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> functionQg = qg();
        if (functionQg == null) {
            k.qg("xgc_dl", "false");
            return;
        }
        try {
            Map map2 = (Map) functionQg.apply(com.byazt.of.qg.n().n(MediaPlayer.MEDIA_PLAYER_OPTION_DECODE_SECOND_VIDEO_FRAME_TIME).n(Map.class).n(0, map).qg());
            if (map2 != null) {
                Notification notification = (Notification) map2.get("notification");
                NotificationManager notificationManager = (NotificationManager) com.byazt.nf.rv.getContext().getSystemService("notification");
                Object obj = map.get("install_download_id");
                notificationManager.notify(ei(obj instanceof Integer ? ((Integer) obj).intValue() : 0), notification);
            }
        } catch (Throwable th) {
            k.qg("xgc_dl", "e:" + th.getMessage());
            com.byazt.eji.s.n().n("csj_install_notification", th);
        }
    }

    public Map<String, Object> n(Object obj) {
        HashMap map = new HashMap();
        map.put("params", obj);
        Function<SparseArray<Object>, Object> functionQg = qg();
        Object objApply = null;
        if (functionQg == null) {
            return null;
        }
        try {
            objApply = functionQg.apply(com.byazt.of.qg.n().n(MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME).n(Map.class).n(0, map).qg());
        } catch (Throwable th) {
            k.qg("xgc_dl", "getCSJDownloadNotificationFromApi error: " + th.getMessage());
        }
        return (Map) objApply;
    }

    public Uri n(String str, String str2) {
        HashMap map = new HashMap();
        map.put("custom_authority", str);
        map.put("custom_file_path", str2);
        Function<SparseArray<Object>, Object> functionQg = qg();
        if (functionQg == null) {
            return null;
        }
        return (Uri) functionQg.apply(com.byazt.of.qg.n().n(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME).n(Uri.class).n(0, map).qg());
    }

    private DeepLink n(long j, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void n(int i, String str, String str2, String str3) {
        AdDownloadModel.Builder builderXi = xi(i);
        if (builderXi == null) {
            return;
        }
        this.q.put(Integer.valueOf(i), builderXi.setAppIcon(str).setAppName(str2).setPackageName(str3).build());
    }

    private void qg(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder builderN = n(((Long) map.get("id")).longValue(), (String) map.get("appIcon"), ((Boolean) map.get("isShowNotification")).booleanValue(), ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue(), (String) map.get("logExtra"), (JSONObject) map.get("extraJson"), (JSONObject) map.get("downloadSettings"), (String) map.get("filePath"), (String) map.get("downloadUrl"), (String) map.get("appName"), (String) map.get(BillingClientConstants.PACKAGE_NAME), ((Boolean) map.get("isNeedIndependentProcess")).booleanValue(), (String) map.get("openUrl"), (String) map.get("webTitle"), (String) map.get("webUrl"));
        this.s.put(Integer.valueOf(i), builderN);
        this.q.put(Integer.valueOf(i), builderN.build());
    }

    private void n(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i2).setDownloadMode(i3).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.l.put(Integer.valueOf(i), isAddToDownloadManage);
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            isAddToDownloadManage.setEnableAM(z3);
        }
        this.w.put(Integer.valueOf(i), isAddToDownloadManage.build());
    }

    private void s(int i, Map<String, Object> map) {
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
        this.l.put(Integer.valueOf(i), enableOppoAutoDownload);
        this.w.put(Integer.valueOf(i), enableOppoAutoDownload.build());
    }

    private void w(int i, int i2) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return;
        }
        adDownloadControllerR.setDownloadMode(i2);
    }

    private int dm(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return 0;
        }
        return adDownloadControllerR.getDownloadMode();
    }

    private void q(int i, Map<String, Object> map) {
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
        this.x.put(Integer.valueOf(i), isEnableV3Event);
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.fs.put(Integer.valueOf(i), isEnableV3Event.build());
    }

    private void l(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
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
        this.x.put(Integer.valueOf(i), paramsJson);
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.fs.put(Integer.valueOf(i), paramsJson.build());
    }

    public int n(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return 0;
        }
        return adDownloadControllerR.getLinkMode();
    }

    public boolean qg(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.isEnableBackDialog();
    }

    public boolean s(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.isAddToDownloadManage();
    }

    public Object q(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return null;
        }
        return adDownloadControllerR.getExtraClickOperation();
    }

    public boolean l(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.isEnableMultipleDownload();
    }

    public int w(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return 1;
        }
        return adDownloadControllerR.getDowloadChunkCount();
    }

    public boolean x(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.shouldUseNewWebView();
    }

    public int fs(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return 0;
        }
        return adDownloadControllerR.getInterceptFlag();
    }

    public JSONObject rv(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return null;
        }
        return adDownloadControllerR.getExtraJson();
    }

    public Object tj(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return null;
        }
        return adDownloadControllerR.getExtraObject();
    }

    public void n(int i, int i2) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return;
        }
        adDownloadControllerR.setLinkMode(i2);
    }

    public boolean cp(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.enableShowComplianceDialog();
    }

    public void n(int i, boolean z) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return;
        }
        adDownloadControllerR.setEnableShowComplianceDialog(z);
    }

    public boolean d(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.isAutoDownloadOnCardShow();
    }

    public boolean oa(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.enableNewActivity();
    }

    public void qg(int i, boolean z) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return;
        }
        adDownloadControllerR.setIsAutoDownloadOnCardShow(z);
    }

    public void s(int i, boolean z) {
        AdDownloadController adDownloadControllerR = r(i);
        if (this.w == null) {
            return;
        }
        adDownloadControllerR.setEnableNewActivity(z);
    }

    public boolean sz(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.enableAH();
    }

    public boolean k(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.enableAM();
    }

    public void n(int i, Object obj) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return;
        }
        adDownloadControllerR.setExtraObject(obj);
    }

    public void n(int i, JSONObject jSONObject) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return;
        }
        adDownloadControllerR.setExtraJson(jSONObject);
    }

    public boolean cy(int i) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return false;
        }
        return adDownloadControllerR.enableOppoAutoDownload();
    }

    private void n(int i, boolean z, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController adDownloadControllerR = r(i);
        if (adDownloadControllerR == null) {
            return;
        }
        try {
            adDownloadControllerR.setDownloadMarketInterceptor(downloadMarketInterceptor);
            adDownloadControllerR.setEnableOppoAutoDownload(z);
        } catch (Throwable unused) {
        }
    }

    public String hd(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        return adDownloadEventConfigMz == null ? "" : adDownloadEventConfigMz.getRefer();
    }

    public String cd(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        return adDownloadEventConfigMz == null ? "" : adDownloadEventConfigMz.getClickButtonTag();
    }

    public String um(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        return adDownloadEventConfigMz == null ? "" : adDownloadEventConfigMz.getClickItemTag();
    }

    public String a(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        return adDownloadEventConfigMz == null ? "" : adDownloadEventConfigMz.getClickLabel();
    }

    public String py(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        return adDownloadEventConfigMz == null ? "" : adDownloadEventConfigMz.getClickStartLabel();
    }

    public String ou(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        return adDownloadEventConfigMz == null ? "" : adDownloadEventConfigMz.getClickPauseLabel();
    }

    public String wm(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        return adDownloadEventConfigMz == null ? "" : adDownloadEventConfigMz.getClickPauseLabel();
    }

    public String m(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        return adDownloadEventConfigMz == null ? "" : adDownloadEventConfigMz.getClickInstallLabel();
    }

    public String hu(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        return adDownloadEventConfigMz == null ? "" : adDownloadEventConfigMz.getStorageDenyLabel();
    }

    public Object h(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return null;
        }
        return adDownloadEventConfigMz.getExtraEventObject();
    }

    public int t(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return 0;
        }
        return adDownloadEventConfigMz.getDownloadScene();
    }

    public boolean ur(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return true;
        }
        return adDownloadEventConfigMz.isEnableClickEvent();
    }

    public boolean bb(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return false;
        }
        return adDownloadEventConfigMz.isEnableV3Event();
    }

    public JSONObject ln(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return null;
        }
        return adDownloadEventConfigMz.getExtraJson();
    }

    public JSONObject lh(int i) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return null;
        }
        return adDownloadEventConfigMz.getParamsJson();
    }

    public void qg(int i, Object obj) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return;
        }
        adDownloadEventConfigMz.setExtraEventObject(obj);
    }

    public void n(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return;
        }
        adDownloadEventConfigMz.setClickButtonTag(str);
    }

    public void qg(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return;
        }
        adDownloadEventConfigMz.setExtraJson(jSONObject);
    }

    public void s(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return;
        }
        adDownloadEventConfigMz.setParamsJson(jSONObject);
    }

    public void qg(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return;
        }
        adDownloadEventConfigMz.setClickItemTag(str);
    }

    public void qg(int i, int i2) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return;
        }
        adDownloadEventConfigMz.setDownloadScene(i2);
    }

    public void s(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return;
        }
        adDownloadEventConfigMz.setRefer(str);
    }

    public void q(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigMz = mz(i);
        if (adDownloadEventConfigMz == null) {
            return;
        }
        adDownloadEventConfigMz.setQuickAppEventTag(str);
    }

    private void w(int i, Map<String, Object> map) {
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
        com.byazt.os.q qVarN = new com.byazt.os.q.n().n(str6).qg((String) map.get("quickAppModelExtraData")).n();
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
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(jLongValue).setMd5(str).setId(jLongValue3).setExtraValue(jLongValue2).setIsAd(zBooleanValue).setModelType(iIntValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(zBooleanValue2).setIsShowNotification(zBooleanValue7).setNeedWifi(zBooleanValue3).setFileName(str4).setVersionCode(iIntValue2).setVersionName(str5).setQuickAppModel(qVarN).setAutoInstallWithoutNotification(zBooleanValue8).setExecutorGroup(iIntValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(zBooleanValue4).setDistinctDir(zBooleanValue5).setEnablePause(zBooleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.byazt.ms.tj.2
            @Override // com.byazt.je.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str19) {
                return tj.this.n(str18, str19);
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
        fileUriProvider.setDeepLink(n(jLongValue3, str15, str16, str17));
        this.s.put(Integer.valueOf(i), fileUriProvider);
        this.q.put(Integer.valueOf(i), fileUriProvider.build());
    }

    public long v(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return 0L;
        }
        return adDownloadModelNp.getId();
    }

    public String j(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getMd5();
    }

    public long an(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return 0L;
        }
        return adDownloadModelNp.getExpectFileLength();
    }

    public long ae(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return 0L;
        }
        return adDownloadModelNp.getExtraValue();
    }

    public String f(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getDownloadUrl();
    }

    public List<String> fi(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.getBackupUrls();
    }

    public String df(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getNotificationJumpUrl();
    }

    public String oj(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getName();
    }

    public String dg(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getMimeType();
    }

    public Map<String, String> u(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.getHeaders();
    }

    public boolean pk(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return true;
        }
        return adDownloadModelNp.isShowToast();
    }

    public boolean wo(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return true;
        }
        return adDownloadModelNp.isShowNotification();
    }

    public boolean sh(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return false;
        }
        return adDownloadModelNp.isNeedWifi();
    }

    public boolean y(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return false;
        }
        return adDownloadModelNp.isInExternalPublicDir();
    }

    public boolean rf(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return false;
        }
        return adDownloadModelNp.isInExternalPublicDir();
    }

    public String dh(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getFilePath();
    }

    public String b(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getFileName();
    }

    public void ri(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.forceWifi();
    }

    public JSONObject nf(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.getDownloadSettings();
    }

    public void pe(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.forceHideToast();
    }

    public void e(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.forceHideNotification();
    }

    public boolean yw(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return false;
        }
        return adDownloadModelNp.needIndependentProcess();
    }

    public int cx(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return 0;
        }
        return adDownloadModelNp.getVersionCode();
    }

    public String lq(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getVersionName();
    }

    public boolean ic(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return true;
        }
        return adDownloadModelNp.isAd();
    }

    public String ci(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getLogExtra();
    }

    public String hf(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getPackageName();
    }

    public String kc(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getAppIcon();
    }

    public DeepLink z(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.getDeepLink();
    }

    public List<String> dn(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.getClickTrackUrl();
    }

    public JSONObject he(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.getExtra();
    }

    public int el(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return 0;
        }
        return adDownloadModelNp.getModelType();
    }

    public com.byazt.os.q vb(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.getQuickAppModel();
    }

    public boolean fl(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return false;
        }
        return adDownloadModelNp.autoInstallWithoutNotification();
    }

    public boolean i(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return com.byazt.es.qg.n(com.byazt.f.n.n(nf(i)), dg(i));
        }
        return adDownloadModelNp.shouldDownloadWithPatchApply();
    }

    public int dw(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return 2;
        }
        return adDownloadModelNp.getExecutorGroup();
    }

    public int su(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return 1;
        }
        return adDownloadModelNp.getFunnelType();
    }

    public String ha(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getStartToast();
    }

    public String g(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        return adDownloadModelNp == null ? "" : adDownloadModelNp.getStartToast();
    }

    public boolean ry(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return true;
        }
        return adDownloadModelNp.isAutoInstall();
    }

    public boolean ju(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return false;
        }
        return adDownloadModelNp.distinctDir();
    }

    public boolean ta(int i) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return true;
        }
        return adDownloadModelNp.enablePause();
    }

    public void l(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.setMd5(str);
    }

    public void n(int i, long j) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.setExpectFileLength(j);
    }

    public void q(int i, boolean z) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.setNeedWifi(z);
    }

    public void l(int i, boolean z) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.setIsShowToast(z);
    }

    public void qg(int i, long j) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.setExtraValue(j);
    }

    public void w(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.setAppName(str);
    }

    public void q(int i, JSONObject jSONObject) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.setExtra(jSONObject);
    }

    public void x(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.setStartToast(str);
    }

    public void fs(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return;
        }
        adDownloadModelNp.setSdkMonitorScene(str);
    }

    public AdDownloadModel s(int i, long j) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setId(j);
    }

    public AdDownloadModel w(int i, boolean z) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setIsAd(z);
    }

    public AdDownloadModel s(int i, int i2) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setModelType(i2);
    }

    public AdDownloadModel rv(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setLogExtra(str);
    }

    public AdDownloadModel tj(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setPackageName(str);
    }

    public AdDownloadModel cp(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setAppIcon(str);
    }

    public AdDownloadModel n(int i, List<String> list) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setClickTrackUrl(list);
    }

    public AdDownloadModel d(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setDownloadUrl(str);
    }

    public AdDownloadModel qg(int i, List<String> list) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setBackupUrls(list);
    }

    public AdDownloadModel oa(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setNotificationJumpUrl(str);
    }

    public AdDownloadModel sz(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setMimeType(str);
    }

    public AdDownloadModel n(int i, Map<String, String> map) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setHeaders(map);
    }

    public AdDownloadModel x(int i, boolean z) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setIsShowNotification(z);
    }

    public AdDownloadModel k(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setFilePath(str);
    }

    public AdDownloadModel cy(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setFileName(str);
    }

    public AdDownloadModel fs(int i, boolean z) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setNeedIndependentProcess(z);
    }

    public AdDownloadModel q(int i, int i2) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setVersionCode(i2);
    }

    public AdDownloadModel hd(int i, String str) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setVersionName(str);
    }

    public AdDownloadModel n(int i, com.byazt.os.q qVar) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setQuickAppModel(qVar);
    }

    public AdDownloadModel rv(int i, boolean z) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setAutoInstallWithoutNotification(z);
    }

    public AdDownloadModel l(int i, int i2) {
        AdDownloadModel adDownloadModelNp = np(i);
        if (adDownloadModelNp == null) {
            return null;
        }
        return adDownloadModelNp.setFunnelType(i2);
    }

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) n().sparseArray();
        }
        return (T) call(i, pluginValueSet, cls);
    }

    public PluginValueSet n() {
        return com.byazt.qvu.n.n().n(0, rv.n).n(1, Boolean.valueOf(rv.qg)).n(10000, 3).qg();
    }

    public <T> T call(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        Map<String, Object> map;
        if (i == 20) {
            n((Bundle) pluginValueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (pluginValueSet != null && pluginValueSet.objectValue(0, Map.class) != null) {
            map = (Map) pluginValueSet.objectValue(0, Map.class);
        } else {
            map = new HashMap<>();
        }
        return (T) n(cls, i, map);
    }
}
