package io.lanbo.wifun.model;

import java.util.List;

/**
 * Created by wumeng051 on 2017/5/31.
 * 接口数据
 */

public class Fun {

    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"车祸现场","hashId":"F4C2439222DE1ED884B3140F6FF96C0F","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/F4C2439222DE1ED884B3140F6FF96C0F.gif"},{"content":"一起吃玉米","hashId":"119208FB44CFA9EA06220769734B39E8","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/119208FB44CFA9EA06220769734B39E8.gif"},{"content":"伸开腿放松下~","hashId":"F842753BABEFB5859B3E96B5CA4E0B96","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/F842753BABEFB5859B3E96B5CA4E0B96.gif"},{"content":"刚抓的鲨鱼","hashId":"AF4679805C207FF720115F1EF65F145B","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/AF4679805C207FF720115F1EF65F145B.gif"},{"content":"卖萌有危险","hashId":"DB0D41F992BEC01577EB8549143674B4","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/DB0D41F992BEC01577EB8549143674B4.gif"},{"content":"好疼","hashId":"806C849F7C6B87EDFA7EF7AAB34D8B7A","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/806C849F7C6B87EDFA7EF7AAB34D8B7A.gif"},{"content":"我绝对能跳过去","hashId":"8319BB8107DE1F7DF91A474ED7FBCAC0","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/8319BB8107DE1F7DF91A474ED7FBCAC0.gif"},{"content":"喝多了","hashId":"D97E9772372BD9B74154976CA9A17008","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/D97E9772372BD9B74154976CA9A17008.gif"},{"content":"新买的劈材机，工作效率高多了","hashId":"A5EF50D4321E9FEB5ABF281B2DA80632","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/A5EF50D4321E9FEB5ABF281B2DA80632.gif"},{"content":"小小游泳健将","hashId":"14F37D413AF8166A94AC3CCAD5600723","unixtime":1418918235,"updatetime":"2014-12-18 23:57:15","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/14F37D413AF8166A94AC3CCAD5600723.gif"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Fun{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class ResultBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * content : 车祸现场
             * hashId : F4C2439222DE1ED884B3140F6FF96C0F
             * unixtime : 1418918235
             * updatetime : 2014-12-18 23:57:15
             * url : http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/19/F4C2439222DE1ED884B3140F6FF96C0F.gif
             */

            private String content;
            private String hashId;
            private String unixtime;
            private String updatetime;
            private String url;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public String getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(String unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "DataBean{" + '\n' +
                        "content=" + content + '\n' +
                        "hashId=" + hashId + '\n' +
                        "unixtime=" + unixtime + '\n' +
                        "updatetime=" + updatetime + '\n' +
                        "url=" + url + '\n' +
                        '}';
            }
        }
    }
}
