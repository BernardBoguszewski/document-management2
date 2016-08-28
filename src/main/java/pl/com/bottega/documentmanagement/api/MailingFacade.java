package pl.com.bottega.documentmanagement.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.events.DocumentListener;

import java.util.Collection;
import java.util.Set;

/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
public interface MailingFacade {

    void sendDocumentPublishedEmails(Document document, Set<EmployeeDetails> employeeDetailsSet);


}
