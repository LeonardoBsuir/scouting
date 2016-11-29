package bsuir.scouting.web.response;

import java.util.List;


public class ResponseList<T> {

    private final List<T> list;
    private final long count;

    public ResponseList(List<T> list, long count) {
        this.list = list;
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public long getCount() {
        return count;
    }
}
