package com.mangooa.server.name.group;

import com.mangooa.data.jpa.BaseJpaEntityStringId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 群组实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "Group")
@Table(
	name = "t_group",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"b_tenant", "f_name"})
	}
)
@Getter
@Setter(AccessLevel.PACKAGE)
public class GroupEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = 3695640949872027982L;

	/**
	 * 群组类型。
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "f_type", nullable = false, length = 32)
	private GroupType type;

	/**
	 * 群组的标题。
	 */
	@Column(name = "f_title", nullable = false, length = 32)
	private String title;

	/**
	 * 群组的名称。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

	/**
	 * 群组的备注。
	 */
	@Column(name = "f_remark", length = 256)
	private String remark;

//	/**
//	 * 群组包含的用户。
//	 */
//	private List<String> users;
//
//	/**
//	 * 群组包含的子群组。
//	 */
//	private List<GroupEntity> children;
}
