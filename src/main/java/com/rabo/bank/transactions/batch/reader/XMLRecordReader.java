package com.rabo.bank.transactions.batch.reader;

import com.rabo.bank.transactions.ds.Records;
import com.rabo.bank.transactions.exception.XMLParsingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

@Slf4j
@Component
@StepScope
public class XMLRecordReader implements ItemReader<Records> {

    @Value("classpath:records.xml")
    private Resource xmlResource;

    private static boolean isRead;

    /**
     * read method reads the Transaction Records from a xml file by unmarshalling the records from the XML
     * @return Records
     */
    @Override
    public Records read() {
        try {
            if (isRead) {
                return null;
            }
            JAXBContext jaxbContext = JAXBContext.newInstance(Records.class);
            Unmarshaller jaxbUnmarshal = jaxbContext.createUnmarshaller();
            Records records = (Records) jaxbUnmarshal.unmarshal(xmlResource.getFile());
            isRead = true;
            return records;
        } catch (JAXBException | IOException ex) {
            throw new XMLParsingException("Error in XML parsing");
        }
    }
}
