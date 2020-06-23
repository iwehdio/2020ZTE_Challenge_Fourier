package iwehdio.domain;

import java.util.List;
/*
请求的实体类
 */
public class Request {
    private Integer reqNum;
    private List<ReqType> requestList;

    public Integer getReqNum() {
        return reqNum;
    }

    public void setReqNum(Integer reqNum) {
        this.reqNum = reqNum;
    }

    public List<ReqType> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<ReqType> requestList) {
        this.requestList = requestList;
    }

    @Override
    public String toString() {
        return "request{" +
                "reqNum=" + reqNum +
                ", requestList=" + requestList +
                '}' + "\n";
    }
}
