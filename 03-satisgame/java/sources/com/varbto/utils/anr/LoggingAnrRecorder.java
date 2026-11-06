package com.varbto.utils.anr;

import android.content.Context;
import android.util.Log;
import com.varbto.internal.b;
import com.varbto.internal.c;
import com.varbto.internal.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class LoggingAnrRecorder implements AnrRecorder {
    public final File a;
    public final c b;

    public LoggingAnrRecorder(Context context, boolean z) {
        if (f.a) {
            Log.d("LoggingAnrRecorder", "LoggingAnrRecorder created, saveStackTrace: " + z);
        }
        File file = new File(context.getFilesDir(), "anr_reports");
        this.a = file;
        if (!file.exists()) {
            if (file.mkdirs()) {
                if (f.a) {
                    Log.d("LoggingAnrRecorder", "ANR report directory created successfully: " + file.getAbsolutePath());
                }
            } else if (f.a) {
                Log.e("LoggingAnrRecorder", "Failed to create ANR report directory");
            }
        }
        this.b = c.a(context);
    }

    @Override // com.varbto.utils.anr.AnrRecorder
    public void cleanupOldFiles(int i) {
    }

    @Override // com.varbto.utils.anr.AnrRecorder
    public int getAnrCountWithinDays(int i) {
        return this.b.a(i);
    }

    @Override // com.varbto.utils.anr.AnrRecorder
    public int getAnrFileCount() {
        return getAnrFileList().size();
    }

    @Override // com.varbto.utils.anr.AnrRecorder
    public List<File> getAnrFileList() {
        if (f.a) {
            Log.d("LoggingAnrRecorder", "Getting ANR file list");
        }
        List<File> arrayList = new ArrayList<>();
        File file = this.a;
        if (file != null && file.exists()) {
            File[] fileArrListFiles = this.a.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                Arrays.sort(fileArrListFiles, new Comparator() { // from class: com.varbto.utils.anr.LoggingAnrRecorder$$ExternalSyntheticLambda2
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
                    }
                });
                arrayList = Arrays.asList(fileArrListFiles);
            }
            if (f.a) {
                Log.d("LoggingAnrRecorder", "Found " + arrayList.size() + " ANR files");
            }
        }
        return arrayList;
    }

    @Override // com.varbto.utils.anr.AnrRecorder
    public JSONArray getAnrTimestampsWithinDays(int i) {
        return this.b.b(i);
    }

    @Override // com.varbto.utils.anr.AnrRecorder
    public void markFileSent(String str, String str2) {
        if (f.a) {
            Log.d("LoggingAnrRecorder", "Marking file as sent: " + str + " for SDK: " + str2);
        }
        try {
            this.b.b(Long.parseLong(str), str2, new b() { // from class: com.varbto.utils.anr.LoggingAnrRecorder$$ExternalSyntheticLambda0
                @Override // com.varbto.internal.b
                public final void a(long j) {
                    this.f$0.a(j);
                }
            });
        } catch (NumberFormatException unused) {
        }
    }

    public final /* synthetic */ void a(long j) {
        File file = new File(this.a, String.valueOf(j));
        if (file.exists()) {
            if (f.a) {
                Log.d("LoggingAnrRecorder", "Deleting ANR file: " + file.getName());
            }
            file.delete();
        }
    }

    @Override // com.varbto.utils.anr.AnrRecorder
    public List<File> getAnrFileList(String str) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        File file = this.a;
        if (file == null || !file.exists() || (fileArrListFiles = this.a.listFiles()) == null) {
            return arrayList;
        }
        HashSet hashSetA = this.b.a(str);
        Arrays.sort(fileArrListFiles, new Comparator() { // from class: com.varbto.utils.anr.LoggingAnrRecorder$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            }
        });
        for (File file2 : fileArrListFiles) {
            if (file2.exists()) {
                try {
                    if (hashSetA.contains(Long.valueOf(Long.parseLong(file2.getName())))) {
                        arrayList.add(file2);
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }
}
