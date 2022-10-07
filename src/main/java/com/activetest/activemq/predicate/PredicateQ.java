package com.activetest.activemq.predicate;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.stereotype.Component;


@Component
public class PredicateQ implements Predicate {


    @Override
    public boolean matches(Exchange exchange) {
        int be = (int) exchange.getProperty("str");
        return be % 2 == 0;
    }
}
