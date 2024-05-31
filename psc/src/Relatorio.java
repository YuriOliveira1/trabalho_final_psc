import java.util.Date;

public class Relatorio {
    private Date dataRelatorio;
    private String tipoRelatorio;

    public Relatorio(Date dataRelatorio, String tipoRelatorio) {
        this.dataRelatorio = dataRelatorio;
        this.tipoRelatorio = tipoRelatorio;
    }

    public void gerarRelatorioGeral(){

    }

    public Date getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(Date dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public String getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(String tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }
}
