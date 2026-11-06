package com.smartdigimkt.dlpd;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.j.h;
import com.smartdigimkt.j.u;
import com.smartdigimkt.k.a0;
import com.smartdigimkt.k.b0;
import com.smartdigimkt.k.c;
import com.smartdigimkt.k.l;
import com.smartdigimkt.k.n;
import com.smartdigimkt.k.o;
import com.smartdigimkt.k.r;
import com.smartdigimkt.n.b;
import com.smartdigimkt.p.a;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.j;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.IExHandlerBaseAd;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ExHandlerBaseAd implements IExHandlerBaseAd {
    private static final String TAG = "ExHandlerBaseAd";
    private final b0 apkManager;
    private volatile boolean haveRecoverDownload = false;
    private CopyOnWriteArrayList<IExHandlerBaseAd.DataFetchListener> uniqueIdDownloadListenerList = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: com.smartdigimkt.dlpd.ExHandlerBaseAd$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$smartdigimkt$dlopt$common$download$ApkDownloadConst$Status;

        static {
            int[] iArr = new int[c.values().length];
            $SwitchMap$com$smartdigimkt$dlopt$common$download$ApkDownloadConst$Status = iArr;
            try {
                iArr[5] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smartdigimkt$dlopt$common$download$ApkDownloadConst$Status[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smartdigimkt$dlopt$common$download$ApkDownloadConst$Status[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smartdigimkt$dlopt$common$download$ApkDownloadConst$Status[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smartdigimkt$dlopt$common$download$ApkDownloadConst$Status[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$smartdigimkt$dlopt$common$download$ApkDownloadConst$Status[1] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$smartdigimkt$dlopt$common$download$ApkDownloadConst$Status[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ExHandlerBaseAd(b0 b0Var) {
        this.apkManager = b0Var;
        if (b0Var != null) {
            ((u) b0Var).r = new a0() { // from class: com.smartdigimkt.dlpd.ExHandlerBaseAd.1
                @Override // com.smartdigimkt.k.a0
                public void onStatusChanged(r rVar) {
                    if (rVar == null) {
                        return;
                    }
                    final c cVar = rVar.s;
                    final String str = rVar.o;
                    if (ExHandlerBaseAd.this.uniqueIdDownloadListenerList != null) {
                        final List listFindDataFetchListener = ExHandlerBaseAd.this.findDataFetchListener(rVar.j);
                        f.a().a(new Runnable() { // from class: com.smartdigimkt.dlpd.ExHandlerBaseAd.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (listFindDataFetchListener.size() > 0) {
                                    for (int i = 0; i < listFindDataFetchListener.size(); i++) {
                                        IExHandlerBaseAd.DataFetchListener dataFetchListener = (IExHandlerBaseAd.DataFetchListener) listFindDataFetchListener.get(i);
                                        if (dataFetchListener != null) {
                                            com.smartdigimkt.b3.c baseAdContent = dataFetchListener.getBaseAdContent();
                                            if (baseAdContent != null) {
                                                baseAdContent.D = ExHandlerBaseAd.this.convertToApkDownloadStatus(cVar);
                                            }
                                            String strA = b.a(SDKContext.getInstance().d(), cVar);
                                            if (!TextUtils.isEmpty(strA)) {
                                                if (baseAdContent != null) {
                                                    baseAdContent.h = strA;
                                                }
                                                dataFetchListener.onStatusChanged(ExHandlerBaseAd.this.convertToApkDownloadStatus(cVar), strA);
                                            }
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int convertToApkDownloadStatus(c cVar) {
        switch (AnonymousClass4.$SwitchMap$com$smartdigimkt$dlopt$common$download$ApkDownloadConst$Status[cVar.ordinal()]) {
            case 1:
                return 6;
            case 2:
                return 1;
            case 3:
            case 4:
                return 7;
            case 5:
                return 5;
            case 6:
                return 4;
            case 7:
                return 2;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<IExHandlerBaseAd.DataFetchListener> findDataFetchListener(com.smartdigimkt.b3.c cVar) {
        ArrayList arrayList = new ArrayList();
        if (this.uniqueIdDownloadListenerList != null && cVar != null) {
            String strA = j.a(cVar);
            for (IExHandlerBaseAd.DataFetchListener dataFetchListener : this.uniqueIdDownloadListenerList) {
                if (dataFetchListener.getBaseAdContent() != null && TextUtils.equals(j.a(dataFetchListener.getBaseAdContent()), strA)) {
                    String str = dataFetchListener.getBaseAdContent().x;
                    arrayList.add(dataFetchListener);
                }
            }
        }
        return arrayList;
    }

    private String getListenerKey(com.smartdigimkt.b3.c cVar) {
        return a.a(j.a(cVar), cVar.x);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public void addDataFetchListener(final IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        f.a().b(new Runnable() { // from class: com.smartdigimkt.dlpd.ExHandlerBaseAd.2
            @Override // java.lang.Runnable
            public void run() {
                ConcurrentHashMap concurrentHashMap;
                IExHandlerBaseAd.DataFetchListener dataFetchListener2 = dataFetchListener;
                if (dataFetchListener2 == null || dataFetchListener2.getBaseAdContent() == null) {
                    return;
                }
                com.smartdigimkt.b3.c baseAdContent = dataFetchListener.getBaseAdContent();
                if (ExHandlerBaseAd.this.uniqueIdDownloadListenerList != null) {
                    ExHandlerBaseAd.this.uniqueIdDownloadListenerList.add(dataFetchListener);
                }
                if (baseAdContent != null) {
                    ExHandlerBaseAd exHandlerBaseAd = ExHandlerBaseAd.this;
                    u uVar = (u) exHandlerBaseAd.apkManager;
                    uVar.getClass();
                    String strA = j.a(baseAdContent);
                    r rVar = null;
                    if (!TextUtils.isEmpty(strA)) {
                        int i = 0;
                        while (true) {
                            if (i >= uVar.b.size()) {
                                ConcurrentHashMap concurrentHashMap2 = uVar.c;
                                rVar = concurrentHashMap2 != null ? (r) concurrentHashMap2.get(strA) : null;
                                if (rVar != null) {
                                    break;
                                }
                                ConcurrentHashMap concurrentHashMap3 = uVar.d;
                                if (concurrentHashMap3 != null) {
                                    rVar = (r) concurrentHashMap3.get(strA);
                                }
                                if (rVar != null) {
                                    break;
                                }
                                ConcurrentHashMap concurrentHashMap4 = uVar.f;
                                if (concurrentHashMap4 != null) {
                                    rVar = (r) concurrentHashMap4.get(strA);
                                }
                                if (rVar != null) {
                                    break;
                                }
                                ConcurrentHashMap concurrentHashMap5 = uVar.g;
                                if (concurrentHashMap5 != null) {
                                    rVar = (r) concurrentHashMap5.get(strA);
                                }
                                if (rVar != null) {
                                    break;
                                }
                                ConcurrentHashMap concurrentHashMap6 = uVar.h;
                                if (concurrentHashMap6 != null) {
                                    rVar = (r) concurrentHashMap6.get(strA);
                                }
                                if (rVar != null || (concurrentHashMap = uVar.i) == null) {
                                    break;
                                    break;
                                } else {
                                    rVar = (r) concurrentHashMap.get(strA);
                                    break;
                                }
                            }
                            r rVar2 = (r) uVar.b.get(i);
                            if (rVar2 != null && rVar2.o.equals(strA)) {
                                rVar = rVar2;
                                break;
                            }
                            i++;
                        }
                    }
                    baseAdContent.D = exHandlerBaseAd.convertToApkDownloadStatus(rVar != null ? rVar.s : c.IDLE);
                }
            }
        });
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public void addDataFetchListenerV2(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        b0 b0Var = this.apkManager;
        if (b0Var == null || (copyOnWriteArrayList = ((u) b0Var).k) == null || dataFetchListener == null) {
            return;
        }
        copyOnWriteArrayList.add(dataFetchListener);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public void onAdxAdDestroy(Context context) {
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public void pause(com.smartdigimkt.b3.c cVar) {
        Context contextD = SDKContext.getInstance().d();
        if (contextD == null || cVar == null) {
            return;
        }
        u.a(contextD).a(j.a(cVar), "LOADING", -1, false);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public void removeDataFetchListener(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        CopyOnWriteArrayList<IExHandlerBaseAd.DataFetchListener> copyOnWriteArrayList;
        if (dataFetchListener == null || dataFetchListener.getBaseAdContent() == null || (copyOnWriteArrayList = this.uniqueIdDownloadListenerList) == null) {
            return;
        }
        copyOnWriteArrayList.remove(dataFetchListener);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public void removeDataFetchListenerV2(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        b0 b0Var = this.apkManager;
        if (b0Var == null || (copyOnWriteArrayList = ((u) b0Var).k) == null || dataFetchListener == null) {
            return;
        }
        copyOnWriteArrayList.remove(dataFetchListener);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd
    public void updateOfferInfoWithDataInfo(final com.smartdigimkt.b3.c cVar) {
        Context contextD = SDKContext.getInstance().d();
        if (this.apkManager == null || cVar == null || contextD == null) {
            return;
        }
        if (b.b(contextD, cVar.m)) {
            cVar.h = contextD.getResources().getString(k.a(contextD, "cta_download_installed", "string"));
            return;
        }
        final String strA = j.a(cVar);
        b0 b0Var = this.apkManager;
        n nVar = new n() { // from class: com.smartdigimkt.dlpd.ExHandlerBaseAd.3
            @Override // com.smartdigimkt.k.n
            public void onCallback(r rVar) {
                if (rVar == null) {
                    return;
                }
                String strA2 = b.a(SDKContext.getInstance().d(), rVar.s);
                if (TextUtils.isEmpty(strA2)) {
                    return;
                }
                cVar.h = strA2;
            }
        };
        u uVar = (u) b0Var;
        o oVar = uVar.o;
        if (oVar != null) {
            oVar.c.b(new l(oVar, strA, new h(uVar, nVar)));
        }
    }
}
