package io.lanbo.wifun.api;

import io.lanbo.wifun.model.Fun;
import rx.Subscriber;

/**
 * Created by wumeng051 on 2017/6/2.
 *
 */

public interface FunInter {
    void getJoke(Subscriber<Fun> subscriber, String key, int Page, int pageSize);
    void getGif(Subscriber<Fun> subscriber, String key, int Page, int pageSize);
    void getRandomJoke(Subscriber<Fun> subscriber, String key, String type);
    void getRandomGif(Subscriber<Fun> subscriber, String key, String type);
}
