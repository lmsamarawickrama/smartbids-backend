package org.saliam.smartbids.user.infrastructure.adapter.database.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartbids.user.domain.entity.Role;
import org.saliam.smartbids.user.infrastructure.adapter.database.entity.RoleEntity;

@Mapper
public interface RoleEntityMapper
{
  RoleEntity roleToRoleEntity(Role role);

  Role roleEntityToRole(RoleEntity roleEntity);
}
