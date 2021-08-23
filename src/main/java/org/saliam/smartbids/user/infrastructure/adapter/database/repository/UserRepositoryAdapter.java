package org.saliam.smartbids.user.infrastructure.adapter.database.repository;

import org.saliam.smartbids.user.domain.entity.User;
import org.saliam.smartbids.user.domain.port.out.UserRepository;
import org.saliam.smartbids.user.infrastructure.adapter.database.entity.RoleEntity;
import org.saliam.smartbids.user.infrastructure.adapter.database.entity.UserEntity;
import org.saliam.smartbids.user.infrastructure.adapter.database.mapper.UserEntityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRepositoryAdapter implements UserRepository
{
  private final UserEntityRepository userEntityRepository;

  private final UserEntityMapper userEntityMapper;

  private final RoleEntityRepository roleEntityRepository;

  public UserRepositoryAdapter(
      final UserEntityRepository userEntityRepository,
      final UserEntityMapper userEntityMapper,
      RoleEntityRepository roleEntityRepository)
  {
    this.userEntityRepository = userEntityRepository;
    this.userEntityMapper = userEntityMapper;
    this.roleEntityRepository = roleEntityRepository;
  }

  @Override
  public Optional<User> findByUsername(String username)
  {
    Optional<UserEntity> userEntityByName = userEntityRepository.findByUsername(username);
    if (userEntityByName.isPresent())
    {
      return Optional.of(userEntityMapper.userEntityToUser(userEntityByName.get()));
    }
    else
    {
      return Optional.empty();
    }
  }

  @Override
  public User save(User user)
  {
    UserEntity userEntity = userEntityMapper.userToUserEntity(user);
    Set<Long> roleIds = userEntity.getRoles().stream().map(RoleEntity::getId).collect(Collectors.toSet());
    List<RoleEntity> roleEntities = roleEntityRepository.findAllById(roleIds);
    userEntity.setRoles(new HashSet<>(roleEntities));
    return userEntityMapper.userEntityToUser(userEntityRepository.save(userEntity));
  }

  @Override
  public boolean existsByUsername(String username)
  {
    return userEntityRepository.existsByUsername(username);
  }

  @Override
  public boolean existsByEmail(String email)
  {
    return userEntityRepository.existsByEmail(email);
  }

  @Override
  public Optional<User> get(Long id)
  {
    Optional<UserEntity> userById = userEntityRepository.findById(id);
    return userById.map(userEntityMapper::userEntityToUser);
  }

  @Override
  public List<User> getAll(int page, int size)
  {
    Page<UserEntity> userEntityPage = userEntityRepository.findAll(PageRequest.of(page, size));
    return userEntityPage.getContent().stream().map(userEntityMapper::userEntityToUser).collect(Collectors.toList());
  }


}
