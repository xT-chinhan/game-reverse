package com.tapsdk.tapad.internal.runtime.bundle;

import android.content.Context;
import android.util.AtomicFile;
import com.tapsdk.tapad.TapAdConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class BundleRegistryStore {
    private static final String LEGACY_LOCK = ".registry.lock";
    private static final String LEGACY_PREFS = "dirichlet_bundle";
    private static final String LEGACY_STATE = ".registry.json";
    private static final int MAX_STATE_BYTES = 1048576;
    private static final String MEDIATION_LOCK = ".registry-mediation.lock";
    private static final String MEDIATION_STATE = ".registry-mediation.json";
    private static final Object PROCESS_LOCK = new Object();
    private static final int SCHEMA_VERSION = 1;
    private static final String TAG = "BundleRegistryStore";
    private final Context context;
    private final String lockName;
    private final boolean migrateLegacy;
    private final String stateName;

    public interface Operation<T> {
        T run(State state);
    }

    public static final class State {
        private final JSONObject values;

        public State() {
            this(new JSONObject());
        }

        public byte[] encode() throws IOException {
            byte[] bytes = new JSONObject().put("schema_version", 1).put("values", this.values).toString().getBytes(StandardCharsets.UTF_8);
            if (bytes.length <= 0 || bytes.length > 1048576) {
                throw new IOException("bundle registry state exceeds bounds");
            }
            return bytes;
        }

        public long getLong(String str, long j) {
            Object objOpt = this.values.opt(str);
            return objOpt instanceof Number ? ((Number) objOpt).longValue() : j;
        }

        public Set<String> getStringSet(String str) {
            JSONArray jSONArrayOptJSONArray = this.values.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i, "");
                if (!strOptString.isEmpty()) {
                    hashSet.add(strOptString);
                }
            }
            return hashSet;
        }

        public void putLong(String str, long j) {
            try {
                this.values.put(str, j);
            } catch (Throwable th) {
                throw new IllegalStateException("cannot encode registry long", th);
            }
        }

        public void putStringSet(String str, Set<String> set) {
            ArrayList arrayList = new ArrayList(set);
            Collections.sort(arrayList);
            JSONArray jSONArray = new JSONArray();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put((String) obj);
            }
            try {
                this.values.put(str, jSONArray);
            } catch (Throwable th) {
                throw new IllegalStateException("cannot encode registry set", th);
            }
        }

        public void remove(String str) {
            this.values.remove(str);
        }

        public State(JSONObject jSONObject) {
            this.values = jSONObject;
        }
    }

    public BundleRegistryStore(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext != null ? applicationContext : context;
        boolean zUsesIsolatedRegistry = BundleId.usesIsolatedRegistry();
        this.stateName = zUsesIsolatedRegistry ? MEDIATION_STATE : LEGACY_STATE;
        this.lockName = zUsesIsolatedRegistry ? MEDIATION_LOCK : LEGACY_LOCK;
        this.migrateLegacy = !zUsesIsolatedRegistry;
    }

    private static File canonical(File file) {
        return file.getCanonicalFile();
    }

    private File ensureRoot() throws IOException {
        File fileCanonical = canonical(this.context.getFilesDir());
        File fileCanonical2 = canonical(new File(fileCanonical, TapAdConfig.AggregationChannel.DIRICHLET));
        File fileCanonical3 = canonical(new File(fileCanonical2, "bundles"));
        if (!fileCanonical.equals(fileCanonical2.getParentFile()) || !fileCanonical2.equals(fileCanonical3.getParentFile())) {
            throw new IOException("bundle registry escaped app-private root");
        }
        if (fileCanonical3.isDirectory() || fileCanonical3.mkdirs()) {
            return fileCanonical3;
        }
        throw new IOException("cannot create bundle registry root");
    }

    private <T> T execute(Operation<T> operation, boolean z, T t) {
        synchronized (PROCESS_LOCK) {
            try {
                File fileEnsureRoot = ensureRoot();
                File fileCanonical = canonical(new File(fileEnsureRoot, this.lockName));
                if (!fileEnsureRoot.equals(fileCanonical.getParentFile())) {
                    throw new IOException("bundle registry lock escaped root");
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileCanonical, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        FileLock fileLockLock = channel.lock();
                        try {
                            AtomicFile atomicFile = new AtomicFile(new File(fileEnsureRoot, this.stateName));
                            State stateLoadOrMigrate = loadOrMigrate(atomicFile);
                            T tRun = operation.run(stateLoadOrMigrate);
                            if (!z || writeAtomic(atomicFile, stateLoadOrMigrate.encode())) {
                                if (fileLockLock != null) {
                                    fileLockLock.close();
                                }
                                channel.close();
                                randomAccessFile.close();
                                t = tRun;
                            } else {
                                if (fileLockLock != null) {
                                    fileLockLock.close();
                                }
                                channel.close();
                                randomAccessFile.close();
                            }
                        } catch (Throwable th) {
                            if (fileLockLock != null) {
                                try {
                                    fileLockLock.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            } catch (Throwable th7) {
                safeLog("bundle registry transaction failed", th7);
                return t;
            }
        }
        return t;
    }

    private State loadOrMigrate(AtomicFile atomicFile) throws IOException {
        byte[] bounded;
        try {
            FileInputStream fileInputStreamOpenRead = atomicFile.openRead();
            try {
                bounded = readBounded(fileInputStreamOpenRead);
                if (fileInputStreamOpenRead != null) {
                    try {
                        fileInputStreamOpenRead.close();
                    } catch (FileNotFoundException e) {
                    }
                }
            } catch (Throwable th) {
                if (fileInputStreamOpenRead != null) {
                    try {
                        fileInputStreamOpenRead.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e2) {
            bounded = null;
        }
        if (bounded == null) {
            State stateMigrateLegacy = this.migrateLegacy ? migrateLegacy() : new State();
            if (!writeAtomic(atomicFile, stateMigrateLegacy.encode())) {
                throw new IOException("cannot persist migrated bundle registry");
            }
            if (this.migrateLegacy) {
                this.context.getSharedPreferences(LEGACY_PREFS, 0).edit().clear().commit();
            }
            return stateMigrateLegacy;
        }
        JSONObject jSONObject = new JSONObject(new String(bounded, StandardCharsets.UTF_8));
        if (jSONObject.optInt("schema_version", 0) != 1) {
            throw new IOException("unsupported bundle registry schema");
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        if (jSONObjectOptJSONObject != null) {
            return new State(jSONObjectOptJSONObject);
        }
        throw new IOException("missing bundle registry values");
    }

    private State migrateLegacy() {
        State state = new State();
        for (Map.Entry<String, ?> entry : this.context.getSharedPreferences(LEGACY_PREFS, 0).getAll().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Number) {
                state.putLong(entry.getKey(), ((Number) value).longValue());
            } else if (value instanceof Set) {
                HashSet hashSet = new HashSet();
                for (Object obj : (Set) value) {
                    if (obj instanceof String) {
                        hashSet.add((String) obj);
                    }
                }
                state.putStringSet(entry.getKey(), hashSet);
            }
        }
        return state;
    }

    private static byte[] readBounded(FileInputStream fileInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            if (byteArrayOutputStream.size() + i > 1048576) {
                throw new IOException("bundle registry state is too large");
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    private static void safeLog(String str, Throwable th) {
    }

    private static boolean writeAtomic(AtomicFile atomicFile, byte[] bArr) {
        FileOutputStream fileOutputStreamStartWrite;
        try {
            fileOutputStreamStartWrite = atomicFile.startWrite();
            try {
                fileOutputStreamStartWrite.write(bArr);
                fileOutputStreamStartWrite.getFD().sync();
                atomicFile.finishWrite(fileOutputStreamStartWrite);
                return true;
            } catch (IOException e) {
                if (fileOutputStreamStartWrite == null) {
                    return false;
                }
                atomicFile.failWrite(fileOutputStreamStartWrite);
                return false;
            }
        } catch (IOException e2) {
            fileOutputStreamStartWrite = null;
        }
    }

    public void clearForTests() {
        synchronized (PROCESS_LOCK) {
            try {
                File fileEnsureRoot = ensureRoot();
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(fileEnsureRoot, this.lockName), "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        FileLock fileLockLock = channel.lock();
                        try {
                            new AtomicFile(new File(fileEnsureRoot, this.stateName)).delete();
                            if (this.migrateLegacy) {
                                this.context.getSharedPreferences(LEGACY_PREFS, 0).edit().clear().commit();
                            }
                            if (fileLockLock != null) {
                                fileLockLock.close();
                            }
                            channel.close();
                            randomAccessFile.close();
                        } catch (Throwable th) {
                            if (fileLockLock != null) {
                                try {
                                    fileLockLock.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            } catch (Throwable th7) {
                safeLog("cannot clear bundle registry test state", th7);
            }
        }
    }

    public <T> T read(Operation<T> operation, T t) {
        return (T) execute(operation, false, t);
    }

    public <T> T update(Operation<T> operation, T t) {
        return (T) execute(operation, true, t);
    }
}
