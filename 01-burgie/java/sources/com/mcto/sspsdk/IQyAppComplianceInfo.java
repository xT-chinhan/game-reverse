package com.mcto.sspsdk;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IQyAppComplianceInfo {
    Map<String, String> getAllInfoKV();

    String getAppName();

    List<String> getFixInfoList();

    Map<String, String> getLinkInfoMap();
}
