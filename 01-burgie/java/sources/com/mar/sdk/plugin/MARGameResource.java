package com.mar.sdk.plugin;

import android.text.TextUtils;
import com.mar.sdk.IGameResource;
import com.mar.sdk.MARCallBack;
import com.mar.sdk.base.PluginFactory;
import com.mar.sdk.log.Log;

/* JADX INFO: loaded from: classes2.dex */
public class MARGameResource {
    private static MARGameResource instance;
    private IGameResource iGameResource;

    private MARGameResource() {
    }

    public static MARGameResource getInstance() {
        if (instance == null) {
            instance = new MARGameResource();
        }
        return instance;
    }

    public void init() {
        this.iGameResource = (IGameResource) PluginFactory.getInstance().initPlugin(11);
    }

    public void getDownloadUrl(String gameVersion, MARCallBack callBack) {
        if (this.iGameResource == null) {
            Log.w("MARSDK", "not support game resource plugin");
            return;
        }
        if (callBack == null) {
            Log.w("MARSDK", "the MARCallBack can not null");
        } else if (gameVersion == null || TextUtils.isEmpty(gameVersion)) {
            Log.w("MARSDK", "the gameVersion can not null");
        } else {
            this.iGameResource.getDownloadUrl(gameVersion, callBack);
        }
    }
}
