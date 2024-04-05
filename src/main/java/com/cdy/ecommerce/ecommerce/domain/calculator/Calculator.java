package com.cdy.ecommerce.ecommerce.domain.calculator;

public class Calculator {
  private Double result;

  public Calculator() {
    this.result = 0.0;
  }

  public Calculator(Double initResult) {
    this.result = initResult;
  }

  public Calculator add(Double number) {
    this.result += number;
    return this;
  }

  public Calculator minus(Double number) {
    this.result -= number;
    return this;
  }

  public Calculator multiply(Double number) {
    this.result *= number;
    return this;
  }

  public Calculator divide(Double number) {
    if (number == 0.0) {
      throw new ZeroDivisionException();
    }
    this.result /= number;
    return this;
  }

  public Double getResult() {
    return this.result;
  }

  public static class ZeroDivisionException extends RuntimeException {}
}
