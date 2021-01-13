package com.mangooa.common.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 字符型主键JPA实体接口实现类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
@MappedSuperclass
public abstract class BaseJpaEntityStringId implements JpaEntityStringId {

	/**
	 * 实体主键。
	 */
	@Id
	@Column(name = "b_id", nullable = false, length = 32)
	private String id;

	/**
	 * 实体创建时间。
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "b_create_time", nullable = false)
	private Date createTime;

	/**
	 * 实体创建者。
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(
			name = "account",
			column = @Column(name = "b_creator_account", nullable = false, length = 32)
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

}
