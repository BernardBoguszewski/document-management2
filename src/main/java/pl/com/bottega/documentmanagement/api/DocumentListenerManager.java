package pl.com.bottega.documentmanagement.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.events.DocumentListener;

import java.util.Collection;

/**
 * Created by bernard.boguszewski on 27.08.2016.
 */
@Component
public class DocumentListenerManager {

    private Collection<DocumentListener> documentListeners;

    public DocumentListenerManager(Collection<DocumentListener> documentListeners) {
        this.documentListeners = documentListeners;
    }

    public void subscribeListeners(Document document) {
        for (DocumentListener documentListener : documentListeners) {
            document.subscribeDocumentListener(documentListener);
        }
        documentListeners.forEach(document::subscribeDocumentListener);
    }
}