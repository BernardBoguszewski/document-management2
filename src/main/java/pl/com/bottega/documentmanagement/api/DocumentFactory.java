package pl.com.bottega.documentmanagement.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentNumberGenerator;
import pl.com.bottega.documentmanagement.domain.PrintingCostCalculator;


/**
 * Created by maciuch on 17.08.16.
 */
@Component
public class DocumentFactory {

    private DocumentNumberGenerator documentNumberGenerator;

    private PrintingCostCalculator printingCostCalculator;

    private UserManager userManager;

    private DocumentListenerManager documentListenerManager;

    public DocumentFactory(DocumentNumberGenerator documentNumberGenerator, UserManager userManager,
                           PrintingCostCalculator printingCostCalculator, DocumentListenerManager documentListenerManager) {
        this.documentNumberGenerator = documentNumberGenerator;
        this.userManager = userManager;
        this.printingCostCalculator = printingCostCalculator;
        this.documentListenerManager = documentListenerManager;
    }

    public Document create(String title, String content) {
        Document document = new  Document(documentNumberGenerator.generate(), content, title, userManager.currentEmployee(), printingCostCalculator);
        documentListenerManager.subscribeListeners(document);
        return document;
    }

}
