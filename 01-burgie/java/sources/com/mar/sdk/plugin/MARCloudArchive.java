package com.mar.sdk.plugin;

import com.mar.sdk.ICloudArchives;
import com.mar.sdk.MARCloudCallBack;
import com.mar.sdk.base.PluginFactory;
import com.mar.sdk.log.Log;
import com.mar.sdk.verify.UGameArchive;

/* JADX INFO: loaded from: classes2.dex */
public class MARCloudArchive {
    private static MARCloudArchive instance;
    private ICloudArchives iCloudArchives;

    private MARCloudArchive() {
    }

    public static MARCloudArchive getInstance() {
        if (instance == null) {
            instance = new MARCloudArchive();
        }
        return instance;
    }

    public void init() {
        this.iCloudArchives = (ICloudArchives) PluginFactory.getInstance().initPlugin(10);
    }

    public void updateGameArchive(String gameArchive, int serialNumber, MARCloudCallBack callBack) {
        if (this.iCloudArchives == null) {
            Log.w("MARSDK", "updateGameArchive: not support cloud archive plugin");
        } else {
            this.iCloudArchives.updateGameArchive(gameArchive, serialNumber, callBack);
        }
    }

    public void getGameArchive(int serialNumber, MARCloudCallBack callBack) {
        if (callBack == null) {
            Log.d("MARSDK", "MARCallBack can not null");
        } else if (this.iCloudArchives == null) {
            Log.w("MARSDK", "not support cloud archive plugin now");
            callBack.onCloudResult(new UGameArchive(400, serialNumber, ""));
        } else {
            this.iCloudArchives.getGameArchive(serialNumber, callBack);
        }
    }

    public void clearGameArchive(int serialNumber, MARCloudCallBack callBack) {
        if (callBack == null) {
            Log.d("MARSDK", "MARCallBack can not null");
        } else if (this.iCloudArchives == null) {
            Log.w("MARSDK", "not support cloud archive plugin now");
            callBack.onCloudResult(new UGameArchive(400, serialNumber, ""));
        } else {
            this.iCloudArchives.clearGameArchive(serialNumber, callBack);
        }
    }
}
