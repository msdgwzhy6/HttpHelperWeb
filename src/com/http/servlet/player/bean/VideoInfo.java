package com.http.servlet.player.bean;

import java.io.Serializable;

/**
 * Created by smart on 2017/8/2.
 */
public class VideoInfo implements Serializable {
    private String mVideoName;
    private String mVideoSize;
    private String mVideoUrl;

    public String getVideoName() {
        return mVideoName;
    }

    public void setVideoName(String pVideoName) {
        mVideoName = pVideoName;
    }

    public String getVideoSize() {
        return mVideoSize;
    }

    public void setVideoSize(String pVideoSize) {
        mVideoSize = pVideoSize;
    }

    public String getVideoUrl() {
        return mVideoUrl;
    }

    public void setVideoUrl(String pVideoUrl) {
        mVideoUrl = pVideoUrl;
    }
}
