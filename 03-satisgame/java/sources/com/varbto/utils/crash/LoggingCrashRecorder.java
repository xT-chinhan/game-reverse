package com.varbto.utils.crash;

import android.content.Context;
import android.util.Log;
import com.varbto.internal.f;
import com.varbto.internal.g;
import com.varbto.internal.h;
import com.varbto.internal.i;
import com.varbto.utils.api.UtilConst;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class LoggingCrashRecorder implements CrashRecorder {
    public final boolean a;
    public final File b;
    public final i c;

    public LoggingCrashRecorder(Context context, boolean z) {
        this.a = z;
        if (f.a) {
            Log.d("LoggingCrashRecorder", "LoggingCrashRecorder created, saveStackTrace: " + z);
        }
        File file = new File(context.getFilesDir(), "crash_reports");
        this.b = file;
        if (!file.exists()) {
            if (file.mkdirs()) {
                if (f.a) {
                    Log.d("LoggingCrashRecorder", "Crash report directory created successfully: " + file.getAbsolutePath());
                }
            } else if (f.a) {
                Log.e("LoggingCrashRecorder", "Failed to create Crash report directory");
            }
        }
        this.c = i.a(context);
    }

    public static void a(File file, CrashReport crashReport, Throwable th) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        try {
            fileWriter.write("=== Crash Report ===\n");
            fileWriter.write("Time: " + new Date() + "\n");
            fileWriter.write("Error ID: " + (crashReport != null ? crashReport.getErrorId() : "Unknown") + "\n");
            fileWriter.write("Category: " + (crashReport != null ? crashReport.getCategory() : g.e) + "\n");
            fileWriter.write("Confidence: " + (crashReport != null ? crashReport.getConfidence() : 0) + "\n");
            fileWriter.write("MatchedType: " + (crashReport != null ? crashReport.getMatchedType() : "None") + "\n");
            fileWriter.write("MatchedPackage: " + (crashReport != null ? crashReport.getMatchedPackage() : "None") + "\n");
            fileWriter.write("Exception: " + th.getClass().getName() + "\n");
            fileWriter.write("Message: " + (th.getMessage() != null ? th.getMessage() : AbstractJsonLexerKt.NULL) + "\n");
            fileWriter.write("\n");
            fileWriter.write("=== Final Trigger Point ===\n");
            fileWriter.write(a(th).concat("\n\n"));
            fileWriter.write("=== Stack Trace (Top) ===\n");
            StackTraceElement[] stackTrace = th.getStackTrace();
            char c = 3;
            if (stackTrace == null || stackTrace.length <= 0) {
                fileWriter.write("No stack trace information\n");
            } else {
                int iMin = Math.min(stackTrace.length, 64);
                for (int i = 0; i < iMin; i++) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    fileWriter.write(String.format(Locale.US, "%02d. %s.%s(%s:%d)\n", Integer.valueOf(i), stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName() != null ? stackTraceElement.getFileName() : "Unknown", Integer.valueOf(stackTraceElement.getLineNumber())));
                }
            }
            fileWriter.write("\n");
            fileWriter.write("=== Cause Chain ===\n");
            Throwable cause = th.getCause();
            int i2 = 0;
            while (cause != null) {
                Locale locale = Locale.US;
                fileWriter.write("Cause[" + i2 + "]: " + cause.getClass().getName() + " - " + String.valueOf(cause.getMessage()) + "\n");
                StackTraceElement[] stackTrace2 = cause.getStackTrace();
                int iMin2 = Math.min(stackTrace2 != null ? stackTrace2.length : 0, 32);
                int i3 = 0;
                while (i3 < iMin2) {
                    StackTraceElement stackTraceElement2 = stackTrace2[i3];
                    fileWriter.write(String.format(Locale.US, "  %02d. %s.%s(%s:%d)\n", Integer.valueOf(i3), stackTraceElement2.getClassName(), stackTraceElement2.getMethodName(), stackTraceElement2.getFileName() != null ? stackTraceElement2.getFileName() : "Unknown", Integer.valueOf(stackTraceElement2.getLineNumber())));
                    i3++;
                    c = 3;
                }
                fileWriter.write("\n");
                cause = cause.getCause();
                i2++;
                c = c;
            }
            fileWriter.write("=== End of Report ===\n");
            fileWriter.close();
        } catch (Throwable th2) {
            try {
                fileWriter.close();
                throw th2;
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
                throw th2;
            }
        }
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public void cleanupOldFiles(int i) {
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public int getCrashCountWithinDays(int i) {
        return this.c.a(i);
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public int getCrashFileCount() {
        return getCrashFileList().size();
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public List<File> getCrashFileList() {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        File file = this.b;
        if (file == null || !file.exists() || (fileArrListFiles = this.b.listFiles()) == null || fileArrListFiles.length <= 0) {
            return arrayList;
        }
        Arrays.sort(fileArrListFiles, new Comparator() { // from class: com.varbto.utils.crash.LoggingCrashRecorder$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            }
        });
        return Arrays.asList(fileArrListFiles);
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public JSONArray getCrashTimestampsWithinDays(int i) {
        return this.c.d(i);
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public void markFileSent(String str, String str2) {
        if (f.a) {
            Log.d("LoggingCrashRecorder", "Marking crash file as sent: " + str + " for SDK: " + str2);
        }
        try {
            this.c.b(Long.parseLong(str), str2, new h() { // from class: com.varbto.utils.crash.LoggingCrashRecorder$$ExternalSyntheticLambda0
                @Override // com.varbto.internal.h
                public final void a(long j) {
                    this.f$0.a(j);
                }
            });
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public void recordCrash(CrashReport crashReport, Throwable th) {
        String str = System.currentTimeMillis() + "";
        File file = new File(this.b, str);
        try {
            if (!this.a || th == null) {
                a(file);
                if (f.a) {
                    Log.i("LoggingCrashRecorder", "Crash empty file created: " + file.getName());
                }
            } else {
                a(file, crashReport, th);
                if (f.a) {
                    Log.i("LoggingCrashRecorder", "Crash stack trace saved to file: " + file.getName());
                }
            }
            this.c.c(Long.parseLong(str), crashReport != null ? crashReport.getCategory().name() : UtilConst.CRASH_CAT_UNKNOWN);
        } catch (Throwable th2) {
            if (f.a) {
                Log.e("LoggingCrashRecorder", "Failed to save Crash file: " + th2.getMessage(), th2);
            }
        }
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public int getCrashCountWithinDays(String str, int i) {
        return this.c.a(i, str);
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public JSONArray getCrashTimestampsWithinDays(String str, int i) {
        return this.c.b(i, str);
    }

    @Override // com.varbto.utils.crash.CrashRecorder
    public List<File> getCrashFileList(String str) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        File file = this.b;
        if (file == null || !file.exists() || (fileArrListFiles = this.b.listFiles()) == null) {
            return arrayList;
        }
        HashSet hashSetA = this.c.a(str);
        Arrays.sort(fileArrListFiles, new Comparator() { // from class: com.varbto.utils.crash.LoggingCrashRecorder$$ExternalSyntheticLambda3
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

    @Override // com.varbto.utils.crash.CrashRecorder
    public List<File> getCrashFileList(String str, String str2) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        File file = this.b;
        if (file == null || !file.exists() || (fileArrListFiles = this.b.listFiles()) == null) {
            return arrayList;
        }
        HashSet hashSetA = this.c.a(str, str2);
        Arrays.sort(fileArrListFiles, new Comparator() { // from class: com.varbto.utils.crash.LoggingCrashRecorder$$ExternalSyntheticLambda1
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

    public static String a(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return "Unknown trigger";
        }
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                if (className != null && !className.startsWith("android.") && !className.startsWith("java.") && !className.startsWith("kotlin.")) {
                    Locale locale = Locale.US;
                    return stackTraceElement.getClassName() + com.anythink.core.common.d.i.E + stackTraceElement.getMethodName() + "(" + (stackTraceElement.getFileName() != null ? stackTraceElement.getFileName() : "Unknown") + ":" + stackTraceElement.getLineNumber() + ")";
                }
                i++;
            } else {
                StackTraceElement stackTraceElement2 = stackTrace[0];
                Locale locale2 = Locale.US;
                return stackTraceElement2.getClassName() + com.anythink.core.common.d.i.E + stackTraceElement2.getMethodName() + "(" + (stackTraceElement2.getFileName() != null ? stackTraceElement2.getFileName() : "Unknown") + ":" + stackTraceElement2.getLineNumber() + ")";
            }
        }
    }

    public static void a(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        try {
            fileWriter.write("Crash detected but stack trace not saved (configured not to save)\n");
            fileWriter.write("Generated at: " + new Date() + "\n");
            fileWriter.close();
        } catch (Throwable th) {
            try {
                fileWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final /* synthetic */ void a(long j) {
        File file = new File(this.b, String.valueOf(j));
        if (file.exists()) {
            if (f.a) {
                Log.d("LoggingCrashRecorder", "Deleting crash file: " + file.getName());
            }
            file.delete();
        }
    }
}
