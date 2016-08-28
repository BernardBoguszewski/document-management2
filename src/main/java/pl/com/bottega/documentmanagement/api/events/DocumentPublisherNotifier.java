package pl.com.bottega.documentmanagement.api.events;

import com.google.common.collect.Sets;
import pl.com.bottega.documentmanagement.api.EmployeeDetails;
import pl.com.bottega.documentmanagement.api.HRSystemFacade;
import pl.com.bottega.documentmanagement.api.MailingFacade;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.EmployeeId;
import pl.com.bottega.documentmanagement.domain.Reader;
import pl.com.bottega.documentmanagement.domain.events.DocumentListener;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by bernard.boguszewski on 27.08.2016.
 */
public class DocumentPublisherNotifier implements DocumentListener {

    private MailingFacade mailingFacade;
    private HRSystemFacade hrSystemFacade;

    public DocumentPublisherNotifier(MailingFacade mailingFacade, HRSystemFacade hrSystemFacade) {
        this.mailingFacade = mailingFacade;
        this.hrSystemFacade = hrSystemFacade;
    }


    @Override
    public void published(Document document) {
        Set<Reader> readers = document.readers();
        Set<EmployeeId> employeeIds = readers.stream().map(reader -> reader.employeeId()).collect(Collectors.toSet());
        Set<EmployeeDetails> employeeDetailsSet = hrSystemFacade.getEmployeeDetails(Sets.newHashSet(employeeIds));
        sendEmailsAboutPublishedDocument(document, employeeDetailsSet);
    }

    private void sendEmailsAboutPublishedDocument(Document document, Set<EmployeeDetails> employeeDetailsSet) {
        Set<EmployeeDetails> employeesWithMails = Sets.newHashSet();
        for (EmployeeDetails employeeDetails : employeeDetailsSet) {
            if (employeeDetails.getEmail() != null)
                employeesWithMails.add(employeeDetails);
        }
        mailingFacade.sendDocumentPublishedEmails(document, employeesWithMails);


    }
}