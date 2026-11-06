package com.bytedance.sdk.component.sl.xr.xr;

import android.content.Context;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener;
import com.bykv.vk.component.ttvideo.PreLoaderItemCallBackInfo;
import com.bykv.vk.component.ttvideo.PreloaderURLItem;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bykv.vk.openvk.component.video.api.c.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bykv.vk.openvk.component.video.api.ka.ms {
    public static volatile int ah;
    public static volatile int d;
    private static Object ka = new Object();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile int f1346ms;
    public static volatile int xr;

    /* JADX WARN: Code duplicated, block: B:10:0x0022 A[PHI: r1
      0x0022: PHI (r1v3 long) = (r1v2 long), (r1v11 long) binds: [B:6:0x0015, B:8:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bykv.vk.openvk.component.video.api.ka.ms
    public void ms(Context context, final d dVar, final com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms) {
        long j;
        int i;
        long jC = dVar.c();
        if (dVar.zb()) {
            jC = 2147483647L;
        }
        int iXr = dVar.xr();
        if (iXr > 0) {
            jC = iXr;
            if (jC >= dVar.sl()) {
                j = 2147483647L;
            } else {
                j = jC;
            }
        } else {
            j = jC;
        }
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(dVar.h(), dVar.ka());
        ah.ms("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload: sourceType = ", 0, " preloadSize = ", Long.valueOf(j));
        if (cacheInfoByFilePath != null) {
            i = (j != 2147483647L ? cacheInfoByFilePath.mCacheSizeFromZero < j : cacheInfoByFilePath.mCacheSizeFromZero < dVar.sl() && cacheInfoByFilePath.mCacheSizeFromZero < cacheInfoByFilePath.mMediaSize) ? 0 : 1;
            ah.ms("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload: cacheInfo.mCacheSizeFromZero = ", Long.valueOf(cacheInfoByFilePath.mCacheSizeFromZero), " cacheInfo.mMediaSize = ", Long.valueOf(cacheInfoByFilePath.mMediaSize), " sourceType = ", Integer.valueOf(i));
        } else {
            i = 0;
        }
        dVar.ny(i);
        PreloaderURLItem preloaderURLItem = new PreloaderURLItem(dVar.h(), null, j, new String[]{dVar.ao()}, dVar.ka());
        preloaderURLItem.setCallBackListener(new IPreLoaderItemCallBackListener() { // from class: com.bytedance.sdk.component.sl.xr.xr.ms.1
            @Override // com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener
            public void preloadItemInfo(PreLoaderItemCallBackInfo preLoaderItemCallBackInfo) {
                synchronized (ms.ka) {
                    try {
                        if (preLoaderItemCallBackInfo == null) {
                            return;
                        }
                        int key = preLoaderItemCallBackInfo.getKey();
                        ah.ms("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload: callback key =", Integer.valueOf(key), "  fileHash =", dVar.h());
                        if (key == 2) {
                            com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms2 = interfaceC0178ms;
                            if (interfaceC0178ms2 != null) {
                                interfaceC0178ms2.ms(dVar, preLoaderItemCallBackInfo.getKey());
                            }
                            ms.xr++;
                        } else if (key == 3) {
                            com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms3 = interfaceC0178ms;
                            if (interfaceC0178ms3 != null) {
                                interfaceC0178ms3.ms(dVar, preLoaderItemCallBackInfo.getKey(), "error");
                            }
                            ms.ah++;
                        } else if (key == 5) {
                            com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms4 = interfaceC0178ms;
                            if (interfaceC0178ms4 != null) {
                                interfaceC0178ms4.xr(dVar, preLoaderItemCallBackInfo.getKey());
                            }
                            ms.d++;
                        }
                        ah.ms("TTVideoPreloadImp", "preloadItemInfo:  preTime = ", Integer.valueOf(ms.f1346ms), "  callback =", Integer.valueOf(ms.xr + ms.ah + ms.d), "  callback2 =", Integer.valueOf(ms.xr), "  callback3=", Integer.valueOf(ms.ah), "  callback5 =", Integer.valueOf(ms.d));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        ah.ms("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload start: fileName = ", dVar.h(), " url =", dVar.ao(), " isH265=", Boolean.valueOf(dVar.u()), " presize=", Integer.valueOf(dVar.c()), " path=", dVar.ka());
        synchronized (ka) {
            f1346ms++;
        }
        TTVideoEngine.addTask(preloaderURLItem);
        ah.ms("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload end: fileName = ", dVar.h());
    }
}
