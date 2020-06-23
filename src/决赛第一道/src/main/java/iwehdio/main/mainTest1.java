package iwehdio.main;

import iwehdio.domain.ReqType;
import iwehdio.domain.Request;
import iwehdio.work.Distribute;


import java.util.ArrayList;
import java.util.List;

public class mainTest1 {
    public static void main(String[] args) {

        //定义总请求域
        Integer numAll = 100;
        List<Boolean> requestField = new ArrayList<Boolean>();
        for(int i=0; i < numAll; i++) {
            //能否被请求
            requestField.add(true);
        }


        List<Request> list = new ArrayList<Request>();
        Request request = new Request();
        request.setReqNum(10);
        List<ReqType> reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Partial","SpecifyRange",null, 40, 49));
        request.setRequestList(reqTypeList);
        list.add(request);

        request = new Request();
        request.setReqNum(45);
        reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Fully","SpecifyPoint",66, null, null));
        reqTypeList.add(new ReqType("Fully","Forward",null, null, null));
        request.setRequestList(reqTypeList);
        list.add(request);

        request = new Request();
        request.setReqNum(20);
        reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Fully","Reverse",null, null, null));
        request.setRequestList(reqTypeList);
        list.add(request);

        request = new Request();
        request.setReqNum(25);
        reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Fully","Forward",null, null, null));
        request.setRequestList(reqTypeList);
        list.add(request);

        //System.out.println(list);

        Distribute distribute = new Distribute(requestField);
        String ans = distribute.distri(list);
        System.out.println(ans);
        System.out.println(requestField);
    }
}
