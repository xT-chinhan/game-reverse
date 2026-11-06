package com.varbto.utils.anr;

import java.io.File;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public interface AnrRecorder {
    void cleanupOldFiles(int i);

    int getAnrCountWithinDays(int i);

    int getAnrFileCount();

    List<File> getAnrFileList();

    List<File> getAnrFileList(String str);

    JSONArray getAnrTimestampsWithinDays(int i);

    void markFileSent(String str, String str2);
}
