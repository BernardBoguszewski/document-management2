package pl.com.bottega.documentmanagement.infrastructure;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.api.EmployeeDetails;
import pl.com.bottega.documentmanagement.api.MailingFacade;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.Employee;

import java.util.Date;
import java.util.Set;


/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
@Component
public class MailingFacadeImpl implements MailingFacade {

    @Override
    public void sendDocumentPublishedEmails(Document document, Set<EmployeeDetails> employeeDetailsSet) {
        for (EmployeeDetails employeeDetails : employeeDetailsSet){
            Logger.getLogger(MailingFacade.class).info("Sending mail to" + employeeDetails.getFirstName() + " " +
                    employeeDetails.getLastName() + " to " + employeeDetails.getEmail());
        }
    }
}
