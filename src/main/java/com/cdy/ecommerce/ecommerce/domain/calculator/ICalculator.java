package com.cdy.ecommerce.ecommerce.domain.calculator;

public interface ICalculator {
    ICalculator add(Double number);

    ICalculator add(Long number);
    ICalculator subtract(Double number);
    ICalculator multiply(Double number);
    ICalculator divide(Double number);
    Double getResult();
}
