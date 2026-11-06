package com.taptap.sdk.update.download.core.breakpoint;

import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.download.DownloadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BreakpointInfo {
    private final List<BlockInfo> blockInfoList = new ArrayList();
    private boolean chunked;
    private String etag;
    private final DownloadStrategy.FilenameHolder filenameHolder;
    final int id;
    final File parentFile;
    private File targetFile;
    private final boolean taskOnlyProvidedParentPath;
    private String url;

    public BreakpointInfo(int id, String url, File parentFile, String filename) {
        this.id = id;
        this.url = url;
        this.parentFile = parentFile;
        if (Util.isEmpty(filename)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
            this.taskOnlyProvidedParentPath = true;
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(filename);
            this.taskOnlyProvidedParentPath = false;
            this.targetFile = new File(parentFile, filename);
        }
    }

    BreakpointInfo(int id, String url, File parentFile, String filename, boolean taskOnlyProvidedParentPath) {
        this.id = id;
        this.url = url;
        this.parentFile = parentFile;
        if (Util.isEmpty(filename)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(filename);
        }
        this.taskOnlyProvidedParentPath = taskOnlyProvidedParentPath;
    }

    public int getId() {
        return this.id;
    }

    public void setChunked(boolean chunked) {
        this.chunked = chunked;
    }

    public void addBlock(BlockInfo blockInfo) {
        this.blockInfoList.add(blockInfo);
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isLastBlock(int blockIndex) {
        return blockIndex == this.blockInfoList.size() - 1;
    }

    public boolean isSingleBlock() {
        return this.blockInfoList.size() == 1;
    }

    boolean isTaskOnlyProvidedParentPath() {
        return this.taskOnlyProvidedParentPath;
    }

    public BlockInfo getBlock(int blockIndex) {
        return this.blockInfoList.get(blockIndex);
    }

    public void resetInfo() {
        this.blockInfoList.clear();
        this.etag = null;
    }

    public void resetBlockInfos() {
        this.blockInfoList.clear();
    }

    public int getBlockCount() {
        return this.blockInfoList.size();
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public long getTotalOffset() {
        long offset = 0;
        Object[] blocks = this.blockInfoList.toArray();
        if (blocks != null) {
            for (Object block : blocks) {
                if (block instanceof BlockInfo) {
                    offset += ((BlockInfo) block).getCurrentOffset();
                }
            }
        }
        return offset;
    }

    public long getTotalLength() {
        if (isChunked()) {
            return getTotalOffset();
        }
        long length = 0;
        Object[] blocks = this.blockInfoList.toArray();
        if (blocks != null) {
            for (Object block : blocks) {
                if (block instanceof BlockInfo) {
                    length += ((BlockInfo) block).getContentLength();
                }
            }
        }
        return length;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilename() {
        return this.filenameHolder.get();
    }

    public DownloadStrategy.FilenameHolder getFilenameHolder() {
        return this.filenameHolder;
    }

    public File getFile() {
        String filename = this.filenameHolder.get();
        if (filename == null) {
            return null;
        }
        if (this.targetFile == null) {
            this.targetFile = new File(this.parentFile, filename);
        }
        return this.targetFile;
    }

    public BreakpointInfo copy() {
        BreakpointInfo info = new BreakpointInfo(this.id, this.url, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
        info.chunked = this.chunked;
        for (BlockInfo blockInfo : this.blockInfoList) {
            info.blockInfoList.add(blockInfo.copy());
        }
        return info;
    }

    public BreakpointInfo copyWithReplaceId(int replaceId) {
        BreakpointInfo info = new BreakpointInfo(replaceId, this.url, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
        info.chunked = this.chunked;
        for (BlockInfo blockInfo : this.blockInfoList) {
            info.blockInfoList.add(blockInfo.copy());
        }
        return info;
    }

    public void reuseBlocks(BreakpointInfo info) {
        this.blockInfoList.clear();
        this.blockInfoList.addAll(info.blockInfoList);
    }

    public BreakpointInfo copyWithReplaceIdAndUrl(int replaceId, String newUrl) {
        BreakpointInfo info = new BreakpointInfo(replaceId, newUrl, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
        info.chunked = this.chunked;
        for (BlockInfo blockInfo : this.blockInfoList) {
            info.blockInfoList.add(blockInfo.copy());
        }
        return info;
    }

    public boolean isSameFrom(DownloadTask task) {
        if (!this.parentFile.equals(task.getParentFile())) {
            return false;
        }
        String otherFilename = task.getFilename();
        if (otherFilename != null && otherFilename.equals(this.filenameHolder.get())) {
            return true;
        }
        if (this.url.equals(task.getUrl()) && this.taskOnlyProvidedParentPath && task.isFilenameFromResponse()) {
            return otherFilename == null || otherFilename.equals(this.filenameHolder.get());
        }
        return false;
    }

    public String toString() {
        return "id[" + this.id + "] url[" + this.url + "] etag[" + this.etag + "] taskOnlyProvidedParentPath[" + this.taskOnlyProvidedParentPath + "] parent path[" + this.parentFile + "] filename[" + this.filenameHolder.get() + "] block(s):" + this.blockInfoList.toString();
    }
}
