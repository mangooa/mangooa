package com.mangooa.data.jpa;

import com.mangooa.common.data.DataObject;
import com.mangooa.common.domain.Editor;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 字符型主键JPA实体接口实现类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter(AccessLevel.PACKAGE)
@MappedSuperclass
@SuppressWarnings("unused")
public abstract class BaseJpaEntityStringId implements DataObject<String> {

	private static final long serialVersionUID = -6348009385682984326L;

	/**
	 * 实体所属租户名称。
	 */
	@Setter(AccessLevel.PROTECTED)
	@Column(name = "b_tenant", nullable = false, updatable = false, length = 32)
	private String tenant;

	/**
	 * 实体主键。
	 */
	@Id
	@Column(name = "b_id", nullable = false, updatable = false, length = 32)
	@GenericGenerator(name = "string-id-generator", strategy = "com.mangooa.data.jpa.hibernate.StringIdGenerator")
	@GeneratedValue(generator = "string-id-generator")
	private String id;

	/**
	 * 实体创建时间。
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "b_create_time", nullable = false, updatable = false)
	private Date createTime;

	/**
	 * 实体创建者。
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(
			name = "account",
			column = @Column(name = "b_creator_account", nullable = false, updatable = false, length = 32)
		),
		@AttributeOverride(
			name = "name",
			column = @Column(name = "b_creator_name", nullable = false, length = 32)
		)}
	)
	private Editor creator;

	/**
	 * 实体最后一次更新时间。
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "b_update_Time", nullable = false)
	private Date updateTime;

	/**
	 * 实体最后一次更新者。
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(
			name = "account",
			column = @Column(name = "b_updator_account", nullable = false, length = 32)
		),
		@AttributeOverride(
			name = "name",
			column = @Column(name = "b_updator_name", nullable = false, length = 32)
		)}
	)
	private Editor updator;

	/**
	 * 实体更新版本，用于乐观锁。
	 */
	@Version
	@Column(name = "b_version", nullable = false)
	private Integer version;

	/**
	 * 设置实体主键。
	 *
	 * @param id 实体主键。
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 是否保存标识，默认为false表示还未保存过。
	 */
	@Column(name = "b_saved", nullable = false, updatable = false)
	private boolean saved = false;

}
