package com.anythink.dlpd;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.IExHandlerBaseAd;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.v.b.b;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import com.anythink.dlopt.common.a.c;
import com.anythink.dlopt.common.a.d;
import com.anythink.dlopt.common.a.j;
import com.anythink.dlopt.common.a.m;
import com.anythink.dlopt.common.a.n;
import com.anythink.dlopt.common.c.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ExHandlerBaseAd implements IExHandlerBaseAd {
    private static final String TAG = "ExHandlerBaseAd";
    private final n apkManager;
    private volatile boolean haveRecoverDownload = false;
    private CopyOnWriteArrayList<IExHandlerBaseAd.DataFetchListener> uniqueIdDownloadListenerList = new CopyOnWriteArrayList<>();

    public ExHandlerBaseAd(n nVar) {
        this.apkManager = nVar;
        if (nVar != null) {
            nVar.a(new m() { // from class: com.anythink.dlpd.ExHandlerBaseAd.1
                @Override // com.anythink.dlopt.common.a.m
                public void onStatusChanged(j jVar) {
                    if (jVar == null) {
                        return;
                    }
                    final c.e eVarA = jVar.a();
                    final String str = jVar.o;
                    if (ExHandlerBaseAd.this.uniqueIdDownloadListenerList != null) {
                        Object[] objArr = new Object[2];
                        String str2 = jVar.a;
                        final List listFindDataFetchListener = ExHandlerBaseAd.this.findDataFetchListener(jVar.j);
                        t.b().b(new Runnable() { // from class: com.anythink.dlpd.ExHandlerBaseAd.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (listFindDataFetchListener.size() > 0) {
                                    for (int i = 0; i < listFindDataFetchListener.size(); i++) {
                                        IExHandlerBaseAd.DataFetchListener dataFetchListener = (IExHandlerBaseAd.DataFetchListener) listFindDataFetchListener.get(i);
                                        if (dataFetchListener != null) {
                                            w baseAdContent = dataFetchListener.getBaseAdContent();
                                            if (baseAdContent != null) {
                                                baseAdContent.m(ExHandlerBaseAd.this.convertToApkDownloadStatus(eVarA));
                                            }
                                            String strA = a.a(t.b().g(), eVarA);
                                            Object[] objArr2 = new Object[3];
                                            if (!TextUtils.isEmpty(strA)) {
                                                dataFetchListener.onStatusChanged(strA);
                                            }
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void onAdxAdDestroy(Context context) {
        Object[] objArr = new Object[1];
        Boolean.valueOf(this.haveRecoverDownload);
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void addDataFetchListener(final IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        b.a().c(new Runnable() { // from class: com.anythink.dlpd.ExHandlerBaseAd.2
            @Override // java.lang.Runnable
            public void run() {
                IExHandlerBaseAd.DataFetchListener dataFetchListener2 = dataFetchListener;
                if (dataFetchListener2 == null || dataFetchListener2.getBaseAdContent() == null) {
                    return;
                }
                w baseAdContent = dataFetchListener.getBaseAdContent();
                if (ExHandlerBaseAd.this.uniqueIdDownloadListenerList != null) {
                    ExHandlerBaseAd.this.uniqueIdDownloadListenerList.add(dataFetchListener);
                }
                if (baseAdContent != null) {
                    ExHandlerBaseAd exHandlerBaseAd = ExHandlerBaseAd.this;
                    baseAdContent.m(exHandlerBaseAd.convertToApkDownloadStatus(exHandlerBaseAd.apkManager.c(baseAdContent)));
                }
            }
        }, 13);
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void removeDataFetchListener(IExHandlerBaseAd.DataFetchListener dataFetchListener) {
        CopyOnWriteArrayList<IExHandlerBaseAd.DataFetchListener> copyOnWriteArrayList;
        if (dataFetchListener == null || dataFetchListener.getBaseAdContent() == null || (copyOnWriteArrayList = this.uniqueIdDownloadListenerList) == null) {
            return;
        }
        copyOnWriteArrayList.remove(dataFetchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<IExHandlerBaseAd.DataFetchListener> findDataFetchListener(w wVar) {
        ArrayList arrayList = new ArrayList();
        if (this.uniqueIdDownloadListenerList != null && wVar != null) {
            String strA = p.a(wVar);
            for (IExHandlerBaseAd.DataFetchListener dataFetchListener : this.uniqueIdDownloadListenerList) {
                if (dataFetchListener.getBaseAdContent() != null && TextUtils.equals(p.a(dataFetchListener.getBaseAdContent()), strA)) {
                    Object[] objArr = new Object[2];
                    dataFetchListener.getBaseAdContent().q();
                    arrayList.add(dataFetchListener);
                }
            }
        }
        return arrayList;
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void updateOfferInfoWithDataInfo(final w wVar) {
        Context contextG = t.b().g();
        if (this.apkManager == null || wVar == null || contextG == null) {
            return;
        }
        if (a.a(contextG, wVar.I())) {
            wVar.s(contextG.getResources().getString(q.a(contextG, "cta_download_installed", "string")));
        } else {
            final String strA = p.a(wVar);
            this.apkManager.a(strA, new d.a() { // from class: com.anythink.dlpd.ExHandlerBaseAd.3
                @Override // com.anythink.dlopt.common.a.d.a
                public void onCallback(j jVar) {
                    if (jVar == null) {
                        return;
                    }
                    String strA2 = a.a(t.b().g(), jVar.a());
                    Object[] objArr = new Object[2];
                    if (TextUtils.isEmpty(strA2)) {
                        return;
                    }
                    wVar.s(strA2);
                }
            });
        }
    }

    @Override // com.anythink.core.api.IExHandlerBaseAd
    public void pause(w wVar) {
        Context contextG = t.b().g();
        if (contextG == null || wVar == null) {
            return;
        }
        String strA = p.a(wVar);
        wVar.H();
        com.anythink.dlopt.common.b.a(contextG).a(strA, c.e.LOADING.toString(), -1);
    }

    private String getListenerKey(w wVar) {
        Object[] objArr = new Object[2];
        return p.a(wVar) + wVar.q();
    }

    /* JADX INFO: renamed from: com.anythink.dlpd.ExHandlerBaseAd$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$anythink$dlopt$common$download$ApkDownloadConst$Status;

        static {
            int[] iArr = new int[c.e.values().length];
            $SwitchMap$com$anythink$dlopt$common$download$ApkDownloadConst$Status = iArr;
            try {
                iArr[c.e.FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$anythink$dlopt$common$download$ApkDownloadConst$Status[c.e.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$anythink$dlopt$common$download$ApkDownloadConst$Status[c.e.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$anythink$dlopt$common$download$ApkDownloadConst$Status[c.e.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$anythink$dlopt$common$download$ApkDownloadConst$Status[c.e.FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$anythink$dlopt$common$download$ApkDownloadConst$Status[c.e.LOADING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$anythink$dlopt$common$download$ApkDownloadConst$Status[c.e.INSTALLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int convertToApkDownloadStatus(c.e eVar) {
        switch (AnonymousClass4.$SwitchMap$com$anythink$dlopt$common$download$ApkDownloadConst$Status[eVar.ordinal()]) {
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
}
