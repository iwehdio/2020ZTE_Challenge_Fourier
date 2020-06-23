package iwehdio.domain;

/*
请求信息的实体类
 */
public class ReqType {
    private String type;
    private String prefer;
    private Integer point;
    private Integer rangeHeader;
    private Integer rangeTralier;

    public ReqType(String type, String prefer, Integer point, Integer rangeHeader, Integer rangeTralier) {
        this.type = type;
        this.prefer = prefer;
        this.point = point;
        this.rangeHeader = rangeHeader;
        this.rangeTralier = rangeTralier;
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

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getRangeHeader() {
        return rangeHeader;
    }

    public void setRangeHeader(Integer rangeHeader) {
        this.rangeHeader = rangeHeader;
    }

    public Integer getRangeTralier() {
        return rangeTralier;
    }

    public void setRangeTralier(Integer rangeTralier) {
        this.rangeTralier = rangeTralier;
    }

    @Override
    public String toString() {
        return "reqType{" +
                "type='" + type + '\'' +
                ", prefer='" + prefer + '\'' +
                ", point=" + point +
                ", rangeHeader=" + rangeHeader +
                ", rangeTralier=" + rangeTralier +
                '}';
    }
}
