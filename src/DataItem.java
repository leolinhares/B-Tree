/**
 * Created by leolinhares on 02/07/2016.
 */
public class DataItem implements Comparable<DataItem>{

    int anoColheita;
    int rid;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getAnoColheita() {
        return anoColheita;
    }

    public void setAnoColheita(int anoColheita) {
        this.anoColheita = anoColheita;
    }


    @Override
    public int compareTo(DataItem o) {
        return this.getAnoColheita() - o.getAnoColheita();
    }
}


