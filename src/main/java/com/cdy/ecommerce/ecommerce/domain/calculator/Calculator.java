package com.cdy.ecommerce.ecommerce.domain.calculator;

public class Calculator implements ICalculator {
  private Double result;

  public Calculator() {
    this.result = 0.0;
  }

  public Calculator(Double initResult) {
    this.result = initResult;
  }

  @Override
  public ICalculator add(Double number) {
    this.result += number;
    return this;
  }

  @Override
  public ICalculator add(Long number) {
    return null;
  }

  @Override
  public ICalculator subtract(Double number) {
    return null;
  }

  @Override
  public ICalculator multiply(Double number) {
    return null;
  }

  @Override
  public ICalculator divide(Double number) {
    return null;
  }


  @Override
  public Double getResult() {
    return this.result;
  }
}
