package org.saliam.smartbids.user.infrastructure.adapter.database.repository;

import org.saliam.smartbids.user.infrastructure.adapter.database.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long>
{
}
