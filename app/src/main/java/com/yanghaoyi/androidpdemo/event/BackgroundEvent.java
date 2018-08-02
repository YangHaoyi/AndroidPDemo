package com.yanghaoyi.androidpdemo.event;

/**
 * @author : YangHaoYi on 2018/8/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/8/2.
 *         Version : V 1.0
 */
public class BackgroundEvent {

    private boolean startService;

    public boolean isStartService() {
        return startService;
    }

    public BackgroundEvent setStartService(boolean startService) {
        this.startService = startService;
        return this;
    }
}
