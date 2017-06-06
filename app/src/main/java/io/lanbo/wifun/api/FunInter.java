package io.lanbo.wifun.api;

import io.lanbo.wifun.model.Fun;
import rx.Subscriber;

/**
 * Created by wumeng051 on 2017/6/2.
 * key app key id
 * page 页数
 * pageSize 每页数据量最大20，默认1
 * type 随机种类 pic:趣图,不传默认为笑话)
 */

public interface FunInter {
    void getJoke(Subscriber<Fun> subscriber, String key, int Page, int pageSize);
    void getGif(Subscriber<Fun> subscriber, String key, int Page, int pageSize);
    void getRandomJoke(Subscriber<Fun> subscriber, String key, String type);
    void getRandomGif(Subscriber<Fun> subscriber, String key, String type);
    void test(String key, int Page, int pageSize);
}
