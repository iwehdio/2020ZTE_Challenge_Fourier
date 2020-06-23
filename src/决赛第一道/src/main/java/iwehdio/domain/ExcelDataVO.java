package iwehdio.domain;

/*
读取Excel表格的实体类
 */
public class ExcelDataVO {
    private String numAll;
    private String reqNum;
    private String type;
    private String prefer;
    private String point;
    private String rangeHeader;
    private String rangeTralier;

    public String getNumAll() {
        return numAll;
    }

    public void setNumAll(String numAll) {
        this.numAll = numAll;
    }

    public String getReqNum() {
        return reqNum;
    }

    public void setReqNum(String reqNum) {
        this.reqNum = reqNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrefer() {
        return prefer;
    }

    public void setPrefer(String prefer) {
        this.prefer = prefer;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getRangeHeader() {
        return rangeHeader;
    }

    public void setRangeHeader(String rangeHeader) {
        this.rangeHeader = rangeHeader;
    }

    public String getRangeTralier() {
        return rangeTralier;
    }

    public void setRangeTralier(String rangeTralier) {
        this.rangeTralier = rangeTralier;
    }

    @Override
    public String toString() {
        return "ExcelDataVO{" +
                "numAll='" + numAll + '\'' +
                ", reqNum='" + reqNum + '\'' +
                ", type='" + type + '\'' +
                ", prefer='" + prefer + '\'' +
                ", point='" + point + '\'' +
                ", rangeHeader='" + rangeHeader + '\'' +
                ", rangeTralier='" + rangeTralier + '\'' +
                '}';
    }
}
