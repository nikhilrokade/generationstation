package com.activetest.activemq.processor;

import com.activetest.activemq.bean.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;


@Component
public class ProcessorQ implements Processor {


    public void process(Exchange exchange) throws Exception {

        String str = (String) exchange.getIn().getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        if(str.startsWith("{") || str.startsWith("[")){
            Bean bean = objectMapper.readValue(str,Bean.class);
            exchange.setProperty("str",bean.getNumber());

        }
        else if (str.startsWith("<")){
            Bean bean = xmlMapper.readValue(str,Bean.class);
            exchange.setProperty("str",bean.getNumber());
        } else{
            exchange.setProperty("str",Integer.parseInt(str));
        }
       }
}
