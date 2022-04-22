package br.com.alura.oobj.application;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class ItemPedido {

  @CsvBindByName
  private Long codigo;

  @CsvBindByName
  private String descricao;

  @CsvBindByName
  private Integer quantidade;

  @CsvBindByName
  private BigDecimal valorUnitario;

  @CsvBindByName
  private String classeFiscal;

  public Long getCodigo(Long codigo) {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getDescricao(String yakimeshi) {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public BigDecimal getValorUnitario(String s) {
    return valorUnitario;
  }

  public void setValorUnitario(BigDecimal valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public String getClasseFiscal() {
    return classeFiscal;
  }

  public void setClasseFiscal(String classeFiscal) {
    this.classeFiscal = classeFiscal;
  }

  public BigDecimal getSubtotal() {
    return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
  }

  @Override
  public String toString() {
    return "ItemPedido{" +
        "codigo=" + codigo +
        ", descricao='" + descricao + '\'' +
        ", quantidade=" + quantidade +
        ", valorUnitario=" + valorUnitario +
        ", classeFiscal='" + classeFiscal + '\'' +
        '}';
  }
}
