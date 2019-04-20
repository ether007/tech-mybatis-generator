package vip.corejava.common;


import lombok.Data;

@Data
public class Pagination {

    private int total; //总条数
    private int pageNum;// 当前页
    private int pageSize;//每页数据条数
    private int pageTotal;//总页数

    public int offset() {
        pageTotal = ((total + pageSize - 1) / pageSize);
        if (pageNum > pageTotal) {
            this.pageNum = pageTotal;
        }
        pageNum = pageNum < 1 ? 1 : pageNum;
        int offset = (pageNum - 1) * pageSize;
        return offset < 0 ? 0 : offset;
    }
}
