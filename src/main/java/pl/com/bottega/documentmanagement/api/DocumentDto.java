package pl.com.bottega.documentmanagement.api;

import pl.com.bottega.documentmanagement.domain.DocumentStatus;

import java.util.Date;

/**
 * Created by maciuch on 12.06.16.
 */
public class DocumentDto {

    private String number;
    private String title;
    private String content;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentDto dto = (DocumentDto) o;

        if (number != null ? !number.equals(dto.number) : dto.number != null) return false;
        if (title != null ? !title.equals(dto.title) : dto.title != null) return false;
        if (content != null ? !content.equals(dto.content) : dto.content != null) return false;
        if (status != null ? !status.equals(dto.status) : dto.status != null) return false;
        if (creatorId != null ? !creatorId.equals(dto.creatorId) : dto.creatorId != null) return false;
        if (verificatorId != null ? !verificatorId.equals(dto.verificatorId) : dto.verificatorId != null) return false;
        if (createdAt != null ? !createdAt.equals(dto.createdAt) : dto.createdAt != null) return false;
        if (verificatedAt != null ? !verificatedAt.equals(dto.verificatedAt) : dto.verificatedAt != null) return false;
        return updatedAt != null ? updatedAt.equals(dto.updatedAt) : dto.updatedAt == null;

    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        result = 31 * result + (verificatorId != null ? verificatorId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (verificatedAt != null ? verificatedAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    private Long creatorId, verificatorId;

    private Date createdAt, verificatedAt, updatedAt;
    public DocumentDto(String number, String title, String content, DocumentStatus status, Date createdAt, Date verificatedAt, Date updatedAt, Long creatorId, Long verificatorId) {
        this.number = number;
        this.title = title;
        this.content = content;
        this.status = status.name();
        this.createdAt = createdAt;
        this.verificatedAt = verificatedAt;
        this.updatedAt = updatedAt;
        this.creatorId = creatorId;
        this.verificatorId = verificatorId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public Long getVerificatorId() {
        return verificatorId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getVerificatedAt() {
        return verificatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
