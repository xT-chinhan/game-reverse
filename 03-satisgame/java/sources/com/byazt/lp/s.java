package com.byazt.lp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.qp.q;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK, 8})
public class s extends com.byazt.lp.n {
    public final Handler cp;
    public volatile float fs;
    public final ReentrantReadWriteLock.WriteLock l;
    public final File n;
    public final ReentrantReadWriteLock.ReadLock q;
    public final LinkedHashMap<String, File> qg = new LinkedHashMap<>(0, 0.75f, true);
    public final qg rv;
    public final ReentrantReadWriteLock s;
    public final Runnable tj;
    public final Set<n> w;
    public volatile long x;

    public interface n {
        void n(String str);

        void n(Set<String> set);
    }

    public void n(n nVar) {
        if (nVar != null) {
            this.w.add(nVar);
        }
    }

    public s(File file) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.s = reentrantReadWriteLock;
        this.q = reentrantReadWriteLock.readLock();
        this.l = reentrantReadWriteLock.writeLock();
        this.w = Collections.newSetFromMap(new ConcurrentHashMap());
        this.x = 104857600L;
        this.fs = 0.5f;
        this.rv = new qg();
        this.tj = new Runnable() { // from class: com.byazt.lp.s.1
            @Override // java.lang.Runnable
            public void run() {
                ((wo) q.n("thread_service")).qg(new Runnable() { // from class: com.byazt.lp.s.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        s.this.qg(s.this.x);
                    }
                });
            }
        };
        this.cp = new Handler(Looper.getMainLooper());
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            throw new IOException("dir error!  ".concat(String.valueOf(file == null ? " dir null" : "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite())));
        }
        this.n = file;
        ((wo) q.n("thread_service")).n(new Runnable() { // from class: com.byazt.lp.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.this.qg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        this.l.lock();
        try {
            File[] fileArrListFiles = this.n.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.byazt.lp.s.3
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        return jLongValue > 0 ? 1 : 0;
                    }
                });
                for (File file2 : arrayList) {
                    this.qg.put(n(file2), file2);
                }
            }
            this.l.unlock();
            s();
        } catch (Throwable th) {
            this.l.unlock();
            throw th;
        }
    }

    public void n(long j) {
        this.x = j;
        s();
    }

    private void s() {
        this.cp.removeCallbacks(this.tj);
        this.cp.postDelayed(this.tj, 10000L);
    }

    public void n() {
        com.byazt.nd.s.n().qg();
        Context context = com.byazt.nd.q.getContext();
        if (context != null) {
            com.byazt.frl.s.n(context).n(0);
        }
        this.cp.removeCallbacks(this.tj);
        ((wo) q.n("thread_service")).qg(new Runnable() { // from class: com.byazt.lp.s.4
            @Override // java.lang.Runnable
            public void run() {
                s.this.qg(0L);
            }
        });
    }

    @Override // com.byazt.lp.n
    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.rv.n(str);
    }

    @Override // com.byazt.lp.n
    public void qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.rv.qg(str);
    }

    @Override // com.byazt.lp.n
    public File s(String str) {
        this.q.lock();
        File file = this.qg.get(str);
        this.q.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.n, str);
        this.l.lock();
        this.qg.put(str, file2);
        this.l.unlock();
        Iterator<n> it = this.w.iterator();
        while (it.hasNext()) {
            it.next().n(str);
        }
        s();
        return file2;
    }

    @Override // com.byazt.lp.n
    public File q(String str) {
        if (!this.q.tryLock()) {
            return null;
        }
        File file = this.qg.get(str);
        this.q.unlock();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(long j) {
        HashSet hashSet;
        final HashSet hashSet2 = new HashSet();
        this.l.lock();
        try {
            Iterator<Map.Entry<String, File>> it = this.qg.entrySet().iterator();
            long length = 0;
            while (it.hasNext()) {
                length += it.next().getValue().length();
            }
            if (length > j) {
                long j2 = (long) (j * this.fs);
                hashSet = new HashSet();
                try {
                    for (Map.Entry<String, File> entry : this.qg.entrySet()) {
                        File value = entry.getValue();
                        if (value != null && value.exists()) {
                            if (!this.rv.s(n(value))) {
                                long length2 = value.length();
                                File file = new File(value.getAbsolutePath() + "-tmp");
                                if (value.renameTo(file)) {
                                    hashSet2.add(file);
                                    length -= length2;
                                    hashSet.add(entry.getKey());
                                }
                            }
                        } else {
                            hashSet.add(entry.getKey());
                        }
                        if (length <= j2) {
                            break;
                        }
                    }
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        this.qg.remove((String) it2.next());
                    }
                } catch (Throwable unused) {
                }
            } else {
                this.l.unlock();
                return;
            }
        } catch (Throwable unused2) {
            hashSet = null;
        }
        this.l.unlock();
        Iterator<n> it3 = this.w.iterator();
        while (it3.hasNext()) {
            it3.next().n(hashSet);
        }
        ((wo) q.n("thread_service")).n(new Runnable() { // from class: com.byazt.lp.s.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it4 = hashSet2.iterator();
                while (it4.hasNext()) {
                    try {
                        ((File) it4.next()).delete();
                    } catch (Throwable unused3) {
                    }
                }
            }
        });
    }

    private String n(File file) {
        return file.getName();
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK, 782})
    private static final class qg {
        public final Map<String, Integer> n;

        private qg() {
            this.n = new HashMap();
        }

        public synchronized void n(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.n.get(str);
                if (num == null) {
                    this.n.put(str, 1);
                    return;
                }
                this.n.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }

        public synchronized void qg(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.n.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.n.remove(str);
                    return;
                }
                this.n.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        public synchronized boolean s(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.n.containsKey(str);
        }
    }
}
