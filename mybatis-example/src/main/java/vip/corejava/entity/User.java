package vip.corejava.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Table(name = "`user`")
public class User implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 手机号
     */
    @Column(name = "`mobile`")
    private String mobile;

    /**
     * 创建时间
     */
    @Column(name = "`created_at`")
    private LocalDateTime createdAt;

    /**
     * 创建人
     */
    @Column(name = "`created_by`")
    private String createdBy;

    /**
     * 更新时间
     */
    @Column(name = "`updated_at`")
    private LocalDateTime updatedAt;

    /**
     * 更新人
     */
    @Column(name = "`updated_by`")
    private String updatedBy;

    /**
     * 是否删除
     */
    @Column(name = "`is_deleted`")
    private Byte isDeleted;

    /**
     * 是否隐藏
     */
    @Column(name = "`is_hidden`")
    private Byte isHidden;

    private static final long serialVersionUID = 1L;
}