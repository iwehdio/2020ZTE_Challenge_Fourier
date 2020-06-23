package iwehdio.main;

import iwehdio.domain.ReqType;
import iwehdio.domain.Request;
import iwehdio.work.Distribute;

import java.util.ArrayList;
import java.util.List;

public class mainTest2 {
    public static void main(String[] args) {

        //定义总请求域
        Integer numAll = 270;
        List<Boolean> requestField = new ArrayList<Boolean>();
        for(int i=0; i < numAll; i++) {
            //能否被请求
            requestField.add(true);
        }


        List<Request> list = new ArrayList<Request>();
        Request request = new Request();
        request.setReqNum(20);
        List<ReqType> reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Partial","SpecifyRange",null, 70, 99));
        request.setRequestList(reqTypeList);
        list.add(request);

        request = new Request();
        request.setReqNum(10);
        reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Partial","SpecifyRange",null, 140, 179));
        request.setRequestList(reqTypeList);
        list.add(request);

        request = new Request();
        request.setReqNum(10);
        reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Partial","SpecifyRange",null, 210, 239));
        request.setRequestList(reqTypeList);
        list.add(request);

        request = new Request();
        request.setReqNum(20);
        reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Fully","SpecifyRange",null, 80, 99));
        reqTypeList.add(new ReqType("Fully","SpecifyPoint",160, null, null));
        reqTypeList.add(new ReqType("Fully","Forward",null, null, null));
        request.setRequestList(reqTypeList);
        list.add(request);

        request = new Request();
        request.setReqNum(80);
        reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Fully","SpecifyPoint",100, null, null));
        reqTypeList.add(new ReqType("Fully","Reverse",null, null, null));
        request.setRequestList(reqTypeList);
        list.add(request);

        request = new Request();
        request.setReqNum(100);
        reqTypeList = new ArrayList<ReqType>();
        reqTypeList.add(new ReqType("Partial","Forward",null, null, null));
        request.setRequestList(reqTypeList);
        list.add(request);

        //System.out.println(list);

        Distribute distribute = new Distribute(requestField);
        String ans = distribute.distri(list);
        System.out.println(ans);
        System.out.println(requestField);
    }
}
