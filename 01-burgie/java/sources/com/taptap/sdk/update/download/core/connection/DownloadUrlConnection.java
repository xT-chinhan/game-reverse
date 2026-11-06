package com.taptap.sdk.update.download.core.connection;

import com.taptap.sdk.update.download.IRedirectHandler;
import com.taptap.sdk.update.download.RedirectUtil;
import com.taptap.sdk.update.download.core.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadUrlConnection implements DownloadConnection, DownloadConnection.Connected {
    private static final String TAG = "DownloadUrlConnection";
    private Configuration configuration;
    protected URLConnection connection;
    private IRedirectHandler redirectHandler;
    private URL url;

    DownloadUrlConnection(URLConnection connection) {
        this(connection, new RedirectHandler());
    }

    DownloadUrlConnection(URLConnection connection, IRedirectHandler redirectHandler) {
        this.connection = connection;
        this.url = connection.getURL();
        this.redirectHandler = redirectHandler;
    }

    public DownloadUrlConnection(String originUrl, Configuration configuration) throws IOException {
        this(new URL(originUrl), configuration);
    }

    public DownloadUrlConnection(URL url, Configuration configuration) throws IOException {
        this(url, configuration, new RedirectHandler());
    }

    public DownloadUrlConnection(URL url, Configuration configuration, IRedirectHandler redirectHandler) throws IOException {
        this.configuration = configuration;
        this.url = url;
        this.redirectHandler = redirectHandler;
        configUrlConnection();
    }

    public DownloadUrlConnection(String originUrl) throws IOException {
        this(originUrl, (Configuration) null);
    }

    void configUrlConnection() throws IOException {
        Util.d(TAG, "config connection for " + this.url);
        Configuration configuration = this.configuration;
        if (configuration == null || configuration.proxy == null) {
            this.connection = this.url.openConnection();
        } else {
            this.connection = this.url.openConnection(this.configuration.proxy);
        }
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
        }
        Configuration configuration2 = this.configuration;
        if (configuration2 == null) {
            return;
        }
        if (configuration2.readTimeout != null) {
            this.connection.setReadTimeout(this.configuration.readTimeout.intValue());
        }
        if (this.configuration.connectTimeout == null) {
            return;
        }
        this.connection.setConnectTimeout(this.configuration.connectTimeout.intValue());
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection
    public void addHeader(String name, String value) {
        this.connection.addRequestProperty(name, value);
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection
    public DownloadConnection.Connected execute() throws IOException {
        Map<String, List<String>> headerProperties = getRequestProperties();
        this.connection.connect();
        this.redirectHandler.handleRedirect(this, this, headerProperties);
        return this;
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection.Connected
    public int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection.Connected
    public InputStream getInputStream() throws IOException {
        return this.connection.getInputStream();
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection
    public boolean setRequestMethod(String method) throws ProtocolException {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setRequestMethod(method);
            return true;
        }
        return false;
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection.Connected
    public Map<String, List<String>> getResponseHeaderFields() {
        return this.connection.getHeaderFields();
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection.Connected
    public String getResponseHeaderField(String name) {
        return this.connection.getHeaderField(name);
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection.Connected
    public String getRedirectLocation() {
        return this.redirectHandler.getRedirectLocation();
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection
    public void release() {
        try {
            InputStream inputStream = this.connection.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
        }
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.connection.getRequestProperties();
    }

    @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection
    public String getRequestProperty(String key) {
        return this.connection.getRequestProperty(key);
    }

    public static class Factory implements DownloadConnection.Factory {
        private final Configuration configuration;

        public Factory() {
            this(null);
        }

        public Factory(Configuration configuration) {
            this.configuration = configuration;
        }

        DownloadConnection create(URL url) throws IOException {
            return new DownloadUrlConnection(url, this.configuration);
        }

        @Override // com.taptap.sdk.update.download.core.connection.DownloadConnection.Factory
        public DownloadConnection create(String originUrl) throws IOException {
            return new DownloadUrlConnection(originUrl, this.configuration);
        }
    }

    public static class Configuration {
        private Integer connectTimeout;
        private Proxy proxy;
        private Integer readTimeout;

        public Configuration proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Configuration readTimeout(int readTimeout) {
            this.readTimeout = Integer.valueOf(readTimeout);
            return this;
        }

        public Configuration connectTimeout(int connectTimeout) {
            this.connectTimeout = Integer.valueOf(connectTimeout);
            return this;
        }
    }

    static final class RedirectHandler implements IRedirectHandler {
        String redirectLocation;

        RedirectHandler() {
        }

        @Override // com.taptap.sdk.update.download.IRedirectHandler
        public void handleRedirect(DownloadConnection originalConnection, DownloadConnection.Connected originalConnected, Map<String, List<String>> headerProperties) throws IOException {
            int redirectCount = 0;
            DownloadUrlConnection downloadUrlConnection = (DownloadUrlConnection) originalConnection;
            for (int responseCode = originalConnected.getResponseCode(); RedirectUtil.isRedirect(responseCode); responseCode = downloadUrlConnection.getResponseCode()) {
                downloadUrlConnection.release();
                redirectCount++;
                if (redirectCount > 10) {
                    throw new ProtocolException("Too many redirect requests: " + redirectCount);
                }
                this.redirectLocation = RedirectUtil.getRedirectedUrl(originalConnected, responseCode);
                downloadUrlConnection.url = new URL(this.redirectLocation);
                downloadUrlConnection.configUrlConnection();
                Util.addRequestHeaderFields(headerProperties, downloadUrlConnection);
                downloadUrlConnection.connection.connect();
            }
        }

        @Override // com.taptap.sdk.update.download.IRedirectHandler
        public String getRedirectLocation() {
            return this.redirectLocation;
        }
    }
}
