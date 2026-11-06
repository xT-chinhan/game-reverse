package com.byazt.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.i.x;
import com.byazt.vkw.qi;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.ILivePlayer;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 505, 20})
public class hn extends com.byazt.j.pr {
    public final hw aj;
    public final ReentrantReadWriteLock.WriteLock c;
    public volatile long fw;
    public final ReentrantReadWriteLock hn;
    public final LinkedHashMap<String, File> hw = new LinkedHashMap<>(0, 0.75f, true);
    public final File pr;
    public final Set<pr> uc;
    public final Runnable vk;
    public final Handler w;
    public final ReentrantReadWriteLock.ReadLock x;
    public volatile float zo;

    public interface pr {
        void pr(String str);

        void pr(Set<String> set);
    }

    public void pr(pr prVar) {
        if (prVar != null) {
            this.uc.add(prVar);
        }
    }

    public hn(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.hn = reentrantReadWriteLock;
        this.x = reentrantReadWriteLock.readLock();
        this.c = reentrantReadWriteLock.writeLock();
        this.uc = Collections.newSetFromMap(new ConcurrentHashMap());
        this.fw = 104857600L;
        this.zo = 0.5f;
        this.aj = new hw();
        this.vk = new Runnable() { // from class: com.byazt.j.hn.1
            @Override // java.lang.Runnable
            public void run() {
                ((qi) uc.pr("thread_service")).hw(new Runnable() { // from class: com.byazt.j.hn.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hn.this.hw(hn.this.fw);
                    }
                });
            }
        };
        this.w = new Handler(Looper.getMainLooper());
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            if (file == null) {
                str = " dir null";
            } else {
                str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
            }
            throw new IOException("dir error!  ".concat(String.valueOf(str)));
        }
        this.pr = file;
        ((qi) uc.pr("thread_service")).pr(new Runnable() { // from class: com.byazt.j.hn.2
            @Override // java.lang.Runnable
            public void run() {
                hn.this.hw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        this.c.lock();
        try {
            File[] fileArrListFiles = this.pr.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.byazt.j.hn.3
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        if (jLongValue > 0) {
                            return 1;
                        }
                        return 0;
                    }
                });
                for (File file2 : arrayList) {
                    this.hw.put(pr(file2), file2);
                }
            }
            this.c.unlock();
            hn();
        } catch (Throwable th) {
            this.c.unlock();
            throw th;
        }
    }

    public void pr(long j) {
        this.fw = j;
        hn();
    }

    private void hn() {
        this.w.removeCallbacks(this.vk);
        this.w.postDelayed(this.vk, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public void pr() {
        com.byazt.i.hn.pr().hw();
        Context context = x.getContext();
        if (context != null) {
            com.byazt.d.hn.pr(context).pr(0);
        }
        this.w.removeCallbacks(this.vk);
        ((qi) uc.pr("thread_service")).hw(new Runnable() { // from class: com.byazt.j.hn.4
            @Override // java.lang.Runnable
            public void run() {
                hn.this.hw(0L);
            }
        });
    }

    @Override // com.byazt.j.pr
    public void pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aj.pr(str);
        }
    }

    @Override // com.byazt.j.pr
    public void hw(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aj.hw(str);
        }
    }

    @Override // com.byazt.j.pr
    public File hn(String str) {
        this.x.lock();
        File file = this.hw.get(str);
        this.x.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.pr, str);
        this.c.lock();
        this.hw.put(str, file2);
        this.c.unlock();
        Iterator<pr> it = this.uc.iterator();
        while (it.hasNext()) {
            it.next().pr(str);
        }
        hn();
        return file2;
    }

    @Override // com.byazt.j.pr
    public File x(String str) {
        if (this.x.tryLock()) {
            File file = this.hw.get(str);
            this.x.unlock();
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(long j) {
        HashSet hashSet;
        final HashSet hashSet2 = new HashSet();
        this.c.lock();
        long length = 0;
        try {
            Iterator<Map.Entry<String, File>> it = this.hw.entrySet().iterator();
            while (it.hasNext()) {
                length += it.next().getValue().length();
            }
            if (length > j) {
                long j2 = (long) (j * this.zo);
                hashSet = new HashSet();
                try {
                    for (Map.Entry<String, File> entry : this.hw.entrySet()) {
                        File value = entry.getValue();
                        if (value != null && value.exists()) {
                            if (!this.aj.hn(pr(value))) {
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
                        this.hw.remove((String) it2.next());
                    }
                } catch (Throwable th) {
                }
            } else {
                this.c.unlock();
                return;
            }
        } catch (Throwable th2) {
            hashSet = null;
        }
        this.c.unlock();
        Iterator<pr> it3 = this.uc.iterator();
        while (it3.hasNext()) {
            it3.next().pr(hashSet);
        }
        ((qi) uc.pr("thread_service")).pr(new Runnable() { // from class: com.byazt.j.hn.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it4 = hashSet2.iterator();
                while (it4.hasNext()) {
                    ((File) it4.next()).delete();
                }
            }
        });
    }

    private String pr(File file) {
        return file.getName();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 505, 506})
    private static final class hw {
        public final Map<String, Integer> pr;

        private hw() {
            this.pr = new HashMap();
        }

        public synchronized void pr(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.pr.get(str);
                if (num == null) {
                    this.pr.put(str, 1);
                    return;
                }
                this.pr.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }

        public synchronized void hw(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.pr.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.pr.remove(str);
                    return;
                }
                this.pr.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        public synchronized boolean hn(String str) {
            if (!TextUtils.isEmpty(str)) {
                return this.pr.containsKey(str);
            }
            return false;
        }
    }
}
