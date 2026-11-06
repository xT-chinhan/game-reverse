package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ContextWrapper {
    private File ab;
    private File ah;
    private File c;
    private File d;
    private File ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Object f1819ms;
    private File x;
    private File xr;

    protected String ms() {
        return "pangle_com.byted.pangle";
    }

    public ms(Context context) {
        super(context);
        this.f1819ms = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File fileMs;
        if (ms() == null) {
            return super.getDataDir();
        }
        synchronized (this.f1819ms) {
            if (this.xr == null) {
                this.xr = new File(xr(), ms());
            }
            fileMs = ms(this.xr);
        }
        return fileMs;
    }

    public File xr() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File fileMs;
        if (ms() == null) {
            return super.getFilesDir();
        }
        synchronized (this.f1819ms) {
            if (this.ah == null) {
                this.ah = new File(super.getFilesDir(), ms());
            }
            fileMs = ms(this.ah);
        }
        return fileMs;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        if (ms() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(ms(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        if (i != 0 || ms() == null) {
            return super.openFileOutput(str, i);
        }
        return new FileOutputStream(ms(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return ms(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File fileMs;
        if (ms() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.f1819ms) {
            if (this.d == null) {
                this.d = new File(super.getNoBackupFilesDir(), ms());
            }
            fileMs = ms(this.d);
        }
        return fileMs;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (ms() == null) {
            return super.getExternalFilesDir(str);
        }
        return ms(new File(super.getExternalFilesDir(str), ms()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (ms() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i = 0; i < externalFilesDirs.length; i++) {
            fileArr[i] = ms(new File(externalFilesDirs[i], ms()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File fileMs;
        if (ms() == null) {
            return super.getObbDir();
        }
        synchronized (this.f1819ms) {
            if (this.ka == null) {
                this.ka = new File(super.getObbDir(), ms());
            }
            fileMs = ms(this.ka);
        }
        return fileMs;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (ms() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i = 0; i < obbDirs.length; i++) {
            fileArr[i] = ms(new File(obbDirs[i], ms()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File fileMs;
        if (ms() == null) {
            return super.getCacheDir();
        }
        synchronized (this.f1819ms) {
            if (this.c == null) {
                this.c = new File(super.getCacheDir(), ms());
            }
            fileMs = ms(this.c);
        }
        return fileMs;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File fileMs;
        if (ms() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.f1819ms) {
            if (this.ab == null) {
                this.ab = new File(super.getCodeCacheDir(), ms());
            }
            fileMs = ms(this.ab);
        }
        return fileMs;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File fileMs;
        if (ms() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.f1819ms) {
            if (this.x == null) {
                this.x = new File(super.getExternalCacheDir(), ms());
            }
            fileMs = ms(this.x);
        }
        return fileMs;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (ms() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i = 0; i < externalCacheDirs.length; i++) {
            fileArr[i] = ms(new File(externalCacheDirs[i], ms()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (ms() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i = 0; i < externalMediaDirs.length; i++) {
            fileArr[i] = ms(new File(externalMediaDirs[i], ms()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        if (i != 0 || ms() == null) {
            return super.getDir(str, i);
        }
        return ms(new File(super.getDir(str, i), ms()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        if (i != 0 || ms() == null) {
            return super.getSharedPreferences(str, i);
        }
        return super.getSharedPreferences(ms(str), i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (ms() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(ms(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        if (i != 0 || ms() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory);
        }
        return super.openOrCreateDatabase(ms(str), i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i != 0 || ms() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(ms(str), i, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (ms() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        if (ms() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(ms(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (ms() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(ms(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (ms() == null) {
            return super.databaseList();
        }
        String[] strArrDatabaseList = super.databaseList();
        int length = strArrDatabaseList.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < strArrDatabaseList.length; i2++) {
            if (strArrDatabaseList[i2].startsWith(ms())) {
                zArr[i2] = true;
                i++;
            } else {
                zArr[i2] = false;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                strArr[i3] = strArrDatabaseList[i4];
                i3++;
            }
        }
        return strArr;
    }

    private String ms(String str) {
        return ms() + "_" + str;
    }

    private static File ms(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File ms(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }
}
