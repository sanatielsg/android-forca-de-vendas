package br.com.qualiapp.appforcadevendas.model.bean;

public class Parametro {
    private int pUsuCodigo;
    private String pImportarCliente;
    private String pEndIPLocal;
    private String pEndIPRemoto;
    private String pTrabalharComEstoqueNegativo;
    private int pDescontoDoVendedor;

    public int getpUsuCodigo() {
        return pUsuCodigo;
    }

    public void setpUsuCodigo(int pUsuCodigo) {
        this.pUsuCodigo = pUsuCodigo;
    }

    public String getpImportarCliente() {
        return pImportarCliente;
    }

    public void setpImportarCliente(String pImportarCliente) {
        this.pImportarCliente = pImportarCliente;
    }

    public String getpEndIPLocal() {
        return pEndIPLocal;
    }

    public void setpEndIPLocal(String pEndIPLocal) {
        this.pEndIPLocal = pEndIPLocal;
    }

    public String getpEndIPRemoto() {
        return pEndIPRemoto;
    }

    public void setpEndIPRemoto(String pEndIPRemoto) {
        this.pEndIPRemoto = pEndIPRemoto;
    }

    public String getpTrabalharComEstoqueNegativo() {
        return pTrabalharComEstoqueNegativo;
    }

    public void setpTrabalharComEstoqueNegativo(String pTrabalharComEstoqueNegativo) {
        this.pTrabalharComEstoqueNegativo = pTrabalharComEstoqueNegativo;
    }

    public int getpDescontoDoVendedor() {
        return pDescontoDoVendedor;
    }

    public void setpDescontoDoVendedor(int pDescontoDoVendedor) {
        this.pDescontoDoVendedor = pDescontoDoVendedor;
    }
}
