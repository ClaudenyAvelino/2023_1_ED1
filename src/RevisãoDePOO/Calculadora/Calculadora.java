package RevisãoDePOO.Calculadora;

import RevisãoDePOO.Exception.CalculadoraException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class Calculadora {

    //Atributos = caracteristicas
    private int primeiroValor=0;
    private int segundoValor=0;
    private String operador="";


    //Métodos = ações
    public void calcular(){

        try {
            capturarDadosUsuario();
            verificarOperadorNaoValido();
            somar();
            dividir();
            subtrair();
            multiplicar();
            dividir();

        }catch (ArithmeticException arithmeticException){
            throw new CalculadoraException("Esse ocorreu um erro ao tentar executar a operação, segue erro: "+arithmeticException.getMessage());
        }catch (InputMismatchException inputMismatchException){
            throw new CalculadoraException("Insira um numero valido, esse não é um número inteiro: "+ inputMismatchException.getMessage());

        }
    }

    private void capturarDadosUsuario(){
        System.out.println("Insira o primeiro valor");
        Scanner entrada = new Scanner(System.in);
        primeiroValor = entrada.nextInt();

        System.out.println("Insira o segundo valor");
        segundoValor = entrada.nextInt();

        System.out.println("Insira o operador");
        operador = entrada.next();
    }

    private void somar(){
        if (operador.equals("+")){
            System.out.println("É uma adição");
            System.out.println(primeiroValor+segundoValor);
        }
    }
    private void subtrair(){
        if (operador.equals("-")){
            System.out.println("É uma subtração");
            System.out.println(primeiroValor-segundoValor);
        }

    }
    private void multiplicar(){
        if (operador.equals("*")){
            System.out.println("É uma multiplicação");
            System.out.println(primeiroValor*segundoValor);
        }

    }

    private void dividir(){
        if (operador.equals("/")){
            System.out.println("É uma divisão");
            System.out.println(primeiroValor/segundoValor);
        }

    }

    private void verificarOperadorNaoValido(){
        if (!operador.equals("/") & !operador.equals("+") & !operador.equals("*") & !operador.equals("-")){
            System.out.println();
            throw new RuntimeException("Esse operador não é valido");
        }

    }
}

