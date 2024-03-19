/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfi028_pizzariacompleta_2024;

/**
 *
 * @author Usuario
 */
public class Pedidos {
    String nome;
    String pizza;
    Double preco;

 public Pedidos(String nome, String pizza, Double preco) {
  this.nome = nome;
  this.pizza = pizza;
  this.preco = preco;
 }

 public Pedidos() {
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public String getPizza() {
  return pizza;
 }

 public void setPizza(String pizza) {
  this.pizza = pizza;
 }

 public Double getPreco() {
  return preco;
 }

 public void setPreco(Double preco) {
  this.preco = preco;
 }

 @Override
 public String toString() {
  return "Cliente:"+nome + ", pizza de " + pizza+" "+", TOTAL:"+ preco;
 }

  
}
