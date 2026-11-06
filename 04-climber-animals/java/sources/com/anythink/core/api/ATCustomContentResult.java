package com.anythink.core.api;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ATCustomContentResult {
    List<ATCustomContentInfo> customContentInfoList;

    public ATCustomContentResult(List<ATCustomContentInfo> list) {
        this.customContentInfoList = list;
    }

    public List<ATCustomContentInfo> getCustomContentInfoList() {
        return this.customContentInfoList;
    }
}
