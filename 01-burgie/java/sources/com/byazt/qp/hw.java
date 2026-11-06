package com.byazt.qp;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadModel;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.cxa.DownloadShortInfo;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1370, 13})
public abstract class hw extends com.byazt.ofr.x implements DownloadStatusChangeListener, LongSupplier {
    public int mCurrentPercent;

    public abstract void onDownloadActive(long j, long j2, String str);

    public abstract void onDownloadFailed(long j, long j2, String str);

    public abstract void onDownloadFinished(long j, long j2, String str);

    public abstract void onDownloadPaused(long j, long j2, String str);

    public abstract void onDownloadStart();

    public abstract void onInstalled(long j, long j2, String str);

    public int getCurrentPercent() {
        return this.mCurrentPercent;
    }

    private void setCurrentPercent(int i) {
        this.mCurrentPercent = i;
    }

    @Override // com.byazt.bek.DownloadStatusChangeListener
    public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
        if (downloadModel == null) {
            return;
        }
        setCurrentPercent(0);
        onDownloadStart();
    }

    @Override // com.byazt.bek.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadActive(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    @Override // com.byazt.bek.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadPaused(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    @Override // com.byazt.bek.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        onDownloadFailed(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    @Override // com.byazt.bek.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        String str;
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(100);
        String str2 = downloadShortInfo.fileName;
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        } else {
            str = "";
        }
        onInstalled(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, str);
    }

    @Override // com.byazt.bek.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        onDownloadFinished(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.ofr.x
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).hw();
        switch (i) {
            case 223600:
                onIdle();
                return null;
            case 223601:
                if (pluginValueSetHw != null) {
                    PluginValueSet pluginValueSetHw2 = com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSetHw.objectValue(-999902, SparseArray.class)).hw();
                    onDownloadStart((Function<SparseArray<Object>, Object>) pluginValueSetHw2.objectValue(223201, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetHw2.objectValue(223203, Function.class));
                }
                return null;
            case 223602:
                if (pluginValueSetHw != null) {
                    PluginValueSet pluginValueSetHw3 = com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSetHw.objectValue(-999902, SparseArray.class)).hw();
                    onDownloadActive((Function<SparseArray<Object>, Object>) pluginValueSetHw3.objectValue(223607, Function.class), ((Integer) pluginValueSetHw3.objectValue(223608, Integer.class)).intValue());
                }
                return null;
            case 223603:
                if (pluginValueSetHw != null) {
                    PluginValueSet pluginValueSetHw4 = com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSetHw.objectValue(-999902, SparseArray.class)).hw();
                    onDownloadPaused((Function<SparseArray<Object>, Object>) pluginValueSetHw4.objectValue(223607, Function.class), ((Integer) pluginValueSetHw4.objectValue(223608, Integer.class)).intValue());
                }
                return null;
            case 223604:
                if (pluginValueSetHw != null) {
                    onDownloadFailed((Function<SparseArray<Object>, Object>) com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSetHw.objectValue(-999902, SparseArray.class)).hw().objectValue(223607, Function.class));
                }
                return null;
            case 223605:
                if (pluginValueSetHw != null) {
                    onInstalled((Function<SparseArray<Object>, Object>) com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSetHw.objectValue(-999902, SparseArray.class)).hw().objectValue(223607, Function.class));
                }
                return null;
            case 223606:
                if (pluginValueSetHw != null) {
                    onDownloadFinished((Function<SparseArray<Object>, Object>) com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSetHw.objectValue(-999902, SparseArray.class)).hw().objectValue(223607, Function.class));
                }
                return null;
            default:
                return null;
        }
    }

    private void onDownloadStart(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2) {
        if (function == null || com.byazt.xi.pr.hw(function) == null) {
            return;
        }
        onDownloadStart();
    }

    private void onDownloadActive(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet pluginValueSetHw;
        if (function == null || (pluginValueSetHw = com.byazt.xi.pr.hw(function)) == null) {
            return;
        }
        onDownloadActive(pluginValueSetHw.longValue(223704), pluginValueSetHw.longValue(223705), pluginValueSetHw.stringValue(223706));
    }

    private void onDownloadPaused(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet pluginValueSetHw;
        if (function == null || (pluginValueSetHw = com.byazt.xi.pr.hw(function)) == null) {
            return;
        }
        onDownloadPaused(pluginValueSetHw.longValue(223704), pluginValueSetHw.longValue(223705), pluginValueSetHw.stringValue(223706));
    }

    private void onDownloadFailed(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetHw;
        if (function == null || (pluginValueSetHw = com.byazt.xi.pr.hw(function)) == null) {
            return;
        }
        onDownloadFailed(pluginValueSetHw.longValue(223704), pluginValueSetHw.longValue(223705), pluginValueSetHw.stringValue(223706));
    }

    private void onInstalled(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetHw;
        String str;
        if (function == null || (pluginValueSetHw = com.byazt.xi.pr.hw(function)) == null) {
            return;
        }
        long jLongValue = pluginValueSetHw.longValue(223704);
        long jLongValue2 = pluginValueSetHw.longValue(223705);
        String strStringValue = pluginValueSetHw.stringValue(223706);
        if (strStringValue != null) {
            str = strStringValue;
        } else {
            str = "";
        }
        onInstalled(jLongValue, jLongValue2, str);
    }

    private void onDownloadFinished(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetHw;
        if (function == null || (pluginValueSetHw = com.byazt.xi.pr.hw(function)) == null) {
            return;
        }
        onDownloadFinished(pluginValueSetHw.longValue(223704), pluginValueSetHw.longValue(223705), pluginValueSetHw.stringValue(223706));
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
