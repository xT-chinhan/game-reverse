package com.byazt.myr;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadModel;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.os.DownloadShortInfo;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1982, 26})
public abstract class qg extends com.byazt.gf.q implements DownloadStatusChangeListener, LongSupplier {
    public int mCurrentPercent;

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

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

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
        if (downloadModel == null) {
            return;
        }
        setCurrentPercent(0);
        onDownloadStart();
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadActive(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadPaused(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        onDownloadFailed(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(100);
        String str = downloadShortInfo.fileName;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        onInstalled(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, str);
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        onDownloadFinished(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).qg();
        switch (i) {
            case 223600:
                onIdle();
                return null;
            case 223601:
                if (pluginValueSetQg != null) {
                    PluginValueSet pluginValueSetQg2 = com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSetQg.objectValue(-999902, SparseArray.class)).qg();
                    onDownloadStart((Function<SparseArray<Object>, Object>) pluginValueSetQg2.objectValue(223201, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetQg2.objectValue(223203, Function.class));
                }
                return null;
            case 223602:
                if (pluginValueSetQg != null) {
                    PluginValueSet pluginValueSetQg3 = com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSetQg.objectValue(-999902, SparseArray.class)).qg();
                    onDownloadActive((Function<SparseArray<Object>, Object>) pluginValueSetQg3.objectValue(223607, Function.class), ((Integer) pluginValueSetQg3.objectValue(223608, Integer.class)).intValue());
                }
                return null;
            case 223603:
                if (pluginValueSetQg != null) {
                    PluginValueSet pluginValueSetQg4 = com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSetQg.objectValue(-999902, SparseArray.class)).qg();
                    onDownloadPaused((Function<SparseArray<Object>, Object>) pluginValueSetQg4.objectValue(223607, Function.class), ((Integer) pluginValueSetQg4.objectValue(223608, Integer.class)).intValue());
                }
                return null;
            case 223604:
                if (pluginValueSetQg != null) {
                    onDownloadFailed((Function<SparseArray<Object>, Object>) com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSetQg.objectValue(-999902, SparseArray.class)).qg().objectValue(223607, Function.class));
                }
                return null;
            case 223605:
                if (pluginValueSetQg != null) {
                    onInstalled((Function<SparseArray<Object>, Object>) com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSetQg.objectValue(-999902, SparseArray.class)).qg().objectValue(223607, Function.class));
                }
                return null;
            case 223606:
                if (pluginValueSetQg != null) {
                    onDownloadFinished((Function<SparseArray<Object>, Object>) com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSetQg.objectValue(-999902, SparseArray.class)).qg().objectValue(223607, Function.class));
                }
                return null;
            default:
                return null;
        }
    }

    private void onDownloadStart(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2) {
        if (function == null || com.byazt.of.n.qg(function) == null) {
            return;
        }
        onDownloadStart();
    }

    private void onDownloadActive(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet pluginValueSetQg;
        if (function == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return;
        }
        onDownloadActive(pluginValueSetQg.longValue(223704), pluginValueSetQg.longValue(223705), pluginValueSetQg.stringValue(223706));
    }

    private void onDownloadPaused(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet pluginValueSetQg;
        if (function == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return;
        }
        onDownloadPaused(pluginValueSetQg.longValue(223704), pluginValueSetQg.longValue(223705), pluginValueSetQg.stringValue(223706));
    }

    private void onDownloadFailed(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetQg;
        if (function == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return;
        }
        onDownloadFailed(pluginValueSetQg.longValue(223704), pluginValueSetQg.longValue(223705), pluginValueSetQg.stringValue(223706));
    }

    private void onInstalled(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetQg;
        if (function == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return;
        }
        long jLongValue = pluginValueSetQg.longValue(223704);
        long jLongValue2 = pluginValueSetQg.longValue(223705);
        String strStringValue = pluginValueSetQg.stringValue(223706);
        if (strStringValue == null) {
            strStringValue = "";
        }
        onInstalled(jLongValue, jLongValue2, strStringValue);
    }

    private void onDownloadFinished(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetQg;
        if (function == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return;
        }
        onDownloadFinished(pluginValueSetQg.longValue(223704), pluginValueSetQg.longValue(223705), pluginValueSetQg.stringValue(223706));
    }
}
