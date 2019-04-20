package vip.corejava.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class PageBody {
    private List list = new ArrayList();

    private Pagination pagination;

    private Map extra = new LinkedHashMap();

    private Map dictionary= new LinkedHashMap();

    public PageBody putDictionary(String key,Object value){
        this.dictionary.put(key,value);
        return this;
    }

    public PageBody(List list, Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }
}
