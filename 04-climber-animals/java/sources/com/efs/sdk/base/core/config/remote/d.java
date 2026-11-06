package com.efs.sdk.base.core.config.remote;

import android.content.SharedPreferences;
import com.anythink.core.common.m.e;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile SharedPreferences a;

    final boolean a(RemoteConfig remoteConfig) {
        c();
        if (this.a == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.clear();
        editorEdit.putInt("cver", remoteConfig.mConfigVersion);
        editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : remoteConfig.mSDKConfigMap.entrySet()) {
            editorEdit.putString(entry.getKey(), entry.getValue());
        }
        editorEdit.putString(e.X, remoteConfig.a);
        editorEdit.apply();
        return true;
    }

    static boolean a() {
        GlobalEnvStruct globalEnvStruct = ControllerCenter.getGlobalEnvStruct();
        File fileB = com.efs.sdk.base.core.util.a.b(globalEnvStruct.mAppContext, globalEnvStruct.getAppid());
        if (!fileB.exists()) {
            return false;
        }
        FileUtil.delete(fileB);
        return true;
    }

    static void b() {
        File fileA = com.efs.sdk.base.core.util.a.a(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileA.exists()) {
            fileA.delete();
        }
    }

    final void c() {
        try {
            d();
        } catch (Throwable th) {
            Log.e("efs.config", "init sharedpreferences error", th);
        }
    }

    private void d() {
        if (this.a == null) {
            synchronized (com.efs.sdk.base.core.b.c.class) {
                if (this.a == null) {
                    this.a = SharedPreferencesUtils.getSharedPreferences(ControllerCenter.getGlobalEnvStruct().mAppContext, EncodeUtil.base64EncodeToStr(("config_" + ControllerCenter.getGlobalEnvStruct().getAppid().toLowerCase()).getBytes()));
                    this.a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (h.a.a.a()) {
            return;
        }
        b.a().b();
    }
}
