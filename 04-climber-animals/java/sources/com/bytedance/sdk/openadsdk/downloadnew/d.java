package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.ms.ab;
import com.bytedance.sdk.openadsdk.api.ms.c;
import com.bytedance.sdk.openadsdk.api.ms.ka;
import com.bytedance.sdk.openadsdk.api.ms.x;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile d f3912ms;
    private final Context xr;
    private Map<Integer, AdDownloadModel.Builder> ah = new ConcurrentHashMap();
    private Map<Integer, AdDownloadModel> d = new ConcurrentHashMap();
    private Map<Integer, AdDownloadController.Builder> ka = new ConcurrentHashMap();
    private Map<Integer, AdDownloadController> c = new ConcurrentHashMap();
    private Map<Integer, AdDownloadEventConfig.Builder> ab = new ConcurrentHashMap();
    private Map<Integer, AdDownloadEventConfig> x = new ConcurrentHashMap();

    private void o(int i) {
        this.ah.remove(Integer.valueOf(i));
        this.d.remove(Integer.valueOf(i));
        this.ka.remove(Integer.valueOf(i));
        this.c.remove(Integer.valueOf(i));
        this.ab.remove(Integer.valueOf(i));
        this.x.remove(Integer.valueOf(i));
    }

    private AdDownloadModel.Builder n(int i) {
        return this.ah.get(Integer.valueOf(i));
    }

    private AdDownloadModel ec(int i) {
        return this.d.get(Integer.valueOf(i));
    }

    private AdDownloadController vf(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    private AdDownloadEventConfig kl(int i) {
        return this.x.get(Integer.valueOf(i));
    }

    private d(Context context) {
        this.xr = context;
    }

    public static d ms(Context context) {
        if (f3912ms == null) {
            synchronized (d.class) {
                if (f3912ms == null) {
                    f3912ms = new d(context);
                }
            }
        }
        return f3912ms;
    }

    public <T> T ms(Class<T> cls, int i, Map<String, Object> map) {
        Object obj = map.get(TTDownloadField.TT_HASHCODE);
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        DownloadModel downloadModelEc = ec(iIntValue);
        switch (i) {
            case 0:
                return (T) Boolean.valueOf(ah.ms(getActivity(map.get(TTDownloadField.TT_ACTIVITY)), ka(map.get(TTDownloadField.TT_EXIT_INSTALL_LISTENER))));
            case 1:
                return (T) ah.ms().c();
            case 2:
                try {
                    return (T) Boolean.valueOf(ah.ms((String) map.get(TTDownloadField.TT_TAG_INTERCEPT), (String) map.get(TTDownloadField.TT_LABEL), new JSONObject((String) map.get(TTDownloadField.TT_META)), new HashMap()));
                } catch (JSONException unused) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                ah.ms(((Integer) map.get(TTDownloadField.TT_HID)).intValue());
                return null;
            case 4:
                ah.ms().ms(downloadModelEc == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : downloadModelEc.getDownloadUrl(), iIntValue);
                o(iIntValue);
                return null;
            case 5:
                if (downloadModelEc == null) {
                    downloadModelEc = xr(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                }
                ah.ms().ms(this.xr, iIntValue, ms(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), downloadModelEc);
                return null;
            case 6:
                return (T) Boolean.valueOf(ah.ms(this.xr, downloadModelEc == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : downloadModelEc.getDownloadUrl()));
            case 7:
                ah.xr();
                return null;
            case 8:
                ah.ms().ms(downloadModelEc == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : downloadModelEc.getDownloadUrl(), ((Boolean) map.get(TTDownloadField.TT_FORCE)).booleanValue());
                return null;
            case 9:
                ah.ms(((Integer) map.get(TTDownloadField.TT_HID)).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                return null;
            case 10:
                ah.ms((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                return null;
            case 11:
            case 20:
            case 21:
            case 22:
            case 43:
            case 77:
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_TOAST /* 126 */:
            case 138:
            default:
                return null;
            case 12:
                Uri uri = (Uri) map.get("uri");
                if (downloadModelEc == null) {
                    downloadModelEc = xr(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                }
                DownloadModel downloadModel = downloadModelEc;
                DownloadEventConfig downloadEventConfigKl = kl(iIntValue);
                if (downloadEventConfigKl == null) {
                    downloadEventConfigKl = ah(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                }
                DownloadEventConfig downloadEventConfig = downloadEventConfigKl;
                DownloadController downloadControllerVf = vf(iIntValue);
                if (downloadControllerVf == null) {
                    downloadControllerVf = d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                }
                DownloadController downloadController = downloadControllerVf;
                IDownloadButtonClickListener iDownloadButtonClickListenerX = x(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (ms(iDownloadButtonClickListenerX)) {
                    return (T) Boolean.valueOf(ah.ms(this.xr, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListenerX));
                }
                return (T) Boolean.valueOf(ah.ms(this.xr, uri, downloadModel, downloadEventConfig, downloadController));
            case 13:
                boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                String str = (String) map.get(TTDownloadField.TT_USERAGENT);
                if (downloadModelEc == null) {
                    downloadModelEc = xr(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                }
                DownloadModel downloadModel2 = downloadModelEc;
                DownloadEventConfig downloadEventConfigKl2 = kl(iIntValue);
                if (downloadEventConfigKl2 == null) {
                    downloadEventConfigKl2 = ah(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                }
                DownloadEventConfig downloadEventConfig2 = downloadEventConfigKl2;
                DownloadController downloadControllerVf2 = vf(iIntValue);
                if (downloadControllerVf2 == null) {
                    downloadControllerVf2 = d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                }
                DownloadController downloadController2 = downloadControllerVf2;
                DownloadStatusChangeListener downloadStatusChangeListenerMs = ms(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                IDownloadButtonClickListener iDownloadButtonClickListenerX2 = x(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (ms(iDownloadButtonClickListenerX2)) {
                    ah.ms().ka().ms(this.xr, str, zBooleanValue, downloadModel2, downloadEventConfig2, downloadController2, downloadStatusChangeListenerMs, iIntValue, iDownloadButtonClickListenerX2);
                    return null;
                }
                ah.ms().ka().ms(this.xr, str, zBooleanValue, downloadModel2, downloadEventConfig2, downloadController2, downloadStatusChangeListenerMs, iIntValue);
                return null;
            case 14:
                return (T) Boolean.valueOf(ah.ms().ka().ms(this.xr, downloadModelEc == null ? ((Long) map.get("id")).longValue() : downloadModelEc.getId(), downloadModelEc == null ? (String) map.get(TTDownloadField.TT_LOG_EXTRA) : downloadModelEc.getLogExtra(), (DownloadStatusChangeListener) null, iIntValue));
            case 15:
                return (T) Boolean.valueOf(ah.ms((Uri) map.get("uri")));
            case 16:
                String downloadUrl = downloadModelEc == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : downloadModelEc.getDownloadUrl();
                long jLongValue = downloadModelEc == null ? ((Long) map.get("id")).longValue() : downloadModelEc.getId();
                int iIntValue2 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                DownloadEventConfig downloadEventConfigKl3 = kl(iIntValue);
                if (downloadEventConfigKl3 == null) {
                    downloadEventConfigKl3 = ah(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                }
                DownloadEventConfig downloadEventConfig3 = downloadEventConfigKl3;
                AdDownloadController adDownloadControllerVf = vf(iIntValue);
                ah.ms().ms(downloadUrl, jLongValue, iIntValue2, downloadEventConfig3, adDownloadControllerVf == null ? d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER)) : adDownloadControllerVf);
                return null;
            case 17:
                String downloadUrl2 = downloadModelEc == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : downloadModelEc.getDownloadUrl();
                long jLongValue2 = ((Long) map.get("id")).longValue();
                int iIntValue3 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                DownloadEventConfig downloadEventConfigKl4 = kl(iIntValue);
                if (downloadEventConfigKl4 == null) {
                    downloadEventConfigKl4 = ah(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                }
                DownloadEventConfig downloadEventConfig4 = downloadEventConfigKl4;
                DownloadController downloadControllerVf3 = vf(iIntValue);
                if (downloadControllerVf3 == null) {
                    downloadControllerVf3 = d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                }
                ah.ms().ms(downloadUrl2, jLongValue2, iIntValue3, downloadEventConfig4, downloadControllerVf3, ab(map.get(TTDownloadField.TT_ITEM_CLICK_LISTENER)), x(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                return null;
            case 18:
                T t = (T) Boolean.valueOf(ah.ms().ka().ms(downloadModelEc == null ? ((Long) map.get("id")).longValue() : downloadModelEc.getId(), iIntValue));
                o(iIntValue);
                return t;
            case 19:
                return (T) Boolean.valueOf(ah.ms().ka().ms(downloadModelEc == null ? ((Long) map.get("id")).longValue() : downloadModelEc.getId()));
            case 23:
                if (((Boolean) map.get(TTDownloadField.TT_MATE_IS_EMPTY)).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.ah.put(Integer.valueOf(iIntValue), builder);
                    this.d.put(Integer.valueOf(iIntValue), builder.build());
                    return null;
                }
                xr(iIntValue, map);
                return null;
            case 24:
                ms(iIntValue, (String) map.get(TTDownloadField.TT_APP_ICON), (String) map.get("appName"), (String) map.get("packageName"));
                return null;
            case 25:
                ms(iIntValue, ((Integer) map.get(TTDownloadField.TT_AUTO_OPEN)).intValue(), ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue(), ((Boolean) map.get(TTDownloadField.TT_IS_HAVE_DOWNLOAD_SDK_CONFIG)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue());
                return null;
            case 26:
                c(iIntValue, ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue());
                return null;
            case 27:
                return (T) Integer.valueOf(gs(iIntValue));
            case 28:
                boolean zBooleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue();
                try {
                    ms(iIntValue, c(map.get(TTDownloadField.TT_DOWNLOAD_MARKET_INTERCEPTOR)));
                    break;
                } catch (Throwable unused2) {
                }
                ch(iIntValue, zBooleanValue2);
                return null;
            case 29:
                d(iIntValue, map);
                return null;
            case 30:
                xr(iIntValue, ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue());
                return null;
            case 31:
                ka(iIntValue, ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue());
                return null;
            case 32:
                ah(iIntValue, map);
                return null;
            case 33:
                return (T) Integer.valueOf(ms(iIntValue));
            case 34:
                return (T) Boolean.valueOf(xr(iIntValue));
            case 35:
                return (T) Boolean.valueOf(ah(iIntValue));
            case 36:
                return (T) d(iIntValue);
            case 37:
                return (T) Boolean.valueOf(ka(iIntValue));
            case 38:
                return (T) Integer.valueOf(c(iIntValue));
            case 39:
                return (T) Boolean.valueOf(ab(iIntValue));
            case 40:
                return (T) Integer.valueOf(x(iIntValue));
            case 41:
                return (T) ny(iIntValue);
            case 42:
                return (T) ch(iIntValue);
            case 44:
                ms(iIntValue, ((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue());
                return null;
            case 45:
                return (T) Boolean.valueOf(hi(iIntValue));
            case 46:
                ms(iIntValue, ((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue());
                return null;
            case 47:
                return (T) Boolean.valueOf(sl(iIntValue));
            case 48:
                return (T) Boolean.valueOf(zb(iIntValue));
            case 49:
                xr(iIntValue, ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue());
                return null;
            case 50:
                ah(iIntValue, ((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue());
                return null;
            case 51:
                return (T) Boolean.valueOf(u(iIntValue));
            case 52:
                return (T) Boolean.valueOf(ub(iIntValue));
            case 53:
                ms(iIntValue, map.get(TTDownloadField.TT_EXTRA_OBJECT));
                return null;
            case 54:
                ms(iIntValue, (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                return null;
            case 55:
                return (T) Boolean.valueOf(ao(iIntValue));
            case 56:
                ka(iIntValue, map);
                return null;
            case 57:
                return (T) String.valueOf(h(iIntValue));
            case 58:
                return (T) String.valueOf(qv(iIntValue));
            case 59:
                return (T) String.valueOf(y(iIntValue));
            case 60:
                return (T) String.valueOf(t(iIntValue));
            case 61:
                return (T) String.valueOf(nw(iIntValue));
            case 62:
                return (T) String.valueOf(b(iIntValue));
            case 63:
                return (T) String.valueOf(re(iIntValue));
            case 64:
                return (T) String.valueOf(i(iIntValue));
            case 65:
                return (T) String.valueOf(w(iIntValue));
            case 66:
                return (T) yu(iIntValue);
            case 67:
                return (T) Integer.valueOf(op(iIntValue));
            case 68:
                return (T) Boolean.valueOf(le(iIntValue));
            case 69:
                return (T) Boolean.valueOf(cv(iIntValue));
            case 70:
                return (T) g(iIntValue);
            case 71:
                return (T) of(iIntValue);
            case 72:
                xr(iIntValue, map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT));
                return null;
            case 73:
                ms(iIntValue, (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG));
                return null;
            case 74:
                xr(iIntValue, (JSONObject) map.get(TTDownloadField.TT_EVENT_CONFIG_EXTRA_JSON));
                return null;
            case 75:
                ah(iIntValue, (JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON));
                return null;
            case 76:
                xr(iIntValue, (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG));
                return null;
            case 78:
                ah(iIntValue, (String) map.get(TTDownloadField.TT_REFER));
                return null;
            case 79:
                d(iIntValue, (String) map.get(TTDownloadField.TT_QUICK_APP_EVENT_TAG));
                return null;
            case 80:
                c(iIntValue, map);
                return null;
            case 81:
                return (T) Long.valueOf(p(iIntValue));
            case 82:
                return (T) String.valueOf(pc(iIntValue));
            case 83:
                return (T) Long.valueOf(jw(iIntValue));
            case 84:
                return (T) Long.valueOf(f(iIntValue));
            case 85:
                return (T) String.valueOf(ul(iIntValue));
            case 86:
                return (T) az(iIntValue);
            case 87:
                return (T) String.valueOf(m(iIntValue));
            case 88:
                return (T) String.valueOf(lm(iIntValue));
            case 89:
                return (T) String.valueOf(e(iIntValue));
            case 90:
                return (T) k(iIntValue);
            case 91:
                return (T) Boolean.valueOf(eg(iIntValue));
            case 92:
                return (T) Boolean.valueOf(fm(iIntValue));
            case 93:
                return (T) Boolean.valueOf(xn(iIntValue));
            case 94:
                return (T) Boolean.valueOf(il(iIntValue));
            case 95:
                return (T) Boolean.valueOf(qf(iIntValue));
            case 96:
                return (T) String.valueOf(l(iIntValue));
            case 97:
                return (T) String.valueOf(am(iIntValue));
            case 98:
                sa(iIntValue);
                return null;
            case 99:
                return (T) tz(iIntValue);
            case 100:
                ti(iIntValue);
                return null;
            case 101:
                s(iIntValue);
                return null;
            case 102:
                return (T) Boolean.valueOf(v(iIntValue));
            case 103:
                return (T) Integer.valueOf(qk(iIntValue));
            case 104:
                return (T) String.valueOf(vm(iIntValue));
            case 105:
                return (T) Boolean.valueOf(zf(iIntValue));
            case 106:
                return (T) String.valueOf(rt(iIntValue));
            case 107:
                return (T) String.valueOf(vy(iIntValue));
            case 108:
                return (T) String.valueOf(sk(iIntValue));
            case 109:
                return (T) gy(iIntValue);
            case 110:
                return (T) vl(iIntValue);
            case 111:
                return (T) qr(iIntValue);
            case 112:
                return (T) Integer.valueOf(ce(iIntValue));
            case 113:
                return (T) jm(iIntValue);
            case 114:
                return (T) Boolean.valueOf(bz(iIntValue));
            case 115:
                return (T) Boolean.valueOf(jy(iIntValue));
            case 116:
                return (T) Integer.valueOf(j(iIntValue));
            case 117:
                return (T) Integer.valueOf(ih(iIntValue));
            case 118:
                return (T) String.valueOf(oh(iIntValue));
            case 119:
                return (T) String.valueOf(zd(iIntValue));
            case 120:
                return (T) Boolean.valueOf(z(iIntValue));
            case 121:
                return (T) Boolean.valueOf(tk(iIntValue));
            case 122:
                return (T) Boolean.valueOf(nn(iIntValue));
            case 123:
                ka(iIntValue, (String) map.get("md5"));
                return null;
            case 124:
                ms(iIntValue, ((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue());
                return null;
            case 125:
                d(iIntValue, ((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue());
                return null;
            case 127:
                xr(iIntValue, ((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue());
                return null;
            case 128:
                c(iIntValue, (String) map.get("appName"));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA /* 129 */:
                d(iIntValue, (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                return null;
            case 130:
                ab(iIntValue, (String) map.get(TTDownloadField.TT_START_TOAST));
                return null;
            case 131:
                x(iIntValue, (String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE));
                return null;
            case 132:
                ah(iIntValue, ((Long) map.get("id")).longValue());
                return null;
            case 133:
                c(iIntValue, ((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue());
                return null;
            case 134:
                ah(iIntValue, ((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue());
                return null;
            case 135:
                ny(iIntValue, (String) map.get(TTDownloadField.TT_LOG_EXTRA));
                return null;
            case 136:
                ch(iIntValue, (String) map.get("packageName"));
                return null;
            case 137:
                hi(iIntValue, (String) map.get(TTDownloadField.TT_APP_ICON));
                return null;
            case 139:
                ms(iIntValue, (List<String>) map.get(TTDownloadField.TT_CLICK_TRACK_URL));
                return null;
            case 140:
                sl(iIntValue, (String) map.get(TTDownloadField.TT_DOWNLOAD_URL));
                return null;
            case 141:
                xr(iIntValue, (List<String>) map.get(TTDownloadField.TT_BACK_UP_URLS));
                return null;
            case 142:
                zb(iIntValue, (String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL));
                return null;
            case 143:
                u(iIntValue, (String) map.get(TTDownloadField.TT_MIME_TYPE));
                return null;
            case 144:
                ms(iIntValue, (Map<String, String>) map.get(TTDownloadField.TT_HEADERS));
                return null;
            case 145:
                ab(iIntValue, ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue());
                return null;
            case 146:
                ub(iIntValue, (String) map.get(TTDownloadField.TT_FILE_PATH));
                return null;
            case 147:
                ao(iIntValue, (String) map.get(TTDownloadField.TT_FILE_NAME));
                return null;
            case 148:
                x(iIntValue, ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue());
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE /* 149 */:
                d(iIntValue, ((Integer) map.get(TTDownloadField.TT_VERSION_CODE)).intValue());
                return null;
            case 150:
                h(iIntValue, (String) map.get(TTDownloadField.TT_VERSION_NAME));
                return null;
            case 151:
                ms(iIntValue, new com.ss.android.download.api.model.d.ms().ms((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL)).xr((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).ms());
                return null;
            case 152:
                ny(iIntValue, ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue());
                return null;
            case 153:
                ka(iIntValue, ((Integer) map.get(TTDownloadField.TT_FUNNEL_TYPE)).intValue());
                return null;
            case 154:
                try {
                    ms(iIntValue, c(map.get(TTDownloadField.TT_DOWNLOAD_MARKET_INTERCEPTOR)));
                    break;
                } catch (Throwable unused3) {
                }
                return null;
        }
    }

    private void ms(int i, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return;
        }
        adDownloadControllerVf.setDownloadMarketInterceptor(downloadMarketInterceptor);
    }

    private static boolean ms(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            return false;
        }
        if (TextUtils.equals("main", UMModuleRegister.INNER)) {
            return ms();
        }
        return true;
    }

    private static boolean ms() {
        try {
            try {
                Field declaredField = com.ss.android.downloadlib.d.class.getDeclaredField("xr");
                declaredField.setAccessible(true);
                return declaredField.get(null) instanceof Integer;
            } catch (Exception unused) {
                Field declaredField2 = com.ss.android.downloadlib.d.class.getDeclaredField("ms");
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

    public void ms(Bundle bundle) {
        ah.ms(this.xr);
    }

    private DownloadStatusChangeListener ms(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        if (obj instanceof EventListener) {
            return new ka((EventListener) obj);
        }
        if (obj instanceof Function) {
            return new ka((Function<SparseArray<Object>, Object>) obj);
        }
        return null;
    }

    private DownloadModel xr(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private DownloadEventConfig ah(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private DownloadController d(Object obj) {
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

    private ExitInstallListener ka(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private DownloadMarketInterceptor c(Object obj) {
        if (obj instanceof DownloadMarketInterceptor) {
            return (DownloadMarketInterceptor) obj;
        }
        if (obj instanceof EventListener) {
            return new ab((EventListener) obj);
        }
        if (obj instanceof Function) {
            return new ab((Function<SparseArray<Object>, Object>) obj);
        }
        return null;
    }

    private OnItemClickListener ab(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new x((EventListener) obj);
        }
        if (obj instanceof Function) {
            return new x((Function<SparseArray<Object>, Object>) obj);
        }
        return null;
    }

    private IDownloadButtonClickListener x(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new c((EventListener) obj);
        }
        if (obj instanceof Function) {
            return new c((Function<SparseArray<Object>, Object>) obj);
        }
        return null;
    }

    private AdDownloadModel.Builder ms(long j, String str, boolean z, boolean z2, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return null;
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
        fileUriProvider.setDeepLink(ms(j, str7, str8, str9));
        return fileUriProvider;
    }

    private DeepLink ms(long j, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void ms(int i, String str, String str2, String str3) {
        AdDownloadModel.Builder builderN = n(i);
        if (builderN == null) {
            return;
        }
        this.d.put(Integer.valueOf(i), builderN.setAppIcon(str).setAppName(str2).setPackageName(str3).build());
    }

    private void xr(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder builderMs = ms(((Long) map.get("id")).longValue(), (String) map.get(TTDownloadField.TT_APP_ICON), ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue(), (String) map.get(TTDownloadField.TT_LOG_EXTRA), (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON), (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS), (String) map.get(TTDownloadField.TT_FILE_PATH), (String) map.get(TTDownloadField.TT_DOWNLOAD_URL), (String) map.get("appName"), (String) map.get("packageName"), ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue(), (String) map.get(TTDownloadField.TT_OPEN_URL), (String) map.get(TTDownloadField.TT_WEB_TITLE), (String) map.get(TTDownloadField.TT_WEB_URL));
        this.ah.put(Integer.valueOf(i), builderMs);
        this.d.put(Integer.valueOf(i), builderMs.build());
    }

    private void ms(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i2).setDownloadMode(i3).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.ka.put(Integer.valueOf(i), isAddToDownloadManage);
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            isAddToDownloadManage.setEnableAM(z3);
        }
        this.c.put(Integer.valueOf(i), isAddToDownloadManage.build());
    }

    private void ah(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int iIntValue = ((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue();
        int iIntValue2 = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue();
        boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_BACK_DIALOG)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ADD_TO_DOWNLOAD_MANAGE)).booleanValue();
        map.get(TTDownloadField.TT_EXTRA_OPERATION);
        boolean zBooleanValue3 = ((Boolean) map.get(TTDownloadField.TT_SHOULD_USE_NEW_WEB_VIEW)).booleanValue();
        int iIntValue3 = ((Integer) map.get(TTDownloadField.TT_INTERCEPT_FLAG)).intValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        Object obj = map.get(TTDownloadField.TT_EXTRA_OBJECT);
        boolean zBooleanValue4 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue();
        boolean zBooleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(iIntValue).setDownloadMode(iIntValue2).setIsEnableBackDialog(zBooleanValue).setIsAddToDownloadManage(zBooleanValue2).setShouldUseNewWebView(zBooleanValue3).setInterceptFlag(iIntValue3).setExtraJson(jSONObject).setExtraObject(obj).setEnableShowComplianceDialog(zBooleanValue4).setIsAutoDownloadOnCardShow(zBooleanValue5).setEnableNewActivity(zBooleanValue6).setEnableAH(zBooleanValue7).setEnableAM(zBooleanValue8).setEnableOppoAutoDownload(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
        this.ka.put(Integer.valueOf(i), enableOppoAutoDownload);
        this.c.put(Integer.valueOf(i), enableOppoAutoDownload.build());
    }

    private void c(int i, int i2) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return;
        }
        adDownloadControllerVf.setDownloadMode(i2);
    }

    private int gs(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return 0;
        }
        return adDownloadControllerVf.getDownloadMode();
    }

    private void d(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str4 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(zBooleanValue).setIsEnableV3Event(zBooleanValue2);
        this.ab.put(Integer.valueOf(i), isEnableV3Event);
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.x.put(Integer.valueOf(i), isEnableV3Event.build());
    }

    private void ka(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_CLICK_LABEL);
        int iIntValue = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue();
        String str4 = (String) map.get(TTDownloadField.TT_REFER);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str8 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str9 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(zBooleanValue).setDownloadScene(iIntValue).setIsEnableV3Event(zBooleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
        this.ab.put(Integer.valueOf(i), paramsJson);
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.x.put(Integer.valueOf(i), paramsJson.build());
    }

    public int ms(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return 0;
        }
        return adDownloadControllerVf.getLinkMode();
    }

    public boolean xr(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.isEnableBackDialog();
    }

    public boolean ah(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.isAddToDownloadManage();
    }

    public Object d(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return null;
        }
        return adDownloadControllerVf.getExtraClickOperation();
    }

    public boolean ka(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.isEnableMultipleDownload();
    }

    public int c(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return 1;
        }
        return adDownloadControllerVf.getDowloadChunkCount();
    }

    public boolean ab(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.shouldUseNewWebView();
    }

    public int x(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return 0;
        }
        return adDownloadControllerVf.getInterceptFlag();
    }

    public JSONObject ny(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return null;
        }
        return adDownloadControllerVf.getExtraJson();
    }

    public Object ch(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return null;
        }
        return adDownloadControllerVf.getExtraObject();
    }

    public void ms(int i, int i2) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return;
        }
        adDownloadControllerVf.setLinkMode(i2);
    }

    public boolean hi(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.enableShowComplianceDialog();
    }

    public void ms(int i, boolean z) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return;
        }
        adDownloadControllerVf.setEnableShowComplianceDialog(z);
    }

    public boolean sl(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.isAutoDownloadOnCardShow();
    }

    public boolean zb(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.enableNewActivity();
    }

    public void xr(int i, boolean z) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return;
        }
        adDownloadControllerVf.setIsAutoDownloadOnCardShow(z);
    }

    public void ah(int i, boolean z) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (this.c == null) {
            return;
        }
        adDownloadControllerVf.setEnableNewActivity(z);
    }

    public boolean u(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.enableAH();
    }

    public boolean ub(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.enableAM();
    }

    public void ms(int i, Object obj) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return;
        }
        adDownloadControllerVf.setExtraObject(obj);
    }

    public void ms(int i, JSONObject jSONObject) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return;
        }
        adDownloadControllerVf.setExtraJson(jSONObject);
    }

    public boolean ao(int i) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return false;
        }
        return adDownloadControllerVf.enableOppoAutoDownload();
    }

    private void ch(int i, boolean z) {
        AdDownloadController adDownloadControllerVf = vf(i);
        if (adDownloadControllerVf == null) {
            return;
        }
        try {
            adDownloadControllerVf.setEnableOppoAutoDownload(z);
        } catch (Throwable unused) {
        }
    }

    public String h(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        return adDownloadEventConfigKl == null ? "" : adDownloadEventConfigKl.getRefer();
    }

    public String qv(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        return adDownloadEventConfigKl == null ? "" : adDownloadEventConfigKl.getClickButtonTag();
    }

    public String y(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        return adDownloadEventConfigKl == null ? "" : adDownloadEventConfigKl.getClickItemTag();
    }

    public String t(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        return adDownloadEventConfigKl == null ? "" : adDownloadEventConfigKl.getClickLabel();
    }

    public String nw(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        return adDownloadEventConfigKl == null ? "" : adDownloadEventConfigKl.getClickStartLabel();
    }

    public String b(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        return adDownloadEventConfigKl == null ? "" : adDownloadEventConfigKl.getClickPauseLabel();
    }

    public String re(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        return adDownloadEventConfigKl == null ? "" : adDownloadEventConfigKl.getClickPauseLabel();
    }

    public String i(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        return adDownloadEventConfigKl == null ? "" : adDownloadEventConfigKl.getClickInstallLabel();
    }

    public String w(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        return adDownloadEventConfigKl == null ? "" : adDownloadEventConfigKl.getStorageDenyLabel();
    }

    public Object yu(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return null;
        }
        return adDownloadEventConfigKl.getExtraEventObject();
    }

    public int op(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return 0;
        }
        return adDownloadEventConfigKl.getDownloadScene();
    }

    public boolean le(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return true;
        }
        return adDownloadEventConfigKl.isEnableClickEvent();
    }

    public boolean cv(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return false;
        }
        return adDownloadEventConfigKl.isEnableV3Event();
    }

    public JSONObject g(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return null;
        }
        return adDownloadEventConfigKl.getExtraJson();
    }

    public JSONObject of(int i) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return null;
        }
        return adDownloadEventConfigKl.getParamsJson();
    }

    public void xr(int i, Object obj) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return;
        }
        adDownloadEventConfigKl.setExtraEventObject(obj);
    }

    public void ms(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return;
        }
        adDownloadEventConfigKl.setClickButtonTag(str);
    }

    public void xr(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return;
        }
        adDownloadEventConfigKl.setExtraJson(jSONObject);
    }

    public void ah(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return;
        }
        adDownloadEventConfigKl.setParamsJson(jSONObject);
    }

    public void xr(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return;
        }
        adDownloadEventConfigKl.setClickItemTag(str);
    }

    public void xr(int i, int i2) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return;
        }
        adDownloadEventConfigKl.setDownloadScene(i2);
    }

    public void ah(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return;
        }
        adDownloadEventConfigKl.setRefer(str);
    }

    public void d(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigKl = kl(i);
        if (adDownloadEventConfigKl == null) {
            return;
        }
        adDownloadEventConfigKl.setQuickAppEventTag(str);
    }

    private void c(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long jLongValue = ((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue();
        String str = (String) map.get("md5");
        long jLongValue2 = ((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue();
        boolean zBooleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue();
        int iIntValue = ((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue();
        List<String> list = (List) map.get(TTDownloadField.TT_CLICK_TRACK_URL);
        List<String> list2 = (List) map.get(TTDownloadField.TT_BACK_UP_URLS);
        String str2 = (String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL);
        String str3 = (String) map.get(TTDownloadField.TT_MIME_TYPE);
        Map<String, String> map2 = (Map) map.get(TTDownloadField.TT_HEADERS);
        boolean zBooleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue();
        boolean zBooleanValue3 = ((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue();
        String str4 = (String) map.get(TTDownloadField.TT_FILE_NAME);
        int iIntValue2 = ((Integer) map.get(TTDownloadField.TT_VERSION_CODE)).intValue();
        String str5 = (String) map.get(TTDownloadField.TT_VERSION_NAME);
        String str6 = (String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL);
        com.ss.android.download.api.model.d dVarMs = new com.ss.android.download.api.model.d.ms().ms(str6).xr((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).ms();
        int iIntValue3 = ((Integer) map.get(TTDownloadField.TT_EXECUTOR_GROUP)).intValue();
        String str7 = (String) map.get(TTDownloadField.TT_START_TOAST);
        String str8 = (String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE);
        boolean zBooleanValue4 = ((Boolean) map.get(TTDownloadField.TT_AUTO_INSTALL)).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get(TTDownloadField.TT_DISTINCT_DIR)).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_PAUSE)).booleanValue();
        long jLongValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get(TTDownloadField.TT_APP_ICON);
        boolean zBooleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue();
        String str10 = (String) map.get(TTDownloadField.TT_LOG_EXTRA);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS);
        String str11 = (String) map.get(TTDownloadField.TT_FILE_PATH);
        String str12 = (String) map.get(TTDownloadField.TT_DOWNLOAD_URL);
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get("packageName");
        boolean zBooleanValue9 = ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue();
        String str15 = (String) map.get(TTDownloadField.TT_OPEN_URL);
        String str16 = (String) map.get(TTDownloadField.TT_WEB_TITLE);
        String str17 = (String) map.get(TTDownloadField.TT_WEB_URL);
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(jLongValue).setMd5(str).setId(jLongValue3).setExtraValue(jLongValue2).setIsAd(zBooleanValue).setModelType(iIntValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(zBooleanValue2).setIsShowNotification(zBooleanValue7).setNeedWifi(zBooleanValue3).setFileName(str4).setVersionCode(iIntValue2).setVersionName(str5).setQuickAppModel(dVarMs).setAutoInstallWithoutNotification(zBooleanValue8).setExecutorGroup(iIntValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(zBooleanValue4).setDistinctDir(zBooleanValue5).setEnablePause(zBooleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.2
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str19) {
                return null;
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
        fileUriProvider.setDeepLink(ms(jLongValue3, str15, str16, str17));
        this.ah.put(Integer.valueOf(i), fileUriProvider);
        this.d.put(Integer.valueOf(i), fileUriProvider.build());
    }

    public long p(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return 0L;
        }
        return adDownloadModelEc.getId();
    }

    public String pc(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getMd5();
    }

    public long jw(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return 0L;
        }
        return adDownloadModelEc.getExpectFileLength();
    }

    public long f(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return 0L;
        }
        return adDownloadModelEc.getExtraValue();
    }

    public String ul(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getDownloadUrl();
    }

    public List<String> az(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.getBackupUrls();
    }

    public String m(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getNotificationJumpUrl();
    }

    public String lm(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getName();
    }

    public String e(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getMimeType();
    }

    public Map<String, String> k(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.getHeaders();
    }

    public boolean eg(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return true;
        }
        return adDownloadModelEc.isShowToast();
    }

    public boolean fm(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return true;
        }
        return adDownloadModelEc.isShowNotification();
    }

    public boolean xn(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return false;
        }
        return adDownloadModelEc.isNeedWifi();
    }

    public boolean il(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return false;
        }
        return adDownloadModelEc.isInExternalPublicDir();
    }

    public boolean qf(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return false;
        }
        return adDownloadModelEc.isInExternalPublicDir();
    }

    public String l(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getFilePath();
    }

    public String am(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getFileName();
    }

    public void sa(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.forceWifi();
    }

    public JSONObject tz(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.getDownloadSettings();
    }

    public void ti(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.forceHideToast();
    }

    public void s(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.forceHideNotification();
    }

    public boolean v(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return false;
        }
        return adDownloadModelEc.needIndependentProcess();
    }

    public int qk(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return 0;
        }
        return adDownloadModelEc.getVersionCode();
    }

    public String vm(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getVersionName();
    }

    public boolean zf(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return true;
        }
        return adDownloadModelEc.isAd();
    }

    public String rt(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getLogExtra();
    }

    public String vy(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getPackageName();
    }

    public String sk(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getAppIcon();
    }

    public DeepLink gy(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.getDeepLink();
    }

    public List<String> vl(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.getClickTrackUrl();
    }

    public JSONObject qr(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.getExtra();
    }

    public int ce(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return 0;
        }
        return adDownloadModelEc.getModelType();
    }

    public com.ss.android.download.api.model.d jm(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.getQuickAppModel();
    }

    public boolean bz(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return false;
        }
        return adDownloadModelEc.autoInstallWithoutNotification();
    }

    public boolean jy(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return com.ss.android.download.api.ah.xr.ms(com.ss.android.socialbase.downloader.ab.ms.ms(tz(i)), e(i));
        }
        return adDownloadModelEc.shouldDownloadWithPatchApply();
    }

    public int j(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return 2;
        }
        return adDownloadModelEc.getExecutorGroup();
    }

    public int ih(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return 1;
        }
        return adDownloadModelEc.getFunnelType();
    }

    public String oh(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getStartToast();
    }

    public String zd(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        return adDownloadModelEc == null ? "" : adDownloadModelEc.getStartToast();
    }

    public boolean z(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return true;
        }
        return adDownloadModelEc.isAutoInstall();
    }

    public boolean tk(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return false;
        }
        return adDownloadModelEc.distinctDir();
    }

    public boolean nn(int i) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return true;
        }
        return adDownloadModelEc.enablePause();
    }

    public void ka(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.setMd5(str);
    }

    public void ms(int i, long j) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.setExpectFileLength(j);
    }

    public void d(int i, boolean z) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.setNeedWifi(z);
    }

    public void ka(int i, boolean z) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.setIsShowToast(z);
    }

    public void xr(int i, long j) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.setExtraValue(j);
    }

    public void c(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.setAppName(str);
    }

    public void d(int i, JSONObject jSONObject) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.setExtra(jSONObject);
    }

    public void ab(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.setStartToast(str);
    }

    public void x(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return;
        }
        adDownloadModelEc.setSdkMonitorScene(str);
    }

    public AdDownloadModel ah(int i, long j) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setId(j);
    }

    public AdDownloadModel c(int i, boolean z) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setIsAd(z);
    }

    public AdDownloadModel ah(int i, int i2) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setModelType(i2);
    }

    public AdDownloadModel ny(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setLogExtra(str);
    }

    public AdDownloadModel ch(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setPackageName(str);
    }

    public AdDownloadModel hi(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setAppIcon(str);
    }

    public AdDownloadModel ms(int i, List<String> list) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setClickTrackUrl(list);
    }

    public AdDownloadModel sl(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setDownloadUrl(str);
    }

    public AdDownloadModel xr(int i, List<String> list) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setBackupUrls(list);
    }

    public AdDownloadModel zb(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setNotificationJumpUrl(str);
    }

    public AdDownloadModel u(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setMimeType(str);
    }

    public AdDownloadModel ms(int i, Map<String, String> map) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setHeaders(map);
    }

    public AdDownloadModel ab(int i, boolean z) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setIsShowNotification(z);
    }

    public AdDownloadModel ub(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setFilePath(str);
    }

    public AdDownloadModel ao(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setFileName(str);
    }

    public AdDownloadModel x(int i, boolean z) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setNeedIndependentProcess(z);
    }

    public AdDownloadModel d(int i, int i2) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setVersionCode(i2);
    }

    public AdDownloadModel h(int i, String str) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setVersionName(str);
    }

    public AdDownloadModel ms(int i, com.ss.android.download.api.model.d dVar) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setQuickAppModel(dVar);
    }

    public AdDownloadModel ny(int i, boolean z) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setAutoInstallWithoutNotification(z);
    }

    public AdDownloadModel ka(int i, int i2) {
        AdDownloadModel adDownloadModelEc = ec(i);
        if (adDownloadModelEc == null) {
            return null;
        }
        return adDownloadModelEc.setFunnelType(i2);
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Map<String, Object> map;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        int iIntValue = valueSetXr.intValue(-99999987);
        Class cls = (Class) valueSetXr.objectValue(-99999985, Class.class);
        if (iIntValue == 20) {
            ms((Bundle) valueSetXr.objectValue(0, Bundle.class));
            return null;
        }
        if (iIntValue == -99999986) {
            return com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ah.f3903ms).ms(1, Boolean.valueOf(ah.xr)).ms(10000, 3).xr().sparseArray();
        }
        if (valueSetXr.objectValue(0, Map.class) != null) {
            map = (Map) valueSetXr.objectValue(0, Map.class);
        } else {
            map = new HashMap<>();
        }
        return ms(cls, iIntValue, map);
    }
}
