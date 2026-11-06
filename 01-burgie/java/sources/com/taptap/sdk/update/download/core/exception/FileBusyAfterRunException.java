package com.taptap.sdk.update.download.core.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class FileBusyAfterRunException extends IOException {
    public static final FileBusyAfterRunException SIGNAL = new FileBusyAfterRunException() { // from class: com.taptap.sdk.update.download.core.exception.FileBusyAfterRunException.1
    };

    private FileBusyAfterRunException() {
        super("File busy after run");
    }
}
