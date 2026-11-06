package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.mcto.sspsdk.QyRewardProperty;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class DataLoaderHelper implements AVMDLDataLoaderListener, AVMDLStartCompleteListener {
    public static final int DATALOADER_KEY_ENABLE_ALOG = 512;
    public static final int DATALOADER_KEY_INT_MAXCACHESIZE = 1;
    public static final int DATALOADER_KEY_INT_OPENTIMEOUT = 3;
    public static final int DATALOADER_KEY_INT_PARALLEL_NUM = 11;
    public static final int DATALOADER_KEY_INT_RWTIMEOUT = 2;
    public static final int DATALOADER_KEY_INT_TRYCOUNT = 4;
    public static final int DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE = 1005;
    public static final int DATALOADER_KEY_STRING_CACHEDIR = 0;
    public static final int IsClose = 1;
    public static final int IsPlayTask = 1;
    public static final int IsPreloadTask = 2;
    public static final int IsStart = 0;
    public static final int IsUnknown = 0;
    public static final String MDL_PREFIX = "mdl://";
    private static final DataLoaderHelper p = new DataLoaderHelper();
    private static int q = 0;
    private static int r = 0;
    private static int s = 0;
    private final d b;
    private final d c;
    private final d d;
    private final d e;
    private AVMDLDataLoader i;
    private VideoEventEngineUploader k;
    private boolean m;
    private final ConcurrentHashMap<String, c> f = new ConcurrentHashMap<>();
    private final HashMap<String, ArrayList<TTVideoEngine>> g = new HashMap<>();
    private final ReentrantLock h = new ReentrantLock();
    private boolean l = true;
    private int n = 0;
    private final ReentrantLock o = new ReentrantLock();
    private volatile int a = 1;
    private AVMDLDataLoaderConfigure j = AVMDLDataLoaderConfigure.getDefaultonfigure();

    public class DataLoaderCacheInfo {
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public String mLocalFilePath = null;

        public DataLoaderCacheInfo(DataLoaderHelper dataLoaderHelper) {
        }
    }

    public static class DataLoaderTaskProgressInfo {
        public String mKey = null;
        public String mVideoId = null;
        public String mLocalFilePath = null;
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public int mTaskType = 0;
    }

    public class b {
        public String a = null;
        public long b = 0;
        public PreloaderURLItem c = null;
        public boolean d = false;
        public List<a> e = new CopyOnWriteArrayList();

        public class a {
            public String a = null;
            public String b = null;
            public String[] c = null;
            public String d = null;
            public long e = 0;
            public long f = 0;
            public long g = 0;
            public long h = 0;
            public long i = 0;

            public a(b bVar) {
            }
        }

        public b(DataLoaderHelper dataLoaderHelper) {
        }

        public a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVarB = b(str);
            if (aVarB != null) {
                return aVarB;
            }
            a aVar = new a(this);
            aVar.a = str;
            this.e.add(aVar);
            return aVar;
        }

        public IPreLoaderItemCallBackListener a() {
            PreloaderURLItem preloaderURLItem = this.c;
            if (preloaderURLItem == null || preloaderURLItem.getCallBackListener() == null) {
                return null;
            }
            return this.c.getCallBackListener();
        }

        public void a(int i) {
            if (a() != null) {
                DataLoaderHelper.c();
                int unused = DataLoaderHelper.s;
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i);
                a().preloadItemInfo(preLoaderItemCallBackInfo);
            }
        }

        public void a(String str, long j) {
            if (this.e.size() == 0) {
                a aVar = new a(this);
                aVar.a = str;
                aVar.g = j;
                this.e.add(aVar);
            } else {
                TTVideoEngineLog.e("DataLoaderHelper", "[preload] DataLoaderTaskItem setup fail");
            }
            this.b = j;
        }

        public a b(String str) {
            if (this.e.size() > 0) {
                for (int i = 0; i < this.e.size(); i++) {
                    a aVar = this.e.get(i);
                    if (aVar.a.equals(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }
    }

    public class c {
        public String a;
        public int b = 0;
        public List<a> c = null;

        public class a {
            public String e;
            public String a = null;
            public long b = 0;
            public long c = 0;
            public List<C0244a> d = null;
            public Error f = null;

            /* JADX INFO: renamed from: com.bykv.vk.component.ttvideo.DataLoaderHelper$c$a$a, reason: collision with other inner class name */
            public class C0244a {
                public long a = 0;
                public long b = 0;

                public C0244a(a aVar) {
                }
            }

            public a(c cVar) {
            }

            void a(long j) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                if (this.d.size() == 0) {
                    this.d.add(new C0244a(this));
                }
                this.d.get(0).a = 0L;
                this.d.get(0).b = j;
            }

            public boolean a() {
                long j = this.c;
                long jMin = j > 0 ? Math.min(j, this.b) : this.b;
                List<C0244a> list = this.d;
                C0244a c0244a = list != null ? list.get(list.size() - 1) : null;
                if (this.f == null) {
                    return c0244a != null && this.b > 0 && c0244a.a + c0244a.b >= jMin;
                }
                return true;
            }

            public long b() {
                List<C0244a> list = this.d;
                if (list == null || list.size() <= 0) {
                    return 0L;
                }
                List<C0244a> list2 = this.d;
                return list2.get(list2.size() - 1).b;
            }
        }

        public c(DataLoaderHelper dataLoaderHelper) {
        }

        private a a(String str) {
            List<a> list;
            if (!TextUtils.isEmpty(str) && (list = this.c) != null) {
                for (a aVar : list) {
                    if (aVar.a.equals(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }

        public long a() {
            long jB = 0;
            if (this.c != null) {
                for (int i = 0; i < this.c.size(); i++) {
                    jB += this.c.get(i).b();
                }
            }
            return jB;
        }

        public void a(b bVar) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            for (b.a aVar : bVar.e) {
                boolean z = true;
                a aVarA = a(aVar.a);
                if (aVarA == null) {
                    aVarA = new a(this);
                    z = false;
                }
                aVarA.a = aVar.a;
                aVarA.b = aVar.h;
                aVarA.a(aVar.i);
                aVarA.c = aVar.g;
                aVarA.e = aVar.d;
                if (!z) {
                    this.c.add(aVarA);
                }
            }
        }

        public void a(String str, Error error) {
            a aVarA = a(str);
            if (aVarA != null) {
                aVarA.f = error;
            }
        }

        public boolean b() {
            int i;
            boolean z;
            if (this.c != null) {
                i = 0;
                z = true;
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    a aVar = this.c.get(i2);
                    if (aVar == null || aVar.a()) {
                        i++;
                    } else {
                        z = false;
                    }
                }
            } else {
                i = 0;
                z = true;
            }
            return z || (i >= 2 && this.b == 1);
        }

        public boolean c() {
            if (this.b != 2) {
                return false;
            }
            if (this.c != null) {
                for (int i = 0; i < this.c.size(); i++) {
                    a aVar = this.c.get(i);
                    if (aVar != null && !aVar.a()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private class d {
        private final ReentrantLock a;
        private final ArrayList<b> b;
        private long c;

        private d(DataLoaderHelper dataLoaderHelper) {
            this.a = new ReentrantLock();
            this.b = new ArrayList<>();
            this.c = 0L;
        }

        private Boolean e() {
            if (this.c >= 1) {
                return Boolean.valueOf(((long) this.b.size()) >= this.c);
            }
            return Boolean.FALSE;
        }

        public b a() {
            this.a.lock();
            if (this.b.size() == 0) {
                this.a.unlock();
                return null;
            }
            ArrayList<b> arrayList = this.b;
            b bVar = arrayList.get(arrayList.size() - 1);
            this.a.unlock();
            return bVar;
        }

        public void a(long j) {
            this.c = j;
        }

        boolean a(b bVar) {
            Boolean bool;
            if (bVar == null || bVar.e.size() == 0) {
                return false;
            }
            this.a.lock();
            if (e().booleanValue()) {
                bool = Boolean.FALSE;
            } else {
                this.b.add(bVar);
                bool = Boolean.TRUE;
            }
            this.a.unlock();
            return bool.booleanValue();
        }

        public boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean bool = Boolean.FALSE;
            this.a.lock();
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).b(str) != null) {
                    bool = Boolean.TRUE;
                    break;
                }
            }
            this.a.unlock();
            return bool.booleanValue();
        }

        public long b() {
            this.a.lock();
            long size = this.b.size();
            this.a.unlock();
            return size;
        }

        public b b(b bVar) {
            b bVarC;
            if (TextUtils.isEmpty(bVar.a)) {
                bVarC = null;
            } else {
                bVarC = d(bVar.a);
                if (bVarC != null) {
                    return bVarC;
                }
            }
            Iterator<b.a> it = bVar.e.iterator();
            while (it.hasNext() && (bVarC = c(it.next().a)) == null) {
            }
            return bVarC;
        }

        public b b(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.a.lock();
            for (int i = 0; i < this.b.size(); i++) {
                b bVar2 = this.b.get(i);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
            }
            this.a.unlock();
            return bVar;
        }

        public b c() {
            this.a.lock();
            if (this.b.size() == 0) {
                this.a.unlock();
                return null;
            }
            ArrayList<b> arrayList = this.b;
            b bVar = arrayList.get(arrayList.size() - 1);
            this.b.remove(bVar);
            this.a.unlock();
            return bVar;
        }

        public b c(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.a.lock();
            for (int i = 0; i < this.b.size(); i++) {
                b bVar2 = this.b.get(i);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
            }
            if (bVar != null) {
                this.b.remove(bVar);
            }
            this.a.unlock();
            return bVar;
        }

        public b d(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.a.lock();
            for (int i = 0; i < this.b.size(); i++) {
                b bVar2 = this.b.get(i);
                if (!TextUtils.isEmpty(bVar2.a) && bVar2.a.equals(str)) {
                    bVar = bVar2;
                    break;
                }
            }
            if (bVar != null) {
                this.b.remove(bVar);
            }
            this.a.unlock();
            return bVar;
        }

        public ArrayList<b> d() {
            try {
                this.a.lock();
                return new ArrayList<>(this.b);
            } finally {
                this.a.unlock();
            }
        }
    }

    private DataLoaderHelper() {
        this.b = new d();
        this.c = new d();
        this.d = new d();
        this.e = new d();
    }

    private String a(String str, String str2, long j, long j2, String[] strArr, String str3) {
        String strEncode;
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        if (j2 <= 0) {
            j2 = 0;
        }
        for (String str4 : strArr2) {
            if (!c(str4)) {
                return null;
            }
        }
        String[] strArrA = a(strArr2);
        String strEncodeUrl = encodeUrl(str);
        if (TextUtils.isEmpty(strEncodeUrl)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        String strEncodeUrl2 = encodeUrl(str);
        if (TextUtils.isEmpty(strEncodeUrl2)) {
            strEncodeUrl2 = QyRewardProperty.VERIFY_VIDEOID;
        }
        StringBuffer stringBuffer = new StringBuffer("?rk=");
        stringBuffer.append(strEncodeUrl2).append("&k=").append(strEncodeUrl);
        if (j2 > 0) {
            stringBuffer.append("&s=").append(j + j2);
        }
        if (!TextUtils.isEmpty(str3)) {
            try {
                strEncode = URLEncoder.encode(str3, Key.STRING_CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                strEncode = null;
            }
            if (!TextUtils.isEmpty(strEncode)) {
                stringBuffer.append("&p=");
                stringBuffer.append(strEncode);
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i = 0; i < strArrA.length; i++) {
            String strEncodeUrlByQuery = encodeUrlByQuery(strArrA[i]);
            StringBuffer stringBuffer3 = new StringBuffer();
            if (!TextUtils.isEmpty(strEncodeUrlByQuery)) {
                stringBuffer3.append("&u").append(i).append("=").append(strEncodeUrlByQuery);
            }
            if (stringBuffer.length() + stringBuffer2.length() + stringBuffer3.length() + 32 > 3096) {
                break;
            }
            stringBuffer2.append(stringBuffer3);
        }
        if (stringBuffer2.length() <= 0) {
            return null;
        }
        stringBuffer.append(stringBuffer2);
        return stringBuffer.toString();
    }

    private ArrayList<TTVideoEngine> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            this.h.lock();
            ArrayList<TTVideoEngine> arrayList = this.g.get(str);
            if (arrayList == null) {
                return null;
            }
            ArrayList<TTVideoEngine> arrayList2 = new ArrayList<>(arrayList);
            arrayList2.size();
            return arrayList2;
        } finally {
            this.h.unlock();
        }
    }

    private void a() {
        if (this.i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        b bVarA = this.b.a();
        if (bVarA != null && this.c.a(bVarA)) {
            this.b.c();
            if (bVarA.c != null) {
                b(bVarA);
            }
        }
    }

    private void a(b bVar) {
        boolean z;
        ArrayList<TTVideoEngine> arrayListA;
        ArrayList<b> arrayListD = this.e.d();
        int i = 0;
        while (true) {
            if (i >= arrayListD.size()) {
                z = true;
                break;
            }
            b bVar2 = arrayListD.get(i);
            if (!TextUtils.isEmpty(bVar2.a) && !TextUtils.isEmpty(bVar.a) && bVar2.a.equals(bVar.a)) {
                z = false;
                break;
            }
            i++;
        }
        if (!z || (arrayListA = a(bVar.a)) == null || arrayListA.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayListA.size(); i2++) {
            arrayListA.get(i2).a();
        }
    }

    private void a(b bVar, b.a aVar) {
        if (bVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. item is null");
            return;
        }
        if (aVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. track is null");
            notifyPreloadError(bVar.c, -100004);
            return;
        }
        String str = aVar.a;
        String[] strArr = aVar.c;
        if (strArr != null) {
            String strA = a(str, bVar.a, aVar.f, 0L, strArr, aVar.d);
            aVar.b = strA;
            if (!TextUtils.isEmpty(strA)) {
                this.d.a(bVar);
                if (aVar.f > 0) {
                    long j = aVar.e;
                    if (j > 0) {
                        this.i.preloadResource(aVar.b, (int) j);
                    }
                    this.i.preloadResource(aVar.b, (int) aVar.f, (int) aVar.g);
                } else {
                    this.i.preloadResource(aVar.b, (int) aVar.g);
                }
                String.format("[preload] exect preload task ,key is %s; videoId = %s", aVar.a, bVar.a);
                return;
            }
        }
        bVar.a(-100001);
    }

    private void a(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo, boolean z, boolean z2) {
        b bVarB;
        d dVar;
        if (aVMDLDataLoaderNotifyInfo == null || TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
            return;
        }
        String[] strArrSplit = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
        if (strArrSplit.length < 4) {
            return;
        }
        boolean z3 = false;
        try {
            long jLongValue = Long.valueOf(strArrSplit[0]).longValue();
            long jLongValue2 = Long.valueOf(strArrSplit[1]).longValue();
            if (jLongValue2 > 0 || z2) {
                String str = strArrSplit[2];
                String str2 = strArrSplit[3];
                if (z || z2) {
                    bVarB = this.d.b(str);
                    if (bVarB == null) {
                        return;
                    }
                    dVar = this.d;
                    z3 = true;
                } else {
                    bVarB = this.e.b(str);
                    if (bVarB == null) {
                        return;
                    } else {
                        dVar = this.e;
                    }
                }
                b.a aVarB = bVarB.b(str);
                if (aVarB != null) {
                    aVarB.h = jLongValue2;
                    aVarB.i = jLongValue;
                    aVarB.d = str2;
                }
                String str3 = TextUtils.isEmpty(bVarB.a) ? str : bVarB.a;
                c loadProgressByRawKey = getLoadProgressByRawKey(str3);
                if (loadProgressByRawKey == null) {
                    loadProgressByRawKey = new c(this);
                }
                loadProgressByRawKey.a = bVarB.a;
                loadProgressByRawKey.b = z ? 2 : 1;
                loadProgressByRawKey.a(bVarB);
                putByRawKey(str3, loadProgressByRawKey);
                if (loadProgressByRawKey.b() || z2) {
                    if (!z3) {
                        dVar.c(str);
                    }
                    removeLoadProgressByRawKey(str3);
                    if (!z) {
                        a(bVarB);
                    }
                    if (bVarB.a() == null || !z2) {
                        return;
                    }
                    s++;
                    dVar.c(str);
                    DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo = new DataLoaderTaskProgressInfo();
                    dataLoaderTaskProgressInfo.mCacheSizeFromZero = jLongValue;
                    dataLoaderTaskProgressInfo.mMediaSize = jLongValue2;
                    dataLoaderTaskProgressInfo.mKey = str;
                    dataLoaderTaskProgressInfo.mLocalFilePath = str2;
                    dataLoaderTaskProgressInfo.mVideoId = bVarB.a;
                    dataLoaderTaskProgressInfo.mTaskType = loadProgressByRawKey.b;
                    PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(2);
                    preLoaderItemCallBackInfo.preloadDataInfo = dataLoaderTaskProgressInfo;
                    preLoaderItemCallBackInfo.loadProgress = loadProgressByRawKey;
                    bVarB.a().preloadItemInfo(preLoaderItemCallBackInfo);
                    loadProgressByRawKey.a();
                }
            }
        } catch (Exception e) {
        }
    }

    private void a(String str, String str2, long j, PreloaderURLItem preloaderURLItem) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] key invalid.");
            notifyPreloadError(preloaderURLItem, -100001);
            return;
        }
        if (this.i == null || this.a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            notifyPreloadError(preloaderURLItem, -100002);
        } else {
            if (this.c.a(str) || this.b.a(str)) {
                notifyPreloadError(preloaderURLItem, -100003);
                return;
            }
            b bVar = new b(this);
            bVar.a(str, j);
            bVar.a = str2;
            bVar.c = preloaderURLItem;
            this.b.a(bVar);
            a();
        }
    }

    private boolean a(d dVar) {
        boolean z = false;
        if (dVar.b() > 0) {
            while (true) {
                b bVarC = dVar.c();
                if (bVarC == null) {
                    break;
                }
                z = true;
                c(bVarC);
            }
        }
        return z;
    }

    private String[] a(String[] strArr) {
        if (strArr == null || strArr.length <= 1) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            String str = strArr[i];
            Boolean bool = Boolean.TRUE;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((String) arrayList.get(size)).equals(str)) {
                    bool = Boolean.FALSE;
                    break;
                }
            }
            if (bool.booleanValue()) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        return strArr2;
    }

    private DataLoaderCacheInfo b(String str) {
        DataLoaderCacheInfo dataLoaderCacheInfo = null;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length >= 4) {
            dataLoaderCacheInfo = new DataLoaderCacheInfo(this);
            dataLoaderCacheInfo.mLocalFilePath = strArrSplit[3];
            if (!TextUtils.isEmpty(strArrSplit[0])) {
                dataLoaderCacheInfo.mCacheSizeFromZero = Long.parseLong(strArrSplit[0]);
            }
            if (!TextUtils.isEmpty(strArrSplit[1])) {
                dataLoaderCacheInfo.mMediaSize = Long.parseLong(strArrSplit[1]);
            }
        }
        return dataLoaderCacheInfo;
    }

    private void b(b bVar) {
        if (bVar == null) {
            a();
            return;
        }
        if (this.i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        this.c.b(bVar);
        long j = bVar.b;
        PreloaderURLItem preloaderURLItem = bVar.c;
        if (preloaderURLItem != null && preloaderURLItem.getUrls() != null && bVar.c.getUrls().length > 0) {
            b.a aVar = bVar.e.get(0);
            aVar.c = bVar.c.getUrls();
            aVar.g = bVar.b;
            aVar.d = bVar.c.getFilePath();
            a(bVar, aVar);
        }
        if (bVar.a() != null) {
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(6);
            preLoaderItemCallBackInfo.preloadType = 0;
            preLoaderItemCallBackInfo.videoPreloadSize = j;
            preLoaderItemCallBackInfo.audioPreloadSize = 0L;
            bVar.a().preloadItemInfo(preLoaderItemCallBackInfo);
        }
        a();
    }

    static /* synthetic */ int c() {
        int i = s;
        s = i + 1;
        return i;
    }

    private void c(b bVar) {
        if (bVar == null || bVar.d) {
            return;
        }
        bVar.d = true;
        if (bVar.a() != null) {
            s++;
            bVar.a().preloadItemInfo(new PreLoaderItemCallBackInfo(5));
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith(MDL_PREFIX) || lowerCase.startsWith("file://") || lowerCase.startsWith("/") || lowerCase.endsWith(".mpd") || lowerCase.contains(".mpd?")) ? false : true;
    }

    private boolean d() {
        if (this.i != null) {
            return true;
        }
        if (AVMDLDataLoader.init(false, false) != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "library has not been loaded");
            return false;
        }
        try {
            AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
            this.i = aVMDLDataLoader;
            aVMDLDataLoader.setConfigure(this.j);
            this.i.setListener(this);
            this.i.setStartCompleteListener(this);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String encodeUrlByQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String strQueryComponentEncode = AVMDLDataLoader.queryComponentEncode(str);
            return TextUtils.isEmpty(strQueryComponentEncode) ? URLEncoder.encode(str, Key.STRING_CHARSET_NAME) : strQueryComponentEncode;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static DataLoaderHelper getDataLoader() {
        return p;
    }

    public void _addEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.h.lock();
            ArrayList<TTVideoEngine> arrayList = this.g.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.g.put(str, arrayList);
            }
            if (!arrayList.contains(tTVideoEngine)) {
                arrayList.add(tTVideoEngine);
                arrayList.size();
            }
        } finally {
            this.h.unlock();
        }
    }

    public String _proxyUrl(String str, String str2, long j, String[] strArr, String str3) {
        if (this.a != 0 || TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (String str4 : strArr2) {
            if (!c(str4)) {
                return str4;
            }
        }
        if (this.i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "start mdl first");
            return null;
        }
        this.o.lock();
        try {
            String localAddr = this.i.getLocalAddr();
            if (TextUtils.isEmpty(localAddr)) {
                TTVideoEngineLog.e("DataLoaderHelper", "local host error");
                this.o.unlock();
                return null;
            }
            String strA = a(str, str2, 0L, j, strArr2, str3);
            if (TextUtils.isEmpty(strA)) {
                this.o.unlock();
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i = this.n;
            this.n = i + 1;
            StringBuffer stringBuffer2 = new StringBuffer();
            if (this.l || !this.m) {
                stringBuffer.append("http://").append(localAddr).append("/").append(i);
            } else {
                stringBuffer.append("mdl://id").append(i).append("/");
            }
            stringBuffer.append(strA);
            stringBuffer2.append(strA);
            String auth = this.i.getAuth(strA);
            if (!TextUtils.isEmpty(auth)) {
                stringBuffer.append("&ah=").append(auth).append("&ah=").append(auth);
            }
            String string = stringBuffer.toString();
            this.o.unlock();
            b bVarD = this.e.d(str2);
            if (bVarD == null) {
                bVarD = new b(this);
            }
            b.a aVarA = bVarD.a(str);
            if (aVarA != null) {
                aVarA.a = str;
                bVarD.a = str2;
                aVarA.b = string;
                aVarA.c = strArr2;
                aVarA.d = str3;
                this.e.a(bVarD);
            }
            return string;
        } catch (Throwable th) {
            this.o.unlock();
            throw th;
        }
    }

    public void _removeEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.h.lock();
            ArrayList<TTVideoEngine> arrayList = this.g.get(str);
            if (arrayList != null) {
                arrayList.remove(tTVideoEngine);
                arrayList.size();
                if (arrayList.size() == 0) {
                    this.g.remove(str);
                }
            }
        } finally {
            this.h.unlock();
        }
    }

    public void _removePlayTask(String str) {
        this.e.c(str);
    }

    public void addTask(PreloaderURLItem preloaderURLItem) {
        q++;
        if (preloaderURLItem == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] url item invalid");
            return;
        }
        this.o.lock();
        try {
            a(preloaderURLItem.getKey(), preloaderURLItem.getVideoId(), preloaderURLItem.getPreloadSize(), preloaderURLItem);
        } finally {
            this.o.unlock();
        }
    }

    public void cancelAllTasks() {
        if (this.i == null || this.a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.o.lock();
        try {
            cancelAllTasksInternal();
            this.o.unlock();
        } catch (Throwable th) {
            this.o.unlock();
        }
    }

    public void cancelAllTasksInternal() {
        a(this.c);
        a(this.b);
        if (a(this.d)) {
            this.i.cancelAll();
        }
    }

    public void cancelTask(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.i == null || this.a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.o.lock();
        try {
            b bVarC = this.b.c(str);
            if (bVarC == null && (bVarC = this.c.c(str)) == null) {
                bVarC = this.d.c(str);
                if (bVarC != null) {
                    this.i.cancel(str);
                    c(bVarC);
                }
            } else {
                c(bVarC);
            }
            this.o.unlock();
        } catch (Throwable th) {
            this.o.unlock();
        }
    }

    public void clearAllCaches() {
        if (this.a != 0) {
            return;
        }
        this.o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.i;
            if (aVMDLDataLoader == null) {
                TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            } else {
                aVMDLDataLoader.clearAllCaches();
            }
        } catch (Throwable th) {
        }
        this.o.unlock();
    }

    public void close() {
        this.o.lock();
        try {
            if (this.a == 1) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader not started, not need close");
            } else {
                this.i.close();
                cancelAllTasksInternal();
                this.a = 1;
            }
        } finally {
            this.o.unlock();
        }
    }

    public DataLoaderCacheInfo getCacheInfoByFilePath(String str, String str2) {
        this.o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.i;
            if (aVMDLDataLoader != null) {
                DataLoaderCacheInfo dataLoaderCacheInfoB = b(aVMDLDataLoader.getStringCacheInfo(str, str2));
                this.o.unlock();
                return dataLoaderCacheInfoB;
            }
        } catch (Throwable th) {
        }
        this.o.unlock();
        return null;
    }

    public long getCacheSize(String str) {
        long j = 0;
        if (this.a != 0) {
            return 0L;
        }
        this.o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.i;
            if (aVMDLDataLoader != null) {
                long cacheSize = aVMDLDataLoader.getCacheSize(str);
                if (cacheSize > 0) {
                    j = cacheSize;
                }
            }
        } catch (Throwable th) {
        }
        this.o.unlock();
        return j;
    }

    public long getCacheSizeByFilePath(String str, String str2) {
        this.o.lock();
        long j = 0;
        try {
            DataLoaderCacheInfo cacheInfoByFilePath = getCacheInfoByFilePath(str, str2);
            if (cacheInfoByFilePath != null) {
                j = cacheInfoByFilePath.mCacheSizeFromZero;
            }
        } catch (Throwable th) {
        }
        this.o.unlock();
        return j;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String str) {
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int i, long j) {
        return 0L;
    }

    public c getLoadProgressByRawKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f.get(str);
        }
        TTVideoEngineLog.e("DataLoaderHelper", "[preload] get, param is invalid key is null");
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int i, long j, String str) {
        return null;
    }

    public void notifyPreloadError(PreloaderURLItem preloaderURLItem, int i) {
        IPreLoaderItemCallBackListener callBackListener = preloaderURLItem.getCallBackListener();
        if (callBackListener != null) {
            s++;
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
            preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i);
            callBackListener.preloadItemInfo(preLoaderItemCallBackInfo);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        String str;
        b bVarB;
        if (aVMDLDataLoaderNotifyInfo == null) {
            return;
        }
        int i = aVMDLDataLoaderNotifyInfo.what;
        if (i != 0 && i != 15) {
            if (i != 20) {
                if (i == 3 || i == 4) {
                    if (aVMDLDataLoaderNotifyInfo.what == 4) {
                        r++;
                    }
                    if (aVMDLDataLoaderNotifyInfo.logInfo != null) {
                        long j = aVMDLDataLoaderNotifyInfo.parameter;
                        if (j != 3) {
                            a(aVMDLDataLoaderNotifyInfo, j == 2, aVMDLDataLoaderNotifyInfo.what == 4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i == 7) {
                    r++;
                    if (TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
                        return;
                    }
                    String[] strArrSplit = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                    if (strArrSplit.length < 4) {
                        return;
                    }
                    String str2 = strArrSplit[2];
                    b bVarB2 = this.d.b(str2);
                    this.d.c(str2);
                    c(bVarB2);
                    return;
                }
                if (i != 8) {
                    if (i != 10 && i != 11) {
                        return;
                    }
                }
            }
            if (aVMDLDataLoaderNotifyInfo.what == 8) {
                r++;
            }
            if ((aVMDLDataLoaderNotifyInfo.logInfo == null || aVMDLDataLoaderNotifyInfo.parameter != 3) && aVMDLDataLoaderNotifyInfo.logInfo != null) {
                String[] strArrSplit2 = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                if (strArrSplit2.length > 0 && (bVarB = this.d.b((str = strArrSplit2[0]))) != null) {
                    d dVar = this.d;
                    Error error = new Error(Error.DataLoaderPreload, (int) aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.logInfo);
                    String str3 = TextUtils.isEmpty(bVarB.a) ? str : bVarB.a;
                    c loadProgressByRawKey = getLoadProgressByRawKey(str3);
                    if (loadProgressByRawKey == null) {
                        loadProgressByRawKey = new c(this);
                    }
                    loadProgressByRawKey.a = bVarB.a;
                    loadProgressByRawKey.b = (int) aVMDLDataLoaderNotifyInfo.parameter;
                    loadProgressByRawKey.a(bVarB);
                    loadProgressByRawKey.a(str, error);
                    putByRawKey(str3, loadProgressByRawKey);
                    if (!loadProgressByRawKey.b() && !loadProgressByRawKey.c()) {
                        loadProgressByRawKey.b();
                        loadProgressByRawKey.c();
                        return;
                    }
                    dVar.c(str);
                    removeLoadProgressByRawKey(str3);
                    if (bVarB.a() == null || aVMDLDataLoaderNotifyInfo.parameter != 2) {
                        return;
                    }
                    PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                    preLoaderItemCallBackInfo.preloadError = error;
                    preLoaderItemCallBackInfo.loadProgress = loadProgressByRawKey;
                    preLoaderItemCallBackInfo.preloadDataInfo = null;
                    s++;
                    bVarB.a().preloadItemInfo(preLoaderItemCallBackInfo);
                    return;
                }
                return;
            }
            return;
        }
        VideoEventEngineUploader videoEventEngineUploader = this.k;
        if (videoEventEngineUploader != null) {
            videoEventEngineUploader.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener
    public void onStartComplete() {
    }

    public void putByRawKey(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] param is invalid");
        } else {
            this.f.put(str, cVar);
        }
    }

    public void removeCacheFile(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.i;
            if (aVMDLDataLoader == null) {
                TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            } else if (z) {
                aVMDLDataLoader.forceRemoveFileCache(str);
            } else {
                aVMDLDataLoader.removeFileCache(str);
            }
        } catch (Throwable th) {
        }
        this.o.unlock();
    }

    public void removeLoadProgressByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] remove, param is invalid key is null");
        } else {
            this.f.remove(str);
        }
    }

    public void setCacheInfoLists(String[] strArr, long[] jArr) {
        Arrays.toString(strArr);
        Arrays.toString(jArr);
        this.o.lock();
        try {
            this.j.setCacheInfoList(strArr, jArr);
        } finally {
            this.o.unlock();
        }
    }

    public void setContext(Context context) {
        this.o.lock();
        this.o.unlock();
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader videoEventEngineUploader) {
        this.k = videoEventEngineUploader;
    }

    public void setIntValue(int i, int i2) {
        this.o.lock();
        try {
            if (i == 11) {
                this.j.mPreloadParallelNum = i2;
                AVMDLDataLoader aVMDLDataLoader = this.i;
                if (aVMDLDataLoader != null) {
                    aVMDLDataLoader.setIntValue(102, i2);
                }
            } else if (i == 512) {
                this.j.mAlogEnable = i2;
                AVMDLDataLoader aVMDLDataLoader2 = this.i;
                if (aVMDLDataLoader2 != null) {
                    aVMDLDataLoader2.setIntValue(AVMDLDataLoader.KeyIsAlogEnable, i2);
                }
            } else if (i != 1005) {
                switch (i) {
                    case 1:
                        this.j.mMaxCacheSize = i2;
                        break;
                    case 2:
                        this.j.mRWTimeOut = i2;
                        break;
                    case 3:
                        this.j.mOpenTimeOut = i2;
                        break;
                    case 4:
                        this.j.mTryCount = i2;
                        break;
                    default:
                }
            } else {
                boolean z = true;
                if (i2 != 1) {
                    z = false;
                }
                this.m = z;
            }
        } catch (Exception e) {
        } finally {
            this.o.unlock();
        }
    }

    public void setStringValue(int i, String str) {
        this.o.lock();
        if (i == 0) {
            try {
                this.j.mCacheDir = str;
            } catch (Exception e) {
            } finally {
                this.o.unlock();
            }
        }
    }

    public void start() {
        this.o.lock();
        try {
            if (this.a == 0) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader has started not need start");
            } else {
                if (!d()) {
                    throw new Exception("init data loader fail");
                }
                this.c.a(4L);
                if (this.j == null) {
                    this.j = AVMDLDataLoaderConfigure.getDefaultonfigure();
                }
                if (this.k != null) {
                    this.j.mEnableReportTaskLog = 1;
                }
                this.i.setConfigure(this.j);
                if (this.i.start() < 0) {
                    throw new Exception("start data loader fail");
                }
                if (this.i.getLongValue(AVMDLDataLoader.KeyIsGetMdlProtocolHandle) == -1) {
                    this.l = true;
                }
                this.a = 0;
            }
            this.o.unlock();
        } catch (Throwable th) {
            this.o.unlock();
            throw th;
        }
    }
}
