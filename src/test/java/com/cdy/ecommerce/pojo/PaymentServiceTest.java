package com.cdy.ecommerce.pojo;

import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.payment.business.Payment;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {
    private PaymentService paymentService;

    private PaymentPort paymentPort;

    @BeforeEach
    void setUp(){
        paymentService = new PaymentService(new PaymentPort() {
            @Override
            public ProductOrder getOrder(Long orderId) {
                return ProductOrder.builder().build();
            }

            @Override
            public void save(Payment payment) {
                // save
            }

            @Override
            public void pay(Payment payment) {
                // pay
            }
        });
    }

    @Test
    void 상품주문(){
        final Long orderId = 1L;
        final PaymentRequest request = new PaymentRequest(orderId);
        paymentService.payment(request);
    }

    private record PaymentRequest(Long orderId){
        private PaymentRequest {
            Assert.notNull(orderId, "주문번호는 필수입니다.");
        }
    }

    private class PaymentService {


        public PaymentService(PaymentPort paymentPort) {
            this.paymentPort = paymentPort;
        }

        public void payment(PaymentRequest request) {
            ProductOrder order = paymentPort.getOrder(request.orderId());
            final Payment payment = Payment.builder().build();

            paymentPort.pay(payment);
            paymentPort.save(payment);
        }


    }
    private interface PaymentPort {
        public ProductOrder getOrder(Long orderId);

        void save(Payment payment);

        void pay(Payment payment);
    }
}
