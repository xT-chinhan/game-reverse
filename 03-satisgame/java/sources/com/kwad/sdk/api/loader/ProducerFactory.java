package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.api.SDKApiHolder;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
class ProducerFactory {

    public interface Consumer<T> {
        void onFailure(Throwable th);

        void onNewResult(T t);
    }

    public interface Producer<T> {
        void produceResults(UpdaterProvider updaterProvider, Consumer<T> consumer);
    }

    ProducerFactory() {
    }

    static Producer<Boolean> newUpdateProducer() {
        return new InstallProducer(new SecurityProducer(new DownloadProducer(new UpgradeProducer(new ConfigProducer()))));
    }

    private static abstract class BaseConsumer<T> implements Consumer<T> {
        Consumer<T> mConsumer;

        BaseConsumer(Consumer<T> consumer) {
            this.mConsumer = consumer;
        }

        @Override // com.kwad.sdk.api.loader.ProducerFactory.Consumer
        public void onFailure(Throwable th) {
            this.mConsumer.onFailure(th);
        }
    }

    private static class InstallProducer implements Producer<Boolean> {
        Producer<Api.Data> mInputProducer;

        InstallProducer(Producer<Api.Data> producer) {
            this.mInputProducer = producer;
        }

        @Override // com.kwad.sdk.api.loader.ProducerFactory.Producer
        public void produceResults(final UpdaterProvider updaterProvider, final Consumer<Boolean> consumer) {
            this.mInputProducer.produceResults(updaterProvider, new Consumer<Api.Data>() { // from class: com.kwad.sdk.api.loader.ProducerFactory.InstallProducer.1
                @Override // com.kwad.sdk.api.loader.ProducerFactory.Consumer
                public void onNewResult(Api.Data data) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        DynamicMonitor.onInstallStart(data);
                        if (!ApkInstaller.installApk(updaterProvider.getContext(), getClass().getClassLoader(), data.downloadFile.getPath(), data.sdkVersion)) {
                            handleFail(data, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        DVersionUtils.setNewDynamicVersion(updaterProvider.getContext(), data.sdkVersion);
                        Dir.safeDeleteFile(data.downloadFile);
                        DynamicMonitor.onInstallSuccess(data, System.currentTimeMillis() - jCurrentTimeMillis);
                        consumer.onNewResult(true);
                    } catch (Throwable th) {
                        handleFail(data, 2, th);
                    }
                }

                private void handleFail(Api.Data data, int i, Throwable th) {
                    Dir.safeDeleteFile(data.downloadFile);
                    DynamicMonitor.onInstallFail(data, i, Log.getStackTraceString(th));
                    onFailure(th);
                }

                @Override // com.kwad.sdk.api.loader.ProducerFactory.Consumer
                public void onFailure(Throwable th) {
                    consumer.onFailure(th);
                }
            });
        }
    }

    private static class SecurityProducer implements Producer<Api.Data> {
        Producer<Api.Data> mInputProducer;

        SecurityProducer(Producer<Api.Data> producer) {
            this.mInputProducer = producer;
        }

        @Override // com.kwad.sdk.api.loader.ProducerFactory.Producer
        public void produceResults(UpdaterProvider updaterProvider, final Consumer<Api.Data> consumer) {
            this.mInputProducer.produceResults(updaterProvider, new BaseConsumer<Api.Data>(consumer) { // from class: com.kwad.sdk.api.loader.ProducerFactory.SecurityProducer.1
                @Override // com.kwad.sdk.api.loader.ProducerFactory.Consumer
                public void onNewResult(Api.Data data) {
                    try {
                        File file = data.downloadFile;
                        if (!SecurityChecker.checkFileValid(file)) {
                            handleFail(data, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!SecurityChecker.checkMd5(file, data.md5)) {
                            handleFail(data, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            consumer.onNewResult(data);
                        }
                    } catch (Throwable th) {
                        handleFail(data, 3, th);
                    }
                }

                private void handleFail(Api.Data data, int i, Throwable th) {
                    Dir.safeDeleteFile(data.downloadFile);
                    DynamicMonitor.onFileCheckFail(data, i, th.getMessage());
                    consumer.onFailure(th);
                }
            });
        }
    }

    private static class DownloadProducer implements Producer<Api.Data> {
        Producer<Api.Data> mInputProducer;

        DownloadProducer(Producer<Api.Data> producer) {
            this.mInputProducer = producer;
        }

        @Override // com.kwad.sdk.api.loader.ProducerFactory.Producer
        public void produceResults(final UpdaterProvider updaterProvider, final Consumer<Api.Data> consumer) {
            this.mInputProducer.produceResults(updaterProvider, new BaseConsumer<Api.Data>(consumer) { // from class: com.kwad.sdk.api.loader.ProducerFactory.DownloadProducer.1
                @Override // com.kwad.sdk.api.loader.ProducerFactory.Consumer
                public void onNewResult(Api.Data data) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        DynamicMonitor.onDownloadStart(data);
                        File downloadFile = Dir.getDownloadFile(updaterProvider.getContext(), data.sdkVersion);
                        DownloadFile.DownloadResult downloadResultDownloadFileSync = DownloadFile.downloadFileSync(updaterProvider.getContext(), data.dynamicUrl, downloadFile);
                        if (!downloadResultDownloadFileSync.isSuccess && data.hasFallbackUrl()) {
                            DynamicMonitor.onFallbackToKCdn(data, downloadResultDownloadFileSync.httpCode, downloadResultDownloadFileSync.errorMsg);
                            ApiLogger.d(DynamicMonitor.TAG, "eCDN download failed (httpCode=" + downloadResultDownloadFileSync.httpCode + "), fallback to kCDN: " + data.oldDynamicUrl);
                            data.dynamicUrl = data.oldDynamicUrl;
                            data.oldDynamicUrl = null;
                            DynamicMonitor.onFallbackDownloadStart(data);
                            downloadResultDownloadFileSync = DownloadFile.downloadFileSync(updaterProvider.getContext(), data.dynamicUrl, downloadFile);
                        }
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        if (downloadResultDownloadFileSync.isSuccess) {
                            DynamicMonitor.onDownloadSuccess(data, jCurrentTimeMillis2);
                            data.downloadFile = downloadFile;
                            consumer.onNewResult(data);
                        } else {
                            DynamicMonitor.onDownloadFail(data, jCurrentTimeMillis2, downloadResultDownloadFileSync.httpCode, downloadResultDownloadFileSync.errorMsg);
                            Dir.safeDeleteFile(downloadFile);
                            consumer.onFailure(new RuntimeException(downloadResultDownloadFileSync.errorMsg));
                        }
                    } catch (Throwable th) {
                        DynamicMonitor.onDownloadFail(data, 0L, 0, Log.getStackTraceString(th));
                        consumer.onFailure(th);
                    }
                }
            });
        }
    }

