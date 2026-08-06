package ar.soft.AT.API.OKS.OksPojo;

import java.util.ArrayList;

public class RecDelOks {

    private ArrayList<Integer> ids;

    public RecDelOks() {
    }

    public RecDelOks(ArrayList<Integer> ids) {
        this.ids = ids;
    }

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }
}
