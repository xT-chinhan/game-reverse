package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.byazt.wo.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ContentProviderManager {
    public static final String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final String PLUGIN_PROCESS_NAME = "process_name";
    public static final String PROVIDER_PARAM_FEILD = "provider_params";
    public static final String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final String PROVIDER_URI = "uri";
    public static ContentProviderManager sInstance = null;
    public final Map<hw, pr> mContentProviderMap = new HashMap();
    public final Map<String, String> mAuthorityProcessNameMap = new HashMap();
    public final Map<String, hn> mSystemProviderInfoMap = new HashMap();

    @com.byazt.vzx.pr(pr = {0, 78, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 1145, 1154})
    public static class hw {
        public final String hn;
        public final String hw;
        public final String pr;

        public hw(String str, String str2, String str3) {
            this.pr = str2;
            this.hw = str3;
            this.hn = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof hw)) {
                return false;
            }
            hw hwVar = (hw) obj;
            return TextUtils.equals(this.hn, hwVar.hn) && TextUtils.equals(this.hw, hwVar.hw) && TextUtils.equals(this.pr, hwVar.pr);
        }

        public int hashCode() {
            return Build.VERSION.SDK_INT >= 19 ? Objects.hash(this.pr, this.hw, this.hn) : (this.pr + this.hw + this.pr).hashCode();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 78, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 1145, 1153})
    protected static final class hn extends hw {
        public final ProviderInfo x;

        public hn(String str, String str2, ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
            this.x = providerInfo;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 78, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 1145, 1146})
    public static final class pr {
        public final PluginContentProvider hn;
        public final ProviderInfo hw;
        public final hw pr;

        public pr(hw hwVar, ProviderInfo providerInfo, PluginContentProvider pluginContentProvider) {
            this.hw = providerInfo;
            this.pr = hwVar;
            this.hn = pluginContentProvider;
        }
    }

    private ContentProviderManager() {
    }

    public static ContentProviderManager getInstance() {
        if (sInstance == null) {
            synchronized (ContentProviderManager.class) {
                if (sInstance == null) {
                    sInstance = new ContentProviderManager();
                }
            }
        }
        return sInstance;
    }

    public Map<String, hn> getSystemProviderInfoMap() {
        return this.mSystemProviderInfoMap;
    }

    public String getPluginProcessNameByAuthority(String str) {
        return this.mAuthorityProcessNameMap.get(str);
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        return a.a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        return a.a(contentResolver, uri, strArr, str, strArr2, str2, str3);
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        return a.a(contentResolver, uri, strArr, bundle, cancellationSignal, str);
    }

    public String getType(ContentResolver contentResolver, Uri uri, String str) {
        return a.a(contentResolver, uri, str);
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        return a.a(contentResolver, uri, contentValues, str);
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return a.a(contentResolver, uri, contentValues, bundle, str);
    }

    public int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        return a.a(contentResolver, uri, str, strArr, str2);
    }

    public int delete(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        return a.a(contentResolver, uri, bundle, str);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        return a.a(contentResolver, uri, contentValues, str, strArr, str2);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return a.b(contentResolver, uri, contentValues, bundle, str);
    }

    public Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        return a.a(contentResolver, uri, str, str2, bundle, str3);
    }

    public final Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        return a.a(contentResolver, str, str2, str3, bundle, str4);
    }

    public boolean isPluginProvider(Uri uri) {
        if (uri == null) {
            return true;
        }
        String authority = uri.getAuthority();
        Set<String> setKeySet = this.mAuthorityProcessNameMap.keySet();
        return setKeySet != null && setKeySet.contains(authority);
    }

    public PluginContentProvider getPluginProvider(hw hwVar) {
        pr prVar = this.mContentProviderMap.get(hwVar);
        if (prVar == null) {
            return null;
        }
        return prVar.hn;
    }

    public void installContentProviders(Collection<ProviderInfo> collection, Plugin plugin) {
        if (collection == null || collection.size() == 0 || plugin == null) {
            return;
        }
        String strPr = x.pr(x.pr(Zeus.getAppApplication()));
        for (ProviderInfo providerInfo : collection) {
            if (ZeusLogger.isDebug()) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name).append("]");
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, sb.toString());
            }
            installProvider(strPr, providerInfo, plugin);
        }
    }

    private void installProvider(String str, ProviderInfo providerInfo, Plugin plugin) {
        if (providerInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + plugin.mPkgName + "】");
            return;
        }
        if (TextUtils.equals(str, providerInfo.processName)) {
            ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + providerInfo.authority + "] [className:" + providerInfo.name + "]");
            try {
                PluginContentProvider pluginContentProviderInstantiateProvider = instantiateProvider(plugin, providerInfo);
                if (pluginContentProviderInstantiateProvider == null) {
                    return;
                }
                pluginContentProviderInstantiateProvider.attachInfo(ZeusTransformUtils.wrapperContext(plugin.mHostApplication, plugin.mPkgName), providerInfo);
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + providerInfo.name + "]");
                hw hwVar = new hw(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
                this.mContentProviderMap.put(hwVar, new pr(hwVar, providerInfo, pluginContentProviderInstantiateProvider));
            } catch (Exception e) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e);
                return;
            }
        }
        this.mAuthorityProcessNameMap.put(providerInfo.authority, providerInfo.processName);
    }

    private PluginContentProvider instantiateProvider(Plugin plugin, ProviderInfo providerInfo) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Object objNewInstance = plugin.mClassLoader.loadClass(providerInfo.name).newInstance();
        if (objNewInstance instanceof FileProvider) {
            if (providerInfo.metaData == null) {
                throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data. provider:".concat(String.valueOf(objNewInstance)));
            }
            com.byazt.ae.FileProvider.pr(plugin, plugin.mResources.getXml(providerInfo.metaData.getInt("android.support.FILE_PROVIDER_PATHS")));
            return null;
        }
        return (PluginContentProvider) objNewInstance;
    }

    public void initSystemContentProviderInfo() {
        GlobalParam.getInstance().getReporter().pr("zeus_stage_content_provider", TrackAction.START);
        try {
            ProviderInfo[] providerInfoArr = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;
            if (providerInfoArr != null && providerInfoArr.length != 0) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (providerInfo != null && providerInfo.authority != null && providerInfo.authority.contains(".pangle.provider.proxy.")) {
                        try {
                            ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                            if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.provider.proxy.")) {
                                String strPr = x.pr(providerInfo.processName);
                                this.mSystemProviderInfoMap.put(strPr, new hn(Zeus.getAppApplication().getPackageName(), strPr, providerInfo));
                                ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                            }
                        } catch (Exception e) {
                            ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception：", e);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
        }
    }
}
