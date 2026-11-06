package com.kwad.sdk.api.proxy.app;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.loader.ApiLogger;
import com.kwad.sdk.api.loader.ApiSpUtils;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdSdkFileProvider extends FileProvider {
    private static final String SP_INSTALLER_CHECK_PKG_AB_SWITCH = "installerCheckPkgAbSwitch";
    private static final String SP_INSTALLER_EXTRA_PKGS_KEY = "installerCheckExtraPkgs";
    private static final String SP_OPEN_FILE_RECORD = "SP_OPEN_FILE_RECORD";
    private static final String TAG = "AdSdkFileProvider";
    public static long sLaunchTime;
    private static Set<String> sSystemInstallers;

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        sSystemInstallers = copyOnWriteArraySet;
        copyOnWriteArraySet.add("com.android.packageinstaller");
        sSystemInstallers.add("com.google.android.packageinstaller");
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        boolean zContains;
        String string;
        ApiLogger.d(TAG, "openFile uri:" + uri + " mode:" + str);
        if (isInstallerPkgCheckOpen()) {
            checkLocalConfig();
            String callingPackage = getCallingPackage();
            zContains = sSystemInstallers.contains(callingPackage);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callingPkg", callingPackage);
                jSONObject.put("checkResult", String.valueOf(zContains));
                jSONObject.put(ContentProviderManager.PROVIDER_URI, uri.toString());
                String string2 = ApiSpUtils.getString(getContext(), SP_OPEN_FILE_RECORD, "");
                if (!TextUtils.isEmpty(string2)) {
                    JSONArray jSONArray = new JSONArray(string2);
                    jSONArray.put(jSONObject);
                    string = jSONArray.toString();
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONObject);
                    string = jSONArray2.toString();
                }
                ApiLogger.d(TAG, "openFile saveRecord:" + string);
                ApiSpUtils.setString(getContext(), SP_OPEN_FILE_RECORD, string);
            } catch (Throwable unused) {
            }
        } else {
            zContains = true;
        }
        if (zContains) {
            return super.openFile(uri, str);
        }
        return null;
    }

    private void checkLocalConfig() {
        try {
            String string = ApiConfigUtils.readString(getContext(), SP_INSTALLER_EXTRA_PKGS_KEY, "");
            ApiLogger.d(TAG, "checkLocalConfig extraPkgs:" + string);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String decodeString = getDecodeString(string);
            ApiLogger.d(TAG, "checkLocalConfig extraPkgs decoded: " + decodeString);
            JSONArray jSONArray = new JSONArray(decodeString);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string2 = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string2)) {
                    sSystemInstallers.add(string2);
                }
            }
        } catch (Throwable th) {
            ApiLogger.printStackTrace(th);
        }
    }

    private static String getDecodeString(String str) {
        return (TextUtils.isEmpty(str) || !ApiBase64.isEncodeKsSdk(str)) ? str : ApiBase64.decodeKsSdk(str);
    }

    private boolean isInstallerPkgCheckOpen() {
        try {
            int i = ApiConfigUtils.readInt(getContext(), SP_INSTALLER_CHECK_PKG_AB_SWITCH, 0);
            ApiLogger.d(TAG, "isInstallerPkgCheckOpen abSwitch:" + i);
            return i == 1;
        } catch (Throwable th) {
            ApiLogger.printStackTrace(th);
            return false;
        }
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        sLaunchTime = System.currentTimeMillis();
        try {
            KSLifecycleObserver.getInstance().init(getContext().getApplicationContext());
        } catch (Throwable unused) {
        }
        return super.onCreate();
    }
}
