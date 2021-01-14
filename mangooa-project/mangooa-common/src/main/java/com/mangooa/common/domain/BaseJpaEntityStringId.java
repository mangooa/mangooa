package com.mangooa.common.domain;

import lombok.Getter;
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
@MappedSuperclass
@SuppressWarnings("unused")
public abstract class BaseJpaEntityStringId implements JpaEntityStringId {

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
	private Creator creator;

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
	private Updator updator;

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

}
