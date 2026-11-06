package com.varbto.utils.crash;

import java.io.File;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public interface CrashRecorder {
    void cleanupOldFiles(int i);

    int getCrashCountWithinDays(int i);

    int getCrashCountWithinDays(String str, int i);

    int getCrashFileCount();

    List<File> getCrashFileList();

    List<File> getCrashFileList(String str);

    List<File> getCrashFileList(String str, String str2);

    JSONArray getCrashTimestampsWithinDays(int i);

    JSONArray getCrashTimestampsWithinDays(String str, int i);

    void markFileSent(String str, String str2);

    void recordCrash(CrashReport crashReport, Throwable th);
}
