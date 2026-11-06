package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.byazt.zi.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
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
    public static ContentProviderManager sInstance;
    public final Map<qg, n> mContentProviderMap = new HashMap();
    public final Map<String, String> mAuthorityProcessNameMap = new HashMap();
    public final Map<String, s> mSystemProviderInfoMap = new HashMap();

    @com.byazt.cp.n(n = {0, 55, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 1225, 1226})
    public static class qg {
        public final String n;
        public final String qg;
        public final String s;

        public qg(String str, String str2, String str3) {
            this.n = str2;
            this.qg = str3;
            this.s = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof qg) {
                qg qgVar = (qg) obj;
                if (TextUtils.equals(this.s, qgVar.s) && TextUtils.equals(this.qg, qgVar.qg) && TextUtils.equals(this.n, qgVar.n)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.n, this.qg, this.s);
        }
    }

    @com.byazt.cp.n(n = {0, 55, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 1225, 1924})
    protected static final class s extends qg {
        public final ProviderInfo q;

        public s(String str, String str2, ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
            this.q = providerInfo;
        }
    }

    @com.byazt.cp.n(n = {0, 55, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 1225, 1925})
    public static final class n {
        public final qg n;
        public final ProviderInfo qg;
        public final PluginContentProvider s;

        public n(qg qgVar, ProviderInfo providerInfo, PluginContentProvider pluginContentProvider) {
            this.qg = providerInfo;
            this.n = qgVar;
            this.s = pluginContentProvider;
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

    public Map<String, s> getSystemProviderInfoMap() {
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

    public PluginContentProvider getPluginProvider(qg qgVar) {
        n nVar = this.mContentProviderMap.get(qgVar);
        if (nVar == null) {
            return null;
        }
        return nVar.s;
    }

    public void installContentProviders(Collection<ProviderInfo> collection, Plugin plugin) {
        if (collection == null || collection.size() == 0 || plugin == null) {
            return;
        }
        String strN = q.n(q.n(Zeus.getAppApplication()));
        for (ProviderInfo providerInfo : collection) {
            if (ZeusLogger.isDebug()) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name).append("]");
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, sb.toString());
            }
            installProvider(strN, providerInfo, plugin);
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
                qg qgVar = new qg(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
                this.mContentProviderMap.put(qgVar, new n(qgVar, providerInfo, pluginContentProviderInstantiateProvider));
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
            com.byazt.ry.FileProvider.n(plugin, plugin.mResources.getXml(providerInfo.metaData.getInt("android.support.FILE_PROVIDER_PATHS")));
            return null;
        }
        return (PluginContentProvider) objNewInstance;
    }

    public void initSystemContentProviderInfo() {
        GlobalParam.getInstance().getReporter().n("zeus_stage_content_provider", "start");
        try {
            ProviderInfo[] providerInfoArr = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;
            if (providerInfoArr == null || providerInfoArr.length == 0) {
                return;
            }
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo != null && providerInfo.authority != null && providerInfo.authority.contains(".pangle.provider.proxy.")) {
                    try {
                        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.provider.proxy.")) {
                            String strN = q.n(providerInfo.processName);
                            this.mSystemProviderInfoMap.put(strN, new s(Zeus.getAppApplication().getPackageName(), strN, providerInfo));
                            ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        }
                    } catch (Exception e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception：", e);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
        }
    }
}
