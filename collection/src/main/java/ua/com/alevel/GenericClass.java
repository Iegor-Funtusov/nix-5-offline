package ua.com.alevel;

public class GenericClass<O> {

    private Object[] list;
    private O[] oList;

    public Object[] getList() {
        return list;
    }

    public void setList(Object[] list) {
        this.list = list;
    }

    public O[] getoList() {
        return oList;
    }

    public void setoList(O[] oList) {
        this.oList = oList;
    }
}
