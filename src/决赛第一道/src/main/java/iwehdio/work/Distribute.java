package iwehdio.work;

import iwehdio.domain.ReqType;
import iwehdio.domain.Request;

import java.util.ArrayList;
import java.util.List;

public class Distribute {
    //资源域对象，构造方法传入初始值
    public List<Boolean> field;

    public Distribute(List<Boolean> field) {
        this.field = field;
    }

    /*
        处理整个需求
         */
    public String distri(List<Request> list) {
        List<String> all = new ArrayList<String>();
        for (Request request : list) {
            String res = dis(request);
            all.add(res);
        }
        StringBuilder ans = new StringBuilder("");
        ans.append("[");
        for (int i = 0; i < all.size(); i++) {
            if (i < all.size() - 1) {
                ans.append(all.get(i) + ",");
            } else {
                ans.append(all.get(i));
            }

        }
        ans.append("]");
        return ans.toString();
    }

    /*
    处理一个请求
    返回Fail分配失败
     */
    public String dis(Request request) {
        Integer num = request.getReqNum();
        for (ReqType reqType : request.getRequestList()) {
            List<Integer> res = find(num, reqType);
            if (res != null) {
                return "[" + res.get(0) + "," + res.get(1) + "]";
            }
        }
        return "Fail";
    }

    /*
    根据不同的分配方式执行
     */
    public List<Integer> find(Integer num, ReqType reqType) {
        List<Integer> res = null;
        //true为Fully，flase为Partial
        boolean type;
        if ("Fully".equals(reqType.getType())) {
            type = true;
        } else {
            type = false;
        }
        //findRange(请求大小，弹性，区域起始点，区域终点，正向还是反向搜索（正向为1））
        switch (reqType.getPrefer()) {
            case "Forward":
                //res = findForward(num, type);
                res = findRange(num, type, 0, field.size(), 1);
                break;
            case "Reverse":
                //res = findReverse(num, type);
                res = findRange(num, type, 0, field.size(), -1);
                break;
            case "SpecifyPoint":
                //res = findPoint(num, type, reqType.getPoint());
                res = findRange(num, type, reqType.getPoint(), field.size(), 1);
                break;
            case "SpecifyRange":
                res = findRange(num, type, reqType.getRangeHeader(), reqType.getRangeTralier() + 1, 1);
                break;
        }
        return res;
    }

    /*
    根据不同的弹性请求执行
     */
    public List<Integer> findRange(Integer size, boolean type, Integer header, Integer trailer, Integer positive) {

        Integer maxLength = 0;
        Integer start = null;
        if (positive == 1) {
            start = header;
        } else {
            start = trailer - 1;
        }
        boolean flag = false;
        //Fully
        if (type) {
            List<Integer> list = testFully(header, trailer, start, size, positive);
            start = list.get(0);
            maxLength = list.get(1);
            if (list.get(2) == 1) {
                flag = true;
            } else {
                flag = false;
            }
        }
        //Partial
        else {
            List<Integer> list = testPartial(header, trailer, start, size, positive);
            start = list.get(0);
            maxLength = list.get(1);
            if (list.get(2) == 1) {
                flag = true;
            } else {
                flag = false;
            }
        }
        if (start >= header && start < trailer && flag) {
            for (int i = 0; i < maxLength; i++) {
                field.set(start + i * positive, false);
            }
        } else {
            return null;
        }
        List<Integer> res = new ArrayList<Integer>();
        if (positive == 1) {
            res.add(start);
            res.add(start + maxLength - 1);
        } else {
            res.add(start - maxLength + 1);
            res.add(start);
        }
        return res;
    }

    /*
    执行弹性为Fully的请求
     */
    public List<Integer> testFully(Integer header, Integer trailer, Integer start, Integer size, Integer positive) {
        Integer maxLength = 0;
        boolean flag = false;
        for (int i = header; i < trailer; i++) {
            int j = 0;
            if (positive == 1) {
                j = i;
            } else {
                j = field.size() - i - 1;
            }
            if (field.get(j)) {
                maxLength += 1;
            } else {
                maxLength = 0;
                start = j + positive;
            }
            if (maxLength == size) {
                flag = true;
                break;
            }
        }
        return formatReturn(start, maxLength, flag);
    }

    /*
    执行弹性为Partial的请求
     */
    public List<Integer> testPartial(Integer header, Integer trailer, Integer start, Integer size, Integer positive) {
        Integer maxLength = 0;
        boolean flag = false;
        Integer saveMaxLength = 0;
        Integer saveStart = start;
        for (int i = header; i < trailer; i++) {
            int j = 0;
            if (positive == 1) {
                j = i;
            } else {
                j = field.size() - i - 1;
            }
            if (field.get(j)) {
                maxLength += 1;
            } else {
                if (saveMaxLength < maxLength) {
                    saveMaxLength = maxLength;
                    saveStart = start;
                }
                maxLength = 0;
                start = j + positive;
            }
            if (maxLength == size) {
                flag = true;
                break;
            }
        }
        if (saveMaxLength < maxLength) {
            saveMaxLength = maxLength;
            saveStart = start;
        }
        maxLength = saveMaxLength;
        start = saveStart;
        flag = true;
        return formatReturn(start, maxLength, flag);
    }

    /*
    封装返回值
     */
    public List<Integer> formatReturn(Integer start, Integer maxLength, boolean flag) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(start);
        ans.add(maxLength);
        if (flag) {
            ans.add(1);
        } else {
            ans.add(0);
        }
        return ans;
    }
}
