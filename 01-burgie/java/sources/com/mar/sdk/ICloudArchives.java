package com.mar.sdk;

/* JADX INFO: loaded from: classes2.dex */
public interface ICloudArchives {
    void clearGameArchive(int i, MARCloudCallBack mARCloudCallBack);

    void getGameArchive(int i, MARCloudCallBack mARCloudCallBack);

    void updateGameArchive(String str, int i, MARCloudCallBack mARCloudCallBack);
}
