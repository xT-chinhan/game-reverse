package com.byazt.qyu;

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
@com.byazt.cp.n(n = {0, 1, 1178, 19})
public class n extends ContextWrapper {
    public File fs;
    public File l;
    public final Object n;
    public File q;
    public File qg;
    public File s;
    public File w;
    public File x;

    public String n() {
        return "pangle_com.byted.pangle";
    }

    public n(Context context) {
        super(context);
        this.n = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File fileN;
        if (n() == null) {
            return super.getDataDir();
        }
        synchronized (this.n) {
            if (this.qg == null) {
                this.qg = new File(qg(), n());
            }
            fileN = n(this.qg);
        }
        return fileN;
    }

    public File qg() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File fileN;
        if (n() == null) {
            return super.getFilesDir();
        }
        synchronized (this.n) {
            if (this.s == null) {
                this.s = new File(super.getFilesDir(), n());
            }
            fileN = n(this.s);
        }
        return fileN;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        if (n() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(n(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        if (i != 0 || n() == null) {
            return super.openFileOutput(str, i);
        }
        return new FileOutputStream(n(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return n(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File fileN;
        if (n() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.n) {
            if (this.q == null) {
                this.q = new File(super.getNoBackupFilesDir(), n());
            }
            fileN = n(this.q);
        }
        return fileN;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (n() == null) {
            return super.getExternalFilesDir(str);
        }
        return n(new File(super.getExternalFilesDir(str), n()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (n() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i = 0; i < externalFilesDirs.length; i++) {
            fileArr[i] = n(new File(externalFilesDirs[i], n()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File fileN;
        if (n() == null) {
            return super.getObbDir();
        }
        synchronized (this.n) {
            if (this.l == null) {
                this.l = new File(super.getObbDir(), n());
            }
            fileN = n(this.l);
        }
        return fileN;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (n() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i = 0; i < obbDirs.length; i++) {
            fileArr[i] = n(new File(obbDirs[i], n()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File fileN;
        if (n() == null) {
            return super.getCacheDir();
        }
        synchronized (this.n) {
            if (this.w == null) {
                this.w = new File(super.getCacheDir(), n());
            }
            fileN = n(this.w);
        }
        return fileN;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File fileN;
        if (n() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.n) {
            if (this.x == null) {
                this.x = new File(super.getCodeCacheDir(), n());
            }
            fileN = n(this.x);
        }
        return fileN;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File fileN;
        if (n() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.n) {
            if (this.fs == null) {
                this.fs = new File(super.getExternalCacheDir(), n());
            }
            fileN = n(this.fs);
        }
        return fileN;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (n() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i = 0; i < externalCacheDirs.length; i++) {
            fileArr[i] = n(new File(externalCacheDirs[i], n()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (n() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i = 0; i < externalMediaDirs.length; i++) {
            fileArr[i] = n(new File(externalMediaDirs[i], n()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        if (i != 0 || n() == null) {
            return super.getDir(str, i);
        }
        return n(new File(super.getDir(str, i), n()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        if (i != 0 || n() == null) {
            return super.getSharedPreferences(str, i);
        }
        return super.getSharedPreferences(n(str), i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (n() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(n(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        if (i != 0 || n() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory);
        }
        return super.openOrCreateDatabase(n(str), i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i != 0 || n() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(n(str), i, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (n() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        if (n() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(n(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (n() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(n(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (n() == null) {
            return super.databaseList();
        }
        String[] strArrDatabaseList = super.databaseList();
        int length = strArrDatabaseList.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < strArrDatabaseList.length; i2++) {
            if (strArrDatabaseList[i2].startsWith(n())) {
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

    private String n(String str) {
        return n() + "_" + str;
    }

    private static File n(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File n(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }
}