    private static class UpgradeProducer implements Producer<Api.Data> {
        Producer<Api.Data> mInputProducer;

        UpgradeProducer(Producer<Api.Data> producer) {
            this.mInputProducer = producer;
        }

        @Override // com.kwad.sdk.api.loader.ProducerFactory.Producer
        public void produceResults(final UpdaterProvider updaterProvider, final Consumer<Api.Data> consumer) {
            this.mInputProducer.produceResults(updaterProvider, new Consumer<Api.Data>() { // from class: com.kwad.sdk.api.loader.ProducerFactory.UpgradeProducer.1
                @Override // com.kwad.sdk.api.loader.ProducerFactory.Consumer
                public void onNewResult(Api.Data data) {
                    String currentDynamicVersion = DVersionUtils.getCurrentDynamicVersion(updaterProvider.getContext());
                    if (TextUtils.isEmpty(currentDynamicVersion)) {
                        currentDynamicVersion = SDKApiHolder.getSDK().getSDKVersion();
                    }
                    ApiLogger.d(DynamicMonitor.TAG, "UpgradeProducer curVersion:" + currentDynamicVersion + "-newVersion" + data.sdkVersion);
                    ApiSpUtils.setLong(updaterProvider.getContext(), ApiSpUtils.SP_INTERVAL, data.interval);
                    ApiSpUtils.setLong(updaterProvider.getContext(), ApiSpUtils.SP_LASTUPDATE_TIME, System.currentTimeMillis());
                    if (data.needDisable()) {
                        Updater.revertDynamic(updaterProvider.getContext());
                        consumer.onFailure(new RuntimeException("DynamicType == -1, curVersion: " + currentDynamicVersion));
                    } else if (DVersionUtils.isGreaterThan(data.sdkVersion, currentDynamicVersion) && data.canUpdate()) {
                        consumer.onNewResult(data);
                    } else {
                        consumer.onFailure(new RuntimeException("No new sdkVersion. remote sdkVersion:" + data.sdkVersion + " currentDynamicVersion:" + currentDynamicVersion + " dynamicType:" + data.dynamicType));
                    }
                }

                @Override // com.kwad.sdk.api.loader.ProducerFactory.Consumer
                public void onFailure(Throwable th) {
                    consumer.onFailure(th);
                }
            });
        }
    }

    private static class ConfigProducer implements Producer<Api.Data> {
        ConfigProducer() {
        }

        @Override // com.kwad.sdk.api.loader.ProducerFactory.Producer
        public void produceResults(final UpdaterProvider updaterProvider, final Consumer<Api.Data> consumer) {
            try {
                new ConfigRequest(updaterProvider).request(new ConfigRequest.RequestCallBack() { // from class: com.kwad.sdk.api.loader.ProducerFactory.ConfigProducer.1
                    @Override // com.kwad.sdk.api.loader.ConfigRequest.RequestCallBack
                    public void onSuccess(Api.UpdateData updateData) {
                        ApiLogger.d(DynamicMonitor.TAG, "ConfigProducer onSuccess data:" + updateData);
                        if (updateData != null && updateData.isLegal()) {
                            consumer.onNewResult(updateData.data);
                        } else {
                            consumer.onFailure(new RuntimeException("UpdateData is illegal"));
                        }
                        try {
                            AutoRevertHandler.getInstance(updaterProvider.getContext()).cancel();
                        } catch (Throwable th) {
                            ApiLogger.handleException(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.loader.ConfigRequest.RequestCallBack
                    public void onError(Exception exc) {
                        consumer.onFailure(exc);
                    }
                });
            } catch (Exception e) {
                consumer.onFailure(e);
            }
        }
    }
}
