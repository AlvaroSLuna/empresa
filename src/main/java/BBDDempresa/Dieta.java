package BBDDempresa;

public class Dieta {

    private String ID;
    private String Empleado;
    private String Cantidad;
    private String Concepto;

    public Dieta(String ID, String Empleado, String Cantidad, String Concepto) {
        this.ID = ID;
        this.Empleado = Empleado;
        this.Cantidad = Cantidad;
        this.Concepto = Concepto;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(String empleado) {
        Empleado = empleado;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String concepto) {
        Concepto = concepto;
    }
}
