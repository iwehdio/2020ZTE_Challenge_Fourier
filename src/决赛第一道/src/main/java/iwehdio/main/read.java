package iwehdio.main;

import iwehdio.domain.ExcelDataVO;
import iwehdio.domain.ReqType;
import iwehdio.domain.Request;
import iwehdio.utils.ExcelReader;
import iwehdio.work.Distribute;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class read {
    public static void main(String[] args) {
        //读入xlsx形式的输入数据
        File directory = new File("");
        String realdirectory = directory.getAbsolutePath() + "\\src\\main\\resources";
        String excelFileName = realdirectory + "\\data1";
        String savePath = excelFileName + "_answer.txt";
        excelFileName += ".xlsx";
        //把数据读出并且存入对象
        List<ExcelDataVO> readResult = ExcelReader.readExcel(excelFileName);
        Integer numAll = null;
        List<Request> list = new ArrayList<Request>();
        Request request = new Request();
        List<ReqType> reqTypeList = new ArrayList<ReqType>();
        for (int i = 0; i < readResult.size(); i++) {
            if (i == 0) {
                numAll = String2Integer(readResult.get(0).getNumAll());
            } else {
                if (readResult.get(i).getReqNum() != null) {
                    request = new Request();
                    request.setReqNum(String2Integer(readResult.get(i).getReqNum()));
                    reqTypeList = new ArrayList<ReqType>();
                    reqTypeList.add(new ReqType(readResult.get(i).getType(), readResult.get(i).getPrefer(),
                            String2Integer(readResult.get(i).getPoint()),
                            String2Integer(readResult.get(i).getRangeHeader()),
                            String2Integer(readResult.get(i).getRangeTralier())));
                } else {
                    reqTypeList.add(new ReqType(readResult.get(i).getType(), readResult.get(i).getPrefer(),
                            String2Integer(readResult.get(i).getPoint()),
                            String2Integer(readResult.get(i).getRangeHeader()),
                            String2Integer(readResult.get(i).getRangeTralier())));
                }
            }
            if (i == readResult.size() - 1 || readResult.get(i+1).getReqNum()!=null) {
                request.setRequestList(reqTypeList);
                list.add(request);
            }
        }
        list.remove(0);
        //定义总请求域
        List<Boolean> requestField = new ArrayList<Boolean>();
        for (int i = 0; i < numAll; i++) {
            //能否被请求
            requestField.add(true);
        }
        //分配资源
        Distribute distribute = new Distribute(requestField);
        String ans = distribute.distri(list);
        System.out.println(ans);
        //写入文件
        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter(savePath);
            fwriter.write(ans);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Integer String2Integer(String str) {
        Integer i = null;
        if (str != null) {
            i = Integer.valueOf(str);
        }
        return i;
    }
}
