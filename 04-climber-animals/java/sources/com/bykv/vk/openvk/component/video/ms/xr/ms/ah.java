package com.bykv.vk.openvk.component.video.ms.xr.ms;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.openvk.component.video.ms.xr.d;
import com.bykv.vk.openvk.component.video.ms.xr.ka;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
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
public class ah extends com.bykv.vk.openvk.component.video.ms.xr.ms.ms {
    private volatile long ab;
    private final ReentrantReadWriteLock ah;
    private final Set<ms> c;
    private final Runnable ch;
    private final ReentrantReadWriteLock.ReadLock d;
    private final Handler hi;
    private final ReentrantReadWriteLock.WriteLock ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final File f90ms;
    private final xr ny;
    private volatile float x;
    private final LinkedHashMap<String, File> xr = new LinkedHashMap<>(0, 0.75f, true);

    public interface ms {
        void ms(String str);

        void ms(Set<String> set);
    }

    public void ms(ms msVar) {
        if (msVar != null) {
            this.c.add(msVar);
        }
    }

    public ah(File file) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.ah = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.readLock();
        this.ka = reentrantReadWriteLock.writeLock();
        this.c = Collections.newSetFromMap(new ConcurrentHashMap());
        this.ab = 104857600L;
        this.x = 0.5f;
        this.ny = new xr();
        this.ch = new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.xr.ms.ah.1
            @Override // java.lang.Runnable
            public void run() {
                ab.xr(new ny("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.component.video.ms.xr.ms.ah.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ah.this.xr(ah.this.ab);
                    }
                });
            }
        };
        this.hi = new Handler(Looper.getMainLooper());
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            throw new IOException("dir error!  ".concat(String.valueOf(file == null ? " dir null" : "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite())));
        }
        this.f90ms = file;
        ab.xr(new ny("DiskLruCache", 5) { // from class: com.bykv.vk.openvk.component.video.ms.xr.ms.ah.2
            @Override // java.lang.Runnable
            public void run() {
                ah.this.xr();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr() {
        this.ka.lock();
        try {
            File[] fileArrListFiles = this.f90ms.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.ms.xr.ms.ah.3
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        return jLongValue > 0 ? 1 : 0;
                    }
                });
                for (File file2 : arrayList) {
                    this.xr.put(ms(file2), file2);
                }
            }
            this.ka.unlock();
            ah();
        } catch (Throwable th) {
            this.ka.unlock();
            throw th;
        }
    }

    public void ms(long j) {
        this.ab = j;
        ah();
    }

    private void ah() {
        this.hi.removeCallbacks(this.ch);
        this.hi.postDelayed(this.ch, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public void ms() {
        d.ah().d();
        Context context = ka.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.ms.xr.xr.ah.ms(context).ms(0);
        }
        this.hi.removeCallbacks(this.ch);
        ab.xr(new ny("clear", 1) { // from class: com.bykv.vk.openvk.component.video.ms.xr.ms.ah.4
            @Override // java.lang.Runnable
            public void run() {
                ah.this.xr(0L);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ms.ms
    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ny.ms(str);
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ms.ms
    public void xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ny.xr(str);
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ms.ms
    public File ah(String str) {
        this.d.lock();
        File file = this.xr.get(str);
        this.d.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.f90ms, str);
        this.ka.lock();
        this.xr.put(str, file2);
        this.ka.unlock();
        Iterator<ms> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().ms(str);
        }
        ah();
        return file2;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ms.ms
    public File d(String str) {
        if (!this.d.tryLock()) {
            return null;
        }
        File file = this.xr.get(str);
        this.d.unlock();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x00e5 A[LOOP:3: B:41:0x00df->B:43:0x00e5, LOOP_END] */
    public void xr(long j) {
        HashSet hashSet;
        Iterator<ms> it;
        final HashSet hashSet2 = new HashSet();
        this.ka.lock();
        HashSet hashSet3 = null;
        try {
            try {
                Iterator<Map.Entry<String, File>> it2 = this.xr.entrySet().iterator();
                long length = 0;
                while (it2.hasNext()) {
                    length += it2.next().getValue().length();
                }
                if (length <= j) {
                    this.ka.unlock();
                    return;
                }
                long j2 = (long) (j * this.x);
                hashSet = new HashSet();
                try {
                    for (Map.Entry<String, File> entry : this.xr.entrySet()) {
                        File value = entry.getValue();
                        if (value == null || !value.exists()) {
                            hashSet.add(entry.getKey());
                        } else if (!this.ny.ah(ms(value))) {
                            long length2 = value.length();
                            File file = new File(value.getAbsolutePath() + "-tmp");
                            if (value.renameTo(file)) {
                                hashSet2.add(file);
                                length -= length2;
                                hashSet.add(entry.getKey());
                            }
                        }
                        if (length <= j2) {
                            break;
                        }
                    }
                    Iterator it3 = hashSet.iterator();
                    while (it3.hasNext()) {
                        this.xr.remove((String) it3.next());
                    }
                    this.ka.unlock();
                } catch (Throwable th) {
                    th = th;
                    hashSet3 = hashSet;
                    sl.ms(th);
                    this.ka.unlock();
                    hashSet = hashSet3;
                }
                it = this.c.iterator();
                while (it.hasNext()) {
                    it.next().ms(hashSet);
                }
                ab.xr(new ny("trimSize", 1) { // from class: com.bykv.vk.openvk.component.video.ms.xr.ms.ah.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it4 = hashSet2.iterator();
                        while (it4.hasNext()) {
                            try {
                                ((File) it4.next()).delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
            } catch (Throwable th2) {
                th = th2;
            }
            sl.ms(th);
            this.ka.unlock();
            hashSet = hashSet3;
            it = this.c.iterator();
            while (it.hasNext()) {
                it.next().ms(hashSet);
            }
            ab.xr(new ny("trimSize", 1) { // from class: com.bykv.vk.openvk.component.video.ms.xr.ms.ah.5
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it4 = hashSet2.iterator();
                    while (it4.hasNext()) {
                        try {
                            ((File) it4.next()).delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable th3) {
            this.ka.unlock();
            throw th3;
        }
    }

    private String ms(File file) {
        return file.getName();
    }

    private static final class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final Map<String, Integer> f97ms;

        private xr() {
            this.f97ms = new HashMap();
        }

        synchronized void ms(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.f97ms.get(str);
                if (num == null) {
                    this.f97ms.put(str, 1);
                    return;
                }
                this.f97ms.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }

        synchronized void xr(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.f97ms.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.f97ms.remove(str);
                    return;
                }
                this.f97ms.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        synchronized boolean ah(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f97ms.containsKey(str);
        }
    }
}
