package pl.Laboratorium1;

public class Krawedz {
    Wierzcholek do_prowadzi;
    int koszt_dotarcia;
    int nr;

    public Krawedz(Wierzcholek do_prowadzi, int koszt_dotarcia, int nr) {
        this.do_prowadzi = do_prowadzi;
        this.koszt_dotarcia = koszt_dotarcia;
        this.nr = nr;
    }

    public Wierzcholek getDo_prowadzi() {
        return do_prowadzi;
    }

    public int getKoszt_dotarcia() {
        return koszt_dotarcia;
    }

    public int getNr() {
        return nr;
    }

    public void setDo_prowadzi(Wierzcholek do_prowadzi) {
        this.do_prowadzi = do_prowadzi;
    }

    public void setKoszt_dotarcia(int koszt_dotarcia) {
        this.koszt_dotarcia = koszt_dotarcia;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
}
