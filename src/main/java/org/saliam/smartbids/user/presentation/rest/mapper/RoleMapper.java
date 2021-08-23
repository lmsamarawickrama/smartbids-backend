package org.saliam.smartbids.user.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartbids.user.domain.entity.Role;
import org.saliam.smartbids.user.presentation.rest.dto.RoleDto;

@Mapper
public interface RoleMapper
{
  Role roleDtoToRole(RoleDto roleDto);
}
