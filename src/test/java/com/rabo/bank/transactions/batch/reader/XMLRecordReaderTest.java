package com.rabo.bank.transactions.batch.reader;

import com.rabo.bank.transactions.exception.XMLParsingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class XMLRecordReaderTest {

    @InjectMocks
    XMLRecordReader xmlRecordReader;

    @Mock
    Resource xmlResource;

    @Test
    public void testRead() throws IOException {
        Mockito.when(xmlResource.getFile()).thenReturn(new File("records.xml"));

        Assertions.assertThrows(XMLParsingException.class, () -> {
            xmlRecordReader.read();
        });
    }
}
