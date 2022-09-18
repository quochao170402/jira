package cybersoft.javabackend.java18.jira.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import cybersoft.javabackend.java18.jira.common.utils.DateTimeUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.experimental.UtilityClass;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    /* Note for base entity
    1. implements serializable
    2. must have id (UUID) -> using @Type to convert uuid to uuid-char
    3. must have version column to manage cache, compare, check data,...
    4. auto generate createdBy, createdAt, lastModifiedAt, lastModifiedBy
     */

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = Columns.ID)
    protected UUID id;

    @Version
    @Column(name = Columns.VERSION)
    protected int version;

    @CreatedBy
    @Column(name = Columns.CREATED_BY)
    protected String createdBy;

    @CreatedDate
    @Column(name = Columns.CREATED_AT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.DATETIME_FORMAT_dd_MM_yyyy_HH_mm_ss)
    @DateTimeFormat(pattern = DateTimeUtils.DATETIME_FORMAT_dd_MM_yyyy_HH_mm_ss)
    protected LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = Columns.LAST_MODIFIED_BY)
    protected String lastModifiedBy;

    @LastModifiedDate
    @Column(name = Columns.LAST_MODIFIED_AT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.DATETIME_FORMAT_dd_MM_yyyy_HH_mm_ss)
    @DateTimeFormat(pattern = DateTimeUtils.DATETIME_FORMAT_dd_MM_yyyy_HH_mm_ss)
    protected LocalDateTime lastModifiedAt;

    // inner class
    @UtilityClass
    static class Columns {
        static final String ID = "ID";
        static final String VERSION = "VERSION";
        static final String CREATED_BY = "CREATED_BY";
        static final String CREATED_AT = "CREATED_AT";
        static final String LAST_MODIFIED_BY = "LAST_MODIFIED_BY";
        static final String LAST_MODIFIED_AT = "LAST_MODIFIED_AT";
    }
}
