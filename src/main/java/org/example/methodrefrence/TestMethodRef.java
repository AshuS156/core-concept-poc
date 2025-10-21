package org.example.methodrefrence;

import java.util.function.Consumer;

public class TestMethodRef{
    public static void main(String[] args){

        PaymentImpl payment = new PaymentImpl();

        Consumer<Integer> instanceMethodRef = payment::pay;
        instanceMethodRef.accept(500);


        final Runnable staticMethodRef = PaymentImpl::show;
        staticMethodRef.run();

        final Runnable constructorMethodRef = PaymentImpl::new;
        constructorMethodRef.run();

    }
}
