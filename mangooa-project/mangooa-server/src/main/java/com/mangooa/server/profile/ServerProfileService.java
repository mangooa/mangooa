package com.mangooa.server.profile;

import com.mangooa.common.domain.Editor;
import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.server.ServerAppProperties;

import org.springframework.boot.ApplicationArguments;


/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface ServerProfileService extends JpaServiceStringId<ServerProfileRepository, ServerProfileEntity> {

	/**
	 * 初始化服务器配置。
	 *
	 * @param init 服务器默认配置属性。
	 * @param args 命令行启动参数。
	 */
	default void init(ServerAppProperties.Init init, ApplicationArguments args) {
		if (!init.isClose() && getDao().count() == 0) {
			String init_domain = "init:domain";
			String domain = init.getDomain();
			if (args.containsOption(init_domain)) {
				domain = args.getOptionValues(init_domain).get(0);
			}
			ServerProfileEntity entity = new ServerProfileEntity("*");
			entity.setDomain(domain);
			Editor creator = new Editor();
			creator.setAccount("admin");
			creator.setName("管理员");
			save(creator, entity);
		}
	}
}
