package com.activetest.activemq.rout;

import com.activetest.activemq.predicate.PredicateQ;
import com.activetest.activemq.processor.ProcessorQ;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Route extends RouteBuilder {

    @Autowired
    private PredicateQ predicateQ;

    @Autowired
    private ProcessorQ processorQ;

    @Override
    public void configure() throws Exception {
        from("activemq:From")
                .process(processorQ)
                .choice()
                .when(predicateQ)
                .to("activemq:Even")
                .otherwise()
                .to("activemq:Odd")
                .end();
    }
}

