package com.byazt.mg;

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
@com.byazt.vzx.pr(pr = {0, 1, 860, 37})
public class pr extends ContextWrapper {
    public File c;
    public File fw;
    public File hn;
    public File hw;
    public final Object pr;
    public File uc;
    public File x;
    public File zo;

    public pr(Context context) {
        super(context);
        this.pr = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File filePr;
        if (pr() == null) {
            return super.getDataDir();
        }
        synchronized (this.pr) {
            if (this.hw == null) {
                this.hw = new File(hw(), pr());
            }
            filePr = pr(this.hw);
        }
        return filePr;
    }

    public String pr() {
        return "pangle_com.byted.pangle";
    }

    public File hw() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File filePr;
        if (pr() == null) {
            return super.getFilesDir();
        }
        synchronized (this.pr) {
            if (this.hn == null) {
                this.hn = new File(super.getFilesDir(), pr());
            }
            filePr = pr(this.hn);
        }
        return filePr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        if (pr() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(pr(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        if (i != 0 || pr() == null) {
            return super.openFileOutput(str, i);
        }
        return new FileOutputStream(pr(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return pr(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File filePr;
        if (pr() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.pr) {
            if (this.x == null) {
                this.x = new File(super.getNoBackupFilesDir(), pr());
            }
            filePr = pr(this.x);
        }
        return filePr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (pr() == null) {
            return super.getExternalFilesDir(str);
        }
        return pr(new File(super.getExternalFilesDir(str), pr()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (pr() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i = 0; i < externalFilesDirs.length; i++) {
            fileArr[i] = pr(new File(externalFilesDirs[i], pr()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File filePr;
        if (pr() == null) {
            return super.getObbDir();
        }
        synchronized (this.pr) {
            if (this.c == null) {
                this.c = new File(super.getObbDir(), pr());
            }
            filePr = pr(this.c);
        }
        return filePr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (pr() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i = 0; i < obbDirs.length; i++) {
            fileArr[i] = pr(new File(obbDirs[i], pr()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File filePr;
        if (pr() == null) {
            return super.getCacheDir();
        }
        synchronized (this.pr) {
            if (this.uc == null) {
                this.uc = new File(super.getCacheDir(), pr());
            }
            filePr = pr(this.uc);
        }
        return filePr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File filePr;
        if (pr() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.pr) {
            if (this.fw == null) {
                this.fw = new File(super.getCodeCacheDir(), pr());
            }
            filePr = pr(this.fw);
        }
        return filePr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File filePr;
        if (pr() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.pr) {
            if (this.zo == null) {
                this.zo = new File(super.getExternalCacheDir(), pr());
            }
            filePr = pr(this.zo);
        }
        return filePr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (pr() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i = 0; i < externalCacheDirs.length; i++) {
            fileArr[i] = pr(new File(externalCacheDirs[i], pr()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (pr() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i = 0; i < externalMediaDirs.length; i++) {
            fileArr[i] = pr(new File(externalMediaDirs[i], pr()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        if (i != 0 || pr() == null) {
            return super.getDir(str, i);
        }
        return pr(new File(super.getDir(str, i), pr()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        if (i != 0 || pr() == null) {
            return super.getSharedPreferences(str, i);
        }
        return super.getSharedPreferences(pr(str), i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (pr() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(pr(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        if (i != 0 || pr() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory);
        }
        return super.openOrCreateDatabase(pr(str), i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i != 0 || pr() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(pr(str), i, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (pr() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        if (pr() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(pr(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (pr() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(pr(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (pr() == null) {
            return super.databaseList();
        }
        String[] strArrDatabaseList = super.databaseList();
        int length = strArrDatabaseList.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < strArrDatabaseList.length; i2++) {
            if (strArrDatabaseList[i2].startsWith(pr())) {
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

    private String pr(String str) {
        return pr() + "_" + str;
    }

    private static File pr(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File pr(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }
}
