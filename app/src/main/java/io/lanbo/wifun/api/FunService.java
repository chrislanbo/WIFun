package io.lanbo.wifun.api;

import io.lanbo.wifun.model.Fun;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wumeng051 on 2017/6/2.
 * Retrofit turns your HTTP API into a Java interface
 */

public interface FunService {
    @GET("text.from")
    rx.Observable<Fun> getItem(@Query("key")String key,
                               @Query("page")int page,
                               @Query("pagesize")int pagesize);
}
