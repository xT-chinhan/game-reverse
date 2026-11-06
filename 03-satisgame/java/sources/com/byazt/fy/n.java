package com.byazt.fy;

import android.content.Context;
import com.byazt.ej.k;
import com.byazt.ej.tj;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener;
import com.bykv.vk.component.ttvideo.PreLoaderItemCallBackInfo;
import com.bykv.vk.component.ttvideo.PreloaderURLItem;
import com.bykv.vk.component.ttvideo.TTVideoEngine;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 986, 19})
public class n implements tj {
    public static Object l = new Object();
    public static volatile int n;
    public static volatile int q;
    public static volatile int qg;
    public static volatile int s;

    @Override // com.byazt.ej.tj
    public void n(Context context, final k kVar, final tj.n nVar) {
        int i;
        long jX = kVar.hd() ? 2147483647L : kVar.x();
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(kVar.wm(), kVar.l());
        Object[] objArr = new Object[4];
        Integer.valueOf(0);
        Long.valueOf(jX);
        if (cacheInfoByFilePath != null) {
            i = (jX != 2147483647L ? cacheInfoByFilePath.mCacheSizeFromZero < jX : cacheInfoByFilePath.mCacheSizeFromZero < kVar.cy() && cacheInfoByFilePath.mCacheSizeFromZero < cacheInfoByFilePath.mMediaSize) ? 0 : 1;
            Object[] objArr2 = new Object[6];
            Long.valueOf(cacheInfoByFilePath.mCacheSizeFromZero);
            Long.valueOf(cacheInfoByFilePath.mMediaSize);
            Integer.valueOf(i);
        } else {
            i = 0;
        }
        kVar.rv(i);
        PreloaderURLItem preloaderURLItem = new PreloaderURLItem(kVar.wm(), null, jX, new String[]{kVar.ou()}, kVar.l());
        preloaderURLItem.setCallBackListener(new IPreLoaderItemCallBackListener() { // from class: com.byazt.fy.n.1
            @Override // com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener
            public void preloadItemInfo(PreLoaderItemCallBackInfo preLoaderItemCallBackInfo) {
                synchronized (n.l) {
                    try {
                        if (preLoaderItemCallBackInfo == null) {
                            return;
                        }
                        int key = preLoaderItemCallBackInfo.getKey();
                        Object[] objArr3 = new Object[4];
                        Integer.valueOf(key);
                        kVar.wm();
                        if (key == 2) {
                            tj.n nVar2 = nVar;
                            if (nVar2 != null) {
                                nVar2.qg(kVar, preLoaderItemCallBackInfo.getKey());
                            }
                            n.qg++;
                        } else if (key == 3) {
                            tj.n nVar3 = nVar;
                            if (nVar3 != null) {
                                nVar3.n(kVar, preLoaderItemCallBackInfo.getKey(), "error");
                            }
                            n.s++;
                        } else if (key == 5) {
                            tj.n nVar4 = nVar;
                            if (nVar4 != null) {
                                nVar4.n(kVar, preLoaderItemCallBackInfo.getKey());
                            }
                            n.q++;
                        }
                        Object[] objArr4 = new Object[10];
                        Integer.valueOf(n.n);
                        Integer.valueOf(n.qg + n.s + n.q);
                        Integer.valueOf(n.qg);
                        Integer.valueOf(n.s);
                        Integer.valueOf(n.q);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        Object[] objArr3 = new Object[10];
        kVar.wm();
        kVar.ou();
        Boolean.valueOf(kVar.a());
        Integer.valueOf(kVar.x());
        kVar.l();
        synchronized (l) {
            n++;
        }
        TTVideoEngine.addTask(preloaderURLItem);
        Object[] objArr4 = new Object[2];
        kVar.wm();
    }
}
