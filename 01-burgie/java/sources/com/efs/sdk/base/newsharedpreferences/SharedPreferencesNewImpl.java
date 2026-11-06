package com.efs.sdk.base.newsharedpreferences;

import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class SharedPreferencesNewImpl implements SharedPreferences {
    private static final String BACKUP_FILE_SUFFIX = ".bak";
    private static final int CONTENT_LENGTH_LOST = 1;
    private static final int CONTENT_OVER_SIZE = 7;
    private static final int DATA_TYPE_ERROR = 8;
    private static final int DATA_TYPE_INVALID = 9;
    private static final long DELAY_TIME_TO_SAVE = 1000;
    private static final byte FINISH_MARK = 18;
    private static final int FINISH_MARK_LENGTH = 1;
    private static final int ID_LENGTH = 4;
    private static final int INIT_EXCEPTION = 10;
    private static final int LOAD_BAK_FILE = 12;
    private static final int MAPPED_BUFFER_ERROR = 4;
    private static final int MAX_HANDLERTHREAD = 3;
    private static final long MAX_LOCK_FILE_TIME = 10000;
    private static final int MAX_NUM = Integer.MAX_VALUE;
    private static final int MAX_TRY_TIME = 6;
    private static final int MIN_INCREASE_LENGTH = 1024;
    private static final int MODIFY_ID_LOST = 2;
    private static final int OTHER_EXCEPTION = 11;
    private static final String TAG = "SharedPreferencesNew";
    private static final long TRY_RELOAD_INTERVAL = 60;
    private static final int TRY_SAVE_TIME_DELAY = 2000;
    private static final int TYPE_CAST_EXCEPTION = 13;
    private static final int VALUE_LOST = 3;
    private static final Object mFileMonitorSyncObj = new Object();
    private static HandlerThread[] mHandlerThreadPool = new HandlerThread[3];
    private static final int mSaveMessageID = 21310;
    private static ExecutorService sCachedThreadPool;
    private String mBackupFilePath;
    private int mCurTryTime;
    private Vector<SharedPreferences.Editor> mEditorList;
    private OnSharedPreferenceErrorListener mErrorListener;
    private File mFile;
    private FileChannel mFileChannel;
    private FileMonitor mFileMonitor;
    private Handler mHandler;
    private boolean mIsSaving;
    private final ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> mListeners;
    private boolean mLoaded;
    private final LinkedHashMap<String, Object> mMap;
    private MappedByteBuffer mMappedByteBuffer;
    private int mModifyErrorCnt;
    private int mModifyID;
    private RunnableEx mSaveRunnable;
    private final Object mSyncObj;
    private final Object mSyncSaveObj;
    private final Runnable mTryReloadRunnable;
    private long mTryReloadStartTime;

    public interface OnSharedPreferenceErrorListener {
        void onError(String str, int i, long j);
    }

    static {
        for (int i = 0; i < 3; i++) {
            mHandlerThreadPool[i] = new HandlerThread("newsp".concat(String.valueOf(i)));
            mHandlerThreadPool[i].start();
        }
        sCachedThreadPool = Executors.newCachedThreadPool();
    }

    class SUPPORTED_TYPE {
        static final byte TYPE_BOOLEAN = 4;
        static final byte TYPE_FLOAT = 2;
        static final byte TYPE_INT = 1;
        static final byte TYPE_LONG = 3;
        static final byte TYPE_STRING = 5;

        private SUPPORTED_TYPE() {
        }
    }

    public SharedPreferencesNewImpl(File file) {
        this(file, 0, null, false);
    }

    public SharedPreferencesNewImpl(File file, boolean z) {
        this(file, 0, null, z);
    }

    public SharedPreferencesNewImpl(File file, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, 0, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, i, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener, boolean z) {
        this.mMap = new LinkedHashMap<>();
        this.mListeners = new ArrayList<>();
        this.mLoaded = true;
        this.mSyncObj = new Object();
        this.mSyncSaveObj = new Object();
        this.mEditorList = new Vector<>();
        this.mIsSaving = false;
        this.mTryReloadRunnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                int modifyID = SharedPreferencesNewImpl.this.getModifyID();
                if (modifyID > 0 && modifyID != SharedPreferencesNewImpl.this.mModifyID) {
                    SharedPreferencesNewImpl.this.saveInner(false);
                }
            }
        };
        this.mSaveRunnable = new RunnableEx() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferencesNewImpl.this.saveInner(((Boolean) getArg()).booleanValue());
            }
        };
        this.mErrorListener = onSharedPreferenceErrorListener;
        this.mHandler = new Handler(getHandlerThread().getLooper());
        this.mFile = file;
        this.mBackupFilePath = file.getAbsolutePath() + BACKUP_FILE_SUFFIX;
        if (initBuffer()) {
            startLoadFromDisk(z);
        }
        this.mHandler.post(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file2 = new File(SharedPreferencesNewImpl.this.mBackupFilePath);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        HashMap map;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            map = new HashMap(this.mMap);
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    String str3 = (String) this.mMap.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return str2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("putStringSet is not supported!");
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Integer num = (Integer) this.mMap.get(str);
                    if (num != null) {
                        i = num.intValue();
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Long l = (Long) this.mMap.get(str);
                    if (l != null) {
                        j = l.longValue();
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Float f2 = (Float) this.mMap.get(str);
                    if (f2 != null) {
                        f = f2.floatValue();
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Boolean bool = (Boolean) this.mMap.get(str);
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        boolean zContainsKey;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            zContainsKey = this.mMap.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        awaitLoadedLocked();
        return new EditorImpl();
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.add(onSharedPreferenceChangeListener);
                if (this.mFileMonitor == null) {
                    try {
                        File file = new File(this.mBackupFilePath);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.mFileMonitor = new FileMonitor(this.mBackupFilePath, 2);
                }
            }
            synchronized (mFileMonitorSyncObj) {
                this.mFileMonitor.startWatching();
            }
        }
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
                if (this.mFileMonitor != null && this.mListeners.size() <= 0) {
                    this.mFileMonitor.stopWatching();
                }
            }
        }
    }

    public final class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mModified = new HashMap<>();

        public EditorImpl() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this) {
                this.mModified.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new RuntimeException("putStringSet is not supported!");
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this) {
                this.mModified.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this) {
                this.mModified.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this) {
                this.mModified.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.mModified.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            synchronized (this) {
                this.mModified.put(str, null);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            synchronized (this) {
                this.mClear = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            SharedPreferencesNewImpl.this.save(this, false, true, false);
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            SharedPreferencesNewImpl.this.save(this, false, false, true);
        }

        final boolean doClear() {
            boolean z;
            synchronized (this) {
                z = this.mClear;
                this.mClear = false;
            }
            return z;
        }

        final HashMap<String, Object> getAll() {
            HashMap<String, Object> map;
            synchronized (this) {
                map = this.mModified;
            }
            return map;
        }
    }

    private boolean merge(SharedPreferences.Editor editor, Map map, boolean z) {
        if (editor == null) {
            return false;
        }
        EditorImpl editorImpl = (EditorImpl) editor;
        boolean zDoClear = editorImpl.doClear();
        if (zDoClear) {
            map.clear();
            this.mEditorList.clear();
        }
        HashMap<String, Object> all = editorImpl.getAll();
        if (all.size() == 0) {
            return zDoClear;
        }
        synchronized (editor) {
            for (Map.Entry<String, Object> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    map.remove(key);
                } else {
                    if (map.containsKey(key)) {
                        map.remove(key);
                    }
                    map.put(key, value);
                }
                if (!z) {
                    notifyDataChanged(key);
                }
            }
        }
        return true;
    }

    private void notifyDataChanged(String str) {
        if (this.mListeners.size() > 0) {
            for (int i = 0; i < this.mListeners.size(); i++) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.mListeners.get(i);
                if (onSharedPreferenceChangeListener != null) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReload() {
        if (SystemClock.uptimeMillis() - this.mTryReloadStartTime > TRY_RELOAD_INTERVAL) {
            this.mTryReloadStartTime = SystemClock.uptimeMillis();
            this.mHandler.removeCallbacks(this.mTryReloadRunnable);
            this.mHandler.post(this.mTryReloadRunnable);
        }
    }

    private boolean tryReloadWhenSave() throws Throwable {
        int modifyID = getModifyID();
        if (modifyID > 0 && modifyID != this.mModifyID) {
            load(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInner(final boolean z) {
        synchronized (this.mSyncSaveObj) {
            FileLock fileLockLockFile = lockFile(false);
            if (fileLockLockFile != null) {
                try {
                    try {
                        this.mIsSaving = true;
                        if (tryReloadWhenSave()) {
                            mergeWhenReload();
                            notifyDataChanged(null);
                        }
                        synchronized (this.mMap) {
                            if (this.mEditorList.size() <= 0) {
                                try {
                                    fileLockLockFile.release();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                this.mIsSaving = false;
                                return;
                            }
                            saveToMappedBuffer(obtainTotalBytes(), z);
                            backup();
                            try {
                                fileLockLockFile.release();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            this.mIsSaving = false;
                            throw th;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (this.mErrorListener != null) {
                            this.mErrorListener.onError(th.getMessage(), 11, -1L);
                        }
                        try {
                            fileLockLockFile.release();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        fileLockLockFile.release();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    this.mIsSaving = false;
                    throw th2;
                }
            } else {
                int i = this.mCurTryTime;
                this.mCurTryTime = i + 1;
                if (i < 6) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.3
                        @Override // java.lang.Runnable
                        public void run() {
                            SharedPreferencesNewImpl.this.saveInner(z);
                        }
                    }, 2000L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(SharedPreferences.Editor editor, boolean z, boolean z2, boolean z3) {
        if (editor == null) {
            return;
        }
        synchronized (this.mMap) {
            boolean z4 = false;
            this.mCurTryTime = 0;
            if (!merge(editor, this.mMap, false)) {
                if (this.mEditorList.size() == 0) {
                    return;
                }
            } else {
                z4 = true;
            }
            if (z4) {
                this.mEditorList.add(editor);
            }
            if (z2) {
                saveInner(z);
                return;
            }
            long j = z3 ? 1000L : 0L;
            this.mSaveRunnable.setArg(Boolean.valueOf(z));
            Message messageObtain = Message.obtain(this.mHandler, this.mSaveRunnable);
            messageObtain.what = mSaveMessageID;
            this.mHandler.sendMessageDelayed(messageObtain, j);
        }
    }

    private Pair<Integer, byte[][]> getDataBytes() {
        byte[][] bArr;
        ArrayList arrayList;
        synchronized (this.mMap) {
            bArr = new byte[this.mMap.size() * 5][];
            arrayList = new ArrayList(this.mMap.entrySet());
            this.mEditorList.clear();
        }
        int i = 0;
        int i2 = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Map.Entry entry = (Map.Entry) arrayList.get(size);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str != null && str.trim().length() > 0 && value != null) {
                byte[] bytes = str.getBytes();
                byte[] bArrIntToBytes = ByteIntUtils.intToBytes(bytes.length);
                bArr[i2] = bArrIntToBytes;
                bArr[i2 + 1] = bytes;
                int length = i + bArrIntToBytes.length + bytes.length;
                byte[] bytes2 = getBytes(value);
                byte[] bArrIntToBytes2 = ByteIntUtils.intToBytes(bytes2.length);
                bArr[i2 + 2] = bArrIntToBytes2;
                bArr[i2 + 3] = bytes2;
                int length2 = length + bArrIntToBytes2.length + bytes2.length;
                bArr[i2 + 4] = new byte[]{(byte) getObjectType(value)};
                i = length2 + 1;
                i2 += 5;
            }
        }
        return new Pair<>(Integer.valueOf(i), bArr);
    }

    private void saveToMappedBuffer(byte[] bArr, boolean z) {
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            safeBufferPut(this.mMappedByteBuffer, bArr);
            if (z) {
                this.mMappedByteBuffer.force();
            }
        }
    }

    private int increaseModifyID() {
        this.mModifyID = (this.mModifyID + 1) % Integer.MAX_VALUE;
        return this.mModifyID;
    }

    private int getContentLength() {
        if (this.mMappedByteBuffer == null || this.mFileChannel == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int iBytesToInt = ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(4);
            byte b = this.mMappedByteBuffer.get();
            if ((b != 18 && b != getMaskByte(bArr)) || iBytesToInt < 0) {
                if (this.mErrorListener != null) {
                    this.mErrorListener.onError(this.mFile != null ? this.mFile.getAbsolutePath() : null, 1, this.mFile != null ? this.mFile.length() : 0L);
                }
                return -1;
            }
            int i = Integer.MAX_VALUE;
            if (iBytesToInt <= Integer.MAX_VALUE) {
                i = iBytesToInt;
            }
            return i;
        }
    }

    private void reallocBuffer() {
        if (this.mMappedByteBuffer == null) {
            return;
        }
        synchronized (this.mSyncObj) {
            try {
                int contentLength = getContentLength();
                if (contentLength > this.mMappedByteBuffer.capacity()) {
                    allocBuffer(contentLength + 1024);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0072, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v6, types: [long] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void load(boolean r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.load(boolean):void");
    }

    final int getModifyID() {
        if (this.mMappedByteBuffer == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(5);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int iBytesToInt = ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(9);
            byte b = this.mMappedByteBuffer.get();
            if ((b == 18 || b == getMaskByte(bArr)) && iBytesToInt >= 0) {
                return iBytesToInt;
            }
            this.mModifyErrorCnt++;
            if (this.mModifyErrorCnt < 3 && this.mErrorListener != null) {
                this.mErrorListener.onError(this.mFile != null ? this.mFile.getAbsolutePath() : null, 2, this.mFile != null ? this.mFile.length() : 0L);
            }
            return -1;
        }
    }

    private void startLoadFromDisk(boolean z) {
        synchronized (this) {
            this.mLoaded = false;
        }
        Runnable runnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SharedPreferencesNewImpl.this) {
                    SharedPreferencesNewImpl.this.loadFromDiskLocked();
                }
            }
        };
        if (z) {
            runnable.run();
        } else {
            sCachedThreadPool.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFromDiskLocked() throws Throwable {
        if (this.mLoaded) {
            return;
        }
        load(false);
        this.mLoaded = true;
        notifyAll();
    }

    private void awaitLoadedLocked() {
        if (!this.mLoaded) {
            synchronized (this) {
                while (!this.mLoaded) {
                    try {
                        wait();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        tryReload();
    }

    private boolean safeBufferGet(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return false;
        }
        Arrays.fill(bArr, (byte) 0);
        int iPosition = mappedByteBuffer.position();
        if (iPosition + bArr.length > mappedByteBuffer.capacity()) {
            return false;
        }
        mappedByteBuffer.get(bArr);
        return true;
    }

    private MappedByteBuffer allocBuffer(int i) {
        int iPosition;
        if (this.mMappedByteBuffer != null) {
            iPosition = this.mMappedByteBuffer.position();
        } else {
            iPosition = 0;
        }
        try {
            this.mMappedByteBuffer = this.mFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mMappedByteBuffer != null) {
            this.mMappedByteBuffer.position(iPosition);
        }
        return this.mMappedByteBuffer;
    }

    private boolean initBuffer() {
        boolean z = true;
        if (this.mMappedByteBuffer != null) {
            return true;
        }
        try {
            if (!this.mFile.exists()) {
                this.mFile.getParentFile().mkdirs();
                this.mFile.createNewFile();
                z = new File(this.mBackupFilePath).exists();
            } else if (this.mFile.length() == 0) {
                if (this.mErrorListener != null) {
                    this.mErrorListener.onError(this.mFile.getAbsolutePath(), 4, this.mFile.length());
                }
                z = false;
            }
            this.mFileChannel = new RandomAccessFile(this.mFile, "rw").getChannel();
            allocBuffer(10);
            if (z) {
                return z;
            }
            initFileHeader();
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mErrorListener != null) {
                this.mErrorListener.onError(this.mFile.getAbsolutePath() + " " + e.getCause(), 10, -1L);
            }
            return false;
        }
    }

    private FileLock lockFile(boolean z) throws IOException {
        FileLock fileLockTryLock = null;
        if (this.mFileChannel == null) {
            return null;
        }
        if (z) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            while (fileLockTryLock == null) {
                try {
                    fileLockTryLock = this.mFileChannel.tryLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (fileLockTryLock == null) {
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (SystemClock.uptimeMillis() - jUptimeMillis > 10000) {
                    return fileLockTryLock;
                }
            }
            return fileLockTryLock;
        }
        try {
            return this.mFileChannel.tryLock();
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final void setSharedPreferenceErrorListener(OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this.mErrorListener = onSharedPreferenceErrorListener;
    }

    private void safeBufferPut(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return;
        }
        if (mappedByteBuffer.position() + bArr.length >= mappedByteBuffer.capacity()) {
            mappedByteBuffer = allocBuffer(mappedByteBuffer.position() + bArr.length + 1024);
        }
        mappedByteBuffer.put(bArr);
    }

    private void mergeWhenReload() {
        synchronized (this.mMap) {
            if (this.mEditorList.size() > 0) {
                Iterator<SharedPreferences.Editor> it = this.mEditorList.iterator();
                while (it.hasNext()) {
                    merge(it.next(), this.mMap, true);
                }
            }
        }
    }

    private boolean parseBytesIntoMap(byte[] bArr, boolean z) {
        LinkedHashMap linkedHashMap;
        synchronized (this.mMap) {
            if (z) {
                try {
                    linkedHashMap = new LinkedHashMap(this.mMap);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                linkedHashMap = null;
            }
            if (z && this.mModifyID > 0) {
                this.mMap.clear();
            }
            if (bArr != null && bArr.length != 0) {
                boolean z2 = false;
                int i = 0;
                boolean z3 = true;
                while (true) {
                    if (i < bArr.length) {
                        try {
                            Pair<byte[], Integer> oneString = getOneString(bArr, i);
                            Pair<byte[], Integer> oneString2 = getOneString(bArr, ((Integer) oneString.second).intValue());
                            int iIntValue = ((Integer) oneString2.second).intValue();
                            byte b = bArr[iIntValue];
                            int i2 = iIntValue + 1;
                            byte b2 = bArr[i2];
                            i = i2 + 1;
                            if (b2 != 18 && b2 != getMaskByte(new byte[]{b})) {
                                if (this.mErrorListener != null) {
                                    this.mErrorListener.onError(this.mFile != null ? this.mFile.getAbsolutePath() : null, 8, bArr.length);
                                }
                                break;
                            }
                            if (!checkTypeValid(b)) {
                                if (this.mErrorListener != null) {
                                    this.mErrorListener.onError(this.mFile != null ? this.mFile.getAbsolutePath() : null, 9, bArr.length);
                                }
                                z3 = false;
                            } else {
                                Object objectByType = getObjectByType((byte[]) oneString2.first, b);
                                if (oneString.first != null && ((byte[]) oneString.first).length > 0 && objectByType != null) {
                                    String str = new String((byte[]) oneString.first);
                                    if (z || !this.mMap.containsKey(str)) {
                                        this.mMap.put(str, objectByType);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (this.mErrorListener != null) {
                                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                                sb.append("#");
                                sb.append(e.getCause());
                                onSharedPreferenceErrorListener.onError(sb.toString(), 3, bArr.length);
                            }
                        }
                    } else {
                        z2 = z3;
                        break;
                    }
                }
                if (!z2 && z) {
                    this.mMap.putAll(linkedHashMap);
                }
                return z2;
            }
            return true;
        }
    }

    private Pair<byte[], Integer> getOneString(byte[] bArr, int i) throws Exception {
        int i2;
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, i, bArr2, 0, 4);
        int i3 = i + 4;
        if (bArr[i3] != 18 && bArr[i3] != getMaskByte(bArr2)) {
            throw new Exception("length string's finish mark missing");
        }
        int i4 = i3 + 1;
        int iBytesToInt = ByteIntUtils.bytesToInt(bArr2);
        if (iBytesToInt < 0 || (i2 = i4 + iBytesToInt) >= bArr.length || iBytesToInt > Integer.MAX_VALUE) {
            throw new Exception("length string is invalid");
        }
        byte[] bArr3 = null;
        if (iBytesToInt != 0) {
            bArr3 = new byte[iBytesToInt];
            System.arraycopy(bArr, i4, bArr3, 0, iBytesToInt);
            if (bArr[i2] != 18 && bArr[i2] != getMaskByte(bArr3)) {
                throw new Exception("Stored bytes' finish mark missing");
            }
            i4 = i2;
        }
        return new Pair<>(bArr3, Integer.valueOf(i4 + 1));
    }

    private byte[] obtainTotalBytes() {
        Pair<Integer, byte[][]> dataBytes = getDataBytes();
        int iIntValue = ((Integer) dataBytes.first).intValue() + 10 + (((byte[][]) dataBytes.second).length * 1);
        if (iIntValue > Integer.MAX_VALUE) {
            iIntValue = Integer.MAX_VALUE;
        }
        byte[] bArr = new byte[iIntValue];
        byte[] bArrIntToBytes = ByteIntUtils.intToBytes(iIntValue);
        System.arraycopy(bArrIntToBytes, 0, bArr, 0, bArrIntToBytes.length);
        int length = bArrIntToBytes.length + 0;
        bArr[length] = getMaskByte(bArrIntToBytes);
        int i = length + 1;
        byte[] bArrIntToBytes2 = ByteIntUtils.intToBytes(increaseModifyID());
        System.arraycopy(bArrIntToBytes2, 0, bArr, i, bArrIntToBytes2.length);
        int length2 = i + bArrIntToBytes2.length;
        bArr[length2] = getMaskByte(bArrIntToBytes2);
        int i2 = length2 + 1;
        for (byte[] bArr2 : (byte[][]) dataBytes.second) {
            if (bArr2 != null) {
                if (bArr2.length + i2 + 1 <= Integer.MAX_VALUE) {
                    System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
                    int length3 = i2 + bArr2.length;
                    bArr[length3] = getMaskByte(bArr2);
                    i2 = length3 + 1;
                } else {
                    StringBuilder sb = new StringBuilder("Write too much data in ");
                    sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                    Log.e(TAG, sb.toString());
                    if (this.mErrorListener == null) {
                        break;
                    }
                    this.mErrorListener.onError(this.mFile != null ? this.mFile.getAbsolutePath() : null, 7, -1L);
                    break;
                }
            }
        }
        return bArr;
    }

    final boolean checkTypeValid(byte b) {
        if (b == 4 || b == 2 || b == 1 || b == 3 || b == 5) {
            return true;
        }
        return false;
    }

    private void initFileHeader() {
        if (this.mMappedByteBuffer != null) {
            byte[] bArr = new byte[10];
            byte[] bArrIntToBytes = ByteIntUtils.intToBytes(0);
            System.arraycopy(bArrIntToBytes, 0, bArr, 0, 4);
            bArr[4] = getMaskByte(bArrIntToBytes);
            byte[] bArrIntToBytes2 = ByteIntUtils.intToBytes(0);
            System.arraycopy(bArrIntToBytes2, 0, bArr, 5, 4);
            bArr[9] = getMaskByte(bArrIntToBytes2);
            this.mMappedByteBuffer.position(0);
            this.mMappedByteBuffer.put(bArr);
        }
    }

    private int getObjectType(Object obj) {
        if (obj instanceof String) {
            return 5;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Long) {
            return 3;
        }
        return 0;
    }

    private Object getObjectByType(byte[] bArr, int i) {
        if (bArr != null && bArr.length > 0) {
            try {
                if (i == 5) {
                    return new String(bArr);
                }
                if (i == 4) {
                    return Boolean.valueOf(bArr[0] == 1);
                }
                if (i == 2) {
                    return Float.valueOf(ByteFloatUtils.bytesToFloat(bArr));
                }
                if (i == 1) {
                    return Integer.valueOf(ByteIntUtils.bytesToInt(bArr));
                }
                if (i == 3) {
                    return Long.valueOf(ByteLongUtils.bytesToLong(bArr));
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private byte[] getBytes(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return ((String) obj).getBytes();
                }
                if (obj instanceof Boolean) {
                    return new byte[]{((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0};
                }
                if (obj instanceof Float) {
                    return ByteFloatUtils.floatToBytes(((Float) obj).floatValue());
                }
                if (obj instanceof Integer) {
                    return ByteIntUtils.intToBytes(((Integer) obj).intValue());
                }
                if (obj instanceof Long) {
                    return ByteLongUtils.longToBytes(((Long) obj).longValue());
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    static class ByteLongUtils {
        private ByteLongUtils() {
        }

        public static byte[] longToBytes(long j) {
            return ByteBuffer.allocate(8).putLong(j).array();
        }

        public static long bytesToLong(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getLong();
        }
    }

    static class ByteIntUtils {
        private ByteIntUtils() {
        }

        public static byte[] intToBytes(int i) {
            return ByteBuffer.allocate(4).putInt(i).array();
        }

        public static int bytesToInt(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getInt();
        }
    }

    static class ByteFloatUtils {
        private ByteFloatUtils() {
        }

        public static byte[] floatToBytes(float f) {
            return ByteBuffer.allocate(4).putFloat(f).array();
        }

        public static float bytesToFloat(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getFloat();
        }
    }

    private void backup() throws Throwable {
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            File file = new File(this.mBackupFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                try {
                    this.mFileChannel.transferTo(0L, this.mMappedByteBuffer.capacity(), channel);
                    safeClose(fileOutputStream);
                    safeClose(channel);
                } catch (Throwable th) {
                    th = th;
                    closeable2 = fileOutputStream;
                    closeable = channel;
                    try {
                        th.printStackTrace();
                        safeClose(closeable2);
                        safeClose(closeable);
                    } catch (Throwable th2) {
                        th = th2;
                        safeClose(closeable2);
                        safeClose(closeable);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                closeable2 = fileOutputStream;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
        }
    }

    private void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00af  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:71:0x010b  */
    /* JADX WARN: Code duplicated, block: B:72:0x010e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0124  */
    /* JADX WARN: Instruction removed from duplicated block: B:51:0x00af, please report this as an issue */
    private boolean loadFromBakFile() throws Throwable {
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        Throwable th;
        Object cause;
        boolean bytesIntoMap;
        byte[] bArr2 = null;
        Throwable th2 = null;
        bArr2 = null;
        boolean bytesIntoMap2 = true;
        try {
            randomAccessFile = new RandomAccessFile(this.mBackupFilePath, "r");
            try {
                byte[] bArr3 = new byte[4];
                randomAccessFile.read(bArr3, 0, 4);
                int iBytesToInt = ByteIntUtils.bytesToInt(bArr3);
                if (iBytesToInt <= 10) {
                    safeClose(randomAccessFile);
                    try {
                        parseBytesIntoMap(null, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }
                if (iBytesToInt > Integer.MAX_VALUE) {
                    iBytesToInt = Integer.MAX_VALUE;
                }
                if (iBytesToInt > randomAccessFile.length()) {
                    iBytesToInt = (int) randomAccessFile.length();
                }
                bArr = new byte[iBytesToInt - 10];
                try {
                    try {
                        randomAccessFile.seek(10L);
                        randomAccessFile.read(bArr);
                        safeClose(randomAccessFile);
                        try {
                            bytesIntoMap = parseBytesIntoMap(bArr, false);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            bytesIntoMap = true;
                        }
                        if (this.mErrorListener == null) {
                            return bytesIntoMap;
                        }
                        this.mErrorListener.onError(this.mBackupFilePath + "#" + ((Object) "") + "#" + bytesIntoMap, 12, bArr.length);
                        return bytesIntoMap;
                    } catch (Throwable th3) {
                        th2 = th3;
                        th2.printStackTrace();
                        safeClose(randomAccessFile);
                        bytesIntoMap2 = parseBytesIntoMap(bArr, false);
                        if (this.mErrorListener != null) {
                            this.mErrorListener.onError(this.mBackupFilePath + "#" + th2.getCause() + "#" + bytesIntoMap2, 12, bArr != null ? bArr.length : 0);
                        }
                        return bytesIntoMap2;
                    }
                } catch (Throwable th4) {
                    th = th2;
                    bArr2 = bArr;
                    th = th4;
                    safeClose(randomAccessFile);
                    try {
                        bytesIntoMap2 = parseBytesIntoMap(bArr2, false);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    if ((bArr2 != null && th == null) || this.mErrorListener == null) {
                        throw th;
                    }
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mBackupFilePath);
                    sb.append("#");
                    if (th == null) {
                        cause = "";
                    } else {
                        cause = th.getCause();
                    }
                    sb.append(cause);
                    sb.append("#");
                    sb.append(bytesIntoMap2);
                    onSharedPreferenceErrorListener.onError(sb.toString(), 12, bArr2 != null ? bArr2.length : 0);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                th = null;
                safeClose(randomAccessFile);
                bytesIntoMap2 = parseBytesIntoMap(bArr2, false);
                if (bArr2 != null) {
                }
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mBackupFilePath);
                sb2.append("#");
                if (th == null) {
                    cause = "";
                } else {
                    cause = th.getCause();
                }
                sb2.append(cause);
                sb2.append("#");
                sb2.append(bytesIntoMap2);
                onSharedPreferenceErrorListener2.onError(sb2.toString(), 12, bArr2 != null ? bArr2.length : 0);
                throw th;
            }
        } catch (Throwable th6) {
            bArr = null;
            th2 = th6;
            randomAccessFile = null;
        }
        th2.printStackTrace();
        safeClose(randomAccessFile);
        try {
            bytesIntoMap2 = parseBytesIntoMap(bArr, false);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (this.mErrorListener != null) {
            this.mErrorListener.onError(this.mBackupFilePath + "#" + th2.getCause() + "#" + bytesIntoMap2, 12, bArr != null ? bArr.length : 0);
        }
        return bytesIntoMap2;
    }

    private byte getBCCCode(byte[] bArr) {
        byte b = 0;
        for (byte b2 : bArr) {
            b = (byte) (b ^ b2);
        }
        return b;
    }

    private byte getMaskByte(byte[] bArr) {
        return getBCCCode(bArr);
    }

    final class FileMonitor extends FileObserver {
        public FileMonitor(String str, int i) {
            super(str, i);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i, String str) {
            if (SharedPreferencesNewImpl.this.mListeners.size() > 0) {
                SharedPreferencesNewImpl.this.tryReload();
            } else {
                stopWatching();
            }
        }
    }

    final void onDestroy() {
        if (this.mIsSaving || this.mHandler.hasMessages(mSaveMessageID)) {
            saveInner(false);
        }
    }

    private HandlerThread getHandlerThread() {
        int iNextInt = new Random().nextInt();
        if (iNextInt < 0) {
            iNextInt = -iNextInt;
        }
        return mHandlerThreadPool[iNextInt % 3];
    }

    public static abstract class RunnableEx implements Runnable {
        private Object mArg;

        public void setArg(Object obj) {
            this.mArg = obj;
        }

        public Object getArg() {
            return this.mArg;
        }
    }
}
