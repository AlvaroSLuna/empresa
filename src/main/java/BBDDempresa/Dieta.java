package BBDDempresa;

public class Dieta {

    private String ID;
    private String Empleado;
    private String Departamento;
    private String Cantidad;
    private String Concepto;

    public Dieta(String ID, String Empleado, String Departamento, String Cantidad, String Concepto) {
        this.ID = ID;
        this.Empleado = Empleado;
        this.Departamento = Departamento;
        this.Cantidad = Cantidad;
        this.Concepto = Concepto;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
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
